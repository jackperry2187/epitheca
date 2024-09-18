package jackperry2187.epitheca.init.item;

import net.minecraft.item.Item;
import net.minecraft.item.TallBlockItem;

import static jackperry2187.epitheca.init.ItemInit.register;
import static jackperry2187.epitheca.init.block.Doors.*;

public class Doors {
    public static final Item COBBLESTONE_DOOR_ITEM = register("cobblestone_door", new TallBlockItem(COBBLESTONE_DOOR, new Item.Settings()));
    public static final Item MOSSY_COBBLESTONE_DOOR_ITEM = register("mossy_cobblestone_door", new TallBlockItem(MOSSY_COBBLESTONE_DOOR, new Item.Settings()));
    public static final Item COBBLED_DEEPSLATE_DOOR_ITEM = register("cobbled_deepslate_door", new TallBlockItem(COBBLED_DEEPSLATE_DOOR, new Item.Settings()));
    public static final Item DIAMOND_DOOR_ITEM = register("diamond_door", new TallBlockItem(DIAMOND_DOOR, new Item.Settings()));
    public static final Item GOLD_DOOR_ITEM = register("gold_door", new TallBlockItem(GOLD_DOOR, new Item.Settings()));
    public static final Item SMOOTH_STONE_DOOR_ITEM = register("smooth_stone_door", new TallBlockItem(SMOOTH_STONE_DOOR, new Item.Settings()));
    public static final Item EMERALD_DOOR_ITEM = register("emerald_door", new TallBlockItem(EMERALD_DOOR, new Item.Settings()));

    public static void loadDoorItems() {}
}
