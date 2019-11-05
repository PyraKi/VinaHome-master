package entity;

import java.time.LocalDate;
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
	private String loaiDatPhong;
	private LocalDate ngayDatPhong;
	private LocalTime gioDatPhong;
	private LocalDate ngayTraPhong;
	private LocalTime gioTraPhong;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((khachHang == null) ? 0 : khachHang.hashCode());
		result = prime * result + ((maDP == null) ? 0 : maDP.hashCode());
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
		DatPhong other = (DatPhong) obj;
		if (khachHang == null) {
			if (other.khachHang != null)
				return false;
		} else if (!khachHang.equals(other.khachHang))
			return false;
		if (maDP == null) {
			if (other.maDP != null)
				return false;
		} else if (!maDP.equals(other.maDP))
			return false;
		return true;
	}
	public DatPhong(String maDP, KhachHang khachHang, String loaiDatPhong, LocalDate ngayDatPhong,
			LocalTime gioDatPhong, LocalDate ngayTraPhong, LocalTime gioTraPhong) {
		super();
		this.maDP = maDP;
		this.khachHang = khachHang;
		this.loaiDatPhong = loaiDatPhong;
		this.ngayDatPhong = ngayDatPhong;
		this.gioDatPhong = gioDatPhong;
		this.ngayTraPhong = ngayTraPhong;
		this.gioTraPhong = gioTraPhong;
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
		builder.append("]");
		return builder.toString();
	}
}
