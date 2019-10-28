package implementsLayer;

import java.util.List;

import entity.DiaChi;

public interface QLDiachiimp {

	boolean themDiachi(DiaChi dc);

	DiaChi timDiachi(String maDC);

	boolean xoaDiachi(String maDC);

	boolean suaDiachi(DiaChi dc);

	List<DiaChi> getDSDiachi();

}