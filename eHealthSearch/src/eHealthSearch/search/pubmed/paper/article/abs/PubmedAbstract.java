package eHealthSearch.search.pubmed.paper.article.abs;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "Abstract" )
@XmlAccessorType(XmlAccessType.FIELD)
public class PubmedAbstract {
	
	@XmlAnyElement(BodyDomHandler.class)
	private ArrayList<String> text;
	
	public ArrayList<String> getText() {
		return text;
	}

	public void setText(ArrayList<String> text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "PubmedAbstract [text=" + text + "]";
	}
}
