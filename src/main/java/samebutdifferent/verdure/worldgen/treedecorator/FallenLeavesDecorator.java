package samebutdifferent.verdure.worldgen.treedecorator;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import org.jetbrains.annotations.NotNull;
import samebutdifferent.verdure.registry.VerdureConfig;
import samebutdifferent.verdure.registry.VerdureTreeDecoratorTypes;

import java.util.List;

public class FallenLeavesDecorator extends TreeDecorator {

    public static final MapCodec<FallenLeavesDecorator> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
        BlockState.CODEC.fieldOf("state").forGetter((it) -> it.state)).apply(instance, FallenLeavesDecorator::new));
    private final BlockState state;

    public FallenLeavesDecorator(BlockState state) {
        this.state = state;
    }

    @Override
    protected @NotNull TreeDecoratorType<?> type() {
        return VerdureTreeDecoratorTypes.FALLEN_LEAVES.get();
    }

    @Override
    public void place(Context context) {
        if (!context.leaves().isEmpty() && context.random().nextFloat() <= VerdureConfig.FALLEN_LEAVES_CHANCE.get()) {
            List<BlockPos> lowestLeafPositions = context.leaves().stream()
                .filter(blockPos -> blockPos.getY() == context.leaves().getFirst().getY()).toList();
            for (BlockPos pos : lowestLeafPositions) {
                var mutable = new BlockPos.MutableBlockPos();
                mutable.set(pos.below());
                while (context.level().isStateAtPosition(mutable.below(), blockState -> !blockState.isSolid())) {
                    mutable.move(Direction.DOWN);
                }
                if (context.level().isStateAtPosition(mutable, BlockBehaviour.BlockStateBase::isAir)) {
                    if (context.random().nextBoolean()) {
                        context.setBlock(mutable, state);
                    }
                }
            }
        }
    }

}
