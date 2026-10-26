package com.ninthplanet.chimaera.entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;

import net.minecraft.world.World;

/** Вариант химеры Leaper. TODO: атрибуты, ИИ, анимации GeckoLib, звук. */
public class LeaperEntity extends ChimaeraEntity {
    public LeaperEntity(EntityType<? extends HostileEntity> type, World world) {
        super(type, world, ChimaeraType.BIO_BULB);
    }
}
