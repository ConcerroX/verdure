package samebutdifferent.verdure.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import samebutdifferent.verdure.registry.VerdureConfig;

import java.util.function.BiConsumer;

@Mixin(TrunkPlacer.class)
public class TrunkPlacerMixin {

    @Inject(method = "setDirtAt", at = @At(value = "HEAD"), cancellable = true)
    private static void onSetDirtAt(
        LevelSimulatedReader level, BiConsumer<BlockPos, BlockState> blockSetter, RandomSource random, BlockPos pos,
        TreeConfiguration config, CallbackInfo ci
    ) {
        if (VerdureConfig.GENERATE_TREE_ROOTS.get()) {
            ci.cancel();
            blockSetter.accept(pos, Blocks.ROOTED_DIRT.defaultBlockState());
        }
    }

}
