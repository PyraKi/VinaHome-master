package useInterface;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import java.awt.Color;
import java.awt.Font;


@SuppressWarnings("serial")
public class DatPhong extends JFrame{

	private JPanel contentPane;
	public DatPhong() {
		setBounds(100, 100, 640, 690);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	    super.requestFocus();
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_infoPhong = new JPanel();
		panel_infoPhong.setBackground(Color.WHITE);
		panel_infoPhong.setBounds(0, 0, 634, 595);
		contentPane.add(panel_infoPhong);
		panel_infoPhong.setLayout(null);
		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder titleBorder = new TitledBorder(border, "Thông tin phòng");
		titleBorder.setTitleFont(new Font("Times New Roman", Font.ITALIC, 24));
		titleBorder.setTitleColor(Color.RED);
		panel_infoPhong.setBorder(titleBorder);
		
	}
	 
}
