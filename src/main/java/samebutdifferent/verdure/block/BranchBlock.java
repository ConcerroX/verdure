package samebutdifferent.verdure.block;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class BranchBlock extends HorizontalDirectionalBlock implements SimpleWaterloggedBlock {

    private final Block log;
    private final Block fallenLeaves;
    protected static final VoxelShape X_AXIS_AABB = Block.box(0.0D, 0.0D, 7.0D, 16.0D, 16.0D, 9.0D);
    protected static final VoxelShape Z_AXIS_AABB = Block.box(7.0D, 0.0D, 0.0D, 9.0D, 16.0D, 16.0D);
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final BooleanProperty LEAVES = BooleanProperty.create("leaves");

    public BranchBlock(Block log, Block fallenLeaves, Properties properties) {
        super(properties);
        this.log = log;
        this.fallenLeaves = fallenLeaves;
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH)
            .setValue(WATERLOGGED, false).setValue(LEAVES, false));
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter level, BlockPos pos, CollisionContext pContext) {
        return pState.getValue(FACING).getAxis() == Direction.Axis.X ? X_AXIS_AABB : Z_AXIS_AABB;
    }

    private boolean canAttachTo(BlockGetter pBlockReader, BlockPos pos) {
        return pBlockReader.getBlockState(pos).is(log);
    }

    @Override
    public boolean canSurvive(BlockState pState, LevelReader level, BlockPos pos) {
        Direction direction = pState.getValue(FACING);
        return this.canAttachTo(level, pos.relative(direction.getOpposite()));
    }

    @Override
    public @NotNull BlockState updateShape(
        BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor level,
        @NotNull BlockPos pCurrentPos, @NotNull BlockPos pFacingPos
    ) {
        if (pFacing.getOpposite() == pState.getValue(FACING) && !pState.canSurvive(level, pCurrentPos)) {
            return Blocks.AIR.defaultBlockState();
        } else {
            if (pState.getValue(WATERLOGGED)) {
                level.scheduleTick(pCurrentPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
            }

            return super.updateShape(pState, pFacing, pFacingState, level, pCurrentPos, pFacingPos);
        }
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        if (!pContext.replacingClickedOnBlock()) {
            BlockState state = pContext.getLevel()
                .getBlockState(pContext.getClickedPos().relative(pContext.getClickedFace().getOpposite()));
            if (state.is(this) && state.getValue(FACING) == pContext.getClickedFace()) {
                return null;
            }
        }

        BlockState defaultBlockState = this.defaultBlockState();
        LevelReader level = pContext.getLevel();
        BlockPos pos = pContext.getClickedPos();
        FluidState fluidState = pContext.getLevel().getFluidState(pContext.getClickedPos());

        for (Direction direction : pContext.getNearestLookingDirections()) {
            if (direction.getAxis().isHorizontal()) {
                defaultBlockState = defaultBlockState.setValue(FACING, direction.getOpposite());
                if (defaultBlockState.canSurvive(level, pos)) {
                    return defaultBlockState.setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER);
                }
            }
        }

        return null;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING, WATERLOGGED, LEAVES);
    }

    @Override
    public @NotNull FluidState getFluidState(BlockState pState) {
        return pState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pState);
    }

    @Override
    public boolean isRandomlyTicking(BlockState pState) {
        return !pState.getValue(LEAVES);
    }

    @Override
    protected void randomTick(
        @NotNull BlockState state, @NotNull ServerLevel level, @NotNull BlockPos pos,
        RandomSource random
    ) {
        if (random.nextInt(5) == 0) {
            level.setBlock(pos, state.setValue(LEAVES, true), 2);
        }
    }

    @Override
    public @Nullable BlockState getToolModifiedState(
        @NotNull BlockState state, @NotNull UseOnContext context,
        @NotNull ItemAbility itemAbility, boolean simulate
    ) {
        if (itemAbility.equals(ItemAbilities.SHEARS_HARVEST) && state.getValue(LEAVES) && context.getItemInHand()
            .canPerformAction(ItemAbilities.SHEARS_HARVEST)) {
            return state.setValue(LEAVES, false);
        }
        return super.getToolModifiedState(state, context, itemAbility, simulate);
    }

    @Override
    protected @NotNull ItemInteractionResult useItemOn(
        @NotNull ItemStack stack, BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player,
        @NotNull InteractionHand hand, @NotNull BlockHitResult hitResult
    ) {
        boolean canShear = false;
        if (state.getValue(LEAVES)) {
            if (stack.canPerformAction(ItemAbilities.SHEARS_HARVEST)) {
                level.playSound(
                    player,
                    player.getX(),
                    player.getY(),
                    player.getZ(),
                    SoundEvents.SHEEP_SHEAR,
                    SoundSource.NEUTRAL,
                    1.0F,
                    1.0F
                );
                popResource(level, pos, new ItemStack(fallenLeaves));
                stack.hurtAndBreak(1, player, player.getEquipmentSlotForItem(stack));
                canShear = true;
                level.gameEvent(player, GameEvent.SHEAR, pos);
            }
            if (!level.isClientSide() && canShear) {
                player.awardStat(Stats.ITEM_USED.get(stack.getItem()));
            }
        }

        if (canShear) {
            level.setBlockAndUpdate(pos, state.setValue(LEAVES, false));
            return ItemInteractionResult.sidedSuccess(level.isClientSide);
        } else {
            return super.useItemOn(stack, state, level, pos, player, hand, hitResult);
        }
    }

    @Override
    public boolean isFlammable(@NotNull BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return true;
    }

    @Override
    public int getFlammability(
        @NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos,
        @NotNull Direction direction
    ) {
        return 100;
    }

    @Override
    protected @NotNull MapCodec<? extends BranchBlock> codec() {
        return RecordCodecBuilder.mapCodec(instance -> instance.group(
            BuiltInRegistries.BLOCK.byNameCodec().fieldOf("log").forGetter((it) -> log),
            BuiltInRegistries.BLOCK.byNameCodec().fieldOf("fallenLeaves").forGetter((it) -> fallenLeaves),
            Properties.CODEC.fieldOf("properties").forGetter((it) -> properties)
        ).apply(instance, BranchBlock::new));
    }
}
