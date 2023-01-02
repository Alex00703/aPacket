package fr.alex.plugin;

import org.bukkit.plugin.java.JavaPlugin;

public class APacket extends JavaPlugin {
	
	private static APacket instance;
	private Object packetManager;
	
	private String a = getServer().getClass().getPackage().getName();
	private String version = a.substring(a.lastIndexOf('.') + 1);
	
	@Override
	public void onEnable() {
		instance = this;
				
		if(version.equalsIgnoreCase("v1_7_R4")){
			packetManager = new fr.alex.manager.v1_7_R4.PacketManager();
		}else if(version.equalsIgnoreCase("v1_8_R3")){
			packetManager = new fr.alex.manager.v1_8_R3.PacketManager();
		}else if(version.equalsIgnoreCase("v1_9_R2")){
			packetManager = new fr.alex.manager.v1_9_R2.PacketManager();
		}else if(version.equalsIgnoreCase("v1_10_R1")){
			packetManager = new fr.alex.manager.v1_10_R1.PacketManager();
		}else if(version.equalsIgnoreCase("v1_11_R1")){
			packetManager = new fr.alex.manager.v1_11_R1.PacketManager();
		}else if(version.equalsIgnoreCase("v1_12_R1")){
			packetManager = new fr.alex.manager.v1_12_R1.PacketManager();
		}
		
	}
	
	public String getVersion() {
		return version;
	}

	public static APacket getInstance() {
		return instance;
	}

	public Object getPacketManager() {
		return packetManager;
	}
	
	
	
}
