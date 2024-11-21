package jackperry2187.epitheca.data.generator;

import jackperry2187.epitheca.Epitheca;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

import static jackperry2187.epitheca.init.block.Bars.BARS;
import static jackperry2187.epitheca.init.block.Doors.DOORS;
import static jackperry2187.epitheca.init.block.Glowstone.GLOWSTONES;
import static jackperry2187.epitheca.init.block.Magma.MAGMAS;
import static jackperry2187.epitheca.init.block.Pumpkins.PUMPKINS;
import static jackperry2187.epitheca.init.block.Recrafter.RECRAFTER;
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
        generateMagmas();
        generateDoors();
        generateBars();
        generatePumpkins();
        generateRecrafter();
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

    public void generateMagmas() {
        // Generate loot tables for each Magma variant
        MAGMAS.forEach(block -> {
            addDrop(block);
            // Epitheca.LOGGER.info("Added loot table for {}", block.getTranslationKey());
        });
    }

    public void generateDoors() {
        // Generate loot tables for each Door variant
        DOORS.forEach(block -> {
            doorDrops(block);
            // Epitheca.LOGGER.info("Added loot table for {}", block.getTranslationKey());
        });
    }

    public void generateBars() {
        // Generate loot tables for each Bars variant
        BARS.forEach(block -> {
            addDrop(block);
            // Epitheca.LOGGER.info("Added loot table for {}", block.getTranslationKey());
        });
    }

    public void generatePumpkins() {
        // Generate loot tables for each Pumpkin variant
        PUMPKINS.forEach(block -> {
            addDrop(block);
            // Epitheca.LOGGER.info("Added loot table for {}", block.getTranslationKey());
        });
    }

    private void generateRecrafter() {
        // Generate loot tables for Recrafter
        addDrop(RECRAFTER);
    }
}
