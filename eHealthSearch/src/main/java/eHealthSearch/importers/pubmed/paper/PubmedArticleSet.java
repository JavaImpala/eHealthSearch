package eHealthSearch.importers.pubmed.paper;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "PubmedArticleSet" )
@XmlAccessorType(XmlAccessType.FIELD)

public class PubmedArticleSet {
	
	@XmlElement(name = "PubmedArticle")
	List<PubmedRootArticle> publications;

	public List<PubmedRootArticle> getPublications() {
		return publications;
	}

	public void setPublications(List<PubmedRootArticle> publications) {
		this.publications = publications;
	}

	@Override
	public String toString() {
		return "PubmedArticleSet [publications=" + publications + "]";
	}

	
	
}
