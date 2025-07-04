package samebutdifferent.verdure.data;

import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import org.jetbrains.annotations.NotNull;
import samebutdifferent.verdure.registry.VerdureBlocks;
import samebutdifferent.verdure.registry.VerdureConfiguredFeatures;

public class ConfiguredFeaturesProvider implements RegistrySetBuilder.RegistryBootstrap<ConfiguredFeature<?, ?>> {

    @Override
    public void run(@NotNull BootstrapContext<ConfiguredFeature<?, ?>> context) {
        context.register(VerdureConfiguredFeatures.PEBBLES, new ConfiguredFeature<>(Feature.SIMPLE_BLOCK,
            new SimpleBlockConfiguration(BlockStateProvider.simple(VerdureBlocks.PEBBLES.get()))));
    }

}