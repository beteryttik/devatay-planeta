package com.ninthplanet.panacea;

import com.ninthplanet.NinthPlanetMod;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModStatusEffects {
    public static final StatusEffect INSTABILITY = Registry.register(
            Registries.STATUS_EFFECT,
            NinthPlanetMod.id("instability"),
            new InstabilityEffect(StatusEffectCategory.HARMFUL, 0xFF5500));

    public static void register() {
        // эффекты регистрируются статикой
    }

    public static class InstabilityEffect extends StatusEffect {
        public InstabilityEffect(StatusEffectCategory category, int color) {
            super(category, color);
        }

        @Override
        public boolean applyUpdateEffect(net.minecraft.entity.LivingEntity entity, int amplifier) {
            // химеры «слышат» нестабильного игрока с большого расстояния
            //TODO: у химер считывать наличие эффекта при выборе цели
            return true;
        }

        @Override
        public boolean canApplyUpdateEffect(int duration, int amplifier) {
            return true;
        }
    }
}
