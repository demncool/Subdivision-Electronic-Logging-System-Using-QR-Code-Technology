package final_;

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
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.CardLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.RootPaneContainer;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.Panel;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


import com.toedter.calendar.JDateChooser;
import javax.swing.JRadioButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

@SuppressWarnings("unused")
public class newVisitor extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel relativeOrFriendsPanel;
	private JPanel deliverPanel;
	private JPanel taxiPanel;
	private JLayeredPane layeredPane;
	private JTextField visitorF_name;
	private JTextField visitorAddress;
	private JTextField visitorMobilenumber;
	private JTextField visitorUsername;
	private JTextField visitorM_name;
	private JTextField visitorL_name;
	private JTextField deliverUsername;
	private JTextField deliverF_name;
	private JTextField deliverM_name;
	private JTextField deliverL_name;
	private JTextField deliverAddress;
	private JTextField deliverNumber;
	private JTextField taxiUsername;
	private JTextField taxiF_name;
	private JTextField taxiM_name;
	private JTextField taxiL_name;
	private JTextField taxiAddress;
	private JTextField taxiNumber;
	private ButtonGroup group = new ButtonGroup();
	boolean male = false, female = false;
	String sex;
	private JTextField othersF_name;
	private JTextField othersM_name;
	private JTextField othersL_name;
	private JTextField othersAddress;
	private JTextField othersNumber;
	private JTextField othersUsername;

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
	
	
	static String generateID() {
		  int rnd = (int) (Math.random() * 10);
		  String chars = "abcdefghijklmnopqqrstuvwxyz";
		  String chars2 = "ABCDEFGHIKLMNOPQRSTVXYZ";
			Random rand = new Random();
			char c = chars.charAt(rand.nextInt(chars.length()));
			char c2 = chars2.charAt(rand.nextInt(chars2.length()));
			String num = Integer.toString(rnd);
			
			String ID = num + c + c2;
		    
			return ID;
	}
	
	static String generatePassword() {
		 int rnd = (int) (Math.random() * 10);
		  String chars = "abcdefghijklmnopqqrstuvwxyz";
		  String chars2 = "ABCDEFGHIKLMNOPQRSTVXYZ";
			Random rand = new Random();
			char c = chars.charAt(rand.nextInt(chars.length()));
			char c2 = chars2.charAt(rand.nextInt(chars2.length()));
			String num = Integer.toString(rnd);
			
			String password = num + c + c2;
		    
			return password;
		
	}
	
	static void restartFrame() {
		newVisitor restart = new newVisitor();
		restart.setVisible(true);
	}
	
	@SuppressWarnings({ "deprecation", "unchecked", "rawtypes" })
	public static void createQRCode(String qrCodeData, String filePath, String charset, Map hintMap, int qrCodeheight,
			int qrCodewidth) throws WriterException, IOException {
		BitMatrix matrix = new MultiFormatWriter().encode(new String(qrCodeData.getBytes(charset), charset),
				BarcodeFormat.QR_CODE, qrCodewidth, qrCodeheight, hintMap);
		MatrixToImageWriter.writeToFile(matrix, filePath.substring(filePath.lastIndexOf('.') + 1), new File(filePath));
	}

	
	/**
	 * Create the frame.
	 */
	public newVisitor() {
		setResizable(false);
		setTitle("Registration");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 926, 668);
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
		lblNewLabel.setBounds(421, 0, 188, 49);
		contentPane.add(lblNewLabel);
		
		//new visitor panel
		JPanel newVisitor = new JPanel();
		newVisitor.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Registration", TitledBorder.LEFT, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		newVisitor.setBounds(10, 43, 900, 585);
		newVisitor.setBackground(new Color(206, 199, 198));
		contentPane.add(newVisitor);
		newVisitor.setLayout(null);
		
		JPanel visitorType = new JPanel();
		visitorType.setBounds(10, 22, 245, 549);
		newVisitor.add(visitorType);
		visitorType.setLayout(null);
		visitorType.setBackground(SystemColor.menu);
		
		
		JLabel lblNewLabel_1 = new JLabel("Visitor Type");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblNewLabel_1.setBounds(10, 11, 225, 25);
		visitorType.add(lblNewLabel_1);
		
		
		
		JPanel Registration = new JPanel();
		Registration.setBounds(265, 22, 625, 549);
		newVisitor.add(Registration);
		Registration.setLayout(null);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(10, 11, 599, 530);
		Registration.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		relativeOrFriendsPanel = new JPanel();
		relativeOrFriendsPanel.setToolTipText("");
		relativeOrFriendsPanel.setOpaque(false);
		layeredPane.add(relativeOrFriendsPanel, "name_8343560175000");
		relativeOrFriendsPanel.setLayout(null);
		
		// --------------------------  Details For Relative and Friends-------------------------------//
		
		JLabel type = new JLabel("RELATIVE");
		type.setHorizontalAlignment(SwingConstants.CENTER);
		type.setFont(new Font("Monospaced", Font.BOLD, 20));
		type.setBounds(246, 11, 120, 20);
		relativeOrFriendsPanel.add(type);
		
		JLabel lblF_name = new JLabel("First Name:");
		lblF_name.setHorizontalAlignment(SwingConstants.LEFT);
		lblF_name.setFont(new Font("Monospaced", Font.PLAIN, 17));
		lblF_name.setBounds(84, 78, 126, 20);
		relativeOrFriendsPanel.add(lblF_name);
		
		visitorF_name = new JTextField();
		visitorF_name.setToolTipText("first name");
		visitorF_name.setBounds(246, 80, 251, 20);
		relativeOrFriendsPanel.add(visitorF_name);
		visitorF_name.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setHorizontalAlignment(SwingConstants.LEFT);
		lblAddress.setFont(new Font("Monospaced", Font.PLAIN, 17));
		lblAddress.setBounds(84, 237, 78, 20);
		relativeOrFriendsPanel.add(lblAddress);
		
		visitorAddress = new JTextField();
		visitorAddress.setToolTipText("address");
		visitorAddress.setColumns(10);
		visitorAddress.setBounds(246, 239, 251, 20);
		relativeOrFriendsPanel.add(visitorAddress);
		
		JLabel lblMobileNumber = new JLabel("Mobile Number:");
		lblMobileNumber.setHorizontalAlignment(SwingConstants.LEFT);
		lblMobileNumber.setFont(new Font("Monospaced", Font.PLAIN, 17));
		lblMobileNumber.setBounds(84, 299, 152, 20);
		relativeOrFriendsPanel.add(lblMobileNumber);
		
		visitorMobilenumber = new JTextField();
		visitorMobilenumber.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char input = e.getKeyChar(); //each time user type
				if(input < '0' || input > '9'){
					e.consume(); // backspace will block anything that is not a number
				}else if(visitorMobilenumber.getText().length() == 11) {
					e.consume();
				}
			}
		});
		visitorMobilenumber.setToolTipText("number");
		visitorMobilenumber.setColumns(10);
		visitorMobilenumber.setBounds(246, 301, 251, 20);
		relativeOrFriendsPanel.add(visitorMobilenumber);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsername.setFont(new Font("Monospaced", Font.PLAIN, 17));
		lblUsername.setBounds(84, 175, 126, 20);
		relativeOrFriendsPanel.add(lblUsername);
		
		visitorUsername = new JTextField();
		visitorUsername.setToolTipText("username");
		visitorUsername.setColumns(10);
		visitorUsername.setBounds(246, 177, 251, 20);
		relativeOrFriendsPanel.add(visitorUsername);
		
		visitorM_name = new JTextField();
		visitorM_name.setToolTipText("middle name");
		visitorM_name.setColumns(10);
		visitorM_name.setBounds(246, 111, 251, 20);
		relativeOrFriendsPanel.add(visitorM_name);
		
		visitorL_name = new JTextField();
		visitorL_name.setToolTipText("last name");
		visitorL_name.setColumns(10);
		visitorL_name.setBounds(246, 144, 251, 20);
		relativeOrFriendsPanel.add(visitorL_name);
		
		JLabel lblF_name_1 = new JLabel("Middle Name:");
		lblF_name_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblF_name_1.setFont(new Font("Monospaced", Font.PLAIN, 17));
		lblF_name_1.setBounds(84, 109, 126, 20);
		relativeOrFriendsPanel.add(lblF_name_1);
		
		JLabel lblF_name_2 = new JLabel("Last Name:");
		lblF_name_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblF_name_2.setFont(new Font("Monospaced", Font.PLAIN, 17));
		lblF_name_2.setBounds(84, 142, 126, 20);
		relativeOrFriendsPanel.add(lblF_name_2);
		
		JLabel lblBirthday = new JLabel("Birthday:");
		lblBirthday.setHorizontalAlignment(SwingConstants.LEFT);
		lblBirthday.setFont(new Font("Monospaced", Font.PLAIN, 17));
		lblBirthday.setBounds(84, 268, 126, 20);
		relativeOrFriendsPanel.add(lblBirthday);
		
		JDateChooser visitorBday = new JDateChooser();
		visitorBday.setBounds(246, 268, 141, 20);
		relativeOrFriendsPanel.add(visitorBday);
		visitorBday.setDateFormatString("yyyy-MM-dd");
		visitorBday.setMaxSelectableDate(new Date());
		
		JLabel lblsex = new JLabel("Sex:");
		lblsex.setHorizontalAlignment(SwingConstants.LEFT);
		lblsex.setFont(new Font("Monospaced", Font.PLAIN, 17));
		lblsex.setBounds(84, 206, 126, 20);
		relativeOrFriendsPanel.add(lblsex);
		

		JLabel lblEmptyFields = new JLabel("");
		lblEmptyFields.setBounds(246, 42, 122, 14);
		relativeOrFriendsPanel.add(lblEmptyFields);
		
		// --------------------------  Registration For Relative/Friends-------------------------------//
		
		JButton btnRelativeRegister = new JButton("Register");
		btnRelativeRegister.addActionListener(new ActionListener() {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public void actionPerformed(ActionEvent e) {
//				String number = visitorMobilenumber.getText().toString();
//				String trimmedNumber = null;
//				if(number.contains("0")) {
//					trimmedNumber = number.substring(1);
//					System.out.println("yes");
//				}else if(number.contains("+63")){
//					trimmedNumber = number.substring(3);
//					System.out.println("no");
//				}else {
//					trimmedNumber = number;
//				}
//				System.out.println(trimmedNumber);
				
				String id = "RF" + generateID();
				String username = visitorUsername.getText();
				String password = "subdivV" + generatePassword();
				String fname = visitorF_name.getText();
				String mname = visitorM_name.getText();
				String lname = visitorL_name.getText();
				String address = visitorAddress.getText();
				String bday = ((JTextField) visitorBday.getDateEditor().getUiComponent()).getText();
				String finalNumber = visitorMobilenumber.getText();
				
				String type = "1";
				
				if(male == true) {
					sex = "male";
				}else {
					sex = "female";
				}
				
				
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/databasethesis1?useTimezone=true&serverTimezone=UTC", "databasethesis1", "databasethesis1");
					String stmt = "INSERT INTO visitor (visitor_ID, username, password, first_name, middle_name, last_name, address, birth_date, number, visitorType_ID, sex) values (?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement pst = con.prepareStatement(stmt);
					
					if(fname.isEmpty() || mname.isEmpty() || lname.isEmpty() || address.isEmpty() || bday.isEmpty() || finalNumber.isEmpty() || type.isEmpty() || sex.isEmpty() || username.isEmpty()) {
						lblEmptyFields.setText("*Fill in required info!");
						lblEmptyFields.setForeground(Color.red);
						
					}else {
						pst.setString(1, id);
						pst.setString(2, username);
						pst.setString(3, password);
						pst.setString(4, fname);
						pst.setString(5, mname);
						pst.setString(6, lname);
						pst.setString(7, address);
						pst.setString(8, bday);
						pst.setString(9, finalNumber);
						pst.setString(10, type);
						pst.setString(11, sex);
						
						pst.executeUpdate();
					

						
						String qrCodeData =   id;
//						+ "\n" + "Type: Relative/Friends"+  "\n" + "Name: " + lname +", " + fname + " " + mname + "\n" + "Contact Number: " + number
						String filePath = "QR.png";
						String charset = "UTF-8"; // or "ISO-8859-1"
						Map hintMap = new HashMap();
						hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
						
						createQRCode(qrCodeData, filePath, charset, hintMap, 200, 200);
						
						JOptionPane.showMessageDialog(null, "Visitor Username and password\n" + "Username: " + username + "\n" + "Passsword: " + password );
						
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
								
								ImageIcon icon = new ImageIcon("QR.png");
								JOptionPane.showMessageDialog(null, icon);
							}

						}).start();
				        
						 d.setVisible(true);
					}
					
					visitorAddress.setText("");
					visitorF_name.setText("");
					visitorL_name.setText("");
					visitorM_name.setText("");
					visitorMobilenumber.setText("");
					
					visitorUsername.setText("");
					
					
					// -------------- RESTART FRAME-------------------
					
					new Thread(new Runnable() {
						@Override
						public void run() {
							try {
								Thread.sleep(2000);
							} catch (Exception e) {
							}
							
							dispose();
											
						}

					}).start();
					
				    
				} catch (Exception e1) {
					System.out.println(e1);
				}	 
				
				
			}
			
			
		});
		btnRelativeRegister.setBounds(316, 369, 89, 23);
		relativeOrFriendsPanel.add(btnRelativeRegister);
		
		JRadioButton rdbtnVsitorSexMale = new JRadioButton("Male");
		rdbtnVsitorSexMale.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					male = true;	
				}else {
					female = false;
				}
			}
		});
		rdbtnVsitorSexMale.setVerticalAlignment(SwingConstants.BOTTOM);
		rdbtnVsitorSexMale.setBounds(246, 204, 109, 23);
		relativeOrFriendsPanel.add(rdbtnVsitorSexMale);
		
		JRadioButton rdbtnVsitorSexFemale = new JRadioButton("Female");
		rdbtnVsitorSexFemale.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					female = true;	
				}else {
					male = false;
				}
			}
		});
		rdbtnVsitorSexFemale.setVerticalAlignment(SwingConstants.BOTTOM);
		rdbtnVsitorSexFemale.setBounds(380, 204, 109, 23);
		relativeOrFriendsPanel.add(rdbtnVsitorSexFemale);
		
	
		
	
		
		
		// --------------------------  Details For Delivery-------------------------------//
	
		
		deliverPanel = new JPanel();
		layeredPane.add(deliverPanel, "name_8343575820300");
		deliverPanel.setLayout(null);
		
		JLabel typeDeliver = new JLabel("DELIVERY");
		typeDeliver.setHorizontalAlignment(SwingConstants.CENTER);
		typeDeliver.setFont(new Font("Monospaced", Font.BOLD, 20));
		typeDeliver.setBounds(246, 11, 120, 20);
		deliverPanel.add(typeDeliver);
		
		JLabel lblUsername_1 = new JLabel("Username:");
		lblUsername_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsername_1.setFont(new Font("Monospaced", Font.PLAIN, 17));
		lblUsername_1.setBounds(84, 210, 126, 20);
		deliverPanel.add(lblUsername_1);
		
		deliverUsername = new JTextField();
		deliverUsername.setColumns(10);
		deliverUsername.setBounds(246, 212, 251, 20);
		deliverPanel.add(deliverUsername);
		
		JLabel lblF_name_3 = new JLabel("First Name:");
		lblF_name_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblF_name_3.setFont(new Font("Monospaced", Font.PLAIN, 17));
		lblF_name_3.setBounds(84, 115, 126, 20);
		deliverPanel.add(lblF_name_3);
		
		deliverF_name = new JTextField();
		deliverF_name.setToolTipText("first name");
		deliverF_name.setColumns(10);
		deliverF_name.setBounds(246, 117, 251, 20);
		deliverPanel.add(deliverF_name);
		
		deliverM_name = new JTextField();
		deliverM_name.setToolTipText("middle name");
		deliverM_name.setColumns(10);
		deliverM_name.setBounds(246, 148, 251, 20);
		deliverPanel.add(deliverM_name);
		
		JLabel lblF_name_1_1 = new JLabel("Middle Name:");
		lblF_name_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblF_name_1_1.setFont(new Font("Monospaced", Font.PLAIN, 17));
		lblF_name_1_1.setBounds(84, 146, 126, 20);
		deliverPanel.add(lblF_name_1_1);
		
		JLabel lblF_name_2_1 = new JLabel("Last Name:");
		lblF_name_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblF_name_2_1.setFont(new Font("Monospaced", Font.PLAIN, 17));
		lblF_name_2_1.setBounds(84, 179, 126, 20);
		deliverPanel.add(lblF_name_2_1);
		
		deliverL_name = new JTextField();
		deliverL_name.setToolTipText("last name");
		deliverL_name.setColumns(10);
		deliverL_name.setBounds(246, 181, 251, 20);
		deliverPanel.add(deliverL_name);
		
		deliverAddress = new JTextField();
		deliverAddress.setColumns(10);
		deliverAddress.setBounds(246, 276, 251, 20);
		deliverPanel.add(deliverAddress);
		
		JLabel lblAddress_1 = new JLabel("Address");
		lblAddress_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblAddress_1.setFont(new Font("Monospaced", Font.PLAIN, 17));
		lblAddress_1.setBounds(84, 274, 78, 20);
		deliverPanel.add(lblAddress_1);
		
		JLabel lblMobileNumber_1 = new JLabel("Mobile Number:");
		lblMobileNumber_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblMobileNumber_1.setFont(new Font("Monospaced", Font.PLAIN, 17));
		lblMobileNumber_1.setBounds(84, 338, 152, 20);
		deliverPanel.add(lblMobileNumber_1);
		
		deliverNumber = new JTextField();
		deliverNumber.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char input = e.getKeyChar(); //each time user type
				if(input < '0' || input > '9'){
					e.consume(); // backspace will block anything that is not a number
				}else if(deliverNumber.getText().length() == 11) {
					e.consume();
				}
			}
		});
		deliverNumber.setColumns(10);
		deliverNumber.setBounds(246, 340, 251, 20);
		deliverPanel.add(deliverNumber);
		
		JLabel lblBirthday_1 = new JLabel("Birthday:");
		lblBirthday_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblBirthday_1.setFont(new Font("Monospaced", Font.PLAIN, 17));
		lblBirthday_1.setBounds(84, 307, 126, 20);
		deliverPanel.add(lblBirthday_1);
		
		JDateChooser deliveryBday = new JDateChooser();
		deliveryBday.setBounds(246, 307, 141, 20);
		deliveryBday.setDateFormatString("yyyy-MM-dd");
		deliveryBday.setMaxSelectableDate(new Date());
		deliverPanel.add(deliveryBday);
		
		JLabel lblsex_1 = new JLabel("Sex:");
		lblsex_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblsex_1.setFont(new Font("Monospaced", Font.PLAIN, 17));
		lblsex_1.setBounds(84, 241, 126, 20);
		deliverPanel.add(lblsex_1);
		
		JLabel lblEmptyFieldTaxt = new JLabel("");
		lblEmptyFieldTaxt.setBounds(246, 47, 122, 14);
		deliverPanel.add(lblEmptyFieldTaxt);
		
		
		
		// --------------------------  Registration For Delivery-------------------------------//
		
		JButton btnDeliveryRegister = new JButton("Register");
		btnDeliveryRegister.addActionListener(new ActionListener() {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public void actionPerformed(ActionEvent e) {
				
				String id = "Del" + generateID();
				String username = deliverUsername.getText();
				String password = "subdivD" + generatePassword();
				String fname = deliverF_name.getText();
				String mname = deliverM_name.getText();
				String lname = deliverL_name.getText();
				String address = deliverAddress.getText();
				String bday = ((JTextField) deliveryBday.getDateEditor().getUiComponent()).getText();
				String number = deliverNumber.getText();
				String type = "3";
			
							
				if(male == true) {
					sex = "male";
				}else {
					sex = "female";
				}
				
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/databasethesis1?useTimezone=true&serverTimezone=UTC", "databasethesis1", "databasethesis1");
					String stmt = "INSERT INTO visitor (visitor_ID, username, password, first_name, middle_name, last_name, address, birth_date, number,  visitorType_ID, sex) "
							+ "values (?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement pst = con.prepareStatement(stmt);
					
					if(fname.isEmpty() || mname.isEmpty() || lname.isEmpty() || address.isEmpty() || bday.isEmpty() || number.isEmpty() || type.isEmpty() || sex.isEmpty() || username.isEmpty()) {
						lblEmptyFieldTaxt.setText("*Fill in required info!");
						lblEmptyFieldTaxt.setForeground(Color.red);
					}else {
						pst.setString(1, id);
						pst.setString(2, username);
						pst.setString(3, password);
						pst.setString(4, fname);
						pst.setString(5, mname);
						pst.setString(6, lname);
						pst.setString(7, address);
						pst.setString(8, bday);
						pst.setString(9, number);
						pst.setString(10, type);
						pst.setString(11, sex);
					
						
						pst.executeUpdate();
						
						String qrCodeData =   id;
						String filePath = "QR.png";
						String charset = "UTF-8"; // or "ISO-8859-1"
						Map hintMap = new HashMap();
						hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
						
						createQRCode(qrCodeData, filePath, charset, hintMap, 200, 200);
						
						JOptionPane.showMessageDialog(null, "Visitor Username and password\n" + "Username: " + username + "\n" + "Passsword: " + password );
						
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

									ImageIcon icon = new ImageIcon("QR.png");
									JOptionPane.showMessageDialog(null, icon);
									
//									 QRCode qr = new QRCode();
//									 qr.setVisible(true);
								}

							}).start();
					        
							 d.setVisible(true);
					}
					
					deliverAddress.setText("");
					deliverF_name.setText("");
					deliverL_name.setText("");
					deliverM_name.setText("");
					deliverNumber.setText("");
					deliverUsername.setText("");
					
					
					
				
			} catch (Exception e1) {
				System.out.println(e1);
			}
				
