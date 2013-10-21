package TFC.Blocks.Vanilla;

import java.util.Random;

import TFC.TFCBlocks;
import TFC.API.TFCOptions;
import TFC.Core.TFC_Climate;
import TFC.Tomatomod.TModOptions;
import net.minecraft.block.Block;
import net.minecraft.block.BlockIce;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;

public class BlockCustomIce extends BlockIce
{
    public BlockCustomIce(int par1)
    {
        super(par1);
    }
    
    private void quickUnfreeze(World world, Chunk chunk)
    {
    	if(!world.isRemote)
    	{
    		int chunkX = chunk.xPosition << 4;
    		int chunkZ = chunk.zPosition << 4;
    	
    		for(int x = chunkX; x < (chunkX + 16); x++)
    		{
    			for(int z = chunkZ; z < (chunkZ + 16); z++)
    			{
    				int height = world.getHeightValue(x,z) - 1;
    				
    				if(world.getBlockId(x, height, z) == Block.ice.blockID)
    				{
    					world.setBlock(x, height, z, Block.waterStill.blockID);
    				}
    			}
    		}
    		
    	}
    }

    /**
     * Called when the player destroys a block with an item that can harvest it. (i, j, k) are the coordinates of the
     * block and l is the block's subtype/damage.
     */
    @Override
	public void harvestBlock(World par1World, EntityPlayer par2EntityPlayer, int par3, int par4, int par5, int par6)
    {
        super.harvestBlock(par1World, par2EntityPlayer, par3, par4, par5, par6);
        Material var7 = par1World.getBlockMaterial(par3, par4 - 1, par5);

        if (var7.blocksMovement() || var7.isLiquid())
        {
            par1World.setBlock(par3, par4, par5, Block.waterMoving.blockID, 0, 2);
        }
    }

    /**
     * Ticks the block if it's been scheduled
     */
    @Override
	public void updateTick(World world, int i, int j, int k, Random rand)
    {
        if (!world.canBlockFreeze(i, j, k, false) && TFC_Climate.getHeightAdjustedTemp(i, j, k) >= TModOptions.snowUnfreezeTemp)
        {
            if (world.getBlockId(i, j+1, k) == Block.snow.blockID)
            {
            	int meta = world.getBlockMetadata(i, j+1, k);
            	if (meta > 0) {
            		world.setBlockMetadataWithNotify(i, j+1, k, meta-1, 2);
            	} else {
            		world.setBlockToAir(i, j+1, k);
            	}
            } else {
            	this.dropBlockAsItem(world, i, j, k, world.getBlockMetadata(i, j, k), 0);
            	world.setBlock(i, j, k, Block.waterStill.blockID, 0, 2);
            }
            this.dropBlockAsItem(world, i, j, k, world.getBlockMetadata(i, j, k), 0);
            if(j > 143){
            	world.setBlock(i, j, k, Block.waterMoving.blockID, 0, 2);
            } else {
            	world.setBlock(i, j, k, Block.waterStill.blockID, 0, 2);
            }
            
            if(TFC_Climate.getHeightAdjustedTemp(i, j, k) >= TModOptions.quickSnowUnfreezeTemp)
            	quickUnfreeze(world, world.getChunkFromBlockCoords(i, k));
        }
    }
}
