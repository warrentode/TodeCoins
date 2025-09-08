package com.github.warrentode.todecoins.datagen.translations;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class EntityTranslations {
    // Map of item IDs → (language code → translated name)
    public static final Map<String, Map<String, String>> LANG_MAPS = createTranslations();

    @Contract(pure = true)
    private static @NotNull Map<String, Map<String, String>> createTranslations() {
        Map<String, Map<String, String>> translations = new HashMap<>();

// Leprechaun entity translations
        translations.put("entity.minecraft.villager.todecoins.leprechaun", Map.ofEntries(
                Map.entry("en_us", "Leprechaun"),
                Map.entry("en_gb", "Leprechaun"),
                Map.entry("en_ca", "Leprechaun"),
                Map.entry("en_au", "Leprechaun"),
                Map.entry("en_pt", "Scallywag o' the Rainbow's Gold"), // Pirate Speak

                Map.entry("de_de", "Kobold"),
                Map.entry("fr_fr", "Lutin"),
                Map.entry("fr_ca", "Lutin"),
                Map.entry("es_es", "Duende"),
                Map.entry("es_mx", "Duende"),
                Map.entry("pt_pt", "Duende"),
                Map.entry("pt_br", "Duende"),
                Map.entry("it_it", "Folletto"),
                Map.entry("nl_nl", "Kabouter"),
                Map.entry("ru_ru", "Лепрекон"),
                Map.entry("uk_ua", "Лепрекон"),
                Map.entry("pl_pl", "Skrzat"),
                Map.entry("cs_cz", "Skřítek"),
                Map.entry("sk_sk", "Skriatok"),
                Map.entry("hu_hu", "Manó"),
                Map.entry("sv_se", "Leprechaun"),
                Map.entry("no_no", "Leprechaun"),
                Map.entry("da_dk", "Leprechaun"),
                Map.entry("fi_fi", "Keiju"),
                Map.entry("tr_tr", "Leprechaun"),
                Map.entry("el_gr", "Λεπρέκαουν"),
                Map.entry("ro_ro", "Leprechaun"),
                Map.entry("bg_bg", "Лепрекон"),
                Map.entry("zh_cn", "小妖精"),
                Map.entry("zh_tw", "小妖精"),
                Map.entry("ja_jp", "レプラコーン"),
                Map.entry("ko_kr", "레프리콘"),
                Map.entry("th_th", "เล็ปพรีคอน"),
                Map.entry("ar_sa", "ليبركون"),
                Map.entry("he_il", "לפרקון"),
                Map.entry("hi_in", "लेप्रीकॉन"),
                Map.entry("id_id", "Leprechaun"),
                Map.entry("ms_my", "Leprechaun")
        ));
// Banker entity translations
        translations.put("entity.minecraft.villager.todecoins.banker", Map.ofEntries(
                Map.entry("en_us", "Banker"),
                Map.entry("en_gb", "Banker"),
                Map.entry("en_ca", "Banker"),
                Map.entry("en_au", "Banker"),
                Map.entry("en_pt", "Treasure Keeper of the Seven Seas"), // Pirate Speak

                Map.entry("de_de", "Bankier"),
                Map.entry("fr_fr", "Banquier"),
                Map.entry("fr_ca", "Banquier"),
                Map.entry("es_es", "Banquero"),
                Map.entry("es_mx", "Banquero"),
                Map.entry("pt_pt", "Banqueiro"),
                Map.entry("pt_br", "Banqueiro"),
                Map.entry("it_it", "Banchiere"),
                Map.entry("nl_nl", "Bankier"),
                Map.entry("ru_ru", "Банкир"),
                Map.entry("uk_ua", "Банкір"),
                Map.entry("pl_pl", "Bankier"),
                Map.entry("cs_cz", "Bankéř"),
                Map.entry("sk_sk", "Bankár"),
                Map.entry("hu_hu", "Bankár"),
                Map.entry("sv_se", "Bankir"),
                Map.entry("no_no", "Banker"),
                Map.entry("da_dk", "Banker"),
                Map.entry("fi_fi", "Pankkiiri"),
                Map.entry("tr_tr", "Banker"),
                Map.entry("el_gr", "Τραπεζίτης"),
                Map.entry("ro_ro", "Bancher"),
                Map.entry("bg_bg", "Банкер"),
                Map.entry("zh_cn", "银行家"),
                Map.entry("zh_tw", "銀行家"),
                Map.entry("ja_jp", "銀行員"),
                Map.entry("ko_kr", "은행원"),
                Map.entry("th_th", "พ่อค้าเงิน"),
                Map.entry("ar_sa", "مصرفي"),
                Map.entry("he_il", "בנקאי"),
                Map.entry("hi_in", "बैंकर"),
                Map.entry("id_id", "Bankir"),
                Map.entry("ms_my", "Banker")
        ));
// Numismatist entity translations
        translations.put("entity.todecoins.numismatist", Map.ofEntries(
                Map.entry("en_us", "Numismatist"),
                Map.entry("en_gb", "Numismatist"),
                Map.entry("en_ca", "Numismatist"),
                Map.entry("en_au", "Numismatist"),
                Map.entry("en_pt", "Coin Collector o' the Seven Seas"), // Pirate Speak

                Map.entry("de_de", "Numismatiker"),
                Map.entry("fr_fr", "Numismate"),
                Map.entry("fr_ca", "Numismate"),
                Map.entry("es_es", "Numismático"),
                Map.entry("es_mx", "Numismático"),
                Map.entry("pt_pt", "Numismata"),
                Map.entry("pt_br", "Numismata"),
                Map.entry("it_it", "Numismatico"),
                Map.entry("nl_nl", "Numismaat"),
                Map.entry("ru_ru", "Нумизмат"),
                Map.entry("uk_ua", "Нумізмат"),
                Map.entry("pl_pl", "Numizmatyk"),
                Map.entry("cs_cz", "Numismatik"),
                Map.entry("sk_sk", "Numizmatik"),
                Map.entry("hu_hu", "Numizmatikus"),
                Map.entry("sv_se", "Numismatist"),
                Map.entry("no_no", "Numismatist"),
                Map.entry("da_dk", "Numismatist"),
                Map.entry("fi_fi", "Numismaatikko"),
                Map.entry("tr_tr", "Numismatist"),
                Map.entry("el_gr", "Νουμισματιστής"),
                Map.entry("ro_ro", "Numismat"),
                Map.entry("bg_bg", "Нумизмат"),
                Map.entry("zh_cn", "钱币学家"),
                Map.entry("zh_tw", "錢幣學家"),
                Map.entry("ja_jp", "貨幣学者"),
                Map.entry("ko_kr", "화폐학자"),
                Map.entry("th_th", "นักสะสมเหรียญ"),
                Map.entry("ar_sa", "جامع النقود"),
                Map.entry("he_il", "אספן מטבעות"),
                Map.entry("hi_in", "सिक्का विशेषज्ञ"),
                Map.entry("id_id", "Numismatis"),
                Map.entry("ms_my", "Numismatis")
        ));
// Piglin Merchant entity translations
        translations.put("entity.todecoins.piglinmerchant", Map.ofEntries(
                Map.entry("en_us", "Piglin Merchant"),
                Map.entry("en_gb", "Piglin Merchant"),
                Map.entry("en_ca", "Piglin Merchant"),
                Map.entry("en_au", "Piglin Merchant"),
                Map.entry("en_pt", "Gold Hoarder o' the Abyss"), // Pirate Speak

                Map.entry("de_de", "Piglin-Händler"),
                Map.entry("fr_fr", "Marchand Piglin"),
                Map.entry("fr_ca", "Marchand Piglin"),
                Map.entry("es_es", "Comerciante Piglin"),
                Map.entry("es_mx", "Comerciante Piglin"),
                Map.entry("pt_pt", "Comerciante Piglin"),
                Map.entry("pt_br", "Comerciante Piglin"),
                Map.entry("it_it", "Mercante Piglin"),
                Map.entry("nl_nl", "Piglin Handelaar"),
                Map.entry("ru_ru", "Торговец Пиглин"),
                Map.entry("uk_ua", "Торговець Піглін"),
                Map.entry("pl_pl", "Kupiec Piglin"),
                Map.entry("cs_cz", "Piglin Obchodník"),
                Map.entry("sk_sk", "Piglin Obchodník"),
                Map.entry("hu_hu", "Piglin Kereskedő"),
                Map.entry("sv_se", "Piglinhandlare"),
                Map.entry("no_no", "Piglin Merchant"),
                Map.entry("da_dk", "Piglin Merchant"),
                Map.entry("fi_fi", "Piglin-kauppias"),
                Map.entry("tr_tr", "Piglin Tüccar"),
                Map.entry("el_gr", "Έμπορος Πίγκλιν"),
                Map.entry("ro_ro", "Negustor Piglin"),
                Map.entry("bg_bg", "Търговец Пиглин"),
                Map.entry("zh_cn", "猪灵商人"),
                Map.entry("zh_tw", "豬靈商人"),
                Map.entry("ja_jp", "ピグリン商人"),
                Map.entry("ko_kr", "피글린 상인"),
                Map.entry("th_th", "พ่อค้า Piglin"),
                Map.entry("ar_sa", "تاجر بيجلين"),
                Map.entry("he_il", "סוחר פיגלין"),
                Map.entry("hi_in", "पिग्लिन व्यापारी"),
                Map.entry("id_id", "Pedagang Piglin"),
                Map.entry("ms_my", "Pedagang Piglin")
        ));

        return translations;
    }

}