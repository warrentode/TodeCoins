package com.github.warrentode.todecoins.util.seasonal;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import org.jetbrains.annotations.NotNull;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SeasonalSounds {
    private static final List<SoundEvent> seasonalPool = new ArrayList<>();
    private static final Random random = new SecureRandom();

    public SeasonalSounds() {}

    public static void eventCheck() {
        seasonalPool.clear();

        if (CalendarUtil.check("ANNIVERSARY")) {
            seasonalPool.add(SoundEvents.PLAYER_LEVELUP);
            seasonalPool.add(SoundEvents.NOTE_BLOCK_CHIME.get());
            seasonalPool.add(SoundEvents.FIREWORK_ROCKET_TWINKLE);
        }
        else if (CalendarUtil.check("BIRTHDAY")) {
            seasonalPool.add(SoundEvents.PLAYER_LEVELUP);
            seasonalPool.add(SoundEvents.FIREWORK_ROCKET_BLAST);
            seasonalPool.add(SoundEvents.FIREWORK_ROCKET_TWINKLE);
        }
        else if (CalendarUtil.check("NEW_YEAR")) {
            seasonalPool.add(SoundEvents.FIREWORK_ROCKET_LAUNCH);
            seasonalPool.add(SoundEvents.FIREWORK_ROCKET_TWINKLE);
            seasonalPool.add(SoundEvents.FIREWORK_ROCKET_BLAST);
        }
        else if (CalendarUtil.check("EASTER")) {
            seasonalPool.add(SoundEvents.CHICKEN_AMBIENT);
            seasonalPool.add(SoundEvents.AMETHYST_BLOCK_RESONATE);
            seasonalPool.add(SoundEvents.NOTE_BLOCK_CHIME.get());
        }
        else if (CalendarUtil.check("HALLOWEEN")) {
            seasonalPool.add(SoundEvents.WITCH_CELEBRATE);
            seasonalPool.add(SoundEvents.BAT_LOOP);
            seasonalPool.add(SoundEvents.FOX_SCREECH);
        }
        else if (CalendarUtil.check("CHRISTMAS")) {
            seasonalPool.add(SoundEvents.AMETHYST_BLOCK_STEP);
            seasonalPool.add(SoundEvents.AMETHYST_CLUSTER_BREAK);
            seasonalPool.add(SoundEvents.NOTE_BLOCK_CHIME.get());
        }
        else if (CalendarUtil.check("SPRING")) {
            seasonalPool.add(SoundEvents.BEE_LOOP);
            seasonalPool.add(SoundEvents.FROG_AMBIENT);
            seasonalPool.add(SoundEvents.AMETHYST_BLOCK_RESONATE);
        }
        else if (CalendarUtil.check("SUMMER")) {
            seasonalPool.add(SoundEvents.PUFFER_FISH_BLOW_OUT);
            seasonalPool.add(SoundEvents.FIREWORK_ROCKET_LAUNCH);
            seasonalPool.add(SoundEvents.CAMPFIRE_CRACKLE);
        }
        else if (CalendarUtil.check("AUTUMN")) {
            seasonalPool.add(SoundEvents.BLASTFURNACE_FIRE_CRACKLE);
            seasonalPool.add(SoundEvents.ALLAY_AMBIENT_WITHOUT_ITEM);
            seasonalPool.add(SoundEvents.FIRE_AMBIENT);
        }
        else if (CalendarUtil.check("WINTER")) {
            seasonalPool.add(SoundEvents.ALLAY_AMBIENT_WITHOUT_ITEM);
            seasonalPool.add(SoundEvents.AMETHYST_CLUSTER_HIT);
            seasonalPool.add(SoundEvents.AMETHYST_CLUSTER_BREAK);
        }
        else {
            seasonalPool.add(SoundEvents.AMETHYST_BLOCK_STEP);
        }
    }

    // for the seasonal sound pool
    public static @NotNull List<SoundEvent> getSeasonalSounds(int count) {
        eventCheck(); // make sure the pool is updated

        int poolSize = seasonalPool.size();
        if (poolSize == 0) {
            return Collections.singletonList(SoundEvents.AMETHYST_BLOCK_STEP); // fallback sound
        }

        if (count >= poolSize) {
            // Return all sounds shuffled if count >= pool size
            List<SoundEvent> shuffled = new ArrayList<>(seasonalPool);
            Collections.shuffle(shuffled, random);
            return shuffled;
        }

        // Otherwise pick unique sounds randomly
        List<SoundEvent> copy = new ArrayList<>(seasonalPool);
        List<SoundEvent> selected = new ArrayList<>(count);

        for (int i = 0; i < count; i++) {
            int index = random.nextInt(copy.size());
            selected.add(copy.remove(index));
        }
        return selected;
    }
}