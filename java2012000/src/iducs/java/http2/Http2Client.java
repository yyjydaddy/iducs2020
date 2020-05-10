package iducs.java.http2;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Http2Client {

    // default
    // private final HttpClient httpClient = HttpClient.newHttpClient();

    private final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();

    public static void main(String[] args) throws IOException, InterruptedException {
    	Http2Client obj = new Http2Client();
        obj.sendGET();
    }

    private void sendGET() throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://cds.induk.ac.kr"))
                //.uri(URI.create("http://passion.induk.ac.kr/device/"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .build();


        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        // print response headers        
        HttpHeaders headers = response.headers();
        
        
        Object[] headerKey =  headers.map().keySet().toArray();
        for(Object key : headerKey) {
        	System.out.println(key + ":" + headers.map().get(key.toString()).toString());
        }        
        
        headers.map().forEach((k, v) -> System.out.println(k + ":" + v));

        // print status code
        System.out.println("Status Code : " + response.statusCode());

        // print response body
        //System.out.println(response.body());

    }

}