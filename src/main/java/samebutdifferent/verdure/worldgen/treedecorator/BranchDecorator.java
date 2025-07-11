package samebutdifferent.verdure.worldgen.treedecorator;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import org.jetbrains.annotations.NotNull;
import samebutdifferent.verdure.registry.VerdureConfig;
import samebutdifferent.verdure.registry.VerdureTreeDecoratorTypes;

import java.util.List;
import java.util.function.Supplier;

public class BranchDecorator extends TreeDecorator {

    public static final Codec<BranchDecorator> CODEC = RecordCodecBuilder.create(
        instance -> instance.group(BlockState.CODEC.fieldOf("state").forGetter((it) -> it.state))
            .apply(instance, BranchDecorator::new));

    private BlockState state = null;
    private Supplier<BlockState> lazyState = null;

    public BranchDecorator(BlockState state) {
        this.state = state;
    }

    public BranchDecorator(Supplier<BlockState> state) {
        this.lazyState = state;
    }

    @Override
    protected @NotNull TreeDecoratorType<?> type() {
        return VerdureTreeDecoratorTypes.BRANCH.get();
    }

    @Override
    public void place(@NotNull Context context) {
        state = lazyState != null ? lazyState.get() : state;
        if (context.leaves().isEmpty() || !VerdureConfig.GENERATE_TREE_BRANCHES.get())
            return;
        int lowestLeafY = context.leaves().get(0).getY();
        List<BlockPos> exposedLogs = context.logs().stream().filter(blockPos -> blockPos.getY() < lowestLeafY).toList();
        if (exposedLogs.size() <= 2)
            return;

        Direction zRand = context.random().nextBoolean() ? Direction.NORTH : Direction.SOUTH;
        Direction xRand = context.random().nextBoolean() ? Direction.EAST : Direction.WEST;
        BlockPos posFirst = exposedLogs.get(exposedLogs.size() - 1);
        if (context.level().isStateAtPosition(posFirst.relative(xRand), BlockBehaviour.BlockStateBase::isAir)) {
            context.setBlock(posFirst.relative(xRand), state.setValue(HorizontalDirectionalBlock.FACING, xRand));
        }
        if (exposedLogs.size() > 3) {
            BlockPos posSecond = exposedLogs.get(exposedLogs.size() - 2);
            if (context.level().isStateAtPosition(posSecond.relative(zRand), BlockBehaviour.BlockStateBase::isAir)) {
                context.setBlock(posSecond.relative(zRand), state.setValue(HorizontalDirectionalBlock.FACING, zRand));
            }
        }
    }

}
