package com.github.warrentode.todecoins.datagen;

import com.github.warrentode.todecoins.block.TCBlocks;
import com.github.warrentode.todecoins.datagen.translations.*;
import com.github.warrentode.todecoins.datagen.translations.effects.VanillaEffectNameTranslations;
import com.github.warrentode.todecoins.effect.TCMobEffects;
import com.github.warrentode.todecoins.entity.TCEntityTypes;
import com.github.warrentode.todecoins.entity.villager.TCVillagers;
import com.github.warrentode.todecoins.item.TCItems;
import com.github.warrentode.todecoins.util.tabs.TCCreativeTabs;
import com.github.warrentode.todecoins.datagen.translations.effects.EffectNameTranslations;
import com.github.warrentode.todecoins.datagen.translations.effects.EffectPrefixTranslations;
import net.minecraft.data.PackOutput;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import net.minecraft.world.item.Item;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * LanguageFileGen fully working as of 2025-08-17
 */

public class LanguageFilesGen extends LanguageProvider {
    private final String locale;
    private final Map<String, Map<String, Map<String, String>>> prefixTranslations;

    public LanguageFilesGen(PackOutput output, String modId, String locale) {
        super(output, modId, locale);
        this.locale = locale;
        this.prefixTranslations = EffectPrefixTranslations.createPrefixMap(); // Prefixes
    }

