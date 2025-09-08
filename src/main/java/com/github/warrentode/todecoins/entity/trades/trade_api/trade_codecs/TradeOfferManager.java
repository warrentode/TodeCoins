package com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs;

import com.github.warrentode.todecoins.entity.trades.trade_api.TradeInjectionHelper;
import com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.trade_types.TradeOfferFactoryType;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.JsonOps;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.ReloadableServerResources;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.StringRepresentable;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraftforge.event.AddReloadListenerEvent;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static com.github.warrentode.todecoins.TodeCoins.MODID;
import static com.github.warrentode.todecoins.TodeCoins.TC_LOGGER;

public class TradeOfferManager extends SimpleJsonResourceReloadListener {
    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    public static final ResourceLocation WANDERING_TRADER_PROFESSION_ID = ForgeRegistries.ENTITY_TYPES.getKey(EntityType.WANDERING_TRADER);
    public static final ResourceLocation NUMISMATIST_PROFESSION_ID = ResourceLocation.parse("todecoins:numismatist");
    public static final ResourceLocation PIGLINMERCHANT_PROFESSION_ID = ResourceLocation.parse("todecoins:piglin_merchant");
    public static final ResourceLocation GOBLIN_TRADER_ID = ResourceLocation.parse("goblintraders:goblin_trader");
    public static final ResourceLocation VEIN_GOBLIN_TRADER_ID = ResourceLocation.parse("goblintraders:vein_goblin_trader");
    public static final ResourceLocation RED_MERCHANT_ID = ResourceLocation.parse("supplementaries:red_merchant");
    private static final ResourceLocation ID = ResourceLocation.parse(MODID + ":trades");

    private static final Map<ResourceLocation, Int2ObjectMap<List<VillagerTrades.ItemListing>>> cachedTrades = new Object2ObjectOpenHashMap<>();
    // Changed to mutable map
    public Map<ResourceLocation, Int2ObjectMap<VillagerTrades.ItemListing[]>> offerFactories = new HashMap<>();

    public TradeOfferManager() {
        super(GSON, ID.getPath());
    }

