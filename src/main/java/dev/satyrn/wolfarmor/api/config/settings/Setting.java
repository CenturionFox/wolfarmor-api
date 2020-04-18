package dev.satyrn.wolfarmor.api.config.settings;

import dev.satyrn.wolfarmor.api.config.IConfigurationSetting;
import net.minecraft.nbt.NBTBase;
import net.minecraftforge.common.config.Property;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

// This file is based on the configuration system implemented in the Wearable Backpacks mod, (c) 2014-2019 copygirl.
// Licensed under MIT.  Please see THIRDPARTY for license and notices related to the use of this code.
public abstract class Setting<T> implements IConfigurationSetting<T> {
    private final T defaultValue;

    private T value;
    private T synchronizedValue;

    private String category = "";
    private String name = "";
    private String comment = "";

    private boolean isSynchronizedSetting;
    private boolean isCurrentlySynchronized;

    private Property.Type propertyType = Property.Type.STRING;

    public Setting(T defaultValue) {
        this.defaultValue = defaultValue;
    }

    /**
     * Gets the setting's name
     * @return The setting's name
     */
    @Nonnull
    public String getName() { return this.name; }

    /**
     * Sets the name of the setting.  This will be used for localization client-side, and also determine the
     * configuration group that the setting will appear under in the UI and in the configuration file.
     * @param value The new value of the name field
     * @return self
     */
    @Nonnull
    public Setting<T> setName(@Nonnull String value) {
        this.name = value;
        return this;
    }

    /**
     * Gets the setting's category
     * @return The setting's category
     */
    @Nonnull
    public String getCategory() { return this.category; }

    /**
     * Sets the configuration category name.  This determines in which group the config will be classified.
     * @param value The new value for the configuration category
     * @return self
     */
    @Nonnull
    public Setting<T> setCategory(@Nonnull String value) {
        this.category = value;
        return this;
    }

    /**
     * Gets the comment value
     * @return The config setting's comment value
     */
    @Nonnull
    public String getComment() { return this.comment; }

    /**
     * Sets the comment for the config entry
     * @param value The comment's value
     * @return self
     */
    @Nonnull
    public Setting<T> setComment(@Nonnull String value) {
        this.comment = value;
        return this;
    }

    /**
     * Gets the config property base type
     * @return The property base type
     */
    @Nonnull
    public Property.Type getPropertyType() { return this.propertyType; }

    /**
     * Sets the configuration property base type
     * @param type The config property type
     * @return self
     */
    @Nonnull
    public Setting<T> setPropertyType(@Nonnull Property.Type value) {
        this.propertyType = value;
        return this;
    }

    /**
     * Gets the actual value, instead of the default or synchronized values
     * @return The actual value
     */
    @Nullable
    protected T getValue() {
        return this.value;
    }

    /**
     * Sets the value of the configuration setting.
     * @param value The new value for the configuration setting
     * @return self
     */
    @Nonnull
    public Setting<T> setValue(T value) {
        this.value = value;
        return this;
    }


    /**
     * Gets a flag indicating whether or not this setting's value is synchronized from the host to the client instance
     * @return <c>true</c> if synchronization is enabled, otherwise <c>false</c>.
     */
    public boolean getIsSynchronizedSetting() { return this.isSynchronizedSetting; }

    /**
     * Flags this setting as either synchronized between server and client, or unsynchronized.
     * @param value <c>true</c> to mark synchronized, <c>false</c> for unsynchronized values.
     * @return self
     */
    @Nonnull
    public Setting<T> setIsSynchronizedSetting(boolean value) {
        this.isSynchronizedSetting = value;
        return this;
    }

    /**
     * Gets the default value of the setting, regardless of synchronization or current value.
     * @return The default value of the setting.
     */
    @Nullable
    public T getDefaultValue() {
        return this.defaultValue;
    }

    /**
     * The synchronized value for the setting
     * @return The synchronized value, or null if the setting is not a synchronized setting.
     */
    public T getSynchronizedValue() { return this.isSynchronizedSetting ? this.synchronizedValue : null;}

    /**
     * Flag indicating whether or not the setting is currently synchronized to a server's setting value
     * @return If the setting is not a synchronized setting, this getter always returns <c>false</c>. However, for
     * synchronized settings, it will return <c>true</c> if the setting is in a synchronized state.
     */
    public boolean getIsCurrentlySynchronized() { return this.isSynchronizedSetting && this.isCurrentlySynchronized; }

    /**
     * Gets the setting's category concatenated with its name.
     * @return The full name of the setting, consisting of its category and name concatenated with a period.
     */
    @Nonnull
    public String getFullName() { return String.format("%s.%s", this.category, this.name); }

    /**
     * Gets the calculated value of the setting.
     * @return If synchronized, the synchronized value will be returned.  Otherwise, the standard value will be
     * returned. If either the synchronized or standard values are null, the default value is returned.
     */
    @Nullable
    public T getCurrentValue() {
        if (this.isSynchronizedSetting && this.isCurrentlySynchronized) {
            return this.synchronizedValue == null ? this.defaultValue : this.synchronizedValue;
        }
        else {
            return this.value == null ? this.defaultValue : this.value;
        }
    }

    /**
     * Reads the synchronized setting value from an NBT object
     * @param tag The tag
     */
    public void readSynchronized(NBTBase tag) {
        this.isCurrentlySynchronized = true;
        this.synchronizedValue = this.readTag(tag);
    }

    /**
     * Writes the value to an NBTBase tag
     * @return The tag
     */
    public NBTBase writeSynchronized() { return this.writeTag(this.value); }

    /**
     * Loads the setting value from an NBT object.
     * @param tag The NBTBase to read
     */
    public abstract T readTag(NBTBase tag);

    /**
     * Writes the value to a new NBT tag object.
     * @param value The value to write to the NBT tag.
     * @return The newly constructed NBT tag object.
     */
    public abstract NBTBase writeTag(T value);
}
