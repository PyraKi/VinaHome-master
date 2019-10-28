package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@Entity
@Table(name="TaiKhoan")
@NamedNativeQuery(name="getTaiKhoan",query="db.TaiKhoan.find({})",resultClass=TaiKhoan.class)
public class TaiKhoan {
	@Id
	private String tenTK;
	private String matKhau;
	public String getTenTK() {
		return tenTK;
	}
	public void setTenTK(String tenTK) {
		this.tenTK = tenTK;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tenTK == null) ? 0 : tenTK.hashCode());
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
		TaiKhoan other = (TaiKhoan) obj;
		if (tenTK == null) {
			if (other.tenTK != null)
				return false;
		} else if (!tenTK.equals(other.tenTK))
			return false;
		return true;
	}
	public TaiKhoan(String tenTK, String matKhau) {
		super();
		this.tenTK = tenTK;
		this.matKhau = matKhau;
	}
	public TaiKhoan() {
		super();
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TaiKhoan [ID=");
		builder.append(tenTK);
		builder.append(", matKhau=");
		builder.append(matKhau);
		builder.append("]");
		return builder.toString();
	}
}
