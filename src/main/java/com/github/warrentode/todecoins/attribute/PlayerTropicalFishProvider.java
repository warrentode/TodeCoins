package com.github.warrentode.todecoins.attribute;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PlayerTropicalFishProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    LivingEntity entity;
    public static Capability<PlayerTropicalFishBonus> PLAYER_TROPICAL_FISH_BONUS = CapabilityManager.get(new CapabilityToken<>() {
    });

    private PlayerTropicalFishBonus playerTropicalFishBonus = null;
    private final LazyOptional<PlayerTropicalFishBonus> optional = LazyOptional.of(this::createPlayerTropicalFishBonus);

    private PlayerTropicalFishBonus createPlayerTropicalFishBonus() {
        if (this.playerTropicalFishBonus == null) {
            this.playerTropicalFishBonus = new PlayerTropicalFishBonus(entity);
        }

        return this.playerTropicalFishBonus;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == PLAYER_TROPICAL_FISH_BONUS) {
            return optional.cast();
        }

        return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        createPlayerTropicalFishBonus().saveNBTData(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        createPlayerTropicalFishBonus().loadNBTData(nbt);
    }
}