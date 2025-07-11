package samebutdifferent.verdure.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.DispenserMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import samebutdifferent.verdure.registry.VerdureBlockEntityTypes;

public class HollowLogBlockEntity extends RandomizableContainerBlockEntity {

    protected final NonNullList<ItemStack> items = NonNullList.withSize(9, ItemStack.EMPTY);

    public HollowLogBlockEntity(BlockPos pos, BlockState state) {
        super(VerdureBlockEntityTypes.HOLLOW_LOG.get(), pos, state);
    }

    @Override
    protected @NotNull NonNullList<ItemStack> getItems() {
        return items;
    }

    @Override
    protected void setItems(@NotNull NonNullList<ItemStack> pItems) {
        for (int i = 0; i < items.size(); i++) {
            setItem(i, pItems.get(i));
        }
    }

    @Override
    protected @NotNull Component getDefaultName() {
        return Component.translatable("container.verdure.hollow_log");
    }

    @Override
    protected @NotNull AbstractContainerMenu createMenu(int pContainerId, @NotNull Inventory pInventory) {
        return new DispenserMenu(pContainerId, pInventory, this);
    }

    @Override
    public int getContainerSize() {
        return 9;
    }

    @Override
    public void load(@NotNull CompoundTag tag) {
        super.load(tag);
        items.clear();
        if (!tryLoadLootTable(tag)) {
            ContainerHelper.loadAllItems(tag, items);
        }
    }

    @Override
    public void saveAdditional(@NotNull CompoundTag tag) {
        super.saveAdditional(tag);
        if (!trySaveLootTable(tag)) {
            ContainerHelper.saveAllItems(tag, items);
        }
    }

}
