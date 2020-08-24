package com.anma.java.http.core9;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;

public interface Core9HttpService {

    HttpRequest getGETRequest(String url) throws MalformedURLException, URISyntaxException;

    HttpRequest getPOSTRequest(String url, String body) throws URISyntaxException;

}
