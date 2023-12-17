package com.github.warrentode.todecoins.integration;

import net.minecraft.server.level.ServerLevel;
import sereneseasons.api.season.Season;
import sereneseasons.api.season.SeasonHelper;

public class SereneSeasonsCompat {
    public SereneSeasonsCompat sereneSeasonsCompat;

    public enum SeasonCompat {
        NONE,
        PATREON_ANNIVERSARY,
        BIRTHDAY,
        EASTER,
        CHRISTMAS,
        HALLOWEEN,
        NEW_YEAR,
        SPRING,
        SUMMER,
        AUTUMN,
        WINTER;

        public static boolean isAnniversary(ServerLevel level) {
            return get(level) == PATREON_ANNIVERSARY;
        }

        public static boolean isEaster(ServerLevel level) {
            return get(level) == EASTER;
        }

        public static boolean isHalloween(ServerLevel level) {
            return get(level) == HALLOWEEN;
        }

        public static boolean isChristmas(ServerLevel level) {
            return get(level) == CHRISTMAS;
        }

        public static boolean isBirthday(ServerLevel level) {
            return get(level) == BIRTHDAY;
        }

        public static boolean isNewYear(ServerLevel level) {
            return get(level) == NEW_YEAR;
        }

        public static boolean isSpring(ServerLevel level) {
            return get(level) == SPRING;
        }

        public static boolean isSummer(ServerLevel level) {
            return get(level) == SUMMER;
        }

        public static boolean isAutumn(ServerLevel level) {
            return get(level) == AUTUMN;
        }

        public static boolean isWinter(ServerLevel level) {
            return get(level) == WINTER;
        }

        private static SeasonCompat get(ServerLevel level) {
            Season season = SeasonHelper.getSeasonState(level).getSeason();
            Season.SubSeason subSeason = SeasonHelper.getSeasonState(level).getSubSeason();
            Season.TropicalSeason tropicalSeason = SeasonHelper.getSeasonState(level).getTropicalSeason();

            // holidays & events
            if ((subSeason == Season.SubSeason.EARLY_SPRING || tropicalSeason == Season.TropicalSeason.MID_WET)
                    && !(subSeason == Season.SubSeason.LATE_WINTER)) {
                return PATREON_ANNIVERSARY;
            }
            if ((subSeason == Season.SubSeason.MID_SPRING || tropicalSeason == Season.TropicalSeason.LATE_WET)
                    && !(subSeason == Season.SubSeason.LATE_SPRING)) {
                return EASTER;
            }
            if ((subSeason == Season.SubSeason.MID_AUTUMN || tropicalSeason == Season.TropicalSeason.LATE_DRY)
                    && !(subSeason == Season.SubSeason.LATE_AUTUMN)) {
                return HALLOWEEN;
            }
            if ((subSeason == Season.SubSeason.EARLY_WINTER || tropicalSeason == Season.TropicalSeason.EARLY_WET)
                    && !(subSeason == Season.SubSeason.MID_WINTER)) {
                return CHRISTMAS;
            }
            if ((subSeason == Season.SubSeason.MID_WINTER || tropicalSeason == Season.TropicalSeason.EARLY_WET)
                    && !(subSeason == Season.SubSeason.EARLY_WINTER)) {
                return BIRTHDAY;
            }
            if ((subSeason == Season.SubSeason.LATE_WINTER || tropicalSeason == Season.TropicalSeason.MID_WET)
                    && !(subSeason == Season.SubSeason.EARLY_SPRING)) {
                return NEW_YEAR;
            }

            // seasons
            if (subSeason == Season.SubSeason.EARLY_SPRING || subSeason == Season.SubSeason.MID_SPRING || subSeason == Season.SubSeason.LATE_SPRING
                    || tropicalSeason == Season.TropicalSeason.MID_WET && !(subSeason == Season.SubSeason.LATE_WINTER)
                    || tropicalSeason == Season.TropicalSeason.LATE_WET) {
                return SPRING;
            }
            if (subSeason == Season.SubSeason.EARLY_SUMMER || subSeason == Season.SubSeason.MID_SUMMER || subSeason == Season.SubSeason.LATE_SUMMER
                    || tropicalSeason == Season.TropicalSeason.EARLY_DRY
                    || tropicalSeason == Season.TropicalSeason.MID_DRY && !(subSeason == Season.SubSeason.EARLY_AUTUMN)) {
                return SUMMER;
            }
            if (subSeason == Season.SubSeason.EARLY_AUTUMN || subSeason == Season.SubSeason.MID_AUTUMN || subSeason == Season.SubSeason.LATE_AUTUMN
                    || tropicalSeason == Season.TropicalSeason.MID_DRY && !(subSeason == Season.SubSeason.LATE_SUMMER)
                    || tropicalSeason == Season.TropicalSeason.LATE_DRY) {
                return AUTUMN;
            }
            if (subSeason == Season.SubSeason.EARLY_WINTER || subSeason == Season.SubSeason.MID_WINTER || subSeason == Season.SubSeason.LATE_WINTER
                    || tropicalSeason == Season.TropicalSeason.EARLY_WET
                    || tropicalSeason == Season.TropicalSeason.MID_WET && !(subSeason == Season.SubSeason.EARLY_SPRING)) {
                return WINTER;
            }

            return NONE;
        }
    }
}