package org.ntnu.torbjoto.eHealthSearch.importers.pubmed.paper.meta;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.ntnu.torbjoto.eHealthSearch.importers.pubmed.paper.PubmedDate;

@XmlRootElement( name = "PubmedData" )
@XmlAccessorType(XmlAccessType.FIELD)
public class PubmedData {
	
	@XmlElementWrapper(name = "ArticleIdList")
	@XmlElement(name = "ArticleId")
	private List<PubmedIdentity> ids;
	
	@XmlElementWrapper(name = "ReferenceList")
	@XmlElement(name = "Reference")
	private List<Reference> refs;
	
	@XmlElementWrapper(name = "History")
	@XmlElement(name = "PubMedPubDate")
	private List<PubmedDate> dates;
	
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
	
	public List<PubmedDate> getDates() {
		return dates;
	}

	public void setDates(List<PubmedDate> dates) {
		this.dates = dates;
	}

	@Override
	public String toString() {
		return "PubmedData [ids=" + ids + ", refs=" + refs + "]";
	}
}
