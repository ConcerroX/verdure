package samebutdifferent.verdure.registry;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import samebutdifferent.verdure.Verdure;
import samebutdifferent.verdure.item.TallHangingMossBlockItem;

@SuppressWarnings("unused")
public class VerdureItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Verdure.MOD_ID);

    public static final DeferredItem<TallHangingMossBlockItem> TALL_HANGING_MOSS = ITEMS.register(
        "tall_hanging_moss",
        () -> new TallHangingMossBlockItem(VerdureBlocks.TALL_HANGING_MOSS.get(), new Item.Properties())
    );

}
