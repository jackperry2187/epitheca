package jackperry2187.epitheca.init.block;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.CarvedPumpkinBlock;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.item.Item;

import java.util.List;
import java.util.stream.Stream;

import static jackperry2187.epitheca.init.BlockInit.registerWithItem;

public class Pumpkins {
    public static final Block PUMPKIN_NO_MOUTH = registerWithItem("pumpkin_no_mouth", new CarvedPumpkinBlock(HorizontalFacingBlock.Settings.copy(Blocks.CARVED_PUMPKIN)), new Item.Settings());
    public static final Block PUMPKIN_NO_MOUTH_LIT = registerWithItem("pumpkin_no_mouth_lit", new CarvedPumpkinBlock(HorizontalFacingBlock.Settings.copy(Blocks.JACK_O_LANTERN)), new Item.Settings());
    public static final Block PUMPKIN_SMILEY = registerWithItem("pumpkin_smiley", new CarvedPumpkinBlock(HorizontalFacingBlock.Settings.copy(Blocks.CARVED_PUMPKIN)), new Item.Settings());
    public static final Block PUMPKIN_SMILEY_LIT = registerWithItem("pumpkin_smiley_lit", new CarvedPumpkinBlock(HorizontalFacingBlock.Settings.copy(Blocks.JACK_O_LANTERN)), new Item.Settings());
    public static final Block PUMPKIN_FROWNY = registerWithItem("pumpkin_frowny", new CarvedPumpkinBlock(HorizontalFacingBlock.Settings.copy(Blocks.CARVED_PUMPKIN)), new Item.Settings());
    public static final Block PUMPKIN_FROWNY_LIT = registerWithItem("pumpkin_frowny_lit", new CarvedPumpkinBlock(HorizontalFacingBlock.Settings.copy(Blocks.JACK_O_LANTERN)), new Item.Settings());
    public static final Block PUMPKIN_ANGRY = registerWithItem("pumpkin_angry", new CarvedPumpkinBlock(HorizontalFacingBlock.Settings.copy(Blocks.CARVED_PUMPKIN)), new Item.Settings());
    public static final Block PUMPKIN_ANGRY_LIT = registerWithItem("pumpkin_angry_lit", new CarvedPumpkinBlock(HorizontalFacingBlock.Settings.copy(Blocks.JACK_O_LANTERN)), new Item.Settings());
    public static final Block PUMPKIN_GROGGY = registerWithItem("pumpkin_groggy", new CarvedPumpkinBlock(HorizontalFacingBlock.Settings.copy(Blocks.CARVED_PUMPKIN)), new Item.Settings());
    public static final Block PUMPKIN_GROGGY_LIT = registerWithItem("pumpkin_groggy_lit", new CarvedPumpkinBlock(HorizontalFacingBlock.Settings.copy(Blocks.JACK_O_LANTERN)), new Item.Settings());

    public static final List<Block> UNLIT_PUMPKINS = List.of(
            PUMPKIN_NO_MOUTH,
            PUMPKIN_SMILEY,
            PUMPKIN_FROWNY,
            PUMPKIN_ANGRY,
            PUMPKIN_GROGGY
    );

    public static final List<Block> LIT_PUMPKINS = List.of(
            PUMPKIN_NO_MOUTH_LIT,
            PUMPKIN_SMILEY_LIT,
            PUMPKIN_FROWNY_LIT,
            PUMPKIN_ANGRY_LIT,
            PUMPKIN_GROGGY_LIT
    );

    public static final List<Block> PUMPKINS = Stream.concat(UNLIT_PUMPKINS.stream(), LIT_PUMPKINS.stream()).toList();

    public static void loadPumpkins() {}
}
