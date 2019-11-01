package implementsLayer;

import java.util.List;

import entity.PhieuDichvu;

public interface QLPhieuDichvuimp {

	boolean themPhieuDichvu(PhieuDichvu pdv);

	PhieuDichvu timPhieuDichvu(String mapdv);

	boolean xoaPhieuDichvu(String mapdv);

	boolean suaPhieuDichvu(PhieuDichvu pdv);

	List<PhieuDichvu> getDSPhieuDichvu();

}