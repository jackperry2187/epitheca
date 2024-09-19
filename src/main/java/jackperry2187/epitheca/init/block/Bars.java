package jackperry2187.epitheca.init.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.PaneBlock;
import net.minecraft.item.Item;

import java.util.List;

import static jackperry2187.epitheca.init.BlockInit.registerWithItem;

public class Bars {
    public static final Block COBBLESTONE_BARS = registerWithItem("cobblestone_bars", new PaneBlock(AbstractBlock.Settings.copy(Blocks.IRON_BARS)), new Item.Settings());
    public static final Block MOSSY_COBBLESTONE_BARS = registerWithItem("mossy_cobblestone_bars", new PaneBlock(AbstractBlock.Settings.copy(Blocks.IRON_BARS)), new Item.Settings());
    public static final Block SMOOTH_STONE_BARS = registerWithItem("smooth_stone_bars", new PaneBlock(AbstractBlock.Settings.copy(Blocks.IRON_BARS)), new Item.Settings());
    public static final Block COBBLED_DEEPSLATE_BARS = registerWithItem("cobbled_deepslate_bars", new PaneBlock(AbstractBlock.Settings.copy(Blocks.IRON_BARS)), new Item.Settings());
    public static final Block GOLD_BARS = registerWithItem("gold_bars", new PaneBlock(AbstractBlock.Settings.copy(Blocks.IRON_BARS)), new Item.Settings());
    public static final Block DIAMOND_BARS = registerWithItem("diamond_bars", new PaneBlock(AbstractBlock.Settings.copy(Blocks.IRON_BARS)), new Item.Settings());
    public static final Block EMERALD_BARS = registerWithItem("emerald_bars", new PaneBlock(AbstractBlock.Settings.copy(Blocks.IRON_BARS)), new Item.Settings());

    public static final List<Block> BARS = List.of(
            COBBLESTONE_BARS,
            MOSSY_COBBLESTONE_BARS,
            COBBLED_DEEPSLATE_BARS,
            SMOOTH_STONE_BARS,
            GOLD_BARS,
            DIAMOND_BARS,
            EMERALD_BARS
    );

    public static void loadBars() {}
}
