package com.ninthplanet;

import com.ninthplanet.registry.*;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NinthPlanetMod implements ModInitializer {
    public static final String MOD_ID = "ninthplanet";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static Identifier id(String path) {
        return new Identifier(MOD_ID, path);
    }

    @Override
    public void onInitialize() {
        ModBlocks.register();
        ModItems.register();
        ModEntities.register();
        ModSounds.register();
        ModStatusEffects.register();

        com.ninthplanet.core.manager.PortalCycleManager.init();
        com.ninthplanet.core.manager.BaseDefenseManager.init();
        com.ninthplanet.core.TaintManager.init();
        com.ninthplanet.memory.MemoryManager.init();

        LOGGER.info("[Ninth Planet] Mod initialized. The planet remembers.");
    }
}
