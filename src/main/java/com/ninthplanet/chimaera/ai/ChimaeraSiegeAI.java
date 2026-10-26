package com.ninthplanet.chimaera.ai;

import com.ninthplanet.chimaera.entity.ChimaeraEntity;
import com.ninthplanet.base.BaseStructure;
import net.minecraft.entity.ai.goal.Goal;

import java.util.EnumSet;

/** ИИ штурмовика: целенаправленно бьёт слабые места базы, разбирает стены, ищет сундуки. */
public class ChimaeraSiegeAI extends Goal {
    private final ChimaeraEntity chimaera;
    private final BaseStructure base;

    public ChimaeraSiegeAI(ChimaeraEntity chimaera, BaseStructure base) {
        this.chimaera = chimaera;
        this.base = base;
        this.setControls(EnumSet.of(Control.MOVE));
    }

    @Override
    public boolean canStart() {
        return base != null;
    }

    @Override
    public void tick() {
        //TODO: путь к ближайшей слабой точке, удары по блокам со снижением прочности
    }
}
