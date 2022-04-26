package prototype;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.JFormattedTextField;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VisitorList extends JFrame {

	private JPanel contentPane;
	private JLayeredPane layeredPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisitorList frame = new VisitorList();
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
	
	public VisitorList() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 908, 624);
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
		lblNewLabel_1.setBounds(320, 21, 225, 25);
		panel.add(lblNewLabel_1);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(10, 135, 865, 436);
		panel.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel allVisitors = new JPanel();
		layeredPane.add(allVisitors, "name_18959113525000");
		allVisitors.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("ALL VISITORS LIST");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Monospaced", Font.BOLD, 24));
		lblNewLabel_1_1.setBounds(234, 110, 349, 25);
		allVisitors.add(lblNewLabel_1_1);
		
		JPanel taxiVisitors = new JPanel();
		layeredPane.add(taxiVisitors, "name_18960804854600");
		taxiVisitors.setLayout(null);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("TAXI LIST");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("Monospaced", Font.BOLD, 24));
		lblNewLabel_1_1_1.setBounds(260, 115, 349, 25);
		taxiVisitors.add(lblNewLabel_1_1_1);
		
		JPanel delivery = new JPanel();
		layeredPane.add(delivery, "name_20119751644100");
		delivery.setLayout(null);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("DELIVERY LIST");
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2.setFont(new Font("Monospaced", Font.BOLD, 24));
		lblNewLabel_1_1_2.setBounds(242, 162, 349, 25);
		delivery.add(lblNewLabel_1_1_2);
		
		JPanel relativesAndFriends = new JPanel();
		layeredPane.add(relativesAndFriends, "name_20121435167700");
		relativesAndFriends.setLayout(null);
		
		JLabel lblNewLabel_1_2 = new JLabel("Relative/Friends List");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Monospaced", Font.BOLD, 24));
		lblNewLabel_1_2.setBounds(276, 159, 332, 25);
		relativesAndFriends.add(lblNewLabel_1_2);
		
		JPanel visitorType = new JPanel();
		visitorType.setLayout(null);
		visitorType.setBackground(new Color(206, 199, 198));
		visitorType.setBounds(10, 57, 865, 76);
		panel.add(visitorType);
		
		JLabel lblNewLabel = new JLabel("Your Visitors");
		lblNewLabel.setFont(new Font("Monospaced", Font.BOLD, 17));
		lblNewLabel.setBounds(10, 11, 148, 14);
		visitorType.add(lblNewLabel);
		
		JButton btnAllVisitors = new JButton("All Visitors");
		btnAllVisitors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(allVisitors);
				
			}
		});
		btnAllVisitors.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAllVisitors.setBorder(null);
		btnAllVisitors.setBounds(20, 36, 109, 23);
		btnAllVisitors.setBackground(new Color(206, 199, 198));
		visitorType.add(btnAllVisitors);
		
		JButton btnDelivery = new JButton("Delivery");
		btnDelivery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(delivery);
			}
		});
		btnDelivery.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDelivery.setBorder(null);
		btnDelivery.setBackground(new Color(206, 199, 198));
		btnDelivery.setBounds(169, 36, 109, 23);
		visitorType.add(btnDelivery);
		
		JButton btnTaxi = new JButton("Taxi");
			btnTaxi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					switchPanel(taxiVisitors);
				}
			});
		btnTaxi.setFont(new Font("Monospaced", Font.PLAIN, 12));
		btnTaxi.setBorder(null);
		btnTaxi.setBackground(new Color(206, 199, 198));
		btnTaxi.setBounds(329, 36, 109, 23);
		visitorType.add(btnTaxi);
		
		JButton btnCommonVisitor = new JButton("Relatives/ Friends");
			btnCommonVisitor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					switchPanel(relativesAndFriends);
				}
			});
		btnCommonVisitor.setFont(new Font("Monospaced", Font.PLAIN, 12));
		btnCommonVisitor.setBorder(null);
		btnCommonVisitor.setBackground(new Color(206, 199, 198));
		btnCommonVisitor.setBounds(490, 36, 162, 23);
		visitorType.add(btnCommonVisitor);
	}
}
