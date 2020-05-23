package com.anma.java.http.services.okhttp;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.Map;

public interface OkHttpService {

    OkHttpClient getClient();

    Map<String, Object> getParams(String url) throws IOException;

    String getBody(String url) throws IOException;

    Response getResponse (String url);

}
