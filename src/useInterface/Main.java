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
import entity.Giuong;
import entity.KhachHang;
import entity.LoaiDichvu;
import entity.LoaiPhong;
import entity.NhanVien;
import entity.Phong;
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
//		loaiphongDAO.themLoaiPhong(new LoaiPhong("PD", "Phòng đơn"));
//		loaiphongDAO.themLoaiPhong(new LoaiPhong("PDD", "Phòng đôi"));
//		loaiphongDAO.themLoaiPhong(new LoaiPhong("PGD", "Phòng gia đình"));
		
		QLGiuongimp giuongDAO = new QLGiuong(em);
//		giuongDAO.themGiuong(new Giuong("GS1", "Một giường đơn lớn"));
//		giuongDAO.themGiuong(new Giuong("GS2", "Hai giường đơn nhỏ"));
//		giuongDAO.themGiuong(new Giuong("GD1", "một giường đôi lớn"));
//		giuongDAO.themGiuong(new Giuong("GD2", "Hai giường đôi nhỏ"));
//		giuongDAO.themGiuong(new Giuong("GDD2", "Hai giường đôi lớn"));
		
		QLDatPhongimp datPhongDAO = new QLDatPhong(em);
		QLPhongimp phongDAO = new QLPhong(em);
//		phongDAO.themPhong(new Phong("P101", new LoaiPhong("PD", "Phòng đơn"),
//				80000, 300000, "101",
//				new Giuong("GS1", "Một giường đơn lớn"),
//				"Trống", 2, null));
		phongDAO.themPhong(new Phong("P102", new LoaiPhong("PD", "Phòng đơn"),
				80000, 300000, "102",
				new Giuong("GS1", "Một giường đơn lớn"),
				"Phòng trống", 2, null));
		phongDAO.themPhong(new Phong("P103", new LoaiPhong("PD", "Phòng đơn"),
				90000, 320000, "103",
				new Giuong("GS2", "Hai giường đơn nhỏ"),
				"Phòng trống", 2, null));
		phongDAO.themPhong(new Phong("P104", new LoaiPhong("PDD", "Phòng đôi"),
				85000, 310000, "104",
				new Giuong("GS2", "Hai giường đơn nhỏ"),
				"Phòng trống", 2, null));
		
		phongDAO.themPhong(new Phong("P201", new LoaiPhong("PD", "Phòng đơn"),
				80000, 300000, "201",
				new Giuong("GS1", "Một giường đơn lớn"),
				"Phòng trống", 2, null));
		phongDAO.themPhong(new Phong("P202", new LoaiPhong("PD", "Phòng đơn"),
				80000, 300000, "202",
				new Giuong("GS1", "Một giường đơn lớn"),
				"Phòng trống", 2, null));
		phongDAO.themPhong(new Phong("P203", new LoaiPhong("PD", "Phòng đơn"),
				90000, 320000, "203",
				new Giuong("GS2", "Hai giường đơn nhỏ"),
				"Phòng trống", 2, null));
		phongDAO.themPhong(new Phong("P204", new LoaiPhong("PDD", "Phòng đôi"),
				85000, 310000, "204",
				new Giuong("GD1", "một giường đôi lớn"),
				"Phòng trống", 2, null));
		
		phongDAO.themPhong(new Phong("P301", new LoaiPhong("PD", "Phòng đơn"),
				80000, 300000, "301",
				new Giuong("GS1", "Một giường đơn lớn"),
				"Phòng trống", 2, null));
		phongDAO.themPhong(new Phong("P302", new LoaiPhong("PD", "Phòng đơn"),
				80000, 300000, "302",
				new Giuong("GS1", "Một giường đơn lớn"),
				"Phòng trống", 2, null));
		phongDAO.themPhong(new Phong("P303", new LoaiPhong("PD", "Phòng đơn"),
				90000, 320000, "303",
				new Giuong("GS2", "Hai giường đơn nhỏ"),
				"Phòng trống", 2, null));
		phongDAO.themPhong(new Phong("P304", new LoaiPhong("PDD", "Phòng đôi"),
				85000, 310000, "304",
				new Giuong("GS2", "Hai giường đơn nhỏ"),
				"Phòng trống", 2, null));
		
		phongDAO.themPhong(new Phong("P401", new LoaiPhong("PGD", "Phòng gia đình"),
				11000, 380000, "401",
				new Giuong("GDD2", "Hai giường đôi lớn"),
				"Phòng trống", 2, null));
		phongDAO.themPhong(new Phong("P402", new LoaiPhong("PGD", "Phòng gia đình"),
				11000, 380000, "402",
				new Giuong("GDD2", "Hai giường đôi lớn"),
				"Phòng trống", 2, null));
		phongDAO.themPhong(new Phong("P403", new LoaiPhong("PDD", "Phòng đôi"),
				90000, 320000, "403",
				new Giuong("GS2", "Hai giường đơn nhỏ"),
				"Phòng trống", 2, null));
		
		QLHoadonimp hoadonDAO = new QLHoadon(em);
	}
	
}
