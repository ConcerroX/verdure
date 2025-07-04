package samebutdifferent.verdure.registry;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.placement.*;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import samebutdifferent.verdure.Verdure;

import java.util.List;

import static net.minecraft.data.worldgen.placement.VegetationPlacements.treePlacement;

public class VerdurePlacedFeatures {

    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(
        Registries.PLACED_FEATURE,
        Verdure.MOD_ID
    );

    // MISC OVERWORLD PLACEMENTS
    public static final DeferredHolder<PlacedFeature, PlacedFeature> BOULDER_STONE = PLACED_FEATURES.register(
        "boulder_stone", () -> new PlacedFeature(
            VerdureConfiguredFeatures.BOULDER_STONE, List.of(
            RarityFilter.onAverageOnceEvery(4),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP,
            BiomeFilter.biome()
        )
        )
    );
    public static final DeferredHolder<PlacedFeature, PlacedFeature> BOULDER_DIORITE = PLACED_FEATURES.register(
        "boulder_diorite", () -> new PlacedFeature(
            VerdureConfiguredFeatures.BOULDER_DIORITE, List.of(
            RarityFilter.onAverageOnceEvery(4),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP,
            BiomeFilter.biome()
        )
        )
    );
    public static final DeferredHolder<PlacedFeature, PlacedFeature> BOULDER_GRANITE = PLACED_FEATURES.register(
        "boulder_granite", () -> new PlacedFeature(
            VerdureConfiguredFeatures.BOULDER_GRANITE, List.of(
            RarityFilter.onAverageOnceEvery(4),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP,
            BiomeFilter.biome()
        )
        )
    );
    public static final DeferredHolder<PlacedFeature, PlacedFeature> BOULDER_ANDESITE = PLACED_FEATURES.register(
        "boulder_andesite", () -> new PlacedFeature(
            VerdureConfiguredFeatures.BOULDER_ANDESITE, List.of(
            RarityFilter.onAverageOnceEvery(4),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP,
            BiomeFilter.biome()
        )
        )
    );
    public static final DeferredHolder<PlacedFeature, PlacedFeature> BOULDER_SLATE = PLACED_FEATURES.register(
        "boulder_slate", () -> new PlacedFeature(
            VerdureConfiguredFeatures.BOULDER_SLATE, List.of(
            RarityFilter.onAverageOnceEvery(4),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP,
            BiomeFilter.biome()
        )
        )
    );
    public static final DeferredHolder<PlacedFeature, PlacedFeature> SMOOTH_DIRT_PATCH = PLACED_FEATURES.register(
        "smooth_dirt_patch", () -> new PlacedFeature(
            VerdureConfiguredFeatures.SMOOTH_DIRT_PATCH, List.of(
            RarityFilter.onAverageOnceEvery(7),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP,
            BiomeFilter.biome()
        )
        )
    );
    public static final DeferredHolder<PlacedFeature, PlacedFeature> SMOOTH_DIRT_PATCH_SWAMP = PLACED_FEATURES.register(
        "smooth_dirt_patch_swamp", () -> new PlacedFeature(
            VerdureConfiguredFeatures.SMOOTH_DIRT_PATCH_SWAMP, List.of(
            RarityFilter.onAverageOnceEvery(4),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP,
            BiomeFilter.biome()
        )
        )
    );
    public static final DeferredHolder<PlacedFeature, PlacedFeature> HUMUS_PATCH = PLACED_FEATURES.register(
        "humus_patch", () -> new PlacedFeature(
            VerdureConfiguredFeatures.HUMUS_PATCH, List.of(
            RarityFilter.onAverageOnceEvery(4),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP,
            BiomeFilter.biome()
        )
        )
    );

