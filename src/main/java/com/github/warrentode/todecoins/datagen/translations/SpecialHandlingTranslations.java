package com.github.warrentode.todecoins.datagen.translations;

import com.github.warrentode.todecoins.item.TCItems;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

public class SpecialHandlingTranslations {
    // custom event lang key prefix
    public static final String customEventPrefix = "custom_event." + MODID + ".prefix";
    // custom event lang key prefix
    public static final String customEventSuffix = "custom_event." + MODID + ".suffix";
    // list for braceletID key prefix
    private static @NotNull List<Item> getBracelets() {
        List<Item> itemIdPrefix = new ArrayList<>();

        itemIdPrefix.add(TCItems.BRACELET_FRIENDSHIP_ECHO.get());
        itemIdPrefix.add(TCItems.BRACELET_FRIENDSHIP_EMERALD.get());
        itemIdPrefix.add(TCItems.BRACELET_FRIENDSHIP_ENDONIAN.get());
        itemIdPrefix.add(TCItems.BRACELET_FRIENDSHIP_LUCKY.get());

        return itemIdPrefix;
    }

    // Map of item IDs → (language code → translated name)
    public static final Map<String, Map<String, String>> LANG_MAPS_PREFIX = createPrefixTranslations();
    public static final Map<String, Map<String, String>> LANG_MAPS_SUFFIX = createSuffixTranslations();
    public static final Map<String, Map<String, String>> LANG_MAPS_BRACELETS = createBraceletTranslations();
    public static final Map<String, Map<String, String>> LANG_MAPS_ATTRIBUTES = createAttributeTranslations();

    private static @NotNull Map<String, Map<String, String>> createAttributeTranslations() {
        Map<String, Map<String, String>> translations = new HashMap<>();

        // Charisma attribute translations
        translations.put("attribute.name.todecoins.charisma", Map.ofEntries(
                Map.entry("en_us", "Charisma"),
                Map.entry("en_gb", "Charisma"),
                Map.entry("en_ca", "Charisma"),
                Map.entry("en_au", "Charisma"),
                Map.entry("en_pt", "Charisma"), // Pirate Speak can stay the same

                Map.entry("de_de", "Charisma"),
                Map.entry("fr_fr", "Charisme"),
                Map.entry("fr_ca", "Charisme"),
                Map.entry("es_es", "Carisma"),
                Map.entry("es_mx", "Carisma"),
                Map.entry("pt_pt", "Carisma"),
                Map.entry("pt_br", "Carisma"),
                Map.entry("it_it", "Carisma"),
                Map.entry("nl_nl", "Charisma"),
                Map.entry("ru_ru", "Харизма"),
                Map.entry("uk_ua", "Харизма"),
                Map.entry("pl_pl", "Charyzma"),
                Map.entry("cs_cz", "Charisma"),
                Map.entry("sk_sk", "Charizma"),
                Map.entry("hu_hu", "Karizma"),
                Map.entry("sv_se", "Karism"),
                Map.entry("no_no", "Karisme"),
                Map.entry("da_dk", "Karisme"),
                Map.entry("fi_fi", "Karisma"),
                Map.entry("tr_tr", "Karizma"),
                Map.entry("el_gr", "Χάρισμα"),
                Map.entry("ro_ro", "Carismă"),
                Map.entry("bg_bg", "Харизма"),
                Map.entry("zh_cn", "魅力"),
                Map.entry("zh_tw", "魅力"),
                Map.entry("ja_jp", "カリスマ"),
                Map.entry("ko_kr", "카리스마"),
                Map.entry("th_th", "เสน่ห์"),
                Map.entry("ar_sa", "الكاريزما"),
                Map.entry("he_il", "כריזמה"),
                Map.entry("hi_in", "करिश्मा"),
                Map.entry("id_id", "Karismatik"),
                Map.entry("ms_my", "Karismatik")
        ));

        return translations;
    }

