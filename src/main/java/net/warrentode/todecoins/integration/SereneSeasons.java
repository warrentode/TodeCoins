package net.warrentode.todecoins.integration;

import net.minecraft.client.Minecraft;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import sereneseasons.api.season.SeasonHelper;

import static sereneseasons.api.season.Season.SubSeason.*;
import static sereneseasons.api.season.Season.TropicalSeason.*;

public class SereneSeasons {
    static RandomSource random = RandomSource.create();
    private static Level level = Minecraft.getInstance().level;

    public enum Season {
        NONE,
        PATREON_ANNIVERSARY,
        BIRTHDAY,
        CHRISTMAS,
        HALLOWEEN,
        SPRING,
        SUMMER,
        AUTUMN,
        WINTER;

        public static boolean isSpring() {
            return get(level) == SPRING;
        }

        public static boolean isSummer() {
            return get(level) == SUMMER;
        }

        public static boolean isAutumn() {
            return get(level) == AUTUMN;
        }

        public static boolean isWinter() {
            return get(level) == WINTER;
        }

        public static boolean isChristmas() {
            return get(level) == CHRISTMAS;
        }

        public static boolean isHalloween() {
            return get(level) == HALLOWEEN;
        }

        public static boolean isBirthday() {
            return get(level) == BIRTHDAY;
        }

        public static boolean isAnniversary() {
            return get(level) == PATREON_ANNIVERSARY;
        }

        private static Season get(Level level) {
            sereneseasons.api.season.Season.SubSeason subSeason = SeasonHelper.getSeasonState(level).getSubSeason();
            sereneseasons.api.season.Season.TropicalSeason tropicalSeason = SeasonHelper.getSeasonState(level).getTropicalSeason();

            // regular seasons
            if (subSeason == EARLY_WINTER) {
                return WINTER;
            }
            else if (subSeason == MID_WINTER) {
                return WINTER;
            }
            else if (subSeason == LATE_WINTER) {
                return WINTER;
            }
            else if (subSeason == EARLY_SPRING) {
                return SPRING;
            }
            else if (subSeason == MID_SPRING) {
                return SPRING;
            }
            else if (subSeason == LATE_SPRING) {
                return SPRING;
            }
            else if (subSeason == EARLY_SUMMER) {
                return SUMMER;
            }
            else if (subSeason == MID_SUMMER) {
                return SUMMER;
            }
            else if (subSeason == LATE_SUMMER) {
                return SUMMER;
            }
            else if (subSeason == EARLY_AUTUMN) {
                return AUTUMN;
            }
            else if (subSeason == MID_AUTUMN) {
                return AUTUMN;
            }
            else if (subSeason == LATE_AUTUMN) {
                return AUTUMN;
            }

            // holiday regular seasons
            if (subSeason == EARLY_WINTER) {
                return CHRISTMAS;
            }
            if (subSeason == MID_WINTER) {
                return PATREON_ANNIVERSARY;
            }
            if (subSeason == MID_AUTUMN) {
                return HALLOWEEN;
            }
            if (subSeason == LATE_AUTUMN) {
                return BIRTHDAY;
            }

            // tropic seasons
            if (tropicalSeason == EARLY_WET) {
                return WINTER;
            }
            else if (tropicalSeason == MID_WET) {
                if (random.nextInt(0, 100) > 50) {
                    return SPRING;
                }
                else {
                    return WINTER;
                }
            }
            else if (tropicalSeason == LATE_WET) {
                return SPRING;
            }
            if (tropicalSeason == EARLY_DRY) {
                return SUMMER;
            }
            else if (tropicalSeason == MID_DRY) {
                if (random.nextInt(0, 100) > 50) {
                    return SUMMER;
                }
                else {
                    return AUTUMN;
                }
            }
            else if (tropicalSeason == LATE_DRY) {
                return AUTUMN;
            }

            // holidays tropical seasons
            if (tropicalSeason == EARLY_WET) {
                return CHRISTMAS;
            }
            if (tropicalSeason == MID_DRY) {
                return HALLOWEEN;
            }

            return NONE;
        }
    }
}