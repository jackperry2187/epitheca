package jackperry2187.epitheca.init.block;

import net.minecraft.block.*;
import net.minecraft.item.Item;

import java.util.List;

import static jackperry2187.epitheca.init.BlockInit.registerWithItem;

public class Bookshelf {
    public static final Block ACACIA_BOOKSHELF = registerWithItem("acacia_bookshelf", new Block(AbstractBlock.Settings.copy(Blocks.BOOKSHELF)), new Item.Settings());
    public static final Block BAMBOO_BOOKSHELF = registerWithItem("bamboo_bookshelf", new Block(AbstractBlock.Settings.copy(Blocks.BOOKSHELF)), new Item.Settings());
    public static final Block BIRCH_BOOKSHELF = registerWithItem("birch_bookshelf", new Block(AbstractBlock.Settings.copy(Blocks.BOOKSHELF)), new Item.Settings());
    public static final Block CHERRY_BOOKSHELF = registerWithItem("cherry_bookshelf", new Block(AbstractBlock.Settings.copy(Blocks.BOOKSHELF)), new Item.Settings());
    public static final Block CRIMSON_BOOKSHELF = registerWithItem("crimson_bookshelf", new Block(AbstractBlock.Settings.copy(Blocks.BOOKSHELF)), new Item.Settings());
    public static final Block DARK_OAK_BOOKSHELF = registerWithItem("dark_oak_bookshelf", new Block(AbstractBlock.Settings.copy(Blocks.BOOKSHELF)), new Item.Settings());
    public static final Block JUNGLE_BOOKSHELF = registerWithItem("jungle_bookshelf", new Block(AbstractBlock.Settings.copy(Blocks.BOOKSHELF)), new Item.Settings());
    public static final Block MANGROVE_BOOKSHELF = registerWithItem("mangrove_bookshelf", new Block(AbstractBlock.Settings.copy(Blocks.BOOKSHELF)), new Item.Settings());
    // Oak - default texture
    public static final Block SPRUCE_BOOKSHELF = registerWithItem("spruce_bookshelf", new Block(AbstractBlock.Settings.copy(Blocks.BOOKSHELF)), new Item.Settings());
    public static final Block WARPED_BOOKSHELF = registerWithItem("warped_bookshelf", new Block(AbstractBlock.Settings.copy(Blocks.BOOKSHELF)), new Item.Settings());

    public static final List<Block> BOOKSHELVES = List.of(
            ACACIA_BOOKSHELF,
            BAMBOO_BOOKSHELF,
            BIRCH_BOOKSHELF,
            CHERRY_BOOKSHELF,
            CRIMSON_BOOKSHELF,
            DARK_OAK_BOOKSHELF,
            JUNGLE_BOOKSHELF,
            MANGROVE_BOOKSHELF,
            SPRUCE_BOOKSHELF,
            WARPED_BOOKSHELF
    );

    public static void loadBookshelves() {}
}
