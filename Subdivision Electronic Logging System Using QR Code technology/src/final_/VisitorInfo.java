package final_;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;



import javax.swing.JRadioButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

@SuppressWarnings({ "serial", "unused" })
public class VisitorInfo extends JFrame {

	private JPanel contentPane;
	private JTextField platenumber;
	static JLabel name;
	static JLabel ID;
	private JButton btnRecord;
	private JLabel homeowner;
	private JPanel panel_1;
	private JLabel lbl1;
	static ArrayList<String> nameList;
	static JTextField visitTo;
	JLabel list;
	static String number;
	static String homeownerName;
	boolean flag = true;
	boolean flagType = true;
	boolean withConfirmation = false, withoutConfirmation = false;
	private ButtonGroup group = new ButtonGroup();
	static ArrayList<String> visitor;
	String confirmation;
	JRadioButton rdbtnWithConfirmation;
	JRadioButton rdbtnWithoutConfirmation;
	int visitorNo;
	Connection con;
	private JTextField othersType;
	/**
	 * Launch the application.
	 * @return 
	 */
	
	public static void autoComplete() {
		nameList = new ArrayList<String>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/databasethesis1?useTimezone=true&serverTimezone=UTC", "databasethesis1", "databasethesis1");
			Statement stmt = con.createStatement();
			String qry = "Select first_name, last_name from homeowners \r\n"
					+ "where first_name like '" +visitTo.getText()+"%'"; 
			ResultSet result = stmt.executeQuery(qry);
			
			while(result.next()) {
				String fname = result.getString("first_name");
				String lname = result.getString("last_name");
				
				String visitTo = fname + " " + lname;
				
				nameList.add((visitTo));
				
			}
			con.close();
			stmt.close();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("error: " + e);
		}
		
		
	}
	
	public static void fillNameHomeowners() {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/databasethesis1?useTimezone=true&serverTimezone=UTC", "databasethesis1", "databasethesis1");
			String x = ID.getText();
			Statement fetch = con.createStatement();
			String getNameqry = "Select * from homeowners \r\n"
					+ "where homeowner_ID = '"+x+"'"
							+ "";
			ResultSet result = fetch.executeQuery(getNameqry);
			while(result.next()) {
				String fname = result.getString("first_name");
				String lname = result.getString("last_name");
				
				String homeownersnName = fname +" "+ lname;

				name.setText(homeownersnName);
				System.out.println(homeownersnName);
				con.close();
				
				
			}
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void fillNameEmp() {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/databasethesis1?useTimezone=true&serverTimezone=UTC", "databasethesis1", "databasethesis1");
			String x = ID.getText();
			Statement fetch = con.createStatement();
			String getNameqry = "Select * from employees \r\n"
					+ "where emp_ID = '"+x+"'";
			ResultSet result = fetch.executeQuery(getNameqry);
			while(result.next()) {
				String fname = result.getString("first_name");
				String lname = result.getString("last_name");
				
				String empName = fname +" "+ lname;

				name.setText(empName);
				
				con.close();
			}
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void fillNameVisitor() {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/databasethesis1?useTimezone=true&serverTimezone=UTC", "databasethesis1", "databasethesis1");
			String x = ID.getText();
			Statement fetch = con.createStatement();
			String getNameqry = "Select * from visitor \r\n"
					+ "where visitor_ID = '"+x+"'"
							+ "";
			ResultSet result = fetch.executeQuery(getNameqry);
			while(result.next()) {
				String fname = result.getString("first_name");
				String lname = result.getString("last_name");
				
				String visName = fname +" "+ lname;

				name.setText(visName);
			}
			
			con.close();
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void all() {
		visitor = new ArrayList<String>();
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/databasethesis1?useTimezone=true&serverTimezone=UTC", "databasethesis1", "databasethesis1");
		
			Statement fetch = con.createStatement();
			String allVisitor = "Select * from logbook where visitorType = '"+"delivery"+"'";
			
			ResultSet rs = fetch.executeQuery(allVisitor);
			
			while(rs.next()) {
				String VistNo = String.valueOf(rs.getInt("visitorNo"));
				String fname = rs.getString("first_name");
				String lname = rs.getString("last_name");
				String name = fname + lname;
				String type = rs.getString("visitorType");
				String visitTo = rs.getString("homeownerName");
				String date_in = rs.getString("date_in");
				String time_in = rs.getString("time_in");
				String date_out = rs.getString("date_out");
				String time_out = rs.getString("time_out");
				String plateNumber = rs.getString("plateNumber");
				
				visitor.add(VistNo);
				visitor.add(name);
				visitor.add(type);
				visitor.add(visitTo);
				visitor.add(date_in);
				visitor.add(time_in);
				visitor.add(date_out);
				visitor.add(time_out);
				visitor.add(plateNumber);
			}
			
			
		}catch(Exception e) {
			
		}
	}
	
	public void tableUpdate() {
		ArrayList<String> update = visitor;
		
		LogBook all = new LogBook();
		DefaultTableModel tblModel = (DefaultTableModel)all.allVisitorTable.getModel();
		
		
	}
	
	
	public static void smsNotification() {
		homeownerName = visitTo.getText();
		
	
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/databasethesis1?useTimezone=true&serverTimezone=UTC", "databasethesis1", "databasethesis1");
			Statement fetch = con.createStatement();
			String getFnameqry = "Select * from homeowners \r\n"
					+ "where CONCAT(first_name, ' ', last_name) LIKE '"+homeownerName+"'"
							+ "";
					
			ResultSet result = fetch.executeQuery(getFnameqry);
			
			
			while(result.next() ) {
				String fetchNumber = result.getString("mobile_number");
				number = fetchNumber.substring(1);
			
				System.out.println("+63"+number);
			}
			con.close();
		}catch (Exception e) {
			System.out.println(e);
		}
		
		final String ACCOUNT_SID =("ACb034dbeadee19aa97e6f3ed3c5c27f9e");
	    final String AUTH_TOKEN = ("e9a71f3222ee9ef35ecdaeec0f93f9cc");
	    
	    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("+63" + number),
                new com.twilio.type.PhoneNumber("+18312154484"),
                "Your Visitor " +name.getText()+ "has arrived")
            .create();

        System.out.println(message.getSid());
		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisitorInfo frame = new VisitorInfo();
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
	public VisitorInfo() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 491, 537);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(156, 182, 214));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Toolkit toolkit = getToolkit();
		Dimension size = toolkit.getScreenSize();
		setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(206, 199, 198));
		panel.setBounds(10, 11, 457, 476);
		contentPane.add(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				String x = ID.getText();
				
				
				if (flagType == true) {
					if (x.contains("SubdO")) {
						fillNameHomeowners();
						homeowner.setText("Homeowner");
						homeowner.setVisible(true);
						rdbtnWithConfirmation.setVisible(false);
						rdbtnWithoutConfirmation.setVisible(false);
						System.out.println(name);
						flagType = false;
					} else if (x.contains("emp")) {
						fillNameEmp();
						homeowner.setText("Employee");
						homeowner.setVisible(true);
						rdbtnWithConfirmation.setVisible(false);
						rdbtnWithoutConfirmation.setVisible(false);
						flagType = false;
					}else if (x.contains("Oth")) {
						fillNameVisitor();
						homeowner.setText("Specify Visitor Type");
						homeowner.setFont(new Font("Monospaced", Font.PLAIN, 15));
						othersType.setVisible(true);
						homeowner.setVisible(true);
						rdbtnWithConfirmation.setVisible(false);
						rdbtnWithoutConfirmation.setVisible(false);
						flagType = false;
					}else if (x.contains("Del")) {
						fillNameVisitor();
						list.setVisible(true);
						lbl1.setVisible(true);
						lbl1.setText("Delivery For:");
						visitTo.setVisible(true);
						flagType = false;
						flag = false;
						rdbtnWithConfirmation.setVisible(false);
						rdbtnWithoutConfirmation.setVisible(false);
						flagType = false;
					}else if (x.contains("Tax")) {
						fillNameVisitor();
						list.setVisible(true);
						lbl1.setVisible(true);
						lbl1.setText("Hire by:");
						visitTo.setVisible(true);
						flagType = false;
						flag = false;
						rdbtnWithConfirmation.setVisible(false);
						rdbtnWithoutConfirmation.setVisible(false);
						flagType = false;
					}else {
						fillNameVisitor();
						list.setVisible(true);
						lbl1.setVisible(true);
						visitTo.setVisible(true);
						flagType = false;
					} 
					
				}else {
					
				}
				
				
				
				String sendTo = visitTo.getText();
				
				
				if(flag == true) {
					if(sendTo.isEmpty()) {
						System.out.println("empty");
					}else {
						//smsNotification();
						System.out.println("send");
						flag = false;
					}
				}else {
					
				}
				System.out.println(flag);
				
				
			}
		});
		panel_1.setBounds(10, 11, 437, 454);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		
		
		name = new JLabel("");
		name.setFont(new Font("Monospaced", Font.BOLD, 30));
		name.setBounds(10, 11, 417, 65);
		panel_1.add(name);
		
		
		lbl1 = new JLabel("Homeowner To Visit:");
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1.setFont(new Font("Monospaced", Font.PLAIN, 17));
		lbl1.setBounds(10, 125, 203, 24);
		panel_1.add(lbl1);
		lbl1.setVisible(false);
		ID = new JLabel("");
		ID.setHorizontalAlignment(SwingConstants.CENTER);
		ID.setFont(new Font("Monospaced", Font.PLAIN, 13));
		ID.setBounds(31, 32, 161, 56);
		panel_1.add(ID);
		
		list = new JLabel("");
		list.setBounds(127, 179, 227, 48);
		panel_1.add(list);
		list.setVisible(false);
		
		visitTo = new JTextField();
		visitTo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
