package com.ninthplanet.sky;

import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.util.math.RotationAxis;

/**
 * Отрисовка двух лун и двух солнц в измерении Девятой планеты.
 * Движение по небу синхронизировано с временем мира.
 */
public class CelestialBodyRenderer {
    public static void renderCelestials(MatrixStack matrices, VertexConsumerProvider consumers) {
        long time = net.minecraft.client.MinecraftClient.getInstance().world.getTimeOfDay();
        float angle = (float) (time / 24000.0 * 2 * Math.PI);

        for (int i = 0; i < SkyConfig.MOONS_COUNT; i++) {
            renderBody(matrices, consumers, SkyConfig.MOON_ANGLES[i] + (float) Math.toDegrees(angle),
                    SkyConfig.MOON_ELEVATIONS[i], SkyConfig.MOON_SCALES[i], "moon_" + (i + 1));
        }
        for (int i = 0; i < SkyConfig.SUNS_COUNT; i++) {
            renderBody(matrices, consumers, SkyConfig.SUN_ANGLES[i] + (float) Math.toDegrees(angle),
                    SkyConfig.SUN_ELEVATIONS[i], SkyConfig.SUN_SCALES[i], "sun_" + (i + 1));
        }
    }

    private static void renderBody(MatrixStack matrices, VertexConsumerProvider consumers,
                                   float angleDeg, float elevation, float scale, String texture) {
        //TODO: рендер quads с текстурой assets/ninthplanet/textures/sky/<texture>.png
        // поворот вокруг оси X по elevation, смещение по углу angleDeg
    }
}
