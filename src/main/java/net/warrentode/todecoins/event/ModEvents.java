package net.warrentode.todecoins.event;

import net.minecraft.client.Minecraft;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.EntityDamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.ThornsEnchantment;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.warrentode.todecoins.TodeCoins;
import net.warrentode.todecoins.attribute.ModAttributes;
import net.warrentode.todecoins.attribute.PlayerCharisma;
import net.warrentode.todecoins.attribute.PlayerCharismaProvider;
import net.warrentode.todecoins.entity.ModEntityTypes;
import net.warrentode.todecoins.integration.Curios;
import net.warrentode.todecoins.item.ModItems;
import net.warrentode.todecoins.util.tags.ForgeTags;
import net.warrentode.todecoins.util.tags.ModTags;
import org.jetbrains.annotations.NotNull;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotResult;

import java.util.Optional;

import static net.warrentode.todecoins.TodeCoins.MODID;

public class ModEvents {
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEventBusEvents {
        @SubscribeEvent
        public static void onEntityAttributeEvent(@NotNull EntityAttributeCreationEvent event) {
            event.put(ModEntityTypes.NUMISMATIST.get(), Mob.createMobAttributes().build());
        }
    }

    @Mod.EventBusSubscriber(modid = MODID)
    public static class ForgeEvents {
        @SubscribeEvent
        public static void onItemCrafted(PlayerEvent.ItemCraftedEvent event) {
            ItemStack stack = event.getCrafting();
            if (stack.is(ModTags.Items.NO_AI_EGGS)) {
                final CompoundTag entityTag = stack.getOrCreateTagElement("EntityTag");
                entityTag.putBoolean("NoAI", true);
            }
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
                    event.modifyVisibility(0.5D);
                    lookingEntity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 200, 0), lookingEntity);
                }
                else if (entitytype.is(ForgeTags.EntityTypes.DROWNED_TYPES) && (stack != null && stack.is(ModTags.Items.DROWNED_COIN_SET))) {
                    event.modifyVisibility(0.5D);
                    lookingEntity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 200, 0), lookingEntity);
                }
                else if (entitytype.is(ForgeTags.EntityTypes.EVOKER_TYPES) && (stack != null && stack.is(ModTags.Items.EVOKER_COIN_SET))) {
                    event.modifyVisibility(0.5D);
                    lookingEntity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 200, 0), lookingEntity);
                }
            }
        }

        @SubscribeEvent
        public static void onAttachCapabilitiesPlayer(@NotNull AttachCapabilitiesEvent<Entity> event) {
            if (event.getObject() instanceof Player) {
                if (!event.getObject().getCapability(PlayerCharismaProvider.PLAYER_CHARISMA).isPresent()) {
                    event.addCapability(new ResourceLocation(MODID, "player_charisma"), new PlayerCharismaProvider());
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

                    if (TodeCoins.isCuriosLoaded()) {
                        Optional<SlotResult> optional = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.LUCKY_COIN.get());
                        if (optional.isPresent()) {
                            luckyCoin = optional.get().stack();
                        }
                        else {
                            for (int i = 0; i < playerInventory.getContainerSize(); ++i) {
                                ItemStack stack = playerInventory.getItem(i);
                                if (stack.getItem().equals(ModItems.LUCKY_COIN.get())) {
                                    luckyCoin = stack;
                                    break;
                                }
                            }
                        }
                    }
                    else {
                        for (int i = 0; i < playerInventory.getContainerSize(); ++i) {
                            ItemStack stack = playerInventory.getItem(i);
                            if (stack.getItem().equals(ModItems.LUCKY_COIN.get())) {
                                luckyCoin = stack;
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

                    if (TodeCoins.isCuriosLoaded()) {
                        Optional<SlotResult> poisonOption1 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.COPPER_BEE_COIN.get());
                        Optional<SlotResult> poisonOption2 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.IRON_BEE_COIN.get());
                        Optional<SlotResult> poisonOption3 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.GOLD_BEE_COIN.get());
                        Optional<SlotResult> poisonOption4 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.NETHERITE_BEE_COIN.get());
                        Optional<SlotResult> poisonOption5 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.COPPER_CAVE_SPIDER_COIN.get());
                        Optional<SlotResult> poisonOption6 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.IRON_CAVE_SPIDER_COIN.get());
                        Optional<SlotResult> poisonOption7 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.GOLD_CAVE_SPIDER_COIN.get());
                        Optional<SlotResult> poisonOption8 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.NETHERITE_CAVE_SPIDER_COIN.get());

                        if (poisonOption1.isPresent()) {
                            poisonCharm = poisonOption1.get().stack();
                        }
                        else if (poisonOption2.isPresent()) {
                            poisonCharm = poisonOption2.get().stack();
                        }
                        else if (poisonOption3.isPresent()) {
                            poisonCharm = poisonOption3.get().stack();
                        }
                        else if (poisonOption4.isPresent()) {
                            poisonCharm = poisonOption4.get().stack();
                        }
                        else if (poisonOption5.isPresent()) {
                            poisonCharm = poisonOption5.get().stack();
                        }
                        else if (poisonOption6.isPresent()) {
                            poisonCharm = poisonOption6.get().stack();
                        }
                        else if (poisonOption7.isPresent()) {
                            poisonCharm = poisonOption7.get().stack();
                        }
                        else if (poisonOption8.isPresent()) {
                            poisonCharm = poisonOption8.get().stack();
                        }

                        if (poisonCharm != null && target != null) {
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
                                    ((LivingEntity) target).addEffect(new MobEffectInstance(MobEffects.POISON, i * 20, 0), target);
                                }
                            }
                        }


                        Optional<SlotResult> flameOption1 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.COPPER_BLAZE_COIN.get());
                        Optional<SlotResult> flameOption2 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.IRON_BLAZE_COIN.get());
                        Optional<SlotResult> flameOption3 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.GOLD_BLAZE_COIN.get());
                        Optional<SlotResult> flameOption4 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.NETHERITE_BLAZE_COIN.get());

                        if (flameOption1.isPresent()) {
                            flameCharm = flameOption1.get().stack();
                        }
                        else if (flameOption2.isPresent()) {
                            flameCharm = flameOption2.get().stack();
                        }
                        else if (flameOption3.isPresent()) {
                            flameCharm = flameOption3.get().stack();
                        }
                        else if (flameOption4.isPresent()) {
                            flameCharm = flameOption4.get().stack();
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
                    }


                    Optional<SlotResult> slownessOption1 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.COPPER_SPIDER_COIN.get());
                    Optional<SlotResult> slownessOption2 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.IRON_SPIDER_COIN.get());
                    Optional<SlotResult> slownessOption3 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.GOLD_SPIDER_COIN.get());
                    Optional<SlotResult> slownessOption4 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.NETHERITE_SPIDER_COIN.get());

                    MobEffect effect = MobEffects.MOVEMENT_SLOWDOWN;

                    if (slownessOption1.isPresent()) {
                        slownessCharm = slownessOption1.get().stack();
                    }
                    else if (slownessOption2.isPresent()) {
                        slownessCharm = slownessOption2.get().stack();
                    }
                    else if (slownessOption3.isPresent()) {
                        slownessCharm = slownessOption3.get().stack();
                    }
                    else if (slownessOption4.isPresent()) {
                        slownessCharm = slownessOption4.get().stack();
                    }

                    if (slownessCharm != null && target != null) {
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
                                if (i > 0) {
                                    ((LivingEntity) target).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, i * 20, 0), target);
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
        public boolean onLivingHurt(LivingHurtEvent event) {
            LivingEntity entity = event.getEntity();
            LivingEntity attacker = event.getEntity();
            DamageSource source = entity.getLastDamageSource();
            Level level = entity.getCommandSenderWorld();
            ItemStack stack = ItemStack.EMPTY;

            if (!level.isClientSide) {
                if (entity instanceof ServerPlayer player && source instanceof EntityDamageSource) {
                    Curios.getCharmSlot(player);
                    if (stack.is(ModTags.Items.EVOKER_COIN_SET)) {
                        @SuppressWarnings("DataFlowIssue")
                        ThornsEnchantment thornsEnchantment = (ThornsEnchantment) (Object) this;

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

                        thornsEnchantment.doPostHurt(player, attacker, i);
                    }
                }
            }
            return false;
        }
    }
}