package com.anma.java.http.netcore.old;

import com.anma.java.json.json.orgjson.OrgJsonExe;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CoreOldExe {

    public static void main(String[] args) throws Exception {

        POSTrequest();

    }

    private static void POSTrequest() throws IOException {
        HttpURLConnection connectionPost = (HttpURLConnection) new URL("https://httpbin.org/post").openConnection();
        connectionPost.setRequestMethod("POST");
        connectionPost.setRequestProperty("Content-Type", "application/json");
        connectionPost.setRequestProperty("User-Agent", "Mozilla/5.0");
        connectionPost.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        connectionPost.setDoOutput(true);
        /* String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";
           try (DataOutputStream wr = new DataOutputStream(connectionPost.getOutputStream())) {
            wr.writeBytes(urlParameters);
            wr.flush();
        }*/
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(connectionPost.getOutputStream()));
        writer.write("\"name\": \"Vasyl\"");
        writer.flush();
        int responseCode = connectionPost.getResponseCode();
        System.out.println("** Sending POST request");
        System.out.println("** Status code is " + responseCode);
        BufferedReader reader = new BufferedReader(new InputStreamReader(connectionPost.getInputStream()));
        String line;
        StringBuilder response = new StringBuilder();

        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        System.out.println(response.toString());
    }

    @NotNull
    private static HttpURLConnection GETrequest() throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL("https://pokeapi.co/api/v2/pokemon/ditto").openConnection();
        connection.setRequestMethod("GET");
//        connection.setRequestProperty("Test Header", "Header value");
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line = "";
        StringBuilder builder = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            builder.append(line);
        }
        System.out.println(builder.toString());
        connection.disconnect();
        return connection;
    }

    private static void readUrlJson() {
        try {
            HttpURLConnection connection = getConnection("https://pokeapi.co/api/v2/pokemon/ditto");
            InputStream inputStream = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            JSONObject jsonObject = OrgJsonExe.getJsonOrgObjext(reader.readLine());
            JSONArray jsonArray = jsonObject.names();
            Set<String> keySet = jsonObject.keySet();

            System.out.println(keySet);
            System.out.println(jsonArray);

            keySet.forEach(key -> {
                System.out.println(jsonObject.get(key));
            });

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
