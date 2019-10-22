package org.ntnu.torbjoto.eHealthSearch.product.article;

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
		this.idType = idType.trim();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id.trim();
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
		return "ArticleId [articleLinkId=" + articleLinkId + ", idType=" + idType + ", id=" + id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idType == null) ? 0 : idType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArticleId other = (ArticleId) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idType == null) {
			if (other.idType != null)
				return false;
		} else if (!idType.equals(other.idType))
			return false;
		return true;
	}
}