    // VEGETATION PLACEMENTS
    public static final DeferredHolder<PlacedFeature, PlacedFeature> PATCH_CLOVER = PLACED_FEATURES.register(
        "patch_clover",
        () -> new PlacedFeature(VerdureConfiguredFeatures.PATCH_CLOVER, worldSurfaceSquaredWithRarityFilter(5))
    );
    public static final DeferredHolder<PlacedFeature, PlacedFeature> PEBBLES = PLACED_FEATURES.register(
        "pebbles", () -> new PlacedFeature(
            VerdureConfiguredFeatures.PEBBLES, List.of(
            RarityFilter.onAverageOnceEvery(2),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            BlockPredicateFilter.forPredicate(BlockPredicate.matchesBlocks(
                new BlockPos(0, -1, 0), List.of(
                    Blocks.GRASS_BLOCK,
                    Blocks.DIRT,
                    Blocks.PODZOL,
                    Blocks.COARSE_DIRT,
                    VerdureBlocks.SMOOTH_DIRT.get(),
                    Blocks.SAND
                )
            )),
            BiomeFilter.biome()
        )
        )
    );
    public static final DeferredHolder<PlacedFeature, PlacedFeature> ROCK = PLACED_FEATURES.register(
        "rock", () -> new PlacedFeature(
            VerdureConfiguredFeatures.ROCK, List.of(
            RarityFilter.onAverageOnceEvery(2),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            BlockPredicateFilter.forPredicate(BlockPredicate.matchesBlocks(
                new BlockPos(0, -1, 0), List.of(
                    Blocks.GRASS_BLOCK,
                    Blocks.DIRT,
                    Blocks.PODZOL,
                    Blocks.COARSE_DIRT,
                    VerdureBlocks.SMOOTH_DIRT.get(),
                    Blocks.SAND
                )
            )),
            BiomeFilter.biome()
        )
        )
    );
    public static final DeferredHolder<PlacedFeature, PlacedFeature> PATCH_DAISIES = PLACED_FEATURES.register(
        "patch_daisies",
        () -> new PlacedFeature(VerdureConfiguredFeatures.PATCH_DAISIES, worldSurfaceSquaredWithRarityFilter(14))
    );
    public static final DeferredHolder<PlacedFeature, PlacedFeature> PATCH_DAISIES_BLUE = PLACED_FEATURES.register(
        "patch_daisies_blue",
        () -> new PlacedFeature(VerdureConfiguredFeatures.PATCH_DAISIES_BLUE, worldSurfaceSquaredWithRarityFilter(14))
    );
    public static final DeferredHolder<PlacedFeature, PlacedFeature> PATCH_DAISIES_PINK = PLACED_FEATURES.register(
        "patch_daisies_pink",
        () -> new PlacedFeature(VerdureConfiguredFeatures.PATCH_DAISIES_PINK, worldSurfaceSquaredWithRarityFilter(14))
    );
    public static final DeferredHolder<PlacedFeature, PlacedFeature> PATCH_WILDFLOWERS = PLACED_FEATURES.register(
        "patch_wildflowers",
        () -> new PlacedFeature(VerdureConfiguredFeatures.PATCH_WILDFLOWERS, worldSurfaceSquaredWithRarityFilter(14))
    );
    public static final DeferredHolder<PlacedFeature, PlacedFeature> FALLEN_LOG = PLACED_FEATURES.register(
        "fallen_log",
        () -> new PlacedFeature(VerdureConfiguredFeatures.FALLEN_LOG, worldSurfaceSquaredWithRarityFilter(7))
    );
    public static final DeferredHolder<PlacedFeature, PlacedFeature> FALLEN_LOG_SAVANNA = PLACED_FEATURES.register(
        "fallen_log_savanna",
        () -> new PlacedFeature(VerdureConfiguredFeatures.FALLEN_LOG, worldSurfaceSquaredWithRarityFilter(11))
    );
    public static final DeferredHolder<PlacedFeature, PlacedFeature> MUSHROOM_SHELF = PLACED_FEATURES.register(
        "mushroom_shelf", () -> new PlacedFeature(
            VerdureConfiguredFeatures.MUSHROOM_SHELF, List.of(
            CountPlacement.of(256),
            InSquarePlacement.spread(),
            HeightRangePlacement.uniform(VerticalAnchor.absolute(64), VerticalAnchor.absolute(100)),
            BiomeFilter.biome()
        )
        )
    );
//    public static final DeferredHolder<PlacedFeature, PlacedFeature> TREES_BIRCH_AND_OAK = PLACED_FEATURES.register(
//        "trees_birch_and_oak",
//        () -> new PlacedFeature(
//            VerdureConfiguredFeatures.TREES_BIRCH_AND_OAK,
//            treePlacement(PlacementUtils.countExtra(10, 0.1F, 1))
//        )
//    );
//    public static final DeferredHolder<PlacedFeature, PlacedFeature> DARK_FOREST_VEGETATION = PLACED_FEATURES.register(
//        "dark_forest_vegetation", () -> new PlacedFeature(
//            VerdureConfiguredFeatures.DARK_FOREST_VEGETATION, List.of(
//            CountPlacement.of(16),
//            InSquarePlacement.spread(),
//            VegetationPlacements.TREE_THRESHOLD,
//            PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
//            BiomeFilter.biome()
//        )
//        )
//    );
    public static final DeferredHolder<PlacedFeature, PlacedFeature> TREES_TAIGA = PLACED_FEATURES.register(
        "trees_taiga",
        () -> new PlacedFeature(
            VerdureConfiguredFeatures.TREES_TAIGA,
            treePlacement(PlacementUtils.countExtra(10, 0.1F, 1))
        )
    );
    public static final DeferredHolder<PlacedFeature, PlacedFeature> TREES_WINDSWEPT_SAVANNA = PLACED_FEATURES.register(
        "trees_windswept_savanna",
        () -> new PlacedFeature(
            VerdureConfiguredFeatures.TREES_SAVANNA,
            treePlacement(PlacementUtils.countExtra(2, 0.1F, 1))
        )
    );
    public static final DeferredHolder<PlacedFeature, PlacedFeature> TREES_SAVANNA = PLACED_FEATURES.register(
        "trees_savanna",
        () -> new PlacedFeature(
            VerdureConfiguredFeatures.TREES_SAVANNA,
            treePlacement(PlacementUtils.countExtra(1, 0.1F, 1))
        )
    );
    public static final DeferredHolder<PlacedFeature, PlacedFeature> BIRCH_TALL = PLACED_FEATURES.register(
        "birch_tall",
        () -> new PlacedFeature(
            VerdureConfiguredFeatures.BIRCH_TALL,
            treePlacement(PlacementUtils.countExtra(10, 0.1F, 1))
        )
    );
    public static final DeferredHolder<PlacedFeature, PlacedFeature> TREES_BIRCH = PLACED_FEATURES.register(
        "trees_birch", () -> new PlacedFeature(
            VerdureConfiguredFeatures.BIRCH,
            treePlacement(PlacementUtils.countExtra(10, 0.1F, 1), Blocks.BIRCH_SAPLING)
        )
    );
//    public static final DeferredHolder<PlacedFeature, PlacedFeature> TREES_JUNGLE = PLACED_FEATURES.register(
//        "trees_jungle",
//        () -> new PlacedFeature(
//            VerdureConfiguredFeatures.TREES_JUNGLE,
//            treePlacement(PlacementUtils.countExtra(50, 0.1F, 1))
//        )
//    );
//    public static final DeferredHolder<PlacedFeature, PlacedFeature> TREES_SPARSE_JUNGLE = PLACED_FEATURES.register(
//        "trees_sparse_jungle",
//        () -> new PlacedFeature(
//            VerdureConfiguredFeatures.TREES_SPARSE_JUNGLE,
//            treePlacement(PlacementUtils.countExtra(2, 0.1F, 1))
//        )
//    );
//    public static final DeferredHolder<PlacedFeature, PlacedFeature> TREES_FLOWER_FOREST = PLACED_FEATURES.register(
//        "trees_flower_forest",
//        () -> new PlacedFeature(
//            VerdureConfiguredFeatures.TREES_FLOWER_FOREST,
//            treePlacement(PlacementUtils.countExtra(6, 0.1F, 1))
//        )
//    );

