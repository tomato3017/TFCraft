package TFC.Tomatomod.Blocks;

import java.util.Random;

import TFC.Blocks.Vanilla.BlockCustomSnow;
import TFC.Core.TFC_Climate;
import TFC.Tomatomod.TModOptions;
import TFC.Tomatomod.TModRef;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSnowBlock;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

public class CustomSnowBlock extends BlockSnowBlock 
{

	public CustomSnowBlock(int par1)
	{
		super(par1);
	}
	
	@Override
	public void updateTick(World world, int x, int y, int z,
			Random par5Random)
	{
		float temperature = TFC_Climate.getHeightAdjustedTemp(x, y, z);
		if(temperature > TModRef.SNOW_LAYER1 && world.canBlockSeeTheSky(x, y, z))
		{
			world.setBlock(x, y, z, Block.snow.blockID, 14, 3);
		}
	}

}
