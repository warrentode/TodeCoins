package com.github.warrentode.todecoins.event;

import com.github.warrentode.todecoins.TodeCoins;
import com.github.warrentode.todecoins.attribute.ModAttributes;
import com.github.warrentode.todecoins.attribute.PlayerCharisma;
import com.github.warrentode.todecoins.attribute.PlayerCharismaProvider;
import com.github.warrentode.todecoins.entity.ModEntityTypes;
import com.github.warrentode.todecoins.integration.Curios;
import com.github.warrentode.todecoins.item.ModItems;
import com.github.warrentode.todecoins.util.tags.ForgeTags;
import com.github.warrentode.todecoins.util.tags.ModTags;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.AbstractIllager;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

import java.util.List;

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
        public static void onPlayerSeen(LivingEvent.LivingVisibilityEvent event) {
            Player player = Minecraft.getInstance().player;
            LivingEntity lookingEntity = (LivingEntity) event.getLookingEntity();
            double d0 = event.getVisibilityModifier();

            if (lookingEntity != null && player != null) {
                ItemStack stack = Curios.getCharmSlot(player);
                EntityType<?> entitytype = lookingEntity.getType();
                if (entitytype.is(ForgeTags.EntityTypes.CREEPER_TYPES) && (stack != null && stack.is(ModTags.Items.CREEPER_COIN_SET))) {
                    event.modifyVisibility(0.25D);
                    lookingEntity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 20, 0), lookingEntity);
                }
                else if (entitytype.is(ForgeTags.EntityTypes.ZOMBIES) && (stack != null &&
                        (stack.is(ModTags.Items.DROWNED_COIN_SET) || stack.is(ModTags.Items.HUSK_COIN_SET)))) {
                    event.modifyVisibility(0.25D);
                    lookingEntity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 20, 0), lookingEntity);
                }
                else if (entitytype.is(ForgeTags.EntityTypes.ILLAGERS) &&
                        (stack != null && (stack.is(ModTags.Items.EVOKER_COIN_SET) || stack.is(ModTags.Items.PILLAGER_COIN_SET)))) {
                    event.modifyVisibility(0.25D);
                    lookingEntity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 20, 0), lookingEntity);
                }
                else if (entitytype.is(ForgeTags.EntityTypes.GHAST_TYPES) && (stack != null && stack.is(ModTags.Items.GHAST_COIN_SET))) {
                    event.modifyVisibility(0.25D);
                    lookingEntity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 20, 0), lookingEntity);
                }
            }
        }

        @SubscribeEvent
        public static void onAttachCapabilitiesPlayer(@NotNull AttachCapabilitiesEvent<Entity> event) {
            if (event.getObject() instanceof Player) {
                if (!event.getObject().getCapability(PlayerCharismaProvider.PLAYER_CHARISMA).isPresent()) {
                    event.addCapability(new ResourceLocation(TodeCoins.MODID, "player_charisma"), new PlayerCharismaProvider());
                }
            }
        }

        @SubscribeEvent
        public static void onEntityAttributeModificationEvent(final EntityAttributeModificationEvent event) {
            event.add(EntityType.PLAYER, ModAttributes.CHARISMA.get());
        }

        @SubscribeEvent
        public static void onPlayerCloned(PlayerEvent.@NotNull Clone event) {
            if (event.isWasDeath()) {
                event.getOriginal().getCapability(PlayerCharismaProvider.PLAYER_CHARISMA)
                        .ifPresent(oldStore -> event.getOriginal().getCapability(PlayerCharismaProvider.PLAYER_CHARISMA)
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
            LivingEntity entity = event.getEntity();
            Level level = entity.getCommandSenderWorld();
            if (!level.isClientSide) {
                if (entity instanceof ServerPlayer player) {
                    Inventory playerInventory = player.getInventory();
                    DamageSource damageSource = player.getLastDamageSource();
                    ItemStack luckyCoin = null;

                    if (TodeCoins.isModLoaded("curios")) {
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

                    if (TodeCoins.isModLoaded("curios")) {
                        if (stack != null) {
                            if (stack.is(ModTags.Items.BEE_COIN_SET) || stack.is(ModTags.Items.CAVE_SPIDER_COIN_SET)) {
                                poisonCharm = stack;
                            }
                            if (stack.is(ModTags.Items.BLAZE_COIN_SET) || stack.is(ModTags.Items.MAGMA_CUBE_COIN_SET)) {
                                flameCharm = stack;
                            }
                            if (stack.is(ModTags.Items.SPIDER_COIN_SET)) {
                                slownessCharm = stack;
                            }
                            if (stack.is(ModTags.Items.PHANTOM_COIN_SET)) {
                                smiteCharm = stack;
                            }
                            if (stack.is(ModTags.Items.EVOKER_COIN_SET) || stack.is(ModTags.Items.PILLAGER_COIN_SET)) {
                                illagerCharm = stack;
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
                                    target.setSecondsOnFire(i * 20);
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

                                // illusioner = 5
                                // iceologer = 4
                                // vindicator = 2
                                if (illagerCharm.is(ModTags.Items.EVOKER_COIN_SET)) {
                                    p = 3;
                                }
                                else if (illagerCharm.is(ModTags.Items.PILLAGER_COIN_SET)) {
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
                    }
                }
            }
            return false;
        }
    }
}