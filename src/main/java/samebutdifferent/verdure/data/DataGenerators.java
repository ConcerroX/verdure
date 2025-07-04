package samebutdifferent.verdure.data;

import net.minecraft.data.DataGenerator;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import samebutdifferent.verdure.Verdure;

@EventBusSubscriber(modid = Verdure.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        //        generator.addProvider(new BlockstateGenerator(generator, event.getExistingFileHelper()));
        //        generator.addProvider(new ItemModelGenerator(generator, event.getExistingFileHelper()));
        //        generator.addProvider(new LangGenerator(generator, "en_us"));
        //        generator.addProvider(new BlockTagGenerator(generator, event.getExistingFileHelper()));
        //        generator.addProvider(new RecipeGenerator(generator));
        //        generator.addProvider(new LootTableGenerator(generator));
    }

}
