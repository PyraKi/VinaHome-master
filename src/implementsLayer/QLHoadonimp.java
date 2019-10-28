package implementsLayer;

import java.util.List;

import entity.Hoadon;

public interface QLHoadonimp {

	boolean themHoadon(Hoadon hd);

	Hoadon timHoadon(String maHD);

	boolean xoaHoadon(String maHD);

	boolean suaHoadon(Hoadon hd);

	List<Hoadon> getDSHoadon();

}