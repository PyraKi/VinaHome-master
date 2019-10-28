package bussinessLayer;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entity.TaiKhoan;
import implementsLayer.QLTaiKhoanimp;

public class QLTaiKhoan implements QLTaiKhoanimp {
	private EntityManager em;
	public QLTaiKhoan(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public boolean themTaikhoan(TaiKhoan tk) {
		EntityTransaction tr=em.getTransaction();
		try {
			tr.begin();
			em.persist(tk);
			tr.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}
	
	
	@Override
	public TaiKhoan timTaiKhoan(String tenTK) {
		return em.find(TaiKhoan.class, tenTK);
	}
	
	
	@Override
	public boolean xoaTaikhoan(String tenTK) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.remove(timTaiKhoan(tenTK));
			tr.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}
	
	@Override
	public boolean suaTaiKhoan(TaiKhoan tk) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(tk);
			tr.commit();
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}
	
	@Override
	public List<TaiKhoan> getDSTaiKhoan() {
		return em.createQuery("from TaiKhoan tk",TaiKhoan.class).getResultList();
	}
}
