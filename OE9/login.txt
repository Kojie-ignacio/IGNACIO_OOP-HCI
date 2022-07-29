package mysqlconnection;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class login extends JFrame {
	
	public JFrame frmLogin;


	private JPanel contentPane;
	private JTextField txtUsername;
	private final JTextField txtPassword = new JTextField();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setTitle("LOGIN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 737, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(165, 73, 425, 37);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\iinig\\Dropbox\\My PC (LAPTOP-IUUI4HAG)\\Downloads\\New folder\\OOP\\OOP\\OE5\\src\\icon\\padlock.png"));
		lblNewLabel.setBounds(119, 146, 24, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\iinig\\Dropbox\\My PC (LAPTOP-IUUI4HAG)\\Downloads\\New folder\\OOP\\OOP\\OE5\\src\\icon\\user1.png"));
		lblNewLabel_1.setBounds(119, 73, 29, 48);
		contentPane.add(lblNewLabel_1);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/copl_db","root","");
					
					Statement stmt = (Statement)  con.createStatement();
					
					String sql = "Select * from users_tbl where username= '"+ txtUsername.getText().toString() + "' and password= '"+ txtPassword.getText().toString() +"' ";
					
					ResultSet rs = stmt.executeQuery(sql);
					
					if(rs.next()) {
						String userName = txtUsername.getText();
						Dashboard window = new Dashboard();
						window.lblUser.setText(userName);
						window.setVisible(true);
						dispose();
						
						
						JOptionPane.showMessageDialog(null, "Login Successful....", "Login Alert", 2);
					
					}
					else if(txtUsername.getText().trim().equals("")){
						JOptionPane.showMessageDialog(null, "Username is Required...", "Login Warning", 2);
					}
					else if(txtPassword.getText().trim().equals("")){
						JOptionPane.showMessageDialog(null, "Password is Required...", "Login Warning", 2);
					}else {
						JOptionPane.showMessageDialog(null, "Username or Password is Incorrect...", "Login Warning", 2);
					}

				}catch(Exception ex) {
					System.out.print(ex);
				}
			}
		});
		btnLogin.setBounds(225, 230, 128, 48);
		contentPane.add(btnLogin);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnExit.setBounds(393, 230, 111, 48);
		contentPane.add(btnExit);
		txtPassword.setBounds(165, 146, 425, 36);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
	}
}