    // CAVE PLACEMENTS
    public static final DeferredHolder<PlacedFeature, PlacedFeature> UNDERGROUND_MUSHROOM_SHELF = PLACED_FEATURES.register(
        "underground_mushroom_shelf", () -> new PlacedFeature(
            VerdureConfiguredFeatures.UNDERGROUND_MUSHROOM_SHELF, List.of(
            CountPlacement.of(UniformInt.of(104, 157)),
            PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT,
            InSquarePlacement.spread(),
            SurfaceRelativeThresholdFilter.of(Heightmap.Types.OCEAN_FLOOR_WG, Integer.MIN_VALUE, -13),
            BiomeFilter.biome()
        )
        )
    );
    public static final DeferredHolder<PlacedFeature, PlacedFeature> HANGING_MOSS = PLACED_FEATURES.register(
        "hanging_moss", () -> new PlacedFeature(
            VerdureConfiguredFeatures.HANGING_MOSS, List.of(
            CountPlacement.of(128),
            InSquarePlacement.spread(),
            PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT,
            EnvironmentScanPlacement.scanningFor(
                Direction.UP,
                BlockPredicate.solid(),
                BlockPredicate.ONLY_IN_AIR_PREDICATE,
                12
            ),
            RandomOffsetPlacement.vertical(ConstantInt.of(-1)),
            BiomeFilter.biome()
        )
        )
    );

