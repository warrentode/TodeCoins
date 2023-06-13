package net.warrentode.todecoins.datagen.tags;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.warrentode.todecoins.util.tags.CageriumTags;
import net.warrentode.todecoins.util.tags.ForgeTags;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class EntityTypeTagsGen extends EntityTypeTagsProvider {
    public EntityTypeTagsGen(DataGenerator pGenerator, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(pGenerator, modId, existingFileHelper);
    }


    @Override
    protected void addTags() {
        this.registerCageriumTags();
        this.registerForgeTags();
    }

    private void registerCageriumTags() {
        tag(CageriumTags.EntityTypes.BOSSES)
                .add(EntityType.WARDEN);
        tag(CageriumTags.EntityTypes.CAGERIUM_BLACKLIST);
    }

    private void registerForgeTags() {
        tag(ForgeTags.EntityTypes.ALLAY_TYPES)
                .add(EntityType.ALLAY);
        tag(ForgeTags.EntityTypes.AXOLOTL_TYPES)
                .add(EntityType.AXOLOTL);
        tag(ForgeTags.EntityTypes.BAT_TYPES)
                .add(EntityType.BAT);
        tag(ForgeTags.EntityTypes.BEE_TYPES)
                .add(EntityType.BEE);
        tag(ForgeTags.EntityTypes.CAT_TYPES)
                .add(EntityType.CAT);
        tag(ForgeTags.EntityTypes.CAMEL_TYPES)
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("minecraft:camel")))
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("ecologics:camel")));
        tag(ForgeTags.EntityTypes.ENDERMAN_TYPES)
                .add(EntityType.ENDERMAN);
        tag(ForgeTags.EntityTypes.OCELOT_TYPES)
                .add(EntityType.OCELOT);
        tag(ForgeTags.EntityTypes.PIGLIN_TYPES)
                .add(EntityType.PIGLIN);
    }
}