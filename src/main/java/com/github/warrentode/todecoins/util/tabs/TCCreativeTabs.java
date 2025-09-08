package com.github.warrentode.todecoins.util.tabs;

import com.github.warrentode.todecoins.item.TCItems;
import com.github.warrentode.todecoins.datagen.translations.TabTranslations;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.function.Supplier;

import static com.github.warrentode.todecoins.TodeCoins.MODID;
import static com.github.warrentode.todecoins.TodeCoins.TC_LOGGER;

public class TCCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    private static final Map<String, Map<String, String>> TAB_LANG_MAP = new HashMap<>();

    public static final RegistryObject<CreativeModeTab> TODECOINSTAB =
            registerTab("todecoinstab", () ->
                            CreativeModeTab.builder()
                                    .title(Component.translatable("itemGroup.todecoinstab"))
                                    .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
                                    .icon(() -> new ItemStack(TCItems.COPPER_COIN.get()))
                                    .displayItems((parameters, output) -> TCItems.ITEMS.getEntries().stream()
                                            .map(RegistryObject::get)
                                            .filter(item -> {
                                                ResourceLocation location = ForgeRegistries.ITEMS.getKey(item);
                                                return location != null && !location.getPath().contains("collectible");
                                            })
                                            .forEach(output::accept))
                                    .build(),
                    TabTranslations.TAB_NAMES.get("todecoinstab")
            );

    public static final RegistryObject<CreativeModeTab> COLLECTORCOINSTAB =
            registerTab("collectorcoinstab", () ->
                            CreativeModeTab.builder()
                                    .title(Component.translatable("itemGroup.collectorcoinstab"))
                                    .withTabsBefore(TODECOINSTAB.getId())
                                    .icon(() -> new ItemStack(TCItems.COLLECTIBLE_COIN_HERO_COPPER.get()))
                                    .displayItems((parameters, output) -> TCItems.ITEMS.getEntries().stream()
                                            .map(RegistryObject::get)
                                            .filter(item -> {
                                                ResourceLocation location = ForgeRegistries.ITEMS.getKey(item);
                                                return location != null && location.getPath().contains("collectible");
                                            })
                                            .forEach(output::accept))
                                    .build(),
                    TabTranslations.TAB_NAMES.get("collectorcoinstab")
            );

    public static RegistryObject<CreativeModeTab> CAGERIUM_TAB;

    public static void registerOptionalTabs() {
        // Only create the tab if Cagerium is loaded
        if (ModList.get().isLoaded("cagerium")) {
            CAGERIUM_TAB = registerTab("cagerium_tab", () ->
                    CreativeModeTab.builder()
                            .title(Component.translatable("itemGroup.cagerium_tab"))
                            .withTabsBefore(COLLECTORCOINSTAB.getId()) // optional: position relative to your tabs
                            .icon(() -> new ItemStack(Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(ResourceLocation.parse("cagerium:cage")))))
                            .displayItems((parameters, output) -> {
                                // Dynamically add all items from Cagerium
                                for (Item item : ForgeRegistries.ITEMS) {
                                    ResourceLocation id = ForgeRegistries.ITEMS.getKey(item);
                                    if (id != null && "cagerium".equals(id.getNamespace())) {
                                        output.accept(item);
                                    }
                                }
                            })
                            .build(),
                    TabTranslations.TAB_NAMES.get("cagerium_tab")
            );
        }
    }

    private static RegistryObject<CreativeModeTab> registerTab(String name, Supplier<CreativeModeTab> supplier, Map<String, String> translations) {
        RegistryObject<CreativeModeTab> item = CREATIVE_TABS.register(name, supplier);
        TAB_LANG_MAP.put(name, translations);
        return item;
    }

    public static @NotNull Map<String, Map<String, String>> getTranslationOverrides() {
        Map<String, Map<String, String>> localeMap = new HashMap<>();

        // Collect all locales used in any tab translations
        Set<String> allLocales = new HashSet<>();
        for (Map.Entry<String, Map<String, String>> entry : TAB_LANG_MAP.entrySet()) {
            Map<String, String> translations = entry.getValue();

            if (translations == null) {
                TC_LOGGER.warn("No translations found for creative tab '{}'", entry.getKey());
                continue; // skip to avoid crash
            }
            allLocales.addAll(translations.keySet());
        }

        for (String locale : allLocales) {
            Map<String, String> perLocale = new HashMap<>();

            // For each tab key, get the translation for this locale or fallback to a formatted key
            for (String tabKey : TAB_LANG_MAP.keySet()) {
                String translated = TAB_LANG_MAP.getOrDefault(tabKey, Map.of()).get(locale);

                if (translated == null && locale.equals("en_us")) {
                    translated = formatName(tabKey); // fallback default English
                }
                else if (translated == null) {
                    translated = formatName(tabKey); // fallback to English-like
                }

                perLocale.put(tabKey, translated);
            }

            localeMap.put(locale, perLocale);
        }

        return localeMap;
    }

    // Helper for formatting e.g. "todecoinstab" → "TodeCoins"
    private static @NotNull String formatName(@NotNull String key) {
        String[] parts = key.split("_");
        StringBuilder stringBuilder = new StringBuilder();
        for (String part : parts) {
            if (!part.isEmpty()) {
                stringBuilder.append(Character.toUpperCase(part.charAt(0)))
                        .append(part.substring(1))
                        .append(" ");
            }
        }
        return stringBuilder.toString().trim();
    }
}