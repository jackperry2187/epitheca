package jackperry2187.epitheca.init;

import jackperry2187.epitheca.Epitheca;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import java.util.List;

public class BlockInit {
    public static final Block SHROOMLIGHT_WHITE = registerWithItem("shroomlight_white", new Block(Block.Settings.copy(Blocks.SHROOMLIGHT)), new Item.Settings());
    public static final Block SHROOMLIGHT_LIGHT_GRAY = registerWithItem("shroomlight_light_gray", new Block(Block.Settings.copy(Blocks.SHROOMLIGHT)), new Item.Settings());
    public static final Block SHROOMLIGHT_GRAY = registerWithItem("shroomlight_gray", new Block(Block.Settings.copy(Blocks.SHROOMLIGHT)), new Item.Settings());
    public static final Block SHROOMLIGHT_BLACK = registerWithItem("shroomlight_black", new Block(Block.Settings.copy(Blocks.SHROOMLIGHT)), new Item.Settings());
    public static final Block SHROOMLIGHT_BROWN = registerWithItem("shroomlight_brown", new Block(Block.Settings.copy(Blocks.SHROOMLIGHT)), new Item.Settings());
    public static final Block SHROOMLIGHT_RED = registerWithItem("shroomlight_red", new Block(Block.Settings.copy(Blocks.SHROOMLIGHT)), new Item.Settings());
    // Orange - default texture
    public static final Block SHROOMLIGHT_YELLOW = registerWithItem("shroomlight_yellow", new Block(Block.Settings.copy(Blocks.SHROOMLIGHT)), new Item.Settings());
    public static final Block SHROOMLIGHT_LIME = registerWithItem("shroomlight_lime", new Block(Block.Settings.copy(Blocks.SHROOMLIGHT)), new Item.Settings());
    public static final Block SHROOMLIGHT_GREEN = registerWithItem("shroomlight_green", new Block(Block.Settings.copy(Blocks.SHROOMLIGHT)), new Item.Settings());
    public static final Block SHROOMLIGHT_CYAN = registerWithItem("shroomlight_cyan", new Block(Block.Settings.copy(Blocks.SHROOMLIGHT)), new Item.Settings());
    public static final Block SHROOMLIGHT_LIGHT_BLUE = registerWithItem("shroomlight_light_blue", new Block(Block.Settings.copy(Blocks.SHROOMLIGHT)), new Item.Settings());
    public static final Block SHROOMLIGHT_BLUE = registerWithItem("shroomlight_blue", new Block(Block.Settings.copy(Blocks.SHROOMLIGHT)), new Item.Settings());
    public static final Block SHROOMLIGHT_PURPLE = registerWithItem("shroomlight_purple", new Block(Block.Settings.copy(Blocks.SHROOMLIGHT)), new Item.Settings());
    public static final Block SHROOMLIGHT_MAGENTA = registerWithItem("shroomlight_magenta", new Block(Block.Settings.copy(Blocks.SHROOMLIGHT)), new Item.Settings());
    public static final Block SHROOMLIGHT_PINK = registerWithItem("shroomlight_pink", new Block(Block.Settings.copy(Blocks.SHROOMLIGHT)), new Item.Settings());

    public static final List<Block> SHROOMLIGHTS = List.of(
            SHROOMLIGHT_WHITE,
            SHROOMLIGHT_LIGHT_GRAY,
            SHROOMLIGHT_GRAY,
            SHROOMLIGHT_BLACK,
            SHROOMLIGHT_BROWN,
            SHROOMLIGHT_RED,
            SHROOMLIGHT_YELLOW,
            SHROOMLIGHT_LIME,
            SHROOMLIGHT_GREEN,
            SHROOMLIGHT_CYAN,
            SHROOMLIGHT_LIGHT_BLUE,
            SHROOMLIGHT_BLUE,
            SHROOMLIGHT_PURPLE,
            SHROOMLIGHT_MAGENTA,
            SHROOMLIGHT_PINK
    );

    public static <T extends Block> T register(String name, T block) {
        var register = Registry.register(Registries.BLOCK, Epitheca.id(name), block);
        // Epitheca.LOGGER.info("Successfully registered block: {}", name);
        return register;
    }

    public static <T extends Block> T registerWithItem(String name, T block, Item.Settings settings) {
        var returnedRegister = register(name, block);
        ItemInit.register(name, new BlockItem(returnedRegister, settings));
        return returnedRegister;
    }

    public static void load() {}
}
