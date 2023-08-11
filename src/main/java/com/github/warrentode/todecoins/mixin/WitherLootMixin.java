package com.github.warrentode.todecoins.mixin;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Unique;

@Mixin(WitherBoss.class)
public abstract class WitherLootMixin extends LivingEntity {
    protected WitherLootMixin(EntityType<? extends LivingEntity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Unique
    protected void todeCoins_dropFromLootTable(DamageSource source, boolean hitByPlayer) {
        if (level.getServer() != null) {
            ItemEntity itementity = this.spawnAtLocation(Items.NETHER_STAR);
            ResourceLocation resourcelocation = this.getLootTable();
            LootTable lootTable = this.level.getServer().getLootTables().get(resourcelocation);
            LootContext.Builder lootcontext$builder = this.createLootContext(hitByPlayer, source);
            lootTable.getRandomItemsRaw(lootcontext$builder.create(LootContextParamSets.ENTITY), (stack) -> {
                ItemEntity itemEntity = new ItemEntity(this.level, this.getX(), this.getY(), this.getZ(), stack);
                itemEntity.setDefaultPickUpDelay();
                itemEntity.setExtendedLifetime();
                this.level.addFreshEntity(itemEntity);
            });
        }
    }

    /**
     * @author Warren Tode
     * @reason not sure how else to get this boss to drop from a custom loot table, but I'm still
     * making sure the nether star remains as a drop so it should be alright
     * having said this, I'm wondering if it's necessary to overwrite the custom drop
     * so far nothing else has worked with this drop method
     * in any case, I don't like it because it might break compatibility with other mods
     * AND oddly enough, only the nether star drops in the auto farm blocks of the Cagerium mod
     **/
    @Overwrite()
    public void dropCustomDeathLoot(@NotNull DamageSource source, int lootBonus, boolean allowDrops) {
    }
}