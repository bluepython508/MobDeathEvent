package io.github.bluepython508.mobdeathevent.mixin;

import io.github.bluepython508.mobdeathevent.MobDeathEvent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public class MobDeathEventMixin {
    @Inject(method = "onDeath(Lnet/minecraft/entity/damage/DamageSource;)V", at = @At("HEAD"))
    void onDeath(DamageSource source, CallbackInfo ci) {
        MobDeathEvent.INSTANCE.trigger((LivingEntity) (Object) this, source);
    }
}
