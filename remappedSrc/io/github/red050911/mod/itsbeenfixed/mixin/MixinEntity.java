package io.github.red050911.mod.itsbeenfixed.mixin;

import io.github.red050911.mod.itsbeenfixed.ItsBeenFixed;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeveledCauldronBlock;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public class MixinEntity {

    @Shadow
    private BlockPos blockPos;
    @Shadow
    public World world;

    @Inject(at = @At("HEAD"), method = "isWet", cancellable = true)
    public void isWet(CallbackInfoReturnable<Boolean> cir) {
        Block blockAtPos = world.getBlockState(blockPos).getBlock();
        if(blockAtPos instanceof LeveledCauldronBlock && blockAtPos.equals(Blocks.WATER_CAULDRON) && world.getGameRules().getBoolean(ItsBeenFixed.ENTITIES_CONSIDERED_WET_IN_CAULDRONS)) {
            cir.setReturnValue(true);
        }
    }



}
