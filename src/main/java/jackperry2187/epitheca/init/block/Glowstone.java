package jackperry2187.epitheca.init.block;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;

import java.util.List;

import static jackperry2187.epitheca.init.BlockInit.registerWithItem;

public class Glowstone {
    public static final Block GLOWSTONE_WHITE = registerWithItem("glowstone_white", new Block(Block.Settings.copy(Blocks.GLOWSTONE)), new Item.Settings());
    public static final Block GLOWSTONE_LIGHT_GRAY = registerWithItem("glowstone_light_gray", new Block(Block.Settings.copy(Blocks.GLOWSTONE)), new Item.Settings());
    public static final Block GLOWSTONE_GRAY = registerWithItem("glowstone_gray", new Block(Block.Settings.copy(Blocks.GLOWSTONE)), new Item.Settings());
    public static final Block GLOWSTONE_BLACK = registerWithItem("glowstone_black", new Block(Block.Settings.copy(Blocks.GLOWSTONE)), new Item.Settings());
    public static final Block GLOWSTONE_BROWN = registerWithItem("glowstone_brown", new Block(Block.Settings.copy(Blocks.GLOWSTONE)), new Item.Settings());
    public static final Block GLOWSTONE_RED = registerWithItem("glowstone_red", new Block(Block.Settings.copy(Blocks.GLOWSTONE)), new Item.Settings());
    // Orange - default texture
    public static final Block GLOWSTONE_YELLOW = registerWithItem("glowstone_yellow", new Block(Block.Settings.copy(Blocks.GLOWSTONE)), new Item.Settings());
    public static final Block GLOWSTONE_LIME = registerWithItem("glowstone_lime", new Block(Block.Settings.copy(Blocks.GLOWSTONE)), new Item.Settings());
    public static final Block GLOWSTONE_GREEN = registerWithItem("glowstone_green", new Block(Block.Settings.copy(Blocks.GLOWSTONE)), new Item.Settings());
    public static final Block GLOWSTONE_CYAN = registerWithItem("glowstone_cyan", new Block(Block.Settings.copy(Blocks.GLOWSTONE)), new Item.Settings());
    public static final Block GLOWSTONE_LIGHT_BLUE = registerWithItem("glowstone_light_blue", new Block(Block.Settings.copy(Blocks.GLOWSTONE)), new Item.Settings());
    public static final Block GLOWSTONE_BLUE = registerWithItem("glowstone_blue", new Block(Block.Settings.copy(Blocks.GLOWSTONE)), new Item.Settings());
    public static final Block GLOWSTONE_PURPLE = registerWithItem("glowstone_purple", new Block(Block.Settings.copy(Blocks.GLOWSTONE)), new Item.Settings());
    public static final Block GLOWSTONE_MAGENTA = registerWithItem("glowstone_magenta", new Block(Block.Settings.copy(Blocks.GLOWSTONE)), new Item.Settings());
    public static final Block GLOWSTONE_PINK = registerWithItem("glowstone_pink", new Block(Block.Settings.copy(Blocks.GLOWSTONE)), new Item.Settings());

    public static final List<Block> GLOWSTONES = List.of(
            GLOWSTONE_WHITE,
            GLOWSTONE_LIGHT_GRAY,
            GLOWSTONE_GRAY,
            GLOWSTONE_BLACK,
            GLOWSTONE_BROWN,
            GLOWSTONE_RED,
            GLOWSTONE_YELLOW,
            GLOWSTONE_LIME,
            GLOWSTONE_GREEN,
            GLOWSTONE_CYAN,
            GLOWSTONE_LIGHT_BLUE,
            GLOWSTONE_BLUE,
            GLOWSTONE_PURPLE,
            GLOWSTONE_MAGENTA,
            GLOWSTONE_PINK
    );

    public static void loadGlowstones() {}
}