    @Override
    protected final void addTranslations() {
        // locales to be translated
        Set<String> all_locales = Set.of(
                "en_us", "en_gb", "en_ca", "en_au", "en_pt",
                "de_de", "fr_fr", "fr_ca", "es_es", "es_mx", "pt_pt", "pt_br",
                "it_it", "nl_nl", "ru_ru", "uk_ua", "pl_pl", "cs_cz", "sk_sk",
                "hu_hu", "sv_se", "no_no", "da_dk", "fi_fi", "tr_tr", "el_gr",
                "ro_ro", "bg_bg", "zh_cn", "zh_tw", "ja_jp", "ko_kr", "th_th",
                "ar_sa", "he_il", "hi_in", "id_id", "ms_my"
        );

        // MISSING ITEM TRANSLATIONS CHECK
        // Loop over all your items
        for (RegistryObject<Item> itemEntry : TCItems.ITEMS.getEntries()) {
            if (itemEntry.get() instanceof BlockItem) {
                continue; // skip block items
            }

            String itemPath = itemEntry.getId().getPath(); // e.g., "coin_dolphin"

            // Check if the translation exists at all
            if (!ItemTranslations.LANG_MAPS.containsKey(itemPath)) {
                System.out.println("Missing translation entry for item: " + itemPath);
            }
            else {
                Map<String, String> localeMap = ItemTranslations.LANG_MAPS.get(itemPath);
                for (String locale : all_locales) {
                    if (!localeMap.containsKey(locale)) {
                        System.out.println("Missing translation for item '" + itemPath + "' in locale: " + locale);
                    }
                }
            }
        }

        // ---- Block translations ----
        for (RegistryObject<Block> blockEntry : TCBlocks.BLOCKS.getEntries()) {
            String blockKey = blockEntry.get().getDescriptionId(); // full key: "block.todecoins.coin_press"
            Map<String, String> localeMap = BlockTranslations.LANG_MAPS.getOrDefault(blockKey, Map.of());

            String blockName = localeMap.getOrDefault(locale, formatName(blockKey));
            add(blockKey, blockName);
        }

        // ---- Item translations (skip BlockItems) ----
        for (RegistryObject<Item> itemEntry : TCItems.ITEMS.getEntries()) {
            if (itemEntry.get() instanceof BlockItem) {
                continue; // ignore menu-only block items
            }

            String itemPath = itemEntry.getId().getPath(); // short key, e.g., "bracelet_friendship_echo"
            Map<String, String> localeMap = ItemTranslations.LANG_MAPS.getOrDefault(itemPath, Map.of());

            String itemName = localeMap.getOrDefault(locale, formatName(itemPath));
            String itemKey = itemEntry.get().getDescriptionId(); // full key: "item.todecoins.bracelet_friendship_echo"
            add(itemKey, itemName);
        }

        // ---- Entity translations ----
        for (RegistryObject<EntityType<?>> entityEntry : TCEntityTypes.ENTITY_TYPES.getEntries()) {
            String entityKey = entityEntry.get().getDescriptionId(); // full key: entity.todecoins.numismatist
            Map<String, String> localeMap = EntityTranslations.LANG_MAPS.getOrDefault(entityKey, Map.of());

            String entityName = localeMap.getOrDefault(locale, formatName(entityEntry.getId().getPath()));
            add(entityKey, entityName);
        }

        // ---- Custom Villager Profession translations ----
        for (RegistryObject<VillagerProfession> professionEntry : TCVillagers.VILLAGER_PROFESSIONS.getEntries()) {
            // Full translation key for the profession
            String professionKey = "entity.minecraft.villager.todecoins." + professionEntry.getId().getPath();

            // Get locale map for this profession
            Map<String, String> localeMap = EntityTranslations.LANG_MAPS.getOrDefault(professionKey, Map.of());

            // Pick translation for the current locale, fallback to formatted path
            String professionName = localeMap.getOrDefault(locale, formatName(professionEntry.getId().getPath()));

            add(professionKey, professionName);
        }

        // ---- Creative tab translations ----
        Map<String, String> creativeTabOverrides = TCCreativeTabs.getTranslationOverrides().getOrDefault(locale, Map.of());
        for (RegistryObject<CreativeModeTab> tabEntry : TCCreativeTabs.CREATIVE_TABS.getEntries()) {
            String tabKey = "itemGroup." + tabEntry.getId().getPath();
            String tabName = creativeTabOverrides.getOrDefault(tabEntry.getId().getPath(),
                    formatName(tabEntry.getId().getPath()));
            add(tabKey, tabName);
        }

        // ---- Subtitle translations ----
        for (Map.Entry<String, Map<String, String>> subtitleEntry : SubtitleTranslations.LANG_MAPS.entrySet()) {
            String subtitleKey = subtitleEntry.getKey(); // e.g., "subtitles.todecoins.coin_press_take"
            Map<String, String> localeMap = subtitleEntry.getValue(); // locale → translation

            String nameForCurrentLocale = localeMap.getOrDefault(locale, formatName(subtitleKey));
            add(subtitleKey, nameForCurrentLocale);
        }

        // ---- Container translations ----
        for (Map.Entry<String, Map<String, String>> containerEntry : ContainerTranslations.LANG_MAPS.entrySet()) {
            String containerKey = containerEntry.getKey(); // e.g., "container.coin_press_block_gui"
            Map<String, String> localeMap = containerEntry.getValue(); // locale → translation

            String nameForCurrentLocale = localeMap.getOrDefault(locale, formatName(containerKey));
            add(containerKey, nameForCurrentLocale);
        }

        // ---- Tooltip translations ----
        Map<String, String> tooltipTranslations = TooltipTranslations.LANG_MAPS.getOrDefault(locale, Map.of());
        for (Map.Entry<String, String> tooltipEntry : tooltipTranslations.entrySet()) {
            add(tooltipEntry.getKey(), tooltipEntry.getValue());
        }
        add(TooltipTranslations.tooltipPrefix + "shift.hover", TooltipTranslations.getTooltipShift(locale));

        // ---- Special Handling translations ----
        for (Map.Entry<String, Map<String, String>> entry : SpecialHandlingTranslations.LANG_MAPS_PREFIX.entrySet()) {
            String translationKey = entry.getKey(); // e.g., "today_is"
            Map<String, String> localeMap = entry.getValue();

            String translationForCurrentLocale = localeMap.getOrDefault(locale, translationKey);
            add(translationKey, translationForCurrentLocale);
        }

        for (Map.Entry<String, Map<String, String>> entry : SpecialHandlingTranslations.LANG_MAPS_SUFFIX.entrySet()) {
            String translationKey = entry.getKey(); // e.g., "today_suffix"
            Map<String, String> localeMap = entry.getValue();

            String translationForCurrentLocale = localeMap.getOrDefault(locale, translationKey);
            add(translationKey, translationForCurrentLocale);
        }

        for (Map.Entry<String, Map<String, String>> entry : SpecialHandlingTranslations.LANG_MAPS_BRACELETS.entrySet()) {
            String translationKey = entry.getKey(); // e.g., "braceletId.linked"
            Map<String, String> localeMap = entry.getValue();

            String translationForCurrentLocale = localeMap.getOrDefault(locale, translationKey);
            add(translationKey, translationForCurrentLocale);
        }

        for (Map.Entry<String, Map<String, String>> entry : SpecialHandlingTranslations.LANG_MAPS_ATTRIBUTES.entrySet()) {
            String translationKey = entry.getKey(); // e.g., "attribute.name.todecoins.charisma"
            Map<String, String> localeMap = entry.getValue();

            String translationForCurrentLocale = localeMap.getOrDefault(locale, translationKey);
            add(translationKey, translationForCurrentLocale);
        }

        // ---- Keybind translations ----
        for (Map.Entry<String, Map<String, String>> entry : KeybindTranslations.LANG_MAPS.entrySet()) {
            String translationKey = entry.getKey(); // e.g., "key.categories.todecoins"
            Map<String, String> localeMap = entry.getValue();

            String translationForCurrentLocale = localeMap.getOrDefault(locale, translationKey);
            add(translationKey, translationForCurrentLocale);
        }

        // ---- Map translations with tooltips ----
        for (Map.Entry<String, Map<String, String>> entry : MapTranslations.LANG_MAPS.entrySet()) {
            String key = entry.getKey(); // e.g., "filled_map.settlement"
            Map<String, String> localeMap = entry.getValue();

            // Get the map name for the current locale
            String nameForCurrentLocale = localeMap.getOrDefault(locale, formatName(key));
            add(key, nameForCurrentLocale);

            // Use the generic tooltipPerLocale
            Map<String, String> tooltipMap = MapTranslations.TOOLTIP_PER_LOCALE.get("tooltipPerLocale");
            if (tooltipMap != null) {
                String tooltipForCurrentLocale = tooltipMap.getOrDefault(locale, "Reveals the location of something interesting...");
                add(key + ".tooltip", tooltipForCurrentLocale);
            }
        }

        // ---- Advancement translations with description ----
        for (Map.Entry<String, Map<String, String>> entry : AdvancementTranslations.COIN_SET_MAPS.entrySet()) {
            String key = entry.getKey();
            Map<String, String> localeMap = entry.getValue();

            // Get the coin set name for the current locale
            String nameForCurrentLocale = localeMap.getOrDefault(locale, formatName(key));
            add("advancement." + key, nameForCurrentLocale);

            // Use the generic coinSetDescPerLocale
            Map<String, String> coinDescMap = AdvancementTranslations.COIN_SET_DESC_MAPS.get("coin_set_desc");
            if (coinDescMap != null) {
                String coinDescForCurrentLocale = coinDescMap.getOrDefault(locale, "Find the Entire Set");
                add("advancement." + key + ".desc", coinDescForCurrentLocale);
            }
        }
        for (Map.Entry<String, Map<String, String>> entry : AdvancementTranslations.ADVANCEMENT_LANG_MAPS.entrySet()) {
            String key = entry.getKey();
            Map<String, String> localeMap = entry.getValue();

            // Get the advancement name for the current locale
            String nameForCurrentLocale = localeMap.getOrDefault(locale, formatName(key));
            add("advancement." + key, nameForCurrentLocale);
        }

        // ---- Unified effect translations (modded + vanilla) ----
        Set<String> allEffectIds = new HashSet<>();
        //noinspection CollectionAddAllCanBeReplacedWithConstructor
        allEffectIds.addAll(TCMobEffects.MOB_EFFECTS.getEntries().stream().map(effectEntry -> effectEntry.getId().getPath()).toList());

        // minecraft translations for luck and unluck
        for (Map.Entry<String, Map<String, String>> entry : VanillaEffectNameTranslations.LANG_MAPS.entrySet()) {
            String key = entry.getKey(); // effect.minecraft.luck or effect.minecraft.unluck
            Map<String, String> localeMap = entry.getValue();

            String nameForCurrentLocale = localeMap.getOrDefault(locale, formatName(key));
            add(key, nameForCurrentLocale);
        }

        // Include vanilla effects
        allEffectIds.add(Objects.requireNonNull(ForgeRegistries.MOB_EFFECTS.getKey(MobEffects.LUCK)).getPath());
        allEffectIds.add(Objects.requireNonNull(ForgeRegistries.MOB_EFFECTS.getKey(MobEffects.UNLUCK)).getPath());

        for (String effectId : allEffectIds) {
            String effectKey = "effect.todecoins." + effectId;

            // ---- Use EffectNameTranslations class strictly ----
            String effectName = EffectNameTranslations.getEffectName(effectId, locale);

            if (effectName.equals(effectId)) { // fallback triggered
                System.out.println("[Warning] Missing translation for effect key: " + effectKey + " in locale: " + locale + ". Using fallback.");
            }

            add(effectKey, effectName);
            generateAllPotionAndArrowVariants(effectId, effectName);

            // ---- Safety check for missing locales ----
            for (String checkLocale : all_locales) {
                String nameCheck = EffectNameTranslations.getEffectName(effectId, checkLocale);
                if (nameCheck.equals(effectId)) {
                    System.out.println("[Warning] Missing translation for effect '" + effectId + "' in locale: " + checkLocale);
                }
            }
        }
    }

