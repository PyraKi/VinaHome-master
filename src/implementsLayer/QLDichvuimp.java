package implementsLayer;

import java.util.List;

import entity.Dichvu;

public interface QLDichvuimp {

	boolean themDichvu(Dichvu dv);

	Dichvu timDichvu(String madv);

	boolean xoaDichvu(String madv);

	boolean suaDichvu(Dichvu dv);

	List<Dichvu> getDSDichvu();

}