package bussinessLayer;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entity.Phong;
import implementsLayer.QLPhongimp;

public class QLPhong implements QLPhongimp {
	
	// truy van databse tren mongo ke thua tu implement
	private EntityManager em;
	public QLPhong(EntityManager em) {
		super();
		this.em = em;
	}
	// them phong vao co so du lieu
	// true khi ko trung
	// fasle khi trung
	@Override
	public boolean themPhong(Phong p) {
		EntityTransaction tr=em.getTransaction();
		try {
			tr.begin();
			em.persist(p);
			tr.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}
	

	
	@Override
	public Phong timPhong(String map) {
		return em.find(Phong.class, map);
	}
	

	
	@Override
	public boolean xoaPhong(String map) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.remove(timPhong(map));
			tr.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}
	
	
	@Override
	public boolean suaPhong(Phong p) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(p);
			tr.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	
	@Override
	public List<Phong> getDSPhong() {
		return em.createQuery("from Phong p",Phong.class).getResultList();
	}
}
