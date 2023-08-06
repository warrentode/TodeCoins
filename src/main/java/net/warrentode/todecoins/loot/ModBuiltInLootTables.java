package net.warrentode.todecoins.loot;

import com.google.common.collect.Sets;
import net.minecraft.resources.ResourceLocation;

import java.util.Collections;
import java.util.Set;

import static net.warrentode.todecoins.TodeCoins.MODID;

public class ModBuiltInLootTables {
    private static final Set<ResourceLocation> LOCATIONS = Sets.newHashSet();
    private static final Set<ResourceLocation> IMMUTABLE_LOCATIONS = Collections.unmodifiableSet(LOCATIONS);
    public static final ResourceLocation TODECOINS_CHEST_LOOT = register(MODID + ":" + "chests/todecoins_chest");
    public static final ResourceLocation BANKER_CHEST = register(MODID + ":" + "chests/village/villager_banker");
    public static final ResourceLocation LEPRECHAUN_CHEST = register(MODID + ":" + "chests/village/villager_leprechaun");
    public static final ResourceLocation BANKER_GIFT = register(MODID + ":" + "gameplay/hero_of_the_village/banker_gift");
    public static final ResourceLocation LEPRECHAUN_GIFT = register(MODID + ":" + "gameplay/hero_of_the_village/leprechaun_gift");
    public static final ResourceLocation NETHER_GOLD_COIN_PIGLIN_BARTERING = register(MODID + ":" + "gameplay/nether_gold_coin_piglin_bartering");
    public static final ResourceLocation TODECOINS_CURRENCY_DROPS = register(MODID + ":" + "currency/todecoins_currency_drops");
    public static final ResourceLocation TODECOINS_BOSS_CURRENCY_DROPS = register(MODID + ":" + "currency/todecoins_boss_currency_drops");

    private static ResourceLocation register(String pId) {
        return register(new ResourceLocation(pId));
    }

    private static ResourceLocation register(ResourceLocation pId) {
        if (LOCATIONS.add(pId)) {
            return pId;
        }
        else {
            throw new IllegalArgumentException(pId + " is already a registered built-in loot table");
        }
    }

    public static Set<ResourceLocation> all() {
        return IMMUTABLE_LOCATIONS;
    }
}