package net.warrentode.todecoins.mixin;

import java.util.Map;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

/** Credits to Botania's dev team for the implementation **/
@Mixin(RecipeManager.class)
public interface RecipeMangerMixin {
    @Invoker("byType")
    <C extends Container, T extends Recipe<C>> Map<ResourceLocation, Recipe<C>> getRecipeMap(RecipeType<T> type);
}
