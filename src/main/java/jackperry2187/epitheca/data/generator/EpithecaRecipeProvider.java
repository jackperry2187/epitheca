package jackperry2187.epitheca.data.generator;

import jackperry2187.epitheca.Epitheca;
import jackperry2187.epitheca.init.TagInit;
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

import static jackperry2187.epitheca.init.block.Glowstone.GLOWSTONES;
import static jackperry2187.epitheca.init.block.Shroomlight.SHROOMLIGHTS;
import static jackperry2187.epitheca.init.item.Defaults.DYES;

public class EpithecaRecipeProvider extends FabricRecipeProvider {
    public EpithecaRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override public void generate(RecipeExporter exporter){
        Epitheca.LOGGER.info("Generating recipes...");
        generateShroomlights(exporter);
        generateGlowstones(exporter);
        Epitheca.LOGGER.info("Recipes generated successfully!");
    }

    public void generateShroomlights(RecipeExporter exporter) {
        // Generate recipes for each Shroomlight variant
        // The default variant is orange, so we skip that one
        List<Item> filtered_dyes = DYES.stream().filter(dye -> dye != Items.ORANGE_DYE).toList();
        for (int i = 0; i < SHROOMLIGHTS.size(); i++) {
            // Relies on the fact that SHROOMLIGHTS and DYES are in the same order
            Block block = SHROOMLIGHTS.get(i);
            Item dye = filtered_dyes.get(i);
            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, block)
                    .input(TagInit.SHROOMLIGHT_ITEM)
                    .input(dye, 1)
                    .group("shroomlight")
                    // this recipe will show up whenever the player acquires a shroomlight OR the dye
                    .criterion(hasItem(dye), conditionsFromItem(dye))
                    .criterion("has_shroomlight", conditionsFromTag(TagInit.SHROOMLIGHT_ITEM))
                    .offerTo(exporter);
            // Epitheca.LOGGER.info("Added recipe to dye {} to {}", dye.getTranslationKey(), block.getTranslationKey());
        }
        // add recipe to dye back to the original Shroomlight
        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Blocks.SHROOMLIGHT)
                .input(TagInit.SHROOMLIGHT_ITEM)
                .input(Items.ORANGE_DYE, 1)
                .group("shroomlight")
                // this recipe will show up whenever the player acquires a shroomlight OR the dye
                .criterion(hasItem(Items.ORANGE_DYE), conditionsFromItem(Items.ORANGE_DYE))
                .criterion("has_shroomlight", conditionsFromTag(TagInit.SHROOMLIGHT_ITEM))
                .offerTo(exporter);
        // Epitheca.LOGGER.info("Added recipe to dye {} to {}", Items.ORANGE_DYE.getTranslationKey(), Blocks.SHROOMLIGHT.getTranslationKey());
    }

    public void generateGlowstones(RecipeExporter exporter) {
        // Generate recipes for each Glowstone variant
        // The default variant is orange, so we skip that one
        List<Item> filtered_dyes = DYES.stream().filter(dye -> dye != Items.ORANGE_DYE).toList();
        for (int i = 0; i < GLOWSTONES.size(); i++) {
            // Relies on the fact that GLOWSTONES and DYES are in the same order
            Block block = GLOWSTONES.get(i);
            Item dye = filtered_dyes.get(i);
            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, block)
                    .input(TagInit.GLOWSTONE_ITEM)
                    .input(dye, 1)
                    .group("glowstone")
                    // this recipe will show up whenever the player acquires a glowstone OR the dye
                    .criterion(hasItem(dye), conditionsFromItem(dye))
                    .criterion("has_glowstone", conditionsFromTag(TagInit.GLOWSTONE_ITEM))
                    .offerTo(exporter);
            // Epitheca.LOGGER.info("Added recipe to dye {} to {}", dye.getTranslationKey(), block.getTranslationKey());
        }
        // add recipe to dye back to the original Glowstone
        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Blocks.GLOWSTONE)
                .input(TagInit.GLOWSTONE_ITEM)
                .input(Items.ORANGE_DYE, 1)
                .group("glowstone")
                // this recipe will show up whenever the player acquires a glowstone OR the dye
                .criterion(hasItem(Items.ORANGE_DYE), conditionsFromItem(Items.ORANGE_DYE))
                .criterion("has_glowstone", conditionsFromTag(TagInit.GLOWSTONE_ITEM))
                .offerTo(exporter);
        // Epitheca.LOGGER.info("Added recipe to dye {} to {}", Items.ORANGE_DYE.getTranslationKey(), Blocks.GLOWSTONE.getTranslationKey());
    }
}
