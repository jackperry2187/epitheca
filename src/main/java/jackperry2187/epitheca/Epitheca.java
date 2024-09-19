package jackperry2187.epitheca;

import jackperry2187.epitheca.init.BlockInit;
import jackperry2187.epitheca.init.ItemInit;
import jackperry2187.epitheca.init.block.*;
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
		initializeDoorCreativeTabEntries();
		initializeBarsCreativeTabEntries();

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

	public void initializeDoorCreativeTabEntries() {
		// Add doors to creative tabs
		ItemStack original_door = IRON_DOOR.asItem().getDefaultStack();
		List<ItemStack> DOORS = blocksToItemStacks(Doors.DOORS);
		List<ItemStack> BEFORE_DOORS = DOORS.subList(0, 4);
		List<ItemStack> AFTER_DOORS = DOORS.subList(4, DOORS.size());

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
			entries.addBefore(original_door, BEFORE_DOORS);
			entries.addAfter(original_door, AFTER_DOORS);
		});
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(entries -> {
			entries.addBefore(original_door, BEFORE_DOORS);
			entries.addAfter(original_door, AFTER_DOORS);
		});
	}

	public void initializeBarsCreativeTabEntries() {
		// Add bars to creative tabs
		ItemStack original_bars = IRON_BARS.asItem().getDefaultStack();
		List<ItemStack> BARS = blocksToItemStacks(Bars.BARS);
		List<ItemStack> BEFORE_BARS = BARS.subList(0, 4);
		List<ItemStack> AFTER_BARS = BARS.subList(4, BARS.size());

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
			entries.addBefore(original_bars, BEFORE_BARS);
			entries.addAfter(original_bars, AFTER_BARS);
		});
	}

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}

	public static List<ItemStack> blocksToItemStacks(List<Block> blocks) {
		var x = blocks.stream().map(block -> block.asItem().getDefaultStack());
		return x.toList();
	}

	public static String capsCase(String str, String delimiter) {
		String[] words = str.split(delimiter);
		StringBuilder sb = new StringBuilder();
		for (String word : words) {
			sb.append(word.substring(0, 1).toUpperCase()).append(word.substring(1)).append(" ");
		}
		return sb.toString().trim();
	}
}