package com.github.warrentode.todecoins.entity.trades.trade_api;

import com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.DefaultMapCodec;
import com.mojang.datafixers.util.Either;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.npc.VillagerType;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Locale;
import java.util.Map;
import java.util.function.Function;

public class CodecHelper {
    /**
     * An ItemStack codec to allow both explicit creation or just an item id.
     */
    public static final Codec<ItemStack> SIMPLE_ITEM_STACK_CODEC = Codec.either(ItemStack.CODEC, ForgeRegistries.ITEMS.getCodec())
            .xmap(either -> either.map(Function.identity(), ItemStack::new), stack -> stack.hasTag() ? Either.left(stack) : Either.right(stack.getItem()));

    /**
     * Codec for Minecraft Component (chat messages).
     * Serializes to and from JSON strings.
     */
    public static final Codec<Component> COMPONENT_CODEC = Codec.STRING.comapFlatMap(
            json -> {
                try {
                    return DataResult.success(Component.Serializer.fromJson(json));
                }
                catch (Exception exception) {
                    return DataResult.error("Failed to parse Component from JSON: " + exception.getMessage());
                }
            },
            component -> {
                try {
                    return Component.Serializer.toJson(component);
                }
                catch (Exception exception) {
                    return "{}"; // fallback or better: DataResult.error if you want more strictness
                }
            }
    );

    /**
     * Create a codec for a villager type -> element map, also allows the 'default' key to use for undefined villager types.
     *
     * @param elementCodec a codec for the element of the map
     * @param <T>          the type of elements in the map
     * @return a codec for mapping VillagerType to elements of type T
     */
    public static <T> Codec<Map<VillagerType, T>> villagerTypeMap(Codec<T> elementCodec) {
        return DefaultMapCodec.of(Registry.VILLAGER_TYPE.byNameCodec(), elementCodec, Registry.VILLAGER_TYPE);
    }

    /**
     * Create a codec for the specified enum, will be case-insensitive.
     *
     * @param enumClass the class of the enum to use
     * @param <T>       the enum type
     * @return a codec for the enum class T
     */
    public static <T extends Enum<T>> Codec<T> forEnum(Class<T> enumClass) {
        return Codec.STRING.xmap(
                enumName -> Enum.valueOf(enumClass, enumName.toUpperCase(Locale.ROOT)),
                enumValue -> enumValue.name().toLowerCase(Locale.ROOT)
        );
    }
}