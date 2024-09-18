package jackperry2187.epitheca.data.generator;

import jackperry2187.epitheca.Epitheca;
import jackperry2187.epitheca.init.TagInit;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

import static jackperry2187.epitheca.init.block.Doors.DOORS;
import static jackperry2187.epitheca.init.block.Glowstone.GLOWSTONES;
import static jackperry2187.epitheca.init.block.Magma.MAGMAS;
import static jackperry2187.epitheca.init.block.Shroomlight.SHROOMLIGHTS;

public class EpithecaBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public EpithecaBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        Epitheca.LOGGER.info("Generating block tags...");
        configureShroomlights();
        configureGlowstones();
        configureMagmas();
        configureDoors();
        Epitheca.LOGGER.info("Block tags generated successfully!");
    }

    public void configureShroomlights() {
        // Properly add tags to SHROOMLIGHTS
        SHROOMLIGHTS.forEach(block -> {
            getOrCreateTagBuilder(TagInit.SHROOMLIGHT).add(block);
            getOrCreateTagBuilder(BlockTags.HOE_MINEABLE).add(block);
        });
        // Add the original Shroomlight block to the shroomlight tag
        getOrCreateTagBuilder(TagInit.SHROOMLIGHT).add(Blocks.SHROOMLIGHT);
    }

    public void configureGlowstones() {
        // Properly add tags to GLOWSTONES
         GLOWSTONES.forEach(block -> {
             getOrCreateTagBuilder(TagInit.GLOWSTONE).add(block);
         });
         // Add the original Glowstone block to the glowstone tag
         getOrCreateTagBuilder(TagInit.GLOWSTONE).add(Blocks.GLOWSTONE);
    }

    public void configureMagmas() {
        // Properly add tags to MAGMAS
        MAGMAS.forEach(block -> {
            getOrCreateTagBuilder(TagInit.MAGMA).add(block);
            getOrCreateTagBuilder(BlockTags.INFINIBURN_END).add(block);
            getOrCreateTagBuilder(BlockTags.INFINIBURN_OVERWORLD).add(block);
            getOrCreateTagBuilder(BlockTags.INFINIBURN_NETHER).add(block);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(block);
        });
        // Add the original Glowstone block to the glowstone tag
        getOrCreateTagBuilder(TagInit.MAGMA).add(Blocks.MAGMA_BLOCK);
    }

    public void configureDoors() {
        // Properly add tags to DOORS
        DOORS.forEach(block -> {
            getOrCreateTagBuilder(BlockTags.DOORS).add(block);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(block);
        });
    }
}
