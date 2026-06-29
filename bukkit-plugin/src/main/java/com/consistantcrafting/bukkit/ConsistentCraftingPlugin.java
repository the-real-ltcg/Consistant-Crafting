package com.consistantcrafting.bukkit;

import org.bukkit.Bukkit;
import org.bukkit.Keyed;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Iterator;

/**
 * Plain Bukkit/Spigot/Paper API plugin that ports the Consistant Crafting
 * data pack's recipe rebalances to a Java-registered recipe set, so it works
 * on any Bukkit-API server (Spigot/Paper/Purpur/Folia) regardless of which
 * mod/plugin loader is in play.
 *
 * For each entry in {@link RecipeDefs#ALL} this:
 *  1. Removes any vanilla ("minecraft:...") simple/shapeless recipe that
 *     produces the exact same result Material, since it's being directly
 *     superseded by our rebalanced version with the same output.
 *  2. Registers a new ShapelessRecipe under the "consistantcrafting"
 *     namespace requiring N copies of one ingredient Material.
 *
 * We intentionally only remove vanilla recipes (key namespace "minecraft")
 * whose result matches our new result exactly - we never touch other
 * plugins' custom recipes, and we never remove a vanilla recipe for an
 * item we are NOT replacing.
 */
public final class ConsistentCraftingPlugin extends JavaPlugin {

    private static final String NAMESPACE = "consistantcrafting";

    @Override
    public void onEnable() {
        int registered = 0;
        for (RecipeDef def : RecipeDefs.ALL) {
            removeVanillaRecipesForResult(def.result());

            NamespacedKey key = new NamespacedKey(NAMESPACE, def.key());
            ItemStack result = new ItemStack(def.result(), def.resultCount());
            ShapelessRecipe recipe = new ShapelessRecipe(key, result);
            recipe.addIngredient(def.ingredientCount(), def.ingredient());

            // Replace our own recipe on reload, and append fresh otherwise.
            Bukkit.removeRecipe(key);
            if (Bukkit.addRecipe(recipe)) {
                registered++;
            } else {
                getLogger().warning("Failed to register recipe: " + key);
            }
        }
        getLogger().info("Consistent Crafting loaded (" + registered + "/" + RecipeDefs.ALL.size() + " recipes registered)");
    }

    /**
     * Removes vanilla ("minecraft:" namespaced) recipes whose result matches
     * the given Material, so our rebalanced shapeless recipe is the only way
     * to craft that result via crafting table. Recipes registered by other
     * plugins are left untouched.
     */
    private void removeVanillaRecipesForResult(org.bukkit.Material result) {
        Iterator<Recipe> it = Bukkit.recipeIterator();
        while (it.hasNext()) {
            Recipe recipe = it.next();
            ItemStack recipeResult = recipe.getResult();
            if (recipeResult.getType() != result) {
                continue;
            }
            if (recipe instanceof Keyed keyed) {
                NamespacedKey existingKey = keyed.getKey();
                if ("minecraft".equals(existingKey.getNamespace())) {
                    it.remove();
                }
            }
        }
    }
}
