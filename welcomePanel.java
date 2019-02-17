import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class welcomePanel {

	private JFrame frame;
	private JTextField txtPleaseEnterUsername;
	private JTextField txtusernameHere;
	private JTextField txtpasswordHere;
	private JTextField txtWelcome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					welcomePanel window = new welcomePanel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public welcomePanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		txtPleaseEnterUsername = new JTextField();
		txtPleaseEnterUsername.setHorizontalAlignment(SwingConstants.CENTER);
		txtPleaseEnterUsername.setText("Please Enter Username and Password");
		frame.getContentPane().add(txtPleaseEnterUsername, BorderLayout.NORTH);
		txtPleaseEnterUsername.setColumns(10);
		
		txtusernameHere = new JTextField();
		txtusernameHere.setText("[Username here]");
		txtusernameHere.setHorizontalAlignment(SwingConstants.RIGHT);
		frame.getContentPane().add(txtusernameHere, BorderLayout.WEST);
		txtusernameHere.setColumns(10);
		
		txtpasswordHere = new JTextField();
		txtpasswordHere.setText("[Password here]");
		txtpasswordHere.setHorizontalAlignment(SwingConstants.LEFT);
		frame.getContentPane().add(txtpasswordHere, BorderLayout.EAST);
		txtpasswordHere.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		frame.getContentPane().add(btnNewButton, BorderLayout.SOUTH);
		
		txtWelcome = new JTextField();
		txtWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		txtWelcome.setText("Welcome!");
		frame.getContentPane().add(txtWelcome, BorderLayout.CENTER);
		txtWelcome.setColumns(10);
	}

}
