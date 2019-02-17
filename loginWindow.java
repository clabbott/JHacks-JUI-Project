import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class loginWindow {

	private JFrame frame;
	private JTextField txtOne;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginWindow window = new loginWindow();
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
	public loginWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		

		JButton btnSubmitUsername = new JButton("Submit Username and Password");
		
		frame.getContentPane().add(btnSubmitUsername, BorderLayout.SOUTH);
		
		txtOne = new JTextField();
		txtOne.setText("[username here]");
		frame.getContentPane().add(txtOne, BorderLayout.CENTER);
		txtOne.setColumns(10);
		String username = txtOne.getText();
		
		txtPassword = new JTextField();
		txtPassword.setText("[password here]");
		frame.getContentPane().add(txtPassword, BorderLayout.EAST);
		txtPassword.setColumns(10);
		String password = txtPassword.getText();
		
		btnSubmitUsername.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource() == btnSubmitUsername) {
					String username = txtOne.getText();
					String password = txtPassword.getText();
					System.out.println("username is: " + username + " " + "password is: " + password);
					
					User newUser = User(username, password);
					for (User identifier: Driver.getServer()) {
						if (identifier.equals(newUser)) {
							int place = Driver.getServer.indexOf(identifier);
							//if exists, dont boot
							//if not exist, boot 
						}
					}
					//run snake game 
					newUser.setID = snake game results; 
					if newUser.process(Driver.getServer.get(i))
						//log in successfully 
				}
			}
		});
		
		
		
		
	}

}
