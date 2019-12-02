package managerLayer;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entity.KhachHang;
import implementsLayer.QLKhachhangimp;

public class QLKhachhang implements QLKhachhangimp {
	
	private EntityManager em;
	public QLKhachhang(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public boolean themKhachHang(KhachHang kh) {
		EntityTransaction tr=em.getTransaction();
		try {
			tr.begin();
			em.persist(kh);
			tr.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}
	
	@Override
	public KhachHang timKhachHang(String makh) {
		return em.find(KhachHang.class, makh);
	}
	
	@Override
	public boolean xoaKhachHang(String makh) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.remove(timKhachHang(makh));
			tr.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}
	
	@Override
	public boolean suaKhachHang(KhachHang kh) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(kh);
			tr.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}
	
	@Override
	public KhachHang timKhachHang(String tenKH, String soDT) {
		for (KhachHang khachHang : getDSKhachHang()) {
			if(khachHang.getTenKH().equalsIgnoreCase(tenKH) && khachHang.getSoDT().equals(soDT))
				return khachHang;
		}
		return null;
	}
	
	@Override
	public KhachHang timTenKH(String tenKH) {
		for (KhachHang khachHang : getDSKhachHang()) {
			if(khachHang.getTenKH().equalsIgnoreCase(tenKH))
				return khachHang;
		}
		return null;
	}
	
	@Override
	public KhachHang timSoDTKH(String soDT) {
		for (KhachHang khachHang : getDSKhachHang()) {
			if(khachHang.getSoDT().equals(soDT))
				return khachHang;
		}
		return null;
	}
	
	@Override
	public KhachHang timKHTheoDinhdang(String tenKHSoDT) {
		for (KhachHang khachHang : getDSKhachHang()) {
			String s = khachHang.getTenKH() + "  [" + khachHang.getSoDT() + "]";
			if(s.equalsIgnoreCase(tenKHSoDT))
				return khachHang;
		}
		return null;
	}

	@Override
	public List<KhachHang> getDSKhachHang() {
		return em.createQuery("from KhachHang kh",KhachHang.class).getResultList();
	}
}
