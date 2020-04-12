package dev.satyrn.wolfarmor.api.util;

import net.minecraft.advancements.ICriterionTrigger;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(Resources.MOD_ID)
public abstract class Criteria {

    public static ICriterionTrigger<?> EQUIP_WOLF_ARMOR;

    public static ICriterionTrigger<?> EQUIP_WOLF_CHEST;
}
