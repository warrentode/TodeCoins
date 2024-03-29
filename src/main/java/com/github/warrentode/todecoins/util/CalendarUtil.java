package com.github.warrentode.todecoins.util;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.server.ServerLifecycleHooks;
import sereneseasons.api.season.Season;
import sereneseasons.api.season.SeasonHelper;

import java.util.Calendar;
import java.util.Objects;

public class CalendarUtil {
    public static Boolean isSeason;
    public String season;

    public static boolean check(String season) {
        if (ModList.get().isLoaded("sereneseasons")) {
            MinecraftServer minecraftServer = ServerLifecycleHooks.getCurrentServer().getPlayerList().getServer();
            //noinspection ConstantValue
            if (minecraftServer != null) {
                ServerLevel serverLevel = minecraftServer.createCommandSourceStack().getLevel();
                if (Objects.equals(season, "ANNIVERSARY")) {
                    return isSeason = CalendarUtil.isAnniversary(serverLevel);
                }
                if (Objects.equals(season, "BIRTHDAY")) {
                    return isSeason = CalendarUtil.isBirthday(serverLevel);
                }
                if (Objects.equals(season, "HALLOWEEN")) {
                    return isSeason = CalendarUtil.isHalloween(serverLevel);
                }
                if (Objects.equals(season, "CHRISTMAS")) {
                    return isSeason = CalendarUtil.isChristmas(serverLevel);
                }
                if (Objects.equals(season, "EASTER")) {
                    return isSeason = CalendarUtil.isEaster(serverLevel);
                }
                if (Objects.equals(season, "NEW_YEAR")) {
                    return isSeason = CalendarUtil.isNewYear(serverLevel);
                }
                if (Objects.equals(season, "SPRING")) {
                    return isSeason = CalendarUtil.isSpring(serverLevel);
                }
                if (Objects.equals(season, "SUMMER")) {
                    return isSeason = CalendarUtil.isSummer(serverLevel);
                }
                if (Objects.equals(season, "AUTUMN")) {
                    return isSeason = CalendarUtil.isAutumn(serverLevel);
                }
                if (Objects.equals(season, "WINTER")) {
                    return isSeason = CalendarUtil.isWinter(serverLevel);
                }
            }
        }
        return false;
    }

    public static boolean isAnniversary(ServerLevel level) {
        if (ModList.get().isLoaded("sereneseasons") && level.dimension() == Level.OVERWORLD) {
            Season.SubSeason subSeason = SeasonHelper.getSeasonState(level).getSubSeason();
            return subSeason == Season.SubSeason.EARLY_SPRING;
        }
        else if (!ModList.get().isLoaded("sereneseasons") || level.dimension() != Level.OVERWORLD) {
            Calendar calendar = Calendar.getInstance();
            int month = calendar.get(Calendar.MONTH);
            int date = calendar.get(Calendar.DATE);

            // week of the blog's first post on Patreon anniversary
            return month == Calendar.JANUARY && (date >= 21 && date <= 27);
        }
        else {
            return false;
        }
    }

    public static boolean isEaster(ServerLevel level) {
        if (ModList.get().isLoaded("sereneseasons") && level.dimension() == Level.OVERWORLD) {
            Season.SubSeason subSeason = SeasonHelper.getSeasonState(level).getSubSeason();
            return subSeason == Season.SubSeason.MID_SPRING;
        }
        else if (!ModList.get().isLoaded("sereneseasons") || level.dimension() != Level.OVERWORLD) {
            Calendar calendar = Calendar.getInstance();
            int month = calendar.get(Calendar.MONTH);
            int date = calendar.get(Calendar.DATE);

            return (month == Calendar.MARCH && date >= 19) || month == Calendar.APRIL;
        }
        else {
            return false;
        }
    }

    public static boolean isHalloween(ServerLevel level) {
        if (ModList.get().isLoaded("sereneseasons") && level.dimension() == Level.OVERWORLD) {
            Season.SubSeason subSeason = SeasonHelper.getSeasonState(level).getSubSeason();
            return subSeason == Season.SubSeason.MID_AUTUMN;
        }
        else if (!ModList.get().isLoaded("sereneseasons") || level.dimension() != Level.OVERWORLD) {
            Calendar calendar = Calendar.getInstance();
            int month = calendar.get(Calendar.MONTH);

            return month == Calendar.OCTOBER;
        }
        else {
            return false;
        }
    }

    public static boolean isChristmas(ServerLevel level) {
        if (ModList.get().isLoaded("sereneseasons") && level.dimension() == Level.OVERWORLD) {
            Season.SubSeason subSeason = SeasonHelper.getSeasonState(level).getSubSeason();
            return subSeason == Season.SubSeason.EARLY_WINTER;
        }
        else if (!ModList.get().isLoaded("sereneseasons") || level.dimension() != Level.OVERWORLD) {
            Calendar calendar = Calendar.getInstance();
            int month = calendar.get(Calendar.MONTH);

            return month == Calendar.DECEMBER;
        }
        else {
            return false;
        }
    }

