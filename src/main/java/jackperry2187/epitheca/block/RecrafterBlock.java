package jackperry2187.epitheca.block;

import jackperry2187.epitheca.screen.RecrafterScreenHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class RecrafterBlock extends Block {
    public RecrafterBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if(world.isClient) {
            return ActionResult.SUCCESS;
        } else {
            player.openHandledScreen(state.createScreenHandlerFactory(world, pos));
            return ActionResult.CONSUME;
        }
    }

    @Override
    protected @Nullable NamedScreenHandlerFactory createScreenHandlerFactory(BlockState state, World world, BlockPos pos) {
        return new SimpleNamedScreenHandlerFactory(
                (syncId, inventory, player) -> new RecrafterScreenHandler(syncId, inventory, ScreenHandlerContext.create(world, pos)), Text.literal("Recrafter")
        );
    }
}
