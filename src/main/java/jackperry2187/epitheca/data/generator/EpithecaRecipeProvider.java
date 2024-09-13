package jackperry2187.epitheca.data.generator;

import jackperry2187.epitheca.Epitheca;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static jackperry2187.epitheca.init.BlockInit.SHROOMLIGHTS;
import static jackperry2187.epitheca.init.ItemInit.DYES;

public class EpithecaRecipeProvider extends FabricRecipeProvider {
    public EpithecaRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override public void generate(RecipeExporter exporter){
        Epitheca.LOGGER.info("Generating recipes...");
        // Generate recipes for each Shroomlight variant
        // The default variant is orange, so we skip that one
        List<Item> filtered_dyes = DYES.stream().filter(dye -> dye != Items.ORANGE_DYE).toList();
        for (int i = 0; i < SHROOMLIGHTS.size(); i++) {
            // Relies on the fact that SHROOMLIGHTS and DYES are in the same order
            Block block = SHROOMLIGHTS.get(i);
            Item dye = filtered_dyes.get(i);
            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, block)
                    .input(Blocks.SHROOMLIGHT, 1)
                    .input(dye, 1)
                    .criterion(hasItem(Blocks.SHROOMLIGHT), conditionsFromItem(Blocks.SHROOMLIGHT))
                    .offerTo(exporter);
        }

        Epitheca.LOGGER.info("Recipes generated successfully!");
    }
}
