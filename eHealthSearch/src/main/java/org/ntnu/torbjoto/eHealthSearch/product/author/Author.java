package org.ntnu.torbjoto.eHealthSearch.product.author;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	private int author_id;
	
	private String first_name;
	private String family_name;
	
	//@OneToMany(mappedBy="author",cascade = {CascadeType.ALL},orphanRemoval = true)
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy="author",cascade = {CascadeType.ALL})
	private Collection<PublicationAuthorAffiliation> publicationAffiliations=new ArrayList<>();
	
	public int getAuthorId() {
		return author_id;
	}
	
	public void setAuthorId(int authorId) {
		this.author_id = authorId;
	}
	
	@Transient
	public String getFullName() {
		return first_name+" "+family_name;
	}
	
	public String getFirstName() {
		return first_name;
	}
	
	public void setFirstName(String firstName) {
		this.first_name = firstName;
	}
	
	public String getFamilyName() {
		return family_name;
	}
	
	public void setFamilyName(String familyName) {
		this.family_name = familyName;
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
		result = prime * result + ((family_name == null) ? 0 : family_name.hashCode());
		result = prime * result + ((first_name == null) ? 0 : first_name.hashCode());
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
		if (family_name == null) {
			if (other.family_name != null)
				return false;
		} else if (!family_name.equals(other.family_name))
			return false;
		if (first_name == null) {
			if (other.first_name != null)
				return false;
		} else if (!first_name.equals(other.first_name))
			return false;
		return true;
	}

	
	
	
	
	
}
