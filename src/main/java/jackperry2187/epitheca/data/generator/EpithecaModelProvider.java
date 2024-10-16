package jackperry2187.epitheca.data.generator;

import jackperry2187.epitheca.Epitheca;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.TextureMap;

import static jackperry2187.epitheca.init.BarsInit.registerBars;
import static jackperry2187.epitheca.init.block.Bars.BARS;
import static jackperry2187.epitheca.init.block.Doors.DOORS;
import static jackperry2187.epitheca.init.block.Glowstone.GLOWSTONES;
import static jackperry2187.epitheca.init.block.Magma.MAGMAS;
import static jackperry2187.epitheca.init.block.Pumpkins.PUMPKINS;
import static jackperry2187.epitheca.init.block.Shroomlight.SHROOMLIGHTS;

public class EpithecaModelProvider extends FabricModelProvider {
    public EpithecaModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        Epitheca.LOGGER.info("Generating block state models...");
        SHROOMLIGHTS.forEach(blockStateModelGenerator::registerSimpleCubeAll);
        GLOWSTONES.forEach(blockStateModelGenerator::registerSimpleCubeAll);
        MAGMAS.forEach(blockStateModelGenerator::registerSimpleCubeAll);
        DOORS.forEach(blockStateModelGenerator::registerDoor);
        BARS.forEach(block -> {
            registerBars(block, blockStateModelGenerator);
        });
//        CHAINS.forEach(block -> {
//            blockStateModelGenerator.registerAxisRotated(block, Epitheca.id(block.getTranslationKey()));
//            // This doesn't work (generate something in the assets/epitheca/models/block folder like regular chains do)
//        });
        TextureMap pumpkinMap = TextureMap.sideEnd(Blocks.PUMPKIN);
        PUMPKINS.forEach(block -> {
            blockStateModelGenerator.registerNorthDefaultHorizontalRotatable(block, pumpkinMap);
        });
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        Epitheca.LOGGER.info("Generating item models...");
        // TODO
        Epitheca.LOGGER.info("Item models generated successfully!");
    }
}
