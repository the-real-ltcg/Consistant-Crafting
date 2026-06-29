package com.consistantcrafting.bukkit;

import org.bukkit.Material;

import java.util.List;

/**
 * Hardcoded literal port of master_recipes.txt (63 rows) from the Consistant
 * Crafting data pack. Do NOT hand-edit individual entries without also
 * updating the source data pack / master_recipes.txt — these must stay in
 * sync. Generated mechanically from master_recipes.txt; ingredient/result
 * Material names are the item id with "minecraft:" stripped and uppercased.
 *
 * NOTE: a couple of these names are worth double-checking against the exact
 * Paper API version you target, since Material enum constants occasionally
 * get renamed/added between snapshots:
 *  - BAMBOO_MOSAIC / BAMBOO_MOSAIC_SLAB (added in 1.20+, fine for 1.21.4+)
 *  - PALE_OAK_PLANKS / PALE_OAK_SLAB (added in 1.21.4 "Pale Garden" update —
 *    requires targeting at least Paper API 1.21.4+)
 *  - RESIN_BRICKS / RESIN_BRICK_SLAB (added in 1.21.4+ as well)
 *  - TUFF_BRICKS / TUFF_BRICK_SLAB, POLISHED_TUFF / POLISHED_TUFF_SLAB
 *    (added in 1.21+)
 * If targeting an older Paper/Spigot API version, these constants will not
 * resolve and those specific RecipeDef entries (and only those) must be
 * removed or the build will fail.
 */
final class RecipeDefs {
    private RecipeDefs() {
    }

