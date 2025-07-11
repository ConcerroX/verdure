package samebutdifferent.verdure.data;

import net.minecraft.core.Direction;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.MultifaceBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.BlockStateConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import org.jetbrains.annotations.NotNull;
import samebutdifferent.verdure.registry.VerdureBlocks;
import samebutdifferent.verdure.registry.VerdureConfiguredFeatures;
import samebutdifferent.verdure.registry.VerdureFeatures;

public class ConfiguredFeaturesProvider implements RegistrySetBuilder.RegistryBootstrap<ConfiguredFeature<?, ?>> {

    @Override
    public void run(@NotNull BootstapContext<ConfiguredFeature<?, ?>> context) {
        context.register(VerdureConfiguredFeatures.BOULDER_STONE, new ConfiguredFeature<>(Feature.FOREST_ROCK,
            new BlockStateConfiguration(Blocks.STONE.defaultBlockState())));
        context.register(VerdureConfiguredFeatures.BOULDER_DIORITE, new ConfiguredFeature<>(Feature.FOREST_ROCK,
            new BlockStateConfiguration(Blocks.DIORITE.defaultBlockState())));
        context.register(VerdureConfiguredFeatures.BOULDER_GRANITE, new ConfiguredFeature<>(Feature.FOREST_ROCK,
            new BlockStateConfiguration(Blocks.GRANITE.defaultBlockState())));
        context.register(VerdureConfiguredFeatures.BOULDER_ANDESITE, new ConfiguredFeature<>(Feature.FOREST_ROCK,
            new BlockStateConfiguration(Blocks.ANDESITE.defaultBlockState())));
        context.register(VerdureConfiguredFeatures.BOULDER_SLATE, new ConfiguredFeature<>(Feature.FOREST_ROCK,
            new BlockStateConfiguration(VerdureBlocks.SLATE.get().defaultBlockState())));

        context.register(VerdureConfiguredFeatures.PEBBLES, new ConfiguredFeature<>(Feature.SIMPLE_BLOCK,
            new SimpleBlockConfiguration(BlockStateProvider.simple(VerdureBlocks.PEBBLES.get()))));
        context.register(VerdureConfiguredFeatures.ROCK, new ConfiguredFeature<>(Feature.SIMPLE_BLOCK,
            new SimpleBlockConfiguration(BlockStateProvider.simple(VerdureBlocks.ROCK.get()))));

        context.register(VerdureConfiguredFeatures.PATCH_CLOVER, new ConfiguredFeature<>(Feature.RANDOM_PATCH,
            new RandomPatchConfiguration(64, 5, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                new SimpleBlockConfiguration(BlockStateProvider.simple(VerdureBlocks.CLOVER.get()))))));

        context.register(VerdureConfiguredFeatures.PATCH_DAISIES, new ConfiguredFeature<>(Feature.RANDOM_PATCH,
            new RandomPatchConfiguration(48, 2, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                new SimpleBlockConfiguration(BlockStateProvider.simple(VerdureBlocks.DAISIES.get().defaultBlockState()
                    .setValue(MultifaceBlock.getFaceProperty(Direction.DOWN), true)))))));
        context.register(VerdureConfiguredFeatures.PATCH_DAISIES_BLUE, new ConfiguredFeature<>(Feature.RANDOM_PATCH,
            new RandomPatchConfiguration(48, 2, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                new SimpleBlockConfiguration(BlockStateProvider.simple(
                    VerdureBlocks.BLUE_DAISIES.get().defaultBlockState()
                        .setValue(MultifaceBlock.getFaceProperty(Direction.DOWN), true)))))));
        context.register(VerdureConfiguredFeatures.PATCH_DAISIES_PINK, new ConfiguredFeature<>(Feature.RANDOM_PATCH,
            new RandomPatchConfiguration(48, 2, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                new SimpleBlockConfiguration(BlockStateProvider.simple(
                    VerdureBlocks.PINK_DAISIES.get().defaultBlockState()
                        .setValue(MultifaceBlock.getFaceProperty(Direction.DOWN), true)))))));
        context.register(VerdureConfiguredFeatures.PATCH_WILDFLOWERS, new ConfiguredFeature<>(Feature.RANDOM_PATCH,
            new RandomPatchConfiguration(48, 2, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                new SimpleBlockConfiguration(BlockStateProvider.simple(
                    VerdureBlocks.WILDFLOWERS.get().defaultBlockState()
                        .setValue(MultifaceBlock.getFaceProperty(Direction.DOWN), true)))))));

        // CAVE FEATURES
        context.register(VerdureConfiguredFeatures.MUSHROOM_SHELF,
            new ConfiguredFeature<>(VerdureFeatures.MUSHROOM_SHELF.get(), FeatureConfiguration.NONE));
        context.register(VerdureConfiguredFeatures.UNDERGROUND_MUSHROOM_SHELF,
            new ConfiguredFeature<>(VerdureFeatures.UNDERGROUND_MUSHROOM_SHELF.get(), FeatureConfiguration.NONE));
        context.register(VerdureConfiguredFeatures.HANGING_MOSS,
            new ConfiguredFeature<>(VerdureFeatures.HANGING_MOSS.get(), new SimpleBlockConfiguration(
                new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                    .add(VerdureBlocks.HANGING_MOSS.get().defaultBlockState(), 1)
                    .add(VerdureBlocks.TALL_HANGING_MOSS.get().defaultBlockState(), 1)))));
    }

}