    // TREE PLACEMENTS
    public static final DeferredHolder<PlacedFeature, PlacedFeature> OAK_DAISIES = PLACED_FEATURES.register(
        "oak_daisies", () -> new PlacedFeature(
            VerdureConfiguredFeatures.OAK_DAISIES, List.of(
            RarityFilter.onAverageOnceEvery(13),
            InSquarePlacement.spread(),
            SurfaceWaterDepthFilter.forMaxDepth(0),
            PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
            BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(
                Blocks.OAK_SAPLING.defaultBlockState(),
                BlockPos.ZERO
            )),
            BiomeFilter.biome()
        )
        )
    );
    public static final DeferredHolder<PlacedFeature, PlacedFeature> BIRCH_DAISIES = PLACED_FEATURES.register(
        "birch_daisies", () -> new PlacedFeature(
            VerdureConfiguredFeatures.BIRCH_DAISIES, List.of(
            RarityFilter.onAverageOnceEvery(13),
            InSquarePlacement.spread(),
            SurfaceWaterDepthFilter.forMaxDepth(0),
            PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
            BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(
                Blocks.BIRCH_SAPLING.defaultBlockState(),
                BlockPos.ZERO
            )),
            BiomeFilter.biome()
        )
        )
    );
    public static final DeferredHolder<PlacedFeature, PlacedFeature> OAK_HOLLOW = PLACED_FEATURES.register(
        "oak_hollow", () -> new PlacedFeature(
            VerdureConfiguredFeatures.OAK_HOLLOW, List.of(
            RarityFilter.onAverageOnceEvery(10),
            InSquarePlacement.spread(),
            SurfaceWaterDepthFilter.forMaxDepth(0),
            PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
            BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(
                Blocks.OAK_SAPLING.defaultBlockState(),
                BlockPos.ZERO
            )),
            BiomeFilter.biome()
        )
        )
    );
    public static final DeferredHolder<PlacedFeature, PlacedFeature> FANCY_OAK_HOLLOW = PLACED_FEATURES.register(
        "fancy_oak_hollow", () -> new PlacedFeature(
            VerdureConfiguredFeatures.FANCY_OAK_HOLLOW, List.of(
            RarityFilter.onAverageOnceEvery(10),
            InSquarePlacement.spread(),
            SurfaceWaterDepthFilter.forMaxDepth(0),
            PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
            BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(
                Blocks.OAK_SAPLING.defaultBlockState(),
                BlockPos.ZERO
            )),
            BiomeFilter.biome()
        )
        )
    );
    public static final DeferredHolder<PlacedFeature, PlacedFeature> OAK_CHECKED = PLACED_FEATURES.register(
        "oak_checked",
        () -> new PlacedFeature(
            VerdureConfiguredFeatures.OAK,
            List.of(PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING))
        )
    );
    public static final DeferredHolder<PlacedFeature, PlacedFeature> BIRCH_CHECKED = PLACED_FEATURES.register(
        "birch_checked",
        () -> new PlacedFeature(
            VerdureConfiguredFeatures.BIRCH,
            List.of(PlacementUtils.filteredByBlockSurvival(Blocks.BIRCH_SAPLING))
        )
    );
    public static final DeferredHolder<PlacedFeature, PlacedFeature> SUPER_BIRCH_CHECKED = PLACED_FEATURES.register(
        "super_birch_checked", () -> new PlacedFeature(
            VerdureConfiguredFeatures.SUPER_BIRCH,
            List.of(PlacementUtils.filteredByBlockSurvival(Blocks.BIRCH_SAPLING))
        )
    );
    public static final DeferredHolder<PlacedFeature, PlacedFeature> DARK_OAK_CHECKED = PLACED_FEATURES.register(
        "dark_oak_checked", () -> new PlacedFeature(
            VerdureConfiguredFeatures.DARK_OAK,
            List.of(PlacementUtils.filteredByBlockSurvival(Blocks.DARK_OAK_SAPLING))
        )
    );
    public static final DeferredHolder<PlacedFeature, PlacedFeature> SPRUCE_CHECKED = PLACED_FEATURES.register(
        "spruce_checked",
        () -> new PlacedFeature(
            VerdureConfiguredFeatures.SPRUCE,
            List.of(PlacementUtils.filteredByBlockSurvival(Blocks.SPRUCE_SAPLING))
        )
    );
    public static final DeferredHolder<PlacedFeature, PlacedFeature> PINE_CHECKED = PLACED_FEATURES.register(
        "pine_checked",
        () -> new PlacedFeature(
            VerdureConfiguredFeatures.PINE,
            List.of(PlacementUtils.filteredByBlockSurvival(Blocks.SPRUCE_SAPLING))
        )
    );
    public static final DeferredHolder<PlacedFeature, PlacedFeature> ACACIA_CHECKED = PLACED_FEATURES.register(
        "acacia_checked",
        () -> new PlacedFeature(
            VerdureConfiguredFeatures.ACACIA,
            List.of(PlacementUtils.filteredByBlockSurvival(Blocks.ACACIA_SAPLING))
        )
    );
//    public static final DeferredHolder<PlacedFeature, PlacedFeature> JUNGLE_TREE_CHECKED = PLACED_FEATURES.register(
//        "jungle_tree_checked", () -> new PlacedFeature(
//            VerdureConfiguredFeatures.JUNGLE_TREE,
//            List.of(PlacementUtils.filteredByBlockSurvival(Blocks.JUNGLE_SAPLING))
//        )
//    );

    // NETHER PLACEMENTS
    public static final DeferredHolder<PlacedFeature, PlacedFeature> FALLEN_LOG_NETHER = PLACED_FEATURES.register(
        "fallen_log_nether",
        () -> new PlacedFeature(
            VerdureConfiguredFeatures.FALLEN_LOG,
            List.of(CountOnEveryLayerPlacement.of(3), BiomeFilter.biome())
        )
    );

    public static List<PlacementModifier> worldSurfaceSquaredWithRarityFilter(int chance) {
        return List.of(
            RarityFilter.onAverageOnceEvery(chance),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            BiomeFilter.biome()
        );
    }
}