//				autoComplete();
//				list.setText(nameList.toString().replace("[", "").replace("]", ""));
				
			}
		});
		visitTo.setBounds(127, 160, 227, 20);
		panel_1.add(visitTo);
		visitTo.setColumns(10);
		visitTo.setVisible(false);
		
		
		JLabel lblPlatenumber = new JLabel("Platenumber:");
		lblPlatenumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlatenumber.setFont(new Font("Monospaced", Font.PLAIN, 17));
		lblPlatenumber.setBounds(-30, 228, 203, 24);
		panel_1.add(lblPlatenumber);
		
		platenumber = new JTextField();
		platenumber.setFont(new Font("Monospaced", Font.PLAIN, 15));
		platenumber.setColumns(10);
		platenumber.setBounds(128, 263, 226, 20);
		panel_1.add(platenumber);
		
		homeowner = new JLabel("");
		homeowner.setHorizontalAlignment(SwingConstants.CENTER);
		homeowner.setFont(new Font("Monospaced", Font.BOLD, 28));
		homeowner.setBounds(43, 125, 323, 65);
		panel_1.add(homeowner);
		homeowner.setVisible(false);
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/databasethesis1?useTimezone=true&serverTimezone=UTC", "databasethesis1", "databasethesis1");
			Statement fetch = con.createStatement();
			String qryCount = "select count(*) from logbook";
			
			ResultSet result = fetch.executeQuery(qryCount);
			
			result.next();
			int count = result.getInt(1);
			
			visitorNo = count + 1;
			
			System.out.println(visitorNo);
		} catch (SQLException e2) {
		
			e2.printStackTrace();
		}
	
		btnRecord = new JButton("Record");
		btnRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					if(withConfirmation == true){
						confirmation = "With Conformation";
					}else {
						confirmation = "Without Conformation";
					}
					
					
					DateTimeFormatter tf = DateTimeFormatter.ofPattern("HH:mm:ss");
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd");
					LocalDate localDate = LocalDate.now();
					LocalTime localTime = LocalTime.now();
					  
					String date = dtf.format(localDate);
					String time = tf.format(localTime);
					  
					String x = ID.getText();
					String plateNum = platenumber.getText();
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/databasethesis1?useTimezone=true&serverTimezone=UTC", "databasethesis1", "databasethesis1");
					
					
							
					//Visitor filtering
						if(x.contains("SubdO")) {
							rdbtnWithConfirmation.setVisible(false);
							rdbtnWithoutConfirmation.setVisible(false);
								String stmt = "insert into logbook(visitor_ID, first_name, last_name)\r\n"
										+ "(select homeowner_ID , first_name, last_name \r\n"
										+ "from homeowners\r\n"
										+ "where homeowner_ID = '" +x+ "')";
								
								String update = "update logbook \r\n"
										+ "set visitorType = '"+"Homeowner"+"', plateNumber = '"+plateNum+"' \r\n"
										+ "where visitorNo = '"+visitorNo+"'";
								
								String timeQry = "update logbook\r\n"
										+ "set date_in = '" +date+ "' , time_in = '" +time+ "' \r\n"
										+ "where visitor_ID = '" +x+ "'\r\n"
										+ "and visitorNo ='"+visitorNo+"'";
								
								
								
								PreparedStatement pst = con.prepareStatement(stmt);
								PreparedStatement updatetype = con.prepareStatement(update);
								PreparedStatement recordTime = con.prepareStatement(timeQry);
							
								
								pst.executeUpdate();
								updatetype.executeUpdate();
								recordTime.executeUpdate();
								
								
								JOptionPane.showMessageDialog(name, "Recorded", "", JOptionPane.INFORMATION_MESSAGE);
								visitTo.setText("");
								con.close();
								dispose();
								
								
								
								
						}else if(x.contains("emp")){	
							rdbtnWithConfirmation.setVisible(false);
							rdbtnWithoutConfirmation.setVisible(false);
								String stmt = "insert into logbook(visitor_ID, first_name, last_name)\r\n"
										+ "(select emp_ID , first_name, last_name\r\n"
										+ "from employees\r\n"
										+ "where emp_ID = '" +x+ "')";
								
								String update = "update logbook \r\n"
										+ "set visitorType = '" +"Employee"+"', plateNumber = '"+plateNum+"' \r\n"
										+ "where visitorNo = '"+visitorNo+"'";
								
								String timeQry = "update logbook\r\n"
										+ "set date_in = '" +date+ "' , time_in = '" +time+ "' \r\n"
										+ "where visitor_ID = '" +x+ "'\r\n"
										+ "and visitorNo ='"+visitorNo+"'";
								
								PreparedStatement pst = con.prepareStatement(stmt);
								PreparedStatement updatetype = con.prepareStatement(update);
								PreparedStatement recordTime = con.prepareStatement(timeQry);
								
								
								pst.executeUpdate();
								updatetype.executeUpdate();
								recordTime.executeUpdate();
								
								
								JOptionPane.showMessageDialog(null, "Recorded", "", JOptionPane.INFORMATION_MESSAGE);
								visitTo.setText("");
								con.close();
								dispose();
								
								
						}else if(x.contains("Oth")){	
							rdbtnWithConfirmation.setVisible(false);
							rdbtnWithoutConfirmation.setVisible(false);
							String type = othersType.getText();
								String stmt = "insert into logbook(visitor_ID, first_name, last_name, visitorType)\r\n"
										+ "(select visitor.visitor_ID , visitor.first_name, visitor.last_name, visitortype.vis_type \r\n"
										+ "from visitor\r\n"
										+ "inner join visitortype on visitor.visitorType_ID = visitortype.visitorType_ID \r\n"
										+ "where visitor_ID = '" + x + "')";
								
								String update = "update logbook \r\n"
										+ "set visitorType = '" +type+"', plateNumber = '"+plateNum+"' \r\n"
										+ "where visitorNo = '"+visitorNo+"'";
								
								String timeQry = "update logbook\r\n"
										+ "set date_in = '" +date+ "' , time_in = '" +time+ "' \r\n"
										+ "where visitor_ID = '" +x+ "'\r\n"
										+ "and visitorNo ='"+visitorNo+"'";
								
								PreparedStatement pst = con.prepareStatement(stmt);
								PreparedStatement updatetype = con.prepareStatement(update);
								PreparedStatement recordTime = con.prepareStatement(timeQry);
								
								
								pst.executeUpdate();
								updatetype.executeUpdate();
								recordTime.executeUpdate();
								
								
								JOptionPane.showMessageDialog(null, "Recorded", "", JOptionPane.INFORMATION_MESSAGE);
								visitTo.setText("");
								con.close();
								dispose();
								
								
								
						}else {
								String stmt = "insert into logbook(visitor_ID, first_name, last_name, visitorType)\r\n"
										+ "(select visitor.visitor_ID , visitor.first_name, visitor.last_name, visitortype.vis_type \r\n"
										+ "from visitor\r\n"
										+ "inner join visitortype on visitor.visitorType_ID = visitortype.visitorType_ID \r\n"
										+ "where visitor_ID = '" + x + "')";
								
								String visits = "update logbook \r\n"
										+ "set homeownerName = '"+visitTo.getText()+"' ,plateNumber = '"+plateNum+"'\r\n"
										+ "where visitor_ID = '"+x+"'\r\n"
										+ "and visitorNo ='"+visitorNo+"'";
								
								
								String getFnameqry = "Select * from homeowners \r\n"
										+ "where CONCAT(first_name, ' ', last_name) LIKE '"+visitTo.getText()+"'"
												+ "";
								
								String timeQry = "update logbook\r\n"
										+ "set date_in = '" +date+ "' , time_in = '" +time+ "' \r\n"
										+ "where visitor_ID = '" +x+ "'\r\n"
										+ "and visitorNo ='"+visitorNo+"'";
								
								String confirmationQry = "update logbook\r\n"
										+ "set confirmation = '" +confirmation+ "' \r\n"
										+ "where visitor_ID = '" +x+ "'";
								
								
								
								Statement fetch = con.createStatement();
								ResultSet result = fetch.executeQuery(getFnameqry);
								PreparedStatement recordTime = con.prepareStatement(timeQry);
								PreparedStatement pst = con.prepareStatement(stmt);
								PreparedStatement visit = con.prepareStatement(visits);
								PreparedStatement exeConfimationQry = con.prepareStatement(confirmationQry);
								
								
								
								System.out.println(time + "\n" + date);
								
								
								if(visitTo.getText().isEmpty()) {
									JOptionPane.showMessageDialog(null, "Fill in Home owner to visit", "ERROR", JOptionPane.ERROR_MESSAGE);
								}else if(result.next()){
									
									pst.executeUpdate();
									visit.executeUpdate();
									recordTime.executeUpdate();
									exeConfimationQry.executeUpdate();
									
									all();
								
									JOptionPane.showMessageDialog(null, "Recorded", "", JOptionPane.INFORMATION_MESSAGE);
									visitTo.setText("");
									con.close();
									dispose();
									
									
								}else {
									JOptionPane.showMessageDialog(null, "Homeowner does not exist!", "ERROR", JOptionPane.ERROR_MESSAGE);
									
								}
							
								
						}
					
							
							
					 }catch (Exception e1) {
						System.out.println("error: " + e1);
					}
				}
			});
			btnRecord.setBackground(Color.LIGHT_GRAY);
			btnRecord.setBounds(166, 417, 98, 26);
			panel_1.add(btnRecord);
			
			rdbtnWithConfirmation = new JRadioButton("With Conformation");
			rdbtnWithConfirmation.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(e.getStateChange()==ItemEvent.SELECTED) {
						withConfirmation = true;
						
					}else {
						withoutConfirmation = false;
					}
				}
			});
			rdbtnWithConfirmation.setFont(new Font("Monospaced", Font.PLAIN, 14));
			rdbtnWithConfirmation.setBounds(10, 336, 203, 23);
			panel_1.add(rdbtnWithConfirmation);
			
			rdbtnWithoutConfirmation = new JRadioButton("Without Conformation");
			rdbtnWithoutConfirmation.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(e.getStateChange()==ItemEvent.SELECTED) {
						withoutConfirmation = true;
						
					}else {
						withConfirmation = false;
					}
				}
			});
			rdbtnWithoutConfirmation.setFont(new Font("Monospaced", Font.PLAIN, 14));
			rdbtnWithoutConfirmation.setBounds(210, 336, 227, 23);
			panel_1.add(rdbtnWithoutConfirmation);
			group.add(rdbtnWithConfirmation);
			group.add(rdbtnWithoutConfirmation);
			
			othersType = new JTextField();
			othersType.setFont(new Font("Monospaced", Font.PLAIN, 15));
			othersType.setVisible(false);
			othersType.setColumns(10);
			othersType.setBounds(127, 179, 226, 20);
			panel_1.add(othersType);
		
	}
}
