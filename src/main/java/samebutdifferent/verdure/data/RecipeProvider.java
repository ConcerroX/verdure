package samebutdifferent.verdure.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;
import samebutdifferent.verdure.registry.VerdureBlocks;

import java.util.concurrent.CompletableFuture;

import static samebutdifferent.verdure.Verdure.res;

public class RecipeProvider extends net.minecraft.data.recipes.RecipeProvider {

    public RecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.COBBLESTONE).pattern("###").pattern("###")
            .pattern("###").define('#', VerdureBlocks.PEBBLES).unlockedBy("has_pebbles", has(VerdureBlocks.PEBBLES))
            .save(output, res("cobblestone_from_pebbles"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.COBBLESTONE).pattern("##").pattern("##")
            .define('#', VerdureBlocks.ROCK).unlockedBy("has_rock", has(VerdureBlocks.ROCK))
            .save(output, res("cobblestone_from_rock"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.BLUE_DYE).requires(VerdureBlocks.BLUE_DAISIES)
            .unlockedBy("has_blue_daisies", has(VerdureBlocks.BLUE_DAISIES))
            .save(output, res("blue_dye_from_blue_daisies"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.PINK_DYE).requires(VerdureBlocks.PINK_DAISIES)
            .unlockedBy("has_pink_daisies", has(VerdureBlocks.PINK_DAISIES))
            .save(output, res("pink_dye_from_pink_daisies"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.WHITE_DYE).requires(VerdureBlocks.DAISIES)
            .unlockedBy("has_white_daisies", has(VerdureBlocks.DAISIES)).save(output, res("white_dye_from_daisies"));
    }

}
