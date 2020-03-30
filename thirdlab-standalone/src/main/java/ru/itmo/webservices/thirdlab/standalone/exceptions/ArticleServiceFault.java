package ru.itmo.webservices.thirdlab.standalone.exceptions;

public class ArticleServiceFault {
    private static final String DEFAULT_MESSAGE = "Parameter q cannot be null or empty";
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static ArticleServiceFault defaultInstance() {
        ArticleServiceFault fault = new ArticleServiceFault();
        fault.message = DEFAULT_MESSAGE;
        return fault;
    }
}
