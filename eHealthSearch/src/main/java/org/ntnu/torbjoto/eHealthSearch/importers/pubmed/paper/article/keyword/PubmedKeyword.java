package org.ntnu.torbjoto.eHealthSearch.importers.pubmed.paper.article.keyword;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement( name = "Keyword" )
@XmlAccessorType(XmlAccessType.FIELD)
public class PubmedKeyword {
	@XmlValue
	private String text;
	
	@XmlAttribute(name="MajorTopicYN")
	private String topic;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	@Override
	public String toString() {
		return "PubmedKeyword [text=" + text + ", topic=" + topic + "]";
	}
}
