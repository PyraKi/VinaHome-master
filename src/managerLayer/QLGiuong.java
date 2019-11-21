package managerLayer;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entity.Giuong;
import implementsLayer.QLGiuongimp;

public class QLGiuong implements QLGiuongimp {
	
	// truy van databse tren mongo ke thua tu implement
	private EntityManager em;
	public QLGiuong(EntityManager em) {
		super();
		this.em = em;
	}
	// them giuong vao co so du lieu
	// true khi ko trung
	// fasle khi trung
	@Override
	public boolean themGiuong(Giuong g) {
		EntityTransaction tr=em.getTransaction();
		try {
			tr.begin();
			em.persist(g);
			tr.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}
	


	@Override
	public Giuong timGiuong(String mag) {
		return em.find(Giuong.class, mag);
	}
	


	@Override
	public boolean xoaGiuong(String mag) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.remove(timGiuong(mag));
			tr.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}
	

	@Override
	public boolean suaGiuong(Giuong g) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(g);
			tr.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}


	@Override
	public List<Giuong> getDSGiuong() {
		return em.createQuery("from Giuong g",Giuong.class).getResultList();
	}
}
