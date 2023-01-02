package fr.alex.manager.v1_12_R1.server;

import java.io.IOException;
import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_12_R1.inventory.CraftItemStack;

import fr.alex.manager.v1_12_R1.APacket;
import net.minecraft.server.v1_12_R1.BlockPosition;
import net.minecraft.server.v1_12_R1.ItemStack;
import net.minecraft.server.v1_12_R1.PacketDataSerializer;
import net.minecraft.server.v1_12_R1.PacketListener;

public abstract class SPacket extends APacket {

    @Override
	public void handle(PacketListener listener) {}
	  
	@Override
	public void readPacketData(PacketDataSerializer data) throws IOException {}
	 
	public void writeDouble(PacketDataSerializer data, Double dbl) {data.writeDouble(dbl.doubleValue()); data.a(); }
    public void writeString(PacketDataSerializer data, String msg) throws IOException {data.writeInt(msg.length()); data.a(msg); }
    public void writeUUID(PacketDataSerializer data, UUID uuid) { data.a(uuid); }
    public void writeItemStack(PacketDataSerializer data, ItemStack is) { data.a(is); }
    public void writeItemStackBukkit(PacketDataSerializer data, org.bukkit.inventory.ItemStack is) { writeItemStack(data, CraftItemStack.asNMSCopy(is)); }
    public void writeBlockPosition(PacketDataSerializer data, BlockPosition pos) { data.a(pos); }
    public void writeBlockPosition(PacketDataSerializer data, Location loc) { writeBlockPosition(data, new BlockPosition(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ())); }
    public void writeEnum(PacketDataSerializer data, Enum<?> in) { data.a(in); }
    public void writeByteArray(PacketDataSerializer data, byte... bytes) { data.a(bytes); }
}
