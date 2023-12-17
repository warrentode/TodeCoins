package com.github.warrentode.todecoins.integration;

import net.minecraft.server.level.ServerLevel;
import sereneseasons.api.season.Season;
import sereneseasons.api.season.SeasonHelper;

public class SereneSeasonsCompat {

    public static boolean isAnniversary(ServerLevel level) {
        Season.SubSeason subSeason = SeasonHelper.getSeasonState(level).getSubSeason();
        Season.TropicalSeason tropicalSeason = SeasonHelper.getSeasonState(level).getTropicalSeason();

        return subSeason == Season.SubSeason.EARLY_SPRING || tropicalSeason == Season.TropicalSeason.MID_WET;
    }

    public static boolean isEaster(ServerLevel level) {
        Season.SubSeason subSeason = SeasonHelper.getSeasonState(level).getSubSeason();
        Season.TropicalSeason tropicalSeason = SeasonHelper.getSeasonState(level).getTropicalSeason();

        return subSeason == Season.SubSeason.MID_SPRING || tropicalSeason == Season.TropicalSeason.LATE_WET;
    }

    public static boolean isHalloween(ServerLevel level) {
        Season.SubSeason subSeason = SeasonHelper.getSeasonState(level).getSubSeason();
        Season.TropicalSeason tropicalSeason = SeasonHelper.getSeasonState(level).getTropicalSeason();

        return subSeason == Season.SubSeason.MID_AUTUMN || tropicalSeason == Season.TropicalSeason.LATE_DRY;
    }

    public static boolean isChristmas(ServerLevel level) {
        Season.SubSeason subSeason = SeasonHelper.getSeasonState(level).getSubSeason();
        Season.TropicalSeason tropicalSeason = SeasonHelper.getSeasonState(level).getTropicalSeason();

        return subSeason == Season.SubSeason.EARLY_WINTER || tropicalSeason == Season.TropicalSeason.EARLY_WET;
    }

    public static boolean isBirthday(ServerLevel level) {
        Season.SubSeason subSeason = SeasonHelper.getSeasonState(level).getSubSeason();
        Season.TropicalSeason tropicalSeason = SeasonHelper.getSeasonState(level).getTropicalSeason();

        return subSeason == Season.SubSeason.MID_WINTER || tropicalSeason == Season.TropicalSeason.EARLY_WET;
    }

    public static boolean isNewYear(ServerLevel level) {
        Season.SubSeason subSeason = SeasonHelper.getSeasonState(level).getSubSeason();
        Season.TropicalSeason tropicalSeason = SeasonHelper.getSeasonState(level).getTropicalSeason();

        return subSeason == Season.SubSeason.LATE_WINTER || tropicalSeason == Season.TropicalSeason.MID_WET;
    }

    public static boolean isSpring(ServerLevel level) {
        Season.SubSeason subSeason = SeasonHelper.getSeasonState(level).getSubSeason();
        Season.TropicalSeason tropicalSeason = SeasonHelper.getSeasonState(level).getTropicalSeason();

        return subSeason == Season.SubSeason.EARLY_SPRING || subSeason == Season.SubSeason.MID_SPRING || subSeason == Season.SubSeason.LATE_SPRING
                || tropicalSeason == Season.TropicalSeason.MID_WET || tropicalSeason == Season.TropicalSeason.LATE_WET;
    }

    public static boolean isSummer(ServerLevel level) {
        Season.SubSeason subSeason = SeasonHelper.getSeasonState(level).getSubSeason();
        Season.TropicalSeason tropicalSeason = SeasonHelper.getSeasonState(level).getTropicalSeason();

        return subSeason == Season.SubSeason.EARLY_SUMMER || subSeason == Season.SubSeason.MID_SUMMER || subSeason == Season.SubSeason.LATE_SUMMER
                || tropicalSeason == Season.TropicalSeason.EARLY_DRY || tropicalSeason == Season.TropicalSeason.MID_DRY;
    }

    public static boolean isAutumn(ServerLevel level) {
        Season.SubSeason subSeason = SeasonHelper.getSeasonState(level).getSubSeason();
        Season.TropicalSeason tropicalSeason = SeasonHelper.getSeasonState(level).getTropicalSeason();

        return subSeason == Season.SubSeason.EARLY_AUTUMN || subSeason == Season.SubSeason.MID_AUTUMN || subSeason == Season.SubSeason.LATE_AUTUMN
                || tropicalSeason == Season.TropicalSeason.MID_DRY || tropicalSeason == Season.TropicalSeason.LATE_DRY;
    }

    public static boolean isWinter(ServerLevel level) {
        Season.SubSeason subSeason = SeasonHelper.getSeasonState(level).getSubSeason();
        Season.TropicalSeason tropicalSeason = SeasonHelper.getSeasonState(level).getTropicalSeason();

        return subSeason == Season.SubSeason.EARLY_WINTER || subSeason == Season.SubSeason.MID_WINTER || subSeason == Season.SubSeason.LATE_WINTER
                || tropicalSeason == Season.TropicalSeason.EARLY_WET || tropicalSeason == Season.TropicalSeason.MID_WET;
    }
}