package com.ninthplanet.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;

/** HUD: шкала нестабильности, таймер окна портала, состояние обороны базы. */
public class MemoryOverlayHud {
    public static void render(DrawContext context, float tickDelta) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.player == null || client.options.hudHidden) return;

        //TODO: считать состояние с сервера (пакеты) и рисовать:
        //  - «До окна: M:SS»
        //  - «Стражей: N» (>8 — красная пульсация)
        //  - «Уязвимость базы: X/100»
        //  - шкала нестабильности панацеи
    }
}
