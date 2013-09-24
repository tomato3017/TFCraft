package TFC.Tomatomod;

import java.io.File;

import TFC.TerraFirmaCraft;
import net.minecraftforge.common.Configuration;

public class TModOptions 
{
	
	//True/False settings
	public static boolean quickSnowUnfreeze = true;
	
	//Parameters
	public static float quickSnowUnfreezeTemp = 5.0F; 
	
	public static void load()
	{
		Configuration config = null;
		try
		{
			config = new Configuration(new File(TerraFirmaCraft.proxy.getMinecraftDir(), "/config/TFCTomatomod.cfg"));
			config.load();
		}
		catch(Exception e)
		{
			System.out.println(String.format("[%s] Exception loading config! Message: %s", TModRef.MOD_NAME, e.getMessage()));
			e.printStackTrace();
		}
		
		quickSnowUnfreeze = config.get("general", "QuickSnowUnfreeze", quickSnowUnfreeze).getBoolean(quickSnowUnfreeze);
		quickSnowUnfreezeTemp = (float) config.get("parameters", "QuickSnowUnfreezeTemp", (double) quickSnowUnfreezeTemp)
												.getDouble((double) quickSnowUnfreezeTemp);
	}
}
