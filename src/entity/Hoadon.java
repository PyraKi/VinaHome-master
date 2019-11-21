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
@Table(name="Hoadon")
@NamedNativeQuery(name="getHoadon",query="db.Hoadon.find({})",resultClass=Hoadon.class)
public class Hoadon {
	@Id
	private String maHD;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="maNV")
	private NhanVien nhanVien;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="maKH")
	private KhachHang khachHang;
	@OneToMany(fetch=FetchType.LAZY)
	private List<ChitietHoadon> chitietHoadons;
	private LocalDate ngayLap;
	public String getMaHD() {
		return maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	public List<ChitietHoadon> getChitietHoadons() {
		return chitietHoadons;
	}
	public void setChitietHoadons(List<ChitietHoadon> chitietHoadons) {
		this.chitietHoadons = chitietHoadons;
	}
	public LocalDate getNgayLap() {
		return ngayLap;
	}
	public void setNgayLap(LocalDate ngayLap) {
		this.ngayLap = ngayLap;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maHD == null) ? 0 : maHD.hashCode());
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
		Hoadon other = (Hoadon) obj;
		if (maHD == null) {
			if (other.maHD != null)
				return false;
		} else if (!maHD.equals(other.maHD))
			return false;
		return true;
	}
	public Hoadon(String maHD, NhanVien nhanVien, KhachHang khachHang, List<ChitietHoadon> chitietHoadons,
			LocalDate ngayLap) {
		super();
		this.maHD = maHD;
		this.nhanVien = nhanVien;
		this.khachHang = khachHang;
		this.chitietHoadons = chitietHoadons;
		this.ngayLap = ngayLap;
	}
	public Hoadon() {
		super();
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Hoadon [maHD=");
		builder.append(maHD);
		builder.append(", nhanVien=");
		builder.append(nhanVien);
		builder.append(", khachHang=");
		builder.append(khachHang);
		builder.append(", chitietHoadons=");
		builder.append(chitietHoadons);
		builder.append(", ngayLap=");
		builder.append(ngayLap);
		builder.append("]");
		return builder.toString();
	}
	public double TongTien() {
		double s = 0;
		for (ChitietHoadon chitietHoadon : chitietHoadons) 
			s += chitietHoadon.thanhTien();
		return s;
	}
}
