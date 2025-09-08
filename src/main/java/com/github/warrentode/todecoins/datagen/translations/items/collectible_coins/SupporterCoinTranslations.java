package com.github.warrentode.todecoins.datagen.translations.items.collectible_coins;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class SupporterCoinTranslations {
    // Map of item IDs → (language code → translated name)
    public static final Map<String, Map<String, String>> LANG_MAPS = createTranslationMaps();


    static @NotNull Map<String, Map<String, String>> createTranslationMaps() {
        Map<String, Map<String, String>> translations = new HashMap<>();

// Collectible Scholar Owl Coin translations
        translations.put("collectible_coin_scholar_owl", Map.ofEntries(
                Map.entry("en_us", "Collectible Scholar Owl Coin"),
                Map.entry("en_gb", "Collectible Scholar Owl Coin"),
                Map.entry("en_ca", "Collectible Scholar Owl Coin"),
                Map.entry("en_au", "Collectible Scholar Owl Coin"),
                Map.entry("en_pt", "Badge o' the Wise Feather"), // Pirate Speak

                Map.entry("de_de", "Sammel-SchulEulenmünze"),
                Map.entry("fr_fr", "Pièce du hibou érudit de collection"),
                Map.entry("fr_ca", "Pièce du hibou érudit de collection"),
                Map.entry("es_es", "Moneda coleccionable del búho erudito"),
                Map.entry("es_mx", "Moneda coleccionable del búho erudito"),
                Map.entry("pt_pt", "Moeda colecionável do Coruja Sábia"),
                Map.entry("pt_br", "Moeda colecionável da Coruja Sábia"),
                Map.entry("it_it", "Moneta del gufo studioso da collezione"),
                Map.entry("nl_nl", "Verzamelbare geleerde uilenmunt"),
                Map.entry("ru_ru", "Коллекционная монета ученой совы"),
                Map.entry("uk_ua", "Колекційна монета вченої сови"),
                Map.entry("pl_pl", "Kolekcjonerska moneta mądrej sowy"),
                Map.entry("cs_cz", "Sběratelská mince učené sovy"),
                Map.entry("sk_sk", "Zberateľská minca múdrej sovy"),
                Map.entry("hu_hu", "Gyűjthető tudós bagoly érme"),
                Map.entry("sv_se", "Samlingsbar lärd ugglemynth"),
                Map.entry("no_no", "Samlebar lærd uglemynt"),
                Map.entry("da_dk", "Samlermønt med lærdomme ugle"),
                Map.entry("fi_fi", "Keräiltävä oppinut pöllöraha"),
                Map.entry("tr_tr", "Koleksiyonluk Bilge Baykuş Parası"),
                Map.entry("el_gr", "Συλλεκτικό νόμισμα σοφής κουκουβάγιας"),
                Map.entry("ro_ro", "Monedă de colecție cu bufniță înțeleaptă"),
                Map.entry("bg_bg", "Колекционерска монета на учен бухал"),
                Map.entry("zh_cn", "收藏学者猫头鹰币"),
                Map.entry("zh_tw", "收藏學者貓頭鷹幣"),
                Map.entry("ja_jp", "コレクション賢者のフクロウコイン"),
                Map.entry("ko_kr", "수집용 학자 부엉이 동전"),
                Map.entry("th_th", "เหรียญนกฮูกนักปราชญ์สะสม"),
                Map.entry("ar_sa", "عملة البومة العالِم القابلة للجمع"),
                Map.entry("he_il", "מטבע איסוף ינשוף חכם"),
                Map.entry("hi_in", "संग्रहणीय विद्वान उल्लू सिक्का"),
                Map.entry("id_id", "Koin Koleksi Burung Hantu Cendekia"),
                Map.entry("ms_my", "Syiling Koleksi Burung Hantu Bijak")
        ));
// Collectible Tuxedo Cat Coin translations
        translations.put("collectible_coin_tuxedo_cat", Map.ofEntries(
                Map.entry("en_us", "Collectible Tuxedo Cat Coin"),
                Map.entry("en_gb", "Collectible Tuxedo Cat Coin"),
                Map.entry("en_ca", "Collectible Tuxedo Cat Coin"),
                Map.entry("en_au", "Collectible Tuxedo Cat Coin"),
                Map.entry("en_pt", "Badge o' the Dapper Paws"), // Pirate Speak

                Map.entry("de_de", "Sammel-Anzugkatzenmünze"),
                Map.entry("fr_fr", "Pièce du chat en smoking de collection"),
                Map.entry("fr_ca", "Pièce du chat en smoking de collection"),
                Map.entry("es_es", "Moneda coleccionable del gato esmoquin"),
                Map.entry("es_mx", "Moneda coleccionable del gato esmoquin"),
                Map.entry("pt_pt", "Moeda colecionável do Gato de Smoking"),
                Map.entry("pt_br", "Moeda colecionável do Gato de Smoking"),
                Map.entry("it_it", "Moneta del gatto in smoking da collezione"),
                Map.entry("nl_nl", "Verzamelbare smokingkattenmunt"),
                Map.entry("ru_ru", "Коллекционная монета кота в смокинге"),
                Map.entry("uk_ua", "Колекційна монета кота в смокінгу"),
                Map.entry("pl_pl", "Kolekcjonerska moneta kota w smokingu"),
                Map.entry("cs_cz", "Sběratelská mince kočky v smokingu"),
                Map.entry("sk_sk", "Zberateľská minca mačky v smokingu"),
                Map.entry("hu_hu", "Gyűjthető szmokingos macska érme"),
                Map.entry("sv_se", "Samlingsbar smokingkattmynt"),
                Map.entry("no_no", "Samlebar smokingkattemynt"),
                Map.entry("da_dk", "Samlermønt med smokingkat"),
                Map.entry("fi_fi", "Keräiltävä smokki-kissaraha"),
                Map.entry("tr_tr", "Koleksiyonluk Smokinli Kedi Parası"),
                Map.entry("el_gr", "Συλλεκτικό νόμισμα γάτας με σμόκιν"),
                Map.entry("ro_ro", "Monedă de colecție cu pisică în tuxedo"),
                Map.entry("bg_bg", "Колекционерска монета на котка с фрак"),
                Map.entry("zh_cn", "收藏燕尾服猫币"),
                Map.entry("zh_tw", "收藏燕尾服貓幣"),
                Map.entry("ja_jp", "コレクションタキシードキャットコイン"),
                Map.entry("ko_kr", "수집용 턱시도 고양이 동전"),
                Map.entry("th_th", "เหรียญแมวทักซิโด้สะสม"),
                Map.entry("ar_sa", "عملة القط ببدلة التكسيدو القابلة للجمع"),
                Map.entry("he_il", "מטבע איסוף חתול טוקסידו"),
                Map.entry("hi_in", "संग्रहणीय टक्सीडो बिल्ली सिक्का"),
                Map.entry("id_id", "Koin Koleksi Kucing Tuxedo"),
                Map.entry("ms_my", "Syiling Koleksi Kucing Tuxedo")
        ));
// Collectible Little Bear Coin translations
        translations.put("collectible_coin_little_bear", Map.ofEntries(
                Map.entry("en_us", "Collectible Little Bear Coin"),
                Map.entry("en_gb", "Collectible Little Bear Coin"),
                Map.entry("en_ca", "Collectible Little Bear Coin"),
                Map.entry("en_au", "Collectible Little Bear Coin"),
                Map.entry("en_pt", "Badge o' the Wee Bearkin"), // Pirate Speak

                Map.entry("de_de", "Sammel-Kleiner Bärenmünze"),
                Map.entry("fr_fr", "Pièce du petit ours de collection"),
                Map.entry("fr_ca", "Pièce du petit ours de collection"),
                Map.entry("es_es", "Moneda coleccionable del osito"),
                Map.entry("es_mx", "Moneda coleccionable del osito"),
                Map.entry("pt_pt", "Moeda colecionável do Ursinho"),
                Map.entry("pt_br", "Moeda colecionável do Ursinho"),
                Map.entry("it_it", "Moneta del piccolo orso da collezione"),
                Map.entry("nl_nl", "Verzamelbare kleine berenmunt"),
                Map.entry("ru_ru", "Коллекционная монета маленького медвежонка"),
                Map.entry("uk_ua", "Колекційна монета маленького ведмедика"),
                Map.entry("pl_pl", "Kolekcjonerska moneta małego misia"),
                Map.entry("cs_cz", "Sběratelská mince malého medvěda"),
                Map.entry("sk_sk", "Zberateľská minca malého medveďa"),
                Map.entry("hu_hu", "Gyűjthető kis medve érme"),
                Map.entry("sv_se", "Samlingsbar liten björnmynt"),
                Map.entry("no_no", "Samlebar liten bjørnemynt"),
                Map.entry("da_dk", "Samlermønt med lille bjørn"),
                Map.entry("fi_fi", "Keräiltävä pieni karharaha"),
                Map.entry("tr_tr", "Koleksiyonluk Küçük Ayı Parası"),
                Map.entry("el_gr", "Συλλεκτικό νόμισμα μικρού αρκούδου"),
                Map.entry("ro_ro", "Monedă de colecție cu ursuleț"),
                Map.entry("bg_bg", "Колекционерска монета на малко мече"),
                Map.entry("zh_cn", "收藏小熊币"),
                Map.entry("zh_tw", "收藏小熊幣"),
                Map.entry("ja_jp", "コレクションリトルベアコイン"),
                Map.entry("ko_kr", "수집용 작은 곰 동전"),
                Map.entry("th_th", "เหรียญลูกหมีสะสม"),
                Map.entry("ar_sa", "عملة الدب الصغير القابلة للجمع"),
                Map.entry("he_il", "מטבע איסוף דוב קטן"),
                Map.entry("hi_in", "संग्रहणीय छोटा भालू सिक्का"),
                Map.entry("id_id", "Koin Koleksi Beruang Kecil"),
                Map.entry("ms_my", "Syiling Koleksi Beruang Kecil")
        ));
// Collectible Carnation Patron Coin translations
        translations.put("collectible_coin_patron_carnation", Map.ofEntries(
                Map.entry("en_us", "Collectible Carnation Patron Coin"),
                Map.entry("en_gb", "Collectible Carnation Patron Coin"),
                Map.entry("en_ca", "Collectible Carnation Patron Coin"),
                Map.entry("en_au", "Collectible Carnation Patron Coin"),
                Map.entry("en_pt", "Badge o' the Carnation Patron"), // Pirate Speak

                Map.entry("de_de", "Sammel-Münze Patron Nelke"),
                Map.entry("fr_fr", "Pièce de collection Patron Œillet"),
                Map.entry("fr_ca", "Pièce de collection Patron Œillet"),
                Map.entry("es_es", "Moneda coleccionable Patrón Clavel"),
                Map.entry("es_mx", "Moneda coleccionable Patrón Clavel"),
                Map.entry("pt_pt", "Moeda colecionável Patron Cravo"),
                Map.entry("pt_br", "Moeda colecionável Patron Cravo"),
                Map.entry("it_it", "Moneta collezionabile Patron Garofano"),
                Map.entry("nl_nl", "Verzamelbare Patron anjermunt"),
                Map.entry("ru_ru", "Коллекционная монета Патрон Гвоздика"),
                Map.entry("uk_ua", "Колекційна монета Патрон Гвоздика"),
                Map.entry("pl_pl", "Kolekcjonerska moneta Patron Goździka"),
                Map.entry("cs_cz", "Sběratelská mince Patron karafiátu"),
                Map.entry("sk_sk", "Zberateľská minca Patron karafiátu"),
                Map.entry("hu_hu", "Gyűjthető Patron szegfű érmé"),
                Map.entry("sv_se", "Samlingsbar Patron Nejlikamynt"),
                Map.entry("no_no", "Samlebar Patron Nellike-mynt"),
                Map.entry("da_dk", "Samlermønt Patron Nellike"),
                Map.entry("fi_fi", "Keräiltävä Patron Neilikka kolikko"),
                Map.entry("tr_tr", "Koleksiyonluk Patron Karanfil Parası"),
                Map.entry("el_gr", "Συλλεκτικό νόμισμα Patron Γαρίφαλο"),
                Map.entry("ro_ro", "Monedă de colecție Patron Garoafa"),
                Map.entry("bg_bg", "Колекционерска монета Патрон Гвоздика"),
                Map.entry("zh_cn", "收藏 Patron 康乃馨币"),
                Map.entry("zh_tw", "收藏 Patron 康乃馨幣"),
                Map.entry("ja_jp", "コレクション Patron カーネーションコイン"),
                Map.entry("ko_kr", "수집용 Patron 카네이션 동전"),
                Map.entry("th_th", "เหรียญสะสม Patron ดอกคาร์เนชั่น"),
                Map.entry("ar_sa", "عملة جمع Patron القرنفل"),
                Map.entry("he_il", "מטבע איסוף Patron ציפורן"),
                Map.entry("hi_in", "संग्रहणीय Patron कारनेशन सिक्का"),
                Map.entry("id_id", "Koin Koleksi Patron Anyelir"),
                Map.entry("ms_my", "Syiling Koleksi Patron Anyelir")
        ));
// Collectible Cosmos Patron Coin translations
        translations.put("collectible_coin_patron_cosmos", Map.ofEntries(
                Map.entry("en_us", "Collectible Cosmos Patron Coin"),
                Map.entry("en_gb", "Collectible Cosmos Patron Coin"),
                Map.entry("en_ca", "Collectible Cosmos Patron Coin"),
                Map.entry("en_au", "Collectible Cosmos Patron Coin"),
                Map.entry("en_pt", "Badge o' the Cosmos Patron"), // Pirate Speak

                Map.entry("de_de", "Sammel-Münze Patron Kosmos"),
                Map.entry("fr_fr", "Pièce de collection Patron Cosmos"),
                Map.entry("fr_ca", "Pièce de collection Patron Cosmos"),
                Map.entry("es_es", "Moneda coleccionable Patron Cosmos"),
                Map.entry("es_mx", "Moneda coleccionable Patron Cosmos"),
                Map.entry("pt_pt", "Moeda colecionável Patron Cosmos"),
                Map.entry("pt_br", "Moeda colecionável Patron Cosmos"),
                Map.entry("it_it", "Moneta collezionabile Patron Cosmo"),
                Map.entry("nl_nl", "Verzamelbare Patron kosmos munt"),
                Map.entry("ru_ru", "Коллекционная монета Патрон Космос"),
                Map.entry("uk_ua", "Колекційна монета Патрон Космос"),
                Map.entry("pl_pl", "Kolekcjonerska moneta Patron Kosmos"),
                Map.entry("cs_cz", "Sběratelská mince Patron vesmír"),
                Map.entry("sk_sk", "Zberateľská minca Patron vesmír"),
                Map.entry("hu_hu", "Gyűjthető Patron univerzum érme"),
                Map.entry("sv_se", "Samlingsbar Patron Kosmos-mynt"),
                Map.entry("no_no", "Samlebar Patron Kosmos-mynt"),
                Map.entry("da_dk", "Samlermønt Patron Kosmos"),
                Map.entry("fi_fi", "Keräiltävä Patron Kosmos kolikko"),
                Map.entry("tr_tr", "Koleksiyonluk Patron Kozmos Parası"),
                Map.entry("el_gr", "Συλλεκτικό νόμισμα Patron Σύμπαν"),
                Map.entry("ro_ro", "Monedă de colecție Patron Cosmos"),
                Map.entry("bg_bg", "Колекционерска монета Патрон Космос"),
                Map.entry("zh_cn", "收藏 Patron 宇宙币"),
                Map.entry("zh_tw", "收藏 Patron 宇宙幣"),
                Map.entry("ja_jp", "コレクション Patron 宇宙コイン"),
                Map.entry("ko_kr", "수집용 Patron 우주 동전"),
                Map.entry("th_th", "เหรียญสะสม Patron จักรวาล"),
                Map.entry("ar_sa", "عملة جمع Patron الكون"),
                Map.entry("he_il", "מטבע איסוף Patron קוסמוס"),
                Map.entry("hi_in", "संग्रहणीय Patron ब्रह्मांड सिक्का"),
                Map.entry("id_id", "Koin Koleksi Patron Kosmos"),
                Map.entry("ms_my", "Syiling Koleksi Patron Kosmos")
        ));
// Collectible Sunflower Patron Coin translations
        translations.put("collectible_coin_patron_sunflower", Map.ofEntries(
                Map.entry("en_us", "Collectible Sunflower Patron Coin"),
                Map.entry("en_gb", "Collectible Sunflower Patron Coin"),
                Map.entry("en_ca", "Collectible Sunflower Patron Coin"),
                Map.entry("en_au", "Collectible Sunflower Patron Coin"),
                Map.entry("en_pt", "Badge o' the Sunflower Patron"), // Pirate Speak

                Map.entry("de_de", "Sammel-Münze Patron Sonnenblume"),
                Map.entry("fr_fr", "Pièce de collection Patron Tournesol"),
                Map.entry("fr_ca", "Pièce de collection Patron Tournesol"),
                Map.entry("es_es", "Moneda coleccionable Patron Girasol"),
                Map.entry("es_mx", "Moneda coleccionable Patron Girasol"),
                Map.entry("pt_pt", "Moeda colecionável Patron Girassol"),
                Map.entry("pt_br", "Moeda colecionável Patron Girassol"),
                Map.entry("it_it", "Moneta collezionabile Patron Girasole"),
                Map.entry("nl_nl", "Verzamelbare Patron zonnebloem munt"),
                Map.entry("ru_ru", "Коллекционная монета Патрон Подсолнечник"),
                Map.entry("uk_ua", "Колекційна монета Патрон Соняшник"),
                Map.entry("pl_pl", "Kolekcjonerska moneta Patron Słonecznik"),
                Map.entry("cs_cz", "Sběratelská mince Patron slunečnice"),
                Map.entry("sk_sk", "Zberateľská minca Patron slnečnica"),
                Map.entry("hu_hu", "Gyűjthető Patron napraforgó érme"),
                Map.entry("sv_se", "Samlingsbar Patron Solros-mynt"),
                Map.entry("no_no", "Samlebar Patron Solsikke-mynt"),
                Map.entry("da_dk", "Samlermønt Patron Solsikke"),
                Map.entry("fi_fi", "Keräiltävä Patron Auringonkukka kolikko"),
                Map.entry("tr_tr", "Koleksiyonluk Patron Ayçiçeği Parası"),
                Map.entry("el_gr", "Συλλεκτικό νόμισμα Patron Ηλίανθος"),
                Map.entry("ro_ro", "Monedă de colecție Patron Floarea-soarelui"),
                Map.entry("bg_bg", "Колекционерска монета Патрон Слънчоглед"),
                Map.entry("zh_cn", "收藏 Patron 向日葵币"),
                Map.entry("zh_tw", "收藏 Patron 向日葵幣"),
                Map.entry("ja_jp", "コレクション Patron ヒマワリコイン"),
                Map.entry("ko_kr", "수집용 Patron 해바라기 동전"),
                Map.entry("th_th", "เหรียญสะสม Patron ดอกทานตะวัน"),
                Map.entry("ar_sa", "عملة جمع Patron زهرة دوار الشمس"),
                Map.entry("he_il", "מטבע איסוף Patron חמנייה"),
                Map.entry("hi_in", "संग्रहणीय Patron सूरजमुखी सिक्का"),
                Map.entry("id_id", "Koin Koleksi Patron Bunga Matahari"),
                Map.entry("ms_my", "Syiling Koleksi Patron Bunga Matahari")
        ));

        return translations;
    }
}