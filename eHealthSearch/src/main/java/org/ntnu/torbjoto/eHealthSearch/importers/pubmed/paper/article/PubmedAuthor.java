package org.ntnu.torbjoto.eHealthSearch.importers.pubmed.paper.article;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "Author" )
@XmlAccessorType(XmlAccessType.FIELD)

public class PubmedAuthor {
	@XmlElement(name="LastName")
	private String lastName;
	
	@XmlElement(name="ForeName")
	private String foreName;
	
	@XmlElement(name="Initials")
	private String initials;
	
	@XmlElementWrapper(name = "AffiliationInfo") 
	@XmlElement(name = "Affiliation")
	private List<String> affiliations;

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getForeName() {
		return foreName;
	}

	public void setForeName(String foreName) {
		this.foreName = foreName;
	}

	public String getInitials() {
		return initials;
	}

	public void setInitials(String initials) {
		this.initials = initials;
	}

	public List<String> getAffiliations() {
		return affiliations;
	}

	public void setAffiliations(List<String> affiliations) {
		this.affiliations = affiliations;
	}

	@Override
	public String toString() {
		return "PubmedAuthor [lastName=" + lastName + ", foreName=" + foreName + ", initials=" + initials
				+ ", affiliations=" + affiliations + "]";
	}
}
