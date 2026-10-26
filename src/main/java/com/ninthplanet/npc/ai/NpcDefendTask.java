package com.ninthplanet.npc.ai;

import com.ninthplanet.chimaera.entity.ChimaeraEntity;
import com.ninthplanet.npc.entity.BaseNpcEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.util.math.Box;

import java.util.Comparator;
import java.util.EnumSet;
import java.util.List;

/** Задача NPC: искать химер в радиусе 16 блоков и стрелять по ближайшей. */
public class NpcDefendTask extends Goal {
    private final BaseNpcEntity npc;
    private LivingEntity nearestChimaera;
    private static final double SEARCH_RADIUS = 16.0;

    public NpcDefendTask(BaseNpcEntity npc) {
        this.npc = npc;
        this.setControls(EnumSet.of(Control.MOVE, Control.LOOK));
    }

    @Override
    public boolean canStart() {
        return npc.getWorld().getTime() % 20 == 0;
    }

    @Override
    public void start() {
        Box searchBox = new Box(npc.getBlockPos()).expand(SEARCH_RADIUS);
        List<ChimaeraEntity> chimaeras = npc.getWorld().getEntitiesByClass(
                ChimaeraEntity.class, searchBox, c -> c.isAlive());
        nearestChimaera = chimaeras.stream()
                .min(Comparator.comparingDouble(npc::distanceTo))
                .orElse(null);
    }

    @Override
    public void tick() {
        if (nearestChimaera != null && nearestChimaera.isAlive()) {
            npc.getLookControl().lookAt(nearestChimaera);
            npc.tryShoot(nearestChimaera);
        }
    }

    @Override
    public boolean shouldContinue() {
        return nearestChimaera != null && nearestChimaera.isAlive();
    }
}
