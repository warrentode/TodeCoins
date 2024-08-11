package com.github.warrentode.todecoins.mixin;

import com.github.warrentode.todecoins.attribute.PlayerCharisma;
import com.github.warrentode.todecoins.config.CommonConfig;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.VillagerData;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.player.Player;
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

import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.Random;

@Mixin(Villager.class)
public abstract class VillagerMixin {
    @Invoker("getVillagerData")
    public abstract VillagerData invokeGetVillagerData();
    @Unique
    @SuppressWarnings("DataFlowIssue")
    Villager todeCoins$villager = (Villager)(Object) this;
    @Shadow
    private long lastRestockGameTime;
    @Shadow
    private int numberOfRestocksToday;

    @Inject(at = {@At("TAIL")}, method = {"getPlayerReputation(Lnet/minecraft/world/entity/player/Player;)I"}, cancellable = true)
    private void todeCoins_updateSpecialPrices(Player player, @NotNull CallbackInfoReturnable<Integer> cir) {
        cir.setReturnValue(cir.getReturnValue() + PlayerCharisma.getCharismaBonus(player));
    }

    @Inject(at = {@At("HEAD")}, method = {"restock"}, cancellable = true)
    public void restock(CallbackInfo ci) {
        if (CommonConfig.getResetTrades()) {
            MerchantOffers newOffers = new MerchantOffers();
            VillagerData data = invokeGetVillagerData();

            var trades = VillagerTrades.TRADES.get(data.getProfession());
            if (trades == null || trades.isEmpty()) {
                ci.cancel();
            }

            if (trades != null) {
                for (int level = 1; level <= data.getLevel(); level++) {
                    var listings = trades.get(level);
                    var tradeCount = CommonConfig.getMaxVillagerTrades();

                    if (listings == null) {
                        continue;
                    }

                    var shuffled = Arrays.asList(listings);
                    Collections.shuffle(shuffled, new Random(todeCoins$villager.getRandom().nextLong()));
                    shuffled.subList(0, Math.min(shuffled.size(), tradeCount)).stream()
                            .map(it -> it.getOffer(todeCoins$villager, todeCoins$villager.getRandom()))
                            .filter(Objects::nonNull)
                            .forEach(newOffers::add);
                }
            }

            ((AbstractVillagerAccessor) todeCoins$villager).setOffers(newOffers);

            todeCoins$villager.updateTrades();

            this.lastRestockGameTime = todeCoins$villager.level.getGameTime();
            ++this.numberOfRestocksToday;

            ci.cancel();
        }
    }
}