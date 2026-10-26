package com.ninthplanet.portal.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

/**
 * Портал в обычный мир: телепортирует только пока активно окно.
 * Тратит 1 панацею как «топливо» перехода (по конфигу).
 * После перехода — эффект послешока 10 сек.
 */
public class EmergencyPortalEntity extends Entity {
    public EmergencyPortalEntity(EntityType<?> type, World world) {
        super(type, world);
    }

    @Override
    public void onPlayerCollision(PlayerEntity player) {
        if (getWorld().isClient) return;
        if (!com.ninthplanet.core.manager.PortalCycleManager.isWindowActive()) return;

        ServerPlayerEntity serverPlayer = (ServerPlayerEntity) player;
        ServerWorld overworld = getServer().getWorld(net.minecraft.world.World.OVERWORLD);

        //TODO: проверить расход панацеи (PortalCycleConfig.COSTS_PANACEA)

        serverPlayer.teleport(overworld, serverPlayer.getX(), serverPlayer.getY(), serverPlayer.getZ(),
                serverPlayer.getYaw(), serverPlayer.getPitch());
    }

    @Override
    protected void initDataTracker() {
    }
}
