package com.github.warrentode.todecoins.mixin.villagers;

import com.github.warrentode.todecoins.Config;
import com.github.warrentode.todecoins.TodeCoins;
import com.github.warrentode.todecoins.attribute.ModAttributes;
import com.github.warrentode.todecoins.entity.trades.BankerTrades;
import com.github.warrentode.todecoins.entity.trades.LeprechaunTrades;
import com.github.warrentode.todecoins.entity.villager.TCVillagers;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.VillagerData;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.item.trading.MerchantOffers;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.*;

@Mixin(Villager.class)
public abstract class VillagerMixin {

    @Invoker("getVillagerData")
    public abstract VillagerData invokeGetVillagerData();

    @Unique
    @SuppressWarnings("DataFlowIssue")
    final
    Villager todeCoins$villager = (Villager) (Object) this;

    // Track if the nitwit has restocked since waking up
    @Unique
    private boolean todeCoins$hasRestockedSinceWake = false;

    @Shadow
    private long lastRestockGameTime;

    @Shadow
    private int numberOfRestocksToday;

    @Inject(at = @At("TAIL"), method = "getPlayerReputation(Lnet/minecraft/world/entity/player/Player;)I", cancellable = true)
    private void todeCoins_updateSpecialPrices(@NotNull Player player, @NotNull CallbackInfoReturnable<Integer> cir) {
        int baseRep = cir.getReturnValue();

        // Get total charisma from equipped coins (or other sources)
        AttributeInstance charismaAttr = player.getAttribute(ModAttributes.CHARISMA.get());
        double totalCharisma = (charismaAttr != null) ? charismaAttr.getValue() : 0;

        // Count nearby villagers
        int nearbyVillagers = player.level.getEntitiesOfClass(
                Villager.class,
                player.getBoundingBox().inflate(25, 8, 25),
                EntitySelector.NO_SPECTATORS
        ).size();

        // Calculate bonus: 1 per charisma per nearby villager - maxing out at 100
        int charismaBonus = (int) Math.min(totalCharisma * nearbyVillagers, 100);

        cir.setReturnValue(baseRep + charismaBonus);
    }

    /**
     * Tick injection to trigger NITWIT restock on wake
     */
    @Inject(method = "tick", at = @At("TAIL"))
    private void nitwitRestockOnWake(CallbackInfo ci) {
        if (todeCoins$villager.level.isClientSide()) return;

        VillagerData data = invokeGetVillagerData();
        if (data.getProfession() == VillagerProfession.NITWIT) {
            if (!todeCoins$villager.isSleeping() && !todeCoins$hasRestockedSinceWake) {
                // Trigger Nitwit restock
                todeCoins$villager.restock();
                todeCoins$hasRestockedSinceWake = true;
            }
            else if (todeCoins$villager.isSleeping()) {
                // Reset flag when sleeping again
                todeCoins$hasRestockedSinceWake = false;
            }
        }
    }

    /**
     * Override restock to respect config and rebuild offers manually
     */
    @Inject(at = @At("HEAD"), method = "restock", cancellable = true)
    public void restock(CallbackInfo ci) {
        if (Config.getResetTrades()) {
            todeCoins$villager.updateDemand();
            todeCoins$rebuildOffers(invokeGetVillagerData());

            // Update restock tracking
            this.lastRestockGameTime = todeCoins$villager.level.getGameTime();
            ++this.numberOfRestocksToday;

            ci.cancel(); // Cancel vanilla restock logic
        }
    }

    @Inject(method = "setVillagerData", at = @At("TAIL"))
    private void onSetVillagerData(VillagerData data, CallbackInfo ci) {
        if (Config.getReplaceVillagerTrades() && !todeCoins$villager.level.isClientSide() && data.getProfession() != VillagerProfession.NONE) {
            todeCoins$rebuildOffers(data);
        }
    }

    /**
     * Helper to rebuild a villager's offers according to config, allowing repeats if needed
     */
    @Unique
    private void todeCoins$rebuildOffers(@NotNull VillagerData data) {
        MerchantOffers newOffers = new MerchantOffers();

        Optional<Int2ObjectMap<List<VillagerTrades.ItemListing>>> jsonTradesOpt =
                TodeCoins.TRADE_OFFER_MANAGER.getVillagerOffers(data.getProfession());

        Int2ObjectMap<List<VillagerTrades.ItemListing>> tradesByLevel =
                jsonTradesOpt.orElseGet(() -> {
                    Int2ObjectMap<List<VillagerTrades.ItemListing>> fallback = new Int2ObjectOpenHashMap<>();
                    VillagerProfession profession = data.getProfession();

                    if (profession.equals(TCVillagers.BANKER.get())) {
                        Int2ObjectMap<VillagerTrades.ItemListing[]> banker = BankerTrades.BANKER_TRADES;
                        for (int level : banker.keySet()) {
                            fallback.put(level, Arrays.asList(banker.get(level)));
                        }
                    } else if (profession.equals(TCVillagers.LEPRECHAUN.get())) {
                        Int2ObjectMap<VillagerTrades.ItemListing[]> leprechaun = LeprechaunTrades.LEPRECHAUN_TRADES;
                        for (int level : leprechaun.keySet()) {
                            fallback.put(level, Arrays.asList(leprechaun.get(level)));
                        }
                    } else {
                        Int2ObjectMap<VillagerTrades.ItemListing[]> vanilla = VillagerTrades.TRADES.get(profession);
                        if (vanilla != null) {
                            for (int level : vanilla.keySet()) {
                                fallback.put(level, Arrays.asList(vanilla.get(level)));
                            }
                        }
                    }

                    return fallback;
                });

        if (!tradesByLevel.isEmpty()) {
            for (int level = 1; level <= data.getLevel(); level++) {
                List<VillagerTrades.ItemListing> listings = tradesByLevel.get(level);
                if (listings == null || listings.isEmpty()) continue;

                List<VillagerTrades.ItemListing> shuffled = new ArrayList<>(listings);
                Collections.shuffle(shuffled, new Random(todeCoins$villager.getRandom().nextLong()));

                int maxTrades = Config.getReplaceVillagerTrades() ? Config.getMaxVillagerTrades() : shuffled.size();

                for (int i = 0; i < maxTrades; i++) {
                    VillagerTrades.ItemListing listing = shuffled.get(i % shuffled.size());
                    MerchantOffer offer = listing.getOffer(todeCoins$villager, todeCoins$villager.getRandom());
                    if (offer != null) newOffers.add(offer);
                }
            }
        }

        // Always set offers for custom professions, and also when replacing trades
        VillagerProfession profession = data.getProfession();
        if (profession.equals(TCVillagers.BANKER.get()) || profession.equals(TCVillagers.LEPRECHAUN.get()) || Config.getReplaceVillagerTrades()) {
            ((AbstractVillagerAccessor) todeCoins$villager).setOffers(newOffers);
        }
    }
}