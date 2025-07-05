package samebutdifferent.verdure.registry;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.placement.*;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import samebutdifferent.verdure.Verdure;

import java.util.List;

public class VerdurePlacedFeatures {

    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(
        Registries.PLACED_FEATURE, Verdure.MOD_ID);

    // MISC OVERWORLD PLACEMENTS
    public static final ResourceKey<PlacedFeature> BOULDER_STONE = create("boulder_stone");
    public static final ResourceKey<PlacedFeature> BOULDER_DIORITE = create("boulder_diorite");
    public static final ResourceKey<PlacedFeature> BOULDER_GRANITE = create("boulder_granite");
    public static final ResourceKey<PlacedFeature> BOULDER_ANDESITE = create("boulder_andesite");
    public static final ResourceKey<PlacedFeature> BOULDER_SLATE = create("boulder_slate");

    public static final DeferredHolder<PlacedFeature, PlacedFeature> SMOOTH_DIRT_PATCH = PLACED_FEATURES.register(
        "smooth_dirt_patch", () -> new PlacedFeature(VerdureConfiguredFeatures.SMOOTH_DIRT_PATCH,
            List.of(RarityFilter.onAverageOnceEvery(7), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP,
                BiomeFilter.biome())));
    public static final DeferredHolder<PlacedFeature, PlacedFeature> SMOOTH_DIRT_PATCH_SWAMP = PLACED_FEATURES.register(
        "smooth_dirt_patch_swamp", () -> new PlacedFeature(VerdureConfiguredFeatures.SMOOTH_DIRT_PATCH_SWAMP,
            List.of(RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP,
                BiomeFilter.biome())));
    public static final DeferredHolder<PlacedFeature, PlacedFeature> HUMUS_PATCH = PLACED_FEATURES.register(
        "humus_patch", () -> new PlacedFeature(VerdureConfiguredFeatures.HUMUS_PATCH,
            List.of(RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP,
                BiomeFilter.biome())));

    // VEGETATION PLACEMENTS
    public static final ResourceKey<PlacedFeature> PEBBLES = create("pebbles");
    public static final ResourceKey<PlacedFeature> ROCK = create("rock");

    public static final ResourceKey<PlacedFeature> PATCH_CLOVER = create("patch_clover");
    public static final ResourceKey<PlacedFeature> PATCH_DAISIES = create("patch_daisies");
    public static final ResourceKey<PlacedFeature> PATCH_DAISIES_BLUE = create("patch_daisies_blue");
    public static final ResourceKey<PlacedFeature> PATCH_DAISIES_PINK = create("patch_daisies_pink");
    public static final ResourceKey<PlacedFeature> PATCH_WILDFLOWERS = create("patch_wildflowers");

//    public static final DeferredHolder<PlacedFeature, PlacedFeature> FALLEN_LOG = PLACED_FEATURES.register("fallen_log",
//        () -> new PlacedFeature(VerdureConfiguredFeatures.FALLEN_LOG, worldSurfaceSquaredWithRarityFilter(7)));
//    public static final DeferredHolder<PlacedFeature, PlacedFeature> FALLEN_LOG_SAVANNA = PLACED_FEATURES.register(
//        "fallen_log_savanna",
//        () -> new PlacedFeature(VerdureConfiguredFeatures.FALLEN_LOG, worldSurfaceSquaredWithRarityFilter(11)));

    // CAVE PLACEMENTS
    public static final ResourceKey<PlacedFeature> MUSHROOM_SHELF = create("mushroom_shelf");
    public static final ResourceKey<PlacedFeature> UNDERGROUND_MUSHROOM_SHELF = create("underground_mushroom_shelf");
    public static final ResourceKey<PlacedFeature> HANGING_MOSS = create("hanging_moss");

    // TREE PLACEMENTS
//    public static final DeferredHolder<PlacedFeature, PlacedFeature> OAK_DAISIES = PLACED_FEATURES.register(
//        "oak_daisies", () -> new PlacedFeature(VerdureConfiguredFeatures.OAK_DAISIES,
//            List.of(RarityFilter.onAverageOnceEvery(13), InSquarePlacement.spread(),
//                SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
//                BlockPredicateFilter.forPredicate(
//                    BlockPredicate.wouldSurvive(Blocks.OAK_SAPLING.defaultBlockState(), BlockPos.ZERO)),
//                BiomeFilter.biome())));
//    public static final DeferredHolder<PlacedFeature, PlacedFeature> BIRCH_DAISIES = PLACED_FEATURES.register(
//        "birch_daisies", () -> new PlacedFeature(VerdureConfiguredFeatures.BIRCH_DAISIES,
//            List.of(RarityFilter.onAverageOnceEvery(13), InSquarePlacement.spread(),
//                SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
//                BlockPredicateFilter.forPredicate(
//                    BlockPredicate.wouldSurvive(Blocks.BIRCH_SAPLING.defaultBlockState(), BlockPos.ZERO)),
//                BiomeFilter.biome())));

    public static final DeferredHolder<PlacedFeature, PlacedFeature> OAK_HOLLOW = PLACED_FEATURES.register("oak_hollow",
        () -> new PlacedFeature(VerdureConfiguredFeatures.OAK_HOLLOW,
            List.of(RarityFilter.onAverageOnceEvery(10), InSquarePlacement.spread(),
                SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
                BlockPredicateFilter.forPredicate(
                    BlockPredicate.wouldSurvive(Blocks.OAK_SAPLING.defaultBlockState(), BlockPos.ZERO)),
                BiomeFilter.biome())));
    public static final DeferredHolder<PlacedFeature, PlacedFeature> FANCY_OAK_HOLLOW = PLACED_FEATURES.register(
        "fancy_oak_hollow", () -> new PlacedFeature(VerdureConfiguredFeatures.FANCY_OAK_HOLLOW,
            List.of(RarityFilter.onAverageOnceEvery(10), InSquarePlacement.spread(),
                SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
                BlockPredicateFilter.forPredicate(
                    BlockPredicate.wouldSurvive(Blocks.OAK_SAPLING.defaultBlockState(), BlockPos.ZERO)),
                BiomeFilter.biome())));

    // NETHER PLACEMENTS
//    public static final DeferredHolder<PlacedFeature, PlacedFeature> FALLEN_LOG_NETHER = PLACED_FEATURES.register(
//        "fallen_log_nether", () -> new PlacedFeature(VerdureConfiguredFeatures.FALLEN_LOG,
//            List.of(CountOnEveryLayerPlacement.of(3), BiomeFilter.biome())));

    public static List<PlacementModifier> worldSurfaceSquaredWithRarityFilter(int chance) {
        return List.of(RarityFilter.onAverageOnceEvery(chance), InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
    }


    private static ResourceKey<PlacedFeature> create(String path) {
        return ResourceKey.create(Registries.PLACED_FEATURE, Verdure.res(path));
    }


}
