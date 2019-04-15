package org.ntnu.torbjoto.eHealthSearch.importers.pubmed.paper.meta;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "PubmedData" )
@XmlAccessorType(XmlAccessType.FIELD)
public class PubmedData {
	
	@XmlElementWrapper(name = "ArticleIdList")
	@XmlElement(name = "ArticleId")
	private List<PubmedIdentity> ids;
	
	@XmlElementWrapper(name = "ReferenceList")
	@XmlElement(name = "Reference")
	private List<Reference> refs;
	
	public List<PubmedIdentity> getIds() {
		return ids;
	}

	public void setIds(List<PubmedIdentity> ids) {
		this.ids = ids;
	}
	
	public List<Reference> getRefs() {
		return refs;
	}

	public void setRefs(List<Reference> refs) {
		this.refs = refs;
	}

	@Override
	public String toString() {
		return "PubmedData [ids=" + ids + ", refs=" + refs + "]";
	}
}
