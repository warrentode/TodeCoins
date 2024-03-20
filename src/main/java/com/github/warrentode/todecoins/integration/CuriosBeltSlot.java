package com.github.warrentode.todecoins.integration;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.Nullable;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.SlotTypePreset;
import top.theillusivec4.curios.api.type.capability.ICurio;
import top.theillusivec4.curios.api.type.capability.ICuriosItemHandler;
import top.theillusivec4.curios.api.type.inventory.ICurioStacksHandler;
import top.theillusivec4.curios.common.capability.CurioItemCapability;

import javax.annotation.Nonnull;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

public class CuriosBeltSlot {
    // yes, I'm leaving this to-do list here for now
    // [LittleBear suggestions:]
    // TODO look into how bone meal works and how that can be altered for the bee coin
    // TODO look into adding Loyalty effect for the Drowned coin
    // TODO look into adding Frost Walker effect for Iceologer, Stray, Snow Golem coins
    // TODO can the splash potion radius be changed for the Witch coin?
    // TODO the Sniffer coin influence what you find while digging?
    // [ScholarOwl suggestions:]
    // TODO look into giving Elder Guardian coin Depth Strider and Thorns
    // TODO look into increase buff duration for Witch coin
    // (or at least maybe look into how to remove debuffs with a coin - like the cow coin)

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

    @Nullable
    public ICapabilityProvider initCapabilities(ItemStack stack) {
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