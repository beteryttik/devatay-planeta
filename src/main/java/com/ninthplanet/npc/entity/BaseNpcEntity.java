package com.ninthplanet.npc.entity;

import com.ninthplanet.npc.projectile.PlasmaBoltEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

/**
 * NPC базы. При волне — обороняется: ищет химер и стреляет снарядами раз в 2 сек.
 * ПКМ — диалог (позже Shift+ПКМ — панель оператора).
 */
public class BaseNpcEntity extends HostileEntity {
    private int shootCooldown = 0;
    private static final int COOLDOWN_TICKS = 40;

    public BaseNpcEntity(EntityType<? extends HostileEntity> type, World world) {
        super(type, world);
    }

    public static DefaultAttributeContainer.Builder createNpcAttributes() {
        return HostileEntity.createAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 40.0)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 4.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25);
    }

    @Override
    public void tick() {
        super.tick();
        if (shootCooldown > 0) shootCooldown--;
    }

    public void tryShoot(LivingEntity target) {
        if (shootCooldown <= 0 && target != null && target.isAlive()) {
            shootCooldown = COOLDOWN_TICKS;
            PlasmaBoltEntity bolt = new PlasmaBoltEntity(getWorld(), this, target);
            bolt.setPosition(getX(), getY() + 1.6, getZ());
            getWorld().spawnEntity(bolt);
            playSound(SoundEvents.ENTITY_GHAST_SHOOT, 1.0f, 1.0f);
        }
    }

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        //TODO: открыть NpcDialogScreen — реплика из профиля + аудио
        return ActionResult.PASS;
    }
}
