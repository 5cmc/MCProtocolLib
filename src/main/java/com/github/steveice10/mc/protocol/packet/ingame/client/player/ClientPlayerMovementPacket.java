package com.github.steveice10.mc.protocol.packet.ingame.client.player;

import com.github.steveice10.mc.protocol.packet.MinecraftPacket;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;

import java.io.IOException;

public class ClientPlayerMovementPacket extends MinecraftPacket {
    protected double x;
    protected double y;
    protected double z;
    protected float yaw;
    protected float pitch;
    protected boolean onGround;

    protected boolean pos = false;
    protected boolean rot = false;

    public ClientPlayerMovementPacket(NetInput in) throws IOException {
        this.onGround = in.readBoolean();
    }

    protected ClientPlayerMovementPacket() {
    }

    public ClientPlayerMovementPacket(boolean onGround) {
        this.onGround = onGround;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getZ() {
        return this.z;
    }

    public double getYaw() {
        return this.yaw;
    }

    public double getPitch() {
        return this.pitch;
    }

    public boolean isOnGround() {
        return this.onGround;
    }

    @Override
    public void write(NetOutput out) throws IOException {
        if(this.pos) {
            out.writeDouble(this.x);
            out.writeDouble(this.y);
            out.writeDouble(this.z);
        }

        if(this.rot) {
            out.writeFloat(this.yaw);
            out.writeFloat(this.pitch);
        }

        out.writeBoolean(this.onGround);
    }
}
