package managerLayer;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entity.ChitietHoadon;
import implementsLayer.QLChitietHoadonimp;

public class QLChitietHoadon implements QLChitietHoadonimp {
	private EntityManager em;
	public QLChitietHoadon(EntityManager em) {
		super();
		this.em = em;
	}
	
	@Override
	public boolean themChitietHoadon(ChitietHoadon cthd) {
		EntityTransaction tr=em.getTransaction();
		try {
			tr.begin();
			em.persist(cthd);
			tr.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}
	
	
	@Override
	public ChitietHoadon timChitietHoadon(String maCTHD) {
		return em.find(ChitietHoadon.class, maCTHD);
	}

	
	@Override
	public boolean xoaChitietHoadon(String maCTHD) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.remove(timChitietHoadon(maCTHD));
			tr.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}
	
	
	@Override
	public boolean suaChitietHoadon(ChitietHoadon cthd) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(cthd);
			tr.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}
	
	
	@Override
	public List<ChitietHoadon> getDSChitietHoadon() {
		return em.createQuery("from ChitietHoadon cthd",ChitietHoadon.class).getResultList();
	}
}
