package net.warrentode.todecoins.block.entity;

import com.google.common.collect.Lists;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.RecipeHolder;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.SingleThreadedRandomSource;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.RecipeWrapper;
import net.warrentode.todecoins.block.custom.CoinPressBlock;
import net.warrentode.todecoins.mixin.RecipeMangerMixin;
import net.warrentode.todecoins.recipe.CoinPressRecipe;
import net.warrentode.todecoins.recipe.ModRecipeTypes;
import net.warrentode.todecoins.screen.coinpressgui.CoinPressMenu;
import net.warrentode.todecoins.util.tags.ModTags;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CoinPressBlockEntity extends BlockEntity implements MenuProvider, RecipeHolder {
    private final ItemStackHandler itemHandler = new ItemStackHandler(3) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
        
        @Override
        public boolean isItemValid(int slot, @NotNull ItemStack stack) {
            return switch (slot) {
                case 0 -> stack.hasTag() == stack.is(ModTags.Items.CURRENCY_STAMPS);
                case 1 -> true;
                case 2 -> false;
                default -> super.isItemValid(slot, stack);
            };
        }
    };
    public LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();
    private final Map<Direction, LazyOptional<WrappedHandler>> directionWrappedHandlerMap = Map.of(Direction.DOWN, LazyOptional.of(() -> new WrappedHandler(itemHandler, (i) -> i == 2, (i, s) -> false)), Direction.NORTH, LazyOptional.of(() -> new WrappedHandler(itemHandler, (i) -> i == 2, (i, s) -> false)), Direction.WEST, LazyOptional.of(() -> new WrappedHandler(itemHandler, (index) -> index == 0, (index, stack) -> itemHandler.isItemValid(0, stack))), Direction.EAST, LazyOptional.of(() -> new WrappedHandler(itemHandler, (i) -> i == 1, (index, stack) -> itemHandler.isItemValid(1, stack))), Direction.SOUTH, LazyOptional.of(() -> new WrappedHandler(itemHandler, (index) -> index == 0 || index == 1, (index, stack) -> itemHandler.isItemValid(0, stack) || itemHandler.isItemValid(1, stack))));
    
    public SimpleContainer inventory;
    public static CoinPressBlockEntity coinPress;
    protected final ContainerData coinPressData;
    public int stampingTime;
    public int totalStampingTime;
    public int experience;
    public Object2IntOpenHashMap<ResourceLocation> usedRecipeTracker;
    public ResourceLocation lastRecipeID;
    public Recipe<?> lastUsedRecipe;
    public boolean checkNewRecipe;
    
    public CoinPressBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.COINPRESS_ENTITY.get(), pPos, pBlockState);
        this.usedRecipeTracker = new Object2IntOpenHashMap<>();
        this.lastRecipeID = null;
        this.checkNewRecipe = true;
        this.experience = 0;
        this.coinPressData = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch (pIndex) {
                    case 0 -> CoinPressBlockEntity.this.stampingTime;
                    case 1 -> CoinPressBlockEntity.this.totalStampingTime;
                    default -> 0;
                };
            }
            
            @Override
            public void set(int pIndex, int pValue) {
                switch (pIndex) {
                    case 0 -> CoinPressBlockEntity.this.stampingTime = pValue;
                    case 1 -> CoinPressBlockEntity.this.totalStampingTime = pValue;
                }
            }
            
            @Override
            public int getCount() {
                return 2;
            }
        };
    }
    @Override
    public @NotNull Component getDisplayName() {
        return Component.translatable("container.coin_press_block_gui");
    }
    
    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, @NotNull Inventory pPlayerInventory, @NotNull Player pPlayer) {
        return new CoinPressMenu(pContainerId, pPlayerInventory, this, this.coinPressData);
    }
    
    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            if (side == null) {
                return lazyItemHandler.cast();
            }
            
            if (directionWrappedHandlerMap.containsKey(side)) {
                Direction localDir = this.getBlockState().getValue(CoinPressBlock.FACING);
                
                if (side == Direction.UP || side == Direction.DOWN) {
                    return directionWrappedHandlerMap.get(side).cast();
                }
                
                return switch (localDir) {
                    default -> directionWrappedHandlerMap.get(side).cast();
                    case EAST -> directionWrappedHandlerMap.get(side.getClockWise()).cast();
                    case SOUTH -> directionWrappedHandlerMap.get(side.getOpposite()).cast();
                    case WEST -> directionWrappedHandlerMap.get(side.getCounterClockWise()).cast();
                };
            }
        }
        
        return super.getCapability(cap, side);
    }
    
    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }
    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }
    @Override
    protected void saveAdditional(@NotNull CompoundTag nbt) {
        super.saveAdditional(nbt);
        nbt.put("inventory", itemHandler.serializeNBT());
        nbt.putInt("coin_press.stampingTime", this.stampingTime);
        nbt.putInt("coin_press.totalStampingTime", this.totalStampingTime);
        CompoundTag compoundRecipes = new CompoundTag();
        usedRecipeTracker.forEach((recipeId, craftedAmount) -> compoundRecipes.putInt(recipeId.toString(), craftedAmount));
        nbt.put("RecipesUsed", compoundRecipes);
    }
    @Override
    public void load(@NotNull CompoundTag nbt) {
        super.load(nbt);
        itemHandler.deserializeNBT(nbt.getCompound("inventory"));
        stampingTime = nbt.getInt("coin_press.stampingTime");
        totalStampingTime = nbt.getInt("coin_press.totalStampingTime");
        CompoundTag compoundRecipes = nbt.getCompound("RecipesUsed");
        for (String key : compoundRecipes.getAllKeys()) {
            usedRecipeTracker.put(new ResourceLocation(key), compoundRecipes.getInt(key));
        }
    }
    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }
        
        assert this.level != null;
        Containers.dropContents(this.level, this.worldPosition, inventory);
    }
    
    public static void tick(Level level, BlockPos pos, BlockState state, CoinPressBlockEntity coinPress) {
        ItemStack stack = ItemStack.EMPTY;
        SimpleContainer inventory = coinPress.inventory;
        if (coinPress.hasInput()) {
            Optional<CoinPressRecipe> recipe = coinPress.getMatchingRecipe(new RecipeWrapper((IItemHandlerModifiable) coinPress.inventory));
            if (recipe.isPresent() && canInsertItemIntoOutputSlot(inventory, stack)) {
                coinPress.processCurrency(recipe.get(), coinPress);
                setChanged(level, pos, state);
            }
            else {
                coinPress.stampingTime = 0;
            }
        }
    }
    
    /* RECIPES */
    private Optional<CoinPressRecipe> getMatchingRecipe(RecipeWrapper inventoryWrapper) {
        if (level == null) return Optional.empty();
        
        if (lastRecipeID != null) {
            Recipe<RecipeWrapper> recipe = ((RecipeMangerMixin) level.getRecipeManager()).getRecipeMap(ModRecipeTypes.COINPRESS.get()).get(lastRecipeID);
            if (recipe instanceof CoinPressRecipe) {
                if (recipe.matches(inventoryWrapper, level)) {
                    return Optional.of((CoinPressRecipe) recipe);
                }
                if (recipe.getResultItem().sameItem(getCraftResult()) && canInsertItemIntoOutputSlot(inventory, getCraftResult())) {
                    return Optional.empty();
                }
            }
        }
        if (checkNewRecipe) {
            Optional<CoinPressRecipe> recipe = level.getRecipeManager().getRecipeFor(ModRecipeTypes.COINPRESS.get(), inventoryWrapper, level);
            if (recipe.isPresent()) {
                lastRecipeID = recipe.get().getId();
                return recipe;
            }
        }
        checkNewRecipe = false;
        return Optional.empty();
    }
    
    public boolean hasInput() {
        return !itemHandler.getStackInSlot(0).isEmpty() || !itemHandler.getStackInSlot(1).isEmpty();
    }
    
    public void processCurrency(CoinPressRecipe recipe, CoinPressBlockEntity coinPress) {
        BlockPos pos = this.getBlockPos();
        BlockState state = this.getBlockState();
        if (level == null) return;
        
        stampingTime = recipe.getStampingTime();
        coinPress.stampingTime++;
        if (coinPress.stampingTime >= coinPress.totalStampingTime) {
            craftItem(coinPress);
        }
        else {
            coinPress.resetStampingTime();
            setChanged(level, pos, state);
        }
    }
    
    public boolean isCrafting() {
        return stampingTime > 0;
    }
    
    private static void craftItem(CoinPressBlockEntity entity) {
        Level level = entity.level;
        if (level == null) return;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }
        
        Map<ResourceLocation, Recipe<RecipeWrapper>> recipe = ((RecipeMangerMixin) level.getRecipeManager()).getRecipeMap(ModRecipeTypes.COINPRESS.get());
        
        if (recipe instanceof CoinPressRecipe) {
            
            // check first input slot for stamp, remove if at max dmg, if not, dmg it - otherwise shrink stack
            if (entity.itemHandler.getStackInSlot(0).getDamageValue() == entity.itemHandler.getStackInSlot(0).getMaxDamage() && entity.itemHandler.getStackInSlot(0).is(ModTags.Items.CURRENCY_STAMPS)) {
                entity.itemHandler.extractItem(0, 1, false);
            }
            else if (entity.itemHandler.getStackInSlot(0).getDamageValue() != entity.itemHandler.getStackInSlot(0).getMaxDamage() && entity.itemHandler.getStackInSlot(0).is(ModTags.Items.CURRENCY_STAMPS)) {
                entity.itemHandler.getStackInSlot(0).hurt(1, new SingleThreadedRandomSource(1), null);
            }
            else {
                entity.itemHandler.extractItem(0, 1, false);
            }
            
            // check second input slot for stamp, remove if at max dmg, if not, dmg it - otherwise shrink stack
            if (entity.itemHandler.getStackInSlot(1).getDamageValue() == entity.itemHandler.getStackInSlot(1).getMaxDamage() && entity.itemHandler.getStackInSlot(1).is(ModTags.Items.CURRENCY_STAMPS)) {
                entity.itemHandler.extractItem(0, 1, false);
            }
            else if (entity.itemHandler.getStackInSlot(1).getDamageValue() != entity.itemHandler.getStackInSlot(1).getMaxDamage() && entity.itemHandler.getStackInSlot(1).is(ModTags.Items.CURRENCY_STAMPS)) {
                entity.itemHandler.getStackInSlot(1).hurt(1, new SingleThreadedRandomSource(1), null);
            }
            else {
                entity.itemHandler.extractItem(1, 1, false);
            }
            
            entity.itemHandler.setStackInSlot(2, new ItemStack(((CoinPressRecipe) recipe).getResultItem().getItem(), entity.itemHandler.getStackInSlot(2).getCount() + (((CoinPressRecipe) recipe).getResultItem().getCount())));
            
            coinPress.setRecipeUsed((Recipe<?>) recipe);
            entity.resetStampingTime();
        }
    }
    
    private static boolean canInsertItemIntoOutputSlot(SimpleContainer inventory, ItemStack stack) {
        return inventory.getItem(2).getItem() == stack.getItem() || inventory.getItem(2).isEmpty();
    }
    
    @Override
    public void setRecipeUsed(@Nullable Recipe<?> recipe) {
        if (recipe != null) {
            ResourceLocation recipeID = recipe.getId();
            lastUsedRecipe = recipe;
            usedRecipeTracker.addTo(recipeID, 1);
        }
    }
    
    private void resetStampingTime() {
        this.stampingTime = 0;
    }
    
    @Nullable
    @Override
    public Recipe<?> getRecipeUsed() {
        return lastUsedRecipe;
    }
    public ItemStack getCraftResult() {
        return lastUsedRecipe.getResultItem();
    }
    
    @Override
    public void awardUsedRecipes(@NotNull Player player) {
        List<Recipe<?>> usedRecipes = getUsedRecipesAndPopExperience(player.level, player.position());
        player.awardRecipes(usedRecipes);
        usedRecipeTracker.clear();
    }
    
    public List<Recipe<?>> getUsedRecipesAndPopExperience(Level level, Vec3 pos) {
        List<Recipe<?>> list = Lists.newArrayList();
        
        for (Object2IntMap.Entry<ResourceLocation> entry : usedRecipeTracker.object2IntEntrySet()) {
            level.getRecipeManager().byKey(entry.getKey()).ifPresent((recipe) -> {
                list.add(recipe);
                splitAndSpawnExperience((ServerLevel) level, pos, entry.getIntValue(), ((CoinPressRecipe) recipe).getExperience());
            });
        }
        
        return list;
    }
    private static void splitAndSpawnExperience(ServerLevel level, Vec3 pos, int craftedAmount, float experience) {
        int expTotal = Mth.floor((float) craftedAmount * experience);
        float expFraction = Mth.frac((float) craftedAmount * experience);
        if (expFraction != 0.0F && Math.random() < (double) expFraction) {
            ++expTotal;
        }
        
        ExperienceOrb.award(level, pos, expTotal);
    }
}