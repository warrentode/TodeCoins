package com.github.warrentode.todecoins.integration;

import com.github.warrentode.todecoins.TodeCoins;
import com.github.warrentode.todecoins.attribute.*;
import com.github.warrentode.todecoins.item.custom.collectiblecoins.entity.*;
import com.github.warrentode.todecoins.item.custom.collectiblecoins.holiday.BirthdayCoinItem;
import com.github.warrentode.todecoins.item.custom.collectiblecoins.holiday.ChristmasCoinItem;
import com.github.warrentode.todecoins.item.custom.collectiblecoins.holiday.HalloweenCoinItem;
import com.github.warrentode.todecoins.item.custom.collectiblecoins.patron.PatronCommemorativeCoinItem;
import com.github.warrentode.todecoins.util.CalendarUtil;
import com.github.warrentode.todecoins.util.tags.ModTags;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
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
import net.minecraft.world.level.material.Fluids;
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
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

public class Curios {
    // TODO learn how custom enchantments work and how enchantments apply to Curio items in order to expand the variety
    // of equipped effects of these coins since it feels very repetitive to me right now
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

    public static ICapabilityProvider createCoinCharmProvider(ItemStack stack) {
        return CurioItemCapability.createProvider(new ICurio() {
            @Override
            public ItemStack getStack() {
                return stack;
            }

            @Override
            public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid) {
                Multimap<Attribute, AttributeModifier> attribute = LinkedHashMultimap.create();
                LivingEntity livingEntity = slotContext.entity();

                // CHR ASSIGNMENTS
                if (stack.is(ModTags.Items.HERO_COIN_SET)) {
                    attribute.put(ModAttributes.CHARISMA.get(),
                            new AttributeModifier(ModAttributes.CHR_MODIFIER_UUID, ModAttributes.CHR_MODIFIER_NAME, 4,
                                    AttributeModifier.Operation.ADDITION));
                    return attribute;
                }
                if (stack.is(ModTags.Items.GUARD_COIN_SET)) {
                    attribute.put(ModAttributes.CHARISMA.get(),
                            new AttributeModifier(ModAttributes.CHR_MODIFIER_UUID, ModAttributes.CHR_MODIFIER_NAME, 1,
                                    AttributeModifier.Operation.ADDITION));
                    return attribute;
                }
                if (stack.is(ModTags.Items.PATRON_COIN_SET)) {
                    attribute.put(ModAttributes.CHARISMA.get(),
                            new AttributeModifier(ModAttributes.CHR_MODIFIER_UUID, ModAttributes.CHR_MODIFIER_NAME, 8,
                                    AttributeModifier.Operation.ADDITION));
                    return attribute;
                }

                // FISHING BONUS ATTRIBUTE ASSIGNMENTS
                if (stack.is(ModTags.Items.COD_COIN_SET)) {
                    attribute.put(ModAttributes.COD_BONUS.get(),
                            new AttributeModifier(ModAttributes.COD_BONUS_MODIFIER_UUID,
                                    ModAttributes.COD_BONUS_MODIFIER_NAME, 1,
                                    AttributeModifier.Operation.ADDITION));
                    return attribute;
                }
                if (stack.is(ModTags.Items.PUFFERFISH_COIN_SET)) {
                    attribute.put(ModAttributes.PUFFERFISH_BONUS.get(),
                            new AttributeModifier(ModAttributes.PUFFERFISH_BONUS_MODIFIER_UUID,
                                    ModAttributes.PUFFERFISH_BONUS_MODIFIER_NAME, 1,
                                    AttributeModifier.Operation.ADDITION));
                    return attribute;
                }
                if (stack.is(ModTags.Items.SALMON_COIN_SET)) {
                    attribute.put(ModAttributes.SALMON_BONUS.get(),
                            new AttributeModifier(ModAttributes.SALMON_BONUS_MODIFIER_UUID,
                                    ModAttributes.SALMON_BONUS_MODIFIER_NAME, 1,
                                    AttributeModifier.Operation.ADDITION));
                    return attribute;
                }
                if (stack.is(ModTags.Items.TROPICAL_FISH_COIN_SET)) {
                    attribute.put(ModAttributes.TROPICAL_FISH_BONUS.get(),
                            new AttributeModifier(ModAttributes.TROPICAL_FISH_BONUS_MODIFIER_UUID,
                                    ModAttributes.TROPICAL_FISH_BONUS_MODIFIER_NAME, 1,
                                    AttributeModifier.Operation.ADDITION));
                    return attribute;
                }

                // GENERIC ARMOR ASSIGNMENTS
                if (stack.getItem() instanceof PiglinCoinItem || stack.is(ModTags.Items.GUARD_COIN_SET)) {
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
                    return attribute;
                }
                if (stack.is(ModTags.Items.ELDER_GUARDIAN_COIN_SET) || stack.is(ModTags.Items.WARDEN_COIN_SET)
                        || stack.is(ModTags.Items.WITHER_COIN_SET) || stack.is(ModTags.Items.ENDER_DRAGON_COIN_SET)
                        || stack.is(ModTags.Items.SHULKER_COIN_SET) || stack.is(ModTags.Items.WILDFIRE_COIN_SET)) {
                    int baseArmorBonus = 0;
                    int bossArmorBonus = 0;

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

                    if (stack.is(ModTags.Items.ELDER_GUARDIAN_COIN_SET) || stack.is(ModTags.Items.ENDER_DRAGON_COIN_SET)
                            || stack.is(ModTags.Items.WITHER_COIN_SET) || stack.is(ModTags.Items.WARDEN_COIN_SET)) {
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

                    attribute.put(Attributes.ARMOR,
                            new AttributeModifier(uuid, "generic.armor", (1 + baseArmorBonus) + bossArmorBonus,
                                    AttributeModifier.Operation.ADDITION));

                    return attribute;
                }

                // GENERIC ARMOR TOUGHNESS ASSIGNMENTS
                if (stack.getItem() instanceof UndeadCoinItem) {
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
                    return attribute;
                }

                // GENERIC MOVEMENT SPEED ASSIGNMENTS
                if (stack.is(ModTags.Items.ENDERMAN_COIN_SET)) {
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
                    return attribute;
                }
                if (stack.getItem() instanceof EquineCoinItem) {
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
                    return attribute;
                }
                if (stack.getItem() instanceof ArthropodCoinItem) {
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
                    return attribute;
                }

                // GENERIC MAX HEALTH ASSIGNMENTS
                if (stack.getItem() instanceof BovineCoinItem || stack.getItem() instanceof RodentCoinItem
                        || stack.getItem() instanceof GlareCoinItem) {
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
                    return attribute;
                }
                if (stack.is(ModTags.Items.ELDER_GUARDIAN_COIN_SET) || stack.is(ModTags.Items.ENDER_DRAGON_COIN_SET)
                        || stack.is(ModTags.Items.WITHER_COIN_SET) || stack.is(ModTags.Items.WARDEN_COIN_SET)
                        || stack.is(ModTags.Items.WILDFIRE_COIN_SET)) {
                    int bossHPBonus = 0;
                    if (stack.is(ModTags.Items.WARDEN_COIN_SET)) {
                        bossHPBonus = 500;
                    }
                    else if (stack.is(ModTags.Items.WITHER_COIN_SET)) {
                        bossHPBonus = 300;
                    }
                    else if (stack.is(ModTags.Items.ENDER_DRAGON_COIN_SET)) {
                        bossHPBonus = 200;
                    }
                    else if (stack.is(ModTags.Items.ENDER_DRAGON_COIN_SET)) {
                        bossHPBonus = 120;
                    }
                    else if (stack.is(ModTags.Items.ELDER_GUARDIAN_COIN_SET)) {
                        bossHPBonus = 80;
                    }

                    attribute.put(Attributes.MAX_HEALTH,
                            new AttributeModifier(uuid, "generic.max_health", bossHPBonus,
                                    AttributeModifier.Operation.ADDITION));

                    return attribute;
                }

                // GENERIC ATK KNOCKBACK ASSIGNMENTS
                if (stack.getItem() instanceof SwineCoinItem || stack.getItem() instanceof GolemCoinItem) {
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
                    return attribute;
                }

                // GENERIC ATK DMG ASSIGNMENTS
                if (stack.getItem() instanceof BearCoinItem || stack.getItem() instanceof IllagerCoinItem
                        || stack.getItem() instanceof MaulerCoinItem) {
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
                    return attribute;
                }
                if (stack.is(ModTags.Items.ELDER_GUARDIAN_COIN_SET) || stack.is(ModTags.Items.ENDER_DRAGON_COIN_SET)
                        || stack.is(ModTags.Items.WITHER_COIN_SET) || stack.is(ModTags.Items.WARDEN_COIN_SET)
                        || stack.is(ModTags.Items.WILDFIRE_COIN_SET)) {
                    int baseAttackBonus = 2;
                    int bossAttackBonus = 0;
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

                    attribute.put(Attributes.ATTACK_DAMAGE,
                            new AttributeModifier(uuid, "generic.attack_damage", (1 + baseAttackBonus) + bossAttackBonus,
                                    AttributeModifier.Operation.ADDITION));

                    return attribute;
                }

                // GENERIC KNOCKBACK RESIST ASSIGNMENTS
                if (stack.is(ModTags.Items.ELDER_GUARDIAN_COIN_SET) || stack.is(ModTags.Items.ENDER_DRAGON_COIN_SET)
                        || stack.is(ModTags.Items.WITHER_COIN_SET) || stack.is(ModTags.Items.WARDEN_COIN_SET)
                        || stack.is(ModTags.Items.WILDFIRE_COIN_SET)) {
                    int baseKnockbackResistanceBonus = 2;
                    int bossKnockBackResistanceBonus = 0;
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

                    attribute.put(Attributes.KNOCKBACK_RESISTANCE,
                            new AttributeModifier(uuid, "generic.knockback_resistance", (1 + baseKnockbackResistanceBonus) + bossKnockBackResistanceBonus,
                                    AttributeModifier.Operation.ADDITION));

                    return attribute;
                }

                return attribute;
            }

            @Override
            public void curioTick(SlotContext slotContext) {
                LivingEntity livingEntity = slotContext.entity();
                MinecraftServer server = livingEntity.getServer();
                ServerLevel level = server != null ? server.getLevel(livingEntity.level.dimension()) : null;
                RandomSource random = RandomSource.create();

                if (livingEntity != null && level != null) {
                    // HERO EFFECT
                    boolean hasHeroEffect = !Objects.equals(livingEntity.getEffect(MobEffects.HERO_OF_THE_VILLAGE), null);
                    // HALLOWEEN EVENT
                    if (stack.getItem() instanceof HalloweenCoinItem && ModList.get().isLoaded("sereneseasons")
                            && SereneSeasonsCompat.SeasonCompat.isHalloween(level)) {
                        if (!hasHeroEffect) {
                            livingEntity.addEffect(new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 6000, 0,
                                    false, false, true));

                            if (random.nextFloat() < 0.3f) {
                                stack.setDamageValue(stack.getDamageValue() + 1);
                            }
                        }
                    }
                    else if (stack.getItem() instanceof HalloweenCoinItem && CalendarUtil.Season.isHalloween()) {
                        if (!hasHeroEffect) {
                            livingEntity.addEffect(new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 6000, 0,
                                    false, false, true));

                            if (random.nextFloat() < 0.3f) {
                                stack.setDamageValue(stack.getDamageValue() + 1);
                            }
                        }
                    }
                    else if (stack.getItem() instanceof HalloweenCoinItem && ModList.get().isLoaded("sereneseasons")
                            && !SereneSeasonsCompat.SeasonCompat.isHalloween(level) && !CalendarUtil.Season.isHalloween()) {
                        livingEntity.removeEffect(MobEffects.HERO_OF_THE_VILLAGE);
                    }
                    // BIRTHDAY EVENT
                    if (stack.getItem() instanceof BirthdayCoinItem && ModList.get().isLoaded("sereneseasons")
                            && SereneSeasonsCompat.SeasonCompat.isBirthday(level)) {
                        if (!hasHeroEffect) {
                            livingEntity.addEffect(new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 6000, 0,
                                    false, false, true));

                            if (random.nextFloat() < 0.3f) {
                                stack.setDamageValue(stack.getDamageValue() + 1);
                            }
                        }
                    }
                    else if (stack.getItem() instanceof BirthdayCoinItem && CalendarUtil.Season.isBirthday()) {
                        if (!hasHeroEffect) {
                            livingEntity.addEffect(new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 6000, 0,
                                    false, false, true));

                            if (random.nextFloat() < 0.3f) {
                                stack.setDamageValue(stack.getDamageValue() + 1);
                            }
                        }
                    }
                    else if (stack.getItem() instanceof BirthdayCoinItem && ModList.get().isLoaded("sereneseasons")
                            && !SereneSeasonsCompat.SeasonCompat.isBirthday(level) && !CalendarUtil.Season.isBirthday()) {
                        livingEntity.removeEffect(MobEffects.HERO_OF_THE_VILLAGE);
                    }
                    // CHRISTMAS EVENT
                    if (stack.getItem() instanceof ChristmasCoinItem && ModList.get().isLoaded("sereneseasons")
                            && SereneSeasonsCompat.SeasonCompat.isChristmas(level)) {
                        if (!hasHeroEffect) {
                            livingEntity.addEffect(new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 6000, 0,
                                    false, false, true));

                            if (random.nextFloat() < 0.3f) {
                                stack.setDamageValue(stack.getDamageValue() + 1);
                            }
                        }
                    }
                    else if (stack.getItem() instanceof ChristmasCoinItem && CalendarUtil.Season.isChristmas()) {
                        if (!hasHeroEffect) {
                            livingEntity.addEffect(new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 6000, 0,
                                    false, false, true));

                            if (random.nextFloat() < 0.3f) {
                                stack.setDamageValue(stack.getDamageValue() + 1);
                            }
                        }
                    }
                    else if (stack.getItem() instanceof ChristmasCoinItem && ModList.get().isLoaded("sereneseasons")
                            && !SereneSeasonsCompat.SeasonCompat.isChristmas(level) && !CalendarUtil.Season.isChristmas()) {
                        livingEntity.removeEffect(MobEffects.HERO_OF_THE_VILLAGE);
                    }

                    // NIGHT VISION EFFECT
                    boolean hasNightVision = !Objects.equals(livingEntity.getEffect(MobEffects.NIGHT_VISION), null);
                    if (stack.is(ModTags.Items.BAT_COIN_SET) || stack.getItem() instanceof HalloweenCoinItem) {
                        if (!hasHeroEffect) {
                            livingEntity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 6000, 0,
                                    false, false, true));

                            if (random.nextFloat() < 0.3f) {
                                stack.setDamageValue(stack.getDamageValue() + 1);
                            }
                        }
                    }

                    // SLOW FALLING EFFECT
                    boolean hasSlowFalling = !Objects.equals(livingEntity.getEffect(MobEffects.SLOW_FALLING), null);
                    if (stack.getItem() instanceof FelineCoinItem) {
                        if (!hasSlowFalling) {
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
                            livingEntity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 6000, i,
                                    false, false, true));

                            if (random.nextFloat() < 0.3f) {
                                stack.setDamageValue(stack.getDamageValue() + 1);
                            }
                        }
                    }
                    if (stack.getItem() instanceof AerialCoinItem) {
                        if (!hasSlowFalling) {
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
                            livingEntity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 6000, i,
                                    false, false, true));

                            if (random.nextFloat() < 0.3f) {
                                stack.setDamageValue(stack.getDamageValue() + 1);
                            }
                        }
                    }

                    // REGEN EFFECT
                    boolean hasRegen = !Objects.equals(livingEntity.getEffect(MobEffects.REGENERATION), null);
                    if (stack.getItem() instanceof AmphibianCoinItem) {
                        if (!hasRegen) {
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
                            livingEntity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 6000, i,
                                    false, false, true));

                            if (random.nextFloat() < 0.3f) {
                                stack.setDamageValue(stack.getDamageValue() + 1);
                            }
                        }
                    }

                    // SATURATION EFFECT
                    boolean hasSaturation = !Objects.equals(livingEntity.getEffect(MobEffects.SATURATION), null);
                    if ((stack.getItem() instanceof CamelidCoinItem) || stack.getItem() instanceof SwineCoinItem
                            || stack.is(ModTags.Items.MAULER_COIN_SET)) {
                        if (!hasSaturation) {
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
                            livingEntity.addEffect(new MobEffectInstance(MobEffects.SATURATION, 6000, i,
                                    false, false, true));

                            if (random.nextFloat() < 0.3f) {
                                stack.setDamageValue(stack.getDamageValue() + 1);
                            }
                        }
                    }

                    // JUMP BOOST EFFECT
                    boolean hasJump = !Objects.equals(livingEntity.getEffect(MobEffects.JUMP), null);
                    if (stack.is(ModTags.Items.FROG_COIN_SET) || stack.is(ModTags.Items.RABBIT_COIN_SET)
                            || stack.is(ModTags.Items.GOAT_COIN_SET) || stack.getItem() instanceof CubeCoinItem) {
                        if (!hasJump) {
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
                            livingEntity.addEffect(new MobEffectInstance(MobEffects.JUMP, 6000, i,
                                    false, false, true));

                            if (random.nextFloat() < 0.3f) {
                                stack.setDamageValue(stack.getDamageValue() + 1);
                            }
                        }
                    }

                    // WATER BREATHING EFFECT
                    boolean hasWaterBreathing = !Objects.equals(livingEntity.getEffect(MobEffects.WATER_BREATHING), null);
                    if (stack.getItem() instanceof AquaticCoinItem || stack.is(ModTags.Items.AXOLOTL_COIN_SET)
                            || stack.is(ModTags.Items.CRAB_COIN_SET) || stack.is(ModTags.Items.TURTLE_COIN_SET)
                            || stack.is(ModTags.Items.TADPOLE_COIN_SET) || stack.is(ModTags.Items.DROWNED_COIN_SET)) {
                        if (!hasWaterBreathing) {
                            if (livingEntity.isEyeInFluidType(Fluids.WATER.getFluidType())) {
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
                                livingEntity.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 6000, i,
                                        false, false, true));

                                if (random.nextFloat() < 0.1f) {
                                    stack.setDamageValue(stack.getDamageValue() + 1);
                                }
                            }
                            else {
                                livingEntity.removeEffect(MobEffects.WATER_BREATHING);
                            }
                        }
                    }

                    // DOLPHIN'S GRACE EFFECT
                    boolean hasDolphinsGrace = !Objects.equals(livingEntity.getEffect(MobEffects.DOLPHINS_GRACE), null);
                    if (stack.is(ModTags.Items.DOLPHIN_COIN_SET)) {
                        if (!hasDolphinsGrace) {
                            if (livingEntity.isEyeInFluidType(Fluids.WATER.getFluidType())) {
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
                                livingEntity.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 6000, i,
                                        false, false, true));

                                if (random.nextFloat() < 0.1f) {
                                    stack.setDamageValue(stack.getDamageValue() + 1);
                                }
                            }
                            else {
                                livingEntity.removeEffect(MobEffects.DOLPHINS_GRACE);
                            }
                        }
                    }

                    // FIRE RESISTANCE EFFECT
                    boolean hasFireResistance = !Objects.equals(livingEntity.getEffect(MobEffects.FIRE_RESISTANCE), null);
                    if (stack.getItem() instanceof StriderCoinItem || stack.getItem() instanceof BlazeCoinItem
                            || stack.getItem() instanceof PiglinCoinItem || stack.is(ModTags.Items.MAGMA_CUBE_COIN_SET)
                            || stack.is(ModTags.Items.GHAST_COIN_SET)) {
                        if (!hasFireResistance) {
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
                            livingEntity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 6000, i,
                                    false, false, false));

                            if (random.nextFloat() < 0.3f) {
                                stack.setDamageValue(stack.getDamageValue() + 1);
                            }
                        }
                    }

                    // INVISIBILITY EFFECT
                    boolean hasInvisibility = !Objects.equals(livingEntity.getEffect(MobEffects.INVISIBILITY), null);
                    if ((stack.is(ModTags.Items.WANDERING_TRADER_COIN_SET) || stack.is(ModTags.Items.NUMISMATIST_COIN_SET))
                            && (livingEntity.level.getDayTime() >= 12000)) {
                        if (!hasInvisibility) {
                            livingEntity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 6000, 0,
                                    false, false, true));

                            if (random.nextFloat() < 0.3f) {
                                stack.setDamageValue(stack.getDamageValue() + 1);
                            }
                        }
                    }

                    // MOVEMENT SPEED EFFECT
                    boolean hasMoveSpeed = !Objects.equals(livingEntity.getEffect(MobEffects.MOVEMENT_SPEED), null);
                    if ((stack.is(ModTags.Items.VILLAGER_COIN_SET) || stack.is(ModTags.Items.GUARD_COIN_SET)
                            || stack.is(ModTags.Items.GLARE_COIN_SET)) && (livingEntity.level.getDayTime() >= 12000)) {
                        if (!hasMoveSpeed) {
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
                            livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 6000, i,
                                    false, false, false));

                            if (random.nextFloat() < 0.3f) {
                                stack.setDamageValue(stack.getDamageValue() + 1);
                            }
                        }
                    }

                    // DIG SPEED EFFECT
                    boolean hasDigSpeed = !Objects.equals(livingEntity.getEffect(MobEffects.DIG_SPEED), null);
                    if (stack.getItem() instanceof SnifferCoinItem) {
                        if (!hasDigSpeed) {
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
                            livingEntity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 6000, i,
                                    false, false, false));

                            if (random.nextFloat() < 0.3f) {
                                stack.setDamageValue(stack.getDamageValue() + 1);
                            }
                        }
                    }

                    // DAMAGE RESISTANCE EFFECT
                    boolean hasDamageResistance = !Objects.equals(livingEntity.getEffect(MobEffects.DAMAGE_RESISTANCE), null);
                    if (stack.is(ModTags.Items.GHAST_COIN_SET) || stack.getItem() instanceof CreeperCoinItem
                            || stack.getItem() instanceof ShulkerCoinItem) {
                        if (!hasDamageResistance) {
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

                            livingEntity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 6000, i,
                                    false, false, true));

                            if (random.nextFloat() < 0.3f) {
                                stack.setDamageValue(stack.getDamageValue() + 1);
                            }
                        }
                    }

                    // LEVITATE EFFECT
                    boolean hasLevitate = !Objects.equals(livingEntity.getEffect(MobEffects.LEVITATION), null);
                    if (stack.getItem() instanceof ShulkerCoinItem) {
                        if (!hasLevitate) {
                            livingEntity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 6000, 0,
                                    false, false, true));

                            if (random.nextFloat() < 0.2f) {
                                stack.setDamageValue(stack.getDamageValue() + 1);
                            }
                        }
                    }
                }

                ICurio.super.curioTick(slotContext);
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
                if (stack.is(ModTags.Items.PATRON_COIN_SET)) {
                    PlayerCharisma.addCharisma(8);
                }
                if (stack.is(ModTags.Items.GUARD_COIN_SET)) {
                    PlayerCharisma.addCharisma(1);
                }
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
                LivingEntity livingEntity = slotContext.entity();
                ICurio.super.onUnequip(slotContext, prevStack);
                if (stack.is(ModTags.Items.HERO_COIN_SET)) {
                    PlayerCharisma.subtractCharisma(4);
                }
                if (stack.is(ModTags.Items.PATRON_COIN_SET)) {
                    PlayerCharisma.subtractCharisma(8);
                }
                if (stack.is(ModTags.Items.GUARD_COIN_SET)) {
                    PlayerCharisma.subtractCharisma(1);
                }
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
                if (stack.is(ModTags.Items.HALLOWEEN_COIN_SET) || stack.is(ModTags.Items.CHRISTMAS_COIN_SET)
                        || stack.is(ModTags.Items.BIRTHDAY_COIN_SET)) {
                    livingEntity.removeEffect(MobEffects.HERO_OF_THE_VILLAGE);
                }
                if (stack.is(ModTags.Items.HALLOWEEN_COIN_SET) || stack.is(ModTags.Items.BAT_COIN_SET)) {
                    livingEntity.removeEffect(MobEffects.NIGHT_VISION);
                }
                if ((stack.getItem() instanceof FelineCoinItem) || (stack.getItem() instanceof AerialCoinItem)) {
                    livingEntity.removeEffect(MobEffects.SLOW_FALLING);
                }
                if (stack.getItem() instanceof AmphibianCoinItem) {
                    livingEntity.removeEffect(MobEffects.REGENERATION);
                }
                if ((stack.getItem() instanceof CamelidCoinItem) || stack.getItem() instanceof SwineCoinItem
                        || stack.is(ModTags.Items.MAULER_COIN_SET)) {
                    livingEntity.removeEffect(MobEffects.SATURATION);
                }
                if (stack.is(ModTags.Items.FROG_COIN_SET) || stack.is(ModTags.Items.RABBIT_COIN_SET)
                        || stack.is(ModTags.Items.GOAT_COIN_SET) || stack.getItem() instanceof CubeCoinItem) {
                    livingEntity.removeEffect(MobEffects.JUMP);
                }
                if (stack.getItem() instanceof AquaticCoinItem || stack.is(ModTags.Items.AXOLOTL_COIN_SET)
                        || stack.is(ModTags.Items.CRAB_COIN_SET) || stack.is(ModTags.Items.TURTLE_COIN_SET)
                        || stack.is(ModTags.Items.TADPOLE_COIN_SET) || stack.is(ModTags.Items.DROWNED_COIN_SET)) {
                    livingEntity.removeEffect(MobEffects.WATER_BREATHING);
                }
                if (stack.is(ModTags.Items.DOLPHIN_COIN_SET)) {
                    livingEntity.removeEffect(MobEffects.DOLPHINS_GRACE);
                }
                if (stack.getItem() instanceof StriderCoinItem || stack.getItem() instanceof BlazeCoinItem
                        || stack.getItem() instanceof PiglinCoinItem || stack.is(ModTags.Items.MAGMA_CUBE_COIN_SET)
                        || stack.is(ModTags.Items.GHAST_COIN_SET)) {
                    livingEntity.removeEffect(MobEffects.FIRE_RESISTANCE);
                }
                if (stack.is(ModTags.Items.WANDERING_TRADER_COIN_SET) || stack.is(ModTags.Items.NUMISMATIST_COIN_SET)) {
                    livingEntity.removeEffect(MobEffects.INVISIBILITY);
                }
                if (stack.is(ModTags.Items.VILLAGER_COIN_SET) || stack.is(ModTags.Items.GUARD_COIN_SET)
                        || stack.is(ModTags.Items.GLARE_COIN_SET)) {
                    livingEntity.removeEffect(MobEffects.MOVEMENT_SPEED);
                }
                if (stack.getItem() instanceof SnifferCoinItem) {
                    livingEntity.removeEffect(MobEffects.DIG_SPEED);
                }
                if (stack.is(ModTags.Items.GHAST_COIN_SET) || stack.getItem() instanceof CreeperCoinItem
                        || stack.getItem() instanceof ShulkerCoinItem) {
                    livingEntity.removeEffect(MobEffects.DAMAGE_RESISTANCE);
                }
            }

            @Override
            public void curioBreak(SlotContext slotContext) {
                if (stack.getDamageValue() == stack.getMaxDamage()) {
                    ICurio.super.curioBreak(slotContext);
                }
            }

            @Override
            public boolean makesPiglinsNeutral(SlotContext slotContext) {
                return stack.getItem() instanceof PiglinCoinItem || stack.getItem() instanceof PatronCommemorativeCoinItem;
            }

            @Override
            public boolean isEnderMask(SlotContext slotContext, EnderMan enderMan) {
                return stack.getItem() instanceof EndermanCoinItem || stack.getItem() instanceof PatronCommemorativeCoinItem;
            }

            @Override
            public boolean canWalkOnPowderedSnow(SlotContext slotContext) {
                return stack.getItem() instanceof RabbitCoinItem || stack.getItem() instanceof RodentCoinItem
                        || stack.is(ModTags.Items.FOX_COIN_SET) || stack.is(ModTags.Items.ENDERMITE_COIN_SET)
                        || stack.is(ModTags.Items.SILVERFISH_COIN_SET) || stack.is(ModTags.Items.SHULKER_COIN_SET)
                        || stack.getItem() instanceof AerialCoinItem || stack.is(ModTags.Items.PENGUIN_COIN_SET)
                        || stack.is(ModTags.Items.ICEOLOGER_COIN_SET);
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