package bussinessLayer;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entity.DiaChi;
import implementsLayer.QLDiachiimp;

public class QLDiachi implements QLDiachiimp{
	
	// truy van databse tren mongo ke thua tu implement
	private EntityManager em;
	public QLDiachi(EntityManager em) {
		super();
		this.em = em;
	}
	
	// them diachi vao co so du lieu
	// true khi ko trung
	// fasle khi trung
	@Override
	public boolean themDiachi(DiaChi dc) {
		EntityTransaction tr=em.getTransaction();
		try {
			tr.begin();
			em.persist(dc);
			tr.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}
	

	@Override
	public DiaChi timDiachi(String maDC) {
		return em.find(DiaChi.class, maDC);
	}
	

	@Override
	public boolean xoaDiachi(String maDC) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.remove(timDiachi(maDC));
			tr.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}
	
	@Override
	public boolean suaDiachi(DiaChi dc) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(dc);
			tr.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	@Override
	public List<DiaChi> getDSDiachi() {
		return em.createQuery("from DiaChi dc",DiaChi.class).getResultList();
	}
}
