package entity;

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
@Table(name="ChitietHoadon")
@NamedNativeQuery(name="getChitietHoadon",query="db.ChitietHoadon.find({})",resultClass=Hoadon.class)
public class ChitietHoadon {
	@Id
	private String maCTHD;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="maPhong")
	private Phong phong;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="maDP")
	private DatPhong datPhong;
	@OneToMany(fetch=FetchType.LAZY)
	private List<PhieuDichvu> phieuDichvus;
	private double phatsinh;
	public String getMaCTHD() {
		return maCTHD;
	}
	public void setMaCTHD(String maCTHD) {
		this.maCTHD = maCTHD;
	}
	public Phong getPhong() {
		return phong;
	}
	public void setPhong(Phong phong) {
		this.phong = phong;
	}
	public DatPhong getDatPhong() {
		return datPhong;
	}
	public void setDatPhong(DatPhong datPhong) {
		this.datPhong = datPhong;
	}
	public List<PhieuDichvu> getPhieuDichvus() {
		return phieuDichvus;
	}
	public void setPhieuDichvus(List<PhieuDichvu> phieuDichvus) {
		this.phieuDichvus = phieuDichvus;
	}
	public double getPhatsinh() {
		return phatsinh;
	}
	public void setPhatsinh(double phatsinh) {
		this.phatsinh = phatsinh;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maCTHD == null) ? 0 : maCTHD.hashCode());
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
		ChitietHoadon other = (ChitietHoadon) obj;
		if (maCTHD == null) {
			if (other.maCTHD != null)
				return false;
		} else if (!maCTHD.equals(other.maCTHD))
			return false;
		return true;
	}
	public ChitietHoadon(String maCTHD, Phong phong, DatPhong datPhong, List<PhieuDichvu> phieuDichvus,
			double phatsinh) {
		super();
		this.maCTHD = maCTHD;
		this.phong = phong;
		this.datPhong = datPhong;
		this.phieuDichvus = phieuDichvus;
		this.phatsinh = phatsinh;
	}
	public ChitietHoadon() {
		super();
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ChitietHoadon [maCTHD=");
		builder.append(maCTHD);
		builder.append(", phong=");
		builder.append(phong);
		builder.append(", datPhong=");
		builder.append(datPhong);
		builder.append(", phieuDichvus=");
		builder.append(phieuDichvus);
		builder.append(", phatsinh=");
		builder.append(phatsinh);
		builder.append("]");
		return builder.toString();
	}
	
	public double thanhTien() {
		double s = 0;
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
			for (int i = 1; i < hours; i++)
				s += s*0.04;
		}else if(loaithue.equalsIgnoreCase("Qua đêm")) {
			s = phong.getGiaQuadem();
		}else {
			s = phong.getGiaTheongay() * (months*30 + days);
		}
		s += phatsinh;
		return s;
	}
}
