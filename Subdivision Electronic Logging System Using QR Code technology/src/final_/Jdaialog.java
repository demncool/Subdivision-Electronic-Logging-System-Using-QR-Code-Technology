package final_;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Jdaialog {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		JOptionPane jop = new JOptionPane();
//		jop.setMessageType(JOptionPane.DEFAULT_OPTION);
//		
//		jop.setMessage("Generating QR CODE......");
//		JDialog dialog = jop.createDialog("" );
//
//		// Set a 2 second timer
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				try {
//					Thread.sleep(2000);
//				} catch (Exception e) {
//				}
//				dialog.dispose();
//				
//			}
//
//		}).start();
//		
//
//		dialog.setVisible(true);
		
		
		JFrame f= new JFrame();  
        JDialog d = new JDialog(f , "Dialog Example", true);  
        d.add(new JLabel("Generating QR CODE...."));
        d.setSize(200,80);
       
        
     // Set a 2 second timer
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
