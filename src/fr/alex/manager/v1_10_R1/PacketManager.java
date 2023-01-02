package fr.alex.manager.v1_10_R1;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.bukkit.craftbukkit.v1_10_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import com.google.common.collect.BiMap;

import net.minecraft.server.v1_10_R1.EnumProtocol;
import net.minecraft.server.v1_10_R1.EnumProtocolDirection;
import net.minecraft.server.v1_10_R1.Packet;
import net.minecraft.server.v1_10_R1.PlayerConnection;

public class PacketManager {
	
	private List<CustomPacket> packets = new ArrayList<>();
	
	public void registerPacket(int id, Packet packet) {
		CustomPacket customPacket = new CustomPacket(id, packet);
		this.packets.add(customPacket);
	}
	
	public void registerPackets() {
		try {
			for (CustomPacket packet : this.packets) {
				Packet p = packet.getPacket();
		        int packetId = packet.getId();
		        
				final EnumProtocol protocol = EnumProtocol.PLAY;
				final EnumProtocolDirection direction = p.getClass().getName().contains("CPacket") ? EnumProtocolDirection.SERVERBOUND : EnumProtocolDirection.CLIENTBOUND;
				
				Field j = EnumProtocol.class.getDeclaredField("h"); j.setAccessible(true);
				Map<EnumProtocolDirection, BiMap<Integer, Class<? extends Packet>>> map = (Map<EnumProtocolDirection, BiMap<Integer, Class<? extends Packet>>>) j.get(protocol);				
				
				BiMap<Integer, Class<? extends Packet>> biMap = (BiMap)map.get(direction);
				biMap.put(packetId, p.getClass());
				map.put(direction, biMap);
								
				Field h = EnumProtocol.class.getDeclaredField("f"); h.setAccessible(true);
			    Map<Class<?>, EnumProtocol> protocols = (Map) h.get(protocol);
			    protocols.put(p.getClass(), protocol);
				
			} 
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public static void sendPacket(Player player, Packet packet) {
		PlayerConnection packetHandler = (((CraftPlayer)player).getHandle()).playerConnection;
		packetHandler.sendPacket(packet);
	}

}
