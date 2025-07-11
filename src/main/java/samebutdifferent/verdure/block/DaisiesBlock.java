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
    public @NotNull MultifaceSpreader getSpreader() {
        return new MultifaceSpreader(this);
    }

}
