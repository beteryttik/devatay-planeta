package com.ninthplanet.base.block;

import net.minecraft.block.Block;

/** Дверь бункера: открывается только по правам владельца базы, прочная. */
public class BunkerDoorBlock extends Block {
    public BunkerDoorBlock(Settings settings) {
        super(settings);
    }
    //TODO: доступ по UUID владельца зоны, звук герметичного закрытия
}
