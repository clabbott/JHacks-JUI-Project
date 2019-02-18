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

public class LoginWindow {

	private JFrame frame;
	private JTextField txtOne;
	private JTextField txtPassword;
	private Driver driver;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWindow window = new LoginWindow();
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
	public LoginWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		driver = new Driver();
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setVisible(true);


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

					User newUser = new User(username, password);
					if(!driver.getServer().contains(newUser)) {
						Driver drive = new Driver();
					}
					int index=0;
					for(User u:driver.getServer()) {
						if(u.getName().equals(username))
							index = driver.getServer().indexOf(u);
					}
					//					run snake game 
					
					GameDriver hello = new GameDriver();
					Biometrics bio = hello.runGame();
					IDStuff id = new IDStuff(bio);
					newUser.setId(id); //snake game results; 
					if (newUser.process(driver.getServer().get(index)))
						System.out.println("You made it!!!!!");
					//log in successfully 
				}
			}
		});




	}

}