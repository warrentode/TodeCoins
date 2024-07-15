package com.github.warrentode.todecoins.event;

import com.github.warrentode.todecoins.TodeCoins;
import com.github.warrentode.todecoins.attribute.*;
import com.github.warrentode.todecoins.commands.VillagerTradeCommands;
import com.github.warrentode.todecoins.effect.*;
import com.github.warrentode.todecoins.entity.ModEntityTypes;
import com.github.warrentode.todecoins.entity.ai.goal.AvoidPlayerCatCoinGoal;
import com.github.warrentode.todecoins.entity.spawners.numismatist.NumismatistSpawner;
import com.github.warrentode.todecoins.item.ModItems;
import com.github.warrentode.todecoins.item.custom.bracelet.FriendshipBraceletItem;
import com.github.warrentode.todecoins.util.PlayerUtil;
import com.github.warrentode.todecoins.util.tags.ModTags;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.PatrollingMonster;
import net.minecraft.world.entity.monster.Phantom;
import net.minecraft.world.entity.monster.Vex;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.living.LivingChangeTargetEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.event.server.ServerStoppedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

public class ModEvents {
    @Mod.EventBusSubscriber(modid = TodeCoins.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEventBusEvents {
        @SubscribeEvent
        public static void onEntityAttributeEvent(@NotNull EntityAttributeCreationEvent event) {
            event.put(ModEntityTypes.NUMISMATIST.get(), Mob.createMobAttributes().build());
        }
    }

    @Mod.EventBusSubscriber(modid = TodeCoins.MODID)
    public static class ForgeEvents {
        @SubscribeEvent
        public static void registerCommands(@NotNull RegisterCommandsEvent event) {
            VillagerTradeCommands.register(event.getDispatcher());
        }
        @SubscribeEvent
        public static void onItemCrafted(@NotNull PlayerEvent.ItemCraftedEvent event) {
            ItemStack stack = event.getCrafting();
            Player player = event.getEntity();
            if (stack.is(ModTags.Items.NO_AI_EGGS)) {
                final CompoundTag entityTag = stack.getOrCreateTagElement("EntityTag");
                entityTag.putBoolean("NoAI", true);
            }
            if (stack.getItem() instanceof FriendshipBraceletItem) {
                final CompoundTag itemTag = stack.getOrCreateTag();
                itemTag.putString(PlayerUtil.BRACELET_MAKER_TAG, player.getGameProfile().getName());
            }
        }

        @Contract("_ -> param1")
        @SubscribeEvent
        public static @NotNull ItemTooltipEvent onItemTooltip(@NotNull ItemTooltipEvent event) {
            ItemStack stack = event.getItemStack();
            Player player = event.getEntity();
            List<Component> tooltip = event.getToolTip();

            if (stack.is(ModItems.CRIMSON_SPORE_CHOCOLATE_COIN.get())) {
                tooltip.add(Component.translatable("tooltips." + ModItems.CRIMSON_SPORE_CHOCOLATE_COIN.get() + "_effects")
                        .withStyle(ChatFormatting.DARK_BLUE));
            }
            if (stack.is(ModItems.WARPED_SPICE_CHOCOLATE_COIN.get())) {
                tooltip.add(Component.translatable("tooltips." + ModItems.WARPED_SPICE_CHOCOLATE_COIN.get() + "_effects")
                        .withStyle(ChatFormatting.DARK_BLUE));
            }
            if (stack.is(ModItems.MILK_BONE_CHOCOLATE_COIN.get())) {
                tooltip.add(Component.translatable("tooltips." + ModItems.MILK_BONE_CHOCOLATE_COIN.get() + "_effects")
                        .withStyle(ChatFormatting.DARK_BLUE));
            }
            if (stack.is(ModItems.ULTIMATE_DARK_CHOCOLATE_COIN.get())) {
                tooltip.add(Component.translatable("tooltips." + ModItems.ULTIMATE_DARK_CHOCOLATE_COIN.get() + "_effects")
                        .withStyle(ChatFormatting.DARK_BLUE));
            }
            if (stack.is(ModItems.BUBBLY_BERRY_CHOCOLATE_COIN.get())) {
                tooltip.add(Component.translatable("tooltips." + ModItems.BUBBLY_BERRY_CHOCOLATE_COIN.get() + "_effects")
                        .withStyle(ChatFormatting.DARK_BLUE));
            }
            if (stack.is(ModItems.VELVETY_CLOVER_CHOCOLATE_COIN.get())) {
                tooltip.add(Component.translatable("tooltips." + ModItems.VELVETY_CLOVER_CHOCOLATE_COIN.get() + "_effects")
                        .withStyle(ChatFormatting.DARK_BLUE));
            }
            if (stack.is(ModItems.FESTIVE_FUDGE_CHOCOLATE_COIN.get())) {
                tooltip.add(Component.translatable("tooltips." + ModItems.FESTIVE_FUDGE_CHOCOLATE_COIN.get() + "_effects")
                        .withStyle(ChatFormatting.DARK_BLUE));
            }
            if (stack.is(ModItems.FUEGO_FUDGE_CHOCOLATE_COIN.get())) {
                tooltip.add(Component.translatable("tooltips." + ModItems.FUEGO_FUDGE_CHOCOLATE_COIN.get() + "_effects")
                        .withStyle(ChatFormatting.DARK_BLUE));
            }
            if (stack.is(ModItems.CARMEL_CRISP_CHOCOLATE_COIN.get())) {
                tooltip.add(Component.translatable("tooltips." + ModItems.CARMEL_CRISP_CHOCOLATE_COIN.get() + "_effects")
                        .withStyle(ChatFormatting.DARK_BLUE));
            }

            if (stack.getItem() instanceof SpawnEggItem) {

                final CompoundTag stackTag = stack.getTagElement("EntityTag");

                if (player != null && stackTag != null && stackTag.getBoolean("NoAI")) {
                    tooltip.add(Component.translatable("tooltips.no_ai_spawn_egg").withStyle(ChatFormatting.GOLD, ChatFormatting.BOLD));
                }
            }
            return event;
        }

        @SubscribeEvent
        public static void onAttachCapabilitiesPlayer(@NotNull AttachCapabilitiesEvent<Entity> event) {
            if (event.getObject() instanceof Player) {
                if (!event.getObject().getCapability(PlayerCharismaProvider.PLAYER_CHARISMA).isPresent()) {
                    event.addCapability(new ResourceLocation(TodeCoins.MODID, "player_charisma"), new PlayerCharismaProvider());
                }
                if (!event.getObject().getCapability(PlayerCodProvider.PLAYER_COD_BONUS).isPresent()) {
                    event.addCapability(new ResourceLocation(TodeCoins.MODID, "player_cod_bonus"), new PlayerCodProvider());
                }
                if (!event.getObject().getCapability(PlayerPufferfishProvider.PLAYER_PUFFERFISH_BONUS).isPresent()) {
                    event.addCapability(new ResourceLocation(TodeCoins.MODID, "player_pufferfish_bonus"), new PlayerPufferfishProvider());
                }
                if (!event.getObject().getCapability(PlayerSalmonProvider.PLAYER_SALMON_BONUS).isPresent()) {
                    event.addCapability(new ResourceLocation(TodeCoins.MODID, "player_salmon_bonus"), new PlayerSalmonProvider());
                }
                if (!event.getObject().getCapability(PlayerTropicalFishProvider.PLAYER_TROPICAL_FISH_BONUS).isPresent()) {
                    event.addCapability(new ResourceLocation(TodeCoins.MODID, "player_tropical_fish_bonus"), new PlayerTropicalFishProvider());
                }
            }
        }

        @SubscribeEvent
        public static void onEntityAttributeModificationEvent(@NotNull final EntityAttributeModificationEvent event) {
            event.add(EntityType.PLAYER, ModAttributes.CHARISMA.get());
            event.add(EntityType.PLAYER, ModAttributes.COD_BONUS.get());
            event.add(EntityType.PLAYER, ModAttributes.PUFFERFISH_BONUS.get());
            event.add(EntityType.PLAYER, ModAttributes.SALMON_BONUS.get());
            event.add(EntityType.PLAYER, ModAttributes.TROPICAL_FISH_BONUS.get());
        }

        @SubscribeEvent
        public static void onPlayerCloned(@NotNull PlayerEvent.Clone event) {
            if (event.isWasDeath()) {
                event.getOriginal().getCapability(PlayerCharismaProvider.PLAYER_CHARISMA)
                        .ifPresent(oldStore -> event.getOriginal().getCapability(PlayerCharismaProvider.PLAYER_CHARISMA)
                                .ifPresent(newStore -> newStore.copyFrom(oldStore)));
                event.getOriginal().getCapability(PlayerCodProvider.PLAYER_COD_BONUS)
                        .ifPresent(oldStore -> event.getOriginal().getCapability(PlayerCodProvider.PLAYER_COD_BONUS)
                                .ifPresent(newStore -> newStore.copyFrom(oldStore)));
                event.getOriginal().getCapability(PlayerPufferfishProvider.PLAYER_PUFFERFISH_BONUS)
                        .ifPresent(oldStore -> event.getOriginal().getCapability(PlayerPufferfishProvider.PLAYER_PUFFERFISH_BONUS)
                                .ifPresent(newStore -> newStore.copyFrom(oldStore)));
                event.getOriginal().getCapability(PlayerSalmonProvider.PLAYER_SALMON_BONUS)
                        .ifPresent(oldStore -> event.getOriginal().getCapability(PlayerSalmonProvider.PLAYER_SALMON_BONUS)
                                .ifPresent(newStore -> newStore.copyFrom(oldStore)));
                event.getOriginal().getCapability(PlayerTropicalFishProvider.PLAYER_TROPICAL_FISH_BONUS)
                        .ifPresent(oldStore -> event.getOriginal().getCapability(PlayerTropicalFishProvider.PLAYER_TROPICAL_FISH_BONUS)
                                .ifPresent(newStore -> newStore.copyFrom(oldStore)));
            }
        }

        @SubscribeEvent
        public static void onRegisterCapabilities(@NotNull RegisterCapabilitiesEvent event) {
            event.register(PlayerCharisma.class);
        }

        @SuppressWarnings("SameReturnValue")
        @SubscribeEvent
        public static boolean onLivingDeath(@NotNull LivingDeathEvent event) {
            LivingEntity dyingEntity = event.getEntity();
            Level level = dyingEntity.getCommandSenderWorld();
            if (!level.isClientSide) {
                if (dyingEntity instanceof ServerPlayer player) {
                    Inventory playerInventory = player.getInventory();
                    DamageSource damageSource = player.getLastDamageSource();
                    ItemStack luckyCoin = null;

                    if (ModList.get().isLoaded("curios")) {
                        Optional<SlotResult> optional = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.LUCKY_COIN.get());
                        if (optional.isPresent()) {
                            luckyCoin = optional.get().stack();
                        }
                        else {
                            for (int i = 0; i < playerInventory.getContainerSize(); ++i) {
                                ItemStack inventoryItem = playerInventory.getItem(i);
                                if (inventoryItem.getItem().equals(ModItems.LUCKY_COIN.get())) {
                                    luckyCoin = inventoryItem;
                                    break;
                                }
                            }
                        }
                    }
                    else {
                        for (int i = 0; i < playerInventory.getContainerSize(); ++i) {
                            ItemStack inventoryItem = playerInventory.getItem(i);
                            if (inventoryItem.getItem().equals(ModItems.LUCKY_COIN.get())) {
                                luckyCoin = inventoryItem;
                                break;
                            }
                        }
                    }

                    if (luckyCoin != null) {
                        player.setHealth(1.0F);
                        player.removeAllEffects();
                        player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 100, 1));
                        player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 800, 0));
                        player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 900, 1));
                        if (damageSource != null && damageSource == DamageSource.OUT_OF_WORLD) {
                            player.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 900, 0));
                        }
                        level.broadcastEntityEvent(player, (byte) 35);
                        luckyCoin.shrink(1);
                        event.setCanceled(true);
                    }
                }
            }
            return false;
        }

        @SuppressWarnings("SameReturnValue")
        @SubscribeEvent
        public static boolean onHurtEntity(@NotNull LivingHurtEvent event) {
            LivingEntity entity = event.getEntity();
            Entity attacker = event.getSource().getEntity();
            Level level = entity.getCommandSenderWorld();

            if (!level.isClientSide && (entity instanceof ServerPlayer player) && attacker != null && attacker.isAttackable()) {
                if (player.hasEffect(ModEffects.THORN_SHIELD.get())) {
                    attacker.hurt(DamageSource.thorns(player), (float) getDamage(ThornShieldEffect.getAmplifier(), RandomSource.create()));
                }
            }
            return false;
        }

        public static int getDamage(int level, RandomSource random) {
            return level > 10 ? level - 10 : 1 + random.nextInt(4);
        }

        @SuppressWarnings("SameReturnValue")
        @SubscribeEvent
        public static boolean onAttackEntity(@NotNull AttackEntityEvent event) {
            LivingEntity entity = event.getEntity();
            Entity target = event.getTarget();

            Level level = entity.getCommandSenderWorld();

            int effectDuration = 0;

            if (entity.level.getDifficulty() == Difficulty.EASY) {
                effectDuration = 15;
            }
            else if (entity.level.getDifficulty() == Difficulty.NORMAL) {
                effectDuration = 10;
            }
            else if (entity.level.getDifficulty() == Difficulty.HARD) {
                effectDuration = 5;
            }

            if (!level.isClientSide && (entity instanceof ServerPlayer player) && target != null) {
                if (player.hasEffect(ModEffects.VENOM_STRIKE.get())) {
                    ((LivingEntity) target).addEffect(new MobEffectInstance(MobEffects.POISON, (effectDuration * 20), VenomEffect.getAmplifier()), target);
                }
                if (player.hasEffect(ModEffects.ILLAGER_BANE.get()) && ((target instanceof Vex || target instanceof PatrollingMonster))) {
                    ((LivingEntity) target).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, (effectDuration * 20), IllagerBaneEffect.getAmplifier()), target);
                    target.hurt(DamageSource.playerAttack(player), 2.5F * getDamage(IllagerBaneEffect.getAmplifier(), RandomSource.create()));
                }
                if (player.hasEffect(ModEffects.THUNDERSTRIKE.get())) {
                    LightningBolt lightningBolt = EntityType.LIGHTNING_BOLT.create(player.level);
                    if (lightningBolt != null) {
                        lightningBolt.moveTo(Vec3.atBottomCenterOf(target.getOnPos()));
                        lightningBolt.setCause(player);
                        player.level.addFreshEntity(lightningBolt);
                    }
                }
                if (player.hasEffect(ModEffects.FROST_STRIKE.get()) && target.canFreeze()) {
                    target.setTicksFrozen(target.getTicksRequiredToFreeze() + (effectDuration * 20) + 20);
                }
                if (player.hasEffect(ModEffects.BURNING_STRIKE.get())) {
                    target.setSecondsOnFire((effectDuration * 20) + 20);
                }
                if (player.hasEffect(ModEffects.ARTHROPOD_BLIGHT.get()) && ((LivingEntity) target).getMobType() == MobType.ARTHROPOD) {
                    ((LivingEntity) target).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, (effectDuration * 20), ArthropodBlightEffect.getAmplifier()), target);
                    target.hurt(DamageSource.playerAttack(player), 2.5F * getDamage(ArthropodBlightEffect.getAmplifier(), RandomSource.create()));
                }
                if (player.hasEffect(ModEffects.WITHERING_STRIKE.get())) {
                    ((LivingEntity) target).addEffect(new MobEffectInstance(MobEffects.WITHER, (effectDuration * 20), WitheringStrikeEffect.getAmplifier()), target);
                }
                if (player.hasEffect(ModEffects.HOLY_STRIKE.get()) && ((LivingEntity) target).getMobType() == MobType.UNDEAD) {
                    ((LivingEntity) target).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, (effectDuration * 20), HolyStrikeEffect.getAmplifier()), target);
                    target.hurt(DamageSource.playerAttack(player), 2.5F * getDamage(HolyStrikeEffect.getAmplifier(), RandomSource.create()));
                }
            }

            return false;
        }

        @SuppressWarnings("SameReturnValue")
        @SubscribeEvent
        public static boolean onLivingChangeTargetAttack(@NotNull LivingChangeTargetEvent event) {
            LivingEntity entity = event.getEntity();
            Entity target = event.getOriginalTarget();
            Level level = entity.getCommandSenderWorld();

            if (!level.isClientSide) {
                if (entity instanceof Phantom && target instanceof ServerPlayer player) {
                    ItemStack catCharm = null;

                    Optional<SlotResult> catCoin1 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.COPPER_CAT_COIN.get());
                    Optional<SlotResult> catCoin2 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.IRON_CAT_COIN.get());
                    Optional<SlotResult> catCoin3 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.GOLD_CAT_COIN.get());
                    Optional<SlotResult> catCoin4 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.NETHERITE_CAT_COIN.get());

                    Optional<SlotResult> ocelotCoin1 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.COPPER_OCELOT_COIN.get());
                    Optional<SlotResult> ocelotCoin2 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.IRON_OCELOT_COIN.get());
                    Optional<SlotResult> ocelotCoin3 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.GOLD_OCELOT_COIN.get());
                    Optional<SlotResult> ocelotCoin4 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.NETHERITE_OCELOT_COIN.get());

                    if (catCoin1.isPresent()) {
                        catCharm = catCoin1.get().stack();
                    }
                    else if (catCoin2.isPresent()) {
                        catCharm = catCoin2.get().stack();
                    }
                    else if (catCoin3.isPresent()) {
                        catCharm = catCoin3.get().stack();
                    }
                    else if (catCoin4.isPresent()) {
                        catCharm = catCoin4.get().stack();
                    }
                    else if (ocelotCoin1.isPresent()) {
                        catCharm = ocelotCoin1.get().stack();
                    }
                    else if (ocelotCoin2.isPresent()) {
                        catCharm = ocelotCoin2.get().stack();
                    }
                    else if (ocelotCoin3.isPresent()) {
                        catCharm = ocelotCoin3.get().stack();
                    }
                    else if (ocelotCoin4.isPresent()) {
                        catCharm = ocelotCoin4.get().stack();
                    }

                    if (catCharm != null && (catCharm.is(ModTags.Items.CAT_COIN_SET) || catCharm.is(ModTags.Items.OCELOT_COIN_SET))) {
                        event.setCanceled(true);
                    }
                }
            }
            return false;
        }

        @SuppressWarnings("SameReturnValue")
        @SubscribeEvent
        public static boolean onEntityJoinLevelEvent(@NotNull EntityJoinLevelEvent event) {
            Entity entity = event.getEntity();
            if (entity instanceof Creeper) {
                Creeper creeper = (Creeper) event.getEntity();
                creeper.goalSelector.addGoal(3, new AvoidPlayerCatCoinGoal<>(creeper, Player.class, 16.0F, 1.0D, 1.2D));
            }
            return false;
        }
    }

    @Mod.EventBusSubscriber(modid = MODID)
    public static class CustomSpawnerHandler {
        private static final Map<ResourceLocation, NumismatistSpawner> numismatistSpawner = new HashMap<>();

        @SubscribeEvent
        public static void onWorldLoad(@NotNull ServerStartingEvent event) {
            MinecraftServer server = event.getServer();
            numismatistSpawner.put(BuiltinDimensionTypes.OVERWORLD.location(), new NumismatistSpawner(server, "Numismatist", ModEntityTypes.NUMISMATIST.get()));
        }

        @SubscribeEvent
        public static void onServerStopped(ServerStoppedEvent event) {
            numismatistSpawner.clear();
        }

        @SubscribeEvent
        public static void onWorldTick(@NotNull TickEvent.LevelTickEvent event) {
            if (event.phase != TickEvent.Phase.START) {
                return;
            }

            if (event.side != LogicalSide.SERVER) {
                return;
            }

            NumismatistSpawner spawner = numismatistSpawner.get(event.level.dimension().location());
            if (spawner != null) {
                spawner.tick((ServerLevel) event.level, true, true);
            }
        }
    }
}