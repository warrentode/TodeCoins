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
        SPRING,
        SUMMER,
        AUTUMN,
        WINTER;

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

        public static boolean isEaster(ServerLevel level) {
            return get(level) == EASTER;
        }

        public static boolean isChristmas(ServerLevel level) {
            return get(level) == CHRISTMAS;
        }

        public static boolean isHalloween(ServerLevel level) {
            return get(level) == HALLOWEEN;
        }

        public static boolean isBirthday(ServerLevel level) {
            return get(level) == BIRTHDAY;
        }

        public static boolean isAnniversary(ServerLevel level) {
            return get(level) == PATREON_ANNIVERSARY;
        }

        private static SeasonCompat get(ServerLevel level) {
            Season season = SeasonHelper.getSeasonState(level).getSeason();
            Season.SubSeason subSeason = SeasonHelper.getSeasonState(level).getSubSeason();
            Season.TropicalSeason tropicalSeason = SeasonHelper.getSeasonState(level).getTropicalSeason();

            // seasons
            if (subSeason == Season.SubSeason.EARLY_WINTER || subSeason == Season.SubSeason.MID_WINTER || subSeason == Season.SubSeason.LATE_WINTER
                    || tropicalSeason == Season.TropicalSeason.EARLY_WET || tropicalSeason == Season.TropicalSeason.MID_WET) {
                return WINTER;
            }
            else if (subSeason == Season.SubSeason.EARLY_SPRING || subSeason == Season.SubSeason.MID_SPRING || subSeason == Season.SubSeason.LATE_SPRING
                    || tropicalSeason == Season.TropicalSeason.LATE_WET) {
                return SPRING;
            }
            else if (subSeason == Season.SubSeason.EARLY_SUMMER || subSeason == Season.SubSeason.MID_SUMMER || subSeason == Season.SubSeason.LATE_SUMMER
                    || tropicalSeason == Season.TropicalSeason.MID_DRY) {
                return SUMMER;
            }
            else if (subSeason == Season.SubSeason.EARLY_AUTUMN || subSeason == Season.SubSeason.MID_AUTUMN || subSeason == Season.SubSeason.LATE_AUTUMN
                    || tropicalSeason == Season.TropicalSeason.EARLY_DRY || tropicalSeason == Season.TropicalSeason.LATE_DRY) {
                return AUTUMN;
            }

            // holidays
            if (subSeason == Season.SubSeason.MID_AUTUMN && tropicalSeason == Season.TropicalSeason.LATE_DRY) {
                return HALLOWEEN;
            }
            if (subSeason == Season.SubSeason.EARLY_WINTER && tropicalSeason == Season.TropicalSeason.EARLY_WET) {
                return CHRISTMAS;
            }

            // yearly built-in events
            if (subSeason == Season.SubSeason.MID_WINTER && tropicalSeason == Season.TropicalSeason.EARLY_WET) {
                return BIRTHDAY;
            }
            if (subSeason == Season.SubSeason.LATE_WINTER && tropicalSeason == Season.TropicalSeason.MID_WET) {
                return PATREON_ANNIVERSARY;
            }

            return NONE;
        }
    }
}