    @Contract(pure = true)
    private static @NotNull Map<String, Map<String, String>> createBraceletTranslations() {
        Map<String, Map<String, String>> translations = new HashMap<>();

        for (Item bracelet : getBracelets()) {
            // Get descriptionID of bracelet
            String braceletId = bracelet.getDescriptionId();

            // LINKED translation
            translations.put(braceletId + ".linked", Map.ofEntries(
                    Map.entry("en_us", "This bracelet is linked to you!"),
                    Map.entry("en_gb", "This bracelet is linked to you!"),
                    Map.entry("en_ca", "This bracelet is linked to you!"),
                    Map.entry("en_au", "This bracelet is linked to you!"),
                    Map.entry("en_pt", "Arr! This bracelet be linked to ye!"), // Pirate Speak

                    Map.entry("de_de", "Dieses Armband ist mit dir verbunden!"),
                    Map.entry("fr_fr", "Ce bracelet est lié à vous !"),
                    Map.entry("fr_ca", "Ce bracelet est lié à vous !"),
                    Map.entry("es_es", "¡Esta pulsera está vinculada a ti!"),
                    Map.entry("es_mx", "¡Esta pulsera está vinculada a ti!"),
                    Map.entry("pt_pt", "Esta pulseira está ligada a você!"),
                    Map.entry("pt_br", "Esta pulseira está ligada a você!"),
                    Map.entry("it_it", "Questo braccialetto è collegato a te!"),
                    Map.entry("nl_nl", "Deze armband is aan jou gekoppeld!"),
                    Map.entry("ru_ru", "Этот браслет привязан к вам!"),
                    Map.entry("uk_ua", "Цей браслет пов'язаний з вами!"),
                    Map.entry("pl_pl", "Ta bransoletka jest do Ciebie przypisana!"),
                    Map.entry("cs_cz", "Tento náramek je s vámi propojen!"),
                    Map.entry("sk_sk", "Tento náramok je s vami prepojený!"),
                    Map.entry("hu_hu", "Ez a karkötő hozzád van kötve!"),
                    Map.entry("sv_se", "Detta armband är kopplat till dig!"),
                    Map.entry("no_no", "Dette armbåndet er koblet til deg!"),
                    Map.entry("da_dk", "Dette armbånd er linket til dig!"),
                    Map.entry("fi_fi", "Tämä ranneke on liitetty sinuun!"),
                    Map.entry("tr_tr", "Bu bileklik sana bağlı!"),
                    Map.entry("el_gr", "Αυτό το βραχιόλι είναι συνδεδεμένο σε εσάς!"),
                    Map.entry("ro_ro", "Această brățară este legată de tine!"),
                    Map.entry("bg_bg", "Тази гривна е свързана с вас!"),
                    Map.entry("zh_cn", "此手镯已绑定给你！"),
                    Map.entry("zh_tw", "此手鐲已綁定給你！"),
                    Map.entry("ja_jp", "このブレスレットはあなたにリンクされています！"),
                    Map.entry("ko_kr", "이 팔찌가 당신과 연결되었습니다!"),
                    Map.entry("th_th", "กำไลนี้เชื่อมโยงกับคุณแล้ว!"),
                    Map.entry("ar_sa", "هذا السوار مرتبط بك!"),
                    Map.entry("he_il", "הצמיד הזה מקושר אליך!"),
                    Map.entry("hi_in", "यह ब्रेसलेट आपके साथ लिंक हो गया है!"),
                    Map.entry("id_id", "Gelang ini telah terhubung kepadamu!"),
                    Map.entry("ms_my", "Gelang ini telah dipautkan kepadamu!")
            ));

            // OFFLINE translation
            translations.put(braceletId + ".offline", Map.ofEntries(
                    Map.entry("en_us", "§cLinked player§r %s §cis offline. Teleport aborted.§r"),
                    Map.entry("en_gb", "§cLinked player§r %s §cis offline. Teleport aborted.§r"),
                    Map.entry("en_ca", "§cLinked player§r %s §cis offline. Teleport aborted.§r"),
                    Map.entry("en_au", "§cLinked player§r %s §cis offline. Teleport aborted.§r"),
                    Map.entry("en_pt", "§cArr! Linked player§r %s §cis walkin’ the plank! Teleport aborted.§r"), // Pirate Speak

                    Map.entry("de_de", "§cVerbundener Spieler§r %s §cist offline. Teleport abgebrochen.§r"),
                    Map.entry("fr_fr", "§cJoueur lié§r %s §cest hors ligne. Téléportation annulée.§r"),
                    Map.entry("fr_ca", "§cJoueur lié§r %s §cest hors ligne. Téléportation annulée.§r"),
                    Map.entry("es_es", "§cJugador vinculado§r %s §cestá desconectado. Teletransporte abortado.§r"),
                    Map.entry("es_mx", "§cJugador vinculado§r %s §cestá desconectado. Teletransporte abortado.§r"),
                    Map.entry("pt_pt", "§cJogador vinculado§r %s §cestá offline. Teleporte abortado.§r"),
                    Map.entry("pt_br", "§cJogador vinculado§r %s §cestá offline. Teleporte abortado.§r"),
                    Map.entry("it_it", "§cGiocatore collegato§r %s §cè offline. Teletrasporto annullato.§r"),
                    Map.entry("nl_nl", "§cGekoppelde speler§r %s §cis offline. Teleport afgebroken.§r"),
                    Map.entry("ru_ru", "§cСвязанный игрок§r %s §cне в сети. Телепорт отменен.§r"),
                    Map.entry("uk_ua", "§cПов’язаний гравець§r %s §cне в мережі. Телепорт скасовано.§r"),
                    Map.entry("pl_pl", "§cPowiązany gracz§r %s §cjest offline. Teleportacja anulowana.§r"),
                    Map.entry("cs_cz", "§cPropojený hráč§r %s §cje offline. Teleport zrušen.§r"),
                    Map.entry("sk_sk", "§cPrepojený hráč§r %s §cnie je online. Teleport zrušený.§r"),
                    Map.entry("hu_hu", "§cKapcsolt játékos§r %s §cnem elérhető. Teleport megszakítva.§r"),
                    Map.entry("sv_se", "§cLänkad spelare§r %s §cär offline. Teleport avbrutet.§r"),
                    Map.entry("no_no", "§cKnyttet spiller§r %s §cer offline. Teleport avbrutt.§r"),
                    Map.entry("da_dk", "§cKnyttet spiller§r %s §cer offline. Teleport afbrudt.§r"),
                    Map.entry("fi_fi", "§cLiitetty pelaaja§r %s §con offline. Teleportti peruutettu.§r"),
                    Map.entry("tr_tr", "§cBağlı oyuncu§r %s §coffline. Teleport iptal edildi.§r"),
                    Map.entry("el_gr", "§cΣυνδεδεμένος παίκτης§r %s §cείναι εκτός σύνδεσης. Τηλεμεταφορά ακυρώθηκε.§r"),
                    Map.entry("ro_ro", "§cJucător legat§r %s §ceste offline. Teleport anulat.§r"),
                    Map.entry("bg_bg", "§cСвързан играч§r %s §cе офлайн. Телепортът е прекратен.§r"),
                    Map.entry("zh_cn", "§c已绑定玩家§r %s §c已离线。传送中止.§r"),
                    Map.entry("zh_tw", "§c已綁定玩家§r %s §c已離線。傳送中止.§r"),
                    Map.entry("ja_jp", "§cリンクされたプレイヤー§r %s §cはオフラインです。テレポート中止.§r"),
                    Map.entry("ko_kr", "§c연결된 플레이어§r %s §c오프라인입니다. 텔레포트 중단.§r"),
                    Map.entry("th_th", "§cผู้เล่นที่เชื่อมโยง§r %s §cออฟไลน์แล้ว การเทเลพอร์ตถูกยกเลิก.§r"),
                    Map.entry("ar_sa", "§cاللاعب المرتبط§r %s §cغير متصل. تم إلغاء النقل.§r"),
                    Map.entry("he_il", "§cשחקן מקושר§r %s §cלא מחובר. הטלפורט בוטל.§r"),
                    Map.entry("hi_in", "§cसंपर्कित खिलाड़ी§r %s §cऑफ़लाइन है। टेलीपोर्ट रद्द.§r"),
                    Map.entry("id_id", "§cPemain terhubung§r %s §ctidak online. Teleport dibatalkan.§r"),
                    Map.entry("ms_my", "§cPemain berhubung§r %s §ctidak dalam talian. Teleport dibatalkan.§r")
            ));

            // Bracelet Teleport Failed translations
            translations.put(braceletId + ".teleport_failed", Map.ofEntries(
                    Map.entry("en_us", "Teleport Failed. Check logs for more information."),
                    Map.entry("en_gb", "Teleport Failed. Check logs for more information."),
                    Map.entry("en_ca", "Teleport Failed. Check logs for more information."),
                    Map.entry("en_au", "Teleport Failed. Check logs for more information."),
                    Map.entry("en_pt", "Arr! Teleport Failed. Check logs for more information."), // Pirate Speak

                    Map.entry("de_de", "Teleport fehlgeschlagen. Prüfe die Logs für weitere Informationen."),
                    Map.entry("fr_fr", "Échec de la téléportation. Vérifiez les journaux pour plus d'informations."),
                    Map.entry("fr_ca", "Échec de la téléportation. Vérifiez les journaux pour plus d'informations."),
                    Map.entry("es_es", "Teletransporte fallido. Comprueba los registros para más información."),
                    Map.entry("es_mx", "Teletransporte fallido. Comprueba los registros para más información."),
                    Map.entry("pt_pt", "Teleporte falhou. Verifique os logs para mais informações."),
                    Map.entry("pt_br", "Teleporte falhou. Verifique os logs para mais informações."),
                    Map.entry("it_it", "Teletrasporto fallito. Controlla i log per maggiori informazioni."),
                    Map.entry("nl_nl", "Teleportatie mislukt. Controleer de logs voor meer informatie."),
                    Map.entry("ru_ru", "Телепортация не удалась. Проверьте логи для получения дополнительной информации."),
                    Map.entry("uk_ua", "Телепортація не вдалася. Перевірте журнали для отримання додаткової інформації."),
                    Map.entry("pl_pl", "Teleportacja nie powiodła się. Sprawdź logi, aby uzyskać więcej informacji."),
                    Map.entry("cs_cz", "Teleport selhal. Zkontrolujte protokoly pro více informací."),
                    Map.entry("sk_sk", "Teleport zlyhal. Skontrolujte logy pre viac informácií."),
                    Map.entry("hu_hu", "Teleportálás sikertelen. Ellenőrizd a naplókat további információkért."),
                    Map.entry("sv_se", "Teleportering misslyckades. Kontrollera loggarna för mer information."),
                    Map.entry("no_no", "Teleport mislyktes. Sjekk loggene for mer informasjon."),
                    Map.entry("da_dk", "Teleportering mislykkedes. Tjek logfiler for mere information."),
                    Map.entry("fi_fi", "Teleporttaus epäonnistui. Tarkista lokit lisätietoja varten."),
                    Map.entry("tr_tr", "Teleport Başarısız. Daha fazla bilgi için logları kontrol edin."),
                    Map.entry("el_gr", "Η τηλεμεταφορά απέτυχε. Ελέγξτε τα αρχεία καταγραφής για περισσότερες πληροφορίες."),
                    Map.entry("ro_ro", "Teleportare eșuată. Verificați jurnalele pentru mai multe informații."),
                    Map.entry("bg_bg", "Телепортирането не бе успешно. Проверете логовете за повече информация."),
                    Map.entry("zh_cn", "传送失败。请检查日志以获取更多信息。"),
                    Map.entry("zh_tw", "傳送失敗。請檢查日誌以獲取更多資訊。"),
                    Map.entry("ja_jp", "テレポートに失敗しました。詳細はログを確認してください。"),
                    Map.entry("ko_kr", "텔레포트 실패. 자세한 내용은 로그를 확인하세요."),
                    Map.entry("th_th", "การเทเลพอร์ตล้มเหลว ตรวจสอบบันทึกสำหรับข้อมูลเพิ่มเติม"),
                    Map.entry("ar_sa", "فشل النقل. تحقق من السجلات لمزيد من المعلومات."),
                    Map.entry("he_il", "הטלה נכשלה. בדוק את הלוגים למידע נוסף."),
                    Map.entry("hi_in", "टेलीपोर्ट विफल। अधिक जानकारी के लिए लॉग देखें।"),
                    Map.entry("id_id", "Teleport Gagal. Periksa log untuk informasi lebih lanjut."),
                    Map.entry("ms_my", "Teleport Gagal. Semak log untuk maklumat lanjut.")
            ));
        }

        return translations;
    }

