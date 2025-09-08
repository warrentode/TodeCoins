package com.github.warrentode.todecoins.datagen.translations.effects;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class VanillaEffectNameTranslations {
    // Map of item IDs → (language code → translated name)
    public static final Map<String, Map<String, String>> LANG_MAPS = createEffectNameTranslations();

    @Contract(pure = true)
    private static @NotNull Map<String, Map<String, String>> createEffectNameTranslations() {
        Map<String, Map<String, String>> translations = new HashMap<>();

        // Unluck Luck effect translations
        translations.put("effect.minecraft.unluck", Map.ofEntries(
                Map.entry("en_us", "Bad Luck"),
                Map.entry("en_gb", "Bad Luck"),
                Map.entry("en_ca", "Bad Luck"),
                Map.entry("en_au", "Bad Luck"),
                Map.entry("en_pt", "Cursed Luck"), // Pirate Speak
                Map.entry("de_de", "Pech"),
                Map.entry("fr_fr", "Malchance"),
                Map.entry("fr_ca", "Malchance"),
                Map.entry("es_es", "Mala Suerte"),
                Map.entry("es_mx", "Mala Suerte"),
                Map.entry("pt_pt", "Má Sorte"),
                Map.entry("pt_br", "Má Sorte"),
                Map.entry("it_it", "Sfortuna"),
                Map.entry("nl_nl", "Ongeluk"),
                Map.entry("ru_ru", "Несчастье"),
                Map.entry("uk_ua", "Невдача"),
                Map.entry("pl_pl", "Pech"),
                Map.entry("cs_cz", "Smůla"),
                Map.entry("sk_sk", "Nešťastie"),
                Map.entry("hu_hu", "Balszerencse"),
                Map.entry("sv_se", "Otur"),
                Map.entry("no_no", "Ulykke"),
                Map.entry("da_dk", "Ulykke"),
                Map.entry("fi_fi", "Epäonni"),
                Map.entry("tr_tr", "Şanssızlık"),
                Map.entry("el_gr", "Κακοτυχία"),
                Map.entry("ro_ro", "Ghinion"),
                Map.entry("bg_bg", "Лош късмет"),
                Map.entry("zh_cn", "坏运气"),
                Map.entry("zh_tw", "壞運氣"),
                Map.entry("ja_jp", "不運"),
                Map.entry("ko_kr", "불운"),
                Map.entry("th_th", "โชคร้าย"),
                Map.entry("ar_sa", "حظ سيء"),
                Map.entry("he_il", "מזל רע"),
                Map.entry("hi_in", "अभाग्य"),
                Map.entry("id_id", "Nasib Buruk"),
                Map.entry("ms_my", "Nasib Malang")
        ));

        // Luck effect translations
        translations.put("effect.minecraft.luck", Map.ofEntries(
                Map.entry("en_us", "Luck"),
                Map.entry("en_gb", "Luck"),
                Map.entry("en_ca", "Luck"),
                Map.entry("en_au", "Luck"),
                Map.entry("en_pt", "Luck o' the Irish"), // Pirate Speak
                Map.entry("de_de", "Glück"),
                Map.entry("fr_fr", "Chance"),
                Map.entry("fr_ca", "Chance"),
                Map.entry("es_es", "Suerte"),
                Map.entry("es_mx", "Suerte"),
                Map.entry("pt_pt", "Sorte"),
                Map.entry("pt_br", "Sorte"),
                Map.entry("it_it", "Fortuna"),
                Map.entry("nl_nl", "Geluk"),
                Map.entry("ru_ru", "Удача"),
                Map.entry("uk_ua", "Удача"),
                Map.entry("pl_pl", "Szczęście"),
                Map.entry("cs_cz", "Štěstí"),
                Map.entry("sk_sk", "Šťastie"),
                Map.entry("hu_hu", "Szerencse"),
                Map.entry("sv_se", "Lycka"),
                Map.entry("no_no", "Flaks"),
                Map.entry("da_dk", "Held"),
                Map.entry("fi_fi", "Onni"),
                Map.entry("tr_tr", "Şans"),
                Map.entry("el_gr", "Τύχη"),
                Map.entry("ro_ro", "Noroc"),
                Map.entry("bg_bg", "Късмет"),
                Map.entry("zh_cn", "好运"),
                Map.entry("zh_tw", "好運"),
                Map.entry("ja_jp", "幸運"),
                Map.entry("ko_kr", "행운"),
                Map.entry("th_th", "โชคดี"),
                Map.entry("ar_sa", "حظ"),
                Map.entry("he_il", "מזל טוב"),
                Map.entry("hi_in", "सौभाग्य"),
                Map.entry("id_id", "Keberuntungan"),
                Map.entry("ms_my", "Nasib Baik")
        ));

        return translations;
    }
}