package com.ninthplanet.chimaera.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;

/** Химера-вертолёт: парит над целью, бросает щупальца вниз, AOE-урон по площадке. */
public class ChimaeraHeliEntity extends ChimaeraEntity {
    public ChimaeraHeliEntity(EntityType<? extends HostileEntity> type, World world) {
        super(type, world);
    }
}
