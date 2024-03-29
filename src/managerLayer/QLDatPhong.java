package managerLayer;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entity.DatPhong;
import entity.Phong;
import implementsLayer.QLDatPhongimp;

public class QLDatPhong implements QLDatPhongimp {
	
	private EntityManager em;
	public QLDatPhong(EntityManager em) {
		super();
		this.em = em;
	}
	
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
		List<DatPhong> datPhongs = em.createQuery("from DatPhong dp",DatPhong.class).getResultList();
		Collections.sort(datPhongs);
		return datPhongs;
	}
	
	@Override
	public boolean kiemTraTrung(DatPhong o) {
		for (DatPhong datPhong : getDSDatPhong()) {
			if(datPhong.getTinhTrang() != -1) {
				for(Phong pd : datPhong.getPhongs()) {
					for(Phong p : o.getPhongs()) {
						if(pd.getMaPhong().equals(p.getMaPhong())) {
							if((datPhong.getNgayDatPhong().compareTo(o.getNgayDatPhong()) >=0 &&
									datPhong.getNgayTraPhong().compareTo(o.getNgayDatPhong()) <=0) ||
									(datPhong.getNgayDatPhong().compareTo(o.getNgayTraPhong()) >=0 &&
									datPhong.getNgayTraPhong().compareTo(o.getNgayTraPhong()) <=0)) {
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}
}
