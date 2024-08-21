package diacritics.owo.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.IllagerEntity;
import net.minecraft.entity.passive.MerchantEntity;
import org.spongepowered.asm.mixin.Mixin;
import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;

@Mixin(IllagerEntity.class)
public class IllagerEntityMixin {
	@WrapMethod(method = "canTarget")
	public boolean canTarget(LivingEntity target, Operation<Boolean> original) {
		if (target instanceof MerchantEntity && target.isBaby())
			return true;

		return original.call(target);
	}
}
