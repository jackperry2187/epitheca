package jackperry2187.epitheca.data.generator;

import jackperry2187.epitheca.Epitheca;
import jackperry2187.epitheca.init.TagInit;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.data.server.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static jackperry2187.epitheca.init.block.Glowstone.GLOWSTONES;
import static jackperry2187.epitheca.init.block.Magma.MAGMAS;
import static jackperry2187.epitheca.init.block.Shroomlight.SHROOMLIGHTS;
import static jackperry2187.epitheca.init.item.Defaults.DYES;
import static jackperry2187.epitheca.init.item.Doors.*;

public class EpithecaRecipeProvider extends FabricRecipeProvider {
    public EpithecaRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override public void generate(RecipeExporter exporter){
        Epitheca.LOGGER.info("Generating recipes...");
        generateShroomlights(exporter);
        generateGlowstones(exporter);
        generateMagmas(exporter);
        generateDoors(exporter);
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

    public void generateMagmas(RecipeExporter exporter) {
        // Generate recipes for each Magma variant
        // The default variant is orange, so we skip that one
        List<Item> filtered_dyes = DYES.stream().filter(dye -> dye != Items.ORANGE_DYE).toList();
        for (int i = 0; i < MAGMAS.size(); i++) {
            // Relies on the fact that GLOWSTONES and DYES are in the same order
            Block block = MAGMAS.get(i);
            Item dye = filtered_dyes.get(i);
            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, block)
                    .input(TagInit.MAGMA_ITEM)
                    .input(dye, 1)
                    .group("magma")
                    // this recipe will show up whenever the player acquires a magma OR the dye
                    .criterion(hasItem(dye), conditionsFromItem(dye))
                    .criterion("has_magma", conditionsFromTag(TagInit.MAGMA_ITEM))
                    .offerTo(exporter);
            // Epitheca.LOGGER.info("Added recipe to dye {} to {}", dye.getTranslationKey(), block.getTranslationKey());
        }
        // add recipe to dye back to the original Magma
        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Blocks.MAGMA_BLOCK)
                .input(TagInit.MAGMA_ITEM)
                .input(Items.ORANGE_DYE, 1)
                .group("magma")
                // this recipe will show up whenever the player acquires a glowstone OR the dye
                .criterion(hasItem(Items.ORANGE_DYE), conditionsFromItem(Items.ORANGE_DYE))
                .criterion("has_magma", conditionsFromTag(TagInit.MAGMA_ITEM))
                .offerTo(exporter);
        // Epitheca.LOGGER.info("Added recipe to dye {} to {}", Items.ORANGE_DYE.getTranslationKey(), Blocks.MAGMA_BLOCK.getTranslationKey());
    }

    public void generateDoors(RecipeExporter exporter) {
        // Generate recipes for each Door variant

        // Cobblestone door
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, COBBLESTONE_DOOR_ITEM)
                .input('C', Items.COBBLESTONE)
                .pattern("CC")
                .pattern("CC")
                .pattern("CC")
                .group("door")
                .criterion(hasItem(Blocks.COBBLESTONE), conditionsFromItem(Blocks.COBBLESTONE))
                .offerTo(exporter);

        // Mossy cobblestone door
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, MOSSY_COBBLESTONE_DOOR_ITEM)
                .input('C', Items.MOSSY_COBBLESTONE)
                .pattern("CC")
                .pattern("CC")
                .pattern("CC")
                .group("door")
                .criterion(hasItem(Blocks.MOSSY_COBBLESTONE), conditionsFromItem(Blocks.MOSSY_COBBLESTONE))
                .offerTo(exporter);

        // Cobbled deepslate door
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, COBBLED_DEEPSLATE_DOOR_ITEM)
                .input('C', Items.COBBLED_DEEPSLATE)
                .pattern("CC")
                .pattern("CC")
                .pattern("CC")
                .group("door")
                .criterion(hasItem(Blocks.COBBLED_DEEPSLATE), conditionsFromItem(Blocks.COBBLED_DEEPSLATE))
                .offerTo(exporter);

        // Smooth stone door
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, SMOOTH_STONE_DOOR_ITEM)
                .input('C', Items.SMOOTH_STONE)
                .pattern("CC")
                .pattern("CC")
                .pattern("CC")
                .group("door")
                .criterion(hasItem(Blocks.SMOOTH_STONE), conditionsFromItem(Blocks.SMOOTH_STONE))
                .offerTo(exporter);

        // Gold door
        SmithingTransformRecipeJsonBuilder.create(Ingredient.EMPTY, Ingredient.ofItems(Items.IRON_DOOR), Ingredient.ofItems(Items.GOLD_INGOT), RecipeCategory.DECORATIONS, GOLD_DOOR_ITEM)
                .criterion(hasItem(Items.IRON_DOOR), conditionsFromItem(Items.IRON_DOOR))
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .offerTo(exporter, "gold_door_smithing");

        // Diamond door
        SmithingTransformRecipeJsonBuilder.create(Ingredient.EMPTY, Ingredient.ofItems(GOLD_DOOR_ITEM), Ingredient.ofItems(Items.DIAMOND), RecipeCategory.DECORATIONS, DIAMOND_DOOR_ITEM)
                .criterion(hasItem(GOLD_DOOR_ITEM), conditionsFromItem(GOLD_DOOR_ITEM))
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .offerTo(exporter, "diamond_door_smithing");

        // Emerald door
        SmithingTransformRecipeJsonBuilder.create(Ingredient.EMPTY, Ingredient.ofItems(DIAMOND_DOOR_ITEM), Ingredient.ofItems(Items.EMERALD), RecipeCategory.DECORATIONS, EMERALD_DOOR_ITEM)
                .criterion(hasItem(DIAMOND_DOOR_ITEM), conditionsFromItem(DIAMOND_DOOR_ITEM))
                .criterion(hasItem(Items.EMERALD), conditionsFromItem(Items.EMERALD))
                .offerTo(exporter, "emerald_door_smithing");
    }
}
