package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@Entity
@Table(name="LoaiPhong")
@NamedNativeQuery(name="getLoaiPhong",query="db.LoaiPhong.find({})",resultClass=LoaiPhong.class)
public class LoaiPhong {
	@Id
	private String maLP;
	private String TenLoaiphong;
	public String getMaLP() {
		return maLP;
	}
	public void setMaLP(String maLP) {
		this.maLP = maLP;
	}
	public String getTenLoaiphong() {
		return TenLoaiphong;
	}
	public void setTenLoaiphong(String tenLoaiphong) {
		TenLoaiphong = tenLoaiphong;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((TenLoaiphong == null) ? 0 : TenLoaiphong.hashCode());
		result = prime * result + ((maLP == null) ? 0 : maLP.hashCode());
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
		LoaiPhong other = (LoaiPhong) obj;
		if (TenLoaiphong == null) {
			if (other.TenLoaiphong != null)
				return false;
		} else if (!TenLoaiphong.equals(other.TenLoaiphong))
			return false;
		if (maLP == null) {
			if (other.maLP != null)
				return false;
		} else if (!maLP.equals(other.maLP))
			return false;
		return true;
	}
	public LoaiPhong(String maLP, String tenLoaiphong) {
		super();
		this.maLP = maLP;
		TenLoaiphong = tenLoaiphong;
	}
	public LoaiPhong() {
		super();
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LoaiPhong [maLP=");
		builder.append(maLP);
		builder.append(", TenLoaiphong=");
		builder.append(TenLoaiphong);
		builder.append("]");
		return builder.toString();
	}
}
