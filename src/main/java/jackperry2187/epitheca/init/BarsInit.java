package jackperry2187.epitheca.init;

import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.item.Item;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;

public class BarsInit {
    public static void registerBars(Block block, BlockStateModelGenerator blockStateModelGenerator) {
        TextureMap textureMap = TextureMap.paneAndTopForEdge(block, block);
        Identifier identifier = Models.TEMPLATE_GLASS_PANE_POST.upload(block, textureMap, blockStateModelGenerator.modelCollector);
        Identifier identifier2 = Models.TEMPLATE_GLASS_PANE_SIDE.upload(block, textureMap, blockStateModelGenerator.modelCollector);
        Identifier identifier3 = Models.TEMPLATE_GLASS_PANE_SIDE_ALT.upload(block, textureMap, blockStateModelGenerator.modelCollector);
        Identifier identifier4 = Models.TEMPLATE_GLASS_PANE_NOSIDE.upload(block, textureMap, blockStateModelGenerator.modelCollector);
        Identifier identifier5 = Models.TEMPLATE_GLASS_PANE_NOSIDE_ALT.upload(block, textureMap, blockStateModelGenerator.modelCollector);
        Item item = block.asItem();
        Models.GENERATED.upload(ModelIds.getItemModelId(item), TextureMap.layer0(block), blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector
                .accept(
                        MultipartBlockStateSupplier.create(block)
                                .with(BlockStateVariant.create().put(VariantSettings.MODEL, identifier))
                                .with(When.create().set(Properties.NORTH, true), BlockStateVariant.create().put(VariantSettings.MODEL, identifier2))
                                .with(
                                        When.create().set(Properties.EAST, true),
                                        BlockStateVariant.create().put(VariantSettings.MODEL, identifier2).put(VariantSettings.Y, VariantSettings.Rotation.R90)
                                )
                                .with(When.create().set(Properties.SOUTH, true), BlockStateVariant.create().put(VariantSettings.MODEL, identifier3))
                                .with(
                                        When.create().set(Properties.WEST, true),
                                        BlockStateVariant.create().put(VariantSettings.MODEL, identifier3).put(VariantSettings.Y, VariantSettings.Rotation.R90)
                                )
                                .with(When.create().set(Properties.NORTH, false), BlockStateVariant.create().put(VariantSettings.MODEL, identifier4))
                                .with(When.create().set(Properties.EAST, false), BlockStateVariant.create().put(VariantSettings.MODEL, identifier5))
                                .with(
                                        When.create().set(Properties.SOUTH, false),
                                        BlockStateVariant.create().put(VariantSettings.MODEL, identifier5).put(VariantSettings.Y, VariantSettings.Rotation.R90)
                                )
                                .with(
                                        When.create().set(Properties.WEST, false),
                                        BlockStateVariant.create().put(VariantSettings.MODEL, identifier4).put(VariantSettings.Y, VariantSettings.Rotation.R270)
                                )
                );
    }
}