//				 -------------- RESTART FRAME-------------------
				
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(2000);
				} catch (Exception e) {
				}
				
				dispose();
								
			}

		}).start();
				
			}
		});
		btnDeliveryRegister.setBounds(319, 389, 89, 23);
		deliverPanel.add(btnDeliveryRegister);
		
		JRadioButton rdbtnDeliverSexMale = new JRadioButton("Male");
		rdbtnDeliverSexMale.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					male = true;
					
				}else {
					female = false;
				}
			}
		});
		rdbtnDeliverSexMale.setBounds(246, 238, 109, 23);
		deliverPanel.add(rdbtnDeliverSexMale);
		
		JRadioButton rdbtnDeliverSexFemale = new JRadioButton("Female");
		rdbtnDeliverSexFemale.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					female = true;
					
				}else {
					male = false;
				}
			}
		});
		rdbtnDeliverSexFemale.setBounds(372, 239, 109, 23);
		deliverPanel.add(rdbtnDeliverSexFemale);
		
		
		
		
		
		
		
		
		// --------------------------  Details For Taxi-------------------------------//
		
		taxiPanel = new JPanel();
		layeredPane.add(taxiPanel, "name_8343592108800");
		taxiPanel.setLayout(null);
		
		JLabel typeTaxi = new JLabel("TAXI");
		typeTaxi.setHorizontalAlignment(SwingConstants.CENTER);
		typeTaxi.setFont(new Font("Monospaced", Font.BOLD, 20));
		typeTaxi.setBounds(246, 11, 120, 20);
		taxiPanel.add(typeTaxi);
		
		JLabel lblUsername_1_1 = new JLabel("Username:");
		lblUsername_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsername_1_1.setFont(new Font("Monospaced", Font.PLAIN, 17));
		lblUsername_1_1.setBounds(87, 205, 126, 20);
		taxiPanel.add(lblUsername_1_1);
		
		taxiUsername = new JTextField();
		taxiUsername.setColumns(10);
		taxiUsername.setBounds(249, 207, 251, 20);
		taxiPanel.add(taxiUsername);
		
		JLabel lblF_name_3_1 = new JLabel("First Name:");
		lblF_name_3_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblF_name_3_1.setFont(new Font("Monospaced", Font.PLAIN, 17));
		lblF_name_3_1.setBounds(87, 110, 126, 20);
		taxiPanel.add(lblF_name_3_1);
		
		taxiF_name = new JTextField();
		taxiF_name.setToolTipText("first name");
		taxiF_name.setColumns(10);
		taxiF_name.setBounds(249, 112, 251, 20);
		taxiPanel.add(taxiF_name);
		
		taxiM_name = new JTextField();
		taxiM_name.setToolTipText("middle name");
		taxiM_name.setColumns(10);
		taxiM_name.setBounds(249, 143, 251, 20);
		taxiPanel.add(taxiM_name);
		
		JLabel lblF_name_1_1_1 = new JLabel("Middle Name:");
		lblF_name_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblF_name_1_1_1.setFont(new Font("Monospaced", Font.PLAIN, 17));
		lblF_name_1_1_1.setBounds(87, 141, 126, 20);
		taxiPanel.add(lblF_name_1_1_1);
		
		JLabel lblF_name_2_1_1 = new JLabel("Last Name:");
		lblF_name_2_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblF_name_2_1_1.setFont(new Font("Monospaced", Font.PLAIN, 17));
		lblF_name_2_1_1.setBounds(87, 174, 126, 20);
		taxiPanel.add(lblF_name_2_1_1);
		
		taxiL_name = new JTextField();
		taxiL_name.setToolTipText("last name");
		taxiL_name.setColumns(10);
		taxiL_name.setBounds(249, 176, 251, 20);
		taxiPanel.add(taxiL_name);
		
		taxiAddress = new JTextField();
		taxiAddress.setColumns(10);
		taxiAddress.setBounds(249, 271, 251, 20);
		taxiPanel.add(taxiAddress);
		
		JLabel lblAddress_1_1 = new JLabel("Address");
		lblAddress_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblAddress_1_1.setFont(new Font("Monospaced", Font.PLAIN, 17));
		lblAddress_1_1.setBounds(87, 269, 78, 20);
		taxiPanel.add(lblAddress_1_1);
		
		JLabel lblMobileNumber_1_1 = new JLabel("Mobile Number:");
		lblMobileNumber_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblMobileNumber_1_1.setFont(new Font("Monospaced", Font.PLAIN, 17));
		lblMobileNumber_1_1.setBounds(87, 333, 152, 20);
		taxiPanel.add(lblMobileNumber_1_1);
		
		taxiNumber = new JTextField();
		taxiNumber.addKeyListener(new KeyAdapter() {
			@Override
				public void keyTyped(KeyEvent e) {
					char input = e.getKeyChar(); //each time user type
					if(input < '0' || input > '9'){
						e.consume(); // backspace will block anything that is not a number
					}else if(taxiNumber.getText().length() == 11) {
						e.consume();
					}
				}
		});
		taxiNumber.setColumns(10);
		taxiNumber.setBounds(249, 335, 251, 20);
		taxiPanel.add(taxiNumber);
		
		JLabel lblBirthday_2 = new JLabel("Birthday:");
		lblBirthday_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblBirthday_2.setFont(new Font("Monospaced", Font.PLAIN, 17));
		lblBirthday_2.setBounds(87, 302, 126, 20);
		taxiPanel.add(lblBirthday_2);
		
		JDateChooser taxiBday = new JDateChooser();
		taxiBday.setBounds(249, 302, 141, 20);
		taxiBday.setDateFormatString("yyyy-MM-dd");
		taxiBday.setMaxSelectableDate(new Date());
		taxiPanel.add(taxiBday);
		
		JLabel lblsex_1_1 = new JLabel("Sex:");
		lblsex_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblsex_1_1.setFont(new Font("Monospaced", Font.PLAIN, 17));
		lblsex_1_1.setBounds(87, 236, 126, 20);
		taxiPanel.add(lblsex_1_1);
		
		JLabel lblEmptyFieldTaxi = new JLabel("");
		lblEmptyFieldTaxi.setBounds(246, 42, 122, 14);
		taxiPanel.add(lblEmptyFieldTaxi);
		
		// --------------------------  Registration For Taxi-------------------------------//
		
		JButton btnTaxtRegister = new JButton("Register");
		btnTaxtRegister.addActionListener(new ActionListener() {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public void actionPerformed(ActionEvent e) {
				
				String id = "Tax" + generateID();
				String username = taxiUsername.getText();
				String password = "subdivD" + generatePassword();
				String fname = taxiF_name.getText();
				String mname = taxiM_name.getText();
				String lname = taxiL_name.getText();
				String address = taxiAddress.getText();
				String bday = ((JTextField) taxiBday.getDateEditor().getUiComponent()).getText();
				String number = taxiNumber.getText();
				String type = "2";
				

				if(male == true) {
					sex = "male";
				}else {
					sex = "female";
				}
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/databasethesis1?useTimezone=true&serverTimezone=UTC", "databasethesis1", "databasethesis1");
					String stmt = "INSERT INTO visitor (visitor_ID, username, password, first_name, middle_name, last_name, address, birth_date, number, visitorType_ID, sex)"
							+ " values (?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement pst = con.prepareStatement(stmt);
					
					taxiUsername.setText("");
					
					if(fname.isEmpty() || mname.isEmpty() || lname.isEmpty() || address.isEmpty() || bday.isEmpty() || number.isEmpty() || type.isEmpty() || sex.isEmpty() || username.isEmpty()) {
						lblEmptyFieldTaxi.setText("*Fill in required info!");
						lblEmptyFieldTaxi.setForeground(Color.red);
					}else {
						pst.setString(1, id);
						pst.setString(2, username);
						pst.setString(3, password);
						pst.setString(4, fname);
						pst.setString(5, mname);
						pst.setString(6, lname);
						pst.setString(7, address);
						pst.setString(8, bday);
						pst.setString(9, number);
						pst.setString(10, type);
						pst.setString(11, sex);
						
						
						
						pst.executeUpdate();
						
						String qrCodeData =   id;
						String filePath = "QR.png";
						String charset = "UTF-8"; // or "ISO-8859-1"
						Map hintMap = new HashMap();
						hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
						
						createQRCode(qrCodeData, filePath, charset, hintMap, 200, 200);
						JOptionPane.showMessageDialog(null, "Visitor Username and password\n" + "Username: " + username + "\n" + "Passsword: " + password );
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
									
									ImageIcon icon = new ImageIcon("QR.png");
									JOptionPane.showMessageDialog(null, icon);
//									 QRCode qr = new QRCode();
//									 qr.setVisible(true);
								}

							}).start();
					        
							 d.setVisible(true);
					}
					
					
					taxiAddress.setText("");
					taxiF_name.setText("");
					taxiL_name.setText("");
					taxiM_name.setText("");
					taxiNumber.setText("");
					taxiUsername.setText("");
				
					
					
