package managerLayer;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entity.DatPhong;
import implementsLayer.QLDatPhongimp;

public class QLDatPhong implements QLDatPhongimp {
	
	// truy van databse tren mongo ke thua tu implement
	private EntityManager em;
	public QLDatPhong(EntityManager em) {
		super();
		this.em = em;
	}
	// them datphong vao co so du lieu
	// true khi ko trung
	// fasle khi trung
	@Override
	public boolean themDatPhong(DatPhong dp) {
		EntityTransaction tr=em.getTransaction();
		try {
			tr.begin();
			em.persist(dp);
			tr.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	
	@Override
	public DatPhong timDatPhong(String maPD) {
		return em.find(DatPhong.class, maPD);
	}
	

	
	
	@Override
	public boolean xoaDatPhong(String maPD) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.remove(timDatPhong(maPD));
			tr.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}
	
	
	
	@Override
	public boolean suaDatPhong(DatPhong dp) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(dp);
			tr.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	
	
	@Override
	public List<DatPhong> getDSDatPhong() {
		return em.createQuery("from DatPhong dp",DatPhong.class).getResultList();
	}
}
