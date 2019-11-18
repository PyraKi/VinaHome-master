package entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@Entity
@Table(name="KhachHang")
@NamedNativeQuery(name="getKhachHang",query="db.KhachHang.find({})",resultClass=KhachHang.class)
public class KhachHang {
	@Id
	private String maKH;
	private String tenKH;
	private String soCMD;
	private String loaiKH;
	private String soDT;
	private LocalDate ngaySinh;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="maDC")
	private DiaChi diaChi;
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public String getSoCMD() {
		return soCMD;
	}
	public void setSoCMD(String soCMD) {
		this.soCMD = soCMD;
	}
	public String getLoaiKH() {
		return loaiKH;
	}
	public void setLoaiKH(String loaiKH) {
		this.loaiKH = loaiKH;
	}
	public String getSoDT() {
		return soDT;
	}
	public void setSoDT(String soDT) {
		this.soDT = soDT;
	}
	public LocalDate getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(LocalDate ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public DiaChi getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(DiaChi diaChi) {
		this.diaChi = diaChi;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((soDT == null) ? 0 : soDT.hashCode());
		result = prime * result + ((tenKH == null) ? 0 : tenKH.hashCode());
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
		KhachHang other = (KhachHang) obj;
		if (soDT == null) {
			if (other.soDT != null)
				return false;
		} else if (!soDT.equals(other.soDT))
			return false;
		if (tenKH == null) {
			if (other.tenKH != null)
				return false;
		} else if (!tenKH.equals(other.tenKH))
			return false;
		return true;
	}
	public KhachHang(String maKH, String tenKH, String soCMD, String loaiKH, String soDT, LocalDate ngaySinh,
			DiaChi diaChi) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.soCMD = soCMD;
		this.loaiKH = loaiKH;
		this.soDT = soDT;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
	}
	public KhachHang() {
		super();
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("KhachHang [maKH=");
		builder.append(maKH);
		builder.append(", tenKH=");
		builder.append(tenKH);
		builder.append(", soCMD=");
		builder.append(soCMD);
		builder.append(", loaiKH=");
		builder.append(loaiKH);
		builder.append(", soDT=");
		builder.append(soDT);
		builder.append(", ngaySinh=");
		builder.append(ngaySinh);
		builder.append(", diaChi=");
		builder.append(diaChi);
		builder.append("]");
		return builder.toString();
	}
}
