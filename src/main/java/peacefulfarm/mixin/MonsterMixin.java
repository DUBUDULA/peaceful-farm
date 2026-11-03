package peacefulfarm.mixin;

import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Silverfish;
import net.minecraft.world.entity.monster.zombie.Zombie;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Monster.class)
public abstract class MonsterMixin {

    @Inject(method = "shouldDespawnInPeaceful", at = @At("HEAD"), cancellable = true)
    private void peacefulfarm$keepFarmMobs(CallbackInfoReturnable<Boolean> cir) {
        Object self = this;
        if (self instanceof Zombie || self instanceof Silverfish) {
            cir.setReturnValue(false);
        }
    }
}
