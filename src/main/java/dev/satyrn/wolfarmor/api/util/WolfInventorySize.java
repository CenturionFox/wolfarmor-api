package dev.satyrn.wolfarmor.api.util;

import net.minecraft.nbt.NBTTagByteArray;
import net.minecraftforge.common.util.INBTSerializable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Represents a wolf's inventory size in the settings
 */
public final class WolfInventorySize implements INBTSerializable<NBTTagByteArray> {
    private static final byte[] DIMS_MIN = {1, 1};
    private static final byte[] DIMS_MAX = {5, 3};

    int columns = DIMS_MIN[0];
    int rows = DIMS_MIN[1];

    public WolfInventorySize() { }

    public WolfInventorySize(int columns, int rows) {
        this.setColumns(columns);
        this.setRows(rows);
    }

    /**
     * Gets the number of columns in the pack
     * @return The number of columns in the pack
     */
    public int getColumns() {
        return this.columns;
    }

    /**
     * Sets the number of columns in the pack
     * @param value The number of columns in the pack
     * @exception IllegalArgumentException The value of value was outside of the range allowed
     */
    public void setColumns(int value) {
        if (value < DIMS_MIN[0] || value > DIMS_MAX[0]) {
           throw new IllegalArgumentException(
                   String.format("The desired column count '%d' was outside the bounds [%d..%d]",
                           value, DIMS_MIN[0], DIMS_MAX[0]));
        }
        this.columns = value;
    }

    /**
     * Gets the number of rows in the pack
     * @return The number of rows in the pack
     */
    public int getRows() {
        return this.rows;
    }

    /**
     * Sets the number of rows in the pack
     * @param value The number of rows in the pack
     * @exception IllegalArgumentException The
     */
    public void setRows(int value) {
        if (value < DIMS_MIN[1] || value > DIMS_MAX[1]) {
            throw new IllegalArgumentException(
                    String.format("The desired row count '%d' was outside the bounds [%d..%d]",
                            value, DIMS_MIN[1], DIMS_MAX[1])
            );
        }
        this.rows = value;
    }

    @Override
    public NBTTagByteArray serializeNBT() {
        byte[] dimensions = {(byte)this.columns, (byte)this.rows};
        return new NBTTagByteArray(dimensions);
    }

    @Override
    public void deserializeNBT(NBTTagByteArray nbtTagByteArray) {
        byte[] dimensions = nbtTagByteArray.getByteArray();
        this.setColumns(dimensions[0]);
        this.setRows(dimensions[1]);
    }

    /**
     * Returns a string representation of the object.
     *
     * @return  a string representation of the object.
     */
    @Override
    public String toString() {
        return String.format("%dx%d", this.columns, this.rows);
    }

    /**
     * Parses a string representation of this object
     * @param s The string value
     * @return A new WolfInventorySize object
     * @throws IllegalArgumentException The input string was not in the proper formeat.
     */
    public static WolfInventorySize parseWolfInventorySize(String s) {
        Pattern pattern = Pattern.compile(
                String.format("([%d-%d])x([%d-%d])", DIMS_MIN[0], DIMS_MAX[0], DIMS_MIN[1], DIMS_MAX[1]));
        Matcher matcher = pattern.matcher(s);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(
                    String.format("The input string was not in the proper format: '%s'", pattern));
        }
        return new WolfInventorySize(Integer.parseInt(matcher.group(1)),
                Integer.parseInt(matcher.group(2)));
    }
}
