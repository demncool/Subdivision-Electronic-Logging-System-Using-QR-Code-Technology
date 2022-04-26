package final_;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.EtchedBorder;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

@SuppressWarnings({ "unused", "serial" })
public class Delete_Homeowner extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	String pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete_Homeowner frame = new Delete_Homeowner();
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
	public Delete_Homeowner() {
		setResizable(false);
		setTitle("Remove Homeowner");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 319, 311);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 283, 250);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setBackground(new Color(  156, 182, 214));
		
		JLabel lblNewLabel = new JLabel("Remove Homeowner");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Monospaced", Font.BOLD, 18));
		lblNewLabel.setBounds(39, 11, 207, 33);
		panel.add(lblNewLabel);
		
		JPanel panelIDinput = new JPanel();
		panelIDinput.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelIDinput.setBounds(21, 55, 239, 74);
		panel.add(panelIDinput);
		panelIDinput.setBackground(new Color(156, 182, 214));
		panelIDinput.setLayout(null);
		
		id = new JTextField();
		id.setBounds(10, 30, 219, 20);
		panelIDinput.add(id);
		id.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Input ID:");
		lblNewLabel_1.setBounds(10, 11, 92, 14);
		panelIDinput.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Monospaced", Font.PLAIN, 13));
		
		JButton btnConfirm = new JButton("CONFIRM");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
			     String ownerID = id.getText();
			 	try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/databasethesis1?useTimezone=true&serverTimezone=UTC", "databasethesis1", "databasethesis1");
					
					String adminCheck = "Select * from employees where password = '" + pass + "'";
					String IDCheck = "Select * from homeowners where homeowner_ID = '" + ownerID + "'";
					String IDDeleteQry = "Delete from homeowners where homeowner_ID = '" + ownerID + "'";
					
					Statement fetch = con.createStatement();
					Statement fetch2 = con.createStatement();
					
					ResultSet checkAdmin = fetch2.executeQuery(adminCheck);
					ResultSet checkID = fetch.executeQuery(IDCheck);
					PreparedStatement exeDelete = con.prepareStatement(IDDeleteQry);
					
					if(ownerID.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Enter Homeowner ID", "ERROR", JOptionPane.ERROR_MESSAGE);
					}else if(checkID.next()) {
						pass = JOptionPane.showInputDialog(null, "Enter Password", 
				                "Admin Confirmation", JOptionPane.INFORMATION_MESSAGE);
						System.out.println(pass);
						if(checkAdmin.next()) { //false
							JOptionPane.showMessageDialog(null, "IncorrectPassword", "ERROR", JOptionPane.ERROR_MESSAGE);
						}else {
							exeDelete.executeUpdate();
							JOptionPane.showMessageDialog(null, "Delete successfully", null, JOptionPane.ERROR_MESSAGE);
							dispose();
							con.close();
						}
					}else {
						JOptionPane.showMessageDialog(null, "ID does not exist", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					
					
					
				}catch (Exception e1) {
					System.out.println(e1);
				}
			}
		});
		btnConfirm.setBounds(96, 170, 89, 23);
		panel.add(btnConfirm);
		
		Toolkit toolkit = getToolkit();
		Dimension size = toolkit.getScreenSize();
		setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
	}
}
