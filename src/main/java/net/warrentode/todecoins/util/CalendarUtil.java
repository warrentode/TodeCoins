package net.warrentode.todecoins.util;

import net.minecraft.client.Minecraft;
import net.minecraft.world.level.Level;
import net.warrentode.todecoins.TodeCoins;
import sereneseasons.api.season.SeasonHelper;

import java.util.Calendar;

public class CalendarUtil {
    public CalendarUtil calendarUtil;
    public static Level level = Minecraft.getInstance().level;

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
            return get() == SPRING;
        }

        public static boolean isSummer() {
            return get() == SUMMER;
        }

        public static boolean isAutumn() {
            return get() == AUTUMN;
        }

        public static boolean isWinter() {
            return get() == AUTUMN;
        }

        public static boolean isChristmas() {
            return get() == CHRISTMAS;
        }

        public static boolean isHalloween() {
            return get() == HALLOWEEN;
        }

        public static boolean isBirthday() {
            return get() == BIRTHDAY;
        }

        public static boolean isAnniversary() {
            return get() == PATREON_ANNIVERSARY;
        }

        private static Season get() {
            Calendar calendar = Calendar.getInstance();
            int month = calendar.get(Calendar.MONTH);
            int date = calendar.get(Calendar.DATE);

            if (TodeCoins.isSereneSeasonsLoaded()) {
                // spring season cycles
                if (SeasonHelper.getSeasonState(level).getSubSeason().equals(sereneseasons.api.season.Season.SubSeason.EARLY_SPRING)) {
                    return SPRING;
                }
                else if (SeasonHelper.getSeasonState(level).getSubSeason().equals(sereneseasons.api.season.Season.SubSeason.MID_SPRING)) {
                    return SPRING;
                }
                else if (SeasonHelper.getSeasonState(level).getSubSeason().equals(sereneseasons.api.season.Season.SubSeason.LATE_SPRING)) {
                    return SPRING;
                }
                // summer season cycles
                else if (SeasonHelper.getSeasonState(level).getSubSeason().equals(sereneseasons.api.season.Season.SubSeason.EARLY_SUMMER)) {
                    return SUMMER;
                }
                else if (SeasonHelper.getSeasonState(level).getSubSeason().equals(sereneseasons.api.season.Season.SubSeason.MID_SUMMER)) {
                    return SUMMER;
                }
                else if (SeasonHelper.getSeasonState(level).getSubSeason().equals(sereneseasons.api.season.Season.SubSeason.LATE_SUMMER)) {
                    return SUMMER;
                }
                // autumn season cycles
                else if (SeasonHelper.getSeasonState(level).getSubSeason().equals(sereneseasons.api.season.Season.SubSeason.EARLY_AUTUMN)) {
                    return AUTUMN;
                }
                else if (SeasonHelper.getSeasonState(level).getSubSeason().equals(sereneseasons.api.season.Season.SubSeason.MID_AUTUMN)) {
                    return AUTUMN;
                }
                else if (SeasonHelper.getSeasonState(level).getSubSeason().equals(sereneseasons.api.season.Season.SubSeason.LATE_AUTUMN)) {
                    return AUTUMN;
                }
                // winter season cycles
                else if (SeasonHelper.getSeasonState(level).getSubSeason().equals(sereneseasons.api.season.Season.SubSeason.EARLY_WINTER)) {
                    return WINTER;
                }
                else if (SeasonHelper.getSeasonState(level).getSubSeason().equals(sereneseasons.api.season.Season.SubSeason.MID_WINTER)) {
                    return WINTER;
                }
                else if (SeasonHelper.getSeasonState(level).getSubSeason().equals(sereneseasons.api.season.Season.SubSeason.LATE_WINTER)) {
                    return WINTER;
                }
                // tropic seasons
                else if (SeasonHelper.getSeasonState(level).getTropicalSeason().equals(sereneseasons.api.season.Season.TropicalSeason.EARLY_DRY)) {
                    return SPRING;
                }
                else if (SeasonHelper.getSeasonState(level).getTropicalSeason().equals(sereneseasons.api.season.Season.TropicalSeason.LATE_DRY)) {
                    return SUMMER;
                }
                else if (SeasonHelper.getSeasonState(level).getTropicalSeason().equals(sereneseasons.api.season.Season.TropicalSeason.EARLY_WET)) {
                    return AUTUMN;
                }
                else if (SeasonHelper.getSeasonState(level).getTropicalSeason().equals(sereneseasons.api.season.Season.TropicalSeason.LATE_WET)) {
                    return WINTER;
                }
                if (SeasonHelper.getSeasonState(level).getTropicalSeason().equals(sereneseasons.api.season.Season.TropicalSeason.MID_DRY)) {
                    return SPRING;
                }
                if (SeasonHelper.getSeasonState(level).getTropicalSeason().equals(sereneseasons.api.season.Season.TropicalSeason.MID_DRY)) {
                    return SUMMER;
                }
                if (SeasonHelper.getSeasonState(level).getTropicalSeason().equals(sereneseasons.api.season.Season.TropicalSeason.MID_WET)) {
                    return AUTUMN;
                }
                if (SeasonHelper.getSeasonState(level).getTropicalSeason().equals(sereneseasons.api.season.Season.TropicalSeason.MID_WET)) {
                    return WINTER;
                }

                // holiday cycles within serene season's calendar
                if (SeasonHelper.getSeasonState(level).getSubSeason().equals(sereneseasons.api.season.Season.SubSeason.EARLY_WINTER) || SeasonHelper.getSeasonState(level).getTropicalSeason().equals(sereneseasons.api.season.Season.TropicalSeason.MID_WET)) {
                    return CHRISTMAS;
                }
                else if (SeasonHelper.getSeasonState(level).getSubSeason().equals(sereneseasons.api.season.Season.SubSeason.MID_AUTUMN) || SeasonHelper.getSeasonState(level).getTropicalSeason().equals(sereneseasons.api.season.Season.TropicalSeason.EARLY_WET)) {
                    return HALLOWEEN;
                }
                else if (SeasonHelper.getSeasonState(level).getSubSeason().equals(sereneseasons.api.season.Season.SubSeason.MID_WINTER) || SeasonHelper.getSeasonState(level).getTropicalSeason().equals(sereneseasons.api.season.Season.TropicalSeason.LATE_WET)) {
                    return BIRTHDAY;
                }
                else if (SeasonHelper.getSeasonState(level).getSubSeason().equals(sereneseasons.api.season.Season.SubSeason.EARLY_SPRING) || SeasonHelper.getSeasonState(level).getTropicalSeason().equals(sereneseasons.api.season.Season.TropicalSeason.EARLY_DRY)) {
                    return PATREON_ANNIVERSARY;
                }
            }

            else {
                // seasonal cycles based on the computer calendar
                if ((month == Calendar.MARCH && date >= 20) && (month == Calendar.JUNE && date <= 20)) {
                    return SPRING;
                }
                else if ((month == Calendar.JUNE && date >= 20) && (month == Calendar.SEPTEMBER && date <= 20)) {
                    return SUMMER;
                }
                else if ((month == Calendar.SEPTEMBER && date >= 20) && (month == Calendar.DECEMBER && date <= 20)) {
                    return AUTUMN;
                }
                else if ((month == Calendar.DECEMBER && date >= 20) && (month == Calendar.MARCH && date <= 20)) {
                    return WINTER;
                }

                // holidays
                if ((month == Calendar.DECEMBER && date >= 1) && (month == Calendar.DECEMBER && date <= 31)) {
                    return CHRISTMAS;
                }
                else if ((month == Calendar.OCTOBER && date >= 1) && (month == Calendar.OCTOBER && date <= 31)) {
                    return HALLOWEEN;
                }

                // yearly built-in events
                if ((month == Calendar.DECEMBER && date >= 19) && (month == Calendar.DECEMBER && date <= 21)) {
                    // mod's birthday is built-in
                    return BIRTHDAY;
                }
                if ((month == Calendar.JANUARY && date >= 21) && (month == Calendar.JANUARY && date <= 27)) {
                    // anniversary of patreon site
                    return PATREON_ANNIVERSARY;
                }
            }

            return NONE;
        }
    }
}