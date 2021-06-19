package io.github.bluepython508.mobdeathevent;

import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;

import java.util.ArrayList;
import java.util.List;

public class MobDeathEvent implements ModInitializer {
    public MobDeathEvent() {
        INSTANCE = this;
    }
    @Override
    public void onInitialize() {}

    public void listen(Callback cb) {
        callbacks.add(cb);
    }

    public void trigger(LivingEntity entity, DamageSource source) {
        callbacks.forEach((cb) -> cb.onEntityDamaged(entity, source));
    }

    @FunctionalInterface
    interface Callback {
        void onEntityDamaged(LivingEntity entity, DamageSource source);
    }

    private final List<Callback> callbacks = new ArrayList<>();

    public static MobDeathEvent INSTANCE;
}
