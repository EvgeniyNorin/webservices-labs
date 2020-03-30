package ru.itmo.webservices.thirdlab.standalone.client;

import com.sun.rowset.internal.Row;
import ru.itmo.webservices.thirdlab.standalone.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class WebServiceClient {
    static void getStatus(ArticleWebService articleWebService) {
        System.out.println("-----------Article Table Content-----------");
        List<Article> articles = articleWebService.getArticles(null, null, null, null, null);
        for (Article article : articles) {
            System.out.println(article.toString());
        }

        System.out.println("-------------------------------------------");
        System.out.println();
    }

    static void handleException(InvalidCreatingParametersException th) {
        System.out.println("Message: " + th.getMessage());
        System.out.println("FaultInfo: " + th.getFaultInfo().getMessage());
    }

    static void handleException(InsertingException th) {
        System.out.println("Message: " + th.getMessage());
        System.out.println("FaultInfo: " + th.getFaultInfo().getMessage());
    }

    static void handleException(IllegalIdException th) {
        System.out.println("Message: " + th.getMessage());
        System.out.println("FaultInfo: " + th.getFaultInfo().getMessage());
    }

    static void handleException(RowsNotAffectedException th) {
        System.out.println("Message: " + th.getMessage());
        System.out.println("FaultInfo: " + th.getFaultInfo().getMessage());
    }

    public static void main(String[] args) throws MalformedURLException  {
        URL url = new URL("http://localhost:8080/ArticleService?wsdl");
        ArticlesService articlesService = new ArticlesService(url);
        ArticleWebService articleWebService = articlesService.getArticleWebServicePort();
        getStatus(articleWebService);

        System.out.println("Inserting entity...");
        try{
            articleWebService.createArticle("authordId", 20L, "articleName", "articleDesc", 20L);
        } catch (InsertingException th) {
            handleException(th);
        } catch (InvalidCreatingParametersException th) {
            handleException(th);
        }
        getStatus(articleWebService);

        System.out.println("Inserting malformed entity...");
        try{
            articleWebService.createArticle("authordId", null, "articleName", "articleDesc", 20L);
        } catch (InsertingException th) {
            handleException(th);
        } catch (InvalidCreatingParametersException th) {
            handleException(th);
        }
        getStatus(articleWebService);

        System.out.println("Deleting entity...");
        try{
            articleWebService.deleteArticle(20L);
        } catch (IllegalIdException th) {
            handleException(th);
        } catch (RowsNotAffectedException th) {
            handleException(th);
        }
        getStatus(articleWebService);

        System.out.println("Deleting entity with null id...");
        try{
            articleWebService.deleteArticle(null);
        } catch (IllegalIdException th) {
            handleException(th);
        } catch (RowsNotAffectedException th) {
            handleException(th);
        }
        getStatus(articleWebService);

        System.out.println("Deleting not existing entity...");
        try{
            articleWebService.deleteArticle(100L);
        } catch (IllegalIdException th) {
            handleException(th);
        } catch (RowsNotAffectedException th) {
            handleException(th);
        }
        getStatus(articleWebService);

        long id = 0L;
        System.out.println("Inserting entity...");
        try{
            id = articleWebService.createArticle("authordId", 20L, "articleName", "articleDesc", 20L);
        } catch (InsertingException th) {
            handleException(th);
        } catch (InvalidCreatingParametersException th) {
            handleException(th);
        }
        getStatus(articleWebService);

        System.out.println("Updating entity...");
        try{
            articleWebService.updateArticle(id ,"new authordId", 20L, "articleName", "articleDesc", 20L);
        } catch (IllegalIdException th) {
            handleException(th);
        } catch (RowsNotAffectedException th) {
            handleException(th);
        }
        getStatus(articleWebService);

        System.out.println("Updating entity with null id...");
        try{
            articleWebService.deleteArticle(null);
        } catch (IllegalIdException th) {
            handleException(th);
        } catch (RowsNotAffectedException th) {
            handleException(th);
        }
        getStatus(articleWebService);

        System.out.println("Updating not existing entity...");
        try{
            articleWebService.deleteArticle(100L);
        } catch (IllegalIdException th) {
            handleException(th);
        } catch (RowsNotAffectedException th) {
            handleException(th);
        }
        getStatus(articleWebService);

    }
}
