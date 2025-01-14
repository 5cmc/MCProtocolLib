package com.github.steveice10.mc.protocol.packet.ingame.client.world;

import com.github.steveice10.mc.protocol.packet.MinecraftPacket;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;

import java.io.IOException;

public class ClientSteerBoatPacket extends MinecraftPacket {
    private boolean rightPaddleTurning;
    private boolean leftPaddleTurning;

    public ClientSteerBoatPacket(NetInput in) throws IOException {
        this.rightPaddleTurning = in.readBoolean();
        this.leftPaddleTurning = in.readBoolean();
    }

    public ClientSteerBoatPacket(boolean rightPaddleTurning, boolean leftPaddleTurning) {
        this.rightPaddleTurning = rightPaddleTurning;
        this.leftPaddleTurning = leftPaddleTurning;
    }

    public boolean isRightPaddleTurning() {
        return this.rightPaddleTurning;
    }

    public boolean isLeftPaddleTurning() {
        return this.leftPaddleTurning;
    }

    @Override
    public void write(NetOutput out) throws IOException {
        out.writeBoolean(this.rightPaddleTurning);
        out.writeBoolean(this.leftPaddleTurning);
    }
}
