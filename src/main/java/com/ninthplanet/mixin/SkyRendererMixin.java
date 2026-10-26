package com.ninthplanet.mixin;

import com.ninthplanet.sky.CelestialBodyRenderer;
import net.minecraft.client.render.WorldRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/** Хук рендера неба: добавляет наши светила. */
@Mixin(WorldRenderer.class)
public class SkyRendererMixin {
    @Inject(method = "renderSky", at = @At("TAIL"))
    private void ninthplanet$renderCustomCelestials(net.minecraft.client.render.RenderTickCounter counter, CallbackInfo ci) {
        //TODO: в измерении ninthplanet:planet — вызвать CelestialBodyRenderer
    }
}
