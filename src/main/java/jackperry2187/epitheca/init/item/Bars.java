package jackperry2187.epitheca.init.item;

import net.minecraft.item.Item;

import static jackperry2187.epitheca.init.ItemInit.register;

public class Bars {
    public static final Item COBBLESTONE_BARS_ITEM = register("cobblestone_bars", new Item(new Item.Settings()));
    public static final Item MOSSY_COBBLESTONE_BARS_ITEM = register("mossy_cobblestone_bars", new Item(new Item.Settings()));
    public static final Item COBBLED_DEEPSLATE_BARS_ITEM = register("cobbled_deepslate_bars", new Item(new Item.Settings()));
    public static final Item DIAMOND_BARS_ITEM = register("diamond_bars", new Item(new Item.Settings()));
    public static final Item GOLD_BARS_ITEM = register("gold_bars", new Item(new Item.Settings()));
    public static final Item SMOOTH_STONE_BARS_ITEM = register("smooth_stone_bars", new Item(new Item.Settings()));
    public static final Item EMERALD_BARS_ITEM = register("emerald_bars", new Item(new Item.Settings()));

    public static void loadBarItems() {}
}
