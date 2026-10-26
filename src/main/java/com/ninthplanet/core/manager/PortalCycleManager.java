package com.ninthplanet.core.manager;

import com.ninthplanet.NinthPlanetMod;
import com.ninthplanet.core.config.PortalCycleConfig;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;

/**
 * Цикл портала: каждые CYCLE_MINUTES открывается окно на WINDOW_SECONDS
 * у обелиска. За WARNING_SECONDS обелиск начинает светиться и гудеть.
 * На фазе окна вокруг спавнятся химеры-стражи.
 */
public class PortalCycleManager {
    private static final int SECONDS_TO_TICKS = 20;
    private static long cycleStart = -1;
    private static long windowStart = -1;
    private static BlockPos obeliskPos = null;
    private static Phase phase = Phase.IDLE;

    public enum Phase { IDLE, WARNING, WINDOW }

    public static void init() {
        ServerTickEvents.END_SERVER_TICK.register(server -> {
            ServerWorld world = server.getOverworld();
            //TODO: определять мир измерения Девятой планеты и тикать только в нём
            tick(world);
        });
    }

    public static void tick(ServerWorld world) {
        if (cycleStart < 0) cycleStart = world.getTime();

        long now = world.getTime();
        long cycleTicks = (long) (PortalCycleConfig.CYCLE_MINUTES * 60 * SECONDS_TO_TICKS);
        long warnTicks = (long) (PortalCycleConfig.WARNING_SECONDS * SECONDS_TO_TICKS);
        long windowTicks = (long) (PortalCycleConfig.WINDOW_SECONDS * SECONDS_TO_TICKS);

        if (phase == Phase.IDLE && now - cycleStart >= cycleTicks) {
            phase = Phase.WARNING;
            windowStart = now;
            broadcast(world, "Обелиск просыпается. Портал скоро откроется...", Formatting.GOLD);
            //TODO: включить визуал обелиска (свет + звук гула)
        }

        if (phase == Phase.WARNING && now - windowStart >= warnTicks) {
            phase = Phase.WINDOW;
            windowStart = now;
            broadcast(world, "ОТКРЫТО ОКНО СТАБИЛЬНОСТИ! Химеры стягиваются к порталу!", Formatting.RED);
            spawnGuards(world);
        }

        if (phase == Phase.WINDOW && now - windowStart >= windowTicks) {
            phase = Phase.IDLE;
            cycleStart = now;
            broadcast(world, "Окно закрылось. Портал спал.", Formatting.GRAY);
            //TODO: despawn стражей, закрыть портал
        }
    }

    public static boolean isWindowActive() {
        return phase == Phase.WINDOW;
    }

    public static Phase getPhase() {
        return phase;
    }

    private static void spawnGuards(ServerWorld world) {
        // Спавн до MAX_GUARDS химер-стражей вокруг обелиска,
        // только в чанках с taint_level >= TAINT_MIN_LEVEL_FOR_GUARDS.
        // Реализация: см. ChimaeraGuardAI и TaintManager.getTaintLevel(world, pos)
        //TODO: реализовать спавн через ModEntities.CHIMAERA
    }

    private static void broadcast(ServerWorld world, String message, net.minecraft.util.Formatting color) {
        world.getPlayers().forEach(p ->
                p.sendMessage(Text.literal("[ПЛАНЕТА] " + message).formatted(color), false));
        NinthPlanetMod.LOGGER.info("[PortalCycle] {}", message);
    }

    public static BlockPos getObeliskPos() {
        return obeliskPos;
    }

    public static void setObeliskPos(BlockPos pos) {
        obeliskPos = pos;
    }
}
