package eHealthSearch.crawler.pubmed.paper.article;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "Abstract" )
@XmlAccessorType(XmlAccessType.FIELD)
public class PubmedAbstract {
	
	@XmlElement(name="AbstractText")
	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "PubmedAbstract [text=" + text + "]";
	}
	
	
}
