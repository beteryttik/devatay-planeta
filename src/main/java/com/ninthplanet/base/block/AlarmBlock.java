package com.ninthplanet.base.block;

import net.minecraft.block.Block;

/** Блок тревоги: мигает красным перед волной, сигналит всем игрокам зоны. */
public class AlarmBlock extends Block {
    public AlarmBlock(Settings settings) {
        super(settings);
    }
    //TODO: привязка к BaseZone, мигание через scheduled ticks
}
