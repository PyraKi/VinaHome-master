package implementsLayer;

import java.util.List;

import entity.KhachHang;

public interface QLKhachhangimp {

	boolean themKhachHang(KhachHang kh);

	KhachHang timKhachHang(String makh);

	boolean xoaKhachHang(String makh);

	boolean suaKhachHang(KhachHang kh);

	List<KhachHang> getDSKhachHang();

}