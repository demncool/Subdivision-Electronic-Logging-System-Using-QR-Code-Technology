package final_;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.DefaultCellEditor;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import com.sun.source.tree.CompilationUnitTree;

import net.proteanit.sql.DbUtils;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;

@SuppressWarnings("serial")
public class AdminDashboard extends JFrame {
	
	
	
	private JLayeredPane layeredPane;
	public JTable allVisitorTable;
//	private  Boolean flagAll = true , flagTaxi = true, flagRF = true, flagDelivery = true, flagOwners = true, flagEmp = true;
	public JTable tableDelivery;
	private JTable tableTaxi;
	private JTable tableRF;
	private JPanel contentPane;
	private JTable tableHomeowners;
	private JTable tableEmployees;
	private JLabel lblVisitorCount;
	private JTable tableRegisteredVisitor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminDashboard frame = new AdminDashboard();
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
	
	public void switchPanel(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
	
//	public void updateTable() {
//		DefaultTableModel tblModel = (DefaultTableModel) allVisitorTable.getModel();
//		tblModel.fireTableDataChanged();
//		
//	}

	public void showAllVisitors() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/databasethesis1?useTimezone=true&serverTimezone=UTC", "databasethesis1", "databasethesis1");
		
			Statement fetch = con.createStatement();
			String allVisitor = "Select * from logbook";
			
			ResultSet rs = fetch.executeQuery(allVisitor);
			
			while(rs.next()) {
				String VistNo = String.valueOf(rs.getInt("visitorNo"));
				String fname = rs.getString("first_name");
				String lname = rs.getString("last_name");
				String name = fname +" " + lname;
				String type = rs.getString("visitorType");
				String visitTo = rs.getString("homeownerName");
				String date_in = rs.getString("date_in");
				String time_in = rs.getString("time_in");
				String date_out = rs.getString("date_out");
				String time_out = rs.getString("time_out");
				String plateNumber = rs.getString("plateNumber");
				
				String tableData[] = {VistNo, name, type, visitTo, date_in, time_in, date_out, time_out, plateNumber};
				DefaultTableModel tblModel = (DefaultTableModel) allVisitorTable.getModel();
				tblModel.addRow(tableData);	
				
			}
		
			
		} catch (Exception e) {
			
			System.out.println("error: " + e);
		}
		
	}
	
	private void showDelivery() {
		
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
				String name = fname +" " + lname;
				String type = rs.getString("visitorType");
				String visitTo = rs.getString("homeownerName");
				String date_in = rs.getString("date_in");
				String time_in = rs.getString("time_in");
				String date_out = rs.getString("date_out");
				String time_out = rs.getString("time_out");
				String plateNumber = rs.getString("plateNumber");
				
				String tableData[] = {VistNo, name, type, visitTo, date_in, time_in, date_out, time_out, plateNumber};
				DefaultTableModel tblModel = (DefaultTableModel) tableDelivery.getModel();
				tblModel.addRow(tableData);	
			}
			
		} catch (Exception e) {
			
			System.out.println("error: " + e);
		}
		
	}
	
	private void showTaxi() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/databasethesis1?useTimezone=true&serverTimezone=UTC", "databasethesis1", "databasethesis1");
		
			Statement fetch = con.createStatement();
			String allVisitor = "Select * from logbook where visitorType = '"+"taxi"+"'";
			
			ResultSet rs = fetch.executeQuery(allVisitor);
			
			while(rs.next()) {
				String VistNo = String.valueOf(rs.getInt("visitorNo"));
				String fname = rs.getString("first_name");
				String lname = rs.getString("last_name");
				String name = fname +" " + lname;
				String type = rs.getString("visitorType");
				String visitTo = rs.getString("homeownerName");
				String date_in = rs.getString("date_in");
				String time_in = rs.getString("time_in");
				String date_out = rs.getString("date_out");
				String time_out = rs.getString("time_out");
				String plateNumber = rs.getString("plateNumber");
				
				String tableData[] = {VistNo, name, type, visitTo, date_in, time_in, date_out, time_out, plateNumber};
				DefaultTableModel tblModel = (DefaultTableModel) tableTaxi.getModel();
				tblModel.addRow(tableData);	
			}
			
		} catch (Exception e) {
			
			System.out.println("error: " + e);
		}
		
	}
	
	
	private void showRF() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/databasethesis1?useTimezone=true&serverTimezone=UTC", "databasethesis1", "databasethesis1");
		
			Statement fetch = con.createStatement();
			String allVisitor = "Select * from logbook where visitorType = '"+"relative/friends"+"'";
			
			ResultSet rs = fetch.executeQuery(allVisitor);
			
			while(rs.next()) {
				String VistNo = String.valueOf(rs.getInt("visitorNo"));
				String fname = rs.getString("first_name");
				String lname = rs.getString("last_name");
				String name = fname +" " + lname;
				String type = rs.getString("visitorType");
				String visitTo = rs.getString("homeownerName");
				String date_in = rs.getString("date_in");
				String time_in = rs.getString("time_in");
				String date_out = rs.getString("date_out");
				String time_out = rs.getString("time_out");
				String plateNumber = rs.getString("plateNumber");
				
				String tableData[] = {VistNo, name, type, visitTo, date_in, time_in, date_out, time_out, plateNumber};
				DefaultTableModel tblModel = (DefaultTableModel) tableRF.getModel();
				tblModel.addRow(tableData);	
			}
			
		} catch (Exception e) {
			
			System.out.println("error: " + e);
		}
	}
	

	
	private void refreshAll() {
		DefaultTableModel tblModel1 = (DefaultTableModel) allVisitorTable.getModel();;
		int rows = tblModel1.getRowCount(); 
		for(int i = rows - 1; i >=0; i--){
			tblModel1.removeRow(i); 
			}
		}
	
	private void refreshRF() {
		DefaultTableModel tblModel1 = (DefaultTableModel) tableRF.getModel();
		int rows = tblModel1.getRowCount(); 
		for(int i = rows - 1; i >=0; i--){
			tblModel1.removeRow(i); 
			}
		}
	
	private void refreshTaxi() {
		DefaultTableModel tblModel1 = (DefaultTableModel) tableTaxi.getModel();
		int rows = tblModel1.getRowCount(); 
		for(int i = rows - 1; i >=0; i--){
			tblModel1.removeRow(i); 
			}
		}
	
	private void refreshDelivery() {
		DefaultTableModel tblModel1 = (DefaultTableModel) tableDelivery.getModel();
		int rows = tblModel1.getRowCount(); 
		for(int i = rows - 1; i >=0; i--){
			tblModel1.removeRow(i); 
			}
		}
	
	private void refreshEmp() {
		DefaultTableModel tblModel1 = (DefaultTableModel) tableEmployees.getModel();
		int rows = tblModel1.getRowCount(); 
		for(int i = rows - 1; i >=0; i--){
			tblModel1.removeRow(i); 
			}
		}
	
	private void refreshOwners() {
		DefaultTableModel tblModel1 = (DefaultTableModel) tableHomeowners.getModel();
		int rows = tblModel1.getRowCount(); 
		for(int i = rows - 1; i >=0; i--){
			tblModel1.removeRow(i); 
			}
		}
	
	private void refreshRegisteredVisitor() {
		DefaultTableModel tblModel1 = (DefaultTableModel) tableRegisteredVisitor.getModel();
		int rows = tblModel1.getRowCount(); 
		for(int i = rows - 1; i >=0; i--){
			tblModel1.removeRow(i); 
			}
		}
	
	private void visitorCount() {
		DefaultTableModel tblModel = (DefaultTableModel) allVisitorTable.getModel();
		int count = tblModel.getRowCount();
		String finalCount = Integer.toString(count);
		lblVisitorCount.setText(finalCount);
	}
	
