package samebutdifferent.verdure.registry;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import samebutdifferent.verdure.Verdure;
import samebutdifferent.verdure.block.*;

import java.util.function.Supplier;

import static net.minecraft.world.level.block.state.BlockBehaviour.Properties.of;
import static net.minecraft.world.level.block.state.BlockBehaviour.Properties.ofFullCopy;

public class VerdureBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Verdure.MOD_ID);

    public static final DeferredBlock<CloverBlock> CLOVER = registerBlock(
        "clover",
        () -> new CloverBlock(ofFullCopy(Blocks.SHORT_GRASS))
    );

    public static final DeferredBlock<Block> PEBBLES = registerBlock(
        "pebbles",
        () -> new PebblesBlock(of().noOcclusion().sound(SoundType.STONE).instabreak().noCollission())
    );

    public static final DeferredBlock<Block> ROCK = registerBlock(
        "rock",
        () -> new RockBlock(of().noOcclusion().sound(SoundType.STONE).instabreak().noCollission())
    );

    public static final DeferredBlock<Block> BROWN_MUSHROOM_SHELF = BLOCKS.register(
        "brown_mushroom_shelf",
        () -> new MushroomShelfBlock(of().mapColor(MapColor.COLOR_BROWN).noCollission().instabreak()
            .sound(SoundType.GRASS).lightLevel((state) -> 1))
    );

    public static final DeferredBlock<Block> RED_MUSHROOM_SHELF = BLOCKS.register(
        "red_mushroom_shelf",
        () -> new MushroomShelfBlock(of().mapColor(MapColor.COLOR_RED).noCollission().instabreak()
            .sound(SoundType.GRASS))
    );

    public static final DeferredBlock<Block> DAISIES = registerBlock(
        "daisies",
        () -> new DaisiesBlock(of().noCollission().instabreak().sound(SoundType.GRASS))
    );

    public static final DeferredBlock<Block> BLUE_DAISIES = registerBlock(
        "blue_daisies",
        () -> new DaisiesBlock(ofFullCopy(DAISIES.get()))
    );

    public static final DeferredBlock<Block> PINK_DAISIES = registerBlock(
        "pink_daisies",
        () -> new DaisiesBlock(ofFullCopy(DAISIES.get()))
    );

    public static final DeferredBlock<Block> WILDFLOWERS = registerBlock(
        "wildflowers",
        () -> new DaisiesBlock(ofFullCopy(DAISIES.get()))
    );

    public static final DeferredBlock<Block> HANGING_MOSS = registerBlock(
        "hanging_moss",
        () -> new HangingMossBlock(of().mapColor(MapColor.COLOR_GREEN).noCollission().instabreak()
            .offsetType(BlockBehaviour.OffsetType.XZ).sound(SoundType.MOSS))
    );

    public static final DeferredBlock<Block> TALL_HANGING_MOSS = BLOCKS.register(
        "tall_hanging_moss",
        () -> new TallHangingMossBlock(of().mapColor(MapColor.COLOR_GREEN).noCollission().instabreak()
            .offsetType(BlockBehaviour.OffsetType.XZ).sound(SoundType.MOSS))
    );

    public static final DeferredBlock<Block> FALLEN_OAK_LEAVES = registerBlock(
        "fallen_oak_leaves",
        () -> new FallenLeavesBlock(of().instabreak().sound(SoundType.GRASS).noOcclusion())
    );

    public static final DeferredBlock<Block> FALLEN_BIRCH_LEAVES = registerBlock(
        "fallen_birch_leaves",
        () -> new FallenLeavesBlock(of().instabreak().sound(SoundType.GRASS).noOcclusion())
    );

    public static final DeferredBlock<Block> FALLEN_SPRUCE_LEAVES = registerBlock(
        "fallen_spruce_leaves",
        () -> new FallenLeavesBlock(of().instabreak().sound(SoundType.GRASS).noOcclusion())
    );

    public static final DeferredBlock<Block> FALLEN_JUNGLE_LEAVES = registerBlock(
        "fallen_jungle_leaves",
        () -> new FallenLeavesBlock(of().instabreak().sound(SoundType.GRASS).noOcclusion())
    );

    public static final DeferredBlock<Block> FALLEN_ACACIA_LEAVES = registerBlock(
        "fallen_acacia_leaves",
        () -> new FallenLeavesBlock(of().instabreak().sound(SoundType.GRASS).noOcclusion())
    );

    public static final DeferredBlock<Block> FALLEN_DARK_OAK_LEAVES = registerBlock(
        "fallen_dark_oak_leaves",
        () -> new FallenLeavesBlock(of().instabreak().sound(SoundType.GRASS).noOcclusion())
    );

    public static final DeferredBlock<Block> OAK_BRANCH = registerBlock(
        "oak_branch", () -> new BranchBlock(
            Blocks.OAK_LOG,
            VerdureBlocks.FALLEN_OAK_LEAVES.get(),
            of().mapColor(MapColor.WOOD).noCollission().noOcclusion().strength(1.0F).sound(SoundType.WOOD)
        )
    );

    public static final DeferredBlock<Block> BIRCH_BRANCH = registerBlock(
        "birch_branch", () -> new BranchBlock(
            Blocks.BIRCH_LOG,
            VerdureBlocks.FALLEN_BIRCH_LEAVES.get(),
            of().mapColor(MapColor.WOOD).noCollission().noOcclusion().strength(1.0F).sound(SoundType.WOOD)
        )
    );

    public static final DeferredBlock<Block> WALL_ROOTS = BLOCKS.register(
        "wall_roots",
        () -> new WallRootsBlock(ofFullCopy(Blocks.HANGING_ROOTS))
    );

    public static final DeferredBlock<Block> HUMUS = registerBlock(
        "humus",
        () -> new SnowyDirtBlock(ofFullCopy(Blocks.DIRT).mapColor(MapColor.DIRT).strength(0.5F).sound(SoundType.GRAVEL))
    );

    public static final DeferredBlock<Block> SMOOTH_DIRT = registerBlock(
        "smooth_dirt",
        () -> new Block(ofFullCopy(Blocks.DIRT))
    );

    public static final DeferredBlock<Block> DRIED_MUD = registerBlock(
        "dried_mud",
        () -> new DriedMudBlock(ofFullCopy(Blocks.DIRT).strength(0.8F).sound(SoundType.GRAVEL))
    );

    public static final DeferredBlock<Block> HOLLOW_LOG = registerBlock(
        "hollow_log",
        () -> new HollowLogBlock(ofFullCopy(Blocks.OAK_LOG).mapColor(MapColor.WOOD).strength(2.0F)
            .sound(SoundType.WOOD))
    );

    public static final DeferredBlock<Block> SLATE = registerBlock(
        "slate",
        () -> new RotatedPillarBlock(ofFullCopy(Blocks.STONE).sound(SoundType.DEEPSLATE))
    );

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        var toReturn = VerdureBlocks.BLOCKS.register(name, block);
        VerdureItems.ITEMS.register(name, () -> new BlockItem(toReturn.get(), new Item.Properties()));
        return toReturn;
    }

}
