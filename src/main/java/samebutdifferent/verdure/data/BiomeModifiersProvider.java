package samebutdifferent.verdure.data;

import net.minecraft.core.HolderSet;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;
import samebutdifferent.verdure.registry.VerdurePlacedFeatures;
import samebutdifferent.verdure.registry.VerdureTags;

import java.util.Arrays;

import static samebutdifferent.verdure.Verdure.res;

public class BiomeModifiersProvider implements RegistrySetBuilder.RegistryBootstrap<BiomeModifier> {

    private BootstapContext<BiomeModifier> context;

    @Override
    public void run(@NotNull BootstapContext<BiomeModifier> context) {
        this.context = context;
        var biomes = context.lookup(Registries.BIOME);
        register("add_boulder_stone",
            new ForgeBiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(VerdureTags.Biomes.HAS_BOULDER_STONE),
                features(VerdurePlacedFeatures.BOULDER_STONE), GenerationStep.Decoration.LOCAL_MODIFICATIONS));
        register("add_boulder_diorite",
            new ForgeBiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(VerdureTags.Biomes.HAS_BOULDER_DIORITE),
                features(VerdurePlacedFeatures.BOULDER_DIORITE), GenerationStep.Decoration.LOCAL_MODIFICATIONS));
        register("add_boulder_granite",
            new ForgeBiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(VerdureTags.Biomes.HAS_BOULDER_GRANITE),
                features(VerdurePlacedFeatures.BOULDER_GRANITE), GenerationStep.Decoration.LOCAL_MODIFICATIONS));
        register("add_boulder_andesite",
            new ForgeBiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(VerdureTags.Biomes.HAS_BOULDER_ANDESITE),
                features(VerdurePlacedFeatures.BOULDER_ANDESITE), GenerationStep.Decoration.LOCAL_MODIFICATIONS));
        register("add_boulder_slate",
            new ForgeBiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(VerdureTags.Biomes.HAS_BOULDER_SLATE),
                features(VerdurePlacedFeatures.BOULDER_SLATE), GenerationStep.Decoration.LOCAL_MODIFICATIONS));

        register("add_pebbles",
            new ForgeBiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(VerdureTags.Biomes.HAS_PEBBLES),
                features(VerdurePlacedFeatures.PEBBLES), GenerationStep.Decoration.LOCAL_MODIFICATIONS));
        register("add_patch_clover",
            new ForgeBiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(VerdureTags.Biomes.HAS_PATCH_CLOVER),
                features(VerdurePlacedFeatures.PATCH_CLOVER), GenerationStep.Decoration.VEGETAL_DECORATION));
        register("add_patch_daisies",
            new ForgeBiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(VerdureTags.Biomes.HAS_PATCH_DAISIES),
                features(VerdurePlacedFeatures.PATCH_DAISIES, VerdurePlacedFeatures.PATCH_DAISIES_BLUE,
                    VerdurePlacedFeatures.PATCH_DAISIES_PINK), GenerationStep.Decoration.VEGETAL_DECORATION));
        register("add_patch_wildflowers",
            new ForgeBiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(VerdureTags.Biomes.HAS_PATCH_WILDFLOWERS),
                features(VerdurePlacedFeatures.PATCH_WILDFLOWERS), GenerationStep.Decoration.VEGETAL_DECORATION));

        register("add_mushroom_shelves",
            new ForgeBiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(VerdureTags.Biomes.HAS_MUSHROOM_SHELVES),
                features(VerdurePlacedFeatures.MUSHROOM_SHELF), GenerationStep.Decoration.VEGETAL_DECORATION));
        register("add_underground_mushroom_shelves", new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
            biomes.getOrThrow(VerdureTags.Biomes.HAS_UNDERGROUND_MUSHROOM_SHELVES),
            features(VerdurePlacedFeatures.UNDERGROUND_MUSHROOM_SHELF), GenerationStep.Decoration.VEGETAL_DECORATION));
        register("add_hanging_moss",
            new ForgeBiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(VerdureTags.Biomes.HAS_HANGING_MOSS),
                features(VerdurePlacedFeatures.HANGING_MOSS), GenerationStep.Decoration.VEGETAL_DECORATION));
    }

    private void register(String path, BiomeModifier modifier) {
        context.register(ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, res(path)), modifier);
    }

    @SafeVarargs
    private HolderSet.Direct<PlacedFeature> features(ResourceKey<PlacedFeature>... keys) {
        return HolderSet.direct(
            Arrays.stream(keys).map(it -> context.lookup(Registries.PLACED_FEATURE).getOrThrow(it)).toList());
    }

}