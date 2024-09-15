package jackperry2187.epitheca.data.generator;

import jackperry2187.epitheca.Epitheca;
import jackperry2187.epitheca.init.TagInit;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

import static jackperry2187.epitheca.init.block.Shroomlight.SHROOMLIGHTS;

public class EpithecaBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public EpithecaBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        Epitheca.LOGGER.info("Generating block tags...");
        // Properly add tags to SHROOMLIGHTS
        SHROOMLIGHTS.forEach(block -> {
            getOrCreateTagBuilder(TagInit.SHROOMLIGHT).add(block);
            getOrCreateTagBuilder(BlockTags.HOE_MINEABLE).add(block);
            // Epitheca.LOGGER.info("Added {} to hoe mineable block tag", block.getTranslationKey());
        });
        // Add the original Shroomlight block to the shroomlight tag
        getOrCreateTagBuilder(TagInit.SHROOMLIGHT).add(Blocks.SHROOMLIGHT);
        Epitheca.LOGGER.info("Block tags generated successfully!");
    }
}
