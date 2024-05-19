package com.github.warrentode.todecoins.datagen;

import com.github.warrentode.todecoins.sounds.ModSounds;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.SoundDefinitionsProvider;

public class SoundsFileGen extends SoundDefinitionsProvider {
    protected SoundsFileGen(DataGenerator generator, String modid, ExistingFileHelper helper) {
        super(generator, modid, helper);
    }

    private static final String modid = "minecraft";

    @Override
    public void registerSounds() {
        this.add(ModSounds.COINPRESS_USE, definition()
                .subtitle("subtitles.todecoins.coin_press_use")
                .with(sound(new ResourceLocation(modid, "random/anvil_use")).pitch(2))
        );
        this.add(ModSounds.COINPRESS_TAKE_RESULT, definition()
                .subtitle("subtitles.todecoins.coin_press_take")
                .with(sound(new ResourceLocation(modid, "block/chain/break1")).weight(3).pitch(1.5))
                .with(sound(new ResourceLocation(modid, "block/chain/break2")).weight(3).pitch(1.5))
                .with(sound(new ResourceLocation(modid, "block/chain/break3")).weight(3).pitch(1.5))
                .with(sound(new ResourceLocation(modid, "block/chain/break4")).weight(3).pitch(1.5))
                .with(sound(new ResourceLocation(modid, "note/icechime")).weight(3))
        );
        this.add(ModSounds.WORK_BANKER, definition()
                .subtitle("subtitles.todecoins.work_banker")
                .with(sound(new ResourceLocation(modid, "block/chain/break1")).weight(3).pitch(1.5))
                .with(sound(new ResourceLocation(modid, "block/chain/break2")).weight(3).pitch(1.5))
                .with(sound(new ResourceLocation(modid, "block/chain/break3")).weight(3).pitch(1.5))
                .with(sound(new ResourceLocation(modid, "block/chain/break4")).weight(3).pitch(1.5))
        );
        this.add(ModSounds.WORK_LEPRECHAUN, definition()
                .subtitle("subtitles.todecoins.work_leprechaun")
                .with(sound(new ResourceLocation(modid, "block/chain/break1")).weight(3).pitch(1.5))
                .with(sound(new ResourceLocation(modid, "block/chain/break2")).weight(3).pitch(1.5))
                .with(sound(new ResourceLocation(modid, "block/chain/break3")).weight(3).pitch(1.5))
                .with(sound(new ResourceLocation(modid, "block/chain/break4")).weight(3).pitch(1.5))
        );
        this.add(ModSounds.NUMISMATIST_DRINK_MILK, definition()
                .subtitle("subtitles.todecoins.numismatist_drink_milk")
                .with(sound(new ResourceLocation(modid, "mob/wandering_trader/drink_milk1")))
                .with(sound(new ResourceLocation(modid, "mob/wandering_trader/drink_milk2")))
                .with(sound(new ResourceLocation(modid, "mob/wandering_trader/drink_milk3")))
                .with(sound(new ResourceLocation(modid, "mob/wandering_trader/drink_milk4")))
                .with(sound(new ResourceLocation(modid, "mob/wandering_trader/drink_milk5")))
        );
        this.add(ModSounds.NUMISMATIST_DRINK_POTION, definition()
                .subtitle("subtitles.todecoins.numismatist_drink_potion")
                .with(sound(new ResourceLocation(modid, "mob/wandering_trader/drink_potion")))
        );
        this.add(ModSounds.NUMISMATIST_HAGGLE, definition()
                .subtitle("subtitles.todecoins.numismatist_haggle")
                .with(sound(new ResourceLocation(modid, "mob/wandering_trader/haggle1")))
                .with(sound(new ResourceLocation(modid, "mob/wandering_trader/haggle2")))
                .with(sound(new ResourceLocation(modid, "mob/wandering_trader/haggle3")))
        );
        this.add(ModSounds.NUMISMATIST_NO, definition()
                .subtitle("subtitles.todecoins.numismatist_no")
                .with(sound(new ResourceLocation(modid, "mob/wandering_trader/no1")))
                .with(sound(new ResourceLocation(modid, "mob/wandering_trader/no2")))
                .with(sound(new ResourceLocation(modid, "mob/wandering_trader/no3")))
                .with(sound(new ResourceLocation(modid, "mob/wandering_trader/no4")))
                .with(sound(new ResourceLocation(modid, "mob/wandering_trader/no5")))
        );
        this.add(ModSounds.NUMISMATIST_YES, definition()
                .subtitle("subtitles.todecoins.numismatist_yes")
                .with(sound(new ResourceLocation(modid, "mob/wandering_trader/yes1")))
                .with(sound(new ResourceLocation(modid, "mob/wandering_trader/yes2")))
                .with(sound(new ResourceLocation(modid, "mob/wandering_trader/yes3")))
                .with(sound(new ResourceLocation(modid, "mob/wandering_trader/yes4")))
        );
        this.add(ModSounds.NUMISMATIST_IDLE, definition()
                .subtitle("subtitles.todecoins.numismatist_haggle")
                .with(sound(new ResourceLocation(modid, "mob/wandering_trader/idle1")))
                .with(sound(new ResourceLocation(modid, "mob/wandering_trader/idle2")))
                .with(sound(new ResourceLocation(modid, "mob/wandering_trader/idle3")))
                .with(sound(new ResourceLocation(modid, "mob/wandering_trader/idle4")))
                .with(sound(new ResourceLocation(modid, "mob/wandering_trader/idle5")))
        );
        this.add(ModSounds.NUMISMATIST_HURT, definition()
                .subtitle("subtitles.todecoins.numismatist_hurt")
                .with(sound(new ResourceLocation(modid, "mob/wandering_trader/hurt1")))
                .with(sound(new ResourceLocation(modid, "mob/wandering_trader/hurt2")))
                .with(sound(new ResourceLocation(modid, "mob/wandering_trader/hurt3")))
                .with(sound(new ResourceLocation(modid, "mob/wandering_trader/hurt4")))
        );
        this.add(ModSounds.NUMISMATIST_DEATH, definition()
                .subtitle("subtitles.todecoins.numismatist_death")
                .with(sound(new ResourceLocation(modid, "mob/wandering_trader/death")))
        );
        this.add(ModSounds.NUMISMATIST_APPEARED, definition()
                .subtitle("subtitles.todecoins.numismatist_appeared")
                .with(sound(new ResourceLocation(modid, "mob/wandering_trader/appeared1")))
                .with(sound(new ResourceLocation(modid, "mob/wandering_trader/appeared2")))
                .with(sound(new ResourceLocation(modid, "mob/wandering_trader/reappeared1")))
                .with(sound(new ResourceLocation(modid, "mob/wandering_trader/reappeared2")))
        );
        this.add(ModSounds.NUMISMATIST_DISAPPEARED, definition()
                .subtitle("subtitles.todecoins.numismatist_disappeared")
                .with(sound(new ResourceLocation(modid, "mob/wandering_trader/disappeared1")))
                .with(sound(new ResourceLocation(modid, "mob/wandering_trader/disappeared2")))
        );
    }
}