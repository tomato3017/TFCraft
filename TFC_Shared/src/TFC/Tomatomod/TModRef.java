package TFC.Tomatomod;

import TFC.Reference;

public class TModRef 
{
	
	public static final int MAJOR_VERSION = 1;
	public static final int MINOR_VERSION = 0;
	public static final int REVISION_VERSION = 0;
	
	public static final String MOD_NAME = "Tomatomod";
	public static final String VERSION_STRING = String.format("%s v%s.%s.%s", MOD_NAME, MAJOR_VERSION, MINOR_VERSION, REVISION_VERSION);
	
	private static String modMessage = null;
	public static String getModMessage()
	{
		if(modMessage == null)
			modMessage = String.format("TFC v%s-%s", Reference.ModVersion, VERSION_STRING);
		
		return modMessage;
	}
}
