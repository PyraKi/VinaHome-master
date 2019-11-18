package entity;

import java.time.LocalDate;
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
@Table(name="PhieuDichvu")
@NamedNativeQuery(name="getPhieuDichvu",query="db.PhieuDichvu.find({})",resultClass=PhieuDichvu.class)
public class PhieuDichvu {
	@Id
	private String maPhieuDV;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="maNV")
	private NhanVien nhanVien;
	private LocalDate ngaylap;
	@OneToMany(fetch=FetchType.LAZY)
	private List<ChitietPhieuDichvu> dschitietPhieuDichvu;
	public String getMaPhieuDV() {
		return maPhieuDV;
	}
	public void setMaPhieuDV(String maPhieuDV) {
		this.maPhieuDV = maPhieuDV;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	public LocalDate getNgaylap() {
		return ngaylap;
	}
	public void setNgaylap(LocalDate ngaylap) {
		this.ngaylap = ngaylap;
	}
	public List<ChitietPhieuDichvu> getDschitietPhieuDichvu() {
		return dschitietPhieuDichvu;
	}
	public void setDschitietPhieuDichvu(List<ChitietPhieuDichvu> dschitietPhieuDichvu) {
		this.dschitietPhieuDichvu = dschitietPhieuDichvu;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maPhieuDV == null) ? 0 : maPhieuDV.hashCode());
		return result;
	}
	public PhieuDichvu(String maPhieuDV, NhanVien nhanVien, LocalDate ngaylap,
			List<ChitietPhieuDichvu> dschitietPhieuDichvu) {
		super();
		this.maPhieuDV = maPhieuDV;
		this.nhanVien = nhanVien;
		this.ngaylap = ngaylap;
		this.dschitietPhieuDichvu = dschitietPhieuDichvu;
	}
	public PhieuDichvu() {
		super();
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhieuDichvu other = (PhieuDichvu) obj;
		if (maPhieuDV == null) {
			if (other.maPhieuDV != null)
				return false;
		} else if (!maPhieuDV.equals(other.maPhieuDV))
			return false;
		return true;
	}
	public double ThanhTien() {
		double s = 0;
		for (ChitietPhieuDichvu chitietPhieuDichvu : dschitietPhieuDichvu) 
			s += chitietPhieuDichvu.ThanhTien();
		return s;
	}
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PhieuDichvu [maPhieuDV=");
		builder.append(maPhieuDV);
		builder.append(", nhanVien=");
		builder.append(nhanVien);
		builder.append(", ngaylap=");
		builder.append(ngaylap);
		builder.append(", dschitietPhieuDichvu=");
		builder.append(dschitietPhieuDichvu);
		builder.append(", birthYear=");
		builder.append("]");
		return builder.toString();
	}
}
