package managerLayer;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entity.PhieuDichvu;
import implementsLayer.QLPhieuDichvuimp;

public class QLPhieuDichvu implements QLPhieuDichvuimp {
	
	// truy van databse tren mongo ke thua tu implement
	private EntityManager em;
	public QLPhieuDichvu(EntityManager em) {
		super();
		this.em = em;
	}
	// them phieudichvu vao co so du lieu
	// true khi ko trung
	// fasle khi trung
	@Override
	public boolean themPhieuDichvu(PhieuDichvu pdv) {
		EntityTransaction tr=em.getTransaction();
		try {
			tr.begin();
			em.persist(pdv);
			tr.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}
	

	
	@Override
	public PhieuDichvu timPhieuDichvu(String mapdv) {
		return em.find(PhieuDichvu.class, mapdv);
	}
	

	
	@Override
	public boolean xoaPhieuDichvu(String mapdv) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.remove(timPhieuDichvu(mapdv));
			tr.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}
	
	
	@Override
	public boolean suaPhieuDichvu(PhieuDichvu pdv) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(pdv);
			tr.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	
	@Override
	public List<PhieuDichvu> getDSPhieuDichvu() {
		return em.createQuery("from PhieuDichvu pdv",PhieuDichvu.class).getResultList();
	}
}
