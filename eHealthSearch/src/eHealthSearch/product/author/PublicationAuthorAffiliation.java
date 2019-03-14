package eHealthSearch.product.author;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import eHealthSearch.product.affiliation.Affiliation;
import eHealthSearch.product.article.Publication;

@Entity
@Table(name="publication_affiliation")
public class PublicationAuthorAffiliation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int linkId;
	
	@ManyToOne
	@JoinColumn(name="author_id")
	private Author author;
	
	@OneToOne(cascade = {CascadeType.ALL})
	private Affiliation affiliation;
	
	@OneToOne(cascade = {CascadeType.ALL})
	private Publication publication;
	
	public int getLinkId() {
		return linkId;
	}
	
	public void setLinkId(int linkId) {
		this.linkId = linkId;
	}
	
	public Author getAuthor() {
		return author;
	}
	
	public void setAuthor(Author author) {
		this.author = author;
	}
	
	public Affiliation getAffiliation() {
		return affiliation;
	}
	
	public void setAffiliation(Affiliation affiliation) {
		this.affiliation = affiliation;
	}
	
	public Publication getPublication() {
		return publication;
	}
	
	public void setPublication(Publication publication) {
		this.publication = publication;
	}
}
