package jackperry2187.epitheca.init.block;

import jackperry2187.epitheca.block.RecrafterBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;

import static jackperry2187.epitheca.init.BlockInit.registerWithItem;

public class Recrafter {
    public static final Block RECRAFTER = registerWithItem("recrafter", new RecrafterBlock(Block.Settings.copy(Blocks.CRAFTING_TABLE)), new Item.Settings());

    public static void loadRecrafter() {}
}
