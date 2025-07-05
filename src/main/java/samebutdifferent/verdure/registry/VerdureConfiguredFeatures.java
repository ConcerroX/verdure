package samebutdifferent.verdure.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.RuleBasedBlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import samebutdifferent.verdure.Verdure;
import samebutdifferent.verdure.worldgen.treedecorator.HollowLogDecorator;

import java.util.List;
import java.util.OptionalInt;

public class VerdureConfiguredFeatures {

    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = DeferredRegister.create(
        Registries.CONFIGURED_FEATURE, Verdure.MOD_ID);

    // MISC OVERWORLD FEATURES
    public static final ResourceKey<ConfiguredFeature<?, ?>> BOULDER_STONE = create("boulder_stone");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BOULDER_DIORITE = create("boulder_diorite");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BOULDER_GRANITE = create("boulder_granite");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BOULDER_ANDESITE = create("boulder_andesite");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BOULDER_SLATE = create("boulder_slate");

    public static final DeferredHolder<ConfiguredFeature<?, ?>, ConfiguredFeature<?, ?>> SMOOTH_DIRT_PATCH = CONFIGURED_FEATURES.register(
        "smooth_dirt_patch", () -> new ConfiguredFeature<>(VerdureFeatures.DITHERED_DISK.get(),
            new DiskConfiguration(RuleBasedBlockStateProvider.simple(VerdureBlocks.SMOOTH_DIRT.get()),
                BlockPredicate.matchesBlocks(Blocks.DIRT, Blocks.GRASS_BLOCK, Blocks.PODZOL, Blocks.COARSE_DIRT,
                    Blocks.MYCELIUM), UniformInt.of(4, 6), 1)));
    public static final DeferredHolder<ConfiguredFeature<?, ?>, ConfiguredFeature<?, ?>> SMOOTH_DIRT_PATCH_SWAMP = CONFIGURED_FEATURES.register(
        "smooth_dirt_patch_swamp", () -> new ConfiguredFeature<>(VerdureFeatures.DITHERED_DISK.get(),
            new DiskConfiguration(RuleBasedBlockStateProvider.simple(VerdureBlocks.SMOOTH_DIRT.get()),
                BlockPredicate.matchesBlocks(Blocks.DIRT, Blocks.GRASS_BLOCK, Blocks.PODZOL, Blocks.COARSE_DIRT,
                    Blocks.MYCELIUM), UniformInt.of(5, 8), 1)));
    public static final DeferredHolder<ConfiguredFeature<?, ?>, ConfiguredFeature<?, ?>> HUMUS_PATCH = CONFIGURED_FEATURES.register(
        "humus_patch", () -> new ConfiguredFeature<>(VerdureFeatures.DITHERED_DISK.get(),
            new DiskConfiguration(RuleBasedBlockStateProvider.simple(VerdureBlocks.HUMUS.get()),
                BlockPredicate.matchesBlocks(Blocks.DIRT, Blocks.GRASS_BLOCK, Blocks.PODZOL, Blocks.COARSE_DIRT,
                    Blocks.MYCELIUM), UniformInt.of(5, 8), 1)));

    // VEGETATION FEATURES
    public static final ResourceKey<ConfiguredFeature<?, ?>> PEBBLES = create("pebbles");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ROCK = create("rock");

    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_CLOVER = create("patch_clover");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_DAISIES = create("patch_daisies");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_DAISIES_BLUE = create("patch_daisies_blue");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_DAISIES_PINK = create("patch_daisies_pink");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_WILDFLOWERS = create("patch_wildflowers");

    // CAVE FEATURES
    public static final ResourceKey<ConfiguredFeature<?, ?>> MUSHROOM_SHELF = create("mushroom_shelf");
    public static final ResourceKey<ConfiguredFeature<?, ?>> UNDERGROUND_MUSHROOM_SHELF = create("underground_mushroom_shelf");
    public static final ResourceKey<ConfiguredFeature<?, ?>> HANGING_MOSS = create("hanging_moss");

    // TREE FEATURES
//    public static final DeferredHolder<ConfiguredFeature<?, ?>, ConfiguredFeature<?, ?>> OAK_DAISIES = CONFIGURED_FEATURES.register(
//        "oak_daisies", () -> new ConfiguredFeature<>(Feature.TREE,
//            createStraightBlobTree(Blocks.OAK_LOG, Blocks.OAK_LEAVES, 4, 2, 0, 2).ignoreVines()
//                .decorators(List.of(new DaisiesDecorator())).build()));
//    public static final DeferredHolder<ConfiguredFeature<?, ?>, ConfiguredFeature<?, ?>> BIRCH_DAISIES = CONFIGURED_FEATURES.register(
//        "birch_daisies", () -> new ConfiguredFeature<>(Feature.TREE,
//            createStraightBlobTree(Blocks.BIRCH_LOG, Blocks.BIRCH_LEAVES, 5, 2, 0, 2).ignoreVines()
//                .decorators(List.of(new DaisiesDecorator())).build()));

    public static final DeferredHolder<ConfiguredFeature<?, ?>, ConfiguredFeature<?, ?>> OAK_HOLLOW = CONFIGURED_FEATURES.register(
        "oak_hollow", () -> new ConfiguredFeature<>(Feature.TREE,
            createStraightBlobTree(Blocks.OAK_LOG, Blocks.OAK_LEAVES, 5, 1, 0, 2).ignoreVines()
                .decorators(List.of(new HollowLogDecorator())).build()));
    public static final DeferredHolder<ConfiguredFeature<?, ?>, ConfiguredFeature<?, ?>> FANCY_OAK_HOLLOW = CONFIGURED_FEATURES.register(
        "fancy_oak_hollow", () -> new ConfiguredFeature<>(Feature.TREE,
            new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.OAK_LOG),
                new FancyTrunkPlacer(3, 11, 0), BlockStateProvider.simple(Blocks.OAK_LEAVES),
                new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4),
                new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))).ignoreVines()
                .decorators(List.of(new HollowLogDecorator())).build()));

    private static TreeConfiguration.TreeConfigurationBuilder createStraightBlobTree(Block logBlock, Block leavesBlock,
        int baseTrunkHeight, int heightRandA, int heightRandB, int foliageRadius
    ) {
        return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(logBlock),
            new StraightTrunkPlacer(baseTrunkHeight, heightRandA, heightRandB), BlockStateProvider.simple(leavesBlock),
            new BlobFoliagePlacer(ConstantInt.of(foliageRadius), ConstantInt.of(0), 3),
            new TwoLayersFeatureSize(1, 0, 1));
    }

    private static ResourceKey<ConfiguredFeature<?, ?>> create(String path) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, Verdure.res(path));
    }

}
