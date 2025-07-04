package samebutdifferent.verdure.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BiomeTags;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import samebutdifferent.verdure.Verdure;
import samebutdifferent.verdure.registry.VerdureTags;

import java.util.concurrent.CompletableFuture;

public class BiomeTagsProvider extends net.minecraft.data.tags.BiomeTagsProvider {

    public BiomeTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider,
        ExistingFileHelper existingFileHelper
    ) {
        super(output, provider, Verdure.MOD_ID, existingFileHelper);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        tag(VerdureTags.Biomes.HAS_PEBBLES).addTags(BiomeTags.IS_BEACH, BiomeTags.IS_FOREST, BiomeTags.IS_HILL,
            BiomeTags.IS_JUNGLE, BiomeTags.IS_MOUNTAIN, BiomeTags.IS_RIVER, BiomeTags.IS_SAVANNA, BiomeTags.IS_TAIGA,
            Tags.Biomes.IS_PLAINS);
    }

}
