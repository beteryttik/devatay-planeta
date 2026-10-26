package com.ninthplanet.sky;

/** Параметры небесных тел: 2 луны и 2 солнца. */
public class SkyConfig {
    public static final int MOONS_COUNT = 2;
    public static final int SUNS_COUNT = 2;

    public static final float[] MOON_ANGLES = {45.0f, 210.0f};
    public static final float[] MOON_ELEVATIONS = {60.0f, 30.0f};
    public static final float[] MOON_SCALES = {0.8f, 0.6f};

    public static final float[] SUN_ANGLES = {135.0f, 315.0f};
    public static final float[] SUN_ELEVATIONS = {75.0f, 45.0f};
    public static final float[] SUN_SCALES = {1.0f, 0.9f};

    public static com.ninthplanet.core.config.ModConfig.Section defaults() {
        return new com.ninthplanet.core.config.ModConfig.Section();
    }
}
