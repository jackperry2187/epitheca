package jackperry2187.epitheca.screen.client;

import jackperry2187.epitheca.screen.RecrafterScreenHandler;
import jackperry2187.epitheca.screen.client.recrafter.*;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.ScreenHandlerProvider;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

import java.util.List;

import static jackperry2187.epitheca.init.TagInit.RECRAFTER_INPUT;

@Environment(EnvType.CLIENT)
public class RecrafterScreen extends HandledScreen<RecrafterScreenHandler> implements ScreenHandlerProvider<RecrafterScreenHandler> {
    private final Identifier BACKGROUND_TEXTURE = Background.BACKGROUND_TEXTURE;
    private final int backgroundHeight = Background.H;
    private final int backgroundWidth = Background.W;

    private float scrollPosition;
    private int visibleTopRow;
    private boolean scrollbarClicked;
    private boolean hasValidInputItem;

    public RecrafterScreen(RecrafterScreenHandler screenHandler, PlayerInventory inventory, Text title) {
        super(screenHandler, inventory, title);
        screenHandler.setInventoryChangeListener(this::onInventoryChanged);
    }

    @Override
    protected void init() {
        super.init();

        playerInventoryTitleY = Background.InventoryTitleY;

        // centers the title ("Recrafter") in the middle of the screen
        this.titleX = (this.backgroundWidth - this.textRenderer.getWidth(this.title)) / 2;
        this.titleY -= 2;
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);

