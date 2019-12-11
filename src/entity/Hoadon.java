package entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
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
	private LocalDate ngayLap = LocalDate.now();
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="maDP")
	private DatPhong datPhong;
	private double phatsinh = 0;
	private float khuyenmai = 0;
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
	public DatPhong getDatPhong() {
		return datPhong;
	}
	public void setDatPhong(DatPhong datPhong) {
		this.datPhong = datPhong;
	}
	public double getPhatsinh() {
		return phatsinh;
	}
	public void setPhatsinh(double phatsinh) {
		this.phatsinh = phatsinh;
	}
	public float getKhuyenmai() {
		return khuyenmai;
	}
	public void setKhuyenmai(float khuyenmai) {
		this.khuyenmai = khuyenmai;
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
			LocalDate ngayLap, DatPhong datPhong, double phatsinh, float khuyenmai) {
		super();
		this.maHD = maHD;
		this.nhanVien = nhanVien;
		this.khachHang = khachHang;
		this.chitietHoadons = chitietHoadons;
		this.ngayLap = ngayLap;
		this.datPhong = datPhong;
		this.phatsinh = phatsinh;
		this.khuyenmai = khuyenmai;
	}
	public Hoadon() {
		super();
	}
	@Override
	public String toString() {
		return "Hoadon [maHD=" + maHD + ", nhanVien=" + nhanVien + ", khachHang=" + khachHang + ", chitietHoadons="
				+ chitietHoadons + ", ngayLap=" + ngayLap + ", datPhong=" + datPhong + ", phatsinh=" + phatsinh
				+ ", khuyenmai=" + khuyenmai + "]";
	}
	public double TongTien() {
		double s = 0;
		for(Phong phong : datPhong.getPhongs()) {
			String loaithue = datPhong.getLoaiDatPhong();
			
			LocalDateTime fromDateTime = datPhong.getNhanPhong();
			LocalDateTime toDateTime = LocalDateTime.now();

			LocalDateTime tempDateTime = LocalDateTime.from(fromDateTime);

			long months = tempDateTime.until( toDateTime, ChronoUnit.MONTHS);
			tempDateTime = tempDateTime.plusMonths( months );
			
			long days = tempDateTime.until( toDateTime, ChronoUnit.DAYS);
			tempDateTime = tempDateTime.plusDays( days );

			long hours = tempDateTime.until( toDateTime, ChronoUnit.HOURS);
			tempDateTime = tempDateTime.plusHours( hours );

			long minutes = tempDateTime.until( toDateTime, ChronoUnit.MINUTES);
			tempDateTime = tempDateTime.plusMinutes( minutes );
			
			if(loaithue.equalsIgnoreCase("Theo giờ")) {
				if(minutes > 15)
					hours++;
				hours +=  days*24;
				s = phong.getGiaTheogio();
				s = s*(1+1.006*hours);
			}else if(loaithue.equalsIgnoreCase("Qua đêm")) {
				s = phong.getGiaQuadem();
			}else {
				s = phong.getGiaTheongay() * (months*30 + days);
			}
		}
//		if(!chitietHoadons.isEmpty())
//			for (ChitietHoadon chitietHoadon : chitietHoadons) {
//				s += chitietHoadon.ThanhTien();
//			}
		s += phatsinh;
		s -= khuyenmai*s;
		return s;
	}
}
