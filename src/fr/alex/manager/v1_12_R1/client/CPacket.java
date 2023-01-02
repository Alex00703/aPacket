package fr.alex.manager.v1_12_R1.client;

import java.io.IOException;
import java.util.UUID;

import org.bukkit.craftbukkit.v1_12_R1.inventory.CraftItemStack;

import fr.alex.manager.v1_12_R1.APacket;
import net.minecraft.server.v1_12_R1.BlockPosition;
import net.minecraft.server.v1_12_R1.ItemStack;
import net.minecraft.server.v1_12_R1.NBTTagCompound;
import net.minecraft.server.v1_12_R1.PacketDataSerializer;

public abstract class CPacket extends APacket {

	@Override
	public void writePacketData(PacketDataSerializer paramPacketDataSerializer) throws IOException {}
	
	public String readString(PacketDataSerializer data) {int stringLength = data.readInt(); return data.e(stringLength);}
	public byte[] readByteArray(PacketDataSerializer data) { return data.a(); }
	public UUID readUUID(PacketDataSerializer data) { return data.i(); }
	public BlockPosition readBlockPosition(PacketDataSerializer data) { return data.e(); }
	public int[] readBlockPositionBukkit(PacketDataSerializer data) {BlockPosition pos = readBlockPosition(data);return new int[] { pos.getX(), pos.getY(), pos.getZ() };}
	public ItemStack readItemStack(PacketDataSerializer data) throws IOException { return data.k(); }
	public org.bukkit.inventory.ItemStack readItemStackBukkit(PacketDataSerializer data) throws IOException { return CraftItemStack.asBukkitCopy(readItemStack(data)); }
	public NBTTagCompound readNBTTagCompound(PacketDataSerializer data) throws IOException { return data.j(); }

	
}
