package final_;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
public class twillio_try extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					twillio_try frame = new twillio_try();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void example () {
		final String ACCOUNT_SID =("ACb034dbeadee19aa97e6f3ed3c5c27f9e");
	    final String AUTH_TOKEN = ("e9a71f3222ee9ef35ecdaeec0f93f9cc");
	    
	    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("+639916210608"),
                new com.twilio.type.PhoneNumber("+18312154484"),
                "Subdivision Electronic Logging System Using QR Code technology. THESIS")
            .create();

        System.out.println(message.getSid());
	}
	public twillio_try() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		example();
	}

}
