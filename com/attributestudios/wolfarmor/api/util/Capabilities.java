package com.attributestudios.wolfarmor.api.util;

import com.attributestudios.wolfarmor.api.IWolfArmorCapability;
import com.attributestudios.wolfarmor.api.util.annotation.ApiHelper;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;

/**
 * Contains references to any registered objects in the mod.
 */
public class Registration {

    /**
     * The wolf armor capability instance.
     */
    @CapabilityInject(IWolfArmorCapability.class)
    public static Capability<IWolfArmorCapability> CAPABILITY_WOLF_ARMOR = null;


}
