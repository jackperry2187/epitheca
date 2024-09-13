package jackperry2187.epitheca.init;

import jackperry2187.epitheca.Epitheca;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import java.util.List;

public class ItemInit {
    public static final List<Item> DYES = List.of(
            Items.WHITE_DYE,
            Items.LIGHT_GRAY_DYE,
            Items.GRAY_DYE,
            Items.BLACK_DYE,
            Items.BROWN_DYE,
            Items.RED_DYE,
            Items.ORANGE_DYE,
            Items.YELLOW_DYE,
            Items.LIME_DYE,
            Items.GREEN_DYE,
            Items.CYAN_DYE,
            Items.LIGHT_BLUE_DYE,
            Items.BLUE_DYE,
            Items.PURPLE_DYE,
            Items.MAGENTA_DYE,
            Items.PINK_DYE
    );

    public static <T extends Item> T register(String name, T item) {
        var register = Registry.register(Registries.ITEM, Epitheca.id(name), item);
        // Epitheca.LOGGER.info("Successfully registered item: {}", name);
        return register;
    }

    public static void load() {}
}
