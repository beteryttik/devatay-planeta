package com.ninthplanet.portal.block;

import com.ninthplanet.core.manager.PortalCycleManager;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Обелиск: точка окна стабильности. Фаза WARNING — свет и гул,
 * фаза WINDOW — активный портал. Регистрирует позицию в PortalCycleManager.
 */
public class ObeliskBlock extends Block {
    public ObeliskBlock(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!world.isClient) {
            PortalCycleManager.setObeliskPos(pos.toImmutable());
            ((ServerWorld) world).spawnParticles(ParticleTypes.END_ROD,
                    pos.getX() + 0.5, pos.getY() + 1.0, pos.getZ() + 0.5, 20, 0.5, 0.5, 0.5, 0.1);
        }
        return ActionResult.SUCCESS;
    }
}
