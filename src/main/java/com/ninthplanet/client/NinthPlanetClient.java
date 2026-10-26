package com.ninthplanet.client;

import com.ninthplanet.memory.MemoryOverlayHud;
import com.ninthplanet.sky.CelestialBodyRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderEvents;

public class NinthPlanetClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // Две луны и два солнца на небе измерения Девятой планеты
        WorldRenderEvents.AFTER_TRANSLUCENT.register(ctx ->
                CelestialBodyRenderer.renderCelestials(ctx.matrixStack(), ctx.consumers()));

        // HUD: нестабильность, воспоминания, оборона базы
        HudRenderCallback.EVENT.register((drawContext, tickDelta) ->
                MemoryOverlayHud.render(drawContext, tickDelta));
    }
}
