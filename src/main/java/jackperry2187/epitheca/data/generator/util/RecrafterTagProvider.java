package jackperry2187.epitheca.data.generator.util;

import jackperry2187.epitheca.Epitheca;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

import static jackperry2187.epitheca.init.block.Bars.BARS;
import static jackperry2187.epitheca.init.block.Bookshelf.BOOKSHELVES;
import static jackperry2187.epitheca.init.block.Doors.DOORS;
import static jackperry2187.epitheca.init.block.Glowstone.GLOWSTONES;
import static jackperry2187.epitheca.init.block.Magma.MAGMAS;
import static jackperry2187.epitheca.init.block.Pumpkins.PUMPKINS;
import static jackperry2187.epitheca.init.block.Recrafter.RECRAFTER;
import static jackperry2187.epitheca.init.block.Shroomlight.SHROOMLIGHTS;

public class RecrafterTagProvider {
    public static void configure(FabricTagProvider<Item>.FabricTagBuilder tagBuilder) {
        Epitheca.LOGGER.info("Generating recrafter input tags...");
        configureShroomlights(tagBuilder);
        configureGlowstones(tagBuilder);
        configureMagmas(tagBuilder);
        configureDoors(tagBuilder);
        configureBars(tagBuilder);
        configurePumpkins(tagBuilder);
        configureRecrafter(tagBuilder);
        configureBookshelves(tagBuilder);
        Epitheca.LOGGER.info("Recrafter input tags generated successfully!");
    }

    private static void configureShroomlights(FabricTagProvider<Item>.FabricTagBuilder tagBuilder) {
        SHROOMLIGHTS.forEach(block -> {
            tagBuilder.add(block.asItem());
        });
        tagBuilder.add(Blocks.SHROOMLIGHT.asItem());
    }

    private static void configureGlowstones(FabricTagProvider<Item>.FabricTagBuilder tagBuilder) {
        GLOWSTONES.forEach(block -> {
            tagBuilder.add(block.asItem());
        });
        tagBuilder.add(Blocks.GLOWSTONE.asItem());
    }

    private static void configureMagmas(FabricTagProvider<Item>.FabricTagBuilder tagBuilder) {
        MAGMAS.forEach(block -> {
            tagBuilder.add(block.asItem());
        });
        tagBuilder.add(Blocks.MAGMA_BLOCK.asItem());
    }

    private static void configureDoors(FabricTagProvider<Item>.FabricTagBuilder tagBuilder) {
        DOORS.forEach(block -> {
            tagBuilder.add(block.asItem());
        });
        tagBuilder.add(Blocks.IRON_DOOR.asItem());
    }

    private static void configureBars(FabricTagProvider<Item>.FabricTagBuilder tagBuilder) {
        BARS.forEach(block -> {
            tagBuilder.add(block.asItem());
        });
        tagBuilder.add(Blocks.IRON_BARS.asItem());
    }

    private static void configurePumpkins(FabricTagProvider<Item>.FabricTagBuilder tagBuilder) {
        PUMPKINS.forEach(block -> {
            tagBuilder.add(block.asItem());
        });
        tagBuilder.add(Blocks.CARVED_PUMPKIN.asItem());
        tagBuilder.add(Blocks.JACK_O_LANTERN.asItem());
    }

    private static void configureRecrafter(FabricTagProvider<Item>.FabricTagBuilder tagBuilder) {
        tagBuilder.add(RECRAFTER.asItem());
        tagBuilder.add(Items.CRAFTING_TABLE);
    }

    private static void configureBookshelves(FabricTagProvider<Item>.FabricTagBuilder tagBuilder) {
        BOOKSHELVES.forEach(block -> {
            tagBuilder.add(block.asItem());
        });
        tagBuilder.add(Blocks.BOOKSHELF.asItem());
    }
}
