package com.github.steveice10.mc.protocol.packet.ingame.client.world;

import com.github.steveice10.mc.protocol.packet.MinecraftPacket;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;

import java.io.IOException;

public class ClientTeleportConfirmPacket extends MinecraftPacket {
    private int id;

    public ClientTeleportConfirmPacket(NetInput in) throws IOException {
        this.id = in.readVarInt();
    }

    public ClientTeleportConfirmPacket(int id) {
        this.id = id;
    }

    public int getTeleportId() {
        return this.id;
    }

    @Override
    public void write(NetOutput out) throws IOException {
        out.writeVarInt(this.id);
    }
}
