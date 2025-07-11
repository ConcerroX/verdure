package samebutdifferent.verdure.mixin;

import com.google.common.collect.ImmutableList;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SingleThreadedRandomSource;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.FeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.rootplacers.RootPlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import samebutdifferent.verdure.registry.VerdureBlocks;
import samebutdifferent.verdure.worldgen.treedecorator.BranchDecorator;
import samebutdifferent.verdure.worldgen.treedecorator.FallenLeavesDecorator;

import java.util.List;
import java.util.Optional;

@Mixin(TreeConfiguration.class)
public class TreeConfigurationMixin {

    @Mutable
    @Shadow
    @Final
    public List<TreeDecorator> decorators;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void onConstructor(BlockStateProvider trunkProvider, TrunkPlacer trunkPlacer,
        BlockStateProvider foliageProvider, FoliagePlacer foliagePlacer, Optional<RootPlacer> rootPlacer,
        BlockStateProvider dirtProvider, FeatureSize minimumSize, List<TreeDecorator> decorators, boolean ignoreVines,
        boolean forceDirt, CallbackInfo ci
    ) {
        if (!(trunkProvider instanceof SimpleStateProvider))
            return;
        Block log = trunkProvider.getState(new SingleThreadedRandomSource(0), BlockPos.ZERO).getBlock();
        var builder = ImmutableList.<TreeDecorator>builder().addAll(this.decorators);
        if (log == Blocks.OAK_LOG) {
            builder.add(new BranchDecorator(() -> VerdureBlocks.OAK_BRANCH.get().defaultBlockState()));
            builder.add(new FallenLeavesDecorator(() -> VerdureBlocks.FALLEN_OAK_LEAVES.get().defaultBlockState()));
        } else if (log == Blocks.BIRCH_LOG) {
            builder.add(new BranchDecorator(() -> VerdureBlocks.BIRCH_BRANCH.get().defaultBlockState()));
            builder.add(new FallenLeavesDecorator(() -> VerdureBlocks.FALLEN_BIRCH_LEAVES.get().defaultBlockState()));
        } else if (log == Blocks.ACACIA_LOG) {
            builder.add(new FallenLeavesDecorator(() -> VerdureBlocks.FALLEN_ACACIA_LEAVES.get().defaultBlockState()));
        } else if (log == Blocks.JUNGLE_LOG) {
            builder.add(new FallenLeavesDecorator(() -> VerdureBlocks.FALLEN_JUNGLE_LEAVES.get().defaultBlockState()));
        } else if (log == Blocks.SPRUCE_LOG) {
            builder.add(new FallenLeavesDecorator(() -> VerdureBlocks.FALLEN_SPRUCE_LEAVES.get().defaultBlockState()));
        } else if (log == Blocks.DARK_OAK_LOG) {
            builder.add(new FallenLeavesDecorator(() -> VerdureBlocks.FALLEN_DARK_OAK_LEAVES.get().defaultBlockState()));
        }
        this.decorators = builder.build();
    }

}
