package eHealthSearch.crawler.pubmed;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "Id")
@XmlAccessorType (XmlAccessType.FIELD)
public class Id {
	@XmlValue
	private long id;

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		System.out.println("halo?");
		this.id = id;
	}

	@Override
	public String toString() {
		return "Id [pmid=" + id + "]";
	}
}