    @Contract(pure = true)
    private static @NotNull Map<String, Map<String, String>> createSuffixTranslations() {
        Map<String, Map<String, String>> translations = new HashMap<>();

// Today suffix translations
        translations.put(customEventSuffix, Map.ofEntries(
                Map.entry("en_us", " Let's Celebrate!"),
                Map.entry("en_gb", " Let's Celebrate!"),
                Map.entry("en_ca", " Let's Celebrate!"),
                Map.entry("en_au", " Let's Celebrate!"),
                Map.entry("en_pt", " Let's Celebrate!"), // Pirate Speak or keep English

                Map.entry("de_de", " Lasst uns feiern!"),
                Map.entry("fr_fr", " Célébrons!"),
                Map.entry("fr_ca", " Célébrons!"),
                Map.entry("es_es", " ¡A celebrar!"),
                Map.entry("es_mx", " ¡A celebrar!"),
                Map.entry("pt_pt", " Vamos Celebrar!"),
                Map.entry("pt_br", " Vamos Celebrar!"),
                Map.entry("it_it", " Festeggiamo!"),
                Map.entry("nl_nl", " Laten we vieren!"),
                Map.entry("ru_ru", " Давайте праздновать!"),
                Map.entry("uk_ua", " Святкуємо!"),
                Map.entry("pl_pl", " Świętujmy!"),
                Map.entry("cs_cz", " Oslavme to!"),
                Map.entry("sk_sk", " Oslávme to!"),
                Map.entry("hu_hu", " Ünnepeljünk!"),
                Map.entry("sv_se", " Låt oss fira!"),
                Map.entry("no_no", " La oss feire!"),
                Map.entry("da_dk", " Lad os fejre!"),
                Map.entry("fi_fi", " Juhlitaan!"),
                Map.entry("tr_tr", " Haydi Kutlayalım!"),
                Map.entry("el_gr", " Ας γιορτάσουμε!"),
                Map.entry("ro_ro", " Să sărbătorim!"),
                Map.entry("bg_bg", " Да празнуваме!"),
                Map.entry("zh_cn", " 让我们庆祝！"),
                Map.entry("zh_tw", " 讓我們慶祝！"),
                Map.entry("ja_jp", " お祝いしよう！"),
                Map.entry("ko_kr", " 축하합시다!"),
                Map.entry("th_th", " มาเฉลิมฉลองกันเถอะ!"),
                Map.entry("ar_sa", "هيا نحتفل! "),
                Map.entry("he_il", "בואו נחגוג! "),
                Map.entry("hi_in", " आइए जश्न मनाएँ!"),
                Map.entry("id_id", " Mari Rayakan!"),
                Map.entry("ms_my", " Mari Raikan!")
        ));

        return translations;
    }

