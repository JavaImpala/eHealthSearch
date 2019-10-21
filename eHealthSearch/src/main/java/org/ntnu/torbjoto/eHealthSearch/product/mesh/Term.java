package org.ntnu.torbjoto.eHealthSearch.product.mesh;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="mesh_term")
public class Term {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int termId;
	
	@OneToOne(cascade = {CascadeType.ALL})
	private MeshElement descriptor;
	
	@ManyToMany(cascade = {CascadeType.ALL})
	private List<MeshElement> qualifier;

	public int getTermId() {
		return termId;
	}

	public void setTermId(int termId) {
		this.termId = termId;
	}

	public MeshElement getDescriptor() {
		return descriptor;
	}

	public void setDescriptor(MeshElement descriptor) {
		this.descriptor = descriptor;
	}

	public List<MeshElement> getQualifier() {
		return qualifier;
	}

	public void setQualifiers(List<MeshElement> qualifier) {
		this.qualifier = qualifier;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descriptor == null) ? 0 : descriptor.hashCode());
		result = prime * result + ((qualifier == null) ? 0 : qualifier.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Term other = (Term) obj;
		if (descriptor == null) {
			if (other.descriptor != null)
				return false;
		} else if (!descriptor.equals(other.descriptor))
			return false;
		if (qualifier == null) {
			if (other.qualifier != null)
				return false;
		} else if (!qualifier.equals(other.qualifier))
			return false;
		return true;
	}

	
	
	
	
}
