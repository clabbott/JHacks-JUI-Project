import javax.swing.JFrame;

public class GameDriver {

	JFrame frame;
	SnakeGame gamePanel;
	Biometrics biometrics;
	
	public GameDriver() {
		frame = new JFrame();
		gamePanel = new SnakeGame();
		biometrics = new Biometrics();
	}
	
	public Biometrics runGame() {
		frame.add(gamePanel);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setTitle("SNEK");
		
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		biometrics = gamePanel.biometrics;
		return biometrics;
	}
	
}
