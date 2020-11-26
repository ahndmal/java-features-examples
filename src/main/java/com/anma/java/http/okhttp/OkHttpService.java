package com.anma.java.http.okhttp;

import okhttp3.OkHttpClient;
import okhttp3.Response;

import java.io.IOException;
import java.util.Map;

public interface OkHttpService {

    OkHttpClient getClient();

    Map<String, Object> getParams(String url) throws IOException;

    String getBody(String url) throws IOException;

    Response getResponse (String url);

}
