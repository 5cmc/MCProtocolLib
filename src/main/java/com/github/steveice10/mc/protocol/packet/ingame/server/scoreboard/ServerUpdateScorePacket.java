package com.github.steveice10.mc.protocol.packet.ingame.server.scoreboard;

import com.github.steveice10.mc.protocol.data.MagicValues;
import com.github.steveice10.mc.protocol.data.game.scoreboard.ScoreboardAction;
import com.github.steveice10.mc.protocol.packet.MinecraftPacket;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;

import java.io.IOException;

public class ServerUpdateScorePacket extends MinecraftPacket {
    private String entry;
    private ScoreboardAction action;
    private String objective;
    private int value;

    public ServerUpdateScorePacket(NetInput in) throws IOException {
        this.entry = in.readString();
        this.action = MagicValues.key(ScoreboardAction.class, in.readVarInt());
        this.objective = in.readString();
        if(this.action == ScoreboardAction.ADD_OR_UPDATE) {
            this.value = in.readVarInt();
        }
    }

    public ServerUpdateScorePacket(String entry, String objective) {
        this.entry = entry;
        this.objective = objective;
        this.action = ScoreboardAction.REMOVE;
    }

    public ServerUpdateScorePacket(String entry, String objective, int value) {
        this.entry = entry;
        this.objective = objective;
        this.value = value;
        this.action = ScoreboardAction.ADD_OR_UPDATE;
    }

    public String getEntry() {
        return this.entry;
    }

    public ScoreboardAction getAction() {
        return this.action;
    }

    public String getObjective() {
        return this.objective;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public void write(NetOutput out) throws IOException {
        out.writeString(this.entry);
        out.writeVarInt(MagicValues.value(Integer.class, this.action));
        out.writeString(this.objective);
        if(this.action == ScoreboardAction.ADD_OR_UPDATE) {
            out.writeVarInt(this.value);
        }
    }
}
