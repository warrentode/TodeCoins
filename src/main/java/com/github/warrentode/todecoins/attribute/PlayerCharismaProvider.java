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

public class PlayerCharismaProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    LivingEntity entity;
    public static Capability<PlayerCharisma> PLAYER_CHARISMA = CapabilityManager.get(new CapabilityToken<>() {
    });

    private PlayerCharisma charisma = null;
    private final LazyOptional<PlayerCharisma> optional = LazyOptional.of(this::createPlayerCharisma);

    private PlayerCharisma createPlayerCharisma() {
        if (this.charisma == null) {
            this.charisma = new PlayerCharisma(entity);
        }

        return this.charisma;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == PLAYER_CHARISMA) {
            return optional.cast();
        }

        return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        createPlayerCharisma().saveNBTData(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        createPlayerCharisma().loadNBTData(nbt);
    }
}