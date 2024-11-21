package jackperry2187.epitheca.screen.client.recrafter;

import jackperry2187.epitheca.Epitheca;
import net.minecraft.util.Identifier;

public class PossibleOutput {
    public static final Identifier SLOT_TEXTURE = Epitheca.id("textures/gui/output.png");
    public static final Identifier SLOT_HIGHLIGHTED = Epitheca.id("textures/gui/output_highlighted.png");
    public static final Identifier SLOT_SELECTED = Epitheca.id("textures/gui/output_selected.png");

    public static final int X = 45;
    public static final int Y = 12;
    public static final int W = 18;
    public static final int H = 18;
    public static final int ROWS = 4;

    public static Identifier getPossibleOutputSlotTexture(int q, int selectedOutput, boolean isHovering) {
        if(isHovering) {
            return PossibleOutput.SLOT_HIGHLIGHTED;
        } else if (q == selectedOutput) {
            return PossibleOutput.SLOT_SELECTED;
        } else {
            return PossibleOutput.SLOT_TEXTURE;
        }
    }
}
