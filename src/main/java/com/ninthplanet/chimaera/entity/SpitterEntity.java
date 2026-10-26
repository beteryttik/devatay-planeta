package com.ninthplanet.chimaera.entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;

import net.minecraft.world.World;

/** Вариант химеры Spitter. TODO: атрибуты, ИИ, анимации GeckoLib, звук. */
public class SpitterEntity extends ChimaeraEntity {
    public SpitterEntity(EntityType<? extends HostileEntity> type, World world) {
        super(type, world, ChimaeraType.BIO_BULB);
    }
}
