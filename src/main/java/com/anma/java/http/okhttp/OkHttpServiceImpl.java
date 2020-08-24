package com.anma.java.http.okhttp;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.Map;

public class OkHttpServiceImpl implements OkHttpService {

//    @Override
//    public OkHttpClient getClient() {
//
//        return new OkHttpClient.Builder()
//                .connectionSpecs(Arrays.asList(ConnectionSpec.MODERN_TLS, ConnectionSpec.COMPATIBLE_TLS))
//                .build();
//        ;
//    }

    @Override
    public String getBody(String url) throws IOException {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url(url).build();

        Response response = client.newCall(request).execute();

        return response.body().string();
    }

    @Override
    public Response getResponse(String url) {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url(url).build();

        Response response = null;
        try {

            response = client.newCall(request).execute();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }

    @Override
    public OkHttpClient getClient() {
        return null;
    }

    @Override
    public Map<String, Object> getParams(String url) throws IOException {
        return null;
    }
}