// 				-------------- RESTART FRAME-------------------
					
					new Thread(new Runnable() {
						@Override
						public void run() {
							try {
								Thread.sleep(2000);
							} catch (Exception e) {
							}
							
							dispose();
												
						}

					}).start();
					
				} catch (Exception e1) {
					System.out.println(e1);
				}
				
			}
		});
		btnTaxtRegister.setBounds(323, 366, 89, 23);
		taxiPanel.add(btnTaxtRegister);
		
		JRadioButton rdbtntaxiSexMale = new JRadioButton("Male");
		rdbtntaxiSexMale.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					male = true;	
				}else {
					female = false;
				}
			}
		});
		rdbtntaxiSexMale.setBounds(246, 234, 109, 23);
		taxiPanel.add(rdbtntaxiSexMale);
		
		JRadioButton rdbtntaxiSexFemale = new JRadioButton("Female");
		rdbtntaxiSexFemale.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					female = true;	
				}else {
					male = false;
				}
			}
		});
		rdbtntaxiSexFemale.setBounds(380, 234, 109, 23);
		taxiPanel.add(rdbtntaxiSexFemale);
		
		// --------------------------  Details For Others-------------------------------/
		
		JPanel othersPanel = new JPanel();
		layeredPane.add(othersPanel, "name_4766989788900");
		othersPanel.setLayout(null);
		
		JLabel typeOthers = new JLabel("OTHERS");
		typeOthers.setHorizontalAlignment(SwingConstants.CENTER);
		typeOthers.setFont(new Font("Monospaced", Font.BOLD, 20));
		typeOthers.setBounds(251, 57, 120, 20);
		othersPanel.add(typeOthers);
		
		JLabel lblUsername_1_1_1 = new JLabel("Username:");
		lblUsername_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsername_1_1_1.setFont(new Font("Monospaced", Font.PLAIN, 17));
		lblUsername_1_1_1.setBounds(89, 253, 126, 20);
		othersPanel.add(lblUsername_1_1_1);
		
		othersUsername = new JTextField();
		othersUsername.setColumns(10);
		othersUsername.setBounds(251, 255, 251, 20);
		othersPanel.add(othersUsername);
		
		JLabel lblF_name_3_1_1 = new JLabel("First Name:");
		lblF_name_3_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblF_name_3_1_1.setFont(new Font("Monospaced", Font.PLAIN, 17));
		lblF_name_3_1_1.setBounds(89, 158, 126, 20);
		othersPanel.add(lblF_name_3_1_1);
		
		othersF_name = new JTextField();
		othersF_name.setToolTipText("first name");
		othersF_name.setColumns(10);
		othersF_name.setBounds(251, 160, 251, 20);
		othersPanel.add(othersF_name);
		
		othersM_name = new JTextField();
		othersM_name.setToolTipText("middle name");
		othersM_name.setColumns(10);
		othersM_name.setBounds(251, 191, 251, 20);
		othersPanel.add(othersM_name);
		
		JLabel lblF_name_1_1_1_1 = new JLabel("Middle Name:");
		lblF_name_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblF_name_1_1_1_1.setFont(new Font("Monospaced", Font.PLAIN, 17));
		lblF_name_1_1_1_1.setBounds(89, 189, 126, 20);
		othersPanel.add(lblF_name_1_1_1_1);
		
		JLabel lblF_name_2_1_1_1 = new JLabel("Last Name:");
		lblF_name_2_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblF_name_2_1_1_1.setFont(new Font("Monospaced", Font.PLAIN, 17));
		lblF_name_2_1_1_1.setBounds(89, 222, 126, 20);
		othersPanel.add(lblF_name_2_1_1_1);
		
		othersL_name = new JTextField();
		othersL_name.setToolTipText("last name");
		othersL_name.setColumns(10);
		othersL_name.setBounds(251, 224, 251, 20);
		othersPanel.add(othersL_name);
		
		othersAddress = new JTextField();
		othersAddress.setColumns(10);
		othersAddress.setBounds(251, 319, 251, 20);
		othersPanel.add(othersAddress);
		
		JLabel lblAddress_1_1_1 = new JLabel("Address");
		lblAddress_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblAddress_1_1_1.setFont(new Font("Monospaced", Font.PLAIN, 17));
		lblAddress_1_1_1.setBounds(89, 317, 78, 20);
		othersPanel.add(lblAddress_1_1_1);
		
		JLabel lblMobileNumber_1_1_1 = new JLabel("Mobile Number:");
		lblMobileNumber_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblMobileNumber_1_1_1.setFont(new Font("Monospaced", Font.PLAIN, 17));
		lblMobileNumber_1_1_1.setBounds(89, 381, 152, 20);
		othersPanel.add(lblMobileNumber_1_1_1);
		
		othersNumber = new JTextField();
		othersNumber.addKeyListener(new KeyAdapter() {
			@Override
				public void keyTyped(KeyEvent e) {
					char input = e.getKeyChar(); //each time user type
					if(input < '0' || input > '9'){
						e.consume(); // backspace will block anything that is not a number
					}else if(othersNumber.getText().length() == 11) {
						e.consume();
					}
				}
		});
		othersNumber.setColumns(10);
		othersNumber.setBounds(251, 383, 251, 20);
		othersPanel.add(othersNumber);
		
		JLabel lblBirthday_2_1 = new JLabel("Birthday:");
		lblBirthday_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblBirthday_2_1.setFont(new Font("Monospaced", Font.PLAIN, 17));
		lblBirthday_2_1.setBounds(89, 350, 126, 20);
		othersPanel.add(lblBirthday_2_1);
		
		JDateChooser othersBday = new JDateChooser();
		othersBday.setDateFormatString("yyyy-MM-dd");
		othersBday.setMaxSelectableDate(new Date());
		othersBday.setBounds(251, 350, 141, 20);
		othersPanel.add(othersBday);
		
		JLabel lblsex_1_1_1 = new JLabel("Sex:");
		lblsex_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblsex_1_1_1.setFont(new Font("Monospaced", Font.PLAIN, 17));
		lblsex_1_1_1.setBounds(89, 284, 126, 20);
		othersPanel.add(lblsex_1_1_1);
		
	
		JRadioButton rdbtnOthersSexMale = new JRadioButton("Male");
		rdbtnOthersSexMale.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					male = true;	
				}else {
					female = false;
				}
			}
		});
		rdbtnOthersSexMale.setBounds(248, 282, 109, 23);
		othersPanel.add(rdbtnOthersSexMale);
		
		JRadioButton rdbtnOthersSexFemale = new JRadioButton("Female");
		rdbtnOthersSexFemale.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					female = true;	
				}else {
					male = false;
				}
			}
		});
		rdbtnOthersSexFemale.setBounds(382, 282, 109, 23);
		othersPanel.add(rdbtnOthersSexFemale);
		
		// --------------------------  Registration For OTHERS-------------------------------/
		
		JButton btnOthersRegister = new JButton("Register");
		btnOthersRegister.addActionListener(new ActionListener() {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public void actionPerformed(ActionEvent e) {
				
				String id = "Oth" + generateID();
				String username = othersUsername.getText();
				String password = "subdivD" + generatePassword();
				String fname = othersF_name.getText();
				String mname = othersM_name.getText();
				String lname = othersL_name.getText();
				String address = othersAddress.getText();
				String bday = ((JTextField) othersBday.getDateEditor().getUiComponent()).getText();
				String number = othersNumber.getText();
				String type = "4";
				
				
				
				
				if(male == true) {
					sex = "male";
				}else {
					sex = "female";
				}
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/databasethesis1?useTimezone=true&serverTimezone=UTC", "databasethesis1", "databasethesis1");
					String stmt = "INSERT INTO visitor (visitor_ID, username, password, first_name, middle_name, last_name, address, birth_date, number, visitorType_ID, sex)"
							+ " values (?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement pst = con.prepareStatement(stmt);
					
					taxiUsername.setText("");
					
					if(fname.isEmpty() || mname.isEmpty() || lname.isEmpty() || address.isEmpty() || bday.isEmpty() || number.isEmpty() || type.isEmpty() || sex.isEmpty() || username.isEmpty()) {
						lblEmptyFieldTaxi.setText("*Fill in required info!");
						lblEmptyFieldTaxi.setForeground(Color.red);
					}else {
						pst.setString(1, id);
						pst.setString(2, username);
						pst.setString(3, password);
						pst.setString(4, fname);
						pst.setString(5, mname);
						pst.setString(6, lname);
						pst.setString(7, address);
						pst.setString(8, bday);
						pst.setString(9, number);
						pst.setString(10, type);
						pst.setString(11, sex);
						
						
						
						pst.executeUpdate();
						
						String qrCodeData =   id;
						String filePath = "QR.png";
						String charset = "UTF-8"; // or "ISO-8859-1"
						Map hintMap = new HashMap();
						hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
						
						createQRCode(qrCodeData, filePath, charset, hintMap, 200, 200);
						
						JOptionPane.showMessageDialog(null, "Visitor Username and password\n" + "Username: " + username + "\n" + "Passsword: " + password );
						
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
									
									ImageIcon icon = new ImageIcon("QR.png");
									JOptionPane.showMessageDialog(null, icon);
//									 QRCode qr = new QRCode();
//									 qr.setVisible(true);
								}

							}).start();
					        
							 d.setVisible(true);
					}
					
					
					
					
					
