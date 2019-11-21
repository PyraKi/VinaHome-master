package implementsLayer;

import java.util.List;

import entity.ChitietHoadon;

public interface QLChitietHoadonimp {

	boolean themChitietHoadon(ChitietHoadon cthd);

	ChitietHoadon timChitietHoadon(String maCTHD);

	boolean xoaChitietHoadon(String maCTHD);

	boolean suaChitietHoadon(ChitietHoadon cthd);

	List<ChitietHoadon> getDSChitietHoadon();

}