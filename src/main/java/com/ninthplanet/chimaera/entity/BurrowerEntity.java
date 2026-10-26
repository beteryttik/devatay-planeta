package com.ninthplanet.chimaera.entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;

import net.minecraft.world.World;

/** Вариант химеры Burrower. TODO: атрибуты, ИИ, анимации GeckoLib, звук. */
public class BurrowerEntity extends ChimaeraEntity {
    public BurrowerEntity(EntityType<? extends HostileEntity> type, World world) {
        super(type, world, ChimaeraType.BIO_BULB);
    }
}
