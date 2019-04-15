package eHealthSearch.importers.scopus.paper;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "search-results",namespace="http://www.w3.org/2005/Atom")
@XmlAccessorType(XmlAccessType.FIELD)

public class ScopusSearchResults {
	
	@XmlElement(name = "entry",namespace="http://www.w3.org/2005/Atom")
	private List<ScopusEntry> publications=new ArrayList<>();

	public List<ScopusEntry> getPublications() {
		return publications;
	}

	public void setPublications(List<ScopusEntry> publications) {
		this.publications = publications;
	}

}
