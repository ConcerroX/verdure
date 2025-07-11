package samebutdifferent.verdure.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;
import samebutdifferent.verdure.registry.VerdureBlocks;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

import static samebutdifferent.verdure.Verdure.res;

public class RecipeProvider extends net.minecraft.data.recipes.RecipeProvider {

    public RecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.COBBLESTONE).pattern("###").pattern("###")
            .pattern("###").define('#', VerdureBlocks.PEBBLES.get()).unlockedBy("has_pebbles", has(VerdureBlocks.PEBBLES.get()))
            .save(output, res("cobblestone_from_pebbles"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.COBBLESTONE).pattern("##").pattern("##")
            .define('#', VerdureBlocks.ROCK.get()).unlockedBy("has_rock", has(VerdureBlocks.ROCK.get()))
            .save(output, res("cobblestone_from_rock"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.BLUE_DYE).requires(VerdureBlocks.BLUE_DAISIES.get())
            .unlockedBy("has_blue_daisies", has(VerdureBlocks.BLUE_DAISIES.get()))
            .save(output, res("blue_dye_from_blue_daisies"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.PINK_DYE).requires(VerdureBlocks.PINK_DAISIES.get())
            .unlockedBy("has_pink_daisies", has(VerdureBlocks.PINK_DAISIES.get()))
            .save(output, res("pink_dye_from_pink_daisies"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.WHITE_DYE).requires(VerdureBlocks.DAISIES.get())
            .unlockedBy("has_white_daisies", has(VerdureBlocks.DAISIES.get())).save(output, res("white_dye_from_daisies"));
    }

}
