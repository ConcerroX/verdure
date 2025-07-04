package samebutdifferent.verdure.data;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import samebutdifferent.verdure.Verdure;

public class ItemModelGenerator extends ItemModelProvider {

    public ItemModelGenerator(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Verdure.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
    }

    private void ofBlock(DeferredBlock<Block> block) {
        withExistingParent(block.getId().getPath(), modLoc("block/" + block.getId().getPath()));
    }

    private ItemModelBuilder generated(DeferredBlock<Block> item) {
        return getBuilder(item.getId().getPath()).parent(getExistingFile(mcLoc("item/generated"))).texture("layer0", "item/" + item.getId().getPath());
    }

    private ItemModelBuilder blockToItemGenerated(DeferredBlock<Block> block) {
        return getBuilder(block.getId().getPath()).parent(getExistingFile(mcLoc("item/generated"))).texture("layer0", "block/" + block.getId().getPath());
    }

    private ItemModelBuilder fence (DeferredBlock<Block> fence, DeferredBlock<Block> planks) {
        return getBuilder(fence.getId().getPath()).parent(getExistingFile(mcLoc("block/fence_inventory"))).texture("texture", "block/" + planks.getId().getPath());
    }

    private void trapdoor (DeferredBlock<Block> trapdoor) {
        withExistingParent(trapdoor.getId().getPath(), modLoc("block/" + trapdoor.getId().getPath() + "_bottom"));
    }

}
