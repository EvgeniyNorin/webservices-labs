package ru.itmo.webservices.fourthlab.j2ee;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.jws.WebParam;
import javax.sql.DataSource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RequestScoped
@Path("/articles")
@Produces({MediaType.APPLICATION_JSON})
public class ArticleResource {
    @Resource(lookup = "jdbc/mydb")
    private DataSource dataSource;

    @GET
    @Path("/find")
    public List<Article> getArticles(@QueryParam("authorId") String authorId,
                                     @QueryParam("hIndex") Long hIndex,
                                     @QueryParam("articleName") String articleName,
                                     @QueryParam("articleDesc") String articleDesc,
                                     @QueryParam("dateAdded") Long dateAdded) {
        ArticlesDao dao = new ArticlesDao(getConnection());
        return dao.getArticles(authorId, hIndex, articleName, articleDesc, dateAdded);
    }

    private Connection getConnection() {
        Connection result = null;
        try {
            result = dataSource.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ArticleResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}