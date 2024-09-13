package jackperry2187.epitheca.init;

import jackperry2187.epitheca.Epitheca;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class BlockInit {
    public static <T extends Block> T register(String name, T block) {
        var register = Registry.register(Registries.BLOCK, Epitheca.id(name), block);
        Epitheca.LOGGER.info("Successfully registered block: {}", name);
        return register;
    }

    public static <T extends Block> T registerWithItem(String name, T block, Item.Settings settings) {
        var returnedRegister = register(name, block);
        ItemInit.register(name, new BlockItem(returnedRegister, settings));
        return returnedRegister;
    }

    public static void load() {}
}
