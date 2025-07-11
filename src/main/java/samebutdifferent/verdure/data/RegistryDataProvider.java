package samebutdifferent.verdure.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;
import samebutdifferent.verdure.Verdure;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class RegistryDataProvider implements DataProvider.Factory<DatapackBuiltinEntriesProvider> {

    private final CompletableFuture<HolderLookup.Provider> lookupProvider;

    private final RegistrySetBuilder builder = new RegistrySetBuilder().add(ForgeRegistries.Keys.BIOME_MODIFIERS,
        bootstrap -> new BiomeModifiersProvider().run(bootstrap)).add(Registries.CONFIGURED_FEATURE,
        bootstrap -> new ConfiguredFeaturesProvider().run(bootstrap)).add(Registries.PLACED_FEATURE,
        bootstrap -> new PlacedFeaturesProvider().run(bootstrap));

    public RegistryDataProvider(CompletableFuture<HolderLookup.Provider> lookupProvider) {
        this.lookupProvider = lookupProvider;
    }

    @Override
    public @NotNull DatapackBuiltinEntriesProvider create(@NotNull PackOutput output) {
        return new DatapackBuiltinEntriesProvider(output, lookupProvider, builder, Set.of(Verdure.MOD_ID));
    }

}