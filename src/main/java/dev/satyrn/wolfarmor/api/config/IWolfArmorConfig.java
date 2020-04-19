package dev.satyrn.wolfarmor.api.config;

import dev.satyrn.wolfarmor.api.util.WolfInventorySize;
import net.minecraftforge.fml.relauncher.Side;

public interface IWolfArmorConfig {
    /**
     * Checks if wolf chests are enabled or disabled
     * @return <c>true</c> if wolf chests are enabled, <c>false</c> if they are disabled.
     */
    boolean getChestEnabled();

    /**
     * Checks if untamed wolves should howl at the full moon when untamed
     * @return <c>true</c> if they should howl, <c>false</c> otherwise
     */
    boolean getHowlAtMoonEnabled();

    /**
     * Checks whether or not wolves should eat food present in their inventory
     * @return <c>true</c> if wolves should auto-heal, <c>false</c> if not
     */
    boolean getAutoHealEnabled();

    /**
     * Checks if the armor layers should be rendered
     * @return <c>true</c> if the armor layers should be rendered, <c>false</c> otherwise
     */
    boolean getArmorRendered();

    /**
     * Checks if the chest model should be rendered
     * @return <c>true</c> if the chests should be rendered; otherwise, <c>false</c>
     */
    boolean getChestRendered();

    /**
     * Checks if the wolf's health should be displayed in the GUI
     * @return <c>true</c> if the health should be displayed; otherwise, <c>false</c>
     */
    boolean getHealthInGui();

    /**
     * Checks if the wolf's equipped armor level should be displayed in the GUI
     * @return <c>true</c> if the armor should be displayed; otherwise, <c>false</c>
     */
    boolean getArmorInGui();

    /**
     * Gets the current configured wolf chest size
     * @return The current configured wolf chest size
     */
    WolfInventorySize getChestSize();

    /**
     * Initializes the config file and directory
     * @param configDirectory The path to the directory where the config file is stored
     */
    void initialize(String configDirectory);

    /**
     * Loads the settings from the configuration file
     * @param side The thread side which is currently being loaded
     */
    void loadFromConfiguration(Side side);

    /**
     * Saves the current settings to the configuration file
     */
    void saveToConfiguration(Side side);
}
