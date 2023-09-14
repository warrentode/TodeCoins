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

public class PlayerCodProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    LivingEntity entity;
    public static Capability<PlayerCodBonus> PLAYER_COD_BONUS = CapabilityManager.get(new CapabilityToken<>() {
    });

    private PlayerCodBonus playerCodBonus = null;
    private final LazyOptional<PlayerCodBonus> optional = LazyOptional.of(this::createPlayerCodBonus);

    private PlayerCodBonus createPlayerCodBonus() {
        if (this.playerCodBonus == null) {
            this.playerCodBonus = new PlayerCodBonus(entity);
        }

        return this.playerCodBonus;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == PLAYER_COD_BONUS) {
            return optional.cast();
        }

        return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        createPlayerCodBonus().saveNBTData(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        createPlayerCodBonus().loadNBTData(nbt);
    }
}