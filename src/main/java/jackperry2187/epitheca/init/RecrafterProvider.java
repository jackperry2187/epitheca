package jackperry2187.epitheca.init;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static jackperry2187.epitheca.init.block.Bars.BARS;
import static jackperry2187.epitheca.init.block.Doors.DOORS;
import static jackperry2187.epitheca.init.block.Glowstone.GLOWSTONES;
import static jackperry2187.epitheca.init.block.Magma.MAGMAS;
import static jackperry2187.epitheca.init.block.Pumpkins.*;
import static jackperry2187.epitheca.init.block.Recrafter.RECRAFTER;
import static jackperry2187.epitheca.init.block.Shroomlight.SHROOMLIGHTS;

public class RecrafterProvider {
    private static final Map<String, List<Block>> outputMap = new HashMap<>();

    public RecrafterProvider() {
        configure();
    }

    private static void configure() {
        configureShroomlights();
        configureGlowstones();
        configureMagmas();
        configureDoors();
        configureBars();
        configurePumpkins();
        configureRecrafter();
    }

    private static void configureShroomlights() {
        List<String> inputs = new ArrayList<>(SHROOMLIGHTS.stream().map(block -> block.getTranslationKey()).toList());
        inputs.add(Blocks.SHROOMLIGHT.getTranslationKey());

        List<Block> outputs = new ArrayList<>(SHROOMLIGHTS);
        outputs.add(Blocks.SHROOMLIGHT);

        addOutputs(inputs, outputs);
    }

    private static void configureGlowstones() {
        List<String> inputs = new ArrayList<>(GLOWSTONES.stream().map(block -> block.getTranslationKey()).toList());
        inputs.add(Blocks.GLOWSTONE.getTranslationKey());

        List<Block> outputs = new ArrayList<>(GLOWSTONES);
        outputs.add(Blocks.GLOWSTONE);

        addOutputs(inputs, outputs);
    }

    private static void configureMagmas() {
        List<String> inputs = new ArrayList<>(MAGMAS.stream().map(block -> block.getTranslationKey()).toList());
        inputs.add(Blocks.MAGMA_BLOCK.getTranslationKey());

        List<Block> outputs = new ArrayList<>(MAGMAS);
        outputs.add(Blocks.MAGMA_BLOCK);

        addOutputs(inputs, outputs);
    }

    private static void configureDoors() {
        List<String> inputs = new ArrayList<>(DOORS.stream().map(block -> block.getTranslationKey()).toList());
        inputs.add(Blocks.IRON_DOOR.getTranslationKey());

        List<Block> outputs = new ArrayList<>(DOORS);
        outputs.add(Blocks.IRON_DOOR);

        addOutputs(inputs, outputs);
    }

    private static void configureBars() {
        List<String> inputs = new ArrayList<>(BARS.stream().map(block -> block.getTranslationKey()).toList());
        inputs.add(Blocks.IRON_BARS.getTranslationKey());

        List<Block> outputs = new ArrayList<>(BARS);
        outputs.add(Blocks.IRON_BARS);

        addOutputs(inputs, outputs);
    }

    private static void configurePumpkins() {
        List<String> unlitInputs = new ArrayList<>(UNLIT_PUMPKINS.stream().map(block -> block.getTranslationKey()).toList());
        unlitInputs.add(Blocks.CARVED_PUMPKIN.getTranslationKey());

        List<Block> unlitOutputs = new ArrayList<>(UNLIT_PUMPKINS);
        unlitOutputs.add(Blocks.CARVED_PUMPKIN);
        
        addOutputs(unlitInputs, unlitOutputs);

        List<String> litInputs = new ArrayList<>(LIT_PUMPKINS.stream().map(block -> block.getTranslationKey()).toList());
        litInputs.add(Blocks.JACK_O_LANTERN.getTranslationKey());

        List<Block> litOutputs = new ArrayList<>(LIT_PUMPKINS);
        litOutputs.add(Blocks.JACK_O_LANTERN);

        addOutputs(litInputs, litOutputs);
    }

    private static void configureRecrafter() {
        List<String> recraftInput = new ArrayList<>();
        recraftInput.add(RECRAFTER.getTranslationKey());

        List<Block> recraftOutput = new ArrayList<>();
        recraftOutput.add(Blocks.CRAFTING_TABLE);

        addOutputs(recraftInput, recraftOutput);

        List<String> craftInput = new ArrayList<>();
        craftInput.add(Blocks.CRAFTING_TABLE.getTranslationKey());

        List<Block> craftOutput = new ArrayList<>();
        craftOutput.add(RECRAFTER);

        addOutputs(craftInput, craftOutput);
    }

    private static void addOutputs(List<String> inputs, List<Block> outputs) {
        for (String input : inputs) {
            outputMap.put(input, outputs);
        }
    }

    public static Map<String, List<Block>> getOutputMap() {
        return outputMap;
    }
}
