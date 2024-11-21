package jackperry2187.epitheca.data.generator;

import jackperry2187.epitheca.Epitheca;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

import static jackperry2187.epitheca.init.block.Bars.BARS;
import static jackperry2187.epitheca.init.block.Doors.DOORS;
import static jackperry2187.epitheca.init.block.Glowstone.GLOWSTONES;
import static jackperry2187.epitheca.init.block.Magma.MAGMAS;
import static jackperry2187.epitheca.init.block.Pumpkins.PUMPKINS;
import static jackperry2187.epitheca.init.block.Recrafter.RECRAFTER;
import static jackperry2187.epitheca.init.block.Shroomlight.SHROOMLIGHTS;

public class EpithecaEnLanguageProvider extends FabricLanguageProvider {
    public EpithecaEnLanguageProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
        Epitheca.LOGGER.info("Generating translations...");
        generateShroomlightTranslations(translationBuilder);
        generateGlowstoneTranslations(translationBuilder);
        generateMagmaTranslations(translationBuilder);
        generateDoorTranslations(translationBuilder);
        generateBarTranslations(translationBuilder);
        generatePumpkinTranslations(translationBuilder);
        translationBuilder.add(RECRAFTER.getTranslationKey(), "Recrafter");
        Epitheca.LOGGER.info("Translations generated successfully!");
    }

    public void generateShroomlightTranslations(TranslationBuilder translationBuilder) {
        // Generate translations for each Shroomlight variant
        SHROOMLIGHTS.forEach(block -> {
            // translation key is formatted as block.epitheca.shroomlight_[light_]<color>
            String translationKey = block.getTranslationKey();
            String casedColor = Epitheca.capsCase(translationKey.substring(translationKey.indexOf('_') + 1), "_");
            translationBuilder.add(translationKey, casedColor + " Shroomlight");
            // Epitheca.LOGGER.info("Added translation for {} to {} Shroomlight", translationKey, casedColor);
        });
    }

    public void generateGlowstoneTranslations(TranslationBuilder translationBuilder) {
        // Generate translations for each Glowstone variant
        GLOWSTONES.forEach(block -> {
            // translation key is formatted as block.epitheca.glowstone_[light_]<color>
            String translationKey = block.getTranslationKey();
            String casedColor = Epitheca.capsCase(translationKey.substring(translationKey.indexOf('_') + 1), "_");
            translationBuilder.add(translationKey, casedColor + " Glowstone");
            // Epitheca.LOGGER.info("Added translation for {} to {} Glowstone", translationKey, casedColor);
        });
    }

    public void generateMagmaTranslations(TranslationBuilder translationBuilder) {
        // Generate translations for each Magma variant
        MAGMAS.forEach(block -> {
            // translation key is formatted as block.epitheca.magma_[light_]<color>
            String translationKey = block.getTranslationKey();
            String casedColor = Epitheca.capsCase(translationKey.substring(translationKey.indexOf('_') + 1), "_");
            translationBuilder.add(translationKey, casedColor + " Magma");
            // Epitheca.LOGGER.info("Added translation for {} to {} Magma", translationKey, casedColor);
        });
    }

    public void generateDoorTranslations(TranslationBuilder translationBuilder) {
        // Generate translations for each Door variant
        DOORS.forEach(block -> {
            // translation key is formatted as block.epitheca.<material>_door
            String translationKey = block.getTranslationKey();
            String casedMaterial = Epitheca.capsCase(translationKey.substring(translationKey.lastIndexOf('.') + 1), "_");
            translationBuilder.add(translationKey, casedMaterial);
            // Epitheca.LOGGER.info("Added translation for {} to {}", translationKey, casedMaterial);
        });
    }

    public void generateBarTranslations(TranslationBuilder translationBuilder) {
        // Generate translations for each Bars variant
        BARS.forEach(block -> {
            // translation key is formatted as block.epitheca.<material>_bars
            String translationKey = block.getTranslationKey();
            String casedMaterial = Epitheca.capsCase(translationKey.substring(translationKey.lastIndexOf('.') + 1), "_");
            translationBuilder.add(translationKey, casedMaterial);
            // Epitheca.LOGGER.info("Added translation for {} to {}", translationKey, casedMaterial);
        });
    }

    public void generatePumpkinTranslations(TranslationBuilder translationBuilder) {
        // Generate translations for each Pumpkin variant
        PUMPKINS.forEach(block -> {
            // translation key is formatted as block.epitheca.pumpkin_<expression>[_lit]
            String translationKey = block.getTranslationKey();
            String casedExpression = Epitheca.capsCase(translationKey.substring(translationKey.indexOf('_') + 1), "_");
            translationBuilder.add(translationKey, casedExpression + " Pumpkin");
            // Epitheca.LOGGER.info("Added translation for {} to {}", translationKey, casedExpression);
        });
    }
}
