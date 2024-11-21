package jackperry2187.epitheca.screen.client.recrafter;

import jackperry2187.epitheca.Epitheca;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class InputSlot {
    public static final Identifier INPUT_TEXTURE = Epitheca.id("textures/gui/input_slot.png");
    public static final int X = 15;
    public static final int Y = 36;
    public static final int W = 20;
    public static final int H = 20;
}
