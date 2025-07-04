package samebutdifferent.verdure.worldgen.feature;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.DiskFeature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.DiskConfiguration;

public class DitheredDiskFeature extends DiskFeature {

    public DitheredDiskFeature(Codec<DiskConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<DiskConfiguration> context) {
        DiskConfiguration config = context.config();
        BlockPos origin = context.origin();
        WorldGenLevel level = context.level();
        boolean shouldPlace = false;

        while (level.isEmptyBlock(origin) && origin.getY() > level.getMinBuildHeight() + 2) {
            origin = origin.below();
        }

        if (level.getBlockState(origin).is(Blocks.GRASS_BLOCK)) {
            int yOrigin = origin.getY();
            int yUpper = yOrigin + config.halfHeight();
            int yLower = yOrigin - config.halfHeight() - 1;
            int radius = config.radius().sample(context.random());

            for (int i = origin.getX() - radius; i <= origin.getX() + radius; ++i) {
                for (int j = origin.getZ() - radius; j <= origin.getZ() + radius; ++j) {
                    int x = i - origin.getX();
                    int z = j - origin.getZ();
                    if (x * x + z * z <= radius * radius) {
                        for (int k = yUpper; k >= yLower; --k) {
                            BlockPos pos = new BlockPos(i, k, j);
                            BlockState state = level.getBlockState(pos);
                            Block block = state.getBlock();
                            if (k > yLower) {
                                if (config.target().test(level, pos)) {
                                    if (i >= origin.getX() + radius - 2 || j >= origin.getZ() + radius - 2
                                        || i <= origin.getX() - radius + 2 || j <= origin.getZ() - radius + 2) {
                                        if (level.getRandom().nextBoolean()) {
                                            level.setBlock(
                                                pos,
                                                config.stateProvider().getState(level, level.getRandom(), pos),
                                                2
                                            );
                                            this.markAboveForPostProcessing(level, pos);
                                            shouldPlace = true;
                                            break;
                                        }
                                    } else {
                                        level.setBlock(
                                            pos,
                                            config.stateProvider().getState(level, level.getRandom(), pos),
                                            2
                                        );
                                        this.markAboveForPostProcessing(level, pos);
                                        shouldPlace = true;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return shouldPlace;
    }
}
