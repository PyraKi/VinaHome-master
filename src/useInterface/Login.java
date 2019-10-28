package useInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bussinessLayer.QLNhanVien;
import entity.NhanVien;

import java.awt.Color;
import java.awt.Button;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField username;
	private JPasswordField passwordField;
	private static EntityManager em;
	
	int xx,xy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		em = Persistence.createEntityManagerFactory("VinaHome-master").createEntityManager();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.	
	 */
	public Login() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 729, 476);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setVisible(true);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(193, 154, 107));
		panel.setBounds(0, 0, 346, 490);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("VinaHome");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(105, 305, 119, 27);
		panel.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				 xx = e.getX();
			     xy = e.getY();
			}
		});
		label.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				
				int x = arg0.getXOnScreen();
	            int y = arg0.getYOnScreen();
	            Login.this.setLocation(x - xx, y - xy);  
			}
		});
		label.setBounds(-38, 0, 420, 275);
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setIcon(new ImageIcon(Login.class.getResource("/images/bg.jpg")));
		panel.add(label);
		
		JLabel lblWeGotYou = new JLabel("At VinaHome, We Love Having You Here.");
		lblWeGotYou.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeGotYou.setForeground(new Color(0, 0, 0));
		lblWeGotYou.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblWeGotYou.setBounds(21, 343, 298, 54);
		panel.add(lblWeGotYou);
		
		Button btLogin = new Button("Login");
		btLogin.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btLogin.setForeground(Color.WHITE);
		btLogin.setBackground(new Color(241, 57, 83));
		btLogin.setBounds(395, 334, 283, 36);
		contentPane.add(btLogin);
		btLogin.addMouseListener(new MouseListener() {
			
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
				
				checklog();
			}
		});
		
		username = new JTextField();
		username.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		username.setBounds(395, 146, 283, 36);
		contentPane.add(username);
		username.setColumns(10);
		username.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				checklog();
			}
		});
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblUsername.setBounds(396, 121, 114, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblPassword.setBounds(395, 207, 96, 14);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		passwordField.setBounds(395, 232, 283, 36);
		contentPane.add(passwordField);
		passwordField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				checklog();
			}
		});
	}
	
	public void checklog() {
		String id = username.getText().trim();
		@SuppressWarnings("deprecation")
		String pw = passwordField.getText().trim();
		
		//by pass
		id = "nv001";
		pw = "123123";
		
		if(id.isEmpty() || pw.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Bạn chưa nhập đầy đủ thông tin!!", "Thông báo", 1);
		}else {
			NhanVien nv = new QLNhanVien(em).getLogin(id, pw);
			if(nv != null) {
				if(nv.getChuVu().equalsIgnoreCase("Tiếp tân"))
					new UITiepTan(nv).setVisible(true);	
				dispose();
			}
			else
				JOptionPane.showMessageDialog(null, "Sai tên tài khoản hoặc mật khẩu!!", "Thông báo", 1);
		}
	}
}
