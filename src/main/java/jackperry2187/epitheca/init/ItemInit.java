package jackperry2187.epitheca.init;

import jackperry2187.epitheca.Epitheca;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import static jackperry2187.epitheca.init.item.Doors.loadDoorItems;

public class ItemInit {
    public static <T extends Item> T register(String name, T item) {
        var register = Registry.register(Registries.ITEM, Epitheca.id(name), item);
        // Epitheca.LOGGER.info("Successfully registered item: {}", name);
        return register;
    }

    public static void load() {
        loadDoorItems();
    }
}