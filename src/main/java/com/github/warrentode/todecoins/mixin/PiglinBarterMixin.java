package com.github.warrentode.todecoins.mixin;

import com.github.warrentode.todecoins.integration.curios.CuriosHelper;
import com.github.warrentode.todecoins.item.TCItems;
import com.github.warrentode.todecoins.loot.ModBuiltInLootTables;
import com.github.warrentode.todecoins.util.tags.TCItemTags;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

import static com.github.warrentode.todecoins.util.seasonal.CalendarUtil.*;
import static net.minecraft.world.entity.monster.piglin.PiglinAi.*;

@Mixin(PiglinAi.class)
public abstract class PiglinBarterMixin {
    @Unique
    private static final RandomSource todeCoins$random = RandomSource.create();
    @Unique
    private static final int todeCoins$giftChance = todeCoins$random.nextInt(100);
    @Unique
    private static final int todeCoins$giftRate = 50;

    // Map piglin coins to their loot table suppliers (for regular piglin coins)
    @Unique
    private static final Map<Item, Function<Piglin, List<ItemStack>>> COIN_LOOT_MAP = Map.of(
            TCItems.COLLECTIBLE_COIN_PIGLIN_COPPER.get(), PiglinBarterMixin::todeCoins$getCopperPiglinCoinBarterResponseItems,
            TCItems.COLLECTIBLE_COIN_PIGLIN_IRON.get(), PiglinBarterMixin::todeCoins$getIronPiglinCoinBarterResponseItems,
            TCItems.COLLECTIBLE_COIN_PIGLIN_GOLD.get(), PiglinBarterMixin::todeCoins$getGoldPiglinCoinBarterResponseItems,
            TCItems.COLLECTIBLE_COIN_PIGLIN_NETHERITE.get(), PiglinBarterMixin::todeCoins$getNetheritePiglinCoinBarterResponseItems
    );

    @Unique
    private static boolean todeCoins$isGiftEvent() {
        return isEaster || isHalloween || isChristmas || isBirthday || isAnniversary || isNewYear;
    }

    @Inject(at = @At("HEAD"), method = "stopHoldingOffHandItem", cancellable = true)
    private static void todeCoins$stopHoldingOffHandItem(@NotNull Piglin piglin, boolean shouldBarter, CallbackInfo ci) {
        MinecraftServer server = piglin.getServer();
        ServerPlayer player = server != null ? server.createCommandSourceStack().getPlayer() : null;

        if (!piglin.isAdult()) return;

        ItemStack offHandItem = piglin.getItemInHand(InteractionHand.OFF_HAND);
        boolean barterItem = PiglinAi.isBarterCurrency(offHandItem);
        boolean netherGoldCoin = offHandItem.is(TCItems.NETHER_GOLD_COIN.get());

        if (!shouldBarter || !barterItem) return;

        piglin.setItemInHand(InteractionHand.OFF_HAND, ItemStack.EMPTY);

        // Event gifts
        if (todeCoins$giftChance >= todeCoins$giftRate && todeCoins$isGiftEvent()) {
            throwItems(piglin, todeCoins$getEventGiftLootResponseItems(piglin));
        }

        // Nether Gold Coin handled separately
        if (netherGoldCoin) {
            throwItems(piglin, todeCoins$getNetherGoldCoinBarterResponseItems(piglin));
            ci.cancel();
            return;
        }

        if (player != null) {
            // Get equipped or inventory coin
            ItemStack equippedCoin = CuriosHelper.getEquippedOrInventoryStack(player,
                    TCItems.COLLECTIBLE_COIN_PIGLIN_COPPER.get(),
                    TCItems.COLLECTIBLE_COIN_PIGLIN_IRON.get(),
                    TCItems.COLLECTIBLE_COIN_PIGLIN_GOLD.get(),
                    TCItems.COLLECTIBLE_COIN_PIGLIN_NETHERITE.get(),
                    TCItems.COLLECTIBLE_COIN_ZOMBIFIED_PIGLIN_COPPER.get(),
                    TCItems.COLLECTIBLE_COIN_ZOMBIFIED_PIGLIN_IRON.get(),
                    TCItems.COLLECTIBLE_COIN_ZOMBIFIED_PIGLIN_GOLD.get(),
                    TCItems.COLLECTIBLE_COIN_ZOMBIFIED_PIGLIN_NETHERITE.get()
            );

            if (equippedCoin != null) {
                // Zombified piglin coins are identified by tag
                if (equippedCoin.is(TCItemTags.UNDEAD_COINS_ZOMBIFIED_PIGLIN_TAG)) {
                    throwItems(piglin, todeCoins$getZombiePiglinCoinBarterResponseItems(piglin));
                }
                else {
                    // piglin coins are identified individually
                    Function<Piglin, List<ItemStack>> lootFunction = COIN_LOOT_MAP.get(equippedCoin.getItem());
                    if (lootFunction != null) {
                        throwItems(piglin, lootFunction.apply(piglin));
                    }
                    else {
                        throwItems(piglin, getBarterResponseItems(piglin)); // fallback
                    }
                }
            }
            else {
                // No coin equipped/in inventory → fallback
                throwItems(piglin, getBarterResponseItems(piglin));
            }
        }
        else {
            // No player → fallback
            throwItems(piglin, getBarterResponseItems(piglin));
        }

        ci.cancel();
    }

