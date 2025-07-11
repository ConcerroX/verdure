package samebutdifferent.verdure;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import samebutdifferent.verdure.registry.*;

@Mod(Verdure.MOD_ID)
public class Verdure {

    public static final String MOD_ID = "verdure";

    public Verdure() {
        var bus = FMLJavaModLoadingContext.get().getModEventBus();
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, VerdureConfig.COMMON_CONFIG);
        MinecraftForge.EVENT_BUS.register(this);

        VerdureItems.ITEMS.register(bus);
        VerdureBlocks.BLOCKS.register(bus);
        VerdureFeatures.FEATURES.register(bus);
        VerdurePlacedFeatures.PLACED_FEATURES.register(bus);
        VerdureCreativeModeTabs.CREATIVE_MODE_TABS.register(bus);
        VerdureBlockEntityTypes.BLOCK_ENTITY_TYPES.register(bus);
        VerdureTreeDecoratorTypes.TREE_DECORATOR_TYPES.register(bus);
        VerdureConfiguredFeatures.CONFIGURED_FEATURES.register(bus);
    }

    public static ResourceLocation res(String path) {
        return new ResourceLocation(MOD_ID, path);
    }

    @SubscribeEvent
    public void onServerStarted(ServerStartedEvent event) {
    }

}
