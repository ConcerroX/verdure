package samebutdifferent.verdure.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;
import samebutdifferent.verdure.registry.VerdureBlocks;

import java.util.Set;

public class BlockLootSubProvider extends net.minecraft.data.loot.BlockLootSubProvider {

    public BlockLootSubProvider() {
        super(Set.of(), FeatureFlags.DEFAULT_FLAGS);
    }

    @Override
    protected void generate() {
        for (RegistryObject<? extends Block> block : VerdureBlocks.BLOCKS.getEntries()) {
            dropSelf(block.get());
        }
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return VerdureBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).toList();
    }

}
