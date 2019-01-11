package eHealthSearch.product.author;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import eHealthSearch.product.affiliation.Affiliation;

@Entity
@Table(name="author")
public class Author {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int authorId;
	
	private String firstName;
	private String familyName;
	
	@OneToMany(cascade = {CascadeType.ALL})
	private Collection<Affiliation> affiliations;
	
	public int getAuthorId() {
		return authorId;
	}
	
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	
	@Transient
	public String getFullName() {
		return firstName+" "+familyName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getFamilyName() {
		return familyName;
	}
	
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public Collection<Affiliation> getAffiliations() {
		return affiliations;
	}

	public void setAffiliations(Collection<Affiliation> affiliations) {
		this.affiliations = affiliations;
	}
}
