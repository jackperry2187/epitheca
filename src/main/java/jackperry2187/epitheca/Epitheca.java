package jackperry2187.epitheca;

import jackperry2187.epitheca.init.BlockInit;
import jackperry2187.epitheca.init.block.Shroomlight;
import jackperry2187.epitheca.init.ItemInit;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import static net.minecraft.block.Blocks.SHROOMLIGHT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Epitheca implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("Epitheca");
	public static final String MOD_ID = "epitheca";

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing Ancestors of Arda...");

		// Load init classes
		ItemInit.load();
		BlockInit.load();

		// Add shroomlights to creative tabs
		ItemStack original_shroomlight = SHROOMLIGHT.asItem().getDefaultStack();
		List<ItemStack> SHROOMLIGHTS = blocksToItemStacks(Shroomlight.SHROOMLIGHTS);
		List<ItemStack> BEFORE_SHROOMLIGHTS = SHROOMLIGHTS.subList(0, 6);
		List<ItemStack> AFTER_SHROOMLIGHTS = SHROOMLIGHTS.subList(6, SHROOMLIGHTS.size());

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
			entries.addBefore(original_shroomlight, BEFORE_SHROOMLIGHTS);
			entries.addAfter(original_shroomlight, AFTER_SHROOMLIGHTS);
		});
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
			entries.addBefore(original_shroomlight, BEFORE_SHROOMLIGHTS);
			entries.addAfter(original_shroomlight, AFTER_SHROOMLIGHTS);
		});

		LOGGER.info("Initialized Successfully!");
	}

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}

	public static List<ItemStack> blocksToItemStacks(List<Block> blocks) {
		var x = blocks.stream().map(block -> block.asItem().getDefaultStack());
		return x.toList();
	}
}