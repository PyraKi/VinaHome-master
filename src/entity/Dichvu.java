package entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@Entity
@Table(name="Dichvu")
@NamedNativeQuery(name="getDichvu",query="db.Dichvu.find({})",resultClass=Dichvu.class)
public class Dichvu {
	@Id
	private String maDV;
	private String tenDV;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="maLDV")
	private LoaiDichvu loaiDichvu;
	private double gia;
	private int soluong;
	public String getMaDV() {
		return maDV;
	}
	public void setMaDV(String maDV) {
		this.maDV = maDV;
	}
	public String getTenDV() {
		return tenDV;
	}
	public void setTenDV(String tenDV) {
		this.tenDV = tenDV;
	}
	public LoaiDichvu getLoaiDichvu() {
		return loaiDichvu;
	}
	public void setLoaiDichvu(LoaiDichvu loaiDichvu) {
		this.loaiDichvu = loaiDichvu;
	}
	public double getGia() {
		return gia;
	}
	public void setGia(double gia) {
		this.gia = gia;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maDV == null) ? 0 : maDV.hashCode());
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
		Dichvu other = (Dichvu) obj;
		if (maDV == null) {
			if (other.maDV != null)
				return false;
		} else if (!maDV.equals(other.maDV))
			return false;
		return true;
	}
	public Dichvu(String maDV, String tenDV, LoaiDichvu loaiDichvu, double gia, int soluong) {
		super();
		this.maDV = maDV;
		this.tenDV = tenDV;
		this.loaiDichvu = loaiDichvu;
		this.gia = gia;
		this.soluong = soluong;
	}
	public Dichvu() {
		super();
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Dichvu [maDV=");
		builder.append(maDV);
		builder.append(", tenDV=");
		builder.append(tenDV);
		builder.append(", loaiDichvu=");
		builder.append(loaiDichvu);
		builder.append(", gia=");
		builder.append(gia);
		builder.append(", soluong=");
		builder.append(soluong);
		builder.append("]");
		return builder.toString();
	}
}