    // Loot table helpers
    @Unique
    private static @NotNull List<ItemStack> todeCoins$getEventGiftLootResponseItems(@NotNull Piglin piglin) {
        LootTable lootTable = Objects.requireNonNull(piglin.level.getServer())
                .getLootData().getLootTable(ModBuiltInLootTables.PIGLIN_EVENT_BARTER_LOOT);
        return lootTable.getRandomItems(new LootParams.Builder((ServerLevel) piglin.level)
                .withParameter(LootContextParams.THIS_ENTITY, piglin)
                .create(LootContextParamSets.PIGLIN_BARTER));
    }

    @Unique
    private static @NotNull List<ItemStack> todeCoins$getCopperPiglinCoinBarterResponseItems(@NotNull Piglin piglin) {
        LootTable lootTable = Objects.requireNonNull(piglin.level.getServer())
                .getLootData().getLootTable(ModBuiltInLootTables.COPPER_PIGLIN_COIN_BARTER_LOOT);
        return lootTable.getRandomItems(new LootParams.Builder((ServerLevel) piglin.level)
                .withParameter(LootContextParams.THIS_ENTITY, piglin)
                .create(LootContextParamSets.PIGLIN_BARTER));
    }

    @Unique
    private static @NotNull List<ItemStack> todeCoins$getIronPiglinCoinBarterResponseItems(@NotNull Piglin piglin) {
        LootTable lootTable = Objects.requireNonNull(piglin.level.getServer())
                .getLootData().getLootTable(ModBuiltInLootTables.IRON_PIGLIN_COIN_BARTER_LOOT);
        return lootTable.getRandomItems(new LootParams.Builder((ServerLevel) piglin.level)
                .withParameter(LootContextParams.THIS_ENTITY, piglin)
                .create(LootContextParamSets.PIGLIN_BARTER));
    }

    @Unique
    private static @NotNull List<ItemStack> todeCoins$getGoldPiglinCoinBarterResponseItems(@NotNull Piglin piglin) {
        LootTable lootTable = Objects.requireNonNull(piglin.level.getServer())
                .getLootData().getLootTable(ModBuiltInLootTables.GOLD_PIGLIN_COIN_BARTER_LOOT);
        return lootTable.getRandomItems(new LootParams.Builder((ServerLevel) piglin.level)
                .withParameter(LootContextParams.THIS_ENTITY, piglin)
                .create(LootContextParamSets.PIGLIN_BARTER));
    }

    @Unique
    private static @NotNull List<ItemStack> todeCoins$getNetheritePiglinCoinBarterResponseItems(@NotNull Piglin piglin) {
        LootTable lootTable = Objects.requireNonNull(piglin.level.getServer())
                .getLootData().getLootTable(ModBuiltInLootTables.NETHERITE_PIGLIN_COIN_BARTER_LOOT);
        return lootTable.getRandomItems(new LootParams.Builder((ServerLevel) piglin.level)
                .withParameter(LootContextParams.THIS_ENTITY, piglin)
                .create(LootContextParamSets.PIGLIN_BARTER));
    }

    @Unique
    private static @NotNull List<ItemStack> todeCoins$getZombiePiglinCoinBarterResponseItems(@NotNull Piglin piglin) {
        LootTable lootTable = Objects.requireNonNull(piglin.level.getServer())
                .getLootData().getLootTable(ModBuiltInLootTables.ZOMBIE_PIGLIN_COIN_BARTER_LOOT);
        return lootTable.getRandomItems(new LootParams.Builder((ServerLevel) piglin.level)
                .withParameter(LootContextParams.THIS_ENTITY, piglin)
                .create(LootContextParamSets.PIGLIN_BARTER));
    }

    @Unique
    private static @NotNull List<ItemStack> todeCoins$getNetherGoldCoinBarterResponseItems(@NotNull Piglin piglin) {
        LootTable lootTable = Objects.requireNonNull(piglin.level.getServer())
                .getLootData().getLootTable(ModBuiltInLootTables.NETHER_GOLD_COIN_PIGLIN_BARTERING);
        return lootTable.getRandomItems(new LootParams.Builder((ServerLevel) piglin.level)
                .withParameter(LootContextParams.THIS_ENTITY, piglin)
                .create(LootContextParamSets.PIGLIN_BARTER));
    }

    // Vanilla behavior injections
    @Inject(at = @At("HEAD"), method = "wantsToPickup", cancellable = true)
    private static void todeCoins$wantsToPickup(Piglin piglin, @NotNull ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        if (stack.is(TCItemTags.PIGLIN_BARTER_ITEMS) && isNotHoldingLovedItemInOffHand(piglin)) {
            cir.setReturnValue(true);
            cir.cancel();
        }
    }

    @Inject(at = @At("HEAD"), method = "canAdmire", cancellable = true)
    private static void todeCoins$canAdmire(Piglin piglin, ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        if (!isAdmiringDisabled(piglin) && !isAdmiringItem(piglin) && piglin.isAdult() &&
                (stack.isPiglinCurrency() || stack.is(TCItemTags.PIGLIN_BARTER_ITEMS))) {
            cir.setReturnValue(true);
            cir.cancel();
        }
    }

    @Inject(at = @At("HEAD"), method = "isBarterCurrency", cancellable = true)
    private static void todeCoins$isBarterCurrency(@NotNull ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        if (stack.is(TCItemTags.PIGLIN_BARTER_ITEMS)) {
            cir.setReturnValue(true);
            cir.cancel();
        }
    }
}