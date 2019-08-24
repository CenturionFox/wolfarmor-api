package dev.satyrn.wolfarmor.api.config;

import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import javax.annotation.Nonnull;

public interface IConfiguration {
    void initializeConfig(FMLPreInitializationEvent preInitEvent);

    boolean getIsWolfChestEnabled();
    boolean getIsWolfArmorRenderEnabled();
    boolean getIsWolfChestRenderEnabled();
    boolean getIsWolfArmorDisplayEnabled();
    boolean getIsWolfHealthDisplayEnabled();
    boolean getAreHowlingUntamedWolvesEnabled();
    boolean getShouldWolvesEatWhenDamaged();
    int getWolfChestSizeHorizontal();
    int getWolfChestSizeVertical();

    @Nonnull
    Property getSettingWolfChestsEnabled();

    @Nonnull
    Property getSettingWolfArmorRenderEnabled();

    @Nonnull
    Property getSettingWolfChestRenderEnabled();

    @Nonnull
    Property getSettingWolfArmorDisplayEnabled();

    @Nonnull
    Property getSettingWolfHealthDisplayEnabled();

    @Nonnull
    Property getSettingHowlingUntamedWolvesEnabled();

    @Nonnull
    Property getSettingWolvesEatWhenDamaged();

    @Nonnull
    Property getSettingWolfChestSizeHorizontal();

    @Nonnull
    Property getSettingWolfChestSizeVertical();
}
