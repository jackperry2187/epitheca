package jackperry2187.epitheca;

import jackperry2187.epitheca.init.client.ScreenInit;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

import static jackperry2187.epitheca.init.block.Bars.BARS;
import static jackperry2187.epitheca.init.block.Doors.DOORS;

public class EpithecaClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.

		ScreenInit.load();

		// Set the render layer for each door block to cutout
		// Which will allow the "windows" in the top part of the door to be transparent
		DOORS.forEach(block -> {
			BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout());
		});

		BARS.forEach(block -> {
			BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout());
		});
	}
}