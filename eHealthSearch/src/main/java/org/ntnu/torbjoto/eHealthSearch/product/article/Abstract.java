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
	private int abstract_id;
	
	@Column(columnDefinition="text")
	private String text;
	
	public int getAbstractId() {
		return abstract_id;
	}

	public void setAbstractId(int abstractId) {
		this.abstract_id = abstractId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Abstract [abstractId=" + abstract_id + ", text=" + text + "]";
	}
	
	
}
