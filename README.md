# aPacket (1.7.10 -> 1.12.2)

aPacket est une librairie simple à utiliser qui va vous permettre d'enregistrer et d'envoyer simplement des packets custom pour votre client.
Fonctionne avec toutes les versions de MCP ( ⚠️ ne comprend pas MCP-Reborn ⚠️ )

# Installation

Dans votre class principale vous allez créer un field PacketManager que vous allez initaliser dans votre méthode onEnable(), et vous pourrez ensuite register vos packets comme ceci :

```
public class Main extends JavaPlugin {

	private PacketManager packetManager;
	
	@Override
	public void onEnable() {		
		this.packetManager = (PacketManager) APacket.getInstance().getPacketManager();
		this.packetManager.registerPacket(74, new SPacketMoney());
		this.packetManager.registerPackets();
	}
}
```

Vous devrez également ajouter dans votre plugin.yml la libraire en dépendance :
```
depend: [aPacket]
```

# Créer un packet

Pour créer un nouveau packet, vous devrez créer une nouvelle class et extends celle-ci par SPacket ou CPacket.
Vous devrez nommer vos packets 'SPacketExample' ou 'CPacketExample' en fonction de la direction souhaitée. (SPacket -> Packet provenant du serveur -> client, CPacket -> Packet provenant du client -> serveur), donc si je veux créer un packet qui va vers le client, ça sera "SPacket".

Exemple de packet :

```
public class SPacketMoney extends SPacket {

	private int money;
	
	public SPacketMoney() {}
	
	public SPacketMoney(int money) {
		this.money = money;
	}
	
	@Override
	public void writePacketData(PacketDataSerializer data) throws IOException {
		data.writeInt(money);
	}

}
```

# Envoyer un packet

Pour envoyer un packet c'est très simple, vous n'aurez qu'à utiliser la méthode PacketManager#sendPacket comme ceci

```
PacketManager.sendPacket(player, packet);
```

# Utilisation côté client 

SOON..

# Liens

Discord : https://discord.gg/CTBG68kUNc

# Informations

Cette librairie n'est pas terminée du tout, elle n'est pas encore optimisée comme elle pourrait l'être et elle peut largement être améliorée.
Elle a été développée pour faciliter l'utilisation des packets qui restent encore un peu flou pour certains développeurs débutants
