package prototype;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import java.util.logging.*;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.Result;
import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;
import javax.swing.SwingConstants;

public class Camera_in extends JFrame {

	private JPanel contentPane;
	WebcamPanel webCamPanel;
	Webcam webcam;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Camera_in frame = new Camera_in();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	};

	/**
	 * Create the frame.
	 */
	public Camera_in() {
		setResizable(false);
		
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		
		setType(Type.UTILITY);
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		
		setBounds(100, 100, 343, 352);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Toolkit toolkit = getToolkit();
		Dimension size = toolkit.getScreenSize();
		setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
		
		try {
			webcam = Webcam.getWebcams().get(0);
			webcam.setViewSize(WebcamResolution.QVGA.getSize());
			webcam.open();
			webCamPanel = new WebcamPanel(webcam);
			webCamPanel.setBounds(124, 5, 176, 144);
			webCamPanel.setImageSizeDisplayed(true);
			webCamPanel.setFPSDisplayed(true);
			webCamPanel.setMirrored(true);
		}catch(Exception e) {
			System.out.println("Camera in use");
		}
		
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 33, 344, 199);
		contentPane.add(panel);
		panel.add(webCamPanel);
		panel.setSize(new Dimension(320,240));
		
		JButton btnCapture = new JButton("CAPTURE");
		btnCapture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame f= new JFrame();  
		        JDialog d = new JDialog(f , "Dialog Example", true);  
		        d.getContentPane().add(new JLabel("Scanning QR CODE...."));
		        d.setSize(200,80);
		        d.setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
		        
		     // Set a 2 second timer
				new Thread(new Runnable() {
					@Override
					public void run() {
						try {
							Thread.sleep(2000);
						} catch (Exception e) {
						}
						d.dispose();
							
							dispose();
							webcam.close();
							RecordPanel recordPanel = new RecordPanel();
							recordPanel.setVisible(true);
							
					}

				}).start();
		        
				 d.setVisible(true);
			}
		});
		btnCapture.setBounds(49, 318, 89, 23);
		contentPane.add(btnCapture);
		
		JButton btnTerminate = new JButton("TERMINATE");
		btnTerminate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				webcam.close();
				dispose();
			}
		});
		btnTerminate.setBounds(186, 318, 89, 23);
		contentPane.add(btnTerminate);
		
		JLabel lblNewLabel = new JLabel("COMING IN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(131, 11, 81, 14);
		contentPane.add(lblNewLabel);
		
		
		
		
		
		
		
	
	
	}
}
