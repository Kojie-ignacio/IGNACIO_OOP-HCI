package mysqlconnection;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Dashboard extends JFrame {

	public JFrame frmMain;
	JLabel lblUser;
	
	private JPanel contentPane;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard();
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
	public Dashboard() {
		setTitle("DashBoard");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 789, 455);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	
	
		lblNewLabel = new JLabel("Welcome to the Dashboard");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 29));
		lblNewLabel.setBounds(189, 72, 408, 37);
		contentPane.add(lblNewLabel);
		
		
		
		lblUser = new JLabel();
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblUser.setBounds(340, 144, 151, 29);
		contentPane.add(lblUser);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\iinig\\Dropbox\\My PC (LAPTOP-IUUI4HAG)\\Downloads\\New folder\\OOP\\OOP\\OE5\\src\\icon\\prof2.png"));
		lblNewLabel_1.setBounds(317, 218, 128, 139);
		contentPane.add(lblNewLabel_1);
	}
}
