package com.github.steveice10.mc.protocol.packet.ingame.client;

import com.github.steveice10.mc.protocol.packet.MinecraftPacket;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;

import java.io.IOException;

public class ClientChatPacket extends MinecraftPacket {
    private String message;

    public ClientChatPacket(NetInput in) throws IOException {
        this.message = in.readString();
    }

    public ClientChatPacket(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    @Override
    public void write(NetOutput out) throws IOException {
        out.writeString(this.message);
    }
}
