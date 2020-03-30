package ru.itmo.webservices.thirdlab.standalone.dao;


import ru.itmo.webservices.thirdlab.standalone.exceptions.ArticleServiceFault;
import ru.itmo.webservices.thirdlab.standalone.exceptions.InsertingException;
import ru.itmo.webservices.thirdlab.standalone.exceptions.InvalidEntityException;
import ru.itmo.webservices.thirdlab.standalone.pojo.Article;

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

    public long insert(String authorId, Long hIndex, String articleName, String articleDesc, Long dateAdded) throws InsertingException {
        String sql = "INSERT INTO Article (author_id, h_index, article_name, article_desc, date_added) VALUES (?, ?, ?, ?, ?)";
        long id = 0;
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, authorId);
            preparedStatement.setLong(2, hIndex);
            preparedStatement.setString(3, articleName);
            preparedStatement.setString(4, articleDesc);
            preparedStatement.setLong(5, dateAdded);

            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                id = generatedKeys.getLong(1);
            }
        } catch (SQLException e) { }
        if (id == 0) {
            ArticleServiceFault fault = ArticleServiceFault.defaultInstance();
            fault.setMessage("Error During creation entity");
            throw new InsertingException("Error During creation entity", fault);
        }

        return id;
    }

    public int update(long id, String authorId, Long hIndex, String articleName, String articleDesc, Long dateAdded) throws InvalidEntityException{
        String sql = QueryBuilder.buildUpdate(id, authorId, hIndex, articleName, articleDesc, dateAdded);
        int affectedRows = 0;
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            affectedRows = preparedStatement.executeUpdate();
        } catch (SQLException e) { }
        if (affectedRows == 0) {
            ArticleServiceFault fault = ArticleServiceFault.defaultInstance();
            fault.setMessage("Invalid entity");
            throw new InvalidEntityException("Invalid entity", fault);
        }
        return affectedRows;
    }

    public int delete(int id) throws InvalidEntityException {
        String sql = "DELETE FROM article WHERE article_id = ?";
        int affectedRows = 0;
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            affectedRows = preparedStatement.executeUpdate();
        } catch (SQLException e) { }
        if (affectedRows == 0) {
            ArticleServiceFault fault = ArticleServiceFault.defaultInstance();
            fault.setMessage("Invalid entity");
            throw new InvalidEntityException("Invalid entity", fault);
        }
        return affectedRows;
    }
}