package com.github.warrentode.todecoins.datagen.translations;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class KeybindTranslations {
    // Map of item IDs → (language code → translated name)
    public static final Map<String, Map<String, String>> LANG_MAPS = createTranslations();

    @Contract(pure = true)
    private static @NotNull Map<String, Map<String, String>> createTranslations() {
        Map<String, Map<String, String>> translations = new HashMap<>();

// Open Equipped Wallet translations
        translations.put("key.todecoins.open_wallet", Map.ofEntries(
                Map.entry("en_us", "Open Equipped Wallet"),
                Map.entry("en_gb", "Open Equipped Wallet"),
                Map.entry("en_ca", "Open Equipped Wallet"),
                Map.entry("en_au", "Open Equipped Wallet"),
                Map.entry("en_pt", "Open the Wallet, Matey!"), // Pirate Speak

                Map.entry("de_de", "Ausgerüstetes Portemonnaie öffnen"),
                Map.entry("fr_fr", "Ouvrir le portefeuille équipé"),
                Map.entry("fr_ca", "Ouvrir le portefeuille équipé"),
                Map.entry("es_es", "Abrir cartera equipada"),
                Map.entry("es_mx", "Abrir cartera equipada"),
                Map.entry("pt_pt", "Abrir Carteira Equipada"),
                Map.entry("pt_br", "Abrir Carteira Equipada"),
                Map.entry("it_it", "Apri il portafoglio equipaggiato"),
                Map.entry("nl_nl", "Open uitgerust portemonnee"),
                Map.entry("ru_ru", "Открыть надетый кошелек"),
                Map.entry("uk_ua", "Відкрити обладнаний гаманець"),
                Map.entry("pl_pl", "Otwórz wyposażony portfel"),
                Map.entry("cs_cz", "Otevřít vybavenou peněženku"),
                Map.entry("sk_sk", "Otvoriť vybavenú peňaženku"),
                Map.entry("hu_hu", "Nyisd ki a felszerelt pénztárcát"),
                Map.entry("sv_se", "Öppna utrustad plånbok"),
                Map.entry("no_no", "Åpne utstyrt lommebok"),
                Map.entry("da_dk", "Åbn udstyret pung"),
                Map.entry("fi_fi", "Avaa varustettu lompakko"),
                Map.entry("tr_tr", "Donanımlı cüzdanı aç"),
                Map.entry("el_gr", "Άνοιγμα εξοπλισμένου πορτοφολιού"),
                Map.entry("ro_ro", "Deschide portofelul echipat"),
                Map.entry("bg_bg", "Отвори оборудваното портмоне"),
                Map.entry("zh_cn", "打开装备的钱包"),
                Map.entry("zh_tw", "打開裝備的錢包"),
                Map.entry("ja_jp", "装備した財布を開く"),
                Map.entry("ko_kr", "장착된 지갑 열기"),
                Map.entry("th_th", "เปิดกระเป๋าเงินที่ติดตั้งแล้ว"),
                Map.entry("ar_sa", "افتح المحفظة المجهزة"),
                Map.entry("he_il", "פתח את הארנק המצויד"),
                Map.entry("hi_in", "सुसज्जित बटुआ खोलें"),
                Map.entry("id_id", "Buka Dompet yang Dipasang"),
                Map.entry("ms_my", "Buka Dompet Bersedia")
        ));

// Use Equipped Bracelet translations
        translations.put("key.todecoins.use_bracelet", Map.ofEntries(
                Map.entry("en_us", "Use Equipped Bracelet"),
                Map.entry("en_gb", "Use Equipped Bracelet"),
                Map.entry("en_ca", "Use Equipped Bracelet"),
                Map.entry("en_au", "Use Equipped Bracelet"),
                Map.entry("en_pt", "Use the Bracelet, Matey!"), // Pirate Speak

                Map.entry("de_de", "Ausgerüstetes Armband verwenden"),
                Map.entry("fr_fr", "Utiliser le bracelet équipé"),
                Map.entry("fr_ca", "Utiliser le bracelet équipé"),
                Map.entry("es_es", "Usar pulsera equipada"),
                Map.entry("es_mx", "Usar pulsera equipada"),
                Map.entry("pt_pt", "Usar Pulseira Equipada"),
                Map.entry("pt_br", "Usar Pulseira Equipada"),
                Map.entry("it_it", "Usa il braccialetto equipaggiato"),
                Map.entry("nl_nl", "Gebruik uitgerust armband"),
                Map.entry("ru_ru", "Использовать надетый браслет"),
                Map.entry("uk_ua", "Використати обладнаний браслет"),
                Map.entry("pl_pl", "Użyj wyposażonej bransoletki"),
                Map.entry("cs_cz", "Použít vybavený náramek"),
                Map.entry("sk_sk", "Použiť vybavený náramok"),
                Map.entry("hu_hu", "Használd a felszerelt karkötőt"),
                Map.entry("sv_se", "Använd utrustat armband"),
                Map.entry("no_no", "Bruk utstyrt armbånd"),
                Map.entry("da_dk", "Brug udstyret armbånd"),
                Map.entry("fi_fi", "Käytä varustettua ranneketta"),
                Map.entry("tr_tr", "Donanımlı bilekliği kullan"),
                Map.entry("el_gr", "Χρησιμοποιήστε το εξοπλισμένο βραχιόλι"),
                Map.entry("ro_ro", "Folosește brățara echipată"),
                Map.entry("bg_bg", "Използвай оборудваната гривна"),
                Map.entry("zh_cn", "使用装备的手链"),
                Map.entry("zh_tw", "使用裝備的手鍊"),
                Map.entry("ja_jp", "装備したブレスレットを使用"),
                Map.entry("ko_kr", "장착된 팔찌 사용"),
                Map.entry("th_th", "ใช้กำไลที่ติดตั้งแล้ว"),
                Map.entry("ar_sa", "استخدم السوار المجهز"),
                Map.entry("he_il", "השתמש בצמיד המצויד"),
                Map.entry("hi_in", "सुसज्जित ब्रेसलेट उपयोग करें"),
                Map.entry("id_id", "Gunakan Gelang yang Dipasang"),
                Map.entry("ms_my", "Gunakan Gelang Bersedia")
        ));

// Use Equipped Coin translations
        translations.put("key.todecoins.use_coin", Map.ofEntries(
                Map.entry("en_us", "Use Equipped Coin"),
                Map.entry("en_gb", "Use Equipped Coin"),
                Map.entry("en_ca", "Use Equipped Coin"),
                Map.entry("en_au", "Use Equipped Coin"),
                Map.entry("en_pt", "Use the Coin, Matey!"), // Pirate Speak

                Map.entry("de_de", "Ausgerüstete Münze verwenden"),
                Map.entry("fr_fr", "Utiliser la pièce équipée"),
                Map.entry("fr_ca", "Utiliser la pièce équipée"),
                Map.entry("es_es", "Usar moneda equipada"),
                Map.entry("es_mx", "Usar moneda equipada"),
                Map.entry("pt_pt", "Usar Moeda Equipada"),
                Map.entry("pt_br", "Usar Moeda Equipada"),
                Map.entry("it_it", "Usa la moneta equipaggiata"),
                Map.entry("nl_nl", "Gebruik uitgeruste munt"),
                Map.entry("ru_ru", "Использовать надетую монету"),
                Map.entry("uk_ua", "Використати обладнану монету"),
                Map.entry("pl_pl", "Użyj wyposażonej monety"),
                Map.entry("cs_cz", "Použít vybavenou minci"),
                Map.entry("sk_sk", "Použiť vybavenú mincu"),
                Map.entry("hu_hu", "Használd a felszerelt érmét"),
                Map.entry("sv_se", "Använd utrustad mynt"),
                Map.entry("no_no", "Bruk utstyrt mynt"),
                Map.entry("da_dk", "Brug udstyret mønt"),
                Map.entry("fi_fi", "Käytä varustettua kolikkoa"),
                Map.entry("tr_tr", "Donanımlı madeni parayı kullan"),
                Map.entry("el_gr", "Χρησιμοποιήστε τον εξοπλισμένο νόμισμα"),
                Map.entry("ro_ro", "Folosește moneda echipată"),
                Map.entry("bg_bg", "Използвай оборудваната монета"),
                Map.entry("zh_cn", "使用装备的硬币"),
                Map.entry("zh_tw", "使用裝備的硬幣"),
                Map.entry("ja_jp", "装備したコインを使用"),
                Map.entry("ko_kr", "장착된 동전 사용"),
                Map.entry("th_th", "ใช้เหรียญที่ติดตั้งแล้ว"),
                Map.entry("ar_sa", "استخدم العملة المجهزة"),
                Map.entry("he_il", "השתמש במטבע המצויד"),
                Map.entry("hi_in", "सुसज्जित सिक्का उपयोग करें"),
                Map.entry("id_id", "Gunakan Koin yang Dipasang"),
                Map.entry("ms_my", "Gunakan Syiling Bersedia")
        ));
// TodeCoin Keys translations
        translations.put("key.categories.todecoins", Map.ofEntries(
                Map.entry("en_us", "TodeCoin Keys"),
                Map.entry("en_gb", "TodeCoin Keys"),
                Map.entry("en_ca", "TodeCoin Keys"),
                Map.entry("en_au", "TodeCoin Keys"),
                Map.entry("en_pt", "TodeCoin Keys"), // Pirate Speak or keep English

                Map.entry("de_de", "TodeCoin Tasten"),
                Map.entry("fr_fr", "Touches TodeCoin"),
                Map.entry("fr_ca", "Touches TodeCoin"),
                Map.entry("es_es", "Teclas TodeCoin"),
                Map.entry("es_mx", "Teclas TodeCoin"),
                Map.entry("pt_pt", "Teclas TodeCoin"),
                Map.entry("pt_br", "Teclas TodeCoin"),
                Map.entry("it_it", "Tasti TodeCoin"),
                Map.entry("nl_nl", "TodeCoin-toetsen"),
                Map.entry("ru_ru", "Клавиши TodeCoin"),
                Map.entry("uk_ua", "Клавіші TodeCoin"),
                Map.entry("pl_pl", "Klawisze TodeCoin"),
                Map.entry("cs_cz", "Klávesy TodeCoin"),
                Map.entry("sk_sk", "Kľúče TodeCoin"),
                Map.entry("hu_hu", "TodeCoin Billentyűk"),
                Map.entry("sv_se", "TodeCoin-knappar"),
                Map.entry("no_no", "TodeCoin-taster"),
                Map.entry("da_dk", "TodeCoin-taster"),
                Map.entry("fi_fi", "TodeCoin-näppäimet"),
                Map.entry("tr_tr", "TodeCoin Tuşları"),
                Map.entry("el_gr", "Πλήκτρα TodeCoin"),
                Map.entry("ro_ro", "Taste TodeCoin"),
                Map.entry("bg_bg", "Бутоните на TodeCoin"),
                Map.entry("zh_cn", "TodeCoin 键"),
                Map.entry("zh_tw", "TodeCoin 鍵"),
                Map.entry("ja_jp", "TodeCoinキー"),
                Map.entry("ko_kr", "TodeCoin 키"),
                Map.entry("th_th", "ปุ่ม TodeCoin"),
                Map.entry("ar_sa", "مفاتيح TodeCoin"),
                Map.entry("he_il", "מקשי TodeCoin"),
                Map.entry("hi_in", "TodeCoin कुंजियाँ"),
                Map.entry("id_id", "Tombol TodeCoin"),
                Map.entry("ms_my", "Kekunci TodeCoin")
        ));

        return translations;
    }
}