package com.github.warrentode.todecoins.gui.coinpressgui;

import com.github.warrentode.todecoins.recipe.recipebook.CoinPressRecipeBookComponent;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.recipebook.RecipeBookComponent;
import net.minecraft.client.gui.screens.recipebook.RecipeUpdateListener;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.inventory.Slot;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.awt.*;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

public class CoinPressScreen extends AbstractContainerScreen<CoinPressMenu> implements RecipeUpdateListener {
    private static final ResourceLocation BACKGROUND_TEXTURE = ResourceLocation.parse(MODID + ":" + "textures/gui/coin_press_gui.png");
    private static final ResourceLocation RECIPE_BOOK_BUTTON_TEXTURE = ResourceLocation.parse("minecraft:textures/gui/recipe_button.png");
    private static final Rectangle PROGRESS_ARROW = new Rectangle(106, 51, 0, 15);
    private final CoinPressRecipeBookComponent recipeBookComponent = new CoinPressRecipeBookComponent();
    private boolean widthTooNarrow;

    public CoinPressScreen(CoinPressMenu screenContainer, Inventory inventory, Component titleIn) {
        super(screenContainer, inventory, titleIn);
    }

    @Override
    public void init() {
        super.init();
        this.widthTooNarrow = this.width < 379;
        this.titleLabelX = 8;
        assert this.minecraft != null;
        this.recipeBookComponent.init(this.width, this.height, this.minecraft, this.widthTooNarrow, this.menu);
        this.leftPos = this.recipeBookComponent.updateScreenPosition(this.width, this.imageWidth);
        this.addRenderableWidget(new ImageButton(
                this.leftPos + 5,
                this.height / 2 - 49,
                20, 18,
                0, 0, 19,
                RECIPE_BOOK_BUTTON_TEXTURE,
                256, 256,
                (button) -> {
                    this.recipeBookComponent.toggleVisibility();
                    this.leftPos = this.recipeBookComponent.updateScreenPosition(this.width, this.imageWidth);
                    button.setPosition(this.leftPos + 5, this.height / 2 - 49);
                }));
        this.addWidget(this.recipeBookComponent);
        this.setInitialFocus(this.recipeBookComponent);
    }

    @Override
    protected void containerTick() {
        super.containerTick();
        this.recipeBookComponent.tick();
    }

    @Override
    public void render(@NotNull GuiGraphics graphics, int mouseX, int mouseY, float delta) {
        this.renderBackground(graphics);

        // always render background
        this.renderBg(graphics, delta, mouseX, mouseY);

        // render the recipe book behind the toggle
        this.recipeBookComponent.render(graphics, mouseX, mouseY, delta);

        // render your widgets (including the toggle button) on top
        super.render(graphics, mouseX, mouseY, delta);

        // ghost recipes, tooltips
        this.recipeBookComponent.renderGhostRecipe(graphics, this.leftPos, this.topPos, true, delta);
        this.renderTooltip(graphics, mouseX, mouseY);
        this.recipeBookComponent.renderTooltip(graphics, this.leftPos, this.topPos, mouseX, mouseY);
    }

    @Override
    protected void renderLabels(@NotNull GuiGraphics graphics, int mouseX, int mouseY) {
        super.renderLabels(graphics, mouseX, mouseY);
        graphics.drawString(this.font, this.playerInventoryTitle, 8, (this.imageHeight - 96 + 2), 4210752, false);
    }

    @Override
    protected void renderBg(@NotNull GuiGraphics graphics, float partialTick, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, BACKGROUND_TEXTURE);
        int x = this.leftPos;
        int y = (height - imageHeight) / 2;

        graphics.blit(BACKGROUND_TEXTURE, x, y, 0, 0, imageWidth, imageHeight);

        renderProgressArrow(graphics);
    }

    private void renderProgressArrow(@NotNull GuiGraphics graphics) {
        if (menu.isCrafting()) {
            int l = menu.getScaledProgress();
            graphics.blit(BACKGROUND_TEXTURE, this.leftPos + PROGRESS_ARROW.x, this.topPos + PROGRESS_ARROW.y, 179, 3, l + 1, PROGRESS_ARROW.height);
        }
    }

    @Override
    protected boolean isHovering(int x, int y, int width, int height, double mouseX, double mouseY) {
        return (!this.widthTooNarrow || !this.recipeBookComponent.isVisible()) && super.isHovering(x, y, width, height, mouseX, mouseY);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int buttonId) {
        if (this.recipeBookComponent.mouseClicked(mouseX, mouseY, buttonId)) {
            this.setFocused(this.recipeBookComponent);
            return true;
        }
        return this.widthTooNarrow && this.recipeBookComponent.isVisible() || super.mouseClicked(mouseX, mouseY, buttonId);
    }

    @Override
    protected boolean hasClickedOutside(double mouseX, double mouseY, int x, int y, int buttonIdx) {
        boolean flag = mouseX < (double) x || mouseY < (double) y || mouseX >= (double) (x + this.imageWidth) || mouseY >= (double) (y + this.imageHeight);
        return flag && this.recipeBookComponent.hasClickedOutside(mouseX, mouseY, this.leftPos, this.topPos, this.imageWidth, this.imageHeight, buttonIdx);
    }

    @Override
    protected void slotClicked(@NotNull Slot slot, int mouseX, int mouseY, @NotNull ClickType clickType) {
        super.slotClicked(slot, mouseX, mouseY, clickType);
        this.recipeBookComponent.slotClicked(slot);
    }

    @Override
    public void recipesUpdated() {
        this.recipeBookComponent.recipesUpdated();
    }

    @SuppressWarnings("EmptyMethod")
    @Override
    public void removed() {
        super.removed();
    }

    @Override
    @Nonnull
    public RecipeBookComponent getRecipeBookComponent() {
        return this.recipeBookComponent;
    }
}