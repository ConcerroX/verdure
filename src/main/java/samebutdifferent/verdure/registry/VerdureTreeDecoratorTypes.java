package samebutdifferent.verdure.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import samebutdifferent.verdure.Verdure;
import samebutdifferent.verdure.worldgen.treedecorator.BranchDecorator;
import samebutdifferent.verdure.worldgen.treedecorator.DaisiesDecorator;
import samebutdifferent.verdure.worldgen.treedecorator.FallenLeavesDecorator;
import samebutdifferent.verdure.worldgen.treedecorator.HollowLogDecorator;

public class VerdureTreeDecoratorTypes {

    public static final DeferredRegister<TreeDecoratorType<?>> TREE_DECORATOR_TYPES = DeferredRegister.create(
        Registries.TREE_DECORATOR_TYPE,
        Verdure.MOD_ID
    );

    public static final DeferredHolder<TreeDecoratorType<?>, TreeDecoratorType<DaisiesDecorator>> DAISIES = TREE_DECORATOR_TYPES.register("daisies",
        () -> new TreeDecoratorType<>(DaisiesDecorator.CODEC)
    );
    public static final DeferredHolder<TreeDecoratorType<?>, TreeDecoratorType<HollowLogDecorator>> HOLLOW_LOG = TREE_DECORATOR_TYPES.register("hollow_log",
        () -> new TreeDecoratorType<>(HollowLogDecorator.CODEC)
    );
    public static final DeferredHolder<TreeDecoratorType<?>, TreeDecoratorType<BranchDecorator>> BRANCH = TREE_DECORATOR_TYPES.register("branch",
        () -> new TreeDecoratorType<>(BranchDecorator.CODEC)
    );
    public static final DeferredHolder<TreeDecoratorType<?>, TreeDecoratorType<FallenLeavesDecorator>> FALLEN_LEAVES = TREE_DECORATOR_TYPES.register("fallen_leaves",
        () -> new TreeDecoratorType<>(FallenLeavesDecorator.CODEC)
    );

}
