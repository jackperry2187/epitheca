package jackperry2187.epitheca;

import jackperry2187.epitheca.init.BlockInit;
import jackperry2187.epitheca.init.block.Glowstone;
import jackperry2187.epitheca.init.block.Shroomlight;
import jackperry2187.epitheca.init.block.Magma;
import jackperry2187.epitheca.init.ItemInit;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static net.minecraft.block.Blocks.*;

public class Epitheca implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("Epitheca");
	public static final String MOD_ID = "epitheca";

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing Epitheca...");

		// Load init classes
		ItemInit.load();
		BlockInit.load();

		// Load creative tab entries
		initializeShroomlightCreativeTabEntries();
		initializeGlowstoneCreativeTabEntries();
		initializeMagmaCreativeTabEntries();

		LOGGER.info("Initialized Successfully!");
	}

	public void initializeShroomlightCreativeTabEntries() {
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
	}

	public void initializeGlowstoneCreativeTabEntries() {
		// Add glowstones to creative tabs
		ItemStack original_glowstone = GLOWSTONE.asItem().getDefaultStack();
		List<ItemStack> GLOWSTONES = blocksToItemStacks(Glowstone.GLOWSTONES);
		List<ItemStack> BEFORE_GLOWSTONES = GLOWSTONES.subList(0, 6);
		List<ItemStack> AFTER_GLOWSTONES = GLOWSTONES.subList(6, GLOWSTONES.size());

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
			entries.addBefore(original_glowstone, BEFORE_GLOWSTONES);
			entries.addAfter(original_glowstone, AFTER_GLOWSTONES);
		});
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
			entries.addBefore(original_glowstone, BEFORE_GLOWSTONES);
			entries.addAfter(original_glowstone, AFTER_GLOWSTONES);
		});
	}

	public void initializeMagmaCreativeTabEntries() {
		// Add magmas to creative tabs
		ItemStack original_magma = MAGMA_BLOCK.asItem().getDefaultStack();
		List<ItemStack> MAGMAS = blocksToItemStacks(Magma.MAGMAS);
		List<ItemStack> BEFORE_MAGMAS = MAGMAS.subList(0, 6);
		List<ItemStack> AFTER_MAGMAS = MAGMAS.subList(6, MAGMAS.size());

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
			entries.addBefore(original_magma, BEFORE_MAGMAS);
			entries.addAfter(original_magma, AFTER_MAGMAS);
		});
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
			entries.addBefore(original_magma, BEFORE_MAGMAS);
			entries.addAfter(original_magma, AFTER_MAGMAS);
		});
	}

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}

	public static List<ItemStack> blocksToItemStacks(List<Block> blocks) {
		var x = blocks.stream().map(block -> block.asItem().getDefaultStack());
		return x.toList();
	}
}