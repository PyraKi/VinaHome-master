package managerLayer;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entity.ChitietPhieuDichvu;
import implementsLayer.QLChitietDichvuimp;



public class QLChitietDichvu implements QLChitietDichvuimp {
	
	// truy van databse tren mongo ke thua tu implement
	private EntityManager em;
	public QLChitietDichvu(EntityManager em) {
		super();
		this.em = em;
	}
	// them chitietphieudichvu vao co so du lieu
	// true khi ko trung
	// fasle khi trung
	@Override
	public boolean themChitietDichvu(ChitietPhieuDichvu ctdv) {
		EntityTransaction tr=em.getTransaction();
		try {
			tr.begin();
			em.persist(ctdv);
			tr.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	@Override
	public ChitietPhieuDichvu timChitietDichvu(String maPDV) {
		return em.find(ChitietPhieuDichvu.class, maPDV);
	}
	

	
	@Override
	public boolean xoaChitietDichvu(String maPDV) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.remove(timChitietDichvu(maPDV));
			tr.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}
	
	
	@Override
	public boolean suaChitietDichvu(ChitietPhieuDichvu ctdv) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(ctdv);
			tr.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	
	@Override
	public List<ChitietPhieuDichvu> getDSChitietDichvu() {
		return em.createQuery("from ChitietPhieuDichvu ctdv",ChitietPhieuDichvu.class).getResultList();
	}
}
