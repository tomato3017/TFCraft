package TFC.Tomatomod;

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
		// TODO Auto-generated method stub
		
	}

}
