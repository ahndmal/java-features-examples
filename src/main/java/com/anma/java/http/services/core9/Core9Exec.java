package com.anma.java.http.services.core9;//package com.anma.bh.sb.springtesting.services.core9;
//
//import java.io.IOException;
//import java.net.URI;
//import java.net.URISyntaxException;
//import java.net.http.HttpClient;
//import java.net.http.HttpHeaders;
//import java.net.http.HttpRequest;
//import java.net.http.HttpResponse;
//
//public class Core9Exec {
//
//    public static void main(String[] args) {
//
//        try {
//
//            HttpRequest request = HttpRequest.newBuilder()
//                    .uri(new URI("https://postman-echo.com/get"))
//                    .version(HttpClient.Version.HTTP_2)
//                    .GET()
//                    .build();
//
//            HttpResponse<String> response = HttpClient.newHttpClient()
//                    .send(request, HttpResponse.BodyHandler.asString());
//
//            assertThat(response.version(), equalTo(HttpClient.Version.HTTP_1_1));
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        }
//
//    }
//}
