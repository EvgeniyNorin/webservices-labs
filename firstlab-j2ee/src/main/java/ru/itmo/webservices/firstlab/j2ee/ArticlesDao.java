package ru.itmo.webservices.firstlab.j2ee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ArticlesDao {
    private Connection connection = null;

    public ArticlesDao(Connection connection) {
        this.connection = connection;
    }

    public List<Article> getArticles(String authorId, Long hIndex, String articleName, String articleDesc, Long dateAdded) {
        List<Article> articles = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(
                    QueryBuilder.build(
                            authorId,
                            hIndex,
                            articleName,
                            articleDesc,
                            dateAdded
                    )
            );

            while (rs.next()) {
                articles.add(
                        new Article(
                                rs.getString("author_id"),
                                rs.getLong("h_index"),
                                rs.getString("article_name"),
                                rs.getString("article_desc"),
                                rs.getLong("date_added")
                        )
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArticlesDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return articles;
    }
}