package com.ninthplanet.npc.entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;

import net.minecraft.world.World;

/** NPC-роль Scout. TODO: задачи ИИ, фразы из профиля, распорядок дня. */
public class ScoutNpcEntity extends BaseNpcEntity {
    public ScoutNpcEntity(EntityType<? extends HostileEntity> type, World world) {
        super(type, world);
    }
}
