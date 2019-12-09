package useInterface;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.toedter.calendar.JDateChooser;

import entity.ChitietHoadon;
import entity.ChitietPhieuDichvu;
import entity.DatPhong;
import entity.DiaChi;
import entity.Dichvu;
import entity.Giuong;
import entity.Hoadon;
import entity.KhachHang;
import entity.LoaiDichvu;
import entity.LoaiPhong;
import entity.NhanVien;
import entity.PhieuDichvu;
import entity.Phong;
import entity.TaiKhoan;
import implementsLayer.QLChitietDichvuimp;
import implementsLayer.QLChitietHoadonimp;
import implementsLayer.QLDatPhongimp;
import implementsLayer.QLDiachiimp;
import implementsLayer.QLDichvuimp;
import implementsLayer.QLGiuongimp;
import implementsLayer.QLHoadonimp;
import implementsLayer.QLKhachhangimp;
import implementsLayer.QLLoaiDichvuimp;
import implementsLayer.QLLoaiphongimp;
import implementsLayer.QLNhanvienimp;
import implementsLayer.QLPhieuDichvuimp;
import implementsLayer.QLPhongimp;
import implementsLayer.QLTaiKhoanimp;
import managerLayer.QLChitietDichvu;
import managerLayer.QLChitietHoadon;
import managerLayer.QLDatPhong;
import managerLayer.QLDiachi;
import managerLayer.QLDichvu;
import managerLayer.QLGiuong;
import managerLayer.QLHoadon;
import managerLayer.QLKhachhang;
import managerLayer.QLLoaiDichvu;
import managerLayer.QLLoaiphong;
import managerLayer.QLNhanVien;
import managerLayer.QLPhieuDichvu;
import managerLayer.QLPhong;
import managerLayer.QLTaiKhoan;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.swing.SwingConstants;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.JSpinner;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;


@SuppressWarnings("serial")
public class UIVinaHome extends JFrame {

	private JPanel contentPane;
	private JLabel time = new JLabel("20:18:45", SwingConstants.CENTER);
	private JLabel dateweek = new JLabel("Thứ hai", SwingConstants.CENTER);
	private JLabel date = new JLabel("09/12/2018", SwingConstants.CENTER);
	private JLabel label_soPhong = new JLabel("16", SwingConstants.RIGHT);
	private JPanel panel_DanhSachPhong = new JPanel();
	private JPanel panel_DSKhachHang = new JPanel();
	private JPanel panel_Dichvu = new JPanel();
	private JPanel panel_ChitietDV = new JPanel();
	private JPanel panel_DSDichvu = new JPanel();
	private JPanel panel_DSNhanVien = new JPanel();
	private JPanel panel_DSHDatPhong = new JPanel();
	private JPanel panel_Thongke = new JPanel();
	private JButton btLaphoadon;
	private JTextField tim = new JTextField();
	private JButton[] phongs;
	private JSpinner[] spinners;
	private JTable tableDSKhachhang;
	private DefaultTableModel dfmodelDSKH;
	private JTable tableDSNhanvien;
	private DefaultTableModel dfmodelDSNV;
	private JTable tableDSDatPhong;
	private DefaultTableModel dfmodelDSDP;
	private JComboBox<String> comboBox_Tim = new JComboBox<String>();
	private TableRowSorter<TableModel> sorterDSKH;
	private TableRowSorter<TableModel> sorterDSNV;
	private TableRowSorter<TableModel> sorterDSDP;
	private String[] timphong = new String[] {
			"Số phòng", "Tầng", "Loại phòng"
	};
	private String titleKH[] = {
			"Mã KH", "Họ tên", "Loại", "Số CMND", "Năm sinh", "SDT", "Địa chỉ"	
	};
	private String titleNV[] = {
			"Mã NV", "Họ tên", "Chức vụ", "Tên tài khoảng", "email", "Số CMND", "Năm sinh", "SDT", "Địa chỉ"
	};
	private String titleDP[] = {
			"Mã đặt phòng", "Họ tên KH", "Số điện thoại", "Phòng", "Hình thức DP", "Ngày đặt phòng", "Giờ đặt phòng"
	};
	private JTable table_ChitietHoadon;
	private DefaultTableModel dfmodelCTHD;
	private String titleCTHD[] = {
			"STT", "Tên dịch vụ", "Loại dịch vụ", "Giá dịch vụ", "Số lượng", "Tổng"
	};
	private String itemsDichvu[] = {
			"Tên dịch vụ", "Loại dịch vụ"
	};
	private JLabel lbtotal;
	private Locale locale = new Locale("vi", "VN");
	private NumberFormat format = NumberFormat.getCurrencyInstance(locale);
	private JLabel lblSPhng = new JLabel("Số phòng còn trống:");
	private static EntityManager em;
	private QLKhachhangimp khachhangDAO;
	private QLDichvuimp dichvuDAO;
	private QLPhongimp phongDAO;
	private QLDiachiimp diachiDAO;
	private QLChitietDichvuimp chitietdichvuDAO;
	private QLPhieuDichvuimp phieuDichvuDAO;
	private QLNhanvienimp nhanVienDAO;
	private QLTaiKhoanimp taiKhoanDAO;
	private QLHoadonimp hoadonDAO;
	private QLChitietHoadonimp chitietHoadonDAO;
	private QLLoaiDichvuimp loaiDichvuDAO;
	private QLDatPhongimp datPhongDAO;
	private QLLoaiphongimp loaiphongDAO;
	private QLGiuongimp giuongDAO;
	private NhanVien nhanVien = new NhanVien();
	private PhieuDichvu phieuDichvu;

	public UIVinaHome(NhanVien nhanVien, EntityManager em) {
		this.nhanVien = nhanVien;
		UIVinaHome.em = em;
		taiKhoanDAO = new QLTaiKhoan(em);
		nhanVienDAO = new QLNhanVien(em);
		khachhangDAO = new QLKhachhang(em);
		dichvuDAO = new QLDichvu(em);
		phongDAO = new QLPhong(em);
		diachiDAO = new QLDiachi(em);
		chitietdichvuDAO = new QLChitietDichvu(em);
		phieuDichvuDAO = new QLPhieuDichvu(em);
		hoadonDAO = new  QLHoadon(em);
		chitietHoadonDAO = new QLChitietHoadon(em);
		loaiDichvuDAO = new QLLoaiDichvu(em);
		datPhongDAO = new QLDatPhong(em);
		loaiphongDAO = new QLLoaiphong(em);
		giuongDAO = new QLGiuong(em);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setBounds(0, 0, 1920, 1080);
		setTitle("Quản lý khách sạn");
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.WHITE);
		menuBar.setBackground(Color.WHITE);
		setJMenuBar(menuBar);
		
		JMenu mnNhanvien = new JMenu("Nhân viên");
		mnNhanvien.setBackground(Color.WHITE);
		mnNhanvien.setIcon(new ImageIcon(UIVinaHome.class.getResource("/images/employee.jpg")));
		mnNhanvien.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		menuBar.add(mnNhanvien);

