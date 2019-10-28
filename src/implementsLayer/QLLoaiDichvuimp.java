package implementsLayer;

import java.util.List;

import entity.LoaiDichvu;

public interface QLLoaiDichvuimp {

	boolean themLoaiDichvu(LoaiDichvu ldv);

	LoaiDichvu timLoaiDichvu(String maldv);

	boolean xoaLoaiDichvu(String maldv);

	boolean suaLoaiDichvu(LoaiDichvu ldv);

	List<LoaiDichvu> getDSLoaiDichvu();

}