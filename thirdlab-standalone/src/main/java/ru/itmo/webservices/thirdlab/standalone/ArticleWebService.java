package ru.itmo.webservices.thirdlab.standalone;

import ru.itmo.webservices.thirdlab.standalone.dao.ArticlesDao;
import ru.itmo.webservices.thirdlab.standalone.exceptions.*;
import ru.itmo.webservices.thirdlab.standalone.pojo.Article;

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
                              @WebParam(name = "dateAdded") Long dateAdded) throws InsertingException, InvalidCreatingParametersException {
        ArticleServiceFault fault = ArticleServiceFault.defaultInstance();
        fault.setMessage("Invalid creating parameter");

        if (authorId == null || authorId.trim().isEmpty()) {
            fault.setMessage("Parameter authorId cannot be null or empty");
            throw new InvalidCreatingParametersException("Invalid creating parameter", fault);
        }

        if (hIndex == null) {
            fault.setMessage("Parameter hIndex cannot be null");
            throw new InvalidCreatingParametersException("Invalid creating parameter", fault);
        }

        if (articleName == null || articleName.trim().isEmpty()) {
            fault.setMessage("Parameter articleName cannot be null or empty");
            throw new InvalidCreatingParametersException("Invalid creating parameter", fault);
        }

        if (articleDesc == null || articleDesc.trim().isEmpty()) {
            fault.setMessage("Parameter articleDesc cannot be null or empty");
            throw new InvalidCreatingParametersException("Invalid creating parameter", fault);
        }

        if (dateAdded == null) {
            fault.setMessage("Parameter dateAdded cannot be null");
            throw new InvalidCreatingParametersException("Invalid creating parameter", fault);
        }

        ArticlesDao dao = new ArticlesDao();
        return dao.insert(authorId, hIndex, articleName, articleDesc, dateAdded);
    }

    @WebMethod
    public long updateArticle(@WebParam(name = "id") Long id,
                              @WebParam(name = "authorId") String authorId,
                              @WebParam(name = "hIndex") Long hIndex,
                              @WebParam(name = "articleName") String articleName,
                              @WebParam(name = "articleDesc") String articleDesc,
                              @WebParam(name = "dateAdded") Long dateAdded) throws IllegalIdException, RowsNotAffectedException {
        ArticlesDao dao = new ArticlesDao();
        if (id == null) {
            ArticleServiceFault fault = ArticleServiceFault.defaultInstance();
            fault.setMessage("Parameter id cannot be null");
            throw new IllegalIdException("Parameter id cannot be null", fault);
        }
        return dao.update(id, authorId, hIndex, articleName, articleDesc, dateAdded);
    }

    @WebMethod
    public int deleteArticle(@WebParam(name = "id") Long id) throws IllegalIdException, RowsNotAffectedException {
        ArticlesDao dao = new ArticlesDao();
        if (id == null) {
            ArticleServiceFault fault = ArticleServiceFault.defaultInstance();
            fault.setMessage("Parameter id cannot be null");
            throw new IllegalIdException("Parameter id cannot be null", fault);
        }
        return dao.delete(id);
    }
}

