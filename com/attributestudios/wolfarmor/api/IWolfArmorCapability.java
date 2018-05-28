package com.attributestudios.wolfarmor.api;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;


public interface IWolfArmorCapability {
    //region Properties
    boolean getHasChest();

    void setHasChest(boolean value);

    @Nonnull
    ItemStack getArmorItemStack();

    void setArmorItemStack(@Nonnull ItemStack armorItemStack);

    boolean getHasArmor();

    @Nonnull
    InventoryBasic getInventory();

    void setInventoryItem(int index, @Nonnull ItemStack itemStack);

    @Nonnegative
    int getMaxSizeInventory();

    //endregion Properties

    boolean canEquipItem(@Nonnull ItemStack armorItemStack);

    void equipArmor(@Nonnull ItemStack armorItemStack);

    boolean processInteract(@Nonnull EntityPlayer player, @Nonnull EnumHand hand);

    void dropEquipment(boolean killedByPlayer, int lootingModifier);

    void dropInventoryContents();

    void damageArmor(float damage);
}
