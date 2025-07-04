package samebutdifferent.verdure.data;

import net.minecraft.core.HolderSet;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.jetbrains.annotations.NotNull;
import samebutdifferent.verdure.registry.VerdurePlacedFeatures;
import samebutdifferent.verdure.registry.VerdureTags;

import static samebutdifferent.verdure.Verdure.res;

public class BiomeModifiersProvider implements RegistrySetBuilder.RegistryBootstrap<BiomeModifier> {

    private BootstrapContext<BiomeModifier> context;

    @Override
    public void run(@NotNull BootstrapContext<BiomeModifier> context) {
        this.context = context;
        var biomes = context.lookup(Registries.BIOME);
        register("add_pebbles",
            new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(VerdureTags.Biomes.HAS_PEBBLES),
                feature(VerdurePlacedFeatures.PEBBLES), GenerationStep.Decoration.LOCAL_MODIFICATIONS));
    }

    private void register(String path, BiomeModifier modifier) {
        context.register(ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, res(path)), modifier);
    }

    private HolderSet.Direct<PlacedFeature> feature(ResourceKey<PlacedFeature> key) {
        return HolderSet.direct(context.lookup(Registries.PLACED_FEATURE).getOrThrow(key));
    }

}