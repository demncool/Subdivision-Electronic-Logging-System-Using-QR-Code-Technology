package final_;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

@SuppressWarnings({ "serial", "unused" })
public class AdminFunctions extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminFunctions frame = new AdminFunctions();
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
	public AdminFunctions() {
		setTitle("Admin");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 334, 406);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(  156, 182, 214));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Toolkit toolkit = getToolkit();
		Dimension size = toolkit.getScreenSize();
		setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
		
		JButton btnNewEmp = new JButton("New Employee");
		btnNewEmp.setIcon(new ImageIcon(AdminDashboard.class.getResource("/Images/add.png")));
		btnNewEmp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmpRegistration newEmp = new EmpRegistration();
				newEmp.setVisible(true);
			}
		});
		btnNewEmp.setBounds(85, 43, 156, 35);
		contentPane.add(btnNewEmp);
		
		JButton btnNewOwner = new JButton("New Homeowner");
		btnNewOwner.setIcon(new ImageIcon(AdminDashboard.class.getResource("/Images/add.png")));
		btnNewOwner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomeownersRegistration newOwner = new HomeownersRegistration();
				newOwner.setVisible(true);
			}
		});
		btnNewOwner.setBounds(85, 119, 156, 35);
		contentPane.add(btnNewOwner);
		
		JButton delEmp = new JButton("Delete Employee");
		delEmp.setIcon(new ImageIcon(AdminDashboard.class.getResource("/Images/cancel.png")));
		delEmp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Delete_Employee delEmp = new Delete_Employee();
				delEmp.setVisible(true);
				
			}
		});
		delEmp.setBounds(85, 205, 156, 35);
		contentPane.add(delEmp);
		
		
		
		JButton delOwner = new JButton("Delete Homeowner");
		delOwner.setIcon(new ImageIcon(AdminDashboard.class.getResource("/Images/cancel.png")));
		delOwner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Delete_Homeowner delOwner = new Delete_Homeowner();
				delOwner.setVisible(true);

			}
		});
		delOwner.setBounds(85, 283, 156, 35);
		contentPane.add(delOwner);
		
		JTextArea copy = new JTextArea();
		copy.setFont(new Font("Arial", Font.PLAIN, 7));
		copy.setText("\u00A9 2021 Group28 Thesis");
		copy.setBackground(new Color(156, 182, 214));
		copy.setBounds(10, 352, 94, 14);
		contentPane.add(copy);
		
		
	}

}
