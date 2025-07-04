package samebutdifferent.verdure.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import samebutdifferent.verdure.Verdure;
import samebutdifferent.verdure.block.entity.HollowLogBlockEntity;

public class VerdureBlockEntityTypes {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(
        Registries.BLOCK_ENTITY_TYPE,
        Verdure.MOD_ID
    );

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<HollowLogBlockEntity>> HOLLOW_LOG = BLOCK_ENTITY_TYPES.register(
        "hollow_log",
        () -> BlockEntityType.Builder.of(HollowLogBlockEntity::new, VerdureBlocks.HOLLOW_LOG.get()).build(null)
    );

}
