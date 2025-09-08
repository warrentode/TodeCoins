package com.github.warrentode.todecoins.datagen.translations.effects;

import java.util.HashMap;
import java.util.Map;

public class EffectPrefixTranslations {

        // Keys for all potion/arrow prefix types
        private static final String[] prefixKeys = {
                "potion",
                "potion_extended",
                "splash_potion",
                "splash_potion_extended",
                "lingering_potion",
                "lingering_potion_extended",
                "arrow",
                "arrow_extended"
        };

        /**
         * Returns a map of all locale → prefix translations for potions and arrows.
         */
        public static Map<String, Map<String, Map<String, String>>> createPrefixMap() {
                Map<String, Map<String, Map<String, String>>> translations = new HashMap<>();
                Map<String, Map<String, String>> prefixTranslations = new HashMap<>();

                // ---- English variants ----
                String[] english = {
                        "Potion of",
                        "Potion of Extended",
                        "Splash Potion of",
                        "Splash Potion of Extended",
                        "Lingering Potion of",
                        "Lingering Potion of Extended",
                        "Arrow of",
                        "Arrow of Extended"
                };
                String[] englishLocales = { "en_us", "en_gb", "en_ca", "en_au" };
                for (String locale : englishLocales) {
                        prefixTranslations.put(locale, arrayToMap(english));
                }

                // ---- Pirate Speak ----
                String[] pirate = {
                        "Brew o’",
                        "Brew o’ Extended",
                        "Splash Brew o’",
                        "Splash Brew o’ Extended",
                        "Lingering Brew o’",
                        "Lingering Brew o’ Extended",
                        "Arrow o’",
                        "Arrow o’ Extended"
                };
                prefixTranslations.put("en_pt", arrayToMap(pirate));

                // ---- Arabic ----
                String[] arabic = {
                        "جرعة",
                        "جرعة موسعة",
                        "جرعة متفجرة من",
                        "جرعة متفجرة موسعة من",
                        "جرعة باقية من",
                        "جرعة باقية موسعة من",
                        "سهم من",
                        "سهم موسع من"
                };
                prefixTranslations.put("ar_sa", arrayToMap(arabic));

                // ---- German ----
                String[] german = {
                        "Trank von",
                        "Erweiterter Trank von",
                        "Spritzen-Trank von",
                        "Erweiterter Spritzen-Trank von",
                        "Anhaltender Trank von",
                        "Erweiterter anhaltender Trank von",
                        "Pfeil von",
                        "Erweiterter Pfeil von"
                };
                prefixTranslations.put("de_de", arrayToMap(german));

                // ---- French ----
                String[] french = {
                        "Potion de",
                        "Potion prolongée de",
                        "Potion éclaboussante de",
                        "Potion éclaboussante prolongée de",
                        "Potion persistante de",
                        "Potion persistante prolongée de",
                        "Flèche de",
                        "Flèche prolongée de"
                };
                prefixTranslations.put("fr_fr", arrayToMap(french));
                prefixTranslations.put("fr_ca", arrayToMap(french));

                // ---- Spanish ----
                String[] spanish = {
                        "Poción de",
                        "Poción extendida de",
                        "Poción explosiva de",
                        "Poción explosiva extendida de",
                        "Poción persistente de",
                        "Poción persistente extendida de",
                        "Flecha de",
                        "Flecha extendida de"
                };
                prefixTranslations.put("es_es", arrayToMap(spanish));
                prefixTranslations.put("es_mx", arrayToMap(spanish));

                // ---- Portuguese ----
                String[] portuguese = {
                        "Poção de",
                        "Poção estendida de",
                        "Poção explosiva de",
                        "Poção explosiva estendida de",
                        "Poção persistente de",
                        "Poção persistente estendida de",
                        "Flecha de",
                        "Flecha estendida de"
                };
                prefixTranslations.put("pt_pt", arrayToMap(portuguese));
                prefixTranslations.put("pt_br", arrayToMap(portuguese));

                // ---- Italian ----
                String[] italian = {
                        "Pozione di",
                        "Pozione estesa di",
                        "Pozione esplosiva di",
                        "Pozione esplosiva estesa di",
                        "Pozione persistente di",
                        "Pozione persistente estesa di",
                        "Freccia di",
                        "Freccia estesa di"
                };
                prefixTranslations.put("it_it", arrayToMap(italian));

                // ---- Dutch ----
                String[] dutch = {
                        "Drank van",
                        "Uitgebreide drank van",
                        "Spatdrank van",
                        "Uitgebreide spatdrank van",
                        "Langdurige drank van",
                        "Uitgebreide langdurige drank van",
                        "Pijl van",
                        "Uitgebreide pijl van"
                };
                prefixTranslations.put("nl_nl", arrayToMap(dutch));

                // ---- Russian / Ukrainian ----
                String[] russian = {
                        "Зелье",
                        "Расширенное зелье",
                        "Брызговое зелье",
                        "Расширенное брызговое зелье",
                        "Длительное зелье",
                        "Расширенное длительное зелье",
                        "Стрела",
                        "Расширенная стрела"
                };
                prefixTranslations.put("ru_ru", arrayToMap(russian));
                prefixTranslations.put("uk_ua", arrayToMap(russian));

                // ---- Polish ----
                String[] polish = {
                        "Mikstura",
                        "Mikstura rozszerzona",
                        "Mikstura wybuchowa",
                        "Mikstura wybuchowa rozszerzona",
                        "Mikstura utrzymująca się",
                        "Mikstura utrzymująca się rozszerzona",
                        "Strzała",
                        "Strzała rozszerzona"
                };
                prefixTranslations.put("pl_pl", arrayToMap(polish));

                // ---- Czech / Slovak ----
                String[] czech = {
                        "Lektvar",
                        "Rozšířený lektvar",
                        "Stříkající lektvar",
                        "Rozšířený stříkající lektvar",
                        "Trvající lektvar",
                        "Rozšířený trvající lektvar",
                        "Šíp",
                        "Rozšířený šíp"
                };
                prefixTranslations.put("cs_cz", arrayToMap(czech));
                prefixTranslations.put("sk_sk", arrayToMap(czech));

                // ---- Hungarian ----
                String[] hungarian = {
                        "Főzet",
                        "Kiterjesztett főzet",
                        "Fröccsenő főzet",
                        "Kiterjesztett fröccsenő főzet",
                        "Maradandó főzet",
                        "Kiterjesztett maradandó főzet",
                        "Nyíl",
                        "Kiterjesztett nyíl"
                };
                prefixTranslations.put("hu_hu", arrayToMap(hungarian));

                // ---- Scandinavian ----
                String[] scandinavian = {
                        "Dryck av",
                        "Utökad dryck av",
                        "Stänkdryck av",
                        "Utökad stänkdryck av",
                        "Bestående dryck av",
                        "Utökad bestående dryck av",
                        "Pil av",
                        "Utökad pil av"
                };
                prefixTranslations.put("sv_se", arrayToMap(scandinavian));
                prefixTranslations.put("no_no", arrayToMap(scandinavian));
                prefixTranslations.put("da_dk", arrayToMap(scandinavian));
                prefixTranslations.put("fi_fi", arrayToMap(scandinavian));

                // ---- Turkish ----
                String[] turkish = {
                        "İksir",
                        "Genişletilmiş İksir",
                        "Patlayan İksir",
                        "Genişletilmiş Patlayan İksir",
                        "Kalıcı İksir",
                        "Genişletilmiş Kalıcı İksir",
                        "Ok",
                        "Genişletilmiş Ok"
                };
                prefixTranslations.put("tr_tr", arrayToMap(turkish));

                // ---- Greek ----
                String[] greek = {
                        "Φίλτρο",
                        "Επεκταμένο φίλτρο",
                        "Αναδυόμενο φίλτρο",
                        "Επεκταμένο αναδυόμενο φίλτρο",
                        "Διαρκές φίλτρο",
                        "Επεκταμένο διαρκές φίλτρο",
                        "Βέλος",
                        "Επεκταμένο βέλος"
                };
                prefixTranslations.put("el_gr", arrayToMap(greek));

                // ---- Romanian ----
                String[] romanian = {
                        "Poțiune",
                        "Poțiune extinsă",
                        "Poțiune explozivă",
                        "Poțiune explozivă extinsă",
                        "Poțiune persistentă",
                        "Poțiune persistentă extinsă",
                        "Săgeată",
                        "Săgeată extinsă"
                };
                prefixTranslations.put("ro_ro", arrayToMap(romanian));

                // ---- Bulgarian ----
                String[] bulgarian = {
                        "Отвара",
                        "Разширена отвара",
                        "Избухваща отвара",
                        "Разширена избухваща отвара",
                        "Устойчива отвара",
                        "Разширена устойчива отвара",
                        "Стрела",
                        "Разширена стрела"
                };
                prefixTranslations.put("bg_bg", arrayToMap(bulgarian));

                // ---- Simplified / Traditional Chinese ----
                String[] chinese = {
                        "药水",
                        "加强药水",
                        "飞溅药水",
                        "加强飞溅药水",
                        "残留药水",
                        "加强残留药水",
                        "箭",
                        "加强箭"
                };
                prefixTranslations.put("zh_cn", arrayToMap(chinese));
                prefixTranslations.put("zh_tw", arrayToMap(chinese));

                // ---- Japanese ----
                String[] japanese = {
                        "ポーション",
                        "強化ポーション",
                        "飛び散るポーション",
                        "強化飛び散るポーション",
                        "持続ポーション",
                        "強化持続ポーション",
                        "矢",
                        "強化矢"
                };
                prefixTranslations.put("ja_jp", arrayToMap(japanese));

                // ---- Korean ----
                String[] korean = {
                        "물약",
                        "강화 물약",
                        "튀는 물약",
                        "강화 튀는 물약",
                        "지속 물약",
                        "강화 지속 물약",
                        "화살",
                        "강화 화살"
                };
                prefixTranslations.put("ko_kr", arrayToMap(korean));

                // ---- Thai ----
                String[] thai = {
                        "ยาพิษ",
                        "ยาพิษขยาย",
                        "ยาพิษสาด",
                        "ยาพิษสาดขยาย",
                        "ยาพิษคงอยู่",
                        "ยาพิษคงอยู่ขยาย",
                        "ลูกศร",
                        "ลูกศรขยาย"
                };
                prefixTranslations.put("th_th", arrayToMap(thai));

                // ---- Hebrew ----
                String[] hebrew = {
                        "שיקוי",
                        "שיקוי מורחב",
                        "שיקוי מתיז",
                        "שיקוי מתיז מורחב",
                        "שיקוי מתמשך",
                        "שיקוי מתמשך מורחב",
                        "חץ",
                        "חץ מורחב"
                };
                prefixTranslations.put("he_il", arrayToMap(hebrew));

                // ---- Hindi ----
                String[] hindi = {
                        "औषधि",
                        "विस्तारित औषधि",
                        "फव्वारा औषधि",
                        "विस्तारित फव्वारा औषधि",
                        "स्थायी औषधि",
                        "विस्तारित स्थायी औषधि",
                        "तीर",
                        "विस्तारित तीर"
                };
                prefixTranslations.put("hi_in", arrayToMap(hindi));

                // ---- Indonesian / Malay ----
                String[] indo = {
                        "Ramuan",
                        "Ramuan Diperluas",
                        "Ramuan Pecah",
                        "Ramuan Pecah Diperluas",
                        "Ramuan Tertinggal",
                        "Ramuan Tertinggal Diperluas",
                        "Panah",
                        "Panah Diperluas"
                };
                prefixTranslations.put("id_id", arrayToMap(indo));
                prefixTranslations.put("ms_my", arrayToMap(indo));

                translations.put("prefixes", prefixTranslations);
                return translations;
        }

        /**
         * Helper to convert string array to key → value map
         */
        private static Map<String, String> arrayToMap(String[] arr) {
                Map<String, String> map = new HashMap<>();
                for (int i = 0; i < prefixKeys.length; i++) map.put(prefixKeys[i], arr[i]);
                return map;
        }
}