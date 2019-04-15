package org.ntnu.torbjoto.eHealthSearch.importers.pubmed.paper.article;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement( name = "Affiliation" )
@XmlAccessorType(XmlAccessType.FIELD)

public class PubmedAuthorAffiliation {
	
	String affiliation;

	public String getAffiliation() {
		return affiliation;
	}

	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}

	
}
