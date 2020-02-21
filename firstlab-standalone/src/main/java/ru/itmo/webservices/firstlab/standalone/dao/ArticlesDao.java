package ru.itmo.webservices.firstlab.standalone.dao;

import ru.itmo.webservices.firstlab.standalone.pojo.Article;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ArticlesDao {
    public List<Article> getArticles(String authorId, Long hIndex, String articleName, String articleDesc, Long dateAdded) {
        List<Article> articles = new ArrayList<>();
        try (Connection connection = ConnectionUtil.getConnection()) {
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