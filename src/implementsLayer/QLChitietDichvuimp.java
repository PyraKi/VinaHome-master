package implementsLayer;

import java.util.List;

import entity.ChitietPhieuDichvu;

public interface QLChitietDichvuimp {

	boolean themChitietDichvu(ChitietPhieuDichvu ctdv);

	ChitietPhieuDichvu timChitietDichvu(String maPDV);

	boolean xoaChitietDichvu(String maDC);

	boolean suaChitietDichvu(ChitietPhieuDichvu ctdv);

	List<ChitietPhieuDichvu> getDSChitietDichvu();

}