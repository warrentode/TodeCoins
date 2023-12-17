package com.github.warrentode.todecoins.util;

import java.util.Calendar;

public class CalendarUtil {
    public CalendarUtil calendarUtil;

    public enum Season {
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

        public static boolean isAnniversary() {
            return get() == PATREON_ANNIVERSARY;
        }

        public static boolean isEaster() {
            return get() == EASTER;
        }

        public static boolean isHalloween() {
            return get() == HALLOWEEN;
        }

        public static boolean isChristmas() {
            return get() == CHRISTMAS;
        }

        public static boolean isBirthday() {
            return get() == BIRTHDAY;
        }

        public static boolean isNewYear() {
            return get() == NEW_YEAR;
        }

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
            return get() == WINTER;
        }

        private static Season get() {
            Calendar calendar = Calendar.getInstance();
            int month = calendar.get(Calendar.MONTH);
            int date = calendar.get(Calendar.DATE);

            // holidays & events
            if ((month == Calendar.MARCH && date >= 19) && (month == Calendar.APRIL && date <= 30)) {
                return EASTER;
            }
            if ((month == Calendar.OCTOBER && date >= 1) && (month == Calendar.OCTOBER && date <= 31)) {
                return HALLOWEEN;
            }
            if ((month == Calendar.DECEMBER && date >= 1) && (month == Calendar.DECEMBER && date <= 30)) {
                return CHRISTMAS;
            }
            if ((month == Calendar.DECEMBER && date >= 19) && (month == Calendar.DECEMBER && date <= 21)) {
                // mod's birthday is built-in
                return BIRTHDAY;
            }
            if ((month == Calendar.DECEMBER && date == 31) || (month == Calendar.JANUARY && date == 1)
                    || ((month == Calendar.FEBRUARY && date <= 20) && (month == Calendar.JANUARY && date >= 21))) {
                return NEW_YEAR;
            }
            if ((month == Calendar.JANUARY && date >= 21) && (month == Calendar.JANUARY && date <= 27)) {
                // anniversary of patreon site
                return PATREON_ANNIVERSARY;
            }

            // seasons
            if ((month == Calendar.MARCH && date >= 20) && (month == Calendar.JUNE && date <= 20)) {
                return SPRING;
            }
            if ((month == Calendar.JUNE && date >= 20) && (month == Calendar.SEPTEMBER && date <= 20)) {
                return SUMMER;
            }
            if ((month == Calendar.SEPTEMBER && date >= 20) && (month == Calendar.DECEMBER && date <= 20)) {
                return AUTUMN;
            }
            if ((month == Calendar.DECEMBER && date >= 20) && (month == Calendar.MARCH && date <= 20)) {
                return WINTER;
            }

            return NONE;
        }
    }
}