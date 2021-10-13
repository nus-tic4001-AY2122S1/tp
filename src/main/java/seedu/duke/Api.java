package seedu.duke;

import com.google.gson.Gson;
import netscape.javascript.JSObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.http.HttpClient;
import java.util.List;

public class Api {

    String urlString = "https://api.nusmods.com/v2/2020-2021/moduleList.json";
    String urlStringDetailed = "https://api.nusmods.com/v2/2020-2021/moduleInfo.json";

    public Api() {
    }

    public Module[] getAllModules() throws IOException {
        URL url = new URL(urlString);
        URLConnection conn = url.openConnection();
        InputStream is = conn.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line = "";

        StringBuilder responseStrBuilder = new StringBuilder();
        while ((line =  br.readLine()) != null) {
            responseStrBuilder.append(line);
        }
        is.close();
        Gson gson = new Gson();
        String tmpStr = responseStrBuilder.toString();
        Module[] myMods = gson.fromJson(tmpStr, Module[].class);
        return myMods;
    }

    public Module[] getAllModulesDetailed() throws IOException {
        URL url = new URL(urlStringDetailed);
        URLConnection conn = url.openConnection();
        InputStream is = conn.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line = "";

        StringBuilder responseStrBuilder = new StringBuilder();
        while ((line =  br.readLine()) != null) {
            responseStrBuilder.append(line);
        }
        is.close();
        Gson gson = new Gson();
        String tmpStr = responseStrBuilder.toString();
        Module[] myMods = gson.fromJson(tmpStr, Module[].class);
        return myMods;
    }
}
