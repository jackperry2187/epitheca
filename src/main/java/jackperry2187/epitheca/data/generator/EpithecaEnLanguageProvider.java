package jackperry2187.epitheca.data.generator;

import jackperry2187.epitheca.Epitheca;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

import static jackperry2187.epitheca.init.BlockInit.SHROOMLIGHTS;

public class EpithecaEnLanguageProvider extends FabricLanguageProvider {
    public EpithecaEnLanguageProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
        Epitheca.LOGGER.info("Generating translations...");
        // Generate translations for each Shroomlight variant
        SHROOMLIGHTS.forEach(block -> {
            String translationKey = block.getTranslationKey();
            String color = translationKey.substring(translationKey.lastIndexOf('_') + 1);
            String casedColor = color.substring(0, 1).toUpperCase() + color.substring(1);
            translationBuilder.add(translationKey, casedColor + " Shroomlight");
            // Epitheca.LOGGER.info("Added translation for {} to {} Shroomlight", translationKey, casedColor);
        });
        Epitheca.LOGGER.info("Translations generated successfully!");
    }
}
