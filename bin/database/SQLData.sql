create database DB_QLKS
GO
USE DB_QLKS
GO

/****** Object:  Table [dbo].[HoaDon]    Script Date: 10/14/2019 9:33:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[maHD] [varchar](10) NOT NULL,
	[maKH] [varchar](10) NULL,
	[maNV] [varchar](10) NULL,
	[maPhong] [varchar](10) NOT NULL,
	[NgayThue] [date] NULL,
	[thanhTien] [real] NULL
	PRIMARY KEY CLUSTERED 
(
	[maHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[ChiTietPhieuDichVu]    Script Date: 10/14/2019 9:33:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietPhieuDichVu](
	[maPDV] [varchar](10) NOT NULL,
	[maDV] [varchar](10) NOT NULL,
	[soluong] [int] NULL,
	PRIMARY KEY (maPDV, maDV)
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[DiaChi]    Script Date: 10/14/2019 9:33:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DiaChi](
	[maDiaChi] [varchar](20) NOT NULL,
	[duong] [nvarchar](20) NULL,
	[soNha] [nvarchar](20) NULL,
	[phuong] [nvarchar](20) NULL,
	[quan] [nvarchar](20) NULL,
	[tinh] [nvarchar](20) NULL
	PRIMARY KEY CLUSTERED 
(
	[maDiaChi] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[LoaiDichVu]    Script Date: 10/14/2019 9:33:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiDichVu](
	[maLDV] [varchar](10) NOT NULL,
	[tenLDV] [nvarchar](30) NULL
	PRIMARY KEY CLUSTERED 
(
	[maLDV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
)ON [PRIMARY]
GO

/****** Object:  Table [dbo].[DichVu]    Script Date: 10/14/2019 9:33:36 PM ******/
CREATE TABLE [dbo].[DichVu](
	[maDV] [varchar](10) NOT NULL,
	[tenDV] [nvarchar](20) NULL,
	[maLDV] [varchar](10) NULL,
	[gia] [real] NULL,
	[soLuong] [int] NULL
	PRIMARY KEY CLUSTERED 
(
	[maDV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[KhachHang]    Script Date: 10/14/2019 9:33:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[maKH] [varchar](10) NOT NULL,
	[maDiaChi] [varchar](20) NULL,
	[tenKH] [nvarchar](50) NULL,
	[soCMND] [varchar](9) NULL,
	[namSinh] [date] NULL,
	[LoaiKH] [varchar](9) NULL,
	[SDT] [varchar](10) NULL
	PRIMARY KEY CLUSTERED 
(
	[maKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[LoaiPhong]    Script Date: 10/14/2019 9:33:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiPhong](
	[maLP] [varchar](10) NOT NULL,
	[loaiPhong] [nvarchar](10) NULL
	PRIMARY KEY CLUSTERED 
(
	[maLP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[NhanVien]    Script Date: 10/14/2019 9:33:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[maNV] [varchar](10) NOT NULL,
	[tenNV] [nvarchar](50) NULL,
	[soCMND] [varchar](9) NULL,
	[email] [varchar](50) NULL,
	[soDT] [varchar](10) NULL,
	[maDiaChi] [varchar](20) NULL,
	[chucVu] [nvarchar](10) NULL,
	[namSinh] [date] NULL
	PRIMARY KEY CLUSTERED 
(
	[maNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[PhieuDichVu]    Script Date: 10/14/2019 9:33:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuDichVu](
	[maPDV] [varchar](10) NOT NULL,
	[maNV] [varchar](10) NULL,
	[ngayLap] [date] NULL,
	[thanhTien] [real] NULL
	PRIMARY KEY CLUSTERED 
(
	[maPDV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[Phong]    Script Date: 10/14/2019 9:33:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Phong](
	[maPhong] [varchar](10) NOT NULL,
	[maLP] [varchar](10) NULL,
	[giaTheogio] [real] NULL,
	[giaQuadem] [real] NULL,
	[soPhong] [int] NULL
	PRIMARY KEY CLUSTERED 
(
	[maPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 10/14/2019 9:33:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[maNV] [varchar](10) NOT NULL,
	[tenTK] [varchar](10) NOT NULL,
	[matKhau] [varchar](10) NULL
	PRIMARY KEY (maNV, tenTK)
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[TinhTrangPhong]    Script Date: 10/14/2019 9:33:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TinhTrangPhong](
	[maPhong] [varchar](10) NOT NULL,
	[TinhTrangPhong] [nvarchar](30) NULL
	PRIMARY KEY CLUSTERED 
(
	[maPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO


/****** Object:  Table [dbo].[DanhSachDatPhong]    Script Date: 10/14/2019 9:33:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DanhSachDatPhong](
	[maPhong] [varchar](10) NOT NULL,
	[NgayDat] [date] NULL,
	[GioDat] [time] NULL,
	[NgayTra] [date] NULL,
	[GioTra] [time] NULL
	PRIMARY KEY CLUSTERED 
(
	[maPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO


INSERT [dbo].[DiaChi] ([maDiaChi], [duong], [soNha], [phuong], [quan], [tinh]) VALUES (N'BD002', N'Lê Hồng Phong', N'253', N'5', N'Thủ Dầu Một', N'Bình Dương')
INSERT [dbo].[DiaChi] ([maDiaChi], [duong], [soNha], [phuong], [quan], [tinh]) VALUES (N'BD101', N'Hòa Lợi', N'147/7', N'3', N'Thủ Dầu Một', N'Bình Dương')
INSERT [dbo].[DiaChi] ([maDiaChi], [duong], [soNha], [phuong], [quan], [tinh]) VALUES (N'BD102', N'Phú Lợi', N'369/3', N'9', N'Thủ Dầu Một', N'Bình Dương')
INSERT [dbo].[DiaChi] ([maDiaChi], [duong], [soNha], [phuong], [quan], [tinh]) VALUES (N'TP001', N'Nguyễn Văn Bảo', N'1/7/11', N'3', N'Gò Vấp', N'TP HCM')
INSERT [dbo].[DiaChi] ([maDiaChi], [duong], [soNha], [phuong], [quan], [tinh]) VALUES (N'TP002', N'Trúc Anh Đài', N'369/4', N'9', N'Phú Nhuận', N'TP HCM')
INSERT [dbo].[DiaChi] ([maDiaChi], [duong], [soNha], [phuong], [quan], [tinh]) VALUES (N'HN101', N'Trần Duy Hưng', N'106/9', N'9', N'Cầu Giấy', N'Hà Nội')
INSERT [dbo].[DiaChi] ([maDiaChi], [duong], [soNha], [phuong], [quan], [tinh]) VALUES (N'BT102', N'Võ Đắt', N'106/9', N'Đức Tài', N'Đức Linh', N'Bình Thuận')
INSERT [dbo].[DiaChi] ([maDiaChi], [duong], [soNha], [phuong], [quan], [tinh]) VALUES (N'AG102', N'Huy Song', N'20', N'Đất Đỏ', N'Ma Mút', N'An Giang')
INSERT [dbo].[DiaChi] ([maDiaChi], [duong], [soNha], [phuong], [quan], [tinh]) VALUES (N'CT102', N'Chà Lá', N'96', N'Phước Hòa', N'Phú Giáo', N'Cần Thơ')
INSERT [dbo].[DiaChi] ([maDiaChi], [duong], [soNha], [phuong], [quan], [tinh]) VALUES (N'TP103', N'Quang Trung', N'96', N'8', N'Gò Vấp', N'TP HCM')
INSERT [dbo].[DiaChi] ([maDiaChi], [duong], [soNha], [phuong], [quan], [tinh]) VALUES (N'LD102', N'Lạ Lùng', N'2017', N'8', N'Đà Lạt', N'Lâm Đồng')
INSERT [dbo].[DiaChi] ([maDiaChi], [duong], [soNha], [phuong], [quan], [tinh]) VALUES (N'LA102', N'Đông Kiếm em', N'17', N'9', N'Tân An', N'Long An')
INSERT [dbo].[DiaChi] ([maDiaChi], [duong], [soNha], [phuong], [quan], [tinh]) VALUES (N'DN102', N'Mùa Hè', N'69/96', N'11', N'Sơn Trà', N'Đà Nẵng')
INSERT [dbo].[DiaChi] ([maDiaChi], [duong], [soNha], [phuong], [quan], [tinh]) VALUES (N'HU102', N'Hoa Tím', N'104', N'6', N'Thừa Thiên Huế', N'Huế')
INSERT [dbo].[DiaChi] ([maDiaChi], [duong], [soNha], [phuong], [quan], [tinh]) VALUES (N'SP102', N'Mây Núi', N'474', N'12', N'Sa Pa', N'Sa Pa')



INSERT [dbo].[LoaiDichVu] ([malDV], [tenlDV]) VALUES (N'DVAN', N'Ăn')
INSERT [dbo].[LoaiDichVu] ([malDV], [tenlDV]) VALUES (N'DVUONG', N'Giải khát')

INSERT [dbo].[DichVu] ([maDV], [tenDV], [maLDV], [gia], [soLuong]) VALUES (N'DVA001', N'Phở', N'DVAN', 35000, 12)
INSERT [dbo].[DichVu] ([maDV], [tenDV], [maLDV], [gia], [soLuong]) VALUES (N'DVA002', N'Cơm Sườn', N'DVAN', 27000, 14)
INSERT [dbo].[DichVu] ([maDV], [tenDV], [maLDV], [gia], [soLuong]) VALUES (N'DVU001', N'Nước khoáng', N'DVUONG', 8000, 22)
INSERT [dbo].[DichVu] ([maDV], [tenDV], [maLDV], [gia], [soLuong]) VALUES (N'DVU002', N'String', N'DVUONG',15000, 16)

INSERT [dbo].[KhachHang] ([maKH], [maDiaChi], [tenKH], [soCMND], [namSinh], [LoaiKH], [SDT]) VALUES (N'KH101', N'BD101', N'Lê Thị Thắm', N'281163633', CAST(N'1987-03-03' AS Date), N'Thuong', N'0299345338')
INSERT [dbo].[KhachHang] ([maKH], [maDiaChi], [tenKH], [soCMND], [namSinh], [LoaiKH], [SDT]) VALUES (N'KH102', N'TP002', N'Huỳnh Ngọc Giàu', N'867344123', CAST(N'1981-12-04' AS Date), N'VIP', N'0139731171')
INSERT [dbo].[KhachHang] ([maKH], [maDiaChi], [tenKH], [soCMND], [namSinh], [LoaiKH], [SDT]) VALUES (N'KH103', N'TP002', N'Phan THị Minh Châu', N'867344477', CAST(N'1981-02-01' AS Date), N'VIP', N'0772123191')
INSERT [dbo].[KhachHang] ([maKH], [maDiaChi], [tenKH], [soCMND], [namSinh], [LoaiKH], [SDT]) VALUES (N'KH104', N'TP002', N'Huỳnh Ngọc Hùng', N'867344147', CAST(N'1981-12-05' AS Date), N'VIP', N'0979631475')
INSERT [dbo].[KhachHang] ([maKH], [maDiaChi], [tenKH], [soCMND], [namSinh], [LoaiKH], [SDT]) VALUES (N'KH105', N'TP002', N'Nguyễn Thị Ngọc Huyền', N'867344258', CAST(N'1981-03-03' AS Date), N'VIP', N'0730801348')
INSERT [dbo].[KhachHang] ([maKH], [maDiaChi], [tenKH], [soCMND], [namSinh], [LoaiKH], [SDT]) VALUES (N'KH106', N'TP002', N'Huỳnh Ngọc Hảo', N'867344369', CAST(N'1999-08-08' AS Date), N'VIP', N'0963961941')
INSERT [dbo].[KhachHang] ([maKH], [maDiaChi], [tenKH], [soCMND], [namSinh], [LoaiKH], [SDT]) VALUES (N'KH107', N'TP002', N'Trần Gia Huy', N'867344654', CAST(N'1998-03-07' AS Date), N'VIP', N'0720725565')
INSERT [dbo].[KhachHang] ([maKH], [maDiaChi], [tenKH], [soCMND], [namSinh], [LoaiKH], [SDT]) VALUES (N'KH108', N'HN101', N'Nguyễn Văn Tứ', N'582335951', CAST(N'1999-10-10' AS Date), N'Thuong', N'0943763552')
INSERT [dbo].[KhachHang] ([maKH], [maDiaChi], [tenKH], [soCMND], [namSinh], [LoaiKH], [SDT]) VALUES (N'KH109', N'HN101', N'Trần Thị Thùy Trang', N'582335959', CAST(N'1999-11-1' AS Date), N'Thuong', N'0130000481')
INSERT [dbo].[KhachHang] ([maKH], [maDiaChi], [tenKH], [soCMND], [namSinh], [LoaiKH], [SDT]) VALUES (N'KH110', N'BT102', N'Lê Duy Tân', N'778047746', CAST(N'1999-03-04' AS Date), N'Thuong', N'0998161420')
INSERT [dbo].[KhachHang] ([maKH], [maDiaChi], [tenKH], [soCMND], [namSinh], [LoaiKH], [SDT]) VALUES (N'KH111', N'BT102', N'Trần Anh Khoa', N'778047696', CAST(N'1999-06-11' AS Date), N'Thuong', N'0366538330')
INSERT [dbo].[KhachHang] ([maKH], [maDiaChi], [tenKH], [soCMND], [namSinh], [LoaiKH], [SDT]) VALUES (N'KH112', N'AG102', N'Võ Thành Đoàn', N'738689999', CAST(N'1999-01-01' AS Date), N'Thuong', N'0154161717')
INSERT [dbo].[KhachHang] ([maKH], [maDiaChi], [tenKH], [soCMND], [namSinh], [LoaiKH], [SDT]) VALUES (N'KH113', N'AG102', N'Phan Huy Quỳnh', N'738689901', CAST(N'1999-12-12' AS Date), N'Thuong', N'0164698224')
INSERT [dbo].[KhachHang] ([maKH], [maDiaChi], [tenKH], [soCMND], [namSinh], [LoaiKH], [SDT]) VALUES (N'KH114', N'CT102', N'Nguyễn Văn Tâm', N'695943227', CAST(N'1999-10-11' AS Date), N'Thuong', N'0287113184')
INSERT [dbo].[KhachHang] ([maKH], [maDiaChi], [tenKH], [soCMND], [namSinh], [LoaiKH], [SDT]) VALUES (N'KH115', N'CT102', N'Trần Đức Viễn', N'695943241', CAST(N'1999-08-03' AS Date), N'Thuong', N'0954838931')
INSERT [dbo].[KhachHang] ([maKH], [maDiaChi], [tenKH], [soCMND], [namSinh], [LoaiKH], [SDT]) VALUES (N'KH116', N'TP103', N'Lê Hoàng Phú', N'929569613', CAST(N'1999-02-10' AS Date), N'VIP', N'054828208')
INSERT [dbo].[KhachHang] ([maKH], [maDiaChi], [tenKH], [soCMND], [namSinh], [LoaiKH], [SDT]) VALUES (N'KH117', N'TP103', N'Nguyễn Nhật Trường', N'929569210', CAST(N'1999-02-11' AS Date), N'VIP', N'0461367310')
INSERT [dbo].[KhachHang] ([maKH], [maDiaChi], [tenKH], [soCMND], [namSinh], [LoaiKH], [SDT]) VALUES (N'KH118', N'TP103', N'Nguyễn Thành Đạt', N'929563102', CAST(N'1999-01-06' AS Date), N'VIP', N'0394457556')
INSERT [dbo].[KhachHang] ([maKH], [maDiaChi], [tenKH], [soCMND], [namSinh], [LoaiKH], [SDT]) VALUES (N'KH119', N'LD102', N'Vũ Phạm Đình Thái', N'210786211', CAST(N'1999-01-05' AS Date), N'VIP', N'0254259590')
INSERT [dbo].[KhachHang] ([maKH], [maDiaChi], [tenKH], [soCMND], [namSinh], [LoaiKH], [SDT]) VALUES (N'KH120', N'LD102', N'Huỳnh Phương', N'210786229', CAST(N'1999-03-04' AS Date), N'VIP', N'0450075120')
INSERT [dbo].[KhachHang] ([maKH], [maDiaChi], [tenKH], [soCMND], [namSinh], [LoaiKH], [SDT]) VALUES (N'KH121', N'LD102', N'Lê Thế Vinh', N'210786296', CAST(N'1999-10-08' AS Date), N'VIP', N'0906920151')
INSERT [dbo].[KhachHang] ([maKH], [maDiaChi], [tenKH], [soCMND], [namSinh], [LoaiKH], [SDT]) VALUES (N'KH122', N'LD102', N'Lê Thế Lâm', N'210786274', CAST(N'1999-12-08' AS Date), N'VIP', N'0979631475')
INSERT [dbo].[KhachHang] ([maKH], [maDiaChi], [tenKH], [soCMND], [namSinh], [LoaiKH], [SDT]) VALUES (N'KH123', N'LD102', N'Nguyễn Ngọc Mai Linh', N'210786123', CAST(N'1999-01-08' AS Date), N'VIP', N'0265112560')
INSERT [dbo].[KhachHang] ([maKH], [maDiaChi], [tenKH], [soCMND], [namSinh], [LoaiKH], [SDT]) VALUES (N'KH124', N'LD102', N'Trịnh Ngọc Thanh', N'210786741', CAST(N'1999-02-09' AS Date), N'VIP', N'0342244604')
INSERT [dbo].[KhachHang] ([maKH], [maDiaChi], [tenKH], [soCMND], [namSinh], [LoaiKH], [SDT]) VALUES (N'KH125', N'LA102', N'Nguyễn Anh Quân', N'370174069', CAST(N'1999-01-12' AS Date), N'Thuong', N'0450276285')
INSERT [dbo].[KhachHang] ([maKH], [maDiaChi], [tenKH], [soCMND], [namSinh], [LoaiKH], [SDT]) VALUES (N'KH126', N'LA102', N'Nguyễn Phạm Thu Hường', N'371740112', CAST(N'1999-06-04' AS Date), N'Thuong', N'0551239356')
INSERT [dbo].[KhachHang] ([maKH], [maDiaChi], [tenKH], [soCMND], [namSinh], [LoaiKH], [SDT]) VALUES (N'KH127', N'LA102', N'Phan Trọng Hiếu', N'370174414', CAST(N'1999-01-07' AS Date), N'Thuong', N'0270468099')
INSERT [dbo].[KhachHang] ([maKH], [maDiaChi], [tenKH], [soCMND], [namSinh], [LoaiKH], [SDT]) VALUES (N'KH128', N'DN102', N'Trần Ngọc Thúy Vy', N'696143339', CAST(N'1999-05-04' AS Date), N'Thuong', N'0741606406')
INSERT [dbo].[KhachHang] ([maKH], [maDiaChi], [tenKH], [soCMND], [namSinh], [LoaiKH], [SDT]) VALUES (N'KH129', N'HU102', N'Lê Thị Thu Thúy', N'615684721', CAST(N'1999-11-10' AS Date), N'Thuong', N'0972277119')
INSERT [dbo].[KhachHang] ([maKH], [maDiaChi], [tenKH], [soCMND], [namSinh], [LoaiKH], [SDT]) VALUES (N'KH130', N'SP102', N'Bùi Phương Trinh', N'256381812', CAST(N'1999-12-09' AS Date), N'Thuong', N'0776433030')
INSERT [dbo].[KhachHang] ([maKH], [maDiaChi], [tenKH], [soCMND], [namSinh], [LoaiKH], [SDT]) VALUES (N'KH131', N'SP102', N'Lê Tấn Linh', N'256383692', CAST(N'1999-09-08' AS Date), N'Thuong', N'0751514697')

INSERT [dbo].[LoaiPhong] ([maLP], [loaiPhong]) VALUES (N'LPD', N'Đơn')
INSERT [dbo].[LoaiPhong] ([maLP], [loaiPhong]) VALUES (N'LPDD', N'Đôi')
INSERT [dbo].[LoaiPhong] ([maLP], [loaiPhong]) VALUES (N'LPGD', N'Gia Đình')


INSERT [dbo].[Phong] ([maPhong], [maLP], [giaTheogio], [giaQuadem], [soPhong]) VALUES (N'PD1', N'LPD', 60000, 300000, 101)
INSERT [dbo].[Phong] ([maPhong], [maLP], [giaTheogio], [giaQuadem], [soPhong]) VALUES (N'PD3', N'LPD', 60000, 300000, 103)
INSERT [dbo].[Phong] ([maPhong], [maLP], [giaTheogio], [giaQuadem], [soPhong]) VALUES (N'PD4', N'LPD', 60000, 300000, 104)
INSERT [dbo].[Phong] ([maPhong], [maLP], [giaTheogio], [giaQuadem], [soPhong]) VALUES (N'PD5', N'LPD', 60000, 300000, 201)
INSERT [dbo].[Phong] ([maPhong], [maLP], [giaTheogio], [giaQuadem], [soPhong]) VALUES (N'PD2', N'LPD', 60000, 300000, 102)
INSERT [dbo].[Phong] ([maPhong], [maLP], [giaTheogio], [giaQuadem], [soPhong]) VALUES (N'PD6', N'LPD', 60000, 300000, 202)
INSERT [dbo].[Phong] ([maPhong], [maLP], [giaTheogio], [giaQuadem], [soPhong]) VALUES (N'PD7', N'LPD', 60000, 300000, 203)

INSERT [dbo].[Phong] ([maPhong], [maLP], [giaTheogio], [giaQuadem], [soPhong]) VALUES (N'PDD1', N'LPDD', 70000, 360000, 204)
INSERT [dbo].[Phong] ([maPhong], [maLP], [giaTheogio], [giaQuadem], [soPhong]) VALUES (N'PDD2', N'LPDD', 70000, 360000, 301)
INSERT [dbo].[Phong] ([maPhong], [maLP], [giaTheogio], [giaQuadem], [soPhong]) VALUES (N'PDD3', N'LPDD', 70000, 360000, 302)
INSERT [dbo].[Phong] ([maPhong], [maLP], [giaTheogio], [giaQuadem], [soPhong]) VALUES (N'PDD4', N'LPDD', 70000, 360000, 303)
INSERT [dbo].[Phong] ([maPhong], [maLP], [giaTheogio], [giaQuadem], [soPhong]) VALUES (N'PDD5', N'LPDD', 70000, 360000, 304)

INSERT [dbo].[Phong] ([maPhong], [maLP], [giaTheogio], [giaQuadem], [soPhong]) VALUES (N'PGD1', N'LPGD', 110000, 420000, 401)
INSERT [dbo].[Phong] ([maPhong], [maLP], [giaTheogio], [giaQuadem], [soPhong]) VALUES (N'PGD2', N'LPGD', 110000, 420000, 402)


INSERT [dbo].[TinhTrangPhong] ([maPhong], [TinhTrangPhong]) VALUES (N'PD1', N'Phòng trống')
INSERT [dbo].[TinhTrangPhong] ([maPhong], [TinhTrangPhong]) VALUES (N'PD2', N'Phòng đang thuê')
INSERT [dbo].[TinhTrangPhong] ([maPhong], [TinhTrangPhong]) VALUES (N'PD3', N'Phòng trống')
INSERT [dbo].[TinhTrangPhong] ([maPhong], [TinhTrangPhong]) VALUES (N'PD4', N'Phòng đang thuê')
INSERT [dbo].[TinhTrangPhong] ([maPhong], [TinhTrangPhong]) VALUES (N'PD5', N'Phòng đang thuê')
INSERT [dbo].[TinhTrangPhong] ([maPhong], [TinhTrangPhong]) VALUES (N'PD6', N'Phòng đang thuê')
INSERT [dbo].[TinhTrangPhong] ([maPhong], [TinhTrangPhong]) VALUES (N'PD7', N'Phòng đặt')

INSERT [dbo].[TinhTrangPhong] ([maPhong], [TinhTrangPhong]) VALUES (N'PDD1', N'Phòng đang thuê')
INSERT [dbo].[TinhTrangPhong] ([maPhong], [TinhTrangPhong]) VALUES (N'PDD2', N'Phòng trống')
INSERT [dbo].[TinhTrangPhong] ([maPhong], [TinhTrangPhong]) VALUES (N'PDD3', N'Phòng trống')
INSERT [dbo].[TinhTrangPhong] ([maPhong], [TinhTrangPhong]) VALUES (N'PDD4', N'Phòng trống')
INSERT [dbo].[TinhTrangPhong] ([maPhong], [TinhTrangPhong]) VALUES (N'PDD5', N'Phòng đang thuê')

INSERT [dbo].[TinhTrangPhong] ([maPhong], [TinhTrangPhong]) VALUES (N'PGD1', N'Phòng trống')
INSERT [dbo].[TinhTrangPhong] ([maPhong], [TinhTrangPhong]) VALUES (N'PGD2', N'Phòng trống')


INSERT [dbo].[NhanVien] ([maNV], [tenNV], [soCMND], [email], [soDT], [maDiaChi], [chucVu], [namSinh]) VALUES (N'QL01', N'Nguyễn Văn Thành', N'281196757', N'thanhnguyen@gmail.com', N'0393100165', N'BD002', N'Quản Lý', CAST(N'1999-12-08' AS Date))
INSERT [dbo].[NhanVien] ([maNV], [tenNV], [soCMND], [email], [soDT], [maDiaChi], [chucVu], [namSinh]) VALUES (N'NV03', N'Bùi Văn Ninh', N'169637559', N'ninhbui@gmail.com', N'0978863647', N'TP001', N'Tiếp tân', CAST(N'1999-02-11' AS Date))
INSERT [dbo].[NhanVien] ([maNV], [tenNV], [soCMND], [email], [soDT], [maDiaChi], [chucVu], [namSinh]) VALUES (N'NV02', N'Tạ Duy Thắng', N'511431326', N'duythang@gmail.com', N'0981123650', N'TP001', N'Tiếp tân', CAST(N'1999-05-19' AS Date))
INSERT [dbo].[NhanVien] ([maNV], [tenNV], [soCMND], [email], [soDT], [maDiaChi], [chucVu], [namSinh]) VALUES (N'NV01', N'Nguyễn Thị Quỳnh', N'982588528', N'thiquynh@gmail.com', N'0998124120', N'TP001', N'Tiếp tân', CAST(N'1999-04-12' AS Date))


INSERT [dbo].[TaiKhoan] ([maNV], [tenTK], [matKhau]) VALUES (N'QL01', N'QL001', N'123123')
INSERT [dbo].[TaiKhoan] ([maNV], [tenTK], [matKhau]) VALUES (N'NV01', N'NV001', N'123123')
INSERT [dbo].[TaiKhoan] ([maNV], [tenTK], [matKhau]) VALUES (N'NV02', N'NV002', N'123123')
INSERT [dbo].[TaiKhoan] ([maNV], [tenTK], [matKhau]) VALUES (N'NV03', N'NV003', N'123123')


ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD FOREIGN KEY([maPhong])
REFERENCES [dbo].[Phong] ([maPhong])
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD FOREIGN KEY([maKH])
REFERENCES [dbo].[KhachHang] ([maKH])
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD FOREIGN KEY([maNV])
REFERENCES [dbo].[NhanVien] ([maNV])
GO


ALTER TABLE [dbo].[KhachHang]  WITH CHECK ADD FOREIGN KEY([maDiaChi])
REFERENCES [dbo].[DiaChi] ([maDiaChi])
GO

ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD FOREIGN KEY([maDiaChi])
REFERENCES [dbo].[DiaChi] ([maDiaChi])
GO


ALTER TABLE [dbo].[PhieuDichVu]  WITH CHECK ADD FOREIGN KEY([maNV])
REFERENCES [dbo].[NhanVien] ([maNV])
GO

ALTER TABLE [dbo].[Phong]  WITH CHECK ADD FOREIGN KEY([maLP])
REFERENCES [dbo].[LoaiPhong] ([maLP])
GO

ALTER TABLE [dbo].[TaiKhoan]  WITH CHECK ADD FOREIGN KEY([maNV])
REFERENCES [dbo].[NhanVien] ([maNV])
GO

ALTER TABLE [dbo].[TinhTrangPhong]  WITH CHECK ADD FOREIGN KEY([maPhong])
REFERENCES [dbo].[Phong] ([maPhong])
GO

ALTER TABLE [dbo].[DanhSachDatPhong]  WITH CHECK ADD FOREIGN KEY([maPhong])
REFERENCES [dbo].[Phong] ([maPhong])
GO

ALTER TABLE [dbo].[ChiTietPhieuDichVu]  WITH CHECK ADD FOREIGN KEY([maPDV])
REFERENCES [dbo].[PhieuDichVu] ([maPDV])
GO

ALTER TABLE [dbo].[ChiTietPhieuDichVu]  WITH CHECK ADD FOREIGN KEY([maDV])
REFERENCES [dbo].[DichVu] ([maDV])
GO

ALTER TABLE [dbo].[DichVu]  WITH CHECK ADD FOREIGN KEY([maLDV])
REFERENCES [dbo].[LoaiDichVu] ([maLDV])
GO
