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
@Table(name="NhanVien")
@NamedNativeQuery(name="getNhanVien",query="db.NhanVien.find({})",resultClass=NhanVien.class)
public class NhanVien {
	@Id
	private String maNV;
	private String tenNV;
	private String soCMND;
	private String Email;
	private String soDT;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="maDC")
	private DiaChi diaChi;
	private String chuVu;
	private LocalDate ngaySinh;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tenTK")
	private TaiKhoan taiKhoan;
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getTenNV() {
		return tenNV;
	}
	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}
	public String getSoCMND() {
		return soCMND;
	}
	public void setSoCMND(String soCMND) {
		this.soCMND = soCMND;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getSoDT() {
		return soDT;
	}
	public void setSoDT(String soDT) {
		this.soDT = soDT;
	}
	public DiaChi getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(DiaChi diaChi) {
		this.diaChi = diaChi;
	}
	public String getChuVu() {
		return chuVu;
	}
	public void setChuVu(String chuVu) {
		this.chuVu = chuVu;
	}
	public LocalDate getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(LocalDate ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}
	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maNV == null) ? 0 : maNV.hashCode());
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
		NhanVien other = (NhanVien) obj;
		if (maNV == null) {
			if (other.maNV != null)
				return false;
		} else if (!maNV.equals(other.maNV))
			return false;
		return true;
	}
	public NhanVien(String maNV, String tenNV, String soCMND, String email, String soDT, DiaChi diaChi, String chuVu,
			LocalDate ngaySinh, TaiKhoan taiKhoan) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.soCMND = soCMND;
		this.Email = email;
		this.soDT = soDT;
		this.diaChi = diaChi;
		this.chuVu = chuVu;
		this.ngaySinh = ngaySinh;
		this.taiKhoan = taiKhoan;
	}
	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("NhanVien [maNV=");
		builder.append(maNV);
		builder.append(", tenNV=");
		builder.append(tenNV);
		builder.append(", soCMND=");
		builder.append(soCMND);
		builder.append(", Email=");
		builder.append(Email);
		builder.append(", soDT=");
		builder.append(soDT);
		builder.append(", diaChi=");
		builder.append(diaChi);
		builder.append(", chuVu=");
		builder.append(chuVu);
		builder.append(", ngaySinh=");
		builder.append(ngaySinh);
		builder.append(", taiKhoan=");
		builder.append(taiKhoan);
		builder.append("]");
		return builder.toString();
	}
}
