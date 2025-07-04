package samebutdifferent.verdure.data;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import samebutdifferent.verdure.Verdure;

public class BlockstateGenerator extends BlockStateProvider {

    public BlockstateGenerator(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Verdure.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
    }

}
