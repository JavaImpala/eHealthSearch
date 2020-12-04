package org.ntnu.torbjoto.eHealthSearch.product.article;

import java.time.LocalDateTime;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.ntnu.torbjoto.eHealthSearch.product.author.Author;
import org.ntnu.torbjoto.eHealthSearch.product.keyword.Keyword;
import org.ntnu.torbjoto.eHealthSearch.product.mesh.Term;

@Entity
@Table(name="publication")
public class Publication {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="publication_db_id")
	private int localDBId;
	
	@Column(name="title",columnDefinition="text")
	private String title;

	@OneToOne(cascade = {CascadeType.ALL})
	private Abstract abs;
	
	//ingen cascade for å unngå duplicate?
	@ManyToMany(cascade = {CascadeType.ALL})
	private Collection<Author> authors;
	
	@OneToMany(cascade = {CascadeType.ALL},mappedBy="publication")
	private Collection<Keyword> keywords;
	
	@OneToMany(cascade = {CascadeType.ALL})
	private Collection<Term> terms;
	
	@OneToMany(cascade = {CascadeType.ALL},mappedBy="publication")
	private Collection<ArticleId> article_ids;
	
	@Column
	private LocalDateTime publication_date;
	
	public Collection<ArticleId> getArticleIds() {
		return article_ids;
	}

	public void setArticleIds(Collection<ArticleId> citIds) {
		this.article_ids = citIds;
	}

	public int getLocalDBId() {
		return localDBId;
	}
	
	public Collection<Keyword> getKeywords() {
		return keywords;
	}

	public void setKeywords(Collection<Keyword> keywords) {
		this.keywords = keywords;
	}

	public void setLocalDBId(int publicationId) {
		this.localDBId = publicationId;
	}

	public Abstract getAbs() {
		return abs;
	}

	public void setAbs(Abstract abs) {
		this.abs = abs;
	}

	public Collection<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Collection<Author> authors) {
		this.authors = authors;
	}

	public Collection<Term> getTerms() {
		return terms;
	}

	public void setTerms(Collection<Term> terms) {
		this.terms = terms;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDateTime getLocalDateTime() {
		return  publication_date;
	}

	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.publication_date = localDateTime;
	}
	

	@Override
	public String toString() {
		return "Publication [localDBId=" + localDBId + ", title=" + title + ", abs=" + abs + ", authors=" + authors
				+ ", keywords=" + keywords + ", terms=" + terms + ", articleIds=" + article_ids + "]";
	}
	
	


}
