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
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

@SuppressWarnings({ "serial", "unused" })
public class EmpRegistration extends JFrame {

	private JPanel contentPane;
	private JTextField empFirstname;
	private JTextField empLastname;
	private JTextField empAddress;
	private JTextField empNumber;
	private JTextField empMiddlename;
	private JTextField empUsername;
	private JTextField empPlatenumber;
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
					EmpRegistration frame = new EmpRegistration();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	static String generateID() {
		 int rnd = (int) (Math.random() * 10);
		  String letters = "emp";
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
		EmpRegistration restart = new EmpRegistration();
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
	@SuppressWarnings("unchecked")
	public EmpRegistration() {
		setResizable(false);
		setTitle("Registration");
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
		
		JLabel lblNewLabel = new JLabel("REGISTRATION");
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
		
		empFirstname = new JTextField();
		empFirstname.setBounds(160, 110, 276, 20);
		panel_1.add(empFirstname);
		empFirstname.setColumns(10);
		
		empLastname = new JTextField();
		empLastname.setColumns(10);
		empLastname.setBounds(161, 196, 276, 20);
		panel_1.add(empLastname);
		
		JLabel lblLastanme = new JLabel("Last Name:");
		lblLastanme.setFont(new Font("Dialog", Font.BOLD, 15));
		lblLastanme.setBounds(42, 192, 112, 26);
		panel_1.add(lblLastanme);
		
		empUsername = new JTextField();
		empUsername.setColumns(10);
		empUsername.setBounds(160, 239, 276, 20);
		panel_1.add(empUsername);
		
		JLabel lblLuserName = new JLabel("Username:");
		lblLuserName.setFont(new Font("Dialog", Font.BOLD, 15));
		lblLuserName.setBounds(41, 235, 112, 26);
		panel_1.add(lblLuserName);
		
		JDateChooser empBday = new JDateChooser();
		empBday.setBounds(160, 276, 143, 20);
		empBday.setMaxSelectableDate(new Date());
		empBday.setDateFormatString("yyyy-MM-dd");
		panel_1.add(empBday);
		
		JLabel lblBday = new JLabel("Birthday:");
		lblBday.setFont(new Font("Dialog", Font.BOLD, 15));
		lblBday.setBounds(41, 270, 112, 26);
		panel_1.add(lblBday);
		
		JLabel lblSex = new JLabel("Sex:");
		lblSex.setFont(new Font("Dialog", Font.BOLD, 15));
		lblSex.setBounds(41, 307, 112, 26);
		panel_1.add(lblSex);
		
		empAddress = new JTextField();
		empAddress.setColumns(10);
		empAddress.setBounds(160, 346, 276, 20);
		panel_1.add(empAddress);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Dialog", Font.BOLD, 15));
		lblAddress.setBounds(41, 342, 112, 26);
		panel_1.add(lblAddress);
		
		JLabel lblDepartment = new JLabel("Deparment:");
		lblDepartment.setFont(new Font("Dialog", Font.BOLD, 15));
		lblDepartment.setBounds(41, 414, 112, 26);
		panel_1.add(lblDepartment);
		
		JLabel lblNumber = new JLabel("Number:");
		lblNumber.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNumber.setBounds(41, 377, 112, 26);
		panel_1.add(lblNumber);
		
		empNumber = new JTextField();
		empNumber.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char input = e.getKeyChar(); //each time user type
				if(input < '0' || input > '9'){
					e.consume(); // backspace will block anything that is not a number
				}else if(empNumber.getText().length() == 11) {
					e.consume();
				}
			}
		});
		empNumber.setColumns(10);
		empNumber.setBounds(160, 381, 276, 20);
		panel_1.add(empNumber);
		
		JLabel lbmnameame_1 = new JLabel("Middle Name:");
		lbmnameame_1.setFont(new Font("Dialog", Font.BOLD, 15));
		lbmnameame_1.setBounds(41, 155, 112, 26);
		panel_1.add(lbmnameame_1);
		
		empMiddlename = new JTextField();
		empMiddlename.setColumns(10);
		empMiddlename.setBounds(160, 159, 276, 20);
		panel_1.add(empMiddlename);
		
		JLabel lblEmptyFields = new JLabel("");
		lblEmptyFields.setBounds(181, 71, 122, 14);
		panel_1.add(lblEmptyFields);
		
