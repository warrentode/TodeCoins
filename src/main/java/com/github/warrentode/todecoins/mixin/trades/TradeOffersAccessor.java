package com.github.warrentode.todecoins.mixin.trades;

import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.npc.VillagerType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.saveddata.maps.MapDecoration;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Map;

@Mixin(VillagerTrades.class)
public interface TradeOffersAccessor {
    @Mixin(VillagerTrades.EmeraldForItems.class)
    interface EmeraldForItemsAccessor {
        @Accessor("item")
        Item getBuy();

        @Accessor("cost")
        int getPrice();

        @Accessor("maxUses")
        int getMaxUses();

        @Accessor("villagerXp")
        int getExperience();
    }

    @Mixin(VillagerTrades.ItemsForEmeralds.class)
    interface ItemsForEmeraldsAccessor {
        @Accessor("itemStack")
        ItemStack getSell();

        @Accessor("emeraldCost")
        int getPrice();

        @Accessor("numberOfItems")
        int getCount();

        @Accessor("maxUses")
        int getMaxUses();

        @Accessor("villagerXp")
        int getExperience();
    }

    @Mixin(VillagerTrades.SuspiciousStewForEmerald.class)
    interface SuspiciousStewForEmeraldAccessor {
        @Accessor("effect")
        MobEffect getEffect();

        @Accessor("duration")
        int getDuration();

        @Accessor("xp")
        int getExperience();
    }

    @Mixin(VillagerTrades.ItemsAndEmeraldsToItems.class)
    interface ItemsAndEmeraldsToItemsAccessor {
        @Accessor("fromItem")
        ItemStack getSecondBuy();

        @Accessor("fromCount")
        int getSecondCount();

        @Accessor("emeraldCost")
        int getPrice();

        @Accessor("toItem")
        ItemStack getSell();

        @Accessor("toCount")
        int getSellCount();

        @Accessor("maxUses")
        int getMaxUses();

        @Accessor("villagerXp")
        int getExperience();
    }

    @Mixin(VillagerTrades.EnchantedItemForEmeralds.class)
    interface EnchantedItemForEmeraldsAccessor {
        @Accessor("itemStack")
        ItemStack getEnchantedItem();

        @Accessor("baseEmeraldCost")
        int getBasePrice();

        @Accessor("maxUses")
        int getMaxUses();

        @Accessor("villagerXp")
        int getExperience();

        @Accessor("priceMultiplier")
        float getMultiplier();
    }

    @Mixin(VillagerTrades.EmeraldsForVillagerTypeItem.class)
    interface EmeraldsForVillagerTypeItemAccessor {
        @Accessor("trades")
        Map<VillagerType, Item> getMap();

        @Accessor("cost")
        int getCount();

        @Accessor("maxUses")
        int getMaxUses();

        @Accessor("villagerXp")
        int getExperience();
    }

    @Mixin(VillagerTrades.TippedArrowForItemsAndEmeralds.class)
    interface TippedArrowForItemsAndEmeraldsAccessor {
        @Accessor("toItem")
        ItemStack getSell();

        @Accessor("toCount")
        int getSellCount();

        @Accessor("emeraldCost")
        int getPrice();

        @Accessor("maxUses")
        int getMaxUses();

        @Accessor("villagerXp")
        int getExperience();

        @Accessor("fromItem")
        Item getSecondBuy();

        @Accessor("fromCount")
        int getSecondCount();
    }

    @Mixin(VillagerTrades.EnchantBookForEmeralds.class)
    interface EnchantBookForEmeraldsAccessor {
        @Accessor("villagerXp")
        int getExperience();
    }

    @Mixin(VillagerTrades.TreasureMapForEmeralds.class)
    interface TreasureMapForEmeraldsAccessor {
        @Accessor("emeraldCost")
        int getPrice();

        @Accessor("destination")
        TagKey<Structure> getStructure();

        @Accessor("displayName")
        String getNameKey();

        @Accessor("destinationType")
        MapDecoration.Type getIconType();

        @Accessor("maxUses")
        int getMaxUses();

        @Accessor("villagerXp")
        int getExperience();
    }

    @Mixin(VillagerTrades.DyedArmorForEmeralds.class)
    interface DyedArmorForEmeraldsAccessor {
        @Accessor("item")
        Item getSell();

        @Accessor("value")
        int getPrice();

        @Accessor("maxUses")
        int getMaxUses();

        @Accessor("villagerXp")
        int getExperience();
    }
}