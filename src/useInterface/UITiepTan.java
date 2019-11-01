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

import bussinessLayer.QLDiachi;
import bussinessLayer.QLDichvu;
import bussinessLayer.QLKhachhang;
import bussinessLayer.QLPhong;
import entity.ChitietPhieuDichvu;
import entity.DiaChi;
import entity.Dichvu;
import entity.KhachHang;
import entity.NhanVien;
import entity.PhieuDichvu;
import entity.Phong;
import implementsLayer.QLDiachiimp;
import implementsLayer.QLDichvuimp;
import implementsLayer.QLKhachhangimp;
import implementsLayer.QLPhongimp;

import javax.swing.JLabel;
import javax.swing.JList;
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.ZoneId;

import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.JSpinner;


@SuppressWarnings("serial")
public class UITiepTan extends JFrame {

	private JPanel contentPane;
	private JLabel time = new JLabel("20:18:45", SwingConstants.CENTER);
	private JLabel dateweek = new JLabel("Thứ hai", SwingConstants.CENTER);
	private JLabel date = new JLabel("09/12/2018", SwingConstants.CENTER);
	private JLabel label_soPhong = new JLabel("", SwingConstants.RIGHT);
	private JPanel panel_DanhSachPhong = new JPanel();
	private JPanel panel_DSKhachHang = new JPanel();
	private JPanel panel_InfoPhong = new JPanel();
	private JPanel panel_Dichvu = new JPanel();
	private JPanel panel_ChitietDV = new JPanel();
	private JPanel panel_DSDichvu = new JPanel();
	private JLabel lbTenNV = new JLabel("Nguyễn Trần Linh Nhi");
	private JLabel lbMaNV = new JLabel("NV01");
	private JLabel lbChucvu = new JLabel("Tiếp tân");
	private JButton btLaphoadon;
	private JTextField tim = new JTextField();
	private JButton[] phongs;
	private JSpinner[] spinners;
	private JTable tableDSKhachhang;
	private DefaultTableModel dfmodelDSKH;
	private JComboBox<String> cbSapxepPhong = new JComboBox<String>();
	private JComboBox<String> comboBox_Tim = new JComboBox<String>();
	private TableRowSorter<TableModel> sorterDSKH;
	private String[] itemsPhong  = new String[] {
			"Sắp xếp theo tầng", "Sắp xếp theo loại phòng",
			"Sắp xếp theo giá tăng", "Sắp xếp theo giá giảm"};
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
	
	private static EntityManager em;
	private QLKhachhangimp khachhangDAO;
	private QLDichvuimp dichvuDAO;
	private QLPhongimp phongDAO;
	QLDiachiimp diachiDAO;
	private NhanVien nhanVien = new NhanVien();
	private PhieuDichvu phieuDichvu;
	/**
	 * Create the frame.
	 */
	
