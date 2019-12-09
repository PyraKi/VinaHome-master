package implementsLayer;

import java.util.List;

import entity.LoaiPhong;

public interface QLLoaiphongimp {

	boolean themLoaiPhong(LoaiPhong lp);

	LoaiPhong timLoaiPhong(String malp);

	boolean xoaLoaiPhong(String malp);

	boolean suaLoaiPhong(LoaiPhong lp);

	List<LoaiPhong> getDSLoaiPhong();

	LoaiPhong timLoaiPhongTheoTen(String tenLP);

}