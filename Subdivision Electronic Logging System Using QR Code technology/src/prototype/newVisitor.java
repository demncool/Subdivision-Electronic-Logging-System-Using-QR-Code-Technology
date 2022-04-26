package prototype;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.CardLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JLayeredPane;
import java.awt.Panel;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class newVisitor extends JFrame {

	private JPanel contentPane;
	private JPanel visitorPanel;
	private JPanel deliverPanel;
	private JPanel taxiPanel;
	private JLayeredPane layeredPane;
	private JTextField visitorName;
	private JTextField visitorAddress;
	private JTextField visitorMobilenumber;
	private JTextField deliveryName;
	private JTextField deliveryPlate;
	private JTextField taxiName;
	private JTextField taxiPlate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newVisitor frame = new newVisitor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public void switchPanel(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
	
	
	/**
	 * Create the frame.
	 */
	public newVisitor() {
		setResizable(false);
		setTitle("Registration");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 869, 567);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(156, 182, 214));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Toolkit toolkit = getToolkit();
		Dimension size = toolkit.getScreenSize();
		setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
		
		JLabel lblNewLabel = new JLabel("New Visitor");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Century", Font.PLAIN, 25));
		lblNewLabel.setBounds(322, 0, 188, 49);
		contentPane.add(lblNewLabel);
		
		//new visitor panel
		JPanel newVisitor = new JPanel();
		newVisitor.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Registration", TitledBorder.LEFT, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		newVisitor.setBounds(10, 43, 843, 467);
		newVisitor.setBackground(new Color(206, 199, 198));
		contentPane.add(newVisitor);
		newVisitor.setLayout(null);
		
		JPanel visitorType = new JPanel();
		visitorType.setBounds(10, 22, 245, 434);
		newVisitor.add(visitorType);
		visitorType.setLayout(null);
		visitorType.setBackground(SystemColor.menu);
		
		
		JLabel lblNewLabel_1 = new JLabel("Visitor Type");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblNewLabel_1.setBounds(10, 11, 225, 25);
		visitorType.add(lblNewLabel_1);
		
		
		
		JPanel Registration = new JPanel();
		Registration.setBounds(265, 22, 568, 434);
		newVisitor.add(Registration);
		Registration.setLayout(null);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(10, 11, 548, 412);
		Registration.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		visitorPanel = new JPanel();
		layeredPane.add(visitorPanel, "name_8343560175000");
		visitorPanel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("RELATIVE");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblNewLabel_2.setBounds(202, 0, 120, 20);
		visitorPanel.add(lblNewLabel_2);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		lblName.setFont(new Font("Monospaced", Font.PLAIN, 17));
		lblName.setBounds(40, 88, 78, 20);
		visitorPanel.add(lblName);
		
		visitorName = new JTextField();
		visitorName.setBounds(202, 90, 251, 20);
		visitorPanel.add(visitorName);
		visitorName.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setHorizontalAlignment(SwingConstants.LEFT);
		lblAddress.setFont(new Font("Monospaced", Font.PLAIN, 17));
		lblAddress.setBounds(40, 150, 78, 20);
		visitorPanel.add(lblAddress);
		
		visitorAddress = new JTextField();
		visitorAddress.setColumns(10);
		visitorAddress.setBounds(202, 152, 251, 20);
		visitorPanel.add(visitorAddress);
		
		JLabel lblMobileNumber = new JLabel("Mobile Number:");
		lblMobileNumber.setHorizontalAlignment(SwingConstants.LEFT);
		lblMobileNumber.setFont(new Font("Monospaced", Font.PLAIN, 17));
		lblMobileNumber.setBounds(40, 213, 152, 20);
		visitorPanel.add(lblMobileNumber);
		
		visitorMobilenumber = new JTextField();
		visitorMobilenumber.setColumns(10);
		visitorMobilenumber.setBounds(202, 215, 251, 20);
		visitorPanel.add(visitorMobilenumber);
		
		JButton btnRelativeRegister = new JButton("Register");
		btnRelativeRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  
		        JDialog d = new JDialog();  
		        d.getContentPane().add(new JLabel("Generating QR CODE...."));
		        d.setSize(200,80);
		        d.setLocation(getMousePosition());
		       
		        
		     // Set a 2 second timer
				new Thread(new Runnable() {
					@Override
					public void run() {
						try {
							Thread.sleep(2000);
						} catch (Exception e) {
						}
						d.dispose();
						
						 QRCode qr = new QRCode();
						 qr.setVisible(true);
					}

				}).start();
		        
				 d.setVisible(true);
				 
				
				 
				 
			}
		});
		btnRelativeRegister.setBounds(224, 367, 89, 23);
		visitorPanel.add(btnRelativeRegister);
		
		deliverPanel = new JPanel();
		layeredPane.add(deliverPanel, "name_8343575820300");
		deliverPanel.setLayout(null);
		
		JLabel lblNewLabel_2_3 = new JLabel("DELIVERY");
		lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_3.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblNewLabel_2_3.setBounds(222, 0, 120, 20);
		deliverPanel.add(lblNewLabel_2_3);
		
		JLabel lblCompany = new JLabel("Company:");
		lblCompany.setHorizontalAlignment(SwingConstants.LEFT);
		lblCompany.setFont(new Font("Monospaced", Font.PLAIN, 17));
		lblCompany.setBounds(37, 111, 108, 20);
		deliverPanel.add(lblCompany);
		
		deliveryName = new JTextField();
		deliveryName.setColumns(10);
		deliveryName.setBounds(194, 113, 251, 20);
		deliverPanel.add(deliveryName);
		
		JLabel lblPlateNumber = new JLabel("Plate Number:");
		lblPlateNumber.setHorizontalAlignment(SwingConstants.LEFT);
		lblPlateNumber.setFont(new Font("Monospaced", Font.PLAIN, 17));
		lblPlateNumber.setBounds(37, 190, 147, 20);
		deliverPanel.add(lblPlateNumber);
		
		deliveryPlate = new JTextField();
		deliveryPlate.setColumns(10);
		deliveryPlate.setBounds(194, 192, 251, 20);
		deliverPanel.add(deliveryPlate);
		
		JButton btnDeliverRegister = new JButton("Register");
		btnDeliverRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDialog d = new JDialog();  
		        d.getContentPane().add(new JLabel("Generating QR CODE...."));
		        d.setSize(200,80);
		        d.setLocation(getMousePosition());
		       
		        
		     // Set a 2 second timer
				new Thread(new Runnable() {
					@Override
					public void run() {
						try {
							Thread.sleep(2000);
						} catch (Exception e) {
						}
						d.dispose();
						
						 QRCode qr = new QRCode();
						 qr.setVisible(true);
					}

				}).start();
		        
				 d.setVisible(true);
			}
		});
		btnDeliverRegister.setBounds(253, 321, 89, 23);
		deliverPanel.add(btnDeliverRegister);
		
		taxiPanel = new JPanel();
		layeredPane.add(taxiPanel, "name_8343592108800");
		taxiPanel.setLayout(null);
		
		JLabel lblNewLabel_2_1 = new JLabel("TAXI");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblNewLabel_2_1.setBounds(206, 0, 120, 20);
		taxiPanel.add(lblNewLabel_2_1);
		
		JLabel lblName_1 = new JLabel("Name:");
		lblName_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblName_1.setFont(new Font("Monospaced", Font.PLAIN, 17));
		lblName_1.setBounds(35, 127, 108, 20);
		taxiPanel.add(lblName_1);
		
		taxiName = new JTextField();
		taxiName.setColumns(10);
		taxiName.setBounds(192, 129, 251, 20);
		taxiPanel.add(taxiName);
		
		JLabel lblPlateNumber_1 = new JLabel("Plate Number:");
		lblPlateNumber_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblPlateNumber_1.setFont(new Font("Monospaced", Font.PLAIN, 17));
		lblPlateNumber_1.setBounds(35, 206, 147, 20);
		taxiPanel.add(lblPlateNumber_1);
		
		taxiPlate = new JTextField();
		taxiPlate.setColumns(10);
		taxiPlate.setBounds(192, 208, 251, 20);
		taxiPanel.add(taxiPlate);
		
		JButton btnTaxiRegister = new JButton("Register");
		btnTaxiRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDialog d = new JDialog();  
		        d.getContentPane().add(new JLabel("Generating QR CODE...."));
		        d.setSize(200,80);
		        Toolkit toolkit = getToolkit();
		        Dimension size = toolkit.getScreenSize();
		        d.setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
		       
		        
		     // Set a 2 second timer
				new Thread(new Runnable() {
					@Override
					public void run() {
						try {
							Thread.sleep(2000);
						} catch (Exception e) {
						}
						d.dispose();
						
						 QRCode qr = new QRCode();
						 qr.setVisible(true);
					}

				}).start();
		        
				 d.setVisible(true);
			}
		});
		btnTaxiRegister.setBounds(247, 344, 89, 23);
		taxiPanel.add(btnTaxiRegister);
		
		JButton btnRelative = new JButton("Relatives/ Friends");
		btnRelative.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRelative.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(visitorPanel);
			}
		});
		btnRelative.setBounds(42, 98, 160, 57);
		visitorType.add(btnRelative);
		
		JButton btnTaxi = new JButton("TAXI");
		btnTaxi.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTaxi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(taxiPanel);
			}
		});
		btnTaxi.setBounds(42, 341, 160, 57);
		visitorType.add(btnTaxi);
		
		JButton btnDeliver = new JButton("DELIVERY");
		btnDeliver.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDeliver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(deliverPanel);
			}
		});
		btnDeliver.setBounds(42, 215, 160, 57);
		visitorType.add(btnDeliver);
		
		
		
	}
}
