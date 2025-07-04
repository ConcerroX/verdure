package samebutdifferent.verdure.registry;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import samebutdifferent.verdure.Verdure;
import samebutdifferent.verdure.item.TallHangingMossBlockItem;

public class VerdureItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.createItems(Verdure.MOD_ID);

    public static final DeferredHolder<Item, Item> TALL_HANGING_MOSS = ITEMS.register(
        "tall_hanging_moss",
        () -> new TallHangingMossBlockItem(VerdureBlocks.TALL_HANGING_MOSS.get(), new Item.Properties())
    );
}
