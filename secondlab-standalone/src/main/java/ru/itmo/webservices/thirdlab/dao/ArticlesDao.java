package ru.itmo.webservices.secondlab.standalone.dao;

import ru.itmo.webservices.secondlab.standalone.pojo.Article;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ArticlesDao {
    private Connection connection;

    public ArticlesDao() {
        connection = ConnectionUtil.getConnection();
    }

    public List<Article> select(String authorId, Long hIndex, String articleName, String articleDesc, Long dateAdded) {
        List<Article> articles = new ArrayList<>();
        try (Connection connection = ConnectionUtil.getConnection()) {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(
                    QueryBuilder.buildSelect(
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

    public long insert(String authorId, Long hIndex, String articleName, String articleDesc, Long dateAdded) {
        String sql = "INSERT INTO Article (author_id, h_index, article_name, article_desc, date_added) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, authorId);
            preparedStatement.setLong(2, hIndex);
            preparedStatement.setString(3, articleName);
            preparedStatement.setString(4, articleDesc);
            preparedStatement.setLong(5, dateAdded);

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows == 0) {
                return -1;
            }

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getLong(1);
            } else {
                return -1;
            }
        } catch (SQLException e) {
            return -1;
        }
    }

    public int update(long id, String authorId, Long hIndex, String articleName, String articleDesc, Long dateAdded) {
        String sql = QueryBuilder.buildUpdate(id, authorId, hIndex, articleName, articleDesc, dateAdded);
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows == 0 ? -1 : 1;
        } catch (SQLException e) {
            return -1;
        }
    }

    public int delete(int id) {
        String sql = "DELETE FROM article WHERE article_id = ?";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows == 0 ? -1 : 1;
        } catch (SQLException e) {
            return -1;
        }
    }
}