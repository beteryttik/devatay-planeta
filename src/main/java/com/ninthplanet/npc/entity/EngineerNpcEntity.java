package com.ninthplanet.npc.entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;

import net.minecraft.world.World;

/** NPC-роль Engineer. TODO: задачи ИИ, фразы из профиля, распорядок дня. */
public class EngineerNpcEntity extends BaseNpcEntity {
    public EngineerNpcEntity(EntityType<? extends HostileEntity> type, World world) {
        super(type, world);
    }
}
