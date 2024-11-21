package jackperry2187.epitheca.init;

import jackperry2187.epitheca.Epitheca;
import jackperry2187.epitheca.screen.RecrafterScreenHandler;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;

public class ScreenInit {
    public static final ScreenHandlerType<RecrafterScreenHandler> RECRAFTER_SCREEN_HANDLER = register("recrafter", RecrafterScreenHandler::new);

    private static <T extends ScreenHandler> ScreenHandlerType<T> register(String id, ScreenHandlerType.Factory<T> factory) {
        Epitheca.LOGGER.info("Successfully registered screen: {}", id);
        return Registry.register(Registries.SCREEN_HANDLER, id, new ScreenHandlerType<>(factory, FeatureFlags.VANILLA_FEATURES));
    }

    public static void load() {}
}
