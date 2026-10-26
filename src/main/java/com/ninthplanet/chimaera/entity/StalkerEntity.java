package com.ninthplanet.chimaera.entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;

import net.minecraft.world.World;

/** Вариант химеры Stalker. TODO: атрибуты, ИИ, анимации GeckoLib, звук. */
public class StalkerEntity extends ChimaeraEntity {
    public StalkerEntity(EntityType<? extends HostileEntity> type, World world) {
        super(type, world, ChimaeraType.BIO_BULB);
    }
}
