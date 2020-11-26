package com.anma.java.http.netcore.old;

import com.anma.java.json.json.orgjson.OrgJsonExe;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class CoreOldExe {

    public static void main(String[] args) {

        try {
            HttpURLConnection connection = getConnection("https://pokeapi.co/api/v2/pokemon/ditto");
            InputStream inputStream = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            JSONObject jsonObject = OrgJsonExe.getJsonOrgObjext(reader.readLine());
            System.out.println(jsonObject.get("name"));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void testCoreNet(String url) throws Exception {

        String jsonString = readUrl(url);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        JsonObject jsonObject = gson.fromJson(jsonString, JsonObject.class);

        System.out.println(jsonObject.get("username"));

    }

    public static HttpURLConnection getConnection(String urlString) throws IOException {

        URL url = new URL(urlString);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");

        Map<String, String> parameters = new HashMap<>();

        parameters.put("nameParam", "Petro");

        connection.setDoOutput(true);

        return connection;
    }

    public static String readUrl(String urlString) throws Exception {

        BufferedReader reader = null;

        try {

            URL url = new URL(urlString);

            reader = new BufferedReader(new InputStreamReader(url.openStream()));

            StringBuffer buffer = new StringBuffer();

            int read;

            char[] chars = new char[1024];

            while ((read = reader.read(chars)) != -1)

                buffer.append(chars, 0, read);

            return buffer.toString();

        } finally {
            if (reader != null)
                reader.close();
        }
    }
}
