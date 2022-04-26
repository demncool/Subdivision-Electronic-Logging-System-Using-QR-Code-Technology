package final_;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.protocol.Resultset;

import net.proteanit.sql.DbUtils;

import javax.swing.border.EtchedBorder;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.JFormattedTextField;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.MatteBorder;

@SuppressWarnings({ "serial", "unused" })
public class LogBook extends JFrame {

	private JPanel contentPane;
	private JLayeredPane layeredPane;
	public JTable allVisitorTable;
	@SuppressWarnings("unused")
	private  Boolean flagAll = true , flagTaxi = true, flagRF = true, flagDelivery = true;
	public JTable tableDelivery;
	private JTable tableTaxi;
	private JTable tableRF;
	private JLabel lblVisitorCount;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogBook frame = new LogBook();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
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
				String name = fname +" "+ lname;
				String type = rs.getString("visitorType");
				String visitTo = rs.getString("homeownerName");
				String date_in = rs.getString("date_in");
				String time_in = rs.getString("time_in");
				String date_out = rs.getString("date_out");
				String time_out = rs.getString("time_out");
				String plateNumber = rs.getString("plateNumber");
				String confirmation = rs.getString("confirmation");
				
				String tableData[] = {VistNo, name, type, visitTo, date_in, time_in, date_out, time_out, plateNumber,confirmation};
				DefaultTableModel tblModel = (DefaultTableModel) allVisitorTable.getModel();
				tblModel.addRow(tableData);	
				
			}
		
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
				String name = fname +" "+ lname;
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
			// TODO Auto-generated catch block
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
				String name = fname +" "+ lname;
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
			// TODO Auto-generated catch block
			System.out.println("error: " + e);
		}
		
	}
	
	
	private void showRF() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/databasethesis1?useTimezone=true&serverTimezone=UTC", "databasethesis1", "databasethesis1");
		
			Statement fetch = con.createStatement();
			String allVisitor = "Select * from logbook where visitorType = '"+"Relative/friends"+"'";
			
			ResultSet rs = fetch.executeQuery(allVisitor);
			
			while(rs.next()) {
				String VistNo = String.valueOf(rs.getInt("visitorNo"));
				String fname = rs.getString("first_name");
				String lname = rs.getString("last_name");
				String name = fname +" "+ lname;
				String type = rs.getString("visitorType");
				String visitTo = rs.getString("homeownerName");
				String date_in = rs.getString("date_in");
				String time_in = rs.getString("time_in");
				String date_out = rs.getString("date_out");
				String time_out = rs.getString("time_out");
				String plateNumber = rs.getString("plateNumber");
				String confirmation = rs.getString("confirmation");
				
				String tableData[] = {VistNo, name, type, visitTo, date_in, time_in, date_out, time_out, plateNumber,confirmation};
				DefaultTableModel tblModel = (DefaultTableModel) tableRF.getModel();
				tblModel.addRow(tableData);	
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
	
	private void visitorCount() {
		DefaultTableModel tblModel = (DefaultTableModel) allVisitorTable.getModel();
		int count = tblModel.getRowCount();
		String finalCount = Integer.toString(count);
		lblVisitorCount.setText(finalCount);
	}
	
	
	public LogBook() {
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1082, 649);
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
		
		JLabel lblNewLabel_1 = new JLabel("Visitor List");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Monospaced", Font.BOLD, 24));
		lblNewLabel_1.setBounds(361, 21, 225, 25);
		panel.add(lblNewLabel_1);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(10, 135, 1046, 458);
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
		scrollPaneAll.setBounds(10, 11, 1026, 436);
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
				"Visitor No.", "Name", "Type", "Visit To", "Date Of Entry", "Time Of Entry", "Date of Exit", "Time Of Exit", "Plate Number", "Confirmation"
			}
		));
		//
		
		//// ---------------------  TAXI TABLE -------------------------------------
		JPanel taxiVisitors = new JPanel();
		layeredPane.add(taxiVisitors, "name_18960804854600");
		taxiVisitors.setLayout(null);
		
		JScrollPane scrollPaneTaxi = new JScrollPane();
		scrollPaneTaxi.setBounds(10, 11, 1026, 436);
		taxiVisitors.add(scrollPaneTaxi);

		
		tableTaxi = new JTable();
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
		scrollPaneDeliver.setBounds(10, 11, 1026, 436);
		delivery.add(scrollPaneDeliver);
		
	
		
		tableDelivery = new JTable();
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
		scrollPaneRF.setBounds(10, 11, 1026, 436);
		relativesAndFriends.add(scrollPaneRF);	
		
		tableRF = new JTable();
		tableRF.setDefaultEditor(Object.class, editor);
		tableRF.getTableHeader().setReorderingAllowed(false);
		tableRF.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Visitor No.", "Name", "Type", "Visit To", "Date Of Entry", "Time Of Entry", "Date of Exit", "Time Of Exit", "Plate Number", "Confirmation"
			}
		));
		scrollPaneRF.setViewportView(tableRF);
		
		JPanel visitorType = new JPanel();
		visitorType.setLayout(null);
		visitorType.setBackground(new Color(206, 199, 198));
		visitorType.setBounds(10, 57, 1046, 76);
		panel.add(visitorType);
		
		JLabel lblNewLabel = new JLabel("Your Visitors");
		lblNewLabel.setFont(new Font("Monospaced", Font.BOLD, 17));
		lblNewLabel.setBounds(10, 11, 148, 14);
		visitorType.add(lblNewLabel);
		
		showAllVisitors();
		
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
		btnAllVisitors.setBounds(20, 36, 109, 23);
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
		btnDelivery.setBounds(139, 36, 109, 23);
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
		btnTaxi.setBounds(258, 36, 109, 23);
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
		btnCommonVisitor.setBounds(377, 36, 162, 23);
		visitorType.add(btnCommonVisitor);
		
		
		
		JButton btnRefreshLog = new JButton();
		btnRefreshLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshAll();
				refreshDelivery();
				refreshRF();
				refreshTaxi();
				showAllVisitors();
				showDelivery();
				showRF();
				showTaxi();
			}
		});
		btnRefreshLog.setBorder(null);
		btnRefreshLog.setBounds(963, 11, 73, 57);
		visitorType.add(btnRefreshLog);
		btnRefreshLog.setIcon(new ImageIcon(AdminDashboard.class.getResource("/Images/refresh.png")));
		btnRefreshLog.setBackground(new Color(206, 199, 198));
		
		lblVisitorCount = new JLabel("");
		lblVisitorCount.setFont(new Font("Monospaced", Font.BOLD, 17));
		lblVisitorCount.setEnabled(false);
		lblVisitorCount.setBounds(155, 11, 49, 14);
		visitorType.add(lblVisitorCount);
	}
}
