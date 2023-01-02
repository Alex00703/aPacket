package fr.alex.manager.v1_9_R2;

import java.io.IOException;

import net.minecraft.server.v1_9_R2.Packet;
import net.minecraft.server.v1_9_R2.PacketDataSerializer;
import net.minecraft.server.v1_9_R2.PacketListener;

public abstract class APacket implements Packet {

	@Override
	public void a(PacketDataSerializer arg0) throws IOException {
		readPacketData(arg0);
	}

	@Override
	public void b(PacketDataSerializer arg0) throws IOException {
		writePacketData(arg0);
	}
	
	@Override
	public void a(PacketListener listener) { 
		handle(listener); 
	}
	
	public abstract void readPacketData(PacketDataSerializer paramPacketDataSerializer) throws IOException;
	  
	public abstract void writePacketData(PacketDataSerializer paramPacketDataSerializer) throws IOException;
	
	public abstract void handle(PacketListener paramPacketListener);

}