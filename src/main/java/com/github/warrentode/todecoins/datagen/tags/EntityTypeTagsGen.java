package com.github.warrentode.todecoins.datagen.tags;

import com.github.warrentode.todecoins.entity.ModEntityTypes;
import com.github.warrentode.todecoins.util.tags.CageriumTags;
import com.github.warrentode.todecoins.util.tags.ForgeTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.common.data.ExistingFileHelper;
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
                .addTag(ForgeTags.EntityTypes.BOSSES);
        tag(CageriumTags.EntityTypes.CAGERIUM_BLACKLIST);
    }

    private void registerForgeTags() {
        tag(ForgeTags.EntityTypes.BOSSES)
                .add(EntityType.ENDER_DRAGON)
                .add(EntityType.ELDER_GUARDIAN)
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("friendsandfoes:wildfire")))
                .add(EntityType.WARDEN)
                .add(EntityType.WITHER);
        tag(ForgeTags.EntityTypes.ILLAGERS)
                .addTag(ForgeTags.EntityTypes.WITCH_TYPES)
                .addTag(ForgeTags.EntityTypes.VEX_TYPES)
                .addTag(ForgeTags.EntityTypes.RAVAGER_TYPES)
                .addTag(ForgeTags.EntityTypes.EVOKER_TYPES)
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("friendsandfoes:iceologer")))
                .addTag(ForgeTags.EntityTypes.ILLUSIONER_TYPES)
                .addTag(ForgeTags.EntityTypes.PILLAGER_TYPES)
                .addTag(ForgeTags.EntityTypes.RAVAGER_TYPES)
                .addTag(ForgeTags.EntityTypes.VINDICATOR_TYPES);
        tag(ForgeTags.EntityTypes.ZOMBIES)
                .addTag(ForgeTags.EntityTypes.ZOMBIE_TYPES)
                .addTag(ForgeTags.EntityTypes.ZOMBIE_VILLAGER_TYPES)
                .addTag(ForgeTags.EntityTypes.DROWNED_TYPES)
                .addTag(ForgeTags.EntityTypes.HUSK_TYPES)
                .addTag(ForgeTags.EntityTypes.ZOGLIN_TYPES);
        tag(ForgeTags.EntityTypes.DROPS_CURRENCY)
                .addTag(ForgeTags.EntityTypes.BOSSES)
                .addTag(ForgeTags.EntityTypes.BLAZE_TYPES)
                .addTag(ForgeTags.EntityTypes.CAVE_SPIDER_TYPES)
                .addTag(ForgeTags.EntityTypes.CREEPER_TYPES)
                .addTag(ForgeTags.EntityTypes.ELDER_GUARDIAN_TYPES)
                .addTag(ForgeTags.EntityTypes.DROWNED_TYPES)
                .addTag(ForgeTags.EntityTypes.ENDERMAN_TYPES)
                .addTag(ForgeTags.EntityTypes.ENDERMITES_TYPES)
                .addTag(ForgeTags.EntityTypes.EVOKER_TYPES)
                .addTag(ForgeTags.EntityTypes.GHAST_TYPES)
                .addTag(ForgeTags.EntityTypes.GUARDIAN_TYPES)
                .addTag(ForgeTags.EntityTypes.HUSK_TYPES)
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("friendsandfoes:iceologer")))
                .addTag(ForgeTags.EntityTypes.ILLUSIONER_TYPES)
                .addTag(ForgeTags.EntityTypes.MAGMA_CUBE_TYPES)
                .addTag(ForgeTags.EntityTypes.PHANTOM_TYPES)
                .addTag(ForgeTags.EntityTypes.PIGLIN_TYPES)
                .addTag(ForgeTags.EntityTypes.PILLAGER_TYPES)
                .addTag(ForgeTags.EntityTypes.RAVAGER_TYPES)
                .addTag(ForgeTags.EntityTypes.SHULKER_TYPES)
                .addTag(ForgeTags.EntityTypes.SILVERFISH_TYPES)
                .addTag(ForgeTags.EntityTypes.SKELETON_TYPES)
                .addTag(ForgeTags.EntityTypes.SLIME_TYPES)
                .addTag(ForgeTags.EntityTypes.SPIDER_TYPES)
                .addTag(ForgeTags.EntityTypes.STRAY_TYPES)
                .addTag(ForgeTags.EntityTypes.VEX_TYPES)
                .addTag(ForgeTags.EntityTypes.VINDICATOR_TYPES)
                .addTag(ForgeTags.EntityTypes.WITCH_TYPES)
                .addTag(ForgeTags.EntityTypes.WITHER_SKELETON_TYPES)
                .addTag(ForgeTags.EntityTypes.ZOGLIN_TYPES)
                .addTag(ForgeTags.EntityTypes.ZOMBIE_TYPES)
                .addTag(ForgeTags.EntityTypes.ZOMBIFIED_PIGLIN_TYPES)
                .addTag(ForgeTags.EntityTypes.HOGLIN_TYPES)
                .addTag(ForgeTags.EntityTypes.PIGLIN_BRUTE_TYPES);
        tag(ForgeTags.EntityTypes.ALLAY_TYPES)
                .add(EntityType.ALLAY);
        tag(ForgeTags.EntityTypes.AXOLOTL_TYPES)
                .add(EntityType.AXOLOTL);
        tag(ForgeTags.EntityTypes.BAT_TYPES)
                .add(EntityType.BAT);
        tag(ForgeTags.EntityTypes.BEE_TYPES)
                .add(EntityType.BEE);
        tag(ForgeTags.EntityTypes.BLAZE_TYPES)
                .add(EntityType.BLAZE);
        tag(ForgeTags.EntityTypes.CAMEL_TYPES)
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("minecraft:camel")))
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("ecologics:camel")));
        tag(ForgeTags.EntityTypes.CAT_TYPES)
                .add(EntityType.CAT);
        tag(ForgeTags.EntityTypes.CAVE_SPIDER_TYPES)
                .add(EntityType.CAVE_SPIDER);
        tag(ForgeTags.EntityTypes.CHICKEN_TYPES)
                .add(EntityType.CHICKEN);
        tag(ForgeTags.EntityTypes.COD_TYPES)
                .add(EntityType.COD);
        tag(ForgeTags.EntityTypes.COPPER_GOLEM_TYPES)
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("friendsandfoes:copper_golem")));
        tag(ForgeTags.EntityTypes.RASCAL_TYPES)
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("friendsandfoes:rascal")));
        tag(ForgeTags.EntityTypes.COW_TYPES)
                .add(EntityType.COW);
        tag(ForgeTags.EntityTypes.CRAB_TYPES)
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("ecologics:coconut_crab")));
        tag(ForgeTags.EntityTypes.CREEPER_TYPES)
                .add(EntityType.CREEPER);
        tag(ForgeTags.EntityTypes.DOLPHIN_TYPES)
                .add(EntityType.DOLPHIN);
        tag(ForgeTags.EntityTypes.DROWNED_TYPES)
                .add(EntityType.DROWNED);
        tag(ForgeTags.EntityTypes.ELDER_GUARDIAN_TYPES)
                .add(EntityType.ELDER_GUARDIAN);
        tag(ForgeTags.EntityTypes.ENDER_DRAGON_TYPES)
                .add(EntityType.ENDER_DRAGON);
        tag(ForgeTags.EntityTypes.ENDERMAN_TYPES)
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("unusualend:undead_enderling")))
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("unusualend:dragling")))
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("unusualend:endstone_trapper")))
                .add(EntityType.ENDERMAN);
        tag(ForgeTags.EntityTypes.ENDERMITES_TYPES)
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("unusualend:ender_blob")))
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("unusualend:ender_firefly")))
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("unusualend:bolok")))
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("phantasm:crystie")))
                .add(EntityType.ENDERMITE);
        tag(ForgeTags.EntityTypes.EVOKER_TYPES)
                .add(EntityType.EVOKER);
        tag(ForgeTags.EntityTypes.FOX_TYPES)
                .add(EntityType.FOX);
        tag(ForgeTags.EntityTypes.FROG_TYPES)
                .add(EntityType.FROG);
        tag(ForgeTags.EntityTypes.GHAST_TYPES)
                .add(EntityType.GHAST);
        tag(ForgeTags.EntityTypes.GLARE_TYPES)
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("friendsandfoes:glare")));
        tag(ForgeTags.EntityTypes.GLOW_SQUID_TYPES)
                .add(EntityType.GIANT);
        tag(ForgeTags.EntityTypes.GIANT_TYPES)
                .add(EntityType.GLOW_SQUID);
        tag(ForgeTags.EntityTypes.GOAT_TYPES)
                .add(EntityType.GOAT);
        tag(ForgeTags.EntityTypes.GUARD_TYPES)
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("guardvillagers:guard")));
        tag(ForgeTags.EntityTypes.GUARDIAN_TYPES)
                .add(EntityType.GUARDIAN);
        tag(ForgeTags.EntityTypes.HOGLIN_TYPES)
                .add(EntityType.HOGLIN);
        tag(ForgeTags.EntityTypes.HORSE_TYPES)
                .add(EntityType.HORSE);
        tag(ForgeTags.EntityTypes.HUSK_TYPES)
                .add(EntityType.HUSK);
        tag(ForgeTags.EntityTypes.ILLUSIONER_TYPES)
                .add(EntityType.ILLUSIONER);
        tag(ForgeTags.EntityTypes.IRON_GOLEM_TYPES)
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("unusualend:endstone_golem")))
                .add(EntityType.IRON_GOLEM);
        tag(ForgeTags.EntityTypes.LLAMA_TYPES)
                .add(EntityType.LLAMA);
        tag(ForgeTags.EntityTypes.MAGMA_CUBE_TYPES)
                .add(EntityType.MAGMA_CUBE);
        tag(ForgeTags.EntityTypes.MAULER_TYPES)
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("friendsandfoes:mauler")));
        tag(ForgeTags.EntityTypes.MULE_TYPES)
                .add(EntityType.MULE);
        tag(ForgeTags.EntityTypes.MOOBLOOM_TYPES)
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("friendsandfoes:moobloom")));
        tag(ForgeTags.EntityTypes.MOOSHROOM_TYPES)
                .add(EntityType.MOOSHROOM);
        tag(ForgeTags.EntityTypes.NUMISMATIST_TYPES)
                .add(ModEntityTypes.NUMISMATIST.get());
        tag(ForgeTags.EntityTypes.OCELOT_TYPES)
                .add(EntityType.OCELOT);
        tag(ForgeTags.EntityTypes.PANDA_TYPES)
                .add(EntityType.PANDA);
        tag(ForgeTags.EntityTypes.PARROT_TYPES)
                .add(EntityType.PARROT);
        tag(ForgeTags.EntityTypes.PENGUIN_TYPES)
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("ecologics:penguin")));
        tag(ForgeTags.EntityTypes.PHANTOM_TYPES)
                .add(EntityType.PHANTOM);
        tag(ForgeTags.EntityTypes.PIG_TYPES)
                .add(EntityType.PIG);
        tag(ForgeTags.EntityTypes.PIGLIN_TYPES)
                .add(EntityType.PIGLIN);
        tag(ForgeTags.EntityTypes.PIGLIN_BRUTE_TYPES)
                .add(EntityType.PIGLIN_BRUTE);
        tag(ForgeTags.EntityTypes.PIGLIN_MERCHANT_TYPES)
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("todepiglins:todepiglinmerchant")));
        tag(ForgeTags.EntityTypes.PILLAGER_TYPES)
                .add(EntityType.PILLAGER);
        tag(ForgeTags.EntityTypes.POLAR_BEAR_TYPES)
                .add(EntityType.POLAR_BEAR);
        tag(ForgeTags.EntityTypes.PUFFERFISH_TYPES)
                .add(EntityType.PUFFERFISH);
        tag(ForgeTags.EntityTypes.RABBIT_TYPES)
                .add(EntityType.RABBIT);
        tag(ForgeTags.EntityTypes.RAVAGER_TYPES)
                .add(EntityType.RAVAGER);
        tag(ForgeTags.EntityTypes.SALMON_TYPES)
                .add(EntityType.SALMON);
        tag(ForgeTags.EntityTypes.SHEEP_TYPES)
                .add(EntityType.SHEEP);
        tag(ForgeTags.EntityTypes.SHULKER_TYPES)
                .add(EntityType.SHULKER);
        tag(ForgeTags.EntityTypes.SILVERFISH_TYPES)
                .add(EntityType.SILVERFISH);
        tag(ForgeTags.EntityTypes.SKELETON_TYPES)
                .add(EntityType.SKELETON);
        tag(ForgeTags.EntityTypes.SKELETON_HORSE_TYPES)
                .add(EntityType.SKELETON_HORSE);
        tag(ForgeTags.EntityTypes.SLIME_TYPES)
                .add(EntityType.SLIME);
        tag(ForgeTags.EntityTypes.SNIFFER_TYPES)
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("minecraft:sniffer")));
        tag(ForgeTags.EntityTypes.ARMADILLO_TYPES)
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("minecraft:armadillo")));
        tag(ForgeTags.EntityTypes.SNOW_GOLEM_TYPES)
                .add(EntityType.SNOW_GOLEM);
        tag(ForgeTags.EntityTypes.SPIDER_TYPES)
                .add(EntityType.SPIDER);
        tag(ForgeTags.EntityTypes.SQUID_TYPES)
                .add(EntityType.SQUID);
        tag(ForgeTags.EntityTypes.SQUIRREL_TYPES)
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("ecologics:squirrel")));
        tag(ForgeTags.EntityTypes.STRAY_TYPES)
                .add(EntityType.STRAY);
        tag(ForgeTags.EntityTypes.STRIDER_TYPES)
                .add(EntityType.STRIDER);
        tag(ForgeTags.EntityTypes.TADPOLE_TYPES)
                .add(EntityType.TADPOLE);
        tag(ForgeTags.EntityTypes.TRADER_LLAMA_TYPES)
                .add(EntityType.TRADER_LLAMA);
        tag(ForgeTags.EntityTypes.TROPICAL_FISH_TYPES)
                .add(EntityType.TROPICAL_FISH);
        tag(ForgeTags.EntityTypes.TUFF_GOLEM_TYPES)
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("friendsandfoes:tuff_golem")));
        tag(ForgeTags.EntityTypes.TURTLE_TYPES)
                .add(EntityType.TURTLE);
        tag(ForgeTags.EntityTypes.VEX_TYPES)
                .add(EntityType.VEX);
        tag(ForgeTags.EntityTypes.VILLAGER_TYPES)
                .add(EntityType.VILLAGER);
        tag(ForgeTags.EntityTypes.VINDICATOR_TYPES)
                .add(EntityType.VINDICATOR);
        tag(ForgeTags.EntityTypes.WANDERING_TRADER_TYPES)
                .add(EntityType.WANDERING_TRADER);
        tag(ForgeTags.EntityTypes.WARDEN_TYPES)
                .add(EntityType.WARDEN);
        tag(ForgeTags.EntityTypes.WITCH_TYPES)
                .add(EntityType.WITCH);
        tag(ForgeTags.EntityTypes.WITHER_TYPES)
                .add(EntityType.WITHER);
        tag(ForgeTags.EntityTypes.WITHER_SKELETON_TYPES)
                .add(EntityType.WITHER_SKELETON);
        tag(ForgeTags.EntityTypes.WOLF_TYPES)
                .add(EntityType.WOLF);
        tag(ForgeTags.EntityTypes.ZOGLIN_TYPES)
                .add(EntityType.ZOGLIN);
        tag(ForgeTags.EntityTypes.ZOMBIE_TYPES)
                .add(EntityType.ZOMBIE);
        tag(ForgeTags.EntityTypes.ZOMBIE_HORSE_TYPES)
                .add(EntityType.ZOMBIE_HORSE);
        tag(ForgeTags.EntityTypes.ZOMBIFIED_PIGLIN_TYPES)
                .add(EntityType.ZOMBIFIED_PIGLIN);
        tag(ForgeTags.EntityTypes.ZOMBIE_VILLAGER_TYPES)
                .add(EntityType.ZOMBIE_VILLAGER);
    }
}