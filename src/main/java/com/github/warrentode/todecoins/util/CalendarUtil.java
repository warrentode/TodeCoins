package com.github.warrentode.todecoins.util;

import java.util.Calendar;

public class CalendarUtil {

    public static boolean isAnniversary() {
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH);
        int date = calendar.get(Calendar.DATE);

        return month == Calendar.JANUARY && (date >= 21 && date <= 27);
    }

    public static boolean isEaster() {
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH);
        int date = calendar.get(Calendar.DATE);

        return (month == Calendar.MARCH && date >= 19) && (month == Calendar.APRIL && date <= 30);
    }

    public static boolean isHalloween() {
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH);
        int date = calendar.get(Calendar.DATE);

        return month == Calendar.OCTOBER && (date >= 1 && date <= 31);
    }

    public static boolean isChristmas() {
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH);
        int date = calendar.get(Calendar.DATE);

        return month == Calendar.DECEMBER && (date >= 1 && date <= 31);
    }

    // week of this mod's birthday
    public static boolean isBirthday() {
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH);
        int date = calendar.get(Calendar.DATE);

        return month == Calendar.DECEMBER && (date >= 19 && date <= 21);
    }

    public static boolean isNewYear() {
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH);
        int date = calendar.get(Calendar.DATE);

        // Georgian and lunisolar calendar dates
        return (month == Calendar.DECEMBER && date == 31) || (month == Calendar.JANUARY && date == 1)
                || ((month == Calendar.FEBRUARY && date <= 20) && (month == Calendar.JANUARY && date >= 21));
    }

    public static boolean isSpring() {
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH);
        int date = calendar.get(Calendar.DATE);

        return (month == Calendar.MARCH && date >= 20) && (month == Calendar.JUNE && date <= 20);
    }

    public static boolean isSummer() {
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH);
        int date = calendar.get(Calendar.DATE);

        return (month == Calendar.JUNE && date >= 20) && (month == Calendar.SEPTEMBER && date <= 20);
    }

    public static boolean isAutumn() {
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH);
        int date = calendar.get(Calendar.DATE);

        return (month == Calendar.SEPTEMBER && date >= 20) && (month == Calendar.DECEMBER && date <= 20);
    }

    public static boolean isWinter() {
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH);
        int date = calendar.get(Calendar.DATE);

        return (month == Calendar.DECEMBER && date >= 20) && (month == Calendar.MARCH && date <= 20);
    }
}