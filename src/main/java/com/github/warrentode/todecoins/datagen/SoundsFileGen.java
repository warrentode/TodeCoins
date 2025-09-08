package com.github.warrentode.todecoins.datagen;

import com.github.warrentode.todecoins.sounds.TCSounds;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.SoundDefinitionsProvider;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

public class SoundsFileGen extends SoundDefinitionsProvider {
    @SuppressWarnings("SameParameterValue")
    protected SoundsFileGen(final PackOutput output, final String modid, final ExistingFileHelper helper) {
        super(output, modid, helper);
    }

    private static final String modid = "minecraft";

    @SuppressWarnings("removal")
    @Override
    public void registerSounds() {
        this.add(TCSounds.COINPRESS_USE, definition()
                .subtitle("subtitles." + MODID + ".coin_press_use")
                .with(sound(new ResourceLocation(modid, "random/anvil_use")).pitch(2))
        );
        this.add(TCSounds.COINPRESS_TAKE_RESULT, definition()
                .subtitle("subtitles." + MODID + ".coin_press_take")
                .with(sound(new ResourceLocation(modid, "block/chain/break1")).weight(3).pitch(1.5))
                .with(sound(new ResourceLocation(modid, "block/chain/break2")).weight(3).pitch(1.5))
                .with(sound(new ResourceLocation(modid, "block/chain/break3")).weight(3).pitch(1.5))
                .with(sound(new ResourceLocation(modid, "block/chain/break4")).weight(3).pitch(1.5))
                .with(sound(new ResourceLocation(modid, "note/icechime")).weight(3))
        );
        this.add(TCSounds.WORK_BANKER, definition()
                .subtitle("subtitles." + MODID + ".work_banker")
                .with(sound(new ResourceLocation(modid, "block/chain/break1")).weight(3).pitch(1.5))
                .with(sound(new ResourceLocation(modid, "block/chain/break2")).weight(3).pitch(1.5))
                .with(sound(new ResourceLocation(modid, "block/chain/break3")).weight(3).pitch(1.5))
                .with(sound(new ResourceLocation(modid, "block/chain/break4")).weight(3).pitch(1.5))
        );
        this.add(TCSounds.WORK_LEPRECHAUN, definition()
                .subtitle("subtitles." + MODID + ".work_leprechaun")
                .with(sound(new ResourceLocation(modid, "block/chain/break1")).weight(3).pitch(1.5))
                .with(sound(new ResourceLocation(modid, "block/chain/break2")).weight(3).pitch(1.5))
                .with(sound(new ResourceLocation(modid, "block/chain/break3")).weight(3).pitch(1.5))
                .with(sound(new ResourceLocation(modid, "block/chain/break4")).weight(3).pitch(1.5))
        );
        this.add(TCSounds.NUMISMATIST_DRINK_MILK, definition()
                .subtitle("subtitles." + MODID + ".numismatist_drink_milk")
                .with(sound(new ResourceLocation(modid, "mob/wandering_trader/drink_milk1")))
                .with(sound(new ResourceLocation(modid, "mob/wandering_trader/drink_milk2")))
                .with(sound(new ResourceLocation(modid, "mob/wandering_trader/drink_milk3")))
                .with(sound(new ResourceLocation(modid, "mob/wandering_trader/drink_milk4")))
                .with(sound(new ResourceLocation(modid, "mob/wandering_trader/drink_milk5")))
        );
        this.add(TCSounds.NUMISMATIST_DRINK_POTION, definition()
                .subtitle("subtitles." + MODID + ".numismatist_drink_potion")
                .with(sound(new ResourceLocation(modid, "mob/wandering_trader/drink_potion")))
        );
        this.add(TCSounds.NUMISMATIST_HAGGLE, definition()
                .subtitle("subtitles." + MODID + ".numismatist_haggle")
                .with(sound(new ResourceLocation(modid, "mob/wandering_trader/haggle1")))
                .with(sound(new ResourceLocation(modid, "mob/wandering_trader/haggle2")))
                .with(sound(new ResourceLocation(modid, "mob/wandering_trader/haggle3")))
        );
        this.add(TCSounds.NUMISMATIST_NO, definition()
                .subtitle("subtitles." + MODID + ".numismatist_no")
                .with(sound(new ResourceLocation(modid, "mob/wandering_trader/no1")))
                .with(sound(new ResourceLocation(modid, "mob/wandering_trader/no2")))
                .with(sound(new ResourceLocation(modid, "mob/wandering_trader/no3")))
                .with(sound(new ResourceLocation(modid, "mob/wandering_trader/no4")))
                .with(sound(new ResourceLocation(modid, "mob/wandering_trader/no5")))
        );
        this.add(TCSounds.NUMISMATIST_YES, definition()
                .subtitle("subtitles." + MODID + ".numismatist_yes")
                .with(sound(new ResourceLocation(modid, "mob/wandering_trader/yes1")))
                .with(sound(new ResourceLocation(modid, "mob/wandering_trader/yes2")))
                .with(sound(new ResourceLocation(modid, "mob/wandering_trader/yes3")))
                .with(sound(new ResourceLocation(modid, "mob/wandering_trader/yes4")))
        );
        this.add(TCSounds.NUMISMATIST_IDLE, definition()
                .subtitle("subtitles." + MODID + ".numismatist_haggle")
                .with(sound(new ResourceLocation(modid, "mob/wandering_trader/idle1")))
                .with(sound(new ResourceLocation(modid, "mob/wandering_trader/idle2")))
                .with(sound(new ResourceLocation(modid, "mob/wandering_trader/idle3")))
                .with(sound(new ResourceLocation(modid, "mob/wandering_trader/idle4")))
                .with(sound(new ResourceLocation(modid, "mob/wandering_trader/idle5")))
        );
        this.add(TCSounds.NUMISMATIST_HURT, definition()
                .subtitle("subtitles." + MODID + ".numismatist_hurt")
                .with(sound(new ResourceLocation(modid, "mob/wandering_trader/hurt1")))
                .with(sound(new ResourceLocation(modid, "mob/wandering_trader/hurt2")))
                .with(sound(new ResourceLocation(modid, "mob/wandering_trader/hurt3")))
                .with(sound(new ResourceLocation(modid, "mob/wandering_trader/hurt4")))
        );
        this.add(TCSounds.NUMISMATIST_DEATH, definition()
                .subtitle("subtitles." + MODID + ".numismatist_death")
                .with(sound(new ResourceLocation(modid, "mob/wandering_trader/death")))
        );
        this.add(TCSounds.NUMISMATIST_APPEARED, definition()
                .subtitle("subtitles." + MODID + ".numismatist_appeared")
                .with(sound(new ResourceLocation(modid, "mob/wandering_trader/appeared1")))
                .with(sound(new ResourceLocation(modid, "mob/wandering_trader/appeared2")))
                .with(sound(new ResourceLocation(modid, "mob/wandering_trader/reappeared1")))
                .with(sound(new ResourceLocation(modid, "mob/wandering_trader/reappeared2")))
        );
        this.add(TCSounds.NUMISMATIST_DISAPPEARED, definition()
                .subtitle("subtitles." + MODID + ".numismatist_disappeared")
                .with(sound(new ResourceLocation(modid, "mob/wandering_trader/disappeared1")))
                .with(sound(new ResourceLocation(modid, "mob/wandering_trader/disappeared2")))
        );

        this.add(TCSounds.PIGLINMERCHANT_HURT, definition()
                .subtitle("subtitles." + MODID + ".piglinmerchant_hurt")
                .with(sound(new ResourceLocation(modid, "mob/piglin/hurt1")).weight(3))
                .with(sound(new ResourceLocation(modid, "mob/piglin/hurt2")).weight(3))
                .with(sound(new ResourceLocation(modid, "mob/piglin/hurt3")).weight(3))
        );
        this.add(TCSounds.PIGLINMERCHANT_DEATH, definition()
                .subtitle("subtitles." + MODID + ".piglinmerchant_death")
                .with(sound(new ResourceLocation(modid, "mob/piglin/death1")).weight(3))
                .with(sound(new ResourceLocation(modid, "mob/piglin/death2")).weight(3))
                .with(sound(new ResourceLocation(modid, "mob/piglin/death3")).weight(3))
                .with(sound(new ResourceLocation(modid, "mob/piglin/death4")).weight(3))
        );
        this.add(TCSounds.PIGLINMERCHANT_AMBIENT.getId(), definition()
                .subtitle("subtitles." + MODID + ".piglinmerchant_ambient")
                .with(sound(new ResourceLocation(modid, "mob/piglin/idle1")).weight(3))
                .with(sound(new ResourceLocation(modid, "mob/piglin/idle2")).weight(3))
                .with(sound(new ResourceLocation(modid, "mob/piglin/idle3")).weight(3))
                .with(sound(new ResourceLocation(modid, "mob/piglin/idle4")).weight(3))
                .with(sound(new ResourceLocation(modid, "mob/piglin/idle5")).weight(3))
        );
        this.add(TCSounds.PIGLINMERCHANT_STEP, definition()
                .subtitle("subtitles." + MODID + ".piglinmerchant_step")
                .with(sound(new ResourceLocation(modid, "mob/piglin/step1")).weight(3))
                .with(sound(new ResourceLocation(modid, "mob/piglin/step2")).weight(3))
                .with(sound(new ResourceLocation(modid, "mob/piglin/step3")).weight(3))
                .with(sound(new ResourceLocation(modid, "mob/piglin/step4")).weight(3))
                .with(sound(new ResourceLocation(modid, "mob/piglin/step5")).weight(3))
        );
        this.add(TCSounds.PIGLINMERCHANT_RETREAT, definition()
                .subtitle("subtitles." + MODID + ".piglinmerchant_retreat")
                .with(sound(new ResourceLocation(modid, "mob/piglin/retreat1")).weight(3))
                .with(sound(new ResourceLocation(modid, "mob/piglin/retreat2")).weight(3))
                .with(sound(new ResourceLocation(modid, "mob/piglin/retreat3")).weight(3))
                .with(sound(new ResourceLocation(modid, "mob/piglin/retreat4")).weight(3))
        );
        this.add(TCSounds.PIGLINMERCHANT_JEALOUS, definition()
                .subtitle("subtitles." + MODID + ".piglinmerchant_jealous")
                .with(sound(new ResourceLocation(modid, "mob/piglin/jealous1")).weight(3))
                .with(sound(new ResourceLocation(modid, "mob/piglin/jealous2")).weight(3))
                .with(sound(new ResourceLocation(modid, "mob/piglin/jealous3")).weight(3))
                .with(sound(new ResourceLocation(modid, "mob/piglin/jealous4")).weight(3))
        );
        this.add(TCSounds.PIGLINMERCHANT_CELEBRATE, definition()
                .subtitle("subtitles." + MODID + ".piglinmerchant_celebrate")
                .with(sound(new ResourceLocation(modid, "mob/piglin/celebrate1")).weight(3))
                .with(sound(new ResourceLocation(modid, "mob/piglin/celebrate2")).weight(3))
                .with(sound(new ResourceLocation(modid, "mob/piglin/celebrate3")).weight(3))
                .with(sound(new ResourceLocation(modid, "mob/piglin/celebrate4")).weight(3))
        );
        this.add(TCSounds.PIGLINMERCHANT_ANGER, definition()
                .subtitle("subtitles." + MODID + ".piglinmerchant_anger")
                .with(sound(new ResourceLocation(modid, "mob/piglin/angry1")).weight(3))
                .with(sound(new ResourceLocation(modid, "mob/piglin/angry2")).weight(3))
                .with(sound(new ResourceLocation(modid, "mob/piglin/angry3")).weight(3))
                .with(sound(new ResourceLocation(modid, "mob/piglin/angry4")).weight(3))
        );
        this.add(TCSounds.PIGLINMERCHANT_EXAMINE, definition()
                .subtitle("subtitles." + MODID + ".piglinmerchant_examine")
                .with(sound(new ResourceLocation(modid, "mob/piglin/admire1")).weight(3))
                .with(sound(new ResourceLocation(modid, "mob/piglin/admire2")).weight(3))
        );
    }
}