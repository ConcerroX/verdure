package samebutdifferent.verdure.event;

import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.ComposterBlock;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import samebutdifferent.verdure.Verdure;
import samebutdifferent.verdure.registry.VerdureBlocks;

@EventBusSubscriber(modid = Verdure.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ModEventHandler {

    @SubscribeEvent
    public static void init(final FMLCommonSetupEvent event) {
        event.enqueueWork(ModEventHandler::registerCompostables);
    }

    private static void registerCompostables() {
        compostableBlocks(0.3F, VerdureBlocks.CLOVER.get());
        compostableBlocks(0.3F, VerdureBlocks.DAISIES.get());
        compostableBlocks(0.3F, VerdureBlocks.BLUE_DAISIES.get());
        compostableBlocks(0.3F, VerdureBlocks.PINK_DAISIES.get());
        compostableBlocks(0.3F, VerdureBlocks.WILDFLOWERS.get());
        compostableBlocks(0.3F, VerdureBlocks.HANGING_MOSS.get());
        compostableBlocks(0.3F, VerdureBlocks.FALLEN_OAK_LEAVES.get());
        compostableBlocks(0.3F, VerdureBlocks.FALLEN_BIRCH_LEAVES.get());
        compostableBlocks(0.3F, VerdureBlocks.FALLEN_SPRUCE_LEAVES.get());
        compostableBlocks(0.3F, VerdureBlocks.FALLEN_JUNGLE_LEAVES.get());
        compostableBlocks(0.3F, VerdureBlocks.FALLEN_ACACIA_LEAVES.get());
        compostableBlocks(0.3F, VerdureBlocks.FALLEN_DARK_OAK_LEAVES.get());
    }

    private static void compostableBlocks(float chance, ItemLike item) {
        ComposterBlock.COMPOSTABLES.put(item.asItem(), chance);
    }

}
