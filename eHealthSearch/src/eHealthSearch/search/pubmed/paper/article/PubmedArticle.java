package eHealthSearch.search.pubmed.paper.article;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import eHealthSearch.search.pubmed.paper.article.journal.PubmedJournal;

@XmlRootElement( name = "Article" )
@XmlAccessorType(XmlAccessType.FIELD)

public class PubmedArticle {
	
	@XmlElement(name="Journal")
	private PubmedJournal journal;
	
	@XmlElement(name="ArticleTitle")
	private String title;
	
	@XmlElement(name="Abstract")
	private PubmedAbstract paperAbstract;
	
	@XmlElementWrapper(name = "AuthorList")
	@XmlElement(name = "Author")
	private List<PubmedAuthor> authors;
	
	@XmlElementWrapper(name = "PublicationTypeList")
	@XmlElement(name = "PublicationType")
	private List<String> publicationType;
	
	@XmlElementWrapper(name = "PublicationTypeList")
	@XmlElement(name = "ArticleId")
	private List<String> articleIdList;
	
	
	/*=====================
	gettere og settere
	=====================*/
	
	public PubmedJournal getJournal() {
		return journal;
	}

	public void setJournal(PubmedJournal journal) {
		this.journal = journal;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public PubmedAbstract getPaperAbstract() {
		return paperAbstract;
	}

	public void setPaperAbstract(PubmedAbstract paperAbstract) {
		this.paperAbstract = paperAbstract;
	}

	public List<PubmedAuthor> getAuthors() {
		return authors;
	}

	public void setAuthors(List<PubmedAuthor> authors) {
		this.authors = authors;
	}

	public List<String> getPublicationType() {
		return publicationType;
	}

	public void setPublicationType(List<String> publicationType) {
		this.publicationType = publicationType;
	}

	public List<String> getArticleIdList() {
		return articleIdList;
	}

	public void setArticleIdList(List<String> articleIdList) {
		this.articleIdList = articleIdList;
	}


	@Override
	public String toString() {
		return "PubmedArticle [journal=" + journal + ", title=" + title + ", paperAbstract=" + paperAbstract
				+ ", authors=" + authors + ", publicationType=" + publicationType + ", articleIdList=" + articleIdList
				+ "]";
	}
}