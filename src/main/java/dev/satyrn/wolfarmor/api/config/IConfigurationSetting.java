package dev.satyrn.wolfarmor.api.config;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

// This file is based on the configuration system implemented in the Wearable Backpacks mod, (c) 2014-2019 copygirl.
// Licensed under MIT.  Please see THIRDPARTY for license and notices related to the use of this code.
/**
 * Provides default implementation methods for configuration setting instances
 * @param <T>
 */
public interface IConfigurationSetting<T> {
    /**
     * Gets the configuration property for the setting
     * @param config The configuration from which to load the property
     * @return The property object
     */
    @Nonnull
    Property getConfigurationProperty(@Nonnull Configuration config);

    /**
     * Gets the setting's category concatenated with its name.
     * @return The full name of the setting, consisting of its category and name concatenated with a period.
     */
    @Nonnull
    String getFullName();

    /**
     * Gets the default value of the setting, regardless of synchronization or current value.
     * @return The default value of the setting.
     */
    @Nullable
    T getDefaultValue();

    /**
     * The synchronized value for the setting
     * @return The synchronized value, or null if the setting is not a synchronized setting.
     */
    @Nullable
    T getSynchronizedValue();

    /**
     * Gets the calculated value of the setting.
     * @return If synchronized, the synchronized value will be returned.  Otherwise, the standard value will be
     * returned. If either the synchronized or standard values are null, the default value is returned.
     */
    @Nullable
    T getCurrentValue();

    /**
     * Sets the value of the configuration setting.
     * @param value The new value for the configuration setting
     * @return self
     */
    @Nonnull
    IConfigurationSetting<T> setValue(@Nullable T value);

    /**
     * Gets the setting's name
     * @return The setting's name
     */
    @Nonnull
    String getName();

    /**
     * Sets the name of the setting.  This will be used for localization client-side, and also determine the
     * configuration group that the setting will appear under in the UI and in the configuration file.
     * @param value The new value of the name field
     * @return self
     */
    @Nonnull
    IConfigurationSetting<T> setName(@Nonnull String value);

    /**
     * Gets the setting's category
     * @return The setting's category
     */
    @Nonnull
    String getCategory();

    /**
     * Sets the configuration category name.  This determines in which group the config will be classified.
     * @param value The new value for the configuration category
     * @return self
     */
    @Nonnull
    IConfigurationSetting<T> setCategory(@Nonnull String value);

    /**
     * Gets the comment value
     * @return The config setting's comment value
     */
    @Nonnull
    String getComment();

    /**
     * Sets the comment for the config entry
     * @param value The comment's value
     * @return self
     */
    @Nonnull
    IConfigurationSetting<T> setComment(@Nonnull String value);

    /**
     * Gets the config property base type
     * @return The property base type
     */
    @Nonnull
    Property.Type getPropertyType();

    /**
     * Sets the configuration property base type
     * @param value The config property type
     * @return self
     */
    @Nonnull
    IConfigurationSetting<T> setPropertyType(@Nonnull Property.Type value);

    /**
     * Gets a flag indicating whether or not this setting's value is synchronized from the host to the client instance
     * @return <c>true</c> if synchronization is enabled, otherwise <c>false</c>.
     */
    boolean getIsSynchronizedSetting();

    /**
     * Flags this setting as either synchronized between server and client, or unsynchronized.
     * @param value <c>true</c> to mark synchronized, <c>false</c> for unsynchronized values.
     * @return self
     */
    @Nonnull
    IConfigurationSetting<T> setIsSynchronizedSetting(boolean value);

    /**
     * Loads the setting from the configuration file
     */
    void loadFromConfiguration(@Nonnull Configuration config);

    /**
     * Saves the value for the setting to the configuration file
     */
    void saveToConfiguration(@Nonnull Configuration config);

    /**
     * Parses a string value into the setting value type
     * @param value The value to parse
     * @return The parsed setting value
     */
    @Nonnull
    T parse(String value);
}
