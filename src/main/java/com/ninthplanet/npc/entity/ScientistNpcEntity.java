package com.ninthplanet.npc.entity;

import net.minecraft.world.World;

/** NPC-роль Scientist. TODO: задачи ИИ, фразы из профиля, распорядок дня. */
public class ScientistNpcEntity extends BaseNpcEntity {
    public ScientistNpcEntity(EntityType<? extends HostileEntity> type, World world) {
        super(type, world);
    }
}
