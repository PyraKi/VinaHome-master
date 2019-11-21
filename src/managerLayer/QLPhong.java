package managerLayer;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entity.Phong;
import implementsLayer.QLPhongimp;

public class QLPhong implements QLPhongimp {
	
	private EntityManager em;
	public QLPhong(EntityManager em) {
		super();
		this.em = em;
	}
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
		List<Phong> dsPhong = em.createQuery("from Phong p",Phong.class).getResultList();
		Collections.sort(dsPhong);
		return dsPhong;
	}
}
