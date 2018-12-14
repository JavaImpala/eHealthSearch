package eHealthSearch.crawler.pubmed.paper;

import java.util.List;

public class PubmedPublication {
	private int pmid;
	private PubmedDate date;
	private PubmedArticle article;
	private List<PubmedCitation> citations;
	
	
	/*====================
	gettere og settere
	====================*/
	
	public int getPmid() {
		return pmid;
	}

	public void setPmid(int pmid) {
		this.pmid = pmid;
	}

	public PubmedDate getDate() {
		return date;
	}

	public void setDate(PubmedDate date) {
		this.date = date;
	}
	
	
	
	
}