		JMenuItem itemPhong = new JMenuItem("Phòng");
		itemPhong.setIcon(new ImageIcon(UIVinaHome.class.getResource("/images/room.png")));
		itemPhong.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		mnNhanvien.add(itemPhong);
		itemPhong.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				displayFormDSPhong();
			}
		});

		JMenuItem itemKhachhang = new JMenuItem("Khách Hàng");
		itemKhachhang.setIcon(new ImageIcon(UIVinaHome.class.getResource("/images/dsKhachhang.png")));
		itemKhachhang.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		mnNhanvien.add(itemKhachhang);
		itemKhachhang.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				displayFormDSKhachHang();
			}
		});

		JMenuItem itemDichvu = new JMenuItem("Dịch vụ");
		itemDichvu.setIcon(new ImageIcon(UIVinaHome.class.getResource("/images/dichvu.png")));
		itemDichvu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		mnNhanvien.add(itemDichvu);
		itemDichvu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				displayFormDSDichvu();
			}
		});


		JMenu mnQuanly = new JMenu("Quản lý");
		mnQuanly.setIcon(new ImageIcon(UIVinaHome.class.getResource("/images/employee-settings.png")));
		mnQuanly.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		menuBar.add(mnQuanly);
		if(!nhanVien.getChuVu().equals("Quản lý")) {
			mnQuanly.setVisible(false);
		}

		JMenuItem itemQLNhanvien = new JMenuItem("Nhân viên");
		itemQLNhanvien.setIcon(new ImageIcon(UIVinaHome.class.getResource("/images/manager.png")));
		itemQLNhanvien.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		itemQLNhanvien.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				displayFormDSNhanvien();
			}
		});
		mnQuanly.add(itemQLNhanvien);

		itemKhachhang = new JMenuItem("Khách Hàng");
		itemKhachhang.setIcon(new ImageIcon(UIVinaHome.class.getResource("/images/kissclipart-customer.png")));
		itemKhachhang.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		mnQuanly.add(itemKhachhang);
		itemKhachhang.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				displayFormDSKhachHang();
			}
		});

		JMenuItem mnQLPhong = new JMenuItem("Phòng");
		mnQLPhong.setIcon(new ImageIcon(UIVinaHome.class.getResource("/images/room.png")));
		mnQLPhong.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		mnQuanly.add(mnQLPhong);
		mnQLPhong.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				displayFormDSPhong();
			}
		});


		JMenuItem mnDichvu = new JMenuItem("Dịch vụ");
		mnDichvu.setIcon(new ImageIcon(UIVinaHome.class.getResource("/images/dichvu.png")));
		mnDichvu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		mnQuanly.add(mnDichvu);
		mnDichvu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				displayFormDSDichvu();				
			}
		});


		JMenuItem QLHoadon = new JMenuItem("Đặt phòng");
		QLHoadon.setIcon(new ImageIcon(UIVinaHome.class.getResource("/images/booking.png")));
		QLHoadon.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		mnQuanly.add(QLHoadon);
		QLHoadon.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				displayFormDSDatPhong();
			}
		});

		JMenuItem itemThongke = new JMenuItem("Thống kê");
		itemThongke.setIcon(new ImageIcon(UIVinaHome.class.getResource("/images/char.png")));
		itemThongke.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		mnQuanly.add(itemThongke);
		itemThongke.addActionListener(new ActionListener() {	
			
			@Override
			public void actionPerformed(ActionEvent e) {
				displayFormThongke();
			}
		});

		JMenu mnCaidat = new JMenu("Cài đặt");
		mnCaidat.setIcon(new ImageIcon(UIVinaHome.class.getResource("/images/setting.png")));
		mnCaidat.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		menuBar.add(mnCaidat);

		JMenuItem itemDoiMatkhau = new JMenuItem("Đổi mật khẩu");
		itemDoiMatkhau.setIcon(new ImageIcon(UIVinaHome.class.getResource("/images/lock.png")));
		itemDoiMatkhau.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		mnCaidat.add(itemDoiMatkhau);
		itemDoiMatkhau.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			 	new DoiMKUI().setVisible(true);				
			}
		});

		JMenuItem itemlogout = new JMenuItem("Đăng xuất");
		itemlogout.setIcon(new ImageIcon(UIVinaHome.class.getResource("/images/logout.png")));
		itemlogout.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		mnCaidat.add(itemlogout);
		itemlogout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				logout();
			}
		});

		JMenu mnHelp = new JMenu("Trợ giúp");
		mnHelp.setIcon(new ImageIcon(UIVinaHome.class.getResource("/images/help.png")));
		mnHelp.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		menuBar.add(mnHelp);
		
		menuBar.add(Box.createHorizontalGlue());
		
		String tenNV = nhanVien.getTenNV();
		JMenu mnNhanVien = new JMenu(tenNV);
		mnNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		mnNhanVien.setIcon(new ImageIcon(UIVinaHome.class.getResource("/images/office_worker.png")));
		mnNhanVien.setHorizontalTextPosition(SwingConstants.LEADING);
		mnNhanVien.setHorizontalAlignment(SwingConstants.LEADING);
		menuBar.add(mnNhanVien);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));		
		setContentPane(contentPane);
		contentPane.setLayout(null);

		/*
		 * danh sách khách hàng
		 */
		panel_DSKhachHang = new JPanel();
		panel_DSKhachHang.setBackground(Color.WHITE);
		panel_DSKhachHang.setBounds(0, 49, 1920, 980);
		panel_DSKhachHang.setVisible(false);
		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder titleBorder = new TitledBorder(border, "Danh sách khách hàng");
		titleBorder.setTitleFont(new Font("Times New Roman", Font.BOLD, 26));
		titleBorder.setTitleColor(Color.RED);
		panel_DSKhachHang.setBorder(titleBorder);
		contentPane.add(panel_DSKhachHang);
		panel_DSKhachHang.setLayout(new BorderLayout(0, 0));
		
		//popup menu quản lý khách hàng
		JPopupMenu menuKH = new JPopupMenu();
		JMenuItem themKH = new JMenuItem("Thêm khách hàng");
		themKH.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		themKH.setIcon(new ImageIcon(UIVinaHome.class.getResource("/images/add_customer.png")));
		menuKH.add(themKH);
		themKH.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new UIKhachhang(null, "add").setVisible(true);				
			}
		});
		
		tableDSKhachhang = new JTable(dfmodelDSKH = new DefaultTableModel(titleKH, 0)) {
			public boolean isCellEditable(int row,int column) { //set non-Editable
				switch(column){
				default: return false; }}
		};
		JMenuItem suaKH = new JMenuItem("Sửa khách hàng");
		suaKH.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		suaKH.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String makh = dfmodelDSKH.getValueAt(tableDSKhachhang.getSelectedRow(), 0).toString();
				KhachHang khachHang = khachhangDAO.timKhachHang(makh);
				new UIKhachhang(khachHang, "edit").setVisible(true);				
			}
		});
		suaKH.setIcon(new ImageIcon(UIVinaHome.class.getResource("/images/edit_customer.png")));
		
		JMenuItem xoaKH = new JMenuItem("Xóa khách hàng");
		xoaKH.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		xoaKH.setIcon(new ImageIcon(UIVinaHome.class.getResource("/images/remove_customer.png")));
		xoaKH.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String makh = dfmodelDSKH.getValueAt(tableDSKhachhang.getSelectedRow(), 0).toString();
				KhachHang khachHang = khachhangDAO.timKhachHang(makh);
				new UIKhachhang(khachHang, "remove").setVisible(true);				
			}
		});
		
		if(nhanVien.getChuVu().equalsIgnoreCase("Quản lý")) {
			menuKH.add(suaKH);
			menuKH.add(xoaKH);
		}

		tableDSKhachhang.setAutoCreateRowSorter(true);
		sorterDSKH = new TableRowSorter<TableModel>(tableDSKhachhang.getModel()); // Sorting and Filtering
		tableDSKhachhang.setRowSorter(sorterDSKH);
		
		tableDSKhachhang.setBackground(Color.WHITE);
		tableDSKhachhang.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		setJTableColumnsWidth(tableDSKhachhang, 140, 370, 160, 160, 160, 160, 760);
		tableDSKhachhang.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableDSKhachhang.setRowHeight(32);
		JScrollPane scrollPaneKH = new JScrollPane(tableDSKhachhang,
			ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
			ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		scrollPaneKH.getViewport().setBackground(Color.WHITE);
		panel_DSKhachHang.add(scrollPaneKH);
		contentPane.add(panel_Dichvu);
		panel_Dichvu.setLayout(new BorderLayout(0, 0));
		scrollPaneKH.getViewport().addMouseListener(new MouseAdapter () {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if(tableDSKhachhang.getSelectedRow() < 0) {
					suaKH.setEnabled(false);
					xoaKH.setEnabled(false);
				}else {
					suaKH.setEnabled(true);
					xoaKH.setEnabled(true);
				}
				if(e.getButton()==MouseEvent.BUTTON3)
					menuKH.show(e.getComponent(),e.getX(),e.getY());
			}
		});
		tableDSKhachhang.addMouseListener(new MouseAdapter () {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if(tableDSKhachhang.getSelectedRow() < 0) {
					suaKH.setEnabled(false);
					xoaKH.setEnabled(false);
				}else {
					suaKH.setEnabled(true);
					xoaKH.setEnabled(true);
				}
				if(e.getButton()==MouseEvent.BUTTON3)
					menuKH.show(e.getComponent(),e.getX(),e.getY());
			}
		});
		panel_DSKhachHang.addMouseListener(new MouseAdapter (){
			public void mouseReleased(MouseEvent e){
				if(tableDSKhachhang.getSelectedRow() < 0) {
					suaKH.setEnabled(false);
					xoaKH.setEnabled(false);
				}else {
					suaKH.setEnabled(true);
					xoaKH.setEnabled(true);
				}
				if(e.getButton()==MouseEvent.BUTTON3)
					menuKH.show(e.getComponent(),e.getX(),e.getY());
			}
		});
		
		/*
		 * danh sách dịch vụ
		 */
		border = BorderFactory.createLineBorder(Color.RED);
		titleBorder = new TitledBorder(border, "Danh sách dịch vụ");
		titleBorder.setTitleFont(new Font("Times New Roman", Font.BOLD, 26));
		titleBorder.setTitleColor(Color.RED);
		panel_Dichvu.setBorder(titleBorder);
		panel_Dichvu.setBackground(Color.WHITE);
		panel_Dichvu.setBounds(0, 49, 1920, 610);
		panel_Dichvu.setVisible(false);

		/*
		 * Chi tiết dịch vụ
		 */
		panel_ChitietDV = new JPanel();
		panel_ChitietDV.setBackground(Color.WHITE);
		panel_ChitietDV.setBounds(0, 654, 1920, 373);
		titleBorder = new TitledBorder(border, "Chi tiết dịch vụ");
		titleBorder.setTitleFont(new Font("Times New Roman",  Font.ITALIC, 22));
		titleBorder.setTitleColor(Color.RED);
		panel_ChitietDV.setBorder(titleBorder);
		panel_ChitietDV.setVisible(false);

		contentPane.add(panel_ChitietDV);
		panel_ChitietDV.setLayout(new BorderLayout(0, 0));

		table_ChitietHoadon = new JTable(dfmodelCTHD = new DefaultTableModel(titleCTHD, 0)) {
			public boolean isCellEditable(int row,int column) { //set non-Editable
				switch(column){
				default: return false; }}
			@Override
	         public Class<?> getColumnClass(int columnIndex) {
	           Class<?> clazz = String.class;
	           switch (columnIndex) {
	             case 3:
	             case 4:
	             case 5:
	               clazz = Integer.class;
	               break;
	           }
	           return clazz;
	         }
		};
		
		table_ChitietHoadon.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		table_ChitietHoadon.setBackground(Color.WHITE);
		JScrollPane scrollPaneCTHD = new JScrollPane(table_ChitietHoadon);
		setJTableColumnsWidth(table_ChitietHoadon, 80, 360, 350, 360, 360, 400);
		table_ChitietHoadon.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table_ChitietHoadon.setRowHeight(32);
		scrollPaneCTHD = new JScrollPane(table_ChitietHoadon,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneCTHD.getViewport().setBackground(Color.WHITE);
		panel_ChitietDV.add(scrollPaneCTHD, BorderLayout.CENTER);

		JPanel Chitiet = new JPanel();
		panel_ChitietDV.add(Chitiet, BorderLayout.SOUTH);
		Chitiet.setBackground(Color.WHITE);
		Chitiet.setLayout(new BorderLayout(0, 0));

		JPanel layout = new JPanel();
		layout.setBackground(Color.WHITE);
		Chitiet.add(layout, BorderLayout.EAST);
		layout.setLayout(new GridLayout(1, 2, 6, 6));

		JLabel label = new JLabel("Tổng (Total): ");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("Times New Roman", Font.BOLD, 22));
		layout.add(label);

		lbtotal = new JLabel(format.format(0));
		lbtotal.setHorizontalAlignment(SwingConstants.LEFT);
		lbtotal.setFont(new Font("Times New Roman", Font.BOLD, 22));
		layout.add(lbtotal);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		Chitiet.add(panel, BorderLayout.WEST);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		btLaphoadon = new JButton("Lập hóa đơn");
		btLaphoadon.setIcon(new ImageIcon(UIVinaHome.class.getResource("/images/bill.png")));
		btLaphoadon.setFont(new Font("Times New Roman", Font.BOLD, 26));
		btLaphoadon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UIPhieuDichvu().setVisible(true);
			}
		});
		btLaphoadon.setEnabled(false);
		panel.add(btLaphoadon);
		
		/*
		 * Danh sách nhân viên 
		 */
		panel_DSNhanVien = new JPanel();
		panel_DSNhanVien.setBackground(Color.WHITE);
		panel_DSNhanVien.setBounds(0, 49, 1920, 980);
		panel_DSNhanVien.setVisible(false);
		border = BorderFactory.createLineBorder(Color.RED);
		titleBorder = new TitledBorder(border, "Danh sách nhân viên");
		titleBorder.setTitleFont(new Font("Times New Roman", Font.BOLD, 26));
		titleBorder.setTitleColor(Color.RED);
		panel_DSNhanVien.setBorder(titleBorder);
		contentPane.add(panel_DSNhanVien);
		panel_DSNhanVien.setLayout(new BorderLayout(0, 0));
		
		tableDSNhanvien = new JTable(dfmodelDSNV = new DefaultTableModel(titleNV, 0)) {
			public boolean isCellEditable(int row,int column) { //set non-Editable
				switch(column){
				default: return false; }}
		};
		tableDSNhanvien.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		setJTableColumnsWidth(tableDSNhanvien, 80, 260, 150, 200 , 280, 150, 150, 150, 500);
		tableDSNhanvien.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableDSNhanvien.setRowHeight(32);
		JScrollPane scrollPaneDSNV = new JScrollPane(tableDSNhanvien,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneDSNV.getViewport().setBackground(Color.WHITE);
		panel_DSNhanVien.add(scrollPaneDSNV, BorderLayout.CENTER);
		
		tableDSNhanvien.setAutoCreateRowSorter(true);
		sorterDSNV = new TableRowSorter<TableModel>(tableDSNhanvien.getModel()); // Sorting and Filtering
		tableDSNhanvien.setRowSorter(sorterDSNV);
		
		//popup menu quản lý nhân viên
		JPopupMenu menuNV = new JPopupMenu();
		JMenuItem themNV = new JMenuItem("Thêm nhân viên");
		themNV.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		themNV.setIcon(new ImageIcon(UIVinaHome.class.getResource("/images/add_customer.png")));
		menuNV.add(themNV);
		themNV.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new UINhanvien(null, "add").setVisible(true);		
			}
		});
		
		JMenuItem suaNV = new JMenuItem("Sửa Nhân viên");
		suaNV.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		suaNV.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String maNV = dfmodelDSNV.getValueAt(tableDSNhanvien.getSelectedRow(), 0).toString();
				NhanVien nv = nhanVienDAO.timNhanvien(maNV);
				new UINhanvien(nv, "edit").setVisible(true);				
			}
		});
		suaNV.setIcon(new ImageIcon(UIVinaHome.class.getResource("/images/edit_customer.png")));
		menuNV.add(suaNV);
		
		JMenuItem xoaNV = new JMenuItem("Xóa nhân viên");
		xoaNV.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		xoaNV.setIcon(new ImageIcon(UIVinaHome.class.getResource("/images/remove_customer.png")));
		xoaNV.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String maNV = dfmodelDSNV.getValueAt(tableDSNhanvien.getSelectedRow(), 0).toString();
				NhanVien nv = nhanVienDAO.timNhanvien(maNV);
				new UINhanvien(nv, "remove").setVisible(true);					
			}
		});
		menuNV.add(xoaNV);
		
		tableDSNhanvien.addMouseListener(new MouseAdapter (){
			
			public void mouseReleased(MouseEvent e){
				if(tableDSNhanvien.getSelectedRow() < 0) {
					suaNV.setEnabled(false);
					xoaNV.setEnabled(false);
				}else {
					suaNV.setEnabled(true);
					xoaNV.setEnabled(true);
					if(nhanVien.equals(nhanVienDAO.timNhanvien(dfmodelDSNV.getValueAt(tableDSNhanvien.getSelectedRow(), 0).toString()))) {
						xoaNV.setEnabled(false);
					}
				}
				if(e.getButton()==MouseEvent.BUTTON3)
					menuNV.show(e.getComponent(),e.getX(),e.getY());
			}
		});
		panel_DSNhanVien.addMouseListener(new MouseAdapter () {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if(tableDSNhanvien.getSelectedRow() < 0) {
					suaNV.setEnabled(false);
					xoaNV.setEnabled(false);
				}else {
					suaNV.setEnabled(true);
					xoaNV.setEnabled(true);
					if(nhanVien.equals(nhanVienDAO.timNhanvien(dfmodelDSNV.getValueAt(tableDSNhanvien.getSelectedRow(), 0).toString()))) {
						xoaNV.setEnabled(false);
					}
				}
				if(e.getButton()==MouseEvent.BUTTON3)
					menuNV.show(e.getComponent(),e.getX(),e.getY());
			}
		});
		scrollPaneDSNV.getViewport().addMouseListener(new MouseAdapter () {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if(tableDSNhanvien.getSelectedRow() < 0) {
					suaNV.setEnabled(false);
					xoaNV.setEnabled(false);
				}else {
					suaNV.setEnabled(true);
					xoaNV.setEnabled(true);
					if(nhanVien.equals(nhanVienDAO.timNhanvien(dfmodelDSNV.getValueAt(tableDSNhanvien.getSelectedRow(), 0).toString()))) {
						xoaNV.setEnabled(false);
					}
				}
				if(e.getButton()==MouseEvent.BUTTON3)
					menuNV.show(e.getComponent(),e.getX(),e.getY());
			}
		});
		
		/*
		 * danh sách đặt phòng
		 */
		panel_DSHDatPhong = new JPanel();
		panel_DSHDatPhong.setBackground(Color.WHITE);
		panel_DSHDatPhong.setBounds(0, 49, 1920, 980);
		panel_DSHDatPhong.setVisible(false);
		border = BorderFactory.createLineBorder(Color.RED);
		titleBorder = new TitledBorder(border, "Danh sách đặt phòng");
		titleBorder.setTitleFont(new Font("Times New Roman", Font.BOLD, 26));
		titleBorder.setTitleColor(Color.RED);
		panel_DSHDatPhong.setBorder(titleBorder);
		contentPane.add(panel_DSHDatPhong);
		panel_DSHDatPhong.setLayout(new BorderLayout(0, 0));
		tableDSDatPhong = new JTable(dfmodelDSDP = new DefaultTableModel(titleDP, 0)) {
			public boolean isCellEditable(int row,int column) { //set non-Editable
				switch(column){
				default: return false; }}
		};
		tableDSDatPhong.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		setJTableColumnsWidth(tableDSDatPhong, 200, 350, 300, 400, 180, 250, 250);
		tableDSDatPhong.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableDSDatPhong.setRowHeight(32);
		JScrollPane scrollPaneDSDP = new JScrollPane(tableDSDatPhong,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneDSDP.getViewport().setBackground(Color.WHITE);
		panel_DSHDatPhong.add(scrollPaneDSDP, BorderLayout.CENTER);
		
		tableDSDatPhong.setAutoCreateRowSorter(true);
		sorterDSDP = new TableRowSorter<TableModel>(tableDSDatPhong.getModel()); // Sorting and Filtering
		tableDSDatPhong.setRowSorter(sorterDSDP);
		//popup menu quản lý đặt phòng
		JPopupMenu menuDP = new JPopupMenu();
		JMenuItem suaDP = new JMenuItem("Sửa đặt phòng");
		suaDP.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		suaDP.setIcon(new ImageIcon(UIVinaHome.class.getResource("/images/setting.png")));
		menuDP.add(suaDP);
		suaDP.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String maDP = dfmodelDSDP.getValueAt(tableDSDatPhong.getSelectedRow(), 0).toString();
				DatPhong datPhong = datPhongDAO.timDatPhong(maDP);
				new UIDatPhong(datPhong, "edit").setVisible(true);
			}
		});
		JMenuItem xoaDP = new JMenuItem("Hủy đặt phòng");
		xoaDP.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		xoaDP.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String maDP = dfmodelDSDP.getValueAt(tableDSDatPhong.getSelectedRow(), 0).toString();
				DatPhong datPhong = datPhongDAO.timDatPhong(maDP);
				new UIDatPhong(datPhong, "remove").setVisible(true);
			}
		});
		xoaDP.setIcon(new ImageIcon(UIVinaHome.class.getResource("/images/remove-service.png")));
		menuDP.add(xoaDP);
		tableDSDatPhong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getButton()==MouseEvent.BUTTON3)
					menuDP.show(e.getComponent(),e.getX(),e.getY());
			}
		});
		
		/*
		 * Thống kê
		 */
		//TODO
		panel_Thongke = new JPanel();
		panel_Thongke.setBackground(Color.WHITE);
		panel_Thongke.setBounds(0, 49, 1920, 980);
		panel_Thongke.setVisible(false);
		border = BorderFactory.createLineBorder(Color.RED);
		titleBorder = new TitledBorder(border, "Thống kê");
		titleBorder.setTitleFont(new Font("Times New Roman", Font.BOLD, 26));
		titleBorder.setTitleColor(Color.RED);
		panel_Thongke.setBorder(titleBorder);
		contentPane.add(panel_Thongke);
		panel_Thongke.setLayout(new BorderLayout(0, 0));
		
		/*
		 * Tìm kiếm
		 */
		tim.setBounds(822, 10, 330, 38);
		contentPane.add(tim);
		tim.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		tim.setToolTipText("Tìm kiếm");
		tim.setColumns(10);
		tim.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				timkiem();
			}
		});
		comboBox_Tim.setBounds(640, 10, 172, 38);
		contentPane.add(comboBox_Tim);
		comboBox_Tim.setForeground(new Color(0, 0, 0));
		comboBox_Tim.setModel(new DefaultComboBoxModel<String>(timphong));
		comboBox_Tim.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		JButton btnTm = new JButton();
		btnTm.setBounds(1162, 10, 51, 38);
		contentPane.add(btnTm);
		btnTm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timkiem();
			}
		});
		
		btnTm.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnTm.setIcon(new ImageIcon(UIVinaHome.class.getResource("/images/tim.png")));
		btnTm.setHorizontalAlignment(SwingConstants.LEFT);

		/*
		 * Hiện thị số phòng còn trống
		 */
		lblSPhng.setBounds(10, 15, 196, 29);
		contentPane.add(lblSPhng);
		lblSPhng.setForeground(Color.BLACK);
		lblSPhng.setFont(new Font("Times New Roman", Font.BOLD, 22));
		label_soPhong.setBounds(196, 15, 41, 29);
		contentPane.add(label_soPhong);

		label_soPhong.setForeground(Color.BLACK);
		label_soPhong.setFont(new Font("Times New Roman", Font.BOLD, 22));
		time.setBounds(1676, 0, 122, 54);
		contentPane.add(time);

		/*
		 * Hiện thị giờ
		 */
		time.setForeground(new Color(0, 0, 255));
		time.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		dateweek.setBounds(1790, 0, 122, 29);
		contentPane.add(dateweek);

		dateweek.setForeground(new Color(0, 0, 255));
		dateweek.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		date.setBounds(1790, 25, 122, 29);
		contentPane.add(date);

		date.setForeground(new Color(0, 0, 255));
		date.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		
		/*
		 * Cập nhật hiện thị
		 */
		tim.requestFocus();
		clock();
		xuatDSPhong();
		displayDSdichvu();
		updateTableKhachHang();
		updateTableNhanvien();
		updateTableDatPhong();
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
			
			@Override
			public boolean dispatchKeyEvent(KeyEvent e) {
				switch (e.getID()) {
				  case KeyEvent.KEY_PRESSED:
                        if (e.getKeyCode() == KeyEvent.VK_F5) {
                        	tim.requestFocus();
                        	xuatDSPhong();
                    		displayDSdichvu();
                    		updateTableKhachHang();
                    		updateTableNhanvien();
                    		updateTableDatPhong();
                        }
                        break;
				}
				return false;
			}
		});
	}
	
	//Hiện thị, cập nhật danh sách phòng
	public void xuatDSPhong() {
		contentPane.remove(panel_DanhSachPhong);
		panel_DanhSachPhong = new JPanel();
		contentPane.add(panel_DanhSachPhong);
		this.invalidate();
		this.validate();
		this.revalidate();
		this.repaint();
        
		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder titleBorder = new TitledBorder(border, "Danh sách phòng");
		titleBorder.setTitleFont(new Font("Times New Roman", Font.BOLD, 26));
		titleBorder.setTitleColor(Color.RED);
		panel_DanhSachPhong.setBorder(titleBorder);
		panel_DanhSachPhong.setBackground(Color.WHITE);
		panel_DanhSachPhong.setBounds(0, 49, 1920, 980);
		

		List<Phong> dsphongs = phongDAO.getDSPhong();
		int soPhong = dsphongs.size(), index = 0;

		JPanel DsPhong = new JPanel();
		DsPhong.setBackground(Color.WHITE);
		DsPhong.setBounds(28, 39, 1309, 848);
		DsPhong.setLayout(new GridLayout(0, 5, 60, 60));
		phongs = new JButton[soPhong];
		
		for (Phong phong : dsphongs) {
			phongs[index] = new JButton();
			JPanel panel_phong = new JPanel();
			DsPhong.add(panel_phong);
			panel_phong.setLayout(new BorderLayout(0, 0));
			panel_phong.setBackground(Color.WHITE);
			String info_phong = "<html><center> Phòng " + phong.getSoPhong() + " - " +
					phong.getLoaiPhong().getTenLoaiphong() + "<br>" + 
					phong.getTinhtrangPhong() + "</center></html>";
			JLabel jLabel_sophong = new JLabel(info_phong, SwingConstants.CENTER);
			jLabel_sophong.setFont(new Font("Times New Roman", Font.BOLD, 22));
			panel_phong.add(jLabel_sophong, BorderLayout.NORTH);

			try {
				String resource = "/images/phong/";
				if(phong.getLoaiPhong().getMaLP().equals("PD"))
					resource += "phongdon.jpg";
				else if(phong.getLoaiPhong().getMaLP().equals("PDD"))
					resource += phong.getGiuong().getMaGiuong().equals("MG") ? "phongdoi.jpg" : "phongdoi2.PNG";
				else resource += "phongGD.jpg";
				Image img = ImageIO.read(getClass().getResource(resource));
				phongs[index].setIcon(new ImageIcon(img));
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			phongs[index].setPreferredSize(new Dimension(200, 220));
			phongs[index].setOpaque(true);
			//TODO
//			String details = "<html><img src=\"" + new ImageIcon(UIVinaHome.class.getResource("/images/booking.png")) + "\">";
//			phongs[index].setToolTipText(details);
//			phongs[index].getToolkit();
			
			JPopupMenu menuPhong = new JPopupMenu();
				JMenuItem datPhong = new JMenuItem("Đặt phòng ");
				datPhong.setFont(new Font("Times New Roman", Font.PLAIN, 22));
				datPhong.setIcon(new ImageIcon(UIVinaHome.class.getResource("/images/booking.png")));
				menuPhong.add(datPhong);
				datPhong.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						DatPhong datPhong = new DatPhong();
						List<Phong> phongs = new ArrayList<Phong>();
						phongs.add(phong);
						datPhong.setPhong(phongs);
						new UIDatPhong(datPhong, "add").setVisible(true);
					}
				});
				JMenuItem doiPhong = new JMenuItem("Đổi phòng");
				doiPhong.setFont(new Font("Times New Roman", Font.PLAIN, 22));
				doiPhong.setIcon(new ImageIcon(UIVinaHome.class.getResource("/images/swap.png")));
				menuPhong.add(doiPhong);
				if(!phong.getTinhtrangPhong().equalsIgnoreCase("Đang thuê"))
					doiPhong.setEnabled(false);
				doiPhong.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						new UIDoiPhong(phong).setVisible(true);						
					}
				});
				JMenuItem traPhong = new JMenuItem("Trả phòng");
				traPhong.setFont(new Font("Times New Roman", Font.PLAIN, 22));
				traPhong.setIcon(new ImageIcon(UIVinaHome.class.getResource("/images/checkout.png")));
			menuPhong.add(traPhong);
			if(nhanVien.getChuVu().equalsIgnoreCase("Quản lý")) {
				JMenu mnQLPhong = new JMenu("Phòng");
					mnQLPhong.setFont(new Font("Times New Roman", Font.PLAIN, 22));
					JMenuItem itemSuaphong = new JMenuItem("Sửa phòng");
					itemSuaphong.setFont(new Font("Times New Roman", Font.PLAIN, 22));
					itemSuaphong.setIcon(new ImageIcon(UIVinaHome.class.getResource("/images/edit_room.png")));
					mnQLPhong.add(itemSuaphong);
					itemSuaphong.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							new UIQLPhong(phong, "edit").setVisible(true);             							
						}
					});
					JMenuItem itemThemPhong = new JMenuItem("Thêm phòng");
					itemThemPhong.setFont(new Font("Times New Roman", Font.PLAIN, 22));
					itemThemPhong.setIcon(new ImageIcon(UIVinaHome.class.getResource("/images/add_room.png")));
					mnQLPhong.add(itemThemPhong);
					itemThemPhong.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							new UIQLPhong(null, "add").setVisible(true);             							
						}
					});
					JMenuItem ItemXoaPhong = new JMenuItem("Xóa Phòng");
					ItemXoaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 22));
					ItemXoaPhong.setIcon(new ImageIcon(UIVinaHome.class.getResource("/images/remove_room.png")));
					mnQLPhong.add(ItemXoaPhong);
					ItemXoaPhong.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							new UIQLPhong(phong, "remove").setVisible(true);             							
						}
					});
				menuPhong.add(mnQLPhong);
			}
				
			phongs[index].addMouseListener(new MouseAdapter () {
				@Override
				public void mouseClicked(MouseEvent e) {
					menuPhong.show(e.getComponent(),e.getX(),e.getY());
				}
			});
			panel_phong.add(phongs[index++]);
		}
		panel_DanhSachPhong.setLayout(new BoxLayout(panel_DanhSachPhong, BoxLayout.X_AXIS));
		JScrollPane scrollPane = new JScrollPane(DsPhong);

		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		panel_DanhSachPhong.add(scrollPane);
		updateSophongtrong();
	}
	
	public class UIDoiPhong extends JDialog {
		
		private JCheckBox[] ckbPhong1;
		private JCheckBox[] ckbPhong2;
		private String[] loaithue = new String[] {"Theo giờ", "Qua đêm", "Theo ngày"};
		private DefaultComboBoxModel<String> dfloaithue1 = new DefaultComboBoxModel<String>(loaithue);
		private JComboBox<String> cb_loaiThue1 = new JComboBox<String>(dfloaithue1);
		private DefaultComboBoxModel<String> dfloaithue2 = new DefaultComboBoxModel<String>(loaithue);
		private JComboBox<String> cb_loaiThue2 = new JComboBox<String>(dfloaithue2);
		private String[] gio = new String[] {"12:00 am", "12:00 pm"};
		private DefaultComboBoxModel<String> dfgionhan1 = new DefaultComboBoxModel<String>(gio);
		private DefaultComboBoxModel<String> dfgionhan2 = new DefaultComboBoxModel<String>(gio);
		private JComboBox<String> cbGionhan1 = new JComboBox<String>(dfgionhan1);
		private JComboBox<String> cbGionhan2 = new JComboBox<String>(dfgionhan2);
		private JDateChooser dateChooser_nhan1 = new JDateChooser();
		private JDateChooser dateChooser_nhan2 = new JDateChooser();
		private JDateChooser ngaysinh1 = new JDateChooser();
		private JDateChooser ngaysinh2 = new JDateChooser();
		private String[] loaiKH = new String[] {"Vãn lai", "Thường", "VIP"};
		private DefaultComboBoxModel<String> dfLoaiKH1 = new DefaultComboBoxModel<String>(loaiKH);
		private JComboBox<String> cb_LoaiKH1 = new JComboBox<String>(dfLoaiKH1);
		private DefaultComboBoxModel<String> dfLoaiKH2 = new DefaultComboBoxModel<String>(loaiKH);
		private JComboBox<String> cb_LoaiKH2 = new JComboBox<String>(dfLoaiKH2);
		private JLabel hoten1 = new JLabel();
		private JLabel soDT1 = new JLabel();
		private JLabel soCMND1 = new JLabel();
		private JLabel diaChi1 = new JLabel();
		private JLabel hoten2 = new JLabel();
		private JLabel soDT2 = new JLabel();
		private JLabel soCMND2 = new JLabel();
		private JLabel diaChi2 = new JLabel();
		
		public UIDoiPhong(Phong phong) {
			super(new JFrame(),"Đặt phòng",true);
			getContentPane().setBackground(Color.WHITE);
			setBounds(0, 0, 850, 665);
			setLocationRelativeTo(null);
			getContentPane().setLayout(null);
			KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {

				@Override
				public boolean dispatchKeyEvent(KeyEvent e) {
					switch (e.getID()) {
					case KeyEvent.KEY_PRESSED:
						if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
							dispose();
						}
						break;
					}
					return false;
				}
			});
			
			dateChooser_nhan1.setDateFormatString("dd/MM/yyyy");
			dateChooser_nhan2.setDateFormatString("dd/MM/yyyy");
			dateChooser_nhan1.getSpinner().setEnabled(false);
			dateChooser_nhan2.getSpinner().setEnabled(false);
			cb_loaiThue1.setEnabled(false);
			cb_loaiThue2.setEnabled(false);
			cbGionhan1.setEnabled(false);
			cbGionhan2.setEnabled(false);
			ngaysinh1.getSpinner().setEnabled(false);
			ngaysinh2.getSpinner().setEnabled(false);
			cb_LoaiKH1.setEnabled(false);
			cb_LoaiKH2.setEnabled(false);
			
			JPanel panel_Phong1 = new JPanel();
			panel_Phong1.setLayout(new BorderLayout(0, 0));
			panel_Phong1.setBackground(Color.WHITE);
			panel_Phong1.setBounds(0, 0, 390, 210);
			Border border = BorderFactory.createLineBorder(Color.RED);
			TitledBorder titleBorder = new TitledBorder(border, "Phòng");
			titleBorder.setTitleFont(new Font("Times New Roman", Font.BOLD, 16));
			titleBorder.setTitleColor(Color.RED);
			panel_Phong1.setBorder(titleBorder);
			
			JPanel panel_Phongs = new JPanel();
			panel_Phongs.setBackground(Color.WHITE);
			panel_Phongs.setLayout(new GridLayout(0, 5, 5, 10));
			ckbPhong1 = new JCheckBox[phongDAO.getDSPhong().size()];
			int index = 0;
			//TODO
			for (Phong ps : phongDAO.getDSPhong()) {
				ckbPhong1[index] = new JCheckBox(ps.getMaPhong());
				ckbPhong1[index].setFont(new Font("Times New Roman", Font.PLAIN, 16));
				ckbPhong1[index].setBackground(Color.WHITE);
				if(ps.equals(phong))
					ckbPhong1[index].setSelected(true);
				if(!ps.getTinhtrangPhong().equalsIgnoreCase("Đang thuê"))
					ckbPhong1[index].setEnabled(false);
				final int temp = index;
				ckbPhong1[index].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						for (int i = 0; i < phongDAO.getDSPhong().size(); i++)
							ckbPhong1[i].setSelected(false);
						ckbPhong1[temp].setSelected(true);
						updateInfo();
					}
				});
				panel_Phongs.add(ckbPhong1[index++]);
			}
			JScrollPane scrollPaneDP = new JScrollPane(panel_Phongs,
					ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
					ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPaneDP.getViewport().setBackground(Color.WHITE);
			panel_Phong1.add(scrollPaneDP);
			getContentPane().add(panel_Phong1);
			
			JPanel panel_ThongTinDP = new JPanel();
			panel_ThongTinDP.setBackground(Color.WHITE);
			panel_ThongTinDP.setBounds(0, 215, 390, 155);
			border = BorderFactory.createLineBorder(Color.RED);
			titleBorder = new TitledBorder(border, "Thông tin đặt phòng");
			titleBorder.setTitleFont(new Font("Times New Roman", Font.BOLD, 16));
			titleBorder.setTitleColor(Color.RED);
			panel_ThongTinDP.setBorder(titleBorder);
			getContentPane().add(panel_ThongTinDP);
			panel_ThongTinDP.setLayout(null);
			
			JLabel label = new JLabel("Hình thức thuê:");
			label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			label.setBounds(10, 25, 134, 21);
			panel_ThongTinDP.add(label);
			
			cb_loaiThue1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			cb_loaiThue1.setBounds(154, 24, 110, 22);
			panel_ThongTinDP.add(cb_loaiThue1);
			
			label = new JLabel("Ngày nhận:");
			label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			label.setBounds(10, 75, 100, 21);
			panel_ThongTinDP.add(label);
			
			dateChooser_nhan1.getSpinner().setFont(new Font("Times New Roman", Font.PLAIN, 20));
			dateChooser_nhan1.setBounds(126, 75, 228, 20);
			panel_ThongTinDP.add(dateChooser_nhan1);
			
			label = new JLabel("Giờ nhận:");
			label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			label.setBounds(10, 125, 90, 21);
			panel_ThongTinDP.add(label);
			
			cbGionhan1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			cbGionhan1.setBounds(126, 125, 110, 20);
			panel_ThongTinDP.add(cbGionhan1);
			

			JPanel panel_thongtinKH = new JPanel();
			panel_thongtinKH.setBackground(Color.WHITE);
			panel_thongtinKH.setBounds(0, 371, 390, 264);
			border = BorderFactory.createLineBorder(Color.RED);
			titleBorder = new TitledBorder(border, "Khách hàng");
			titleBorder.setTitleFont(new Font("Times New Roman", Font.BOLD, 16));
			titleBorder.setTitleColor(Color.RED);
			panel_thongtinKH.setBorder(titleBorder);
			getContentPane().add(panel_thongtinKH);
			panel_thongtinKH.setLayout(null);
			
			label = new JLabel("Họ tên:");
			label.setFont(new Font("Times New Roman", Font.BOLD, 18));
			label.setBounds(10, 25, 58, 21);
			panel_thongtinKH.add(label);

			label = new JLabel("Số ĐT:");
			label.setFont(new Font("Times New Roman", Font.BOLD,18));
			label.setBounds(10, 65, 58, 21);
			panel_thongtinKH.add(label);

			label = new JLabel("Số CMND:");
			label.setFont(new Font("Times New Roman", Font.BOLD,18));
			label.setBounds(10, 105, 86, 21);
			panel_thongtinKH.add(label);

			label = new JLabel("Ngày sinh:");
			label.setFont(new Font("Times New Roman", Font.BOLD, 18));
			label.setBounds(10, 145, 83, 21);
			panel_thongtinKH.add(label);
			titleBorder = new TitledBorder(border, "Địa chỉ");
			titleBorder.setTitleFont(new Font("Times New Roman", Font.ITALIC, 16));
			titleBorder.setTitleColor(Color.RED);

			label = new JLabel("Loại KH:");
			label.setFont(new Font("Times New Roman", Font.BOLD, 18));
			label.setBounds(10, 185, 74, 21);
			panel_thongtinKH.add(label);
			
			ngaysinh1.getSpinner().setFont(new Font("Times New Roman", Font.BOLD, 18));
			ngaysinh1.setDateFormatString("dd/MM/yyyy");
			ngaysinh1.setBounds(106, 140, 205, 25);
			panel_thongtinKH.add(ngaysinh1);

			cb_LoaiKH1.setFont(new Font("Times New Roman", Font.BOLD, 18));
			cb_LoaiKH1.setBounds(106, 180, 95, 27);
			panel_thongtinKH.add(cb_LoaiKH1);
			
			label = new JLabel("Địa chỉ");
			label.setFont(new Font("Times New Roman", Font.BOLD, 18));
			label.setBounds(10, 225, 74, 21);
			panel_thongtinKH.add(label);
			
			hoten1.setFont(new Font("Times New Roman", Font.BOLD, 18));
			hoten1.setBounds(106, 25, 222, 21);
			panel_thongtinKH.add(hoten1);
			
			soDT1.setFont(new Font("Times New Roman", Font.BOLD, 18));
			soDT1.setBounds(106, 65, 222, 21);
			panel_thongtinKH.add(soDT1);
			
			soCMND1.setFont(new Font("Times New Roman", Font.BOLD, 18));
			soCMND1.setBounds(106, 105, 222, 21);
			panel_thongtinKH.add(soCMND1);
			
			diaChi1.setFont(new Font("Times New Roman", Font.BOLD, 18));
			diaChi1.setBounds(106, 225, 222, 21);
			panel_thongtinKH.add(diaChi1);
			
			JPanel panel_Phong2 = new JPanel();
			panel_Phong2.setBackground(Color.WHITE);
			panel_Phong2.setBounds(450, 0, 390, 210);
			getContentPane().add(panel_Phong2);
			panel_Phong2.setLayout(new BorderLayout(0, 0));
			border = BorderFactory.createLineBorder(Color.RED);
			titleBorder = new TitledBorder(border, "Phòng");
			titleBorder.setTitleFont(new Font("Times New Roman", Font.BOLD, 16));
			titleBorder.setTitleColor(Color.RED);
			panel_Phong2.setBorder(titleBorder);
			
			JPanel panel_Phongs2 = new JPanel();
			panel_Phongs2.setBackground(Color.WHITE);
			panel_Phongs2.setLayout(new GridLayout(0, 5, 5, 10));
			ckbPhong2 = new JCheckBox[phongDAO.getDSPhong().size()];
			index = 0;
			for(Phong ps : phongDAO.getDSPhong()) {
				ckbPhong2[index] = new JCheckBox(ps.getMaPhong());
				ckbPhong2[index].setFont(new Font("Times New Roman", Font.PLAIN, 16));
				ckbPhong2[index].setBackground(Color.WHITE);
				if(ps.equals(phong))
					ckbPhong2[index].setEnabled(false);
				if(!ps.getTinhtrangPhong().equalsIgnoreCase("Đang thuê"))
					ckbPhong2[index].setEnabled(false);
				final int temp = index;
				ckbPhong2[index].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						for (int i = 0; i < phongDAO.getDSPhong().size(); i++)
							ckbPhong2[i].setSelected(false);
						ckbPhong2[temp].setSelected(true);
						updateInfo();
					}
				});
				panel_Phongs2.add(ckbPhong2[index++]);
			}
			JScrollPane scrollPaneDP2 = new JScrollPane(panel_Phongs2,
					ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
					ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPaneDP2.getViewport().setBackground(Color.WHITE);
			panel_Phong2.add(scrollPaneDP2);
			getContentPane().add(panel_Phong2);
			
			JButton btbswap = new JButton();
			btbswap.setIcon(new ImageIcon(UIDoiPhong.class.getResource("/images/swap_06.png")));
			btbswap.setBounds(397, 300, 45, 45);
			getContentPane().add(btbswap);
			
			JPanel panel_ThongTinDP2 = new JPanel();
			panel_ThongTinDP2.setBackground(Color.WHITE);
			panel_ThongTinDP2.setBounds(450, 215, 390, 155);
			border = BorderFactory.createLineBorder(Color.RED);
			titleBorder = new TitledBorder(border, "Thông tin đặt phòng");
			titleBorder.setTitleFont(new Font("Times New Roman", Font.BOLD, 16));
			titleBorder.setTitleColor(Color.RED);
			panel_ThongTinDP2.setBorder(titleBorder);
			getContentPane().add(panel_ThongTinDP2);
			panel_ThongTinDP2.setLayout(null);
			
			label = new JLabel("Hình thức thuê:");
			label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			label.setBounds(10, 25, 134, 21);
			panel_ThongTinDP2.add(label);
			
			cb_loaiThue2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			cb_loaiThue2.setBounds(154, 24, 110, 22);
			panel_ThongTinDP2.add(cb_loaiThue2);
			
			label = new JLabel("Ngày nhận:");
			label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			label.setBounds(10, 75, 100, 21);
			panel_ThongTinDP2.add(label);
			
			dateChooser_nhan2.getSpinner().setFont(new Font("Times New Roman", Font.PLAIN, 20));
			dateChooser_nhan2.setBounds(126, 75, 228, 20);
			panel_ThongTinDP2.add(dateChooser_nhan2);
			
			label = new JLabel("Giờ nhận:");
			label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			label.setBounds(10, 125, 90, 21);
			panel_ThongTinDP2.add(label);
			
			cbGionhan2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			cbGionhan2.setBounds(126, 125, 110, 20);
			panel_ThongTinDP2.add(cbGionhan2);
			
			JPanel panel_thongtinKH2 = new JPanel();
			panel_thongtinKH2.setBackground(Color.WHITE);
			panel_thongtinKH2.setBounds(450, 371, 390, 264);
			border = BorderFactory.createLineBorder(Color.RED);
			titleBorder = new TitledBorder(border, "Khách hàng");
			titleBorder.setTitleFont(new Font("Times New Roman", Font.BOLD, 16));
			titleBorder.setTitleColor(Color.RED);
			panel_thongtinKH2.setBorder(titleBorder);
			getContentPane().add(panel_thongtinKH2);
			panel_thongtinKH2.setLayout(null);
			
			label = new JLabel("Họ tên:");
			label.setFont(new Font("Times New Roman", Font.BOLD, 18));
			label.setBounds(10, 25, 58, 21);
			panel_thongtinKH2.add(label);

			label = new JLabel("Số ĐT:");
			label.setFont(new Font("Times New Roman", Font.BOLD,18));
			label.setBounds(10, 65, 58, 21);
			panel_thongtinKH2.add(label);

			label = new JLabel("Số CMND:");
			label.setFont(new Font("Times New Roman", Font.BOLD,18));
			label.setBounds(10, 105, 86, 21);
			panel_thongtinKH2.add(label);

			label = new JLabel("Ngày sinh:");
			label.setFont(new Font("Times New Roman", Font.BOLD, 18));
			label.setBounds(10, 145, 83, 21);
			panel_thongtinKH2.add(label);
			
			titleBorder = new TitledBorder(border, "Địa chỉ");
			titleBorder.setTitleFont(new Font("Times New Roman", Font.ITALIC, 16));
			titleBorder.setTitleColor(Color.RED);

			label = new JLabel("Loại KH:");
			label.setFont(new Font("Times New Roman", Font.BOLD, 18));
			label.setBounds(10, 185, 74, 21);
			panel_thongtinKH2.add(label);
			
			ngaysinh2.setBounds(106, 140, 205, 25);
			ngaysinh2.getSpinner().setFont(new Font("Times New Roman", Font.BOLD, 18));
			ngaysinh2.setDateFormatString("dd/MM/yyyy");
			panel_thongtinKH2.add(ngaysinh2);

			cb_LoaiKH2.setFont(new Font("Times New Roman", Font.BOLD, 18));
			cb_LoaiKH2.setBounds(106, 180, 95, 27);
			panel_thongtinKH2.add(cb_LoaiKH2);
			
			label = new JLabel("Địa chỉ");
			label.setFont(new Font("Times New Roman", Font.BOLD, 18));
			label.setBounds(10, 225, 74, 21);
			panel_thongtinKH2.add(label);
			
			hoten2.setFont(new Font("Times New Roman", Font.BOLD, 18));
			hoten2.setBounds(106, 25, 222, 21);
			panel_thongtinKH2.add(hoten2);
			
			soDT2.setFont(new Font("Times New Roman", Font.BOLD, 18));
			soDT2.setBounds(106, 65, 222, 21);
			panel_thongtinKH2.add(soDT2);
			
			soCMND2.setFont(new Font("Times New Roman", Font.BOLD, 18));
			soCMND2.setBounds(106, 105, 222, 21);
			panel_thongtinKH2.add(soCMND2);
			
			diaChi2.setFont(new Font("Times New Roman", Font.BOLD, 18));
			diaChi2.setBounds(106, 225, 222, 21);
			panel_thongtinKH2.add(diaChi2);
			
			updateInfo();
		}
		public void updateInfo() {
			 DatPhong datPhongA = null;
			 DatPhong datPhongB = null;
			 Phong phongA = null;
			 Phong phongB = null;
			 List<Phong> phongs = phongDAO.getDSPhong();
			 for(int i = 0; i < phongs.size(); i++) {
				 if(ckbPhong1[i].isSelected())
					 phongA = phongs.get(i);
				 if(ckbPhong2[i].isSelected())
					 phongB = phongs.get(i);
				 
			 }
			for (DatPhong datPhong : datPhongDAO.getDSDatPhong()) {
				if(datPhong.getPhong().contains(phongA))
					datPhongA = datPhong;
				if(datPhong.getPhong().contains(phongB))
					datPhongB = datPhong;
			}
			if(datPhongA != null) {
				hoten1.setText(datPhongA.getKhachHang().getTenKH());
				soDT1.setText(datPhongA.getKhachHang().getSoDT());
				soCMND1.setText(datPhongA.getKhachHang().getSoCMD());
				diaChi1.setText((datPhongA.getKhachHang().getDiaChi().getTinh().equals("TP HCM") || 
						datPhongA.getKhachHang().getDiaChi().getTinh().equals("Hà Nội")) ?
						String.format("%s %s, P.%s, Q.%s, %s", 
								datPhongA.getKhachHang().getDiaChi().getSoNha(),
								datPhongA.getKhachHang().getDiaChi().getDuong(),
								datPhongA.getKhachHang().getDiaChi().getPhuong(), 
								datPhongA.getKhachHang().getDiaChi().getQuan(),
								datPhongA.getKhachHang().getDiaChi().getTinh()) :
						String.format("%s %s, P.%s, TP.%s, T.%s", 
								datPhongA.getKhachHang().getDiaChi().getSoNha(), 
								datPhongA.getKhachHang().getDiaChi().getDuong(),
								datPhongA.getKhachHang().getDiaChi().getPhuong(), 
								datPhongA.getKhachHang().getDiaChi().getQuan(), 
								datPhongA.getKhachHang().getDiaChi().getTinh()));
				ngaysinh1.setDate(java.sql.Date.valueOf(datPhongA.getKhachHang().getNgaySinh()));
				cb_LoaiKH1.setSelectedItem(datPhongA.getKhachHang().getLoaiKH());
			}
			if(datPhongB != null) {
				hoten2.setText(datPhongB.getKhachHang().getTenKH());
				soDT2.setText(datPhongB.getKhachHang().getSoDT());
				soCMND2.setText(datPhongB.getKhachHang().getSoCMD());
				diaChi2.setText((datPhongB.getKhachHang().getDiaChi().getTinh().equals("TP HCM") || 
						datPhongB.getKhachHang().getDiaChi().getTinh().equals("Hà Nội")) ?
						String.format("%s %s, P.%s, Q.%s, %s", 
								datPhongB.getKhachHang().getDiaChi().getSoNha(),
								datPhongB.getKhachHang().getDiaChi().getDuong(),
								datPhongB.getKhachHang().getDiaChi().getPhuong(), 
								datPhongB.getKhachHang().getDiaChi().getQuan(),
								datPhongB.getKhachHang().getDiaChi().getTinh()) :
						String.format("%s %s, P.%s, TP.%s, T.%s", 
								datPhongB.getKhachHang().getDiaChi().getSoNha(), 
								datPhongB.getKhachHang().getDiaChi().getDuong(),
								datPhongB.getKhachHang().getDiaChi().getPhuong(), 
								datPhongB.getKhachHang().getDiaChi().getQuan(), 
								datPhongB.getKhachHang().getDiaChi().getTinh()));
				ngaysinh2.setDate(java.sql.Date.valueOf(datPhongB.getKhachHang().getNgaySinh()));
				cb_LoaiKH2.setSelectedItem(datPhongB.getKhachHang().getLoaiKH());
			}
		}
	}
	
	public void updateSophongtrong() {
		List<Phong> dsphongs = phongDAO.getDSPhong();
		int soPhongTrong = 0, ra;
		for (Phong phong : dsphongs) {
			ra = (phong.getTinhtrangPhong().equalsIgnoreCase("Phòng trống")) ? 0 : 1;
			soPhongTrong += (ra == 0) ? 1 : 0;
			label_soPhong.setText(Integer.toString(soPhongTrong));
		}
	}
	
	public class UIQLPhong extends JDialog {
		private JLabel lblHinh = new JLabel();
		private JLabel lblsoPhong = new JLabel();
		private JLabel lblMaPhong = new JLabel();
		private JTextField tfTheogio = new JTextField();
		private JTextField tfQuadem = new JTextField();
		private JTextField tfTheoNgay = new JTextField();
		private JSpinner soNguoi = new JSpinner();
		private String[] loaiPhong;
		private DefaultComboBoxModel<String> dfloaiphong;
		private JComboBox<String> cb_LoaiPhong;
		private String[] loaiGiuong;
		private DefaultComboBoxModel<String> dfloaigiuong;
		private JComboBox<String> cb_LoaiGiuong = new JComboBox<String>();
		private String maPhong = "";
		private Phong phong;
		
		public UIQLPhong(Phong phong, String action) {
			super(new JFrame(), "Quản lý phòng", true);
			getContentPane().setBackground(Color.WHITE);
			setBackground(Color.WHITE);
			setBounds(0, 0, 340, 615);
			setLocationRelativeTo(null);
			getContentPane().setLayout(null);
			KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
				
				@Override
				public boolean dispatchKeyEvent(KeyEvent e) {
					switch (e.getID()) {
					  case KeyEvent.KEY_PRESSED:
	                        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
	                            dispose();
	                        }
	                        break;
					}
					return false;
				}
			});
			this.phong = phong;
			
			int sizePhong = phongDAO.getDSPhong().size();
			maPhong = String.format("P%d0%d", (sizePhong/5 + 1), sizePhong%6);
			
			int index = 0;
			loaiPhong = new String[loaiphongDAO.getDSLoaiPhong().size()];
			for(LoaiPhong lp : loaiphongDAO.getDSLoaiPhong()) {
				loaiPhong[index++] = lp.getTenLoaiphong();
			}
			dfloaiphong = new DefaultComboBoxModel<String>(loaiPhong);
			cb_LoaiPhong = new JComboBox<String>(dfloaiphong);
			
			index = 0;
			loaiGiuong = new String[giuongDAO.getDSGiuong().size()];
			for(Giuong giuong : giuongDAO.getDSGiuong()) {
				loaiGiuong[index++] = giuong.getLoaiGiuong();
			}
			dfloaigiuong = new DefaultComboBoxModel<String>(loaiGiuong);
			cb_LoaiGiuong = new JComboBox<String>(dfloaigiuong);
			
			lblHinh.setHorizontalAlignment(SwingConstants.CENTER);
			lblHinh.setBounds(0, 0, 330, 245);
			getContentPane().add(lblHinh);
			
			JPanel panel_InfoPhong = new JPanel();
			panel_InfoPhong.setBackground(Color.WHITE);
			panel_InfoPhong.setBounds(0, 256, 330, 300);
			getContentPane().add(panel_InfoPhong);
			Border border = BorderFactory.createLineBorder(Color.RED);
			TitledBorder titleBorder = new TitledBorder(border, "Thông tin phòng");
			titleBorder.setTitleFont(new Font("Times New Roman", Font.BOLD, 18));
			titleBorder.setTitleColor(Color.RED);
			panel_InfoPhong.setBorder(titleBorder);
			panel_InfoPhong.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Mã Phòng:");
			lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			lblNewLabel.setBounds(10, 25, 80, 21);
			panel_InfoPhong.add(lblNewLabel);
			
			lblMaPhong.setText(maPhong);
			lblMaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			lblMaPhong.setBounds(100, 25, 80, 21);
			panel_InfoPhong.add(lblMaPhong);
			
			JLabel lblMPhng = new JLabel("Số phòng:");
			lblMPhng.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			lblMPhng.setBounds(197, 25, 80, 21);
			panel_InfoPhong.add(lblMPhng);
			
			lblsoPhong.setText(maPhong.substring(1, maPhong.length()));
			lblsoPhong.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			lblsoPhong.setBounds(287, 25, 33, 21);
			panel_InfoPhong.add(lblsoPhong);
			
			JLabel lblLoiPhng = new JLabel("Loại phòng:");
			lblLoiPhng.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			lblLoiPhng.setBounds(10, 65, 95, 21);
			panel_InfoPhong.add(lblLoiPhng);
			
			cb_LoaiPhong.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			cb_LoaiPhong.setBounds(144, 65, 162, 22);
			panel_InfoPhong.add(cb_LoaiPhong);
			cb_LoaiPhong.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					updateHinhphong();
				}
			});
			
			JLabel lblLoiGing = new JLabel("Loại giường:");
			lblLoiGing.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			lblLoiGing.setBounds(10, 105, 95, 21);
			panel_InfoPhong.add(lblLoiGing);
			
			cb_LoaiGiuong.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			cb_LoaiGiuong.setBounds(144, 105, 162, 22);
			panel_InfoPhong.add(cb_LoaiGiuong);
			cb_LoaiGiuong.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					updateHinhphong();
				}
			});
			
			JLabel lblGiTheoGi = new JLabel("Giá theo giờ:");
			lblGiTheoGi.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			lblGiTheoGi.setBounds(10, 145, 110, 21);
			panel_InfoPhong.add(lblGiTheoGi);
			
			tfTheogio = new JTextField();
			tfTheogio.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			tfTheogio.setBounds(146, 138, 160, 21);
			panel_InfoPhong.add(tfTheogio);
			tfTheogio.setColumns(10);
			
			JLabel lblGiQuam = new JLabel("Giá qua đêm:");
			lblGiQuam.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			lblGiQuam.setBounds(10, 185, 110, 21);
			panel_InfoPhong.add(lblGiQuam);
			
			tfQuadem.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			tfQuadem.setColumns(10);
			tfQuadem.setBounds(146, 178, 160, 21);
			panel_InfoPhong.add(tfQuadem);
			
			JLabel lblGiTheoNgy = new JLabel("Giá theo ngày:");
			lblGiTheoNgy.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			lblGiTheoNgy.setBounds(10, 225, 110, 21);
			panel_InfoPhong.add(lblGiTheoNgy);
			
			tfTheoNgay.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			tfTheoNgay.setColumns(10);
			tfTheoNgay.setBounds(146, 218, 160, 21);
			panel_InfoPhong.add(tfTheoNgay);
			
			JLabel lblSNgiTi = new JLabel("Số người tối đa:");
			lblSNgiTi.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			lblSNgiTi.setBounds(10, 265, 126, 21);
			panel_InfoPhong.add(lblSNgiTi);
		
			soNguoi.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			soNguoi.setBounds(146, 265, 160, 21);
			panel_InfoPhong.add(soNguoi);
			
			JButton btnThoat = new JButton("Thoát");
			btnThoat.setIcon(new ImageIcon(UIDichvu.class.getResource("/images/back.png")));
			btnThoat.setBounds(5, 560, 89, 23);
			btnThoat.setFont(new Font("Times New Roman", Font.BOLD, 20));
			getContentPane().add(btnThoat);
			btnThoat.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(JOptionPane.showConfirmDialog(null,
							"Bạn có thoát?", "Thoát", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
						dispose();
				}
			});
			
			if(action.equalsIgnoreCase("add")) {
				JButton button = new JButton("Lưu");
				button.setFont(new Font("Times New Roman", Font.BOLD, 20));
				button.setHorizontalTextPosition(SwingConstants.LEADING);
				button.setHorizontalAlignment(SwingConstants.LEADING);
				button.setIcon(new ImageIcon(UIQLPhong.class.getResource("/images/add_room.png")));
				button.setBounds(240, 560, 89, 23);
				add(button);
				button.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if(isValidDataPhong() && JOptionPane.showConfirmDialog(null,
							"Bạn có muốn thêm phòng?", "Thêm phòng", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
							them();
					}
				});
			}else {
				if(phong != null) {
					maPhong = phong.getMaPhong();
					lblMaPhong.setText(phong.getMaPhong());
					lblsoPhong.setText(phong.getSoPhong());
					cb_LoaiPhong.setSelectedItem(phong.getLoaiPhong().getTenLoaiphong());
					cb_LoaiGiuong.setSelectedItem(phong.getGiuong().getLoaiGiuong());
					tfQuadem.setText(Double.toString(phong.getGiaQuadem()));
					tfTheogio.setText(Double.toString(phong.getGiaTheogio()));
					tfTheoNgay.setText(Double.toString(phong.getGiaTheongay()));
					soNguoi.setValue(phong.getSoNguoiToida());
				}
				if(action.equalsIgnoreCase("edit")) {
					JButton button = new JButton("Sửa");
					button.setFont(new Font("Times New Roman", Font.BOLD, 20));
					button.setHorizontalTextPosition(SwingConstants.LEADING);
					button.setHorizontalAlignment(SwingConstants.LEADING);
					button.setIcon(new ImageIcon(UIQLPhong.class.getResource("/images/edit_room.png")));
					button.setBounds(240, 560, 89, 23);
					add(button);
					button.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							if(isValidDataPhong() && JOptionPane.showConfirmDialog(null,
								"Bạn có muốn sửa phòng?", "Sửa phòng", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
								sua();
						}
					});
				}else {
					JButton button = new JButton("Xóa");
					button.setFont(new Font("Times New Roman", Font.BOLD, 20));
					button.setHorizontalTextPosition(SwingConstants.LEADING);
					button.setHorizontalAlignment(SwingConstants.LEADING);
					button.setIcon(new ImageIcon(UIQLPhong.class.getResource("/images/remove_room.png")));
					button.setBounds(240, 560, 89, 23);
					add(button);
					button.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							if(JOptionPane.showConfirmDialog(null,
								"Bạn có muốn xóa phòng?", "Xóa phòng", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
								xoa();
						}
					});
				}
			}
			updateHinhphong();
		}
		
		public void them() {
			phong = new Phong(maPhong,
					loaiphongDAO.timLoaiPhongTheoTen(cb_LoaiPhong.getSelectedItem().toString()),
					Double.parseDouble(tfTheogio.getText().trim()),
					Double.parseDouble(tfQuadem.getText().trim()), 
					Double.parseDouble(tfTheoNgay.getText().trim()), 
					lblsoPhong.getText().trim(), 
					giuongDAO.timTheoTen(cb_LoaiGiuong.getSelectedItem().toString()),
					"Phòng trống",
					Integer.parseInt(soNguoi.getValue().toString()));
			if(phongDAO.themPhong(phong)) {
				JOptionPane.showMessageDialog(null, "Thêm phòng thành công!!", "Thông báo", 1);
				xuatDSPhong();
				dispose();
			}
			else JOptionPane.showMessageDialog(null, "Thêm phòng không thành công!!", "Thông báo", 1);
		}
		
		public void xoa() {
			if(phongDAO.getDSPhong().indexOf(phong) == phongDAO.getDSPhong().size() - 1) {
				if(phongDAO.xoaPhong(phong.getMaPhong())) {
					JOptionPane.showMessageDialog(null, "Xóa phòng thành công!!", "Thông báo", 1);
					xuatDSPhong();
					dispose();
				}
				else JOptionPane.showMessageDialog(null, "Xóa phòng không thành công!!", "Thông báo", 1);
			}else {
				phong.setTinhtrangPhong("Deleted");
				if(phongDAO.suaPhong(phong)) {
					JOptionPane.showMessageDialog(null, "Xóa phòng thành công!!", "Thông báo", 1);
					xuatDSPhong();
					dispose();
				}
				else JOptionPane.showMessageDialog(null, "Xóa phòng không thành công!!", "Thông báo", 1);
			}
		}
		
		public void sua() {
			phong = new Phong(maPhong,
					loaiphongDAO.timLoaiPhongTheoTen(cb_LoaiPhong.getSelectedItem().toString()),
					Double.parseDouble(tfTheogio.getText().trim()),
					Double.parseDouble(tfQuadem.getText().trim()), 
					Double.parseDouble(tfTheoNgay.getText().trim()), 
					lblsoPhong.getText().trim(), 
					giuongDAO.timTheoTen(cb_LoaiGiuong.getSelectedItem().toString()),
					"Phòng trống",
					Integer.parseInt(soNguoi.getValue().toString()));
			if(phongDAO.suaPhong(phong)) {
				JOptionPane.showMessageDialog(null, "Sửa phòng thành công!!", "Thông báo", 1);
				xuatDSPhong();
				dispose();
			}
			else JOptionPane.showMessageDialog(null, "Sửa phòng không thành công!!", "Thông báo", 1);
		}
		
		public boolean isValidDataPhong() {
			try {
				Double.parseDouble(tfTheogio.getText().trim());
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Giá theo giờ phải là số thực!!", "Thông báo", 1);
				return false;
			}
			try {
				Double.parseDouble(tfQuadem.getText().trim());
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Giá theo giờ phải là số thực!!", "Thông báo", 1);
				return false;
			}
			try {
				Double.parseDouble(tfTheoNgay.getText().trim());
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Giá theo giờ phải là số thực!!", "Thông báo", 1);
				return false;
			}
			return true;
		}
		
		public void updateHinhphong() {
			cb_LoaiGiuong.setEnabled(false);
			if(cb_LoaiPhong.getSelectedItem().toString().equalsIgnoreCase("Phòng đơn")) {
				lblHinh.setIcon(new ImageIcon(UIQLPhong.class.getResource("/images/phong/phongdon.jpg")));
				soNguoi.setModel(new SpinnerNumberModel(2, 1, 8, 1));
			}else if(cb_LoaiPhong.getSelectedItem().toString().equalsIgnoreCase("Phòng đôi")) {
				cb_LoaiGiuong.setEnabled(true);
				soNguoi.setModel(new SpinnerNumberModel(4, 1, 8, 1));
				if(cb_LoaiGiuong.getSelectedItem().toString().equalsIgnoreCase("Một giường")) {
					lblHinh.setIcon(new ImageIcon(UIQLPhong.class.getResource("/images/phong/phongdoi.jpg")));
				}else {
					lblHinh.setIcon(new ImageIcon(UIQLPhong.class.getResource("/images/phong/phongdoi2.PNG")));
				}
			}else {
				lblHinh.setIcon(new ImageIcon(UIQLPhong.class.getResource("/images/phong/phongGD.jpg")));
				soNguoi.setModel(new SpinnerNumberModel(8, 1, 8, 1));
			}
		}
	}
	
	public class UIDatPhong extends JDialog {
		
		private Date today = new Date();
		private Date ngayNhan_old = new Date();
		private Date ngayTra_old = new Date();
		private JCheckBox[] ckbPhong;
		private String[] loaithue = new String[] {"Theo giờ", "Qua đêm", "Theo ngày"};
		private DefaultComboBoxModel<String> dfloaithue = new DefaultComboBoxModel<String>(loaithue);
		private JComboBox<String> comboBox = new JComboBox<String>(dfloaithue);
		private String[] gio = new String[] {"12:00 am", "12:00 pm"};
		private DefaultComboBoxModel<String> dfgionhan = new DefaultComboBoxModel<String>(gio);
		private DefaultComboBoxModel<String> dfgiotra = new DefaultComboBoxModel<String>(gio);
		private JComboBox<String> cbGionhan = new JComboBox<String>(dfgionhan);
		private JComboBox<String> cbGiotra = new JComboBox<String>(dfgiotra);
		private JDateChooser dateChooser_nhan = new JDateChooser();
		private JDateChooser dateChooser_tra = new JDateChooser();
		private JTextField tfTinh = new JTextField();
		private JTextField tfQuan = new JTextField();
		private JTextField tfPhuong = new JTextField();
		private JTextField tfDuong = new JTextField();
		private JTextField tfSonha = new JTextField();
		private JTextField tfHoten = new JTextField();
		private JTextField tfSoDT = new JTextField();
		private JTextField tfSoCMND = new JTextField();
		private JList<String> list_KhachHang = new JList<String>();
		private DefaultListModel<String> lm_KhachHang;
		private JDateChooser ngaysinh = new JDateChooser();
		private String[] loaiKH = new String[] {"Vãn lai", "Thường", "VIP"};
		private DefaultComboBoxModel<String> dfLoaiKH = new DefaultComboBoxModel<String>(loaiKH);
		private JComboBox<String> cb_LoaiKH = new JComboBox<String>(dfLoaiKH);
		private KhachHang khachHang = new KhachHang();
		private List<Phong> phongs;
		private DatPhong datPhong;
		
		public UIDatPhong(DatPhong datPhong, String action) {
			super(new JFrame(),"Đặt phòng",true);
			getContentPane().setBackground(Color.WHITE);
			setBounds(0, 0, 735, 533);
			setLocationRelativeTo(null);
			getContentPane().setLayout(null);
			KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
				
				@Override
				public boolean dispatchKeyEvent(KeyEvent e) {
					switch (e.getID()) {
					  case KeyEvent.KEY_PRESSED:
	                        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
	                            dispose();
	                        }
	                        break;
					}
					return false;
				}
			});
			this.datPhong = datPhong;
			dateChooser_nhan.setDateFormatString("dd/MM/yyyy");
			dateChooser_tra.setDateFormatString("dd/MM/yyyy");
			
			JPanel panel_Phong = new JPanel();
			panel_Phong.setLayout(new BorderLayout(0, 0));
			panel_Phong.setBackground(Color.WHITE);
			panel_Phong.setBounds(0, 0, 390, 210);
			Border border = BorderFactory.createLineBorder(Color.RED);
			TitledBorder titleBorder = new TitledBorder(border, "Phòng");
			titleBorder.setTitleFont(new Font("Times New Roman", Font.BOLD, 16));
			titleBorder.setTitleColor(Color.RED);
			panel_Phong.setBorder(titleBorder);
			
			JPanel panel_Phongs = new JPanel();
			panel_Phongs.setBackground(Color.WHITE);
			panel_Phongs.setLayout(new GridLayout(0, 5, 5, 10));
			ckbPhong = new JCheckBox[phongDAO.getDSPhong().size()];
			int index = 0, temp = 0;
			for (Phong ps : phongDAO.getDSPhong()) {
				ckbPhong[index] = new JCheckBox(ps.getMaPhong());
				ckbPhong[index].setFont(new Font("Times New Roman", Font.PLAIN, 16));
				ckbPhong[index].setBackground(Color.WHITE);
				if(temp < datPhong.getPhong().size() && ps.equals(datPhong.getPhong().get(temp))) {
					ckbPhong[index].setSelected(true);
					temp++;
				}
				panel_Phongs.add(ckbPhong[index++]);
			}
			JScrollPane scrollPaneDP = new JScrollPane(panel_Phongs,
					ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
					ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPaneDP.getViewport().setBackground(Color.WHITE);
			panel_Phong.add(scrollPaneDP);
			getContentPane().add(panel_Phong);
			
			JPanel panel_ThongTinDP = new JPanel();
			panel_ThongTinDP.setBackground(Color.WHITE);
			panel_ThongTinDP.setBounds(0, 215, 390, 289);
			border = BorderFactory.createLineBorder(Color.RED);
			titleBorder = new TitledBorder(border, "Thông tin đặt phòng");
			titleBorder.setTitleFont(new Font("Times New Roman", Font.BOLD, 16));
			titleBorder.setTitleColor(Color.RED);
			panel_ThongTinDP.setBorder(titleBorder);
			getContentPane().add(panel_ThongTinDP);
			panel_ThongTinDP.setLayout(null);
			
			JLabel label = new JLabel("Hình thức thuê:");
			label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			label.setBounds(10, 25, 134, 21);
			panel_ThongTinDP.add(label);
			comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			
			comboBox.setBounds(154, 24, 110, 22);
			panel_ThongTinDP.add(comboBox);
			comboBox.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					updateLoaiDP();
				}
			});
			
			label = new JLabel("Ngày nhận:");
			label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			label.setBounds(10, 75, 100, 21);
			panel_ThongTinDP.add(label);
			
			dateChooser_nhan.getSpinner().setFont(new Font("Times New Roman", Font.PLAIN, 20));
			dateChooser_nhan.setBounds(126, 75, 228, 20);
			panel_ThongTinDP.add(dateChooser_nhan);
			
			label = new JLabel("Giờ nhận:");
			label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			label.setBounds(10, 125, 90, 21);
			panel_ThongTinDP.add(label);
			
			cbGionhan.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			cbGionhan.setBounds(126, 125, 110, 20);
			panel_ThongTinDP.add(cbGionhan);
			
			label = new JLabel("Ngày trả:");
			label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			label.setBounds(10, 175, 90, 21);
			panel_ThongTinDP.add(label);
			
			dateChooser_tra.getSpinner().setFont(new Font("Times New Roman", Font.PLAIN, 20));
			dateChooser_tra.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			dateChooser_tra.setBounds(126, 175, 228, 20);
			panel_ThongTinDP.add(dateChooser_tra);
			
			label = new JLabel("Giờ Trả:");
			label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			label.setBounds(10, 225, 90, 21);
			panel_ThongTinDP.add(label);
			
			cbGiotra.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			cbGiotra.setBounds(126, 225, 110, 20);
			panel_ThongTinDP.add(cbGiotra);
			
			
			JPanel panel_thongtinKH = new JPanel();
			panel_thongtinKH.setBackground(Color.WHITE);
			panel_thongtinKH.setBounds(395, 0, 326, 453);
			border = BorderFactory.createLineBorder(Color.RED);
			titleBorder = new TitledBorder(border, "Khách hàng");
			titleBorder.setTitleFont(new Font("Times New Roman", Font.BOLD, 16));
			titleBorder.setTitleColor(Color.RED);
			panel_thongtinKH.setBorder(titleBorder);
			getContentPane().add(panel_thongtinKH);
			panel_thongtinKH.setLayout(null);
			
			JLabel lblHoTen = new JLabel("Họ tên:");
			lblHoTen.setFont(new Font("Times New Roman", Font.BOLD, 18));
			lblHoTen.setBounds(10, 25, 58, 21);
			panel_thongtinKH.add(lblHoTen);

			JLabel lblSCmnd = new JLabel("Số ĐT:");
			lblSCmnd.setFont(new Font("Times New Roman", Font.BOLD,18));
			lblSCmnd.setBounds(10, 65, 58, 21);
			panel_thongtinKH.add(lblSCmnd);

			JLabel lblSCmnd_1 = new JLabel("Số CMND:");
			lblSCmnd_1.setFont(new Font("Times New Roman", Font.BOLD,18));
			lblSCmnd_1.setBounds(10, 105, 86, 21);
			panel_thongtinKH.add(lblSCmnd_1);

			JLabel lblNgySinh = new JLabel("Ngày sinh:");
			lblNgySinh.setFont(new Font("Times New Roman", Font.BOLD, 18));
			lblNgySinh.setBounds(10, 145, 83, 21);
			panel_thongtinKH.add(lblNgySinh);
			titleBorder = new TitledBorder(border, "Địa chỉ");
			titleBorder.setTitleFont(new Font("Times New Roman", Font.ITALIC, 16));
			titleBorder.setTitleColor(Color.RED);

			JLabel lblLoiKh = new JLabel("Loại KH:");
			lblLoiKh.setFont(new Font("Times New Roman", Font.BOLD, 18));
			lblLoiKh.setBounds(10, 185, 74, 21);
			panel_thongtinKH.add(lblLoiKh);

			tfHoten.setFont(new Font("Times New Roman", Font.BOLD, 18));
			tfHoten.setBounds(106, 20, 209, 25);
			tfHoten.getDocument().addDocumentListener(new DocumentListener() {
				@Override
				public void removeUpdate(DocumentEvent e) {
					hienThiKH();
				}

				@Override
				public void insertUpdate(DocumentEvent e) {
					hienThiKH();
				}

				@Override
				public void changedUpdate(DocumentEvent e) {
					hienThiKH();
				}
			});
			tfHoten.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					list_KhachHang.setVisible(false);
					tfSoDT.requestFocus();
				}
			});
			panel_thongtinKH.add(tfHoten);
			
			lm_KhachHang = new DefaultListModel<String>();
			list_KhachHang.setModel(lm_KhachHang);
			list_KhachHang.setBounds(106, 60, 209, 120);
			list_KhachHang.setFont(new Font("Times New Roman", Font.BOLD, 12));
			list_KhachHang.setVisibleRowCount(5);
			list_KhachHang.setVisible(false);
			panel_thongtinKH.add(list_KhachHang);

			tfSoDT.setFont(new Font("Times New Roman", Font.BOLD, 18));
			tfSoDT.setColumns(10);
			tfSoDT.setBounds(106, 60, 209, 25);
			panel_thongtinKH.add(tfSoDT);

			tfSoCMND.setFont(new Font("Times New Roman", Font.BOLD, 18));
			tfSoCMND.setColumns(10);
			tfSoCMND.setBounds(106, 100, 209, 25);
			panel_thongtinKH.add(tfSoCMND);

			ngaysinh.getSpinner().setFont(new Font("Times New Roman", Font.BOLD, 18));
			ngaysinh.setDateFormatString("dd/MM/yyyy");
			ngaysinh.setBounds(106, 180, 205, 25);
			ngaysinh.getSpinner().addChangeListener(new ChangeListener() {
				@SuppressWarnings("deprecation")
				@Override
				public void stateChanged(ChangeEvent e) {
					if(today.getYear() - ngaysinh.getDate().getYear() < 16) {
						JOptionPane.showMessageDialog(null, "Khách hàng phải lớn hơn 15 tuổi!!", "Thông báo", 1);
					}
				}
			});
			panel_thongtinKH.add(ngaysinh);

			cb_LoaiKH.setFont(new Font("Times New Roman", Font.BOLD, 18));
			cb_LoaiKH.setBounds(106, 140, 95, 27);
			panel_thongtinKH.add(cb_LoaiKH);
			
			JPanel panel_Diachi = new JPanel();
			panel_Diachi.setBackground(Color.WHITE);
			panel_Diachi.setBounds(10, 217, 310, 230);
			panel_Diachi.setBorder(titleBorder);
			panel_Diachi.setLayout(null);

			JLabel lblTnhtp = new JLabel("Tỉnh/TP:");
			lblTnhtp.setBounds(10, 21, 85, 24);
			lblTnhtp.setFont(new Font("Times New Roman", Font.BOLD, 18));
			panel_Diachi.add(lblTnhtp);

			JLabel lblQun = new JLabel("Quận:");
			lblQun.setBounds(10, 56, 85, 24);
			lblQun.setFont(new Font("Times New Roman", Font.BOLD, 18));
			panel_Diachi.add(lblQun);

			JLabel lblPhng = new JLabel("Phường:");
			lblPhng.setBounds(10, 91, 85, 24);
			lblPhng.setFont(new Font("Times New Roman", Font.BOLD, 18));
			panel_Diachi.add(lblPhng);

			JLabel lblng = new JLabel("Đường:");
			lblng.setBounds(10, 126, 85, 24);
			lblng.setFont(new Font("Times New Roman", Font.BOLD, 18));
			panel_Diachi.add(lblng);

			JLabel lblSNh = new JLabel("Số nhà:");
			lblSNh.setBounds(10, 161, 85, 24);
			lblSNh.setFont(new Font("Times New Roman", Font.BOLD, 18));
			panel_Diachi.add(lblSNh);
			tfTinh.setBounds(105, 21, 195, 25);

			tfTinh.setFont(new Font("Times New Roman", Font.BOLD, 18));
			tfTinh.setColumns(10);
			panel_Diachi.add(tfTinh);
			tfQuan.setBounds(105, 56, 195, 25);

			tfQuan.setFont(new Font("Times New Roman", Font.BOLD, 18));
			tfQuan.setColumns(10);
			panel_Diachi.add(tfQuan);
			tfPhuong.setBounds(105, 91, 195, 25);

			tfPhuong.setFont(new Font("Times New Roman", Font.BOLD, 18));
			tfPhuong.setColumns(10);
			panel_Diachi.add(tfPhuong);
			tfDuong.setBounds(105, 126, 195, 25);

			tfDuong.setFont(new Font("Times New Roman", Font.BOLD, 18));
			tfDuong.setColumns(10);
			panel_Diachi.add(tfDuong);
			tfSonha.setBounds(105, 161, 195, 25);

			tfSonha.setFont(new Font("Times New Roman", Font.BOLD, 18));
			tfSonha.setColumns(10);
			panel_Diachi.add(tfSonha);

			JButton btnclear = new JButton("clear");
			btnclear.setBounds(211, 197, 89, 23);
			btnclear.setIcon(new ImageIcon(UIDatPhong.class.getResource("/images/clear.png")));
			btnclear.setFont(new Font("Times New Roman", Font.PLAIN, 16));
			btnclear.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(MouseEvent e) {
					tfHoten.setText("");
					tfHoten.requestFocus();
					tfSoDT.setText("");
					tfSoCMND.setText("");
					ngaysinh.setDate(new Date());
					dfLoaiKH.setSelectedItem(loaiKH[0]);
					tfTinh.setText("");
					tfQuan.setText("");
					tfPhuong.setText("");
					tfDuong.setText("");
					tfSonha.setText("");
				}
			});
			panel_Diachi.add(btnclear);
			panel_thongtinKH.add(panel_Diachi);
			
			
			
			JButton btnCancel = new JButton("Thoát");
			btnCancel.setIcon(new ImageIcon(UIDatPhong.class.getResource("/images/back.png")));
			btnCancel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			btnCancel.setBounds(395, 464, 115, 30);
			getContentPane().add(btnCancel);
			btnCancel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(JOptionPane.showConfirmDialog(null,
							"Bạn có muốn Thoát?", "Thoát", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
						dispose();
				}
			});
			
			if(action.equalsIgnoreCase("add")) {
				JButton btntPhng = new JButton("Đặt phòng");
				btntPhng.setFont(new Font("Times New Roman", Font.PLAIN, 18));
				btntPhng.setHorizontalTextPosition(SwingConstants.LEADING);
				btntPhng.setHorizontalAlignment(SwingConstants.LEADING);
				btntPhng.setIcon(new ImageIcon(UIDatPhong.class.getResource("/images/icons8-arrow-64.png")));
				btntPhng.setBounds(596, 464, 125, 30);
				getContentPane().add(btntPhng);
				btntPhng.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if(checkdate() && isValidDataKH() && JOptionPane.showConfirmDialog(null,
								"Bạn có muốn đặt phòng?", "Đặt phòng", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
							evDatphong();
					}
				});
				updateLoaiDP();
			}else {
				dfloaithue.setSelectedItem(datPhong.getLoaiDatPhong());
				dateChooser_nhan.setDate(java.sql.Date.valueOf(datPhong.getNgayDatPhong()));
				dateChooser_tra.setDate(java.sql.Date.valueOf(datPhong.getNgayTraPhong()));
				cbGionhan.setSelectedIndex(datPhong.getGioDatPhong().compareTo(LocalTime.of(0, 0)) == 0 ? 0 : 1);
				cbGiotra.setSelectedIndex(datPhong.getGioTraPhong().compareTo(LocalTime.of(0, 0)) == 0 ? 0 : 1);
				
				khachHang = datPhong.getKhachHang();
				tfHoten.setText(khachHang.getTenKH());
				tfHoten.requestFocus();
				tfSoDT.setText(khachHang.getSoDT());
				tfSoCMND.setText(khachHang.getSoCMD());
				ngaysinh.setDate(java.sql.Date.valueOf(khachHang.getNgaySinh()));
				dfLoaiKH.setSelectedItem(khachHang.getLoaiKH());
				tfTinh.setText(khachHang.getDiaChi().getTinh());
				tfQuan.setText(khachHang.getDiaChi().getQuan());
				tfPhuong.setText(khachHang.getDiaChi().getPhuong());
				tfDuong.setText(khachHang.getDiaChi().getDuong());
				tfSonha.setText(khachHang.getDiaChi().getSoNha());
				list_KhachHang.setVisible(false);
				if(action.equalsIgnoreCase("edit")) {
					JButton btntPhng = new JButton("Sửa đặt phòng");
					btntPhng.setFont(new Font("Times New Roman", Font.PLAIN, 18));
					btntPhng.setHorizontalTextPosition(SwingConstants.LEADING);
					btntPhng.setHorizontalAlignment(SwingConstants.LEADING);
					btntPhng.setIcon(new ImageIcon(UIDatPhong.class.getResource("/images/setting.png")));
					btntPhng.setBounds(571, 464, 150, 30);
					getContentPane().add(btntPhng);
					btntPhng.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							if(checkdate() && isValidDataKH() && JOptionPane.showConfirmDialog(null,
									"Bạn có muốn sửa đặt phòng?", "Sửa đặt phòng", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
								evSuaDatPhong();
						}
					});
					updateLoaiDP();
				}else {
					JButton btntPhng = new JButton("Hủy đặt phòng");
					btntPhng.setFont(new Font("Times New Roman", Font.PLAIN, 18));
					btntPhng.setHorizontalTextPosition(SwingConstants.LEADING);
					btntPhng.setHorizontalAlignment(SwingConstants.LEADING);
					btntPhng.setIcon(new ImageIcon(UIDatPhong.class.getResource("/images/remove-service.png")));
					btntPhng.setBounds(571, 464, 150, 30);
					getContentPane().add(btntPhng);
					btntPhng.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							if(JOptionPane.showConfirmDialog(null,
									"Bạn có hủy đặt phòng?", "Hủy đặt phòng", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
								evHuyDatPhong();
						}
					});
					updateLoaiDP();
				}
			}
		}
		
		public void evDatphong() {
			if(!khachhangDAO.getDSKhachHang().contains(khachHang)) {
				khachHang.setTenKH(tfHoten.getText().trim());
				khachHang.setSoDT(tfSoDT.getText().trim());
				khachHang.setSoCMD(tfSoCMND.getText().trim());
				khachHang.setNgaySinh(convertToLocalDateViaInstant(ngaysinh.getDate()));
				khachHang.setLoaiKH(dfLoaiKH.getSelectedItem().toString());

				DiaChi diaChi = new DiaChi();
				diaChi.setTinh(tfTinh.getText().trim());
				diaChi.setQuan(tfQuan.getText().trim());
				diaChi.setPhuong(tfPhuong.getText().trim());
				diaChi.setDuong(tfDuong.getText().trim());
				diaChi.setSoNha(tfSonha.getText().trim());
				diaChi.setMaDC(getAlphaString(10));
				khachHang.setDiaChi(diaChi);
				diachiDAO.themDiachi(diaChi);

				String maKH = String.format("KH%03d", khachhangDAO.getDSKhachHang().size() + 1);
				khachHang.setMaKH(maKH);
				khachhangDAO.themKhachHang(khachHang);

				updateTableKhachHang();
			}
			datPhong.setMaDP(getAlphaString(7));
			datPhong.setKhachHang(khachHang);
			
			phongs = new ArrayList<Phong>();
			for (int i = 0; i < ckbPhong.length; i++) {
				if(ckbPhong[i].isSelected()) {
					if(!phongs.contains(phongDAO.timPhong(ckbPhong[i].getText().trim())))
						phongs.add(phongDAO.timPhong(ckbPhong[i].getText().trim()));
				}
			}
			datPhong.setPhong(phongs);
			datPhong.setLoaiDatPhong(dfloaithue.getSelectedItem().toString());
			datPhong.setNgayDatPhong(convertToLocalDateViaInstant(dateChooser_nhan.getDate()));
			datPhong.setNgayTraPhong(convertToLocalDateViaInstant(dateChooser_nhan.getDate()));
			datPhong.setGioDatPhong(dfgionhan.getSelectedItem().equals(gio[0]) ? 
					LocalTime.of(0, 0) : LocalTime.of(12, 0));
			datPhong.setGioTraPhong(dfgiotra.getSelectedItem().equals(gio[0]) ? 
					LocalTime.of(0, 0) : LocalTime.of(12, 0));
			if(datPhongDAO.kiemTraTrung(datPhong)) {
				JOptionPane.showMessageDialog(null, "Đặt phòng trùng!!");
			}else {
				if(datPhongDAO.themDatPhong(datPhong)) {
					if(!dfloaithue.getSelectedItem().equals(loaithue[2]))
						datPhong.getPhong().forEach(p -> {
							p.setTinhtrangPhong("Đang thuê");
							phongDAO.suaPhong(p);
						});
					JOptionPane.showMessageDialog(null, "Đặt phòng thành công!!");
					updateTableDatPhong();
					xuatDSPhong();
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Đặt phòng không thành công!!");
				}
			}
		}
		
		public void evSuaDatPhong() {
			DatPhong datPhong_old = datPhong;
			datPhongDAO.xoaDatPhong(datPhong.getMaDP());
			if(!khachhangDAO.getDSKhachHang().contains(khachHang)) {
				khachHang.setTenKH(tfHoten.getText().trim());
				khachHang.setSoDT(tfSoDT.getText().trim());
				khachHang.setSoCMD(tfSoCMND.getText().trim());
				khachHang.setNgaySinh(convertToLocalDateViaInstant(ngaysinh.getDate()));
				khachHang.setLoaiKH(dfLoaiKH.getSelectedItem().toString());

				DiaChi diaChi = new DiaChi();
				diaChi.setTinh(tfTinh.getText().trim());
				diaChi.setQuan(tfQuan.getText().trim());
				diaChi.setPhuong(tfPhuong.getText().trim());
				diaChi.setDuong(tfDuong.getText().trim());
				diaChi.setSoNha(tfSonha.getText().trim());
				diaChi.setMaDC(getAlphaString(10));
				khachHang.setDiaChi(diaChi);
				diachiDAO.themDiachi(diaChi);

				String maKH = String.format("KH%03d", khachhangDAO.getDSKhachHang().size() + 1);
				khachHang.setMaKH(maKH);
				khachhangDAO.themKhachHang(khachHang);

				updateTableKhachHang();
			}
			datPhong.setMaDP(getAlphaString(7));
			datPhong.setKhachHang(khachHang);
			
			phongs = new ArrayList<Phong>();
			for (int i = 0; i < ckbPhong.length; i++) {
				if(ckbPhong[i].isSelected()) {
					if(!phongs.contains(phongDAO.timPhong(ckbPhong[i].getText().trim())))
						phongs.add(phongDAO.timPhong(ckbPhong[i].getText().trim()));
				}
			}
			datPhong.setPhong(phongs);
			datPhong.setLoaiDatPhong(dfloaithue.getSelectedItem().toString());
			datPhong.setNgayDatPhong(convertToLocalDateViaInstant(dateChooser_nhan.getDate()));
			datPhong.setNgayTraPhong(convertToLocalDateViaInstant(dateChooser_nhan.getDate()));
			datPhong.setGioDatPhong(dfgionhan.getSelectedItem().equals(gio[0]) ? 
					LocalTime.of(0, 0) : LocalTime.of(12, 0));
			datPhong.setGioTraPhong(dfgiotra.getSelectedItem().equals(gio[0]) ? 
					LocalTime.of(0, 0) : LocalTime.of(12, 0));
			if(datPhongDAO.kiemTraTrung(datPhong)) {
				JOptionPane.showMessageDialog(null, "Đặt phòng trùng!!");
				datPhongDAO.themDatPhong(datPhong_old);
			}else {
				if(datPhongDAO.suaDatPhong(datPhong)) {
					JOptionPane.showMessageDialog(null, "Sửa đặt phòng thành công!!");
					updateTableDatPhong();
					xuatDSPhong();
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Sửa đặt phòng không thành công!!");
					datPhongDAO.themDatPhong(datPhong_old);
				}
			}
		}
		
		public void evHuyDatPhong() {
			if(datPhongDAO.xoaDatPhong(datPhong.getMaDP())) {
				datPhong.getPhong().forEach(p -> {
					p.setTinhtrangPhong("Phòng trống");
					phongDAO.suaPhong(p);
				});
				JOptionPane.showMessageDialog(null, "Hủy đặt phòng thành công!!");
				updateTableDatPhong();
				xuatDSPhong();
				dispose();
			}else {
				JOptionPane.showMessageDialog(null, "Hủy đặt không thành công!!");
			}
		}
		
		public void hienThiKH() {
			list_KhachHang.setVisible(true);
			String filterten = tfHoten.getText().trim();
			lm_KhachHang.removeAllElements();
			for (KhachHang kh : khachhangDAO.getDSKhachHang()) {
				String s = kh.getTenKH() + "  [" + kh.getSoDT() + "]";
				if (!s.startsWith(filterten)) {
					if (lm_KhachHang.contains(s)) {
						lm_KhachHang.removeElement(s);
					}
				} else {
					if (!lm_KhachHang.contains(s)) {
						lm_KhachHang.addElement(s);
					}
				}
			}
			list_KhachHang.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					list_KhachHang.setVisible(false);
					khachHang = khachhangDAO.timKHTheoDinhdang(list_KhachHang.getSelectedValue());
					if(khachHang != null) {
						tfHoten.setText(khachHang.getTenKH());
						tfHoten.requestFocus();
						tfSoDT.setText(khachHang.getSoDT());
						tfSoCMND.setText(khachHang.getSoCMD());
						ngaysinh.setDate(java.sql.Date.valueOf(khachHang.getNgaySinh()));
						dfLoaiKH.setSelectedItem(khachHang.getLoaiKH());
						tfTinh.setText(khachHang.getDiaChi().getTinh());
						tfQuan.setText(khachHang.getDiaChi().getQuan());
						tfPhuong.setText(khachHang.getDiaChi().getPhuong());
						tfDuong.setText(khachHang.getDiaChi().getDuong());
						tfSonha.setText(khachHang.getDiaChi().getSoNha());
						list_KhachHang.setVisible(false);
					}
				}
			});
		}
		
		public void updateLoaiDP() {
			if(dfloaithue.getSelectedItem().equals(loaithue[2])) {
				dateChooser_nhan.getSpinner().setEnabled(true);
				dateChooser_tra.getSpinner().setEnabled(true);
				cbGionhan.setEnabled(true);
				cbGiotra.setEnabled(true);
			}else {
				dateChooser_nhan.getSpinner().setEnabled(false);
				dateChooser_tra.getSpinner().setEnabled(false);
				cbGionhan.setEnabled(false);
				cbGiotra.setEnabled(false);
			}
		}
		
		public boolean checkdate() {
			if(dfloaithue.getSelectedItem().equals(loaithue[2])) {
				if(dateChooser_nhan.getDate().getTime() >= today.getTime() && 
						dateChooser_tra.getDate().getTime() >= today.getTime()) {
					if(dateChooser_nhan.getDate().getTime() <= dateChooser_tra.getDate().getTime()) {
						ngayTra_old = dateChooser_tra.getDate();
						ngayNhan_old = dateChooser_nhan.getDate();
						return true;
					}else {
						JOptionPane.showMessageDialog(null, "Ngày trả phòng phải lớn hơn bằng ngày nhận phòng!!");
						dateChooser_tra.setDate(ngayTra_old);
						dateChooser_nhan.setDate(ngayNhan_old);
						return false;
					}
				}else {
					JOptionPane.showMessageDialog(null, "Ngày trả phòng và ngày nhận phòng\n"
							+ "phải lớn hơn bằng ngày hiện tại!!");
					dateChooser_tra.setDate(ngayTra_old);
					dateChooser_nhan.setDate(ngayNhan_old);
					return false;
				}
			}
			return true;
		}
		
		@SuppressWarnings("deprecation")
		public boolean isValidDataKH() {
			if(tfHoten.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Tên KH không được để trống!!", "Thông báo", 1);
				return false;
			}
			if(!tfSoDT.getText().trim().matches("[0-9]{10,11}")) {
				JOptionPane.showMessageDialog(null, "Số điện thoại không được để trống\n10-11 chứ số!!", "Thông báo", 1);
				return false;	
			}
			if(!tfSoCMND.getText().trim().matches("[0-9]{9}")) {
				JOptionPane.showMessageDialog(null, "Số cmnd không được để trống\nĐầy đủ 9 kí tự số!!", "Thông báo", 1);
				return false;
			}
			if(today.getYear() - ngaysinh.getDate().getYear() < 16) {
				JOptionPane.showMessageDialog(null, "Khách hàng phải lớn hơn 15 tuổi!!", "Thông báo", 1);
				return false;
			}
			if(tfTinh.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Tỉnh TP không được để trống", "Thông báo", 1);
				return false;
			}
			if(tfQuan.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Quận không được để trống", "Thông báo", 1);
				return false;
			}
			if(tfPhuong.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Phường không được để trống", "Thông báo", 1);
				return false;
			}
			if(tfDuong.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Đường không được để trống", "Thông báo", 1);
				return false;
			}
			if(tfSonha.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Số nhà không được để trống", "Thông báo", 1);
				return false;
			}
			return true;
		}
	}
	
	public void updateTableDatPhong(){
		while(dfmodelDSDP.getRowCount() > 0)
			dfmodelDSDP.removeRow(0);
		for (DatPhong datPhong : datPhongDAO.getDSDatPhong()) {
			String phong = "";
			for(Phong p : datPhong.getPhong()) {
				phong += p.getMaPhong() + ", ";
			}
			phong = phong.substring(0, phong.length() - 2);
			dfmodelDSDP.addRow(new Object[] {
					datPhong.getMaDP(), datPhong.getKhachHang().getTenKH(), datPhong.getKhachHang().getSoDT(),
					phong, datPhong.getLoaiDatPhong(), datPhong.getNgayDatPhong(), datPhong.getGioDatPhong()
			});
		}
		tableDSDatPhong.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
					int row, int column) {
				final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				c.setBackground(row % 2 == 1 ? Color.LIGHT_GRAY : Color.WHITE);
				c.setForeground(Color.BLACK);
				return c;
			}
		});
	}
	
	public void displayDSdichvu() {
		contentPane.remove(panel_DSDichvu);
		panel_DSDichvu = new JPanel();
		contentPane.add(panel_DSDichvu);
		this.invalidate();
		this.validate();
		this.revalidate();
		this.repaint();
		
		panel_DSDichvu = new JPanel();
		panel_DSDichvu.setBackground(Color.WHITE);
		panel_DSDichvu.setLayout(new GridLayout(0, 6, 10 , 12));

		List<Dichvu> dichvus = dichvuDAO.getDSDichvu();
		spinners = new JSpinner[dichvus.size()];

		Box dv, b1;
		int max = 99, index = 0;

		for (final Dichvu dichvu : dichvus) {
			JPanel panel = new JPanel();
			JPopupMenu menuDV = new JPopupMenu();
			JMenuItem capnhatDV = new JMenuItem("Cập nhật dịch vụ");
			capnhatDV.setFont(new Font("Times New Roman", Font.PLAIN, 22));
			capnhatDV.setIcon(new ImageIcon(UIVinaHome.class.getResource("/images/business-management-icon.png")));
			menuDV.add(capnhatDV);
			capnhatDV.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					new UIDichvu(dichvu, "edit").setVisible(true);
				}
			});
			JMenuItem themDV = new JMenuItem("Thêm dịch vụ");
			themDV.setFont(new Font("Times New Roman", Font.PLAIN, 22));
			themDV.setIcon(new ImageIcon(UIVinaHome.class.getResource("/images/add-service.png")));
			menuDV.add(themDV);
			themDV.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					new UIDichvu(null, "add").setVisible(true);
				}
			});
			JMenuItem xoaDV = new JMenuItem("Xóa dịch vụ");
			xoaDV.setFont(new Font("Times New Roman", Font.PLAIN, 22));
			xoaDV.setIcon(new ImageIcon(UIVinaHome.class.getResource("/images/remove-service.png")));
			menuDV.add(xoaDV);
			xoaDV.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					new UIDichvu(dichvu, "remove").setVisible(true);
				}
			});
			
			panel.addMouseListener(new MouseAdapter() {
				
				@Override
				public void mouseClicked(MouseEvent e) {
					if(e.getButton()==MouseEvent.BUTTON3 && nhanVien.getChuVu().equalsIgnoreCase("Quản lý"))
						menuDV.show(e.getComponent(),e.getX(),e.getY());
				}
			});
			panel.setBackground(Color.WHITE);
			panel.add(dv = Box.createVerticalBox());
			dv.add(b1 = Box.createHorizontalBox());
			JLabel label = new JLabel();
			try {
				String resource = "/images/dichvu/"+dichvu.getMaDV()+".jpg";
				Image img = ImageIO.read(getClass().getResource(resource));
				label.setIcon(new ImageIcon(img));
			} catch (Exception ex) {
				label.setIcon(new ImageIcon(UIDichvu.class.getResource("/images/dichvu/service.jpg")));
				ex.printStackTrace();
			}
			b1.add(label);
			dv.add(b1 = Box.createHorizontalBox());
			label = new JLabel();
			label.setText(dichvu.getTenDV());
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setFont(new Font("Times New Roman", Font.BOLD, 24));
			b1.add(label);
			dv.add(b1 = Box.createHorizontalBox());
			JLabel gia = new JLabel();
			gia.setFont(new Font("Times New Roman", Font.BOLD, 24));
			gia.setText(format.format(dichvu.getGia()));
			panel_DSDichvu.add(panel);
			b1.add(gia);
			b1.add(Box.createHorizontalStrut(80));
			max = dichvu.getSoluong();
			SpinnerNumberModel model = new SpinnerNumberModel(0, 0, max, 1);
			spinners[index] = new JSpinner(model);
			spinners[index].setForeground(Color.WHITE);
			spinners[index].setFont(new Font("Times New Roman", Font.BOLD, 22));
			spinners[index].addChangeListener(new ChangeListener() {		
				@Override
				public void stateChanged(ChangeEvent e) {
					final int value = model.getNumber().intValue();
					updateTableChitietDichvu(dichvu, value);	
				}
			});
			b1.add(spinners[index++]);
		}
		JScrollPane scrollPane = new JScrollPane(panel_DSDichvu);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		panel_Dichvu.add(scrollPane);

	}

	public void updateTableChitietDichvu(Dichvu dichvu, int value){
		if(phieuDichvu == null) {
			phieuDichvu = new PhieuDichvu();
			phieuDichvu.setMaPhieuDV(getAlphaString(10));
			phieuDichvu.setNhanVien(nhanVien);
			phieuDichvu.setDschitietPhieuDichvu(new ArrayList<ChitietPhieuDichvu>());
		}
		ChitietPhieuDichvu ctdv = new ChitietPhieuDichvu(getAlphaString(10), dichvu, value);
		List<ChitietPhieuDichvu> dsCTDV = phieuDichvu.getDschitietPhieuDichvu();
		if(value == 1 && !phieuDichvu.getDschitietPhieuDichvu().contains(ctdv)) {
			dsCTDV.add(ctdv);
		} if(value == 0) {
			dsCTDV.remove(ctdv);
		} else {
			int index = dsCTDV.indexOf(ctdv);
			ctdv.setSoluong(value);
			dsCTDV.set(index, ctdv);
		}
		phieuDichvu.setDschitietPhieuDichvu(dsCTDV);
		if(phieuDichvu.getDschitietPhieuDichvu().isEmpty())
			btLaphoadon.setEnabled(false);
		else
			btLaphoadon.setEnabled(true);
		while(dfmodelCTHD.getRowCount() > 0)
			dfmodelCTHD.removeRow(0);
		for (ChitietPhieuDichvu chitietPhieuDichvu : dsCTDV) {
			dfmodelCTHD.addRow(new Object[] {
					table_ChitietHoadon.getRowCount() + 1, chitietPhieuDichvu.getDichvu().getTenDV(), 
					chitietPhieuDichvu.getDichvu().getLoaiDichvu().getTenLDV(),
					format.format(chitietPhieuDichvu.getDichvu().getGia()), 
					chitietPhieuDichvu.getSoluong(), 
					format.format(chitietPhieuDichvu.ThanhTien())
			});
		}
		lbtotal.setText(format.format(phieuDichvu.ThanhTien()));
	}
	
	public class UIDichvu extends JDialog {
		
		private JTextField tfMaDV = new JTextField();
		private JTextField tfTenDV = new JTextField();
		private JTextField tfGiaDV = new JTextField();
		private JComboBox<String> loaiDV = new JComboBox<String>();
		private String[] tenLDV;
		private JSpinner spinner = new JSpinner();
		
		public UIDichvu(Dichvu dichvu, String action) {
			super(new JFrame(), "Dịch vụ", true);
			setBounds(0, 0, 320, 500);
			setLocationRelativeTo(null);
			getContentPane().setLayout(new BorderLayout(0, 0));
			getContentPane().setBackground(Color.WHITE);
			JPanel panelDichvu = new JPanel();
			panelDichvu.setBackground(Color.WHITE);
			getContentPane().add(panelDichvu, BorderLayout.CENTER);
			KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
				
				@Override
				public boolean dispatchKeyEvent(KeyEvent e) {
					switch (e.getID()) {
					  case KeyEvent.KEY_PRESSED:
	                        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
	                            dispose();
	                        }
	                        break;
					}
					return false;
				}
			});
			
			Box b, b1, b2;
			tenLDV = new String[loaiDichvuDAO.getDSLoaiDichvu().size()];
			int index = 0;
			for (LoaiDichvu loaiDichvu : loaiDichvuDAO.getDSLoaiDichvu()) {
				tenLDV[index++] = loaiDichvu.getTenLDV();
			}
			loaiDV.setModel(new DefaultComboBoxModel<String>(tenLDV));
			loaiDV.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					updateMaDV();					
				}
			});
			
			panelDichvu.add(b = Box.createVerticalBox());
			b.add(b1 = Box.createHorizontalBox());
				b1.add(Box.createHorizontalStrut(30));
				JLabel lblHinh = new JLabel();
				if(action.equalsIgnoreCase("add")) {
					lblHinh.setIcon(new ImageIcon(UIDichvu.class.getResource("/images/dichvu/service.jpg")));
				}else {
					try {
						String resource = "/images/dichvu/"+dichvu.getMaDV()+".jpg";
						Image img = ImageIO.read(getClass().getResource(resource));
						lblHinh.setIcon(new ImageIcon(img));
					} catch (Exception ex) {
						lblHinh.setIcon(new ImageIcon(UIDichvu.class.getResource("/images/dichvu/service.jpg")));
						ex.printStackTrace();
					}
					tfMaDV.setText(dichvu.getMaDV());
					tfTenDV.setText(dichvu.getTenDV());
					tfGiaDV.setText(Double.toString(dichvu.getGia()));
				}
				b1.add(lblHinh);
				b1.add(Box.createHorizontalStrut(30));
				
			b.add(Box.createVerticalStrut(10));	
			b.add(b1 = Box.createVerticalBox());
			b1.add(b2 = Box.createHorizontalBox());
				JLabel label = new JLabel("Mã dịch vụ:");
				label.setFont(new Font("Times New Roman", Font.PLAIN, 18));
				b2.add(label);
				b2.add(Box.createHorizontalStrut(28));
				tfMaDV.setFont(new Font("Times New Roman", Font.PLAIN, 18));
				b2.add(tfMaDV);
				tfMaDV.setEditable(false);
		
			b1.add(Box.createVerticalStrut(10));	
			b1.add(b2 = Box.createHorizontalBox());
				label = new JLabel("Loại dịch vụ:");
				label.setFont(new Font("Times New Roman", Font.PLAIN, 18));
				b2.add(label);
				b2.add(Box.createHorizontalStrut(20));
				loaiDV.setFont(new Font("Times New Roman", Font.PLAIN, 18));
				b2.add(loaiDV);
				
			b1.add(Box.createVerticalStrut(10));	
			b1.add(b2 = Box.createHorizontalBox());
				label = new JLabel("Tên dịch vụ:");
				label.setFont(new Font("Times New Roman", Font.PLAIN, 18));
				b2.add(label);
				b2.add(Box.createHorizontalStrut(25));
				tfTenDV.setFont(new Font("Times New Roman", Font.PLAIN, 18));
				b2.add(tfTenDV);
			
			b1.add(Box.createVerticalStrut(10));	
			b1.add(b2 = Box.createHorizontalBox());
				label = new JLabel("Giá dịch vụ:");
				label.setFont(new Font("Times New Roman", Font.PLAIN, 18));
				b2.add(label);
				b2.add(Box.createHorizontalStrut(27));
				tfGiaDV.setFont(new Font("Times New Roman", Font.PLAIN, 18));
				b2.add(tfGiaDV);
				
			b1.add(Box.createVerticalStrut(10));	
			b1.add(b2 = Box.createHorizontalBox());
				label = new JLabel("Số lượng dịch vụ:");
				label.setFont(new Font("Times New Roman", Font.PLAIN, 18));
				b2.add(label);
				b2.add(Box.createHorizontalStrut(45));
				int value = 0;
				if(!action.equalsIgnoreCase("add"))
					value = dichvu.getSoluong();
				spinner.setModel(new SpinnerNumberModel(value, 0, 999999, 1));
				spinner.setFont(new Font("Times New Roman", Font.PLAIN, 18));
				b2.add(spinner);
				
			b1.add(Box.createVerticalStrut(30));	
			b1.add(b2 = Box.createHorizontalBox());
				if(action.equalsIgnoreCase("add")) {
					JButton btnclear = new JButton("clear");
					btnclear.setIcon(new ImageIcon(UIDichvu.class.getResource("/images/clear.png")));
					btnclear.setFont(new Font("Times New Roman", Font.BOLD, 20));
					b2.add(btnclear);
					b2.add(Box.createHorizontalGlue());
					JButton btnThem = new JButton("Thêm");
					btnThem.setFont(new Font("Times New Roman", Font.BOLD, 20));
					btnThem.setIcon(new ImageIcon(UIDichvu.class.getResource("/images/business-management-icon.png")));
					btnThem.setHorizontalTextPosition(SwingConstants.LEADING);
					btnThem.setHorizontalAlignment(SwingConstants.LEADING);
					b2.add(btnThem);
					btnThem.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							if(isValidDataDV() && JOptionPane.showConfirmDialog(null,
									"Thêm dịch vụ?", "Thêm", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
								them();
						}
					});
					updateMaDV();
				}else {
					JButton btnThoat = new JButton("Thoát");
					btnThoat.setIcon(new ImageIcon(UIDichvu.class.getResource("/images/back.png")));
					btnThoat.setFont(new Font("Times New Roman", Font.BOLD, 20));
					b2.add(btnThoat);
					btnThoat.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							if(JOptionPane.showConfirmDialog(null,
									"Bạn có thoát?", "Thoát", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
								dispose();
						}
					});
					b2.add(Box.createHorizontalGlue());
					if(action.equalsIgnoreCase("edit")) {
						JButton btnSua = new JButton("Sửa");
						btnSua.setFont(new Font("Times New Roman", Font.BOLD, 20));
						btnSua.setIcon(new ImageIcon(UIDichvu.class.getResource("/images/add-service.png")));
						btnSua.setHorizontalTextPosition(SwingConstants.LEADING);
						btnSua.setHorizontalAlignment(SwingConstants.LEADING);
						b2.add(btnSua);
						btnSua.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								if(isValidDataDV() && JOptionPane.showConfirmDialog(null,
										"Sửa dịch vụ?", "Sửa", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
									sua();
							}
						});
					}
					else {
						JButton btnXoa = new JButton("Xóa");
						btnXoa.setFont(new Font("Times New Roman", Font.BOLD, 20));
						btnXoa.setIcon(new ImageIcon(UIDichvu.class.getResource("/images/remove-service.png")));
						btnXoa.setHorizontalTextPosition(SwingConstants.LEADING);
						btnXoa.setHorizontalAlignment(SwingConstants.LEADING);
						b2.add(btnXoa);
						btnXoa.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								if(isValidDataDV() && JOptionPane.showConfirmDialog(null,
										"Xóa dịch vụ?", "Xóa", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
									xoa();
							}
						});
					}
				}
		}
		
		public void them() {
			Dichvu dichvu = new Dichvu(tfMaDV.getText().trim(),
					tfTenDV.getText().trim(),
					loaiDichvuDAO.timTheotenLDV(loaiDV.getSelectedItem().toString()),
					Double.parseDouble(tfGiaDV.getText().trim()),
					Integer.parseInt(spinner.getValue().toString()));
			if(dichvuDAO.themDichvu(dichvu)) {
				JOptionPane.showMessageDialog(null, "Thêm dịch vụ thành công", "Thông báo", 1);
				dispose();
				displayDSdichvu();
			}else {
				JOptionPane.showMessageDialog(null, "Thêm dịch vụ thất bại", "Thông báo", 1);
			}
		}
		
		public void sua() {
			Dichvu dichvu = new Dichvu(tfMaDV.getText().trim(),
					tfTenDV.getText().trim(),
					loaiDichvuDAO.timTheotenLDV(loaiDV.getSelectedItem().toString()),
					Double.parseDouble(tfGiaDV.getText().trim()),
					Integer.parseInt(spinner.getValue().toString()));
			if(dichvuDAO.suaDichvu(dichvu)) {
				JOptionPane.showMessageDialog(null, "Sửa dịch vụ thành công", "Thông báo", 1);
				dispose();
				displayDSdichvu();
			}else {
				JOptionPane.showMessageDialog(null, "Sửa dịch vụ thất bại", "Thông báo", 1);
			}
		}
		
		public void xoa() {
			if(dichvuDAO.xoaDichvu(tfMaDV.getText().trim())) {
				JOptionPane.showMessageDialog(null, "Xóa dịch vụ thành công", "Thông báo", 1);
				dispose();
				displayDSdichvu();
			}else {
				JOptionPane.showMessageDialog(null, "Xóa dịch vụ thất bại", "Thông báo", 1);
			}
		}
		
		public boolean isValidDataDV() {
			if(tfTenDV.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Tên dịch vụ không được để trống!!", "Thông báo", 1);
				return false;
			}
			if(tfGiaDV.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Giá dịch vụ không được để trống!!", "Thông báo", 1);
				return false;
			}
			try {
			     if(Double.parseDouble(tfGiaDV.getText().trim()) < 0) {
			    	 JOptionPane.showMessageDialog(null, "Giá dịch vụ phải lớn hơn 0!!", "Thông báo", 1);
			    	 return false;
			     }
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Giá dịch vụ phải là số thực!!", "Thông báo", 1);
				return false;
			}
			try {
			     if(Integer.parseInt(spinner.getValue().toString()) < 0) {
			    	 JOptionPane.showMessageDialog(null, "Số lượng phải lớn hơn 0!!", "Thông báo", 1);
			    	 return false;
			     }
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Số lượng phải là số nguyên!!", "Thông báo", 1);
				return false;
			}
			return true;
		}
		
		public void updateMaDV() {
			String item = loaiDV.getSelectedItem().toString();
			int value = 0;
			for (Dichvu dv : dichvuDAO.getDSDichvu()) {
				if(dv.getLoaiDichvu().getTenLDV().equalsIgnoreCase(item)) {
					value++;
				}
			}
			item = loaiDichvuDAO.timTheotenLDV(item).getMaLDV();
			do {
				value++;
				item = String.format("%s%03d", item, value);
			}while(dichvuDAO.timDichvu(item) != null);
			tfMaDV.setText(item);
		}
	}
	
	public class UIPhieuDichvu extends JDialog {
		private JTextField tfPhong = new JTextField();
		private JTextField tfTienNhan = new JTextField();
		private JRadioButton rbTructiep = new JRadioButton("Trực tiếp");
		private JRadioButton rdbtnTrSau = new JRadioButton("Trả sau");
		private JLabel lblTienTra = new JLabel();
		private JLabel war = new JLabel();
		private JLabel warr = new JLabel();
		private JButton btnLuuPDV = new JButton("Thanh toán");
		private Phong phong;
		
		public UIPhieuDichvu() {
			super(new JFrame(), "Phiếu dịch vụ", true);
			setBounds(0, 0, 390, 650);
			setLocationRelativeTo(null);
			getContentPane().setLayout(new BorderLayout());
			getContentPane().setBackground(Color.WHITE);
			getContentPane().setLayout(null);
			KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
				
				@Override
				public boolean dispatchKeyEvent(KeyEvent e) {
					switch (e.getID()) {
					  case KeyEvent.KEY_PRESSED:
	                        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
	                            dispose();
	                        }
	                        break;
					}
					return false;
				}
			});
			
			JLabel lblMPhiuDch = new JLabel("Mã phiếu dịch vụ:");
			lblMPhiuDch.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			lblMPhiuDch.setBounds(10, 25, 139, 21);
			add(lblMPhiuDch);
			
			JLabel lblMaPhieuDV = new JLabel();
			lblMaPhieuDV.setText(phieuDichvu.getMaPhieuDV());
			lblMaPhieuDV.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			lblMaPhieuDV.setBounds(159, 25, 160, 21);
			add(lblMaPhieuDV);
			
			JLabel lblNgyLp = new JLabel("Ngày lập:");
			lblNgyLp.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			lblNgyLp.setBounds(10, 57, 81, 21);
			add(lblNgyLp);
			
			JLabel lblNgayLap = new JLabel();
			String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm"));
			lblNgayLap.setText(date);
			lblNgayLap.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			lblNgayLap.setBounds(101, 57, 218, 21);
			add(lblNgayLap);
			
			JLabel lblNhnVin = new JLabel("Nhân viên:");
			lblNhnVin.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			lblNhnVin.setBounds(10, 89, 81, 21);
			add(lblNhnVin);
			
			JLabel lblTenNV = new JLabel();
			lblTenNV.setText(nhanVien.getTenNV());
			lblTenNV.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			lblTenNV.setBounds(101, 89, 218, 21);
			add(lblTenNV);
			
			JLabel lblHnhThcThanh = new JLabel("Hình thức thanh toán:");
			lblHnhThcThanh.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			lblHnhThcThanh.setBounds(10, 121, 192, 21);
			add(lblHnhThcThanh);
			
			rbTructiep.setBackground(Color.WHITE);
			rbTructiep.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			rbTructiep.setBounds(39, 149, 109, 23);
			add(rbTructiep);
			rbTructiep.setSelected(true);
			rbTructiep.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					rdbtnTrSau.setSelected(false);
					tfPhong.setEditable(false);
					tfTienNhan.setEditable(true);
				}
			});
			
			rdbtnTrSau.setBackground(Color.WHITE);
			rdbtnTrSau.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			rdbtnTrSau.setBounds(192, 149, 109, 23);
			add(rdbtnTrSau);
			rdbtnTrSau.setSelected(false);
			rdbtnTrSau.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					rbTructiep.setSelected(false);
					tfPhong.setEditable(true);
					tfTienNhan.setEditable(false);
				}
			});
			
			JLabel lblPhng = new JLabel("Phòng:");
			lblPhng.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			lblPhng.setBounds(10, 179, 56, 21);
			add(lblPhng);
			
			tfPhong.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			tfPhong.setBounds(76, 181, 75, 20);
			tfPhong.setEditable(false);
			add(tfPhong);
			tfPhong.setColumns(10);
			
			war.setFont(new Font("Times New Roman", Font.ITALIC, 13));
			war.setForeground(Color.RED);
			war.setBounds(76, 201, 130, 16);
			add(war);
			
			JLabel label = new JLabel("==================================================");
			label.setBounds(10, 212, 354, 14);
			add(label);
			
			JPanel Description = new JPanel();
			Description.setBackground(Color.WHITE);
			Description.setBounds(10, 225, 354, 225);
			Description.setLayout(new BorderLayout(0, 0));
			add(Description);
			Border border = BorderFactory.createLineBorder(Color.RED);
			TitledBorder titleBorder = new TitledBorder(border, "Mổ tả");
			titleBorder.setTitleFont(new Font("Times New Roman", Font.BOLD, 16));
			titleBorder.setTitleColor(Color.RED);
			Description.setBorder(titleBorder);
			
			JPanel panel_CTDV = new JPanel();
			
			panel_CTDV.setLayout(new GridLayout(0, 2, 100, 0));
			panel_CTDV.setBackground(Color.WHITE);
			JScrollPane scrollPane_CTDV = new JScrollPane(panel_CTDV,
					ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
					ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane_CTDV.getViewport().setBackground(Color.WHITE);
			Description.add(scrollPane_CTDV);
			List<ChitietPhieuDichvu> dsct = phieuDichvu.getDschitietPhieuDichvu();
			int index = 1;
			for (ChitietPhieuDichvu ctdv : dsct) {
				String dichvus = String.format("%d %s*%d", index++, ctdv.getDichvu().getTenDV(), ctdv.getSoluong());
				JLabel labelDV = new JLabel(dichvus);
				labelDV.setFont(new Font("Times New Roman", Font.PLAIN, 18));
				panel_CTDV.add(labelDV);
				JLabel lblThanhtien = new JLabel(format.format(ctdv.ThanhTien()));
				lblThanhtien.setFont(new Font("Times New Roman", Font.PLAIN, 18));
				panel_CTDV.add(lblThanhtien);
			}	
			if(dsct.size() < 9) for (int i = 0; i < 9-dsct.size(); i++) panel_CTDV.add(new JLabel());
		
			label = new JLabel("==================================================");
			label.setBounds(10, 451, 354, 14);
			add(label);
			
			JLabel lblTng = new JLabel("Tổng:");
			lblTng.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			lblTng.setBounds(10, 470, 50, 21);
			add(lblTng);
			
			JLabel lblTinNhn = new JLabel("Tiền nhận:");
			lblTinNhn.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			lblTinNhn.setBounds(10, 502, 81, 21);
			add(lblTinNhn);
			
			JLabel lblTinThi = new JLabel("Tiền trả:");
			lblTinThi.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			lblTinThi.setBounds(10, 534, 81, 21);
			add(lblTinThi);
			
			JLabel lbltong = new JLabel();
			lbltong.setHorizontalAlignment(SwingConstants.RIGHT);
			lbltong.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			lbltong.setBounds(211, 470, 153, 21);
			add(lbltong);
			lbltong.setText(format.format(phieuDichvu.ThanhTien()));
			
			lblTienTra.setHorizontalAlignment(SwingConstants.RIGHT);
			lblTienTra.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			lblTienTra.setBounds(211, 534, 153, 21);
			add(lblTienTra);
			
			JButton btnCancel = new JButton("Thoát");
			btnCancel.setIcon(new ImageIcon(UIPhieuDichvu.class.getResource("/images/cancel.png")));
			btnCancel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			btnCancel.setBounds(10, 580, 130, 28);
			add(btnCancel);
			btnCancel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					dispose();
				}
			});
			
			btnLuuPDV.setHorizontalTextPosition(SwingConstants.LEADING);
			btnLuuPDV.setHorizontalAlignment(SwingConstants.LEADING);
			btnLuuPDV.setIcon(new ImageIcon(UIPhieuDichvu.class.getResource("/images/icons8-arrow-64.png")));
			btnLuuPDV.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			btnLuuPDV.setBounds(234, 580, 130, 28);
			add(btnLuuPDV);
			btnLuuPDV.setEnabled(false);
			btnLuuPDV.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(JOptionPane.showConfirmDialog(null,
							"Bạn có muốn lập phiếu dịch vụ?", "Lập phiếu dịch vụ", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						LapPhieuDichvu();
					}
				}});
			
			tfTienNhan.setHorizontalAlignment(SwingConstants.RIGHT);
			tfTienNhan.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			tfTienNhan.setColumns(10);
			tfTienNhan.setBounds(234, 502, 130, 20);
			lblTienTra.setText(format.format(0));
			add(tfTienNhan);
			
			warr.setFont(new Font("Times New Roman", Font.ITALIC, 13));
			warr.setForeground(Color.RED);
			warr.setBounds(234, 522, 300, 16);
			add(warr);
			
			tfPhong.getDocument().addDocumentListener(new DocumentListener() {
				
				@Override
				public void removeUpdate(DocumentEvent e) {
					checktfPhong();
				}
				
				@Override
				public void insertUpdate(DocumentEvent e) {
					checktfPhong();
				}
				
				@Override
				public void changedUpdate(DocumentEvent e) {
					checktfPhong();
				}
			});
			
			tfTienNhan.getDocument().addDocumentListener(new DocumentListener() {
				
				@Override
				public void removeUpdate(DocumentEvent e) {
					checktfTienNhan();
				}
				
				@Override
				public void insertUpdate(DocumentEvent e) {
					checktfTienNhan();
				}
				
				@Override
				public void changedUpdate(DocumentEvent e) {
					checktfTienNhan();
				}
			});
		}
		
		public void checktfPhong() {
			if(tfPhong.getText().trim().isEmpty()) {
				war.setText("*Không được để trống");
				btnLuuPDV.setEnabled(false);
			}else {
				boolean isInteger = tfPhong.getText().trim().matches("\\d+");
				if(!isInteger) {
					war.setText("*Chỉ nhập chữ số");
				}else {
					if(tfPhong.getText().length() < 3) {
						war.setText("*Số phòng phải đủ 3 chữ số");
						btnLuuPDV.setEnabled(false);
					}else if(tfPhong.getText().length() > 3) {
						war.setText("*Số phòng không quá 3 chữ số");
						btnLuuPDV.setEnabled(false);
					}else {
						war.setText("");
						phong = phongDAO.timPhong("P"+tfPhong.getText().trim());
						if(phong == null) {
							war.setText("*Phòng không tồn tại");
							btnLuuPDV.setEnabled(false);
						}else if(!phong.getTinhtrangPhong().equalsIgnoreCase("Đang thuê")) {
							war.setText("*Phòng đang trống");
							btnLuuPDV.setEnabled(false);
						}else {
							btnLuuPDV.setEnabled(true);
						}
					}
				}
			}
		}
		
		public void checktfTienNhan() {
			if(tfTienNhan.getText().trim().isEmpty()) {
				warr.setText("*Không được để trống");
				btnLuuPDV.setEnabled(false);
			}else {
				boolean isInteger = tfTienNhan.getText().trim().matches("\\d+");
				if(!isInteger) {
					warr.setText("*Chỉ nhập chữ số");
				}else {
					warr.setText("");
					if(Double.parseDouble(tfTienNhan.getText().trim()) >= phieuDichvu.ThanhTien()) {
						lblTienTra.setText(format.format(Double.parseDouble(tfTienNhan.getText().trim()) - phieuDichvu.ThanhTien()));
						btnLuuPDV.setEnabled(true);
					}else {
						lblTienTra.setText(format.format(0));
						btnLuuPDV.setEnabled(false);
					}
				}
			}
		}
		
		public void LapPhieuDichvu() {
			phieuDichvu.setNgaylap(LocalDateTime.now());
			for (ChitietPhieuDichvu chitietPhieuDichvu : phieuDichvu.getDschitietPhieuDichvu()) {
				chitietdichvuDAO.themChitietDichvu(chitietPhieuDichvu);
				Dichvu dv = chitietPhieuDichvu.getDichvu();
				dv.setSoluong(dichvuDAO.timDichvu(dv.getMaDV()).getSoluong() - chitietPhieuDichvu.getSoluong());
				dichvuDAO.suaDichvu(dv);
			}
			if(phieuDichvuDAO.themPhieuDichvu(phieuDichvu)) {
				if(rdbtnTrSau.isSelected()) {
					Hoadon hoadon = hoadonDAO.timHoadonPhongDangThue(phong.getMaPhong());
					List<ChitietHoadon> chitietHoadons = hoadon.getChitietHoadons();
					ChitietHoadon chitietHoadon = null;
					for (ChitietHoadon cthd : chitietHoadons) {
						if(cthd.getPhong().getMaPhong().equals(phong.getMaPhong())) {
							chitietHoadon = cthd;
							break;
						}
					}
					List<PhieuDichvu> phieuDichvus = chitietHoadon.getPhieuDichvus();
					phieuDichvus.add(phieuDichvu);
					chitietHoadon.setPhieuDichvus(phieuDichvus);
					
					
					int index = chitietHoadons.indexOf(chitietHoadon);
					chitietHoadons.remove(index);
					chitietHoadons.add(index, chitietHoadon);
					
					hoadon.setChitietHoadons(chitietHoadons);
					if(!(chitietHoadonDAO.suaChitietHoadon(chitietHoadon) && hoadonDAO.suaHoadon(hoadon))) {
						JOptionPane.showMessageDialog(null, "Lập phiếu dịch vụ thất bại!!");
					}
				}
				phieuDichvu = null;
				for (int i = 0; i < 4; i++)
					spinners[i].setValue(0);
				while(dfmodelCTHD.getRowCount() > 0)
					dfmodelCTHD.removeRow(0);
				btLaphoadon.setEnabled(false);
				lbtotal.setText(format.format(0));
				JOptionPane.showMessageDialog(null, "Lập phiếu dịch vụ thành công!!");
				dispose();
			}else {
				JOptionPane.showMessageDialog(null, "Lập phiếu dịch vụ thất bại!!");
			}
		}
	}
	
	public void updateTableKhachHang(){
		while(dfmodelDSKH.getRowCount() > 0)
			dfmodelDSKH.removeRow(0);
		for (KhachHang khachhang : khachhangDAO.getDSKhachHang()) {
			dfmodelDSKH.addRow(new Object[] {
					khachhang.getMaKH(), khachhang.getTenKH(), khachhang.getLoaiKH(),
					khachhang.getSoCMD(), khachhang.getNgaySinh(), khachhang.getSoDT(),
					(khachhang.getDiaChi().getTinh().equals("TP HCM") || khachhang.getDiaChi().getTinh().equals("Hà Nội")) ?
					String.format("%s %s, P.%s, Q.%s, %s", khachhang.getDiaChi().getSoNha(), khachhang.getDiaChi().getDuong(),
					khachhang.getDiaChi().getPhuong(), khachhang.getDiaChi().getQuan(), khachhang.getDiaChi().getTinh()) :
					String.format("%s %s, P.%s, TP.%s, T.%s", khachhang.getDiaChi().getSoNha(), khachhang.getDiaChi().getDuong(),
					khachhang.getDiaChi().getPhuong(), khachhang.getDiaChi().getQuan(), khachhang.getDiaChi().getTinh())	
			});
		}
		tableDSKhachhang.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
					int row, int column) {
				final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				c.setBackground(row % 2 == 1 ? Color.LIGHT_GRAY : Color.WHITE);
				c.setForeground(Color.BLACK);
				return c;
			}
		});
	}
	
	public class UIKhachhang extends JDialog {
		private Date today = new Date();
		private JTextField tfMaKH = new JTextField();
		private JTextField tfTinh = new JTextField();
		private JTextField tfQuan = new JTextField();
		private JTextField tfPhuong = new JTextField();
		private JTextField tfDuong = new JTextField();
		private JTextField tfSonha = new JTextField();
		private JTextField tfHoten = new JTextField();
		private JTextField tfSoDT = new JTextField();
		private JTextField tfSoCMND = new JTextField();
		private JDateChooser ngaysinh = new JDateChooser();
		private String[] loaiKH = new String[] {"Vãn lai", "Thường", "VIP"};
		private DefaultComboBoxModel<String> dfLoaiKH = new DefaultComboBoxModel<String>(loaiKH);
		private JComboBox<String> cb_LoaiKH = new JComboBox<String>(dfLoaiKH);
		private List<KhachHang> dsKH = khachhangDAO.getDSKhachHang();
		private String maKH;
		private boolean clear = false;
		private KhachHang khachHang;
		
		public UIKhachhang(KhachHang khachHang, String action) {
			super(new JFrame(), "Thông tin khách hàng", true);
			setBounds(0, 0, 360, 495);
			setResizable(false);
			setLocationRelativeTo(null);
			getContentPane().setBackground(Color.WHITE);
			getContentPane().setLayout(null);
			this.khachHang = khachHang;
			KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
				
				@Override
				public boolean dispatchKeyEvent(KeyEvent e) {
					switch (e.getID()) {
					  case KeyEvent.KEY_PRESSED:
	                        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
	                            dispose();
	                        }
	                        break;
					}
					return false;
				}
			});

			int valueMaKH = dsKH.size();
			do {
				valueMaKH++;
				maKH = String.format("KH%03d", valueMaKH);
			}while(khachhangDAO.timKhachHang(maKH) != null);
			
			JPanel panel_thongtinKH = new JPanel();
			panel_thongtinKH.setBackground(Color.WHITE); 
			panel_thongtinKH.setBounds(0, 0, 360, 465);
			getContentPane().add(panel_thongtinKH);
			panel_thongtinKH.setLayout(null);
			
			JLabel lblMaKH = new JLabel("Mã KH:");
			lblMaKH.setFont(new Font("Times New Roman", Font.BOLD, 18));
			lblMaKH.setBounds(10, 10, 103, 25);
			panel_thongtinKH.add(lblMaKH);
			
			tfMaKH = new JTextField();
			tfMaKH.setFont(new Font("Times New Roman", Font.BOLD, 18));
			tfMaKH.setColumns(10);
			tfMaKH.setEditable(false);
			tfMaKH.setText(maKH);
			tfMaKH.setBounds(116, 10, 221, 25);
			panel_thongtinKH.add(tfMaKH);

			JLabel lblHoTen = new JLabel("Họ tên:");
			lblHoTen.setFont(new Font("Times New Roman", Font.BOLD, 18));
			lblHoTen.setBounds(10, 47, 103, 25);
			lblHoTen.requestFocus();
			panel_thongtinKH.add(lblHoTen);

			JLabel lblSCmnd = new JLabel("số ĐT:");
			lblSCmnd.setFont(new Font("Times New Roman", Font.BOLD,18));
			lblSCmnd.setBounds(10, 83, 103, 25);
			panel_thongtinKH.add(lblSCmnd);

			JLabel lblSCmnd_1 = new JLabel("Số CMND:");
			lblSCmnd_1.setFont(new Font("Times New Roman", Font.BOLD,18));
			lblSCmnd_1.setBounds(10, 119, 103, 25);
			panel_thongtinKH.add(lblSCmnd_1);

			JLabel lblNgySinh = new JLabel("Ngày sinh:");
			lblNgySinh.setFont(new Font("Times New Roman", Font.BOLD, 18));
			lblNgySinh.setBounds(10, 155, 103, 25);
			panel_thongtinKH.add(lblNgySinh);

			JPanel panel_Diachi = new JPanel();
			panel_Diachi.setBackground(Color.WHITE);
			panel_Diachi.setBounds(10, 225, 336, 197);
			Border border = BorderFactory.createLineBorder(Color.RED);
			TitledBorder titleBorder = new TitledBorder(border, "Địa chỉ");
			titleBorder.setTitleFont(new Font("Times New Roman", Font.ITALIC, 16));
			titleBorder.setTitleColor(Color.RED);
			panel_Diachi.setBorder(titleBorder);
			panel_thongtinKH.add(panel_Diachi);
			panel_Diachi.setLayout(null);

			JLabel lblTnhtp = new JLabel("Tỉnh/TP:");
			lblTnhtp.setBounds(10, 21, 85, 24);
			lblTnhtp.setFont(new Font("Times New Roman", Font.BOLD, 18));
			panel_Diachi.add(lblTnhtp);

			JLabel lblQun = new JLabel("Quận/Huyện:");
			lblQun.setFont(new Font("Times New Roman", Font.BOLD, 18));
			lblQun.setBounds(10, 56, 85, 24);
			panel_Diachi.add(lblQun);

			JLabel lblPhng = new JLabel("Phường:");
			lblPhng.setFont(new Font("Times New Roman", Font.BOLD, 18));
			lblPhng.setBounds(10, 91, 85, 24);
			panel_Diachi.add(lblPhng);

			JLabel lblng = new JLabel("Đường:");
			lblng.setFont(new Font("Times New Roman", Font.BOLD, 18));
			lblng.setBounds(10, 126, 85, 24);
			panel_Diachi.add(lblng);

			JLabel lblSNh = new JLabel("Số nhà:");
			lblSNh.setFont(new Font("Times New Roman", Font.BOLD, 18));
			lblSNh.setBounds(10, 161, 85, 24);
			panel_Diachi.add(lblSNh);


			tfTinh.setFont(new Font("Times New Roman", Font.BOLD, 18));
			tfTinh.setColumns(10);
			tfTinh.setBounds(105, 21, 221, 25);
			panel_Diachi.add(tfTinh);

			tfQuan.setFont(new Font("Times New Roman", Font.BOLD, 18));
			tfQuan.setColumns(10);
			tfQuan.setBounds(105, 56, 221, 25);
			panel_Diachi.add(tfQuan);

			tfPhuong.setFont(new Font("Times New Roman", Font.BOLD, 18));
			tfPhuong.setColumns(10);
			tfPhuong.setBounds(105, 91, 221, 25);
			panel_Diachi.add(tfPhuong);

			tfDuong.setFont(new Font("Times New Roman", Font.BOLD, 18));
			tfDuong.setColumns(10);
			tfDuong.setBounds(105, 126, 221, 25);
			panel_Diachi.add(tfDuong);

			tfSonha.setFont(new Font("Times New Roman", Font.BOLD, 18));
			tfSonha.setColumns(10);
			tfSonha.setBounds(105, 161, 221, 25);
			panel_Diachi.add(tfSonha);

			JLabel lblLoiKh = new JLabel("Loại KH:");
			lblLoiKh.setFont(new Font("Times New Roman", Font.BOLD, 18));
			lblLoiKh.setBounds(10, 191, 103, 25);
			panel_thongtinKH.add(lblLoiKh);

			tfHoten.setFont(new Font("Times New Roman", Font.BOLD, 18));
			tfHoten.setBounds(116, 46, 221, 25);
			panel_thongtinKH.add(tfHoten);
			tfHoten.setColumns(10);

			tfSoDT.setFont(new Font("Times New Roman", Font.BOLD, 18));
			tfSoDT.setColumns(10);
			tfSoDT.setBounds(116, 83, 221, 25);
			panel_thongtinKH.add(tfSoDT);

			tfSoCMND.setFont(new Font("Times New Roman", Font.BOLD, 18));
			tfSoCMND.setColumns(10);
			tfSoCMND.setBounds(116, 119, 221, 25);
			panel_thongtinKH.add(tfSoCMND);
			
			cb_LoaiKH.setFont(new Font("Times New Roman", Font.BOLD, 18));
			cb_LoaiKH.setBounds(116, 155, 103, 22);
			panel_thongtinKH.add(cb_LoaiKH);

			ngaysinh.getSpinner().setFont(new Font("Times New Roman", Font.BOLD, 18));
			ngaysinh.setDateFormatString("dd/MM/yyyy");
			ngaysinh.setBounds(116, 191, 221, 21);
			ngaysinh.getSpinner().addChangeListener(new ChangeListener() {
				@SuppressWarnings("deprecation")
				@Override
				public void stateChanged(ChangeEvent e) {
					if(today.getYear() - ngaysinh.getDate().getYear() < 16 && !clear) {
						JOptionPane.showMessageDialog(null, "Khách hàng phải lớn hơn 15 tuổi!!", "Thông báo", 1);
					}
				}
			});
			panel_thongtinKH.add(ngaysinh);

			JButton btnclear = new JButton("clear");
			btnclear.setBounds(10, 433, 89, 25);
			panel_thongtinKH.add(btnclear);
			btnclear.setIcon(new ImageIcon(UIKhachhang.class.getResource("/images/clear.png")));
			btnclear.setFont(new Font("Times New Roman", Font.BOLD, 20));
			btnclear.addMouseListener(new MouseAdapter () {

				@Override
				public void mouseClicked(MouseEvent e) {
					clear = true;
					tfHoten.setText("");
					tfHoten.requestFocus();
					tfSoDT.setText("");
					tfSoCMND.setText("");
					ngaysinh.setDate(new Date());
					dfLoaiKH.setSelectedItem(loaiKH[0]);
					tfTinh.setText("");
					tfQuan.setText("");
					tfPhuong.setText("");
					tfDuong.setText("");
					tfSonha.setText("");
					clear = false;
				}
			});
			
			if(action.equalsIgnoreCase("add")) {
				JButton btnThem = new JButton("Thêm");
				btnThem.setIcon(new ImageIcon(UIKhachhang.class.getResource("/images/add_customer.png")));
				btnThem.setHorizontalTextPosition(SwingConstants.LEADING);
				btnThem.setHorizontalAlignment(SwingConstants.LEADING);
				btnThem.setFont(new Font("Times New Roman", Font.BOLD, 20));
				btnThem.setBounds(257, 433, 89, 25);
				panel_thongtinKH.add(btnThem);
				btnThem.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if(isValidDataKH() && JOptionPane.showConfirmDialog(null,
								"Bạn có muốn thêm khách hàng?", "Thêm Khách hàng", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
							them();
						}
					}
				});
			}else {
				maKH = khachHang.getMaKH();
				tfMaKH.setText(maKH);
				tfHoten.setText(khachHang.getTenKH());
				tfHoten.requestFocus();
				tfSoDT.setText(khachHang.getSoDT());
				tfSoCMND.setText(khachHang.getSoCMD());
				ngaysinh.setDate(java.sql.Date.valueOf(khachHang.getNgaySinh()));
				dfLoaiKH.setSelectedItem(khachHang.getLoaiKH());
				tfTinh.setText(khachHang.getDiaChi().getTinh());
				tfQuan.setText(khachHang.getDiaChi().getQuan());
				tfPhuong.setText(khachHang.getDiaChi().getPhuong());
				tfDuong.setText(khachHang.getDiaChi().getDuong());
				tfSonha.setText(khachHang.getDiaChi().getSoNha());
				
				if(action.equalsIgnoreCase("edit")) {
					JButton btnSua = new JButton("Sửa");
					btnSua.setIcon(new ImageIcon(UIKhachhang.class.getResource("/images/edit_customer.png")));
					btnSua.setHorizontalTextPosition(SwingConstants.LEADING);
					btnSua.setHorizontalAlignment(SwingConstants.LEADING);
					btnSua.setFont(new Font("Times New Roman", Font.BOLD, 20));
					btnSua.setBounds(257, 433, 89, 25);
					panel_thongtinKH.add(btnSua);
					btnSua.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							if(isValidDataKH() && JOptionPane.showConfirmDialog(null,
									"Bạn có muốn sửa khách hàng?", "Sửa Khách hàng", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
								sua();
							}
						}
					});
				}else {
					JButton btnXoa = new JButton("Xóa");
					btnXoa.setIcon(new ImageIcon(UIKhachhang.class.getResource("/images/remove_customer.png")));
					btnXoa.setHorizontalTextPosition(SwingConstants.LEADING);
					btnXoa.setHorizontalAlignment(SwingConstants.LEADING);
					btnXoa.setFont(new Font("Times New Roman", Font.BOLD, 20));
					btnXoa.setBounds(257, 433, 89, 25);
					panel_thongtinKH.add(btnXoa);
					btnXoa.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							if(JOptionPane.showConfirmDialog(null,
									"Bạn có muốn xóa khách hàng?", "Xóa Khách hàng", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
								xoa();
							}
						}
					});
				}
			}
		}
		
		public void them() {
			khachHang = khachhangDAO.timKhachHang(tfHoten.getText().trim(), tfSoDT.getText().trim());
			if(khachHang == null) {
				khachHang = new KhachHang();
				khachHang.setMaKH(maKH);
				khachHang.setTenKH(tfHoten.getText().trim());
				khachHang.setSoDT(tfSoDT.getText().trim());
				khachHang.setSoCMD(tfSoCMND.getText().trim());
				khachHang.setNgaySinh(convertToLocalDateViaInstant(ngaysinh.getDate()));
				khachHang.setLoaiKH(dfLoaiKH.getSelectedItem().toString());

				DiaChi diaChi = new DiaChi();
				diaChi.setTinh(tfTinh.getText().trim());
				diaChi.setQuan(tfQuan.getText().trim());
				diaChi.setPhuong(tfPhuong.getText().trim());
				diaChi.setDuong(tfDuong.getText().trim());
				diaChi.setSoNha(tfSonha.getText().trim());
				diaChi.setMaDC(getAlphaString(10));
				khachHang.setDiaChi(diaChi);
				
				if(diachiDAO.themDiachi(diaChi) && khachhangDAO.themKhachHang(khachHang)) {
					updateTableKhachHang();
					JOptionPane.showMessageDialog(null, "Thêm khách hàng thành công!!");
					dispose();
				}else {
					diachiDAO.xoaDiachi(diaChi.getMaDC());
					JOptionPane.showMessageDialog(null, "Thêm khách hàng không thành công!!");
				}
			}else {
				JOptionPane.showMessageDialog(null, "Khách hàng trùng!!");
			}
		}
		
		public void sua() {
			khachHang.setTenKH(tfHoten.getText().trim());
			khachHang.setSoDT(tfSoDT.getText().trim());
			khachHang.setSoCMD(tfSoCMND.getText().trim());
			khachHang.setNgaySinh(convertToLocalDateViaInstant(ngaysinh.getDate()));
			khachHang.setLoaiKH(dfLoaiKH.getSelectedItem().toString());

			DiaChi diaChi = new DiaChi();
			diaChi.setTinh(tfTinh.getText().trim());
			diaChi.setQuan(tfQuan.getText().trim());
			diaChi.setPhuong(tfPhuong.getText().trim());
			diaChi.setDuong(tfDuong.getText().trim());
			diaChi.setSoNha(tfSonha.getText().trim());
			diaChi.setMaDC(khachHang.getDiaChi().getMaDC());
			khachHang.setDiaChi(diaChi);
			
			if(diachiDAO.suaDiachi(diaChi) && khachhangDAO.suaKhachHang(khachHang)) {
				updateTableKhachHang();
				JOptionPane.showMessageDialog(null, "Sửa khách hàng thành công!!");
				dispose();
			}else {
				diachiDAO.xoaDiachi(diaChi.getMaDC());
				JOptionPane.showMessageDialog(null, "Sửa khách hàng không thành công!!");
			}
		}
		
		public void xoa() {
			if(	diachiDAO.xoaDiachi(khachHang.getDiaChi().getMaDC()) && khachhangDAO.xoaKhachHang(khachHang.getMaKH())) {
				updateTableKhachHang();
				JOptionPane.showMessageDialog(null, "Xóa khách hàng thành công!!");
				dispose();
			}else {
				JOptionPane.showMessageDialog(null, "Xóa khách hàng không thành công!!");
			}
		}
		
		@SuppressWarnings("deprecation")
		public boolean isValidDataKH() {
			if(tfHoten.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Tên KH không được để trống!!", "Thông báo", 1);
				return false;
			}
			if(!tfSoDT.getText().trim().matches("[0-9]{9,12}")) {
				JOptionPane.showMessageDialog(null, "Số điện thoại không được để trống 9-12 chứ số!!", "Thông báo", 1);
				return false;	
			}
			if(!tfSoCMND.getText().trim().matches("[0-9]{9}")) {
				JOptionPane.showMessageDialog(null, "Số cmnd không được để trốngĐầy đủ 9 kí tự số!!", "Thông báo", 1);
				return false;
			}
			if(today.getYear() - ngaysinh.getDate().getYear() < 16) {
				JOptionPane.showMessageDialog(null, "Khách hàng phải lớn hơn 15 tuổi!!", "Thông báo", 1);
				return false;
			}
			if(tfTinh.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Tỉnh TP không được để trống", "Thông báo", 1);
				return false;
			}
			if(tfQuan.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Quận không được để trống", "Thông báo", 1);
				return false;
			}
			if(tfPhuong.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Phường không được để trống", "Thông báo", 1);
				return false;
			}
			if(tfDuong.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Đường không được để trống", "Thông báo", 1);
				return false;
			}
			if(tfSonha.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Số nhà không được để trống", "Thông báo", 1);
				return false;
			}
			return true;
		}
	}
	
	public void updateTableNhanvien(){
		while(dfmodelDSNV.getRowCount() > 0)
			dfmodelDSNV.removeRow(0);
		for (NhanVien nhanVien : nhanVienDAO.getDSNV()) {
			dfmodelDSNV.addRow(new Object[] {
					nhanVien.getMaNV(), nhanVien.getTenNV(), nhanVien.getChuVu(), nhanVien.getTaiKhoan().getTenTK(),
					nhanVien.getEmail(), nhanVien.getSoCMND(), nhanVien.getNgaySinh(), nhanVien.getSoDT(),
					(nhanVien.getDiaChi().getTinh().equals("TP HCM") || nhanVien.getDiaChi().getTinh().equals("Hà Nội")) ?
					String.format("%s %s, P.%s, Q.%s, %s", nhanVien.getDiaChi().getSoNha(), nhanVien.getDiaChi().getDuong(),
							nhanVien.getDiaChi().getPhuong(), nhanVien.getDiaChi().getQuan(), nhanVien.getDiaChi().getTinh()) :
					String.format("%s %s, P.%s, TP.%s, T.%s", nhanVien.getDiaChi().getSoNha(), nhanVien.getDiaChi().getDuong(),
							nhanVien.getDiaChi().getPhuong(), nhanVien.getDiaChi().getQuan(), nhanVien.getDiaChi().getTinh())	
			});
		}
		tableDSNhanvien.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
					int row, int column) {
				final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				c.setBackground(row % 2 == 1 ? Color.LIGHT_GRAY : Color.WHITE);
				c.setForeground(Color.BLACK);
				return c;
			}
		});
	}
	
	//Hiện thị from nhân viên
	public class UINhanvien extends JDialog{
		private Date today = new Date();
		private JTextField tfMaNV = new JTextField();
		private JTextField tfEmail = new JTextField();
		private JTextField tfTinh = new JTextField();
		private JTextField tfQuan = new JTextField();
		private JTextField tfPhuong = new JTextField();
		private JTextField tfDuong = new JTextField();
		private JTextField tfSonha = new JTextField();
		private JTextField tfHoten = new JTextField();
		private JTextField tfSoDT = new JTextField();
		private JTextField tfSoCMND = new JTextField();
		private JDateChooser ngaysinh = new JDateChooser();
		private String[] chucvu = new String[] {"Tiếp tân", "Quản lý"};
		private DefaultComboBoxModel<String> dfChucvu = new DefaultComboBoxModel<String>(chucvu);
		private JComboBox<String> cb_Chucvu = new JComboBox<String>(dfChucvu);
		private String maNV;
		private boolean clear = false;
		private List<NhanVien> dsnv = nhanVienDAO.getDSNV();
		private NhanVien nv;
		private JTextField tfTenTK;
		private JPasswordField passwordField;
		
		public UINhanvien(NhanVien nv, String action) {
			super(new JFrame(), "Thông tin nhân viên", true);
			setBounds(0, 0, 360, 620);
			setResizable(false);
			setLocationRelativeTo(null);
			getContentPane().setBackground(Color.WHITE);
			getContentPane().setLayout(null);
			this.nv = nv;
			KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
				
				@Override
				public boolean dispatchKeyEvent(KeyEvent e) {
					switch (e.getID()) {
					  case KeyEvent.KEY_PRESSED:
	                        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
	                            dispose();
	                        }
	                        break;
					}
					return false;
				}
			});
			
			JPanel panel_thongtinNV = new JPanel();
			panel_thongtinNV.setBackground(Color.WHITE); 
			panel_thongtinNV.setBounds(0, 0, 360, 595);
			add(panel_thongtinNV);
			panel_thongtinNV.setLayout(null);
			
			JLabel lblMaNV = new JLabel("Mã NV:");
			lblMaNV.setBounds(10, 10, 103, 25);
			lblMaNV.setFont(new Font("Times New Roman", Font.BOLD, 18));
			panel_thongtinNV.add(lblMaNV);
			
			tfMaNV = new JTextField();
			tfMaNV.setBounds(116, 10, 221, 25);
			tfMaNV.setFont(new Font("Times New Roman", Font.BOLD, 18));
			tfMaNV.setColumns(10);
			tfMaNV.setEditable(false);
			updateMaNV();
			panel_thongtinNV.add(tfMaNV);

			JLabel lblHoTen = new JLabel("Họ tên:");
			lblHoTen.setBounds(10, 47, 103, 25);
			lblHoTen.setFont(new Font("Times New Roman", Font.BOLD, 18));
			lblHoTen.requestFocus();
			panel_thongtinNV.add(lblHoTen);
			
			JLabel lblChucvu = new JLabel("Chức vụ:");
			lblChucvu.setBounds(10, 83, 103, 25);
			lblChucvu.setFont(new Font("Times New Roman", Font.BOLD, 18));
			panel_thongtinNV.add(lblChucvu);
			cb_Chucvu.setBounds(116, 83, 103, 22);

			cb_Chucvu.setFont(new Font("Times New Roman", Font.BOLD, 18));
			cb_Chucvu.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					updateMaNV();
				}
			});
			panel_thongtinNV.add(cb_Chucvu);
			
			JLabel lalemail = new JLabel("Email:");
			lalemail.setBounds(10, 119, 103, 25);
			lalemail.setFont(new Font("Times New Roman", Font.BOLD, 18));
			panel_thongtinNV.add(lalemail);
			
			tfEmail = new JTextField();
			tfEmail.setBounds(116, 119, 221, 25);
			tfEmail.setFont(new Font("Times New Roman", Font.BOLD, 18));
			tfEmail.setColumns(10);
			panel_thongtinNV.add(tfEmail);

			JLabel lblSCmnd = new JLabel("số ĐT:");
			lblSCmnd.setBounds(10, 155, 103, 25);
			lblSCmnd.setFont(new Font("Times New Roman", Font.BOLD,18));
			panel_thongtinNV.add(lblSCmnd);

			JLabel lblSCmnd_1 = new JLabel("Số CMND:");
			lblSCmnd_1.setBounds(10, 191, 103, 25);
			lblSCmnd_1.setFont(new Font("Times New Roman", Font.BOLD,18));
			panel_thongtinNV.add(lblSCmnd_1);

			JLabel lblNgySinh = new JLabel("Ngày sinh:");
			lblNgySinh.setBounds(10, 227, 103, 25);
			lblNgySinh.setFont(new Font("Times New Roman", Font.BOLD, 18));
			panel_thongtinNV.add(lblNgySinh);

			JPanel panel_TK = new JPanel();
			panel_TK.setBounds(10, 255, 336, 93);
			panel_TK.setBackground(Color.WHITE);
			panel_thongtinNV.add(panel_TK);
			panel_TK.setLayout(null);
			Border border = BorderFactory.createLineBorder(Color.RED);
			TitledBorder titleBorder = new TitledBorder(border, "Tài khoảng");
			titleBorder.setTitleFont(new Font("Times New Roman", Font.ITALIC, 16));
			titleBorder.setTitleColor(Color.RED);
			panel_TK.setBorder(titleBorder);
			
			JLabel lblTnTk = new JLabel("Tên TK:");
			lblTnTk.setFont(new Font("Times New Roman", Font.BOLD, 18));
			lblTnTk.setBounds(10, 21, 85, 24);
			panel_TK.add(lblTnTk);
			
			tfTenTK = new JTextField();
			tfTenTK.setFont(new Font("Times New Roman", Font.BOLD, 18));
			tfTenTK.setColumns(10);
			tfTenTK.setBounds(105, 21, 221, 25);
			panel_TK.add(tfTenTK);
			
			JLabel lblMtKhu = new JLabel("Mật khẩu:");
			lblMtKhu.setFont(new Font("Times New Roman", Font.BOLD, 18));
			lblMtKhu.setBounds(10, 56, 85, 24);
			panel_TK.add(lblMtKhu);
			
			passwordField = new JPasswordField();
			passwordField.setBounds(105, 56, 221, 25);
			panel_TK.add(passwordField);
			
			JPanel panel_Diachi = new JPanel();
			panel_Diachi.setBounds(10, 350, 336, 197);
			panel_Diachi.setBackground(Color.WHITE);
			border = BorderFactory.createLineBorder(Color.RED);
			titleBorder = new TitledBorder(border, "Địa chỉ");
			titleBorder.setTitleFont(new Font("Times New Roman", Font.ITALIC, 16));
			titleBorder.setTitleColor(Color.RED);
			panel_Diachi.setBorder(titleBorder);
			panel_thongtinNV.add(panel_Diachi);
			panel_Diachi.setLayout(null);

			JLabel lblTnhtp = new JLabel("Tỉnh/TP:");
			lblTnhtp.setBounds(10, 21, 85, 24);
			lblTnhtp.setFont(new Font("Times New Roman", Font.BOLD, 18));
			panel_Diachi.add(lblTnhtp);

			JLabel lblQun = new JLabel("Quận/Huyện:");
			lblQun.setFont(new Font("Times New Roman", Font.BOLD, 18));
			lblQun.setBounds(10, 56, 85, 24);
			panel_Diachi.add(lblQun);

			JLabel lblPhng = new JLabel("Phường:");
			lblPhng.setFont(new Font("Times New Roman", Font.BOLD, 18));
			lblPhng.setBounds(10, 91, 85, 24);
			panel_Diachi.add(lblPhng);

			JLabel lblng = new JLabel("Đường:");
			lblng.setFont(new Font("Times New Roman", Font.BOLD, 18));
			lblng.setBounds(10, 126, 85, 24);
			panel_Diachi.add(lblng);

			JLabel lblSNh = new JLabel("Số nhà:");
			lblSNh.setFont(new Font("Times New Roman", Font.BOLD, 18));
			lblSNh.setBounds(10, 161, 85, 24);
			panel_Diachi.add(lblSNh);


			tfTinh.setFont(new Font("Times New Roman", Font.BOLD, 18));
			tfTinh.setColumns(10);
			tfTinh.setBounds(105, 21, 221, 25);
			panel_Diachi.add(tfTinh);

			tfQuan.setFont(new Font("Times New Roman", Font.BOLD, 18));
			tfQuan.setColumns(10);
			tfQuan.setBounds(105, 56, 221, 25);
			panel_Diachi.add(tfQuan);

			tfPhuong.setFont(new Font("Times New Roman", Font.BOLD, 18));
			tfPhuong.setColumns(10);
			tfPhuong.setBounds(105, 91, 221, 25);
			panel_Diachi.add(tfPhuong);

			tfDuong.setFont(new Font("Times New Roman", Font.BOLD, 18));
			tfDuong.setColumns(10);
			tfDuong.setBounds(105, 126, 221, 25);
			panel_Diachi.add(tfDuong);

			tfSonha.setFont(new Font("Times New Roman", Font.BOLD, 18));
			tfSonha.setColumns(10);
			tfSonha.setBounds(105, 161, 221, 25);
			panel_Diachi.add(tfSonha);
			tfHoten.setBounds(116, 46, 221, 25);

			tfHoten.setFont(new Font("Times New Roman", Font.BOLD, 18));
			panel_thongtinNV.add(tfHoten);
			tfHoten.setColumns(10);
			tfSoDT.setBounds(116, 155, 221, 25);

			tfSoDT.setFont(new Font("Times New Roman", Font.BOLD, 18));
			tfSoDT.setColumns(10);
			panel_thongtinNV.add(tfSoDT);
			tfSoCMND.setBounds(116, 191, 221, 25);

			tfSoCMND.setFont(new Font("Times New Roman", Font.BOLD, 18));
			tfSoCMND.setColumns(10);
			panel_thongtinNV.add(tfSoCMND);

			ngaysinh.getSpinner().setFont(new Font("Times New Roman", Font.BOLD, 18));
			ngaysinh.setBounds(116, 227, 221, 21);
			ngaysinh.setDateFormatString("dd/MM/yyyy");
			ngaysinh.getSpinner().addChangeListener(new ChangeListener() {
				@SuppressWarnings("deprecation")
				@Override
				public void stateChanged(ChangeEvent e) {
					if(today.getYear() - ngaysinh.getDate().getYear() < 16 && !clear) {
						JOptionPane.showMessageDialog(null, "Khách hàng phải lớn hơn 15 tuổi!!", "Thông báo", 1);
					}
				}
			});
			panel_thongtinNV.add(ngaysinh);
			
			JButton btnclear = new JButton("clear");
			btnclear.setBounds(10, 558, 89, 25);
			panel_thongtinNV.add(btnclear);
			btnclear.setIcon(new ImageIcon(UINhanvien.class.getResource("/images/clear.png")));
			btnclear.setFont(new Font("Times New Roman", Font.BOLD, 20));
			btnclear.addMouseListener(new MouseAdapter () {

				@Override
				public void mouseClicked(MouseEvent e) {
					clear = true;
					tfHoten.setText("");
					tfHoten.requestFocus();
					dfChucvu.setSelectedItem(chucvu[0]);
					tfEmail.setText("");
					tfSoDT.setText("");
					tfSoCMND.setText("");
					ngaysinh.setDate(new Date());
					tfTenTK.setText("");
					passwordField.setText("");
					tfTinh.setText("");
					tfQuan.setText("");
					tfPhuong.setText("");
					tfDuong.setText("");
					tfSonha.setText("");
					clear = false;
				}
			});
			
			if(action.equalsIgnoreCase("add")) {
				JButton btnThem = new JButton("Thêm");
				btnThem.setIcon(new ImageIcon(UINhanvien.class.getResource("/images/add_customer.png")));
				btnThem.setHorizontalTextPosition(SwingConstants.LEADING);
				btnThem.setHorizontalAlignment(SwingConstants.LEADING);
				btnThem.setFont(new Font("Times New Roman", Font.BOLD, 20));
				btnThem.setBounds(257, 558, 89, 25);
				panel_thongtinNV.add(btnThem);
				btnThem.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if(isValidDataNV() && JOptionPane.showConfirmDialog(null,
								"Bạn có muốn thêm nhân viên?", "Thêm nhân viên", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
							them();
						}
					}
				});
			}else {
				tfMaNV.setText(nv.getMaNV());
				tfHoten.setText(nv.getTenNV());
				tfHoten.requestFocus();
				dfChucvu.setSelectedItem(nv.getChuVu());
				tfEmail.setText(nv.getEmail());
				tfSoDT.setText(nv.getSoDT());
				tfSoCMND.setText(nv.getSoCMND());
				ngaysinh.setDate(java.sql.Date.valueOf(nv.getNgaySinh()));
				tfTenTK.setText(nv.getTaiKhoan().getTenTK());
				tfTenTK.setEditable(false);
				passwordField.setText(nv.getTaiKhoan().getMatKhau());
				tfTinh.setText(nv.getDiaChi().getTinh());
				tfQuan.setText(nv.getDiaChi().getQuan());
				tfPhuong.setText(nv.getDiaChi().getPhuong());
				tfDuong.setText(nv.getDiaChi().getDuong());
				tfSonha.setText(nv.getDiaChi().getSoNha());
				
				if(action.equalsIgnoreCase("edit")) {
					JButton btnSua = new JButton("Sửa");
					btnSua.setIcon(new ImageIcon(UINhanvien.class.getResource("/images/edit_customer.png")));
					btnSua.setHorizontalTextPosition(SwingConstants.LEADING);
					btnSua.setHorizontalAlignment(SwingConstants.LEADING);
					btnSua.setFont(new Font("Times New Roman", Font.BOLD, 20));
					btnSua.setBounds(257, 558, 89, 25);
					panel_thongtinNV.add(btnSua);
					btnSua.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							if(isValidDataNV() && JOptionPane.showConfirmDialog(null,
									"Bạn có muốn sửa nhân viên?", "Sửa nhân viên", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
								sua();
							}
						}
					});
				}else {
					JButton btnXoa = new JButton("Xóa");
					btnXoa.setIcon(new ImageIcon(UINhanvien.class.getResource("/images/remove_customer.png")));
					btnXoa.setHorizontalTextPosition(SwingConstants.LEADING);
					btnXoa.setHorizontalAlignment(SwingConstants.LEADING);
					btnXoa.setFont(new Font("Times New Roman", Font.BOLD, 20));
					btnXoa.setBounds(257, 558, 89, 25);
					panel_thongtinNV.add(btnXoa);
					btnXoa.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							if(JOptionPane.showConfirmDialog(null,
									"Bạn có muốn xóa nhân viên?", "Xóa nhân viên", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
								xoa();
							}
						}
					});
				}
			}
		}
		
		public void updateMaNV() {
			int valueQL = 0, valueTT = 0;
			for (NhanVien x : dsnv) {
				if(x.getChuVu().equalsIgnoreCase("Quản lý"))
					valueQL++;
				else valueTT++;
			}
			do {
				if(cb_Chucvu.getSelectedItem().equals(chucvu[0])) {
					valueTT++;
					maNV = String.format("TT%03d", valueTT);
				}else {
					valueQL++;
					maNV = String.format("QL%03d", valueQL);
				}
			}while(nhanVienDAO.timNhanvien(maNV) != null);
			if(nv != null && nv.getChuVu().equals(cb_Chucvu.getSelectedItem())) {
				tfMaNV.setText(nv.getMaNV());
			}else {
				tfMaNV.setText(maNV);
			}
		}
		
		@SuppressWarnings("deprecation")
		public void them() {
			nv = nhanVienDAO.timNhanvien(tfHoten.getText().trim(), tfSoDT.getText().trim());
			if(nv == null) {
				nv = new NhanVien();
				nv.setMaNV(maNV);
				nv.setChuVu(dfChucvu.getSelectedItem().toString());
				nv.setEmail(tfEmail.getText().trim());
				nv.setTenNV(tfHoten.getText().trim());
				nv.setSoDT(tfSoDT.getText().trim());
				nv.setSoCMND(tfSoCMND.getText().trim());
				nv.setNgaySinh(convertToLocalDateViaInstant(ngaysinh.getDate()));
				
				TaiKhoan taiKhoan = new TaiKhoan();
				taiKhoan.setTenTK(tfTenTK.getText().trim());
				taiKhoan.setMatKhau(passwordField.getText().trim());
				
				DiaChi diaChi = new DiaChi();
				diaChi.setTinh(tfTinh.getText().trim());
				diaChi.setQuan(tfQuan.getText().trim());
				diaChi.setPhuong(tfPhuong.getText().trim());
				diaChi.setDuong(tfDuong.getText().trim());
				diaChi.setSoNha(tfSonha.getText().trim());
				diaChi.setMaDC(getAlphaString(10));
				nv.setDiaChi(diaChi);
				
				if(taiKhoanDAO.themTaikhoan(taiKhoan) && diachiDAO.themDiachi(diaChi) && nhanVienDAO.themNhanvien(nv)) {
					updateTableNhanvien();
					JOptionPane.showMessageDialog(null, "Thêm nhân viên thành công!!");
					dispose();
				}else {
					taiKhoanDAO.xoaTaikhoan(taiKhoan.getTenTK());
					diachiDAO.xoaDiachi(diaChi.getMaDC());
					JOptionPane.showMessageDialog(null, "Thêm nhân viên không thành công!!");
				}
			}else {
				JOptionPane.showMessageDialog(null, "Nhân viên trùng!!");
			}
		}
		
		@SuppressWarnings("deprecation")
		public void sua() {
			nv.setTenNV(tfHoten.getText().trim());
			nv.setChuVu(dfChucvu.getSelectedItem().toString());
			nv.setEmail(tfEmail.getText().trim());
			nv.setSoDT(tfSoDT.getText().trim());
			nv.setSoCMND(tfSoCMND.getText().trim());
			nv.setNgaySinh(convertToLocalDateViaInstant(ngaysinh.getDate()));
			
			TaiKhoan taiKhoan = new TaiKhoan();
			taiKhoan.setTenTK(tfTenTK.getText().trim());
			taiKhoan.setMatKhau(passwordField.getText().trim());
			
			DiaChi diaChi = new DiaChi();
			diaChi.setTinh(tfTinh.getText().trim());
			diaChi.setQuan(tfQuan.getText().trim());
			diaChi.setPhuong(tfPhuong.getText().trim());
			diaChi.setDuong(tfDuong.getText().trim());
			diaChi.setSoNha(tfSonha.getText().trim());
			diaChi.setMaDC(nv.getDiaChi().getMaDC());
			nv.setDiaChi(diaChi);
			
			if(taiKhoanDAO.suaTaiKhoan(taiKhoan) && diachiDAO.suaDiachi(diaChi) && nhanVienDAO.suaNhanvien(nv)) {
				updateTableNhanvien();
				JOptionPane.showMessageDialog(null, "Sửa nhân viên thành công!!");
				dispose();
			}else {
				diachiDAO.xoaDiachi(diaChi.getMaDC());
				JOptionPane.showMessageDialog(null, "Sửa nhân viên không thành công!!");
			}
		}
		
		public void xoa() {
			if(taiKhoanDAO.xoaTaikhoan(nv.getTaiKhoan().getTenTK()) &&
					diachiDAO.xoaDiachi(nv.getDiaChi().getMaDC()) && 
					nhanVienDAO.xoaNhanVien(nv.getMaNV())) {
				updateTableNhanvien();
				JOptionPane.showMessageDialog(null, "Xóa nhân viên thành công!!");
				dispose();
			}else {
				JOptionPane.showMessageDialog(null, "Xóa nhân viên không thành công!!");
			}
		}
		
		@SuppressWarnings("deprecation")
		public boolean isValidDataNV() {
			if(tfHoten.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Tên nhân viên không được để trống!!", "Thông báo", 1);
				return false;
			}
			if(!tfEmail.getText().trim().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
				JOptionPane.showMessageDialog(null, "Sai định dạng Email!!", "Thông báo", 1);
				return false;
			}
			if(!tfSoDT.getText().trim().matches("[0-9]{9,12}")) {
				JOptionPane.showMessageDialog(null, "Số điện thoại không được để trống 9-12 chứ số!!", "Thông báo", 1);
				return false;	
			}
			if(!tfSoCMND.getText().trim().matches("[0-9]{9}")) {
				JOptionPane.showMessageDialog(null, "Số cmnd không được để trốngĐầy đủ 9 kí tự số!!", "Thông báo", 1);
				return false;
			}
			if(today.getYear() - ngaysinh.getDate().getYear() < 16) {
				JOptionPane.showMessageDialog(null, "Nhân viên phải lớn hơn 15 tuổi!!", "Thông báo", 1);
				return false;
			}
			if(tfTenTK.getText().trim().length() < 6) {
				JOptionPane.showMessageDialog(null, "Tên tài khoảng phải lớn hơn 6 kí tự!!", "Thông báo", 1);
				return false;
			}
			if(passwordField.getText().trim().length() < 6){
				JOptionPane.showMessageDialog(null, "Mật khẩu phải lớn hơn 6 kí tự!!", "Thông báo", 1);
				return false;
			}
			if(tfTinh.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Tỉnh TP không được để trống", "Thông báo", 1);
				return false;
			}
			if(tfQuan.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Quận không được để trống", "Thông báo", 1);
				return false;
			}
			if(tfPhuong.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Phường không được để trống", "Thông báo", 1);
				return false;
			}
			if(tfDuong.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Đường không được để trống", "Thông báo", 1);
				return false;
			}
			if(tfSonha.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Số nhà không được để trống", "Thông báo", 1);
				return false;
			}
			return true;
		}
	}

	
	//Chức năng tìm kiếm
	public void timkiem() {
		if(comboBox_Tim.getItemAt(0).equals(timphong[0])) {

		}else if(comboBox_Tim.getItemAt(0).equals(titleKH[0])) {
			newFilterKH();
		}else if(comboBox_Tim.getItemAt(0).equals(titleNV[0])){
			newFilterNV();
		}else if(comboBox_Tim.getItemAt(0).equals(titleDP[0])) {
			newFilterDP();
		}
	}
	
	//Filter khách hàng
	public void newFilterKH() {
		RowFilter<TableModel, Object> rf = null;
		int selected = comboBox_Tim.getSelectedIndex();
		try {
			rf = RowFilter.regexFilter("(?i)" + tim.getText().trim(), selected);
		} catch (java.util.regex.PatternSyntaxException e) {
			return;
		}
		sorterDSKH.setRowFilter(rf);
	}
	
	//Filter nhân viên
	public void newFilterNV() {
		RowFilter<TableModel, Object> rf = null;
		int selected = comboBox_Tim.getSelectedIndex();
		try {
			rf = RowFilter.regexFilter("(?i)" + tim.getText().trim(), selected);
		} catch (java.util.regex.PatternSyntaxException e) {
			return;
		}
		sorterDSNV.setRowFilter(rf);
	}
	
	//Filter Đặt phòng
	public void newFilterDP() {
		RowFilter<TableModel, Object> rf = null;
		int selected = comboBox_Tim.getSelectedIndex();
		try {
			rf = RowFilter.regexFilter("(?i)" + tim.getText().trim(), selected);
		} catch (java.util.regex.PatternSyntaxException e) {
			return;
		}
		sorterDSDP.setRowFilter(rf);
	}

	public void displayFormDSPhong() {
		label_soPhong.setVisible(true);
		lblSPhng.setVisible(true);
		panel_DSKhachHang.setVisible(false);
		panel_DanhSachPhong.setVisible(true);
		panel_Dichvu.setVisible(false);
		panel_ChitietDV.setVisible(false);
		panel_DSNhanVien.setVisible(false);
		comboBox_Tim.setModel(new DefaultComboBoxModel<String>(timphong));
		panel_Thongke.setVisible(false);
		panel_DSHDatPhong.setVisible(false);
		tim.requestFocus();
	}

	public void displayFormDSKhachHang() {
		label_soPhong.setVisible(false);
		lblSPhng.setVisible(false);
		panel_DSKhachHang.setVisible(true);
		panel_DanhSachPhong.setVisible(false);
		panel_Dichvu.setVisible(false);
		panel_ChitietDV.setVisible(false);
		comboBox_Tim.setModel(new DefaultComboBoxModel<String>(titleKH));
		comboBox_Tim.setSelectedIndex(1);
		panel_DSNhanVien.setVisible(false);
		panel_Thongke.setVisible(false);
		panel_DSHDatPhong.setVisible(false);
		tim.requestFocus();
	}

	public void displayFormDSDichvu() {
		label_soPhong.setVisible(false);
		lblSPhng.setVisible(false);
		panel_DanhSachPhong.setVisible(false);
		panel_Dichvu.setVisible(true);
		panel_DSKhachHang.setVisible(false);
		panel_ChitietDV.setVisible(true);
		panel_DSNhanVien.setVisible(false);
		comboBox_Tim.setModel(new DefaultComboBoxModel<String>(itemsDichvu));
		panel_Thongke.setVisible(false);
		panel_DSHDatPhong.setVisible(false);
		tim.requestFocus();
	}
	
	public void displayFormDSNhanvien() {
		label_soPhong.setVisible(false);
		lblSPhng.setVisible(false);
		panel_DanhSachPhong.setVisible(false);
		panel_Dichvu.setVisible(false);
		panel_DSKhachHang.setVisible(false);
		panel_ChitietDV.setVisible(false);
		panel_DSNhanVien.setVisible(true);
		comboBox_Tim.setModel(new DefaultComboBoxModel<String>(titleNV));
		comboBox_Tim.setSelectedIndex(1);
		panel_Thongke.setVisible(false);
		panel_DSHDatPhong.setVisible(false);
		tim.requestFocus();
	}
	
	public void displayFormDSDatPhong() {
		label_soPhong.setVisible(false);
		lblSPhng.setVisible(false);
		panel_DanhSachPhong.setVisible(false);
		panel_Dichvu.setVisible(false);
		panel_DSKhachHang.setVisible(false);
		panel_ChitietDV.setVisible(false);
		panel_DSNhanVien.setVisible(false);
		comboBox_Tim.setModel(new DefaultComboBoxModel<String>(titleDP));
		comboBox_Tim.setSelectedIndex(1);
		panel_Thongke.setVisible(false);
		panel_DSHDatPhong.setVisible(true);
		tim.requestFocus();
	}
	
	public void displayFormThongke() {
		label_soPhong.setVisible(false);
		lblSPhng.setVisible(false);
		panel_DanhSachPhong.setVisible(false);
		panel_Dichvu.setVisible(false);
		panel_DSKhachHang.setVisible(false);
		panel_ChitietDV.setVisible(false);
		panel_DSNhanVien.setVisible(false);
		//TODO
		comboBox_Tim.setModel(new DefaultComboBoxModel<String>(titleNV));
		comboBox_Tim.setSelectedIndex(1);
		panel_Thongke.setVisible(true);
		panel_DSHDatPhong.setVisible(false);
		tim.requestFocus();
	}
	
	public class DoiMKUI extends JDialog{
		private JPasswordField pwfOld;
		private JPasswordField pwfNew;
		private JPasswordField pwfConfirm;
		public DoiMKUI() {
			super(new JFrame(), "Đổi mật khẩu", true);
			setBounds(0, 0, 410, 279);
			setLayout(null);
			setResizable(false);
			setLocationRelativeTo(null);
			getContentPane().setLayout(new BorderLayout());
			getContentPane().setBackground(Color.WHITE);
			KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
				
				@Override
				public boolean dispatchKeyEvent(KeyEvent e) {
					switch (e.getID()) {
					  case KeyEvent.KEY_PRESSED:
	                        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
	                            dispose();
	                        }
	                        break;
					}
					return false;
				}
			});
			
			JPanel PanelDoiMK = new JPanel();
			PanelDoiMK.setBounds(0, 0, 410, 279);
			PanelDoiMK.setLayout(null);
			add(PanelDoiMK);
			
			JLabel lblNewLabel = new JLabel("Mật khẩu cũ:");
			lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
			lblNewLabel.setBounds(18, 39, 150, 26);
			PanelDoiMK.add(lblNewLabel);

			JLabel lblMtKhuMi = new JLabel("Mật khẩu mới:");
			lblMtKhuMi.setFont(new Font("Times New Roman", Font.BOLD, 22));
			lblMtKhuMi.setBounds(18, 87, 150, 26);
			PanelDoiMK.add(lblMtKhuMi);

			JLabel lblXcNhnMk = new JLabel("Xác nhận MK:");
			lblXcNhnMk.setFont(new Font("Times New Roman", Font.BOLD, 22));
			lblXcNhnMk.setBounds(18, 137, 150, 26);
			PanelDoiMK.add(lblXcNhnMk);

			pwfOld = new JPasswordField();
			pwfOld.setFont(new Font("Times New Roman", Font.BOLD, 22));
			pwfOld.setBounds(178, 39, 195, 26);
			PanelDoiMK.add(pwfOld);

			pwfNew = new JPasswordField();
			pwfNew.setFont(new Font("Times New Roman", Font.BOLD, 22));
			pwfNew.setBounds(178, 87, 195, 26);
			PanelDoiMK.add(pwfNew);
			
			pwfConfirm = new JPasswordField();
			pwfConfirm.setFont(new Font("Times New Roman", Font.BOLD, 22));
			pwfConfirm.setBounds(178, 137, 195, 26);
			PanelDoiMK.add(pwfConfirm);
			
			JButton btnCancel = new JButton("Thoát");
			btnCancel.setIcon(new ImageIcon(DoiMKUI.class.getResource("/images/cancel.png")));
			btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 20));
			btnCancel.setBounds(10, 193, 135, 36);
			PanelDoiMK.add(btnCancel);
			btnCancel.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(JOptionPane.showConfirmDialog(null,
							"Bạn có muốn thoát?", "Thoát", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) 
						dispose();
				}
			});
			
			JButton btnConfirm = new JButton("Đổi MK");
			btnConfirm.setHorizontalTextPosition(SwingConstants.LEADING);
			btnConfirm.setHorizontalAlignment(SwingConstants.LEADING);
			btnConfirm.setIcon(new ImageIcon(DoiMKUI.class.getResource("/images/icons8-arrow-64.png")));
			btnConfirm.setFont(new Font("Times New Roman", Font.BOLD, 20));
			btnConfirm.setBounds(249, 193, 135, 36);
			PanelDoiMK.add(btnConfirm);
			btnConfirm.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(isValidDataMK() && JOptionPane.showConfirmDialog(null,
							"Bạn có muốn đổi mật khẩu?", "Đổi mật khẩu", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
						doiMK();
				}
			});
		}
		
		@SuppressWarnings("deprecation")
		public void doiMK() {
			TaiKhoan taiKhoan = nhanVien.getTaiKhoan();
			TaiKhoan taiKhoanOld = nhanVien.getTaiKhoan();
			taiKhoan.setMatKhau(pwfNew.getText().trim());
			nhanVien.setTaiKhoan(taiKhoan);
			if(taiKhoanDAO.suaTaiKhoan(taiKhoan) && nhanVienDAO.suaNhanvien(nhanVien)) {
				JOptionPane.showMessageDialog(null, "Thay đổi mật khẩu thành công!!");
				dispose();
			}else {
				taiKhoanDAO.suaTaiKhoan(taiKhoanOld);
				nhanVien.setTaiKhoan(taiKhoanOld);
				nhanVienDAO.suaNhanvien(nhanVien);
			}
		}
		
		@SuppressWarnings("deprecation")
		boolean isValidDataMK() {
			if(!pwfOld.getText().trim().equals(nhanVien.getTaiKhoan().getMatKhau())) {
				JOptionPane.showMessageDialog(null, "Mật khẩu cũ không khớp!!");
				return false;
			}
			if(pwfNew.getText().trim().length() < 6 && pwfConfirm.getText().trim().length() < 6) {
				JOptionPane.showMessageDialog(null, "Mật khẩu mới không được để trống, lớn hơn 6 kí tự!!");
				return false;
			}
			if(!pwfNew.getText().trim().equals(pwfConfirm.getText().trim())) {
				JOptionPane.showMessageDialog(null, "Mật khẩu không khớp!!");
				return false;
			}
			return true;
		}
	}

	public void logout() {
		if(JOptionPane.showConfirmDialog(null,
				"Bạn có muốn đăng xuất?", "Đăng xuất", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			dispose();
			new Login(em).setVisible(true);
		}
	}

	public void setJTableColumnsWidth(JTable table, int... tablePreferredWidth) {
		TableColumnModel columnModel = table.getColumnModel();
		for (int i = 0; i < tablePreferredWidth.length; i++)
			columnModel.getColumn(i).setPreferredWidth(tablePreferredWidth[i]);
	}

	public void clock() {
		Thread clock = new Thread() {
			public void run() {
				try {
					while(true) {
						Calendar cal = Calendar.getInstance();
						int day = cal.get(Calendar.DAY_OF_MONTH);
						int month = cal.get(Calendar.MONTH);
						int year = cal.get(Calendar.YEAR);
						date.setText(String.format("%02d/%02d/%04d", day, month+1, year));

						int second = cal.get(Calendar.SECOND);
						int minute = cal.get(Calendar.MINUTE);
						int hour = cal.get(Calendar.HOUR_OF_DAY);
						time.setText(String.format("%02d:%02d:%02d", hour, minute, second));

						String[] strDays = new String[] {"Chủ nhật", "Thứ hai", "Thứ ba",
								"Thứ tư", "Thứ năm", "Thứ sáu", "Thứ bảy"};
						dateweek.setText(strDays[cal.get(Calendar.DAY_OF_WEEK) - 1]);
						
						sleep(1000);
					}

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		clock.start();
	}

	public String getAlphaString(int n) 
	{ 
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"; 

		StringBuilder sb = new StringBuilder(n); 
		for (int i = 0; i < n; i++) { 
			int index = (int)(AlphaNumericString.length() * Math.random()); 
			sb.append(AlphaNumericString.charAt(index)); 
		} 
		return sb.toString(); 
	}

	public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
		return dateToConvert.toInstant()
				.atZone(ZoneId.systemDefault())
				.toLocalDate();
	}
}
