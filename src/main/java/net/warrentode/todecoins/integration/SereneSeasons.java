package net.warrentode.todecoins.integration;

import net.minecraft.client.Minecraft;
import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import sereneseasons.api.season.SeasonHelper;

import static sereneseasons.api.season.Season.SubSeason.*;
import static sereneseasons.api.season.Season.TropicalSeason.*;

public class SereneSeasons {
    static RandomSource random = RandomSource.create();
    private static Player player = Minecraft.getInstance().player;
    private static Level level = Minecraft.getInstance().level;
    private static Holder<Biome> biome;

    static {
        assert Minecraft.getInstance().level != null;
        assert player != null;
        biome = Minecraft.getInstance().level.getBiome(player.getOnPos());
    }

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
            return get() == WINTER;
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
            sereneseasons.api.season.Season.SubSeason subSeason = SeasonHelper.getSeasonState(level).getSubSeason();
            sereneseasons.api.season.Season.TropicalSeason tropicalSeason = SeasonHelper.getSeasonState(level).getTropicalSeason();

            // regular seasons
            if (!SeasonHelper.usesTropicalSeasons(biome) && subSeason == EARLY_WINTER) {
                return WINTER;
            }
            else if (!SeasonHelper.usesTropicalSeasons(biome) && subSeason == MID_WINTER) {
                return WINTER;
            }
            else if (!SeasonHelper.usesTropicalSeasons(biome) && subSeason == LATE_WINTER) {
                return WINTER;
            }
            else if (!SeasonHelper.usesTropicalSeasons(biome) && subSeason == EARLY_SPRING) {
                return SPRING;
            }
            else if (!SeasonHelper.usesTropicalSeasons(biome) && subSeason == MID_SPRING) {
                return SPRING;
            }
            else if (!SeasonHelper.usesTropicalSeasons(biome) && subSeason == LATE_SPRING) {
                return SPRING;
            }
            else if (!SeasonHelper.usesTropicalSeasons(biome) && subSeason == EARLY_SUMMER) {
                return SUMMER;
            }
            else if (!SeasonHelper.usesTropicalSeasons(biome) && subSeason == MID_SUMMER) {
                return SUMMER;
            }
            else if (!SeasonHelper.usesTropicalSeasons(biome) && subSeason == LATE_SUMMER) {
                return SUMMER;
            }
            else if (!SeasonHelper.usesTropicalSeasons(biome) && subSeason == EARLY_AUTUMN) {
                return AUTUMN;
            }
            else if (!SeasonHelper.usesTropicalSeasons(biome) && subSeason == MID_AUTUMN) {
                return AUTUMN;
            }
            else if (!SeasonHelper.usesTropicalSeasons(biome) && subSeason == LATE_AUTUMN) {
                return AUTUMN;
            }

            // holiday regular seasons
            if (!SeasonHelper.usesTropicalSeasons(biome) && subSeason == EARLY_WINTER) {
                return CHRISTMAS;
            }
            else if (!SeasonHelper.usesTropicalSeasons(biome) && subSeason == MID_WINTER) {
                return PATREON_ANNIVERSARY;
            }
            else if (!SeasonHelper.usesTropicalSeasons(biome) && subSeason == MID_AUTUMN) {
                return HALLOWEEN;
            }
            else if (!SeasonHelper.usesTropicalSeasons(biome) && subSeason == LATE_AUTUMN) {
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
            else if (tropicalSeason == MID_WET) {
                return PATREON_ANNIVERSARY;
            }
            else if (tropicalSeason == MID_DRY) {
                return HALLOWEEN;
            }
            else if (tropicalSeason == LATE_DRY) {
                return BIRTHDAY;
            }

            return NONE;
        }
    }
}