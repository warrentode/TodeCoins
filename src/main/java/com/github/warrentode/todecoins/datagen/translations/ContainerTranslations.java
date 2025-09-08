package com.github.warrentode.todecoins.datagen.translations;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class ContainerTranslations {
    // Map of item IDs → (language code → translated name)
    public static final Map<String, Map<String, String>> LANG_MAPS = createTranslations();

    @Contract(pure = true)
    private static @NotNull Map<String, Map<String, String>> createTranslations() {
        Map<String, Map<String, String>> translations = new HashMap<>();

// Collectible coin album container title translations
        translations.put("container.todecoins.coin_album.page", Map.ofEntries(
                Map.entry("en_us", "Page"),
                Map.entry("en_gb", "Page"),
                Map.entry("en_ca", "Page"),
                Map.entry("en_au", "Page"),
                Map.entry("en_pt", "Page"), // Pirate Speak

                Map.entry("de_de", "Seite"),
                Map.entry("fr_fr", "Page"),
                Map.entry("fr_ca", "Page"),
                Map.entry("es_es", "Página"),
                Map.entry("es_mx", "Página"),
                Map.entry("pt_pt", "Página"),
                Map.entry("pt_br", "Página"),
                Map.entry("it_it", "Pagina"),
                Map.entry("nl_nl", "Pagina"),
                Map.entry("ru_ru", "Страница"),
                Map.entry("uk_ua", "Сторінка"),
                Map.entry("zh_cn", "页"),
                Map.entry("zh_tw", "頁"),
                Map.entry("ja_jp", "ページ"),
                Map.entry("ko_kr", "페이지"),
                Map.entry("pl_pl", "Strona"),
                Map.entry("sv_se", "Sida"),
                Map.entry("no_no", "Side"),
                Map.entry("da_dk", "Side"),
                Map.entry("fi_fi", "Sivu"),
                Map.entry("tr_tr", "Sayfa"),
                Map.entry("cs_cz", "Stránka"),
                Map.entry("sk_sk", "Strana"),
                Map.entry("hu_hu", "Oldal"),
                Map.entry("el_gr", "Σελίδα"),
                Map.entry("ro_ro", "Pagină"),
                Map.entry("bg_bg", "Страница"),
                Map.entry("vi_vn", "Trang"),
                Map.entry("id_id", "Halaman"),
                Map.entry("hi_in", "पृष्ठ"),
                Map.entry("he_il", "דף"),
                Map.entry("ar_sa", "صفحة"),
                Map.entry("ms_my", "Halaman"),
                Map.entry("ca_es", "Pàgina"),
                Map.entry("gl_es", "Páxina"),
                Map.entry("eo_ee", "Paĝo"),
                Map.entry("la_la", "Pagina"),
                Map.entry("th_th", "หน้า")
        ));

// Collectible coin album container title translations
        translations.put("container.todecoins.coin_album", Map.ofEntries(
                Map.entry("en_us", "Collectible Coin Album"),
                Map.entry("en_gb", "Collectible Coin Album"),
                Map.entry("en_ca", "Collectible Coin Album"),
                Map.entry("en_au", "Collectible Coin Album"),
                Map.entry("en_pt", "Album o' Badges"), // Pirate Speak

                Map.entry("de_de", "Sammel-Münzalbum"),
                Map.entry("fr_fr", "Album de Pièces de Collection"),
                Map.entry("fr_ca", "Album de Pièces de Collection"),
                Map.entry("es_es", "Álbum de Monedas Coleccionables"),
                Map.entry("es_mx", "Álbum de Monedas Coleccionables"),
                Map.entry("pt_pt", "Álbum de Moedas Colecionáveis"),
                Map.entry("pt_br", "Álbum de Moedas Colecionáveis"),
                Map.entry("it_it", "Album di Monete da Collezione"),
                Map.entry("nl_nl", "Verzamelmunten Album"),
                Map.entry("ru_ru", "Альбом Коллекционных Монет"),
                Map.entry("uk_ua", "Альбом Колекційних Монет"),
                Map.entry("zh_cn", "收藏硬币册"),
                Map.entry("zh_tw", "收藏硬幣冊"),
                Map.entry("ja_jp", "コレクションコインアルバム"),
                Map.entry("ko_kr", "수집용 코인 앨범"),
                Map.entry("pl_pl", "Album Kolekcjonerskich Monet"),
                Map.entry("sv_se", "Samlarmyntalbum"),
                Map.entry("no_no", "Samlemyntalbum"),
                Map.entry("da_dk", "Samlemøntalbum"),
                Map.entry("fi_fi", "Keräilykolikoiden Albumi"),
                Map.entry("tr_tr", "Koleksiyon Para Albümü"),
                Map.entry("cs_cz", "Album Sběratelských Mince"),
                Map.entry("sk_sk", "Album Zberateľských Mince"),
                Map.entry("hu_hu", "Gyűjthető Érmealbum"),
                Map.entry("el_gr", "Άλμπουμ Συλλεκτικών Νομισμάτων"),
                Map.entry("ro_ro", "Album de Monede Colecționabile"),
                Map.entry("bg_bg", "Албум за Колекционерски Монети"),
                Map.entry("vi_vn", "Album Đồng Tiền Sưu Tầm"),
                Map.entry("id_id", "Album Koin Koleksi"),
                Map.entry("hi_in", "संग्रहणीय सिक्का एल्बम"),
                Map.entry("he_il", "אלבום מטבעות לאסוף"),
                Map.entry("ar_sa", "ألبوم العملات القابلة للجمع"),
                Map.entry("ms_my", "Album Syiling Koleksi"),
                Map.entry("ca_es", "Àlbum de Monedes de Col·lecció"),
                Map.entry("gl_es", "Álbum de Moedas de Colección"),
                Map.entry("eo_ee", "Album de Kolekteblaj Moneroj"),
                Map.entry("la_la", "Album Monetarum Collectabilium"),
                Map.entry("th_th", "อัลบั้มเหรียญสะสม")
        ));

// Tip jar container contents translations
        translations.put("container.todecoins.tip_jar.contents", Map.ofEntries(
                Map.entry("en_us", "Tip Jar Contents"),
                Map.entry("en_gb", "Tip Jar Contents"),
                Map.entry("en_ca", "Tip Jar Contents"),
                Map.entry("en_au", "Tip Jar Contents"),
                Map.entry("en_pt", "Jar o' Tips Contents"), // Pirate Speak

                Map.entry("de_de", "Inhalt des Trinkgeldglases"),
                Map.entry("fr_fr", "Contenu du bocal à pourboires"),
                Map.entry("fr_ca", "Contenu du bocal à pourboires"),
                Map.entry("es_es", "Contenido del frasco de propinas"),
                Map.entry("es_mx", "Contenido del frasco de propinas"),
                Map.entry("it_it", "Contenuto del barattolo delle mance"),
                Map.entry("pt_br", "Conteúdo do Pote de Gorjetas"),
                Map.entry("pt_pt", "Conteúdo do Frasco de Gorjetas"),
                Map.entry("ru_ru", "Содержимое банки с чаевыми"),
                Map.entry("uk_ua", "Вміст банки для чайових"),
                Map.entry("zh_cn", "小费罐内容"),
                Map.entry("zh_tw", "小費罐內容"),
                Map.entry("ja_jp", "チップ瓶の中身"),
                Map.entry("ko_kr", "팁 항아리 내용물"),
                Map.entry("nl_nl", "Inhoud van de foedraalpot"),
                Map.entry("pl_pl", "Zawartość słoika na napiwki"),
                Map.entry("sv_se", "Innehåll i tipsskrin"),
                Map.entry("no_no", "Innhold i tipskrukke"),
                Map.entry("da_dk", "Indhold i drikkepengekrukke"),
                Map.entry("fi_fi", "Tipsipurkin sisältö"),
                Map.entry("tr_tr", "Bahşiş Kavanozu İçeriği"),
                Map.entry("cs_cz", "Obsah pokladničky"),
                Map.entry("sk_sk", "Obsah pokladničky"),
                Map.entry("hu_hu", "Borravaló üveg tartalma"),
                Map.entry("bg_bg", "Съдържание на буркана за бакшиши"),
                Map.entry("el_gr", "Περιεχόμενα βάζου φιλοδωρήματος"),
                Map.entry("ro_ro", "Conținutul borcanului de bacșiș"),
                Map.entry("vi_vn", "Nội dung hũ tiền tip"),
                Map.entry("id_id", "Isi Stoples Tip"),
                Map.entry("hi_in", "टिप जार की सामग्री"),
                Map.entry("he_il", "תכולת צנצנת הטיפים"),
                Map.entry("ar_sa", "محتويات وعاء البقشيش"),
                Map.entry("ms_my", "Kandungan Balang Tip"),
                Map.entry("ca_es", "Contingut del pot de propines"),
                Map.entry("gl_es", "Contido do pote de propinas"),
                Map.entry("eo_ee", "Enhavo de tipujo"),
                Map.entry("la_la", "Contenta Dolii Praemiorum"),
                Map.entry("th_th", "เนื้อหาโถทิป")
        ));

// Wallet container translations
        translations.put("container.todecoins.wallet", Map.ofEntries(
                Map.entry("en_us", "Wallet"),
                Map.entry("en_gb", "Wallet"),
                Map.entry("en_ca", "Wallet"),
                Map.entry("en_au", "Wallet"),
                Map.entry("en_pt", "Wallet, Arr!"), // Pirate Speak

                Map.entry("de_de", "Brieftasche"),
                Map.entry("fr_fr", "Portefeuille"),
                Map.entry("fr_ca", "Portefeuille"),
                Map.entry("es_es", "Cartera"),
                Map.entry("es_mx", "Cartera"),
                Map.entry("pt_pt", "Carteira"),
                Map.entry("pt_br", "Carteira"),
                Map.entry("it_it", "Portafoglio"),
                Map.entry("nl_nl", "Portemonnee"),
                Map.entry("ru_ru", "Кошелек"),
                Map.entry("uk_ua", "Гаманець"),
                Map.entry("pl_pl", "Portfel"),
                Map.entry("cs_cz", "Peněženka"),
                Map.entry("sk_sk", "Peňaženka"),
                Map.entry("hu_hu", "Pénztárca"),
                Map.entry("sv_se", "Plånbok"),
                Map.entry("no_no", "Lommebok"),
                Map.entry("da_dk", "Pung"),
                Map.entry("fi_fi", "Lompakko"),
                Map.entry("tr_tr", "Cüzdan"),
                Map.entry("el_gr", "Πορτοφόλι"),
                Map.entry("ro_ro", "Portofel"),
                Map.entry("bg_bg", "Портфейл"),
                Map.entry("zh_cn", "钱包"),
                Map.entry("zh_tw", "錢包"),
                Map.entry("ja_jp", "財布"),
                Map.entry("ko_kr", "지갑"),
                Map.entry("th_th", "กระเป๋าเงิน"),
                Map.entry("ar_sa", "محفظة"),
                Map.entry("he_il", "ארנק"),
                Map.entry("hi_in", "बटुआ"),
                Map.entry("id_id", "Dompet"),
                Map.entry("ms_my", "Dompet")
        ));

// Coin Press GUI translations
        translations.put("container.coin_press_block_gui", Map.ofEntries(
                Map.entry("en_us", "Coin Press"),
                Map.entry("en_gb", "Coin Press"),
                Map.entry("en_ca", "Coin Press"),
                Map.entry("en_au", "Coin Press"),
                Map.entry("en_pt", "Coin Press, Arr!"), // Pirate Speak

                Map.entry("de_de", "Münzprägeautomat"),
                Map.entry("fr_fr", "Presse à pièces"),
                Map.entry("fr_ca", "Presse à pièces"),
                Map.entry("es_es", "Prensa de monedas"),
                Map.entry("es_mx", "Prensa de monedas"),
                Map.entry("pt_pt", "Prensa de Moedas"),
                Map.entry("pt_br", "Prensa de Moedas"),
                Map.entry("it_it", "Pressa per monete"),
                Map.entry("nl_nl", "Muntpers"),
                Map.entry("ru_ru", "Монетный пресс"),
                Map.entry("uk_ua", "Монетний прес"),
                Map.entry("pl_pl", "Prasa do monet"),
                Map.entry("cs_cz", "Lis na mince"),
                Map.entry("sk_sk", "Lis na mince"),
                Map.entry("hu_hu", "Érmeprés"),
                Map.entry("sv_se", "Myntpress"),
                Map.entry("no_no", "Myntepresser"),
                Map.entry("da_dk", "Møntpresse"),
                Map.entry("fi_fi", "Kolikkoprässi"),
                Map.entry("tr_tr", "Para Presi"),
                Map.entry("el_gr", "Πρέσα Νομισμάτων"),
                Map.entry("ro_ro", "Presă de monede"),
                Map.entry("bg_bg", "Преса за монети"),
                Map.entry("zh_cn", "铸币机"),
                Map.entry("zh_tw", "鑄幣機"),
                Map.entry("ja_jp", "コインプレス"),
                Map.entry("ko_kr", "동전 프레스기"),
                Map.entry("th_th", "เครื่องกดเหรียญ"),
                Map.entry("ar_sa", "آلة سك العملات"),
                Map.entry("he_il", "מכבש מטבעות"),
                Map.entry("hi_in", "सिक्का प्रेस"),
                Map.entry("id_id", "Mesin Cetak Koin"),
                Map.entry("ms_my", "Mesin Cetak Syiling")
        ));

// Coin Press Recipes translations
        translations.put("container.recipe_book.coin_press", Map.ofEntries(
                Map.entry("en_us", "Coin Press Recipes"),
                Map.entry("en_gb", "Coin Press Recipes"),
                Map.entry("en_ca", "Coin Press Recipes"),
                Map.entry("en_au", "Coin Press Recipes"),
                Map.entry("en_pt", "Coin Press Recipes, Arr!"), // Pirate Speak

                Map.entry("de_de", "Münzpressenrezepte"),
                Map.entry("fr_fr", "Recettes de presse à pièces"),
                Map.entry("fr_ca", "Recettes de presse à pièces"),
                Map.entry("es_es", "Recetas de prensa de monedas"),
                Map.entry("es_mx", "Recetas de prensa de monedas"),
                Map.entry("pt_pt", "Receitas da Prensa de Moedas"),
                Map.entry("pt_br", "Receitas da Prensa de Moedas"),
                Map.entry("it_it", "Ricette della pressa per monete"),
                Map.entry("nl_nl", "Muntpersrecepten"),
                Map.entry("ru_ru", "Рецепты монетного пресса"),
                Map.entry("uk_ua", "Рецепти монетного преса"),
                Map.entry("pl_pl", "Przepisy do prasy do monet"),
                Map.entry("cs_cz", "Recepty lisování mincí"),
                Map.entry("sk_sk", "Recepty lisovania mincí"),
                Map.entry("hu_hu", "Érmeprés receptek"),
                Map.entry("sv_se", "Myntpressrecept"),
                Map.entry("no_no", "Myntepressoppskrifter"),
                Map.entry("da_dk", "Møntpresserecept"),
                Map.entry("fi_fi", "Kolikkoprässin reseptit"),
                Map.entry("tr_tr", "Para Presi Tarifleri"),
                Map.entry("el_gr", "Συνταγές Πρέσας Νομισμάτων"),
                Map.entry("ro_ro", "Rețete pentru presa de monede"),
                Map.entry("bg_bg", "Рецепти за монетен прес"),
                Map.entry("zh_cn", "铸币机配方"),
                Map.entry("zh_tw", "鑄幣機配方"),
                Map.entry("ja_jp", "コインプレスのレシピ"),
                Map.entry("ko_kr", "동전 프레스 조합법"),
                Map.entry("th_th", "สูตรเครื่องกดเหรียญ"),
                Map.entry("ar_sa", "وصفات آلة سك العملات"),
                Map.entry("he_il", "מתכוני מכבש מטבעות"),
                Map.entry("hi_in", "सिक्का प्रेस रेसिपी"),
                Map.entry("id_id", "Resep Mesin Cetak Koin"),
                Map.entry("ms_my", "Resipi Mesin Cetak Syiling")
        ));

        return translations;
    }

}