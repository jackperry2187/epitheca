package jackperry2187.epitheca.init.client;

import jackperry2187.epitheca.screen.client.RecrafterScreen;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.gui.screen.ingame.ScreenHandlerProvider;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;

import static jackperry2187.epitheca.init.ScreenInit.RECRAFTER_SCREEN_HANDLER;

@Environment(EnvType.CLIENT)
public class ScreenInit {
    static {
        register(RECRAFTER_SCREEN_HANDLER, RecrafterScreen::new);
    }

    private static <M extends ScreenHandler, U extends Screen & ScreenHandlerProvider<M>> void register (
            ScreenHandlerType<? extends M> type, HandledScreens.Provider<M, U> provider
    ) {
        HandledScreens.register(type, provider);
    }

    public static void load() {}
}
