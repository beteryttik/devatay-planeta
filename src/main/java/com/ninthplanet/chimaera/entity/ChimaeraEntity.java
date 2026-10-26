package com.ninthplanet.chimaera.entity;

import com.ninthplanet.chimaera.ChimaeraType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

/**
 * Единая сущность химеры с типом. Слабая точка — голова/ядро:
 * попадание туда даёт множитель урона WEAK_POINT_MULTIPLIER.
 */
public class ChimaeraEntity extends HostileEntity {
    private static final float WEAK_POINT_MULTIPLIER = 2.0f;
    private ChimaeraType chimaeraType = ChimaeraType.BIO_BULB;

    public ChimaeraEntity(EntityType<? extends HostileEntity> type, World world) {
        super(type, world);
    }

    public ChimaeraEntity(EntityType<? extends HostileEntity> type, World world, ChimaeraType chimaeraType) {
        super(type, world);
        this.chimaeraType = chimaeraType;
    }

    public ChimaeraType getChimaeraType() {
        return chimaeraType;
    }

    public static DefaultAttributeContainer.Builder createChimaeraAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 120.0)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 12.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.22);
    }

    /** Хитбокс слабой точки (голова/ядро) в зависимости от типа. */
    public Box getWeakPointBox() {
        Vec3d head = getPos().add(0, getHeight() * 0.8, 0);
        double r = 1.5;
        return new Box(head.x - r, head.y - r, head.z - r, head.x + r, head.y + r, head.z + r);
    }

    @Override
    public boolean damage(DamageSource source, float amount) {
        Vec3d sourcePos = source.getPosition() != null ? source.getPosition() : Vec3d.ZERO;
        if (getWeakPointBox().expand(0.5).contains(sourcePos)) {
            amount *= WEAK_POINT_MULTIPLIER;
            // визуальная реакция: вспышка ядра
            //TODO: World.sendParticles в точке головы
        }
        return super.damage(source, amount);
    }
}
