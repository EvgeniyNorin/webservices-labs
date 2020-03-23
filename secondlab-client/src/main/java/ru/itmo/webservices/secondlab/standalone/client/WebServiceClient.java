package ru.itmo.webservices.secondlab.standalone.client;

import ru.itmo.webservices.secondlab.standalone.Article;
import ru.itmo.webservices.secondlab.standalone.ArticleWebService;
import ru.itmo.webservices.secondlab.standalone.ArticlesService;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class WebServiceClient {
    public static void getStatus(ArticleWebService articleWebService) {
        System.out.println("Articles Status");
        List<Article> articles = articleWebService.getArticles(null, null, null, null, null);
        for (Article article : articles) {
            System.out.println(article.toString());
        }

        System.out.println("Total articles: " + articles.size());
        System.out.println();
    }

    public static void main(String[] args) throws MalformedURLException  {
        URL url = new URL("http://localhost:8080/ArticleService?wsdl");
        ArticlesService articlesService = new ArticlesService(url);
        ArticleWebService articleWebService = articlesService.getArticleWebServicePort();
        getStatus(articleWebService);

        System.out.println("Inserting entity...");
        int id = (int)articleWebService.createArticle("authordId", 20L, "articleName", "articleDesc", 20L);
        getStatus(articleWebService);

        System.out.println("Deleting entity...");
        articleWebService.deleteArticle(id);
        getStatus(articleWebService);

        System.out.println("Inserting another entity...");
        long id1 = articleWebService.createArticle("authordId1", 20L, "articleName", "articleDesc", 20L);
        getStatus(articleWebService);

        System.out.println("Updating entity...");
        articleWebService.updateArticle(id1, "authordId1", 20L, "articleName", "articleDesc", 20L);
        getStatus(articleWebService);

        System.out.println("Deleting entity...");
        articleWebService.deleteArticle((int)id1);
        getStatus(articleWebService);
    }
}
