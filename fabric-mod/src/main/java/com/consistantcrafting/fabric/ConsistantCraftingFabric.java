package com.consistantcrafting.fabric;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Entry point for the Consistant Crafting Fabric port.
 *
 * The actual recipe changes are plain data pack recipe JSON files bundled
 * under src/main/resources/data/... (copied verbatim from the data pack's
 * data/consistant_crafting/recipe and data/minecraft/recipe directories).
 * Fabric loads mod resources as a data pack automatically, so no code is
 * required to register the recipes themselves.
 */
public class ConsistantCraftingFabric implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("consistant-crafting");

    @Override
    public void onInitialize() {
        LOGGER.info("Consistent Crafting loaded");
    }
}
