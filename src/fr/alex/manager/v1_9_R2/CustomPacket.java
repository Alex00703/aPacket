package fr.alex.manager.v1_9_R2;

import net.minecraft.server.v1_10_R1.Packet;

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
