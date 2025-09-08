package com.github.warrentode.todecoins.datagen.translations.items.collectible_coins;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("GrazieInspection")
public class HolidayCoinTranslations {
    // Map of item IDs → (language code → translated name)
    public static final Map<String, Map<String, String>> LANG_MAPS = createTranslationMaps();


    static @NotNull Map<String, Map<String, String>> createTranslationMaps() {
        Map<String, Map<String, String>> translations = new HashMap<>();

// Collectible Birthday Coin translations
        translations.put("collectible_coin_birthday", Map.ofEntries(
                Map.entry("en_us", "Collectible Birthday Coin"),
                Map.entry("en_gb", "Collectible Birthday Coin"),
                Map.entry("en_ca", "Collectible Birthday Coin"),
                Map.entry("en_au", "Collectible Birthday Coin"),
                Map.entry("en_pt", "Badge o' the Born Day Treasure"), // Pirate Speak

                Map.entry("de_de", "Sammelgeburtstagsmünze"),
                Map.entry("fr_fr", "Pièce d'anniversaire de collection"),
                Map.entry("fr_ca", "Pièce d'anniversaire de collection"),
                Map.entry("es_es", "Moneda de cumpleaños coleccionable"),
                Map.entry("es_mx", "Moneda de cumpleaños coleccionable"),
                Map.entry("pt_pt", "Moeda colecionável de aniversário"),
                Map.entry("pt_br", "Moeda colecionável de aniversário"),
                Map.entry("it_it", "Moneta da compleanno da collezione"),
                Map.entry("nl_nl", "Verzamelbare verjaardagsmunt"),
                Map.entry("ru_ru", "Коллекционная монета на день рождения"),
                Map.entry("uk_ua", "Колекційна монета на день народження"),
                Map.entry("pl_pl", "Kolekcjonerska moneta urodzinowa"),
                Map.entry("cs_cz", "Sběratelská narozeninová mince"),
                Map.entry("sk_sk", "Zberateľská narodeninová minca"),
                Map.entry("hu_hu", "Gyűjthető születésnapi érme"),
                Map.entry("sv_se", "Samlingsbar födelsedagsmynt"),
                Map.entry("no_no", "Samlebar bursdagsmynt"),
                Map.entry("da_dk", "Samlermønt til fødselsdag"),
                Map.entry("fi_fi", "Keräiltävä syntymäpäiväkolikko"),
                Map.entry("tr_tr", "Koleksiyonluk Doğum Günü Parası"),
                Map.entry("el_gr", "Συλλεκτικό νόμισμα γενεθλίων"),
                Map.entry("ro_ro", "Monedă de colecție de ziua de naștere"),
                Map.entry("bg_bg", "Колекционерска монета за рожден ден"),
                Map.entry("zh_cn", "收藏生日币"),
                Map.entry("zh_tw", "收藏生日幣"),
                Map.entry("ja_jp", "コレクション誕生日コイン"),
                Map.entry("ko_kr", "수집용 생일 동전"),
                Map.entry("th_th", "เหรียญวันเกิดสะสม"),
                Map.entry("ar_sa", "عملة عيد ميلاد قابلة للجمع"),
                Map.entry("he_il", "מטבע יום הולדת לאספנים"),
                Map.entry("hi_in", "संग्रहणीय जन्मदिन सिक्का"),
                Map.entry("id_id", "Koin Ulang Tahun Koleksi"),
                Map.entry("ms_my", "Syiling Koleksi Hari Jadi")
        ));
// Collectible Christmas Coin translations
        translations.put("collectible_coin_christmas", Map.ofEntries(
                Map.entry("en_us", "Collectible Christmas Coin"),
                Map.entry("en_gb", "Collectible Christmas Coin"),
                Map.entry("en_ca", "Collectible Christmas Coin"),
                Map.entry("en_au", "Collectible Christmas Coin"),
                Map.entry("en_pt", "Badge o' the Yuletide Treasure"), // Pirate Speak

                Map.entry("de_de", "Sammel-Weihnachtsmünze"),
                Map.entry("fr_fr", "Pièce de Noël de collection"),
                Map.entry("fr_ca", "Pièce de Noël de collection"),
                Map.entry("es_es", "Moneda coleccionable de Navidad"),
                Map.entry("es_mx", "Moneda coleccionable de Navidad"),
                Map.entry("pt_pt", "Moeda colecionável de Natal"),
                Map.entry("pt_br", "Moeda colecionável de Natal"),
                Map.entry("it_it", "Moneta natalizia da collezione"),
                Map.entry("nl_nl", "Verzamelbare kerstmunt"),
                Map.entry("ru_ru", "Коллекционная рождественская монета"),
                Map.entry("uk_ua", "Колекційна різдвяна монета"),
                Map.entry("pl_pl", "Kolekcjonerska moneta świąteczna"),
                Map.entry("cs_cz", "Sběratelská vánoční mince"),
                Map.entry("sk_sk", "Zberateľská vianočná minca"),
                Map.entry("hu_hu", "Gyűjthető karácsonyi érme"),
                Map.entry("sv_se", "Samlingsbar julmynt"),
                Map.entry("no_no", "Samlebar julemynt"),
                Map.entry("da_dk", "Samlermønt til jul"),
                Map.entry("fi_fi", "Keräiltävä joulukolikko"),
                Map.entry("tr_tr", "Koleksiyonluk Noel Parası"),
                Map.entry("el_gr", "Συλλεκτικό χριστουγεννιάτικο νόμισμα"),
                Map.entry("ro_ro", "Monedă de colecție de Crăciun"),
                Map.entry("bg_bg", "Колекционерска коледна монета"),
                Map.entry("zh_cn", "收藏圣诞币"),
                Map.entry("zh_tw", "收藏聖誕幣"),
                Map.entry("ja_jp", "コレクションクリスマスコイン"),
                Map.entry("ko_kr", "수집용 크리스마스 동전"),
                Map.entry("th_th", "เหรียญคริสต์มาสสะสม"),
                Map.entry("ar_sa", "عملة عيد الميلاد قابلة للجمع"),
                Map.entry("he_il", "מטבע איסוף לחג המולד"),
                Map.entry("hi_in", "संग्रहणीय क्रिसमस सिक्का"),
                Map.entry("id_id", "Koin Koleksi Natal"),
                Map.entry("ms_my", "Syiling Koleksi Krismas")
        ));
// Collectible Halloween Coin translations
        translations.put("collectible_coin_halloween", Map.ofEntries(
                Map.entry("en_us", "Collectible Halloween Coin"),
                Map.entry("en_gb", "Collectible Halloween Coin"),
                Map.entry("en_ca", "Collectible Halloween Coin"),
                Map.entry("en_au", "Collectible Halloween Coin"),
                Map.entry("en_pt", "Badge o' the Haunting Night"), // Pirate Speak

                Map.entry("de_de", "Sammel-Halloweenmünze"),
                Map.entry("fr_fr", "Pièce d'Halloween de collection"),
                Map.entry("fr_ca", "Pièce d'Halloween de collection"),
                Map.entry("es_es", "Moneda coleccionable de Halloween"),
                Map.entry("es_mx", "Moneda coleccionable de Halloween"),
                Map.entry("pt_pt", "Moeda colecionável de Halloween"),
                Map.entry("pt_br", "Moeda colecionável de Halloween"),
                Map.entry("it_it", "Moneta di Halloween da collezione"),
                Map.entry("nl_nl", "Verzamelbare Halloweenmunt"),
                Map.entry("ru_ru", "Коллекционная хэллоуинская монета"),
                Map.entry("uk_ua", "Колекційна монета на Геловін"),
                Map.entry("pl_pl", "Kolekcjonerska moneta halloweenowa"),
                Map.entry("cs_cz", "Sběratelská halloweenová mince"),
                Map.entry("sk_sk", "Zberateľská halloweenská minca"),
                Map.entry("hu_hu", "Gyűjthető halloween érméje"),
                Map.entry("sv_se", "Samlingsbar halloweenmynt"),
                Map.entry("no_no", "Samlebar halloweenmynt"),
                Map.entry("da_dk", "Samlermønt til halloween"),
                Map.entry("fi_fi", "Keräiltävä halloween-kolikko"),
                Map.entry("tr_tr", "Koleksiyonluk Cadılar Bayramı Parası"),
                Map.entry("el_gr", "Συλλεκτικό νόμισμα Χάλογουιν"),
                Map.entry("ro_ro", "Monedă de colecție de Halloween"),
                Map.entry("bg_bg", "Колекционерска хелоуин монета"),
                Map.entry("zh_cn", "收藏万圣节币"),
                Map.entry("zh_tw", "收藏萬聖節幣"),
                Map.entry("ja_jp", "コレクションハロウィンコイン"),
                Map.entry("ko_kr", "수집용 할로윈 동전"),
                Map.entry("th_th", "เหรียญฮาโลวีนสะสม"),
                Map.entry("ar_sa", "عملة هالووين قابلة للجمع"),
                Map.entry("he_il", "מטבע איסוף ליל כל הקדושים"),
                Map.entry("hi_in", "संग्रहणीय हैलोवीन सिक्का"),
                Map.entry("id_id", "Koin Koleksi Halloween"),
                Map.entry("ms_my", "Syiling Koleksi Halloween")
        ));
// Collectible Easter Coin translations
        translations.put("collectible_coin_easter", Map.ofEntries(
                Map.entry("en_us", "Collectible Easter Coin"),
                Map.entry("en_gb", "Collectible Easter Coin"),
                Map.entry("en_ca", "Collectible Easter Coin"),
                Map.entry("en_au", "Collectible Easter Coin"),
                Map.entry("en_pt", "Badge o' the Springtide Treasure"), // Pirate Speak

                Map.entry("de_de", "Sammel-Ostermünze"),
                Map.entry("fr_fr", "Pièce de Pâques de collection"),
                Map.entry("fr_ca", "Pièce de Pâques de collection"),
                Map.entry("es_es", "Moneda coleccionable de Pascua"),
                Map.entry("es_mx", "Moneda coleccionable de Pascua"),
                Map.entry("pt_pt", "Moeda colecionável de Páscoa"),
                Map.entry("pt_br", "Moeda colecionável de Páscoa"),
                Map.entry("it_it", "Moneta pasquale da collezione"),
                Map.entry("nl_nl", "Verzamelbare paasmunt"),
                Map.entry("ru_ru", "Коллекционная пасхальная монета"),
                Map.entry("uk_ua", "Колекційна пасхальна монета"),
                Map.entry("pl_pl", "Kolekcjonerska moneta wielkanocna"),
                Map.entry("cs_cz", "Sběratelská velikonoční mince"),
                Map.entry("sk_sk", "Zberateľská veľkonočná minca"),
                Map.entry("hu_hu", "Gyűjthető húsvéti érme"),
                Map.entry("sv_se", "Samlingsbar påskmynt"),
                Map.entry("no_no", "Samlebar påskemynt"),
                Map.entry("da_dk", "Samlermønt til påske"),
                Map.entry("fi_fi", "Keräiltävä pääsiäiskolikko"),
                Map.entry("tr_tr", "Koleksiyonluk Paskalya Parası"),
                Map.entry("el_gr", "Συλλεκτικό πασχαλινό νόμισμα"),
                Map.entry("ro_ro", "Monedă de colecție de Paște"),
                Map.entry("bg_bg", "Колекционерска великденска монета"),
                Map.entry("zh_cn", "收藏复活节币"),
                Map.entry("zh_tw", "收藏復活節幣"),
                Map.entry("ja_jp", "コレクションイースターコイン"),
                Map.entry("ko_kr", "수집용 부활절 동전"),
                Map.entry("th_th", "เหรียญอีสเตอร์สะสม"),
                Map.entry("ar_sa", "عملة عيد الفصح قابلة للجمع"),
                Map.entry("he_il", "מטבע איסוף לחג הפסחא"),
                Map.entry("hi_in", "संग्रहणीय ईस्टर सिक्का"),
                Map.entry("id_id", "Koin Koleksi Paskah"),
                Map.entry("ms_my", "Syiling Koleksi Paskah")
        ));
// Collectible New Year Coin translations
        translations.put("collectible_coin_new_year", Map.ofEntries(
                Map.entry("en_us", "Collectible New Year Coin"),
                Map.entry("en_gb", "Collectible New Year Coin"),
                Map.entry("en_ca", "Collectible New Year Coin"),
                Map.entry("en_au", "Collectible New Year Coin"),
                Map.entry("en_pt", "Badge o' the New Year's Cheer"), // Pirate Speak

                Map.entry("de_de", "Sammel-Neujahrsmünze"),
                Map.entry("fr_fr", "Pièce du Nouvel An de collection"),
                Map.entry("fr_ca", "Pièce du Nouvel An de collection"),
                Map.entry("es_es", "Moneda coleccionable de Año Nuevo"),
                Map.entry("es_mx", "Moneda coleccionable de Año Nuevo"),
                Map.entry("pt_pt", "Moeda colecionável de Ano Novo"),
                Map.entry("pt_br", "Moeda colecionável de Ano Novo"),
                Map.entry("it_it", "Moneta di Capodanno da collezione"),
                Map.entry("nl_nl", "Verzamelbare nieuwjaarsmunt"),
                Map.entry("ru_ru", "Коллекционная новогодняя монета"),
                Map.entry("uk_ua", "Колекційна новорічна монета"),
                Map.entry("pl_pl", "Kolekcjonerska moneta noworoczna"),
                Map.entry("cs_cz", "Sběratelská novoroční mince"),
                Map.entry("sk_sk", "Zberateľská novoročná minca"),
                Map.entry("hu_hu", "Gyűjthető újévi érme"),
                Map.entry("sv_se", "Samlingsbar nyårsmyn"),
                Map.entry("no_no", "Samlebar nyttårsmyn"),
                Map.entry("da_dk", "Samlermønt til nytår"),
                Map.entry("fi_fi", "Keräiltävä uudenvuoden kolikko"),
                Map.entry("tr_tr", "Koleksiyonluk Yeni Yıl Parası"),
                Map.entry("el_gr", "Συλλεκτικό νόμισμα Πρωτοχρονιάς"),
                Map.entry("ro_ro", "Monedă de colecție de Anul Nou"),
                Map.entry("bg_bg", "Колекционерска новогодишна монета"),
                Map.entry("zh_cn", "收藏新年币"),
                Map.entry("zh_tw", "收藏新年幣"),
                Map.entry("ja_jp", "コレクションニューイヤーコイン"),
                Map.entry("ko_kr", "수집용 새해 동전"),
                Map.entry("th_th", "เหรียญปีใหม่สะสม"),
                Map.entry("ar_sa", "عملة رأس السنة قابلة للجمع"),
                Map.entry("he_il", "מטבע איסוף לשנה החדשה"),
                Map.entry("hi_in", "संग्रहणीय नववर्ष सिक्का"),
                Map.entry("id_id", "Koin Koleksi Tahun Baru"),
                Map.entry("ms_my", "Syiling Koleksi Tahun Baru")
        ));

        return translations;
    }
}