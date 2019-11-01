package useInterface;

import java.net.MalformedURLException;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class Demo extends JFrame{
	private static EntityManager em;
	public Demo() throws MalformedURLException {
		JWindow window = new JWindow();
		window.getContentPane().add(
				new JLabel("", new ImageIcon(Demo.class.getResource("/images/loading.gif")),
						SwingConstants.CENTER));
		window.setBounds(0, 0, 750, 450);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		try {
			em = Persistence.createEntityManagerFactory("VinaHome-master").createEntityManager();
			Thread.sleep(800);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		window.setVisible(false);
		window.dispose();
		new Login(em).setVisible(true);
	}
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
			new Demo();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

