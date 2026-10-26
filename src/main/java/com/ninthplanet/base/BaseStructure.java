package com.ninthplanet.base;

import net.minecraft.util.math.BlockPos;

import java.util.HashMap;
import java.util.Map;

/** Структура базы: бронированные стены, двери и запасной бункер. */
public class BaseStructure {
    public final BlockPos center;
    public final BlockPos bunkerEntrance;

    /** pos -> {hp, maxHp} — прочность стен. */
    public final Map<BlockPos, int[]> walls = new HashMap<>();
    /** pos -> {hp, maxHp} — прочность бронированных дверей. */
    public final Map<BlockPos, int[]> doors = new HashMap<>();

    public final int bunkerMaxHp;
    public int bunkerHp;

    public BaseStructure(BlockPos center, BlockPos bunkerEntrance, int wallHp, int doorHp, int bunkerHp) {
        this.center = center;
        this.bunkerEntrance = bunkerEntrance;
        this.bunkerMaxHp = bunkerHp;
        this.bunkerHp = bunkerHp;
    }

    public void addWall(BlockPos pos, int hp) {
        walls.put(pos.toImmutable(), new int[]{hp, hp});
    }

    public void addDoor(BlockPos pos, int hp) {
        doors.put(pos.toImmutable(), new int[]{hp, hp});
    }

    public int damageWall(BlockPos pos, int amount) {
        int[] hp = walls.get(pos);
        if (hp == null) return 0;
        hp[0] = Math.max(0, hp[0] - amount);
        return hp[0];
    }

    public int damageDoor(BlockPos pos, int amount) {
        int[] hp = doors.get(pos);
        if (hp == null) return 0;
        hp[0] = Math.max(0, hp[0] - amount);
        return hp[0];
    }

    public double integrity() {
        if (walls.isEmpty()) return 1.0;
        long total = 0, max = 0;
        for (int[] hp : walls.values()) { total += hp[0]; max += hp[1]; }
        return max == 0 ? 1.0 : (double) total / max;
    }

    /** Игрок прячется в бункере: пока бункер цел, химеры не добираются. */
    public boolean isBunkerIntact() {
        return bunkerHp > 0;
    }
}
