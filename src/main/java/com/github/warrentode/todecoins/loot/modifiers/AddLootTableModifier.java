package com.github.warrentode.todecoins.loot.modifiers;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;

import javax.annotation.Nonnull;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

/**
 * Credits to Commoble for this implementation!
 * Modified by WarrenTode to prevent recursion
 */
public class AddLootTableModifier extends LootModifier {
    public static final Supplier<Codec<AddLootTableModifier>> CODEC = Suppliers.memoize(() ->
            RecordCodecBuilder.create(inst -> codecStart(inst)
                    .and(ResourceLocation.CODEC.fieldOf("lootTable").forGetter(m -> m.lootTable))
                    .apply(inst, AddLootTableModifier::new)));

    private final ResourceLocation lootTable;
    private static final ThreadLocal<Set<ResourceLocation>> LOADING_TABLES = ThreadLocal.withInitial(HashSet::new);

    public AddLootTableModifier(LootItemCondition[] conditionsIn, ResourceLocation lootTable) {
        super(conditionsIn);
        this.lootTable = lootTable;
    }

    @Nonnull
    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        Set<ResourceLocation> loadingTables = LOADING_TABLES.get();

        // Skip if we are already injecting this table (prevents recursion)
        if (loadingTables.contains(this.lootTable)) {
            return generatedLoot;
        }

        loadingTables.add(this.lootTable);
        try {
            LootTable extraTable = context.getResolver().getLootTable(this.lootTable);
            extraTable.getRandomItems(context, generatedLoot::add);
        } finally {
            loadingTables.remove(this.lootTable);
        }

        return generatedLoot;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }
}