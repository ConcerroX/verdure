package samebutdifferent.verdure.worldgen.treedecorator;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.MultifaceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import org.jetbrains.annotations.NotNull;
import samebutdifferent.verdure.registry.VerdureBlocks;
import samebutdifferent.verdure.registry.VerdureTreeDecoratorTypes;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.BiConsumer;

public class DaisiesDecorator extends TreeDecorator {

    public static final MapCodec<DaisiesDecorator> CODEC = MapCodec.unit(() -> DaisiesDecorator.INSTANCE);
    public static final DaisiesDecorator INSTANCE = new DaisiesDecorator();

    @Override
    protected @NotNull TreeDecoratorType<?> type() {
        return VerdureTreeDecoratorTypes.DAISIES.get();
    }

    @Override
    public void place(Context context) {
        BlockState state;
        switch (context.random().nextInt(3)) {
            case 1 -> state = VerdureBlocks.BLUE_DAISIES.get().defaultBlockState();
            case 2 -> state = VerdureBlocks.PINK_DAISIES.get().defaultBlockState();
            default -> state = VerdureBlocks.DAISIES.get().defaultBlockState();
        }
        context.leaves().forEach((pos -> {
            for (Direction direction : Direction.values()) {
                if (context.level().isStateAtPosition(pos.relative(direction), BlockBehaviour.BlockStateBase::isAir)) {
                    context.setBlock(pos.relative(direction), state.setValue(MultifaceBlock.getFaceProperty(direction.getOpposite()), true));
                }
            }
        }));
    }

}
