package TFC.Tomatomod;

import TFC.Blocks.Vanilla.BlockCustomSnow;
import TFC.Tomatomod.Blocks.CustomSnowBlock;
import net.minecraft.block.Block;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class Tomatomod
{

	public static void preInit(FMLPreInitializationEvent event)
	{
		TModOptions.load();
		
	}

	public static void init(FMLInitializationEvent evt)
	{
		Block.blocksList[80] = null;
		
		Block.blocksList[80] = (new CustomSnowBlock(80)).setHardness(0.1F).setStepSound(Block.soundClothFootstep).setUnlocalizedName("snow").setLightOpacity(1);
		
	}

}
