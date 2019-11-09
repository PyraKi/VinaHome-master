@echo import database MonogoDB
mongoimport --db HotelManager --collection DiaChi --file DiaChi.json --jsonArray
mongoimport --db HotelManager --collection KhachHang --file KhachHang.json --jsonArray
mongoimport --db HotelManager --collection TaiKhoan --file TaiKhoan.json --jsonArray
mongoimport --db HotelManager --collection NhanVien --file NhanVien.json --jsonArray
mongoimport --db HotelManager --collection LoaiPhong --file LoaiPhong.json --jsonArray
mongoimport --db HotelManager --collection Giuong --file Giuong.json --jsonArray
mongoimport --db HotelManager --collection Phong --file Phong.json --jsonArray
@echo import sucsess
pause