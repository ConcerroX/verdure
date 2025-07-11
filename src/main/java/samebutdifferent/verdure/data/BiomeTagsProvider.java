package samebutdifferent.verdure.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
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
    protected void addTags(@NotNull HolderLookup.Provider provider) {
        tag(VerdureTags.Biomes.HAS_BOULDER_STONE).addTags(BiomeTags.IS_FOREST);
        tag(VerdureTags.Biomes.HAS_BOULDER_DIORITE).addTags(BiomeTags.IS_TAIGA);
        tag(VerdureTags.Biomes.HAS_BOULDER_GRANITE).addTags(BiomeTags.IS_SAVANNA);
        tag(VerdureTags.Biomes.HAS_BOULDER_ANDESITE).addTags(BiomeTags.IS_BEACH);
        tag(VerdureTags.Biomes.HAS_BOULDER_SLATE).addTags(BiomeTags.IS_RIVER, BiomeTags.IS_JUNGLE);

        tag(VerdureTags.Biomes.HAS_PEBBLES).addTags(BiomeTags.IS_BEACH, BiomeTags.IS_FOREST, BiomeTags.IS_HILL,
            BiomeTags.IS_JUNGLE, BiomeTags.IS_MOUNTAIN, BiomeTags.IS_RIVER, BiomeTags.IS_SAVANNA, BiomeTags.IS_TAIGA,
            Tags.Biomes.IS_PLAINS, Tags.Biomes.IS_SWAMP);
        tag(VerdureTags.Biomes.HAS_PATCH_CLOVER).addTags(BiomeTags.IS_FOREST, BiomeTags.IS_JUNGLE, BiomeTags.IS_TAIGA,
            BiomeTags.IS_SAVANNA, Tags.Biomes.IS_PLAINS, Tags.Biomes.IS_SWAMP);
        tag(VerdureTags.Biomes.HAS_PATCH_DAISIES).addTags(BiomeTags.IS_FOREST, BiomeTags.IS_JUNGLE, BiomeTags.IS_TAIGA,
            Tags.Biomes.IS_PLAINS, Tags.Biomes.IS_SWAMP);
        tag(VerdureTags.Biomes.HAS_PATCH_WILDFLOWERS).add(Biomes.BIRCH_FOREST, Biomes.OLD_GROWTH_BIRCH_FOREST,
            Biomes.FLOWER_FOREST);

        tag(VerdureTags.Biomes.HAS_MUSHROOM_SHELVES).addTags(BiomeTags.IS_FOREST, BiomeTags.IS_TAIGA,
            Tags.Biomes.IS_SWAMP);
        tag(VerdureTags.Biomes.HAS_UNDERGROUND_MUSHROOM_SHELVES).addTags(BiomeTags.IS_OVERWORLD);
        tag(VerdureTags.Biomes.HAS_HANGING_MOSS).addTags(Tags.Biomes.IS_LUSH);
    }

}
