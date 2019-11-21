package entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@Entity
@Table(name="DatPhong")
@NamedNativeQuery(name="getDatPhong",query="db.DatPhong.find({})",resultClass=DatPhong.class)
public class DatPhong {
	@Id
	private String maDP;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="maKH")
	private KhachHang khachHang;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="maPhong")
	private Phong phong;
	private String loaiDatPhong;
	private LocalDate ngayDatPhong;
	private LocalTime gioDatPhong;
	private LocalDate ngayTraPhong;
	private LocalTime gioTraPhong;
	private LocalDateTime nhanPhong;
	public String getMaDP() {
		return maDP;
	}
	public void setMaDP(String maDP) {
		this.maDP = maDP;
	}
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	public Phong getPhong() {
		return phong;
	}
	public void setPhong(Phong phong) {
		this.phong = phong;
	}
	public String getLoaiDatPhong() {
		return loaiDatPhong;
	}
	public void setLoaiDatPhong(String loaiDatPhong) {
		this.loaiDatPhong = loaiDatPhong;
	}
	public LocalDate getNgayDatPhong() {
		return ngayDatPhong;
	}
	public void setNgayDatPhong(LocalDate ngayDatPhong) {
		this.ngayDatPhong = ngayDatPhong;
	}
	public LocalTime getGioDatPhong() {
		return gioDatPhong;
	}
	public void setGioDatPhong(LocalTime gioDatPhong) {
		this.gioDatPhong = gioDatPhong;
	}
	public LocalDate getNgayTraPhong() {
		return ngayTraPhong;
	}
	public void setNgayTraPhong(LocalDate ngayTraPhong) {
		this.ngayTraPhong = ngayTraPhong;
	}
	public LocalTime getGioTraPhong() {
		return gioTraPhong;
	}
	public void setGioTraPhong(LocalTime gioTraPhong) {
		this.gioTraPhong = gioTraPhong;
	}
	public LocalDateTime getNhanPhong() {
		return nhanPhong;
	}
	public void setNhanPhong(LocalDateTime nhanPhong) {
		this.nhanPhong = nhanPhong;
	}
	public DatPhong(String maDP, KhachHang khachHang, Phong phong, String loaiDatPhong, LocalDate ngayDatPhong,
			LocalTime gioDatPhong, LocalDate ngayTraPhong, LocalTime gioTraPhong, LocalDateTime nhanPhong) {
		super();
		this.maDP = maDP;
		this.khachHang = khachHang;
		this.phong = phong;
		this.loaiDatPhong = loaiDatPhong;
		this.ngayDatPhong = ngayDatPhong;
		this.gioDatPhong = gioDatPhong;
		this.ngayTraPhong = ngayTraPhong;
		this.gioTraPhong = gioTraPhong;
		this.nhanPhong = nhanPhong;
	}
	public DatPhong() {
		super();
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DatPhong [maDP=");
		builder.append(maDP);
		builder.append(", khachHang=");
		builder.append(khachHang);
		builder.append(", loaiDatPhong=");
		builder.append(loaiDatPhong);
		builder.append(", ngayDatPhong=");
		builder.append(ngayDatPhong);
		builder.append(", gioDatPhong=");
		builder.append(gioDatPhong);
		builder.append(", ngayTraPhong=");
		builder.append(ngayTraPhong);
		builder.append(", ngayTraPhong=");
		builder.append(ngayTraPhong);
		builder.append(", gioTraPhong=");
		builder.append(gioTraPhong);
		builder.append(", nhanPhong=");
		builder.append(nhanPhong);
		builder.append("]");
		return builder.toString();
	}
}
