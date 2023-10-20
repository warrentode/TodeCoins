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
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.AbstractIllager;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Phantom;
import net.minecraft.world.entity.monster.Ravager;
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

            if (stack.getItem() instanceof SpawnEggItem) {

                final CompoundTag stackTag = stack.getTagElement("EntityTag");

                if (player != null && stackTag != null && stackTag.getBoolean("NoAI")) {
                    tooltip.add(Component.translatable("tooltips.no_ai_spawn_egg")
                            .withStyle(ChatFormatting.GOLD, ChatFormatting.BOLD));
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

                    ItemStack poisonCharm = null;
                    ItemStack flameCharm = null;
                    ItemStack slownessCharm = null;
                    ItemStack smiteCharm = null;
                    ItemStack illagerCharm = null;
                    ItemStack arthropodCharm = null;
                    ItemStack witheringCharm = null;

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

                        Optional<SlotResult> silverfishCoin1 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.COPPER_SILVERFISH_COIN.get());
                        Optional<SlotResult> silverfishCoin2 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.IRON_SILVERFISH_COIN.get());
                        Optional<SlotResult> silverfishCoin3 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.GOLD_SILVERFISH_COIN.get());
                        Optional<SlotResult> silverfishCoin4 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.NETHERITE_SILVERFISH_COIN.get());

                        Optional<SlotResult> endermiteCoin1 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.COPPER_ENDERMITE_COIN.get());
                        Optional<SlotResult> endermiteCoin2 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.IRON_ENDERMITE_COIN.get());
                        Optional<SlotResult> endermiteCoin3 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.GOLD_ENDERMITE_COIN.get());
                        Optional<SlotResult> endermiteCoin4 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.NETHERITE_ENDERMITE_COIN.get());

                        if (beeCoin1.isPresent()) {
                            poisonCharm = beeCoin1.get().stack();
                        }
                        else if (beeCoin2.isPresent()) {
                            poisonCharm = beeCoin2.get().stack();
                        }
                        else if (beeCoin3.isPresent()) {
                            poisonCharm = beeCoin3.get().stack();
                        }
                        else if (beeCoin4.isPresent()) {
                            poisonCharm = beeCoin4.get().stack();
                        }
                        else if (caveSpiderCoin1.isPresent()) {
                            poisonCharm = caveSpiderCoin1.get().stack();
                        }
                        else if (caveSpiderCoin2.isPresent()) {
                            poisonCharm = caveSpiderCoin2.get().stack();
                        }
                        else if (caveSpiderCoin3.isPresent()) {
                            poisonCharm = caveSpiderCoin3.get().stack();
                        }
                        else if (caveSpiderCoin4.isPresent()) {
                            poisonCharm = caveSpiderCoin4.get().stack();
                        }
                        else if (witchCoin1.isPresent()) {
                            poisonCharm = witchCoin1.get().stack();
                        }
                        else if (witchCoin2.isPresent()) {
                            poisonCharm = witchCoin2.get().stack();
                        }
                        else if (witchCoin3.isPresent()) {
                            poisonCharm = witchCoin3.get().stack();
                        }
                        else if (witchCoin4.isPresent()) {
                            poisonCharm = witchCoin4.get().stack();
                        }

                        if (wildfireCoin1.isPresent()) {
                            flameCharm = wildfireCoin1.get().stack();
                        }
                        else if (wildfireCoin2.isPresent()) {
                            flameCharm = wildfireCoin2.get().stack();
                        }
                        else if (wildfireCoin3.isPresent()) {
                            flameCharm = wildfireCoin3.get().stack();
                        }
                        else if (wildfireCoin4.isPresent()) {
                            flameCharm = wildfireCoin4.get().stack();
                        }
                        else if (blazeCoin1.isPresent()) {
                            flameCharm = blazeCoin1.get().stack();
                        }
                        else if (blazeCoin2.isPresent()) {
                            flameCharm = blazeCoin2.get().stack();
                        }
                        else if (blazeCoin3.isPresent()) {
                            flameCharm = blazeCoin3.get().stack();
                        }
                        else if (blazeCoin4.isPresent()) {
                            flameCharm = blazeCoin4.get().stack();
                        }
                        else if (magmaCubeCoin1.isPresent()) {
                            flameCharm = magmaCubeCoin1.get().stack();
                        }
                        else if (magmaCubeCoin2.isPresent()) {
                            flameCharm = magmaCubeCoin2.get().stack();
                        }
                        else if (magmaCubeCoin3.isPresent()) {
                            flameCharm = magmaCubeCoin3.get().stack();
                        }
                        else if (magmaCubeCoin4.isPresent()) {
                            flameCharm = magmaCubeCoin4.get().stack();
                        }

                        if (spiderCoin1.isPresent()) {
                            slownessCharm = spiderCoin1.get().stack();
                        }
                        else if (spiderCoin2.isPresent()) {
                            slownessCharm = spiderCoin2.get().stack();
                        }
                        else if (spiderCoin3.isPresent()) {
                            slownessCharm = spiderCoin3.get().stack();
                        }
                        else if (spiderCoin4.isPresent()) {
                            slownessCharm = spiderCoin4.get().stack();
                        }
                        else if (strayCoin1.isPresent()) {
                            slownessCharm = strayCoin1.get().stack();
                        }
                        else if (strayCoin2.isPresent()) {
                            slownessCharm = strayCoin2.get().stack();
                        }
                        else if (strayCoin3.isPresent()) {
                            slownessCharm = strayCoin3.get().stack();
                        }
                        else if (strayCoin4.isPresent()) {
                            slownessCharm = strayCoin4.get().stack();
                        }
                        else if (iceologerCoin1.isPresent()) {
                            slownessCharm = iceologerCoin1.get().stack();
                        }
                        else if (iceologerCoin2.isPresent()) {
                            slownessCharm = iceologerCoin2.get().stack();
                        }
                        else if (iceologerCoin3.isPresent()) {
                            slownessCharm = iceologerCoin3.get().stack();
                        }
                        else if (iceologerCoin4.isPresent()) {
                            slownessCharm = iceologerCoin4.get().stack();
                        }

                        if (drownedCoin1.isPresent()) {
                            smiteCharm = drownedCoin1.get().stack();
                        }
                        else if (drownedCoin2.isPresent()) {
                            smiteCharm = drownedCoin2.get().stack();
                        }
                        else if (drownedCoin3.isPresent()) {
                            smiteCharm = drownedCoin3.get().stack();
                        }
                        else if (drownedCoin4.isPresent()) {
                            smiteCharm = drownedCoin4.get().stack();
                        }
                        else if (giantCoin1.isPresent()) {
                            smiteCharm = giantCoin1.get().stack();
                        }
                        else if (giantCoin2.isPresent()) {
                            smiteCharm = giantCoin2.get().stack();
                        }
                        else if (giantCoin3.isPresent()) {
                            smiteCharm = giantCoin3.get().stack();
                        }
                        else if (giantCoin4.isPresent()) {
                            smiteCharm = giantCoin4.get().stack();
                        }
                        else if (huskCoin1.isPresent()) {
                            smiteCharm = huskCoin1.get().stack();
                        }
                        else if (huskCoin2.isPresent()) {
                            smiteCharm = huskCoin2.get().stack();
                        }
                        else if (huskCoin3.isPresent()) {
                            smiteCharm = huskCoin3.get().stack();
                        }
                        else if (huskCoin4.isPresent()) {
                            smiteCharm = huskCoin4.get().stack();
                        }
                        else if (phantomCoin1.isPresent()) {
                            smiteCharm = phantomCoin1.get().stack();
                        }
                        else if (phantomCoin2.isPresent()) {
                            smiteCharm = phantomCoin2.get().stack();
                        }
                        else if (phantomCoin3.isPresent()) {
                            smiteCharm = phantomCoin3.get().stack();
                        }
                        else if (phantomCoin4.isPresent()) {
                            smiteCharm = phantomCoin4.get().stack();
                        }
                        else if (skeletonCoin1.isPresent()) {
                            smiteCharm = skeletonCoin1.get().stack();
                        }
                        else if (skeletonCoin2.isPresent()) {
                            smiteCharm = skeletonCoin2.get().stack();
                        }
                        else if (skeletonCoin3.isPresent()) {
                            smiteCharm = skeletonCoin3.get().stack();
                        }
                        else if (skeletonCoin4.isPresent()) {
                            smiteCharm = skeletonCoin4.get().stack();
                        }
                        else if (strayCoin1.isPresent()) {
                            smiteCharm = strayCoin1.get().stack();
                        }
                        else if (strayCoin2.isPresent()) {
                            smiteCharm = strayCoin2.get().stack();
                        }
                        else if (strayCoin3.isPresent()) {
                            smiteCharm = strayCoin3.get().stack();
                        }
                        else if (strayCoin4.isPresent()) {
                            smiteCharm = strayCoin4.get().stack();
                        }
                        else if (witherSkeletonCoin1.isPresent()) {
                            smiteCharm = witherSkeletonCoin1.get().stack();
                        }
                        else if (witherSkeletonCoin2.isPresent()) {
                            smiteCharm = witherSkeletonCoin2.get().stack();
                        }
                        else if (witherSkeletonCoin3.isPresent()) {
                            smiteCharm = witherSkeletonCoin3.get().stack();
                        }
                        else if (witherSkeletonCoin4.isPresent()) {
                            smiteCharm = witherSkeletonCoin4.get().stack();
                        }
                        else if (witherCoin1.isPresent()) {
                            smiteCharm = witherCoin1.get().stack();
                        }
                        else if (witherCoin2.isPresent()) {
                            smiteCharm = witherCoin2.get().stack();
                        }
                        else if (witherCoin3.isPresent()) {
                            smiteCharm = witherCoin3.get().stack();
                        }
                        else if (witherCoin4.isPresent()) {
                            smiteCharm = witherCoin4.get().stack();
                        }
                        else if (zombieCoin1.isPresent()) {
                            smiteCharm = zombieCoin1.get().stack();
                        }
                        else if (zombieCoin2.isPresent()) {
                            smiteCharm = zombieCoin2.get().stack();
                        }
                        else if (zombieCoin3.isPresent()) {
                            smiteCharm = zombieCoin3.get().stack();
                        }
                        else if (zombieCoin4.isPresent()) {
                            smiteCharm = zombieCoin4.get().stack();
                        }
                        else if (zombieHorseCoin1.isPresent()) {
                            smiteCharm = zombieHorseCoin1.get().stack();
                        }
                        else if (zombieHorseCoin2.isPresent()) {
                            smiteCharm = zombieHorseCoin2.get().stack();
                        }
                        else if (zombieHorseCoin3.isPresent()) {
                            smiteCharm = zombieHorseCoin3.get().stack();
                        }
                        else if (zombieHorseCoin4.isPresent()) {
                            smiteCharm = zombieHorseCoin4.get().stack();
                        }
                        else if (zombieVillagerCoin1.isPresent()) {
                            smiteCharm = zombieVillagerCoin1.get().stack();
                        }
                        else if (zombieVillagerCoin2.isPresent()) {
                            smiteCharm = zombieVillagerCoin2.get().stack();
                        }
                        else if (zombieVillagerCoin3.isPresent()) {
                            smiteCharm = zombieVillagerCoin3.get().stack();
                        }
                        else if (zombieVillagerCoin4.isPresent()) {
                            smiteCharm = zombieVillagerCoin4.get().stack();
                        }
                        else if (zombiePiglinCoin1.isPresent()) {
                            smiteCharm = zombiePiglinCoin1.get().stack();
                        }
                        else if (zombiePiglinCoin2.isPresent()) {
                            smiteCharm = zombiePiglinCoin2.get().stack();
                        }
                        else if (zombiePiglinCoin3.isPresent()) {
                            smiteCharm = zombiePiglinCoin3.get().stack();
                        }
                        else if (zombiePiglinCoin4.isPresent()) {
                            smiteCharm = zombiePiglinCoin4.get().stack();
                        }
                        else if (zoglinCoin1.isPresent()) {
                            smiteCharm = zoglinCoin1.get().stack();
                        }
                        else if (zoglinCoin2.isPresent()) {
                            smiteCharm = zoglinCoin2.get().stack();
                        }
                        else if (zoglinCoin3.isPresent()) {
                            smiteCharm = zoglinCoin3.get().stack();
                        }
                        else if (zoglinCoin4.isPresent()) {
                            smiteCharm = zoglinCoin4.get().stack();
                        }

                        if (illusionerCoin1.isPresent()) {
                            illagerCharm = illusionerCoin1.get().stack();
                        }
                        else if (illusionerCoin2.isPresent()) {
                            illagerCharm = illusionerCoin2.get().stack();
                        }
                        else if (illusionerCoin3.isPresent()) {
                            illagerCharm = illusionerCoin3.get().stack();
                        }
                        else if (illusionerCoin4.isPresent()) {
                            illagerCharm = illusionerCoin4.get().stack();
                        }
                        else if (iceologerCoin1.isPresent()) {
                            illagerCharm = iceologerCoin1.get().stack();
                        }
                        else if (iceologerCoin2.isPresent()) {
                            illagerCharm = iceologerCoin2.get().stack();
                        }
                        else if (iceologerCoin3.isPresent()) {
                            illagerCharm = iceologerCoin3.get().stack();
                        }
                        else if (iceologerCoin4.isPresent()) {
                            illagerCharm = iceologerCoin4.get().stack();
                        }
                        else if (ravagerCoin1.isPresent()) {
                            illagerCharm = ravagerCoin1.get().stack();
                        }
                        else if (ravagerCoin2.isPresent()) {
                            illagerCharm = ravagerCoin2.get().stack();
                        }
                        else if (ravagerCoin3.isPresent()) {
                            illagerCharm = ravagerCoin3.get().stack();
                        }
                        else if (ravagerCoin4.isPresent()) {
                            illagerCharm = ravagerCoin4.get().stack();
                        }
                        else if (evokerCoin1.isPresent()) {
                            illagerCharm = evokerCoin1.get().stack();
                        }
                        else if (evokerCoin2.isPresent()) {
                            illagerCharm = evokerCoin2.get().stack();
                        }
                        else if (evokerCoin3.isPresent()) {
                            illagerCharm = evokerCoin3.get().stack();
                        }
                        else if (evokerCoin4.isPresent()) {
                            illagerCharm = evokerCoin4.get().stack();
                        }
                        else if (witchCoin1.isPresent()) {
                            illagerCharm = witchCoin1.get().stack();
                        }
                        else if (witchCoin2.isPresent()) {
                            illagerCharm = witchCoin2.get().stack();
                        }
                        else if (witchCoin3.isPresent()) {
                            illagerCharm = witchCoin3.get().stack();
                        }
                        else if (witchCoin4.isPresent()) {
                            illagerCharm = witchCoin4.get().stack();
                        }
                        else if (pillagerCoin1.isPresent()) {
                            illagerCharm = pillagerCoin1.get().stack();
                        }
                        else if (pillagerCoin2.isPresent()) {
                            illagerCharm = pillagerCoin2.get().stack();
                        }
                        else if (pillagerCoin3.isPresent()) {
                            illagerCharm = pillagerCoin3.get().stack();
                        }
                        else if (pillagerCoin4.isPresent()) {
                            illagerCharm = pillagerCoin4.get().stack();
                        }
                        else if (vexCoin1.isPresent()) {
                            illagerCharm = vexCoin1.get().stack();
                        }
                        else if (vexCoin2.isPresent()) {
                            illagerCharm = vexCoin2.get().stack();
                        }
                        else if (vexCoin3.isPresent()) {
                            illagerCharm = vexCoin3.get().stack();
                        }
                        else if (vexCoin4.isPresent()) {
                            illagerCharm = vexCoin4.get().stack();
                        }

                        if (beeCoin1.isPresent()) {
                            arthropodCharm = beeCoin1.get().stack();
                        }
                        else if (beeCoin2.isPresent()) {
                            arthropodCharm = beeCoin2.get().stack();
                        }
                        else if (beeCoin3.isPresent()) {
                            arthropodCharm = beeCoin3.get().stack();
                        }
                        else if (beeCoin4.isPresent()) {
                            arthropodCharm = beeCoin4.get().stack();
                        }
                        else if (caveSpiderCoin1.isPresent()) {
                            arthropodCharm = caveSpiderCoin1.get().stack();
                        }
                        else if (caveSpiderCoin2.isPresent()) {
                            arthropodCharm = caveSpiderCoin2.get().stack();
                        }
                        else if (caveSpiderCoin3.isPresent()) {
                            arthropodCharm = caveSpiderCoin3.get().stack();
                        }
                        else if (caveSpiderCoin4.isPresent()) {
                            arthropodCharm = caveSpiderCoin4.get().stack();
                        }
                        else if (silverfishCoin1.isPresent()) {
                            arthropodCharm = silverfishCoin1.get().stack();
                        }
                        else if (silverfishCoin2.isPresent()) {
                            arthropodCharm = silverfishCoin2.get().stack();
                        }
                        else if (silverfishCoin3.isPresent()) {
                            arthropodCharm = silverfishCoin3.get().stack();
                        }
                        else if (silverfishCoin4.isPresent()) {
                            arthropodCharm = silverfishCoin4.get().stack();
                        }
                        else if (spiderCoin1.isPresent()) {
                            arthropodCharm = spiderCoin1.get().stack();
                        }
                        else if (spiderCoin2.isPresent()) {
                            arthropodCharm = spiderCoin2.get().stack();
                        }
                        else if (spiderCoin3.isPresent()) {
                            arthropodCharm = spiderCoin3.get().stack();
                        }
                        else if (spiderCoin4.isPresent()) {
                            arthropodCharm = spiderCoin4.get().stack();
                        }
                        else if (endermiteCoin1.isPresent()) {
                            arthropodCharm = endermiteCoin1.get().stack();
                        }
                        else if (endermiteCoin2.isPresent()) {
                            arthropodCharm = endermiteCoin2.get().stack();
                        }
                        else if (endermiteCoin3.isPresent()) {
                            arthropodCharm = endermiteCoin3.get().stack();
                        }
                        else if (endermiteCoin4.isPresent()) {
                            arthropodCharm = endermiteCoin4.get().stack();
                        }

                        else if (witherSkeletonCoin1.isPresent()) {
                            witheringCharm = witherSkeletonCoin1.get().stack();
                        }
                        else if (witherSkeletonCoin2.isPresent()) {
                            witheringCharm = witherSkeletonCoin2.get().stack();
                        }
                        else if (witherSkeletonCoin3.isPresent()) {
                            witheringCharm = witherSkeletonCoin3.get().stack();
                        }
                        else if (witherSkeletonCoin4.isPresent()) {
                            witheringCharm = witherSkeletonCoin4.get().stack();
                        }
                        else if (witherCoin1.isPresent()) {
                            witheringCharm = witherCoin1.get().stack();
                        }
                        else if (witherCoin2.isPresent()) {
                            witheringCharm = witherCoin2.get().stack();
                        }
                        else if (witherCoin3.isPresent()) {
                            witheringCharm = witherCoin3.get().stack();
                        }
                        else if (witherCoin4.isPresent()) {
                            witheringCharm = witherCoin4.get().stack();
                        }

                        if (poisonCharm != null && target != null) {
                            if (target instanceof LivingEntity) {
                                int i = 0;
                                int j = 0;
                                if (player.level.getDifficulty() == Difficulty.EASY) {
                                    i = 5;
                                    j = 1;
                                }
                                else if (player.level.getDifficulty() == Difficulty.NORMAL) {
                                    i = 10;
                                    j = 2;
                                }
                                else if (player.level.getDifficulty() == Difficulty.HARD) {
                                    i = 20;
                                    j = 3;
                                }

                                if (i > 0 && j > 0) {
                                    ((LivingEntity) target).addEffect(new MobEffectInstance(MobEffects.POISON, i * 20, j), target);
                                }
                            }
                        }
                        if (flameCharm != null && target != null) {
                            if (target instanceof LivingEntity) {
                                int i = 0;
                                int p = 0;

                                if (flameCharm.is(ModTags.Items.WILDFIRE_COIN_SET)) {
                                    p = 4;
                                }

                                if (player.level.getDifficulty() == Difficulty.EASY) {
                                    i = 5;
                                }
                                else if (player.level.getDifficulty() == Difficulty.NORMAL) {
                                    i = 10;
                                }
                                else if (player.level.getDifficulty() == Difficulty.HARD) {
                                    i = 20;
                                }

                                if (i > 0) {
                                    target.setSecondsOnFire((i + p) * 20);
                                }
                            }
                        }
                        if (slownessCharm != null && target != null) {
                            MobEffect slowEffect = MobEffects.MOVEMENT_SLOWDOWN;

                            if (target instanceof LivingEntity) {
                                int i = 0;
                                int j = 0;
                                if (player.level.getDifficulty() == Difficulty.EASY) {
                                    i = 5;
                                    j = 1;
                                }
                                else if (player.level.getDifficulty() == Difficulty.NORMAL) {
                                    i = 10;
                                    j = 2;
                                }
                                else if (player.level.getDifficulty() == Difficulty.HARD) {
                                    i = 20;
                                    j = 3;
                                }

                                if (i > 0 && j > 0) {
                                    ((LivingEntity) target).addEffect(new MobEffectInstance(slowEffect, i * 20, j), target);
                                }
                            }
                        }
                        if (smiteCharm != null && target != null) {
                            MobEffect slowEffect = MobEffects.MOVEMENT_SLOWDOWN;

                            if (target instanceof LivingEntity) {
                                if (((LivingEntity) target).getMobType() == MobType.UNDEAD) {
                                    int i = 0;
                                    int j = 0;
                                    if (player.level.getDifficulty() == Difficulty.EASY) {
                                        i = 5;
                                        j = 1;
                                    }
                                    else if (player.level.getDifficulty() == Difficulty.NORMAL) {
                                        i = 10;
                                        j = 2;
                                    }
                                    else if (player.level.getDifficulty() == Difficulty.HARD) {
                                        i = 20;
                                        j = 3;
                                    }

                                    if (i > 0 && j > 0) {
                                        player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, i * 20, j));
                                        ((LivingEntity) target).addEffect(new MobEffectInstance(slowEffect, i * 20, j), target);
                                    }
                                }
                            }
                        }
                        if (illagerCharm != null && target != null) {
                            if (target instanceof AbstractIllager || target instanceof Ravager) {
                                int i = 0;
                                int j = 0;
                                int p = 0;

                                if (illagerCharm.is(ModTags.Items.ILLUSIONER_COIN_SET) || illagerCharm.is(ModTags.Items.ICEOLOGER_COIN_SET)) {
                                    p = 4;
                                }
                                else if (illagerCharm.is(ModTags.Items.EVOKER_COIN_SET) || illagerCharm.is(ModTags.Items.RAVAGER_COIN_SET)) {
                                    p = 3;
                                }
                                else if (illagerCharm.is(ModTags.Items.VINDICATOR_COIN_SET) || illagerCharm.is(ModTags.Items.WITCH_COIN_SET)) {
                                    p = 2;
                                }
                                else if (illagerCharm.is(ModTags.Items.PILLAGER_COIN_SET) || illagerCharm.is(ModTags.Items.VEX_COIN_SET)) {
                                    p = 1;
                                }

                                if (player.level.getDifficulty() == Difficulty.EASY) {
                                    i = 5;
                                    j = 1;
                                }
                                else if (player.level.getDifficulty() == Difficulty.NORMAL) {
                                    i = 10;
                                    j = 2;
                                }
                                else if (player.level.getDifficulty() == Difficulty.HARD) {
                                    i = 20;
                                    j = 3;
                                }

                                if (i > 0 && j > 0) {
                                    player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, (i + p) * 20, j));
                                }
                            }
                        }
                        if (arthropodCharm != null && target != null) {
                            MobEffect slowEffect = MobEffects.MOVEMENT_SLOWDOWN;

                            if (target instanceof LivingEntity) {
                                if (((LivingEntity) target).getMobType() == MobType.ARTHROPOD) {
                                    int i = 0;
                                    int j = 0;
                                    if (player.level.getDifficulty() == Difficulty.EASY) {
                                        i = 5;
                                        j = 1;
                                    }
                                    else if (player.level.getDifficulty() == Difficulty.NORMAL) {
                                        i = 10;
                                        j = 2;
                                    }
                                    else if (player.level.getDifficulty() == Difficulty.HARD) {
                                        i = 20;
                                        j = 3;
                                    }

                                    if (i > 0 && j > 0) {
                                        player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, i * 20, j));
                                        ((LivingEntity) target).addEffect(new MobEffectInstance(slowEffect, i * 20, j), target);
                                    }
                                }
                            }
                        }
                        if (witheringCharm != null && target != null) {
                            if (target instanceof LivingEntity) {
                                int i = 0;
                                int j = 0;
                                if (player.level.getDifficulty() == Difficulty.EASY) {
                                    i = 5;
                                    j = 1;
                                }
                                else if (player.level.getDifficulty() == Difficulty.NORMAL) {
                                    i = 10;
                                    j = 2;
                                }
                                else if (player.level.getDifficulty() == Difficulty.HARD) {
                                    i = 20;
                                    j = 3;
                                }

                                if (i > 0 && j > 0) {
                                    ((LivingEntity) target).addEffect(new MobEffectInstance(MobEffects.WITHER, i * 20, j), target);
                                }
                            }
                        }
                    }
                }
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