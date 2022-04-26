package final_;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.toedter.calendar.JDateChooser;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JRadioButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

@SuppressWarnings({ "serial", "unused" })
public class HomeownersRegistration extends JFrame {

	private JPanel contentPane;
	private JTextField homeownerFirstname;
	private JTextField homeownerLastname;
	private JTextField street;
	private JTextField mobileNumber;
	private JTextField homeownerMiddlename;
	private JTextField homeownerUsername;
	private JTextField lotNumber;
	private JTextField telNumber;
	private ButtonGroup group = new ButtonGroup();
	boolean male = false, female = false;
	String sex;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeownersRegistration frame = new HomeownersRegistration();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	static String generateID() {
		 int rnd = (int) (Math.random() * 10);
		  String letters = "SubdO";
		  String chars = "abcdefghijklmnopqqrstuvwxyz";
		  String chars2 = "ABCDEFGHIKLMNOPQRSTVXYZ";
			Random rand = new Random();
			char c = chars.charAt(rand.nextInt(chars.length()));
			char c2 = chars2.charAt(rand.nextInt(chars2.length()));
			String num = Integer.toString(rnd);
		    String ID = (letters + num + c + c2);
		    
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
		HomeownersRegistration restart = new HomeownersRegistration();
		restart.getContentPane();
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
	public HomeownersRegistration() {
		setTitle("Registration");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 517, 637);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Toolkit toolkit = getToolkit();
		Dimension size = toolkit.getScreenSize();
		setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 516, 658);
		contentPane.add(panel);
		panel.setBackground(new Color(156, 182, 214));
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(12, 12, 481, 579);
		panel.add(panel_1);
		panel_1.setBackground(new Color(206, 199, 198));
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("HOMEOWNER REGISTRATION");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Monospaced", Font.BOLD, 25));
		lblNewLabel.setBackground(Color.DARK_GRAY);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 496, 60);
		panel_1.add(lblNewLabel);
		lblNewLabel.setOpaque(true);
		
		JLabel lblFIrstName = new JLabel("First Name:");
		lblFIrstName.setFont(new Font("Dialog", Font.BOLD, 15));
		lblFIrstName.setBounds(41, 106, 112, 26);
		panel_1.add(lblFIrstName);
		
		homeownerFirstname = new JTextField();
		homeownerFirstname.setBounds(160, 110, 276, 20);
		panel_1.add(homeownerFirstname);
		homeownerFirstname.setColumns(10);
		
		homeownerLastname = new JTextField();
		homeownerLastname.setColumns(10);
		homeownerLastname.setBounds(160, 184, 276, 20);
		panel_1.add(homeownerLastname);
		
		JLabel lblLastanme = new JLabel("Last Name:");
		lblLastanme.setFont(new Font("Dialog", Font.BOLD, 15));
		lblLastanme.setBounds(41, 180, 112, 26);
		panel_1.add(lblLastanme);
		
		homeownerUsername = new JTextField();
		homeownerUsername.setColumns(10);
		homeownerUsername.setBounds(160, 219, 276, 20);
		panel_1.add(homeownerUsername);
		
		JLabel lblLuserName = new JLabel("Username:");
		lblLuserName.setFont(new Font("Dialog", Font.BOLD, 15));
		lblLuserName.setBounds(41, 215, 112, 26);
		panel_1.add(lblLuserName);
		
		JDateChooser homeownerBday = new JDateChooser();
		homeownerBday.setBounds(160, 256, 143, 20);
		homeownerBday.setMaxSelectableDate(new Date());
		homeownerBday.setDateFormatString("yyyy-MM-dd");
		panel_1.add(homeownerBday);
		
		JLabel lblBday = new JLabel("Birthday:");
		lblBday.setFont(new Font("Dialog", Font.BOLD, 15));
		lblBday.setBounds(41, 250, 112, 26);
		panel_1.add(lblBday);
		
		JLabel lblGender = new JLabel("Sex:");
		lblGender.setFont(new Font("Dialog", Font.BOLD, 15));
		lblGender.setBounds(41, 287, 112, 26);
		panel_1.add(lblGender);
		