    public static boolean isBirthday(ServerLevel level) {
        if (ModList.get().isLoaded("sereneseasons") && level.dimension() == Level.OVERWORLD) {
            Season.SubSeason subSeason = SeasonHelper.getSeasonState(level).getSubSeason();
            return subSeason == Season.SubSeason.MID_WINTER;
        }
        else if (!ModList.get().isLoaded("sereneseasons") || level.dimension() != Level.OVERWORLD) {
            Calendar calendar = Calendar.getInstance();
            int month = calendar.get(Calendar.MONTH);
            int date = calendar.get(Calendar.DATE);

            // week of this mod's birthday
            return month == Calendar.DECEMBER && (date >= 19 && date <= 21);
        }
        else {
            return false;
        }
    }

    public static boolean isNewYear(ServerLevel level) {
        if (ModList.get().isLoaded("sereneseasons") && level.dimension() == Level.OVERWORLD) {
            Season.SubSeason subSeason = SeasonHelper.getSeasonState(level).getSubSeason();
            return subSeason == Season.SubSeason.LATE_WINTER;
        }
        else if (!ModList.get().isLoaded("sereneseasons") || level.dimension() != Level.OVERWORLD) {
            Calendar calendar = Calendar.getInstance();
            int month = calendar.get(Calendar.MONTH);
            int date = calendar.get(Calendar.DATE);

            // Georgian and lunisolar calendar time frames
            return (month == Calendar.DECEMBER && date == 31) || (month == Calendar.JANUARY && date == 1)
                    || ((month == Calendar.FEBRUARY && date <= 20) || (month == Calendar.JANUARY && date >= 21));
        }
        else {
            return false;
        }
    }

    public static boolean isSpring(ServerLevel level) {
        if (ModList.get().isLoaded("sereneseasons") && level.dimension() == Level.OVERWORLD) {
            Season.SubSeason subSeason = SeasonHelper.getSeasonState(level).getSubSeason();
            return subSeason == Season.SubSeason.EARLY_SPRING
                    || subSeason == Season.SubSeason.MID_SPRING
                    || subSeason == Season.SubSeason.LATE_SPRING;
        }
        else if (!ModList.get().isLoaded("sereneseasons") || level.dimension() != Level.OVERWORLD) {
            Calendar calendar = Calendar.getInstance();
            int month = calendar.get(Calendar.MONTH);
            int date = calendar.get(Calendar.DATE);

            return (month == Calendar.MARCH && date >= 20) || (month == Calendar.JUNE && date <= 20);
        }
        else {
            return false;
        }
    }

    public static boolean isSummer(ServerLevel level) {
        if (ModList.get().isLoaded("sereneseasons") && level.dimension() == Level.OVERWORLD) {
            Season.SubSeason subSeason = SeasonHelper.getSeasonState(level).getSubSeason();
            return subSeason == Season.SubSeason.EARLY_SUMMER
                    || subSeason == Season.SubSeason.MID_SUMMER
                    || subSeason == Season.SubSeason.LATE_SUMMER;
        }
        else if (!ModList.get().isLoaded("sereneseasons") || level.dimension() != Level.OVERWORLD) {
            Calendar calendar = Calendar.getInstance();
            int month = calendar.get(Calendar.MONTH);
            int date = calendar.get(Calendar.DATE);

            return (month == Calendar.JUNE && date >= 20) || (month == Calendar.SEPTEMBER && date <= 20);
        }
        else {
            return false;
        }
    }

    public static boolean isAutumn(ServerLevel level) {
        if (ModList.get().isLoaded("sereneseasons") && level.dimension() == Level.OVERWORLD) {
            Season.SubSeason subSeason = SeasonHelper.getSeasonState(level).getSubSeason();
            return subSeason == Season.SubSeason.EARLY_AUTUMN
                    || subSeason == Season.SubSeason.MID_AUTUMN
                    || subSeason == Season.SubSeason.LATE_AUTUMN;
        }
        else if (!ModList.get().isLoaded("sereneseasons") || level.dimension() != Level.OVERWORLD) {
            Calendar calendar = Calendar.getInstance();
            int month = calendar.get(Calendar.MONTH);
            int date = calendar.get(Calendar.DATE);

            return (month == Calendar.SEPTEMBER && date >= 20) || (month == Calendar.DECEMBER && date <= 20);
        }
        else {
            return false;
        }
    }

    public static boolean isWinter(ServerLevel level) {
        if (ModList.get().isLoaded("sereneseasons") && level.dimension() == Level.OVERWORLD) {
            Season.SubSeason subSeason = SeasonHelper.getSeasonState(level).getSubSeason();
            return subSeason == Season.SubSeason.EARLY_WINTER
                    || subSeason == Season.SubSeason.MID_WINTER
                    || subSeason == Season.SubSeason.LATE_WINTER;
        }
        else if (!ModList.get().isLoaded("sereneseasons") || level.dimension() != Level.OVERWORLD) {
            Calendar calendar = Calendar.getInstance();
            int month = calendar.get(Calendar.MONTH);
            int date = calendar.get(Calendar.DATE);

            return (month == Calendar.DECEMBER && date >= 20) || (month == Calendar.MARCH && date <= 20);
        }
        else {
            return false;
        }
    }
}