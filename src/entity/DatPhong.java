package entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
@Table(name="DatPhong")
@NamedNativeQuery(name="getDatPhong",query="db.DatPhong.find({})",resultClass=DatPhong.class)
public class DatPhong {
	@Id
	private String maDP;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="maKH")
	private KhachHang khachHang;
	@OneToMany(fetch=FetchType.LAZY)
	private List<Phong> phongs;
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
	public List<Phong> getPhong() {
		return phongs;
	}
	public void setPhong(List<Phong> phongs) {
		this.phongs = phongs;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		if (maDP == null) {
			if (other.maDP != null)
				return false;
		} else if (!maDP.equals(other.maDP))
			return false;
		return true;
	}
	public DatPhong(String maDP, KhachHang khachHang, List<Phong> phongs, String loaiDatPhong, LocalDate ngayDatPhong,
			LocalTime gioDatPhong, LocalDate ngayTraPhong, LocalTime gioTraPhong, LocalDateTime nhanPhong) {
		super();
		this.maDP = maDP;
		this.khachHang = khachHang;
		this.phongs = phongs;
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
		builder.append(", phongs=");
		builder.append(phongs);
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
