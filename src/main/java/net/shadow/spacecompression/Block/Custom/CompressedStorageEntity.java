package net.shadow.spacecompression.Block.Custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShulkerBoxBlock;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.LootableContainerBlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ShulkerBoxScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;

import java.util.stream.IntStream;

public class CompressedStorageEntity extends LootableContainerBlockEntity implements SidedInventory {
    public static final int field_31354 = 9;
    public static final int field_31355 = 3;
    public static final int INVENTORY_SIZE = 5;
    public static final int field_31357 = 1;
    public static final int field_31358 = 10;
    public static final float field_31359 = 0.5F;
    public static final float field_31360 = 270.0F;
    public static final String ITEMS_KEY = "Items";
    private static final int[] AVAILABLE_SLOTS = IntStream.range(0, 5).toArray();
    private DefaultedList<ItemStack> inventory = DefaultedList.ofSize(5, ItemStack.EMPTY);
    private int viewerCount;

    public CompressedStorageEntity(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(BlockEntityType.CHEST, blockPos, blockState);
    }

    @Override
    protected Text getContainerName() {
        return Text.translatable("container.shulkerBox");
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        this.readInventoryNbt(nbt);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        if (!this.serializeLootTable(nbt)) {
            Inventories.writeNbt(nbt, this.inventory, false);
        }
    }

    public void readInventoryNbt(NbtCompound nbt) {
        this.inventory = DefaultedList.ofSize(this.size(), ItemStack.EMPTY);
        if (!this.deserializeLootTable(nbt) && nbt.contains("Items", NbtElement.LIST_TYPE)) {
            Inventories.readNbt(nbt, this.inventory);
        }
    }

    @Override
    protected DefaultedList<ItemStack> getInvStackList() {
        return this.inventory;
    }

    @Override
    protected void setInvStackList(DefaultedList<ItemStack> list) {
        this.inventory = list;
    }

    @Override
    public int[] getAvailableSlots(Direction side) {
        return AVAILABLE_SLOTS;
    }

    @Override
    public boolean canInsert(int slot, ItemStack stack, @Nullable Direction dir) {
        return !(Block.getBlockFromItem(stack.getItem()) instanceof ShulkerBoxBlock);
    }
    @Override
    public int size() {
        return this.inventory.size();
    }

    @Override
    public boolean canExtract(int slot, ItemStack stack, Direction dir) {
        return true;
    }
    @Override
    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return new ShulkerBoxScreenHandler(syncId, playerInventory, this);
    }
}
