package ru.itmo.webservices.thirdlab.standalone.exceptions;

import javax.xml.ws.WebFault;

@WebFault(faultBean = "ru.itmo.webservices.thirdlab.standalone.exceptions.ArticleServiceFault")
public class InvalidCreatingParametersException extends Exception {
    private static final long serialVersionUID = -6647544772732631047L;
    private final ArticleServiceFault fault;

    public InvalidCreatingParametersException(String message, ArticleServiceFault fault) {
        super(message);
        this.fault = fault;
    }

    public InvalidCreatingParametersException(String message, ArticleServiceFault fault, Throwable cause) {
        super(message, cause);
        this.fault = fault;
    }

    public ArticleServiceFault getFaultInfo() {
        return fault;
    }
}