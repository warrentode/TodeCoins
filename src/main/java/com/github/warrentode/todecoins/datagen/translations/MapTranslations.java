package com.github.warrentode.todecoins.datagen.translations;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class MapTranslations {
    // Map of item IDs → (language code → translated name)
    public static final Map<String, Map<String, String>> LANG_MAPS = createTranslations();
    public static final Map<String, Map<String, String>> TOOLTIP_PER_LOCALE = createTooltipTranslations();

    @Contract(pure = true)
    private static @NotNull Map<String, Map<String, String>> createTranslations() {
        Map<String, Map<String, String>> translations = new HashMap<>();

        // End of the Rainbow Map
        translations.put("filled_map.rainbow_end", Map.ofEntries(
                Map.entry("en_us", "End of the Rainbow"),
                Map.entry("en_gb", "End of the Rainbow"),
                Map.entry("en_ca", "End of the Rainbow"),
                Map.entry("en_au", "End of the Rainbow"),
                Map.entry("en_pt", "Map o' Rainbow's End"), // Pirate Speak or keep English

                Map.entry("de_de", "Ende des Regenbogens"),
                Map.entry("fr_fr", "Fin de l'arc-en-ciel"),
                Map.entry("fr_ca", "Fin de l'arc-en-ciel"),
                Map.entry("es_es", "Fin del Arcoíris"),
                Map.entry("es_mx", "Fin del Arcoíris"),
                Map.entry("pt_pt", "Fim do Arco-Íris"),
                Map.entry("pt_br", "Fim do Arco-Íris"),
                Map.entry("it_it", "Fine dell'Arcobaleno"),
                Map.entry("nl_nl", "Einde van de Regenboog"),
                Map.entry("ru_ru", "Конец радуги"),
                Map.entry("uk_ua", "Кінець веселки"),
                Map.entry("pl_pl", "Koniec Tęczy"),
                Map.entry("cs_cz", "Konec duhy"),
                Map.entry("sk_sk", "Koniec dúhy"),
                Map.entry("hu_hu", "A szivárvány vége"),
                Map.entry("sv_se", "Regnbågens slut"),
                Map.entry("no_no", "Regnbuens ende"),
                Map.entry("da_dk", "Regnbuens ende"),
                Map.entry("fi_fi", "Sateenkaaren loppu"),
                Map.entry("tr_tr", "Gökkuşağının Sonu"),
                Map.entry("el_gr", "Τέλος του Ουράνιου Τόξου"),
                Map.entry("ro_ro", "Sfârșitul curcubeului"),
                Map.entry("bg_bg", "Краят на дъгата"),
                Map.entry("zh_cn", "彩虹尽头"),
                Map.entry("zh_tw", "彩虹盡頭"),
                Map.entry("ja_jp", "虹の終わり"),
                Map.entry("ko_kr", "무지개의 끝"),
                Map.entry("th_th", "ปลายรุ้ง"),
                Map.entry("ar_sa", "نهاية قوس قزح"),
                Map.entry("he_il", "סוף הקשת"),
                Map.entry("hi_in", "इंद्रधनुष का अंत"),
                Map.entry("id_id", "Ujung Pelangi"),
                Map.entry("ms_my", "Hujung Pelangi")
        ));

        // Explorer's Map
        translations.put("filled_map.overworld_poi", Map.ofEntries(
                Map.entry("en_us", "Explorer's Map"),
                Map.entry("en_gb", "Explorer's Map"),
                Map.entry("en_ca", "Explorer's Map"),
                Map.entry("en_au", "Explorer's Map"),
                Map.entry("en_pt", "Map o' the Explorer"), // Pirate Speak or keep English

                Map.entry("de_de", "Entdeckerkarte"),
                Map.entry("fr_fr", "Carte de l'explorateur"),
                Map.entry("fr_ca", "Carte de l'explorateur"),
                Map.entry("es_es", "Mapa del explorador"),
                Map.entry("es_mx", "Mapa del explorador"),
                Map.entry("pt_pt", "Mapa do Explorador"),
                Map.entry("pt_br", "Mapa do Explorador"),
                Map.entry("it_it", "Mappa dell'esploratore"),
                Map.entry("nl_nl", "Ontdekkerskaart"),
                Map.entry("ru_ru", "Карта исследователя"),
                Map.entry("uk_ua", "Карта дослідника"),
                Map.entry("pl_pl", "Mapa odkrywcy"),
                Map.entry("cs_cz", "Mapa průzkumníka"),
                Map.entry("sk_sk", "Mapa prieskumníka"),
                Map.entry("hu_hu", "Felfedező térkép"),
                Map.entry("sv_se", "Upptäckarkarta"),
                Map.entry("no_no", "Utforskerkart"),
                Map.entry("da_dk", "Opdagelseskort"),
                Map.entry("fi_fi", "Tutkijan kartta"),
                Map.entry("tr_tr", "Kaşif Haritası"),
                Map.entry("el_gr", "Χάρτης του εξερευνητή"),
                Map.entry("ro_ro", "Harta exploratorului"),
                Map.entry("bg_bg", "Карта на изследователя"),
                Map.entry("zh_cn", "探险者地图"),
                Map.entry("zh_tw", "探險者地圖"),
                Map.entry("ja_jp", "探検家の地図"),
                Map.entry("ko_kr", "탐험가 지도"),
                Map.entry("th_th", "แผนที่นักสำรวจ"),
                Map.entry("ar_sa", "خريطة المستكشف"),
                Map.entry("he_il", "מפת המגלה"),
                Map.entry("hi_in", "एक्सप्लोरर का नक्शा"),
                Map.entry("id_id", "Peta Penjelajah"),
                Map.entry("ms_my", "Peta Penjelajah")
        ));

        // Spelunker's Map translations
        translations.put(TooltipTranslations.tooltipPrefix + "undergound_poi", Map.ofEntries(
                Map.entry("en_us", "Spelunker's Map"),
                Map.entry("en_gb", "Spelunker's Map"),
                Map.entry("en_ca", "Spelunker's Map"),
                Map.entry("en_au", "Spelunker's Map"),
                Map.entry("en_pt", "Caverner’s Chart"), // whimsical / playful English variant

                Map.entry("de_de", "Höhlenforscherkarte"),
                Map.entry("fr_fr", "Carte du Spéléologue"),
                Map.entry("fr_ca", "Carte du Spéléologue"),
                Map.entry("es_es", "Mapa del Espeleólogo"),
                Map.entry("es_mx", "Mapa del Espeleólogo"),
                Map.entry("pt_pt", "Mapa do Espeleólogo"),
                Map.entry("pt_br", "Mapa do Espeleólogo"),
                Map.entry("it_it", "Mappa dello Speleologo"),
                Map.entry("nl_nl", "Kaart van de Grotonderzoeker"),
                Map.entry("ru_ru", "Карта спелеолога"),
                Map.entry("uk_ua", "Карта спелеолога"),
                Map.entry("pl_pl", "Mapa Poszukiwacza Jaskiń"),
                Map.entry("cs_cz", "Mapa Jeskynáře"),
                Map.entry("sk_sk", "Mapa Jeskynnára"),
                Map.entry("hu_hu", "Barlangász térkép"),
                Map.entry("sv_se", "Grottforskarkarta"),
                Map.entry("no_no", "Huleforskerkart"),
                Map.entry("da_dk", "Huleforskerkort"),
                Map.entry("fi_fi", "Luolatutkijan kartta"),
                Map.entry("tr_tr", "Mağara Kaşifleri Haritası"),
                Map.entry("el_gr", "Χάρτης Σπηλαιολόγου"),
                Map.entry("ro_ro", "Harta Speologului"),
                Map.entry("bg_bg", "Карта на спелеолога"),
                Map.entry("zh_cn", "探洞者地图"),
                Map.entry("zh_tw", "探洞者地圖"),
                Map.entry("ja_jp", "探検家の地図"),
                Map.entry("ko_kr", "동굴 탐험가 지도"),
                Map.entry("th_th", "แผนที่นักสำรวจถ้ำ"),
                Map.entry("ar_sa", "خريطة المستكشف الكهفي"),
                Map.entry("he_il", "מפת סיוע לחוקרי מערות"),
                Map.entry("hi_in", "घूमक्कड़ नक्शा"),
                Map.entry("id_id", "Peta Penjelajah Gua"),
                Map.entry("ms_my", "Peta Penyelidik Gua")
        ));

        // Scout's Map translations
        translations.put(TooltipTranslations.tooltipPrefix + "pillager_poi", Map.ofEntries(
                Map.entry("en_us", "Scout's Map"),
                Map.entry("en_gb", "Scout's Map"),
                Map.entry("en_ca", "Scout's Map"),
                Map.entry("en_au", "Scout's Map"),
                Map.entry("en_pt", "Plunderin' Chart"), // Pirate Speak

                Map.entry("de_de", "Späherkarte"),
                Map.entry("fr_fr", "Carte de l'éclaireur"),
                Map.entry("fr_ca", "Carte de l'éclaireur"),
                Map.entry("es_es", "Mapa del explorador"),
                Map.entry("es_mx", "Mapa del explorador"),
                Map.entry("pt_pt", "Mapa do Batedor"),
                Map.entry("pt_br", "Mapa do Batedor"),
                Map.entry("it_it", "Mappa dell'esploratore"),
                Map.entry("nl_nl", "Verkennerskaart"),
                Map.entry("ru_ru", "Карта разведчика"),
                Map.entry("uk_ua", "Карта розвідника"),
                Map.entry("pl_pl", "Mapa zwiadowcy"),
                Map.entry("cs_cz", "Mapa průzkumníka"),
                Map.entry("sk_sk", "Mapa prieskumníka"),
                Map.entry("hu_hu", "Felderítő térkép"),
                Map.entry("sv_se", "Spejarkarta"),
                Map.entry("no_no", "Speiderkart"),
                Map.entry("da_dk", "Spejderkort"),
                Map.entry("fi_fi", "Tiedustelukartta"),
                Map.entry("tr_tr", "Gözcü Haritası"),
                Map.entry("el_gr", "Χάρτης Ανιχνευτή"),
                Map.entry("ro_ro", "Harta cercetașului"),
                Map.entry("bg_bg", "Карта на разузнавача"),
                Map.entry("zh_cn", "斥候地图"),
                Map.entry("zh_tw", "斥候地圖"),
                Map.entry("ja_jp", "斥候の地図"),
                Map.entry("ko_kr", "정찰병의 지도"),
                Map.entry("th_th", "แผนที่ลูกเสือ"),
                Map.entry("ar_sa", "خريطة الكشاف"),
                Map.entry("he_il", "מפת הסייר"),
                Map.entry("hi_in", "टोही का नक्शा"),
                Map.entry("id_id", "Peta Pengintai"),
                Map.entry("ms_my", "Peta Peninjau")
        ));

        // Swamp POI translations
        translations.put(TooltipTranslations.tooltipPrefix + "swamp_poi", Map.ofEntries(
                Map.entry("en_us", "Witch Sighting"),
                Map.entry("en_gb", "Witch Sighting"),
                Map.entry("en_ca", "Witch Sighting"),
                Map.entry("en_au", "Witch Sighting"),
                Map.entry("en_pt", "A Hag Be Spotted!"), // Pirate Speak

                Map.entry("de_de", "Hexensichtung"),
                Map.entry("fr_fr", "Apparition de sorcière"),
                Map.entry("fr_ca", "Apparition de sorcière"),
                Map.entry("es_es", "Avistamiento de bruja"),
                Map.entry("es_mx", "Avistamiento de bruja"),
                Map.entry("pt_pt", "Avistamento de Bruxa"),
                Map.entry("pt_br", "Avistamento de Bruxa"),
                Map.entry("it_it", "Avvistamento di strega"),
                Map.entry("nl_nl", "Heks gespot"),
                Map.entry("ru_ru", "Замечена ведьма"),
                Map.entry("uk_ua", "Помічена відьма"),
                Map.entry("pl_pl", "Dostrzeżono wiedźmę"),
                Map.entry("cs_cz", "Pozorování čarodějnice"),
                Map.entry("sk_sk", "Pozorovanie čarodejnice"),
                Map.entry("hu_hu", "Boszorkány észlelése"),
                Map.entry("sv_se", "Häxsikt"),
                Map.entry("no_no", "Hektsyn"),
                Map.entry("da_dk", "Hekseobservation"),
                Map.entry("fi_fi", "Noidan havainto"),
                Map.entry("tr_tr", "Cadı Görüldü"),
                Map.entry("el_gr", "Θέα μάγισσας"),
                Map.entry("ro_ro", "Vedere de vrăjitoare"),
                Map.entry("bg_bg", "Забелязана вещица"),
                Map.entry("zh_cn", "女巫目击"),
                Map.entry("zh_tw", "女巫目擊"),
                Map.entry("ja_jp", "魔女の目撃情報"),
                Map.entry("ko_kr", "마녀 목격"),
                Map.entry("th_th", "พบแม่มด"),
                Map.entry("ar_sa", "رصد ساحرة"),
                Map.entry("he_il", "תצפית על מכשפה"),
                Map.entry("hi_in", "चुड़ैल देखी गई"),
                Map.entry("id_id", "Penampakan Penyihir"),
                Map.entry("ms_my", "Penampakan Ahli Sihir")
        ));

        // Nether Map translations
        translations.put(TooltipTranslations.tooltipPrefix + "nether_poi", Map.ofEntries(
                Map.entry("en_us", "Map o' the Abyss"),
                Map.entry("en_gb", "Map o' the Abyss"),
                Map.entry("en_ca", "Map o' the Abyss"),
                Map.entry("en_au", "Map o' the Abyss"),
                Map.entry("en_pt", "Map o' the Abyss"), // Pirate Speak or keep English

                Map.entry("de_de", "Netherkarte"),
                Map.entry("fr_fr", "Carte du Nether"),
                Map.entry("fr_ca", "Carte du Nether"),
                Map.entry("es_es", "Mapa del Nether"),
                Map.entry("es_mx", "Mapa del Nether"),
                Map.entry("pt_pt", "Mapa do Nether"),
                Map.entry("pt_br", "Mapa do Nether"),
                Map.entry("it_it", "Mappa del Nether"),
                Map.entry("nl_nl", "Netherkaart"),
                Map.entry("ru_ru", "Карта Незера"),
                Map.entry("uk_ua", "Карта Незеру"),
                Map.entry("pl_pl", "Mapa Netheru"),
                Map.entry("cs_cz", "Mapa Netheru"),
                Map.entry("sk_sk", "Mapa Netheru"),
                Map.entry("hu_hu", "Nether térkép"),
                Map.entry("sv_se", "Netherkarta"),
                Map.entry("no_no", "Netherkart"),
                Map.entry("da_dk", "Netherkort"),
                Map.entry("fi_fi", "Nether-kartta"),
                Map.entry("tr_tr", "Nether Haritası"),
                Map.entry("el_gr", "Χάρτης του Nether"),
                Map.entry("ro_ro", "Hartă Nether"),
                Map.entry("bg_bg", "Карта на Недъра"),
                Map.entry("zh_cn", "下界地图"),
                Map.entry("zh_tw", "地獄地圖"),
                Map.entry("ja_jp", "ネザーマップ"),
                Map.entry("ko_kr", "네더 지도"),
                Map.entry("th_th", "แผนที่เนเธอร์"),
                Map.entry("ar_sa", "خريطة النذر"),
                Map.entry("he_il", "מפת נתר"),
                Map.entry("hi_in", "नेदर का नक्शा"),
                Map.entry("id_id", "Peta Nether"),
                Map.entry("ms_my", "Peta Nether")
        ));

        // End POI translations
        translations.put(TooltipTranslations.tooltipPrefix + "end_poi", Map.ofEntries(
                Map.entry("en_us", "Endonian Map"),
                Map.entry("en_gb", "Endonian Map"),
                Map.entry("en_ca", "Endonian Map"),
                Map.entry("en_au", "Endonian Map"),
                Map.entry("en_pt", "Map o’ the End"), // Pirate Speak

                Map.entry("de_de", "Endonische Karte"),
                Map.entry("fr_fr", "Carte endonienne"),
                Map.entry("fr_ca", "Carte endonienne"),
                Map.entry("es_es", "Mapa endonio"),
                Map.entry("es_mx", "Mapa endonio"),
                Map.entry("pt_pt", "Mapa Endoniano"),
                Map.entry("pt_br", "Mapa Endoniano"),
                Map.entry("it_it", "Mappa endoniana"),
                Map.entry("nl_nl", "Endonische kaart"),
                Map.entry("ru_ru", "Эндонианская карта"),
                Map.entry("uk_ua", "Ендонійська мапа"),
                Map.entry("pl_pl", "Mapa endońska"),
                Map.entry("cs_cz", "Endonská mapa"),
                Map.entry("sk_sk", "Endonská mapa"),
                Map.entry("hu_hu", "Endoni térkép"),
                Map.entry("sv_se", "Endonisk karta"),
                Map.entry("no_no", "Endonisk kart"),
                Map.entry("da_dk", "Endonisk kort"),
                Map.entry("fi_fi", "Endonialainen kartta"),
                Map.entry("tr_tr", "Endonya Haritası"),
                Map.entry("el_gr", "Ενδονιανός Χάρτης"),
                Map.entry("ro_ro", "Hartă endoniană"),
                Map.entry("bg_bg", "Ендонска карта"),
                Map.entry("zh_cn", "终界安多尼亚地图"),
                Map.entry("zh_tw", "終界安多尼亞地圖"),
                Map.entry("ja_jp", "エンドニアン地図"),
                Map.entry("ko_kr", "엔도니안 지도"),
                Map.entry("th_th", "แผนที่เอนโดเนียน"),
                Map.entry("ar_sa", "خريطة إندونيان"),
                Map.entry("he_il", "מפת אנדוניה"),
                Map.entry("hi_in", "एंडोनियन नक्शा"),
                Map.entry("id_id", "Peta Endonian"),
                Map.entry("ms_my", "Peta Endonian")
        ));


        // Jungle POI translations
        translations.put(TooltipTranslations.tooltipPrefix + "jungle_poi", Map.ofEntries(
                Map.entry("en_us", "Jungle Map"),
                Map.entry("en_gb", "Jungle Map"),
                Map.entry("en_ca", "Jungle Map"),
                Map.entry("en_au", "Jungle Map"),
                Map.entry("en_pt", "Map o’ de Jungle"), // Pirate Speak twist

                Map.entry("de_de", "Dschungelkarte"),
                Map.entry("fr_fr", "Carte de la jungle"),
                Map.entry("fr_ca", "Carte de la jungle"),
                Map.entry("es_es", "Mapa de la jungla"),
                Map.entry("es_mx", "Mapa de la jungla"),
                Map.entry("pt_pt", "Mapa da Selva"),
                Map.entry("pt_br", "Mapa da Selva"),
                Map.entry("it_it", "Mappa della giungla"),
                Map.entry("nl_nl", "Junglekaart"),
                Map.entry("ru_ru", "Карта джунглей"),
                Map.entry("uk_ua", "Мапа джунглів"),
                Map.entry("pl_pl", "Mapa dżungli"),
                Map.entry("cs_cz", "Mapa džungle"),
                Map.entry("sk_sk", "Mapa džungle"),
                Map.entry("hu_hu", "Dzsungeltérkép"),
                Map.entry("sv_se", "Djungelkarta"),
                Map.entry("no_no", "Jungelkart"),
                Map.entry("da_dk", "Junglekort"),
                Map.entry("fi_fi", "Viidakkokartta"),
                Map.entry("tr_tr", "Orman Haritası"),
                Map.entry("el_gr", "Χάρτης Ζούγκλας"),
                Map.entry("ro_ro", "Hartă a junglei"),
                Map.entry("bg_bg", "Карта на джунглата"),
                Map.entry("zh_cn", "丛林地图"),
                Map.entry("zh_tw", "叢林地圖"),
                Map.entry("ja_jp", "ジャングルの地図"),
                Map.entry("ko_kr", "정글 지도"),
                Map.entry("th_th", "แผนที่ป่า"),
                Map.entry("ar_sa", "خريطة الأدغال"),
                Map.entry("he_il", "מפת ג'ונגל"),
                Map.entry("hi_in", "जंगल का नक्शा"),
                Map.entry("id_id", "Peta Hutan Rimba"),
                Map.entry("ms_my", "Peta Rimba")
        ));

        // Nautical Map translations
        translations.put("filled_map.ocean_poi", Map.ofEntries(
                Map.entry("en_us", "Nautical Map"),
                Map.entry("en_gb", "Nautical Map"),
                Map.entry("en_ca", "Nautical Map"),
                Map.entry("en_au", "Nautical Map"),
                Map.entry("en_pt", "Seafarer’s Chart"), // Pirate Speak or keep English

                Map.entry("de_de", "Nautische Karte"),
                Map.entry("fr_fr", "Carte nautique"),
                Map.entry("fr_ca", "Carte nautique"),
                Map.entry("es_es", "Mapa náutico"),
                Map.entry("es_mx", "Mapa náutico"),
                Map.entry("pt_pt", "Mapa Náutico"),
                Map.entry("pt_br", "Mapa Náutico"),
                Map.entry("it_it", "Carta nautica"),
                Map.entry("nl_nl", "Nautische kaart"),
                Map.entry("ru_ru", "Морская карта"),
                Map.entry("uk_ua", "Морська карта"),
                Map.entry("pl_pl", "Mapa morska"),
                Map.entry("cs_cz", "Námořní mapa"),
                Map.entry("sk_sk", "Námorná mapa"),
                Map.entry("hu_hu", "Nautikus térkép"),
                Map.entry("sv_se", "Nautisk karta"),
                Map.entry("no_no", "Nautisk kart"),
                Map.entry("da_dk", "Nautisk kort"),
                Map.entry("fi_fi", "Merikartta"),
                Map.entry("tr_tr", "Denizcilik Haritası"),
                Map.entry("el_gr", "Ναυτικός χάρτης"),
                Map.entry("ro_ro", "Hartă nautică"),
                Map.entry("bg_bg", "Морска карта"),
                Map.entry("zh_cn", "航海图"),
                Map.entry("zh_tw", "航海圖"),
                Map.entry("ja_jp", "航海図"),
                Map.entry("ko_kr", "항해 지도"),
                Map.entry("th_th", "แผนที่การเดินเรือ"),
                Map.entry("ar_sa", "خريطة بحرية"),
                Map.entry("he_il", "מפה ימית"),
                Map.entry("hi_in", "नौवहन मानचित्र"),
                Map.entry("id_id", "Peta Nautika"),
                Map.entry("ms_my", "Peta Nautika")
        ));

        // settlement map
        translations.put("filled_map.settlement", Map.ofEntries(
                Map.entry("en_us", "Settlement Map"),
                Map.entry("en_gb", "Settlement Map"),
                Map.entry("en_ca", "Settlement Map"),
                Map.entry("en_au", "Settlement Map"),
                Map.entry("en_pt", "Map o' the Settlement"), // Pirate Speak or keep English

                Map.entry("de_de", "Siedlungskarte"),
                Map.entry("fr_fr", "Carte de colonie"),
                Map.entry("fr_ca", "Carte de colonie"),
                Map.entry("es_es", "Mapa de asentamiento"),
                Map.entry("es_mx", "Mapa de asentamiento"),
                Map.entry("pt_pt", "Mapa do assentamento"),
                Map.entry("pt_br", "Mapa do assentamento"),
                Map.entry("it_it", "Mappa dell’insediamento"),
                Map.entry("nl_nl", "Nederzettingskaart"),
                Map.entry("ru_ru", "Карта поселения"),
                Map.entry("uk_ua", "Карта поселення"),
                Map.entry("pl_pl", "Mapa osady"),
                Map.entry("cs_cz", "Mapa osady"),
                Map.entry("sk_sk", "Mapa osady"),
                Map.entry("hu_hu", "Településtérkép"),
                Map.entry("sv_se", "Bosättningskarta"),
                Map.entry("no_no", "Bosettingskart"),
                Map.entry("da_dk", "Bosætningskort"),
                Map.entry("fi_fi", "Asutuskartta"),
                Map.entry("tr_tr", "Yerleşim Haritası"),
                Map.entry("el_gr", "Χάρτης οικισμού"),
                Map.entry("ro_ro", "Hartă a așezării"),
                Map.entry("bg_bg", "Карта на селище"),
                Map.entry("zh_cn", "定居点地图"),
                Map.entry("zh_tw", "定居點地圖"),
                Map.entry("ja_jp", "集落の地図"),
                Map.entry("ko_kr", "정착지 지도"),
                Map.entry("th_th", "แผนที่นิคม"),
                Map.entry("ar_sa", "خريطة المستوطنة"),
                Map.entry("he_il", "מפת יישוב"),
                Map.entry("hi_in", "बस्ती का नक्शा"),
                Map.entry("id_id", "Peta Pemukiman"),
                Map.entry("ms_my", "Peta Penempatan")
        ));

        return translations;
    }

    @Contract(pure = true)
    private static @NotNull Map<String, Map<String, String>> createTooltipTranslations() {
        Map<String, Map<String, String>> translations = new HashMap<>();

        // Generic tooltip for all maps
        translations.put("tooltipPerLocale", Map.ofEntries(
                Map.entry("en_us", "Reveals the location of something interesting..."),
                Map.entry("en_gb", "Reveals the location of something interesting..."),
                Map.entry("en_ca", "Reveals the location of something interesting..."),
                Map.entry("en_au", "Reveals the location of something interesting..."),
                Map.entry("en_pt", "Reveals the location of something interesting..."),

                Map.entry("de_de", "Zeigt den Standort von etwas Interessantem..."),
                Map.entry("fr_fr", "Révèle l'emplacement de quelque chose d'intéressant..."),
                Map.entry("fr_ca", "Révèle l'emplacement de quelque chose d'intéressant..."),
                Map.entry("es_es", "Revela la ubicación de algo interesante..."),
                Map.entry("es_mx", "Revela la ubicación de algo interesante..."),
                Map.entry("pt_pt", "Revela a localização de algo interessante..."),
                Map.entry("pt_br", "Revela a localização de algo interessante..."),
                Map.entry("it_it", "Rivela la posizione di qualcosa di interessante..."),
                Map.entry("nl_nl", "Toont de locatie van iets interessants..."),
                Map.entry("ru_ru", "Показывает местоположение чего-то интересного..."),
                Map.entry("uk_ua", "Показує місце розташування чогось цікавого..."),
                Map.entry("pl_pl", "Pokazuje lokalizację czegoś interesującego..."),
                Map.entry("cs_cz", "Zobrazuje polohu něčeho zajímavého..."),
                Map.entry("sk_sk", "Zobrazuje polohu niečoho zaujímavého..."),
                Map.entry("hu_hu", "Megmutatja valami érdekes helyét..."),
                Map.entry("sv_se", "Visar platsen för något intressant..."),
                Map.entry("no_no", "Viser plasseringen av noe interessant..."),
                Map.entry("da_dk", "Viser placeringen af noget interessant..."),
                Map.entry("fi_fi", "Näyttää mielenkiintoisen kohteen sijainnin..."),
                Map.entry("tr_tr", "İlginç bir şeyin konumunu gösterir..."),
                Map.entry("el_gr", "Αποκαλύπτει τη θέση κάτι ενδιαφέροντος..."),
                Map.entry("ro_ro", "Dezvăluie locația unui lucru interesant..."),
                Map.entry("bg_bg", "Показва местоположението на нещо интересно..."),
                Map.entry("zh_cn", "显示某些有趣事物的位置..."),
                Map.entry("zh_tw", "顯示某些有趣事物的位置..."),
                Map.entry("ja_jp", "何か面白い場所を示します..."),
                Map.entry("ko_kr", "흥미로운 위치를 보여줍니다..."),
                Map.entry("th_th", "เผยตำแหน่งของสิ่งที่น่าสนใจ..."),
                Map.entry("ar_sa", "يكشف موقع شيء مثير للاهتمام..."),
                Map.entry("he_il", "מראה את מיקומו של משהו מעניין..."),
                Map.entry("hi_in", "कुछ दिलचस्प की स्थिति को दिखाता है..."),
                Map.entry("id_id", "Menunjukkan lokasi sesuatu yang menarik..."),
                Map.entry("ms_my", "Menunjukkan lokasi sesuatu yang menarik...")
        ));

        return translations;
    }
}