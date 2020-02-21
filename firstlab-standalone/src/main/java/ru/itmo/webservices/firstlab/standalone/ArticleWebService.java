package ru.itmo.webservices.firstlab.standalone;

import ru.itmo.webservices.firstlab.standalone.dao.ArticlesDao;
import ru.itmo.webservices.firstlab.standalone.pojo.Article;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService(serviceName = "ArticlesService")
public class ArticleWebService {
    @WebMethod
    public List<Article> getArticles(@WebParam(name = "authorId") String authorId,
                                     @WebParam(name = "hIndex") Long hIndex,
                                     @WebParam(name = "articleName") String articleName,
                                     @WebParam(name = "articleDesc") String articleDesc,
                                     @WebParam(name = "dateAdded") Long dateAdded) {
        ArticlesDao dao = new ArticlesDao();
        return dao.getArticles(authorId, hIndex, articleName, articleDesc, dateAdded);
    }
}