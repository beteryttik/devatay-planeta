package com.ninthplanet.memory;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;

/**
 * Воспоминания: игрок активирует артефакт — на 10-15 сек мир
 * «возвращается» в прошлое. В застывших контейнерах — сырая панацея.
 * В зонах с высоким заражением воспоминания «сбоят».
 */
public class MemoryManager {
    private static final int DURATION_TICKS = 15 * 20;

    public static void init() {
        //TODO: регистрация события активации артефакта
    }

    public static void startMemory(PlayerEntity player) {
        if (!(player.getWorld() instanceof ServerWorld world)) return;
        int taint = com.ninthplanet.core.TaintManager.getTaintLevel(world, player.getBlockPos());
        boolean corrupted = taint >= 4;

        world.playSound(null, player.getBlockPos(), SoundEvents.BLOCK_BEACON_ACTIVATE, SoundCategory.PLAYERS, 1.0f, corrupted ? 0.5f : 1.0f);
        //TODO: отправить пакет клиенту на включение MemoryOverlayHud (цвета: тёплые / искажённые)
    }
}
