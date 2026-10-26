package com.ninthplanet.registry;

import com.ninthplanet.NinthPlanetMod;
import com.ninthplanet.base.block.AlarmBlock;
import com.ninthplanet.base.block.BunkerDoorBlock;
import com.ninthplanet.base.block.ReinforcedWallBlock;
import com.ninthplanet.portal.block.ObeliskBlock;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModBlocks {
    public static final Block OBELISK = Registry.register(Registries.BLOCK,
            NinthPlanetMod.id("obelisk"), new ObeliskBlock(Block.Settings.create().strength(-1.0f, 3600000.0f)));

    public static final Block REINFORCED_WALL = Registry.register(Registries.BLOCK,
            NinthPlanetMod.id("reinforced_wall"), new ReinforcedWallBlock(Block.Settings.create().strength(12.0f, 1200.0f)));

    public static final Block BUNKER_DOOR = Registry.register(Registries.BLOCK,
            NinthPlanetMod.id("bunker_door"), new BunkerDoorBlock(Block.Settings.create().strength(10.0f, 900.0f)));

    public static final Block ALARM = Registry.register(Registries.BLOCK,
            NinthPlanetMod.id("alarm"), new AlarmBlock(Block.Settings.create().strength(2.0f)));

    public static void register() {
    }
}
