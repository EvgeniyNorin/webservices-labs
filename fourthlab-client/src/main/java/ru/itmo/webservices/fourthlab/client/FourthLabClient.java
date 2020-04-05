package ru.itmo.webservices.fourthlab.client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

import javax.ws.rs.core.MediaType;

public class FourthLabClient {

    public static void main(String[] args) {

        Client client = Client.create();

        String  url = "http://localhost:8080/articles/find";

        System.out.println("Querying all existing Articles");
        display(findArticles(client, url, ""));
        System.out.println();

        System.out.println("Querying all existing Articles with authorId=authorId");
        display(findArticles(client, url, "authorId=authorId"));
        System.out.println();

        System.out.println("Querying all existing Articles with hIndex=3");
        display(findArticles(client, url, "hIndex=3"));
        System.out.println();

        System.out.println("Querying all existing Articles with articleName=articleName2");
        display(findArticles(client, url, "articleName=articleName2"));
    }

    private static List<Article> findArticles(Client client, String url, String query) {
        WebResource webResource = client.resource(url);
        if (!query.isEmpty()) {
            Map<String, String> map = getQueryMap(query);

            Set<String> keys = map.keySet();
            for (String key : keys) {
                webResource = webResource.queryParam(key, map.get(key));
            }
        }

        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
        if (response.getStatus() != ClientResponse.Status.OK.getStatusCode()) {
            throw new IllegalStateException("Request failed");
        }

        GenericType<List<Article>> type = new GenericType<List<Article>>() {
        };

        return response.getEntity(type);
    }

    private static Map<String, String> getQueryMap(String query) {
        String[] params = query.split("&");
        Map<String, String> map = new HashMap<String, String>();
        for (String param : params) {
            String name = param.split("=")[0];
            String value = param.split("=")[1];
            map.put(name, value);
        }
        return map;
    }

    private static void display(List<Article> articles) {
        for (Article article : articles) {
            System.out.println(article);
        }
    }
}
