package net.heipiao.fix_quark_3951.mixins;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import vazkii.quark.content.tweaks.module.ReacharoundPlacingModule;

@Mixin(value = ReacharoundPlacingModule.class, remap = false)
public class ReacharoundPlacingModuleMixin {
    @Redirect(method = "onRightClick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/Item;useOn(Lnet/minecraft/world/item/context/UseOnContext;)Lnet/minecraft/world/InteractionResult;"))
    public InteractionResult redirectUseOn(Item instance, UseOnContext p_41427_){
        return p_41427_.getItemInHand().useOn(p_41427_);
    }
}
