package eHealthSearch.importers.pubmed.paper.article.journal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "PubDate" )
@XmlAccessorType(XmlAccessType.FIELD)
public class PubmedJournalPubDate {
	
	@XmlElement(name="Year")
	private int year;
	
	@XmlElement(name="Month")
	private String month;

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	@Override
	public String toString() {
		return "PubmedJournalPubDate [year=" + year + ", month=" + month + "]";
	}
	
	
}
