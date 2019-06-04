package dev.satyrn.wolfarmor.api;

import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

public interface IArmoredWolf {

    boolean getHasChest();

    void setHasChest(boolean value);

    boolean getHasArmor();

    int getMaxSizeInventory();

    void setArmorItemStack(@Nonnull ItemStack armorItemStack);

    void equipArmor(@Nonnull ItemStack armorItemStack);

    boolean canEquipItem(@Nonnull ItemStack armorItemStack);

    void setInventoryItem(int index, @Nonnull ItemStack itemStack);

    @Nonnull
    ItemStack getArmorItemStack();

    @Nonnull
    InventoryBasic getInventory();

    void dropInventoryContents();

    void dropEquipment();

    void dropChest();
}
