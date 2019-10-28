package bussinessLayer;

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
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	
	@Override
	public List<KhachHang> getDSKhachHang() {
		return em.createQuery("from KhachHang kh",KhachHang.class).getResultList();
	}
}
