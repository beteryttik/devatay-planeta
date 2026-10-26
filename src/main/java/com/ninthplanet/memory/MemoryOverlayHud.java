package com.ninthplanet.memory;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.DrawContext;

@Environment(EnvType.CLIENT)
public class MemoryOverlayHud {

    public static void render(DrawContext context, float tickDelta) {
        // Заглушка: оверлей памяти появится здесь позже.
    }
}
