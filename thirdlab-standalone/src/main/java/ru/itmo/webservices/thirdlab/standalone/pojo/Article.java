package ru.itmo.webservices.thirdlab.standalone.pojo;

public class Article {
    private String authorId;
    private Long hIndex;
    private String articleName;
    private String articleDesc;
    private Long dateAdded;

    public Article() {
    }

    public Article(String authorId, Long hIndex, String articleName, String articleDesc, Long dateAdded) {
        this.authorId = authorId;
        this.hIndex = hIndex;
        this.articleName = articleName;
        this.articleDesc = articleDesc;
        this.dateAdded = dateAdded;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public Long gethIndex() {
        return hIndex;
    }

    public void sethIndex(Long hIndex) {
        this.hIndex = hIndex;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getArticleDesc() {
        return articleDesc;
    }

    public void setArticleDesc(String articleDesc) {
        this.articleDesc = articleDesc;
    }

    public Long getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Long dateAdded) {
        this.dateAdded = dateAdded;
    }

    @Override
    public String toString() {
        return "Article{" +
                "authorId='" + authorId + '\'' +
                ", hIndex=" + hIndex +
                ", articleName='" + articleName + '\'' +
                ", articleDesc='" + articleDesc + '\'' +
                ", dateAdded=" + dateAdded +
                '}';
    }
}
