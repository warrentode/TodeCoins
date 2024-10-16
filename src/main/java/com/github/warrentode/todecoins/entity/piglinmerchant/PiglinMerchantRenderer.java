package com.github.warrentode.todecoins.entity.piglinmerchant;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import static com.github.warrentode.todecoins.TodeCoins.MODID;


public class PiglinMerchantRenderer extends MobRenderer<PiglinMerchant, PiglinMerchantModel<PiglinMerchant>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(MODID, "textures/entity/piglinmerchant.png");

    public PiglinMerchantRenderer(EntityRendererProvider.Context context) {
        super(context, new PiglinMerchantModel<>(context.bakeLayer(PiglinMerchantModelLayers.PIGLINMERCHANT)), 0.6f);
        this.addLayer(new ItemInHandLayer<>(this, context.getItemInHandRenderer()));
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull PiglinMerchant merchant) {
        return TEXTURE;
    }
}