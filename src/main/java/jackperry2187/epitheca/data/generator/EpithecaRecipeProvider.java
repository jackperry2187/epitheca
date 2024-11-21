package jackperry2187.epitheca.data.generator;

import jackperry2187.epitheca.Epitheca;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

import static jackperry2187.epitheca.init.block.Recrafter.RECRAFTER;

public class EpithecaRecipeProvider extends FabricRecipeProvider {
    public EpithecaRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override public void generate(RecipeExporter exporter){
        Epitheca.LOGGER.info("Generating recipes...");
        generateRecrafter(exporter);
        // TODO: make a dynamic way to generate recipes used in the Recrafter as opposed to doing whatever bad stuff you're doing now
        Epitheca.LOGGER.info("Recipes generated successfully!");
    }

    public void generateRecrafter(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, RECRAFTER, 1)
                .input('G', Items.LIGHT_GRAY_DYE)
                .input('O', Items.ORANGE_DYE)
                .input('L', Items.LIME_DYE)

                .input('C', Items.LIME_DYE)
                .input('R', Items.CRAFTING_TABLE)
                .input('B', Items.CYAN_DYE)

                .input('P', Items.LIGHT_BLUE_DYE)
                .input('M', Items.PURPLE_DYE)
                .input('I', Items.PINK_DYE)
                .pattern("GOL")
                .pattern("CRB")
                .pattern("PMI")
                .criterion(hasItem(Blocks.CRAFTING_TABLE), conditionsFromItem(Blocks.CRAFTING_TABLE))
                .offerTo(exporter);
    }
}
