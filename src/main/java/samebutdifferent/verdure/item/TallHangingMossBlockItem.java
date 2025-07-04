package samebutdifferent.verdure.item;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class TallHangingMossBlockItem extends BlockItem {

    public TallHangingMossBlockItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    protected boolean placeBlock(BlockPlaceContext context, @NotNull BlockState state) {
        Level level = context.getLevel();
        BlockPos belowPos = context.getClickedPos().below();
        BlockState belowState = level.isWaterAt(belowPos) ? Blocks.WATER.defaultBlockState() : Blocks.AIR.defaultBlockState();
        level.setBlock(belowPos, belowState, 27);
        return super.placeBlock(context, state);
    }

}
