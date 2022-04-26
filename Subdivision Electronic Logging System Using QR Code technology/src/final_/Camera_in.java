package final_;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.border.EmptyBorder;

import java.util.HashMap;
import java.util.Map;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class Camera_in extends JFrame {

	private JPanel contentPane;
	WebcamPanel webCamPanel;
	Webcam webcam;
	String visitorID;
	String ownerID;
	String visitorIDalone;
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

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static String readQRCode(String filePath, String charset, Map hintMap)
			throws FileNotFoundException, IOException, NotFoundException {
		BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(ImageIO.read(new FileInputStream(filePath)))));
		Result qrCodeResult = new MultiFormatReader().decode(binaryBitmap, hintMap);
		return qrCodeResult.getText();
	}
	
	
	public Camera_in() {
		setUndecorated(true);
		setType(Type.UTILITY);
		setResizable(false);
		getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setBounds(100, 100, 343, 388);
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
		panel.setBounds(10, 61, 344, 199);
		contentPane.add(panel);
		panel.add(webCamPanel);
		panel.setSize(new Dimension(320,240));
		
		JButton btnCapture = new JButton("CAPTURE");
		btnCapture.addActionListener(new ActionListener() {
			@SuppressWarnings({ "unchecked", "rawtypes", "static-access" })
			public void actionPerformed(ActionEvent e) {
				
				JFrame f= new JFrame();  
		        JDialog d = new JDialog(f , "Dialog Example", true);  
		        d.getContentPane().add(new JLabel("Try Again...."));
		        d.setSize(200,80);
		        d.setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
		        
		        String filePath = "QR_in.png";
				String charset = "UTF-8"; // or "ISO-8859-1"
				Map hintMap = new HashMap();
				hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
				
				
						try {
							ImageIO.write(webcam.getImage(), "PNG", new File("QR_in.png"));
							readQRCode(filePath, charset, hintMap);
						} catch (IOException  e1) {
							System.out.println("error: "+ e1);
						} catch (NotFoundException e1) {
							// TODO Auto-generated catch block
							new Thread(new Runnable() {
								@Override
								public void run() {
									try {
										Thread.sleep(1200);
									} catch (Exception e) {
									}
									d.dispose();
									
								}

							}).start();
					        
							 d.setVisible(true);
						}
						
		
				 
				 try {
					 
					 DateTimeFormatter tf = DateTimeFormatter.ofPattern("HH:mm:ss");
					  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd");
					  LocalDate localDate = LocalDate.now();
					  LocalTime localTime = LocalTime.now();
					  
					  String date = dtf.format(localDate);
					  String time = tf.format(localTime);
					  
					  
					 String x = readQRCode(filePath, charset, hintMap);		
					 String[] idSplit = x.split(" ");
					 if(idSplit.length == 2) {
						 visitorID = idSplit[0];	
						 ownerID = idSplit[1];	
						 

					 }else {
						 visitorIDalone = idSplit[0];
					 }
					
					 
						 Class.forName("com.mysql.cj.jdbc.Driver");
						 	Connection con = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/databasethesis1?useTimezone=true&serverTimezone=UTC", "databasethesis1", "databasethesis1");							
							String checkVisitor = "select * from visitor where visitor_ID = '"+visitorIDalone+"'";
							String checkToVisit = "select * from homeowners where homeowner_ID = '"+ownerID+"'";
							String checkOwner = "select * from homeowners where homeowner_ID = '"+visitorIDalone+"'";
							String checkEmp = "select * from employees where emp_ID = '"+visitorIDalone+"'";
							
							Statement fetch = con.createStatement();
							PreparedStatement pst1 = con.prepareStatement(checkVisitor);
							PreparedStatement pst2 = con.prepareStatement(checkToVisit);
							PreparedStatement pst3 = con.prepareStatement(checkEmp);
							PreparedStatement pst4 = con.prepareStatement(checkOwner);
							ResultSet result = fetch.executeQuery(checkToVisit);
							
							
							if(idSplit.length == 2) {
								String checkIn = "update logbook\r\n"
										+ "set date_out = '" +date+ "' , time_out = '" +time+ "' \r\n"
										+ "where visitor_ID = '" +ownerID+ "'";
								VisitorInfo pass = new VisitorInfo();
								
								if(pst2.executeQuery().next()) {
									while(result.next()) {
										String fname = result.getString("first_name");
										String lname = result.getString("last_name");
										
										String ownerName = fname +" "+ lname;

										pass.ID.setText(visitorID);
										pass.visitTo.setText(ownerName);
										
										pass.setVisible(true);
									}
									PreparedStatement pst = con.prepareStatement(checkIn);
									
									pst.executeUpdate();
									
								}else{
									JOptionPane.showMessageDialog(null, "does not exist", "ERROR", JOptionPane.ERROR_MESSAGE);
								}
								
							 }else{
								 if(pst1.executeQuery().next()) {
										VisitorInfo pass = new VisitorInfo();
										pass.ID.setText( visitorIDalone);
										pass.setVisible(true);						
								 }else if (pst4.executeQuery().next()) {
										VisitorInfo pass = new VisitorInfo();
										pass.ID.setText(visitorIDalone);
										pass.setVisible(true);
									}else if(pst3.executeQuery().next()) {
									 	VisitorInfo pass = new VisitorInfo();
									 	pass.ID.setText( visitorIDalone);
										pass.setVisible(true);
								 }else {
									 JOptionPane.showMessageDialog(null, "does not exist", "ERROR", JOptionPane.ERROR_MESSAGE);
								 }
							 }
							
							dispose();
							webcam.close();
							
				 }catch (Exception e1) {
					System.out.println("ERROR: " + e1);
				}
			}
		});
		btnCapture.setBounds(123, 325, 89, 23);
		contentPane.add(btnCapture);
		
		JLabel lblNewLabel = new JLabel("ENTRY");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(131, 11, 81, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnTerminate = new JButton("");
		btnTerminate.setIcon(new ImageIcon(Camera_in.class.getResource("/Images/cancel.png")));
		btnTerminate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				webcam.close();
			}
		});
		btnTerminate.setFont(new Font("Unispace", Font.BOLD, 12));
		btnTerminate.setBounds(288, 7, 45, 38);
		contentPane.add(btnTerminate);
	
	}
}
