package eHealthSearch.crawler.pubmed.paper.article.journal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "JournalIssue" )
@XmlAccessorType(XmlAccessType.FIELD)
public class PubmedJournalIssue {
	@XmlElement(name="Volume")
	private int volume;
	
	@XmlElement(name="Issue")
	private int issue;
	
	@XmlElement(name="PubDate")
	private PubmedJournalPubDate pub;

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public int getIssue() {
		return issue;
	}

	public void setIssue(int issue) {
		this.issue = issue;
	}

	public PubmedJournalPubDate getPub() {
		return pub;
	}

	public void setPub(PubmedJournalPubDate pub) {
		this.pub = pub;
	}

	@Override
	public String toString() {
		return "PubmedJournalIssue [volume=" + volume + ", issue=" + issue + ", pub=" + pub + "]";
	}
	
	
}
