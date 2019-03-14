package eHealthSearch.product.article;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="articleId")
public class ArticleId {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int articleLinkId;
	
	private String idType;
	private String id;
	
	@ManyToOne
	@JoinColumn(name="article_id")
	private Publication article;

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Publication getArticle() {
		return article;
	}

	public void setArticle(Publication article) {
		this.article = article;
	}

	public int getArticleLinkId() {
		return articleLinkId;
	}

	public void setArticleLinkId(int articleLinkId) {
		this.articleLinkId = articleLinkId;
	}

	@Override
	public String toString() {
		return "ArticleId [articleLinkId=" + articleLinkId + ", idType=" + idType + ", id=" + id + ", article="
				+ article.getPublicationId() + "]";
	}
	
	
}
