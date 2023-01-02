package fr.alex.manager.v1_7_R4;

import net.minecraft.server.v1_7_R4.Packet;

public class CustomPacket {
	
	int id;
	Packet packet;
	
	public CustomPacket(int id, Packet packet) {
		this.id = id;
		this.packet = packet;
	}

	public int getId() {
		return id;
	}

	public Packet getPacket() {
		return packet;
	}

}
