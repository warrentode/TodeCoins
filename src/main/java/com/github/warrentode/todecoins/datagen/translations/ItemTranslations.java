package com.github.warrentode.todecoins.datagen.translations;

import com.github.warrentode.todecoins.datagen.translations.items.CurrencyItemTranslations;
import com.github.warrentode.todecoins.datagen.translations.items.FoodTranslations;
import com.github.warrentode.todecoins.datagen.translations.items.MiscItemTranslations;
import com.github.warrentode.todecoins.datagen.translations.items.collectible_coins.*;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ItemTranslations {
    // Map of item IDs → (language code → translated name)
    public static final Map<String, Map<String, String>> LANG_MAPS = createTranslations();

    public static @NotNull Map<String, Map<String, String>> createTranslations() {
        Map<String, Map<String, String>> combined = new HashMap<>();

        // Get item translations (e.g., from FoodTranslations, etc.)
        Map<String, Map<String, String>> foodTranslations = FoodTranslations.LANG_MAPS;
        Map<String, Map<String, String>> miscItemTranslations = MiscItemTranslations.LANG_MAPS;
        Map<String, Map<String, String>> currencyItemTranslations = CurrencyItemTranslations.LANG_MAPS;
        Map<String, Map<String, String>> holidayCoinTranslations = HolidayCoinTranslations.LANG_MAPS;
        Map<String, Map<String, String>> supporterCoinTranslations = SupporterCoinTranslations.LANG_MAPS;
        Map<String, Map<String, String>> gameplayCoinTranslations = GameplayCoinTranslations.LANG_MAPS;
        Map<String, Map<String, String>> bossCoinTranslations = BossCoinTranslations.LANG_MAPS;
        Map<String, Map<String, String>> flyingEntityCoinTranslations = AerialEntityCoinTranslations.LANG_MAPS;
        Map<String, Map<String, String>> waterEntityCoinTranslations = AquaticEntityCoinTranslations.LANG_MAPS;
        Map<String, Map<String, String>> arthropodEntityCoinTranslations = ArthropodCoinTranslations.LANG_MAPS;
        Map<String, Map<String, String>> miscCreatureCoinTranslations = MiscCreatureCoinTranslations.LANG_MAPS;
        Map<String, Map<String, String>> steedCoinTranslations = SteedCoinTranslations.LANG_MAPS;
        Map<String, Map<String, String>> animalCoinTranslations = AnimalCoinTranslations.LANG_MAPS;
        Map<String, Map<String, String>> zombieCoinTranslations = UndeadCoinTranslations.LANG_MAPS;
        Map<String, Map<String, String>> raiderCoinTranslations = RaiderCoinTranslations.LANG_MAPS;
        Map<String, Map<String, String>> slimeCoinTranslations = SlimeCoinTranslations.LANG_MAPS;
        Map<String, Map<String, String>> golemCoinTranslations = GolemCoinTranslations.LANG_MAPS;
        Map<String, Map<String, String>> merchantCoinTranslations = MerchantCoinTranslations.LANG_MAPS;
        Map<String, Map<String, String>> piglinCoinTranslations = PiglinCoinTranslations.LANG_MAPS;
        Map<String, Map<String, String>> skeletonCoinTranslations = SkeletonCoinTranslations.LANG_MAPS;

        // Merge them
        Set<String> locales = new HashSet<>();

        locales.addAll(foodTranslations.keySet());
        locales.addAll(miscItemTranslations.keySet());
        locales.addAll(currencyItemTranslations.keySet());
        locales.addAll(holidayCoinTranslations.keySet());
        locales.addAll(supporterCoinTranslations.keySet());
        locales.addAll(gameplayCoinTranslations.keySet());
        locales.addAll(bossCoinTranslations.keySet());
        locales.addAll(flyingEntityCoinTranslations.keySet());
        locales.addAll(waterEntityCoinTranslations.keySet());
        locales.addAll(arthropodEntityCoinTranslations.keySet());
        locales.addAll(miscCreatureCoinTranslations.keySet());
        locales.addAll(steedCoinTranslations.keySet());
        locales.addAll(animalCoinTranslations.keySet());
        locales.addAll(zombieCoinTranslations.keySet());
        locales.addAll(raiderCoinTranslations.keySet());
        locales.addAll(slimeCoinTranslations.keySet());
        locales.addAll(golemCoinTranslations.keySet());
        locales.addAll(merchantCoinTranslations.keySet());
        locales.addAll(piglinCoinTranslations.keySet());
        locales.addAll(skeletonCoinTranslations.keySet());

        for (String locale : locales) {
            Map<String, String> combinedLocaleMap = new HashMap<>();

            // Merge translations from all sources for each locale

            combinedLocaleMap.putAll(foodTranslations.getOrDefault(locale, Map.of()));
            combinedLocaleMap.putAll(miscItemTranslations.getOrDefault(locale, Map.of()));
            combinedLocaleMap.putAll(currencyItemTranslations.getOrDefault(locale, Map.of()));
            combinedLocaleMap.putAll(holidayCoinTranslations.getOrDefault(locale, Map.of()));
            combinedLocaleMap.putAll(supporterCoinTranslations.getOrDefault(locale, Map.of()));
            combinedLocaleMap.putAll(gameplayCoinTranslations.getOrDefault(locale, Map.of()));
            combinedLocaleMap.putAll(bossCoinTranslations.getOrDefault(locale, Map.of()));
            combinedLocaleMap.putAll(flyingEntityCoinTranslations.getOrDefault(locale, Map.of()));
            combinedLocaleMap.putAll(waterEntityCoinTranslations.getOrDefault(locale, Map.of()));
            combinedLocaleMap.putAll(arthropodEntityCoinTranslations.getOrDefault(locale, Map.of()));
            combinedLocaleMap.putAll(miscCreatureCoinTranslations.getOrDefault(locale, Map.of()));
            combinedLocaleMap.putAll(steedCoinTranslations.getOrDefault(locale, Map.of()));
            combinedLocaleMap.putAll(animalCoinTranslations.getOrDefault(locale, Map.of()));
            combinedLocaleMap.putAll(zombieCoinTranslations.getOrDefault(locale, Map.of()));
            combinedLocaleMap.putAll(raiderCoinTranslations.getOrDefault(locale, Map.of()));
            combinedLocaleMap.putAll(slimeCoinTranslations.getOrDefault(locale, Map.of()));
            combinedLocaleMap.putAll(golemCoinTranslations.getOrDefault(locale, Map.of()));
            combinedLocaleMap.putAll(merchantCoinTranslations.getOrDefault(locale, Map.of()));
            combinedLocaleMap.putAll(piglinCoinTranslations.getOrDefault(locale, Map.of()));
            combinedLocaleMap.putAll(skeletonCoinTranslations.getOrDefault(locale, Map.of()));

            // Add the merged locale map to the final combined map
            combined.put(locale, combinedLocaleMap);
        }

        return combined;
    }
}