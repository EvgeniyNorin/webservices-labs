
package ru.itmo.webservices.thirdlab.standalone;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "RowsNotAffectedException", targetNamespace = "http://standalone.thirdlab.webservices.itmo.ru/")
public class RowsNotAffectedException
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private ArticleServiceFault faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public RowsNotAffectedException(String message, ArticleServiceFault faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public RowsNotAffectedException(String message, ArticleServiceFault faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: ru.itmo.webservices.thirdlab.standalone.ArticleServiceFault
     */
    public ArticleServiceFault getFaultInfo() {
        return faultInfo;
    }

}
