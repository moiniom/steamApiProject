package org.example.steamapiproject.ownedresponse;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record GameRecord(int gameid, String name, int totalPlaytime, int last2WeeksPlaytime, String iconUrl,
                         boolean hasPublicStats, boolean hasLeaderBoards, int windowsPlaytime, int macPlaytime,
                         int linuxPlaytime, int steamDeckPlaytime, int rtimeLastPlayed, List<Integer> contentDescriptorIds,
                         int playtimeDisconnected) {
    public GameRecord(
            @JsonProperty("appid") int gameid,
            @JsonProperty("name") String name,
            @JsonProperty("playtime_forever") int totalPlaytime,
            @JsonProperty("playtime_2weeks") int last2WeeksPlaytime,
            @JsonProperty("img_icon_url") String iconUrl,
            @JsonProperty("has_community_visible_stats") boolean hasPublicStats,
            @JsonProperty("has_leaderboards") boolean hasLeaderBoards,
            @JsonProperty("playtime_windows_forever") int windowsPlaytime,
            @JsonProperty("playtime_mac_forever") int macPlaytime,
            @JsonProperty("playtime_linux_forever") int linuxPlaytime,
            @JsonProperty("playtime_deck_forever") int steamDeckPlaytime,
            @JsonProperty("rtime_last_played") int rtimeLastPlayed,
            @JsonProperty("content_descriptorids") List<Integer> contentDescriptorIds,
            @JsonProperty("playtime_disconnected") int playtimeDisconnected
    ) {

        this.gameid = gameid;
        this.name = name;
        this.totalPlaytime = totalPlaytime;
        this.last2WeeksPlaytime = last2WeeksPlaytime;
        this.iconUrl = iconUrl;
        this.hasPublicStats = hasPublicStats;
        this.hasLeaderBoards = hasLeaderBoards;
        this.windowsPlaytime = windowsPlaytime;
        this.macPlaytime = macPlaytime;
        this.linuxPlaytime = linuxPlaytime;
        this.steamDeckPlaytime = steamDeckPlaytime;
        this.rtimeLastPlayed = rtimeLastPlayed;
        this.contentDescriptorIds = contentDescriptorIds;
        this.playtimeDisconnected = playtimeDisconnected;
    }
}
