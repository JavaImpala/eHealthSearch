package eHealthSearch.search.pubmed.paper;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import eHealthSearch.search.pubmed.paper.article.PubmedArticle;
import eHealthSearch.search.pubmed.paper.article.PubmedMesh;

@XmlRootElement( name = "MedlineCitation" )
@XmlAccessorType(XmlAccessType.FIELD)

public class PubmedMedlineCitation {
	
	@XmlElement(name = "DateCompleted")
	private PubmedDate date;
	
	@XmlElementWrapper(name = "MeshHeadingList")
	@XmlElement(name = "MeshHeading")
	private List<PubmedMesh> meshTerms;
	
	@XmlElement(name="Article")
	private PubmedArticle article;

	public List<PubmedMesh> getMeshTerms() {
		return meshTerms;
	}

	public void setMeshTerms(List<PubmedMesh> meshTerms) {
		this.meshTerms = meshTerms;
	}

	public PubmedArticle getArticle() {
		return article;
	}

	public void setArticle(PubmedArticle article) {
		this.article = article;
	}
	
	

	public PubmedDate getDate() {
		return date;
	}

	public void setDate(PubmedDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "PubmedMedlineCitation [date=" + date + ", meshTerms=" + meshTerms + ", article=" + article + "]";
	}
}
