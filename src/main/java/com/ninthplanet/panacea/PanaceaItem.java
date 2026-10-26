package com.ninthplanet.panacea;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Панацея: снимает ВСЕ негативные эффекты и лечит, но даёт
 * нестабильность (Instability) — химеры замечают игрока дальше.
 * ЧИСТАЯ = меньше нестабильности; БЫСТРАЯ = мгновенно, высокий риск.
 */
public class PanaceaItem extends Item {
    private final boolean pure;

    public PanaceaItem(Settings settings, boolean pure) {
        super(settings);
        this.pure = pure;
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (user instanceof PlayerEntity player) {
            for (net.minecraft.entity.effect.StatusEffect effect : List.of()) {
                player.removeStatusEffect(effect); //TODO: снять все негативные эффекты
            }
            player.heal(pure ? 10.0f : 20.0f);
            int instabilitySeconds = pure ? 30 : 60;
            player.addStatusEffect(new StatusEffectInstance(
                    ModStatusEffects.INSTABILITY, instabilitySeconds * 20, 0));
        }
        return super.finishUsing(stack, world, user);
    }
}
