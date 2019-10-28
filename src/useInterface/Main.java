package useInterface;


import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import bussinessLayer.QLChitietDichvu;
import bussinessLayer.QLDatPhong;
import bussinessLayer.QLDiachi;
import bussinessLayer.QLDichvu;
import bussinessLayer.QLGiuong;
import bussinessLayer.QLHoadon;
import bussinessLayer.QLKhachhang;
import bussinessLayer.QLLoaiDichvu;
import bussinessLayer.QLLoaiphong;
import bussinessLayer.QLNhanVien;
import bussinessLayer.QLPhieuDichvu;
import bussinessLayer.QLPhong;
import bussinessLayer.QLTaiKhoan;
import entity.DiaChi;
import entity.Dichvu;
import entity.KhachHang;
import entity.LoaiDichvu;
import entity.NhanVien;
import entity.TaiKhoan;
import implementsLayer.QLChitietDichvuimp;
import implementsLayer.QLDatPhongimp;
import implementsLayer.QLDiachiimp;
import implementsLayer.QLDichvuimp;
import implementsLayer.QLGiuongimp;
import implementsLayer.QLHoadonimp;
import implementsLayer.QLKhachhangimp;
import implementsLayer.QLLoaiDichvuimp;
import implementsLayer.QLLoaiphongimp;
import implementsLayer.QLNhanvienimp;
import implementsLayer.QLPhieuDichvuimp;
import implementsLayer.QLPhongimp;
import implementsLayer.QLTaiKhoanimp;

public class Main {
	public static void main(String[] args) {
		//Load database
		EntityManager em = Persistence.createEntityManagerFactory("VinaHome-master").createEntityManager();
		QLDiachiimp diachiDAO = new QLDiachi(em);

		QLTaiKhoanimp taikhoanDAO = new QLTaiKhoan(em);
		QLNhanvienimp nhanvienDAO = new QLNhanVien(em);
//		nhanvienDAO.themNhanvien(new NhanVien("TT001", "Nguyễn Trần Linh Nhi",
//				"281196757", "nhinguyen@gmail.com", "0393100165", 
//				new DiaChi("SG001", "14", "10", "Thành Thái", "3/81", "HCM"),
//				"Tiếp tân", LocalDate.of(1999, 05, 21),
//				new TaiKhoan("nv001", "123123")));
		QLKhachhangimp khachhangDAO = new QLKhachhang(em);
		
		QLLoaiDichvuimp loaiDichvuDAO = new QLLoaiDichvu(em);

		QLDichvuimp dichvuDAO = new QLDichvu(em);
	
		QLChitietDichvuimp chitietdichvuDAO = new QLChitietDichvu(em);
		QLPhieuDichvuimp phieuDichvuDAO = new QLPhieuDichvu(em);
	
	
		QLLoaiphongimp loaiphongDAO = new QLLoaiphong(em);
		QLGiuongimp giuongDAO = new QLGiuong(em);
		
		QLDatPhongimp datPhongDAO = new QLDatPhong(em);
		QLPhongimp phongDAO = new QLPhong(em);
		QLHoadonimp hoadonDAO = new QLHoadon(em);
	}
	
}
