package com.github.steveice10.mc.protocol.packet.ingame.client;

import com.github.steveice10.mc.protocol.packet.MinecraftPacket;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;

import java.io.IOException;

public class ClientKeepAlivePacket extends MinecraftPacket {
    private long id;

    public ClientKeepAlivePacket(NetInput in) throws IOException {
        this.id = in.readLong();
    }

    public ClientKeepAlivePacket(long id) {
        this.id = id;
    }

    public long getPingId() {
        return this.id;
    }

    @Override
    public void write(NetOutput out) throws IOException {
        out.writeLong(this.id);
    }
}
