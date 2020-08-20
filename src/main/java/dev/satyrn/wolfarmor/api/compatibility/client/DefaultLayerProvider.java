package dev.satyrn.wolfarmor.api.compatibility.client;

import dev.satyrn.wolfarmor.api.util.Resources;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.LogManager;

import javax.annotation.Nonnull;
import java.lang.reflect.InvocationTargetException;

/**
 * Low priority basic layer provider for EntityWolf
 * @author Isabel Maskrey (satyrnidae)
 * @since 4.5.0-alpha
 */
@SideOnly(Side.CLIENT)
public final class DefaultLayerProvider extends LayerProvider {

    /**
     * This instance provides a backpack layer
     * @return {@code true}
     */
    @Override
    public boolean getProvidesArmorLayer() {
        return true;
    }

    /**
     * This instance provides a backpack layer
     * @return {@code true}
     */
    @Override
    public boolean getProvidesBackpackLayer() {
        return true;
    }

    /**
     * Returns the custom armor layer for this provider
     * @param entityRenderer The entity renderer
     * @return A new layer renderer
     * @since 4.5.0-alpha
     */
    @Override
    public LayerRenderer<?> getArmorLayer(@Nonnull RenderLiving<?> entityRenderer) {
        try {
            Class<?> layerClass = this.getClass().getClassLoader().loadClass("dev.satyrn.wolfarmor.client.renderer.entity.layer.LayerWolfArmor" );
            return (LayerRenderer<?>)layerClass.getConstructor(RenderLiving.class).newInstance(entityRenderer);
        } catch (InstantiationException | IllegalArgumentException | IllegalAccessException
                | InvocationTargetException | ExceptionInInitializerError | NoSuchMethodException
                | SecurityException | ClassCastException | ClassNotFoundException ex) {
            LogManager.getLogger(Resources.MOD_ID).error(ex);
            return null;
        }
    }

    /**
     * Returns the custom armor layer for this provider
     * @param entityRenderer The entity renderer
     * @return A new layer renderer
     * @since 4.5.0-alpha
     */
    @Override
    public LayerRenderer<?> getBackpackLayer(@Nonnull RenderLiving<?> entityRenderer) {
        try {
            Class<?> layerClass = LayerProvider.class.getClassLoader().loadClass( "dev.satyrn.wolfarmor.client.renderer.entity.layer.LayerWolfBackpack");
            return (LayerRenderer<?>)layerClass.getConstructor(RenderLiving.class).newInstance(entityRenderer);
        } catch (InstantiationException | IllegalArgumentException | IllegalAccessException
                | InvocationTargetException | ExceptionInInitializerError | NoSuchMethodException
                | SecurityException | ClassCastException | ClassNotFoundException ex) {
            LogManager.getLogger(Resources.MOD_ID).error(ex);
            return null;
        }
    }
}
