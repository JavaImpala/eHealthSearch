package eHealthSearch.search.scopus.paper;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "author")
@XmlAccessorType(XmlAccessType.FIELD)

public class ScopusAuthor {
	
	@XmlElement(name = "author-url",namespace="http://www.w3.org/2005/Atom")
	String authorUrl;
	
	@XmlElement(name = "authid",namespace="http://www.w3.org/2005/Atom")
	String authid;
	
	@XmlElement(name = "surname",namespace="http://www.w3.org/2005/Atom")
	String surname;
	
	@XmlElement(name = "given-name",namespace="http://www.w3.org/2005/Atom")
	String givenName;
	
	@XmlElement(name = "afid",namespace="http://www.w3.org/2005/Atom")
	String afId;

	public String getAuthorUrl() {
		return authorUrl;
	}
	
	
	
	public void setAuthorUrl(String authorUrl) {
		this.authorUrl = authorUrl;
	}

	public String getAuthid() {
		return authid;
	}

	public void setAuthid(String authid) {
		this.authid = authid;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getGivenName() {
		return givenName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	public String getAfId() {
		return afId;
	}

	public void setAfId(String afId) {
		this.afId = afId;
	}

	@Override
	public String toString() {
		return "ScopusAuthor [authorUrl=" + authorUrl + ", authid=" + authid + ", surname=" + surname + ", givenName="
				+ givenName + ", afId=" + afId + "]";
	}
}
