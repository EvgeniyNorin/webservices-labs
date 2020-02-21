package ru.itmo.webservices.firstlab.client;

import ru.itmo.webservices.firstlab.standalone.Article;
import ru.itmo.webservices.firstlab.standalone.ArticleWebService;
import ru.itmo.webservices.firstlab.standalone.ArticlesService;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class FirstLabClient {

    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:8080/ArticleService?wsdl");
        ArticlesService articlesService = new ArticlesService(url);
        ArticleWebService articlesWebService = articlesService.getArticleWebServicePort();


        System.out.println("Querying all existing Articles");
        List<Article> articles = articlesWebService.getArticles(null, null, null, null, null);
        for (Article picture : articles) {
            System.out.println(picture.toString());
        }

        System.out.println("Querying all Articles by specific fields");
        List<Article> articles2 = articlesWebService.getArticles(null, 15L, null, "article_desc_1", null);
        for (Article picture : articles2) {
            System.out.println(picture.toString());
        }

    }
}
