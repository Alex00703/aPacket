package fr.alex.manager.v1_7_R4.server;

import java.io.IOException;
import java.util.UUID;

import org.bukkit.craftbukkit.v1_7_R4.inventory.CraftItemStack;

import fr.alex.manager.v1_7_R4.APacket;
import net.minecraft.server.v1_7_R4.PacketDataSerializer;
import net.minecraft.server.v1_7_R4.PacketListener;

public abstract class SPacket extends APacket {

	@Override
	public void readPacketData(PacketDataSerializer paramPacketDataSerializer) throws IOException {}

	@Override
	public void handle(PacketListener arg0) {}
	
	public void writeDouble(PacketDataSerializer data, Double dbl) {data.writeDouble(dbl.doubleValue()); data.a(); }
    public void writeString(PacketDataSerializer data, String msg) throws IOException {data.writeInt(msg.length()); data.a(msg); }
    public void writeUUID(PacketDataSerializer data, UUID uuid) { data.writeUUID(uuid); }
    public void writeItemStackBukkit(PacketDataSerializer data, org.bukkit.inventory.ItemStack is) { data.a(CraftItemStack.asNMSCopy(is)); }


}
