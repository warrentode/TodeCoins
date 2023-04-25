package net.warrentode.todecoins.screen.coinpressgui;

import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import net.minecraft.client.ClientRecipeBook;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.recipebook.RecipeBookComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;

import static net.warrentode.todecoins.TodeCoins.MODID;

@ParametersAreNonnullByDefault
public class CoinPressRecipeBookComponent extends RecipeBookComponent {
    public int width;
    public int height;
    protected CoinPressMenu menu;
    public boolean widthTooNarrow;
    public ClientRecipeBook book;
    public int timesInventoryChanged;
    public boolean visible;
    protected static final ResourceLocation RECIPE_BOOK_BUTTONS = new ResourceLocation(MODID, "minecraft:textures/gui/recipe_book_buttons.png");
    @Override
    protected void initFilterButtonTextures() {
        this.filterButton.initTextureValues(0, 0, 28, 18, RECIPE_BOOK_BUTTONS);
    }
    
    public void init(int width, int height, Minecraft minecraft, boolean widthTooNarrow, CoinPressMenu menu) {
        this.minecraft = minecraft;
        this.width = width;
        this.height = height;
        this.menu = menu;
        this.widthTooNarrow = widthTooNarrow;
        assert minecraft.player != null;
        minecraft.player.containerMenu = menu;
        this.book = minecraft.player.getRecipeBook();
        this.timesInventoryChanged = minecraft.player.getInventory().getTimesChanged();
        if (this.visible) {
            this.initVisuals();
        }
        
        minecraft.keyboardHandler.setSendRepeatsToGui(true);
    }
    
    @Override
    @Nonnull
    protected Component getRecipeFilterName() {
        return Component.translatable("container.recipe_book.mintable");
    }
    
    @Override
    public void setupGhostRecipe(Recipe<?> recipe, List<Slot> slots) {
        ItemStack resultStack = recipe.getResultItem();
        this.ghostRecipe.setRecipe(recipe);
        
        if (slots.get(3).getItem().isEmpty()) {
            this.ghostRecipe.addIngredient(Ingredient.of(resultStack), (slots.get(3)).x, (slots.get(3)).y);
        }
        
        this.placeRecipe(this.menu.getGridWidth(), this.menu.getGridHeight(),
                this.menu.getResultSlotIndex(), recipe, recipe.getIngredients().iterator(), 0);
    }
}