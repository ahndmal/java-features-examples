//package com.anma.java.core.concur.vertxx;
//
//import io.vertx.core.Vertx;
//import io.vertx.ext.auth.authentication.TokenCredentials;
//import io.vertx.ext.web.client.OAuth2WebClient;
//import io.vertx.ext.web.client.OAuth2WebClientOptions;
//import io.vertx.ext.web.client.WebClient;
//
//public class VrtClientAuth2 {
//    public static void main(String[] args) {
//        Vertx vertx = Vertx.vertx();
//        WebClient client = WebClient.create(vertx);
//        OAuth2WebClient oauth2 = OAuth2WebClient.create(
//                        client,
//                        OAuth2Auth.create(vertx, new OAuth2Options(/* enter IdP config */)))
//
//                // configure the initial credentials (needed to fetch if needed
//                // the access_token
//                .withCredentials(new TokenCredentials("some.jwt.token"));
//
//        //
//        OAuth2WebClient client2 = OAuth2WebClient.create(
//                baseClient,
//                oAuth2Auth,
//                new OAuth2WebClientOptions()
//                        .setLeeway(5));
//    }
//}
