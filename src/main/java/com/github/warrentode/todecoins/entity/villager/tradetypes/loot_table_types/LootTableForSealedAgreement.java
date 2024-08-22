package com.github.warrentode.todecoins.entity.villager.tradetypes.loot_table_types;

import io.github.mortuusars.wares.Wares;
import io.github.mortuusars.wares.data.agreement.SealedDeliveryAgreement;
import io.github.mortuusars.wares.data.agreement.component.TextProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class LootTableForSealedAgreement implements VillagerTrades.ItemListing {
    private final int maxUses;
    private final int xpValue;
    private final float priceMultiplier;
    private final ResourceLocation requestTable;
    private final ResourceLocation agreementPriceTable;
    private final ResourceLocation agreementOfferTable;
    private final String agreementID;
    private final TextProvider title;
    private final Component backsideMessage;
    private final TextProvider buyerName;
    private final TextProvider buyerAddress;
    private final TextProvider buyerMessage;
    private final String seal;
    private final Component sealTooltip;
    private final int orderCount;
    private final int orderXP;

    public LootTableForSealedAgreement(ResourceLocation requestTable, ResourceLocation agreementPriceTable,
                                       ResourceLocation agreementOfferTable, String agreementID,
                                       TextProvider title, Component backsideMessage,
                                       TextProvider buyerName, TextProvider buyerAddress,
                                       TextProvider buyerMessage, String seal, Component sealTooltip,
                                       int orderCount, int orderXP, int maxUses, int xpValue, float priceMultiplier) {
        this.requestTable = requestTable;
        this.agreementPriceTable = agreementPriceTable;
        this.agreementOfferTable = agreementOfferTable;
        this.agreementID = agreementID;
        this.title = title;
        this.backsideMessage = backsideMessage;
        this.buyerName = buyerName;
        this.buyerAddress = buyerAddress;
        this.buyerMessage = buyerMessage;
        this.orderCount = orderCount;
        this.seal = seal;
        this.sealTooltip = sealTooltip;
        this.orderXP = orderXP;
        this.maxUses = maxUses;
        this.xpValue = xpValue;
        this.priceMultiplier = priceMultiplier;
    }

    @Nullable
    @Override
    public MerchantOffer getOffer(@NotNull Entity trader, @NotNull RandomSource source) {
        if (!(trader.level instanceof ServerLevel)) {
            return null;
        }
        else {
            MinecraftServer minecraftServer = trader.level.getServer();
            LootTable requestedTable = minecraftServer.getLootTables().get(requestTable);

            LootContext lootContext = new LootContext.Builder(minecraftServer.createCommandSourceStack().getLevel())
                    .withParameter(LootContextParams.ORIGIN, trader.position())
                    .withParameter(LootContextParams.THIS_ENTITY, trader)
                    .withRandom(trader.level.random).create(LootContextParamSets.GIFT);

            List<ItemStack> requested = requestedTable.getRandomItems(lootContext);

            ItemStack requestStack = new ItemStack(
                    requested.get(source.nextInt(requested.size())).getItem(),
                    requested.get(source.nextInt(requested.size())).getCount());

            ItemStack sealedAgreement = new ItemStack(Wares.Items.SEALED_DELIVERY_AGREEMENT.get());
            new SealedDeliveryAgreement.Builder()
                    .requested(ResourceLocation.tryParse(this.agreementPriceTable.toString()))
                    .payment(ResourceLocation.tryParse(this.agreementOfferTable.toString()))
                    .title(this.title)
                    .backsideMessage(this.backsideMessage)
                    .buyerName(this.buyerName)
                    .buyerAddress(this.buyerAddress)
                    .message(this.buyerMessage)
                    .seal(this.seal)
                    .sealTooltip(this.sealTooltip)
                    .ordered(this.orderCount)
                    .experience(this.orderXP)
                    .id(this.agreementID)
                    .build().toItemStack(sealedAgreement);

            return new MerchantOffer(requestStack, sealedAgreement, this.maxUses, this.xpValue, this.priceMultiplier);
        }
    }
}