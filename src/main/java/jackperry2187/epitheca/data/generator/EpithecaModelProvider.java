package jackperry2187.epitheca.data.generator;

import jackperry2187.epitheca.Epitheca;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;

import static jackperry2187.epitheca.init.BarsInit.registerBars;
import static jackperry2187.epitheca.init.block.Bars.BARS;
import static jackperry2187.epitheca.init.block.Doors.DOORS;
import static jackperry2187.epitheca.init.block.Glowstone.GLOWSTONES;
import static jackperry2187.epitheca.init.block.Magma.MAGMAS;
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
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        Epitheca.LOGGER.info("Generating item models...");
        // TODO
        Epitheca.LOGGER.info("Item models generated successfully!");
    }
}
