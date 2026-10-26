package com.ninthplanet.npc.entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;

import net.minecraft.world.World;

/** NPC-роль Farmer. TODO: задачи ИИ, фразы из профиля, распорядок дня. */
public class FarmerNpcEntity extends BaseNpcEntity {
    public FarmerNpcEntity(EntityType<? extends HostileEntity> type, World world) {
        super(type, world);
    }
}
