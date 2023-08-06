package com.github.warrentode.util.tags;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

public class CageriumTags {
    public static class EntityTypes {
        public static final TagKey<EntityType<?>> BOSSES = cageriumEntityTypeTag("bosses");
        public static final TagKey<EntityType<?>> CAGERIUM_BLACKLIST = cageriumEntityTypeTag("cagerium_blacklist");
    }

    private static TagKey<EntityType<?>> cageriumEntityTypeTag(String path) {
        return TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation("cagerium", path));
    }
}