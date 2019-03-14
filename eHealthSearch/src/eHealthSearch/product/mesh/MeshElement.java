package eHealthSearch.product.mesh;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mesh_element")
public class MeshElement {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int meshElementId;
	
	@Column(name="ui")
	private String ui;
	
	@Column(name="value")
	private String value;

	public int getMeshElementId() {
		return meshElementId;
	}

	public void setMeshElementId(int meshElementId) {
		this.meshElementId = meshElementId;
	}

	public String getUi() {
		return ui;
	}

	public void setUi(String ui) {
		this.ui = ui;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ui == null) ? 0 : ui.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		MeshElement other = (MeshElement) obj;
		if (ui == null) {
			if (other.ui != null)
				return false;
		} else if (!ui.equals(other.ui))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MeshElement [meshElementId=" + meshElementId + ", ui=" + ui + ", value=" + value + "]";
	}
	
	
	
}