//		JLabel lblPlate = new JLabel("Plate Number:");
//		lblPlate.setFont(new Font("Dialog", Font.BOLD, 15));
//		lblPlate.setBounds(41, 307, 112, 26);
//		panel_1.add(lblPlate);
//		
//		empPlatenumber = new JTextField();
//		empPlatenumber.setColumns(10);
//		empPlatenumber.setBounds(160, 311, 276, 20);
//		panel_1.add(empPlatenumber);
		
		
		@SuppressWarnings("rawtypes")
		JComboBox empDept = new JComboBox();
		empDept.setBounds(159, 418, 276, 22);
		panel_1.add(empDept);
		empDept.addItem("--SELECT DEPARTMENT--");
		empDept.addItem("Security");
		empDept.addItem("Maintenance");
		empDept.addItem("Board Of Directors");
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBackground(UIManager.getColor("CheckBox.focus"));
		btnRegister.addActionListener(new ActionListener() {
			@SuppressWarnings({ "rawtypes" })
			public void actionPerformed(ActionEvent e) {
					
				
			String id = generateID();
			String fName = empFirstname.getText();
			String lName = empLastname.getText();
			String mName = empMiddlename.getText();
			String bday = ((JTextField) empBday.getDateEditor().getUiComponent()).getText();
			String address = empAddress.getText();
//			String plateNum = empPlatenumber.getText();
			String number = empNumber.getText();
//			String dept = empDept.getSelectedItem().toString();
			String DepartmentNumber = null;
			String username = empUsername.getText();
			String password ="SubdivE" +  generatePassword();
			
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd");
			LocalDate localDate = LocalDate.now();
					  
			String date = dtf.format(localDate);
			
			if(empDept.getSelectedItem().toString().equals("Security")) {
				DepartmentNumber="2";
			}else if(empDept.getSelectedItem().toString().equals("Maintenance")) {
				DepartmentNumber="1";
			}else if(empDept.getSelectedItem().toString().equals("Board Of Directors")) {
				DepartmentNumber="3";
			}
			
			if(male == true) {
				sex = "male";
			}else {
				sex = "female";
			}
			
			
			
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/databasethesis1?useTimezone=true&serverTimezone=UTC", "databasethesis1", "databasethesis1");
					String stmt = "INSERT INTO employees (emp_ID, first_name, last_name, middle_name, birth_date, sex, address, number, hire_date, dept_ID, username, password) values (?,?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement pst = con.prepareStatement(stmt);
					
					
					
					if(fName.isEmpty() || lName.isEmpty() || mName.isEmpty() || bday.isEmpty() || sex.isEmpty() || address.isEmpty() || number.isEmpty() || empDept.getSelectedItem().toString().equals("--SELECT DEPARTMENT--") || username.isEmpty()) {
						lblEmptyFields.setText("*Fill in required info!");
						lblEmptyFields.setForeground(Color.red);
						
					}else {
						pst.setString(1, id);
						pst.setString(2, fName);
						pst.setString(3, lName);
						pst.setString(4, mName);
						pst.setString(5, bday);
						pst.setString(6, sex);
						pst.setString(7, address);
						pst.setString(8, number);
						pst.setString(9, date);
						pst.setString(10, DepartmentNumber);
						pst.setString(11, username);
						pst.setString(12, password);
						
						
						
						pst.executeUpdate();
						
						String qrCodeData = id;
						String filePath = "QR.png";
						String charset = "UTF-8"; // or "ISO-8859-1"
						Map hintMap = new HashMap();
						hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
						
						createQRCode(qrCodeData, filePath, charset, hintMap, 200, 200);
						
						
						JOptionPane.showMessageDialog(null, "Your ID: " + id);
						
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
							 
							 
							 	empFirstname.setText("");
							 	empMiddlename.setText("");
								empLastname.setText("");
								empMiddlename.getText();								
								empAddress.setText("");
								empNumber.setText("");
								empUsername.setText("");
								
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
		
		JRadioButton empSexMale = new JRadioButton("Male");
		empSexMale.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					male = true;	
				}else {
					female = false;
				}
			}
		});
		empSexMale.setBounds(160, 311, 109, 23);
		panel_1.add(empSexMale);
		empSexMale.setBackground(new Color(206, 199, 198));
		
		JRadioButton empSexFemale = new JRadioButton("Female");
		empSexFemale.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					female = true;
					
				}else {
					male = false;
				}
			}
		});
		empSexFemale.setBounds(302, 311, 109, 23);
		panel_1.add(empSexFemale);
		empSexFemale.setBackground(new Color(206, 199, 198));
		
		group.add(empSexFemale);
		group.add(empSexMale);
		
	}
}
