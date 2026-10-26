package com.ninthplanet.chimaera.entity;

import net.minecraft.world.World;

/** Вариант химеры Lurker. TODO: атрибуты, ИИ, анимации GeckoLib, звук. */
public class LurkerEntity extends ChimaeraEntity {
    public LurkerEntity(EntityType<? extends HostileEntity> type, World world) {
        super(type, world, ChimaeraType.BIO_BULB);
    }
}
