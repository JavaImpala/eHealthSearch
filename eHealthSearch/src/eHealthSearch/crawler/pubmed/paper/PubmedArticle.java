package eHealthSearch.crawler.pubmed.paper;

import java.util.List;

public class PubmedArticle {
	private PubmedJournal journal;
	private String title;
	private String paperAbstract;
	private List<PubmedAuthor> authors;
	private List<String> publicationType;
	private List<PubmedIdentity> articleIdList;
	private List<PubmedMesh> meshTerms;
	
	
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
	public String getPaperAbstract() {
		return paperAbstract;
	}
	public void setPaperAbstract(String paperAbstract) {
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
	public List<PubmedIdentity> getArticleIdList() {
		return articleIdList;
	}
	public void setArticleIdList(List<PubmedIdentity> articleIdList) {
		this.articleIdList = articleIdList;
	}
	public List<PubmedMesh> getMeshTerms() {
		return meshTerms;
	}
	public void setMeshTerms(List<PubmedMesh> meshTerms) {
		this.meshTerms = meshTerms;
	}
}
