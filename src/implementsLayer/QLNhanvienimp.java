package implementsLayer;

import java.util.List;

import entity.NhanVien;

public interface QLNhanvienimp {

	boolean themNhanvien(NhanVien nv);

	List<NhanVien> getDSNV();

	NhanVien timNhanvien(String maNV);

	NhanVien getLogin(String id, String pw);

	boolean xoaNhanVien(String maNV);

	boolean suaNhanvien(NhanVien nv);

	NhanVien timNhanvien(String tenNV, String soDT);

}