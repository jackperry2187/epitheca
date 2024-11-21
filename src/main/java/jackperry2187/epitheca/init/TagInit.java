package jackperry2187.epitheca.init;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import static jackperry2187.epitheca.Epitheca.MOD_ID;

public class TagInit {
    public static final TagKey<Item> RECRAFTER_INPUT = TagKey.of(RegistryKeys.ITEM, itemId("recrafter_input"));

    public static final TagKey<Block> SHROOMLIGHT = TagKey.of(RegistryKeys.BLOCK, blockId("shroomlight"));
    public static final TagKey<Item> SHROOMLIGHT_ITEM = TagKey.of(RegistryKeys.ITEM, itemId("shroomlight"));
    public static final TagKey<Block> GLOWSTONE = TagKey.of(RegistryKeys.BLOCK, blockId("glowstone"));
    public static final TagKey<Item> GLOWSTONE_ITEM = TagKey.of(RegistryKeys.ITEM, itemId("glowstone"));
    public static final TagKey<Block> MAGMA = TagKey.of(RegistryKeys.BLOCK, blockId("magma"));
    public static final TagKey<Item> MAGMA_ITEM = TagKey.of(RegistryKeys.ITEM, itemId("magma"));
    public static final TagKey<Block> PUMPKIN = TagKey.of(RegistryKeys.BLOCK, blockId("pumpkin"));
    public static final TagKey<Item> PUMPKIN_ITEM = TagKey.of(RegistryKeys.ITEM, itemId("pumpkin"));

    public static Identifier itemId(String name) {
        return Identifier.of("tag.item." + MOD_ID + "." + name);
    }

    public static Identifier blockId(String name) {
        return Identifier.of("tag.block." + MOD_ID + "." + name);
    }
}
