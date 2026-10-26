package com.ninthplanet.chimaera.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;

/** Химера-машина: рывок-таран, сбивает с ног, ломает двери базы. */
public class ChimaeraCarEntity extends ChimaeraEntity {
    public ChimaeraCarEntity(EntityType<? extends HostileEntity> type, World world) {
        super(type, world);
    }
}
