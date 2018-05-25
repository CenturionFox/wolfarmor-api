package com.attributestudios.wolfarmor.api;

import net.minecraft.item.Item;
import static net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@ObjectHolder(Strings.MOD_ID)
public abstract class Items
{
    /**
     * The leather wolf armor item.
     */
    @ObjectHolder("leather_wolf_armor")
    public static Item LEATHER_WOLF_ARMOR;

    /**
     * The chainmail wolf armor item.
     */
    @ObjectHolder("chainmail_wolf_armor")
    public static Item CHAINMAIL_WOLF_ARMOR;

    /**
     * The iron wolf armor item.
     */
    @ObjectHolder("iron_wolf_armor")
    public static Item IRON_WOLF_ARMOR;

    /**
     * The gold wolf armor item.
     */
    @ObjectHolder("gold_wolf_armor")
    public static Item GOLD_WOLF_ARMOR;

    /**
     * The diamond wolf armor item.
     */
    @ObjectHolder("diamond_wolf_armor")
    public static Item DIAMOND_WOLF_ARMOR;
}
