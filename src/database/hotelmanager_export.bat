@echo export database MonogoDB
mongoexport -d "HotelManager" -c "Phong" -o "Phong.json"
mongoexport -d "HotelManager" -c "LoaiPhong" -o "LoaiPhong.json"
mongoexport -d "HotelManager" -c "DatPhong" -o "DatPhong.json"
mongoexport -d "HotelManager" -c "DiaChi" -o "DiaChi.json"
mongoexport -d "HotelManager" -c "Dichvu" -o "Dichvu.json"
mongoexport -d "HotelManager" -c "Giuong" -o "Giuong.json"
mongoexport -d "HotelManager" -c "Hoadon" -o "Hoadon.json"
mongoexport -d "HotelManager" -c "KhachHang" -o "KhachHang.json"
mongoexport -d "HotelManager" -c "LoaiDichvu" -o "LoaiDichvu.json"
mongoexport -d "HotelManager" -c "NhanVien" -o "NhanVien.json"
mongoexport -d "HotelManager" -c "PhieuDichvu" -o "PhieuDichvu.json"
mongoexport -d "HotelManager" -c "TaiKhoan" -o "TaiKhoan.json"
@echo exported sucsess
pause