public void showHomeowners() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/databasethesis1?useTimezone=true&serverTimezone=UTC", "databasethesis1", "databasethesis1");
		
			Statement fetch = con.createStatement();
			String allVisitor = "Select * from homeowners";
			
			ResultSet rs = fetch.executeQuery(allVisitor);
			
			while(rs.next()) {
				String ID = rs.getString("homeowner_ID");
				String fname = rs.getString("first_name");
				String lname = rs.getString("last_name");
				String name = fname +" " + lname;
				String lot = rs.getString("lot_number");
				String block = rs.getString("block_number");
				String mobile = rs.getString("mobile_number");
				String tel = rs.getString("tel_number");
				String user = rs.getString("username");
				String pass = rs.getString("password");
				
				String tableData[] = {ID, name, lot, block, mobile, tel, user, pass};
				DefaultTableModel tblModel = (DefaultTableModel) tableHomeowners.getModel();
				tblModel.addRow(tableData);	
				//"ID", "Name", "Street", "Lot", "block", "Mobile Number", "Telephone Number", "Username", "Password"
			}
		
			
		} catch (Exception e) {
			
			System.out.println("error: " + e);
		}
		
	}

public void showregisterdVisitors() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/databasethesis1?useTimezone=true&serverTimezone=UTC", "databasethesis1", "databasethesis1");
	
		Statement fetch = con.createStatement();
		String allVisitor = "Select * from visitor";
		
		ResultSet rs = fetch.executeQuery(allVisitor);
		
		while(rs.next()) {
			String ID = rs.getString("Visitor_ID");
			String fname = rs.getString("first_name");
			String lname = rs.getString("last_name");
			String name = fname +" " + lname;
			String address = rs.getString("address");
			String mobile = rs.getString("number");
			String sex = rs.getString("sex");
			String user = rs.getString("username");
			String pass = rs.getString("password");
			
			String tableData[] = {ID, name, address, mobile, sex, user, pass};
			DefaultTableModel tblModel = (DefaultTableModel) tableRegisteredVisitor.getModel();
			tblModel.addRow(tableData);	
			//"ID", "Name", "Address", "Number", "Sex",  "Username", "Password"
		}
	
		
	} catch (Exception e) {
		
		System.out.println("error: " + e);
	}
	
}

	

	public void showEmp() {
		String ID;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/databasethesis1?useTimezone=true&serverTimezone=UTC", "databasethesis1", "databasethesis1");
		
			Statement fetch = con.createStatement();
			String allVisitor = "Select * from employees";
			
			ResultSet rs = fetch.executeQuery(allVisitor);
			
			while(rs.next()) {
				ID = rs.getString("emp_ID");
				String fname = rs.getString("first_name");
				String lname = rs.getString("last_name");
				String name = fname +" " +lname;
				String Department = rs.getString("dept_ID");
				String hireDate = rs.getString("hire_date");
				String address = rs.getString("address");
				String number = rs.getString("number");
				String user = rs.getString("username");
				String pass = rs.getString("password");
				
				String tableData[] = {ID, name, Department, hireDate, address, number, user, pass};
				DefaultTableModel tblModel = (DefaultTableModel) tableEmployees.getModel();
				tblModel.addRow(tableData);	
				
			//"ID", "Name", "Department", "Hire Date", "Address", "Number", "Username", "Password"
				
			}
		
			
		} catch (Exception e) {
			
			System.out.println("error: " + e);
		}
		
	}
	
	
	public AdminDashboard() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1043, 624);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		Toolkit toolkit = getToolkit();
		Dimension size = toolkit.getScreenSize();
		setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(156, 182, 214));
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("Admin Dashboard");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Monospaced", Font.BOLD, 24));
		lblNewLabel_1.setBounds(10, 11, 225, 25);
		panel.add(lblNewLabel_1);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(10, 135, 1007, 436);
		panel.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel allVisitors = new JPanel();
		layeredPane.add(allVisitors, "name_18959113525000");
		allVisitors.setLayout(null);
		
		JTextField tf = new JTextField();
		tf.setEditable(false);
		DefaultCellEditor editor = new DefaultCellEditor( tf );
		
		// --------------------- ALL VISITOR TABLE -------------------------------------
		
		JScrollPane scrollPaneAll = new JScrollPane();
		scrollPaneAll.setBounds(10, 11, 987, 414);
		allVisitors.add(scrollPaneAll);
		
		allVisitorTable = new JTable();
		
		allVisitorTable.setFocusable(false);
		allVisitorTable.setCellSelectionEnabled(true);
		
		allVisitorTable.setDefaultEditor(Object.class, editor);
		allVisitorTable.getTableHeader().setReorderingAllowed(false);
		
		allVisitorTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPaneAll.setViewportView(allVisitorTable);
		allVisitorTable.setColumnSelectionAllowed(true);
		allVisitorTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Visitor No.", "Name", "Type", "Visit To", "Date Of Entry", "Time Of Entry", "Date of Exit", "Time Of Exit", "Plate Number"
			}
		));
		//
		
		//// ---------------------  TAXI TABLE -------------------------------------
		JPanel taxiVisitors = new JPanel();
		layeredPane.add(taxiVisitors, "name_18960804854600");
		taxiVisitors.setLayout(null);
		
		JScrollPane scrollPaneTaxi = new JScrollPane();
		scrollPaneTaxi.setBounds(10, 11, 987, 414);
		taxiVisitors.add(scrollPaneTaxi);
		
		tableTaxi = new JTable();
		
		tableTaxi.setFocusable(false);
		tableTaxi.setCellSelectionEnabled(true);
		
		tableTaxi.setDefaultEditor(Object.class, editor);
		tableTaxi.getTableHeader().setReorderingAllowed(false);
		
		tableTaxi.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Visitor No.", "Name", "Type", "Visit To", "Date Of Entry", "Time Of Entry", "Date of Exit", "Time Of Exit", "Plate Number"
			}
		));
		scrollPaneTaxi.setViewportView(tableTaxi);
		
		
		
		
		
		// ---------------------  DELIVERY TABLE -------------------------------------

		JPanel delivery = new JPanel();
		layeredPane.add(delivery, "name_20119751644100");
		delivery.setLayout(null);
		
		JScrollPane scrollPaneDeliver = new JScrollPane();
		scrollPaneDeliver.setBounds(10, 11, 987, 414);
		delivery.add(scrollPaneDeliver);
		
		tableDelivery = new JTable();
		
		tableDelivery.setFocusable(false);
		tableDelivery.setCellSelectionEnabled(true);
		
		tableDelivery.setDefaultEditor(Object.class, editor);
		tableDelivery.getTableHeader().setReorderingAllowed(false);
		
		scrollPaneDeliver.setViewportView(tableDelivery);
		tableDelivery.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Visitor No.", "Name", "Type", "Visit To", "Date Of Entry", "Time Of Entry", "Date of Exit", "Time Of Exit", "Plate Number"
			}
		));
		
		
		// ---------------------  RELATIVE/FRIENDS TABLE -------------------------------------
		
		JPanel relativesAndFriends = new JPanel();
		layeredPane.add(relativesAndFriends, "name_20121435167700");
		relativesAndFriends.setLayout(null);
		
		JScrollPane scrollPaneRF = new JScrollPane();
		scrollPaneRF.setBounds(10, 11, 987, 414);
		relativesAndFriends.add(scrollPaneRF);
		
		tableRF = new JTable();
		
		tableRF.setFocusable(false);
		tableRF.setCellSelectionEnabled(true);
		
		tableRF.setDefaultEditor(Object.class, editor);
		tableRF.getTableHeader().setReorderingAllowed(false);
		
		tableRF.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Visitor No.", "Name", "Type", "Visit To", "Date Of Entry", "Time Of Entry", "Date of Exit", "Time Of Exit", "Plate Number"
			}
		));
		scrollPaneRF.setViewportView(tableRF);
		
		
		// --------------------- HOMEOWNERS TABLE -------------------------------------
		JPanel homeowners = new JPanel();
		layeredPane.add(homeowners, "name_50880014926200");
		homeowners.setLayout(null);
		
		JScrollPane scrollPaneOwners = new JScrollPane();
		scrollPaneOwners.setBounds(10, 11, 987, 414);
		homeowners.add(scrollPaneOwners);
		
		tableHomeowners = new JTable();
		
		tableHomeowners.setFocusable(false);
		tableHomeowners.setCellSelectionEnabled(true);
		
		tableHomeowners.setDefaultEditor(Object.class, editor);
		tableHomeowners.getTableHeader().setReorderingAllowed(false);
		
		scrollPaneOwners.setViewportView(tableHomeowners);
		tableHomeowners.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "Lot", "block", "Mobile Number", "Telephone Number", "Username", "Password"
			}
		));
		
		// --------------------- EMPLOYEES TABLE -------------------------------------
		
		JPanel employees = new JPanel();
		layeredPane.add(employees, "name_52560929856500");
		employees.setLayout(null);
		
		JScrollPane scrollPaneEmp = new JScrollPane();
		scrollPaneEmp.setBounds(10, 11, 987, 414);
		employees.add(scrollPaneEmp);
		
		tableEmployees = new JTable();
		
		tableEmployees.setFocusable(false);
		tableEmployees.setCellSelectionEnabled(true);
		
		tableEmployees.setDefaultEditor(Object.class, editor);
		tableEmployees.getTableHeader().setReorderingAllowed(false);
		
		
		scrollPaneEmp.setViewportView(tableEmployees);
		tableEmployees.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "Department", "Hire Date", "Address", "Number", "Username", "Password"
			}
		));
		
		
		// --------------------- REGISTED VISITORS TABLE -------------------------------------
		JPanel registerdVisitorPanel = new JPanel();
		layeredPane.add(registerdVisitorPanel, "name_11853919811900");
		registerdVisitorPanel.setLayout(null);
		
		JScrollPane scrollPaneRegistedVisitor = new JScrollPane();
		scrollPaneRegistedVisitor.setBounds(10, 11, 987, 414);
		registerdVisitorPanel.add(scrollPaneRegistedVisitor);
		
		tableRegisteredVisitor = new JTable();
		tableRegisteredVisitor.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"ID", "Name", "Address", "Number", "Sex",  "Username", "Password"
			}
		));
		scrollPaneRegistedVisitor.setViewportView(tableRegisteredVisitor);
		
		JPanel visitorType = new JPanel();
		visitorType.setLayout(null);
		visitorType.setBackground(new Color(206, 199, 198));
		visitorType.setBounds(10, 47, 1007, 86);
		panel.add(visitorType);
		
		JLabel lblNewLabel = new JLabel("Your Visitors");
		lblNewLabel.setFont(new Font("Monospaced", Font.BOLD, 17));
		lblNewLabel.setBounds(10, 11, 148, 14);
		visitorType.add(lblNewLabel);
		
		//------------------------------- BUTTONS -----------------------------------------
		
		JButton btnAllVisitors = new JButton("All Visitors");
		btnAllVisitors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(allVisitors);
				refreshAll();
				showAllVisitors();
				visitorCount();
			}
		});
		btnAllVisitors.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAllVisitors.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnAllVisitors.setBounds(20, 42, 109, 23);
		btnAllVisitors.setBackground(new Color(206, 199, 198));
		visitorType.add(btnAllVisitors);
		
		JButton btnDelivery = new JButton("Delivery");
		btnDelivery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(delivery);
				refreshDelivery();
				showDelivery();
				visitorCount();
			}
		});
		btnDelivery.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDelivery.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnDelivery.setBackground(new Color(206, 199, 198));
		btnDelivery.setBounds(139, 42, 109, 23);
		visitorType.add(btnDelivery);
		
		JButton btnTaxi = new JButton("Taxi");
			btnTaxi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					switchPanel(taxiVisitors);
					refreshTaxi();
					showTaxi();
					visitorCount();
				}
			});
		btnTaxi.setFont(new Font("Monospaced", Font.PLAIN, 12));
		btnTaxi.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnTaxi.setBackground(new Color(206, 199, 198));
		btnTaxi.setBounds(258, 42, 109, 23);
		visitorType.add(btnTaxi);
		
		JButton btnCommonVisitor = new JButton("Relatives/ Friends");
			btnCommonVisitor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					switchPanel(relativesAndFriends);
					refreshRF();
					showRF();
					visitorCount();
				}
			});
		btnCommonVisitor.setFont(new Font("Monospaced", Font.PLAIN, 12));
		btnCommonVisitor.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnCommonVisitor.setBackground(new Color(206, 199, 198));
		btnCommonVisitor.setBounds(377, 42, 162, 23);
		visitorType.add(btnCommonVisitor);
		
		
		JButton btnRefreshLog = new JButton();
		btnRefreshLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshAll();
				refreshDelivery();
				refreshEmp();
				refreshOwners();
				refreshRF();
				refreshTaxi();
				showAllVisitors();
				showDelivery();
				showRF();
				showTaxi();
				showHomeowners();
				showEmp();
			}
		});
		btnRefreshLog.setBorder(null);
		btnRefreshLog.setBounds(950, 31, 49, 44);
		visitorType.add(btnRefreshLog);
		btnRefreshLog.setIcon(new ImageIcon(AdminDashboard.class.getResource("/Images/refresh.png")));
		btnRefreshLog.setBackground(new Color(206, 199, 198));
		
		lblVisitorCount = new JLabel("");
		lblVisitorCount.setEnabled(false);
		lblVisitorCount.setFont(new Font("Monospaced", Font.BOLD, 17));
		lblVisitorCount.setBounds(156, 11, 49, 14);
		visitorType.add(lblVisitorCount);
		
		JPanel listPanel = new JPanel();
		listPanel.setBackground(new Color(206, 199, 198));
		listPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Registered", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		listPanel.setBounds(549, 11, 390, 64);
		visitorType.add(listPanel);
		listPanel.setLayout(null);
		
		JButton btnHomeowners = new JButton("Homeowners");
		btnHomeowners.setBounds(10, 32, 114, 21);
		listPanel.add(btnHomeowners);
		btnHomeowners.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(homeowners);
				refreshOwners();
				showHomeowners();
				visitorCount();
			}
		});
		btnHomeowners.setFont(new Font("Monospaced", Font.PLAIN, 12));
		btnHomeowners.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnHomeowners.setBackground(new Color(206, 199, 198));
		
		
		JButton btnEmp = new JButton("Employees");
		btnEmp.setBounds(258, 31, 114, 23);
		listPanel.add(btnEmp);
		btnEmp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(employees);
				refreshEmp();
				showEmp();
				visitorCount();
			}
		});
		btnEmp.setFont(new Font("Monospaced", Font.PLAIN, 12));
		btnEmp.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnEmp.setBackground(new Color(206, 199, 198));
		
		JButton btnRegisteredVisitors = new JButton("Visitors");
		btnRegisteredVisitors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(registerdVisitorPanel);
				refreshRegisteredVisitor();
				showregisterdVisitors();
				visitorCount();
				
			}
		});
		btnRegisteredVisitors.setFont(new Font("Monospaced", Font.PLAIN, 12));
		btnRegisteredVisitors.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnRegisteredVisitors.setBackground(new Color(206, 199, 198));
		btnRegisteredVisitors.setBounds(134, 32, 114, 21);
		listPanel.add(btnRegisteredVisitors);
		
		
		JButton btnAdmin = new JButton();
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminFunctions admin = new AdminFunctions();
				admin.setVisible(true);
			}
		});
		btnAdmin.setBorder(null);
		btnAdmin.setBounds(937, 0, 80, 39);
		btnAdmin.setIcon(new ImageIcon(AdminDashboard.class.getResource("/Images/edit.png")));
		btnAdmin.setBackground(new Color(156, 182, 214));
		panel.add(btnAdmin);
		
	}
}
