package samebutdifferent.verdure.worldgen.treedecorator;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import org.jetbrains.annotations.NotNull;
import samebutdifferent.verdure.block.HollowLogBlock;
import samebutdifferent.verdure.registry.VerdureBlocks;
import samebutdifferent.verdure.registry.VerdureTreeDecoratorTypes;

public class HollowLogDecorator extends TreeDecorator {

    public static final Codec<HollowLogDecorator> CODEC = Codec.unit(() -> HollowLogDecorator.INSTANCE);
    public static final HollowLogDecorator INSTANCE = new HollowLogDecorator();

    @Override
    protected @NotNull TreeDecoratorType<?> type() {
        return VerdureTreeDecoratorTypes.HOLLOW_LOG.get();
    }

    @Override
    public void place(Context context) {
        BlockPos pos = context.logs().get(2);
        Direction direction = Direction.from2DDataValue(context.random().nextInt(4));
        context.setBlock(pos, VerdureBlocks.HOLLOW_LOG.get().defaultBlockState().setValue(HollowLogBlock.FACING, direction));
        // TODO: fix
        //        RandomizableContainerBlockEntity.setLootTable((BlockGetter) pLevel, pRandom, pos, new ResourceLocation(Verdure.MOD_ID, "chests/hollow_log"));
    }

}
