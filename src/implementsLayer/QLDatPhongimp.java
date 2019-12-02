package implementsLayer;

import java.util.List;

import entity.DatPhong;

public interface QLDatPhongimp {

	boolean themDatPhong(DatPhong dp);

	DatPhong timDatPhong(String maPD);

	boolean xoaDatPhong(String maPD);

	boolean suaDatPhong(DatPhong dp);

	List<DatPhong> getDSDatPhong();

	boolean kiemTraTrung(DatPhong o);

}