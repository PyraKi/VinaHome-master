package implementsLayer;

import java.util.List;

import entity.Giuong;

public interface QLGiuongimp {

	boolean themGiuong(Giuong g);

	Giuong timGiuong(String mag);

	boolean xoaGiuong(String mag);

	boolean suaGiuong(Giuong g);

	List<Giuong> getDSGiuong();

	Giuong timTheoTen(String tenGiuong);

}