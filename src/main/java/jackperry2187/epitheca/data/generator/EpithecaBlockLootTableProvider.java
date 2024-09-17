package jackperry2187.epitheca.data.generator;

import jackperry2187.epitheca.Epitheca;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

import static jackperry2187.epitheca.init.block.Glowstone.GLOWSTONES;
import static jackperry2187.epitheca.init.block.Shroomlight.SHROOMLIGHTS;

public class EpithecaBlockLootTableProvider extends FabricBlockLootTableProvider {

    public EpithecaBlockLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        Epitheca.LOGGER.info("Generating block loot tables...");
        generateShroomlights();
        generateGlowstones();
        Epitheca.LOGGER.info("Block loot tables generated successfully!");
    }

    public void generateShroomlights() {
        // Generate loot tables for each Shroomlight variant
        SHROOMLIGHTS.forEach(block -> {
            addDrop(block);
            // Epitheca.LOGGER.info("Added loot table for {}", block.getTranslationKey());
        });
    }

    public void generateGlowstones() {
        // Generate loot tables for each Glowstone variant
         GLOWSTONES.forEach(block -> {
             addDrop(block);
             // Epitheca.LOGGER.info("Added loot table for {}", block.getTranslationKey());
         });
    }
}