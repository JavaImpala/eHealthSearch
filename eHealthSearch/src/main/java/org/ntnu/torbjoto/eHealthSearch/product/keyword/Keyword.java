package org.ntnu.torbjoto.eHealthSearch.product.keyword;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.ntnu.torbjoto.eHealthSearch.product.article.Publication;

@Entity
@Table(name="keywords")
public class Keyword {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int keyword_id;
	
	@Column(name="major_topic")
	private boolean majorTopic;
	
	@Column(name="text",columnDefinition="text")
	private String text;

	@ManyToOne
	@JoinColumn(name="article_id")
	private Publication publication;
	
	public Publication getArticle() {
		return publication;
	}

	public void setArticle(Publication article) {
		this.publication = article;
	}

	public boolean isMajorTopic() {
		return majorTopic;
	}

	public void setMajorTopic(boolean majorTopic) {
		this.majorTopic = majorTopic;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
}
