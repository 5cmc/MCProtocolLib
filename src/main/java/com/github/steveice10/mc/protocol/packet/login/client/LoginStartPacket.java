package com.github.steveice10.mc.protocol.packet.login.client;

import com.github.steveice10.mc.protocol.packet.MinecraftPacket;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;

import java.io.IOException;

public class LoginStartPacket extends MinecraftPacket {
    private String username;

    public LoginStartPacket(NetInput in) throws IOException {
        this.username = in.readString();
    }

    public LoginStartPacket(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    @Override
    public void write(NetOutput out) throws IOException {
        out.writeString(this.username);
    }

    @Override
    public boolean isPriority() {
        return true;
    }
}
