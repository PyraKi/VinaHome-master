package entity;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@Entity
@Table(name="Phong")
@NamedNativeQuery(name="getPhong",query="db.Phong.find({})",resultClass=Phong.class)
public class Phong implements Comparable<Phong>{
	@Id
	private String maPhong;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="maLP")
	private LoaiPhong loaiPhong;
	private double giaTheogio;
	private double giaQuadem;
	private double giaTheongay;
	private String soPhong;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="maGiuong")
	private Giuong giuong;
	private String tinhtrangPhong;
	private int soNguoiToida;
	public String getMaPhong() {
		return maPhong;
	}
	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}
	public LoaiPhong getLoaiPhong() {
		return loaiPhong;
	}
	public void setLoaiPhong(LoaiPhong loaiPhong) {
		this.loaiPhong = loaiPhong;
	}
	public double getGiaTheogio() {
		return giaTheogio;
	}
	public void setGiaTheogio(double giaTheogio) {
		this.giaTheogio = giaTheogio;
	}
	public double getGiaQuadem() {
		return giaQuadem;
	}
	public void setGiaQuadem(double giaQuadem) {
		this.giaQuadem = giaQuadem;
	}
	public double getGiaTheongay() {
		return giaTheongay;
	}
	public void setGiaTheongay(double giaTheongay) {
		this.giaTheongay = giaTheongay;
	}
	public String getSoPhong() {
		return soPhong;
	}
	public void setSoPhong(String soPhong) {
		this.soPhong = soPhong;
	}
	public Giuong getGiuong() {
		return giuong;
	}
	public void setGiuong(Giuong giuong) {
		this.giuong = giuong;
	}
	public String getTinhtrangPhong() {
		return tinhtrangPhong;
	}
	public void setTinhtrangPhong(String tinhtrangPhong) {
		this.tinhtrangPhong = tinhtrangPhong;
	}
	public int getSoNguoiToida() {
		return soNguoiToida;
	}
	public void setSoNguoiToida(int soNguoiToida) {
		this.soNguoiToida = soNguoiToida;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maPhong == null) ? 0 : maPhong.hashCode());
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
		Phong other = (Phong) obj;
		if (maPhong == null) {
			if (other.maPhong != null)
				return false;
		} else if (!maPhong.equals(other.maPhong))
			return false;
		return true;
	}
	public Phong(String maPhong, LoaiPhong loaiPhong, double giaTheogio, double giaQuadem, double giaTheongay,
			String soPhong, Giuong giuong, String tinhtrangPhong, int soNguoiToida) {
		super();
		this.maPhong = maPhong;
		this.loaiPhong = loaiPhong;
		this.giaTheogio = giaTheogio;
		this.giaQuadem = giaQuadem;
		this.giaTheongay = giaTheongay;
		this.soPhong = soPhong;
		this.giuong = giuong;
		this.tinhtrangPhong = tinhtrangPhong;
		this.soNguoiToida = soNguoiToida;
	}
	public Phong() {
		super();
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Phong [maPhong=");
		builder.append(maPhong);
		builder.append(", loaiPhong=");
		builder.append(loaiPhong);
		builder.append(", giaTheogio=");
		builder.append(giaTheogio);
		builder.append(", giaQuadem=");
		builder.append(giaQuadem);
		builder.append(", giaTheongay=");
		builder.append(giaTheongay);
		builder.append(", soPhong=");
		builder.append(soPhong);
		builder.append(", giuong=");
		builder.append(giuong);
		builder.append(", tinhtrangPhong=");
		builder.append(tinhtrangPhong);
		builder.append(", soNguoiToida=");
		builder.append(soNguoiToida);
		builder.append("]");
		return builder.toString();
	}
	@Override
	public int compareTo(Phong o) {
		return this.getMaPhong().compareTo(o.getMaPhong());
	}
}
