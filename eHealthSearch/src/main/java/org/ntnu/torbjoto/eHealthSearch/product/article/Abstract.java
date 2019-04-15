package org.ntnu.torbjoto.eHealthSearch.product.article;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="abstract")
public class Abstract {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int abstractId;
	
	@Column(columnDefinition="text")
	private String text;
	
	
	
	public int getAbstractId() {
		return abstractId;
	}

	public void setAbstractId(int abstractId) {
		this.abstractId = abstractId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Abstract [abstractId=" + abstractId + ", text=" + text + "]";
	}
	
	
}
