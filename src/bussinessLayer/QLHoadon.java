package bussinessLayer;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entity.Hoadon;
import implementsLayer.QLHoadonimp;

public class QLHoadon implements QLHoadonimp {
	
	// truy van databse tren mongo ke thua tu implement
	private EntityManager em;
	public QLHoadon(EntityManager em) {
		super();
		this.em = em;
	}
	// them hoadon vao co so du lieu
	// true khi ko trung
	// fasle khi trung
	@Override
	public boolean themHoadon(Hoadon hd) {
		EntityTransaction tr=em.getTransaction();
		try {
			tr.begin();
			em.persist(hd);
			tr.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	
	@Override
	public Hoadon timHoadon(String maHD) {
		return em.find(Hoadon.class, maHD);
	}
	

	@Override
	public boolean xoaHoadon(String maHD) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.remove(timHoadon(maHD));
			tr.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}
	
	
	
	@Override
	public boolean suaHoadon(Hoadon hd) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(hd);
			tr.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	
	
	@Override
	public List<Hoadon> getDSHoadon() {
		return em.createQuery("from Hoadon hd",Hoadon.class).getResultList();
	}
}
