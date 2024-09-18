package jackperry2187.epitheca.init.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.DoorBlock;

import java.util.List;

import static jackperry2187.epitheca.init.BlockInit.register;
import static jackperry2187.epitheca.init.BlockSetTypeInit.getDoorSet;

public class Doors {
    private static final AbstractBlock.Settings DOOR_SETTINGS = AbstractBlock.Settings.copy(Blocks.IRON_DOOR);
    public static final Block COBBLESTONE_DOOR = register("cobblestone_door", new DoorBlock(getDoorSet("cobblestone"), DOOR_SETTINGS));
    public static final Block MOSSY_COBBLESTONE_DOOR = register("mossy_cobblestone_door", new DoorBlock(getDoorSet("mossy_cobblestone"), DOOR_SETTINGS));
    public static final Block SMOOTH_STONE_DOOR = register("smooth_stone_door", new DoorBlock(getDoorSet("smooth_stone"), DOOR_SETTINGS));
    public static final Block COBBLED_DEEPSLATE_DOOR = register("cobbled_deepslate_door", new DoorBlock(getDoorSet("cobbled_deepslate"), DOOR_SETTINGS));
    public static final Block GOLD_DOOR = register("gold_door", new DoorBlock(getDoorSet("gold"), DOOR_SETTINGS));
    public static final Block DIAMOND_DOOR = register("diamond_door", new DoorBlock(getDoorSet("diamond"), DOOR_SETTINGS));
    public static final Block EMERALD_DOOR = register("emerald_door", new DoorBlock(getDoorSet("emerald"), DOOR_SETTINGS));

    public static final List<Block> DOORS = List.of(
            COBBLESTONE_DOOR,
            MOSSY_COBBLESTONE_DOOR,
            SMOOTH_STONE_DOOR,
            COBBLED_DEEPSLATE_DOOR,
            GOLD_DOOR,
            DIAMOND_DOOR,
            EMERALD_DOOR
    );

    public static void loadDoorBlocks() {}
}
