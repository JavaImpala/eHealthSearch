package org.ntnu.torbjoto.eHealthSearch.product.article;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="article_id")
public class ArticleId {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int article_link_id;
	
	private String id_type;
	private String id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="publication_id")
	private Publication publication;

	public String getIdType() {
		return id_type;
	}

	public void setIdType(String idType) {
		this.id_type = idType.trim();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id.trim();
	}

	public Publication getArticle() {
		return publication;
	}

	public void setArticle(Publication article) {
		this.publication = article;
	}

	public int getArticleLinkId() {
		return article_link_id;
	}

	public void setArticleLinkId(int articleLinkId) {
		this.article_link_id = articleLinkId;
	}
	
	

	@Override
	public String toString() {
		return "ArticleId [articleLinkId=" + article_link_id + ", idType=" + id_type + ", id=" + id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((id_type == null) ? 0 : id_type.hashCode());
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
		if (id_type == null) {
			if (other.id_type != null)
				return false;
		} else if (!id_type.equals(other.id_type))
			return false;
		return true;
	}
}
