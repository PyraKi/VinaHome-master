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
	@JoinColumn(name="maPhieuDichvu")
	private List<ChitietPhieuDichvu> dschitietPhieuDichvu;
	private Double thanhtien;
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
	public Double getThanhtien() {
		return thanhtien;
	}
	public void setThanhtien(Double thanhtien) {
		this.thanhtien = thanhtien;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maPhieuDV == null) ? 0 : maPhieuDV.hashCode());
		return result;
	}
	public PhieuDichvu(String maPhieuDV, NhanVien nhanVien, LocalDate ngaylap,
			List<ChitietPhieuDichvu> dschitietPhieuDichvu, Double thanhtien) {
		super();
		this.maPhieuDV = maPhieuDV;
		this.nhanVien = nhanVien;
		this.ngaylap = ngaylap;
		this.dschitietPhieuDichvu = dschitietPhieuDichvu;
		this.thanhtien = thanhtien;
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
		builder.append(", thanhtien=");
		builder.append(thanhtien);
		builder.append(", birthYear=");
		builder.append("]");
		return builder.toString();
	}
}