	public UITiepTan(NhanVien nhanVien, EntityManager em) {
		this.nhanVien = nhanVien;
		UITiepTan.em = em;
		khachhangDAO = new QLKhachhang(em);
		dichvuDAO = new QLDichvu(em);
		phongDAO = new QLPhong(em);
		diachiDAO = new QLDiachi(em);
		
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(255, 250, 250));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));		
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label;
		/*
		 * nhân viên thông tin
		 */
		
		JPanel panel_InfoNV = new JPanel();
		panel_InfoNV.setBounds(10, 11, 435, 1030);
		panel_InfoNV.setBackground(Color.WHITE);
		contentPane.add(panel_InfoNV);
		panel_InfoNV.setLayout(null);
		
		JPanel panel_NV = new JPanel();
		panel_NV.setBackground(Color.WHITE);
		panel_NV.setBounds(0, 0, 430, 200);
		panel_InfoNV.add(panel_NV);
		panel_NV.setLayout(null);
		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder titleBorder = new TitledBorder(border, "Nhân viên");
		titleBorder.setTitleFont(new Font("Times New Roman", Font.ITALIC, 24));
		titleBorder.setTitleColor(Color.RED);
		panel_NV.setBorder(titleBorder);
		
		JLabel lbAvatar = new JLabel();
		lbAvatar.setBounds(10, 30, 120, 160);
		panel_NV.add(lbAvatar);
		lbAvatar.setIcon(new ImageIcon(UITiepTan.class.getResource("/images/ava/avatarNV01.png")));
		
		JLabel lblMSNhn = new JLabel("Mã số:");
		lblMSNhn.setBounds(140, 60, 77, 31);
		panel_NV.add(lblMSNhn);
		lblMSNhn.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JLabel lblHTnNhn = new JLabel("Họ tên:");
		lblHTnNhn.setBounds(140, 100, 84, 31);
		panel_NV.add(lblHTnNhn);
		lblHTnNhn.setFont(new Font("Times New Roman", Font.BOLD, 20));

		
		lbMaNV.setBounds(227, 60, 193, 31);
		panel_NV.add(lbMaNV);
		lbMaNV.setFont(new Font("Times New Roman", Font.BOLD, 20));
		//set ma NV
		lbMaNV.setText(nhanVien.getMaNV());
		
		
		lbTenNV.setBounds(227, 100, 193, 31);
		panel_NV.add(lbTenNV);
		lbTenNV.setFont(new Font("Times New Roman", Font.BOLD, 20));
		//set ten NV
		lbTenNV.setText(nhanVien.getTenNV());
		
		JLabel lblChcV = new JLabel("Chức vụ:");
		lblChcV.setBounds(140, 140, 84, 31);
		panel_NV.add(lblChcV);
		lblChcV.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		
		lbChucvu.setBounds(227, 140, 193, 31);
		panel_NV.add(lbChucvu);
		lbChucvu.setFont(new Font("Times New Roman", Font.BOLD, 20));
		//set chuc vu
		lbChucvu.setText(nhanVien.getChuVu());
		
		
		JPanel dsTool = new JPanel();
		dsTool.setBackground(Color.WHITE);
		dsTool.setBounds(0, 196, 430, 834);
		panel_InfoNV.add(dsTool);
		dsTool.setLayout(null);
		border = BorderFactory.createLineBorder(Color.RED);
		titleBorder = new TitledBorder(border, "Công cụ");
		titleBorder.setTitleFont(new Font("Times New Roman", Font.ITALIC, 24));
		titleBorder.setTitleColor(Color.RED);
		dsTool.setBorder(titleBorder);

		comboBox_Tim.setBounds(208, 40, 132, 38);
		dsTool.add(comboBox_Tim);
		comboBox_Tim.setForeground(new Color(0, 0, 0));
		comboBox_Tim.setModel(new DefaultComboBoxModel<String>(timphong));
		comboBox_Tim.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
	
		tim.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		tim.setBounds(35, 40, 163, 38);
		tim.setToolTipText("Tìm kiếm");
		dsTool.add(tim);
		tim.setColumns(10);
		tim.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				timkiem();
			}
		});
		JButton btnTm = new JButton();
		btnTm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timkiem();
			}
		});
		btnTm.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnTm.setIcon(new ImageIcon(UITiepTan.class.getResource("/images/tim.png")));
		btnTm.setHorizontalAlignment(SwingConstants.LEFT);
		btnTm.setBounds(350, 40, 51, 38);
		dsTool.add(btnTm);
		
		JButton btndichvu = new JButton("Danh sách dịch vụ");
		btndichvu.setHorizontalAlignment(SwingConstants.LEFT);
		btndichvu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayFormDSDichvu();
			}
		});
		
		btndichvu.setIcon(new ImageIcon(UITiepTan.class.getResource("/images/dichvu.png")));
		btndichvu.setFont(new Font("Times New Roman", Font.BOLD, 26));
		btndichvu.setBounds(35, 290, 366, 60);
		dsTool.add(btndichvu);
		
		JButton btnDanhSchKhch = new JButton("Danh sách khách hàng");
		btnDanhSchKhch.setHorizontalAlignment(SwingConstants.LEFT);
		btnDanhSchKhch.setIcon(new ImageIcon(UITiepTan.class.getResource("/images/dsKhachhang.png")));
		btnDanhSchKhch.setFont(new Font("Times New Roman", Font.BOLD, 26));
		btnDanhSchKhch.setBounds(35, 200, 366, 60);
		btnDanhSchKhch.addMouseListener(new MouseListener() {
			
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
				
				displayFormDSKhachHang();
			}
		});
		dsTool.add(btnDanhSchKhch);
		
		JButton btnDanhSchPhng = new JButton("Danh sách phòng");
		btnDanhSchPhng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDanhSchPhng.setHorizontalAlignment(SwingConstants.LEFT);
		btnDanhSchPhng.setIcon(new ImageIcon(UITiepTan.class.getResource("/images/room.png")));
		btnDanhSchPhng.setFont(new Font("Times New Roman", Font.BOLD, 26));
		btnDanhSchPhng.setBounds(35, 110, 366, 60);
		btnDanhSchPhng.addMouseListener(new MouseListener() {
			
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
				
				displayFormDSPhong();
			}
		});
		dsTool.add(btnDanhSchPhng);
		
		JButton logout = new JButton("Đăng xuất");
		logout.setBounds(35, 758, 177, 65);
		logout.addMouseListener(new MouseListener() {
			
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
	                    "Bạn có muốn đăng xuất?", "Đăng xuất", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
					logout();
			}
		});
		dsTool.add(logout);
		logout.setIcon(new ImageIcon(UITiepTan.class.getResource("/images/logout.png")));
		logout.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		//hien thi thoi gian
		clock();
		
		/*
		 * danh sach phong
		 */
		border = BorderFactory.createLineBorder(Color.RED);
		titleBorder = new TitledBorder(border, "Danh sách phòng");
		titleBorder.setTitleFont(new Font("Times New Roman", Font.BOLD, 26));
		titleBorder.setTitleColor(Color.RED);
		
				panel_InfoPhong.setBounds(1113, 11, 788, 78);
				panel_InfoPhong.setBackground(Color.WHITE);
				contentPane.add(panel_InfoPhong);
				panel_InfoPhong.setLayout(null);
				
				JLabel lblSPhng = new JLabel("Số phòng còn trống:");
				lblSPhng.setForeground(Color.BLACK);
				lblSPhng.setFont(new Font("Times New Roman", Font.BOLD, 26));
				lblSPhng.setBounds(113, 0, 226, 29);
				panel_InfoPhong.add(lblSPhng);
				
				
				label_soPhong.setForeground(Color.BLACK);
				label_soPhong.setFont(new Font("Times New Roman", Font.BOLD, 26));
				label_soPhong.setBounds(333, 3, 46, 26);
				panel_InfoPhong.add(label_soPhong);
				
				JPanel panel_PTrong = new JPanel();
				panel_PTrong.setBackground(new Color(245, 245, 220));
				panel_PTrong.setForeground(Color.WHITE);
				panel_PTrong.setBounds(475, 38, 135, 35);
				panel_InfoPhong.add(panel_PTrong);
				
				JLabel lblPhngTrng = new JLabel("Phòng trống");
				panel_PTrong.add(lblPhngTrng);
				lblPhngTrng.setFont(new Font("Times New Roman", Font.BOLD, 18));
				
				JPanel panel_Psua = new JPanel();
				panel_Psua.setBackground(Color.LIGHT_GRAY);
				panel_Psua.setForeground(Color.WHITE);
				panel_Psua.setBounds(643, 38, 135, 35);
				panel_InfoPhong.add(panel_Psua);
				
				JLabel lblP = new JLabel("P.Đang sử dụng");
				panel_Psua.add(lblP);
				lblP.setFont(new Font("Times New Roman", Font.BOLD, 18));
			
				cbSapxepPhong.setFont(new Font("Times New Roman", Font.PLAIN, 18));
				cbSapxepPhong.setModel(new DefaultComboBoxModel<String>(itemsPhong));
				cbSapxepPhong.setForeground(Color.BLACK);
				cbSapxepPhong.setBounds(428, 0, 350, 27);
				panel_InfoPhong.add(cbSapxepPhong);
		panel_DanhSachPhong.setBorder(titleBorder);
		
		panel_DanhSachPhong.setBackground(Color.WHITE);
		panel_DanhSachPhong.setBounds(445, 85, 1456, 957);
		contentPane.add(panel_DanhSachPhong);
		//Xuất danh sách phòng từ hệ thống
		xuatDSPhong();
		
		/*
		 * danh sach khach hang
		 */

		border = BorderFactory.createLineBorder(Color.RED);
		titleBorder = new TitledBorder(border, "Danh sách dịch vụ");
		titleBorder.setTitleFont(new Font("Times New Roman", Font.BOLD, 26));
		titleBorder.setTitleColor(Color.RED);
		panel_Dichvu.setBorder(titleBorder);
		panel_Dichvu.setBackground(Color.WHITE);
		panel_Dichvu.setBounds(445, 85, 1452, 574);
		panel_Dichvu.setVisible(false);
		panel_Dichvu.setVisible(false);
		contentPane.add(panel_Dichvu);
		panel_Dichvu.setLayout(new BorderLayout(0, 0));
		
		panel_DSKhachHang = new JPanel();
		panel_DSKhachHang.setBackground(Color.WHITE);
		panel_DSKhachHang.setBounds(445, 85, 1456, 957);
		panel_DSKhachHang.setVisible(false);
		border = BorderFactory.createLineBorder(Color.RED);
		titleBorder = new TitledBorder(border, "Danh sách khách hàng");
		titleBorder.setTitleFont(new Font("Times New Roman", Font.BOLD, 26));
		titleBorder.setTitleColor(Color.RED);
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
		setJTableColumnsWidth(tableDSKhachhang, 100, 270, 100, 130, 130, 130, 570);
		tableDSKhachhang.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableDSKhachhang.setRowHeight(32);
		JScrollPane scrollPaneKH = new JScrollPane(tableDSKhachhang,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		scrollPaneKH.getViewport().setBackground(Color.WHITE);
		panel_DSKhachHang.add(scrollPaneKH);
		titleBorder = new TitledBorder(border, "Chức năng");
		titleBorder.setTitleFont(new Font("Times New Roman",  Font.ITALIC, 22));
		titleBorder.setTitleColor(Color.RED);
		
		

		panel_ChitietDV = new JPanel();
		panel_ChitietDV.setBackground(Color.WHITE);
		panel_ChitietDV.setBounds(445, 654, 1449, 387);
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
		setJTableColumnsWidth(table_ChitietHoadon, 80, 270, 270, 270, 270, 275);
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
		btLaphoadon.setIcon(new ImageIcon(UITiepTan.class.getResource("/images/bill.png")));
		btLaphoadon.setFont(new Font("Times New Roman", Font.BOLD, 26));
		btLaphoadon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btactionLapPhieuDichvu();
			}
		});
		btLaphoadon.setEnabled(false);
		panel.add(btLaphoadon);
		
		time.setBounds(445, 11, 217, 66);
		contentPane.add(time);
		
		
		time.setForeground(new Color(0, 0, 255));
		time.setFont(new Font("Times New Roman", Font.PLAIN, 58));
		dateweek.setBounds(657, 0, 202, 49);
		contentPane.add(dateweek);
		
		dateweek.setForeground(new Color(0, 0, 255));
		dateweek.setFont(new Font("Times New Roman", Font.PLAIN, 36));
		date.setBounds(657, 42, 202, 39);
		contentPane.add(date);
		
		date.setForeground(new Color(0, 0, 255));
		date.setFont(new Font("Times New Roman", Font.PLAIN, 36));
	
		
		//Hien thi dich vu
		displayDSdichvu();
		updateTableKhachHang();
		
		
		tim.requestFocus();
	}
	
	public boolean xuatDSPhong() {
		List<Phong> dsphongs = phongDAO.getDSPhong();
		int soPhong = dsphongs.size(),
				soPhongTrong = 0, index = 0;

		/*
		 * tạo ds phòng
		 */
		JPanel DsPhong = new JPanel();
		DsPhong.setBackground(Color.WHITE);
		DsPhong.setBounds(28, 39, 1309, 848);
		DsPhong.setLayout(new GridLayout(0, 4, 60, 60));
		String mausac[] = {
				"#F5F5DC",	//Phòng trống
				"#D3D3D3"	//Phòng đang sử dụng
				};
		phongs = new JButton[soPhong];
		int ra = 0;
		String thongtinPhong;
		
		for (Phong phong : dsphongs) {
			thongtinPhong = String.format("<HTML>\r\n" + 
					"<center>" + 
					"Phòng %s <br>" + 
					"Loại: %s <br>" +
					"Giường: %s <br>" +
					"Tình trạng: %s <br>" + 
					"Theo giờ: %s<br>" + 
					"Qua đêm: %s<br>" + 
					"</center>" + 
					"</HTML>", phong.getSoPhong(), phong.getLoaiPhong().getTenLoaiphong(),
					phong.getGiuong().getLoaiGiuong(), phong.getTinhtrangPhong(), 
					format.format(phong.getGiaTheogio()), format.format(phong.getGiaQuadem()));
			phongs[index] = new JButton(thongtinPhong);
			ra = (phong.getTinhtrangPhong().equalsIgnoreCase("Phòng trống")) ? 0 : 1;
			soPhongTrong += (ra == 0) ? 1 : 0;
			phongs[index].setBackground(Color.decode(mausac[ra]));
			phongs[index].setFont(new Font("Times New Roman", Font.BOLD, 20));
			phongs[index].setPreferredSize(new Dimension(150, 180));
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
						new DatPhong(phong).setVisible(true);;
				}
			});
			DsPhong.add(phongs[index++]);
		}
		panel_DanhSachPhong.setLayout(new BoxLayout(panel_DanhSachPhong, BoxLayout.X_AXIS));
		JScrollPane scrollPane = new JScrollPane(DsPhong);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		panel_DanhSachPhong.add(scrollPane);
		label_soPhong.setText(Integer.toString(soPhongTrong));
		return true;
	}
	
	public class DatPhong extends JDialog {
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
		String[] loaiKH = new String[] {"Vãn lai", "Thường", "VIP"};
		DefaultComboBoxModel<String> dfLoaiKH = new DefaultComboBoxModel<String>(loaiKH);
		JComboBox<String> cb_LoaiKH = new JComboBox<String>(dfLoaiKH);
		private Phong phong;
		private KhachHang khachHang = new KhachHang();
		
		public DatPhong(Phong phong) {
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
					
				}
			});
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
		
		public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
		    return dateToConvert.toInstant()
		      .atZone(ZoneId.systemDefault())
		      .toLocalDate();
		}
	}
	
	public void displayDSdichvu() {
		panel_DSDichvu = new JPanel();
		panel_DSDichvu.setBackground(Color.WHITE);
		panel_DSDichvu.setLayout(new GridLayout(0, 4, 10 , 12));

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
			label.setIcon(new ImageIcon(UITiepTan.class.getResource(img)));
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
		ChitietPhieuDichvu ctdv = new ChitietPhieuDichvu(phieuDichvu.getMaPhieuDV(), dichvu, value, 0);
		List<ChitietPhieuDichvu> dsCTDV = phieuDichvu.getDschitietPhieuDichvu();
		if(value == 1 && !phieuDichvu.getDschitietPhieuDichvu().contains(ctdv)) {
			phieuDichvu.getDschitietPhieuDichvu().add(ctdv);
		} if(value == 0) {
			phieuDichvu.getDschitietPhieuDichvu().remove(ctdv);
		} else {
			int index = phieuDichvu.getDschitietPhieuDichvu().indexOf(ctdv);
			ctdv.setSoluong(value);
			phieuDichvu.getDschitietPhieuDichvu().set(index, ctdv);
		}
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
		lbtotal.setText(format.format(tong));
		lbvat.setText(format.format(tong*0.1));
		lbsum.setText(format.format(tong*0.1 + tong));
	}
	
	public void btactionLapPhieuDichvu() {
		phieuDichvu = null;
		for (int i = 0; i < 4; i++)
			spinners[i].setValue(0);
		while(dfmodelCTHD.getRowCount() > 0)
			dfmodelCTHD.removeRow(0);
		btLaphoadon.setEnabled(false);
		lbtotal.setText(format.format(0));
		lbvat.setText(format.format(0));
		lbsum.setText(format.format(0));
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
		//If current expression doesn't parse, don't update.
		int selected = comboBox_Tim.getSelectedIndex();
		try {
			rf = RowFilter.regexFilter("(?i)" + tim.getText().trim(), selected);
		} catch (java.util.regex.PatternSyntaxException e) {
			return;
		}
		sorterDSKH.setRowFilter(rf);
	}
	
	public void displayFormDSPhong() {
		panel_DSKhachHang.setVisible(false);
		panel_DanhSachPhong.setVisible(true);
		panel_InfoPhong.setVisible(true);
		panel_Dichvu.setVisible(false);
		panel_ChitietDV.setVisible(false);
		comboBox_Tim.setModel(new DefaultComboBoxModel<String>(timphong));
		tim.requestFocus();
	}
	
	public void displayFormDSKhachHang() {
		panel_DSKhachHang.setVisible(true);
		panel_DanhSachPhong.setVisible(false);
		panel_InfoPhong.setVisible(false);
		panel_Dichvu.setVisible(false);
		panel_ChitietDV.setVisible(false);
		comboBox_Tim.setModel(new DefaultComboBoxModel<String>(dsKH));
		tim.requestFocus();
	}
	
	public void displayFormDSDichvu() {
		panel_InfoPhong.setVisible(false);
		panel_DanhSachPhong.setVisible(false);
		panel_Dichvu.setVisible(true);
		panel_DSKhachHang.setVisible(false);
		panel_ChitietDV.setVisible(true);
		comboBox_Tim.setModel(new DefaultComboBoxModel<String>(itemsDichvu));
		tim.requestFocus();
	}
	
	public void logout() {
		dispose();
		new Login(em).setVisible(true);
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
  
        // chose a Character random from this String 
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "0123456789" +
                                    "abcdefghijklmnopqrstuvwxyz"; 
  
        // create StringBuffer size of AlphaNumericString 
        StringBuilder sb = new StringBuilder(n); 
  
        for (int i = 0; i < n; i++) { 
  
            // generate a random number between 
            // 0 to AlphaNumericString variable length 
            int index 
                = (int)(AlphaNumericString.length() 
                        * Math.random()); 
  
            // add Character one by one in end of sb 
            sb.append(AlphaNumericString 
                          .charAt(index)); 
        } 
        return sb.toString(); 
    }
}
