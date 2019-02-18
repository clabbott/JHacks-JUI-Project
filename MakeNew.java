import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JTextField;

public class MakeNew {

	private JFrame frame;
	private JTextField txtinsertPasswordHere;
	private JTextField txtusernameHere;
	private Driver driver;
	private long avgTimeLeft;
	private long avgTimeRight;
	private long avgTimeUp;
	private long avgTimeDown;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MakeNew window = new MakeNew();
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
	public MakeNew() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		driver = new Driver();
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		JButton btnSubmitNewUsername = new JButton("Submit New Username and Password and perform biometrics");
		frame.getContentPane().add(btnSubmitNewUsername, BorderLayout.SOUTH);

		txtinsertPasswordHere = new JTextField();
		txtinsertPasswordHere.setText("[Password Here]");
		frame.getContentPane().add(txtinsertPasswordHere, BorderLayout.WEST);
		txtinsertPasswordHere.setColumns(10);

		txtusernameHere = new JTextField();
		txtusernameHere.setText("[Username here]");
		frame.getContentPane().add(txtusernameHere, BorderLayout.EAST);
		txtusernameHere.setColumns(10);

		btnSubmitNewUsername.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource() == btnSubmitNewUsername) {
					String username = txtusernameHere.getText();
					String password = txtinsertPasswordHere.getText();
					System.out.println("username is: " + username + " " + "password is: " + password);

					User newUser = new User(username, password);

					//					run snake game 
					for(int i = 0; i < 10; i++) {
						GameDriver main = new GameDriver();
						Biometrics bio = main.runGame();
						IDStuff id = new IDStuff(bio);
						newUser.setId(id); //snake game results;
						avgTimeLeft += bio.getTimeLeft();
						avgTimeRight += bio.getTimeRight();
						avgTimeUp += bio.getTimeUp();
						avgTimeDown += bio.getTimeDown();
					}
					avgTimeLeft = avgTimeLeft/10;
					avgTimeRight = avgTimeRight/10;
					avgTimeUp = avgTimeUp/10;
					avgTimeDown = avgTimeDown/10;
					
					IDStuff finalID = new IDStuff(avgTimeRight, avgTimeLeft, avgTimeUp, avgTimeDown);

					newUser.setId(finalID);
					System.out.println("Id entered successfully");
					Driver drive = new Driver();
				}
			}
		});
	}

}
