package com.ninthplanet.npc.entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;

import net.minecraft.world.World;

/** NPC-роль Medic. TODO: задачи ИИ, фразы из профиля, распорядок дня. */
public class MedicNpcEntity extends BaseNpcEntity {
    public MedicNpcEntity(EntityType<? extends HostileEntity> type, World world) {
        super(type, world);
    }
}
