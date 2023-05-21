package net.warrentode.todecoins.integration;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.warrentode.todecoins.attribute.ModAttributes;
import net.warrentode.todecoins.attribute.PlayerCharisma;
import net.warrentode.todecoins.item.ModItems;
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

import static net.warrentode.todecoins.TodeCoins.MODID;
import static net.warrentode.todecoins.attribute.ModAttributes.CHR_MODIFIER_NAME;
import static net.warrentode.todecoins.attribute.ModAttributes.CHR_MODIFIER_UUID;

public class Curios {
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
                        new AttributeModifier(uuid, MODID + ":luck_bonus", 1,
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

    public static ICapabilityProvider createHeroCoinCharmProvider(ItemStack stack) {
        return CurioItemCapability.createProvider(new ICurio() {
            @Override
            public ItemStack getStack() {
                return stack;
            }

            @Override
            public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid) {
                Multimap<Attribute, AttributeModifier> attribute = LinkedHashMultimap.create();
                if (stack.is(ModItems.COPPER_HERO_COIN.get())) {
                    attribute.put(ModAttributes.CHARISMA.get(),
                            new AttributeModifier(CHR_MODIFIER_UUID, CHR_MODIFIER_NAME, 1,
                                    AttributeModifier.Operation.ADDITION));
                    return attribute;
                }
                else if (stack.is(ModItems.IRON_HERO_COIN.get())) {
                    attribute.put(ModAttributes.CHARISMA.get(),
                            new AttributeModifier(CHR_MODIFIER_UUID, CHR_MODIFIER_NAME, 2,
                                    AttributeModifier.Operation.ADDITION));
                    return attribute;
                }
                else if (stack.is(ModItems.GOLD_HERO_COIN.get())) {
                    attribute.put(ModAttributes.CHARISMA.get(),
                            new AttributeModifier(CHR_MODIFIER_UUID, CHR_MODIFIER_NAME, 3,
                                    AttributeModifier.Operation.ADDITION));
                    return attribute;
                }
                else if (stack.is(ModItems.NETHERITE_HERO_COIN.get())) {
                    attribute.put(ModAttributes.CHARISMA.get(),
                            new AttributeModifier(CHR_MODIFIER_UUID, CHR_MODIFIER_NAME, 4,
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
                if (stack.is(ModItems.COPPER_HERO_COIN.get())) {
                    PlayerCharisma.addCharisma(1);
                }
                else if (stack.is(ModItems.IRON_HERO_COIN.get())) {
                    PlayerCharisma.addCharisma(2);
                }
                else if (stack.is(ModItems.GOLD_HERO_COIN.get())) {
                    PlayerCharisma.addCharisma(3);
                }
                else if (stack.is(ModItems.NETHERITE_HERO_COIN.get())) {
                    PlayerCharisma.addCharisma(4);
                }
            }

            @Override
            public void onUnequip(SlotContext slotContext, ItemStack prevStack) {
                ICurio.super.onEquip(slotContext, prevStack);
                if (stack.is(ModItems.COPPER_HERO_COIN.get())) {
                    PlayerCharisma.subtractCharisma(1);
                }
                else if (stack.is(ModItems.IRON_HERO_COIN.get())) {
                    PlayerCharisma.subtractCharisma(2);
                }
                else if (stack.is(ModItems.GOLD_HERO_COIN.get())) {
                    PlayerCharisma.subtractCharisma(3);
                }
                else if (stack.is(ModItems.NETHERITE_HERO_COIN.get())) {
                    PlayerCharisma.subtractCharisma(4);
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

    public static ICapabilityProvider createWalletBeltProvider(ItemStack stack) {
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
}