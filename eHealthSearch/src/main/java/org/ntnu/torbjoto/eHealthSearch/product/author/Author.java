package org.ntnu.torbjoto.eHealthSearch.product.author;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="author")
public class Author {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int authorId;
	
	private String firstName;
	private String familyName;
	
	//@OneToMany(mappedBy="author",cascade = {CascadeType.ALL},orphanRemoval = true)
	
	@OneToMany(mappedBy="author",cascade = {CascadeType.ALL})
	private Collection<PublicationAuthorAffiliation> publicationAffiliations=new ArrayList<>();
	
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

	public Collection<PublicationAuthorAffiliation> getPublicationAffiliations() {
		return publicationAffiliations;
	}

	public void setPublicationAffiliations(Collection<PublicationAuthorAffiliation> affiliations) {
		this.publicationAffiliations = affiliations;
	}
	
	public void addPublicationAffiliations(Collection<PublicationAuthorAffiliation> affiliations) {
		this.publicationAffiliations.addAll(affiliations);
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((familyName == null) ? 0 : familyName.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
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
		Author other = (Author) obj;
		if (familyName == null) {
			if (other.familyName != null)
				return false;
		} else if (!familyName.equals(other.familyName))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", firstName=" + firstName + ", familyName=" + familyName
				+ ", publicationAffiliations=" + publicationAffiliations + "]";
	}

	
	
	
	
}
