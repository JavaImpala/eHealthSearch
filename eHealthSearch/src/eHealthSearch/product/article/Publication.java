package eHealthSearch.product.article;

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

import eHealthSearch.product.author.Author;
import eHealthSearch.product.keyword.Keyword;
import eHealthSearch.product.mesh.Term;

@Entity
@Table(name="publication")
public class Publication {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int publicationId;
	
	@Column(name="title",columnDefinition="text")
	private String title;
	
	

	@OneToOne(cascade = {CascadeType.ALL})
	private Abstract abs;
	
	//ingen cascade for å unngå duplicate
	@ManyToMany(cascade = {CascadeType.ALL})
	private Collection<Author> authors;
	
	@OneToMany(cascade = {CascadeType.ALL},mappedBy="article")
	private Collection<Keyword> keywords;
	
	@OneToMany(cascade = {CascadeType.ALL})
	private Collection<Term> terms;
	
	@OneToMany(cascade = {CascadeType.ALL},mappedBy="article")
	private Collection<ArticleId> citIds;
	
	public Collection<ArticleId> getCitIds() {
		return citIds;
	}

	public void setCitIds(Collection<ArticleId> citIds) {
		this.citIds = citIds;
	}

	public int getPublicationId() {
		return publicationId;
	}
	
	public Collection<Keyword> getKeywords() {
		return keywords;
	}

	public void setKeywords(Collection<Keyword> keywords) {
		this.keywords = keywords;
	}

	public void setPublicationId(int publicationId) {
		this.publicationId = publicationId;
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

	@Override
	public String toString() {
		return "Publication [publicationId=" + publicationId + ", abs=" + abs + ", authors=" + authors + ", terms="
				+ terms + ", citIds=" + citIds + "]";
	}
}
