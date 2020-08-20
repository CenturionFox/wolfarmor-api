package dev.satyrn.wolfarmor.api.compatibility.client;

import dev.satyrn.wolfarmor.api.compatibility.IProvider;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Overrides the armor or backpack layer renders for a wolf.
 * @author Isabel Maskrey (satyrnidae)
 * @since 4.5.0-alpha
 */
@SideOnly(Side.CLIENT)
public abstract class LayerProvider implements IProvider {

    /**
     * Checks whether or not the provider provides an armor layer.
     * @return {@code false} by default, if not respecified as {@code true} this provider will not be used for armor
     *         layers
     * @since 4.5.0-alpha
     */
    public boolean getProvidesArmorLayer() { return false; }

    /**
     * Checks whether or not the provider provides a backpack layer
     * @return {@code false} by default, if not respecified as {@code true} this provider will not be used for armor
     *         layers
     * @since 4.5.0-alpha
     */
    public boolean getProvidesBackpackLayer() { return false; }

    /**
     * Checks whether or not this provider can provide layers for a given entity class
     * @param entityClass The entity class to check
     * @return {@code true} if the provider can provide layers for the type
     * @since 4.5.0-alpha
     */
    public boolean validForClass(@Nonnull Class<?> entityClass) {
        return EntityWolf.class.isAssignableFrom(entityClass);
    }

    /**
     * Returns the custom armor layer for this provider
     * @param entityRenderer The entity renderer
     * @return A new layer renderer
     * @since 4.5.0-alpha
     */
    @Nullable
    public LayerRenderer<?> getArmorLayer(@Nonnull RenderLiving<?> entityRenderer) {
        return null;
    }

    /**
     * Returns the custom backpack layer for this provider
     * @param entityRenderer The entity renderer
     * @return A new layer renderer
     * @since 4.5.0-alpha
     */
    @Nullable public LayerRenderer<?> getBackpackLayer(@Nonnull RenderLiving<?> entityRenderer) {
        return null;
    }
}
