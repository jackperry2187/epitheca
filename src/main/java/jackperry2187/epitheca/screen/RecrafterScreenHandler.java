package jackperry2187.epitheca.screen;

import jackperry2187.epitheca.init.RecrafterProvider;
import jackperry2187.epitheca.init.ScreenInit;
import jackperry2187.epitheca.screen.recrafter.InputSlot;
import jackperry2187.epitheca.screen.recrafter.InventorySlots;
import jackperry2187.epitheca.screen.recrafter.OutputSlot;
import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.*;
import net.minecraft.screen.slot.Slot;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static jackperry2187.epitheca.init.TagInit.RECRAFTER_INPUT;
import static jackperry2187.epitheca.init.block.Recrafter.RECRAFTER;

public class RecrafterScreenHandler extends ScreenHandler {
    private final ScreenHandlerContext context;
    private final Property selectedOutput = Property.create();
    private Runnable inventoryChangeListener = () -> {};
    private final Slot inputSlot;
    private final Slot outputSlot;
    private final Inventory input = new SimpleInventory(1) {
        @Override
        public void markDirty() {
            super.markDirty();
            RecrafterScreenHandler.this.onContentChanged(this);
            RecrafterScreenHandler.this.inventoryChangeListener.run();
        }
    };
    private final Inventory output = new SimpleInventory(1) {
        @Override
        public void markDirty() {
            super.markDirty();
            RecrafterScreenHandler.this.inventoryChangeListener.run();
        }
    };
    private List<Block> possibleOutputs;
    private final RecrafterProvider recrafterProvider;

