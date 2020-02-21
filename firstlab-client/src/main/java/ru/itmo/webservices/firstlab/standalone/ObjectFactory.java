
package ru.itmo.webservices.firstlab.standalone;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.itmo.webservices.firstlab.standalone package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetArticles_QNAME = new QName("http://standalone.firstlab.webservices.itmo.ru/", "getArticles");
    private final static QName _GetArticlesResponse_QNAME = new QName("http://standalone.firstlab.webservices.itmo.ru/", "getArticlesResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.itmo.webservices.firstlab.standalone
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetArticlesResponse }
     * 
     */
    public GetArticlesResponse createGetArticlesResponse() {
        return new GetArticlesResponse();
    }

    /**
     * Create an instance of {@link GetArticles }
     * 
     */
    public GetArticles createGetArticles() {
        return new GetArticles();
    }

    /**
     * Create an instance of {@link Article }
     * 
     */
    public Article createArticle() {
        return new Article();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetArticles }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://standalone.firstlab.webservices.itmo.ru/", name = "getArticles")
    public JAXBElement<GetArticles> createGetArticles(GetArticles value) {
        return new JAXBElement<GetArticles>(_GetArticles_QNAME, GetArticles.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetArticlesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://standalone.firstlab.webservices.itmo.ru/", name = "getArticlesResponse")
    public JAXBElement<GetArticlesResponse> createGetArticlesResponse(GetArticlesResponse value) {
        return new JAXBElement<GetArticlesResponse>(_GetArticlesResponse_QNAME, GetArticlesResponse.class, null, value);
    }

}
