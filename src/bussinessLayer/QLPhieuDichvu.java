package bussinessLayer;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entity.PhieuDichvu;
import implementsLayer.QLPhieuDichvuimp;

public class QLPhieuDichvu implements QLPhieuDichvuimp {
	private EntityManager em;
	public QLPhieuDichvu(EntityManager em) {
		super();
		this.em = em;
	}
	
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
