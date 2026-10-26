package com.ninthplanet.base.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;

/** Бронированная стена: высокая прочность, химеры-штурмовики ломают медленно. */
public class ReinforcedWallBlock extends Block {
    public ReinforcedWallBlock(Settings settings) {
        super(settings);
    }

    //TODO: оверрайд onBreak для обновления прочности в BaseStructure
    //TODO: при ударе химеры — снижать HP блока через BaseDefenseManager
}
