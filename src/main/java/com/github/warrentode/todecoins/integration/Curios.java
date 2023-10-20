package com.github.warrentode.todecoins.integration;

import com.github.warrentode.todecoins.TodeCoins;
import com.github.warrentode.todecoins.attribute.*;
import com.github.warrentode.todecoins.item.custom.collectiblecoins.entity.FelineCoinItem;
import com.github.warrentode.todecoins.util.CalendarUtil;
import com.github.warrentode.todecoins.util.tags.ModTags;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fml.ModList;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.SlotTypePreset;
import top.theillusivec4.curios.api.type.capability.ICurio;
import top.theillusivec4.curios.api.type.capability.ICuriosItemHandler;
import top.theillusivec4.curios.api.type.inventory.ICurioStacksHandler;
import top.theillusivec4.curios.common.capability.CurioItemCapability;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

public class Curios {
    // TODO is there a better, more streamlined way to organize all this? does each effect really need a separate method
    // or can that be managed with if-else checks within just a couple of methods?
    // TODO learn how custom enchantments work and how enchantments apply to Curio items in order to expand the variety
    // of equipped effects of these coins since it feels very repetitive to me right now
    // TODO since the coins do not stack in inventory, I may need to make them breakable and repairable in some fashion to reduce clutter
    // [LittleBear suggestions:]
    // TODO look into how bone meal works and how that can be altered for the bee coin
    // TODO look into adding Loyalty effect for the Drowned coin
    // TODO look into adding Frost Walker effect for Iceologer, Stray, Snow Golem coins
    // TODO can the splash potion radius be changed for the Witch coin?
    // TODO the Sniffer coin influence what you find while digging?
    // [ScholarOwl suggestions:]
    // TODO look into giving Elder Guardian coin Depth Strider and Thorns
    // TODO look into increase buff duration for Witch coin
    // TODO look into giving immunity to poison for Cave Spider

    /**
     * Gets the stack in the Belt Slot
     **/
    public static ItemStack getBeltSlot(Player player) {
        AtomicReference<ItemStack> belt = new AtomicReference<>(ItemStack.EMPTY);
        LazyOptional<ICuriosItemHandler> optional = CuriosApi.getCuriosHelper().getCuriosHandler(player);
        optional.ifPresent(itemHandler -> {
            Optional<ICurioStacksHandler> stacksOptional = itemHandler.getStacksHandler(SlotTypePreset.BELT.getIdentifier());
            stacksOptional.ifPresent(stacksHandler -> {
                ItemStack stack = stacksHandler.getStacks().getStackInSlot(0);
                if (!stack.isEmpty()) {
                    belt.set(stack);
                }
            });
        });
        return belt.get();
    }

    public static ICapabilityProvider createBeltSlotProvider(ItemStack stack) {
        return CurioItemCapability.createProvider(new ICurio() {
            @Override
            public ItemStack getStack() {
                return stack;
            }

            @Nonnull
            @Override
            public SoundInfo getEquipSound(SlotContext context) {
                return new SoundInfo(SoundEvents.ARMOR_EQUIP_GENERIC, 1.0F, 1.5F);
            }

            @Override
            public boolean canEquipFromUse(SlotContext context) {
                return true;
            }

            @Nonnull
            @Override
            public DropRule getDropRule(SlotContext context, DamageSource source, int lootingLevel, boolean recentlyHit) {
                return DropRule.DEFAULT;
            }
        });
    }