        // renders the tooltip with an item name when hovering over an item in the inventory
        this.drawMouseoverTooltip(context, mouseX, mouseY);
    }

    @Override
    public void drawMouseoverTooltip(DrawContext context, int mouseX, int mouseY) {
        // if the cursor is hovering over somewhere where we have rendered a possible output, render the tooltip
        if (this.hasValidInputItem) {
            int i = this.x + PossibleOutput.X;
            int j = this.y + PossibleOutput.Y;
            List<Block> possibleOutputs = handler.getPossibleOutputs();

            for (int k = 0; k < 4; k++) {
                for (int l = 0; l < 4; l++) {
                    int m = l + this.visibleTopRow;
                    int n = m * PossibleOutput.ROWS + k;
                    if (n >= possibleOutputs.size()) {
                        break;
                    }

                    int o = i + k * PossibleOutput.W;
                    int p = j + l * PossibleOutput.H;
                    if (mouseX >= o && mouseY >= p && mouseX < o + PossibleOutput.W && mouseY < p + PossibleOutput.H) {
                        ItemStack hoveredOutput = possibleOutputs.get(n).asItem().getDefaultStack();
                        context.drawTooltip(this.textRenderer, this.getTooltipFromItem(hoveredOutput), hoveredOutput.getTooltipData(), mouseX, mouseY);
                    }
                }
            }
        }

        // if the cursor is hovering over the input when it is empty, render a tooltip saying "Input"
        if (!this.hasValidInputItem) {
            int i = this.x + InputSlot.X;
            int j = this.y + InputSlot.Y;
            if (mouseX >= i && mouseY >= j && mouseX < i + InputSlot.W && mouseY < j + InputSlot.H) {
                context.drawTooltip(this.textRenderer, Text.literal("Input"), mouseX, mouseY);
            }
        }

        // if the cursor is hovering over the output when it is empty, render a tooltip saying "Output"
        if (!this.hasValidInputItem && this.handler.getSelectedOutput() <= 0) {
            int i = this.x + OutputSlot.X;
            int j = this.y + OutputSlot.Y;
            if (mouseX >= i && mouseY >= j && mouseX < i + OutputSlot.W && mouseY < j + OutputSlot.H) {
                context.drawTooltip(this.textRenderer, Text.literal("Output"), mouseX, mouseY);
            }
        }

        // if the cursor is hovering over the scrollbar, render a tooltip saying "Showing X-Y of Z"
        // where X is the first possible output index shown, Y is the last possible output index shown, and Z is the total number of possible outputs
        if (this.hasValidInputItem) {
            int i = this.x + Scrollbar.X;
            int j = this.y + Scrollbar.Y;
            if (mouseX >= i && mouseY >= j && mouseX < i + Scrollbar.W && mouseY < j + Scrollbar.INNER_H) {
                int k = this.getRows() - 4;
                int l = MathHelper.clamp((int)(this.scrollPosition * (float)k + 0.5F), 0, k);
                int m = MathHelper.clamp(l + 4, 0, this.getRows());
                context.drawTooltip(this.textRenderer, Text.of("Showing " + (l * 4 + 1) + "-" + (m * 4) + " of " + this.handler.getPossibleOutputs().size()), mouseX, mouseY);
            }
        }

        super.drawMouseoverTooltip(context, mouseX, mouseY);
    }

    private int getRows() { return MathHelper.ceilDiv(this.handler.getPossibleOutputs().size(), 4); }

    @Override
    public void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        int i = this.x;
        int j = this.y;

        context.drawTexture(BACKGROUND_TEXTURE, i, j, 0, 0, this.backgroundWidth, this.backgroundHeight);

        if(!this.hasValidInputItem) {
            drawForeground(InputSlot.INPUT_TEXTURE, context, i + InputSlot.X, j + InputSlot.Y, InputSlot.W, InputSlot.H);
        }

        if(!this.hasValidInputItem && this.handler.getSelectedOutput() <= 0) {
            drawForeground(OutputSlot.OUTPUT_TEXTURE, context, i + OutputSlot.X, j + OutputSlot.Y, OutputSlot.W, OutputSlot.H);
        }

        int k = (int) ((float) (Scrollbar.INNER_H - Scrollbar.H) * this.scrollPosition);
        Identifier scrollbar = (hasValidInputItem && this.getRows() > PossibleOutput.ROWS) ? Scrollbar.SCROLLBAR_TEXTURE : Scrollbar.SCROLLBAR_DISABLED_TEXTURE;
        drawForeground(scrollbar, context, i + Scrollbar.X, j + Scrollbar.Y + k, Scrollbar.W, Scrollbar.H);

        if(this.hasValidInputItem) {
            int l = i + PossibleOutput.X;
            int m = j + PossibleOutput.Y;
            List<Block> possibleOutputs = handler.getPossibleOutputs();

            label64:
            for (int n = 0; n < 4; n++) {
                for (int o = 0; o < 4; o++) {
                    int p = n + this.visibleTopRow;
                    int q = p * PossibleOutput.ROWS + o;
                    if (q >= possibleOutputs.size()) {
                        break label64;
                    }

                    int r = l + o * PossibleOutput.W;
                    int s = m + n * PossibleOutput.H;
                    boolean isHovering = mouseX >= r && mouseY >= s && mouseX < r + PossibleOutput.W && mouseY < s + PossibleOutput.H;
                    Identifier possibleOutputSlot = PossibleOutput.getPossibleOutputSlotTexture(q, this.handler.getSelectedOutput(), isHovering);

                    this.drawForeground(possibleOutputSlot, context, r, s, PossibleOutput.W, PossibleOutput.H);
                    this.drawPossibleOutput(context, possibleOutputs.get(q), r + 1, s + 1);
                }
            }
        }
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        this.scrollbarClicked = false;
        if (this.hasValidInputItem) {
            int i = this.x + PossibleOutput.X;
            int j = this.y + PossibleOutput.Y;

            for (int k = 0; k < 4; k++) {
                for (int l = 0; l < 4; l++) {
                    double d = mouseX - (double) (i + l * PossibleOutput.W);
                    double e = mouseY - (double) (j + k * PossibleOutput.H);
                    int m = k + this.visibleTopRow;
                    int n = m * 4 + l;
                    if (d >= 0.0 && e >= 0.0 && d < (double) PossibleOutput.W && e < (double) PossibleOutput.H && this.handler.onButtonClick(this.client.player, n)) {
                        MinecraftClient.getInstance().getSoundManager().play(PositionedSoundInstance.master(SoundEvents.UI_BUTTON_CLICK, 1.0F));
                        this.client.interactionManager.clickButton(this.handler.syncId, n);
                        return true;
                    }
                }
            }

            i = this.x + Scrollbar.X;
            j = this.y + Scrollbar.Y;
            if (mouseX >= (double) i && mouseX < (double) (i + Scrollbar.W) && mouseY >= (double) j && mouseY < (double) (j + Scrollbar.INNER_H)) {
                this.scrollbarClicked = true;
            }
        }

        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double deltaX, double deltaY) {
        int i = this.getRows() - 4;
        if (this.scrollbarClicked && this.hasValidInputItem && i > 0) {
            int j = this.y + Scrollbar.W;
            int k = j + Scrollbar.INNER_H;
            this.scrollPosition = ((float)mouseY - (float)j - 7.5F) / ((float)(k - j) - 15.0F);
            this.scrollPosition = MathHelper.clamp(this.scrollPosition, 0.0F, 1.0F);
            this.visibleTopRow = Math.max((int)((double)(this.scrollPosition * (float)i) + 0.5), 0);
            return true;
        } else {
            return super.mouseDragged(mouseX, mouseY, button, deltaX, deltaY);
        }
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double horizontalAmount, double verticalAmount) {
        int i = this.getRows() - 4;
        if (this.hasValidInputItem && i > 0) {
            float f = (float)verticalAmount / (float)i;
            this.scrollPosition = MathHelper.clamp(this.scrollPosition - f, 0.0F, 1.0F);
            this.visibleTopRow = Math.max((int)(this.scrollPosition * (float)i + 0.5F), 0);
        }

        return true;
    }

    @Override
    protected boolean isClickOutsideBounds(double mouseX, double mouseY, int left, int top, int button) {
        return mouseX < (double)left || mouseY < (double)top || mouseX >= (double)(left + this.backgroundWidth) || mouseY >= (double)(top + this.backgroundHeight);
    }

    private void onInventoryChanged() {
        ItemStack input = this.handler.getInputSlot().getStack();
        this.hasValidInputItem = !input.isEmpty() && input.streamTags().toList().contains(RECRAFTER_INPUT);

        if (this.visibleTopRow >= this.getRows()) {
            this.visibleTopRow = 0;
            this.scrollPosition = 0.0F;
        }
    }

    private void drawForeground(Identifier texture, DrawContext context, int x, int y, int w, int h) {
        context.drawTexture(texture, x, y, 1, 0, 0, w, h, w, h);
    }

    private void drawPossibleOutput(DrawContext context, Block block, int x, int y) {
        context.drawItem(block.asItem().getDefaultStack(), x, y, 0, 2);
    }
}
