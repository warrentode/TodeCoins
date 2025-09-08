package com.github.warrentode.todecoins.datagen.translations.tooltips;

import com.github.warrentode.todecoins.datagen.translations.TooltipTranslations;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class WaresTooltipTranslations {
    // Map of item IDs → (language code → translated name)
    public static final Map<String, Map<String, String>> LANG_MAPS = createTooltipTranslations();

    @Contract(pure = true)
    private static @NotNull Map<String, Map<String, String>> createTooltipTranslations() {
        Map<String, Map<String, String>> translations = new HashMap<>();

        // Backside Message translations
        translations.put(TooltipTranslations.tooltipPrefix + "backside_message", Map.ofEntries(
                Map.entry("en_us", "Deliveries Sent All Over Minecraft On Demand!"),
                Map.entry("en_gb", "Deliveries Sent All Over Minecraft On Demand!"),
                Map.entry("en_ca", "Deliveries Sent All Over Minecraft On Demand!"),
                Map.entry("en_au", "Deliveries Sent All Over Minecraft On Demand!"),
                Map.entry("en_pt", "Parcels Shipped 'Cross Minecraft On Command!"), // Pirate Speak or keep English

                Map.entry("de_de", "Lieferungen in ganz Minecraft auf Abruf!"),
                Map.entry("fr_fr", "Livraisons partout dans Minecraft à la demande!"),
                Map.entry("fr_ca", "Livraisons partout dans Minecraft à la demande!"),
                Map.entry("es_es", "¡Entregas por todo Minecraft bajo demanda!"),
                Map.entry("es_mx", "¡Entregas por todo Minecraft bajo demanda!"),
                Map.entry("pt_pt", "Entregas por todo o Minecraft a pedido!"),
                Map.entry("pt_br", "Entregas por todo o Minecraft sob demanda!"),
                Map.entry("it_it", "Consegne in tutto Minecraft su richiesta!"),
                Map.entry("nl_nl", "Leveringen door heel Minecraft op aanvraag!"),
                Map.entry("ru_ru", "Доставки по всему Minecraft по требованию!"),
                Map.entry("uk_ua", "Доставки по всьому Minecraft на вимогу!"),
                Map.entry("pl_pl", "Dostawy w całym Minecraft na żądanie!"),
                Map.entry("cs_cz", "Doručení po celém Minecraftu na vyžádání!"),
                Map.entry("sk_sk", "Doručenie po celom Minecrafte na požiadanie!"),
                Map.entry("hu_hu", "Kézbesítések egész Minecraftban igény szerint!"),
                Map.entry("sv_se", "Leveranser över hela Minecraft på begäran!"),
                Map.entry("no_no", "Leveranser over hele Minecraft på forespørsel!"),
                Map.entry("da_dk", "Leverancer over hele Minecraft på anmodning!"),
                Map.entry("fi_fi", "Toimitukset ympäri Minecraftin pyynnöstä!"),
                Map.entry("tr_tr", "Minecraft'ta Her Yere İstek Üzerine Teslimat!"),
                Map.entry("el_gr", "Παραδόσεις σε όλο το Minecraft κατ' απαίτηση!"),
                Map.entry("ro_ro", "Livrări în tot Minecraft la cerere!"),
                Map.entry("bg_bg", "Доставки в целия Minecraft при поискване!"),
                Map.entry("zh_cn", "Minecraft 全境按需送货！"),
                Map.entry("zh_tw", "Minecraft 全境按需送貨！"),
                Map.entry("ja_jp", "Minecraft全域へのオンデマンド配送！"),
                Map.entry("ko_kr", "마인크래프트 전역 주문형 배송!"),
                Map.entry("th_th", "การจัดส่งทั่ว Minecraft ตามคำสั่ง!"),
                Map.entry("ar_sa", "تسليمات في جميع أنحاء ماينكرافت عند الطلب!"),
                Map.entry("he_il", "משלוחים בכל רחבי מיינקראפט לפי דרישה!"),
                Map.entry("hi_in", "Minecraft में हर जगह डिलीवरी, जब भी चाहें!"),
                Map.entry("id_id", "Pengiriman ke seluruh Minecraft Sesuai Permintaan!"),
                Map.entry("ms_my", "Penghantaran ke seluruh Minecraft Atas Permintaan!")
        ));

// Buyer Name translations
        translations.put(TooltipTranslations.tooltipPrefix + "buyer_name", Map.ofEntries(
                Map.entry("en_us", "Packager"),
                Map.entry("en_gb", "Packager"),
                Map.entry("en_ca", "Packager"),
                Map.entry("en_au", "Packager"),
                Map.entry("en_pt", "Box-Packer"), // Pirate Speak or keep English

                Map.entry("de_de", "Verpacker"),
                Map.entry("fr_fr", "Emballeur"),
                Map.entry("fr_ca", "Emballeur"),
                Map.entry("es_es", "Empaquetador"),
                Map.entry("es_mx", "Empaquetador"),
                Map.entry("pt_pt", "Empacotador"),
                Map.entry("pt_br", "Empacotador"),
                Map.entry("it_it", "Imballatore"),
                Map.entry("nl_nl", "Inpakker"),
                Map.entry("ru_ru", "Упаковщик"),
                Map.entry("uk_ua", "Пакувальник"),
                Map.entry("pl_pl", "Pakowacz"),
                Map.entry("cs_cz", "Balič"),
                Map.entry("sk_sk", "Balič"),
                Map.entry("hu_hu", "Csomagoló"),
                Map.entry("sv_se", "Paketerare"),
                Map.entry("no_no", "Pakkeren"),
                Map.entry("da_dk", "Pakker"),
                Map.entry("fi_fi", "Pakkaaja"),
                Map.entry("tr_tr", "Paketleyici"),
                Map.entry("el_gr", "Συσκευαστής"),
                Map.entry("ro_ro", "Ambalator"),
                Map.entry("bg_bg", "Опаковчик"),
                Map.entry("zh_cn", "打包员"),
                Map.entry("zh_tw", "包裝員"),
                Map.entry("ja_jp", "パッケージ係"),
                Map.entry("ko_kr", "포장 담당자"),
                Map.entry("th_th", "ผู้บรรจุหีบห่อ"),
                Map.entry("ar_sa", "مُغلف"),
                Map.entry("he_il", "אורז חבילות"),
                Map.entry("hi_in", "पैकेजर"),
                Map.entry("id_id", "Pengemas"),
                Map.entry("ms_my", "Pengemas")
        ));

// Buyer Address translations (whimsical / localized flavor)
        translations.put(TooltipTranslations.tooltipPrefix + "buyer_address", Map.ofEntries(
                Map.entry("en_us", "100 Tode Lane, Todeville, Overworld 00000"),
                Map.entry("en_gb", "100 Tode Lane, Todeborough, Realm of Minecraft 00000"),
                Map.entry("en_ca", "100 Tode Trail, Todehaven, Minecraft North 00000"),
                Map.entry("en_au", "100 Tode Track, Tode Downs, Minecraft Outback 00000"),
                Map.entry("en_pt", "Dock 100, Port o’ Tode, the Blocky Seas 00000"), // Pirate Speak

                Map.entry("de_de", "Todesgasse 100, Todeburg, Reich von Minecraft 00000"),
                Map.entry("fr_fr", "100 Allée Tode, Todébourg, Royaume Minecraft 00000"),
                Map.entry("fr_ca", "100 Chemin Tode, Todéville, Royaume Minecraft 00000"),
                Map.entry("es_es", "Callejón Tode 100, Todópolis, Reino de Minecraft 00000"),
                Map.entry("es_mx", "Calle Tode 100, Villa Tode, Mundo de Minecraft 00000"),
                Map.entry("pt_pt", "Rua do Tode 100, Todevila, Reino Minecraft 00000"),
                Map.entry("pt_br", "Rua do Tode 100, Todevila, Reino Minecraft 00000"),
                Map.entry("it_it", "Via Tode 100, Todicittà, Regno Minecraft 00000"),
                Map.entry("nl_nl", "Todestraat 100, Todestad, Blokkenrijk 00000"),
                Map.entry("ru_ru", "ул. Тоде, д.100, Тодовград, Мир Майнкрафта 00000"),
                Map.entry("uk_ua", "вул. Тоде, буд.100, Тодовіль, Світ Майнкрафта 00000"),
                Map.entry("pl_pl", "ul. Tode 100, Todewice, Kraina Minecraft 00000"),
                Map.entry("cs_cz", "Todeova ulice 100, Todeskálov, Říše Minecraft 00000"),
                Map.entry("sk_sk", "Todeova ulica 100, Todemesto, Kraj Minecraft 00000"),
                Map.entry("hu_hu", "Tode utca 100, Todeváros, Minecraft Birodalom 00000"),
                Map.entry("sv_se", "Todegatan 100, Todestad, Blockriket 00000"),
                Map.entry("no_no", "Todegata 100, Todestad, Riket Minecraft 00000"),
                Map.entry("da_dk", "Todegade 100, Todeby, Blokkeriget 00000"),
                Map.entry("fi_fi", "Todekatu 100, Todekaupunki, Palikkamaailma 00000"),
                Map.entry("tr_tr", "Tode Caddesi 100, Todeşehir, Minecraft Diyarı 00000"),
                Map.entry("el_gr", "Οδός Τόντε 100, Τοντεβίλ, Βασίλειο του Μάινκραφτ 00000"),
                Map.entry("ro_ro", "Strada Tode 100, Todeburg, Ținutul Minecraft 00000"),
                Map.entry("bg_bg", "ул. Тоде 100, Тодевил, Кралство Майнкрафт 00000"),
                Map.entry("zh_cn", "托德巷100号，托德城，方块王国 00000"),
                Map.entry("zh_tw", "托德巷100號，托德城，方塊王國 00000"),
                Map.entry("ja_jp", "トード通り100番地、トードタウン、ブロック王国 00000"),
                Map.entry("ko_kr", "토드길 100번지, 토드빌, 블록 왕국 00000"),
                Map.entry("th_th", "100 ถนนโทด, เมืองโทดวิล, อาณาจักรบล็อก 00000"),
                Map.entry("ar_sa", "١٠٠ شارع تود، مدينة تودفيل، مملكة ماينكرافت ٠٠٠٠٠"),
                Map.entry("he_il", "רחוב טודה 100, טודוויל, ממלכת מיינקראפט 00000"),
                Map.entry("hi_in", "100 टोड मार्ग, टोडविल, माइनक्राफ्ट राज्य 00000"),
                Map.entry("id_id", "Jalan Tode No.100, Kota Todeville, Kerajaan Minecraft 00000"),
                Map.entry("ms_my", "Jalan Tode 100, Bandar Todeville, Alam Minecraft 00000")
        ));
// Seal tooltip translations (whimsical company names)
        translations.put(TooltipTranslations.tooltipPrefix + "seal_tooltip", Map.ofEntries(
                Map.entry("en_us", "Wares R Us"),
                Map.entry("en_gb", "Goods R Glee"),
                Map.entry("en_ca", "Blocks ‘n’ Bits"),
                Map.entry("en_au", "Down Under Wares"),
                Map.entry("en_pt", "Treasure R Tamed"),

                Map.entry("de_de", "Kisten & Kuriositäten"),
                Map.entry("fr_fr", "Marchandises Magiques"),
                Map.entry("fr_ca", "Boîtes et Blocs"),
                Map.entry("es_es", "Mercancías Mágicas"),
                Map.entry("es_mx", "Cosas y Cubos"),
                Map.entry("pt_pt", "Produtos Peculiares"),
                Map.entry("pt_br", "Tesouros & Tralhas"),
                Map.entry("it_it", "Bottega dei Blocchi"),
                Map.entry("nl_nl", "Goederen & Gezelligheid"),
                Map.entry("ru_ru", "Товары Таверны"),
                Map.entry("uk_ua", "Кубічні Крамниці"),
                Map.entry("pl_pl", "Klocki i Skarby"),
                Map.entry("cs_cz", "Krabice a Kostičky"),
                Map.entry("sk_sk", "Kocky a Krabice"),
                Map.entry("hu_hu", "Kincsek és Kockák"),
                Map.entry("sv_se", "Varor & Väsen"),
                Map.entry("no_no", "Leker & Lager"),
                Map.entry("da_dk", "Bunker & Blokke"),
                Map.entry("fi_fi", "Palikat & Pömpelit"),
                Map.entry("tr_tr", "Kutular & Kıymetler"),
                Map.entry("el_gr", "Κυβικά Καταστήματα"),
                Map.entry("ro_ro", "Cufere și Cuburi"),
                Map.entry("bg_bg", "Кубчета и Кутийки"),
                Map.entry("zh_cn", "方块宝库"),
                Map.entry("zh_tw", "方塊寶庫"),
                Map.entry("ja_jp", "ブロック商会"),
                Map.entry("ko_kr", "블록 상점"),
                Map.entry("th_th", "ร้านบล็อกสนุก"),
                Map.entry("ar_sa", "متجر المكعبات"),
                Map.entry("he_il", "חנות הקוביות"),
                Map.entry("hi_in", "ब्लॉक बाजार"),
                Map.entry("id_id", "Blok & Barang"),
                Map.entry("ms_my", "Kedai Kubik")
        ));

        // Buyer message translations
        translations.put(TooltipTranslations.tooltipPrefix + "buyer_message", Map.ofEntries(
                Map.entry("en_us", "Willing to pay on delivery for these goods right away!"),
                Map.entry("en_gb", "Willing to pay on delivery for these goods right away!"),
                Map.entry("en_ca", "Willing to pay on delivery for these goods right away!"),
                Map.entry("en_au", "Willing to pay on delivery for these goods right away!"),
                Map.entry("en_pt", "Ready t’ pay upon delivery, no delay!"), // Pirate Speak

                Map.entry("de_de", "Bereit, diese Waren sofort bei Lieferung zu bezahlen!"),
                Map.entry("fr_fr", "Prêt à payer à la livraison pour ces marchandises immédiatement !"),
                Map.entry("fr_ca", "Prêt à payer à la livraison pour ces marchandises immédiatement !"),
                Map.entry("es_es", "¡Dispuesto a pagar contra entrega por estas mercancías de inmediato!"),
                Map.entry("es_mx", "¡Dispuesto a pagar al momento de la entrega por estas mercancías!"),
                Map.entry("pt_pt", "Disposto a pagar na entrega por estas mercadorias de imediato!"),
                Map.entry("pt_br", "Disposto a pagar na entrega por estas mercadorias de imediato!"),
                Map.entry("it_it", "Disposto a pagare alla consegna per queste merci subito!"),
                Map.entry("nl_nl", "Bereid om direct bij levering voor deze goederen te betalen!"),
                Map.entry("ru_ru", "Готов заплатить при доставке за эти товары немедленно!"),
                Map.entry("uk_ua", "Готовий одразу оплатити ці товари при доставці!"),
                Map.entry("pl_pl", "Gotów zapłacić przy odbiorze za te towary od razu!"),
                Map.entry("cs_cz", "Ochoten zaplatit při dodání za toto zboží hned!"),
                Map.entry("sk_sk", "Ochotný zaplatiť pri doručení za tento tovar hneď!"),
                Map.entry("hu_hu", "Kész vagyok azonnal fizetni az áru átvételekor!"),
                Map.entry("sv_se", "Villig att betala vid leverans för dessa varor direkt!"),
                Map.entry("no_no", "Villig til å betale ved levering for disse varene med en gang!"),
                Map.entry("da_dk", "Villig til at betale ved levering for disse varer med det samme!"),
                Map.entry("fi_fi", "Halukas maksamaan heti toimituksen yhteydessä näistä tavaroista!"),
                Map.entry("tr_tr", "Bu mallar için teslimatta hemen ödeme yapmaya hazırım!"),
                Map.entry("el_gr", "Πρόθυμος να πληρώσω κατά την παράδοση για αυτά τα αγαθά αμέσως!"),
                Map.entry("ro_ro", "Dispus să plătesc la livrare pentru aceste bunuri imediat!"),
                Map.entry("bg_bg", "Готов да платя при доставка за тези стоки веднага!"),
                Map.entry("zh_cn", "愿意在交货时立即支付这些货物的费用！"),
                Map.entry("zh_tw", "願意在交貨時立即支付這些貨物的費用！"),
                Map.entry("ja_jp", "これらの商品を配達時にすぐに支払う用意があります！"),
                Map.entry("ko_kr", "이 물품들을 배송 시 즉시 지불하겠습니다!"),
                Map.entry("th_th", "ยินดีที่จะจ่ายเมื่อส่งมอบสินค้านี้ทันที!"),
                Map.entry("ar_sa", "مستعد للدفع عند التسليم لهذه البضائع فورًا!"),
                Map.entry("he_il", "מוכן לשלם במעמד המסירה עבור סחורה זו מיד!"),
                Map.entry("hi_in", "मैं इन वस्तुओं के लिए डिलीवरी पर तुरंत भुगतान करने को तैयार हूँ!"),
                Map.entry("id_id", "Siap membayar saat pengiriman untuk barang ini segera!"),
                Map.entry("ms_my", "Sanggup membayar semasa penghantaran untuk barang ini dengan segera!")
        ));

        // Delivery Order translations
        translations.put(TooltipTranslations.tooltipPrefix + "delivery_order", Map.ofEntries(
                Map.entry("en_us", "Delivery Order"),
                Map.entry("en_gb", "Delivery Order"),
                Map.entry("en_ca", "Delivery Order"),
                Map.entry("en_au", "Delivery Order"),
                Map.entry("en_pt", "Order o' Delivery"), // Pirate Speak or keep English

                Map.entry("de_de", "Lieferauftrag"),
                Map.entry("fr_fr", "Bon de livraison"),
                Map.entry("fr_ca", "Bon de livraison"),
                Map.entry("es_es", "Orden de entrega"),
                Map.entry("es_mx", "Orden de entrega"),
                Map.entry("pt_pt", "Ordem de Entrega"),
                Map.entry("pt_br", "Ordem de Entrega"),
                Map.entry("it_it", "Ordine di consegna"),
                Map.entry("nl_nl", "Leveringsorder"),
                Map.entry("ru_ru", "Накладная на доставку"),
                Map.entry("uk_ua", "Замовлення на доставку"),
                Map.entry("pl_pl", "Zlecenie dostawy"),
                Map.entry("cs_cz", "Dodací příkaz"),
                Map.entry("sk_sk", "Dodací príkaz"),
                Map.entry("hu_hu", "Szállítási megrendelés"),
                Map.entry("sv_se", "Leveransorder"),
                Map.entry("no_no", "Leveringsordre"),
                Map.entry("da_dk", "Leveringsordre"),
                Map.entry("fi_fi", "Toimitustilaus"),
                Map.entry("tr_tr", "Teslimat Emri"),
                Map.entry("el_gr", "Εντολή Παράδοσης"),
                Map.entry("ro_ro", "Ordin de livrare"),
                Map.entry("bg_bg", "Поръчка за доставка"),
                Map.entry("zh_cn", "送货单"),
                Map.entry("zh_tw", "送貨單"),
                Map.entry("ja_jp", "配送注文書"),
                Map.entry("ko_kr", "배송 지시서"),
                Map.entry("th_th", "คำสั่งจัดส่ง"),
                Map.entry("ar_sa", "أمر تسليم"),
                Map.entry("he_il", "הוראת משלוח"),
                Map.entry("hi_in", "वितरण आदेश"),
                Map.entry("id_id", "Pesanan Pengiriman"),
                Map.entry("ms_my", "Pesanan Penghantaran")
        ));

        return translations;
    }
}