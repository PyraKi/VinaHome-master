package implementsLayer;

import java.util.List;

import entity.TaiKhoan;

public interface QLTaiKhoanimp {

	boolean themTaikhoan(TaiKhoan tk);

	TaiKhoan timTaiKhoan(String tenTK);

	boolean xoaTaikhoan(String tenTK);

	boolean suaTaiKhoan(TaiKhoan tk);

	List<TaiKhoan> getDSTaiKhoan();

}