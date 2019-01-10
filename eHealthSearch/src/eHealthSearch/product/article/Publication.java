package eHealthSearch.product.article;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import eHealthSearch.product.author.Author;

@Entity
@Table(name="publiction")
public class Publication {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int publicationId;
	
	@OneToOne(cascade = {CascadeType.ALL})
	private Abstract abs;
	
	@OneToMany(cascade = {CascadeType.ALL})
	private Collection<Author> authors;
	
	public int getPublicationId() {
		return publicationId;
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
}
