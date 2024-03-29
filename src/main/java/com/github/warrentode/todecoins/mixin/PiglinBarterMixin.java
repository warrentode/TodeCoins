package com.github.warrentode.todecoins.mixin;

import com.github.warrentode.todecoins.item.ModItems;
import com.github.warrentode.todecoins.loot.ModBuiltInLootTables;
import com.github.warrentode.todecoins.util.CalendarUtil;
import com.github.warrentode.todecoins.util.tags.ForgeTags;
import com.github.warrentode.todecoins.util.tags.ModTags;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraftforge.fml.ModList;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
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
    @Unique
    private static final RandomSource todeCoins$random = RandomSource.create();
    @Unique
    private static final int todeCoins$giftChance = todeCoins$random.nextInt(100);
    @Unique
    private static final int todeCoins$giftRate = 50;

    @Unique
    private static boolean todeCoins$isWearingZombiePiglinCoin(ServerPlayer player) {
        if (player != null && ModList.get().isLoaded("curios")) {
            ItemStack stack = null;

            Optional<SlotResult> zombiePiglinCoin1 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.COPPER_ZOMBIFIED_PIGLIN_COIN.get());
            Optional<SlotResult> zombiePiglinCoin2 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.IRON_ZOMBIFIED_PIGLIN_COIN.get());
            Optional<SlotResult> zombiePiglinCoin3 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.GOLD_ZOMBIFIED_PIGLIN_COIN.get());
            Optional<SlotResult> zombiePiglinCoin4 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.NETHERITE_ZOMBIFIED_PIGLIN_COIN.get());

            if (zombiePiglinCoin1.isPresent()) {
                stack = zombiePiglinCoin1.get().stack();
            }
            else if (zombiePiglinCoin2.isPresent()) {
                stack = zombiePiglinCoin2.get().stack();
            }
            else if (zombiePiglinCoin3.isPresent()) {
                stack = zombiePiglinCoin3.get().stack();
            }
            else if (zombiePiglinCoin4.isPresent()) {
                stack = zombiePiglinCoin4.get().stack();
            }

            return stack != null && stack.is(ModTags.Items.ZOMBIFIED_PIGLIN_COIN_SET);
        }
        return false;
    }

    @Unique
    private static boolean todeCoins$isWearingNetheritePiglinCoin(ServerPlayer player) {
        if (player != null && ModList.get().isLoaded("curios")) {
            ItemStack stack = null;

            Optional<SlotResult> piglinCoin = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.NETHERITE_PIGLIN_COIN.get());

            if (piglinCoin.isPresent()) {
                stack = piglinCoin.get().stack();
            }

            return stack != null  && stack.is(ModItems.NETHERITE_PIGLIN_COIN.get());
        }
        return false;
    }
    @Unique
    private static boolean todeCoins$isWearingGoldPiglinCoin(ServerPlayer player) {
        if (player != null && ModList.get().isLoaded("curios")) {
            ItemStack stack = null;

            Optional<SlotResult> piglinCoin = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.GOLD_PIGLIN_COIN.get());

            if (piglinCoin.isPresent()) {
                stack = piglinCoin.get().stack();
            }

            return stack != null  && stack.is(ModItems.GOLD_PIGLIN_COIN.get());
        }
        return false;
    }
    @Unique
    private static boolean todeCoins$isWearingIronPiglinCoin(ServerPlayer player) {
        if (player != null && ModList.get().isLoaded("curios")) {
            ItemStack stack = null;

            Optional<SlotResult> piglinCoin = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.IRON_PIGLIN_COIN.get());

            if (piglinCoin.isPresent()) {
                stack = piglinCoin.get().stack();
            }

            return stack != null  && stack.is(ModItems.IRON_PIGLIN_COIN.get());
        }
        return false;
    }
    @Unique
    private static boolean todeCoins$isWearingCopperPiglinCoin(ServerPlayer player) {
        if (player != null && ModList.get().isLoaded("curios")) {
            ItemStack stack = null;

            Optional<SlotResult> piglinCoin = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.COPPER_PIGLIN_COIN.get());

            if (piglinCoin.isPresent()) {
                stack = piglinCoin.get().stack();
            }

            return stack != null  && stack.is(ModItems.COPPER_PIGLIN_COIN.get());
        }
        return false;
    }

    @Unique
    private static boolean todeCoins$isGiftEvent(ServerLevel serverLevel) {
        return CalendarUtil.check("EASTER") || CalendarUtil.check("HALLOWEEN")
                || CalendarUtil.check("CHRISTMAS") || CalendarUtil.check("BIRTHDAY")
                || CalendarUtil.check("ANNIVERSARY") || CalendarUtil.check("NEW_YEAR");
    }

    @Inject(at = @At("HEAD"), method = "stopHoldingOffHandItem", cancellable = true)
    private static void todeCoins_stopHoldingOffHandItem(@NotNull Piglin piglin, boolean shouldBarter, CallbackInfo ci) {
        MinecraftServer server = piglin != null ? piglin.getServer() : null;
        ServerLevel serverLevel = server != null ? server.getLevel(piglin.level.dimension()) : null;
        ServerPlayer player = server != null ? server.createCommandSourceStack().getPlayer() : null;
        if (piglin.isAdult()) {
            ItemStack offHandItem = piglin.getItemInHand(InteractionHand.OFF_HAND);
            boolean barterItem = PiglinAi.isBarterCurrency(offHandItem);
            boolean netherGoldCoin = piglin.getItemInHand(InteractionHand.OFF_HAND).is(ModItems.NETHER_GOLD_COIN.get());
            if (shouldBarter && barterItem) {
                piglin.setItemInHand(InteractionHand.OFF_HAND, ItemStack.EMPTY);
                if (shouldBarter && todeCoins$giftChance >= todeCoins$giftRate && todeCoins$isGiftEvent(serverLevel)) {
                    throwItems(piglin, todeCoins_getEventGiftLootResponseItems(piglin));
                }
                if (netherGoldCoin) {
                    throwItems(piglin, todeCoins_getNetherGoldCoinBarterResponseItems(piglin));
                }
                else if (shouldBarter && todeCoins$isWearingNetheritePiglinCoin(player)) {
                    throwItems(piglin, todeCoins_getNetheritePiglinCoinBarterResponseItems(piglin));
                }
                else if (shouldBarter && todeCoins$isWearingGoldPiglinCoin(player)) {
                    throwItems(piglin, todeCoins_getGoldPiglinCoinBarterResponseItems(piglin));
                }
                else if (shouldBarter && todeCoins$isWearingIronPiglinCoin(player)) {
                    throwItems(piglin, todeCoins_getIronPiglinCoinBarterResponseItems(piglin));
                }
                else if (shouldBarter && todeCoins$isWearingCopperPiglinCoin(player)) {
                    throwItems(piglin, todeCoins_getCopperPiglinCoinBarterResponseItems(piglin));
                }
                else if (shouldBarter && todeCoins$isWearingZombiePiglinCoin(player)) {
                    throwItems(piglin, todeCoins_getZombiePiglinCoinBarterResponseItems(piglin));
                }
                else {
                    throwItems(piglin, getBarterResponseItems(piglin));
                }
                ci.cancel();
            }
        }
    }

    @Unique
    private static List<ItemStack> todeCoins_getEventGiftLootResponseItems(@NotNull Piglin piglin) {
        LootTable lootTable = Objects.requireNonNull(piglin.level.getServer()).getLootTables().get(ModBuiltInLootTables.PIGLIN_EVENT_BARTER_LOOT);
        return lootTable.getRandomItems((new LootContext.Builder((ServerLevel) piglin.level)).withParameter(LootContextParams.THIS_ENTITY, piglin).withRandom(piglin.level.random).create(LootContextParamSets.PIGLIN_BARTER));
    }

    @Unique
    private static List<ItemStack> todeCoins_getZombiePiglinCoinBarterResponseItems(@NotNull Piglin piglin) {
        LootTable lootTable = Objects.requireNonNull(piglin.level.getServer()).getLootTables().get(ModBuiltInLootTables.ZOMBIE_PIGLIN_COIN_BARTER_LOOT);
        return lootTable.getRandomItems((new LootContext.Builder((ServerLevel) piglin.level)).withParameter(LootContextParams.THIS_ENTITY, piglin).withRandom(piglin.level.random).create(LootContextParamSets.PIGLIN_BARTER));
    }

    @Unique
    private static List<ItemStack> todeCoins_getCopperPiglinCoinBarterResponseItems(@NotNull Piglin piglin) {
        LootTable lootTable = Objects.requireNonNull(piglin.level.getServer()).getLootTables().get(ModBuiltInLootTables.COPPER_PIGLIN_COIN_BARTER_LOOT);
        return lootTable.getRandomItems((new LootContext.Builder((ServerLevel) piglin.level)).withParameter(LootContextParams.THIS_ENTITY, piglin).withRandom(piglin.level.random).create(LootContextParamSets.PIGLIN_BARTER));
    }

    @Unique
    private static List<ItemStack> todeCoins_getIronPiglinCoinBarterResponseItems(@NotNull Piglin piglin) {
        LootTable lootTable = Objects.requireNonNull(piglin.level.getServer()).getLootTables().get(ModBuiltInLootTables.IRON_PIGLIN_COIN_BARTER_LOOT);
        return lootTable.getRandomItems((new LootContext.Builder((ServerLevel) piglin.level)).withParameter(LootContextParams.THIS_ENTITY, piglin).withRandom(piglin.level.random).create(LootContextParamSets.PIGLIN_BARTER));
    }
    @Unique
    private static List<ItemStack> todeCoins_getGoldPiglinCoinBarterResponseItems(@NotNull Piglin piglin) {
        LootTable lootTable = Objects.requireNonNull(piglin.level.getServer()).getLootTables().get(ModBuiltInLootTables.GOLD_PIGLIN_COIN_BARTER_LOOT);
        return lootTable.getRandomItems((new LootContext.Builder((ServerLevel) piglin.level)).withParameter(LootContextParams.THIS_ENTITY, piglin).withRandom(piglin.level.random).create(LootContextParamSets.PIGLIN_BARTER));
    }
    @Unique
    private static List<ItemStack> todeCoins_getNetheritePiglinCoinBarterResponseItems(@NotNull Piglin piglin) {
        LootTable lootTable = Objects.requireNonNull(piglin.level.getServer()).getLootTables().get(ModBuiltInLootTables.NETHERITE_PIGLIN_COIN_BARTER_LOOT);
        return lootTable.getRandomItems((new LootContext.Builder((ServerLevel) piglin.level)).withParameter(LootContextParams.THIS_ENTITY, piglin).withRandom(piglin.level.random).create(LootContextParamSets.PIGLIN_BARTER));
    }

    @Unique
    private static List<ItemStack> todeCoins_getNetherGoldCoinBarterResponseItems(@NotNull Piglin piglin) {
        LootTable lootTable = Objects.requireNonNull(piglin.level.getServer()).getLootTables().get(ModBuiltInLootTables.NETHER_GOLD_COIN_PIGLIN_BARTERING);
        return lootTable.getRandomItems((new LootContext.Builder((ServerLevel) piglin.level)).withParameter(LootContextParams.THIS_ENTITY, piglin).withRandom(piglin.level.random).create(LootContextParamSets.PIGLIN_BARTER));
    }

    @Inject(at = @At("HEAD"), method = "wantsToPickup", cancellable = true)
    private static void todeCoins_wantsToPickup(Piglin piglin, @NotNull ItemStack pStack, CallbackInfoReturnable<Boolean> cir) {
        if (pStack.is(ForgeTags.Items.PIGLIN_BARTER_ITEMS) && isNotHoldingLovedItemInOffHand(piglin)) {
            cir.setReturnValue(true);
            cir.cancel();
        }
    }
    @Inject(at = @At("HEAD"), method = "canAdmire", cancellable = true)
    private static void todeCoins_canAdmire(Piglin piglin, ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        if (!isAdmiringDisabled(piglin) && !isAdmiringItem(piglin) && piglin.isAdult() && (stack.isPiglinCurrency() || stack.is(ForgeTags.Items.PIGLIN_BARTER_ITEMS))) {
            cir.setReturnValue(true);
            cir.cancel();
        }
    }
    @Inject(at = @At("HEAD"), method = "isBarterCurrency", cancellable = true)
    private static void todeCoins_isBarterCurrency(@NotNull ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        if (stack.is(ForgeTags.Items.PIGLIN_BARTER_ITEMS)) {
            cir.setReturnValue(true);
            cir.cancel();
        }
    }
}