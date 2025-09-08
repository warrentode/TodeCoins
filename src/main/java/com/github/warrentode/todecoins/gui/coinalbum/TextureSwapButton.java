package com.github.warrentode.todecoins.gui.coinalbum;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class TextureSwapButton extends ImageButton {
    private final ResourceLocation unlitTexture;
    private final ResourceLocation litTexture;
    private boolean enabled = true;

    public TextureSwapButton(int x, int y, int width, int height,
                             ResourceLocation unlitTexture, ResourceLocation litTexture,
                             OnPress onPress) {
        super(x, y, width, height, 0, 0, 0, unlitTexture, onPress);
        this.unlitTexture = unlitTexture;
        this.litTexture = litTexture;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean isActive() {
        return enabled;
    }

    @Override
    public void renderWidget(@NotNull GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        if (!this.visible) return;
        ResourceLocation textureToRender = this.isHovered() ? litTexture : unlitTexture;
        graphics.blit(textureToRender, this.getX(), this.getY(), 0, 0, this.width, this.height, this.width, this.height);
    }
}