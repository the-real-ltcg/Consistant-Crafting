package com.consistantcrafting.bukkit;

import org.bukkit.Bukkit;
import org.bukkit.Keyed;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Iterator;
import java.util.List;

/**
 * Plain Bukkit/Spigot/Paper API plugin that ports the Consistant Crafting
 * data pack's recipe rebalances to a Java-registered recipe set, so it works
 * on any Bukkit-API server (Spigot/Paper/Purpur/Folia) regardless of which
 * mod/plugin loader is in play.
 *
 * Three recipe sets, registered differently:
 *  - {@link RecipeDefs#ALL}: single-ingredient "fix" recipes (slabs, bread,
 *    bucket, paper) that replace a vanilla recipe outright - the existing
 *    vanilla recipe for that exact result is removed first.
 *  - {@link RecipeDefs#ADDITIVE}: stairs-to-block recipes. Purely additive -
 *    no vanilla recipe is removed, since results like planks already have
 *    other legitimate vanilla recipes (e.g. log -> planks) that must keep
 *    working.
 *  - {@link RecipeDefs#MULTI}: recipes with more than one distinct
 *    ingredient Material (shulker box, dispenser). Each entry decides for
 *    itself whether to remove the existing vanilla recipe.
 *
 * We intentionally only ever remove vanilla recipes (key namespace
 * "minecraft") whose result matches our new result exactly - we never touch
 * other plugins' custom recipes.
 */
public final class ConsistentCraftingPlugin extends JavaPlugin {

    private static final String NAMESPACE = "consistantcrafting";

    @Override
    public void onEnable() {
        int registered = 0;
        for (RecipeDef def : RecipeDefs.ALL) {
            removeVanillaRecipesForResult(def.result());
            if (registerShapeless(def.key(), def.result(), def.resultCount(),
                    List.of(new RecipeDefs.IngredientStack(def.ingredient(), def.ingredientCount())))) {
                registered++;
            }
        }

        // Stairs-to-block recipes: purely additive, no vanilla recipe removal,
        // since the result Material (e.g. planks) keeps its other vanilla
        // recipes (e.g. log -> planks) intact.
        for (RecipeDef def : RecipeDefs.ADDITIVE) {
            if (registerShapeless(def.key(), def.result(), def.resultCount(),
                    List.of(new RecipeDefs.IngredientStack(def.ingredient(), def.ingredientCount())))) {
                registered++;
            }
        }

        // Multi-ingredient recipes (shulker box, dispenser).
        for (RecipeDefs.MultiRecipeDef def : RecipeDefs.MULTI) {
            if (def.removeVanilla()) {
                removeVanillaRecipesForResult(def.result());
            }
            if (registerShapeless(def.key(), def.result(), def.resultCount(), def.ingredients())) {
                registered++;
            }
        }

        // Remove-only: vanilla button recipes are removed with no replacement.
        for (Material mat : RecipeDefs.REMOVE_ONLY) {
            removeVanillaRecipesForResult(mat);
        }

        int total = RecipeDefs.ALL.size() + RecipeDefs.ADDITIVE.size() + RecipeDefs.MULTI.size();
        getLogger().info("Consistent Crafting loaded (" + registered + "/" + total + " recipes registered)");
    }

    private boolean registerShapeless(String key, Material result, int resultCount,
                                       List<RecipeDefs.IngredientStack> ingredients) {
        NamespacedKey recipeKey = new NamespacedKey(NAMESPACE, key);
        ItemStack resultStack = new ItemStack(result, resultCount);
        ShapelessRecipe recipe = new ShapelessRecipe(recipeKey, resultStack);
        for (RecipeDefs.IngredientStack ingredient : ingredients) {
            recipe.addIngredient(ingredient.count(), ingredient.material());
        }

        // Replace our own recipe on reload, and append fresh otherwise.
        Bukkit.removeRecipe(recipeKey);
        if (Bukkit.addRecipe(recipe)) {
            return true;
        }
        getLogger().warning("Failed to register recipe: " + recipeKey);
        return false;
    }

    /**
     * Removes vanilla ("minecraft:" namespaced) recipes whose result matches
     * the given Material, so our rebalanced shapeless recipe is the only way
     * to craft that result via crafting table. Recipes registered by other
     * plugins are left untouched.
     */
    private void removeVanillaRecipesForResult(Material result) {
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
