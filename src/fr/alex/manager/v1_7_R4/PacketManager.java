package fr.alex.manager.v1_7_R4;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import net.minecraft.server.v1_7_R4.EnumProtocol;
import net.minecraft.server.v1_7_R4.Packet;
import net.minecraft.server.v1_7_R4.PlayerConnection;
import net.minecraft.util.com.google.common.collect.BiMap;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class PacketManager
{
	  public List<CustomPacket> packets = new ArrayList();
	  
	  public static void sendPacket(Player player, Packet packet) {
		  PlayerConnection packetHandler = (((CraftPlayer)player).getHandle()).playerConnection;
		  packetHandler.sendPacket(packet);
	  }
	  
	  public void registerPacket(int packetId, Packet packet) {
		  CustomPacket p = new CustomPacket(packetId, packet);
		  this.packets.add(p);
	  }
	  
	  public void registerPackets() {
		  try {
			  for (CustomPacket packet : this.packets) {
				  Packet p = packet.getPacket();
				  int packetId = packet.getId();
			        
				  Class<EnumProtocol> clazz = EnumProtocol.class;
				  Field f = null;
				  BiMap<Integer, Class<?>> packetsMap = null;
			        
				  f = p.getClass().getName().contains("CPacket") ? clazz.getDeclaredField("h") : clazz.getDeclaredField("i");
				  f.setAccessible(true);
				  packetsMap = (BiMap)f.get(EnumProtocol.PLAY);
				  packetsMap.put(Integer.valueOf(packetId), p.getClass());
			      		      
				  Field f2 = EnumProtocol.class.getDeclaredField("f");
				  f2.setAccessible(true);
				  Map<Class<?>, EnumProtocol> map = (Map)f2.get(EnumProtocol.PLAY);
				  map.put(p.getClass(), EnumProtocol.PLAY);
		        
			  } 
		  } catch (Exception e) {
			  e.printStackTrace();
		  } 
	  }
}
