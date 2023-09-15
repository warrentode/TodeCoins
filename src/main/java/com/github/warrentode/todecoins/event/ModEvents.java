package com.github.warrentode.todecoins.event;

import com.github.warrentode.todecoins.TodeCoins;
import com.github.warrentode.todecoins.attribute.*;
import com.github.warrentode.todecoins.entity.ModEntityTypes;
import com.github.warrentode.todecoins.entity.ai.goal.AvoidPlayerCatCoinGoal;
import com.github.warrentode.todecoins.entity.spawners.numismatist.NumismatistSpawner;
import com.github.warrentode.todecoins.integration.Curios;
import com.github.warrentode.todecoins.item.ModItems;
import com.github.warrentode.todecoins.item.custom.collectiblecoins.entity.ArthropodCoinItem;
import com.github.warrentode.todecoins.item.custom.collectiblecoins.entity.IllagerCoinItem;
import com.github.warrentode.todecoins.item.custom.collectiblecoins.entity.UndeadCoinItem;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        public static void onItemCrafted(PlayerEvent.ItemCraftedEvent event) {
            ItemStack stack = event.getCrafting();
            Player player = event.getEntity();
            if (stack.is(ModTags.Items.NO_AI_EGGS)) {
                final CompoundTag entityTag = stack.getOrCreateTagElement("EntityTag");
                entityTag.putBoolean("NoAI", true);
            }
        }

        @SubscribeEvent
        public static ItemTooltipEvent onItemTooltip(ItemTooltipEvent event) {
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
        public static void onEntityAttributeModificationEvent(final EntityAttributeModificationEvent event) {
            event.add(EntityType.PLAYER, ModAttributes.CHARISMA.get());
            event.add(EntityType.PLAYER, ModAttributes.COD_BONUS.get());
            event.add(EntityType.PLAYER, ModAttributes.PUFFERFISH_BONUS.get());
            event.add(EntityType.PLAYER, ModAttributes.SALMON_BONUS.get());
            event.add(EntityType.PLAYER, ModAttributes.TROPICAL_FISH_BONUS.get());
        }

        @SubscribeEvent
        public static void onPlayerCloned(PlayerEvent.@NotNull Clone event) {
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
                        ItemStack stack = Curios.getCharmSlot(player);
                        if (stack != null && stack.getItem().equals(ModItems.LUCKY_COIN.get())) {
                            luckyCoin = stack;
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
                    ItemStack stack = Curios.getCharmSlot(player);
                    ItemStack poisonCharm = null;
                    ItemStack flameCharm = null;
                    ItemStack slownessCharm = null;
                    ItemStack smiteCharm = null;
                    ItemStack illagerCharm = null;
                    ItemStack arthropodCharm = null;
                    ItemStack witheringCharm = null;

                    if (ModList.get().isLoaded("curios")) {
                        if (stack != null) {
                            if (stack.is(ModTags.Items.BEE_COIN_SET) || stack.is(ModTags.Items.CAVE_SPIDER_COIN_SET)
                                    || stack.is(ModTags.Items.WITCH_COIN_SET)) {
                                poisonCharm = stack;
                            }
                            if (stack.is(ModTags.Items.BLAZE_COIN_SET) || stack.is(ModTags.Items.MAGMA_CUBE_COIN_SET)
                                    || stack.is(ModTags.Items.MAGMA_CUBE_COIN_SET)) {
                                flameCharm = stack;
                            }
                            if (stack.is(ModTags.Items.SPIDER_COIN_SET) || stack.is(ModTags.Items.STRAY_COIN_SET)
                                    || stack.is(ModTags.Items.ICEOLOGER_COIN_SET)) {
                                slownessCharm = stack;
                            }
                            if (stack.getItem() instanceof UndeadCoinItem || stack.is(ModTags.Items.ZOMBIFIED_PIGLIN_COIN_SET)
                                    || stack.is(ModTags.Items.ZOMBIE_HORSE_COIN_SET) || stack.is(ModTags.Items.ZOGLIN_COIN_SET)) {
                                smiteCharm = stack;
                            }
                            if (stack.getItem() instanceof IllagerCoinItem || stack.is(ModTags.Items.WITCH_COIN_SET)
                                    || stack.is(ModTags.Items.RAVAGER_COIN_SET) || stack.is(ModTags.Items.VEX_COIN_SET)) {
                                illagerCharm = stack;
                            }
                            if (stack.getItem() instanceof ArthropodCoinItem) {
                                arthropodCharm = stack;
                            }
                            if (stack.is(ModTags.Items.WITHER_SKELETON_COIN_SET) || stack.is(ModTags.Items.WITHER_COIN_SET)) {
                                witheringCharm = stack;
                            }
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

                                if (stack.is(ModTags.Items.WILDFIRE_COIN_SET)) {
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
                            if (target instanceof AbstractIllager) {
                                int i = 0;
                                int j = 0;
                                int p = 0;

                                if (illagerCharm.is(ModTags.Items.ILLUSIONER_COIN_SET) || stack.is(ModTags.Items.ICEOLOGER_COIN_SET)) {
                                    p = 4;
                                }
                                else if (illagerCharm.is(ModTags.Items.EVOKER_COIN_SET) || stack.is(ModTags.Items.RAVAGER_COIN_SET)) {
                                    p = 3;
                                }
                                else if (illagerCharm.is(ModTags.Items.VINDICATOR_COIN_SET) || stack.is(ModTags.Items.WITCH_COIN_SET)) {
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
                    ItemStack stack = Curios.getCharmSlot(player);
                    if (stack.is(ModTags.Items.CAT_COIN_SET) || stack.is(ModTags.Items.OCELOT_COIN_SET)) {
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
        public static void onWorldTick(TickEvent.@NotNull LevelTickEvent event) {
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