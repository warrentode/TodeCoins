package net.warrentode.todecoins.util;

import java.util.Calendar;

public class CalendarUtil {
    public CalendarUtil calendarUtil;

    public enum Season {
        NONE,
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

        private static Season get() {
            Calendar calendar = Calendar.getInstance();
            int month = calendar.get(Calendar.MONTH);
            int date = calendar.get(Calendar.DATE);
            if ((month == Calendar.DECEMBER && date >= 21) && (month == Calendar.MARCH && date <= 20)) {
                return WINTER;
            }
            else if ((month == Calendar.MARCH && date >= 20) && (month == Calendar.JUNE && date <= 20)) {
                return SPRING;
            }
            else if ((month == Calendar.JUNE && date >= 20) && (month == Calendar.SEPTEMBER && date <= 22)) {
                return SUMMER;
            }
            else if ((month == Calendar.SEPTEMBER && date >= 22) && (month == Calendar.DECEMBER && date <= 21)) {
                return AUTUMN;
            }
            if ((month == Calendar.DECEMBER && date >= 1) && (month == Calendar.DECEMBER && date <= 31)) {
                return CHRISTMAS;
            }
            else if ((month == Calendar.OCTOBER && date >= 1) && (month == Calendar.OCTOBER && date <= 31)) {
                return HALLOWEEN;
            }
            if ((month == Calendar.SEPTEMBER && date <= 28) && (month == Calendar.OCTOBER && date >= 4)) {
                return BIRTHDAY;
            }
            else if ((month == Calendar.APRIL && date <= 10) && (month == Calendar.APRIL && date >= 16)) {
                return BIRTHDAY;
            }
            else if ((month == Calendar.SEPTEMBER && date <= 17) && (month == Calendar.APRIL && date >= 24)) {
                return BIRTHDAY;
            }
            else if ((month == Calendar.MARCH && date <= 29) && (month == Calendar.APRIL && date >= 4)) {
                return BIRTHDAY;
            }
            return NONE;
        }
    }
}