package net.warrentode.todecoins.screen.coinpressgui;

public enum CoinPressRecipeBookTab {
    COINS("coins"),
    BANK_NOTES("bank_notes");

    public final String name;

    CoinPressRecipeBookTab(String name) {
        this.name = name;
    }

    public static CoinPressRecipeBookTab findByName(String name) {
        for (CoinPressRecipeBookTab value : values()) {
            if (value.name.equals(name)) {
                return value;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.name;
    }
}