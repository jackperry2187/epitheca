package jackperry2187.epitheca;

import jackperry2187.epitheca.data.generator.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class EpithecaDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		Epitheca.LOGGER.info("Data generator initialized");
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(EpithecaBlockLootTableProvider::new);
		pack.addProvider(EpithecaBlockTagProvider::new);
		pack.addProvider(EpithecaEnLanguageProvider::new);
		pack.addProvider(EpithecaItemTagProvider::new);
		pack.addProvider(EpithecaModelProvider::new);
		pack.addProvider(EpithecaRecipeProvider::new);
	}
}
