package fr.alex.manager.v1_7_R4;

import java.io.IOException;

import net.minecraft.server.v1_7_R4.Packet;
import net.minecraft.server.v1_7_R4.PacketDataSerializer;

public abstract class APacket extends Packet {

	@Override
	public void a(PacketDataSerializer arg0) throws IOException {
		readPacketData(arg0);
	}

	@Override
	public void b(PacketDataSerializer arg0) throws IOException {
		writePacketData(arg0);
	}
	
	public abstract void readPacketData(PacketDataSerializer paramPacketDataSerializer) throws IOException;
	  
	public abstract void writePacketData(PacketDataSerializer paramPacketDataSerializer) throws IOException;
	  
}
