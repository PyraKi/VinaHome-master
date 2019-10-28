package bussinessLayer;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entity.Dichvu;
import implementsLayer.QLDichvuimp;

public class QLDichvu implements QLDichvuimp {
	private EntityManager em;
	
	public QLDichvu(EntityManager em) {
		super();
		this.em = em;
	}
	
	@Override
	public boolean themDichvu(Dichvu dv) {
		EntityTransaction tr=em.getTransaction();
		try {
			tr.begin();
			em.persist(dv);
			tr.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}
	

	
	@Override
	public Dichvu timDichvu(String madv) {
		return em.find(Dichvu.class, madv);
	}
	

	
	@Override
	public boolean xoaDichvu(String madv) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.remove(timDichvu(madv));
			tr.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}
	
	
	@Override
	public boolean suaDichvu(Dichvu dv) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(dv);
			tr.commit();
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	
	@Override
	public List<Dichvu> getDSDichvu() {
		return em.createQuery("from Dichvu dv",Dichvu.class).getResultList();
	}
}
