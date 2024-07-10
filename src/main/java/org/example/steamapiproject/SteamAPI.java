package org.example.steamapiproject;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;

public class SteamAPI {
    private String key = "";

    public String gameSchema(int gameid) throws IOException {
        String api = "ISteamUserStats/GetSchemaForGame/v2";
        HashMap<String, String> args = new HashMap<>();
        args.put("appid", String.valueOf(gameid));
        return makeReq(api, args);
    }

    public String getAchievementStats(int gameid) throws IOException {
        String api = "ISteamUserStats/GetGlobalAchievementPercentageForApp/v1";
        HashMap<String, String> args = new HashMap<>();
        args.put("gameid", String.valueOf(gameid));
        return makeReq(api, args);
    }

    public String getOwnedGames(int steamid) throws IOException {
        String api = "IPlayerService/GetOwnedGames/v1";
        HashMap<String, String> args = new HashMap<>();
        args.put("steamid", String.valueOf(steamid));
        args.put("include_appinfo", "true");
        args.put("include_played_free_games", "true");
        return makeReq(api, args);
    }

    public String getPlayerAchievements(int steamid, int gameid) throws IOException {
        String api = "ISteamUserStats/GetPlayerAchievements/v1";
        HashMap<String, String> args = new HashMap<>();
        args.put("steamid", String.valueOf(steamid));
        args.put("gameid", String.valueOf(gameid));
        return makeReq(api, args);
    }

    private String makeReq(String api, HashMap<String, String> args) throws IOException {
        String base = "https://api.steampowered.com/";
        StringBuilder link = new StringBuilder(base + api + "?key=" + key);
        for(String arg : args.keySet()) {
            link.append("&").append(arg).append("=").append(args.get(arg));
        }
        URL url = new URL(link.toString());
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        BufferedReader result = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        return result.readLine();
    }

    public void setKey(String key) {
        this.key = key;
    }
}