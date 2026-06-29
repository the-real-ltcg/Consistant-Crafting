package com.consistantcrafting.bukkit;

import org.bukkit.Material;

/**
 * Plain data holder for one rebalanced recipe: N copies of one ingredient
 * Material craft into a result Material/count, shapeless.
 */
public record RecipeDef(String key, Material ingredient, int ingredientCount, Material result, int resultCount) {
}
