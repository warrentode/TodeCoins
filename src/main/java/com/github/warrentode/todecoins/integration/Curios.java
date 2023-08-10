package com.github.warrentode.todecoins.integration;

import com.github.warrentode.todecoins.TodeCoins;
import com.github.warrentode.todecoins.attribute.ModAttributes;
import com.github.warrentode.todecoins.attribute.PlayerCharisma;
import com.github.warrentode.todecoins.item.ModItems;
import com.github.warrentode.todecoins.util.CalendarUtil;
import com.github.warrentode.todecoins.util.tags.ModTags;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.client.Minecraft;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
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
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.SlotResult;
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

    /**
     * Gets the stack in the Charm Slot
     **/
    public static ItemStack getCharmSlot(Player player) {
        AtomicReference<ItemStack> charm = new AtomicReference<>(ItemStack.EMPTY);
        LazyOptional<ICuriosItemHandler> optional = CuriosApi.getCuriosHelper().getCuriosHandler(player);
        optional.ifPresent(itemHandler -> {
            Optional<ICurioStacksHandler> stacksOptional = itemHandler.getStacksHandler(SlotTypePreset.CHARM.getIdentifier());
            stacksOptional.ifPresent(stacksHandler -> {
                ItemStack stack = stacksHandler.getStacks().getStackInSlot(0);
                if (!stack.isEmpty()) {
                    charm.set(stack);
                }
            });
        });
        return charm.get();
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
                            new AttributeModifier(ModAttributes.CHR_MODIFIER_UUID, ModAttributes.CHR_MODIFIER_NAME, 1,
                                    AttributeModifier.Operation.ADDITION));
                    return attribute;
                }
                else if (stack.is(ModTags.Items.PATRON_COIN_SET)) {
                    attribute.put(ModAttributes.CHARISMA.get(),
                            new AttributeModifier(ModAttributes.CHR_MODIFIER_UUID, ModAttributes.CHR_MODIFIER_NAME, 5,
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
                    PlayerCharisma.addCharisma(1);
                }
                else if (stack.is(ModTags.Items.PATRON_COIN_SET)) {
                    PlayerCharisma.addCharisma(5);
                }
            }

            @Override
            public void onUnequip(SlotContext slotContext, ItemStack prevStack) {
                ICurio.super.onEquip(slotContext, prevStack);
                if (stack.is(ModTags.Items.HERO_COIN_SET)) {
                    PlayerCharisma.subtractCharisma(1);
                }
                else if (stack.is(ModTags.Items.PATRON_COIN_SET)) {
                    PlayerCharisma.subtractCharisma(5);
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
                if (stack.is(ModTags.Items.PIGLIN_COIN_SET)) {
                    attribute.put(Attributes.ARMOR,
                            new AttributeModifier(uuid, "generic.armor", 1,
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
                attribute.put(Attributes.MOVEMENT_SPEED,
                        new AttributeModifier(uuid, "generic.movement_speed", 0.05,
                                AttributeModifier.Operation.ADDITION));
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
                attribute.put(Attributes.MAX_HEALTH,
                        new AttributeModifier(uuid, "generic.max_health", 10,
                                AttributeModifier.Operation.ADDITION));
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
                attribute.put(Attributes.MOVEMENT_SPEED,
                        new AttributeModifier(uuid, "generic.movement_speed", 0.2,
                                AttributeModifier.Operation.ADDITION));
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
                attribute.put(Attributes.MOVEMENT_SPEED,
                        new AttributeModifier(uuid, "generic.movement_speed", 0.05,
                                AttributeModifier.Operation.ADDITION));
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
                Player player = Minecraft.getInstance().player;
                if ((stack.is(ModTags.Items.HALLOWEEN_COIN_SET) && CalendarUtil.Season.isHalloween()) || stack.is(ModTags.Items.BAT_COIN_SET)) {
                    if (player != null) {
                        player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 200, 0,
                                false, false, true));
                    }
                }
                else if (player != null && (stack.is(ModTags.Items.HALLOWEEN_COIN_SET) && !CalendarUtil.Season.isHalloween())) {
                    player.removeEffect(MobEffects.NIGHT_VISION);
                }
            }

            @Override
            public void onUnequip(SlotContext slotContext, ItemStack newStack) {
                Player player = Minecraft.getInstance().player;
                if (player != null && (stack.is(ModTags.Items.HALLOWEEN_COIN_SET) || stack.is(ModTags.Items.BAT_COIN_SET))) {
                    player.removeEffect(MobEffects.NIGHT_VISION);
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
                Player player = Minecraft.getInstance().player;
                if (stack.is(ModTags.Items.BIRTHDAY_COIN_SET) && CalendarUtil.Season.isBirthday()) {
                    if (player != null) {
                        player.addEffect(new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 200, 0,
                                false, false, false));
                    }
                }
                else if (stack.is(ModTags.Items.CHRISTMAS_COIN_SET) && CalendarUtil.Season.isChristmas()) {
                    if (player != null) {
                        player.addEffect(new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 200, 0,
                                false, false, false));
                    }
                }
                else if (player != null && (stack.is(ModTags.Items.BIRTHDAY_COIN_SET) && !CalendarUtil.Season.isBirthday())) {
                    player.removeEffect(MobEffects.HERO_OF_THE_VILLAGE);
                }
                else if (player != null && (stack.is(ModTags.Items.CHRISTMAS_COIN_SET) && !CalendarUtil.Season.isChristmas())) {
                    player.removeEffect(MobEffects.HERO_OF_THE_VILLAGE);
                }
            }

            @Override
            public void onUnequip(SlotContext slotContext, ItemStack newStack) {
                Player player = Minecraft.getInstance().player;
                if (player != null && (stack.is(ModTags.Items.BIRTHDAY_COIN_SET) || stack.is(ModTags.Items.CHRISTMAS_COIN_SET))) {
                    player.removeEffect(MobEffects.HERO_OF_THE_VILLAGE);
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
                Player player = Minecraft.getInstance().player;
                if (stack.is(ModTags.Items.ALLAY_COIN_SET) || stack.is(ModTags.Items.CHICKEN_COIN_SET) || stack.is(ModTags.Items.PARROT_COIN_SET)) {
                    if (player != null) {
                        player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 200, 0,
                                false, false, false));
                    }
                }
            }

            @Override
            public void onUnequip(SlotContext slotContext, ItemStack newStack) {
                Player player = Minecraft.getInstance().player;
                if (player != null && (stack.is(ModTags.Items.ALLAY_COIN_SET) || stack.is(ModTags.Items.CHICKEN_COIN_SET) || stack.is(ModTags.Items.PARROT_COIN_SET))) {
                    player.removeEffect(MobEffects.SLOW_FALLING);
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
                Player player = Minecraft.getInstance().player;
                if (stack.is(ModTags.Items.AXOLOTL_COIN_SET)) {
                    if (player != null) {
                        player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 200, 0,
                                false, false, false));
                    }
                }
            }

            @Override
            public void onUnequip(SlotContext slotContext, ItemStack newStack) {
                Player player = Minecraft.getInstance().player;
                if (player != null && stack.is(ModTags.Items.AXOLOTL_COIN_SET)) {
                    player.removeEffect(MobEffects.REGENERATION);
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
                Player player = Minecraft.getInstance().player;
                if (stack.is(ModTags.Items.CAMEL_COIN_SET) || stack.is(ModTags.Items.PIG_COIN_SET)) {
                    if (player != null) {
                        player.addEffect(new MobEffectInstance(MobEffects.SATURATION, 200, 3,
                                false, false, false));
                    }
                }
            }

            @Override
            public void onUnequip(SlotContext slotContext, ItemStack newStack) {
                Player player = Minecraft.getInstance().player;
                if (player != null && (stack.is(ModTags.Items.CAMEL_COIN_SET) || stack.is(ModTags.Items.PIG_COIN_SET))) {
                    player.removeEffect(MobEffects.SATURATION);
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

    public static ICapabilityProvider createCatDisguiseCharmProvider(ItemStack stack) {
        return CurioItemCapability.createProvider(new ICurio() {
            @Override
            public ItemStack getStack() {
                return stack;
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
                return true;
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

    public static ICapabilityProvider createPoisonAttackCharmProvider(ItemStack stack) {
        return CurioItemCapability.createProvider(new ICurio() {
            @Override
            public ItemStack getStack() {
                return stack;
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

    public static ICapabilityProvider createFireAspectCharmProvider(ItemStack stack) {
        return CurioItemCapability.createProvider(new ICurio() {
            @Override
            public ItemStack getStack() {
                return stack;
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

    public static ICapabilityProvider createJumpBoostCharmProvider(ItemStack stack) {
        return CurioItemCapability.createProvider(new ICurio() {
            @Override
            public ItemStack getStack() {
                return stack;
            }

            @Override
            public void curioTick(SlotContext slotContext) {
                Player player = Minecraft.getInstance().player;
                if (stack.is(ModTags.Items.FROG_COIN_SET) || stack.is(ModTags.Items.RABBIT_COIN_SET) || stack.is(ModTags.Items.GOAT_COIN_SET)) {
                    if (player != null) {
                        player.addEffect(new MobEffectInstance(MobEffects.JUMP, 200, 0,
                                false, false, true));
                    }
                }
            }

            @Override
            public void onUnequip(SlotContext slotContext, ItemStack newStack) {
                Player player = Minecraft.getInstance().player;
                if (player != null && (stack.is(ModTags.Items.FROG_COIN_SET) || stack.is(ModTags.Items.RABBIT_COIN_SET) || stack.is(ModTags.Items.GOAT_COIN_SET))) {
                    player.removeEffect(MobEffects.JUMP);
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

    public static ICapabilityProvider createFishCharmProvider(ItemStack stack) {
        return CurioItemCapability.createProvider(new ICurio() {
            @Override
            public ItemStack getStack() {
                return stack;
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

    public static Boolean matchCodFishCharm(ItemStack isCodFishCharm) {
        Player player = Minecraft.getInstance().player;
        ItemStack stack = ItemStack.EMPTY;
        if (player != null) {
            Optional<SlotResult> optional = CuriosApi.getCuriosHelper().findFirstCurio(player, isCodFishCharm.getItem());
            return (isCodFishCharm.getItem() == ModItems.COPPER_COD_COIN.get()) || (isCodFishCharm.getItem() == ModItems.IRON_COD_COIN.get())
                   || (isCodFishCharm.getItem() == ModItems.GOLD_COD_COIN.get()) || (isCodFishCharm.getItem() == ModItems.NETHERITE_COD_COIN.get());
        }
        return false;
    }

    public static Boolean matchSalmonFishCharm(ItemStack isSalmonFishCharm) {
        Player player = Minecraft.getInstance().player;
        ItemStack stack = ItemStack.EMPTY;
        if (player != null) {
            Optional<SlotResult> optional = CuriosApi.getCuriosHelper().findFirstCurio(player, isSalmonFishCharm.getItem());
            return (isSalmonFishCharm.getItem() == ModItems.COPPER_SALMON_COIN.get()) || (isSalmonFishCharm.getItem() == ModItems.IRON_SALMON_COIN.get())
                   || (isSalmonFishCharm.getItem() == ModItems.GOLD_SALMON_COIN.get()) || (isSalmonFishCharm.getItem() == ModItems.NETHERITE_SALMON_COIN.get());
        }
        return false;
    }

    public static Boolean matchPufferfishCharm(ItemStack isPufferfishCharm) {
        Player player = Minecraft.getInstance().player;
        ItemStack stack = ItemStack.EMPTY;
        if (player != null) {
            Optional<SlotResult> optional = CuriosApi.getCuriosHelper().findFirstCurio(player, isPufferfishCharm.getItem());
            return (isPufferfishCharm.getItem() == ModItems.COPPER_PUFFERFISH_COIN.get()) || (isPufferfishCharm.getItem() == ModItems.IRON_PUFFERFISH_COIN.get())
                   || (isPufferfishCharm.getItem() == ModItems.GOLD_PUFFERFISH_COIN.get()) || (isPufferfishCharm.getItem() == ModItems.NETHERITE_PUFFERFISH_COIN.get());
        }
        return false;
    }

    public static Boolean matchTropicalFishCharm(ItemStack isTropicalFishCharm) {
        Player player = Minecraft.getInstance().player;
        ItemStack stack = ItemStack.EMPTY;
        if (player != null) {
            Optional<SlotResult> optional = CuriosApi.getCuriosHelper().findFirstCurio(player, isTropicalFishCharm.getItem());
            return (isTropicalFishCharm.getItem() == ModItems.COPPER_TROPICAL_FISH_COIN.get()) || (isTropicalFishCharm.getItem() == ModItems.IRON_TROPICAL_FISH_COIN.get())
                    || (isTropicalFishCharm.getItem() == ModItems.GOLD_TROPICAL_FISH_COIN.get()) || (isTropicalFishCharm.getItem() == ModItems.NETHERITE_TROPICAL_FISH_COIN.get());
        }
        return false;
    }

    public static ICapabilityProvider createWaterBreathingCharmProvider(ItemStack stack) {
        return CurioItemCapability.createProvider(new ICurio() {
            @Override
            public ItemStack getStack() {
                return stack;
            }

            @SuppressWarnings("deprecation")
            @Override
            public void curioTick(SlotContext slotContext) {
                Player player = Minecraft.getInstance().player;
                if ((stack.is(ModTags.Items.SQUID_COIN_SET) || stack.is(ModTags.Items.GLOW_SQUID_COIN_SET)
                     || stack.is(ModTags.Items.TURTLE_COIN_SET) || stack.is(ModTags.Items.TADPOLE_COIN_SET)
                     || stack.is(ModTags.Items.GUARDIAN_COIN_SET) || stack.is(ModTags.Items.ELDER_GUARDIAN_COIN_SET))
                    && player != null) {
                    if (player.isEyeInFluid(FluidTags.WATER)) {
                        player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 200, 0,
                                false, false, true));
                    }
                    else if (!player.isEyeInFluid(FluidTags.WATER)) {
                        player.removeEffect(MobEffects.WATER_BREATHING);
                    }
                }
            }

            @Override
            public void onUnequip(SlotContext slotContext, ItemStack newStack) {
                Player player = Minecraft.getInstance().player;
                if ((stack.is(ModTags.Items.SQUID_COIN_SET) || stack.is(ModTags.Items.GLOW_SQUID_COIN_SET)
                     || stack.is(ModTags.Items.TURTLE_COIN_SET) || stack.is(ModTags.Items.TADPOLE_COIN_SET)
                     || stack.is(ModTags.Items.GUARDIAN_COIN_SET) || stack.is(ModTags.Items.ELDER_GUARDIAN_COIN_SET))
                    && player != null) {
                    player.removeEffect(MobEffects.WATER_BREATHING);
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
                attribute.put(Attributes.ATTACK_KNOCKBACK,
                        new AttributeModifier(uuid, "generic.attack_knockback", 1,
                                AttributeModifier.Operation.ADDITION));
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
                Player player = Minecraft.getInstance().player;
                if (stack.is(ModTags.Items.STRIDER_COIN_SET) || stack.is(ModTags.Items.BLAZE_COIN_SET)
                        || stack.is(ModTags.Items.MAGMA_CUBE_COIN_SET)) {
                    if (player != null) {
                        player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200, 0,
                                false, false, true));
                    }
                }
            }

            @Override
            public void onUnequip(SlotContext slotContext, ItemStack newStack) {
                Player player = Minecraft.getInstance().player;
                if (player != null && (stack.is(ModTags.Items.STRIDER_COIN_SET) || stack.is(ModTags.Items.BLAZE_COIN_SET)
                        || stack.is(ModTags.Items.MAGMA_CUBE_COIN_SET))) {
                    player.removeEffect(MobEffects.FIRE_RESISTANCE);
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

    public static ICapabilityProvider createNightTimeInvisibilityCharmProvider(ItemStack stack) {
        return CurioItemCapability.createProvider(new ICurio() {
            @Override
            public ItemStack getStack() {
                return stack;
            }

            @Override
            public void curioTick(SlotContext slotContext) {
                Player player = Minecraft.getInstance().player;
                if (player != null && (stack.is(ModTags.Items.WANDERING_TRADER_COIN_SET) || stack.is(ModTags.Items.NUMISMATIST_COIN_SET)) && (player.level.getDayTime() >= 12000)) {
                    player.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 200, 0,
                            false, false, true));
                }
                else if (player != null && (stack.is(ModTags.Items.WANDERING_TRADER_COIN_SET) || stack.is(ModTags.Items.NUMISMATIST_COIN_SET)) && (player.level.getDayTime() < 12000)) {
                    player.removeEffect(MobEffects.INVISIBILITY);
                }
            }

            @Override
            public void onUnequip(SlotContext slotContext, ItemStack newStack) {
                Player player = Minecraft.getInstance().player;
                if (player != null && (stack.is(ModTags.Items.WANDERING_TRADER_COIN_SET) || stack.is(ModTags.Items.NUMISMATIST_COIN_SET))) {
                    player.removeEffect(MobEffects.INVISIBILITY);
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

    public static ICapabilityProvider createNightTimeSpeedCharmProvider(ItemStack stack) {
        return CurioItemCapability.createProvider(new ICurio() {
            @Override
            public ItemStack getStack() {
                return stack;
            }

            @Override
            public void curioTick(SlotContext slotContext) {
                Player player = Minecraft.getInstance().player;
                if (player != null && stack.is(ModTags.Items.VILLAGER_COIN_SET) && (player.level.getDayTime() >= 12000)) {
                    player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 0,
                            false, false, true));
                } else if (player != null && stack.is(ModTags.Items.VILLAGER_COIN_SET) && (player.level.getDayTime() < 12000)) {
                    player.removeEffect(MobEffects.MOVEMENT_SPEED);
                }
            }

            @Override
            public void onUnequip(SlotContext slotContext, ItemStack newStack) {
                Player player = Minecraft.getInstance().player;
                if (player != null && stack.is(ModTags.Items.VILLAGER_COIN_SET)) {
                    player.removeEffect(MobEffects.MOVEMENT_SPEED);
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
                Player player = Minecraft.getInstance().player;
                if (stack.is(ModTags.Items.SNIFFER_COIN_SET)) {
                    if (player != null) {
                        player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 200, 0,
                                false, false, true));
                    }
                }
            }

            @Override
            public void onUnequip(SlotContext slotContext, ItemStack newStack) {
                Player player = Minecraft.getInstance().player;
                if (player != null && stack.is(ModTags.Items.SNIFFER_COIN_SET)) {
                    player.removeEffect(MobEffects.DIG_SPEED);
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

    public static ICapabilityProvider createDolphinGraceCharmProvider(ItemStack stack) {
        return CurioItemCapability.createProvider(new ICurio() {
            @Override
            public ItemStack getStack() {
                return stack;
            }

            @SuppressWarnings("deprecation")
            @Override
            public void curioTick(SlotContext slotContext) {
                Player player = Minecraft.getInstance().player;
                if (stack.is(ModTags.Items.DOLPHIN_COIN_SET)) {
                    if (player != null) {
                        player.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 200, 0,
                                false, false, true));
                        if (player.isEyeInFluid(FluidTags.WATER)) {
                            player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 200, 0,
                                    false, false, true));
                        }
                        else if (!player.isEyeInFluid(FluidTags.WATER)) {
                            player.removeEffect(MobEffects.WATER_BREATHING);
                        }
                    }
                }
            }

            @Override
            public void onUnequip(SlotContext slotContext, ItemStack newStack) {
                Player player = Minecraft.getInstance().player;
                if (player != null && stack.is(ModTags.Items.DOLPHIN_COIN_SET)) {
                    player.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 200, 0,
                            false, false, true));
                    player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 200, 0,
                            false, false, true));
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

    public static ICapabilityProvider createSlownessAttackCharmProvider(ItemStack stack) {
        return CurioItemCapability.createProvider(new ICurio() {
            @Override
            public ItemStack getStack() {
                return stack;
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

    public static ICapabilityProvider createAttackStrengthCharmProvider(ItemStack stack) {
        return CurioItemCapability.createProvider(new ICurio() {
            @Override
            public ItemStack getStack() {
                return stack;
            }

            @Override
            public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid) {
                Multimap<Attribute, AttributeModifier> attribute = LinkedHashMultimap.create();
                attribute.put(Attributes.ATTACK_DAMAGE,
                        new AttributeModifier(uuid, "generic.attack_damage", 1,
                                AttributeModifier.Operation.ADDITION));
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

    public static ICapabilityProvider createMobHeadCharmProvider(ItemStack stack) {
        return CurioItemCapability.createProvider(new ICurio() {
            @Override
            public ItemStack getStack() {
                return stack;
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
}