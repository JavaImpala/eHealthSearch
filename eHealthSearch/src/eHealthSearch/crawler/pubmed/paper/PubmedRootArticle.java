package eHealthSearch.crawler.pubmed.paper;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import eHealthSearch.crawler.pubmed.paper.meta.PubmedData;

@XmlRootElement( name = "PubmedArticle" )
@XmlAccessorType(XmlAccessType.FIELD)

public class PubmedRootArticle {
	
	
	
	@XmlElement(name = "MedlineCitation")
	private PubmedMedlineCitation medlineCitation;
	
	
	@XmlElement(name = "PubmedData")
	private PubmedData meta;
	

	/*====================
	gettere og settere
	====================*/
	

	public PubmedMedlineCitation getMedlineCitation() {
		return medlineCitation;
	}

	public void setMedlineCitation(PubmedMedlineCitation medlineCitation) {
		this.medlineCitation = medlineCitation;
	}

	public PubmedData getMeta() {
		return meta;
	}

	public void setMeta(PubmedData meta) {
		this.meta = meta;
	}

	@Override
	public String toString() {
		return "PubmedRootArticle [medlineCitation=" + medlineCitation + ", meta=" + meta + "]";
	}
	
	


	
	
	

	
	
	
	
	
	
}