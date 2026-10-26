package com.ninthplanet.npc.entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;

import net.minecraft.world.World;

/** NPC-роль Guard. TODO: задачи ИИ, фразы из профиля, распорядок дня. */
public class GuardNpcEntity extends BaseNpcEntity {
    public GuardNpcEntity(EntityType<? extends HostileEntity> type, World world) {
        super(type, world);
    }
}
