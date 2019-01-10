package eHealthSearch.search.pubmed.paper.article;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "AffiliationInfo" )
@XmlAccessorType(XmlAccessType.FIELD)

public class PubmedAuthorAffiliations {
	
	@XmlElementWrapper(name = "Affiliation")
	@XmlElement(name = "Affiliation")
	List<String> affiliation;

	public List<String> getAffiliation() {
		return affiliation;
	}

	public void setAffiliation(List<String> affiliation) {
		this.affiliation = affiliation;
	}

	@Override
	public String toString() {
		return "PubmedAuthorAffiliations [affiliation=" + affiliation + "]";
	}
}
