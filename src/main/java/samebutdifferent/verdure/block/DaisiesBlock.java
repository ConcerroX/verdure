package samebutdifferent.verdure.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.block.MultifaceBlock;
import net.minecraft.world.level.block.MultifaceSpreader;
import org.jetbrains.annotations.NotNull;

public class DaisiesBlock extends MultifaceBlock {

    public DaisiesBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected @NotNull MapCodec<? extends MultifaceBlock> codec() {
        return simpleCodec(DaisiesBlock::new);
    }

    @Override
    public @NotNull MultifaceSpreader getSpreader() {
        return new MultifaceSpreader(this);
    }

}
