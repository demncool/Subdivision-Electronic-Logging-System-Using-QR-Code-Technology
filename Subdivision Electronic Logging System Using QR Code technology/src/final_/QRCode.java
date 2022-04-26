package final_;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QRCode extends JFrame {

	private JPanel contentPane;
	boolean female = false, male = false;
	private ButtonGroup group = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QRCode frame = new QRCode();
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
	public QRCode() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 365, 279);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 329, 218);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JRadioButton Male = new JRadioButton("Male");
		Male.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					male = true;		
				}else {
					female = false;
				}
			}
		});
		Male.setBounds(44, 43, 109, 23);
		panel.add(Male);
		
		JRadioButton Female = new JRadioButton("Female");
		Female.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					female = true;
				}else {
					male = false;
				}
			}
		});
		Female.setBounds(44, 105, 109, 23);
		panel.add(Female);
		
		group.add(Female);
		group.add(Male);
		
		JButton btnOkay = new JButton("New button");
		btnOkay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sex;
				if(male == true){
					sex = "MALE";
				}else {
					sex = "Female";
				}
				System.out.println(sex);
			}
		});
		btnOkay.setBounds(114, 165, 89, 23);
		panel.add(btnOkay);
		
		
		
		
		Toolkit toolkit = getToolkit();
		Dimension size = toolkit.getScreenSize();
		setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
	}
}
