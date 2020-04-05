package ru.itmo.webservices.fourthlab.standalone;

import ru.itmo.webservices.fourthlab.standalone.dao.ArticlesDao;
import ru.itmo.webservices.fourthlab.standalone.pojo.Article;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/articles")
@Produces({MediaType.APPLICATION_JSON})
public class ArticleResource {

    @GET
    @Path("/find")
    public List<Article> getArticles(@QueryParam("authorId") String authorId,
                                     @QueryParam("hIndex") Long hIndex,
                                     @QueryParam("articleName") String articleName,
                                     @QueryParam("articleDesc") String articleDesc,
                                     @QueryParam("dateAdded") Long dateAdded) {
        ArticlesDao dao = new ArticlesDao();
        return dao.getArticles(authorId, hIndex, articleName, articleDesc, dateAdded);
    }
}