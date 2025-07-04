package samebutdifferent.verdure.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import samebutdifferent.verdure.Verdure;

public class VerdureCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(
        Registries.CREATIVE_MODE_TAB,
        Verdure.MOD_ID
    );

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> VERDURE_TAB = CREATIVE_MODE_TABS.register(
        "verdure_tab",
        () -> CreativeModeTab.builder().icon(() -> new ItemStack(VerdureBlocks.CLOVER.get()))
            .displayItems((itemDisplayParameters, output) -> VerdureItems.ITEMS.getEntries()
                .forEach((it) -> output.accept(it.get()))).build()
    );

}
