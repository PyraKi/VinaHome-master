package bussinessLayer;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import java.util.List;
import entity.NhanVien;
import implementsLayer.QLNhanvienimp;

public class QLNhanVien implements QLNhanvienimp{
	private EntityManager em;
	public QLNhanVien(EntityManager em) {
		super();
		this.em = em;
	}
	
	@Override
	public boolean themNhanvien(NhanVien nv) {
		// TODO Auto-generated method stub
		EntityTransaction tr=em.getTransaction();
		try {
			tr.begin();
			em.persist(nv);
			tr.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}
	
	
	@Override
	public List<NhanVien> getDSNV(){
		return em.createQuery("from NhanVien nv",NhanVien.class).getResultList();
	}
	
	@Override
	public boolean xoaNhanVien(String maNV) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.remove(timNhanvien(maNV));
			tr.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}
	
	@Override
	public NhanVien timNhanvien(String maNV) {
		return em.find(NhanVien.class, maNV);
	}
	
	@Override
	public boolean suaNhanvien(NhanVien nv) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(nv);
			tr.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}
	
	@Override
	public NhanVien getLogin(String id, String pw) {
		for (NhanVien nhanVien : getDSNV()) {
			if(nhanVien.getTaiKhoan().getTenTK().equalsIgnoreCase(id) && nhanVien.getTaiKhoan().getMatKhau().equals(pw))
				return nhanVien;
		}
		return null;
	}
}
