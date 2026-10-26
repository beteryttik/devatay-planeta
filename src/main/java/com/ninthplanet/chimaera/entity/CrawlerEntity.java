package com.ninthplanet.chimaera.entity;

import net.minecraft.world.World;

/** Вариант химеры Crawler. TODO: атрибуты, ИИ, анимации GeckoLib, звук. */
public class CrawlerEntity extends ChimaeraEntity {
    public CrawlerEntity(EntityType<? extends HostileEntity> type, World world) {
        super(type, world, ChimaeraType.BIO_BULB);
    }
}
