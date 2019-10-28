package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@Entity
@Table(name="Giuong")
@NamedNativeQuery(name="getGiuong",query="db.Giuong.find({})",resultClass=Giuong.class)
public class Giuong {
	@Id
	private String maGiuong;
	private String loaiGiuong;
	public String getMaGiuong() {
		return maGiuong;
	}
	public void setMaGiuong(String maGiuong) {
		this.maGiuong = maGiuong;
	}
	public String getLoaiGiuong() {
		return loaiGiuong;
	}
	public void setLoaiGiuong(String loaiGiuong) {
		this.loaiGiuong = loaiGiuong;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((loaiGiuong == null) ? 0 : loaiGiuong.hashCode());
		result = prime * result + ((maGiuong == null) ? 0 : maGiuong.hashCode());
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
		Giuong other = (Giuong) obj;
		if (loaiGiuong == null) {
			if (other.loaiGiuong != null)
				return false;
		} else if (!loaiGiuong.equals(other.loaiGiuong))
			return false;
		if (maGiuong == null) {
			if (other.maGiuong != null)
				return false;
		} else if (!maGiuong.equals(other.maGiuong))
			return false;
		return true;
	}
	public Giuong(String maGiuong, String loaiGiuong) {
		super();
		this.maGiuong = maGiuong;
		this.loaiGiuong = loaiGiuong;
	}
	public Giuong() {
		super();
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Giuong [maGiuong=");
		builder.append(maGiuong);
		builder.append(", loaiGiuong=");
		builder.append(loaiGiuong);
		builder.append("]");
		return builder.toString();
	}
}
