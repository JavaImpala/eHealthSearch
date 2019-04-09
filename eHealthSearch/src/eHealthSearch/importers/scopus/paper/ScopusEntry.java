package eHealthSearch.importers.scopus.paper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "entry")
@XmlAccessorType(XmlAccessType.FIELD)

public class ScopusEntry {
	
	@XmlElement(name = "title",namespace="http://purl.org/dc/elements/1.1/")
	String title;
	
	@XmlElement(name = "creator",namespace="http://purl.org/dc/elements/1.1/")
	String creator;
	
	@XmlElement(name = "publicationName",namespace="http://prismstandard.org/namespaces/basic/2.0/")
	String journal;
	
	@XmlElement(name = "doi",namespace="http://prismstandard.org/namespaces/basic/2.0/")
	String doi;
	
	@XmlElement(name = "description",namespace="http://purl.org/dc/elements/1.1/")
	String description;
	
	@XmlElement(name = "author",namespace="http://www.w3.org/2005/Atom")
	List<ScopusAuthor> authors=new ArrayList<>();
	
	@XmlElement(name = "affiliation",namespace="http://www.w3.org/2005/Atom")
	ScopusAffiliation affiliation;
	
	@XmlElement(name = "authkeywords",namespace="http://www.w3.org/2005/Atom")
	String keywords="";

	public ScopusAffiliation getAffiliation() {
		return affiliation;
	}

	public void setAffiliation(ScopusAffiliation affiliation) {
		this.affiliation = affiliation;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getJournal() {
		return journal;
	}

	public void setJournal(String journal) {
		this.journal = journal;
	}

	public String getDoi() {
		return doi;
	}

	public void setDoi(String doi) {
		this.doi = doi;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<ScopusAuthor> getAuthors() {
		return authors;
	}

	public void setAuthors(List<ScopusAuthor> authors) {
		this.authors = authors;
	}

	public List<String> getKeywords() {
		if(keywords=="") {
			return new ArrayList<>();
		}
		
	
		
		return Arrays.asList(keywords.split("\\|"))
				.stream()
				.map(s->s.replaceAll("\\s+",""))
				.collect(Collectors.toList());
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	@Override
	public String toString() {
		return "ScopusEntry [title=" + title + ", creator=" + creator + ", journal=" + journal + ", doi=" + doi
				+ ", description=" + description + ", authors=" + authors + ", affiliation=" + affiliation
				+ ", keywords=" + keywords + "]";
	}

	
}
