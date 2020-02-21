package ru.itmo.webservices.firstlab.standalone.dao;

public class QueryBuilder {
    public static String build(String authorId, Long hIndex, String articleName, String articleDesc, Long dateAdded) {
        StringBuilder builder = new StringBuilder(0);
        if (authorId != null) {
            builder.append(String.format("author_id='%s'", authorId));
        }
        if (hIndex != null) {
            if (builder.length() != 0) {
                builder.append(String.format("and h_index=%d", hIndex));
            } else {
                builder.append(String.format("h_index=%d", hIndex));
            }
        }
        if (articleName != null) {
            if (builder.length() != 0) {
                builder.append(String.format("and article_name='%s'", articleName));
            } else {
                builder.append(String.format("article_name='%s'", articleName));
            }
        }
        if (articleDesc != null) {
            if (builder.length() != 0) {
                builder.append(String.format("and article_desc='%s'", articleDesc));
            } else {
                builder.append(String.format("article_desc='%s'", articleDesc));
            }
        }
        if (dateAdded != null) {
            if (builder.length() != 0) {
                builder.append(String.format("and date_added=%d", dateAdded));
            } else {
                builder.append(String.format("date_added=%d", dateAdded));
            }
        }
        if (builder.length() != 0) {
            return "select * from article where " + builder.toString();
        } else {
            return "select * from article;";
        }
    }
}
