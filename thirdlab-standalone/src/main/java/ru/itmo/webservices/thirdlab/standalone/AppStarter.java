package ru.itmo.webservices.thirdlab.standalone;

import javax.xml.ws.Endpoint;

public class AppStarter {
    public static void main(String[] args) {
        System.setProperty("com.sun.xml.ws.fault.SOAPFaultBuilder.disableCaptureStackTrace", "false");
        String url = "http://0.0.0.0:8080/ArticleService";
        Endpoint.publish(url, new ArticleWebService());
    }
}
