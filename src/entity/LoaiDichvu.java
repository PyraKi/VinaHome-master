package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@Entity
@Table(name="LoaiDichvu")
@NamedNativeQuery(name="getLoaiDichvu",query="db.LoaiDichvu.find({})",resultClass=LoaiDichvu.class)
public class LoaiDichvu {
	@Id
	private String maLDV;
	private String tenLDV;
	public String getMaLDV() {
		return maLDV;
	}
	public void setMaLDV(String maLDV) {
		this.maLDV = maLDV;
	}
	public String getTenLDV() {
		return tenLDV;
	}
	public void setTenLDV(String tenLDV) {
		this.tenLDV = tenLDV;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maLDV == null) ? 0 : maLDV.hashCode());
		result = prime * result + ((tenLDV == null) ? 0 : tenLDV.hashCode());
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
		LoaiDichvu other = (LoaiDichvu) obj;
		if (maLDV == null) {
			if (other.maLDV != null)
				return false;
		} else if (!maLDV.equals(other.maLDV))
			return false;
		if (tenLDV == null) {
			if (other.tenLDV != null)
				return false;
		} else if (!tenLDV.equals(other.tenLDV))
			return false;
		return true;
	}
	public LoaiDichvu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoaiDichvu(String maLDV, String tenLDV) {
		super();
		this.maLDV = maLDV;
		this.tenLDV = tenLDV;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LoaiDichvu [maLDV=");
		builder.append(maLDV);
		builder.append(", tenLDV=");
		builder.append(tenLDV);
		builder.append("]");
		return builder.toString();
	}
}
