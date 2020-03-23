package ru.itmo.webservices.secondlab.standalone;

import javax.xml.ws.Endpoint;

public class AppStarter {
    public static void main(String[] args) {
        String url = "http://0.0.0.0:8080/ArticleService";
        Endpoint.publish(url, new ArticleWebService());
    }
}