    static final List<RecipeDef> ALL = List.of(
        new RecipeDef("auto_slab_acacia_planks", Material.ACACIA_PLANKS, 1, Material.ACACIA_SLAB, 2),
        new RecipeDef("auto_slab_andesite", Material.ANDESITE, 1, Material.ANDESITE_SLAB, 2),
        new RecipeDef("auto_slab_bamboo_mosaic", Material.BAMBOO_MOSAIC, 1, Material.BAMBOO_MOSAIC_SLAB, 2),
        new RecipeDef("auto_slab_bamboo_planks", Material.BAMBOO_PLANKS, 1, Material.BAMBOO_SLAB, 2),
        new RecipeDef("auto_slab_birch_planks", Material.BIRCH_PLANKS, 1, Material.BIRCH_SLAB, 2),
        new RecipeDef("auto_slab_blackstone", Material.BLACKSTONE, 1, Material.BLACKSTONE_SLAB, 2),
        new RecipeDef("auto_slab_bricks", Material.BRICKS, 1, Material.BRICK_SLAB, 2),
        new RecipeDef("auto_slab_cherry_planks", Material.CHERRY_PLANKS, 1, Material.CHERRY_SLAB, 2),
        new RecipeDef("auto_slab_cobbled_deepslate", Material.COBBLED_DEEPSLATE, 1, Material.COBBLED_DEEPSLATE_SLAB, 2),
        new RecipeDef("auto_slab_cobblestone", Material.COBBLESTONE, 1, Material.COBBLESTONE_SLAB, 2),
        new RecipeDef("auto_slab_crimson_planks", Material.CRIMSON_PLANKS, 1, Material.CRIMSON_SLAB, 2),
        new RecipeDef("auto_slab_cut_copper", Material.CUT_COPPER, 1, Material.CUT_COPPER_SLAB, 2),
        new RecipeDef("auto_slab_cut_red_sandstone", Material.CUT_RED_SANDSTONE, 1, Material.CUT_RED_SANDSTONE_SLAB, 2),
        new RecipeDef("auto_slab_cut_sandstone", Material.CUT_SANDSTONE, 1, Material.CUT_SANDSTONE_SLAB, 2),
        new RecipeDef("auto_slab_dark_oak_planks", Material.DARK_OAK_PLANKS, 1, Material.DARK_OAK_SLAB, 2),
        new RecipeDef("auto_slab_dark_prismarine", Material.DARK_PRISMARINE, 1, Material.DARK_PRISMARINE_SLAB, 2),
        new RecipeDef("auto_slab_deepslate_bricks", Material.DEEPSLATE_BRICKS, 1, Material.DEEPSLATE_BRICK_SLAB, 2),
        new RecipeDef("auto_slab_deepslate_tiles", Material.DEEPSLATE_TILES, 1, Material.DEEPSLATE_TILE_SLAB, 2),
        new RecipeDef("auto_slab_end_stone_bricks", Material.END_STONE_BRICKS, 1, Material.END_STONE_BRICK_SLAB, 2),
        new RecipeDef("auto_slab_exposed_cut_copper", Material.EXPOSED_CUT_COPPER, 1, Material.EXPOSED_CUT_COPPER_SLAB, 2),
        new RecipeDef("auto_slab_jungle_planks", Material.JUNGLE_PLANKS, 1, Material.JUNGLE_SLAB, 2),
        new RecipeDef("auto_slab_mangrove_planks", Material.MANGROVE_PLANKS, 1, Material.MANGROVE_SLAB, 2),
        new RecipeDef("auto_slab_mossy_cobblestone", Material.MOSSY_COBBLESTONE, 1, Material.MOSSY_COBBLESTONE_SLAB, 2),
        new RecipeDef("auto_slab_mossy_stone_bricks", Material.MOSSY_STONE_BRICKS, 1, Material.MOSSY_STONE_BRICK_SLAB, 2),
        new RecipeDef("auto_slab_mud_bricks", Material.MUD_BRICKS, 1, Material.MUD_BRICK_SLAB, 2),
        new RecipeDef("auto_slab_nether_bricks", Material.NETHER_BRICKS, 1, Material.NETHER_BRICK_SLAB, 2),
        new RecipeDef("auto_slab_oak_planks", Material.OAK_PLANKS, 1, Material.OAK_SLAB, 2),
        new RecipeDef("auto_slab_oxidized_cut_copper", Material.OXIDIZED_CUT_COPPER, 1, Material.OXIDIZED_CUT_COPPER_SLAB, 2),
        new RecipeDef("auto_slab_pale_oak_planks", Material.PALE_OAK_PLANKS, 1, Material.PALE_OAK_SLAB, 2),
        new RecipeDef("auto_slab_polished_andesite", Material.POLISHED_ANDESITE, 1, Material.POLISHED_ANDESITE_SLAB, 2),
        new RecipeDef("auto_slab_polished_blackstone", Material.POLISHED_BLACKSTONE, 1, Material.POLISHED_BLACKSTONE_SLAB, 2),
        new RecipeDef("auto_slab_polished_blackstone_bricks", Material.POLISHED_BLACKSTONE_BRICKS, 1, Material.POLISHED_BLACKSTONE_BRICK_SLAB, 2),
        new RecipeDef("auto_slab_polished_deepslate", Material.POLISHED_DEEPSLATE, 1, Material.POLISHED_DEEPSLATE_SLAB, 2),
        new RecipeDef("auto_slab_prismarine", Material.PRISMARINE, 1, Material.PRISMARINE_SLAB, 2),
        new RecipeDef("auto_slab_prismarine_bricks", Material.PRISMARINE_BRICKS, 1, Material.PRISMARINE_BRICK_SLAB, 2),
        new RecipeDef("auto_slab_purpur_block", Material.PURPUR_BLOCK, 1, Material.PURPUR_SLAB, 2),
        new RecipeDef("auto_slab_quartz_block", Material.QUARTZ_BLOCK, 1, Material.QUARTZ_SLAB, 2),
        new RecipeDef("auto_slab_red_nether_bricks", Material.RED_NETHER_BRICKS, 1, Material.RED_NETHER_BRICK_SLAB, 2),
        new RecipeDef("auto_slab_red_sandstone", Material.RED_SANDSTONE, 1, Material.RED_SANDSTONE_SLAB, 2),
        new RecipeDef("auto_slab_sandstone", Material.SANDSTONE, 1, Material.SANDSTONE_SLAB, 2),
        new RecipeDef("auto_slab_smooth_quartz", Material.SMOOTH_QUARTZ, 1, Material.SMOOTH_QUARTZ_SLAB, 2),
        new RecipeDef("auto_slab_smooth_red_sandstone", Material.SMOOTH_RED_SANDSTONE, 1, Material.SMOOTH_RED_SANDSTONE_SLAB, 2),
        new RecipeDef("auto_slab_smooth_sandstone", Material.SMOOTH_SANDSTONE, 1, Material.SMOOTH_SANDSTONE_SLAB, 2),
        new RecipeDef("auto_slab_smooth_stone", Material.SMOOTH_STONE, 1, Material.SMOOTH_STONE_SLAB, 2),
        new RecipeDef("auto_slab_spruce_planks", Material.SPRUCE_PLANKS, 1, Material.SPRUCE_SLAB, 2),
        new RecipeDef("auto_slab_stone_bricks", Material.STONE_BRICKS, 1, Material.STONE_BRICK_SLAB, 2),
        new RecipeDef("auto_slab_warped_planks", Material.WARPED_PLANKS, 1, Material.WARPED_SLAB, 2),
        new RecipeDef("auto_slab_waxed_cut_copper", Material.WAXED_CUT_COPPER, 1, Material.WAXED_CUT_COPPER_SLAB, 2),
        new RecipeDef("auto_slab_waxed_exposed_cut_copper", Material.WAXED_EXPOSED_CUT_COPPER, 1, Material.WAXED_EXPOSED_CUT_COPPER_SLAB, 2),
        new RecipeDef("auto_slab_waxed_oxidized_cut_copper", Material.WAXED_OXIDIZED_CUT_COPPER, 1, Material.WAXED_OXIDIZED_CUT_COPPER_SLAB, 2),
        new RecipeDef("auto_slab_waxed_weathered_cut_copper", Material.WAXED_WEATHERED_CUT_COPPER, 1, Material.WAXED_WEATHERED_CUT_COPPER_SLAB, 2),
        new RecipeDef("auto_slab_weathered_cut_copper", Material.WEATHERED_CUT_COPPER, 1, Material.WEATHERED_CUT_COPPER_SLAB, 2),
        new RecipeDef("block_slab", Material.STONE, 1, Material.STONE_SLAB, 2),
        new RecipeDef("block_slab_2", Material.GRANITE, 1, Material.GRANITE_SLAB, 2),
        new RecipeDef("bs_3", Material.POLISHED_GRANITE, 1, Material.POLISHED_GRANITE_SLAB, 2),
        new RecipeDef("bs_4", Material.DIORITE, 1, Material.DIORITE_SLAB, 2),
        new RecipeDef("bs_5", Material.POLISHED_DIORITE, 1, Material.POLISHED_DIORITE_SLAB, 2),
        new RecipeDef("bs_6", Material.TUFF, 1, Material.TUFF_SLAB, 2),
        new RecipeDef("bs_7", Material.POLISHED_TUFF, 1, Material.POLISHED_TUFF_SLAB, 2),
        new RecipeDef("bs_8", Material.TUFF_BRICKS, 1, Material.TUFF_BRICK_SLAB, 2),
        new RecipeDef("bs_9", Material.RESIN_BRICKS, 1, Material.RESIN_BRICK_SLAB, 2),
        new RecipeDef("better_bread", Material.WHEAT, 3, Material.BREAD, 3),
        new RecipeDef("better_bucket", Material.IRON_INGOT, 3, Material.BUCKET, 1)
    );
}
