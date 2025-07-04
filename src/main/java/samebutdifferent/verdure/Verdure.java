package samebutdifferent.verdure;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartedEvent;
import samebutdifferent.verdure.registry.*;

@Mod(Verdure.MOD_ID)
public class Verdure {

    public static final String MOD_ID = "verdure";

    public Verdure(IEventBus bus, ModContainer container) {
        container.registerConfig(ModConfig.Type.COMMON, VerdureConfig.COMMON_CONFIG);
        NeoForge.EVENT_BUS.register(this);

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
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }

    @SubscribeEvent
    public void onServerStarted(ServerStartedEvent event) {
    }

}
