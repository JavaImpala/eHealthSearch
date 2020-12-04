package org.ntnu.torbjoto.eHealthSearch.importers.pubmed.paper;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "PubMedPubDate" )
@XmlAccessorType(XmlAccessType.FIELD)

public class PubmedDate {
	
	@XmlElement(name = "Year")
	private int year;
	
	@XmlElement(name = "Month")
	private int month;
	
	@XmlElement(name = "Day")
	private int day;
	
	@XmlAttribute(name = "PubStatus")
	private String type;

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "PubmedDate [year=" + year + ", month=" + month + ", day=" + day + ", type=" + type + "]";
	}
}