// 				-------------- RESTART FRAME-------------------
					
					new Thread(new Runnable() {
						@Override
						public void run() {
							try {
								Thread.sleep(2000);
							} catch (Exception e) {
							}
							
							dispose();
												
						}

					}).start();
					
				} catch (Exception e1) {
					System.out.println(e1);
				}
				
			}
		});
		btnOthersRegister.setBounds(325, 414, 89, 23);
		othersPanel.add(btnOthersRegister);
		
		// --------------------------  VISITOR TYPE BUTTONS-------------------------------/

		JButton btnRelative = new JButton("Relatives/ Friends");
		btnRelative.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRelative.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(relativeOrFriendsPanel);
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
		
		JButton btnOthers = new JButton("OTHERS");
		btnOthers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(othersPanel);
				
			}
		});
		btnOthers.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnOthers.setBounds(42, 442, 160, 57);
		visitorType.add(btnOthers);
		
		
		group.add(rdbtntaxiSexMale);
		group.add(rdbtntaxiSexFemale);
		group.add(rdbtnDeliverSexFemale);
		group.add(rdbtnDeliverSexMale);
		group.add(rdbtnVsitorSexFemale);
		group.add(rdbtnVsitorSexMale);
		group.add(rdbtnOthersSexMale);
		group.add(rdbtnOthersSexFemale);
	}
}
