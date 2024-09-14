package jackperry2187.epitheca.data.generator;

import jackperry2187.epitheca.Epitheca;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
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
        Epitheca.LOGGER.info("Generating tags...");
        // Properly add tags to SHROOMLIGHTS
        SHROOMLIGHTS.forEach(block -> {
            getOrCreateTagBuilder(BlockTags.HOE_MINEABLE).add(block);
            // Epitheca.LOGGER.info("Added {} to hoe mineable block tag", block.getTranslationKey());
        });
        Epitheca.LOGGER.info("Tags generated successfully!");
    }
}
