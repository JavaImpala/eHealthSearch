package eHealthSearch.importers.pubmed.paper.meta;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement( name = "ArticleId" )
@XmlAccessorType(XmlAccessType.FIELD)

public class PubmedIdentity {
	
	@XmlAttribute(name="IdType")
	private String idType;
	
	@XmlValue
	private String id;

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "PubmedIdentity [idType=" + idType + ", id=" + id + "]";
	}
	
	
}
