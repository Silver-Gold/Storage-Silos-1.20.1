package net.silvergold.storagesilos.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class CustomCheeseBlock extends Block {
    public CustomCheeseBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {

        ItemStack itemInHand = pPlayer.getItemInHand(pHand);

        if ((itemInHand.isEmpty() && (pPlayer.getFoodData().needsFood() || pPlayer.isCreative()))) {

            pLevel.playSound(pPlayer, pPos, SoundEvents.GENERIC_EAT, SoundSource.BLOCKS, 1f, 1f);
            pLevel.destroyBlock(pPos, false, pPlayer);

            pPlayer.getFoodData().eat(2, 2.0F);

            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }
}
