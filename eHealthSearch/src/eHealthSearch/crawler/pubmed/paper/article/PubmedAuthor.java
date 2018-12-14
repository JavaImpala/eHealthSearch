package eHealthSearch.crawler.pubmed.paper.article;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
	
	@XmlElement(name = "AffiliationInfo")
	private PubmedAuthorAffiliations affiliations;

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

	public PubmedAuthorAffiliations getAffiliations() {
		return affiliations;
	}

	public void setAffiliations(PubmedAuthorAffiliations affiliations) {
		this.affiliations = affiliations;
	}

	@Override
	public String toString() {
		return "PubmedAuthor [lastName=" + lastName + ", foreName=" + foreName + ", initials=" + initials
				+ ", affiliations=" + affiliations + "]";
	}
}