    @Override
    protected void apply(@NotNull Map<ResourceLocation, JsonElement> prepared, @NotNull ResourceManager manager, @NotNull ProfilerFiller profiler) {
        TC_LOGGER.info("Applying trade data...");

        TradeInjectionHelper.clearCache();
        cachedTrades.clear(); // Clear previous cached trades
        AtomicInteger loadedCount = new AtomicInteger();

        for (Map.Entry<ResourceLocation, JsonElement> entry : prepared.entrySet()) {
            ResourceLocation resourceLocation = entry.getKey();
            JsonElement jsonElement = entry.getValue();

            // Decode villager-style trades
            try {
                CustomVillagerTrades trades = CustomVillagerTrades.CUSTOM_VILLAGER_TRADES_CODEC
                        .decode(JsonOps.INSTANCE, jsonElement)
                        .getOrThrow(false, err -> {
                        })
                        .getFirst();

                ResourceLocation profession = trades.profession();
                Int2ObjectMap<List<VillagerTrades.ItemListing>> levelMap =
                        cachedTrades.computeIfAbsent(profession, k -> new Int2ObjectOpenHashMap<>());

                trades.trades().forEach((level, listings) -> {
                    List<VillagerTrades.ItemListing> levelList =
                            levelMap.computeIfAbsent(level, k -> new ArrayList<>());
                    levelList.addAll(listings);
                });

                TC_LOGGER.info("Loaded Villager trades for {}: {}", profession, trades.trades());
                loadedCount.incrementAndGet();
                continue;
            }
            catch (Exception exception) {
                TC_LOGGER.error("Failed to process Villager trade JSON {}: {}", resourceLocation, exception.getMessage());
            }

            // Decode wandering-trader-style trades
            try {
                CustomWanderingTraderTrades trades = CustomWanderingTraderTrades.CUSTOM_WANDERING_TRADER_TRADES_CODEC
                        .decode(JsonOps.INSTANCE, jsonElement)
                        .getOrThrow(false, err -> {
                        })
                        .getFirst();

                ResourceLocation profession = trades.profession();
                Int2ObjectMap<List<VillagerTrades.ItemListing>> rarityMap =
                        cachedTrades.computeIfAbsent(profession, k -> new Int2ObjectOpenHashMap<>());

                trades.trades().forEach((rarityId, listings) -> {
                    List<VillagerTrades.ItemListing> rarityList =
                            rarityMap.computeIfAbsent(rarityId, k -> new ArrayList<>());
                    rarityList.addAll(listings);
                });

                TC_LOGGER.info("Loaded Wandering Trader trades for {}: {}", profession, trades.trades());
                loadedCount.incrementAndGet();
            }
            catch (Exception exception) {
                TC_LOGGER.error("Failed to process Wandering Trader trade JSON {}: {}", resourceLocation, exception.getMessage());
            }

            loadedCount.incrementAndGet();
        }

        // Convert cachedTrades to offerFactories
        offerFactories = cachedTrades.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey, // The ResourceLocation key (e.g., profession or custom merchant ID)
                        entry -> {
                            Int2ObjectMap<List<VillagerTrades.ItemListing>> tradeLevels = entry.getValue();

                            return tradeLevels.int2ObjectEntrySet().stream()
                                    .collect(Collectors.toMap(
                                            Int2ObjectMap.Entry::getIntKey, // Trade level (e.g., 1 = novice)
                                            tradeLevelEntry -> {
                                                List<VillagerTrades.ItemListing> itemListings = tradeLevelEntry.getValue();
                                                return itemListings.toArray(new VillagerTrades.ItemListing[0]);
                                            },
                                            (first, second) -> first, // Merge function, not used (no duplicates expected)
                                            Int2ObjectOpenHashMap::new // Preserve map type
                                    ));
                        }
                ));

        TC_LOGGER.info("Loaded {} trade offer files", loadedCount.get());
    }

    public Optional<Int2ObjectMap<List<VillagerTrades.ItemListing>>> getVillagerOffers(VillagerProfession profession) {
        return Optional.ofNullable(cachedTrades.get(ForgeRegistries.VILLAGER_PROFESSIONS.getKey(profession)));
    }

    public Optional<VillagerTrades.ItemListing[]> getWanderingTraderOffers(MerchantLevel rarity) {
        Int2ObjectMap<List<VillagerTrades.ItemListing>> map = cachedTrades.get(WANDERING_TRADER_PROFESSION_ID);
        if (map != null && map.containsKey(rarity.getId())) {
            List<VillagerTrades.ItemListing> itemsList = map.get(rarity.getId());
            return Optional.of(itemsList.toArray(new VillagerTrades.ItemListing[0]));
        }
        else {
            return Optional.empty();
        }
    }

    public Optional<VillagerTrades.ItemListing[]> getNumismatistOffers(MerchantLevel rarity) {
        Int2ObjectMap<List<VillagerTrades.ItemListing>> map = cachedTrades.get(NUMISMATIST_PROFESSION_ID);
        if (map != null && map.containsKey(rarity.getId())) {
            List<VillagerTrades.ItemListing> itemsList = map.get(rarity.getId());
            return Optional.of(itemsList.toArray(new VillagerTrades.ItemListing[0]));
        }
        else {
            return Optional.empty();
        }
    }

    public Optional<VillagerTrades.ItemListing[]> getPiglinMerchantOffers(MerchantLevel rarity) {
        Int2ObjectMap<List<VillagerTrades.ItemListing>> map = cachedTrades.get(PIGLINMERCHANT_PROFESSION_ID);
        if (map != null && map.containsKey(rarity.getId())) {
            List<VillagerTrades.ItemListing> itemsList = map.get(rarity.getId());
            return Optional.of(itemsList.toArray(new VillagerTrades.ItemListing[0]));
        }
        else {
            return Optional.empty();
        }
    }

    public Optional<VillagerTrades.ItemListing[]> getOffersForGoblinTrader(MerchantLevel rarity) {
        Int2ObjectMap<List<VillagerTrades.ItemListing>> map = cachedTrades.get(GOBLIN_TRADER_ID);
        if (map != null && map.containsKey(rarity.getId())) {
            List<VillagerTrades.ItemListing> itemsList = map.get(rarity.getId());
            return Optional.of(itemsList.toArray(new VillagerTrades.ItemListing[0]));
        }
        else {
            return Optional.empty();
        }
    }

    public Optional<VillagerTrades.ItemListing[]> getOffersForVeinGoblinTrader(MerchantLevel rarity) {
        Int2ObjectMap<List<VillagerTrades.ItemListing>> map = cachedTrades.get(VEIN_GOBLIN_TRADER_ID);
        if (map != null && map.containsKey(rarity.getId())) {
            List<VillagerTrades.ItemListing> itemsList = map.get(rarity.getId());
            return Optional.of(itemsList.toArray(new VillagerTrades.ItemListing[0]));
        }
        else {
            return Optional.empty();
        }
    }

    public Optional<VillagerTrades.ItemListing[]> getOffersForRedMerchant(MerchantLevel rarity) {
        Int2ObjectMap<List<VillagerTrades.ItemListing>> map = cachedTrades.get(RED_MERCHANT_ID);
        if (map != null && map.containsKey(rarity.getId())) {
            List<VillagerTrades.ItemListing> itemsList = map.get(rarity.getId());
            return Optional.of(itemsList.toArray(new VillagerTrades.ItemListing[0]));
        }
        else {
            return Optional.empty();
        }
    }

    public ResourceLocation getId() {
        return ID;
    }

    public void onDataPackReload(@NotNull AddReloadListenerEvent event) {
        ReloadableServerResources serverResources = event.getServerResources();
        serverResources.listeners();
        event.addListener(this);
    }

    public void reload(@NotNull MinecraftServer server) {
        ResourceManager manager = server.getResourceManager();
        Map<ResourceLocation, JsonElement> tradesJson = this.prepare(manager, server.getProfiler());
        this.apply(tradesJson, manager, server.getProfiler());
        TC_LOGGER.info("Manually reloaded trade offers.");
    }

    public enum MerchantLevel implements StringRepresentable {
        NOVICE("novice", 1),
        APPRENTICE("apprentice", 2),
        JOURNEYMAN("journeyman", 3),
        EXPERT("expert", 4),
        MASTER("master", 5),
        COMMON("common", 1),
        RARE("rare", 2);

        public final String name;
        public final int id;

        MerchantLevel(String name, int id) {
            this.name = name;
            this.id = id;
        }

        public int getId() {
            return this.id;
        }

        public static DataResult<MerchantLevel> fromId(int id) {
            for (MerchantLevel value : values()) {
                if (value.id == id) {
                    return DataResult.success(value);
                }
            }

            return DataResult.error(() -> "Invalid level index " + id + " provided.");
        }

        @Override
        public @NotNull String getSerializedName() {
            return name;
        }

        @SuppressWarnings("unused")
        public static @NotNull MerchantLevel byName(String name) {
            for (MerchantLevel level : values()) {
                if (level.name.equals(name)) {
                    return level;
                }
            }
            throw new IllegalArgumentException("Invalid MerchantLevel name: " + name);
        }
    }

    public record CustomVillagerTrades(ResourceLocation profession, boolean replace,
                                       Map<Integer, List<VillagerTrades.ItemListing>> trades) {
        public static final Codec<CustomVillagerTrades> CUSTOM_VILLAGER_TRADES_CODEC = RecordCodecBuilder.create(instance -> instance.group(
                ResourceLocation.CODEC.fieldOf("profession").forGetter(CustomVillagerTrades::profession),
                Codec.BOOL.optionalFieldOf("replace", false).forGetter(CustomVillagerTrades::replace),
                Codec.unboundedMap(StringRepresentable.fromEnum(MerchantLevel::values).flatComapMap(MerchantLevel::getId, MerchantLevel::fromId),
                        TradeOfferFactoryType.TRADE_OFFER_FACTORY_REGISTRY_CODEC.listOf()
                ).fieldOf("offers").forGetter(CustomVillagerTrades::trades)
        ).apply(instance, CustomVillagerTrades::new));
    }

    public record CustomWanderingTraderTrades(ResourceLocation profession, boolean replace,
                                              Map<Integer, List<VillagerTrades.ItemListing>> trades) {
        public static final Codec<CustomWanderingTraderTrades> CUSTOM_WANDERING_TRADER_TRADES_CODEC = RecordCodecBuilder.create(instance -> instance.group(
                ResourceLocation.CODEC.fieldOf("profession").forGetter(CustomWanderingTraderTrades::profession),
                Codec.BOOL.optionalFieldOf("replace", false).forGetter(CustomWanderingTraderTrades::replace),
                Codec.unboundedMap(StringRepresentable.fromEnum(MerchantLevel::values).flatComapMap(MerchantLevel::getId, MerchantLevel::fromId),
                        TradeOfferFactoryType.TRADE_OFFER_FACTORY_REGISTRY_CODEC.listOf()
                ).fieldOf("offers").forGetter(CustomWanderingTraderTrades::trades)
        ).apply(instance, CustomWanderingTraderTrades::new));
    }
}