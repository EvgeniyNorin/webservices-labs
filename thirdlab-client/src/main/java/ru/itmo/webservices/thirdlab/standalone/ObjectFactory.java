
package ru.itmo.webservices.thirdlab.standalone;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.itmo.webservices.thirdlab.standalone package. 
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

    private final static QName _InsertingException_QNAME = new QName("http://standalone.thirdlab.webservices.itmo.ru/", "InsertingException");
    private final static QName _IllegalIdException_QNAME = new QName("http://standalone.thirdlab.webservices.itmo.ru/", "IllegalIdException");
    private final static QName _CreateArticle_QNAME = new QName("http://standalone.thirdlab.webservices.itmo.ru/", "createArticle");
    private final static QName _GetArticlesResponse_QNAME = new QName("http://standalone.thirdlab.webservices.itmo.ru/", "getArticlesResponse");
    private final static QName _UpdateArticle_QNAME = new QName("http://standalone.thirdlab.webservices.itmo.ru/", "updateArticle");
    private final static QName _RowsNotAffectedException_QNAME = new QName("http://standalone.thirdlab.webservices.itmo.ru/", "RowsNotAffectedException");
    private final static QName _DeleteArticle_QNAME = new QName("http://standalone.thirdlab.webservices.itmo.ru/", "deleteArticle");
    private final static QName _DeleteArticleResponse_QNAME = new QName("http://standalone.thirdlab.webservices.itmo.ru/", "deleteArticleResponse");
    private final static QName _UpdateArticleResponse_QNAME = new QName("http://standalone.thirdlab.webservices.itmo.ru/", "updateArticleResponse");
    private final static QName _CreateArticleResponse_QNAME = new QName("http://standalone.thirdlab.webservices.itmo.ru/", "createArticleResponse");
    private final static QName _InvalidCreatingParametersException_QNAME = new QName("http://standalone.thirdlab.webservices.itmo.ru/", "InvalidCreatingParametersException");
    private final static QName _GetArticles_QNAME = new QName("http://standalone.thirdlab.webservices.itmo.ru/", "getArticles");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.itmo.webservices.thirdlab.standalone
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
     * Create an instance of {@link UpdateArticle }
     * 
     */
    public UpdateArticle createUpdateArticle() {
        return new UpdateArticle();
    }

    /**
     * Create an instance of {@link ArticleServiceFault }
     * 
     */
    public ArticleServiceFault createArticleServiceFault() {
        return new ArticleServiceFault();
    }

    /**
     * Create an instance of {@link CreateArticle }
     * 
     */
    public CreateArticle createCreateArticle() {
        return new CreateArticle();
    }

    /**
     * Create an instance of {@link GetArticles }
     * 
     */
    public GetArticles createGetArticles() {
        return new GetArticles();
    }

    /**
     * Create an instance of {@link CreateArticleResponse }
     * 
     */
    public CreateArticleResponse createCreateArticleResponse() {
        return new CreateArticleResponse();
    }

    /**
     * Create an instance of {@link DeleteArticleResponse }
     * 
     */
    public DeleteArticleResponse createDeleteArticleResponse() {
        return new DeleteArticleResponse();
    }

    /**
     * Create an instance of {@link UpdateArticleResponse }
     * 
     */
    public UpdateArticleResponse createUpdateArticleResponse() {
        return new UpdateArticleResponse();
    }

    /**
     * Create an instance of {@link DeleteArticle }
     * 
     */
    public DeleteArticle createDeleteArticle() {
        return new DeleteArticle();
    }

    /**
     * Create an instance of {@link Article }
     * 
     */
    public Article createArticle() {
        return new Article();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArticleServiceFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://standalone.thirdlab.webservices.itmo.ru/", name = "InsertingException")
    public JAXBElement<ArticleServiceFault> createInsertingException(ArticleServiceFault value) {
        return new JAXBElement<ArticleServiceFault>(_InsertingException_QNAME, ArticleServiceFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArticleServiceFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://standalone.thirdlab.webservices.itmo.ru/", name = "IllegalIdException")
    public JAXBElement<ArticleServiceFault> createIllegalIdException(ArticleServiceFault value) {
        return new JAXBElement<ArticleServiceFault>(_IllegalIdException_QNAME, ArticleServiceFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateArticle }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://standalone.thirdlab.webservices.itmo.ru/", name = "createArticle")
    public JAXBElement<CreateArticle> createCreateArticle(CreateArticle value) {
        return new JAXBElement<CreateArticle>(_CreateArticle_QNAME, CreateArticle.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetArticlesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://standalone.thirdlab.webservices.itmo.ru/", name = "getArticlesResponse")
    public JAXBElement<GetArticlesResponse> createGetArticlesResponse(GetArticlesResponse value) {
        return new JAXBElement<GetArticlesResponse>(_GetArticlesResponse_QNAME, GetArticlesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateArticle }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://standalone.thirdlab.webservices.itmo.ru/", name = "updateArticle")
    public JAXBElement<UpdateArticle> createUpdateArticle(UpdateArticle value) {
        return new JAXBElement<UpdateArticle>(_UpdateArticle_QNAME, UpdateArticle.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArticleServiceFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://standalone.thirdlab.webservices.itmo.ru/", name = "RowsNotAffectedException")
    public JAXBElement<ArticleServiceFault> createRowsNotAffectedException(ArticleServiceFault value) {
        return new JAXBElement<ArticleServiceFault>(_RowsNotAffectedException_QNAME, ArticleServiceFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteArticle }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://standalone.thirdlab.webservices.itmo.ru/", name = "deleteArticle")
    public JAXBElement<DeleteArticle> createDeleteArticle(DeleteArticle value) {
        return new JAXBElement<DeleteArticle>(_DeleteArticle_QNAME, DeleteArticle.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteArticleResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://standalone.thirdlab.webservices.itmo.ru/", name = "deleteArticleResponse")
    public JAXBElement<DeleteArticleResponse> createDeleteArticleResponse(DeleteArticleResponse value) {
        return new JAXBElement<DeleteArticleResponse>(_DeleteArticleResponse_QNAME, DeleteArticleResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateArticleResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://standalone.thirdlab.webservices.itmo.ru/", name = "updateArticleResponse")
    public JAXBElement<UpdateArticleResponse> createUpdateArticleResponse(UpdateArticleResponse value) {
        return new JAXBElement<UpdateArticleResponse>(_UpdateArticleResponse_QNAME, UpdateArticleResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateArticleResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://standalone.thirdlab.webservices.itmo.ru/", name = "createArticleResponse")
    public JAXBElement<CreateArticleResponse> createCreateArticleResponse(CreateArticleResponse value) {
        return new JAXBElement<CreateArticleResponse>(_CreateArticleResponse_QNAME, CreateArticleResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArticleServiceFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://standalone.thirdlab.webservices.itmo.ru/", name = "InvalidCreatingParametersException")
    public JAXBElement<ArticleServiceFault> createInvalidCreatingParametersException(ArticleServiceFault value) {
        return new JAXBElement<ArticleServiceFault>(_InvalidCreatingParametersException_QNAME, ArticleServiceFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetArticles }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://standalone.thirdlab.webservices.itmo.ru/", name = "getArticles")
    public JAXBElement<GetArticles> createGetArticles(GetArticles value) {
        return new JAXBElement<GetArticles>(_GetArticles_QNAME, GetArticles.class, null, value);
    }

}
