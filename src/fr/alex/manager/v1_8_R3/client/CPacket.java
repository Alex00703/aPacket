package fr.alex.manager.v1_8_R3.client;

import java.io.IOException;
import java.util.UUID;

import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;

import fr.alex.manager.v1_8_R3.APacket;
import net.minecraft.server.v1_8_R3.BlockPosition;
import net.minecraft.server.v1_8_R3.ItemStack;
import net.minecraft.server.v1_8_R3.NBTTagCompound;
import net.minecraft.server.v1_8_R3.PacketDataSerializer;

public abstract class CPacket extends APacket {

	@Override
	public void writePacketData(PacketDataSerializer paramPacketDataSerializer) throws IOException {}
	
	public String readString(PacketDataSerializer data) {int stringLength = data.readInt();return data.c(stringLength);}
	public byte[] readByteArray(PacketDataSerializer data) { return data.a(); }
	public UUID readUUID(PacketDataSerializer data) { return data.g(); }
	public BlockPosition readBlockPosition(PacketDataSerializer data) { return data.c(); }
	public int[] readBlockPositionBukkit(PacketDataSerializer data) {BlockPosition pos = readBlockPosition(data);return new int[] { pos.getX(), pos.getY(), pos.getZ() };}
	public ItemStack readItemStack(PacketDataSerializer data) throws IOException { return data.i(); }
	public org.bukkit.inventory.ItemStack readItemStackBukkit(PacketDataSerializer data) throws IOException { return CraftItemStack.asBukkitCopy(readItemStack(data)); }
	public NBTTagCompound readNBTTagCompound(PacketDataSerializer data) throws IOException { return data.h(); }

	
}
