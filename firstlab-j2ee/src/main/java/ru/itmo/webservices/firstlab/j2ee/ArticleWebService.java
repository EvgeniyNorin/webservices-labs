package ru.itmo.webservices.firstlab.j2ee;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebService(serviceName = "ArticlesService")
public class ArticleWebService {
    @Resource(lookup = "jdbc/mydb")
    private DataSource dataSource;

    @WebMethod
    public List<Article> getArticles(@WebParam(name = "authorId") String authorId,
                                     @WebParam(name = "hIndex") Long hIndex,
                                     @WebParam(name = "articleName") String articleName,
                                     @WebParam(name = "articleDesc") String articleDesc,
                                     @WebParam(name = "dateAdded") Long dateAdded) {
        ArticlesDao dao = new ArticlesDao(getConnection());
        return dao.getArticles(authorId, hIndex, articleName, articleDesc, dateAdded);
    }

    private Connection getConnection() {
        Connection result = null;
        try {
            result = dataSource.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ArticleWebService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}