package org.ntnu.torbjoto.eHealthSearch.product.affiliation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="affiliation")
public class Affiliation{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int affiliation_id;
	
	@Column(columnDefinition="text")
	private String name;
	
	public int getAffiliationId() {
		return affiliation_id;
	}

	public void setAffiliationId(int affiliationId) {
		this.affiliation_id = affiliationId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
