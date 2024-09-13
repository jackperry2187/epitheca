package jackperry2187.epitheca;

import jackperry2187.epitheca.init.BlockInit;
import jackperry2187.epitheca.init.ItemInit;
import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Epitheca implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("Epitheca");
	public static final String MOD_ID = "epitheca";

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing Ancestors of Arda...");

		// Load init classes
		ItemInit.load();
		BlockInit.load();

		LOGGER.info("Initialized Successfully!");
	}

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}