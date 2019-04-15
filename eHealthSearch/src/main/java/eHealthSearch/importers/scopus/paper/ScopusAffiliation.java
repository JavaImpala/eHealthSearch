package eHealthSearch.importers.scopus.paper;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "affiliation" )
@XmlAccessorType(XmlAccessType.FIELD)

public class ScopusAffiliation {
	
	@XmlElement(name = "affiliation-url",namespace="http://www.w3.org/2005/Atom")
	String affUrl;
	
	@XmlElement(name = "afid",namespace="http://www.w3.org/2005/Atom")
	String afid;
	
	@XmlElement(name = "affilname",namespace="http://www.w3.org/2005/Atom")
	String affilname;
	
	@XmlElement(name = "affiliation-city",namespace="http://www.w3.org/2005/Atom")
	String affilCity;
	
	@XmlElement(name = "affiliation-country",namespace="http://www.w3.org/2005/Atom")
	String affilContry;

	public String getAffUrl() {
		return affUrl;
	}

	public void setAffUrl(String affUrl) {
		this.affUrl = affUrl;
	}

	public String getAfid() {
		return afid;
	}

	public void setAfid(String afid) {
		this.afid = afid;
	}

	public String getAffilname() {
		return affilname;
	}

	public void setAffilname(String affilname) {
		this.affilname = affilname;
	}

	public String getAffilCity() {
		return affilCity;
	}

	public void setAffilCity(String affilCity) {
		this.affilCity = affilCity;
	}

	public String getAffilContry() {
		return affilContry;
	}

	public void setAffilContry(String affilContry) {
		this.affilContry = affilContry;
	}

	@Override
	public String toString() {
		return "ScopusAffiliation [affUrl=" + affUrl + ", afid=" + afid + ", affilname=" + affilname + ", affilCity="
				+ affilCity + ", affilContry=" + affilContry + "]";
	}
}
