package com.github.warrentode.todecoins.datagen.translations.items.collectible_coins;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class SlimeCoinTranslations {
    // Map of item IDs → (language code → translated name)
    public static final Map<String, Map<String, String>> LANG_MAPS = createTranslationMaps();


    static @NotNull Map<String, Map<String, String>> createTranslationMaps() {
        Map<String, Map<String, String>> translations = new HashMap<>();

// Collectible Copper Magma Cube Coin translations
        translations.put("collectible_coin_magma_cube_copper", Map.ofEntries(
                Map.entry("en_us", "Collectible Copper Magma Cube Coin"),
                Map.entry("en_gb", "Collectible Copper Magma Cube Coin"),
                Map.entry("en_ca", "Collectible Copper Magma Cube Coin"),
                Map.entry("en_au", "Collectible Copper Magma Cube Coin"),
                Map.entry("en_pt", "Badge o' the Copper Magma Cube"), // Pirate Speak

                Map.entry("de_de", "Sammel-Münze Kupfer-Magmawürfel"),
                Map.entry("fr_fr", "Pièce de cube de magma en cuivre de collection"),
                Map.entry("fr_ca", "Pièce de cube de magma en cuivre de collection"),
                Map.entry("es_es", "Moneda coleccionable de cubo de magma de cobre"),
                Map.entry("es_mx", "Moneda coleccionable de cubo de magma de cobre"),
                Map.entry("pt_pt", "Moeda colecionável de cubo de magma de cobre"),
                Map.entry("pt_br", "Moeda colecionável de cubo de magma de cobre"),
                Map.entry("it_it", "Moneta collezionabile di cubo di magma in rame"),
                Map.entry("nl_nl", "Verzamelbare koperen magmakubusmunt"),
                Map.entry("ru_ru", "Коллекционная медная монета магмового куба"),
                Map.entry("uk_ua", "Колекційна мідна монета магмового куба"),
                Map.entry("pl_pl", "Kolekcjonerska miedziana moneta kostki magmy"),
                Map.entry("cs_cz", "Sběratelská měděná mince magmatické kostky"),
                Map.entry("sk_sk", "Zberateľská medená minca magmatickej kocky"),
                Map.entry("hu_hu", "Gyűjthető réz magma kocka érme"),
                Map.entry("sv_se", "Samlingsbar kopparmagma-kubmynt"),
                Map.entry("no_no", "Samlebar kobbermagmakube-mynt"),
                Map.entry("da_dk", "Samlermønt med kobbermagmakube"),
                Map.entry("fi_fi", "Keräiltävä kuparinen magmakuutio kolikko"),
                Map.entry("tr_tr", "Koleksiyonluk Bakır Magma Küpü Parası"),
                Map.entry("el_gr", "Συλλεκτικό νόμισμα κύβου μάγματος από χαλκό"),
                Map.entry("ro_ro", "Monedă de colecție cub de magmă de cupru"),
                Map.entry("bg_bg", "Колекционерска медна монета магмена куб"),
                Map.entry("zh_cn", "收藏铜岩浆怪币"),
                Map.entry("zh_tw", "收藏銅岩漿怪幣"),
                Map.entry("ja_jp", "コレクションカッパーマグマキューブコイン"),
                Map.entry("ko_kr", "수집용 구리 마그마 큐브 동전"),
                Map.entry("th_th", "เหรียญเก็บสะสมแมกมาลูกบาศก์ทองแดง"),
                Map.entry("ar_sa", "عملة جمع مكعب حمم نحاسية"),
                Map.entry("he_il", "מטבע איסוף קוביית מגמה נחושת"),
                Map.entry("hi_in", "संग्रहणीय तांबे का मैग्मा क्यूब सिक्का"),
                Map.entry("id_id", "Koin Koleksi Kubus Magma Tembaga"),
                Map.entry("ms_my", "Syiling Koleksi Kiub Magma Tembaga")
        ));

// Collectible Iron Magma Cube Coin translations
        translations.put("collectible_coin_magma_cube_iron", Map.ofEntries(
                Map.entry("en_us", "Collectible Iron Magma Cube Coin"),
                Map.entry("en_gb", "Collectible Iron Magma Cube Coin"),
                Map.entry("en_ca", "Collectible Iron Magma Cube Coin"),
                Map.entry("en_au", "Collectible Iron Magma Cube Coin"),
                Map.entry("en_pt", "Badge o' the Iron Magma Cube"), // Pirate Speak

                Map.entry("de_de", "Sammel-Münze Eisen-Magmawürfel"),
                Map.entry("fr_fr", "Pièce de cube de magma en fer de collection"),
                Map.entry("fr_ca", "Pièce de cube de magma en fer de collection"),
                Map.entry("es_es", "Moneda coleccionable de cubo de magma de hierro"),
                Map.entry("es_mx", "Moneda coleccionable de cubo de magma de hierro"),
                Map.entry("pt_pt", "Moeda colecionável de cubo de magma de ferro"),
                Map.entry("pt_br", "Moeda colecionável de cubo de magma de ferro"),
                Map.entry("it_it", "Moneta collezionabile di cubo di magma in ferro"),
                Map.entry("nl_nl", "Verzamelbare ijzeren magmakubusmunt"),
                Map.entry("ru_ru", "Коллекционная железная монета магмового куба"),
                Map.entry("uk_ua", "Колекційна залізна монета магмового куба"),
                Map.entry("pl_pl", "Kolekcjonerska żelazna moneta kostki magmy"),
                Map.entry("cs_cz", "Sběratelská železná mince magmatické kostky"),
                Map.entry("sk_sk", "Zberateľská železná minca magmatickej kocky"),
                Map.entry("hu_hu", "Gyűjthető vas magma kocka érme"),
                Map.entry("sv_se", "Samlingsbar järnmagma-kubmynt"),
                Map.entry("no_no", "Samlebar jernmagmakube-mynt"),
                Map.entry("da_dk", "Samlermønt med jernmagmakube"),
                Map.entry("fi_fi", "Keräiltävä rautainen magmakuutio kolikko"),
                Map.entry("tr_tr", "Koleksiyonluk Demir Magma Küpü Parası"),
                Map.entry("el_gr", "Συλλεκτικό νόμισμα κύβου μάγματος από σίδηρο"),
                Map.entry("ro_ro", "Monedă de colecție cub de magmă de fier"),
                Map.entry("bg_bg", "Колекционерска желязна монета магмена куб"),
                Map.entry("zh_cn", "收藏铁岩浆怪币"),
                Map.entry("zh_tw", "收藏鐵岩漿怪幣"),
                Map.entry("ja_jp", "コレクションアイアンマグマキューブコイン"),
                Map.entry("ko_kr", "수집용 철 마그마 큐브 동전"),
                Map.entry("th_th", "เหรียญเก็บสะสมแมกมาลูกบาศก์เหล็ก"),
                Map.entry("ar_sa", "عملة جمع مكعب حمم حديدية"),
                Map.entry("he_il", "מטבע איסוף קוביית מגמה ברזל"),
                Map.entry("hi_in", "संग्रहणीय लोहे का मैग्मा क्यूब सिक्का"),
                Map.entry("id_id", "Koin Koleksi Kubus Magma Besi"),
                Map.entry("ms_my", "Syiling Koleksi Kiub Magma Besi")
        ));

// Collectible Gold Magma Cube Coin translations
        translations.put("collectible_coin_magma_cube_gold", Map.ofEntries(
                Map.entry("en_us", "Collectible Gold Magma Cube Coin"),
                Map.entry("en_gb", "Collectible Gold Magma Cube Coin"),
                Map.entry("en_ca", "Collectible Gold Magma Cube Coin"),
                Map.entry("en_au", "Collectible Gold Magma Cube Coin"),
                Map.entry("en_pt", "Badge o' the Gold Magma Cube"), // Pirate Speak

                Map.entry("de_de", "Sammel-Münze Gold-Magmawürfel"),
                Map.entry("fr_fr", "Pièce de cube de magma en or de collection"),
                Map.entry("fr_ca", "Pièce de cube de magma en or de collection"),
                Map.entry("es_es", "Moneda coleccionable de cubo de magma de oro"),
                Map.entry("es_mx", "Moneda coleccionable de cubo de magma de oro"),
                Map.entry("pt_pt", "Moeda colecionável de cubo de magma de ouro"),
                Map.entry("pt_br", "Moeda colecionável de cubo de magma de ouro"),
                Map.entry("it_it", "Moneta collezionabile di cubo di magma in oro"),
                Map.entry("nl_nl", "Verzamelbare gouden magmakubusmunt"),
                Map.entry("ru_ru", "Коллекционная золотая монета магмового куба"),
                Map.entry("uk_ua", "Колекційна золота монета магмового куба"),
                Map.entry("pl_pl", "Kolekcjonerska złota moneta kostki magmy"),
                Map.entry("cs_cz", "Sběratelská zlatá mince magmatické kostky"),
                Map.entry("sk_sk", "Zberateľská zlatá minca magmatickej kocky"),
                Map.entry("hu_hu", "Gyűjthető arany magma kocka érme"),
                Map.entry("sv_se", "Samlingsbar guldmagma-kubmynt"),
                Map.entry("no_no", "Samlebar gullmagmakube-mynt"),
                Map.entry("da_dk", "Samlermønt med guldmagmakube"),
                Map.entry("fi_fi", "Keräiltävä kultainen magmakuutio kolikko"),
                Map.entry("tr_tr", "Koleksiyonluk Altın Magma Küpü Parası"),
                Map.entry("el_gr", "Συλλεκτικό νόμισμα κύβου μάγματος από χρυσό"),
                Map.entry("ro_ro", "Monedă de colecție cub de magmă de aur"),
                Map.entry("bg_bg", "Колекционерска златна монета магмена куб"),
                Map.entry("zh_cn", "收藏金岩浆怪币"),
                Map.entry("zh_tw", "收藏金岩漿怪幣"),
                Map.entry("ja_jp", "コレクションゴールドマグマキューブコイン"),
                Map.entry("ko_kr", "수집용 금 마그마 큐브 동전"),
                Map.entry("th_th", "เหรียญเก็บสะสมแมกมาลูกบาศก์ทอง"),
                Map.entry("ar_sa", "عملة جمع مكعب حمم ذهبية"),
                Map.entry("he_il", "מטבע איסוף קוביית מגמה זהב"),
                Map.entry("hi_in", "संग्रहणीय सोने का मैग्मा क्यूब सिक्का"),
                Map.entry("id_id", "Koin Koleksi Kubus Magma Emas"),
                Map.entry("ms_my", "Syiling Koleksi Kiub Magma Emas")
        ));

// Collectible Netherite Magma Cube Coin translations
        translations.put("collectible_coin_magma_cube_netherite", Map.ofEntries(
                Map.entry("en_us", "Collectible Netherite Magma Cube Coin"),
                Map.entry("en_gb", "Collectible Netherite Magma Cube Coin"),
                Map.entry("en_ca", "Collectible Netherite Magma Cube Coin"),
                Map.entry("en_au", "Collectible Netherite Magma Cube Coin"),
                Map.entry("en_pt", "Badge o' the Netherite Magma Cube"), // Pirate Speak

                Map.entry("de_de", "Sammel-Münze Netherit-Magmawürfel"),
                Map.entry("fr_fr", "Pièce de cube de magma en netherite de collection"),
                Map.entry("fr_ca", "Pièce de cube de magma en netherite de collection"),
                Map.entry("es_es", "Moneda coleccionable de cubo de magma de netherita"),
                Map.entry("es_mx", "Moneda coleccionable de cubo de magma de netherita"),
                Map.entry("pt_pt", "Moeda colecionável de cubo de magma de netherita"),
                Map.entry("pt_br", "Moeda colecionável de cubo de magma de netherita"),
                Map.entry("it_it", "Moneta collezionabile di cubo di magma in netherite"),
                Map.entry("nl_nl", "Verzamelbare netheriet magmakubusmunt"),
                Map.entry("ru_ru", "Коллекционная незеритовая монета магмового куба"),
                Map.entry("uk_ua", "Колекційна незеритова монета магмового куба"),
                Map.entry("pl_pl", "Kolekcjonerska netherytowa moneta kostki magmy"),
                Map.entry("cs_cz", "Sběratelská netheritová mince magmatické kostky"),
                Map.entry("sk_sk", "Zberateľská netheritová minca magmatickej kocky"),
                Map.entry("hu_hu", "Gyűjthető netherit magma kocka érme"),
                Map.entry("sv_se", "Samlingsbar netheritmagma-kubmynt"),
                Map.entry("no_no", "Samlebar netheritmagmakube-mynt"),
                Map.entry("da_dk", "Samlermønt med netheritmagmakube"),
                Map.entry("fi_fi", "Keräiltävä netheritinen magmakuutio kolikko"),
                Map.entry("tr_tr", "Koleksiyonluk Netherit Magma Küpü Parası"),
                Map.entry("el_gr", "Συλλεκτικό νόμισμα κύβου μάγματος από νεθερίτη"),
                Map.entry("ro_ro", "Monedă de colecție cub de magmă de netherit"),
                Map.entry("bg_bg", "Колекционерска нетеритна монета магмена куб"),
                Map.entry("zh_cn", "收藏下界合金岩浆怪币"),
                Map.entry("zh_tw", "收藏獄髓岩漿怪幣"),
                Map.entry("ja_jp", "コレクションネザライトマグマキューブコイン"),
                Map.entry("ko_kr", "수집용 네더라이트 마그마 큐브 동전"),
                Map.entry("th_th", "เหรียญเก็บสะสมแมกมาลูกบาศก์เนเธอไรต์"),
                Map.entry("ar_sa", "عملة جمع مكعب حمم نذريتية"),
                Map.entry("he_il", "מטבע איסוף קוביית מגמה נתרייט"),
                Map.entry("hi_in", "संग्रहणीय नेथेराइट का मैग्मा क्यूब सिक्का"),
                Map.entry("id_id", "Koin Koleksi Kubus Magma Netherite"),
                Map.entry("ms_my", "Syiling Koleksi Kiub Magma Netherite")
        ));
// Collectible Copper Slime Coin translations
        translations.put("collectible_coin_slime_copper", Map.ofEntries(
                Map.entry("en_us", "Collectible Copper Slime Coin"),
                Map.entry("en_gb", "Collectible Copper Slime Coin"),
                Map.entry("en_ca", "Collectible Copper Slime Coin"),
                Map.entry("en_au", "Collectible Copper Slime Coin"),
                Map.entry("en_pt", "Badge o' the Copper Slime"), // Pirate Speak

                Map.entry("de_de", "Sammel-Münze Kupfer-Schleim"),
                Map.entry("fr_fr", "Pièce de slime en cuivre de collection"),
                Map.entry("fr_ca", "Pièce de slime en cuivre de collection"),
                Map.entry("es_es", "Moneda coleccionable de slime de cobre"),
                Map.entry("es_mx", "Moneda coleccionable de slime de cobre"),
                Map.entry("pt_pt", "Moeda colecionável de gosma de cobre"),
                Map.entry("pt_br", "Moeda colecionável de gosma de cobre"),
                Map.entry("it_it", "Moneta collezionabile di melma in rame"),
                Map.entry("nl_nl", "Verzamelbare koperen slijmmunt"),
                Map.entry("ru_ru", "Коллекционная медная монета слизня"),
                Map.entry("uk_ua", "Колекційна мідна монета слизня"),
                Map.entry("pl_pl", "Kolekcjonerska miedziana moneta śluzu"),
                Map.entry("cs_cz", "Sběratelská měděná mince slizu"),
                Map.entry("sk_sk", "Zberateľská medená minca slizu"),
                Map.entry("hu_hu", "Gyűjthető réz nyálka érme"),
                Map.entry("sv_se", "Samlingsbar koppar-slemmynt"),
                Map.entry("no_no", "Samlebar kobberslimmynt"),
                Map.entry("da_dk", "Samlermønt med kobberslim"),
                Map.entry("fi_fi", "Keräiltävä kuparilimakolikko"),
                Map.entry("tr_tr", "Koleksiyonluk Bakır Slime Parası"),
                Map.entry("el_gr", "Συλλεκτικό νόμισμα slime από χαλκό"),
                Map.entry("ro_ro", "Monedă de colecție slime de cupru"),
                Map.entry("bg_bg", "Колекционерска медна монета на слуз"),
                Map.entry("zh_cn", "收藏铜史莱姆币"),
                Map.entry("zh_tw", "收藏銅史萊姆幣"),
                Map.entry("ja_jp", "コレクションカッパースライムコイン"),
                Map.entry("ko_kr", "수집용 구리 슬라임 동전"),
                Map.entry("th_th", "เหรียญเก็บสะสมสไลม์ทองแดง"),
                Map.entry("ar_sa", "عملة جمع سلايم نحاسية"),
                Map.entry("he_il", "מטבע איסוף סליים נחושת"),
                Map.entry("hi_in", "संग्रहणीय तांबे का स्लाइम सिक्का"),
                Map.entry("id_id", "Koin Koleksi Slime Tembaga"),
                Map.entry("ms_my", "Syiling Koleksi Slime Tembaga")
        ));

// Collectible Iron Slime Coin translations
        translations.put("collectible_coin_slime_iron", Map.ofEntries(
                Map.entry("en_us", "Collectible Iron Slime Coin"),
                Map.entry("en_gb", "Collectible Iron Slime Coin"),
                Map.entry("en_ca", "Collectible Iron Slime Coin"),
                Map.entry("en_au", "Collectible Iron Slime Coin"),
                Map.entry("en_pt", "Badge o' the Iron Slime"), // Pirate Speak

                Map.entry("de_de", "Sammel-Münze Eisen-Schleim"),
                Map.entry("fr_fr", "Pièce de slime en fer de collection"),
                Map.entry("fr_ca", "Pièce de slime en fer de collection"),
                Map.entry("es_es", "Moneda coleccionable de slime de hierro"),
                Map.entry("es_mx", "Moneda coleccionable de slime de hierro"),
                Map.entry("pt_pt", "Moeda colecionável de gosma de ferro"),
                Map.entry("pt_br", "Moeda colecionável de gosma de ferro"),
                Map.entry("it_it", "Moneta collezionabile di melma in ferro"),
                Map.entry("nl_nl", "Verzamelbare ijzeren slijmmunt"),
                Map.entry("ru_ru", "Коллекционная железная монета слизня"),
                Map.entry("uk_ua", "Колекційна залізна монета слизня"),
                Map.entry("pl_pl", "Kolekcjonerska żelazna moneta śluzu"),
                Map.entry("cs_cz", "Sběratelská železná mince slizu"),
                Map.entry("sk_sk", "Zberateľská železná minca slizu"),
                Map.entry("hu_hu", "Gyűjthető vas nyálka érme"),
                Map.entry("sv_se", "Samlingsbar järn-slemmynt"),
                Map.entry("no_no", "Samlebar jernslimmynt"),
                Map.entry("da_dk", "Samlermønt med jernslem"),
                Map.entry("fi_fi", "Keräiltävä rautalimakolikko"),
                Map.entry("tr_tr", "Koleksiyonluk Demir Slime Parası"),
                Map.entry("el_gr", "Συλλεκτικό νόμισμα slime από σίδερο"),
                Map.entry("ro_ro", "Monedă de colecție slime de fier"),
                Map.entry("bg_bg", "Колекционерска желязна монета на слуз"),
                Map.entry("zh_cn", "收藏铁史莱姆币"),
                Map.entry("zh_tw", "收藏鐵史萊姆幣"),
                Map.entry("ja_jp", "コレクションアイアンスライムコイン"),
                Map.entry("ko_kr", "수집용 철 슬라임 동전"),
                Map.entry("th_th", "เหรียญเก็บสะสมสไลม์เหล็ก"),
                Map.entry("ar_sa", "عملة جمع سلايم حديدية"),
                Map.entry("he_il", "מטבע איסוף סליים ברזל"),
                Map.entry("hi_in", "संग्रहणीय लोहे का स्लाइम सिक्का"),
                Map.entry("id_id", "Koin Koleksi Slime Besi"),
                Map.entry("ms_my", "Syiling Koleksi Slime Besi")
        ));

// Collectible Gold Slime Coin translations
        translations.put("collectible_coin_slime_gold", Map.ofEntries(
                Map.entry("en_us", "Collectible Gold Slime Coin"),
                Map.entry("en_gb", "Collectible Gold Slime Coin"),
                Map.entry("en_ca", "Collectible Gold Slime Coin"),
                Map.entry("en_au", "Collectible Gold Slime Coin"),
                Map.entry("en_pt", "Badge o' the Gold Slime"), // Pirate Speak

                Map.entry("de_de", "Sammel-Münze Gold-Schleim"),
                Map.entry("fr_fr", "Pièce de slime en or de collection"),
                Map.entry("fr_ca", "Pièce de slime en or de collection"),
                Map.entry("es_es", "Moneda coleccionable de slime de oro"),
                Map.entry("es_mx", "Moneda coleccionable de slime de oro"),
                Map.entry("pt_pt", "Moeda colecionável de gosma de ouro"),
                Map.entry("pt_br", "Moeda colecionável de gosma de ouro"),
                Map.entry("it_it", "Moneta collezionabile di melma in oro"),
                Map.entry("nl_nl", "Verzamelbare gouden slijmmunt"),
                Map.entry("ru_ru", "Коллекционная золотая монета слизня"),
                Map.entry("uk_ua", "Колекційна золота монета слизня"),
                Map.entry("pl_pl", "Kolekcjonerska złota moneta śluzu"),
                Map.entry("cs_cz", "Sběratelská zlatá mince slizu"),
                Map.entry("sk_sk", "Zberateľská zlatá minca slizu"),
                Map.entry("hu_hu", "Gyűjthető arany nyálka érme"),
                Map.entry("sv_se", "Samlingsbar guld-slemmynt"),
                Map.entry("no_no", "Samlebar gullslimmynt"),
                Map.entry("da_dk", "Samlermønt med guldslim"),
                Map.entry("fi_fi", "Keräiltävä kultalimakolikko"),
                Map.entry("tr_tr", "Koleksiyonluk Altın Slime Parası"),
                Map.entry("el_gr", "Συλλεκτικό νόμισμα slime από χρυσό"),
                Map.entry("ro_ro", "Monedă de colecție slime de aur"),
                Map.entry("bg_bg", "Колекционерска златна монета на слуз"),
                Map.entry("zh_cn", "收藏金史莱姆币"),
                Map.entry("zh_tw", "收藏金史萊姆幣"),
                Map.entry("ja_jp", "コレクションゴールドスライムコイン"),
                Map.entry("ko_kr", "수집용 금 슬라임 동전"),
                Map.entry("th_th", "เหรียญเก็บสะสมสไลม์ทอง"),
                Map.entry("ar_sa", "عملة جمع سلايم ذهبية"),
                Map.entry("he_il", "מטבע איסוף סליים זהב"),
                Map.entry("hi_in", "संग्रहणीय सोने का स्लाइम सिक्का"),
                Map.entry("id_id", "Koin Koleksi Slime Emas"),
                Map.entry("ms_my", "Syiling Koleksi Slime Emas")
        ));

// Collectible Netherite Slime Coin translations
        translations.put("collectible_coin_slime_netherite", Map.ofEntries(
                Map.entry("en_us", "Collectible Netherite Slime Coin"),
                Map.entry("en_gb", "Collectible Netherite Slime Coin"),
                Map.entry("en_ca", "Collectible Netherite Slime Coin"),
                Map.entry("en_au", "Collectible Netherite Slime Coin"),
                Map.entry("en_pt", "Badge o' the Netherite Slime"), // Pirate Speak

                Map.entry("de_de", "Sammel-Münze Netherit-Schleim"),
                Map.entry("fr_fr", "Pièce de slime en netherite de collection"),
                Map.entry("fr_ca", "Pièce de slime en netherite de collection"),
                Map.entry("es_es", "Moneda coleccionable de slime de netherite"),
                Map.entry("es_mx", "Moneda coleccionable de slime de netherite"),
                Map.entry("pt_pt", "Moeda colecionável de gosma de netherite"),
                Map.entry("pt_br", "Moeda colecionável de gosma de netherite"),
                Map.entry("it_it", "Moneta collezionabile di melma in netherite"),
                Map.entry("nl_nl", "Verzamelbare netheriet slijmmunt"),
                Map.entry("ru_ru", "Коллекционная незеритовая монета слизня"),
                Map.entry("uk_ua", "Колекційна незеритова монета слизня"),
                Map.entry("pl_pl", "Kolekcjonerska netherytowa moneta śluzu"),
                Map.entry("cs_cz", "Sběratelská netheritová mince slizu"),
                Map.entry("sk_sk", "Zberateľská netheritová minca slizu"),
                Map.entry("hu_hu", "Gyűjthető netherit nyálka érme"),
                Map.entry("sv_se", "Samlingsbar netherit-slemmynt"),
                Map.entry("no_no", "Samlebar netherit-slimmynt"),
                Map.entry("da_dk", "Samlermønt med netheritslim"),
                Map.entry("fi_fi", "Keräiltävä netheritlimakolikko"),
                Map.entry("tr_tr", "Koleksiyonluk Netherit Slime Parası"),
                Map.entry("el_gr", "Συλλεκτικό νόμισμα slime από νεδερίτη"),
                Map.entry("ro_ro", "Monedă de colecție slime de netherit"),
                Map.entry("bg_bg", "Колекционерска нетеритова монета на слуз"),
                Map.entry("zh_cn", "收藏下界合金史莱姆币"),
                Map.entry("zh_tw", "收藏下界合金史萊姆幣"),
                Map.entry("ja_jp", "コレクションネザライトスライムコイン"),
                Map.entry("ko_kr", "수집용 네더라이트 슬라임 동전"),
                Map.entry("th_th", "เหรียญเก็บสะสมสไลม์เนเธอไรต์"),
                Map.entry("ar_sa", "عملة جمع سلايم نذرايت"),
                Map.entry("he_il", "מטבע איסוף סליים נדרייט"),
                Map.entry("hi_in", "संग्रहणीय नेथराइट का स्लाइम सिक्का"),
                Map.entry("id_id", "Koin Koleksi Slime Netherite"),
                Map.entry("ms_my", "Syiling Koleksi Slime Netherite")
        ));

        return translations;
    }
}