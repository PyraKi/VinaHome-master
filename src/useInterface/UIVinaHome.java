package useInterface;

import javax.swing.JFrame;
import javax.swing.JPanel;
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

import bussinessLayer.QLChitietDichvu;
import bussinessLayer.QLDatPhong;
import bussinessLayer.QLDiachi;
import bussinessLayer.QLDichvu;
import bussinessLayer.QLHoadon;
import bussinessLayer.QLKhachhang;
import bussinessLayer.QLPhieuDichvu;
import bussinessLayer.QLPhong;
import entity.ChitietPhieuDichvu;
import entity.DatPhong;
import entity.DiaChi;
import entity.Dichvu;
import entity.Hoadon;
import entity.KhachHang;
import entity.NhanVien;
import entity.PhieuDichvu;
import entity.Phong;
import implementsLayer.QLChitietDichvuimp;
import implementsLayer.QLDatPhongimp;
import implementsLayer.QLDiachiimp;
import implementsLayer.QLDichvuimp;
import implementsLayer.QLHoadonimp;
import implementsLayer.QLKhachhangimp;
import implementsLayer.QLPhieuDichvuimp;
import implementsLayer.QLPhongimp;

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
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;

import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;
import java.awt.Component;

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
	private JButton btLaphoadon;
	private JTextField tim = new JTextField();

	private JButton[] phongs;
	private JSpinner[] spinners;
	private JTable tableDSKhachhang;
	private DefaultTableModel dfmodelDSKH;
	private JComboBox<String> comboBox_Tim = new JComboBox<String>();
	private TableRowSorter<TableModel> sorterDSKH;
	private String[] timphong = new String[] {
			"Số phòng", "Tầng", "Loại phòng"
	};
	private String dsKH[] = {
			"Mã KH", "Họ tên", "Loại", "Số CMND", "Năm sinh", "SDT", "Địa chỉ"	
	};
	private JTable table_ChitietHoadon;
	private DefaultTableModel dfmodelCTHD;
	private String cTHD[] = {
			"STT", "Tên dịch vụ", "Loại dịch vụ", "Giá dịch vụ", "Số lượng", "Tổng"
	};
	private String itemsDichvu[] = {
			"Tên dịch vụ", "Loại dịch vụ"
	};
	private JLabel lbtotal;
	private JLabel lbvat;
	private JLabel lbsum;
	private Locale locale = new Locale("vi", "VN");
	private NumberFormat format = NumberFormat.getCurrencyInstance(locale);
	private JLabel lblSPhng = new JLabel("Số phòng còn trống:");
	private static EntityManager em;
	private QLKhachhangimp khachhangDAO;
	private QLDichvuimp dichvuDAO;
	private QLPhongimp phongDAO;
	private QLDiachiimp diachiDAO;
	private QLHoadonimp hoadonDAO;
	private QLChitietDichvuimp chitietdichvuDAO;
	private QLPhieuDichvuimp phieuDichvuDAO;
	private QLDatPhongimp datPhongDAO;
	private NhanVien nhanVien = new NhanVien();
	private PhieuDichvu phieuDichvu;

	public UIVinaHome(NhanVien nhanVien, EntityManager em) {
		this.nhanVien = nhanVien;
		UIVinaHome.em = em;
		khachhangDAO = new QLKhachhang(em);
		dichvuDAO = new QLDichvu(em);
		datPhongDAO = new QLDatPhong(em);
		phongDAO = new QLPhong(em);
		diachiDAO = new QLDiachi(em);
		hoadonDAO = new QLHoadon(em);
		chitietdichvuDAO = new QLChitietDichvu(em);
		phieuDichvuDAO = new QLPhieuDichvu(em);

		setForeground(new Color(255, 255, 255));
		setBackground(new Color(255, 250, 250));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setBounds(0, 0, 1920, 1080);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNhanvien = new JMenu("Nhân viên");
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

		JMenu mnQLPhong = new JMenu("Phòng");
		mnQLPhong.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		mnQuanly.add(mnQLPhong);

		JMenuItem itemSuaphong = new JMenuItem("Sửa phòng");
		itemSuaphong.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		mnQLPhong.add(itemSuaphong);

		JMenuItem itemThemPhong = new JMenuItem("Thêm phòng");
		itemThemPhong.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		mnQLPhong.add(itemThemPhong);

		JMenuItem ItemXoaPhong = new JMenuItem("Xóa Phòng");
		ItemXoaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		mnQLPhong.add(ItemXoaPhong);

		JMenu mnDichvu = new JMenu("Dịch vụ");
		mnDichvu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		mnQuanly.add(mnDichvu);

		JMenuItem itemThemDV = new JMenuItem("Thêm dịch vụ");
		itemThemDV.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		mnDichvu.add(itemThemDV);

		JMenuItem itemSuaDV = new JMenuItem("Sửa dịch vụ");
		itemSuaDV.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		mnDichvu.add(itemSuaDV);

		JMenuItem itemXoaDichvu = new JMenuItem("Xóa dịch vụ");
		itemXoaDichvu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		mnDichvu.add(itemXoaDichvu);

		JMenuItem QLHoadon = new JMenuItem("Hóa đơn");
		QLHoadon.setIcon(new ImageIcon(UIVinaHome.class.getResource("/images/dichvu.png")));
		QLHoadon.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		mnQuanly.add(QLHoadon);

		JMenuItem itemThongke = new JMenuItem("Thống kê");
		itemThongke.setIcon(new ImageIcon(UIVinaHome.class.getResource("/images/char.png")));
		itemThongke.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		mnQuanly.add(itemThongke);

		JMenu mnCaidat = new JMenu("Cài đặt");
		mnCaidat.setIcon(new ImageIcon(UIVinaHome.class.getResource("/images/setting.png")));
		mnCaidat.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		menuBar.add(mnCaidat);

		JMenuItem itemDoiMatkhau = new JMenuItem("Đổi mật khẩu");
		itemDoiMatkhau.setIcon(new ImageIcon(UIVinaHome.class.getResource("/images/lock.png")));
		itemDoiMatkhau.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		mnCaidat.add(itemDoiMatkhau);

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
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));		
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label;
		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder titleBorder = new TitledBorder(border, "Nhân viên");
		titleBorder.setTitleFont(new Font("Times New Roman", Font.ITALIC, 24));
		titleBorder.setTitleColor(Color.RED);
		border = BorderFactory.createLineBorder(Color.RED);
		titleBorder = new TitledBorder(border, "Công cụ");
		titleBorder.setTitleFont(new Font("Times New Roman", Font.ITALIC, 24));
		titleBorder.setTitleColor(Color.RED);

		clock();
		xuatDSPhong();

		border = BorderFactory.createLineBorder(Color.RED);
		titleBorder = new TitledBorder(border, "Danh sách dịch vụ");
		titleBorder.setTitleFont(new Font("Times New Roman", Font.BOLD, 26));
		titleBorder.setTitleColor(Color.RED);
		panel_Dichvu.setBorder(titleBorder);
		panel_Dichvu.setBackground(Color.WHITE);
		panel_Dichvu.setBounds(0, 49, 1897, 610);
		panel_Dichvu.setVisible(false);

		panel_DSKhachHang = new JPanel();
		panel_DSKhachHang.setBackground(Color.WHITE);
		panel_DSKhachHang.setBounds(0, 49, 1901, 965);
		panel_DSKhachHang.setVisible(false);
		panel_DSKhachHang.setBorder(titleBorder);
		contentPane.add(panel_DSKhachHang);
		panel_DSKhachHang.setLayout(new BorderLayout(0, 0));

		tableDSKhachhang = new JTable(dfmodelDSKH = new DefaultTableModel(dsKH, 0)) {
			public boolean isCellEditable(int row,int column) { //set non-Editable
				switch(column){
				default: return false; }}};
				tableDSKhachhang.addMouseListener(new MouseListener() {

					@Override
					public void mouseReleased(MouseEvent e) {


					}

					@Override
					public void mousePressed(MouseEvent e) {


					}

					@Override
					public void mouseExited(MouseEvent e) {


					}

					@Override
					public void mouseEntered(MouseEvent e) {


					}

					@Override
					public void mouseClicked(MouseEvent e) {

						int row = tableDSKhachhang.getSelectedRow();
						tableDSKhachhang.getValueAt(row, 0);
					}
				});
				tableDSKhachhang.setAutoCreateRowSorter(true);
				sorterDSKH = new TableRowSorter<TableModel>(tableDSKhachhang.getModel()); // Sorting and Filtering
				tableDSKhachhang.setRowSorter(sorterDSKH);

				tableDSKhachhang.setBackground(Color.WHITE);
				tableDSKhachhang.setFont(new Font("Times New Roman", Font.PLAIN, 22));
				setJTableColumnsWidth(tableDSKhachhang, 130, 370, 150, 160, 160, 160, 750);
				tableDSKhachhang.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				tableDSKhachhang.setRowHeight(32);
				JScrollPane scrollPaneKH = new JScrollPane(tableDSKhachhang,
						ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
						ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

				scrollPaneKH.getViewport().setBackground(Color.WHITE);
				panel_DSKhachHang.add(scrollPaneKH);
				contentPane.add(panel_Dichvu);
				panel_Dichvu.setLayout(new BorderLayout(0, 0));
				border = BorderFactory.createLineBorder(Color.RED);
				titleBorder = new TitledBorder(border, "Danh sách khách hàng");
				titleBorder.setTitleFont(new Font("Times New Roman", Font.BOLD, 26));
				titleBorder.setTitleColor(Color.RED);
				titleBorder = new TitledBorder(border, "Chức năng");
				titleBorder.setTitleFont(new Font("Times New Roman",  Font.ITALIC, 22));
				titleBorder.setTitleColor(Color.RED);



				panel_ChitietDV = new JPanel();
				panel_ChitietDV.setBackground(Color.WHITE);
				panel_ChitietDV.setBounds(0, 654, 1894, 360);
				titleBorder = new TitledBorder(border, "Chi tiết dịch vụ");
				titleBorder.setTitleFont(new Font("Times New Roman",  Font.ITALIC, 22));
				titleBorder.setTitleColor(Color.RED);
				panel_ChitietDV.setBorder(titleBorder);
				panel_ChitietDV.setVisible(false);

				contentPane.add(panel_ChitietDV);
				panel_ChitietDV.setLayout(new BorderLayout(0, 0));

				table_ChitietHoadon = new JTable(dfmodelCTHD = new DefaultTableModel(cTHD, 0)) {
					public boolean isCellEditable(int row,int column) { //set non-Editable
						switch(column){
						default: return false; }}};

						table_ChitietHoadon.setFont(new Font("Times New Roman", Font.PLAIN, 22));
						table_ChitietHoadon.setBackground(Color.WHITE);
						JScrollPane scrollPaneCTHD = new JScrollPane(table_ChitietHoadon);
						setJTableColumnsWidth(table_ChitietHoadon, 80, 350, 350, 350, 350, 400);
						table_ChitietHoadon.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
						table_ChitietHoadon.setRowHeight(32);
						scrollPaneCTHD.getViewport().setBackground(Color.WHITE);
						panel_ChitietDV.add(scrollPaneCTHD, BorderLayout.CENTER);

						JPanel Chitiet = new JPanel();
						panel_ChitietDV.add(Chitiet, BorderLayout.SOUTH);
						Chitiet.setBackground(Color.WHITE);
						Chitiet.setLayout(new BorderLayout(0, 0));

						JPanel layout = new JPanel();
						layout.setBackground(Color.WHITE);
						Chitiet.add(layout, BorderLayout.EAST);
						layout.setLayout(new GridLayout(3, 2, 6, 6));

						label = new JLabel("Tổng (Total): ");
						label.setHorizontalAlignment(SwingConstants.RIGHT);
						label.setFont(new Font("Times New Roman", Font.BOLD, 22));
						layout.add(label);

						lbtotal = new JLabel(format.format(0));
						lbtotal.setHorizontalAlignment(SwingConstants.LEFT);
						lbtotal.setFont(new Font("Times New Roman", Font.BOLD, 22));
						layout.add(lbtotal);

						label = new JLabel("Thuế VAT: ");
						label.setHorizontalAlignment(SwingConstants.RIGHT);
						label.setFont(new Font("Times New Roman", Font.BOLD, 22));
						layout.add(label);

						lbvat = new JLabel(format.format(0));
						lbvat.setHorizontalAlignment(SwingConstants.LEFT);
						lbvat.setFont(new Font("Times New Roman", Font.BOLD, 22));
						layout.add(lbvat);

						label = new JLabel("Tiền sau thuế: ");
						label.setHorizontalAlignment(SwingConstants.RIGHT);
						label.setFont(new Font("Times New Roman", Font.BOLD, 22));
						layout.add(label);

						lbsum = new JLabel(format.format(0));
						lbsum.setHorizontalAlignment(SwingConstants.LEFT);
						lbsum.setFont(new Font("Times New Roman", Font.BOLD, 22));
						layout.add(lbsum);

						JPanel panel = new JPanel();
						panel.setBackground(Color.WHITE);
						Chitiet.add(panel, BorderLayout.WEST);
						panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

						btLaphoadon = new JButton("Lập hóa đơn");
						btLaphoadon.setIcon(new ImageIcon(UIVinaHome.class.getResource("/images/bill.png")));
						btLaphoadon.setFont(new Font("Times New Roman", Font.BOLD, 26));
						btLaphoadon.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								btactionLapPhieuDichvu();
							}
						});
						btLaphoadon.setEnabled(false);
						panel.add(btLaphoadon);
						tim.setBounds(740, 10, 330, 38);
						contentPane.add(tim);


						tim.setFont(new Font("Times New Roman", Font.PLAIN, 20));
						tim.setToolTipText("Tìm kiếm");
						tim.setColumns(10);
						comboBox_Tim.setBounds(1080, 10, 132, 38);
						contentPane.add(comboBox_Tim);
						comboBox_Tim.setForeground(new Color(0, 0, 0));
						comboBox_Tim.setModel(new DefaultComboBoxModel<String>(timphong));
						comboBox_Tim.setFont(new Font("Times New Roman", Font.PLAIN, 18));
						JButton btnTm = new JButton();
						btnTm.setBounds(1222, 10, 51, 38);
						contentPane.add(btnTm);
						btnTm.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								timkiem();
							}
						});
						btnTm.setFont(new Font("Times New Roman", Font.BOLD, 18));
						btnTm.setIcon(new ImageIcon(UIVinaHome.class.getResource("/images/tim.png")));
						btnTm.setHorizontalAlignment(SwingConstants.LEFT);

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
						tim.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								timkiem();
							}
						});


						tim.requestFocus();


						//Hien thi dich vu
						displayDSdichvu();
						updateTableKhachHang();
	}

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
		panel_DanhSachPhong.setBounds(0, 49, 1901, 965);
		

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
					resource += phong.getGiuong().getMaGiuong().equals("GDN") ? "phongdoi.jpg" : "phongdoi2.PNG";
				else resource += "phongGD.jpg";
				Image img = ImageIO.read(getClass().getResource(resource));
				phongs[index].setIcon(new ImageIcon(img));
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			phongs[index].setOpaque(true);
			phongs[index].addMouseListener(new MouseListener() {

				@Override
				public void mouseReleased(MouseEvent e) {


				}

				@Override
				public void mousePressed(MouseEvent e) {


				}

				@Override
				public void mouseExited(MouseEvent e) {


				}

				@Override
				public void mouseEntered(MouseEvent e) {


				}

				@Override
				public void mouseClicked(MouseEvent e) {
					if(phong.getTinhtrangPhong().equals("Phòng trống"))
						new DatPhongUI(phong).setVisible(true);
					else if(phong.getTinhtrangPhong().equals("Phòng đặt"))
						new ThuePhongUI(phong).setVisible(true);
					else new LapHoaDonUI(phong).setVisible(true);
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
	public void updateSophongtrong() {
		List<Phong> dsphongs = phongDAO.getDSPhong();
		int soPhongTrong = 0, ra;
		for (Phong phong : dsphongs) {
			ra = (phong.getTinhtrangPhong().equalsIgnoreCase("Phòng trống")) ? 0 : 1;
			soPhongTrong += (ra == 0) ? 1 : 0;
			label_soPhong.setText(Integer.toString(soPhongTrong));
		}
	}

	public class DatPhongUI extends JDialog {
		private JLabel tongtien = new JLabel();
		private Date today = new Date();
		private Date ngayNhan_old = new Date();
		private Date ngayTra_old = new Date();
		private String[] loaithue = new String[] {"Theo giờ", "Qua đêm", "Theo ngày"};
		private JComboBox<String> comboBox = new JComboBox<String>();
		private DefaultComboBoxModel<String> dfloaithue = new DefaultComboBoxModel<String>(loaithue);
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
		private Phong phong;
		private KhachHang khachHang = new KhachHang();

		public DatPhongUI(Phong phong) {
			super(new JFrame(), "Đặt phòng", true);
			setBounds(0, 0, 720, 530);
			setResizable(false);
			setLocationRelativeTo(null);
			getContentPane().setBackground(Color.WHITE);
			setLayout(null);
			this.phong = phong;

			dateChooser_nhan.setDateFormatString("dd/MM/yyyy");
			dateChooser_tra.setDateFormatString("dd/MM/yyyy");

			JPanel panel_infoPhong = new JPanel();
			panel_infoPhong.setBackground(Color.WHITE);
			panel_infoPhong.setBounds(0, 0, 344, 130);
			add(panel_infoPhong);
			panel_infoPhong.setLayout(null);
			Border border = BorderFactory.createLineBorder(Color.RED);
			TitledBorder titleBorder = new TitledBorder(border, "Thông tin phòng");
			titleBorder.setTitleFont(new Font("Times New Roman", Font.ITALIC, 18));
			titleBorder.setTitleColor(Color.RED);
			panel_infoPhong.setBorder(titleBorder);

			JLabel label = new JLabel("Phòng:");
			label.setFont(new Font("Times New Roman", Font.BOLD, 22));
			label.setBounds(10, 26, 70, 25);
			panel_infoPhong.add(label);

			JLabel label_sophong = new JLabel(phong.getSoPhong());
			label_sophong.setFont(new Font("Times New Roman", Font.BOLD, 22));
			label_sophong.setBounds(90, 26, 244, 25);
			panel_infoPhong.add(label_sophong);

			label = new JLabel("Loại Phòng:");
			label.setFont(new Font("Times New Roman", Font.BOLD, 22));
			label.setBounds(10, 62, 115, 25);
			panel_infoPhong.add(label);

			JLabel label_Loaiphong = new JLabel(phong.getLoaiPhong().getTenLoaiphong());
			label_Loaiphong.setFont(new Font("Times New Roman", Font.BOLD, 22));
			label_Loaiphong.setBounds(135, 62, 199, 25);
			panel_infoPhong.add(label_Loaiphong);

			label = new JLabel("Loại giường:");
			label.setFont(new Font("Times New Roman", Font.BOLD, 22));
			label.setBounds(10, 98, 130, 25);
			panel_infoPhong.add(label);

			JLabel label_Loaigiuong = new JLabel(phong.getGiuong().getLoaiGiuong());
			label_Loaigiuong.setFont(new Font("Times New Roman", Font.BOLD, 22));
			label_Loaigiuong.setBounds(140, 98, 194, 25);
			panel_infoPhong.add(label_Loaigiuong);

			JPanel panel_datPhong = new JPanel();
			panel_datPhong.setBackground(Color.WHITE);
			panel_datPhong.setBounds(0, 130, 344, 314);
			border = BorderFactory.createLineBorder(Color.RED);
			titleBorder = new TitledBorder(border, "Đặt phòng");
			titleBorder.setTitleFont(new Font("Times New Roman", Font.ITALIC, 18));
			titleBorder.setTitleColor(Color.RED);
			panel_datPhong.setBorder(titleBorder);
			add(panel_datPhong);
			panel_datPhong.setLayout(null);

			dateChooser_nhan.getSpinner().setEnabled(false);
			dateChooser_tra.getSpinner().setEnabled(false);
			cbGionhan.setEnabled(false);
			cbGiotra.setEnabled(false);

			label = new JLabel("Loại thuê");
			label.setFont(new Font("Times New Roman", Font.BOLD, 18));
			label.setBounds(10, 23, 91, 25);
			panel_datPhong.add(label);

			comboBox.setFont(new Font("Times New Roman", Font.BOLD, 18));
			comboBox.setModel(dfloaithue);
			comboBox.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
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
					updateTongtien();
				}
			});
			comboBox.setBounds(111, 24, 125, 22);
			panel_datPhong.add(comboBox);

			dateChooser_nhan.getSpinner().addChangeListener(new ChangeListener() {
				@Override
				public void stateChanged(ChangeEvent e) {
					updateTongtien();
				}
			});
			dateChooser_tra.getSpinner().addChangeListener(new ChangeListener() {
				@Override
				public void stateChanged(ChangeEvent e) {
					updateTongtien();
				}
			});

			label = new JLabel("Ngày nhận:");
			label.setFont(new Font("Times New Roman", Font.BOLD, 18));
			label.setBounds(10, 78, 104, 25);
			panel_datPhong.add(label);

			label = new JLabel("Giờ nhận:");
			label.setFont(new Font("Times New Roman", Font.BOLD, 18));
			label.setBounds(10, 114, 104, 25);
			panel_datPhong.add(label);

			label = new JLabel("Ngày trả:");
			label.setFont(new Font("Times New Roman", Font.BOLD, 18));
			label.setBounds(10, 150, 104, 25);
			panel_datPhong.add(label);

			label = new JLabel("Giờ trả:");
			label.setFont(new Font("Times New Roman", Font.BOLD, 18));
			label.setBounds(10, 186, 104, 25);
			panel_datPhong.add(label);


			dateChooser_nhan.getSpinner().setFont(new Font("Times New Roman", Font.BOLD, 18));
			dateChooser_nhan.setBounds(111, 78, 221, 21);
			panel_datPhong.add(dateChooser_nhan);

			dateChooser_tra.getSpinner().setFont(new Font("Times New Roman", Font.BOLD, 18));
			dateChooser_tra.setBounds(111, 150, 221, 21);
			panel_datPhong.add(dateChooser_tra);


			cbGionhan.setFont(new Font("Times New Roman", Font.BOLD, 18));
			cbGionhan.setBounds(111, 114, 104, 22);
			panel_datPhong.add(cbGionhan);

			cbGiotra.setFont(new Font("Times New Roman", Font.BOLD, 18));
			cbGiotra.setBounds(111, 186, 104, 22);
			panel_datPhong.add(cbGiotra);

			label = new JLabel("Tổng tiền (tạm tính):");
			label.setFont(new Font("Times New Roman", Font.BOLD, 18));
			label.setBounds(10, 278, 190, 25);
			panel_datPhong.add(label);

			tongtien.setFont(new Font("Times New Roman", Font.BOLD, 18));
			tongtien.setBounds(180, 278, 135, 25);
			panel_datPhong.add(tongtien);

			JPanel panel_thongtinKH = new JPanel();
			panel_thongtinKH.setBackground(Color.WHITE); 
			panel_thongtinKH.setBounds(354, 0, 356, 444);
			border = BorderFactory.createLineBorder(Color.RED);
			titleBorder = new TitledBorder(border, "Thông tin Khách hàng");
			titleBorder.setTitleFont(new Font("Times New Roman", Font.ITALIC, 18));
			titleBorder.setTitleColor(Color.RED);
			panel_thongtinKH.setBorder(titleBorder);
			add(panel_thongtinKH);
			panel_thongtinKH.setLayout(null);

			JLabel lblHoTen = new JLabel("Họ tên:");
			lblHoTen.setFont(new Font("Times New Roman", Font.BOLD, 18));
			lblHoTen.setBounds(10, 26, 103, 25);
			panel_thongtinKH.add(lblHoTen);

			JLabel lblSCmnd = new JLabel("số ĐT:");
			lblSCmnd.setFont(new Font("Times New Roman", Font.BOLD,18));
			lblSCmnd.setBounds(10, 62, 103, 25);
			panel_thongtinKH.add(lblSCmnd);

			JLabel lblSCmnd_1 = new JLabel("Số CMND:");
			lblSCmnd_1.setFont(new Font("Times New Roman", Font.BOLD,18));
			lblSCmnd_1.setBounds(10, 98, 103, 25);
			panel_thongtinKH.add(lblSCmnd_1);

			JLabel lblNgySinh = new JLabel("Ngày sinh:");
			lblNgySinh.setFont(new Font("Times New Roman", Font.BOLD, 18));
			lblNgySinh.setBounds(10, 134, 103, 25);
			panel_thongtinKH.add(lblNgySinh);

			JPanel panel_Diachi = new JPanel();
			panel_Diachi.setBackground(Color.WHITE);
			panel_Diachi.setBounds(10, 204, 336, 229);
			titleBorder = new TitledBorder(border, "Địa chỉ");
			titleBorder.setTitleFont(new Font("Times New Roman", Font.ITALIC, 16));
			titleBorder.setTitleColor(Color.RED);
			panel_Diachi.setBorder(titleBorder);
			panel_thongtinKH.add(panel_Diachi);
			panel_Diachi.setLayout(null);

			JLabel lblTnhtp = new JLabel("Tỉnh/TP:");
			lblTnhtp.setBounds(10, 21, 85, 24);
			lblTnhtp.setFont(new Font("Times New Roman", Font.BOLD, 18));
			panel_Diachi.add(lblTnhtp);

			JLabel lblQun = new JLabel("Quận:");
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
			lblLoiKh.setBounds(10, 170, 103, 25);
			panel_thongtinKH.add(lblLoiKh);

			tfHoten.setFont(new Font("Times New Roman", Font.BOLD, 18));
			tfHoten.setBounds(116, 25, 221, 25);
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
			tfHoten.setColumns(10);
			lm_KhachHang = new DefaultListModel<String>();

			list_KhachHang.setModel(lm_KhachHang);
			list_KhachHang.setBounds(116, 50, 221, 95);
			list_KhachHang.setFont(new Font("Times New Roman", Font.BOLD, 12));
			list_KhachHang.setVisibleRowCount(5);
			list_KhachHang.setVisible(false);
			panel_thongtinKH.add(list_KhachHang);

			tfSoDT.setFont(new Font("Times New Roman", Font.BOLD, 18));
			tfSoDT.setColumns(10);
			tfSoDT.setBounds(116, 62, 221, 25);
			panel_thongtinKH.add(tfSoDT);

			tfSoCMND.setFont(new Font("Times New Roman", Font.BOLD, 18));
			tfSoCMND.setColumns(10);
			tfSoCMND.setBounds(116, 98, 221, 25);
			panel_thongtinKH.add(tfSoCMND);

			ngaysinh.getSpinner().setFont(new Font("Times New Roman", Font.BOLD, 18));
			ngaysinh.setDateFormatString("dd/MM/yyyy");
			ngaysinh.setBounds(116, 134, 221, 21);
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
			cb_LoaiKH.setBounds(116, 170, 103, 22);
			panel_thongtinKH.add(cb_LoaiKH);

			JButton btnclear = new JButton("clear");
			btnclear.setIcon(new ImageIcon(DatPhong.class.getResource("/images/clear.png")));
			btnclear.setFont(new Font("Times New Roman", Font.PLAIN, 16));
			btnclear.setBounds(237, 197, 89, 23);
			btnclear.addMouseListener(new MouseListener() {
				@Override
				public void mouseReleased(MouseEvent e) {

				}

				@Override
				public void mousePressed(MouseEvent e) {

				}

				@Override
				public void mouseExited(MouseEvent e) {

				}

				@Override
				public void mouseEntered(MouseEvent e) {

				}

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

			JButton btnThoat = new JButton("Thoát");
			btnThoat.setIcon(new ImageIcon(DatPhong.class.getResource("/images/cancel.png")));
			btnThoat.setFont(new Font("Times New Roman", Font.BOLD, 28));
			btnThoat.setBounds(10, 455, 127, 35);
			btnThoat.addMouseListener(new MouseListener() {

				@Override
				public void mouseReleased(MouseEvent e) {

				}

				@Override
				public void mousePressed(MouseEvent e) {

				}

				@Override
				public void mouseExited(MouseEvent e) {

				}

				@Override
				public void mouseEntered(MouseEvent e) {

				}

				@Override
				public void mouseClicked(MouseEvent e) {
					if(JOptionPane.showConfirmDialog(null,
							"Bạn có muốn Thoát?", "Thoát", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
						dispose();
				}
			});
			add(btnThoat);

			JButton btDatphong = new JButton("Đặt phòng");
			btDatphong.setIcon(new ImageIcon(DatPhong.class.getResource("/images/icons8-arrow-64.png")));
			btDatphong.setFont(new Font("Times New Roman", Font.BOLD, 28));
			btDatphong.setBounds(513, 455, 191, 35);
			btDatphong.setVerticalTextPosition(SwingConstants.CENTER);
			btDatphong.setHorizontalTextPosition(SwingConstants.LEFT);
			add(btDatphong);
			btDatphong.addMouseListener(new MouseListener() {

				@Override
				public void mouseReleased(MouseEvent e) {

				}

				@Override
				public void mousePressed(MouseEvent e) {

				}

				@Override
				public void mouseExited(MouseEvent e) {

				}

				@Override
				public void mouseEntered(MouseEvent e) {

				}

				@Override
				public void mouseClicked(MouseEvent e) {
					evDatphong();
				}
			});
			updateTongtien();
		}


		public void hienThiKH() {
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

				list_KhachHang.addMouseListener(new MouseListener() {

					@Override
					public void mouseReleased(MouseEvent e) {

					}

					@Override
					public void mousePressed(MouseEvent e) {

					}

					@Override
					public void mouseExited(MouseEvent e) {

					}

					@Override
					public void mouseEntered(MouseEvent e) {

					}

					@Override
					public void mouseClicked(MouseEvent e) {
						list_KhachHang.setVisible(false);
						khachHang = kh;
						tfHoten.setText(kh.getTenKH());
						tfHoten.requestFocus();
						tfSoDT.setText(kh.getSoDT());
						tfSoCMND.setText(kh.getSoCMD());
						ngaysinh.setDate(java.sql.Date.valueOf(kh.getNgaySinh()));
						dfLoaiKH.setSelectedItem(kh.getLoaiKH());
						tfTinh.setText(kh.getDiaChi().getTinh());
						tfQuan.setText(kh.getDiaChi().getQuan());
						tfPhuong.setText(kh.getDiaChi().getPhuong());
						tfDuong.setText(kh.getDiaChi().getDuong());
						tfSonha.setText(kh.getDiaChi().getSoNha());
						list_KhachHang.setVisible(false);
					}
				});
			}
			list_KhachHang.setVisible(true);
		}

		public void evDatphong() {
			if(isValidDataKH()) {
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
				boolean check_dp = true;
				DatPhong datPhong = new DatPhong();
				datPhong.setMaDP(getAlphaString(10));
				datPhong.setKhachHang(khachHang);
				datPhong.setLoaiDatPhong(dfloaithue.getSelectedItem().toString());
				datPhong.setNgayDatPhong(convertToLocalDateViaInstant(dateChooser_nhan.getDate()));
				datPhong.setNgayTraPhong(convertToLocalDateViaInstant(dateChooser_nhan.getDate()));
				datPhong.setGioDatPhong(dfgionhan.getSelectedItem().equals(gio[0]) ? 
						LocalTime.of(0, 0) : LocalTime.of(12, 0));
				datPhong.setGioTraPhong(dfgiotra.getSelectedItem().equals(gio[0]) ? 
						LocalTime.of(0, 0) : LocalTime.of(12, 0));
				List<DatPhong> listDatPhong = phong.getDatPhong();
				for (DatPhong dp : listDatPhong) {
					if((dp.getNgayDatPhong().compareTo(datPhong.getNgayDatPhong()) >=0 &&
							dp.getNgayTraPhong().compareTo(datPhong.getNgayDatPhong()) <=0) ||
							(dp.getNgayDatPhong().compareTo(datPhong.getNgayTraPhong()) >=0 &&
							dp.getNgayTraPhong().compareTo(datPhong.getNgayTraPhong()) <=0)) {
						check_dp = false;
						JOptionPane.showMessageDialog(null, "Đặt phòng bị trùng!!");
					}
				}
				if(check_dp) {
					listDatPhong.add(datPhong);
					if(datPhongDAO.themDatPhong(datPhong)) {
						phong.setDatPhong(listDatPhong);
						phong.setTinhtrangPhong("Phòng đặt");
						int index = phongDAO.getDSPhong().indexOf(phong);
						phongDAO.suaPhong(phong);
						phongs[index].setBackground(Color.decode("#D3D3D3")); //Phòng đang sử dụng
						updateSophongtrong();
						dispose();
						JOptionPane.showMessageDialog(null, "Đặt phòng thành công!!");
						if(datPhong.getLoaiDatPhong().equals(loaithue[0])) 
							new ThuePhongUI(phong).setVisible(true);
					}else JOptionPane.showMessageDialog(null, "Đặt phòng không thành công!!");
				}
			}
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

		public void updateTongtien() {
			if(dfloaithue.getSelectedItem().equals(loaithue[2])) {
				if(dateChooser_nhan.getDate().getTime() >= today.getTime() && 
						dateChooser_tra.getDate().getTime() >= today.getTime()) {
					if(dateChooser_nhan.getDate().getTime() <= dateChooser_tra.getDate().getTime()) {
						long date = ((dateChooser_tra.getDate().getTime() - 
								dateChooser_nhan.getDate().getTime()))/(1000*60*60*24);
						tongtien.setText(format.format((date*(phong.getGiaQuadem()*2 - phong.getGiaQuadem()*0.4))));
						ngayTra_old = dateChooser_tra.getDate();
						ngayNhan_old = dateChooser_nhan.getDate();
					}else {
						JOptionPane.showMessageDialog(null, "Ngày trả phòng phải lớn hơn bằng ngày nhận phòng!!");
						dateChooser_tra.setDate(ngayTra_old);
						dateChooser_nhan.setDate(ngayNhan_old);
					}
				}else {
					JOptionPane.showMessageDialog(null, "Ngày trả phòng và ngày nhận phòng\n"
							+ "phải lớn hơn bằng ngày hiện tại!!");
					dateChooser_tra.setDate(ngayTra_old);
					dateChooser_nhan.setDate(ngayNhan_old);
				}
			}else 
				tongtien.setText(format.format((dfloaithue.getSelectedItem().equals(loaithue[0]) ? 
						phong.getGiaTheogio() : phong.getGiaQuadem())));
		}
	}

	class ThuePhongUI extends JDialog{
		private JLabel tongtien = new JLabel();
		private String[] loaithue = new String[] {"Theo giờ", "Qua đêm", "Theo ngày"};
		private JComboBox<String> comboBox = new JComboBox<String>();
		private DefaultComboBoxModel<String> dfloaithue = new DefaultComboBoxModel<String>(loaithue);
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
		private JDateChooser ngaysinh = new JDateChooser();
		private String[] loaiKH = new String[] {"Vãn lai", "Thường", "VIP"};
		private DefaultComboBoxModel<String> dfLoaiKH = new DefaultComboBoxModel<String>(loaiKH);
		private JComboBox<String> cb_LoaiKH = new JComboBox<String>(dfLoaiKH);
		private DatPhong datPhong;
		private Phong phong;

		public ThuePhongUI(Phong phong) {
			super(new JFrame(), "Thuê phòng", true);
			setBounds(0, 0, 720, 530);
			setResizable(false);
			setLocationRelativeTo(null);
			getContentPane().setBackground(Color.WHITE);
			setLayout(null);
			this.phong = phong;

			//lay thong tin dat phong
			for (DatPhong dp : phong.getDatPhong()) {
				if(dp.getNgayDatPhong().compareTo(LocalDate.now()) <= 0) {
					datPhong = dp;
					break;
				}
			}

			dateChooser_nhan.setDateFormatString("dd/MM/yyyy");
			dateChooser_tra.setDateFormatString("dd/MM/yyyy");

			dateChooser_nhan.setDate(java.sql.Date.valueOf(datPhong.getNgayDatPhong()));
			dateChooser_tra.setDate(java.sql.Date.valueOf(datPhong.getNgayTraPhong()));

			dateChooser_nhan.getSpinner().setEnabled(false);
			dateChooser_tra.getSpinner().setEnabled(false);

			JPanel panel_infoPhong = new JPanel();
			panel_infoPhong.setBackground(Color.WHITE);
			panel_infoPhong.setBounds(0, 0, 344, 130);
			add(panel_infoPhong);
			panel_infoPhong.setLayout(null);
			Border border = BorderFactory.createLineBorder(Color.RED);
			TitledBorder titleBorder = new TitledBorder(border, "Thông tin phòng");
			titleBorder.setTitleFont(new Font("Times New Roman", Font.ITALIC, 18));
			titleBorder.setTitleColor(Color.RED);
			panel_infoPhong.setBorder(titleBorder);

			JLabel label = new JLabel("Phòng:");
			label.setFont(new Font("Times New Roman", Font.BOLD, 22));
			label.setBounds(10, 26, 70, 25);
			panel_infoPhong.add(label);

			JLabel label_sophong = new JLabel(phong.getSoPhong());
			label_sophong.setFont(new Font("Times New Roman", Font.BOLD, 22));
			label_sophong.setBounds(90, 26, 244, 25);
			panel_infoPhong.add(label_sophong);

			label = new JLabel("Loại Phòng:");
			label.setFont(new Font("Times New Roman", Font.BOLD, 22));
			label.setBounds(10, 62, 115, 25);
			panel_infoPhong.add(label);

			JLabel label_Loaiphong = new JLabel(phong.getLoaiPhong().getTenLoaiphong());
			label_Loaiphong.setFont(new Font("Times New Roman", Font.BOLD, 22));
			label_Loaiphong.setBounds(135, 62, 199, 25);
			panel_infoPhong.add(label_Loaiphong);

			label = new JLabel("Loại giường:");
			label.setFont(new Font("Times New Roman", Font.BOLD, 22));
			label.setBounds(10, 98, 130, 25);
			panel_infoPhong.add(label);

			JLabel label_Loaigiuong = new JLabel(phong.getGiuong().getLoaiGiuong());
			label_Loaigiuong.setFont(new Font("Times New Roman", Font.BOLD, 22));
			label_Loaigiuong.setBounds(140, 98, 194, 25);
			panel_infoPhong.add(label_Loaigiuong);

			JPanel panel_datPhong = new JPanel();
			panel_datPhong.setBackground(Color.WHITE);
			panel_datPhong.setBounds(0, 130, 344, 314);
			border = BorderFactory.createLineBorder(Color.RED);
			titleBorder = new TitledBorder(border, "Đặt phòng");
			titleBorder.setTitleFont(new Font("Times New Roman", Font.ITALIC, 18));
			titleBorder.setTitleColor(Color.RED);
			panel_datPhong.setBorder(titleBorder);
			add(panel_datPhong);
			panel_datPhong.setLayout(null);

			dateChooser_nhan.getSpinner().setEnabled(false);
			dateChooser_tra.getSpinner().setEnabled(false);
			cbGionhan.setEnabled(false);
			cbGiotra.setEnabled(false);

			label = new JLabel("Loại thuê");
			label.setFont(new Font("Times New Roman", Font.BOLD, 18));
			label.setBounds(10, 23, 91, 25);
			panel_datPhong.add(label);

			comboBox.setFont(new Font("Times New Roman", Font.BOLD, 18));
			comboBox.setModel(dfloaithue);
			comboBox.setBounds(111, 24, 125, 22);
			panel_datPhong.add(comboBox);
			dfloaithue.setSelectedItem(datPhong.getLoaiDatPhong());
			comboBox.setEnabled(false);

			label = new JLabel("Ngày nhận:");
			label.setFont(new Font("Times New Roman", Font.BOLD, 18));
			label.setBounds(10, 78, 104, 25);
			panel_datPhong.add(label);

			label = new JLabel("Giờ nhận:");
			label.setFont(new Font("Times New Roman", Font.BOLD, 18));
			label.setBounds(10, 114, 104, 25);
			panel_datPhong.add(label);

			label = new JLabel("Ngày trả:");
			label.setFont(new Font("Times New Roman", Font.BOLD, 18));
			label.setBounds(10, 150, 104, 25);
			panel_datPhong.add(label);

			label = new JLabel("Giờ trả:");
			label.setFont(new Font("Times New Roman", Font.BOLD, 18));
			label.setBounds(10, 186, 104, 25);
			panel_datPhong.add(label);


			dateChooser_nhan.getSpinner().setFont(new Font("Times New Roman", Font.BOLD, 18));
			dateChooser_nhan.setBounds(111, 78, 221, 21);
			panel_datPhong.add(dateChooser_nhan);

			dateChooser_tra.getSpinner().setFont(new Font("Times New Roman", Font.BOLD, 18));
			dateChooser_tra.setBounds(111, 150, 221, 21);
			panel_datPhong.add(dateChooser_tra);


			cbGionhan.setFont(new Font("Times New Roman", Font.BOLD, 18));
			cbGionhan.setBounds(111, 114, 104, 22);
			panel_datPhong.add(cbGionhan);

			cbGiotra.setFont(new Font("Times New Roman", Font.BOLD, 18));
			cbGiotra.setBounds(111, 186, 104, 22);
			panel_datPhong.add(cbGiotra);

			label = new JLabel("Tổng tiền (tạm tính):");
			label.setFont(new Font("Times New Roman", Font.BOLD, 18));
			label.setBounds(10, 278, 190, 25);
			panel_datPhong.add(label);

			tongtien.setFont(new Font("Times New Roman", Font.BOLD, 18));
			tongtien.setBounds(180, 278, 135, 25);
			panel_datPhong.add(tongtien);

			JPanel panel_thongtinKH = new JPanel();
			panel_thongtinKH.setBackground(Color.WHITE); 
			panel_thongtinKH.setBounds(354, 0, 356, 444);
			border = BorderFactory.createLineBorder(Color.RED);
			titleBorder = new TitledBorder(border, "Thông tin Khách hàng");
			titleBorder.setTitleFont(new Font("Times New Roman", Font.ITALIC, 18));
			titleBorder.setTitleColor(Color.RED);
			panel_thongtinKH.setBorder(titleBorder);
			add(panel_thongtinKH);
			panel_thongtinKH.setLayout(null);

			JLabel lblHoTen = new JLabel("Họ tên:");
			lblHoTen.setFont(new Font("Times New Roman", Font.BOLD, 18));
			lblHoTen.setBounds(10, 26, 103, 25);
			panel_thongtinKH.add(lblHoTen);

			JLabel lblSCmnd = new JLabel("số ĐT:");
			lblSCmnd.setFont(new Font("Times New Roman", Font.BOLD,18));
			lblSCmnd.setBounds(10, 62, 103, 25);
			panel_thongtinKH.add(lblSCmnd);

			JLabel lblSCmnd_1 = new JLabel("Số CMND:");
			lblSCmnd_1.setFont(new Font("Times New Roman", Font.BOLD,18));
			lblSCmnd_1.setBounds(10, 98, 103, 25);
			panel_thongtinKH.add(lblSCmnd_1);

			JLabel lblNgySinh = new JLabel("Ngày sinh:");
			lblNgySinh.setFont(new Font("Times New Roman", Font.BOLD, 18));
			lblNgySinh.setBounds(10, 134, 103, 25);
			panel_thongtinKH.add(lblNgySinh);

			JPanel panel_Diachi = new JPanel();
			panel_Diachi.setBackground(Color.WHITE);
			panel_Diachi.setBounds(10, 204, 336, 229);
			titleBorder = new TitledBorder(border, "Địa chỉ");
			titleBorder.setTitleFont(new Font("Times New Roman", Font.ITALIC, 16));
			titleBorder.setTitleColor(Color.RED);
			panel_Diachi.setBorder(titleBorder);
			panel_thongtinKH.add(panel_Diachi);
			panel_Diachi.setLayout(null);

			JLabel lblTnhtp = new JLabel("Tỉnh/TP:");
			lblTnhtp.setBounds(10, 21, 85, 24);
			lblTnhtp.setFont(new Font("Times New Roman", Font.BOLD, 18));
			panel_Diachi.add(lblTnhtp);

			JLabel lblQun = new JLabel("Quận:");
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
			tfTinh.setText(datPhong.getKhachHang().getDiaChi().getTinh());
			tfTinh.setEnabled(false);

			tfQuan.setFont(new Font("Times New Roman", Font.BOLD, 18));
			tfQuan.setColumns(10);
			tfQuan.setBounds(105, 56, 221, 25);
			panel_Diachi.add(tfQuan);
			tfQuan.setText(datPhong.getKhachHang().getDiaChi().getQuan());
			tfQuan.setEnabled(false);

			tfPhuong.setFont(new Font("Times New Roman", Font.BOLD, 18));
			tfPhuong.setColumns(10);
			tfPhuong.setBounds(105, 91, 221, 25);
			panel_Diachi.add(tfPhuong);
			tfPhuong.setText(datPhong.getKhachHang().getDiaChi().getPhuong());
			tfPhuong.setEnabled(false);

			tfDuong.setFont(new Font("Times New Roman", Font.BOLD, 18));
			tfDuong.setColumns(10);
			tfDuong.setBounds(105, 126, 221, 25);
			panel_Diachi.add(tfDuong);
			tfDuong.setText(datPhong.getKhachHang().getDiaChi().getDuong());
			tfDuong.setEnabled(false);

			tfSonha.setFont(new Font("Times New Roman", Font.BOLD, 18));
			tfSonha.setColumns(10);
			tfSonha.setBounds(105, 161, 221, 25);
			panel_Diachi.add(tfSonha);
			tfSonha.setText(datPhong.getKhachHang().getDiaChi().getSoNha());
			tfSonha.setEnabled(false);

			JLabel lblLoiKh = new JLabel("Loại KH:");
			lblLoiKh.setFont(new Font("Times New Roman", Font.BOLD, 18));
			lblLoiKh.setBounds(10, 170, 103, 25);
			panel_thongtinKH.add(lblLoiKh);

			tfHoten.setFont(new Font("Times New Roman", Font.BOLD, 18));
			tfHoten.setBounds(116, 25, 221, 25);
			panel_thongtinKH.add(tfHoten);
			tfHoten.setColumns(10);
			tfHoten.setText(datPhong.getKhachHang().getTenKH());
			tfHoten.setEnabled(false);

			tfSoDT.setFont(new Font("Times New Roman", Font.BOLD, 18));
			tfSoDT.setColumns(10);
			tfSoDT.setBounds(116, 62, 221, 25);
			panel_thongtinKH.add(tfSoDT);
			tfSoDT.setText(datPhong.getKhachHang().getSoDT());
			tfSoDT.setEnabled(false);

			tfSoCMND.setFont(new Font("Times New Roman", Font.BOLD, 18));
			tfSoCMND.setColumns(10);
			tfSoCMND.setBounds(116, 98, 221, 25);
			panel_thongtinKH.add(tfSoCMND);
			tfSoCMND.setText(datPhong.getKhachHang().getSoCMD());
			tfSoCMND.setEnabled(false);

			ngaysinh.getSpinner().setFont(new Font("Times New Roman", Font.BOLD, 18));
			ngaysinh.setDateFormatString("dd/MM/yyyy");
			ngaysinh.setBounds(116, 134, 221, 21);
			panel_thongtinKH.add(ngaysinh);
			ngaysinh.setDate(java.sql.Date.valueOf(datPhong.getKhachHang().getNgaySinh()));
			ngaysinh.getSpinner().setEnabled(false);

			cb_LoaiKH.setFont(new Font("Times New Roman", Font.BOLD, 18));
			cb_LoaiKH.setBounds(116, 170, 103, 22);
			panel_thongtinKH.add(cb_LoaiKH);
			dfLoaiKH.setSelectedItem(datPhong.getKhachHang().getLoaiKH());
			cb_LoaiKH.setEnabled(false);

			JButton btnHuyDatphong = new JButton("Hủy đặt phòng");
			btnHuyDatphong.setIcon(new ImageIcon(DatPhong.class.getResource("/images/cancel-button.jpg")));
			btnHuyDatphong.setFont(new Font("Times New Roman", Font.BOLD, 28));
			btnHuyDatphong.setBounds(10, 455, 235, 35);
			btnHuyDatphong.setVerticalTextPosition(SwingConstants.CENTER);
			btnHuyDatphong.setHorizontalTextPosition(SwingConstants.LEFT);
			btnHuyDatphong.addMouseListener(new MouseListener() {

				@Override
				public void mouseReleased(MouseEvent e) {

				}

				@Override
				public void mousePressed(MouseEvent e) {

				}

				@Override
				public void mouseExited(MouseEvent e) {

				}

				@Override
				public void mouseEntered(MouseEvent e) {

				}

				@Override
				public void mouseClicked(MouseEvent e) {
					if(JOptionPane.showConfirmDialog(null,
							"Bạn có muốn hủy đặt phòng?", "Hủy", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						huyDatphong();
					}
				}
			});
			add(btnHuyDatphong);

			JButton btThuephong = new JButton("Thuê phòng");
			btThuephong.setIcon(new ImageIcon(DatPhong.class.getResource("/images/icons8-arrow-64.png")));
			btThuephong.setFont(new Font("Times New Roman", Font.BOLD, 28));
			btThuephong.setBounds(513, 455, 191, 35);
			btThuephong.setVerticalTextPosition(SwingConstants.CENTER);
			btThuephong.setHorizontalTextPosition(SwingConstants.LEFT);
			add(btThuephong);
			btThuephong.addMouseListener(new MouseListener() {

				@Override
				public void mouseReleased(MouseEvent e) {

				}

				@Override
				public void mousePressed(MouseEvent e) {

				}

				@Override
				public void mouseExited(MouseEvent e) {

				}

				@Override
				public void mouseEntered(MouseEvent e) {

				}

				@Override
				public void mouseClicked(MouseEvent e) {
					if(JOptionPane.showConfirmDialog(null,
							"Bạn có muốn thuê phòng?", "Thuê phòng", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						thuePhongev();
					}
				}
			});

			updateTongtien();
		}

		public void updateTongtien() {
			if(dfloaithue.getSelectedItem().equals(loaithue[2])) {
				long date = ((dateChooser_tra.getDate().getTime() - 
						dateChooser_nhan.getDate().getTime()))/(1000*60*60*24);
				tongtien.setText(format.format((date*(phong.getGiaQuadem()*2 - phong.getGiaQuadem()*0.4))));
			}else 
				tongtien.setText(format.format((dfloaithue.getSelectedItem().equals(loaithue[0]) ? 
						phong.getGiaTheogio() : phong.getGiaQuadem())));
		}

		public void huyDatphong() {
			if(datPhongDAO.xoaDatPhong(datPhong.getMaDP())) {
				List<DatPhong> newDatphong = phong.getDatPhong();
				newDatphong.remove(datPhong);
				phong.setDatPhong(newDatphong);
				phong.setTinhtrangPhong("Phòng trống");
				phongDAO.suaPhong(phong);
				xuatDSPhong();
				JOptionPane.showMessageDialog(null, "Hủy đặt phòng thành công!!");
				dispose();
			}else JOptionPane.showMessageDialog(null, "Hủy đặt phòng không thành công!!");
		}

		public void thuePhongev() {
			phong.setTinhtrangPhong("Phòng đang thuê");
			if(phongDAO.suaPhong(phong)) {
				xuatDSPhong();
				JOptionPane.showMessageDialog(null, "Thuê phòng thành công!!");
				dispose();
			}else JOptionPane.showMessageDialog(null, "Thuê phòng không thành công!!");
		}
	}

	class LapHoaDonUI extends JDialog{
		private JLabel tongtien = new JLabel();
		private String[] loaithue = new String[] {"Theo giờ", "Qua đêm", "Theo ngày"};
		private JComboBox<String> comboBox = new JComboBox<String>();
		private DefaultComboBoxModel<String> dfloaithue = new DefaultComboBoxModel<String>(loaithue);
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
		private JDateChooser ngaysinh = new JDateChooser();
		private String[] loaiKH = new String[] {"Vãn lai", "Thường", "VIP"};
		private DefaultComboBoxModel<String> dfLoaiKH = new DefaultComboBoxModel<String>(loaiKH);
		private JComboBox<String> cb_LoaiKH = new JComboBox<String>(dfLoaiKH);
		private DatPhong datPhong;
		private Phong phong;
		private double tongTien = 0;

		public LapHoaDonUI(Phong phong) {
			super(new JFrame(), "Lập hóa đơn", true);
			setBounds(0, 0, 720, 530);
			setResizable(false);
			setLocationRelativeTo(null);
			getContentPane().setBackground(Color.WHITE);
			setLayout(null);
			this.phong = phong;

			//lay thong tin dat phong
			for (DatPhong dp : phong.getDatPhong()) {
				if(dp.getNgayDatPhong().compareTo(LocalDate.now()) <= 0) {
					datPhong = dp;
					break;
				}
			}

			dateChooser_nhan.setDateFormatString("dd/MM/yyyy");
			dateChooser_tra.setDateFormatString("dd/MM/yyyy");

			dateChooser_nhan.setDate(java.sql.Date.valueOf(datPhong.getNgayDatPhong()));
			dateChooser_tra.setDate(java.sql.Date.valueOf(datPhong.getNgayTraPhong()));

			dateChooser_nhan.getSpinner().setEnabled(false);
			dateChooser_tra.getSpinner().setEnabled(false);

			JPanel panel_infoPhong = new JPanel();
			panel_infoPhong.setBackground(Color.WHITE);
			panel_infoPhong.setBounds(0, 0, 344, 130);
			add(panel_infoPhong);
			panel_infoPhong.setLayout(null);
			Border border = BorderFactory.createLineBorder(Color.RED);
			TitledBorder titleBorder = new TitledBorder(border, "Thông tin phòng");
			titleBorder.setTitleFont(new Font("Times New Roman", Font.ITALIC, 18));
			titleBorder.setTitleColor(Color.RED);
			panel_infoPhong.setBorder(titleBorder);

			JLabel label = new JLabel("Phòng:");
			label.setFont(new Font("Times New Roman", Font.BOLD, 22));
			label.setBounds(10, 26, 70, 25);
			panel_infoPhong.add(label);

			JLabel label_sophong = new JLabel(phong.getSoPhong());
			label_sophong.setFont(new Font("Times New Roman", Font.BOLD, 22));
			label_sophong.setBounds(90, 26, 244, 25);
			panel_infoPhong.add(label_sophong);

			label = new JLabel("Loại Phòng:");
			label.setFont(new Font("Times New Roman", Font.BOLD, 22));
			label.setBounds(10, 62, 115, 25);
			panel_infoPhong.add(label);

			JLabel label_Loaiphong = new JLabel(phong.getLoaiPhong().getTenLoaiphong());
			label_Loaiphong.setFont(new Font("Times New Roman", Font.BOLD, 22));
			label_Loaiphong.setBounds(135, 62, 199, 25);
			panel_infoPhong.add(label_Loaiphong);

			label = new JLabel("Loại giường:");
			label.setFont(new Font("Times New Roman", Font.BOLD, 22));
			label.setBounds(10, 98, 130, 25);
			panel_infoPhong.add(label);

			JLabel label_Loaigiuong = new JLabel(phong.getGiuong().getLoaiGiuong());
			label_Loaigiuong.setFont(new Font("Times New Roman", Font.BOLD, 22));
			label_Loaigiuong.setBounds(140, 98, 194, 25);
			panel_infoPhong.add(label_Loaigiuong);

			JPanel panel_datPhong = new JPanel();
			panel_datPhong.setBackground(Color.WHITE);
			panel_datPhong.setBounds(0, 130, 344, 314);
			border = BorderFactory.createLineBorder(Color.RED);
			titleBorder = new TitledBorder(border, "Đặt phòng");
			titleBorder.setTitleFont(new Font("Times New Roman", Font.ITALIC, 18));
			titleBorder.setTitleColor(Color.RED);
			panel_datPhong.setBorder(titleBorder);
			add(panel_datPhong);
			panel_datPhong.setLayout(null);

			dateChooser_nhan.getSpinner().setEnabled(false);
			dateChooser_tra.getSpinner().setEnabled(false);
			cbGionhan.setEnabled(false);
			cbGiotra.setEnabled(false);

			label = new JLabel("Loại thuê");
			label.setFont(new Font("Times New Roman", Font.BOLD, 18));
			label.setBounds(10, 23, 91, 25);
			panel_datPhong.add(label);

			comboBox.setFont(new Font("Times New Roman", Font.BOLD, 18));
			comboBox.setModel(dfloaithue);
			comboBox.setBounds(111, 24, 125, 22);
			panel_datPhong.add(comboBox);
			dfloaithue.setSelectedItem(datPhong.getLoaiDatPhong());
			comboBox.setEnabled(false);

			label = new JLabel("Ngày nhận:");
			label.setFont(new Font("Times New Roman", Font.BOLD, 18));
			label.setBounds(10, 78, 104, 25);
			panel_datPhong.add(label);

			label = new JLabel("Giờ nhận:");
			label.setFont(new Font("Times New Roman", Font.BOLD, 18));
			label.setBounds(10, 114, 104, 25);
			panel_datPhong.add(label);

			label = new JLabel("Ngày trả:");
			label.setFont(new Font("Times New Roman", Font.BOLD, 18));
			label.setBounds(10, 150, 104, 25);
			panel_datPhong.add(label);

			label = new JLabel("Giờ trả:");
			label.setFont(new Font("Times New Roman", Font.BOLD, 18));
			label.setBounds(10, 186, 104, 25);
			panel_datPhong.add(label);


			dateChooser_nhan.getSpinner().setFont(new Font("Times New Roman", Font.BOLD, 18));
			dateChooser_nhan.setBounds(111, 78, 221, 21);
			panel_datPhong.add(dateChooser_nhan);

			dateChooser_tra.getSpinner().setFont(new Font("Times New Roman", Font.BOLD, 18));
			dateChooser_tra.setBounds(111, 150, 221, 21);
			panel_datPhong.add(dateChooser_tra);


			cbGionhan.setFont(new Font("Times New Roman", Font.BOLD, 18));
			cbGionhan.setBounds(111, 114, 104, 22);
			panel_datPhong.add(cbGionhan);

			cbGiotra.setFont(new Font("Times New Roman", Font.BOLD, 18));
			cbGiotra.setBounds(111, 186, 104, 22);
			panel_datPhong.add(cbGiotra);

			label = new JLabel("Tổng tiền (tạm tính):");
			label.setFont(new Font("Times New Roman", Font.BOLD, 18));
			label.setBounds(10, 278, 190, 25);
			panel_datPhong.add(label);

			tongtien.setFont(new Font("Times New Roman", Font.BOLD, 18));
			tongtien.setBounds(180, 278, 135, 25);
			panel_datPhong.add(tongtien);

			JPanel panel_thongtinKH = new JPanel();
			panel_thongtinKH.setBackground(Color.WHITE); 
			panel_thongtinKH.setBounds(354, 0, 356, 444);
			border = BorderFactory.createLineBorder(Color.RED);
			titleBorder = new TitledBorder(border, "Thông tin Khách hàng");
			titleBorder.setTitleFont(new Font("Times New Roman", Font.ITALIC, 18));
			titleBorder.setTitleColor(Color.RED);
			panel_thongtinKH.setBorder(titleBorder);
			add(panel_thongtinKH);
			panel_thongtinKH.setLayout(null);

			JLabel lblHoTen = new JLabel("Họ tên:");
			lblHoTen.setFont(new Font("Times New Roman", Font.BOLD, 18));
			lblHoTen.setBounds(10, 26, 103, 25);
			panel_thongtinKH.add(lblHoTen);

			JLabel lblSCmnd = new JLabel("số ĐT:");
			lblSCmnd.setFont(new Font("Times New Roman", Font.BOLD,18));
			lblSCmnd.setBounds(10, 62, 103, 25);
			panel_thongtinKH.add(lblSCmnd);

			JLabel lblSCmnd_1 = new JLabel("Số CMND:");
			lblSCmnd_1.setFont(new Font("Times New Roman", Font.BOLD,18));
			lblSCmnd_1.setBounds(10, 98, 103, 25);
			panel_thongtinKH.add(lblSCmnd_1);

			JLabel lblNgySinh = new JLabel("Ngày sinh:");
			lblNgySinh.setFont(new Font("Times New Roman", Font.BOLD, 18));
			lblNgySinh.setBounds(10, 134, 103, 25);
			panel_thongtinKH.add(lblNgySinh);

			JPanel panel_Diachi = new JPanel();
			panel_Diachi.setBackground(Color.WHITE);
			panel_Diachi.setBounds(10, 204, 336, 229);
			titleBorder = new TitledBorder(border, "Địa chỉ");
			titleBorder.setTitleFont(new Font("Times New Roman", Font.ITALIC, 16));
			titleBorder.setTitleColor(Color.RED);
			panel_Diachi.setBorder(titleBorder);
			panel_thongtinKH.add(panel_Diachi);
			panel_Diachi.setLayout(null);

			JLabel lblTnhtp = new JLabel("Tỉnh/TP:");
			lblTnhtp.setBounds(10, 21, 85, 24);
			lblTnhtp.setFont(new Font("Times New Roman", Font.BOLD, 18));
			panel_Diachi.add(lblTnhtp);

			JLabel lblQun = new JLabel("Quận:");
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
			tfTinh.setText(datPhong.getKhachHang().getDiaChi().getTinh());
			tfTinh.setEnabled(false);

			tfQuan.setFont(new Font("Times New Roman", Font.BOLD, 18));
			tfQuan.setColumns(10);
			tfQuan.setBounds(105, 56, 221, 25);
			panel_Diachi.add(tfQuan);
			tfQuan.setText(datPhong.getKhachHang().getDiaChi().getQuan());
			tfQuan.setEnabled(false);

			tfPhuong.setFont(new Font("Times New Roman", Font.BOLD, 18));
			tfPhuong.setColumns(10);
			tfPhuong.setBounds(105, 91, 221, 25);
			panel_Diachi.add(tfPhuong);
			tfPhuong.setText(datPhong.getKhachHang().getDiaChi().getPhuong());
			tfPhuong.setEnabled(false);

			tfDuong.setFont(new Font("Times New Roman", Font.BOLD, 18));
			tfDuong.setColumns(10);
			tfDuong.setBounds(105, 126, 221, 25);
			panel_Diachi.add(tfDuong);
			tfDuong.setText(datPhong.getKhachHang().getDiaChi().getDuong());
			tfDuong.setEnabled(false);

			tfSonha.setFont(new Font("Times New Roman", Font.BOLD, 18));
			tfSonha.setColumns(10);
			tfSonha.setBounds(105, 161, 221, 25);
			panel_Diachi.add(tfSonha);
			tfSonha.setText(datPhong.getKhachHang().getDiaChi().getSoNha());
			tfSonha.setEnabled(false);

			JLabel lblLoiKh = new JLabel("Loại KH:");
			lblLoiKh.setFont(new Font("Times New Roman", Font.BOLD, 18));
			lblLoiKh.setBounds(10, 170, 103, 25);
			panel_thongtinKH.add(lblLoiKh);

			tfHoten.setFont(new Font("Times New Roman", Font.BOLD, 18));
			tfHoten.setBounds(116, 25, 221, 25);
			panel_thongtinKH.add(tfHoten);
			tfHoten.setColumns(10);
			tfHoten.setText(datPhong.getKhachHang().getTenKH());
			tfHoten.setEnabled(false);

			tfSoDT.setFont(new Font("Times New Roman", Font.BOLD, 18));
			tfSoDT.setColumns(10);
			tfSoDT.setBounds(116, 62, 221, 25);
			panel_thongtinKH.add(tfSoDT);
			tfSoDT.setText(datPhong.getKhachHang().getSoDT());
			tfSoDT.setEnabled(false);

			tfSoCMND.setFont(new Font("Times New Roman", Font.BOLD, 18));
			tfSoCMND.setColumns(10);
			tfSoCMND.setBounds(116, 98, 221, 25);
			panel_thongtinKH.add(tfSoCMND);
			tfSoCMND.setText(datPhong.getKhachHang().getSoCMD());
			tfSoCMND.setEnabled(false);

			ngaysinh.getSpinner().setFont(new Font("Times New Roman", Font.BOLD, 18));
			ngaysinh.setDateFormatString("dd/MM/yyyy");
			ngaysinh.setBounds(116, 134, 221, 21);
			panel_thongtinKH.add(ngaysinh);
			ngaysinh.setDate(java.sql.Date.valueOf(datPhong.getKhachHang().getNgaySinh()));
			ngaysinh.getSpinner().setEnabled(false);

			cb_LoaiKH.setFont(new Font("Times New Roman", Font.BOLD, 18));
			cb_LoaiKH.setBounds(116, 170, 103, 22);
			panel_thongtinKH.add(cb_LoaiKH);
			dfLoaiKH.setSelectedItem(datPhong.getKhachHang().getLoaiKH());
			cb_LoaiKH.setEnabled(false);

			JButton btnThoat = new JButton("Thoát");
			btnThoat.setIcon(new ImageIcon(DatPhong.class.getResource("/images/cancel.png")));
			btnThoat.setFont(new Font("Times New Roman", Font.BOLD, 28));
			btnThoat.setBounds(10, 455, 127, 35);
			btnThoat.setVerticalTextPosition(SwingConstants.CENTER);
			btnThoat.setHorizontalTextPosition(SwingConstants.LEFT);
			btnThoat.addMouseListener(new MouseListener() {

				@Override
				public void mouseReleased(MouseEvent e) {

				}

				@Override
				public void mousePressed(MouseEvent e) {

				}

				@Override
				public void mouseExited(MouseEvent e) {

				}

				@Override
				public void mouseEntered(MouseEvent e) {

				}

				@Override
				public void mouseClicked(MouseEvent e) {
					if(JOptionPane.showConfirmDialog(null,
							"Bạn có muốn thoát", "Thoát", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						dispose();
					}
				}
			});
			add(btnThoat);

			JButton btTraphong = new JButton("Trả phòng");
			btTraphong.setIcon(new ImageIcon(DatPhong.class.getResource("/images/icons8-arrow-64.png")));
			btTraphong.setFont(new Font("Times New Roman", Font.BOLD, 28));
			btTraphong.setBounds(513, 455, 191, 35);
			btTraphong.setVerticalTextPosition(SwingConstants.CENTER);
			btTraphong.setHorizontalTextPosition(SwingConstants.LEFT);
			add(btTraphong);
			btTraphong.addMouseListener(new MouseListener() {

				@Override
				public void mouseReleased(MouseEvent e) {

				}

				@Override
				public void mousePressed(MouseEvent e) {

				}

				@Override
				public void mouseExited(MouseEvent e) {

				}

				@Override
				public void mouseEntered(MouseEvent e) {

				}

				@Override
				public void mouseClicked(MouseEvent e) {
					if(JOptionPane.showConfirmDialog(null,
							"Bạn có muốn trả phòng và lập hóa đơn không?", "Trả phòng", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						traPhongev();
					}
				}
			});

			updateTongtien();
		}

		public void updateTongtien() {
			if(dfloaithue.getSelectedItem().equals(loaithue[0])) {
				long hours = ((new Date().getTime() - 
						dateChooser_nhan.getDate().getTime()))/(1000*60*60*24);
				for(long i = 1; i <= hours; i++) {
					if(i==1)
						tongTien += phong.getGiaTheogio()*hours;
					else tongTien += phong.getGiaTheogio()*hours + tongTien*0.01;
				}
				if(tongTien < phong.getGiaTheogio())
					tongTien = phong.getGiaTheogio();
				tongtien.setText(format.format(tongTien));
			}else if(dfloaithue.getSelectedItem().equals(loaithue[2])) {
				long date = ((dateChooser_tra.getDate().getTime() - 
						dateChooser_nhan.getDate().getTime()))/(1000*60*60*24);
				tongTien = (date*(phong.getGiaQuadem()*2 - phong.getGiaQuadem()*0.4));
				tongtien.setText(format.format(tongTien));
			}else {
				tongTien = phong.getGiaQuadem();
				tongtien.setText(format.format(tongTien));
			}
		}

		public void traPhongev() {
			phong.setTinhtrangPhong("Phòng trống");
			Hoadon hoadon = new Hoadon();
			hoadon.setMaHD(getAlphaString(10));
			hoadon.setKhachHang(datPhong.getKhachHang());
			hoadon.setNhanVien(nhanVien);
			hoadon.setPhong(phong);
			hoadon.setTongTien(tongTien);

			if(hoadonDAO.themHoadon(hoadon) && phongDAO.suaPhong(phong)) {
				xuatDSPhong();
				JOptionPane.showMessageDialog(null, "Trả phòng thành công!!");
				dispose();
			}else JOptionPane.showMessageDialog(null, "Trả phòng không thành công!!");
		}
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
			panel.setBackground(Color.WHITE);
			panel.add(dv = Box.createVerticalBox());
			dv.add(b1 = Box.createHorizontalBox());
			JLabel label = new JLabel();
			String img = "/images/dichvu/"+dichvu.getMaDV()+".jpg";
			label.setIcon(new ImageIcon(UIVinaHome.class.getResource(img)));
			b1.add(label);
			dv.add(b1 = Box.createHorizontalBox());
			label = new JLabel("Phở bò");
			label.setText(dichvu.getTenDV());
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setFont(new Font("Times New Roman", Font.BOLD, 24));
			b1.add(label);
			dv.add(b1 = Box.createHorizontalBox());
			JLabel gia = new JLabel("20000 VND");
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
		ChitietPhieuDichvu ctdv = new ChitietPhieuDichvu(getAlphaString(10), dichvu, value, 0);
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
		double tong = 0, thanhTien = 0;
		while(dfmodelCTHD.getRowCount() > 0)
			dfmodelCTHD.removeRow(0);
		for (ChitietPhieuDichvu chitietPhieuDichvu : dsCTDV) {
			thanhTien = chitietPhieuDichvu.getSoluong()*chitietPhieuDichvu.getDichvu().getGia();
			chitietPhieuDichvu.setThanhTien(thanhTien);
			dfmodelCTHD.addRow(new Object[] {
					table_ChitietHoadon.getRowCount() + 1, chitietPhieuDichvu.getDichvu().getTenDV(), 
					chitietPhieuDichvu.getDichvu().getLoaiDichvu().getTenLDV(),
					format.format(chitietPhieuDichvu.getDichvu().getGia()), 
					chitietPhieuDichvu.getSoluong(), 
					format.format(chitietPhieuDichvu.getSoluong()*chitietPhieuDichvu.getDichvu().getGia())
			});
			tong += thanhTien;
		}
		phieuDichvu.setThanhtien(tong);
		lbtotal.setText(format.format(tong));
		lbvat.setText(format.format(tong*0.1));
		lbsum.setText(format.format(tong*0.1 + tong));
	}

	public void btactionLapPhieuDichvu() {
		phieuDichvu.setNgaylap(LocalDate.now());
		for (ChitietPhieuDichvu chitietPhieuDichvu : phieuDichvu.getDschitietPhieuDichvu()) {
			chitietdichvuDAO.themChitietDichvu(chitietPhieuDichvu);
			Dichvu dv = chitietPhieuDichvu.getDichvu();
			dv.setSoluong(dichvuDAO.timDichvu(dv.getMaDV()).getSoluong() - chitietPhieuDichvu.getSoluong());
			dichvuDAO.suaDichvu(dv);
		}
		if(phieuDichvuDAO.themPhieuDichvu(phieuDichvu)) {
			phieuDichvu = null;
			for (int i = 0; i < 4; i++)
				spinners[i].setValue(0);
			while(dfmodelCTHD.getRowCount() > 0)
				dfmodelCTHD.removeRow(0);
			btLaphoadon.setEnabled(false);
			lbtotal.setText(format.format(0));
			lbvat.setText(format.format(0));
			lbsum.setText(format.format(0));
			JOptionPane.showMessageDialog(null, "Lập phiếu dịch vụ thành công!!");
		}else {
			JOptionPane.showMessageDialog(null, "Lập phiếu dịch vụ thất bại!!");
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

	public void timkiem() {
		if(comboBox_Tim.getItemAt(0).equals(timphong[0])) {

		}else if(comboBox_Tim.getItemAt(0).equals(dsKH[0])) {
			newFilterKH();
		}else {

		}
	}

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

	public void displayFormDSPhong() {
		label_soPhong.setVisible(true);
		lblSPhng.setVisible(true);
		panel_DSKhachHang.setVisible(false);
		panel_DanhSachPhong.setVisible(true);
		panel_Dichvu.setVisible(false);
		panel_ChitietDV.setVisible(false);
		comboBox_Tim.setModel(new DefaultComboBoxModel<String>(timphong));
		tim.requestFocus();
	}

	public void displayFormDSKhachHang() {
		label_soPhong.setVisible(false);
		lblSPhng.setVisible(false);
		panel_DSKhachHang.setVisible(true);
		panel_DanhSachPhong.setVisible(false);
		panel_Dichvu.setVisible(false);
		panel_ChitietDV.setVisible(false);
		comboBox_Tim.setModel(new DefaultComboBoxModel<String>(dsKH));
		comboBox_Tim.setSelectedIndex(1);
		tim.requestFocus();
	}

	public void displayFormDSDichvu() {
		label_soPhong.setVisible(false);
		lblSPhng.setVisible(false);
		panel_DanhSachPhong.setVisible(false);
		panel_Dichvu.setVisible(true);
		panel_DSKhachHang.setVisible(false);
		panel_ChitietDV.setVisible(true);
		comboBox_Tim.setModel(new DefaultComboBoxModel<String>(itemsDichvu));
		tim.requestFocus();
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
