package com.sparta.framework.connection;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.SQLOutput;

public class ConnectionManager {

    public static String getBaseURLConnection(){
        return Endpoints.BASEURL.getUrl();
    }
    public static String getConnection(Endpoints endpoint, String value){
        return endpoint.getUrl() + "/" + value + "?format=json";
    }
    public static String getConnection(Endpoints endpoint, int value){
        return endpoint.getUrl() + "/" + value + "?format=json";
    }

    private static HttpResponse<String> getResponse(Endpoints endpoint){
        var client = HttpClient.newHttpClient();
        var request = HttpRequest
                .newBuilder()
                .uri(URI.create(endpoint.getUrl()))
                .build();
        HttpResponse<String> response = null;

        try{
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }

    public static int getStatusCode(Endpoints endpoint){
        return getResponse(endpoint).statusCode();
    }
    public static String getHeader(String key, Endpoints endpoint){
        return getResponse(endpoint)
                .headers()
                .firstValue(key)
                .orElse("Key not found");
    }
}

