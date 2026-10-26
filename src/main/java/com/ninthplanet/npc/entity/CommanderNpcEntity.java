package com.ninthplanet.npc.entity;

import net.minecraft.world.World;

/** NPC-роль Commander. TODO: задачи ИИ, фразы из профиля, распорядок дня. */
public class CommanderNpcEntity extends BaseNpcEntity {
    public CommanderNpcEntity(EntityType<? extends HostileEntity> type, World world) {
        super(type, world);
    }
}
