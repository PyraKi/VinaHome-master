package entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ChitietHoadon")
@NamedNativeQuery(name="getChitietHoadon",query="db.ChitietHoadon.find({})",resultClass=Hoadon.class)
public class ChitietHoadon {
	@Id
	private String maCTHD;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="maPhong")
	private Phong phong;
	@OneToMany(fetch=FetchType.LAZY)
	private List<PhieuDichvu> phieuDichvus;
	public String getMaCTHD() {
		return maCTHD;
	}
	public void setMaCTHD(String maCTHD) {
		this.maCTHD = maCTHD;
	}
	public Phong getPhong() {
		return phong;
	}
	public void setPhong(Phong phong) {
		this.phong = phong;
	}
	public List<PhieuDichvu> getPhieuDichvus() {
		return phieuDichvus;
	}
	public void setPhieuDichvus(List<PhieuDichvu> phieuDichvus) {
		this.phieuDichvus = phieuDichvus;
	}
	public ChitietHoadon(String maCTHD, Phong phong, List<PhieuDichvu> phieuDichvus) {
		super();
		this.maCTHD = maCTHD;
		this.phong = phong;
		this.phieuDichvus = phieuDichvus;
	}
	public ChitietHoadon() {
		super();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maCTHD == null) ? 0 : maCTHD.hashCode());
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
		ChitietHoadon other = (ChitietHoadon) obj;
		if (maCTHD == null) {
			if (other.maCTHD != null)
				return false;
		} else if (!maCTHD.equals(other.maCTHD))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ChitietHoadon [maCTHD=" + maCTHD + ", phong=" + phong + ", phieuDichvus=" + phieuDichvus + "]";
	}
	public double ThanhTien() {
		double s = 0;
		for (PhieuDichvu phieuDichvu : phieuDichvus) {
			s += phieuDichvu.ThanhTien();
		}
		return s;
	}
}
