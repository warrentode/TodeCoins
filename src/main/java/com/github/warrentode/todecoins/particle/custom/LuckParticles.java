package com.github.warrentode.todecoins.particle.custom;

import com.github.warrentode.todecoins.util.seasonal.SeasonalParticleColors;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;

public class LuckParticles extends TextureSheetParticle {
    private float fadeR;
    private float fadeG;
    private float fadeB;

    protected LuckParticles(ClientLevel clientLevel, double xCoord, double yCoord, double zCoord,
                            SpriteSet spriteSet, double xSpeed, double ySpeed, double zSpeed) {
        super(clientLevel, xCoord, yCoord, zCoord, xSpeed, ySpeed, zSpeed);

        // provides movement resistance?
        this.friction = 0.8F;

        // Set initial velocity
        this.xd = xSpeed;
        this.yd = ySpeed;
        this.zd = zSpeed;

        // Lifetime and size
        this.lifetime = 100;
        this.setSpriteFromAge(spriteSet);
        this.quadSize *= 0.85F; // scale value

        // RGB tint
        this.setColor();

        // start fully visible
        this.alpha = 1.0F;
    }

    @Override
    public void tick() {
        super.tick();

        // Age ratio (0 → 1 over lifetime)
        float ageRatio = (float)this.age / (float)this.lifetime;

        // Tie alpha to fadeColor curve with randomness
        this.setAlpha((1.0F - ageRatio) * this.alpha);

        // Color fade uses same ageRatio for consistency
        fadeColor(ageRatio);
    }

    private void setColor() {
        Vector3f color1 = SeasonalParticleColors.getPrimarySeasonalParticleColor();
        this.setColor(color1.x, color1.y, color1.z);
    }

    private void fadeColor(float ageRatio) {
        Vector3f color2 = SeasonalParticleColors.getSecondarySeasonalParticleColor();
        this.fadeR = color2.x;
        this.fadeG = color2.y;
        this.fadeB = color2.z;

        // Blend factor grows with age (or invert if you want the opposite)
        float blendFactor = 0.05F + 0.25F * ageRatio;

        this.rCol += (this.fadeR - this.rCol) * blendFactor;
        this.gCol += (this.fadeG - this.gCol) * blendFactor;
        this.bCol += (this.fadeB - this.bCol) * blendFactor;
    }

    @Override
    public @NotNull ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet spriteSet;

        public Provider(SpriteSet spriteSet) {
            this.spriteSet = spriteSet;
        }

        @Nullable
        @Override
        public Particle createParticle(@NotNull SimpleParticleType type, @NotNull ClientLevel clientLevel,
                                       double xCoord, double yCoord, double zCoord,
                                       double xSpeed, double ySpeed, double zSpeed) {
            return new LuckParticles(clientLevel, xCoord, yCoord, zCoord, this.spriteSet, xSpeed, ySpeed, zSpeed);
        }
    }
}