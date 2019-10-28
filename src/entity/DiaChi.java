package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@Entity
@Table(name="DiaChi")
@NamedNativeQuery(name="getDiaChi",query="db.DiaChi.find({})",resultClass=DiaChi.class)
public class DiaChi {
	public interface QLDiachiimp {

	}
	@Id
	private String maDC;
	private String phuong;
	private String quan;
	private String duong;
	private String soNha;
	private String tinh;
	public String getMaDC() {
		return maDC;
	}
	public void setMaDC(String maDC) {
		this.maDC = maDC;
	}
	public String getPhuong() {
		return phuong;
	}
	public void setPhuong(String phuong) {
		this.phuong = phuong;
	}
	public String getQuan() {
		return quan;
	}
	public void setQuan(String quan) {
		this.quan = quan;
	}
	public String getDuong() {
		return duong;
	}
	public void setDuong(String duong) {
		this.duong = duong;
	}
	public String getSoNha() {
		return soNha;
	}
	public void setSoNha(String soNha) {
		this.soNha = soNha;
	}
	public String getTinh() {
		return tinh;
	}
	public void setTinh(String tinh) {
		this.tinh = tinh;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maDC == null) ? 0 : maDC.hashCode());
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
		DiaChi other = (DiaChi) obj;
		if (maDC == null) {
			if (other.maDC != null)
				return false;
		} else if (!maDC.equals(other.maDC))
			return false;
		return true;
	}
	public DiaChi(String maDC, String phuong, String quan, String duong, String soNha, String tinh) {
		super();
		this.maDC = maDC;
		this.phuong = phuong;
		this.quan = quan;
		this.duong = duong;
		this.soNha = soNha;
		this.tinh = tinh;
	}
	public DiaChi() {
		super();
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DiaChi [maDC=");
		builder.append(maDC);
		builder.append(", phuong=");
		builder.append(phuong);
		builder.append(", quan=");
		builder.append(quan);
		builder.append(", duong=");
		builder.append(duong);
		builder.append(", soNha=");
		builder.append(soNha);
		builder.append(", tinh=");
		builder.append(tinh);
		builder.append("]");
		return builder.toString();
	}
}
