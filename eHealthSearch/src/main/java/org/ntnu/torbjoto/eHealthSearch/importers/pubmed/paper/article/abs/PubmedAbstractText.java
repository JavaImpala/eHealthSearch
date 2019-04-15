package org.ntnu.torbjoto.eHealthSearch.importers.pubmed.paper.article.abs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement( name = "AbstractText" )
@XmlAccessorType(XmlAccessType.FIELD)
public class PubmedAbstractText {
	@XmlValue
	private String text;

	public String getText() {
		return text;
	}
	
	
	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "PubmedAbstractText [text=" + text + "]";
	}

	

	
	
	
}
