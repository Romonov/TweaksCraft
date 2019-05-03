package com.romonov.mcmod.tweakscraft.tileEntity;

import com.romonov.mcmod.tweakscraft.block.BlockAccelerateTorch;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fluids.BlockFluidBase;

import java.util.Random;

public class TileEntityAccelerateTorch extends TileEntity implements ITickable {
    private Random rand;
    private int xMin;
    private int yMin;
    private int zMin;
    private int xMax;
    private int yMax;
    private int zMax;
    private Speed speed;
    private Mode mode;
    private Mode cachedMode;

    public TileEntityAccelerateTorch() {
        this.rand = new Random();
        this.speed = Speed.Speed1;
        this.mode = Mode.Radius3x3x3;
        this.cachedMode = Mode.Stopped;
    }

    @Override
    public void update() {
        if (this.mode == Mode.Stopped) {
            return;
        }

        updateCachedModeIfNeeded();
        tickNeighbors();
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        this.mode = Mode.values()[nbt.getInteger("Mode")];
        this.speed = Speed.values()[nbt.getInteger("Speed")];
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
        nbt.setInteger("Mode", this.mode.ordinal());
        nbt.setInteger("Speed", this.speed.ordinal());
        return super.writeToNBT(nbt);
    }

    public void changeMode(boolean isSneaking) {
        if (isSneaking) {
            if (this.speed.ordinal() < Speed.values().length - 1) {
                this.speed = Speed.values()[this.speed.ordinal() + 1];
            } else {
                this.speed = Speed.Speed1;
            }
        } else {
            if (this.mode.ordinal() < Mode.values().length - 1) {
                this.mode = Mode.values()[this.mode.ordinal() + 1];
            } else {
                this.mode = Mode.Stopped;
            }
        }
    }

    private void updateCachedModeIfNeeded()
    {
        if (this.cachedMode != this.mode)
        {
            this.xMin = (getPos().getX() - this.mode.ordinal());
            this.yMin = (getPos().getY() - 1);
            this.zMin = (getPos().getZ() - this.mode.ordinal());
            this.xMax = (getPos().getX() + this.mode.ordinal());
            this.yMax = (getPos().getY() + 1);
            this.zMax = (getPos().getZ() + this.mode.ordinal());
            this.cachedMode = this.mode;
        }
    }

    public String getSpeedChanged() {
        return (this.speed.ordinal() + 1) * 100 + "%";
    }

    public String getModeChanged() {
        switch (this.mode) {
            case Radius3x3x3:
                return "3x3x3";
            case Radius5x3x5:
                return "5x3x5";
            case Radius7x3x7:
                return "7x3x7";
            case Radius9x3x9:
                return "9x3x9";
            case Stopped:
            default:
                return "停止";
        }
    }

    private void tickNeighbors()
    {
        for (int x = this.xMin; x <= this.xMax; x++) {
            for (int y = this.yMin; y <= this.yMax; y++) {
                for (int z = this.zMin; z <= this.zMax; z++) {
                    tickBlock(new BlockPos(x, y, z));
                }
            }
        }
    }

    private void tickBlock(BlockPos pos)
    {
        IBlockState blockState = world.getBlockState(pos);
        Block block = blockState.getBlock();

        if (block instanceof BlockAccelerateTorch
                || block == Blocks.AIR.getDefaultState()
                || block instanceof BlockFluidBase) {
            return;
        }
        if (block.getTickRandomly()) {
            for (int i = 0; i < this.speed.ordinal(); i++)
            {
                if (getWorld().getBlockState(pos) != blockState) {
                    break;
                }
                block.randomTick(getWorld(), pos, blockState, this.rand);
            }
        }
        if (block.hasTileEntity(blockState))
        {
            TileEntity tileEntity = getWorld().getTileEntity(pos);
            if ((tileEntity != null) && (!tileEntity.isInvalid()) && ((tileEntity instanceof ITickable)))
            {
                for (int i = 0; i < this.speed.ordinal(); i++)
                {
                    if (tileEntity.isInvalid()) {
                        break;
                    }
                    ((ITickable)tileEntity).update();
                }
            }
        }
    }

    private enum Speed {
        Speed1,
        Speed2,
        Speed3,
        Speed4
    }

    private enum Mode {
        Stopped,
        Radius3x3x3,
        Radius5x3x5,
        Radius7x3x7,
        Radius9x3x9
    }
}
