package com.github.warrentode.util;

import java.util.Calendar;

public class CalendarUtil {
    public CalendarUtil calendarUtil;

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

            // seasons
            if ((month == Calendar.DECEMBER && date >= 20) && (month == Calendar.MARCH && date <= 20)) {
                return WINTER;
            }
            else if ((month == Calendar.MARCH && date >= 20) && (month == Calendar.JUNE && date <= 20)) {
                return SPRING;
            }
            else if ((month == Calendar.JUNE && date >= 20) && (month == Calendar.SEPTEMBER && date <= 20)) {
                return SUMMER;
            }
            else if ((month == Calendar.SEPTEMBER && date >= 20) && (month == Calendar.DECEMBER && date <= 20)) {
                return AUTUMN;
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

            return NONE;
        }
    }
}