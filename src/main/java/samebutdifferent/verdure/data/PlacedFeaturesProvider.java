package samebutdifferent.verdure.data;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.VerticalAnchor;
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

        var boulderPlacement = List.of(
            RarityFilter.onAverageOnceEvery(4),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP,
            BiomeFilter.biome()
        );
        context.register(VerdurePlacedFeatures.BOULDER_STONE, new PlacedFeature(feature(VerdureConfiguredFeatures.BOULDER_STONE),
            boulderPlacement));
        context.register(VerdurePlacedFeatures.BOULDER_DIORITE, new PlacedFeature(feature(VerdureConfiguredFeatures.BOULDER_DIORITE),
            boulderPlacement));
        context.register(VerdurePlacedFeatures.BOULDER_GRANITE, new PlacedFeature(feature(VerdureConfiguredFeatures.BOULDER_GRANITE),
            boulderPlacement));
        context.register(VerdurePlacedFeatures.BOULDER_ANDESITE, new PlacedFeature(feature(VerdureConfiguredFeatures.BOULDER_ANDESITE),
            boulderPlacement));
        context.register(VerdurePlacedFeatures.BOULDER_SLATE, new PlacedFeature(feature(VerdureConfiguredFeatures.BOULDER_SLATE),
            boulderPlacement));

        var rockAndPebblesPlacement = List.of(
            RarityFilter.onAverageOnceEvery(2),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            BlockPredicateFilter.forPredicate(BlockPredicate.matchesBlocks(
                new BlockPos(0, -1, 0),
                List.of(Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.PODZOL, Blocks.COARSE_DIRT, VerdureBlocks.SMOOTH_DIRT.get(), Blocks.SAND)
            )),
            BiomeFilter.biome()
        );
        context.register(VerdurePlacedFeatures.PEBBLES, new PlacedFeature(feature(VerdureConfiguredFeatures.PEBBLES),
            rockAndPebblesPlacement));
        context.register(VerdurePlacedFeatures.ROCK, new PlacedFeature(feature(VerdureConfiguredFeatures.ROCK),
            rockAndPebblesPlacement));

        context.register(VerdurePlacedFeatures.PATCH_CLOVER, new PlacedFeature(feature(VerdureConfiguredFeatures.PATCH_CLOVER), List.of(
            RarityFilter.onAverageOnceEvery(5),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            BiomeFilter.biome()
        )));

        var wildflowersPlacement = List.of(
            RarityFilter.onAverageOnceEvery(14),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            BiomeFilter.biome()
        );
        context.register(VerdurePlacedFeatures.PATCH_DAISIES, new PlacedFeature(feature(VerdureConfiguredFeatures.PATCH_DAISIES),
            wildflowersPlacement));
        context.register(VerdurePlacedFeatures.PATCH_DAISIES_BLUE, new PlacedFeature(feature(VerdureConfiguredFeatures.PATCH_DAISIES_BLUE),
            wildflowersPlacement));
        context.register(VerdurePlacedFeatures.PATCH_DAISIES_PINK, new PlacedFeature(feature(VerdureConfiguredFeatures.PATCH_DAISIES_PINK),
            wildflowersPlacement));
        context.register(VerdurePlacedFeatures.PATCH_WILDFLOWERS, new PlacedFeature(feature(VerdureConfiguredFeatures.PATCH_WILDFLOWERS),
            wildflowersPlacement));

        context.register(VerdurePlacedFeatures.MUSHROOM_SHELF, new PlacedFeature(feature(VerdureConfiguredFeatures.MUSHROOM_SHELF), List.of(
            CountPlacement.of(256),
            InSquarePlacement.spread(),
            HeightRangePlacement.uniform(VerticalAnchor.absolute(64), VerticalAnchor.absolute(100)),
            BiomeFilter.biome()
        )));
        context.register(VerdurePlacedFeatures.UNDERGROUND_MUSHROOM_SHELF, new PlacedFeature(feature(VerdureConfiguredFeatures.UNDERGROUND_MUSHROOM_SHELF), List.of(
            CountPlacement.of(UniformInt.of(104, 157)),
            PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT,
            InSquarePlacement.spread(),
            SurfaceRelativeThresholdFilter.of(Heightmap.Types.OCEAN_FLOOR_WG, Integer.MIN_VALUE, -13),
            BiomeFilter.biome()
        )));
        context.register(VerdurePlacedFeatures.HANGING_MOSS, new PlacedFeature(feature(VerdureConfiguredFeatures.HANGING_MOSS), List.of(
            CountPlacement.of(128),
            InSquarePlacement.spread(),
            PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT,
            EnvironmentScanPlacement.scanningFor(
                Direction.UP, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12
            ), RandomOffsetPlacement.vertical(ConstantInt.of(-1)),
            BiomeFilter.biome()))
        );
    }

    private Holder.Reference<ConfiguredFeature<?, ?>> feature(ResourceKey<ConfiguredFeature<?, ?>> key) {
        return context.lookup(Registries.CONFIGURED_FEATURE).getOrThrow(key);
    }

    private static List<PlacementModifier> worldSurfaceSquaredWithRarityFilter(int chance) {
        return List.of(RarityFilter.onAverageOnceEvery(chance), InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
    }

}