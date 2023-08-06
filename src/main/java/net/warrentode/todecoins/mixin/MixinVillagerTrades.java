package net.warrentode.todecoins.mixin;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.npc.*;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraft.world.level.Level;
import net.warrentode.todecoins.ModLogger;
import net.warrentode.todecoins.trades.CreateTradeList;
import net.warrentode.todecoins.trades.EntityTrades;
import net.warrentode.todecoins.trades.TradeLevel;
import net.warrentode.todecoins.trades.TradeManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.Map;

@Mixin({Villager.class})
public abstract class MixinVillagerTrades extends AbstractVillager {
    Villager trader;
    AbstractVillager abstractVillager;

    public MixinVillagerTrades(EntityType<? extends AbstractVillager> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Invoker("getVillagerData")
    public abstract VillagerData invokeGetVillagerData();
    @Inject(method = {"updateTrades()V"}, at = @At("HEAD"), cancellable = true)
    private void todecoins_injectedUpdateTrades(CallbackInfo ci) {
        VillagerData data = this.invokeGetVillagerData();
        VillagerProfession profession = data.getProfession();
        System.out.println("Update Trades Step");
        EntityTrades entityTrades = TradeManager.instance().getTrades(profession);
        if (entityTrades != null) {
            Map<TradeLevel, List<VillagerTrades.ItemListing>> tradeLevelListMap = entityTrades.tradeMap();
            MerchantOffers offers = CreateTradeList.getOffers();
            CreateTradeList.populateTradeData();
            ModLogger.info("populating Trade Data");
            ci.cancel();
        }
    }

    /**
     * @author Warren Tode
     * @reason should be okay since I'm using a check for the custom trade files and to go to the built in vanilla trades if not present
     */
    @Overwrite(aliases = "updateTrades()V")
    public void updateTrades() {
        System.out.println("Update Trades Step");
        VillagerData data = trader.getVillagerData();
        VillagerProfession profession = data.getProfession();
        EntityTrades entityTrades = TradeManager.instance().getTrades(profession);
        if (entityTrades != null) {
            MerchantOffers offers = CreateTradeList.getOffers();
            CreateTradeList.populateTradeData();
            ModLogger.info("populating Trade Data");
        }
        else {
            Int2ObjectMap<VillagerTrades.ItemListing[]> int2objectmap = VillagerTrades.TRADES.get(data.getProfession());
            if (int2objectmap != null && !int2objectmap.isEmpty()) {
                VillagerTrades.ItemListing[] avillagertrades$itemlisting = int2objectmap.get(data.getLevel());
                if (avillagertrades$itemlisting != null) {
                    MerchantOffers merchantoffers = abstractVillager.getOffers();
                    abstractVillager.addOffersFromItemListings(merchantoffers, avillagertrades$itemlisting, 2);
                }
            }
        }
    }
}