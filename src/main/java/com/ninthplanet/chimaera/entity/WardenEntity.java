package com.ninthplanet.chimaera.entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;

import net.minecraft.world.World;

/** Вариант химеры Warden. TODO: атрибуты, ИИ, анимации GeckoLib, звук. */
public class WardenEntity extends ChimaeraEntity {
    public WardenEntity(EntityType<? extends HostileEntity> type, World world) {
        super(type, world, ChimaeraType.BIO_BULB);
    }
}
