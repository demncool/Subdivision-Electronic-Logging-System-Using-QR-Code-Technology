package final_;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings({ "serial", "unused" })
public class AdminLogin extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin frame = new AdminLogin();
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
	
	
	@SuppressWarnings("deprecation")
	private void login() {
		
		String user = username.getText();
		String pass = password.getText();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/databasethesis1?useTimezone=true&serverTimezone=UTC", "databasethesis1", "databasethesis1");
			Statement fetch = con.createStatement();
			String admin = "Select * from employees where username = '" + user +"' and password = '" + pass + "'";
			
			ResultSet result = fetch.executeQuery(admin);
			
			if (user.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Enter username....", "ERROR", JOptionPane.ERROR_MESSAGE);
			}else if (pass.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Enter password....", "ERROR", JOptionPane.ERROR_MESSAGE);
			}else if (result.next()) {
				dispose();
				AdminDashboard adminWindow = new AdminDashboard();
				adminWindow.setVisible(true);
				con.close();
				
			}			
			else
				JOptionPane.showMessageDialog(null, "Incorrect password or username", "ERROR", JOptionPane.ERROR_MESSAGE);
			con.close();
			
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	public AdminLogin() {
		setResizable(false);
		setTitle("Admin Login");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 416, 276);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setFont(new Font("Monospaced", Font.PLAIN, 20));
		lblNewLabel.setBounds(54, 55, 116, 20);
		contentPane.add(lblNewLabel);
		
		username = new JTextField();
		username.setFont(new Font("Tahoma", Font.PLAIN, 20));
		username.setBounds(180, 55, 163, 20);
		contentPane.add(username);
		username.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Monospaced", Font.PLAIN, 20));
		lblPassword.setBounds(54, 86, 116, 20);
		contentPane.add(lblPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addKeyListener(new KeyAdapter() {	
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnLogin.setBounds(146, 154, 101, 29);
		contentPane.add(btnLogin);
		
		password = new JPasswordField();
		password.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		password.setBounds(180, 90, 163, 20);
		contentPane.add(password);
		
		Toolkit toolkit = getToolkit();
		Dimension size = toolkit.getScreenSize();
		setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
		
	}
}
