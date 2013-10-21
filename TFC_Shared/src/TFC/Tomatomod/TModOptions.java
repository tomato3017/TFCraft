package TFC.Tomatomod;

import java.io.File;

import TFC.TerraFirmaCraft;
import net.minecraftforge.common.Configuration;

public class TModOptions 
{
	
	//True/False settings
	public static boolean quickSnowUnfreeze = true;
	public static boolean cheapPowderKegRecipe = true; 
	public static boolean allowSluiceGems = false;
	
	//Parameters
	public static float quickSnowUnfreezeTemp = 5.0F;
	public static float snowUnfreezeTemp = 2.0F; //TODO: Hook to config
	
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
		snowUnfreezeTemp = (float) config.get("parameters", "SnowUnfreezeTemp", (double) snowUnfreezeTemp, "This allows for a snow and ice to melt higher then it freezes, for performance. Set to 0 to disable.")
												.getDouble((double) snowUnfreezeTemp);
		
		cheapPowderKegRecipe = config.get("general", "CheapPowderKegRecipe", cheapPowderKegRecipe, "Only requires 128 gunpowder if enabled")
									 .getBoolean(cheapPowderKegRecipe);
		allowSluiceGems = config.get("general", "AllowSluiceGems", allowSluiceGems, "If disabled, gems will not spawn on sluices")
								.getBoolean(allowSluiceGems);
		
		if(config != null) config.save();
	}
}