//		street = new JTextField();
//		street.setColumns(10);
//		street.setBounds(160, 329, 276, 20);
//		panel_1.add(street);
//		
//		JLabel lblstreet = new JLabel("Street:");
//		lblstreet.setFont(new Font("Dialog", Font.BOLD, 15));
//		lblstreet.setBounds(41, 324, 112, 26);
//		panel_1.add(lblstreet);
		
		JLabel lblNumber = new JLabel("Mobile Number:");
		lblNumber.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNumber.setBounds(41, 434, 112, 26);
		panel_1.add(lblNumber);
		
		mobileNumber = new JTextField();
		mobileNumber.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char input = e.getKeyChar(); //each time user type
				if(input < '0' || input > '9'){
					e.consume(); // backspace will block anything that is not a number
				}else if(mobileNumber.getText().length() == 11) {
					e.consume();
				}
			}
		});
		mobileNumber.setColumns(10);
		mobileNumber.setBounds(160, 438, 276, 20);
		panel_1.add(mobileNumber);
		
		JLabel lbmnameame_1 = new JLabel("Middle Name:");
		lbmnameame_1.setFont(new Font("Dialog", Font.BOLD, 15));
		lbmnameame_1.setBounds(41, 143, 112, 26);
		panel_1.add(lbmnameame_1);
		
		homeownerMiddlename = new JTextField();
		homeownerMiddlename.setColumns(10);
		homeownerMiddlename.setBounds(160, 147, 276, 20);
		panel_1.add(homeownerMiddlename);
		
		JLabel lblEmptyFields = new JLabel("");
		lblEmptyFields.setBounds(181, 71, 122, 14);
		panel_1.add(lblEmptyFields);
		
		
		JLabel lblAlotNumber = new JLabel("Lot:");
		lblAlotNumber.setFont(new Font("Dialog", Font.BOLD, 15));
		lblAlotNumber.setBounds(41, 360, 112, 26);
		panel_1.add(lblAlotNumber);
		
		lotNumber = new JTextField();
		lotNumber.setColumns(10);
		lotNumber.setBounds(160, 360, 276, 20);
		panel_1.add(lotNumber);
		
		JLabel lblBlockNumber = new JLabel("Block:");
		lblBlockNumber.setFont(new Font("Dialog", Font.BOLD, 15));
		lblBlockNumber.setBounds(41, 397, 112, 26);
		panel_1.add(lblBlockNumber);
		
		JTextField block = new JTextField();
		block.setColumns(10);
		block.setBounds(160, 402, 276, 20);
		panel_1.add(block);
		
		JLabel lblTelephoneNumber = new JLabel("Telephone \r\nNumber:");
		lblTelephoneNumber.setFont(new Font("Dialog", Font.BOLD, 15));
		lblTelephoneNumber.setBounds(41, 471, 143, 26);
		panel_1.add(lblTelephoneNumber);
		
		telNumber = new JTextField();
		telNumber.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped (KeyEvent e) {
				char input = e.getKeyChar(); //each time user type
				if(input < '0' || input > '9'){
					e.consume(); // backspace will block anything that is not a number
				}else if(telNumber.getText().length() == 11) {
					e.consume();
				}
			}
		});
		telNumber.setColumns(10);
		telNumber.setBounds(194, 475, 242, 20);
		panel_1.add(telNumber);
		
