package com.github.warrentode.todecoins.util.seasonal;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;

public class SeasonalEffects {
    // main and secondary seasonal effect variables
    private static MobEffect PRIMARY_SEASONAL_EFFECT;
    private static MobEffect SECONDARY_SEASONAL_EFFECT;

    public SeasonalEffects() {}

    /**
     * Call this before fetching the seasonal effects to ensure they are updated
     * according to the current date or Serene Seasons state.
     */
    public static void eventCheck() {
        if (CalendarUtil.check("ANNIVERSARY")) {
            PRIMARY_SEASONAL_EFFECT = MobEffects.ABSORPTION; // place holder for now
            SECONDARY_SEASONAL_EFFECT = MobEffects.ABSORPTION; // place holder for now
        }
        else if (CalendarUtil.check("EASTER")) {
            PRIMARY_SEASONAL_EFFECT = MobEffects.ABSORPTION; // place holder for now
            SECONDARY_SEASONAL_EFFECT = MobEffects.ABSORPTION; // place holder for now
        }
        else if (CalendarUtil.check("HALLOWEEN")) {
            PRIMARY_SEASONAL_EFFECT = MobEffects.ABSORPTION; // place holder for now
            SECONDARY_SEASONAL_EFFECT = MobEffects.ABSORPTION; // place holder for now
        }
        else if (CalendarUtil.check("CHRISTMAS")) {
            PRIMARY_SEASONAL_EFFECT = MobEffects.ABSORPTION; // place holder for now
            SECONDARY_SEASONAL_EFFECT = MobEffects.ABSORPTION; // place holder for now
        }
        else if (CalendarUtil.check("BIRTHDAY")) {
            PRIMARY_SEASONAL_EFFECT = MobEffects.ABSORPTION; // place holder for now
            SECONDARY_SEASONAL_EFFECT = MobEffects.ABSORPTION; // place holder for now
        }
        else if (CalendarUtil.check("NEW_YEAR")) {
            PRIMARY_SEASONAL_EFFECT = MobEffects.ABSORPTION; // place holder for now
            SECONDARY_SEASONAL_EFFECT = MobEffects.ABSORPTION; // place holder for now
        }
        else if (CalendarUtil.check("SPRING")) {
            PRIMARY_SEASONAL_EFFECT = MobEffects.ABSORPTION; // place holder for now
            SECONDARY_SEASONAL_EFFECT = MobEffects.ABSORPTION; // place holder for now
        }
        else if (CalendarUtil.check("SUMMER")) {
            PRIMARY_SEASONAL_EFFECT = MobEffects.ABSORPTION; // place holder for now
            SECONDARY_SEASONAL_EFFECT = MobEffects.ABSORPTION; // place holder for now
        }
        else if (CalendarUtil.check("AUTUMN")) {
            PRIMARY_SEASONAL_EFFECT = MobEffects.ABSORPTION; // place holder for now
            SECONDARY_SEASONAL_EFFECT = MobEffects.ABSORPTION; // place holder for now
        }
        // defaults to winter effects
        else {
            PRIMARY_SEASONAL_EFFECT = MobEffects.ABSORPTION; // place holder for now
            SECONDARY_SEASONAL_EFFECT = MobEffects.ABSORPTION; // place holder for now
        }
    }

    public static MobEffect getPrimarySeasonalEffect() {
        eventCheck();
        return PRIMARY_SEASONAL_EFFECT;
    }

    public static MobEffect getSecondarySeasonalEffect() {
        eventCheck();
        return SECONDARY_SEASONAL_EFFECT;
    }
}