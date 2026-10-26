package com.ninthplanet.chimaera.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;

/** Альфа-химера: босс третьей волны, идёт к сундукам и ценным блокам, дропает панацею. */
public class AlphaChimaeraEntity extends ChimaeraEntity {
    public AlphaChimaeraEntity(EntityType<? extends HostileEntity> type, World world) {
        super(type, world);
    }

    public static DefaultAttributeContainer.Builder createAlphaAttributes() {
        return ChimaeraEntity.createChimaeraAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 400.0)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 25.0);
    }
}
