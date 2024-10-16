package jackperry2187.epitheca.init;

import jackperry2187.epitheca.Epitheca;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

public class TagInit {
    public static final TagKey<Block> SHROOMLIGHT = TagKey.of(RegistryKeys.BLOCK, Epitheca.id("shroomlight"));
    public static final TagKey<Item> SHROOMLIGHT_ITEM = TagKey.of(RegistryKeys.ITEM, Epitheca.id("shroomlight"));
    public static final TagKey<Block> GLOWSTONE = TagKey.of(RegistryKeys.BLOCK, Epitheca.id("glowstone"));
    public static final TagKey<Item> GLOWSTONE_ITEM = TagKey.of(RegistryKeys.ITEM, Epitheca.id("glowstone"));
    public static final TagKey<Block> MAGMA = TagKey.of(RegistryKeys.BLOCK, Epitheca.id("magma"));
    public static final TagKey<Item> MAGMA_ITEM = TagKey.of(RegistryKeys.ITEM, Epitheca.id("magma"));
    public static final TagKey<Block> PUMPKIN = TagKey.of(RegistryKeys.BLOCK, Epitheca.id("pumpkin"));
    public static final TagKey<Item> PUMPKIN_ITEM = TagKey.of(RegistryKeys.ITEM, Epitheca.id("pumpkin"));
}
