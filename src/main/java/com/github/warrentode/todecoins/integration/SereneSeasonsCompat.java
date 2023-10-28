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

            // holidays
            if (subSeason == Season.SubSeason.MID_AUTUMN) {
                return HALLOWEEN;
            }
            if (subSeason == Season.SubSeason.EARLY_WINTER) {
                return CHRISTMAS;
            }

            // yearly built-in events
            if (subSeason == Season.SubSeason.MID_WINTER) {
                return BIRTHDAY;
            }
            if (subSeason == Season.SubSeason.LATE_WINTER) {
                return PATREON_ANNIVERSARY;
            }

            // seasons
            if (season == Season.WINTER) {
                return WINTER;
            }
            else if (season == Season.SPRING) {
                return SPRING;
            }
            else if (season == Season.SUMMER) {
                return SUMMER;
            }
            else if (season == Season.AUTUMN) {
                return AUTUMN;
            }

            return NONE;
        }
    }
}