package com.romonov.mcmod.tweakscraft.block;

import com.romonov.mcmod.tweakscraft.tileEntity.TileEntityAccelerateTorch;
import net.minecraft.block.BlockTorch;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

public class BlockAccelerateTorch extends BlockTorch implements ITileEntityProvider {
    public BlockAccelerateTorch() {
        super();
        setLightLevel(3.0F);
    }

    @Override
    public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        return;
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityAccelerateTorch();
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand,
                                    EnumFacing side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            TileEntity tileEntity = world.getTileEntity(pos);
            if (hand != EnumHand.MAIN_HAND) {
                return false;
            }
            if (!(tileEntity instanceof TileEntityAccelerateTorch)) {
                return false;
            }
            TileEntityAccelerateTorch accelerateTorch = (TileEntityAccelerateTorch) tileEntity;
            accelerateTorch.changeMode(player.isSneaking());
            if (player.isSneaking()) {
                player.sendMessage(new TextComponentString(I18n.format("message.speed_changed") + accelerateTorch.getSpeedChanged()));
            } else {
                player.sendMessage(new TextComponentString(I18n.format("message.mode_changed") + accelerateTorch.getModeChanged()));
            }
        }
        return false;
    }
}
