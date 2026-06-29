package com.consistantcrafting.forge;

import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Entry point for the Consistant Crafting Forge port.
 *
 * The actual recipe changes are plain data pack recipe JSON files bundled
 * under src/main/resources/data/... (copied verbatim from the data pack's
 * data/consistant_crafting/recipe and data/minecraft/recipe directories).
 * Forge loads mod resources as a data pack automatically, so no code is
 * required to register the recipes themselves.
 */
@Mod("consistant_crafting")
public class ConsistantCraftingForge {
    private static final Logger LOGGER = LogManager.getLogger();

    public ConsistantCraftingForge() {
        LOGGER.info("Consistent Crafting loaded");
    }
}
