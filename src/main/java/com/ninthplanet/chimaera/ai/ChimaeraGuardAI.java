package com.ninthplanet.chimaera.ai;

import com.ninthplanet.chimaera.entity.ChimaeraEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.util.math.BlockPos;

import java.util.EnumSet;

/**
 * ИИ стража портала: держит позицию вокруг обелиска, перекрывает проходы,
 * атакует игроков в радиусе обнаружения. Во время окна получает баффы.
 */
public class ChimaeraGuardAI extends Goal {
    private final ChimaeraEntity chimaera;
    private final BlockPos anchor;

    public ChimaeraGuardAI(ChimaeraEntity chimaera, BlockPos anchor) {
        this.chimaera = chimaera;
        this.anchor = anchor;
        this.setControls(EnumSet.of(Control.MOVE, Control.LOOK));
    }

    @Override
    public boolean canStart() {
        return anchor != null && chimaera.getWorld().getTime() % 20 == 0;
    }

    @Override
    public void tick() {
        double dist = chimaera.squaredDistanceTo(anchor.getX(), anchor.getY(), anchor.getZ());
        if (dist > 12 * 12) {
            //TODO: pathfind обратно к посту
        }
        //TODO: баффы окна: SPEED +30%, радиус обнаружения +50%, иммунитет к отбрасыванию
    }
}
