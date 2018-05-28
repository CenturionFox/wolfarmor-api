package com.attributestudios.wolfarmor.api.client;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@SideOnly(Side.CLIENT)
public abstract class RenderLayerFactory {

    /**
     * Constructs a new instance of the wolf armor render layer.
     * @param renderLiving The parent renderer.
     * @return <tt>null</tt> if the class load or instantiation failed; otherwise, a new instance of LayerWolfArmor.
     */
    @SuppressWarnings("unchecked")
    @Nullable
    public static LayerRenderer createArmorLayer(@Nonnull RenderLiving renderLiving) {
        try {
            Class clazz = RenderLayerFactory.class.getClassLoader().loadClass("com.attributestudios.wolfarmor.client.renderer.entity.layer.LayerWolfArmor");
            return (LayerRenderer) clazz.getConstructor(RenderLiving.class).newInstance(renderLiving);
        }
        catch(Exception e) {
            return null;
        }
    }

    /**
     * Constructs a new wolf backpack layer renderer object.
     * @param renderLiving The parent renderer.
     * @return <tt>null</tt> if the class load or instantiation failed; otherwise, a new instance of LayerWolfBackpack.
     */
    @SuppressWarnings("unchecked")
    @Nullable
    public static LayerRenderer createBackpackLayer(@Nonnull RenderLiving renderLiving) {
        try {
            Class clazz = RenderLayerFactory.class.getClassLoader().loadClass("com.attributestudios.wolfarmor.client.renderer.entity.layer.LayerWolfBackpack");
            return (LayerRenderer) clazz.getConstructor(RenderLiving.class).newInstance(renderLiving);
        } catch(Exception e) {
            return null;
        }
    }

}
