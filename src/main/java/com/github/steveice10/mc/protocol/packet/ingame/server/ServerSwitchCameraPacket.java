package com.github.steveice10.mc.protocol.packet.ingame.server;

import com.github.steveice10.mc.protocol.packet.MinecraftPacket;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;

import java.io.IOException;

public class ServerSwitchCameraPacket extends MinecraftPacket {
    private int cameraEntityId;

    public ServerSwitchCameraPacket(NetInput in) throws IOException {
        this.cameraEntityId = in.readVarInt();
    }

    public ServerSwitchCameraPacket(int cameraEntityId) {
        this.cameraEntityId = cameraEntityId;
    }

    public int getCameraEntityId() {
        return this.cameraEntityId;
    }

    @Override
    public void write(NetOutput out) throws IOException {
        out.writeVarInt(this.cameraEntityId);
    }
}
