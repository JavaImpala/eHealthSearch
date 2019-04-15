package org.ntnu.torbjoto.eHealthSearch.importers.pubmed.paper.article.mesh;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "MeshHeading" )
@XmlAccessorType(XmlAccessType.FIELD)

public class PubmedMesh {
	@XmlElement(name="DescriptorName")
	private PubmedMeshDescriptor descriptorVal;
	
	@XmlElement(name="QualifierName")
	private ArrayList<PubmedMeshQualifier> qualifierVal;
	
	public PubmedMesh() {
		
	}
	
	
	
	public PubmedMeshDescriptor getDescriptorVal() {
		return descriptorVal;
	}



	public void setDescriptorVal(PubmedMeshDescriptor descriptorVal) {
		this.descriptorVal = descriptorVal;
	}



	public ArrayList<PubmedMeshQualifier> getQualifierVal() {
		return qualifierVal;
	}

	public void setQualifierVal(ArrayList<PubmedMeshQualifier> qualifierVal) {
		this.qualifierVal = qualifierVal;
	}

	@Override
	public String toString() {
		return "PubmedMesh [descriptorVal=" + descriptorVal + ", qualifierVal=" + qualifierVal + "]";
	}
	
	
	
}
