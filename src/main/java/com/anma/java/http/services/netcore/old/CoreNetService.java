package com.anma.java.http.services.netcore.old;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.util.Map;

public interface CoreNetService {

    HttpURLConnection getParams(String url) throws IOException;

    String readUrl(String urlString) throws Exception;
}
