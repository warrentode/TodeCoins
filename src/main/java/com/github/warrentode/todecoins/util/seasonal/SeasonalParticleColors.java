package com.github.warrentode.todecoins.util.seasonal;

import net.minecraft.world.item.DyeColor;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;
import org.joml.Vector4f;

import java.awt.*;
import java.awt.image.ColorModel;

/**
 * SeasonalParticleColors for Forge 1.20.1
 * <p>
 * - RGB values stored as floats in 0–1 range (scaled by RGB_SCALE)
 * - Seasonal colors updated via CalendarUtil
 * - Supports float[], int[], hex, and flexible particle spawning
 * NOTE: Particle spawning helpers were moved to SeasonalParticleSpawner (client-only).
 */
public class SeasonalParticleColors {
    public static final float RGB_SCALE = 150.0F;
    public static Vector3f PRIMARY_SEASONAL_PARTICLE_COLOR = new Vector3f(0, 0, 0);
    public static Vector3f SECONDARY_SEASONAL_PARTICLE_COLOR = new Vector3f(0, 0, 0);

    public SeasonalParticleColors() {}

    /**
     * Checks the current season and updates colors. Call before getters to avoid black particles.
     */
    public static void eventCheck() {
        if (CalendarUtil.check("ANNIVERSARY")) {
            // gold
            setPrimarySeasonalColor(255, 215, 0);
            // silver
            setSecondarySeasonalColor(192, 192, 192);
        }
        else if (CalendarUtil.check("EASTER")) {
            // fuchsia
            setPrimarySeasonalColor(255, 0, 255);
            // crayola canary
            setSecondarySeasonalColor(255, 255, 153);
        }
        else if (CalendarUtil.check("HALLOWEEN")) {
            // dark orange
            setPrimarySeasonalColor(255, 140, 0);
            // crayola licorice
            setSecondarySeasonalColor(26, 17, 16);
        }
        else if (CalendarUtil.check("CHRISTMAS")) {
            // crayola winter wizard
            setPrimarySeasonalColor(160, 230, 255);
            // crayola winter sky
            setSecondarySeasonalColor(255, 0, 124);
        }
        else if (CalendarUtil.check("BIRTHDAY")) {
            // chocolate
            setPrimarySeasonalColor(210, 105, 30);
            // crayola strawberry
            setSecondarySeasonalColor(252, 90, 141);
        }
        else if (CalendarUtil.check("NEW_YEAR")) {
            // red
            setPrimarySeasonalColor(255, 0, 0);
            // crayola illuminating emerald
            setSecondarySeasonalColor(49, 145, 119);
        }
        else if (CalendarUtil.check("SPRING")) {
            // pale green
            setPrimarySeasonalColor(152, 251, 152);
            // crayola sunglow
            setSecondarySeasonalColor(255, 204, 51);
        }
        else if (CalendarUtil.check("SUMMER")) {
            // yellow
            setPrimarySeasonalColor(255, 255, 0);
            // crayola wild watermelon
            setSecondarySeasonalColor(253, 91, 120);
        }
        else if (CalendarUtil.check("AUTUMN")) {
            // burly wood
            setPrimarySeasonalColor(222, 184, 135);
            // crayola twilight lavender
            setSecondarySeasonalColor(138, 73, 107);
        }
        // defaults to winter colors
        else {
            // powder blue
            setPrimarySeasonalColor(176, 224, 230);
            // crayola wintergreen dream
            setSecondarySeasonalColor(86, 136, 125);
        }
    }

    // Standard getters
    public static Vector3f getPrimarySeasonalParticleColor() {
        eventCheck();
        return PRIMARY_SEASONAL_PARTICLE_COLOR;
    }
    public static Vector3f getSecondarySeasonalParticleColor() {
        eventCheck();
        return SECONDARY_SEASONAL_PARTICLE_COLOR;
    }

    /**
     * references:
     * SlimeKnight's FaucetBlock in Tinkers Construct
     * textureDiffuseColors equation in the {@link DyeColor}
     * <a href="https://nanogui.readthedocs.io/en/latest/api/classnanogui_1_1Color.html">Color Methods for C++ and Python</a>
     * {@link Vector4f}
     * {@link Color}
     * {@link ColorModel}
     **/

    // Set RGB from ints
    public static void setPrimarySeasonalColor(int red, int green, int blue) {
        PRIMARY_SEASONAL_PARTICLE_COLOR = new Vector3f(red / RGB_SCALE, green / RGB_SCALE, blue / RGB_SCALE);
    }
    public static void setSecondarySeasonalColor(int red, int green, int blue) {
        SECONDARY_SEASONAL_PARTICLE_COLOR = new Vector3f(red / RGB_SCALE, green / RGB_SCALE, blue / RGB_SCALE);
    }

    // Set RGB from hex
    @SuppressWarnings("unused")
    public static void setPrimarySeasonalColorHex(int hex) {
        // Extract red, green, blue components from the hex integer and call the standard setter
        setPrimarySeasonalColor((hex >> 16) & 0xFF,  // Red
                (hex >> 8) & 0xFF,   // Green
                hex & 0xFF);         // Blue
    }
    @SuppressWarnings("unused")
    public static void setSecondarySeasonalColorHex(int hex) {
        setSecondarySeasonalColor((hex >> 16) & 0xFF,
                (hex >> 8) & 0xFF,
                hex & 0xFF);
    }

    // Hex getters
    @SuppressWarnings("unused")
    public static int getPrimarySeasonalParticleColorHex() {
        int[] rgb = getPrimarySeasonalParticleColorInt();
        return (rgb[0] << 16) | (rgb[1] << 8) | rgb[2];
    }
    @SuppressWarnings("unused")
    public static int getSecondarySeasonalParticleColorHex() {
        int[] rgb = getSecondarySeasonalParticleColorInt();
        return (rgb[0] << 16) | (rgb[1] << 8) | rgb[2];
    }

    // Integer RGB getters
    @SuppressWarnings("unused")
    public static int @NotNull [] getPrimarySeasonalParticleColorInt() {
        Vector3f c = getPrimarySeasonalParticleColor();
        return new int[]{(int) (c.x * RGB_SCALE), (int) (c.y * RGB_SCALE), (int) (c.z * RGB_SCALE)};
    }
    @SuppressWarnings("unused")
    public static int @NotNull [] getSecondarySeasonalParticleColorInt() {
        Vector3f c = getSecondarySeasonalParticleColor();
        return new int[]{(int) (c.x * RGB_SCALE), (int) (c.y * RGB_SCALE), (int) (c.z * RGB_SCALE)};
    }

    // Float array getters
    @SuppressWarnings("unused")
    public static float @NotNull [] getPrimarySeasonalParticleColorArray() {
        Vector3f c = getPrimarySeasonalParticleColor();
        return new float[]{c.x, c.y, c.z};
    }
    @SuppressWarnings("unused")
    public static float @NotNull [] getSecondarySeasonalParticleColorArray() {
        Vector3f c = getSecondarySeasonalParticleColor();
        return new float[]{c.x, c.y, c.z};
    }
}