package jackperry2187.epitheca.init;


import net.minecraft.block.BlockSetType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;

public class BlockSetTypeInit {
    public static BlockSetType getDoorSet(String name) {
        return new BlockSetType(
                name,
                false,
                false,
                false,
                BlockSetType.ActivationRule.EVERYTHING,
                BlockSoundGroup.METAL,
                SoundEvents.BLOCK_IRON_DOOR_CLOSE,
                SoundEvents.BLOCK_IRON_DOOR_OPEN,
                SoundEvents.BLOCK_IRON_TRAPDOOR_CLOSE,
                SoundEvents.BLOCK_IRON_TRAPDOOR_OPEN,
                SoundEvents.BLOCK_METAL_PRESSURE_PLATE_CLICK_OFF,
                SoundEvents.BLOCK_METAL_PRESSURE_PLATE_CLICK_ON,
                SoundEvents.BLOCK_STONE_BUTTON_CLICK_OFF,
                SoundEvents.BLOCK_STONE_BUTTON_CLICK_ON
        );
    }
}
