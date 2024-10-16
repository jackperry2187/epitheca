package jackperry2187.epitheca.data.generator;

import jackperry2187.epitheca.Epitheca;
import jackperry2187.epitheca.init.TagInit;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

import static jackperry2187.epitheca.init.block.Doors.DOORS;
import static jackperry2187.epitheca.init.block.Glowstone.GLOWSTONES;
import static jackperry2187.epitheca.init.block.Magma.MAGMAS;
import static jackperry2187.epitheca.init.block.Pumpkins.PUMPKINS;
import static jackperry2187.epitheca.init.block.Shroomlight.SHROOMLIGHTS;

public class EpithecaItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public EpithecaItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        Epitheca.LOGGER.info("Generating item tags...");
        configureShroomlights();
        configureGlowstones();
        configureMagmas();
        configureDoors();
        configurePumpkins();
        Epitheca.LOGGER.info("Item tags generated successfully!");
    }

    public void configureShroomlights() {
        // Properly add tags to SHROOMLIGHTS
        SHROOMLIGHTS.forEach(block -> {
            getOrCreateTagBuilder(TagInit.SHROOMLIGHT_ITEM).add(block.asItem());
            // Epitheca.LOGGER.info("Added {} to the shroomlight_item tag", block.getTranslationKey());
        });
        // Add the original Shroomlight item to the shroomlight tag
        getOrCreateTagBuilder(TagInit.SHROOMLIGHT_ITEM).add(Blocks.SHROOMLIGHT.asItem());
        // Epitheca.LOGGER.info("Added {} to the shroomlight_item tag", Blocks.SHROOMLIGHT.getTranslationKey());
    }

    public void configureGlowstones() {
        // Properly add tags to GLOWSTONES
        GLOWSTONES.forEach(block -> {
            getOrCreateTagBuilder(TagInit.GLOWSTONE_ITEM).add(block.asItem());
            // Epitheca.LOGGER.info("Added {} to the glowstone_item tag", block.getTranslationKey());
        });
        // Add the original Glowstone item to the glowstone tag
        getOrCreateTagBuilder(TagInit.GLOWSTONE_ITEM).add(Blocks.GLOWSTONE.asItem());
        // Epitheca.LOGGER.info("Added {} to the glowstone_item tag", Blocks.GLOWSTONE.getTranslationKey());
    }

    public void configureMagmas() {
        // Properly add tags to MAGMAS
        MAGMAS.forEach(block -> {
            getOrCreateTagBuilder(TagInit.MAGMA_ITEM).add(block.asItem());
            // Epitheca.LOGGER.info("Added {} to the magma_item tag", block.getTranslationKey());
        });
        // Add the original Glowstone item to the magma tag
        getOrCreateTagBuilder(TagInit.MAGMA_ITEM).add(Blocks.MAGMA_BLOCK.asItem());
        // Epitheca.LOGGER.info("Added {} to the magma_item tag", Blocks.MAGMA_BLOCK.getTranslationKey());
    }

    public void configureDoors() {
        // Properly add tags to DOORS
        DOORS.forEach(block -> {
            getOrCreateTagBuilder(ItemTags.DOORS).add(block.asItem());
        });
    }

    public void configurePumpkins() {
        // Properly add tags to PUMPKINS
        PUMPKINS.forEach(block -> {
            getOrCreateTagBuilder(TagInit.PUMPKIN_ITEM).add(block.asItem());
            getOrCreateTagBuilder(ItemTags.EQUIPPABLE_ENCHANTABLE).add(block.asItem());
            getOrCreateTagBuilder(ItemTags.VANISHING_ENCHANTABLE).add(block.asItem());
        });
    }
}
