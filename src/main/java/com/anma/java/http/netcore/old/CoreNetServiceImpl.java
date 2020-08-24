package com.anma.java.http.netcore.old;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class CoreNetServiceImpl implements CoreNetService {

    @Override
    public HttpURLConnection getParams(String urlString) throws IOException {

        URL url = new URL(urlString);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");

        Map<String, String> parameters = new HashMap<>();

        parameters.put("nameParam", "Petro");

        connection.setDoOutput(true);

        return connection;
    }

    @Override
    public String readUrl(String urlString) throws Exception {

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
