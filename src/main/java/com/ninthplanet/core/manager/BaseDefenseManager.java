package com.ninthplanet.core.manager;

import com.ninthplanet.core.config.BaseDefenseConfig;
import com.ninthplanet.base.zone.BaseZone;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.HashMap;
import java.util.Map;

/**
 * Уязвимость базы растёт со временем и от факторов (заражение, слабые места, паника).
 * При достижении THRESHOLD_FOR_WAVE начинается волна химер:
 * фаза предупреждения -> волна 1 -> усиление -> откат.
 */
public class BaseDefenseManager {
    private static final Map<String, BaseZone> zones = new HashMap<>();
    private static boolean initialized = false;

    public static void init() {
        if (initialized) return;
        initialized = true;
        ServerTickEvents.END_SERVER_TICK.register(server -> {
            for (ServerWorld world : server.getWorlds()) {
                for (BaseZone zone : zones.values()) {
                    if (zone.worldKey == null || world.getRegistryKey().getValue().equals(zone.worldKey)) {
                        tickZone(zone, world);
                    }
                }
            }
        });
    }

    private static void tickZone(BaseZone zone, ServerWorld world) {
        long now = world.getTime();
        double growth = BaseDefenseConfig.VULNERABILITY_GROWTH_PER_MINUTE;
        if (now - zone.lastActivityTick > 60 * 20L) {
            zone.addVulnerability(growth);
        }
        //TODO: бонусы за слабые места/заражение/панику (weak_spot_bonus и др.)

        if (zone.getVulnerability() >= BaseDefenseConfig.THRESHOLD_FOR_WAVE && !zone.isWaveActive()) {
            startWave(zone, world);
        }
    }

    private static void startWave(BaseZone zone, ServerWorld world) {
        zone.setWaveActive(true);
        world.getPlayers().forEach(p ->
                p.sendMessage(Text.literal("ТРЕВОГА! Химеры идут на базу!").formatted(Formatting.RED), true));
        //TODO: spawnFirstWave -> если прочность < 30%: spawnSecondWave (таранщики)
        //TODO: если прочность < 10%: альфа-химера идёт к сундукам
        //TODO: по завершении волны — сброс уязвимости, часть химер убегает в зоны заражения
    }

    public static void registerZone(BaseZone zone) {
        zones.put(zone.name, zone);
    }

    public static BaseZone getZone(String name) {
        return zones.get(name);
    }
}
