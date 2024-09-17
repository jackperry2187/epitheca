package jackperry2187.epitheca.data.generator;

import jackperry2187.epitheca.Epitheca;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;

import static jackperry2187.epitheca.init.block.Glowstone.GLOWSTONES;
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
        Epitheca.LOGGER.info("Block state models generated successfully!");
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        Epitheca.LOGGER.info("Generating item models...");
        // TODO
        Epitheca.LOGGER.info("Item models generated successfully!");
    }
}
