package com.github.warrentode.todecoins.datagen.translations;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("GrazieInspection")
public class TabTranslations {
    // Map of tab keys → (language code → translated name)
    public static final Map<String, Map<String, String>> TAB_NAMES = createTabTranslations();


    private static @NotNull Map<String, Map<String, String>> createTabTranslations() {
        Map<String, Map<String, String>> map = new HashMap<>();

        map.put("cagerium_tab", Map.ofEntries(
                Map.entry("en_us", "Cagerium Tab"),
                Map.entry("en_gb", "Cagerium Tab"),
                Map.entry("en_ca", "Cagerium Tab"),
                Map.entry("en_au", "Cagerium Tab"),
                Map.entry("en_pt", "Cagerium Tab"), // Pirate Speak

                Map.entry("de_de", "Cagerium-Reiter"),
                Map.entry("fr_fr", "Onglet Cagerium"),
                Map.entry("fr_ca", "Onglet Cagerium"),
                Map.entry("es_es", "Pestaña Cagerium"),
                Map.entry("es_mx", "Pestaña Cagerium"),
                Map.entry("it_it", "Scheda Cagerium"),
                Map.entry("pt_br", "Aba Cagerium"),
                Map.entry("pt_pt", "Separador Cagerium"),
                Map.entry("ru_ru", "Вкладка Cagerium"),
                Map.entry("uk_ua", "Вкладка Cagerium"),
                Map.entry("zh_cn", "笼晶标签"),
                Map.entry("zh_tw", "籠晶標籤"),
                Map.entry("ja_jp", "ケイジャリウムタブ"),
                Map.entry("ko_kr", "케이저리움 탭"),
                Map.entry("nl_nl", "Cagerium Tab"),
                Map.entry("pl_pl", "Karta Cagerium"),
                Map.entry("sv_se", "Cagerium-flik"),
                Map.entry("no_no", "Cagerium-fane"),
                Map.entry("da_dk", "Cagerium-faneblad"),
                Map.entry("fi_fi", "Cagerium-välilehti"),
                Map.entry("tr_tr", "Cagerium Sekmesi"),
                Map.entry("cs_cz", "Karta Cagerium"),
                Map.entry("sk_sk", "Karta Cagerium"),
                Map.entry("hu_hu", "Cagerium Lap"),
                Map.entry("bg_bg", "Cagerium Таб"),
                Map.entry("el_gr", "Καρτέλα Cagerium"),
                Map.entry("ro_ro", "Fila Cagerium"),
                Map.entry("vi_vn", "Tab Cagerium"),
                Map.entry("id_id", "Tab Cagerium"),
                Map.entry("hi_in", "Cagerium टैब"),
                Map.entry("he_il", "כרטיסייה Cagerium"),
                Map.entry("ar_sa", "تبويب Cagerium"),
                Map.entry("ms_my", "Tab Cagerium"),
                Map.entry("ca_es", "Pestanya Cagerium"),
                Map.entry("gl_es", "Pestana Cagerium"),
                Map.entry("eo_ee", "Cagerium-Folio"),
                Map.entry("la_la", "Cagerium Tabula"),
                Map.entry("th_th", "แท็บเคเจเรียม")
        ));

        map.put("todecoinstab", Map.ofEntries(
                Map.entry("en_us", "TodeCoins"),
                Map.entry("en_gb", "TodeCoins"),
                Map.entry("en_ca", "TodeCoins"),
                Map.entry("en_au", "TodeCoins"),
                Map.entry("en_pt", "Tode Doubloons"), // Pirate Speak

                Map.entry("de_de", "TodeMünzen"),
                Map.entry("fr_fr", "Pièces de Tode"),
                Map.entry("fr_ca", "Pièces de Tode"),
                Map.entry("es_es", "Monedas de Tode"),
                Map.entry("es_mx", "Monedas Tode"),
                Map.entry("it_it", "Monete di Tode"),
                Map.entry("pt_br", "Moedas de Tode"),
                Map.entry("pt_pt", "Moedas de Tode"),
                Map.entry("ru_ru", "ТодКоины"),
                Map.entry("uk_ua", "ТодМонети"),
                Map.entry("zh_cn", "托德币"),
                Map.entry("zh_tw", "托德幣"),
                Map.entry("ja_jp", "トードコイン"),
                Map.entry("ko_kr", "토드코인"),
                Map.entry("nl_nl", "TodeMunten"),
                Map.entry("pl_pl", "Monety Tode"),
                Map.entry("sv_se", "TodeMynt"),
                Map.entry("no_no", "TodeMynter"),
                Map.entry("da_dk", "TodeMønter"),
                Map.entry("fi_fi", "TodeKolikot"),
                Map.entry("tr_tr", "TodeParaları"),
                Map.entry("cs_cz", "TodeMince"),
                Map.entry("sk_sk", "TodeMince"),
                Map.entry("hu_hu", "TodeÉrmék"),
                Map.entry("bg_bg", "ТодМонети"),
                Map.entry("el_gr", "Νομίσματα Tode"),
                Map.entry("ro_ro", "Monede Tode"),
                Map.entry("vi_vn", "Đồng Tode"),
                Map.entry("id_id", "Koin Tode"),
                Map.entry("hi_in", "टोड कॉइन"),
                Map.entry("he_il", "מטבעות טוד"),
                Map.entry("ar_sa", "عملات تود"),
                Map.entry("ms_my", "TodeCoins"),
                Map.entry("ca_es", "Monedes de Tode"),
                Map.entry("gl_es", "Moedas de Tode"),
                Map.entry("eo_ee", "Tode-Moneroj"),
                Map.entry("la_la", "TodeMonetae"),
                Map.entry("th_th", "เหรียญโทด")
        ));

        map.put("collectorcoinstab", Map.ofEntries(
                Map.entry("en_us", "Collectible Coins"),
                Map.entry("en_gb", "Collectible Coins"),
                Map.entry("en_ca", "Collectible Coins"),
                Map.entry("en_au", "Collectible Coins"),
                Map.entry("en_pt", "Collectible Doubloons"), // Pirate Speak

                Map.entry("de_de", "Sammlermünzen"),
                Map.entry("fr_fr", "Pièces de collection"),
                Map.entry("fr_ca", "Pièces de collection"),
                Map.entry("es_es", "Monedas coleccionables"),
                Map.entry("es_mx", "Monedas coleccionables"),
                Map.entry("it_it", "Monete da collezione"),
                Map.entry("pt_br", "Moedas colecionáveis"),
                Map.entry("pt_pt", "Moedas colecionáveis"),
                Map.entry("ru_ru", "Коллекционные монеты"),
                Map.entry("uk_ua", "Колекційні монети"),
                Map.entry("zh_cn", "收藏币"),
                Map.entry("zh_tw", "收藏幣"),
                Map.entry("ja_jp", "コレクションコイン"),
                Map.entry("ko_kr", "수집용 동전"),
                Map.entry("nl_nl", "Verzamelmunten"),
                Map.entry("pl_pl", "Monety kolekcjonerskie"),
                Map.entry("sv_se", "Samlar mynt"),
                Map.entry("no_no", "Samle mynter"),
                Map.entry("da_dk", "Samlermønter"),
                Map.entry("fi_fi", "Keräilykolikot"),
                Map.entry("tr_tr", "Koleksiyon Paraları"),
                Map.entry("cs_cz", "Sbírkové mince"),
                Map.entry("sk_sk", "Zberateľské mince"),
                Map.entry("hu_hu", "Gyűjthető érmék"),
                Map.entry("bg_bg", "Колекционерски монети"),
                Map.entry("el_gr", "Νόμισματα συλλογής"),
                Map.entry("ro_ro", "Monede de colecție"),
                Map.entry("vi_vn", "Tiền sưu tập"),
                Map.entry("id_id", "Koin Koleksi"),
                Map.entry("hi_in", "संग्रहणीय सिक्के"),
                Map.entry("he_il", "מטבעות אספנים"),
                Map.entry("ar_sa", "عملات جمع"),
                Map.entry("ms_my", "Syiling Koleksi"),
                Map.entry("ca_es", "Monedes de col·lecció"),
                Map.entry("gl_es", "Moedas de colección"),
                Map.entry("eo_ee", "Kolektaj Moneroj"),
                Map.entry("la_la", "Monetae Collectabilia"),
                Map.entry("th_th", "เหรียญสะสม")
        ));

        return map;
    }
}