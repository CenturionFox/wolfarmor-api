package dev.satyrn.wolfarmor.api.util;

import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(Resources.MOD_ID)
public abstract class Recipes {
    /**
     * The leather armor dyeing recipe.
     */
    @ObjectHolder("leather_wolf_armor_dyed")
    public static final IRecipe LEATHER_ARMOR_DYES = null;
}