    @Contract(pure = true)
    private static @NotNull Map<String, Map<String, String>> createPrefixTranslations() {
        Map<String, Map<String, String>> translations = new HashMap<>();
// Today is translations
        translations.put(customEventPrefix, Map.ofEntries(
                Map.entry("en_us", "Today is "),
                Map.entry("en_gb", "Today is "),
                Map.entry("en_ca", "Today is "),
                Map.entry("en_au", "Today is "),
                Map.entry("en_pt", "Today is "), // Pirate Speak or keep English

                Map.entry("de_de", "Heute ist "),
                Map.entry("fr_fr", "Aujourd'hui c'est "),
                Map.entry("fr_ca", "Aujourd'hui c'est "),
                Map.entry("es_es", "Hoy es "),
                Map.entry("es_mx", "Hoy es "),
                Map.entry("pt_pt", "Hoje é "),
                Map.entry("pt_br", "Hoje é "),
                Map.entry("it_it", "Oggi è "),
                Map.entry("nl_nl", "Vandaag is het "),
                Map.entry("ru_ru", "Сегодня "),
                Map.entry("uk_ua", "Сьогодні "),
                Map.entry("pl_pl", "Dziś jest "),
                Map.entry("cs_cz", "Dnes je "),
                Map.entry("sk_sk", "Dnes je "),
                Map.entry("hu_hu", "Ma van "),
                Map.entry("sv_se", "Idag är det "),
                Map.entry("no_no", "I dag er det "),
                Map.entry("da_dk", "I dag er det "),
                Map.entry("fi_fi", "Tänään on "),
                Map.entry("tr_tr", "Bugün "),
                Map.entry("el_gr", "Σήμερα είναι "),
                Map.entry("ro_ro", "Astăzi este "),
                Map.entry("bg_bg", "Днес е "),
                Map.entry("zh_cn", "今天是 "),
                Map.entry("zh_tw", "今天是 "),
                Map.entry("ja_jp", "今日は "),
                Map.entry("ko_kr", "오늘은 "),
                Map.entry("th_th", "วันนี้คือ "),
                Map.entry("ar_sa", "اليوم هو "),
                Map.entry("he_il", "היום הוא "),
                Map.entry("hi_in", "आज है "),
                Map.entry("id_id", "Hari ini adalah "),
                Map.entry("ms_my", "Hari ini ialah ")
        ));

        return translations;
    }
}