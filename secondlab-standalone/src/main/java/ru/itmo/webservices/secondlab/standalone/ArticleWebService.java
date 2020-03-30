package ru.itmo.webservices.secondlab.standalone;

import ru.itmo.webservices.secondlab.standalone.dao.ArticlesDao;
import ru.itmo.webservices.secondlab.standalone.pojo.Article;

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
        return dao.select(authorId, hIndex, articleName, articleDesc, dateAdded);
    }

    @WebMethod
    public long createArticle(@WebParam(name = "authorId") String authorId,
                              @WebParam(name = "hIndex") Long hIndex,
                              @WebParam(name = "articleName") String articleName,
                              @WebParam(name = "articleDesc") String articleDesc,
                              @WebParam(name = "dateAdded") Long dateAdded) {
        ArticlesDao dao = new ArticlesDao();
        return dao.insert(authorId, hIndex, articleName, articleDesc, dateAdded);
    }

    @WebMethod
    public long updateArticle(@WebParam(name = "id") Long id,
                              @WebParam(name = "authorId") String authorId,
                              @WebParam(name = "hIndex") Long hIndex,
                              @WebParam(name = "articleName") String articleName,
                              @WebParam(name = "articleDesc") String articleDesc,
                              @WebParam(name = "dateAdded") Long dateAdded) {
        ArticlesDao dao = new ArticlesDao();
        return dao.update(id, authorId, hIndex, articleName, articleDesc, dateAdded);
    }

    @WebMethod
    public int deleteArticle(@WebParam(name = "id") int id) {
        ArticlesDao dao = new ArticlesDao();
        return dao.delete(id);
    }
}

