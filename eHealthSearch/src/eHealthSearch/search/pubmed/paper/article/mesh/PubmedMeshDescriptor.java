package eHealthSearch.search.pubmed.paper.article.mesh;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement( name = "DescriptorName" )
@XmlAccessorType(XmlAccessType.FIELD)
public class PubmedMeshDescriptor {
	
	@XmlValue
	private String value;
	
	@XmlAttribute(name="UI")
	private String ui;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public String getUi() {
		return ui;
	}

	public void setUi(String ui) {
		this.ui = ui;
	}

	@Override
	public String toString() {
		return "PubmedMeshQualifier [value=" + value + "]";
	}
}
