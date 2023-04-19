package net.warrentode.todecoins;

import com.mojang.logging.LogUtils;
import org.slf4j.Logger;

import java.util.logging.Level;

public class ModLogger {
    private static final Logger speakerTode = LogUtils.getLogger();

    public static void info(String message) {
        speakerTode.info("TodeCoins INFO: " + message, Level.INFO);
    }

    public static void warn(String message) {
        speakerTode.warn("TodeCoins WARNING: " + message, Level.WARNING);
    }

    public static void error(String message) {
        speakerTode.error("TodeCoins ERROR: " + message, Level.SEVERE);
    }
}
