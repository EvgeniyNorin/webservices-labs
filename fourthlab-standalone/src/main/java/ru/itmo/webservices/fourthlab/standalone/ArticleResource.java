package ru.itmo.webservices.fourthlab.standalone;

import ru.itmo.webservices.fourthlab.standalone.dao.ArticlesDao;
import ru.itmo.webservices.fourthlab.standalone.pojo.Article;

import javax.jws.WebParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/articles")
@Produces({MediaType.APPLICATION_JSON})
public class ArticleResource {

    @GET
    @Path("/{authorId}/{hIndex}/{articleName}/{articleDesc}/{dateAdded}")
    public List<Article> getArticles(@PathParam("authorId") String authorId,
                                     @PathParam("hIndex") Long hIndex,
                                     @PathParam("articleName") String articleName,
                                     @PathParam("articleDesc") String articleDesc,
                                     @PathParam("dateAdded") Long dateAdded) {
        ArticlesDao dao = new ArticlesDao();
        return dao.getArticles(authorId, hIndex, articleName, articleDesc, dateAdded);
    }
}