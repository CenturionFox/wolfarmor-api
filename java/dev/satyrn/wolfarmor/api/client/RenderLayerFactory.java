package dev.satyrn.wolfarmor.api.client;

import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public abstract class RenderLayerFactory {

    /**
     * Constructs a new instance of the wolf armor render layer.
     * @param renderer The parent renderer.
     * @return <tt>null</tt> if the class load or instantiation failed; otherwise, a new instance of LayerWolfArmor.
     */
    @Nullable
    public static LayerRenderer<?, ?> createArmorLayer(@Nonnull LivingRenderer<?, ?> renderer) {
        try {
            Class<?> clazz = RenderLayerFactory.class.getClassLoader().loadClass("dev.satyrn.wolfarmor.client.renderer.entity.layer.LayerWolfArmor");
            return (LayerRenderer<?, ?>) clazz.getConstructor(LivingRenderer.class).newInstance(renderer);
        }
        catch(Exception e) {
            return null;
        }
    }

    /**
     * Constructs a new wolf backpack layer renderer object.
     * @param renderer The parent renderer.
     * @return <tt>null</tt> if the class load or instantiation failed; otherwise, a new instance of LayerWolfBackpack.
     */
    @Nullable
    public static LayerRenderer<?, ?> createBackpackLayer(@Nonnull LivingRenderer<?, ?> renderer) {
        try {
            Class<?> clazz = RenderLayerFactory.class.getClassLoader().loadClass("dev.satyrn.wolfarmor.client.renderer.entity.layer.LayerWolfBackpack");
            return (LayerRenderer<?, ?>) clazz.getConstructor(LivingRenderer.class).newInstance(renderer);
        } catch(Exception e) {
            return null;
        }
    }

}