    // ---- Helper to generate potions & arrows for a single effect ----
    // Note: This method loops through all levels and uses prefix maps for each locale.
    // If you add new potion types, levels, or locales in the future, you can update
    // the EffectPrefixTranslations class and LANG_MAPS without touching this method.
    private void generateAllPotionAndArrowVariants(String effectId, String effectName) {
        String minecraftNamespace = "minecraft";
        Map<String, String> prefixMap = prefixTranslations.getOrDefault("prefixes", Map.of()).getOrDefault(locale, prefixTranslations.get("prefixes").get("en_us"));

        // ---- Loop through all levels for potions and arrows ----
        for (int level = 0; level <= 6; level++) {
            String levelSuffix = (level == 0) ? "_potion" : "_potion_" + level;

            // ---- Normal potions ----
            add("item." + minecraftNamespace + ".potion.effect." + effectId + levelSuffix,
                    generatePotionName(effectName, level, prefixMap.get("potion")));
            add("item." + minecraftNamespace + ".potion.effect.long_" + effectId + levelSuffix,
                    generatePotionName(effectName, level, prefixMap.get("potion_extended")));

            // ---- Splash potions ----
            add("item." + minecraftNamespace + ".splash_potion.effect." + effectId + levelSuffix,
                    generatePotionName(effectName, level, prefixMap.get("splash_potion")));
            add("item." + minecraftNamespace + ".splash_potion.effect.long_" + effectId + levelSuffix,
                    generatePotionName(effectName, level, prefixMap.get("splash_potion_extended")));

            // ---- Lingering potions ----
            add("item." + minecraftNamespace + ".lingering_potion.effect." + effectId + levelSuffix,
                    generatePotionName(effectName, level, prefixMap.get("lingering_potion")));
            add("item." + minecraftNamespace + ".lingering_potion.effect.long_" + effectId + levelSuffix,
                    generatePotionName(effectName, level, prefixMap.get("lingering_potion_extended")));

            // ---- Arrows ----
            add("item." + minecraftNamespace + ".tipped_arrow.effect." + effectId + levelSuffix,
                    generateArrowName(effectName, level, prefixMap.get("arrow")));
            add("item." + minecraftNamespace + ".tipped_arrow.effect.long_" + effectId + levelSuffix,
                    generateArrowName(effectName, level, prefixMap.get("arrow_extended")));
        }
    }

    // ---- Potion & arrow name helpers ----
    @Contract(pure = true)
    private @NotNull String generatePotionName(String effectName, int level, String prefix) {
        String displayName = effectName;
        if (level > 0) displayName += " " + toRoman(level); // Keeps your level formatting
        return prefix + " " + displayName; // Prefix already includes Lingering / Splash / etc.
    }

    @Contract(pure = true)
    private @NotNull String generateArrowName(String effectName, int level, String prefix) {
        String displayName = effectName;
        if (level > 0) displayName += " " + toRoman(level);
        return prefix + " " + displayName;
    }

    @Contract(pure = true)
    private @NotNull String toRoman(int number) {
        return switch (number) {
            case 1 -> "II";
            case 2 -> "III";
            case 3 -> "IV";
            case 4 -> "V";
            case 5 -> "VI";
            case 6 -> "VII";
            default -> "";
        };
    }

    private @NotNull String formatName(@NotNull String path) {
        String[] words = path.split("_");
        StringBuilder formatted = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                formatted.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1)).append(" ");
            }
        }
        return formatted.toString().trim();
    }
}