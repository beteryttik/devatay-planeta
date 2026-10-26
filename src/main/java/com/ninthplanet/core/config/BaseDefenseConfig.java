package com.ninthplanet.core.config;

/** Настройки уязвимости базы и волн химер. */
public class BaseDefenseConfig {
    public static double VULNERABILITY_GROWTH_PER_MINUTE = 5;
    public static double THRESHOLD_FOR_WAVE = 100;
    public static double WAVE_DURATION_SECONDS = 180;
    public static double WEAK_SPOT_BONUS = 20;
    public static double TAINT_VULNERABILITY_MULTIPLIER = 1.5;
    public static double PANIC_VULNERABILITY_BONUS = 40;
    public static int FIRST_WAVE_COUNT = 4;
    public static int SECOND_WAVE_COUNT = 8;
    public static int WALL_HP = 400;
    public static int DOOR_HP = 250;
    public static int BUNKER_HP = 500;

    public static ModConfig.Section defaults() {
        ModConfig.Section s = new ModConfig.Section();
        s.vulnerabilityGrowthPerMinute = VULNERABILITY_GROWTH_PER_MINUTE;
        s.thresholdForWave = THRESHOLD_FOR_WAVE;
        return s;
    }
}
