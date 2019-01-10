package eHealthSearch.search.pubmed.paper.article.journal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "Journal" )
@XmlAccessorType(XmlAccessType.FIELD)

public class PubmedJournal {
	
	@XmlElement(name="JournalIssue")
	private PubmedJournalIssue issue;
	
	@XmlElement(name="ISSN")
	private String issn;
	
	@XmlElement(name="Title")
	private String title;
	
	public String getIssn() {
		return issn;
	}

	public void setIssn(String issn) {
		this.issn = issn;
	}

	@XmlElement(name="ISOAbbreviation")
	private String abbr;

	public PubmedJournalIssue getIssue() {
		return issue;
	}

	public void setIssue(PubmedJournalIssue issue) {
		this.issue = issue;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAbbr() {
		return abbr;
	}

	public void setAbbr(String abbr) {
		this.abbr = abbr;
	}

	@Override
	public String toString() {
		return "PubmedJournal [issue=" + issue + ", title=" + title + ", abbr=" + abbr + "]";
	}
	
	
}
