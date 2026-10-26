package com.ninthplanet.base.zone;

import java.util.UUID;

/** Зона базы: центр, уровень уязвимости, состояние волны. */
public class BaseZone {
    public final String name;
    public final UUID worldKey;
    public final net.minecraft.util.math.BlockPos center;
    public final int radius;

    private double vulnerability = 0;
    private boolean waveActive = false;
    public long lastActivityTick = 0;

    public BaseZone(String name, UUID worldKey, net.minecraft.util.math.BlockPos center, int radius) {
        this.name = name;
        this.worldKey = worldKey;
        this.center = center;
        this.radius = radius;
    }

    public void addVulnerability(double amount) {
        vulnerability = Math.min(100, vulnerability + amount);
    }

    public double getVulnerability() {
        return vulnerability;
    }

    public boolean isWaveActive() {
        return waveActive;
    }

    public void setWaveActive(boolean waveActive) {
        this.waveActive = waveActive;
    }
}