    public RecrafterScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, ScreenHandlerContext.EMPTY);
    }

    public RecrafterScreenHandler(int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
        super(ScreenInit.RECRAFTER_SCREEN_HANDLER, syncId);
        this.context = context;
        this.inputSlot = this.addSlot(new Slot(this.input, 0, InputSlot.X, InputSlot.Y) {
            @Override
            public boolean canInsert(ItemStack stack) {
                return stack.isIn(RECRAFTER_INPUT);
            }
        });
        this.outputSlot = this.addSlot(new Slot(this.output, 0, OutputSlot.X, OutputSlot.Y) {
           @Override
           public boolean canInsert(ItemStack stack) {
               return false;
           }

            @Override
            public void onTakeItem(PlayerEntity player, ItemStack stack) {
               RecrafterScreenHandler.this.inputSlot.takeStack(stack.getCount());
               RecrafterScreenHandler.this.selectedOutput.set(-1);

               super.onTakeItem(player, stack);
            }

            @Override
            public void onQuickTransfer(ItemStack stack, ItemStack originalStack) {
               RecrafterScreenHandler.this.inputSlot.takeStack(originalStack.getCount() - stack.getCount());
               RecrafterScreenHandler.this.selectedOutput.set(-1);

               super.onQuickTransfer(stack, originalStack);
            }
        });

        this.addInventorySlots(playerInventory);

        this.addProperty(this.selectedOutput);
        this.possibleOutputs = List.of();
        this.recrafterProvider = new RecrafterProvider();
    }

    @Override
    public final boolean canUse(PlayerEntity player) { return canUse(this.context, player, RECRAFTER); }

    @Override
    public final boolean onButtonClick(PlayerEntity player, int id) {
        if(id >= 0 && id < this.possibleOutputs.size()) {
            this.selectedOutput.set(id);
            this.outputSlot.setStackNoCallbacks(this.possibleOutputs.get(id).asItem().getDefaultStack().copyWithCount(this.inputSlot.getStack().getCount()));
            return true;
        } else {
            return false;
        }
    }

    private List<Block> getPossibleOutputs(ItemStack input) {
        @Nullable List<Block> outputs = recrafterProvider.getOutputMap().get(input.getTranslationKey());
        return outputs != null ? outputs : List.of();
    }

    private boolean isPossibleOutputIndexValid(int index) {
        return index >= 0 && index < this.possibleOutputs.size();
    }

    @Override
    public final void onContentChanged(Inventory inventory) {
        ItemStack itemStack = this.inputSlot.getStack();

        if (!itemStack.isEmpty()) {
            int outputIndex = this.selectedOutput.get();
            boolean isValid = this.isPossibleOutputIndexValid(outputIndex);

            this.possibleOutputs = this.getPossibleOutputs(itemStack);
            int found = this.possibleOutputs.stream().map(Block::getTranslationKey).toList().indexOf(itemStack.getTranslationKey());

            Block selectedBlock;
            if(this.possibleOutputs.size() == 1) {
                this.selectedOutput.set(0);
                selectedBlock = this.possibleOutputs.get(0);
            } else if (found != -1) {
                this.selectedOutput.set(found);
                selectedBlock = this.possibleOutputs.get(found);
            } else if (!isValid) {
                this.selectedOutput.set(-1);
                selectedBlock = null;
            } else {
                selectedBlock = this.possibleOutputs.get(outputIndex);
            }

            if(selectedBlock != null) {
                this.outputSlot.setStackNoCallbacks(selectedBlock.asItem().getDefaultStack().copyWithCount(itemStack.getCount()));
            } else {
                this.outputSlot.setStackNoCallbacks(ItemStack.EMPTY);
            }

            this.sendContentUpdates();
        } else {
            this.outputSlot.setStackNoCallbacks(ItemStack.EMPTY);
            this.possibleOutputs = List.of();
            this.selectedOutput.set(-1);
        }
    }

    public final void setInventoryChangeListener(Runnable inventoryChangeListener) {
        this.inventoryChangeListener = inventoryChangeListener;
    }

    @Override
    public final ItemStack quickMove(PlayerEntity player, int slot) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot clickedFrom = this.slots.get(slot);

        if(clickedFrom.hasStack()) {
            // slot could be found and has a stack in it
            ItemStack clickedStack = clickedFrom.getStack();
            itemStack = clickedStack.copy();

            if (slot == this.outputSlot.id || slot == this.inputSlot.id) {
                // user quick moved from the input or output slot, trying to move to inventory/hotbar
                if (!this.insertItem(clickedStack, 2, 38, true)) {
                    return ItemStack.EMPTY;
                }

                clickedFrom.onQuickTransfer(clickedStack, itemStack);
            } else {
                // user quick moved their inventory, trying to move to input
                if (!this.insertItem(clickedStack, this.inputSlot.id, this.inputSlot.id + 1, false)) {
                    return ItemStack.EMPTY;
                }

                clickedFrom.onQuickTransfer(clickedStack, itemStack);
            }

            // items have now been moved from original slot to new slot
            if (clickedStack.isEmpty()) {
                // original slot is now empty
                clickedFrom.setStack(ItemStack.EMPTY);
            } else {
                // original slot still has items, but a different number of items
                clickedFrom.markDirty();
            }

            if (clickedStack.getCount() == itemStack.getCount()) {
                // no items were moved
                return ItemStack.EMPTY;
            }

            clickedFrom.onTakeItem(player, clickedStack);
        }

        return itemStack;
    }

    @Override
    public final void onClosed(PlayerEntity player) {
        super.onClosed(player);
        this.context.run((world, blockPos) -> {
            this.dropInventory(player, this.input);
        });
    }

    public final List<Block> getPossibleOutputs() { return this.possibleOutputs; }

    public final Slot getInputSlot() { return this.inputSlot; }

    public final int getSelectedOutput() { return this.selectedOutput.get(); }

    private void addInventorySlots(PlayerInventory playerInventory) {
        for (int i = 0; i < 3; i++) { // rows
            for (int j = 0; j < 9; j++) { // columns
                this.addSlot(new Slot(playerInventory, j + i * 9 + 9, InventorySlots.INV_X + j * (InventorySlots.SLOT_W + 2), InventorySlots.INV_Y + i * (InventorySlots.SLOT_H + 2)));
            }
        }

        for (int i = 0; i < 9; i++) {
            this.addSlot(new Slot(playerInventory, i, InventorySlots.HOTBAR_X + i * (InventorySlots.SLOT_W + 2), InventorySlots.HOTBAR_Y));
        }
    }
}
