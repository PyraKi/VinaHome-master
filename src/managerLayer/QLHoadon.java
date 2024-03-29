package managerLayer;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entity.ChitietHoadon;
import entity.Hoadon;
import implementsLayer.QLHoadonimp;

public class QLHoadon implements QLHoadonimp {
	
	private EntityManager em;
	public QLHoadon(EntityManager em) {
		super();
		this.em = em;
	}
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
	
	@Override
	public Hoadon timHoadonPhongDangThue(String maPhong) {
		for (Hoadon hoadon : getDSHoadon()) {
			if(hoadon.getNgayLap() == null) {
				for (ChitietHoadon chitietHoadon : hoadon.getChitietHoadons()) {
					if(chitietHoadon.getPhong().getMaPhong().equals(maPhong))
						return hoadon;
				}
			}
		}
		return null;
	}
}
