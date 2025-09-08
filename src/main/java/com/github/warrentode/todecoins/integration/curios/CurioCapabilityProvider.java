package com.github.warrentode.todecoins.integration.curios;

import com.github.warrentode.todecoins.item.TCItems;
import com.github.warrentode.todecoins.item.custom.collectible.CollectibleCoinItem;
import com.github.warrentode.todecoins.item.custom.collectible.CollectibleCoinMaterial;
import com.github.warrentode.todecoins.item.custom.collectible.CollectibleCoinSetDefinitions;
import com.github.warrentode.todecoins.util.tags.TCItemTags;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurio;

import javax.annotation.Nonnull;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

public class CurioCapabilityProvider {

    /**
     * Attach this provider to an ItemStack to optionally enable Curios capabilities.
     */

    @Nullable
    public static ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundTag ignoredNbt) {
        if (!ModList.get().isLoaded("curios")) {
            // stops the provider from doing anything if curios isn't loaded
            return null;
        }

        return CuriosApi.createCurioProvider(new ICurio() {
            @Override
            public ItemStack getStack() {
                // calls the stack in curios slot for checking
                return stack;
            }

            @Override
            public void curioTick(SlotContext context) {
                // nothing going on here yet
            }

            @Nonnull
            @Override
            public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext context, UUID uuid) {
                Multimap<Attribute, AttributeModifier> modifiers = LinkedHashMultimap.create();
                Item item = stack.getItem();

                // Check if it's the Lucky Coin first
                if (item == TCItems.LUCKY_COIN.get()) {
                    uuid = getStableUUID(item, Attributes.LUCK);
                    modifiers.put(Attributes.LUCK, new AttributeModifier(
                            uuid, "coin_lucky_modifier", 1.0,
                            AttributeModifier.Operation.ADDITION
                    ));
                    return modifiers;
                }

                // Otherwise, handle collectible coins by material
                if (item instanceof CollectibleCoinItem coinItem) {
                    // ---- Material attribute ----
                    CollectibleCoinMaterial material = coinItem.getMaterial();
                    modifiers.put(material.getMaterialAttribute(), coinAttributeModifier(stack, material));

                    // ---- Set attribute ----
                    CollectibleCoinSetDefinitions setDefinition = coinItem.getCoinSet();
                    if (setDefinition != null && setDefinition.getSetAttribute() != null) {
                        modifiers.put(setDefinition.getSetAttribute(), coinSetAttributeModifier(stack, setDefinition));
                    }
                }

                // add checks for anything else we might decide to add curio capabilities to

                return modifiers;
            }

            @Override
            public int getFortuneLevel(SlotContext context, @Nullable LootContext lootContext) {
                // Adjust per coin if desired
                if (stack.is(TCItems.LUCKY_COIN.get())) {
                    return 1;
                }
                return 0;
            }

            @Override
            public int getLootingLevel(SlotContext context, DamageSource source, LivingEntity target, int baseLooting) {
                // Adjust per coin if desired
                if (stack.is(TCItems.LUCKY_COIN.get())) {
                    return 1;
                }
                return 0;
            }

            @Override
            public boolean makesPiglinsNeutral(SlotContext context) {
                // Adjust per coin if desired
                return stack.is(TCItemTags.PIGLIN_COINS_PIGLIN_TAG)
                        || stack.is(TCItemTags.PIGLIN_COINS_PIGLIN_MERCHANT_TAG)
                        || stack.is(TCItemTags.PIGLIN_COINS_PIGLIN_BRUTE_TAG);
            }

            @Override
            public boolean isEnderMask(SlotContext context, EnderMan enderMan) {
                // Adjust per coin if desired
                return stack.is(TCItemTags.MISC_COINS_ENDERMAN_TAG)
                        || stack.is(TCItemTags.ARTHROPOD_COINS_ENDERMITE_TAG);
            }

            @Nonnull
            @Override
            public SoundInfo getEquipSound(SlotContext context) {
                if (stack.is(TCItemTags.FRIENDSHIP_BRACELETS)) {
                    return new SoundInfo(SoundEvents.AMETHYST_BLOCK_RESONATE, 1.0F, 1.5F);
                }
                else if (stack.is(TCItems.LUCKY_COIN.get()) || stack.is(TCItemTags.COLLECTIBLE_COINS_TAG)) {
                    return new SoundInfo(SoundEvents.CHAIN_STEP, 1.0F, 1.5F);
                }
                return new SoundInfo(SoundEvents.ARMOR_EQUIP_GENERIC, 1.0F, 1.5F);
            }

            @Override
            public boolean canEquip(SlotContext context) {

                if (stack.is(TCItemTags.FRIENDSHIP_BRACELETS)) {
                    if (!(context.entity() instanceof Player player)) return false;

                    // Deny equipping if the player already has a bracelet
                    for (ItemStack equippedStack : CuriosHelper.getEquippedBracelets(player)) {
                        if (!equippedStack.isEmpty()) {
                            return false;
                        }
                    }
                }
                if (stack.is(TCItemTags.WALLETS)) {
                    if (!(context.entity() instanceof Player player)) return false;

                    // Deny equipping if the player already has a bracelet
                    for (ItemStack equippedStack : CuriosHelper.getEquippedWallets(player)) {
                        if (!equippedStack.isEmpty()) {
                            return false;
                        }
                    }
                }

                // allow everything else
                return true;
            }

            @Override
            public void onEquip(SlotContext context, ItemStack prevStack) {
                ICurio.super.onEquip(context, prevStack);
            }

            @Override
            public void onUnequip(SlotContext context, ItemStack prevStack) {
                ICurio.super.onUnequip(context, prevStack);
            }

            @Override
            public boolean canEquipFromUse(SlotContext context) {
                // false to prevent problems with hand use of the items
                return false;
            }

            @Override
            public boolean canSync(SlotContext context) {
                return true;
            }

            @Nonnull
            @Override
            public DropRule getDropRule(SlotContext context, net.minecraft.world.damagesource.DamageSource source, int lootingLevel, boolean recentlyHit) {
                return DropRule.DEFAULT;
            }

            @Override
            public List<Component> getSlotsTooltip(List<Component> tooltips) {
                // applied attributes from an equipped curio is auto tooltipped
                return ICurio.super.getSlotsTooltip(tooltips);
            }
        });
    }

    private static @NotNull UUID getStableUUID(@NotNull Item coinItem, @NotNull Attribute attribute) {
        String key = "coin_attr_" + ForgeRegistries.ITEMS.getKey(coinItem) + "_" + attribute.getDescriptionId();
        return UUID.nameUUIDFromBytes(key.getBytes(StandardCharsets.UTF_8));
    }

    private static @NotNull AttributeModifier coinAttributeModifier(@NotNull ItemStack stack, @NotNull CollectibleCoinMaterial material) {
        UUID uuid = getStableUUID(stack.getItem(), material.getMaterialAttribute());
        return new AttributeModifier(
                uuid, "coin_" + material.name().toLowerCase(Locale.ROOT) + "_modifier",
                material.getAttributeValue(),
                AttributeModifier.Operation.ADDITION
        );
    }

    private static @NotNull AttributeModifier coinSetAttributeModifier(@NotNull ItemStack stack, @NotNull CollectibleCoinSetDefinitions setDefinition) {
        UUID uuid = getStableUUID(stack.getItem(), setDefinition.getSetAttribute());
        return new AttributeModifier(
                uuid, "coinset_" + setDefinition.name().toLowerCase(Locale.ROOT) + "_modifier",
                setDefinition.getSetAttributeValue(),
                AttributeModifier.Operation.ADDITION
        );
    }
}