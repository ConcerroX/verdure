package samebutdifferent.verdure.data;

import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import samebutdifferent.verdure.Verdure;

import java.util.List;
import java.util.Set;

@Mod.EventBusSubscriber(modid = Verdure.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class VerdureDataGeneration {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        var generator = event.getGenerator();
        var output = generator.getPackOutput();
        var lookupProvider = event.getLookupProvider();
        var existingFileHelper = event.getExistingFileHelper();

        generator.addProvider(event.includeServer(), new RegistryDataProvider(lookupProvider));
        generator.addProvider(event.includeServer(), new RecipeProvider(output));
        generator.addProvider(event.includeServer(), new BiomeTagsProvider(output, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new BlockTagsProvider(output, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new LootTableProvider(output, Set.of(),
            List.of(new LootTableProvider.SubProviderEntry(BlockLootSubProvider::new, LootContextParamSets.BLOCK))));
    }

}
