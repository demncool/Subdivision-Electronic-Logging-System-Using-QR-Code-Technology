package final_;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main_ extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_ frame = new Main_();
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
	public Main_() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 414, 531);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(  156, 182, 214));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Toolkit toolkit = getToolkit();
		Dimension size = toolkit.getScreenSize();
		setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);

		
		JTextArea title = new JTextArea();
		title.setForeground(SystemColor.controlText);
		title.setBorder(null);
		title.setFont(new Font("Monospaced", Font.BOLD, 17));
		title.setBackground(new Color( 156, 182, 214));
		title.setEditable(false);
		title.setVerifyInputWhenFocusTarget(false);
		title.setWrapStyleWord(true);
		title.setText("s\u1D1C\u0299\u1D05\u026A\u1D20\u026As\u026A\u1D0F\u0274 \u1D07\u029F\u1D07\u1D04\u1D1B\u0280\u1D0F\u0274\u026A\u1D04 \u029F\u1D0F\u0262\u0262\u026A\u0274\u0262 s\u028Fs\u1D1B\u1D07\u1D0D \r\n       \u1D1Cs\u026A\u0274\u0262 \u01EB\u0280 \u1D04\u1D0F\u1D05\u1D07 \u1D1B\u1D07\u1D04\u029C\u0274\u1D0F\u029F\u1D0F\u0262\u028F");
		title.setBounds(10, 37, 382, 75);
		contentPane.add(title);
		
		JButton newVisitor = new JButton("Unregistered Visitor");
		newVisitor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newVisitor newVisit = new newVisitor();
				newVisit.setVisible(true);
			}
		});
		newVisitor.setBounds(103, 157, 186, 35);
		contentPane.add(newVisitor);
		
		JButton entry = new JButton("ENTRY");
		entry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Camera_in cam = new Camera_in();
				cam.setVisible(true);
			}
		});
		entry.setBounds(103, 233, 186, 35);
		contentPane.add(entry);
		
		JButton exit = new JButton("EXIT");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Camera_out camOut = new Camera_out();
				camOut.setVisible(true);
			}
		});
		exit.setBounds(103, 319, 186, 35);
		contentPane.add(exit);
		
		JTextArea copy = new JTextArea();
		copy.setFont(new Font("Arial", Font.PLAIN, 7));
		copy.setText("\u00A9 2021 Group28 Thesis");
		copy.setBackground(new Color(156, 182, 214));
		copy.setBounds(0, 488, 94, 14);
		contentPane.add(copy);
		
		JButton visitorsList = new JButton("View Logs");
		visitorsList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogBook allList = new LogBook();
				allList.setVisible(true);
				
			}
		});
		visitorsList.setBounds(103, 397, 186, 35);
		contentPane.add(visitorsList);
	}
}
