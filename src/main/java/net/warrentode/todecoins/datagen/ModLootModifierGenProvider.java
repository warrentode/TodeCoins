package net.warrentode.todecoins.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.warrentode.todecoins.item.ModItems;
import net.warrentode.todecoins.loot.conditions.BlockTagCondition;
import net.warrentode.todecoins.loot.modifiers.AddItemLootModifier;
import net.warrentode.todecoins.util.tags.ModTags;

public class ModLootModifierGenProvider extends GlobalLootModifierProvider {
    public ModLootModifierGenProvider(DataGenerator gen, String modid) {
        super(gen, modid);
    }

    @Override
    protected void start() {
        add("add_four_leaf_clover_drops", new AddItemLootModifier(
                new LootItemCondition[]{
                        BlockTagCondition.isTag(ModTags.Blocks.DROPS_FOUR_LEAF_CLOVER)
                },
                ModItems.FOUR_LEAF_CLOVER.get(), 0.01F
        ));
    }
}