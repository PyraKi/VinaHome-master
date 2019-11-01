package entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@Entity
@Table(name="ChitietPhieuDichvu")
@NamedNativeQuery(name="getChitietPhieuDichvu",query="db.ChitietPhieuDichvu.find({})",resultClass=ChitietPhieuDichvu.class)
public class ChitietPhieuDichvu {
	@Id
	private String maPhieuDichvu;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="maDV")
	private Dichvu dichvu;
	private int soluong;
	private double thanhTien;
	public String getMaPhieuDichvu() {
		return maPhieuDichvu;
	}

	public void setMaPhieuDichvu(String maPhieuDichvu) {
		this.maPhieuDichvu = maPhieuDichvu;
	}

	public Dichvu getDichvu() {
		return dichvu;
	}

	public void setDichvu(Dichvu dichvu) {
		this.dichvu = dichvu;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public double getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(double thanhTien) {
		this.thanhTien = thanhTien;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dichvu == null) ? 0 : dichvu.hashCode());
		result = prime * result + ((maPhieuDichvu == null) ? 0 : maPhieuDichvu.hashCode());
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
		ChitietPhieuDichvu other = (ChitietPhieuDichvu) obj;
		if (dichvu == null) {
			if (other.dichvu != null)
				return false;
		} else if (!dichvu.equals(other.dichvu))
			return false;
		if (maPhieuDichvu == null) {
			if (other.maPhieuDichvu != null)
				return false;
		} else if (!maPhieuDichvu.equals(other.maPhieuDichvu))
			return false;
		return true;
	}
	public ChitietPhieuDichvu(String maPhieuDichvu, Dichvu dichvu, int soluong, double thanhTien) {
		super();
		this.maPhieuDichvu = maPhieuDichvu;
		this.dichvu = dichvu;
		this.soluong = soluong;
		this.thanhTien = thanhTien;
	}
	public ChitietPhieuDichvu() {
		super();
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ChitietPhieuDichvu [maPhieuDichvu=");
		builder.append(maPhieuDichvu);
		builder.append(", dichvu=");
		builder.append(dichvu);
		builder.append(", soluong=");
		builder.append(soluong);
		builder.append(", thanhTien=");
		builder.append(thanhTien);
		builder.append("]");
		return builder.toString();
	}
}
