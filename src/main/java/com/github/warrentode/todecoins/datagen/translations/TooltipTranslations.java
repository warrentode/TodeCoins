package com.github.warrentode.todecoins.datagen.translations;

import com.github.warrentode.todecoins.datagen.translations.tooltips.ItemTooltipTranslations;
import com.github.warrentode.todecoins.datagen.translations.tooltips.WaresTooltipTranslations;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

public class TooltipTranslations {
    // tooltip lang key prefix
    public static final String tooltipPrefix = "tooltip." + MODID + ".";

    // coin use effect tooltip prefix
    public static final String coinUseTipPrefix = "tooltip." + MODID + ".effect_on_use";
    // sub set count tooltip string
    public static final String setCountTipKey4 = "collectible_coin_set_4"; // total count of the sub set
    public static final String holidayCoinCountTipKey = "collectible_coin_set_holiday";
    public static final String lifetimeCoinCountTipKey = "collectible_coin_set_lifetime";
    public static final String patronCoinCountTipKey = "collectible_coin_set_patron";


    private static final Map<String, String> TOOLTIP_SHIFT_MAP = Map.ofEntries(
            Map.entry("en_us", "Press SHIFT for more info..."),
            Map.entry("en_gb", "Press SHIFT for more info..."),
            Map.entry("en_ca", "Press SHIFT for more info..."),
            Map.entry("en_au", "Press SHIFT for more info..."),
            Map.entry("en_pt", "Press SHIFT for more info..."),

            Map.entry("de_de", "Drücke UMSCHALT für mehr Infos..."),
            Map.entry("fr_fr", "Appuyez sur MAJ pour plus d'informations..."),
            Map.entry("fr_ca", "Appuyez sur MAJ pour plus d'informations..."),
            Map.entry("es_es", "Pulsa SHIFT para más información..."),
            Map.entry("es_mx", "Pulsa SHIFT para más información..."),
            Map.entry("pt_pt", "Pressione SHIFT para mais informações..."),
            Map.entry("pt_br", "Pressione SHIFT para mais informações..."),
            Map.entry("it_it", "Premi SHIFT per maggiori informazioni..."),
            Map.entry("nl_nl", "Druk op SHIFT voor meer info..."),
            Map.entry("ru_ru", "Нажмите SHIFT для подробностей..."),
            Map.entry("uk_ua", "Натисніть SHIFT для більше інформації..."),
            Map.entry("pl_pl", "Naciśnij SHIFT, aby uzyskać więcej informacji..."),
            Map.entry("cs_cz", "Stiskněte SHIFT pro více informací..."),
            Map.entry("sk_sk", "Stlačte SHIFT pre viac informácií..."),
            Map.entry("hu_hu", "Nyomd meg a SHIFT-et a további információkért..."),
            Map.entry("sv_se", "Tryck på SHIFT för mer info..."),
            Map.entry("no_no", "Trykk på SHIFT for mer info..."),
            Map.entry("da_dk", "Tryk på SHIFT for mere info..."),
            Map.entry("fi_fi", "Paina VAIHTO saadaksesi lisätietoja..."),
            Map.entry("tr_tr", "Daha fazla bilgi için SHIFT tuşuna basın..."),
            Map.entry("el_gr", "Πατήστε SHIFT για περισσότερες πληροφορίες..."),
            Map.entry("ro_ro", "Apăsați SHIFT pentru mai multe informații..."),
            Map.entry("bg_bg", "Натиснете SHIFT за повече информация..."),
            Map.entry("zh_cn", "按下 SHIFT 获取更多信息..."),
            Map.entry("zh_tw", "按下 SHIFT 以獲取更多資訊..."),
            Map.entry("ja_jp", "SHIFTキーを押して詳細を表示..."),
            Map.entry("ko_kr", "SHIFT 키를 눌러 자세한 정보를 확인하세요..."),
            Map.entry("th_th", "กด SHIFT เพื่อดูข้อมูลเพิ่มเติม..."),
            Map.entry("ar_sa", "اضغط SHIFT لمزيد من المعلومات..."),
            Map.entry("he_il", "לחץ SHIFT לפרטים נוספים..."),
            Map.entry("hi_in", "अधिक जानकारी के लिए SHIFT दबाएं..."),
            Map.entry("id_id", "Tekan SHIFT untuk info lebih lanjut..."),
            Map.entry("ms_my", "Tekan SHIFT untuk maklumat lanjut...")
    );

    public static String getTooltipShift(String locale) {
        return TOOLTIP_SHIFT_MAP.getOrDefault(locale, "Press SHIFT for more info...");
    }

    // main tooltip lang map holding **all** tooltip translations keyed by full keys
    public static final Map<String, Map<String, String>> LANG_MAPS = createTranslations();

    public static @NotNull Map<String, Map<String, String>> createTranslations() {
        Map<String, Map<String, String>> translations = new HashMap<>();

        // Get item tooltip translations (e.g., from ItemTooltipTranslations, etc.)
        Map<String, Map<String, String>> itemTooltipTranslations = ItemTooltipTranslations.LANG_MAPS;
        Map<String, Map<String, String>> waresTranslations = WaresTooltipTranslations.LANG_MAPS;

        // define entries here
        Map<String, Map<String, String>> allTooltipEntries = new HashMap<>();

        allTooltipEntries.putAll(itemTooltipTranslations);
        allTooltipEntries.putAll(waresTranslations);

        // Collect and merge all locales
        Set<String> locales = new HashSet<>();
        allTooltipEntries.values().forEach(map -> locales.addAll(map.keySet()));

        // combine locales with overrides into master translation list
        for (String locale : locales) {
            Map<String, String> combinedLocaleMap = new HashMap<>();

            // Add all tooltip translations for this locale
            for (Map.Entry<String, Map<String, String>> entry : allTooltipEntries.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue().get(locale);
                if (value != null) {
                    combinedLocaleMap.put(key, value);
                }
            }

            // Add the merged locale map to the final combined map
            translations.put(locale, combinedLocaleMap);
        }

        return translations;
    }
}