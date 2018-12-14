package eHealthSearch.crawler.pubmed.paper.article;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "MeshHeading" )
@XmlAccessorType(XmlAccessType.FIELD)

public class PubmedMesh {
	@XmlElement(name="DescriptorName")
	private String descriptorVal;
	
	@XmlElement(name="QualifierName")
	private String qualifierVal;

	public String getDescriptorVal() {
		return descriptorVal;
	}

	public void setDescriptorVal(String descriptorVal) {
		this.descriptorVal = descriptorVal;
	}

	public String getQualifierVal() {
		return qualifierVal;
	}

	public void setQualifierVal(String qualifierVal) {
		this.qualifierVal = qualifierVal;
	}

	@Override
	public String toString() {
		return "PubmedMesh [descriptorVal=" + descriptorVal + ", qualifierVal=" + qualifierVal + "]";
	}
	
	
	
}