//		homeownerPlate = new JTextField();
//		homeownerPlate.setColumns(10);
//		homeownerPlate.setBounds(160, 316, 276, 20);
//		panel_1.add(homeownerPlate);
//		
//		JLabel lblPlateNumber = new JLabel("Plate Number:");
//		lblPlateNumber.setFont(new Font("Dialog", Font.BOLD, 15));
//		lblPlateNumber.setBounds(41, 312, 112, 26);
//		panel_1.add(lblPlateNumber);
		
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBackground(UIManager.getColor("CheckBox.focus"));
		btnRegister.addActionListener(new ActionListener() {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public void actionPerformed(ActionEvent e) {
				
			
			String id = generateID();
			String fName = homeownerFirstname.getText();
			String mName = homeownerMiddlename.getText();
			String lName = homeownerLastname.getText();
			String bday = ((JTextField) homeownerBday.getDateEditor().getUiComponent()).getText();
//			String plateNumber =  homeownerPlate.getText();
//			String Street= street.getText();
			String lot = lotNumber.getText();
			String Block = block.getText();
			String number = mobileNumber.getText();
			String TelNumber = telNumber.getText();
			String username = homeownerUsername.getText();
			String password ="SubdivO" +  generatePassword();
			
	
			if(male == true) {
				sex = "male";
			}else {
				sex = "female";
			}
			
			
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/databasethesis1?useTimezone=true&serverTimezone=UTC", "databasethesis1", "databasethesis1");
					String stmt = "INSERT INTO homeowners (homeowner_ID, first_name, middle_name, last_name, birth_date, lot_number, block_number,"
							+ "mobile_number, tel_number, username, password, sex) values (?,?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement pst = con.prepareStatement(stmt);
					
					if(fName.isEmpty() || lName.isEmpty() || mName.isEmpty() || bday.isEmpty() || sex.isEmpty() || lot.isEmpty() ||
							 Block.isEmpty() || number.isEmpty() || username.isEmpty() || sex.isEmpty()) {
						lblEmptyFields.setText("*Fill in required info!");
						lblEmptyFields.setForeground(Color.red);
						
					}else {
						
						pst.setString(1, id);
						pst.setString(2, fName);
						pst.setString(3, mName);
						pst.setString(4, lName);
						pst.setString(5, bday);
//						pst.setString(6, plateNumber);
//						pst.setString(6, Street);
						pst.setString(6, lot);
						pst.setString(7, Block);
						pst.setString(8, number);
						pst.setString(9, TelNumber);
						pst.setString(10, username);
						pst.setString(11, password);
						pst.setString(12, sex);
						
						pst.executeUpdate();
						
					String qrCodeData =  id;
					String filePath = "QR.png";
					String charset = "UTF-8"; // or "ISO-8859-1"
					Map hintMap = new HashMap();
					hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
					
					createQRCode(qrCodeData, filePath, charset, hintMap, 200, 200);
					
					
					JOptionPane.showMessageDialog(null, "Homeowner's Username and password\n" + "Username: " + username + "\n" + "Passsword: " + password );
					
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
								
//								 QRCode qr = new QRCode();
//								 qr.setVisible(true);
							}

						}).start();
				        
						 d.setVisible(true);
						 
						 
						 	homeownerFirstname.setText("");
						 	homeownerMiddlename.setText("");
							homeownerLastname.setText("");
							homeownerMiddlename.getText();
							
//							street.setText("");
							mobileNumber.setText("");
							homeownerUsername.setText("");
//							homeownerPlate.setText("");
							block.setText("");
							lotNumber.setText("");
					
							con.close();
							dispose();
					}		
				}catch (Exception e1) {
					System.out.println(e1);
				}		
				
				

			}
		});
		
		
		
		
		
		btnRegister.setBounds(205, 522, 98, 26);
		panel_1.add(btnRegister);
		
		JRadioButton ownerSexMale = new JRadioButton("Male");
		ownerSexMale.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					male = true;	
				}else {
					female = false;
				}
			}
		});
		ownerSexMale.setBackground(new Color(206, 199, 198));
		ownerSexMale.setBounds(160, 291, 109, 23);
		panel_1.add(ownerSexMale);
		
		JRadioButton ownerSexFemale = new JRadioButton("Female");
		ownerSexFemale.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					female = true;
					
				}else {
					male = false;
				}
			}
		});
		ownerSexFemale.setBackground(new Color(206, 199, 198));
		ownerSexFemale.setBounds(300, 291, 109, 23);
		panel_1.add(ownerSexFemale);
		
		group.add(ownerSexMale);
		group.add(ownerSexFemale);
		
		
	}
}
