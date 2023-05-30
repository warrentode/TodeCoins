package net.warrentode.todecoins.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.warrentode.todecoins.TodeCoins;
import net.warrentode.todecoins.item.ModItems;
import net.warrentode.todecoins.loot.ModBuiltInLootTables;
import net.warrentode.todecoins.util.CalendarUtil;
import net.warrentode.todecoins.util.tags.ForgeTags;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotResult;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static net.minecraft.world.entity.monster.piglin.PiglinAi.*;

@Mixin(PiglinAi.class)
public abstract class PiglinBarterMixin {
    private static final RandomSource random = RandomSource.create();
    private static final int giftChance = random.nextInt(100);
    private static final int giftRate = 50;

    private static boolean isWearingNetheritePiglinCoin(Player player) {
        Optional<SlotResult> optional = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.NETHERITE_PIGLIN_COIN.get());
        ItemStack netheritePiglinCoin = null;

        if (TodeCoins.isCuriosLoaded()) {
            if (optional.isPresent()) {
                netheritePiglinCoin = optional.get().stack();
            }
        }
        return netheritePiglinCoin != null;
    }

    private static boolean isWearingGoldPiglinCoin(Player player) {
        Optional<SlotResult> optional = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.GOLD_PIGLIN_COIN.get());
        ItemStack goldPiglinCoin = null;

        if (TodeCoins.isCuriosLoaded()) {
            if (optional.isPresent()) {
                goldPiglinCoin = optional.get().stack();
            }
        }
        return goldPiglinCoin != null;
    }

    private static boolean isWearingIronPiglinCoin(Player player) {
        Optional<SlotResult> optional = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.IRON_PIGLIN_COIN.get());
        ItemStack ironPiglinCoin = null;

        if (TodeCoins.isCuriosLoaded()) {
            if (optional.isPresent()) {
                ironPiglinCoin = optional.get().stack();
            }
        }
        return ironPiglinCoin != null;
    }

    private static boolean isWearingCopperPiglinCoin(Player player) {
        Optional<SlotResult> optional = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.COPPER_PIGLIN_COIN.get());
        ItemStack copperPiglinCoin = null;

        if (TodeCoins.isCuriosLoaded()) {
            if (optional.isPresent()) {
                copperPiglinCoin = optional.get().stack();
            }
        }
        return copperPiglinCoin != null;
    }

    @Inject(at = @At("HEAD"), method = "stopHoldingOffHandItem", cancellable = true)
    private static void todecoins_stopHoldingOffHandItem(@NotNull Piglin piglin, boolean shouldBarter, CallbackInfo ci) {
        Player player = Minecraft.getInstance().player;
        if (piglin.isAdult()) {
            ItemStack offHandItem = piglin.getItemInHand(InteractionHand.OFF_HAND);
            boolean barterItem = PiglinAi.isBarterCurrency(offHandItem);
            boolean netherGoldCoin = piglin.getItemInHand(InteractionHand.OFF_HAND).is(ModItems.NETHER_GOLD_COIN.get());
            if (shouldBarter && barterItem) {
                piglin.setItemInHand(InteractionHand.OFF_HAND, ItemStack.EMPTY);
                if (shouldBarter && giftChance >= giftRate && (CalendarUtil.Season.isChristmas() || CalendarUtil.Season.isHalloween() || CalendarUtil.Season.isBirthday() || CalendarUtil.Season.isAnniversary())) {
                    throwItems(piglin, todecoins_getEventGiftLootResponseItems(piglin));
                }
                if (netherGoldCoin) {
                    throwItems(piglin, todecoins_getNetherGoldCoinBarterResponseItems(piglin));
                } else if (shouldBarter && isWearingNetheritePiglinCoin(player)) {
                    throwItems(piglin, todecoins_getNetheritePiglinCoinBarterResponseItems(piglin));
                } else if (shouldBarter && isWearingGoldPiglinCoin(player)) {
                    throwItems(piglin, todecoins_getGoldPiglinCoinBarterResponseItems(piglin));
                } else if (shouldBarter && isWearingIronPiglinCoin(player)) {
                    throwItems(piglin, todecoins_getIronPiglinCoinBarterResponseItems(piglin));
                } else if (shouldBarter && isWearingCopperPiglinCoin(player)) {
                    throwItems(piglin, todecoins_getCopperPiglinCoinBarterResponseItems(piglin));
                } else {
                    throwItems(piglin, getBarterResponseItems(piglin));
                }
                ci.cancel();
            }
        }
    }

    private static List<ItemStack> todecoins_getEventGiftLootResponseItems(@NotNull Piglin piglin) {
        LootTable lootTable = Objects.requireNonNull(piglin.level.getServer()).getLootTables().get(ModBuiltInLootTables.PIGLIN_EVENT_BARTER_LOOT);
        return lootTable.getRandomItems((new LootContext.Builder((ServerLevel) piglin.level)).withParameter(LootContextParams.THIS_ENTITY, piglin).withRandom(piglin.level.random).create(LootContextParamSets.PIGLIN_BARTER));
    }

    private static List<ItemStack> todecoins_getCopperPiglinCoinBarterResponseItems(@NotNull Piglin piglin) {
        LootTable lootTable = Objects.requireNonNull(piglin.level.getServer()).getLootTables().get(ModBuiltInLootTables.COPPER_PIGLIN_COIN_BARTER_LOOT);
        return lootTable.getRandomItems((new LootContext.Builder((ServerLevel) piglin.level)).withParameter(LootContextParams.THIS_ENTITY, piglin).withRandom(piglin.level.random).create(LootContextParamSets.PIGLIN_BARTER));
    }

    private static List<ItemStack> todecoins_getIronPiglinCoinBarterResponseItems(@NotNull Piglin piglin) {
        LootTable lootTable = Objects.requireNonNull(piglin.level.getServer()).getLootTables().get(ModBuiltInLootTables.IRON_PIGLIN_COIN_BARTER_LOOT);
        return lootTable.getRandomItems((new LootContext.Builder((ServerLevel) piglin.level)).withParameter(LootContextParams.THIS_ENTITY, piglin).withRandom(piglin.level.random).create(LootContextParamSets.PIGLIN_BARTER));
    }

    private static List<ItemStack> todecoins_getGoldPiglinCoinBarterResponseItems(@NotNull Piglin piglin) {
        LootTable lootTable = Objects.requireNonNull(piglin.level.getServer()).getLootTables().get(ModBuiltInLootTables.GOLD_PIGLIN_COIN_BARTER_LOOT);
        return lootTable.getRandomItems((new LootContext.Builder((ServerLevel) piglin.level)).withParameter(LootContextParams.THIS_ENTITY, piglin).withRandom(piglin.level.random).create(LootContextParamSets.PIGLIN_BARTER));
    }

    private static List<ItemStack> todecoins_getNetheritePiglinCoinBarterResponseItems(@NotNull Piglin piglin) {
        LootTable lootTable = Objects.requireNonNull(piglin.level.getServer()).getLootTables().get(ModBuiltInLootTables.NETHERITE_PIGLIN_COIN_BARTER_LOOT);
        return lootTable.getRandomItems((new LootContext.Builder((ServerLevel) piglin.level)).withParameter(LootContextParams.THIS_ENTITY, piglin).withRandom(piglin.level.random).create(LootContextParamSets.PIGLIN_BARTER));
    }

    private static List<ItemStack> todecoins_getNetherGoldCoinBarterResponseItems(@NotNull Piglin piglin) {
        LootTable lootTable = Objects.requireNonNull(piglin.level.getServer()).getLootTables().get(ModBuiltInLootTables.NETHER_GOLD_COIN_PIGLIN_BARTERING);
        return lootTable.getRandomItems((new LootContext.Builder((ServerLevel) piglin.level)).withParameter(LootContextParams.THIS_ENTITY, piglin).withRandom(piglin.level.random).create(LootContextParamSets.PIGLIN_BARTER));
    }

    @Inject(at = @At("HEAD"), method = "wantsToPickup", cancellable = true)
    private static void todecoins_wantsToPickup(Piglin piglin, @NotNull ItemStack pStack, CallbackInfoReturnable<Boolean> cir) {
        if (pStack.is(ForgeTags.Items.PIGLIN_BARTER_ITEMS) && isNotHoldingLovedItemInOffHand(piglin)) {
            cir.setReturnValue(true);
            cir.cancel();
        }
    }

    @Inject(at = @At("HEAD"), method = "canAdmire", cancellable = true)
    private static void todecoins_canAdmire(Piglin piglin, ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        if (!isAdmiringDisabled(piglin) && !isAdmiringItem(piglin) && piglin.isAdult() && (stack.isPiglinCurrency() || stack.is(ForgeTags.Items.PIGLIN_BARTER_ITEMS))) {
            cir.setReturnValue(true);
            cir.cancel();
        }
    }

    @Inject(at = @At("HEAD"), method = "isBarterCurrency", cancellable = true)
    private static void todecoins_isBarterCurrency(@NotNull ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        if (stack.is(ForgeTags.Items.PIGLIN_BARTER_ITEMS)) {
            cir.setReturnValue(true);
            cir.cancel();
        }
    }
}