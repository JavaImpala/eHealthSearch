package eHealthSearch.product.affiliation;

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
	private int affiliationId;
	
	@Column(columnDefinition="text")
	private String name;

	public int getAffiliationId() {
		return affiliationId;
	}

	public void setAffiliationId(int affiliationId) {
		this.affiliationId = affiliationId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
