package implementsLayer;

import java.util.List;

import entity.Phong;

public interface QLPhongimp {

	boolean themPhong(Phong p);

	Phong timPhong(String map);

	boolean xoaPhong(String map);

	boolean suaPhong(Phong p);

	List<Phong> getDSPhong();

}