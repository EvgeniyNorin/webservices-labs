package ru.itmo.webservices.firstlab.client;

import ru.itmo.webservices.firstlab.standalone.Article;
import ru.itmo.webservices.firstlab.standalone.ArticleWebService;
import ru.itmo.webservices.firstlab.standalone.ArticlesService;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FirstLabClient {

    public static ArticleWebService createService() throws MalformedURLException {
        URL url = new URL("http://localhost:8080/ArticleService?wsdl");
        ArticlesService articlesService = new ArticlesService(url);
        return articlesService.getArticleWebServicePort();
    }

    public static ArticleWebService runFirstExample(ArticleWebService articlesWebService) {
        System.out.println("Querying all existing Articles");
        List<Article> articles = articlesWebService.getArticles(null, null, null, null, null);
        for (Article picture : articles) {
            System.out.println(picture.toString());
        }
        return articlesWebService;
    }


    public static ArticleWebService runSecondExample(ArticleWebService articlesWebService) {
        System.out.println("Querying all Articles by specific fields");
        List<Article> articles2 = articlesWebService.getArticles(null, 15L, null, "article_desc_1", null);
        for (Article picture : articles2) {
            System.out.println(picture.toString());
        }
        return articlesWebService;
    }

    public static void main(String[] args) throws MalformedURLException, ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        // API calls are still synchronous because of the nature of wsimport autogen code, but their composition is asynchronous
        // Finally we call get() method - this call obviously synchronous, but it serves as a point of synchronization
        CompletableFuture
                .completedFuture(createService())
                .thenComposeAsync(service -> CompletableFuture.supplyAsync(() -> runFirstExample(service)), executorService)
                .thenComposeAsync(service -> CompletableFuture.supplyAsync(() -> runSecondExample(service)), executorService)
                .get();
    }
}
