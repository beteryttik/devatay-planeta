package com.ninthplanet.core.config;

/** Настройки цикла портала: вариант 2 «Окно стабильности» + стражи-химеры. */
public class PortalCycleConfig {
    public static double CYCLE_MINUTES = 15;      // раз в сколько минут открывается окно
    public static double WINDOW_SECONDS = 180;    // сколько живёт окно
    public static double WARNING_SECONDS = 120;   // за сколько до окна гудит обелиск
    public static int MAX_GUARDS = 12;            // максимум химер-стражей
    public static double GUARD_SPAWN_RADIUS = 40;
    public static int TAINT_MIN_LEVEL_FOR_GUARDS = 2;
    public static double PANIC_AGGRESSION_MULTIPLIER = 1.5;
    public static boolean COSTS_PANACEA = true;   // телепорт тратит 1 панацею

    public static ModConfig.Section defaults() {
        ModConfig.Section s = new ModConfig.Section();
        s.cycleMinutes = CYCLE_MINUTES;
        s.windowSeconds = WINDOW_SECONDS;
        return s;
    }
}
