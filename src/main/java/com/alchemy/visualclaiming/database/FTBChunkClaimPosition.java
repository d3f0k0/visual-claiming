package com.alchemy.visualclaiming.database;

import com.feed_the_beast.ftbutilities.gui.ClientClaimedChunks;
import net.minecraft.client.resources.I18n;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.ChunkPos;

import java.util.ArrayList;
import java.util.List;

public class FTBChunkClaimPosition {
    public int x;
    public int z;

    public short uid;
    public int flags;
    public int teamColor;
    public String teamName;

    public List<String> tooltips;


    public FTBChunkClaimPosition(ChunkPos pos, short uid, int flags, int teamColor, String teamName ) {
        this.x = pos.x;
        this.z = pos.z;

        this.uid = uid;
        this.flags = flags;
        this.teamColor = teamColor;
        this.teamName = teamName;

        tooltips = new ArrayList<>();
        tooltips.add(I18n.format("visualclaiming.team", teamName));
        if (flags == 1) {
            tooltips.add(I18n.format("visualclaiming.chunkedloaded"));
        }
    }

    public NBTTagCompound toNBT() {
        NBTTagCompound result = new NBTTagCompound();
        result.setShort("team", uid);
        result.setInteger("flags", flags);
        result.setInteger("team_color", teamColor);
        result.setString("team_name", teamName);
        return result;
    }
}
