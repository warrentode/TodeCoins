package com.github.warrentode.todecoins.util;

import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.Item;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class ModUtil {
    // fetches registry key based on its location
    public static MobEffect getEffect(String effectID) {
        ResourceLocation effectLocation = ResourceLocation.parse(effectID);
        return ForgeRegistries.MOB_EFFECTS.getValue(effectLocation);
    }

    // fetches registry key base on its location
    public static Item getItem(String item) {
        ResourceLocation itemLocation = ResourceLocation.parse(item);
        return ForgeRegistries.ITEMS.getValue(itemLocation);
    }

    // ========== Block Shape Utilities ==========
    public static void runCalculation(Map<Direction, VoxelShape> shapes, VoxelShape shape) {
        for (Direction direction : Direction.values()) {
            shapes.put(direction, calculateShapes(direction, shape));
        }
    }

    public static VoxelShape calculateShapes(@NotNull Direction to, VoxelShape shape) {
        final VoxelShape[] buffer = {shape, Shapes.empty()};

        final int times = (to.get2DDataValue() - Direction.NORTH.get2DDataValue() + 4) % 4;
        for (int i = 0; i < times; i++) {
            buffer[0].forAllBoxes((minX, minY, minZ, maxX, maxY, maxZ) -> buffer[1] = Shapes.or(buffer[1],
                    Shapes.create(1 - maxZ, minY, minX, 1 - minZ, maxY, maxX)));
            buffer[0] = buffer[1];
            buffer[1] = Shapes.empty();
        }

        return buffer[0];
    }
}