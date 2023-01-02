package fr.alex.manager.v1_8_R3;

import net.minecraft.server.v1_8_R3.Packet;

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
