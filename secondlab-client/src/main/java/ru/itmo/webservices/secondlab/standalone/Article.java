
package ru.itmo.webservices.secondlab.standalone;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for article complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="article">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="articleDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="articleName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="authorId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dateAdded" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="hIndex" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "article", propOrder = {
    "articleDesc",
    "articleName",
    "authorId",
    "dateAdded",
    "hIndex"
})
public class Article {

    protected String articleDesc;
    protected String articleName;
    protected String authorId;
    protected Long dateAdded;
    protected Long hIndex;

    /**
     * Gets the value of the articleDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArticleDesc() {
        return articleDesc;
    }

    /**
     * Sets the value of the articleDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArticleDesc(String value) {
        this.articleDesc = value;
    }

    /**
     * Gets the value of the articleName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArticleName() {
        return articleName;
    }

    /**
     * Sets the value of the articleName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArticleName(String value) {
        this.articleName = value;
    }

    /**
     * Gets the value of the authorId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthorId() {
        return authorId;
    }

    /**
     * Sets the value of the authorId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthorId(String value) {
        this.authorId = value;
    }

    /**
     * Gets the value of the dateAdded property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDateAdded() {
        return dateAdded;
    }

    /**
     * Sets the value of the dateAdded property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDateAdded(Long value) {
        this.dateAdded = value;
    }

    /**
     * Gets the value of the hIndex property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getHIndex() {
        return hIndex;
    }

    /**
     * Sets the value of the hIndex property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setHIndex(Long value) {
        this.hIndex = value;
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
