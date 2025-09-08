package com.github.warrentode.todecoins.gui.coinalbum;

import com.github.warrentode.todecoins.block.entity.container.coinalbum.CoinAlbumSlotHandler;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

public class CoinAlbumScreen extends AbstractContainerScreen<CoinAlbumMenu> {
    private static final ResourceLocation BACKGROUND_TEXTURE =
            ResourceLocation.parse("minecraft:textures/gui/container/generic_54.png");

    private static final ResourceLocation PAGE_LEFT_LIT =
            ResourceLocation.parse(MODID + ":textures/gui/page_backward_highlighted.png");
    private static final ResourceLocation PAGE_LEFT_UNLIT =
            ResourceLocation.parse(MODID + ":textures/gui/page_backward.png");

    private static final ResourceLocation PAGE_RIGHT_LIT =
            ResourceLocation.parse(MODID + ":textures/gui/page_forward_highlighted.png");
    private static final ResourceLocation PAGE_RIGHT_UNLIT =
            ResourceLocation.parse(MODID + ":textures/gui/page_forward.png");

    private TextureSwapButton leftPageButton;
    private TextureSwapButton rightPageButton;

    public CoinAlbumScreen(CoinAlbumMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
        this.imageWidth = 174;
        this.imageHeight = 220;
    }

    @Override
    protected void init() {
        super.init();
        this.titleLabelX = (this.imageWidth - this.font.width(this.title)) / 2;
        this.inventoryLabelX = 8;
        this.inventoryLabelY = this.imageHeight - 96 + 2;

        int leftX = (this.width - this.imageWidth) / 2 - 14;
        int rightX = (this.width + this.imageWidth) / 2 + 2;
        int buttonsY = (this.height - this.imageHeight) / 2 + 100;

        leftPageButton = new TextureSwapButton(leftX, buttonsY, 12, 17, PAGE_LEFT_UNLIT, PAGE_LEFT_LIT, button -> {
            this.menu.previousPage();
            updatePageButtons();
        });
        this.addRenderableWidget(leftPageButton);

        rightPageButton = new TextureSwapButton(rightX, buttonsY, 12, 17, PAGE_RIGHT_UNLIT, PAGE_RIGHT_LIT, button -> {
            this.menu.nextPage();
            updatePageButtons();
        });
        this.addRenderableWidget(rightPageButton);

        updatePageButtons();
    }

    private void updatePageButtons() {
        int maxPage = this.menu.getTotalPages() - 1;

        leftPageButton.setEnabled(this.menu.getCurrentPage() > 0);
        rightPageButton.setEnabled(this.menu.getCurrentPage() < maxPage);

        // Force GUI to redraw slots
        for (Slot slot : this.menu.slots) {
            if (slot instanceof CoinAlbumSlotHandler albumSlot) {
                albumSlot.setChanged();
            }
        }
        assert this.minecraft != null;
        this.minecraft.getWindow().updateDisplay();
    }

    @Override
    protected void renderLabels(@NotNull GuiGraphics graphics, int mouseX, int mouseY) {
        // Shifted down slightly
        int labelY = this.imageHeight - 92; // slightly below the original inventory label

        // Draw screen title (centered at top)
        graphics.drawString(this.font, this.title, this.titleLabelX, this.titleLabelY, 4210752, false);

        // Draw player inventory label (bottom-left)
        graphics.drawString(this.font, this.playerInventoryTitle, this.inventoryLabelX, labelY, 4210752, false);

        // Draw page number (bottom-right)
        int pageNum = menu.getCurrentPage() + 1;
        int totalPages = menu.getTotalPages();
        Component pageText = Component.translatable("container.todecoins.coin_album.page").append(" ").append(String.valueOf(pageNum)).append("/").append(String.valueOf(totalPages));
        graphics.drawString(this.font, pageText, this.imageWidth - font.width(pageText) - 8, labelY, 4210752, false);
    }

    @Override
    public void render(@NotNull GuiGraphics graphics, int mouseX, int mouseY, float delta) {
        this.renderBackground(graphics);
        this.renderBg(graphics, delta, mouseX, mouseY);
        super.render(graphics, mouseX, mouseY, delta);
    }

    @Override
    protected void renderBg(@NotNull GuiGraphics graphics, float partialTick, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, BACKGROUND_TEXTURE);
        int x = (this.width - this.imageWidth) / 2;
        int y = (this.height - this.imageHeight) / 2;
        graphics.blit(BACKGROUND_TEXTURE, x, y, 0, 0, imageWidth, imageHeight);
    }

    @Override
    protected void renderTooltip(@NotNull GuiGraphics graphics, int mouseX, int mouseY) {
        // Only show tooltip if the slot under the cursor is active
        Slot hovered = this.getSlotUnderMouse(); // helper from AbstractContainerScreen
        if (hovered instanceof CoinAlbumSlotHandler albumSlot && albumSlot.isActive() && hovered.hasItem()) {
            ItemStack stack = hovered.getItem();
            graphics.renderTooltip(this.font, this.getTooltipFromContainerItem(stack), stack.getTooltipImage(), stack, mouseX, mouseY);
        }
    }
}