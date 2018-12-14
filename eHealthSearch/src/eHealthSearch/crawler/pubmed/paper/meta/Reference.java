package eHealthSearch.crawler.pubmed.paper.meta;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "Reference" )
@XmlAccessorType(XmlAccessType.FIELD)
public class Reference {
	
	@XmlElement(name = "Citation")
	private String cit;

	@XmlElementWrapper(name = "ArticleIdList")
	@XmlElement(name = "ArticleId")
	private List<String> articleIdList;

	public String getCit() {
		return cit;
	}

	public void setCit(String cit) {
		this.cit = cit;
	}

	public List<String> getArticleIdList() {
		return articleIdList;
	}

	public void setArticleIdList(List<String> articleIdList) {
		this.articleIdList = articleIdList;
	}

	@Override
	public String toString() {
		return "Reference [cit=" + cit + ", articleIdList=" + articleIdList + "]";
	}
}
