package com.ninthplanet.taint;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.PersistentState;

/** Данные заражения чанка: уровень taint, последнее обновление. */
public class TaintChunkData extends PersistentState {
    private int taintLevel = 0;
    private long lastUpdate;

    public int getTaintLevel() {
        return taintLevel;
    }

    public void setTaintLevel(int level) {
        taintLevel = Math.max(0, Math.min(5, level));
        markDirty();
    }

    public void touch(long time) {
        lastUpdate = time;
        markDirty();
    }

    public static BlockPos key(net.minecraft.util.math.ChunkPos pos) {
        return new BlockPos(pos.x, 0, pos.z);
    }
}
