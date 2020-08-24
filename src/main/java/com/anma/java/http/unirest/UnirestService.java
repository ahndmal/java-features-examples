package com.anma.java.http.unirest;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;

public interface UnirestService {

    HttpResponse<JsonNode> getResponse (String url) throws UnirestException;

    String getBody (String url) throws UnirestException;
}
