package com.ninthplanet.npc.projectile;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

/** Снаряд «плазменной пушки»: летит, наносит урон, отбрасывает цель, взрывается. */
public class PlasmaBoltEntity extends ProjectileEntity {
    public static final EntityType<PlasmaBoltEntity> TYPE = com.ninthplanet.registry.ModEntities.PLASMA_BOLT;

    private static final float DAMAGE = 6.0f;
    private static final double KNOCKBACK = 1.2;

    public PlasmaBoltEntity(EntityType<? extends PlasmaBoltEntity> type, World world) {
        super(type, world);
    }

    public PlasmaBoltEntity(World world, LivingEntity owner, LivingEntity target) {
        super(com.ninthplanet.registry.ModEntities.PLASMA_BOLT, world);
        setOwner(owner);
        Vec3d dir = target.getPos().add(0, target.getHeight() / 2, 0).subtract(getPos()).normalize();
        setVelocity(dir.multiply(1.5));
    }

    @Override
    public void tick() {
        super.tick();
        if (getWorld().isClient) {
            getWorld().addParticle(ParticleTypes.END_ROD, getX(), getY(), getZ(), 0, 0, 0);
        }
        HitResult hit = getCollision();
        if (hit != null && hit.getType() != HitResult.Type.MISS) {
            onHit(hit);
        }
    }

    private void onHit(HitResult hit) {
        if (hit instanceof EntityHitResult entityHit && entityHit.getEntity() instanceof LivingEntity living) {
            DamageSource src = new DamageSource(
                    getWorld().getRegistryManager().get(RegistryKeys.DAMAGE_TYPE).entryOf(DamageTypes.GENERIC), getOwner());
            living.damage(src, DAMAGE);
            living.takeKnockback(KNOCKBACK, getX() - living.getX(), getZ() - living.getZ());
        }
        getWorld().addParticle(ParticleTypes.FLASH, getX(), getY(), getZ(), 0, 0, 0);
        discard();
    }

    @Override
    protected void initDataTracker() {
    }
}
