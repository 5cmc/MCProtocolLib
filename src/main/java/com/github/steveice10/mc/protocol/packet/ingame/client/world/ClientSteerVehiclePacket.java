package com.github.steveice10.mc.protocol.packet.ingame.client.world;

import com.github.steveice10.mc.protocol.packet.MinecraftPacket;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;

import java.io.IOException;

public class ClientSteerVehiclePacket extends MinecraftPacket {
    private float sideways;
    private float forward;
    private boolean jump;
    private boolean dismount;

    public ClientSteerVehiclePacket(NetInput in) throws IOException {
        this.sideways = in.readFloat();
        this.forward = in.readFloat();
        int flags = in.readUnsignedByte();
        this.jump = (flags & 1) > 0;
        this.dismount = (flags & 2) > 0;
    }

    public ClientSteerVehiclePacket(float sideways, float forward, boolean jump, boolean dismount) {
        this.sideways = sideways;
        this.forward = forward;
        this.jump = jump;
        this.dismount = dismount;
    }

    public float getSideways() {
        return this.sideways;
    }

    public float getForward() {
        return this.forward;
    }

    public boolean getJumping() {
        return this.jump;
    }

    public boolean getDismounting() {
        return this.dismount;
    }

    @Override
    public void write(NetOutput out) throws IOException {
        out.writeFloat(this.sideways);
        out.writeFloat(this.forward);
        byte flags = 0;
        if(this.jump) {
            flags = (byte) (flags | 1);
        }

        if(this.dismount) {
            flags = (byte) (flags | 2);
        }

        out.writeByte(flags);
    }
}
