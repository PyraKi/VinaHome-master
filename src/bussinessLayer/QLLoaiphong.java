package bussinessLayer;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entity.LoaiPhong;
import implementsLayer.QLLoaiphongimp;

public class QLLoaiphong implements QLLoaiphongimp {
	private EntityManager em;
	public QLLoaiphong(EntityManager em) {
		super();
		this.em = em;
	}
	
	@Override
	public boolean themLoaiPhong(LoaiPhong lp) {
		EntityTransaction tr=em.getTransaction();
		try {
			tr.begin();
			em.persist(lp);
			tr.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}
	

	
	@Override
	public LoaiPhong timLoaiPhong(String malp) {
		return em.find(LoaiPhong.class, malp);
	}
	

	
	@Override
	public boolean xoaLoaiPhong(String malp) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.remove(timLoaiPhong(malp));
			tr.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}
	
	
	@Override
	public boolean suaLoaiPhong(LoaiPhong lp) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(lp);
			tr.commit();
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	
	@Override
	public List<LoaiPhong> getDSLoaiPhong() {
		return em.createQuery("from LoaiPhong lp",LoaiPhong.class).getResultList();
	}
}
