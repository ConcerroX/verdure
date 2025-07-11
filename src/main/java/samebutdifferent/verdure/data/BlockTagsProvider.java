package samebutdifferent.verdure.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import samebutdifferent.verdure.Verdure;
import samebutdifferent.verdure.registry.VerdureBlocks;

import java.util.concurrent.CompletableFuture;

public class BlockTagsProvider extends net.minecraftforge.common.data.BlockTagsProvider {

    public BlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider,
        ExistingFileHelper existingFileHelper
    ) {
        super(output, provider, Verdure.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(@NotNull HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_AXE).add(VerdureBlocks.OAK_BRANCH.get(), VerdureBlocks.BIRCH_BRANCH.get());
        tag(BlockTags.MINEABLE_WITH_SHOVEL).add(VerdureBlocks.SMOOTH_DIRT.get(), VerdureBlocks.DRIED_MUD.get(),
            VerdureBlocks.HUMUS.get());
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(VerdureBlocks.SLATE.get(), VerdureBlocks.PEBBLES.get(),
            VerdureBlocks.ROCK.get());

        tag(BlockTags.DIRT).add(VerdureBlocks.SMOOTH_DIRT.get(), VerdureBlocks.HUMUS.get());
        tag(BlockTags.LOGS_THAT_BURN).add(VerdureBlocks.HOLLOW_LOG.get());
    }

}