    public static ICapabilityProvider createLuckyCoinCharmProvider(ItemStack stack) {
        return CurioItemCapability.createProvider(new ICurio() {
            @Override
            public ItemStack getStack() {
                return stack;
            }

            @Override
            public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid) {
                Multimap<Attribute, AttributeModifier> attribute = LinkedHashMultimap.create();
                attribute.put(Attributes.LUCK,
                        new AttributeModifier(uuid, TodeCoins.MODID + ":luck_bonus", 1,
                                AttributeModifier.Operation.ADDITION));
                return attribute;
            }

            @Override
            public int getFortuneLevel(SlotContext slotContext, @Nullable LootContext lootContext) {
                return 1;
            }

            @Override
            public int getLootingLevel(SlotContext slotContext, DamageSource source, LivingEntity target, int baseLooting) {
                return 1;
            }

            @Nonnull
            @Override
            public SoundInfo getEquipSound(SlotContext context) {
                return new SoundInfo(SoundEvents.CHAIN_STEP, 1.0F, 1.5F);
            }

            @Override
            public boolean canEquipFromUse(SlotContext context) {
                return true;
            }

            @Override
            public boolean canSync(SlotContext context) {
                return true;
            }

            @Nonnull
            @Override
            public DropRule getDropRule(SlotContext context, DamageSource source, int lootingLevel, boolean recentlyHit) {
                return DropRule.DEFAULT;
            }
        });
    }

    public static ICapabilityProvider createCHRCharmProvider(ItemStack stack) {
        return CurioItemCapability.createProvider(new ICurio() {
            @Override
            public ItemStack getStack() {
                return stack;
            }

            @Override
            public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid) {
                Multimap<Attribute, AttributeModifier> attribute = LinkedHashMultimap.create();
                if (stack.is(ModTags.Items.HERO_COIN_SET)) {
                    attribute.put(ModAttributes.CHARISMA.get(),
                            new AttributeModifier(ModAttributes.CHR_MODIFIER_UUID, ModAttributes.CHR_MODIFIER_NAME, 4,
                                    AttributeModifier.Operation.ADDITION));
                    return attribute;
                }
                else if (stack.is(ModTags.Items.GUARD_COIN_SET)) {
                    attribute.put(ModAttributes.CHARISMA.get(),
                            new AttributeModifier(ModAttributes.CHR_MODIFIER_UUID, ModAttributes.CHR_MODIFIER_NAME, 1,
                                    AttributeModifier.Operation.ADDITION));
                    return attribute;
                }
                else if (stack.is(ModTags.Items.PATRON_COIN_SET)) {
                    attribute.put(ModAttributes.CHARISMA.get(),
                            new AttributeModifier(ModAttributes.CHR_MODIFIER_UUID, ModAttributes.CHR_MODIFIER_NAME, 8,
                                    AttributeModifier.Operation.ADDITION));
                    return attribute;
                }
                return attribute;
            }

            @Nonnull
            @Override
            public SoundInfo getEquipSound(SlotContext context) {
                return new SoundInfo(SoundEvents.CHAIN_STEP, 1.0F, 2.0F);
            }

            @Override
            public void onEquip(SlotContext slotContext, ItemStack prevStack) {
                ICurio.super.onEquip(slotContext, prevStack);
                if (stack.is(ModTags.Items.HERO_COIN_SET)) {
                    PlayerCharisma.addCharisma(4);
                }
                else if (stack.is(ModTags.Items.PATRON_COIN_SET)) {
                    PlayerCharisma.addCharisma(8);
                }
                else if (stack.is(ModTags.Items.GUARD_COIN_SET)) {
                    PlayerCharisma.addCharisma(1);
                }
            }

            @Override
            public void onUnequip(SlotContext slotContext, ItemStack prevStack) {
                ICurio.super.onUnequip(slotContext, prevStack);
                if (stack.is(ModTags.Items.HERO_COIN_SET)) {
                    PlayerCharisma.subtractCharisma(4);
                }
                else if (stack.is(ModTags.Items.PATRON_COIN_SET)) {
                    PlayerCharisma.subtractCharisma(8);
                }
                else if (stack.is(ModTags.Items.GUARD_COIN_SET)) {
                    PlayerCharisma.subtractCharisma(1);
                }
            }

            @Override
            public boolean canEquipFromUse(SlotContext context) {
                return true;
            }

            @Override
            public boolean canSync(SlotContext context) {
                return true;
            }

            @Nonnull
            @Override
            public DropRule getDropRule(SlotContext context, DamageSource source, int lootingLevel, boolean recentlyHit) {
                return DropRule.DEFAULT;
            }
        });
    }

    public static ICapabilityProvider createPiglinCoinCharmProvider(ItemStack stack) {
        return CurioItemCapability.createProvider(new ICurio() {
            @Override
            public ItemStack getStack() {
                return stack;
            }

            @Override
            public boolean makesPiglinsNeutral(SlotContext slotContext) {
                return true;
            }

            @Override
            public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid) {
                Multimap<Attribute, AttributeModifier> attribute = LinkedHashMultimap.create();
                LivingEntity livingEntity = slotContext.entity();
                if (livingEntity != null && (stack.is(ModTags.Items.PIGLIN_COIN_SET)
                        || stack.is(ModTags.Items.PIGLIN_BRUTE_COIN_SET)
                        || stack.is(ModTags.Items.GUARD_COIN_SET)
                )) {

                    int i = 0;
                    if (livingEntity.level.getDifficulty() == Difficulty.EASY) {
                        i = 1;
                    }
                    else if (livingEntity.level.getDifficulty() == Difficulty.NORMAL) {
                        i = 2;
                    }
                    else if (livingEntity.level.getDifficulty() == Difficulty.HARD) {
                        i = 3;
                    }
                    attribute.put(Attributes.ARMOR,
                            new AttributeModifier(uuid, "generic.armor", 1 + i,
                                    AttributeModifier.Operation.ADDITION));
                }

                return attribute;
            }

            @Nonnull
            @Override
            public SoundInfo getEquipSound(SlotContext context) {
                return new SoundInfo(SoundEvents.CHAIN_STEP, 1.0F, 2.0F);
            }

            @Override
            public boolean canEquipFromUse(SlotContext context) {
                return true;
            }

            @Override
            public boolean canSync(SlotContext context) {
                return true;
            }

            @Nonnull
            @Override
            public DropRule getDropRule(SlotContext context, DamageSource source, int lootingLevel, boolean recentlyHit) {
                return DropRule.DEFAULT;
            }
        });
    }

    public static ICapabilityProvider createEndermanCoinCharmProvider(ItemStack stack) {
        return CurioItemCapability.createProvider(new ICurio() {
            @Override
            public ItemStack getStack() {
                return stack;
            }

            @Override
            public boolean isEnderMask(SlotContext slotContext, EnderMan enderMan) {
                return true;
            }

            @Override
            public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid) {
                Multimap<Attribute, AttributeModifier> attribute = LinkedHashMultimap.create();
                LivingEntity livingEntity = slotContext.entity();
                if (livingEntity != null) {

                    double d = 0;
                    if (livingEntity.level.getDifficulty() == Difficulty.EASY) {
                        d = 0.01;
                    }
                    else if (livingEntity.level.getDifficulty() == Difficulty.NORMAL) {
                        d = 0.02;
                    }
                    else if (livingEntity.level.getDifficulty() == Difficulty.HARD) {
                        d = 0.03;
                    }
                    attribute.put(Attributes.MOVEMENT_SPEED,
                            new AttributeModifier(uuid, "generic.movement_speed", 0.05 + d,
                                    AttributeModifier.Operation.ADDITION));
                }

                return attribute;
            }

            @Nonnull
            @Override
            public SoundInfo getEquipSound(SlotContext context) {
                return new SoundInfo(SoundEvents.CHAIN_STEP, 1.0F, 2.0F);
            }

            @Override
            public boolean canEquipFromUse(SlotContext context) {
                return true;
            }

            @Override
            public boolean canSync(SlotContext context) {
                return true;
            }

            @Nonnull
            @Override
            public DropRule getDropRule(SlotContext context, DamageSource source, int lootingLevel, boolean recentlyHit) {
                return DropRule.DEFAULT;
            }
        });
    }

    public static ICapabilityProvider createMaxHealthCharmProvider(ItemStack stack) {
        return CurioItemCapability.createProvider(new ICurio() {
            @Override
            public ItemStack getStack() {
                return stack;
            }

            @Override
            public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid) {
                Multimap<Attribute, AttributeModifier> attribute = LinkedHashMultimap.create();
                LivingEntity livingEntity = slotContext.entity();
                if (livingEntity != null) {

                    int i = 0;
                    if (livingEntity.level.getDifficulty() == Difficulty.EASY) {
                        i = 5;
                    }
                    else if (livingEntity.level.getDifficulty() == Difficulty.NORMAL) {
                        i = 10;
                    }
                    else if (livingEntity.level.getDifficulty() == Difficulty.HARD) {
                        i = 15;
                    }
                    attribute.put(Attributes.MAX_HEALTH,
                            new AttributeModifier(uuid, "generic.max_health", 10 + i,
                                    AttributeModifier.Operation.ADDITION));
                }

                return attribute;
            }

            @Nonnull
            @Override
            public SoundInfo getEquipSound(SlotContext context) {
                return new SoundInfo(SoundEvents.CHAIN_STEP, 1.0F, 2.0F);
            }

            @Override
            public boolean canEquipFromUse(SlotContext context) {
                return true;
            }

            @Override
            public boolean canSync(SlotContext context) {
                return true;
            }

            @Nonnull
            @Override
            public DropRule getDropRule(SlotContext context, DamageSource source, int lootingLevel, boolean recentlyHit) {
                return DropRule.DEFAULT;
            }
        });
    }

    public static ICapabilityProvider createMountMovementSpeedCharmProvider(ItemStack stack) {
        return CurioItemCapability.createProvider(new ICurio() {
            @Override
            public ItemStack getStack() {
                return stack;
            }

            @Override
            public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid) {
                Multimap<Attribute, AttributeModifier> attribute = LinkedHashMultimap.create();
                LivingEntity livingEntity = slotContext.entity();
                if (livingEntity != null) {

                    double d = 0;
                    if (livingEntity.level.getDifficulty() == Difficulty.EASY) {
                        d = 0.01;
                    }
                    else if (livingEntity.level.getDifficulty() == Difficulty.NORMAL) {
                        d = 0.02;
                    }
                    else if (livingEntity.level.getDifficulty() == Difficulty.HARD) {
                        d = 0.03;
                    }
                    attribute.put(Attributes.MOVEMENT_SPEED,
                            new AttributeModifier(uuid, "generic.movement_speed", 0.2 + d,
                                    AttributeModifier.Operation.ADDITION));
                }

                return attribute;
            }

            @Nonnull
            @Override
            public SoundInfo getEquipSound(SlotContext context) {
                return new SoundInfo(SoundEvents.CHAIN_STEP, 1.0F, 2.0F);
            }

            @Override
            public boolean canEquipFromUse(SlotContext context) {
                return true;
            }

            @Override
            public boolean canSync(SlotContext context) {
                return true;
            }

            @Nonnull
            @Override
            public DropRule getDropRule(SlotContext context, DamageSource source, int lootingLevel, boolean recentlyHit) {
                return DropRule.DEFAULT;
            }
        });
    }

    public static ICapabilityProvider createMinorMovementSpeedCharmProvider(ItemStack stack) {
        return CurioItemCapability.createProvider(new ICurio() {
            @Override
            public ItemStack getStack() {
                return stack;
            }

            @Override
            public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid) {
                Multimap<Attribute, AttributeModifier> attribute = LinkedHashMultimap.create();
                LivingEntity livingEntity = slotContext.entity();
                if (livingEntity != null) {

                    double d = 0;
                    if (livingEntity.level.getDifficulty() == Difficulty.EASY) {
                        d = 0.01;
                    }
                    else if (livingEntity.level.getDifficulty() == Difficulty.NORMAL) {
                        d = 0.02;
                    }
                    else if (livingEntity.level.getDifficulty() == Difficulty.HARD) {
                        d = 0.03;
                    }
                    attribute.put(Attributes.MOVEMENT_SPEED,
                            new AttributeModifier(uuid, "generic.movement_speed", 0.05 + d,
                                    AttributeModifier.Operation.ADDITION));
                }

                return attribute;
            }

            @Nonnull
            @Override
            public SoundInfo getEquipSound(SlotContext context) {
                return new SoundInfo(SoundEvents.CHAIN_STEP, 1.0F, 2.0F);
            }

            @Override
            public boolean canEquipFromUse(SlotContext context) {
                return true;
            }

            @Override
            public boolean canSync(SlotContext context) {
                return true;
            }

            @Nonnull
            @Override
            public DropRule getDropRule(SlotContext context, DamageSource source, int lootingLevel, boolean recentlyHit) {
                return DropRule.DEFAULT;
            }
        });
    }

    public static ICapabilityProvider createNightVisionCharmProvider(ItemStack stack) {
        return CurioItemCapability.createProvider(new ICurio() {
            @Override
            public ItemStack getStack() {
                return stack;
            }

            @Override
            public void curioTick(SlotContext slotContext) {
                LivingEntity livingEntity = slotContext.entity();
                MinecraftServer server = livingEntity != null ? livingEntity.getServer() : null;
                ServerLevel serverLevel = server != null ? server.getLevel(livingEntity.level.dimension()) : null;

                if (livingEntity != null && !livingEntity.level.isClientSide()) {
                    if (stack.is(ModTags.Items.BAT_COIN_SET) || stack.is(ModTags.Items.HALLOWEEN_COIN_SET)) {
                        livingEntity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 200, 0,
                                false, false, true));
                    }
                }
            }

            @Override
            public void onUnequip(SlotContext slotContext, ItemStack newStack) {
                LivingEntity livingEntity = slotContext.entity();
                if (livingEntity != null && stack.is(ModTags.Items.BAT_COIN_SET)) {
                    livingEntity.removeEffect(MobEffects.NIGHT_VISION);
                }
                if (livingEntity != null && stack.is(ModTags.Items.HALLOWEEN_COIN_SET)) {
                    livingEntity.removeEffect(MobEffects.NIGHT_VISION);
                }
            }

            @Nonnull
            @Override
            public SoundInfo getEquipSound(SlotContext context) {
                return new SoundInfo(SoundEvents.CHAIN_STEP, 1.0F, 2.0F);
            }

            @Override
            public boolean canEquipFromUse(SlotContext context) {
                return true;
            }

            @Override
            public boolean canSync(SlotContext context) {
                return true;
            }

            @Nonnull
            @Override
            public DropRule getDropRule(SlotContext context, DamageSource source, int lootingLevel, boolean recentlyHit) {
                return DropRule.DEFAULT;
            }
        });
    }

    public static ICapabilityProvider createGiftingCharmProvider(ItemStack stack) {
        return CurioItemCapability.createProvider(new ICurio() {
            @Override
            public ItemStack getStack() {
                return stack;
            }

            @Override
            public void curioTick(SlotContext slotContext) {
                LivingEntity livingEntity = slotContext.entity();
                MinecraftServer server = livingEntity != null ? livingEntity.getServer() : null;
                ServerLevel serverLevel = server != null ? server.getLevel(livingEntity.level.dimension()) : null;

                if (livingEntity != null && !livingEntity.level.isClientSide()) {

                    if (stack.is(ModTags.Items.HALLOWEEN_COIN_SET)) {
                        if (ModList.get().isLoaded("sereneseasons") && SereneSeasonsCompat.SeasonCompat.isHalloween(serverLevel)) {
                            livingEntity.addEffect(new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 200, 0,
                                    false, false, true));
                        }
                        else if (CalendarUtil.Season.isHalloween()) {
                            livingEntity.addEffect(new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 200, 0,
                                    false, false, true));
                        }
                        else {
                            livingEntity.removeEffect(MobEffects.HERO_OF_THE_VILLAGE);
                        }
                    }

                    if (stack.is(ModTags.Items.BIRTHDAY_COIN_SET)) {
                        if (ModList.get().isLoaded("sereneseasons") && SereneSeasonsCompat.SeasonCompat.isBirthday(serverLevel)) {
                            livingEntity.addEffect(new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 200, 0,
                                    false, false, true));
                        }
                        else if (CalendarUtil.Season.isBirthday()) {
                            livingEntity.addEffect(new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 200, 0,
                                    false, false, true));
                        }
                        else {
                            livingEntity.removeEffect(MobEffects.HERO_OF_THE_VILLAGE);
                        }
                    }

                    if (stack.is(ModTags.Items.CHRISTMAS_COIN_SET)) {
                        if (ModList.get().isLoaded("sereneseasons") && SereneSeasonsCompat.SeasonCompat.isChristmas(serverLevel)) {
                            livingEntity.addEffect(new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 200, 0,
                                    false, false, true));
                        }
                        else if (CalendarUtil.Season.isChristmas()) {
                            livingEntity.addEffect(new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 200, 0,
                                    false, false, true));
                        }
                        else {
                            livingEntity.removeEffect(MobEffects.HERO_OF_THE_VILLAGE);
                        }
                    }
                }
            }

            @Override
            public void onUnequip(SlotContext slotContext, ItemStack newStack) {
                LivingEntity livingEntity = slotContext.entity();
                if (livingEntity != null
                        && (stack.is(ModTags.Items.HALLOWEEN_COIN_SET)
                        || stack.is(ModTags.Items.BIRTHDAY_COIN_SET)
                        || stack.is(ModTags.Items.CHRISTMAS_COIN_SET))) {
                    livingEntity.removeEffect(MobEffects.HERO_OF_THE_VILLAGE);
                }
            }

            @Nonnull
            @Override
            public SoundInfo getEquipSound(SlotContext context) {
                return new SoundInfo(SoundEvents.CHAIN_STEP, 1.0F, 2.0F);
            }

            @Override
            public boolean canEquipFromUse(SlotContext context) {
                return true;
            }

            @Override
            public boolean canSync(SlotContext context) {
                return true;
            }

            @Nonnull
            @Override
            public DropRule getDropRule(SlotContext context, DamageSource source, int lootingLevel, boolean recentlyHit) {
                return DropRule.DEFAULT;
            }
        });
    }

    public static ICapabilityProvider createSlowFallingCharmProvider(ItemStack stack) {
        return CurioItemCapability.createProvider(new ICurio() {
            @Override
            public ItemStack getStack() {
                return stack;
            }

            @Override
            public void curioTick(SlotContext slotContext) {
                LivingEntity livingEntity = slotContext.entity();
                if (livingEntity != null) {
                    if (stack.is(ModTags.Items.ALLAY_COIN_SET) || stack.is(ModTags.Items.BAT_COIN_SET)
                            || stack.is(ModTags.Items.CHICKEN_COIN_SET) || stack.is(ModTags.Items.GHAST_COIN_SET)
                            || stack.is(ModTags.Items.PARROT_COIN_SET) || stack.is(ModTags.Items.PHANTOM_COIN_SET)
                            || stack.is(ModTags.Items.ENDER_DRAGON_COIN_SET)) {
                        int i = 0;
                        if (livingEntity.level.getDifficulty() == Difficulty.EASY) {
                            i = 1;
                        }
                        else if (livingEntity.level.getDifficulty() == Difficulty.NORMAL) {
                            i = 2;
                        }
                        else if (livingEntity.level.getDifficulty() == Difficulty.HARD) {
                            i = 3;
                        }
                        livingEntity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 200, i,
                                false, false, false));
                    }
                    if (stack.getItem() instanceof FelineCoinItem) {
                        livingEntity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 200, 0,
                                false, false, false));
                    }
                }
            }

            @Override
            public void onUnequip(SlotContext slotContext, ItemStack newStack) {
                LivingEntity livingEntity = slotContext.entity();
                if (livingEntity != null && (stack.is(ModTags.Items.ALLAY_COIN_SET) || stack.is(ModTags.Items.BAT_COIN_SET)
                        || stack.is(ModTags.Items.CAT_COIN_SET) || stack.is(ModTags.Items.CHICKEN_COIN_SET)
                        || stack.is(ModTags.Items.GHAST_COIN_SET) || stack.is(ModTags.Items.OCELOT_COIN_SET)
                        || stack.is(ModTags.Items.PARROT_COIN_SET) || stack.is(ModTags.Items.PHANTOM_COIN_SET))) {
                    livingEntity.removeEffect(MobEffects.SLOW_FALLING);
                }
            }

            @Nonnull
            @Override
            public SoundInfo getEquipSound(SlotContext context) {
                return new SoundInfo(SoundEvents.CHAIN_STEP, 1.0F, 2.0F);
            }

            @Override
            public boolean canEquipFromUse(SlotContext context) {
                return true;
            }

            @Override
            public boolean canSync(SlotContext context) {
                return true;
            }

            @Nonnull
            @Override
            public DropRule getDropRule(SlotContext context, DamageSource source, int lootingLevel, boolean recentlyHit) {
                return DropRule.DEFAULT;
            }
        });
    }

    public static ICapabilityProvider createRegenCharmProvider(ItemStack stack) {
        return CurioItemCapability.createProvider(new ICurio() {
            @Override
            public ItemStack getStack() {
                return stack;
            }

            @Override
            public void curioTick(SlotContext slotContext) {
                LivingEntity livingEntity = slotContext.entity();
                if (livingEntity != null) {
                    if (stack.is(ModTags.Items.AXOLOTL_COIN_SET) || stack.is(ModTags.Items.PENGUIN_COIN_SET)) {

                        int i = 0;
                        if (livingEntity.level.getDifficulty() == Difficulty.EASY) {
                            i = 1;
                        }
                        else if (livingEntity.level.getDifficulty() == Difficulty.NORMAL) {
                            i = 2;
                        }
                        else if (livingEntity.level.getDifficulty() == Difficulty.HARD) {
                            i = 3;
                        }
                        livingEntity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 200, i,
                                false, false, false));
                    }
                }
            }

            @Override
            public void onUnequip(SlotContext slotContext, ItemStack newStack) {
                LivingEntity livingEntity = slotContext.entity();
                if (livingEntity != null && (stack.is(ModTags.Items.AXOLOTL_COIN_SET) || stack.is(ModTags.Items.PENGUIN_COIN_SET))) {
                    livingEntity.removeEffect(MobEffects.REGENERATION);
                }
            }

            @Nonnull
            @Override
            public SoundInfo getEquipSound(SlotContext context) {
                return new SoundInfo(SoundEvents.CHAIN_STEP, 1.0F, 2.0F);
            }

            @Override
            public boolean canEquipFromUse(SlotContext context) {
                return true;
            }

            @Override
            public boolean canSync(SlotContext context) {
                return true;
            }

            @Nonnull
            @Override
            public DropRule getDropRule(SlotContext context, DamageSource source, int lootingLevel, boolean recentlyHit) {
                return DropRule.DEFAULT;
            }
        });
    }

    public static ICapabilityProvider createSaturationCharmProvider(ItemStack stack) {
        return CurioItemCapability.createProvider(new ICurio() {
            @Override
            public ItemStack getStack() {
                return stack;
            }

            @Override
            public void curioTick(SlotContext slotContext) {
                LivingEntity livingEntity = slotContext.entity();
                if (livingEntity != null) {
                    if (stack.is(ModTags.Items.CAMEL_COIN_SET) || stack.is(ModTags.Items.PIG_COIN_SET)
                            || stack.is(ModTags.Items.MAULER_COIN_SET)) {

                        int i = 0;
                        if (livingEntity.level.getDifficulty() == Difficulty.EASY) {
                            i = 1;
                        }
                        else if (livingEntity.level.getDifficulty() == Difficulty.NORMAL) {
                            i = 2;
                        }
                        else if (livingEntity.level.getDifficulty() == Difficulty.HARD) {
                            i = 3;
                        }
                        livingEntity.addEffect(new MobEffectInstance(MobEffects.SATURATION, 200, i,
                                false, false, false));
                    }
                }
            }

            @Override
            public void onUnequip(SlotContext slotContext, ItemStack newStack) {
                LivingEntity livingEntity = slotContext.entity();
                if (livingEntity != null && (stack.is(ModTags.Items.CAMEL_COIN_SET) || stack.is(ModTags.Items.PIG_COIN_SET))) {
                    livingEntity.removeEffect(MobEffects.SATURATION);
                }
            }

            @Nonnull
            @Override
            public SoundInfo getEquipSound(SlotContext context) {
                return new SoundInfo(SoundEvents.CHAIN_STEP, 1.0F, 2.0F);
            }

            @Override
            public boolean canEquipFromUse(SlotContext context) {
                return true;
            }

            @Override
            public boolean canSync(SlotContext context) {
                return true;
            }

            @Nonnull
            @Override
            public DropRule getDropRule(SlotContext context, DamageSource source, int lootingLevel, boolean recentlyHit) {
                return DropRule.DEFAULT;
            }
        });
    }

    public static ICapabilityProvider createPowderedSnowCharmProvider(ItemStack stack) {
        return CurioItemCapability.createProvider(new ICurio() {
            @Override
            public ItemStack getStack() {
                return stack;
            }

            @Override
            public boolean canWalkOnPowderedSnow(SlotContext slotContext) {
                return stack.is(ModTags.Items.RABBIT_COIN_SET) || stack.is(ModTags.Items.FOX_COIN_SET)
                        || stack.is(ModTags.Items.ENDERMITE_COIN_SET) || stack.is(ModTags.Items.SILVERFISH_COIN_SET)
                        || stack.is(ModTags.Items.SHULKER_COIN_SET) || stack.is(ModTags.Items.VEX_COIN_SET)
                        || stack.is(ModTags.Items.PENGUIN_COIN_SET) || stack.is(ModTags.Items.ICEOLOGER_COIN_SET)
                        || stack.is(ModTags.Items.CHRISTMAS_COIN_SET);
            }

            @Nonnull
            @Override
            public SoundInfo getEquipSound(SlotContext context) {
                return new SoundInfo(SoundEvents.CHAIN_STEP, 1.0F, 2.0F);
            }

            @Override
            public boolean canEquipFromUse(SlotContext context) {
                return true;
            }

            @Override
            public boolean canSync(SlotContext context) {
                return true;
            }

            @Nonnull
            @Override
            public DropRule getDropRule(SlotContext context, DamageSource source, int lootingLevel, boolean recentlyHit) {
                return DropRule.DEFAULT;
            }
        });
    }

    public static ICapabilityProvider createJumpBoostCharmProvider(ItemStack stack) {
        return CurioItemCapability.createProvider(new ICurio() {
            @Override
            public ItemStack getStack() {
                return stack;
            }

            @Override
            public void curioTick(SlotContext slotContext) {
                LivingEntity livingEntity = slotContext.entity();
                if (livingEntity != null) {
                    if (stack.is(ModTags.Items.FROG_COIN_SET) || stack.is(ModTags.Items.RABBIT_COIN_SET)
                            || stack.is(ModTags.Items.GOAT_COIN_SET) || stack.is(ModTags.Items.SLIME_COIN_SET)
                            || stack.is(ModTags.Items.SLIME_COIN_SET)) {
                        int i = 0;
                        if (livingEntity.level.getDifficulty() == Difficulty.EASY) {
                            i = 1;
                        }
                        else if (livingEntity.level.getDifficulty() == Difficulty.NORMAL) {
                            i = 2;
                        }
                        else if (livingEntity.level.getDifficulty() == Difficulty.HARD) {
                            i = 3;
                        }
                        livingEntity.addEffect(new MobEffectInstance(MobEffects.JUMP, 200, i,
                                false, false, false));
                    }
                }
            }

            @Override
            public void onUnequip(SlotContext slotContext, ItemStack newStack) {
                LivingEntity livingEntity = slotContext.entity();
                if (livingEntity != null && (stack.is(ModTags.Items.FROG_COIN_SET) || stack.is(ModTags.Items.RABBIT_COIN_SET)
                        || stack.is(ModTags.Items.GOAT_COIN_SET) || stack.is(ModTags.Items.SLIME_COIN_SET)
                        || stack.is(ModTags.Items.SLIME_COIN_SET))) {
                    livingEntity.removeEffect(MobEffects.JUMP);
                }
            }

            @Nonnull
            @Override
            public SoundInfo getEquipSound(SlotContext context) {
                return new SoundInfo(SoundEvents.CHAIN_STEP, 1.0F, 2.0F);
            }

            @Override
            public boolean canEquipFromUse(SlotContext context) {
                return true;
            }

            @Override
            public boolean canSync(SlotContext context) {
                return true;
            }

            @Nonnull
            @Override
            public DropRule getDropRule(SlotContext context, DamageSource source, int lootingLevel, boolean recentlyHit) {
                return DropRule.DEFAULT;
            }
        });
    }

    public static ICapabilityProvider createWaterBreathingCharmProvider(ItemStack stack) {
        return CurioItemCapability.createProvider(new ICurio() {
            @Override
            public ItemStack getStack() {
                return stack;
            }

            @Override
            public void curioTick(SlotContext slotContext) {
                LivingEntity livingEntity = slotContext.entity();
                if (livingEntity != null) {
                    if (stack.is(ModTags.Items.SQUID_COIN_SET) || stack.is(ModTags.Items.GLOW_SQUID_COIN_SET)
                            || stack.is(ModTags.Items.AXOLOTL_COIN_SET) || stack.is(ModTags.Items.CRAB_COIN_SET)
                            || stack.is(ModTags.Items.TURTLE_COIN_SET) || stack.is(ModTags.Items.TADPOLE_COIN_SET)
                            || stack.is(ModTags.Items.GUARDIAN_COIN_SET) || stack.is(ModTags.Items.ELDER_GUARDIAN_COIN_SET)
                            || stack.is(ModTags.Items.COD_COIN_SET) || stack.is(ModTags.Items.SALMON_COIN_SET)
                            || stack.is(ModTags.Items.PUFFERFISH_COIN_SET) || stack.is(ModTags.Items.TROPICAL_FISH_COIN_SET)
                            || stack.is(ModTags.Items.DROWNED_COIN_SET)) {
                        //noinspection deprecation
                        if (livingEntity.isEyeInFluid(FluidTags.WATER)) {

                            int i = 0;
                            if (livingEntity.level.getDifficulty() == Difficulty.EASY) {
                                i = 1;
                            }
                            else if (livingEntity.level.getDifficulty() == Difficulty.NORMAL) {
                                i = 2;
                            }
                            else if (livingEntity.level.getDifficulty() == Difficulty.HARD) {
                                i = 3;
                            }
                            livingEntity.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 200, i,
                                    false, false, false));
                        }
                    }
                    if (stack.is(ModTags.Items.DOLPHIN_COIN_SET)) {
                        //noinspection deprecation
                        if (livingEntity.isEyeInFluid(FluidTags.WATER)) {

                            int i = 0;
                            if (livingEntity.level.getDifficulty() == Difficulty.EASY) {
                                i = 1;
                            }
                            else if (livingEntity.level.getDifficulty() == Difficulty.NORMAL) {
                                i = 2;
                            }
                            else if (livingEntity.level.getDifficulty() == Difficulty.HARD) {
                                i = 3;
                            }
                            livingEntity.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 200, i,
                                    false, false, true));
                        }
                        else {
                            livingEntity.removeEffect(MobEffects.DOLPHINS_GRACE);
                        }
                    }
                }
            }

            @Override
            public void onUnequip(SlotContext slotContext, ItemStack newStack) {
                LivingEntity livingEntity = slotContext.entity();
                if ((stack.is(ModTags.Items.SQUID_COIN_SET) || stack.is(ModTags.Items.GLOW_SQUID_COIN_SET)
                        || stack.is(ModTags.Items.TURTLE_COIN_SET) || stack.is(ModTags.Items.TADPOLE_COIN_SET)
                        || stack.is(ModTags.Items.GUARDIAN_COIN_SET) || stack.is(ModTags.Items.ELDER_GUARDIAN_COIN_SET))
                        && livingEntity != null) {
                    livingEntity.removeEffect(MobEffects.WATER_BREATHING);
                }
            }

            @Nonnull
            @Override
            public SoundInfo getEquipSound(SlotContext context) {
                return new SoundInfo(SoundEvents.CHAIN_STEP, 1.0F, 2.0F);
            }

            @Override
            public boolean canEquipFromUse(SlotContext context) {
                return true;
            }

            @Override
            public boolean canSync(SlotContext context) {
                return true;
            }

            @Nonnull
            @Override
            public DropRule getDropRule(SlotContext context, DamageSource source, int lootingLevel, boolean recentlyHit) {
                return DropRule.DEFAULT;
            }
        });
    }

    public static ICapabilityProvider createKnockbackCharmProvider(ItemStack stack) {
        return CurioItemCapability.createProvider(new ICurio() {
            @Override
            public ItemStack getStack() {
                return stack;
            }

            @Override
            public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid) {
                Multimap<Attribute, AttributeModifier> attribute = LinkedHashMultimap.create();
                LivingEntity livingEntity = slotContext.entity();
                if (livingEntity != null) {

                    int i = 0;
                    if (livingEntity.level.getDifficulty() == Difficulty.EASY) {
                        i = 1;
                    }
                    else if (livingEntity.level.getDifficulty() == Difficulty.NORMAL) {
                        i = 2;
                    }
                    else if (livingEntity.level.getDifficulty() == Difficulty.HARD) {
                        i = 3;
                    }
                    attribute.put(Attributes.ATTACK_KNOCKBACK,
                            new AttributeModifier(uuid, "generic.attack_knockback", 1 + i,
                                    AttributeModifier.Operation.ADDITION));
                }

                return attribute;
            }

            @Nonnull
            @Override
            public SoundInfo getEquipSound(SlotContext context) {
                return new SoundInfo(SoundEvents.CHAIN_STEP, 1.0F, 2.0F);
            }

            @Override
            public boolean canEquipFromUse(SlotContext context) {
                return true;
            }

            @Override
            public boolean canSync(SlotContext context) {
                return true;
            }

            @Nonnull
            @Override
            public DropRule getDropRule(SlotContext context, DamageSource source, int lootingLevel, boolean recentlyHit) {
                return DropRule.DEFAULT;
            }
        });
    }

    public static ICapabilityProvider createFireResistCharmProvider(ItemStack stack) {
        return CurioItemCapability.createProvider(new ICurio() {
            @Override
            public ItemStack getStack() {
                return stack;
            }

            @Override
            public void curioTick(SlotContext slotContext) {
                LivingEntity livingEntity = slotContext.entity();
                if (livingEntity != null) {
                    if (stack.is(ModTags.Items.STRIDER_COIN_SET) || stack.is(ModTags.Items.BLAZE_COIN_SET)
                            || stack.is(ModTags.Items.MAGMA_CUBE_COIN_SET) || stack.is(ModTags.Items.GHAST_COIN_SET)
                            || stack.is(ModTags.Items.WILDFIRE_COIN_SET)) {

                        int i = 0;
                        if (livingEntity.level.getDifficulty() == Difficulty.EASY) {
                            i = 1;
                        }
                        else if (livingEntity.level.getDifficulty() == Difficulty.NORMAL) {
                            i = 2;
                        }
                        else if (livingEntity.level.getDifficulty() == Difficulty.HARD) {
                            i = 3;
                        }
                        livingEntity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200, i,
                                false, false, false));
                    }
                }
            }

            @Override
            public void onUnequip(SlotContext slotContext, ItemStack newStack) {
                LivingEntity livingEntity = slotContext.entity();
                if (livingEntity != null && (stack.is(ModTags.Items.STRIDER_COIN_SET) || stack.is(ModTags.Items.BLAZE_COIN_SET)
                        || stack.is(ModTags.Items.MAGMA_CUBE_COIN_SET))) {
                    livingEntity.removeEffect(MobEffects.FIRE_RESISTANCE);
                }
            }

            @Nonnull
            @Override
            public SoundInfo getEquipSound(SlotContext context) {
                return new SoundInfo(SoundEvents.CHAIN_STEP, 1.0F, 2.0F);
            }

            @Override
            public boolean canEquipFromUse(SlotContext context) {
                return true;
            }

            @Override
            public boolean canSync(SlotContext context) {
                return true;
            }

            @Nonnull
            @Override
            public DropRule getDropRule(SlotContext context, DamageSource source, int lootingLevel, boolean recentlyHit) {
                return DropRule.DEFAULT;
            }
        });
    }

    public static ICapabilityProvider createVillagerCharmProvider(ItemStack stack) {
        return CurioItemCapability.createProvider(new ICurio() {
            @Override
            public ItemStack getStack() {
                return stack;
            }

            @Override
            public void curioTick(SlotContext slotContext) {
                LivingEntity livingEntity = slotContext.entity();
                if (livingEntity != null) {
                    if (livingEntity != null && (stack.is(ModTags.Items.WANDERING_TRADER_COIN_SET)
                            || stack.is(ModTags.Items.NUMISMATIST_COIN_SET)) && (livingEntity.level.getDayTime() >= 12000)) {
                        livingEntity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 200, 0,
                                false, false, true));
                    }
                    else {
                        livingEntity.removeEffect(MobEffects.INVISIBILITY);
                    }

                    if (livingEntity != null && (stack.is(ModTags.Items.VILLAGER_COIN_SET)
                            || stack.is(ModTags.Items.GUARD_COIN_SET)
                            || stack.is(ModTags.Items.GLARE_COIN_SET))
                            && (livingEntity.level.getDayTime() >= 12000)) {

                        int i = 0;
                        if (livingEntity.level.getDifficulty() == Difficulty.EASY) {
                            i = 1;
                        }
                        else if (livingEntity.level.getDifficulty() == Difficulty.NORMAL) {
                            i = 2;
                        }
                        else if (livingEntity.level.getDifficulty() == Difficulty.HARD) {
                            i = 3;
                        }
                        livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, i,
                                false, false, false));
                    }
                    else {
                        livingEntity.removeEffect(MobEffects.MOVEMENT_SPEED);
                    }
                }
            }

            @Override
            public void onUnequip(SlotContext slotContext, ItemStack newStack) {
                LivingEntity livingEntity = slotContext.entity();

                if (livingEntity != null && (stack.is(ModTags.Items.WANDERING_TRADER_COIN_SET)
                        || stack.is(ModTags.Items.GUARD_COIN_SET)
                        || stack.is(ModTags.Items.GLARE_COIN_SET)
                        || stack.is(ModTags.Items.NUMISMATIST_COIN_SET)
                        || stack.is(ModTags.Items.VILLAGER_COIN_SET))) {
                    livingEntity.removeEffect(MobEffects.MOVEMENT_SPEED);
                    livingEntity.removeEffect(MobEffects.INVISIBILITY);
                }
            }

            @Nonnull
            @Override
            public SoundInfo getEquipSound(SlotContext context) {
                return new SoundInfo(SoundEvents.CHAIN_STEP, 1.0F, 2.0F);
            }

            @Override
            public boolean canEquipFromUse(SlotContext context) {
                return true;
            }

            @Override
            public boolean canSync(SlotContext context) {
                return true;
            }

            @Nonnull
            @Override
            public DropRule getDropRule(SlotContext context, DamageSource source, int lootingLevel, boolean recentlyHit) {
                return DropRule.DEFAULT;
            }
        });
    }

    public static ICapabilityProvider createSnifferCharmProvider(ItemStack stack) {
        return CurioItemCapability.createProvider(new ICurio() {
            @Override
            public ItemStack getStack() {
                return stack;
            }

            @Override
            public void curioTick(SlotContext slotContext) {
                LivingEntity livingEntity = slotContext.entity();
                if (livingEntity != null) {
                    if (stack.is(ModTags.Items.SNIFFER_COIN_SET)) {

                        int i = 0;
                        if (livingEntity.level.getDifficulty() == Difficulty.EASY) {
                            i = 1;
                        }
                        else if (livingEntity.level.getDifficulty() == Difficulty.NORMAL) {
                            i = 2;
                        }
                        else if (livingEntity.level.getDifficulty() == Difficulty.HARD) {
                            i = 3;
                        }
                        livingEntity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 200, i,
                                false, false, false));
                    }
                }
            }

            @Override
            public void onUnequip(SlotContext slotContext, ItemStack newStack) {
                LivingEntity livingEntity = slotContext.entity();
                if (livingEntity != null && stack.is(ModTags.Items.SNIFFER_COIN_SET)) {
                    livingEntity.removeEffect(MobEffects.DIG_SPEED);
                }
            }

            @Nonnull
            @Override
            public SoundInfo getEquipSound(SlotContext context) {
                return new SoundInfo(SoundEvents.CHAIN_STEP, 1.0F, 2.0F);
            }

            @Override
            public boolean canEquipFromUse(SlotContext context) {
                return true;
            }

            @Override
            public boolean canSync(SlotContext context) {
                return true;
            }

            @Nonnull
            @Override
            public DropRule getDropRule(SlotContext context, DamageSource source, int lootingLevel, boolean recentlyHit) {
                return DropRule.DEFAULT;
            }
        });
    }

    public static ICapabilityProvider createAttackStrengthCharmProvider(ItemStack stack) {
        return CurioItemCapability.createProvider(new ICurio() {
            @Override
            public ItemStack getStack() {
                return stack;
            }

            @Override
            public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid) {
                Multimap<Attribute, AttributeModifier> attribute = LinkedHashMultimap.create();
                LivingEntity livingEntity = slotContext.entity();
                if (livingEntity != null) {

                    int i = 0;
                    if (livingEntity.level.getDifficulty() == Difficulty.EASY) {
                        i = 1;
                    }
                    else if (livingEntity.level.getDifficulty() == Difficulty.NORMAL) {
                        i = 2;
                    }
                    else if (livingEntity.level.getDifficulty() == Difficulty.HARD) {
                        i = 3;
                    }
                    attribute.put(Attributes.ATTACK_DAMAGE,
                            new AttributeModifier(uuid, "generic.attack_damage", 1 + i,
                                    AttributeModifier.Operation.ADDITION));
                }

                return attribute;
            }

            @Nonnull
            @Override
            public SoundInfo getEquipSound(SlotContext context) {
                return new SoundInfo(SoundEvents.CHAIN_STEP, 1.0F, 2.0F);
            }

            @Override
            public boolean canEquipFromUse(SlotContext context) {
                return true;
            }

            @Override
            public boolean canSync(SlotContext context) {
                return true;
            }

            @Nonnull
            @Override
            public DropRule getDropRule(SlotContext context, DamageSource source, int lootingLevel, boolean recentlyHit) {
                return DropRule.DEFAULT;
            }
        });
    }

    public static ICapabilityProvider createDamageResistanceCharmProvider(ItemStack stack) {
        return CurioItemCapability.createProvider(new ICurio() {
            @Override
            public ItemStack getStack() {
                return stack;
            }

            @Override
            public void curioTick(SlotContext slotContext) {
                if (stack.is(ModTags.Items.GHAST_COIN_SET) || stack.is(ModTags.Items.CREEPER_COIN_SET)) {
                    LivingEntity livingEntity = slotContext.entity();
                    if (livingEntity != null) {
                        int i = 0;
                        if (livingEntity.level.getDifficulty() == Difficulty.EASY) {
                            i = 1;
                        }
                        else if (livingEntity.level.getDifficulty() == Difficulty.NORMAL) {
                            i = 2;
                        }
                        else if (livingEntity.level.getDifficulty() == Difficulty.HARD) {
                            i = 3;
                        }

                        livingEntity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 200, i,
                                false, false, true));
                    }
                }
            }

            @Override
            public void onUnequip(SlotContext slotContext, ItemStack newStack) {
                LivingEntity livingEntity = slotContext.entity();
                if (livingEntity != null && (stack.is(ModTags.Items.GHAST_COIN_SET) || stack.is(ModTags.Items.CREEPER_COIN_SET))) {
                    livingEntity.removeEffect(MobEffects.DAMAGE_RESISTANCE);
                }
            }

            @Nonnull
            @Override
            public SoundInfo getEquipSound(SlotContext context) {
                return new SoundInfo(SoundEvents.CHAIN_STEP, 1.0F, 2.0F);
            }

            @Override
            public boolean canEquipFromUse(SlotContext context) {
                return true;
            }

            @Override
            public boolean canSync(SlotContext context) {
                return true;
            }

            @Nonnull
            @Override
            public DropRule getDropRule(SlotContext context, DamageSource source, int lootingLevel, boolean recentlyHit) {
                return DropRule.DEFAULT;
            }
        });
    }

    public static ICapabilityProvider createUndeadCharmProvider(ItemStack stack) {
        return CurioItemCapability.createProvider(new ICurio() {
            @Override
            public ItemStack getStack() {
                return stack;
            }

            @Override
            public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid) {
                Multimap<Attribute, AttributeModifier> attribute = LinkedHashMultimap.create();
                LivingEntity livingEntity = slotContext.entity();
                if (livingEntity != null) {

                    int i = 0;
                    if (livingEntity.level.getDifficulty() == Difficulty.EASY) {
                        i = 1;
                    }
                    else if (livingEntity.level.getDifficulty() == Difficulty.NORMAL) {
                        i = 2;
                    }
                    else if (livingEntity.level.getDifficulty() == Difficulty.HARD) {
                        i = 3;
                    }
                    attribute.put(Attributes.ARMOR_TOUGHNESS,
                            new AttributeModifier(uuid, "generic.armor_toughness", 1 + i,
                                    AttributeModifier.Operation.ADDITION));
                }

                return attribute;
            }

            @Nonnull
            @Override
            public SoundInfo getEquipSound(SlotContext context) {
                return new SoundInfo(SoundEvents.CHAIN_STEP, 1.0F, 2.0F);
            }

            @Override
            public boolean canEquipFromUse(SlotContext context) {
                return true;
            }

            @Override
            public boolean canSync(SlotContext context) {
                return true;
            }

            @Nonnull
            @Override
            public DropRule getDropRule(SlotContext context, DamageSource source, int lootingLevel, boolean recentlyHit) {
                return DropRule.DEFAULT;
            }
        });
    }

    public static ICapabilityProvider createLevitateCharmProvider(ItemStack stack) {
        return CurioItemCapability.createProvider(new ICurio() {
            @Override
            public ItemStack getStack() {
                return stack;
            }

            @Override
            public void curioTick(SlotContext slotContext) {
                LivingEntity livingEntity = slotContext.entity();
                if (livingEntity != null) {
                    if (stack.is(ModTags.Items.SHULKER_COIN_SET)) {
                        livingEntity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 20, 0,
                                false, false, true));
                    }
                }
            }

            @Override
            public void onUnequip(SlotContext slotContext, ItemStack newStack) {
                LivingEntity livingEntity = slotContext.entity();
                if (livingEntity != null && stack.is(ModTags.Items.SHULKER_COIN_SET)) {
                    livingEntity.removeEffect(MobEffects.LEVITATION);
                }
            }

            @Nonnull
            @Override
            public SoundInfo getEquipSound(SlotContext context) {
                return new SoundInfo(SoundEvents.CHAIN_STEP, 1.0F, 2.0F);
            }

            @Override
            public boolean canEquipFromUse(SlotContext context) {
                return true;
            }

            @Override
            public boolean canSync(SlotContext context) {
                return true;
            }

            @Nonnull
            @Override
            public DropRule getDropRule(SlotContext context, DamageSource source, int lootingLevel, boolean recentlyHit) {
                return DropRule.DEFAULT;
            }
        });
    }

    public static ICapabilityProvider createBossCharmProvider(ItemStack stack) {
        return CurioItemCapability.createProvider(new ICurio() {
            @Override
            public ItemStack getStack() {
                return stack;
            }

            /**
             * shulker is not actually a boss, I just needed to put it in the armor attribute method here is all to save
             * me on space and sanity - sorry if it's a bit confusing, no other reason for it
             **/
            @Override
            public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid) {
                Multimap<Attribute, AttributeModifier> attribute = LinkedHashMultimap.create();
                LivingEntity livingEntity = slotContext.entity();
                if (livingEntity != null) {
                    int baseArmorBonus = 0;
                    int bossArmorBonus = 0;
                    int baseHpBonus = 0;
                    int bossHPBonus = 0;
                    int baseKnockbackResistanceBonus = 0;
                    int bossKnockBackResistanceBonus = 0;
                    int baseAttackBonus = 0;
                    int bossAttackBonus = 0;

                    // base armor bonus applied to all coins in this set
                    if (stack.is(ModTags.Items.ELDER_GUARDIAN_COIN_SET)
                            || stack.is(ModTags.Items.WARDEN_COIN_SET)
                            || stack.is(ModTags.Items.WITHER_COIN_SET)
                            || stack.is(ModTags.Items.ENDER_DRAGON_COIN_SET)
                            || stack.is(ModTags.Items.SHULKER_COIN_SET)
                            || stack.is(ModTags.Items.WILDFIRE_COIN_SET)) {
                        if (livingEntity.level.getDifficulty() == Difficulty.PEACEFUL) {
                            baseArmorBonus = 1;
                        }
                        else if (livingEntity.level.getDifficulty() == Difficulty.EASY) {
                            baseArmorBonus = 2;
                        }
                        else if (livingEntity.level.getDifficulty() == Difficulty.NORMAL) {
                            baseArmorBonus = 3;
                        }
                        else if (livingEntity.level.getDifficulty() == Difficulty.HARD) {
                            baseArmorBonus = 4;
                        }
                    }
                    // boss armor bonus
                    if (stack.is(ModTags.Items.ELDER_GUARDIAN_COIN_SET)
                            || stack.is(ModTags.Items.ENDER_DRAGON_COIN_SET)
                            || stack.is(ModTags.Items.WITHER_COIN_SET)
                            || stack.is(ModTags.Items.WARDEN_COIN_SET)) {
                        if (livingEntity.level.getDifficulty() == Difficulty.PEACEFUL) {
                            if (stack.is(ModTags.Items.WARDEN_COIN_SET)) {
                                bossArmorBonus = 2;
                            }
                            else {
                                bossArmorBonus = 1;
                            }
                        }
                        else if (livingEntity.level.getDifficulty() == Difficulty.EASY) {
                            if (stack.is(ModTags.Items.WARDEN_COIN_SET)) {
                                bossArmorBonus = 3;
                            }
                            else {
                                bossArmorBonus = 2;
                            }
                        }
                        else if (livingEntity.level.getDifficulty() == Difficulty.NORMAL) {
                            if (stack.is(ModTags.Items.WARDEN_COIN_SET)) {
                                bossArmorBonus = 4;
                            }
                            else {
                                bossArmorBonus = 3;
                            }
                        }
                        else if (livingEntity.level.getDifficulty() == Difficulty.HARD) {
                            if (stack.is(ModTags.Items.WARDEN_COIN_SET)) {
                                bossArmorBonus = 5;
                            }
                            else {
                                bossArmorBonus = 4;
                            }
                        }
                    }
                    // hp bonuses
                    if (stack.is(ModTags.Items.ELDER_GUARDIAN_COIN_SET)
                            || stack.is(ModTags.Items.ENDER_DRAGON_COIN_SET)
                            || stack.is(ModTags.Items.WITHER_COIN_SET)
                            || stack.is(ModTags.Items.WARDEN_COIN_SET)
                            || stack.is(ModTags.Items.WILDFIRE_COIN_SET)) {
                        if (livingEntity.level.getDifficulty() == Difficulty.PEACEFUL) {
                            baseHpBonus = 10;
                            if (stack.is(ModTags.Items.WARDEN_COIN_SET)) {
                                bossHPBonus = 15;
                            }
                            else if (stack.is(ModTags.Items.WITHER_COIN_SET)) {
                                bossHPBonus = 10;
                            }
                            else {
                                bossHPBonus = 5;
                            }
                        }
                        else if (livingEntity.level.getDifficulty() == Difficulty.EASY) {
                            baseHpBonus = 15;
                            if (stack.is(ModTags.Items.WARDEN_COIN_SET)) {
                                bossHPBonus = 20;
                            }
                            else if (stack.is(ModTags.Items.WITHER_COIN_SET)) {
                                bossHPBonus = 15;
                            }
                            else {
                                bossHPBonus = 10;
                            }
                        }
                        else if (livingEntity.level.getDifficulty() == Difficulty.NORMAL) {
                            baseHpBonus = 20;
                            if (stack.is(ModTags.Items.WARDEN_COIN_SET)) {
                                bossHPBonus = 20;
                            }
                            else if (stack.is(ModTags.Items.WITHER_COIN_SET)) {
                                bossHPBonus = 15;
                            }
                            else {
                                bossHPBonus = 10;
                            }
                        }
                        else if (livingEntity.level.getDifficulty() == Difficulty.HARD) {
                            baseHpBonus = 25;
                            if (stack.is(ModTags.Items.WARDEN_COIN_SET)) {
                                bossHPBonus = 25;
                            }
                            else if (stack.is(ModTags.Items.WITHER_COIN_SET)) {
                                bossHPBonus = 20;
                            }
                            else {
                                bossHPBonus = 15;
                            }
                        }
                    }
                    // knockback resistance bonuses
                    if (stack.is(ModTags.Items.ELDER_GUARDIAN_COIN_SET)
                            || stack.is(ModTags.Items.ENDER_DRAGON_COIN_SET)
                            || stack.is(ModTags.Items.WITHER_COIN_SET)
                            || stack.is(ModTags.Items.WARDEN_COIN_SET)
                            || stack.is(ModTags.Items.WILDFIRE_COIN_SET)) {
                        baseKnockbackResistanceBonus = 2;

                        if (livingEntity.level.getDifficulty() == Difficulty.EASY) {
                            if (stack.is(ModTags.Items.ENDER_DRAGON_COIN_SET)) {
                                bossKnockBackResistanceBonus = 2;
                            }
                            else {
                                bossKnockBackResistanceBonus = 1;
                            }
                        }
                        else if (livingEntity.level.getDifficulty() == Difficulty.NORMAL) {
                            if (stack.is(ModTags.Items.ENDER_DRAGON_COIN_SET)) {
                                bossKnockBackResistanceBonus = 2;
                            }
                            else {
                                bossKnockBackResistanceBonus = 1;
                            }
                        }
                        else if (livingEntity.level.getDifficulty() == Difficulty.HARD) {
                            if (stack.is(ModTags.Items.ENDER_DRAGON_COIN_SET)) {
                                bossKnockBackResistanceBonus = 2;
                            }
                            else {
                                bossKnockBackResistanceBonus = 1;
                            }
                        }
                    }
                    // attack bonuses
                    if (stack.is(ModTags.Items.ELDER_GUARDIAN_COIN_SET)
                            || stack.is(ModTags.Items.ENDER_DRAGON_COIN_SET)
                            || stack.is(ModTags.Items.WITHER_COIN_SET)
                            || stack.is(ModTags.Items.WARDEN_COIN_SET)
                            || stack.is(ModTags.Items.WILDFIRE_COIN_SET)) {
                        baseAttackBonus = 2;

                        if (livingEntity.level.getDifficulty() == Difficulty.EASY) {
                            if (stack.is(ModTags.Items.WARDEN_COIN_SET)) {
                                bossAttackBonus = 2;
                            }
                            else {
                                bossAttackBonus = 1;
                            }
                        }
                        else if (livingEntity.level.getDifficulty() == Difficulty.NORMAL) {
                            if (stack.is(ModTags.Items.WARDEN_COIN_SET)) {
                                bossAttackBonus = 2;
                            }
                            else {
                                bossAttackBonus = 1;
                            }
                        }
                        else if (livingEntity.level.getDifficulty() == Difficulty.HARD) {
                            if (stack.is(ModTags.Items.WARDEN_COIN_SET)) {
                                bossAttackBonus = 2;
                            }
                            else {
                                bossAttackBonus = 1;
                            }
                        }
                    }

                    attribute.put(Attributes.ARMOR,
                            new AttributeModifier(uuid, "generic.armor", (1 + baseArmorBonus) + bossArmorBonus,
                                    AttributeModifier.Operation.ADDITION));
                    attribute.put(Attributes.MAX_HEALTH,
                            new AttributeModifier(uuid, "generic.max_health", (10 + baseHpBonus) + bossHPBonus,
                                    AttributeModifier.Operation.ADDITION));
                    attribute.put(Attributes.KNOCKBACK_RESISTANCE,
                            new AttributeModifier(uuid, "generic.knockback_resistance", (1 + baseKnockbackResistanceBonus) + bossKnockBackResistanceBonus,
                                    AttributeModifier.Operation.ADDITION));
                    attribute.put(Attributes.ATTACK_DAMAGE,
                            new AttributeModifier(uuid, "generic.attack_damage", (1 + baseAttackBonus) + bossAttackBonus,
                                    AttributeModifier.Operation.ADDITION));
                }
                return attribute;
            }

            @Override
            public void curioTick(SlotContext slotContext) {
                LivingEntity livingEntity = slotContext.entity();
                if (livingEntity != null) {
                    if (stack.is(ModTags.Items.WARDEN_COIN_SET)) {
                        livingEntity.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 200, 1,
                                false, false, true));
                    }
                }
            }

            @Override
            public void onUnequip(SlotContext slotContext, ItemStack newStack) {
                LivingEntity livingEntity = slotContext.entity();
                if (livingEntity != null && stack.is(ModTags.Items.WARDEN_COIN_SET)) {
                    livingEntity.removeEffect(MobEffects.HEALTH_BOOST);
                }
            }

            @Nonnull
            @Override
            public SoundInfo getEquipSound(SlotContext context) {
                return new SoundInfo(SoundEvents.CHAIN_STEP, 1.0F, 2.0F);
            }

            @Override
            public boolean canEquipFromUse(SlotContext context) {
                return true;
            }

            @Override
            public boolean canSync(SlotContext context) {
                return true;
            }

            @Nonnull
            @Override
            public DropRule getDropRule(SlotContext context, DamageSource source, int lootingLevel, boolean recentlyHit) {
                return DropRule.DEFAULT;
            }
        });
    }

    public static ICapabilityProvider createFishingCharmProvider(ItemStack stack) {
        return CurioItemCapability.createProvider(new ICurio() {
            @Override
            public ItemStack getStack() {
                return stack;
            }

            @Override
            public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid) {
                Multimap<Attribute, AttributeModifier> attribute = LinkedHashMultimap.create();
                if (stack.is(ModTags.Items.COD_COIN_SET)) {
                    attribute.put(ModAttributes.COD_BONUS.get(),
                            new AttributeModifier(ModAttributes.COD_BONUS_MODIFIER_UUID,
                                    ModAttributes.COD_BONUS_MODIFIER_NAME, 1,
                                    AttributeModifier.Operation.ADDITION));
                    return attribute;
                }
                else if (stack.is(ModTags.Items.PUFFERFISH_COIN_SET)) {
                    attribute.put(ModAttributes.PUFFERFISH_BONUS.get(),
                            new AttributeModifier(ModAttributes.PUFFERFISH_BONUS_MODIFIER_UUID,
                                    ModAttributes.PUFFERFISH_BONUS_MODIFIER_NAME, 1,
                                    AttributeModifier.Operation.ADDITION));
                    return attribute;
                }
                else if (stack.is(ModTags.Items.SALMON_COIN_SET)) {
                    attribute.put(ModAttributes.SALMON_BONUS.get(),
                            new AttributeModifier(ModAttributes.SALMON_BONUS_MODIFIER_UUID,
                                    ModAttributes.SALMON_BONUS_MODIFIER_NAME, 1,
                                    AttributeModifier.Operation.ADDITION));
                    return attribute;
                }
                else if (stack.is(ModTags.Items.TROPICAL_FISH_COIN_SET)) {
                    attribute.put(ModAttributes.TROPICAL_FISH_BONUS.get(),
                            new AttributeModifier(ModAttributes.TROPICAL_FISH_BONUS_MODIFIER_UUID,
                                    ModAttributes.TROPICAL_FISH_BONUS_MODIFIER_NAME, 1,
                                    AttributeModifier.Operation.ADDITION));
                    return attribute;
                }
                return attribute;
            }

            @Nonnull
            @Override
            public SoundInfo getEquipSound(SlotContext context) {
                return new SoundInfo(SoundEvents.CHAIN_STEP, 1.0F, 2.0F);
            }

            @Override
            public void onEquip(SlotContext slotContext, ItemStack prevStack) {
                ICurio.super.onEquip(slotContext, prevStack);
                if (stack.is(ModTags.Items.COD_COIN_SET)) {
                    PlayerCodBonus.addBonus(1);
                }
                if (stack.is(ModTags.Items.PUFFERFISH_COIN_SET)) {
                    PlayerPufferfishBonus.addBonus(1);
                }
                if (stack.is(ModTags.Items.SALMON_COIN_SET)) {
                    PlayerSalmonBonus.addBonus(1);
                }
                if (stack.is(ModTags.Items.TROPICAL_FISH_COIN_SET)) {
                    PlayerTropicalFishBonus.addBonus(1);
                }
            }

            @Override
            public void onUnequip(SlotContext slotContext, ItemStack prevStack) {
                ICurio.super.onEquip(slotContext, prevStack);
                if (stack.is(ModTags.Items.COD_COIN_SET)) {
                    PlayerCodBonus.subtractBonus(1);
                }
                if (stack.is(ModTags.Items.PUFFERFISH_COIN_SET)) {
                    PlayerPufferfishBonus.subtractBonus(1);
                }
                if (stack.is(ModTags.Items.SALMON_COIN_SET)) {
                    PlayerSalmonBonus.subtractBonus(1);
                }
                if (stack.is(ModTags.Items.TROPICAL_FISH_COIN_SET)) {
                    PlayerTropicalFishBonus.subtractBonus(1);
                }
            }

            @Override
            public boolean canEquipFromUse(SlotContext context) {
                return true;
            }

            @Override
            public boolean canSync(SlotContext context) {
                return true;
            }

            @Nonnull
            @Override
            public DropRule getDropRule(SlotContext context, DamageSource source, int lootingLevel, boolean recentlyHit) {
                return DropRule.DEFAULT;
            }
        });
    }
}