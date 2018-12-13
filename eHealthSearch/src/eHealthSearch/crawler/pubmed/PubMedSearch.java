package eHealthSearch.crawler.pubmed;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement(name = "eSearchResult")
@XmlAccessorType(XmlAccessType.FIELD)

public class PubMedSearch {
	
	
    @XmlElementWrapper(name = "IdList")
    @XmlElement(name = "Id")
    List<Id> idList=new ArrayList<>();
	
	public List<Id> getIds() {
        return idList;
    }
	
    public void setIds(List<Id> idList) {
    	this.idList=idList;
    }
    
    public void add(Id id) {
        
        this.idList.add(id);
    }

	@Override
	public String toString() {
		return "PubMedSearch [idList=" + idList + "]";
	}
}
