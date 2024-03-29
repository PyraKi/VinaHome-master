package managerLayer;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entity.LoaiDichvu;
import implementsLayer.QLLoaiDichvuimp;

public class QLLoaiDichvu implements QLLoaiDichvuimp {
	
	// truy van databse tren mongo ke thua tu implement
	private EntityManager em;
	public QLLoaiDichvu(EntityManager em) {
		super();
		this.em = em;
	}
	// them loaidichvu vao co so du lieu
	// true khi ko trung
	// fasle khi trung
	@Override
	public boolean themLoaiDichvu(LoaiDichvu ldv) {
		EntityTransaction tr=em.getTransaction();
		try {
			tr.begin();
			em.persist(ldv);
			tr.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}
	
	@Override
	public LoaiDichvu timLoaiDichvu(String maldv) {
		return em.find(LoaiDichvu.class, maldv);
	}
	
	@Override
	public LoaiDichvu timTheotenLDV(String tenDV) {
		for (LoaiDichvu loaiDichvu : getDSLoaiDichvu()) {
			if(loaiDichvu.getTenLDV().equalsIgnoreCase(tenDV))
				return loaiDichvu;
		}
		return null;
	}
	@Override
	public boolean xoaLoaiDichvu(String maldv) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.remove(timLoaiDichvu(maldv));
			tr.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}
	
	
	@Override
	public boolean suaLoaiDichvu(LoaiDichvu ldv) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(ldv);
			tr.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}
	
	@Override
	public List<LoaiDichvu> getDSLoaiDichvu() {
		return em.createQuery("from LoaiDichvu ldv",LoaiDichvu.class).getResultList();
	}
}
