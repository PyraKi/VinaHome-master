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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import bussinessLayer.QLDichvu;
import bussinessLayer.QLKhachhang;
import bussinessLayer.QLPhong;
import entity.ChitietPhieuDichvu;
import entity.Dichvu;
import entity.KhachHang;
import entity.NhanVien;
import entity.PhieuDichvu;
import entity.Phong;
import implementsLayer.QLDichvuimp;
import implementsLayer.QLKhachhangimp;
import implementsLayer.QLPhongimp;

import javax.swing.JLabel;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.swing.SwingConstants;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;

import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;
import java.awt.Component;

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
	private JTextField tim;
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
	private boolean focusable = true; 
	private Locale locale = new Locale("vi", "VN");
	private NumberFormat format = NumberFormat.getCurrencyInstance(locale);
	private SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
	
	private static final EntityManager em = Persistence.createEntityManagerFactory("VinaHome-master").createEntityManager();
	private QLKhachhangimp khachhangDAO = new QLKhachhang(em);
	private QLDichvuimp dichvuDAO = new QLDichvu(em);
	private QLPhongimp phongDAO = new QLPhong(em);
	private NhanVien nhanVien = new NhanVien();
	private PhieuDichvu phieuDichvu;

	/**
	 * Create the frame.
	 */
	
	public UITiepTan(NhanVien nhanVien) {
		//set nv
		this.nhanVien = nhanVien;
		
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
		
		tim = new JTextField();
		tim.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		tim.setBounds(35, 40, 163, 38);
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
					"Tình trạng: %s <br>" + 
					"Theo giờ: %s<br>" + 
					"Qua đêm: %s<br>" + 
					"</center>" + 
					"</HTML>", phong.getSoPhong(), phong.getTinhtrangPhong(), 
					format.format(phong.getGiaTheogio()), format.format(phong.getGiaQuadem()));
			phongs[index] = new JButton(thongtinPhong);
			ra = (phong.getTinhtrangPhong().equalsIgnoreCase("Phòng trống")) ? 0 : 1;
			soPhongTrong += (ra == 0) ? 1 : 0;
			phongs[index].setBackground(Color.decode(mausac[ra]));
			phongs[index].setFont(new Font("Times New Roman", Font.BOLD, 18));
//			phongs[index].setPreferredSize(new Dimension(150, 180));
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
					if(focusable)
						btdatPhong();
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
	
	public void btdatPhong() {
		
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
					khachhang.getSoCMD(), sf.format(khachhang.getNgaySinh()), khachhang.getSoDT(),
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
		new Login();
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
