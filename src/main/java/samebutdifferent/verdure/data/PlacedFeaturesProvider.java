package samebutdifferent.verdure.data;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import org.jetbrains.annotations.NotNull;
import samebutdifferent.verdure.registry.VerdureBlocks;
import samebutdifferent.verdure.registry.VerdureConfiguredFeatures;
import samebutdifferent.verdure.registry.VerdurePlacedFeatures;

import java.util.List;

public class PlacedFeaturesProvider implements RegistrySetBuilder.RegistryBootstrap<PlacedFeature> {

    private BootstrapContext<PlacedFeature> context;

    @Override
    public void run(@NotNull BootstrapContext<PlacedFeature> context) {
        this.context = context;
        context.register(VerdurePlacedFeatures.PEBBLES, new PlacedFeature(feature(VerdureConfiguredFeatures.PEBBLES), List.of(
            RarityFilter.onAverageOnceEvery(2),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            BlockPredicateFilter.forPredicate(BlockPredicate.matchesBlocks(
                new BlockPos(0, -1, 0),
                List.of(Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.PODZOL, Blocks.COARSE_DIRT, VerdureBlocks.SMOOTH_DIRT.get(), Blocks.SAND)
            )), BiomeFilter.biome()
        )));
    }

    private Holder.Reference<ConfiguredFeature<?, ?>> feature(ResourceKey<ConfiguredFeature<?, ?>> key) {
        return context.lookup(Registries.CONFIGURED_FEATURE).getOrThrow(key);
    }

}