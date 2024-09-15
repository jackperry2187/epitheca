package jackperry2187.epitheca.data.generator;

import jackperry2187.epitheca.Epitheca;
import jackperry2187.epitheca.init.TagInit;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

import static jackperry2187.epitheca.init.block.Shroomlight.SHROOMLIGHTS;

public class EpithecaItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public EpithecaItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        Epitheca.LOGGER.info("Generating item tags...");
        // Properly add tags to SHROOMLIGHTS
        SHROOMLIGHTS.forEach(block -> {
            getOrCreateTagBuilder(TagInit.SHROOMLIGHT_ITEM).add(block.asItem());
        });
        // Add the original Shroomlight item to the shroomlight tag
        getOrCreateTagBuilder(TagInit.SHROOMLIGHT_ITEM).add(Blocks.SHROOMLIGHT.asItem());
        Epitheca.LOGGER.info("Item tags generated successfully!");
    }
}
