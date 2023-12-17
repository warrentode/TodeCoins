package com.github.warrentode.todecoins.event;

import com.github.warrentode.todecoins.TodeCoins;
import com.github.warrentode.todecoins.attribute.*;
import com.github.warrentode.todecoins.entity.ModEntityTypes;
import com.github.warrentode.todecoins.entity.ai.goal.AvoidPlayerCatCoinGoal;
import com.github.warrentode.todecoins.entity.spawners.numismatist.NumismatistSpawner;
import com.github.warrentode.todecoins.item.ModItems;
import com.github.warrentode.todecoins.util.tags.ModTags;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.living.LivingChangeTargetEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.event.server.ServerStoppedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

public class ModEvents {

    @Mod.EventBusSubscriber(modid = TodeCoins.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEventBusEvents {
        @SubscribeEvent
        public static void onEntityAttributeEvent(@NotNull EntityAttributeCreationEvent event) {
            event.put(ModEntityTypes.NUMISMATIST.get(), Mob.createMobAttributes().build());
        }
    }

    @Mod.EventBusSubscriber(modid = TodeCoins.MODID)
    public static class ForgeEvents {
        @SubscribeEvent
        public static void onItemCrafted(@NotNull PlayerEvent.ItemCraftedEvent event) {
            ItemStack stack = event.getCrafting();
            Player player = event.getEntity();
            if (stack.is(ModTags.Items.NO_AI_EGGS)) {
                final CompoundTag entityTag = stack.getOrCreateTagElement("EntityTag");
                entityTag.putBoolean("NoAI", true);
            }
        }

        @SubscribeEvent
        public static ItemTooltipEvent onItemTooltip(@NotNull ItemTooltipEvent event) {
            ItemStack stack = event.getItemStack();
            Player player = event.getEntity();
            List<Component> tooltip = event.getToolTip();

            if (stack.is(ModItems.CRIMSON_SPORE_CHOCOLATE_COIN.get())) {
                tooltip.add(Component.translatable("tooltips." + ModItems.CRIMSON_SPORE_CHOCOLATE_COIN.get() + "_effects")
                        .withStyle(ChatFormatting.DARK_BLUE));
            }
            if (stack.is(ModItems.WARPED_SPICE_CHOCOLATE_COIN.get())) {
                tooltip.add(Component.translatable("tooltips." + ModItems.WARPED_SPICE_CHOCOLATE_COIN.get() + "_effects")
                        .withStyle(ChatFormatting.DARK_BLUE));
            }
            if (stack.is(ModItems.MILK_BONE_CHOCOLATE_COIN.get())) {
                tooltip.add(Component.translatable("tooltips." + ModItems.MILK_BONE_CHOCOLATE_COIN.get() + "_effects")
                        .withStyle(ChatFormatting.DARK_BLUE));
            }
            if (stack.is(ModItems.ULTIMATE_DARK_CHOCOLATE_COIN.get())) {
                tooltip.add(Component.translatable("tooltips." + ModItems.ULTIMATE_DARK_CHOCOLATE_COIN.get() + "_effects")
                        .withStyle(ChatFormatting.DARK_BLUE));
            }
            if (stack.is(ModItems.BUBBLY_BERRY_CHOCOLATE_COIN.get())) {
                tooltip.add(Component.translatable("tooltips." + ModItems.BUBBLY_BERRY_CHOCOLATE_COIN.get() + "_effects")
                        .withStyle(ChatFormatting.DARK_BLUE));
            }
            if (stack.is(ModItems.VELVETY_CLOVER_CHOCOLATE_COIN.get())) {
                tooltip.add(Component.translatable("tooltips." + ModItems.VELVETY_CLOVER_CHOCOLATE_COIN.get() + "_effects")
                        .withStyle(ChatFormatting.DARK_BLUE));
            }
            if (stack.is(ModItems.FESTIVE_FUDGE_CHOCOLATE_COIN.get())) {
                tooltip.add(Component.translatable("tooltips." + ModItems.FESTIVE_FUDGE_CHOCOLATE_COIN.get() + "_effects")
                        .withStyle(ChatFormatting.DARK_BLUE));
            }
            if (stack.is(ModItems.FUEGO_FUDGE_CHOCOLATE_COIN.get())) {
                tooltip.add(Component.translatable("tooltips." + ModItems.FUEGO_FUDGE_CHOCOLATE_COIN.get() + "_effects")
                        .withStyle(ChatFormatting.DARK_BLUE));
            }
            if (stack.is(ModItems.CARMEL_CRISP_CHOCOLATE_COIN.get())) {
                tooltip.add(Component.translatable("tooltips." + ModItems.CARMEL_CRISP_CHOCOLATE_COIN.get() + "_effects")
                        .withStyle(ChatFormatting.DARK_BLUE));
            }

            if (stack.getItem() instanceof SpawnEggItem) {

                final CompoundTag stackTag = stack.getTagElement("EntityTag");

                if (player != null && stackTag != null && stackTag.getBoolean("NoAI")) {
                    tooltip.add(Component.translatable("tooltips.no_ai_spawn_egg").withStyle(ChatFormatting.GOLD, ChatFormatting.BOLD));
                }
            }
            return event;
        }

        @SubscribeEvent
        public static void onAttachCapabilitiesPlayer(@NotNull AttachCapabilitiesEvent<Entity> event) {
            if (event.getObject() instanceof Player) {
                if (!event.getObject().getCapability(PlayerCharismaProvider.PLAYER_CHARISMA).isPresent()) {
                    event.addCapability(new ResourceLocation(TodeCoins.MODID, "player_charisma"), new PlayerCharismaProvider());
                }
                if (!event.getObject().getCapability(PlayerCodProvider.PLAYER_COD_BONUS).isPresent()) {
                    event.addCapability(new ResourceLocation(TodeCoins.MODID, "player_cod_bonus"), new PlayerCodProvider());
                }
                if (!event.getObject().getCapability(PlayerPufferfishProvider.PLAYER_PUFFERFISH_BONUS).isPresent()) {
                    event.addCapability(new ResourceLocation(TodeCoins.MODID, "player_pufferfish_bonus"), new PlayerPufferfishProvider());
                }
                if (!event.getObject().getCapability(PlayerSalmonProvider.PLAYER_SALMON_BONUS).isPresent()) {
                    event.addCapability(new ResourceLocation(TodeCoins.MODID, "player_salmon_bonus"), new PlayerSalmonProvider());
                }
                if (!event.getObject().getCapability(PlayerTropicalFishProvider.PLAYER_TROPICAL_FISH_BONUS).isPresent()) {
                    event.addCapability(new ResourceLocation(TodeCoins.MODID, "player_tropical_fish_bonus"), new PlayerTropicalFishProvider());
                }
            }
        }

        @SubscribeEvent
        public static void onEntityAttributeModificationEvent(@NotNull final EntityAttributeModificationEvent event) {
            event.add(EntityType.PLAYER, ModAttributes.CHARISMA.get());
            event.add(EntityType.PLAYER, ModAttributes.COD_BONUS.get());
            event.add(EntityType.PLAYER, ModAttributes.PUFFERFISH_BONUS.get());
            event.add(EntityType.PLAYER, ModAttributes.SALMON_BONUS.get());
            event.add(EntityType.PLAYER, ModAttributes.TROPICAL_FISH_BONUS.get());
        }

        @SubscribeEvent
        public static void onPlayerCloned(@NotNull PlayerEvent.Clone event) {
            if (event.isWasDeath()) {
                event.getOriginal().getCapability(PlayerCharismaProvider.PLAYER_CHARISMA)
                        .ifPresent(oldStore -> event.getOriginal().getCapability(PlayerCharismaProvider.PLAYER_CHARISMA)
                                .ifPresent(newStore -> newStore.copyFrom(oldStore)));
                event.getOriginal().getCapability(PlayerCodProvider.PLAYER_COD_BONUS)
                        .ifPresent(oldStore -> event.getOriginal().getCapability(PlayerCodProvider.PLAYER_COD_BONUS)
                                .ifPresent(newStore -> newStore.copyFrom(oldStore)));
                event.getOriginal().getCapability(PlayerPufferfishProvider.PLAYER_PUFFERFISH_BONUS)
                        .ifPresent(oldStore -> event.getOriginal().getCapability(PlayerPufferfishProvider.PLAYER_PUFFERFISH_BONUS)
                                .ifPresent(newStore -> newStore.copyFrom(oldStore)));
                event.getOriginal().getCapability(PlayerSalmonProvider.PLAYER_SALMON_BONUS)
                        .ifPresent(oldStore -> event.getOriginal().getCapability(PlayerSalmonProvider.PLAYER_SALMON_BONUS)
                                .ifPresent(newStore -> newStore.copyFrom(oldStore)));
                event.getOriginal().getCapability(PlayerTropicalFishProvider.PLAYER_TROPICAL_FISH_BONUS)
                        .ifPresent(oldStore -> event.getOriginal().getCapability(PlayerTropicalFishProvider.PLAYER_TROPICAL_FISH_BONUS)
                                .ifPresent(newStore -> newStore.copyFrom(oldStore)));
            }
        }

        @SubscribeEvent
        public static void onRegisterCapabilities(@NotNull RegisterCapabilitiesEvent event) {
            event.register(PlayerCharisma.class);
        }

        @SuppressWarnings("SameReturnValue")
        @SubscribeEvent
        public static boolean onLivingDeath(@NotNull LivingDeathEvent event) {
            LivingEntity dyingEntity = event.getEntity();
            Level level = dyingEntity.getCommandSenderWorld();
            DamageSource source = event.getSource();
            LivingEntity target = event.getEntity();
            if (!level.isClientSide) {
                if (dyingEntity instanceof ServerPlayer player) {
                    Inventory playerInventory = player.getInventory();
                    DamageSource damageSource = player.getLastDamageSource();
                    ItemStack luckyCoin = null;

                    if (ModList.get().isLoaded("curios")) {
                        Optional<SlotResult> optional = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.LUCKY_COIN.get());
                        if (optional.isPresent()) {
                            luckyCoin = optional.get().stack();
                        }
                        else {
                            for (int i = 0; i < playerInventory.getContainerSize(); ++i) {
                                ItemStack inventoryItem = playerInventory.getItem(i);
                                if (inventoryItem.getItem().equals(ModItems.LUCKY_COIN.get())) {
                                    luckyCoin = inventoryItem;
                                    break;
                                }
                            }
                        }
                    }
                    else {
                        for (int i = 0; i < playerInventory.getContainerSize(); ++i) {
                            ItemStack inventoryItem = playerInventory.getItem(i);
                            if (inventoryItem.getItem().equals(ModItems.LUCKY_COIN.get())) {
                                luckyCoin = inventoryItem;
                                break;
                            }
                        }
                    }

                    if (luckyCoin != null) {
                        player.setHealth(1.0F);
                        player.removeAllEffects();
                        player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 100, 1));
                        player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 800, 0));
                        player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 900, 1));
                        if (damageSource != null && damageSource == DamageSource.OUT_OF_WORLD) {
                            player.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 900, 0));
                        }
                        level.broadcastEntityEvent(player, (byte) 35);
                        luckyCoin.shrink(1);
                        event.setCanceled(true);
                    }
                }
            }
            return false;
        }

        @SuppressWarnings("SameReturnValue")
        @SubscribeEvent
        public static boolean onAttackEntity(@NotNull AttackEntityEvent event) {
            LivingEntity entity = event.getEntity();
            Entity target = event.getTarget();
            Level level = entity.getCommandSenderWorld();

            if (!level.isClientSide) {
                if (entity instanceof ServerPlayer player) {
                    Inventory playerInventory = player.getInventory();
                    DamageSource damageSource = player.getLastDamageSource();

                    Boolean poisonCharm = getPoisonCharm(player);
                    Boolean arthropodCharm = getArthropodCharm(player);
                    Boolean flameCharm = getFlameCharm(player);
                    Boolean slownessCharm = getSlowCharm(player);
                    Boolean smiteCharm = getSmiteCharm(player);
                    Boolean illagerCharm = getIllagerCharm(player);
                    Boolean witheringCharm = getWitheringCharm(player);

                    int effectDuration = 0;
                    int effectAmplifier = 0;

                    if (player.level.getDifficulty() == Difficulty.EASY) {
                        effectDuration = 5;
                        effectAmplifier = 1;
                    }
                    else if (player.level.getDifficulty() == Difficulty.NORMAL) {
                        effectDuration = 10;
                        effectAmplifier = 2;
                    }
                    else if (player.level.getDifficulty() == Difficulty.HARD) {
                        effectDuration = 20;
                        effectAmplifier = 3;
                    }

                    if (target != null) {
                        if (poisonCharm == true && target instanceof LivingEntity) {
                            ((LivingEntity) target).addEffect(new MobEffectInstance(MobEffects.POISON, (effectDuration * 20) + 20, effectAmplifier), target);
                        }
                        if (arthropodCharm == true && ((LivingEntity) target).getMobType() == MobType.ARTHROPOD) {
                            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, (effectDuration * 20) + 20, effectAmplifier));
                            ((LivingEntity) target).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, (effectDuration * 20) + 20, effectAmplifier), target);
                        }
                        if (flameCharm == true && target instanceof LivingEntity) {
                            target.setSecondsOnFire((effectDuration * 20) + 20);
                        }
                        if (slownessCharm == true && target instanceof LivingEntity) {
                            ((LivingEntity) target).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, (effectDuration * 20) + 20, effectAmplifier), target);
                        }
                        if (smiteCharm == true && ((LivingEntity) target).getMobType() == MobType.UNDEAD) {
                            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, (effectDuration * 20) + 20, effectAmplifier));
                            ((LivingEntity) target).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, (effectDuration * 20) + 20, effectAmplifier), target);
                        }
                        if (illagerCharm == true && ((target instanceof AbstractIllager || target instanceof Ravager || target instanceof Vex || target instanceof Witch))) {
                            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, (effectDuration * 20) + 20, effectAmplifier));
                        }
                        if (witheringCharm == true && target instanceof LivingEntity) {
                            ((LivingEntity) target).addEffect(new MobEffectInstance(MobEffects.WITHER, (effectDuration * 20) + 20, effectAmplifier), target);
                        }
                    }
                }
            }
            return false;
        }

        private static Boolean getWitheringCharm(ServerPlayer player) {
            if (ModList.get().isLoaded("curios")) {
                Optional<SlotResult> witherSkeletonCoin1 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.COPPER_WITHER_SKELETON_COIN.get());
                Optional<SlotResult> witherSkeletonCoin2 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.IRON_WITHER_SKELETON_COIN.get());
                Optional<SlotResult> witherSkeletonCoin3 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.GOLD_WITHER_SKELETON_COIN.get());
                Optional<SlotResult> witherSkeletonCoin4 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.NETHERITE_WITHER_SKELETON_COIN.get());
                Optional<SlotResult> witherCoin1 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.COPPER_WITHER_COIN.get());
                Optional<SlotResult> witherCoin2 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.IRON_WITHER_COIN.get());
                Optional<SlotResult> witherCoin3 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.GOLD_WITHER_COIN.get());
                Optional<SlotResult> witherCoin4 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.NETHERITE_WITHER_COIN.get());

                return witherSkeletonCoin1.isPresent() || witherSkeletonCoin2.isPresent() || witherSkeletonCoin3.isPresent() || witherSkeletonCoin4.isPresent()
                        || witherCoin1.isPresent() || witherCoin2.isPresent() || witherCoin3.isPresent() || witherCoin4.isPresent();
            }
            return false;
        }

        private static Boolean getIllagerCharm(ServerPlayer player) {
            if (ModList.get().isLoaded("curios")) {
                Optional<SlotResult> witchCoin1 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.COPPER_WITCH_COIN.get());
                Optional<SlotResult> witchCoin2 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.IRON_WITCH_COIN.get());
                Optional<SlotResult> witchCoin3 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.GOLD_WITCH_COIN.get());
                Optional<SlotResult> witchCoin4 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.NETHERITE_WITCH_COIN.get());
                Optional<SlotResult> iceologerCoin1 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.COPPER_ICEOLOGER_COIN.get());
                Optional<SlotResult> iceologerCoin2 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.IRON_ICEOLOGER_COIN.get());
                Optional<SlotResult> iceologerCoin3 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.GOLD_ICEOLOGER_COIN.get());
                Optional<SlotResult> iceologerCoin4 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.NETHERITE_ICEOLOGER_COIN.get());
                Optional<SlotResult> ravagerCoin1 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.COPPER_RAVAGER_COIN.get());
                Optional<SlotResult> ravagerCoin2 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.IRON_RAVAGER_COIN.get());
                Optional<SlotResult> ravagerCoin3 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.GOLD_RAVAGER_COIN.get());
                Optional<SlotResult> ravagerCoin4 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.NETHERITE_RAVAGER_COIN.get());
                Optional<SlotResult> evokerCoin1 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.COPPER_EVOKER_COIN.get());
                Optional<SlotResult> evokerCoin2 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.IRON_EVOKER_COIN.get());
                Optional<SlotResult> evokerCoin3 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.GOLD_EVOKER_COIN.get());
                Optional<SlotResult> evokerCoin4 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.NETHERITE_EVOKER_COIN.get());
                Optional<SlotResult> vexCoin1 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.COPPER_VEX_COIN.get());
                Optional<SlotResult> vexCoin2 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.IRON_VEX_COIN.get());
                Optional<SlotResult> vexCoin3 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.GOLD_VEX_COIN.get());
                Optional<SlotResult> vexCoin4 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.NETHERITE_VEX_COIN.get());
                Optional<SlotResult> illusionerCoin1 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.COPPER_ILLUSIONER_COIN.get());
                Optional<SlotResult> illusionerCoin2 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.IRON_ILLUSIONER_COIN.get());
                Optional<SlotResult> illusionerCoin3 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.GOLD_ILLUSIONER_COIN.get());
                Optional<SlotResult> illusionerCoin4 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.NETHERITE_ILLUSIONER_COIN.get());
                Optional<SlotResult> pillagerCoin1 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.COPPER_PILLAGER_COIN.get());
                Optional<SlotResult> pillagerCoin2 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.IRON_PILLAGER_COIN.get());
                Optional<SlotResult> pillagerCoin3 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.GOLD_PILLAGER_COIN.get());
                Optional<SlotResult> pillagerCoin4 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.NETHERITE_PILLAGER_COIN.get());

                return witchCoin1.isPresent() || witchCoin2.isPresent() || witchCoin3.isPresent() || witchCoin4.isPresent()
                        || iceologerCoin1.isPresent() || iceologerCoin2.isPresent() || iceologerCoin3.isPresent() || iceologerCoin4.isPresent()
                        || ravagerCoin1.isPresent() || ravagerCoin2.isPresent() || ravagerCoin3.isPresent() || ravagerCoin4.isPresent()
                        || evokerCoin1.isPresent() || evokerCoin2.isPresent() || evokerCoin3.isPresent() || evokerCoin4.isPresent()
                        || vexCoin1.isPresent() || vexCoin2.isPresent() || vexCoin3.isPresent() || vexCoin4.isPresent()
                        || illusionerCoin1.isPresent() || illusionerCoin2.isPresent() || illusionerCoin3.isPresent() || illusionerCoin4.isPresent()
                        || pillagerCoin1.isPresent() || pillagerCoin2.isPresent() || pillagerCoin3.isPresent() || pillagerCoin4.isPresent();
            }
            return false;
        }

        private static Boolean getSmiteCharm(ServerPlayer player) {
            if (ModList.get().isLoaded("curios")) {
                Optional<SlotResult> drownedCoin1 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.COPPER_DROWNED_COIN.get());
                Optional<SlotResult> drownedCoin2 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.IRON_DROWNED_COIN.get());
                Optional<SlotResult> drownedCoin3 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.GOLD_DROWNED_COIN.get());
                Optional<SlotResult> drownedCoin4 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.NETHERITE_DROWNED_COIN.get());
                Optional<SlotResult> giantCoin1 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.COPPER_GIANT_COIN.get());
                Optional<SlotResult> giantCoin2 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.IRON_GIANT_COIN.get());
                Optional<SlotResult> giantCoin3 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.GOLD_GIANT_COIN.get());
                Optional<SlotResult> giantCoin4 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.NETHERITE_GIANT_COIN.get());
                Optional<SlotResult> huskCoin1 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.COPPER_HUSK_COIN.get());
                Optional<SlotResult> huskCoin2 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.IRON_HUSK_COIN.get());
                Optional<SlotResult> huskCoin3 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.GOLD_HUSK_COIN.get());
                Optional<SlotResult> huskCoin4 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.NETHERITE_HUSK_COIN.get());
                Optional<SlotResult> phantomCoin1 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.COPPER_PHANTOM_COIN.get());
                Optional<SlotResult> phantomCoin2 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.IRON_PHANTOM_COIN.get());
                Optional<SlotResult> phantomCoin3 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.GOLD_PHANTOM_COIN.get());
                Optional<SlotResult> phantomCoin4 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.NETHERITE_PHANTOM_COIN.get());
                Optional<SlotResult> skeletonCoin1 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.COPPER_SKELETON_COIN.get());
                Optional<SlotResult> skeletonCoin2 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.IRON_SKELETON_COIN.get());
                Optional<SlotResult> skeletonCoin3 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.GOLD_SKELETON_COIN.get());
                Optional<SlotResult> skeletonCoin4 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.NETHERITE_SKELETON_COIN.get());
                Optional<SlotResult> skeletonHorseCoin1 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.COPPER_SKELETON_HORSE_COIN.get());
                Optional<SlotResult> skeletonHorseCoin2 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.IRON_SKELETON_HORSE_COIN.get());
                Optional<SlotResult> skeletonHorseCoin3 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.GOLD_SKELETON_HORSE_COIN.get());
                Optional<SlotResult> skeletonHorseCoin4 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.NETHERITE_SKELETON_HORSE_COIN.get());
                Optional<SlotResult> strayCoin1 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.COPPER_STRAY_COIN.get());
                Optional<SlotResult> strayCoin2 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.IRON_STRAY_COIN.get());
                Optional<SlotResult> strayCoin3 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.GOLD_STRAY_COIN.get());
                Optional<SlotResult> strayCoin4 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.NETHERITE_STRAY_COIN.get());
                Optional<SlotResult> witherSkeletonCoin1 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.COPPER_WITHER_SKELETON_COIN.get());
                Optional<SlotResult> witherSkeletonCoin2 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.IRON_WITHER_SKELETON_COIN.get());
                Optional<SlotResult> witherSkeletonCoin3 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.GOLD_WITHER_SKELETON_COIN.get());
                Optional<SlotResult> witherSkeletonCoin4 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.NETHERITE_WITHER_SKELETON_COIN.get());
                Optional<SlotResult> witherCoin1 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.COPPER_WITHER_COIN.get());
                Optional<SlotResult> witherCoin2 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.IRON_WITHER_COIN.get());
                Optional<SlotResult> witherCoin3 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.GOLD_WITHER_COIN.get());
                Optional<SlotResult> witherCoin4 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.NETHERITE_WITHER_COIN.get());
                Optional<SlotResult> zombieCoin1 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.COPPER_ZOMBIE_COIN.get());
                Optional<SlotResult> zombieCoin2 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.IRON_ZOMBIE_COIN.get());
                Optional<SlotResult> zombieCoin3 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.GOLD_ZOMBIE_COIN.get());
                Optional<SlotResult> zombieCoin4 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.NETHERITE_ZOMBIE_COIN.get());
                Optional<SlotResult> zombieHorseCoin1 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.COPPER_ZOMBIE_HORSE_COIN.get());
                Optional<SlotResult> zombieHorseCoin2 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.IRON_ZOMBIE_HORSE_COIN.get());
                Optional<SlotResult> zombieHorseCoin3 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.GOLD_ZOMBIE_HORSE_COIN.get());
                Optional<SlotResult> zombieHorseCoin4 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.NETHERITE_ZOMBIE_HORSE_COIN.get());
                Optional<SlotResult> zombieVillagerCoin1 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.COPPER_ZOMBIE_VILLAGER_COIN.get());
                Optional<SlotResult> zombieVillagerCoin2 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.IRON_ZOMBIE_VILLAGER_COIN.get());
                Optional<SlotResult> zombieVillagerCoin3 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.GOLD_ZOMBIE_VILLAGER_COIN.get());
                Optional<SlotResult> zombieVillagerCoin4 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.NETHERITE_ZOMBIE_VILLAGER_COIN.get());
                Optional<SlotResult> zombiePiglinCoin1 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.COPPER_ZOMBIFIED_PIGLIN_COIN.get());
                Optional<SlotResult> zombiePiglinCoin2 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.IRON_ZOMBIFIED_PIGLIN_COIN.get());
                Optional<SlotResult> zombiePiglinCoin3 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.GOLD_ZOMBIFIED_PIGLIN_COIN.get());
                Optional<SlotResult> zombiePiglinCoin4 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.NETHERITE_ZOMBIFIED_PIGLIN_COIN.get());
                Optional<SlotResult> zoglinCoin1 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.COPPER_ZOGLIN_COIN.get());
                Optional<SlotResult> zoglinCoin2 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.IRON_ZOGLIN_COIN.get());
                Optional<SlotResult> zoglinCoin3 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.GOLD_ZOGLIN_COIN.get());
                Optional<SlotResult> zoglinCoin4 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.NETHERITE_ZOGLIN_COIN.get());

                return drownedCoin1.isPresent() || drownedCoin2.isPresent() || drownedCoin3.isPresent() || drownedCoin4.isPresent()
                        || giantCoin1.isPresent() || giantCoin2.isPresent() || giantCoin3.isPresent() || giantCoin4.isPresent()
                        || huskCoin1.isPresent() || huskCoin2.isPresent() || huskCoin3.isPresent() || huskCoin4.isPresent()
                        || phantomCoin1.isPresent() || phantomCoin2.isPresent() || phantomCoin3.isPresent() || phantomCoin4.isPresent()
                        || skeletonCoin1.isPresent() || skeletonCoin2.isPresent() || skeletonCoin3.isPresent() || skeletonCoin4.isPresent()
                        || skeletonHorseCoin1.isPresent() || skeletonHorseCoin2.isPresent() || skeletonHorseCoin3.isPresent() || skeletonHorseCoin4.isPresent()
                        || strayCoin1.isPresent() || strayCoin2.isPresent() || strayCoin3.isPresent() || strayCoin4.isPresent()
                        || witherSkeletonCoin1.isPresent() || witherSkeletonCoin2.isPresent() || witherSkeletonCoin3.isPresent() || witherSkeletonCoin4.isPresent()
                        || witherCoin1.isPresent() || witherCoin2.isPresent() || witherCoin3.isPresent() || witherCoin4.isPresent()
                        || zombieCoin1.isPresent() || zombieCoin2.isPresent() || zombieCoin3.isPresent() || zombieCoin4.isPresent()
                        || zombieHorseCoin1.isPresent() || zombieHorseCoin2.isPresent() || zombieHorseCoin3.isPresent() || zombieHorseCoin4.isPresent()
                        || zombieVillagerCoin1.isPresent() || zombieVillagerCoin2.isPresent() || zombieVillagerCoin3.isPresent() || zombieVillagerCoin4.isPresent()
                        || zombiePiglinCoin1.isPresent() || zombiePiglinCoin2.isPresent() || zombiePiglinCoin3.isPresent() || zombiePiglinCoin4.isPresent()
                        || zoglinCoin1.isPresent() || zoglinCoin2.isPresent() || zoglinCoin3.isPresent() || zoglinCoin4.isPresent();
            }
            return false;
        }

        private static Boolean getSlowCharm(ServerPlayer player) {
            if (ModList.get().isLoaded("curios")) {
                Optional<SlotResult> spiderCoin1 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.COPPER_SPIDER_COIN.get());
                Optional<SlotResult> spiderCoin2 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.IRON_SPIDER_COIN.get());
                Optional<SlotResult> spiderCoin3 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.GOLD_SPIDER_COIN.get());
                Optional<SlotResult> spiderCoin4 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.NETHERITE_SPIDER_COIN.get());
                Optional<SlotResult> strayCoin1 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.COPPER_STRAY_COIN.get());
                Optional<SlotResult> strayCoin2 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.IRON_STRAY_COIN.get());
                Optional<SlotResult> strayCoin3 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.GOLD_STRAY_COIN.get());
                Optional<SlotResult> strayCoin4 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.NETHERITE_STRAY_COIN.get());
                Optional<SlotResult> iceologerCoin1 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.COPPER_ICEOLOGER_COIN.get());
                Optional<SlotResult> iceologerCoin2 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.IRON_ICEOLOGER_COIN.get());
                Optional<SlotResult> iceologerCoin3 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.GOLD_ICEOLOGER_COIN.get());
                Optional<SlotResult> iceologerCoin4 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.NETHERITE_ICEOLOGER_COIN.get());

                return spiderCoin1.isPresent() || spiderCoin2.isPresent() || spiderCoin3.isPresent() || spiderCoin4.isPresent()
                        || strayCoin1.isPresent() || strayCoin2.isPresent() || strayCoin3.isPresent() || strayCoin4.isPresent()
                        || iceologerCoin1.isPresent() || iceologerCoin2.isPresent() || iceologerCoin3.isPresent() || iceologerCoin4.isPresent();
            }
            return false;
        }

        private static Boolean getFlameCharm(ServerPlayer player) {
            if (ModList.get().isLoaded("curios")) {
                Optional<SlotResult> blazeCoin1 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.COPPER_BLAZE_COIN.get());
                Optional<SlotResult> blazeCoin2 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.IRON_BLAZE_COIN.get());
                Optional<SlotResult> blazeCoin3 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.GOLD_BLAZE_COIN.get());
                Optional<SlotResult> blazeCoin4 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.NETHERITE_BLAZE_COIN.get());
                Optional<SlotResult> wildfireCoin1 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.COPPER_WILDFIRE_COIN.get());
                Optional<SlotResult> wildfireCoin2 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.IRON_WILDFIRE_COIN.get());
                Optional<SlotResult> wildfireCoin3 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.GOLD_WILDFIRE_COIN.get());
                Optional<SlotResult> wildfireCoin4 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.NETHERITE_WILDFIRE_COIN.get());
                Optional<SlotResult> magmaCubeCoin1 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.COPPER_MAGMA_CUBE_COIN.get());
                Optional<SlotResult> magmaCubeCoin2 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.IRON_MAGMA_CUBE_COIN.get());
                Optional<SlotResult> magmaCubeCoin3 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.GOLD_MAGMA_CUBE_COIN.get());
                Optional<SlotResult> magmaCubeCoin4 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.NETHERITE_MAGMA_CUBE_COIN.get());

                return blazeCoin1.isPresent() || blazeCoin2.isPresent() || blazeCoin3.isPresent() || blazeCoin4.isPresent()
                        || wildfireCoin1.isPresent() || wildfireCoin2.isPresent() || wildfireCoin3.isPresent() || wildfireCoin4.isPresent()
                        || magmaCubeCoin1.isPresent() || magmaCubeCoin2.isPresent() || magmaCubeCoin3.isPresent() || magmaCubeCoin4.isPresent();
            }
            return false;
        }

        private static Boolean getArthropodCharm(ServerPlayer player) {
            if (ModList.get().isLoaded("curios")) {
                Optional<SlotResult> beeCoin1 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.COPPER_BEE_COIN.get());
                Optional<SlotResult> beeCoin2 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.IRON_BEE_COIN.get());
                Optional<SlotResult> beeCoin3 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.GOLD_BEE_COIN.get());
                Optional<SlotResult> beeCoin4 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.NETHERITE_BEE_COIN.get());
                Optional<SlotResult> caveSpiderCoin1 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.COPPER_CAVE_SPIDER_COIN.get());
                Optional<SlotResult> caveSpiderCoin2 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.IRON_CAVE_SPIDER_COIN.get());
                Optional<SlotResult> caveSpiderCoin3 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.GOLD_CAVE_SPIDER_COIN.get());
                Optional<SlotResult> caveSpiderCoin4 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.NETHERITE_CAVE_SPIDER_COIN.get());
                Optional<SlotResult> spiderCoin1 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.COPPER_SPIDER_COIN.get());
                Optional<SlotResult> spiderCoin2 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.IRON_SPIDER_COIN.get());
                Optional<SlotResult> spiderCoin3 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.GOLD_SPIDER_COIN.get());
                Optional<SlotResult> spiderCoin4 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.NETHERITE_SPIDER_COIN.get());
                Optional<SlotResult> silverfishCoin1 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.COPPER_SILVERFISH_COIN.get());
                Optional<SlotResult> silverfishCoin2 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.IRON_SILVERFISH_COIN.get());
                Optional<SlotResult> silverfishCoin3 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.GOLD_SILVERFISH_COIN.get());
                Optional<SlotResult> silverfishCoin4 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.NETHERITE_SILVERFISH_COIN.get());
                Optional<SlotResult> endermiteCoin1 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.COPPER_ENDERMITE_COIN.get());
                Optional<SlotResult> endermiteCoin2 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.IRON_ENDERMITE_COIN.get());
                Optional<SlotResult> endermiteCoin3 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.GOLD_ENDERMITE_COIN.get());
                Optional<SlotResult> endermiteCoin4 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.NETHERITE_ENDERMITE_COIN.get());

                return beeCoin1.isPresent() || beeCoin2.isPresent() || beeCoin3.isPresent() || beeCoin4.isPresent()
                        || caveSpiderCoin1.isPresent() || caveSpiderCoin2.isPresent() || caveSpiderCoin3.isPresent() || caveSpiderCoin4.isPresent()
                        || spiderCoin1.isPresent() || spiderCoin2.isPresent() || spiderCoin3.isPresent() || spiderCoin4.isPresent()
                        || silverfishCoin1.isPresent() || silverfishCoin2.isPresent() || silverfishCoin3.isPresent() || silverfishCoin4.isPresent()
                        || endermiteCoin1.isPresent() || endermiteCoin2.isPresent() || endermiteCoin3.isPresent() || endermiteCoin4.isPresent();
            }
            return false;
        }

        private static Boolean getPoisonCharm(ServerPlayer player) {
            if (ModList.get().isLoaded("curios")) {
                Optional<SlotResult> beeCoin1 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.COPPER_BEE_COIN.get());
                Optional<SlotResult> beeCoin2 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.IRON_BEE_COIN.get());
                Optional<SlotResult> beeCoin3 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.GOLD_BEE_COIN.get());
                Optional<SlotResult> beeCoin4 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.NETHERITE_BEE_COIN.get());
                Optional<SlotResult> caveSpiderCoin1 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.COPPER_CAVE_SPIDER_COIN.get());
                Optional<SlotResult> caveSpiderCoin2 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.IRON_CAVE_SPIDER_COIN.get());
                Optional<SlotResult> caveSpiderCoin3 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.GOLD_CAVE_SPIDER_COIN.get());
                Optional<SlotResult> caveSpiderCoin4 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.NETHERITE_CAVE_SPIDER_COIN.get());
                Optional<SlotResult> witchCoin1 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.COPPER_WITCH_COIN.get());
                Optional<SlotResult> witchCoin2 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.IRON_WITCH_COIN.get());
                Optional<SlotResult> witchCoin3 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.GOLD_WITCH_COIN.get());
                Optional<SlotResult> witchCoin4 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.NETHERITE_WITCH_COIN.get());

                return beeCoin1.isPresent() || beeCoin2.isPresent() || beeCoin3.isPresent() || beeCoin4.isPresent()
                        || caveSpiderCoin1.isPresent() || caveSpiderCoin2.isPresent() || caveSpiderCoin3.isPresent() || caveSpiderCoin4.isPresent()
                        || witchCoin1.isPresent() || witchCoin2.isPresent() || witchCoin3.isPresent() || witchCoin4.isPresent();
            }
            return false;
        }

        @SuppressWarnings("SameReturnValue")
        @SubscribeEvent
        public static boolean onLivingChangeTargetAttack(@NotNull LivingChangeTargetEvent event) {
            LivingEntity entity = event.getEntity();
            Entity target = event.getOriginalTarget();
            Level level = entity.getCommandSenderWorld();

            if (!level.isClientSide) {
                if (entity instanceof Phantom phantom && target instanceof ServerPlayer player) {
                    ItemStack catCharm = null;

                    Optional<SlotResult> catCoin1 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.COPPER_CAT_COIN.get());
                    Optional<SlotResult> catCoin2 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.IRON_CAT_COIN.get());
                    Optional<SlotResult> catCoin3 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.GOLD_CAT_COIN.get());
                    Optional<SlotResult> catCoin4 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.NETHERITE_CAT_COIN.get());

                    Optional<SlotResult> ocelotCoin1 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.COPPER_OCELOT_COIN.get());
                    Optional<SlotResult> ocelotCoin2 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.IRON_OCELOT_COIN.get());
                    Optional<SlotResult> ocelotCoin3 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.GOLD_OCELOT_COIN.get());
                    Optional<SlotResult> ocelotCoin4 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.NETHERITE_OCELOT_COIN.get());

                    if (catCoin1.isPresent()) {
                        catCharm = catCoin1.get().stack();
                    }
                    else if (catCoin2.isPresent()) {
                        catCharm = catCoin2.get().stack();
                    }
                    else if (catCoin3.isPresent()) {
                        catCharm = catCoin3.get().stack();
                    }
                    else if (catCoin4.isPresent()) {
                        catCharm = catCoin4.get().stack();
                    }
                    else if (ocelotCoin1.isPresent()) {
                        catCharm = ocelotCoin1.get().stack();
                    }
                    else if (ocelotCoin2.isPresent()) {
                        catCharm = ocelotCoin2.get().stack();
                    }
                    else if (ocelotCoin3.isPresent()) {
                        catCharm = ocelotCoin3.get().stack();
                    }
                    else if (ocelotCoin4.isPresent()) {
                        catCharm = ocelotCoin4.get().stack();
                    }

                    if (catCharm != null && (catCharm.is(ModTags.Items.CAT_COIN_SET) || catCharm.is(ModTags.Items.OCELOT_COIN_SET))) {
                        event.setCanceled(true);
                    }
                }
            }
            return false;
        }

        @SuppressWarnings("SameReturnValue")
        @SubscribeEvent
        public static boolean onEntityJoinLevelEvent(@NotNull EntityJoinLevelEvent event) {
            Entity entity = event.getEntity();
            if (entity instanceof Creeper) {
                Creeper creeper = (Creeper) event.getEntity();
                creeper.goalSelector.addGoal(3, new AvoidPlayerCatCoinGoal<>(creeper, Player.class, 16.0F, 1.0D, 1.2D));
            }
            return false;
        }
    }

    @Mod.EventBusSubscriber(modid = MODID)
    public static class CustomSpawnerHandler {
        private static Map<ResourceLocation, NumismatistSpawner> numismatistSpawner = new HashMap<>();

        @SubscribeEvent
        public static void onWorldLoad(@NotNull ServerStartingEvent event) {
            MinecraftServer server = event.getServer();
            numismatistSpawner.put(BuiltinDimensionTypes.OVERWORLD.location(), new NumismatistSpawner(server, "Numismatist", ModEntityTypes.NUMISMATIST.get()));
        }

        @SubscribeEvent
        public static void onServerStopped(ServerStoppedEvent event) {
            numismatistSpawner.clear();
        }

        @SubscribeEvent
        public static void onWorldTick(@NotNull TickEvent.LevelTickEvent event) {
            if (event.phase != TickEvent.Phase.START) {
                return;
            }

            if (event.side != LogicalSide.SERVER) {
                return;
            }

            NumismatistSpawner spawner = numismatistSpawner.get(event.level.dimension().location());
            if (spawner != null) {
                spawner.tick((ServerLevel) event.level, true, true);
            }
        }
    }
}