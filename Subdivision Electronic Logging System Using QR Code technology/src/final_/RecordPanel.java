package final_;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;

public class RecordPanel extends JFrame {

	private JPanel contentPane;
	private JTextField visitTo;
	private JLabel lblVisitTo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RecordPanel frame = new RecordPanel();
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
	public RecordPanel() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 885, 533);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Toolkit toolkit = getToolkit();
		Dimension size = toolkit.getScreenSize();
		setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 864, 489);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setBackground(new Color(156, 182, 214));
		
		JPanel newVisitor = new JPanel();
		newVisitor.setLayout(null);
		newVisitor.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Record", TitledBorder.LEFT, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		newVisitor.setBackground(new Color(206, 199, 198));
		newVisitor.setBounds(10, 11, 843, 467);
		panel.add(newVisitor);
		
		JPanel visitorType = new JPanel();
		visitorType.setLayout(null);
		visitorType.setBackground(SystemColor.menu);
		visitorType.setBounds(10, 22, 245, 434);
		newVisitor.add(visitorType);
		
		JLabel lblNewLabel_1 = new JLabel("Visitor Type");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblNewLabel_1.setBounds(10, 11, 225, 25);
		visitorType.add(lblNewLabel_1);
		

		JPanel visitorInformation = new JPanel();
		visitorInformation.setLayout(null);
		visitorInformation.setBounds(265, 22, 568, 434);
		newVisitor.add(visitorInformation);
		
		JLabel lblVisitorType = new JLabel("");
		lblVisitorType.setHorizontalAlignment(SwingConstants.CENTER);
		lblVisitorType.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblVisitorType.setBounds(174, 11, 225, 25);
		visitorInformation.add(lblVisitorType);
		
		JButton btnRelative = new JButton("Relatives/ Friends");
		btnRelative.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblVisitorType.setText("Visitor");
			}
		});
		btnRelative.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRelative.setBounds(42, 98, 160, 57);
		visitorType.add(btnRelative);
		
		JButton btnTaxi = new JButton("TAXI");
		btnTaxi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblVisitorType.setText("Taxi");
			}
		});
		btnTaxi.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTaxi.setBounds(42, 341, 160, 57);
		visitorType.add(btnTaxi);
		
		JButton btnDeliver = new JButton("DELIVERY");
		btnDeliver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblVisitorType.setText("Delivery");
			}
		});
		btnDeliver.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDeliver.setBounds(42, 215, 160, 57);
		visitorType.add(btnDeliver);
		
		
		
		JLabel lblName_1 = new JLabel("Name:");
		lblName_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblName_1.setFont(new Font("Monospaced", Font.PLAIN, 17));
		lblName_1.setBounds(59, 109, 108, 20);
		visitorInformation.add(lblName_1);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setHorizontalAlignment(SwingConstants.LEFT);
		lblAddress.setFont(new Font("Monospaced", Font.PLAIN, 17));
		lblAddress.setBounds(59, 163, 78, 20);
		visitorInformation.add(lblAddress);
		
		JLabel lblMobileNumber = new JLabel("Mobile Number:");
		lblMobileNumber.setHorizontalAlignment(SwingConstants.LEFT);
		lblMobileNumber.setFont(new Font("Monospaced", Font.PLAIN, 17));
		lblMobileNumber.setBounds(59, 232, 152, 20);
		visitorInformation.add(lblMobileNumber);
		
		JLabel lblName_1_1 = new JLabel("Angelica Riva");
		lblName_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblName_1_1.setFont(new Font("Monospaced", Font.PLAIN, 17));
		lblName_1_1.setBounds(240, 109, 225, 20);
		visitorInformation.add(lblName_1_1);
		
		JLabel lblName_1_2 = new JLabel("San Juan, Lapasan");
		lblName_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblName_1_2.setFont(new Font("Monospaced", Font.PLAIN, 17));
		lblName_1_2.setBounds(240, 163, 225, 20);
		visitorInformation.add(lblName_1_2);
		
		JLabel lblName_1_3 = new JLabel("09546465831");
		lblName_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblName_1_3.setFont(new Font("Monospaced", Font.PLAIN, 17));
		lblName_1_3.setBounds(240, 232, 225, 20);
		visitorInformation.add(lblName_1_3);
		
		
		JButton btnRecord = new JButton("RECORD");
		btnRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(visitTo.getText().isEmpty()) {
					visitTo.setForeground(Color.red);
					visitTo.setText("Invalid Input...");
				
				}else {
					JDialog d = new JDialog();  
				    d.getContentPane().add(new JLabel("Succesfully recorded!"));
				    d.setSize(200,80);
				    d.setLocation(getMousePosition());
					d.setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
					
					new Thread(new Runnable() {
						@Override
						public void run() {
							try {
								Thread.sleep(2000);
							} catch (Exception e) {
							}
							d.dispose();
								
							
								
						}

					}).start();
			        
					 d.setVisible(true);
				}
				
			}
		});
		btnRecord.setBounds(240, 377, 89, 23);
		visitorInformation.add(btnRecord);
		
		lblVisitTo = new JLabel("Visit to: ");
		lblVisitTo.setHorizontalAlignment(SwingConstants.LEFT);
		lblVisitTo.setFont(new Font("Monospaced", Font.PLAIN, 17));
		lblVisitTo.setBounds(59, 299, 152, 20);
		visitorInformation.add(lblVisitTo);
		
		visitTo = new JTextField();
		visitTo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				visitTo.setText("");
				visitTo.setForeground(Color.BLACK);
			}
		});
		visitTo.setBounds(240, 301, 225, 20);
		visitorInformation.add(visitTo);
		visitTo.setColumns(10);
		
		
		
		
	}
}
