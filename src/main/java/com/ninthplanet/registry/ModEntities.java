package com.ninthplanet.registry;

import com.ninthplanet.NinthPlanetMod;
import com.ninthplanet.chimaera.entity.*;
import com.ninthplanet.npc.entity.BaseNpcEntity;
import com.ninthplanet.npc.projectile.PlasmaBoltEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModEntities {
    public static final EntityType<ChimaeraEntity> CHIMAERA = Registry.register(
            Registries.ENTITY_TYPE,
            NinthPlanetMod.id("chimaera"),
            EntityType.Builder.create(ChimaeraEntity::new, SpawnGroup.MONSTER)
                    .dimensions(2.5f, 2.5f).build());

    public static final EntityType<AlphaChimaeraEntity> ALPHA_CHIMAERA = Registry.register(
            Registries.ENTITY_TYPE,
            NinthPlanetMod.id("alpha_chimaera"),
            EntityType.Builder.create(AlphaChimaeraEntity::new, SpawnGroup.MONSTER)
                    .dimensions(3.5f, 3.5f).build());

    public static final EntityType<BaseNpcEntity> BASE_NPC = Registry.register(
            Registries.ENTITY_TYPE,
            NinthPlanetMod.id("base_npc"),
            EntityType.Builder.create(BaseNpcEntity::new, net.minecraft.entity.SpawnGroup.CREATURE)
                    .dimensions(0.6f, 1.8f).build());

    public static final EntityType<PlasmaBoltEntity> PLASMA_BOLT = Registry.register(
            Registries.ENTITY_TYPE,
            NinthPlanetMod.id("plasma_bolt"),
            EntityType.Builder.<PlasmaBoltEntity>create(PlasmaBoltEntity::new, net.minecraft.entity.SpawnGroup.MISC)
                    .dimensions(0.3f, 0.3f).build());

    public static void register() {
        FabricDefaultAttributeRegistry.register(CHIMAERA, ChimaeraEntity.createChimaeraAttributes());
        FabricDefaultAttributeRegistry.register(ALPHA_CHIMAERA, AlphaChimaeraEntity.createAlphaAttributes());
        FabricDefaultAttributeRegistry.register(BASE_NPC, BaseNpcEntity.createNpcAttributes());
    }
}
