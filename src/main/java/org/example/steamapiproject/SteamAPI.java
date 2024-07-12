package org.example.steamapiproject;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.steamapiproject.globalachievementresponse.AchievementResponse;
import org.example.steamapiproject.ownedresponse.OwnedResponse;
import org.example.steamapiproject.playerachivementresponse.PlayerResponse;
import org.example.steamapiproject.schemaresponse.SchemaResponse;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;

public class SteamAPI {
    private final ObjectMapper mapper = new ObjectMapper();
    private String key = "";

    //returns a record containing information about a game critically icons and such of the games achievements.
    public SchemaResponse getGameSchema(int gameid) throws IOException {
        String api = "ISteamUserStats/GetSchemaForGame/v2";
        HashMap<String, String> args = new HashMap<>();
        args.put("appid", String.valueOf(gameid));
        return mapper.readValue(makeReq(api, args), SchemaResponse.class);
    }

    //returns a record containing the percentage of players who completed the different achievements off a game.
    public AchievementResponse getAchievementStats(int gameid) throws IOException {
        String api = "ISteamUserStats/GetGlobalAchievementPercentagesForApp/v2";
        HashMap<String, String> args = new HashMap<>();
        args.put("gameid", String.valueOf(gameid));
        return mapper.readValue(makeReq(api, args), AchievementResponse.class);
    }

    //returns a record containing a list of all the games the given user owns as well as some metadata on those games.
    public OwnedResponse getOwnedGames(String steamid) throws IOException {
        String api = "IPlayerService/GetOwnedGames/v1";
        HashMap<String, String> args = new HashMap<>();
        args.put("steamid", steamid);
        args.put("include_appinfo", "true");
        args.put("include_played_free_games", "true");
        return mapper.readValue(makeReq(api, args), OwnedResponse.class);
    }

    //returns a record containing a list of all achievements of a Game and whether and when the player achieved it.
    public PlayerResponse getPlayerAchievements(String steamid, int gameid) throws IOException {
        String api = "ISteamUserStats/GetPlayerAchievements/v1";
        HashMap<String, String> args = new HashMap<>();
        args.put("steamid", String.valueOf(steamid));
        args.put("appid", String.valueOf(gameid));
        return mapper.readValue(makeReq(api, args), PlayerResponse.class);
    }

    //makes the actual request and returns the given JSON string
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

    //Sets the api key.txt
    public void setKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}