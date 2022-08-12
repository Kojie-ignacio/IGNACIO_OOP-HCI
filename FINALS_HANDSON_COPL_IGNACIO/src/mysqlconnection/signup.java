package mysqlconnection;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.SystemColor;

public class signup extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JTextField txtPassword2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signup frame = new signup();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
public signup() {
	setForeground(Color.YELLOW);
	initialize();
	addAccount();
}
	/**
	 * Create the frame.
	 */
private void initialize() {
		setTitle("SIGN UP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 899, 514);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 232, 170));
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(271, 109, 348, 49);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(271, 188, 348, 49);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
		
		txtPassword2 = new JTextField();
		txtPassword2.setBounds(271, 258, 348, 49);
		contentPane.add(txtPassword2);
		txtPassword2.setColumns(10);
		
		JButton btnSignup1 = new JButton("SIGN UP");
		btnSignup1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addAccount();
			}
		});
		btnSignup1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSignup1.setBounds(271, 329, 131, 35);
		contentPane.add(btnSignup1);
		
		JButton btnLogin1 = new JButton("LOGIN");
		btnLogin1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			login window = new login();
	        window.setVisible(true);
	        dispose();
			}
		});
		btnLogin1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLogin1.setBounds(688, 258, 131, 35);
		contentPane.add(btnLogin1);
		
		JLabel lblNewLabel = new JLabel("USERNAME");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(58, 123, 91, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPassword.setBounds(58, 202, 105, 35);
		contentPane.add(lblPassword);
		
		JLabel lblReenterPassword = new JLabel("RE-ENTER PASSWORD");
		lblReenterPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblReenterPassword.setBounds(58, 272, 194, 35);
		contentPane.add(lblReenterPassword);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnClear.setBounds(436, 329, 131, 35);
		contentPane.add(btnClear);
		
		JLabel lblNewLabel_1 = new JLabel("Already have");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBackground(Color.RED);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(698, 157, 105, 80);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("an Account?");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBackground(Color.RED);
		lblNewLabel_1_1.setBounds(698, 213, 105, 35);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\iinig\\Dropbox\\My PC (LAPTOP-IUUI4HAG)\\Downloads\\New folder\\OOP\\OOP\\OE5\\src\\icon\\signup.png"));
		lblNewLabel_2.setBounds(688, 25, 131, 89);
		contentPane.add(lblNewLabel_2);
	}
static Connection connect() {
	try {
		String myDriver = "com.mysql.cj.jdbc.Driver";
		//connection string
		String url = "jdbc:mysql://localhost:3306/copl_db";
		Class.forName(myDriver);
		return (Connection)DriverManager.getConnection(url,"root","");
		
	}catch(Exception e) {
		System.out.print("Cannot connect to the database");
	}
	return null;
}

public void addAccount() {
	
			
	try {
		Connection con = connect();
		Statement stmt = (Statement)  con.createStatement();
		
		
		
		String sql1 = "Select * from users_tbl where username ='"+txtUsername.getText()+ "'";
		ResultSet rs = stmt.executeQuery(sql1);
		if(rs.next()){
			JOptionPane.showMessageDialog(null,"username:"+txtUsername.getText()+" "+"already exists");
			
			
		}else {
			String sql = "INSERT INTO users_tbl (username, password, re_password) VALUES (?,?,?)";
			PreparedStatement ps =(PreparedStatement) con.prepareStatement(sql);
			
			ps.setString(1,txtUsername.getText());
			ps.setString(2,txtPassword.getText());
			ps.setString(3,txtPassword2.getText());
			ps.execute();
			
			JOptionPane.showMessageDialog(null,"Account Registered...");
		}
		
		
		
	}catch(Exception e) {
		System.out.print("Error..." + e);
	}
}
}

