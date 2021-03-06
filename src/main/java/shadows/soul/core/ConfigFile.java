package shadows.soul.core;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import shadows.soul.proxy.CommonProxy;

public class ConfigFile {

	public static int shardValue = 9;  // valid 1-9
	public static boolean enableLava = true; //enable Lava Immolation
	public static boolean enableBlaze = true; //enable Blaze Immolation
	public static int shardDropChance = 1; // 1/n
	public static int extraWitherSkeletons = 0; //+n skeletons per spawn event
	public static boolean extraSpawns = false;
	public static boolean allowAllBiomes = false;
	public static boolean delSwords = true; //name

	public static void syncConfig() { // Gets called from preInit
	    try {
	        // Load config
	    	CommonProxy.config.load();

	        // Read props from config
	        Property PShardValue = CommonProxy.config.get(Configuration.CATEGORY_GENERAL, // What category will it be saved to, can be any string
	                "Shard Value", // Property name
	                "9", // Default value
	                "The value of a skull fragment, in terms of 1/n (How many shards per skull) Valid values are 1-9",
	                Property.Type.INTEGER); // Comment
	        Property PEnableLava = CommonProxy.config.get(Configuration.CATEGORY_GENERAL, // What category will it be saved to, can be any string
	                "Enable Lava Immolation Blade", // Property name
	                "true", // Default value
	                "If the Immolation Blade (Lava) is enabled",
	                Property.Type.BOOLEAN); // Comment
	        Property PEnableBlaze = CommonProxy.config.get(Configuration.CATEGORY_GENERAL, // What category will it be saved to, can be any string
	                "Enable Blaze Immolation Blade", // Property name
	                "true", // Default value
	                "If the Immolation Blade (Blaze) is enabled",
	                Property.Type.BOOLEAN); // Comment
	        Property PShardDropChance = CommonProxy.config.get(Configuration.CATEGORY_GENERAL, // What category will it be saved to, can be any string
	                "Fragment Drop Chance", // Property name
	                "1", // Default value
	                "The wither skull fragment drop chance in 1/n.  Higher numbers means less drops.",
	                Property.Type.INTEGER); // Comment
	        Property PExtraWitherSkeletons = CommonProxy.config.get(Configuration.CATEGORY_GENERAL, // What category will it be saved to, can be any string
	                "Extra Wither Skeletons", // Property name
	                "0", // Default value
	                "How many extra wither skeletons are spawned when one would be.",
	                Property.Type.INTEGER); // Comment
	        Property PExtraSpawns = CommonProxy.config.get(Configuration.CATEGORY_GENERAL, // What category will it be saved to, can be any string
	                "Extra Spawns", // Property name
	                "false", // Default value
	                "If, when a blaze or pigman spawns on Nether Brick, a wither skeleton spawns with it.",
	                Property.Type.BOOLEAN); 
	        Property PAllBiomes = CommonProxy.config.get(Configuration.CATEGORY_GENERAL, // What category will it be saved to, can be any string
	                "All Biomes", // Property name
	                "false", // Default value
	                "If ALL skeletons in any Biome are turned into Wither Skeletons.",
	                Property.Type.BOOLEAN); 
	        Property PDelSwords = CommonProxy.config.get(Configuration.CATEGORY_GENERAL, // What category will it be saved to, can be any string
	                "Delete Stone Swords", // Property name
	                "true", // Default value
	                "Whether or not to remove stone swords from wither skeleton drops.",
	                Property.Type.BOOLEAN); 
	        
	        	shardValue = PShardValue.getInt();
	        	enableLava = PEnableLava.getBoolean();
	        	enableBlaze = PEnableBlaze.getBoolean();
	        	shardDropChance = PShardDropChance.getInt();
	        	extraWitherSkeletons = PExtraWitherSkeletons.getInt();
	        	extraSpawns = PExtraSpawns.getBoolean();
	        	allowAllBiomes = PAllBiomes.getBoolean();
	        	delSwords = PDelSwords.getBoolean();
	    } catch (Exception e) {
	        // Failed reading/writing, just continue
	    } finally {
	        // Save props to config IF config changed
	        if (CommonProxy.config.hasChanged()) CommonProxy.config.save();
	    }
	}
	
	
}
