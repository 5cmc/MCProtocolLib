package com.github.steveice10.mc.protocol.packet.ingame.client.window;

import com.github.steveice10.mc.protocol.packet.MinecraftPacket;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;

import java.io.IOException;

public class ClientConfirmTransactionPacket extends MinecraftPacket {
    private int windowId;
    private int actionId;
    private boolean accepted;

    public ClientConfirmTransactionPacket(NetInput in) throws IOException {
        this.windowId = in.readByte();
        this.actionId = in.readShort();
        this.accepted = in.readBoolean();
    }

    public ClientConfirmTransactionPacket(int windowId, int actionId, boolean accepted) {
        this.windowId = windowId;
        this.actionId = actionId;
        this.accepted = accepted;
    }

    public int getWindowId() {
        return this.windowId;
    }

    public int getActionId() {
        return this.actionId;
    }

    public boolean getAccepted() {
        return this.accepted;
    }

    @Override
    public void write(NetOutput out) throws IOException {
        out.writeByte(this.windowId);
        out.writeShort(this.actionId);
        out.writeBoolean(this.accepted);
    }
}
