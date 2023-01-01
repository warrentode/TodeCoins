package net.warrentode.todecoins.item.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import static net.minecraft.world.effect.MobEffects.LUCK;

public class LuckyPennyItem extends Item {
    int duration;

    public LuckyPennyItem(Properties pProperties) {
        super(pProperties);
    }

    public void MobEffectInstance(MobEffect pEffect) {
        this.MobEffectInstance(LUCK);
        this.duration = 300;
        int amplifier = 1;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if(!pLevel.isClientSide() && pUsedHand == InteractionHand.MAIN_HAND) {
            pPlayer.addEffect(new MobEffectInstance(LUCK), pPlayer);
            pPlayer.getCooldowns().addCooldown(this, 600);
        }

        return super.use(pLevel, pPlayer, pUsedHand);
    }




}
