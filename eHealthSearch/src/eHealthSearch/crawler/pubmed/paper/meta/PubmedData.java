package eHealthSearch.crawler.pubmed.paper.meta;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "PubmedData" )
@XmlAccessorType(XmlAccessType.FIELD)
public class PubmedData {
	
	@XmlElementWrapper(name = "ReferenceList")
	@XmlElement(name = "Reference")
	private List<Reference> articleIdList;

	@Override
	public String toString() {
		return "PubmedData [references=" + articleIdList + "]";
	}
	
	
}
