package net.warrentode.todecoins.util;

import net.minecraft.client.Minecraft;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.warrentode.todecoins.TodeCoins;
import sereneseasons.api.season.SeasonHelper;

import java.util.Calendar;

public class CalendarUtil {
    private static Player player = Minecraft.getInstance().player;
    private static Level level = Minecraft.getInstance().level;
    private static Holder<Biome> biome;
    private static Calendar calendar = Calendar.getInstance();
    private static int month = calendar.get(Calendar.MONTH);
    private static int date = calendar.get(Calendar.DATE);

    static {
        assert Minecraft.getInstance().level != null;
        assert player != null;
        biome = Minecraft.getInstance().level.getBiome(player.getOnPos());
    }

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


        public static boolean isChristmas() {
            if (TodeCoins.isSereneSeasonsLoaded()) {
                return SeasonHelper.getSeasonState(level).getSubSeason().equals(sereneseasons.api.season.Season.SubSeason.EARLY_WINTER)
                       || SeasonHelper.getSeasonState(level).getTropicalSeason().equals(sereneseasons.api.season.Season.TropicalSeason.MID_WET);
            }
            else {
                return (month == Calendar.DECEMBER) && (date >= 1 && date <= 31);
            }
        }

        public static boolean isHalloween() {
            if (TodeCoins.isSereneSeasonsLoaded()) {
                return SeasonHelper.getSeasonState(level).getSubSeason().equals(sereneseasons.api.season.Season.SubSeason.MID_AUTUMN)
                       || SeasonHelper.getSeasonState(level).getTropicalSeason().equals(sereneseasons.api.season.Season.TropicalSeason.EARLY_WET);
            }
            else {
                return (month == Calendar.OCTOBER) && (date >= 1 && date <= 31);
            }
        }

        public static boolean isBirthday() {
            if (TodeCoins.isSereneSeasonsLoaded()) {
                return SeasonHelper.getSeasonState(level).getSubSeason().equals(sereneseasons.api.season.Season.SubSeason.MID_WINTER)
                       || SeasonHelper.getSeasonState(level).getTropicalSeason().equals(sereneseasons.api.season.Season.TropicalSeason.LATE_WET);
            }
            else {
                return (month == Calendar.DECEMBER) && (date >= 19 && date <= 21);
            }
        }

        public static boolean isAnniversary() {
            if (TodeCoins.isSereneSeasonsLoaded()) {
                return SeasonHelper.getSeasonState(level).getSubSeason().equals(sereneseasons.api.season.Season.SubSeason.EARLY_SPRING)
                       || SeasonHelper.getSeasonState(level).getTropicalSeason().equals(sereneseasons.api.season.Season.TropicalSeason.EARLY_DRY);
            }
            else {
                return (month == Calendar.JANUARY) && (date >= 21 && date <= 27);
            }
        }

        public static boolean isSpring() {
            if (TodeCoins.isSereneSeasonsLoaded()) {
                return SeasonHelper.getSeasonState(level).getSeason().equals(sereneseasons.api.season.Season.SPRING)
                       || SeasonHelper.getSeasonState(level).getTropicalSeason().equals(sereneseasons.api.season.Season.TropicalSeason.EARLY_DRY)
                       || SeasonHelper.getSeasonState(level).getTropicalSeason().equals(sereneseasons.api.season.Season.TropicalSeason.MID_DRY);
            }
            else {
                return (month == Calendar.MARCH && date >= 20) && (month == Calendar.JUNE && date <= 20);
            }
        }

        public static boolean isSummer() {
            if (TodeCoins.isSereneSeasonsLoaded()) {
                return SeasonHelper.getSeasonState(level).getSeason().equals(sereneseasons.api.season.Season.SUMMER)
                       || SeasonHelper.getSeasonState(level).getTropicalSeason().equals(sereneseasons.api.season.Season.TropicalSeason.LATE_DRY)
                       || SeasonHelper.getSeasonState(level).getTropicalSeason().equals(sereneseasons.api.season.Season.TropicalSeason.MID_DRY);
            }
            else {
                return (month == Calendar.JUNE && date >= 20) && (month == Calendar.SEPTEMBER && date <= 20);
            }
        }

        public static boolean isAutumn() {
            if (TodeCoins.isSereneSeasonsLoaded()) {
                return SeasonHelper.getSeasonState(level).getSeason().equals(sereneseasons.api.season.Season.AUTUMN)
                       || SeasonHelper.getSeasonState(level).getTropicalSeason().equals(sereneseasons.api.season.Season.TropicalSeason.EARLY_WET)
                       || SeasonHelper.getSeasonState(level).getTropicalSeason().equals(sereneseasons.api.season.Season.TropicalSeason.MID_WET);
            }
            else {
                return (month == Calendar.SEPTEMBER && date >= 20) && (month == Calendar.DECEMBER && date <= 20);
            }
        }

        public static boolean isWinter() {
            if (TodeCoins.isSereneSeasonsLoaded()) {
                return SeasonHelper.getSeasonState(level).getSeason().equals(sereneseasons.api.season.Season.WINTER)
                       || SeasonHelper.getSeasonState(level).getTropicalSeason().equals(sereneseasons.api.season.Season.TropicalSeason.LATE_WET)
                       || SeasonHelper.getSeasonState(level).getTropicalSeason().equals(sereneseasons.api.season.Season.TropicalSeason.MID_WET);
            }
            else {
                return (month == Calendar.DECEMBER && date >= 20) && (month == Calendar.MARCH && date <= 20);
            }
        }
    }
}