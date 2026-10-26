package com.ninthplanet.registry;

import com.ninthplanet.NinthPlanetMod;
import com.ninthplanet.panacea.PanaceaItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModItems {
    public static final Item RAW_PANACEA = Registry.register(Registries.ITEM,
            NinthPlanetMod.id("raw_panacea"), new PanaceaItem(new Item.Settings(), true));

    public static final Item QUICK_PANACEA = Registry.register(Registries.ITEM,
            NinthPlanetMod.id("quick_panacea"), new PanaceaItem(new Item.Settings(), false));

    public static final Item NEUTRALIZING_POWDER = Registry.register(Registries.ITEM,
            NinthPlanetMod.id("neutralizing_powder"), new Item(new Item.Settings()));

    public static final Item MEMORY_CRYSTAL = Registry.register(Registries.ITEM,
            NinthPlanetMod.id("memory_crystal"), new Item(new Item.Settings()));

    public static final Item PLASMA_GUN = Registry.register(Registries.ITEM,
            NinthPlanetMod.id("plasma_gun"), new Item(new Item.Settings()));

    public static final Item CHIMAERA_SHARD = Registry.register(Registries.ITEM,
            NinthPlanetMod.id("chimaera_shard"), new Item(new Item.Settings()));

    public static void register() {
    }
}
