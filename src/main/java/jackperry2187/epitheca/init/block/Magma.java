package jackperry2187.epitheca.init.block;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;

import java.util.List;

import static jackperry2187.epitheca.init.BlockInit.registerWithItem;

public class Magma {
    public static final Block MAGMA_WHITE = registerWithItem("magma_white", new Block(Block.Settings.copy(Blocks.MAGMA_BLOCK)), new Item.Settings());
    public static final Block MAGMA_LIGHT_GRAY = registerWithItem("magma_light_gray", new Block(Block.Settings.copy(Blocks.MAGMA_BLOCK)), new Item.Settings());
    public static final Block MAGMA_GRAY = registerWithItem("magma_gray", new Block(Block.Settings.copy(Blocks.MAGMA_BLOCK)), new Item.Settings());
    public static final Block MAGMA_BLACK = registerWithItem("magma_black", new Block(Block.Settings.copy(Blocks.MAGMA_BLOCK)), new Item.Settings());
    public static final Block MAGMA_BROWN = registerWithItem("magma_brown", new Block(Block.Settings.copy(Blocks.MAGMA_BLOCK)), new Item.Settings());
    public static final Block MAGMA_RED = registerWithItem("magma_red", new Block(Block.Settings.copy(Blocks.MAGMA_BLOCK)), new Item.Settings());
    // Orange - default texture
    public static final Block MAGMA_YELLOW = registerWithItem("magma_yellow", new Block(Block.Settings.copy(Blocks.MAGMA_BLOCK)), new Item.Settings());
    public static final Block MAGMA_LIME = registerWithItem("magma_lime", new Block(Block.Settings.copy(Blocks.MAGMA_BLOCK)), new Item.Settings());
    public static final Block MAGMA_GREEN = registerWithItem("magma_green", new Block(Block.Settings.copy(Blocks.MAGMA_BLOCK)), new Item.Settings());
    public static final Block MAGMA_CYAN = registerWithItem("magma_cyan", new Block(Block.Settings.copy(Blocks.MAGMA_BLOCK)), new Item.Settings());
    public static final Block MAGMA_LIGHT_BLUE = registerWithItem("magma_light_blue", new Block(Block.Settings.copy(Blocks.MAGMA_BLOCK)), new Item.Settings());
    public static final Block MAGMA_BLUE = registerWithItem("magma_blue", new Block(Block.Settings.copy(Blocks.MAGMA_BLOCK)), new Item.Settings());
    public static final Block MAGMA_PURPLE = registerWithItem("magma_purple", new Block(Block.Settings.copy(Blocks.MAGMA_BLOCK)), new Item.Settings());
    public static final Block MAGMA_MAGENTA = registerWithItem("magma_magenta", new Block(Block.Settings.copy(Blocks.MAGMA_BLOCK)), new Item.Settings());
    public static final Block MAGMA_PINK = registerWithItem("magma_pink", new Block(Block.Settings.copy(Blocks.MAGMA_BLOCK)), new Item.Settings());

    public static final List<Block> MAGMAS = List.of(
            MAGMA_WHITE,
            MAGMA_LIGHT_GRAY,
            MAGMA_GRAY,
            MAGMA_BLACK,
            MAGMA_BROWN,
            MAGMA_RED,
            MAGMA_YELLOW,
            MAGMA_LIME,
            MAGMA_GREEN,
            MAGMA_CYAN,
            MAGMA_LIGHT_BLUE,
            MAGMA_BLUE,
            MAGMA_PURPLE,
            MAGMA_MAGENTA,
            MAGMA_PINK
    );

    public static void loadMagmas() {}
}
