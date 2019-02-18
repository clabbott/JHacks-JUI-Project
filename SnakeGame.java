import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class SnakeGame extends JPanel implements Runnable, KeyListener {

	private static final long serialVersionUID = 1L;

	public static final int WIDTH = 500, HEIGHT = 500;

	private Thread thread;

	protected boolean running;
	private boolean success = false;

	private boolean right = true, left = false, up = false, down = false;

	private BodyPart b;
	private ArrayList<BodyPart> snake;

	private Apple apple;
	private ArrayList<Apple> apples;

	private ArrayList<Integer> keyPresses;
	private long timePressed;
	private long timeReleased;
	private ArrayList<Long> timePressedLeft;
	private ArrayList<Long> timePressedRight;
	private ArrayList<Long> timePressedUp;
	private ArrayList<Long> timePressedDown;
	private long startTime;
	private long endTime;

	private int xCoor = 10, yCoor = 10, size = 15;
	private int ticks = 0;

	Biometrics biometrics;

	public SnakeGame() {
		setFocusable(true);

		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		addKeyListener(this);

		snake = new ArrayList<BodyPart>();
		apples = new ArrayList<Apple>();

		keyPresses = new ArrayList<Integer>();
		timePressedLeft = new ArrayList<Long>();
		timePressedRight = new ArrayList<Long>();
		timePressedUp = new ArrayList<Long>();
		timePressedDown = new ArrayList<Long>();

		start();
	}

	public void start() {
		running = true;
		thread = new Thread(this);
		thread.start();
		startTime = System.nanoTime();
	}
	
	public Biometrics stop() {
		endTime = System.nanoTime();
		biometrics = new Biometrics(keyPresses, timePressedLeft, timePressedRight, timePressedUp, timePressedDown, startTime, endTime, success);
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return biometrics;
	}
	
	public void tick() {
		if(snake.size() == 0) {
			b = new BodyPart(xCoor, yCoor, 10);
			snake.add(b);
		}
		ticks++;
		if(ticks > 250000) {
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(right) {
				xCoor++;
			}
			if(left) {
				xCoor--;
			}
			if(up) {
				yCoor--;
			}
			if(down) {
				yCoor++;
			}
			ticks = 0;
			b = new BodyPart(xCoor, yCoor, 10);
			snake.add(b);

			if(snake.size() > size) {
				snake.remove(0);
			}
		}
		if(apples.size() == 0) {
			int xCoor = 30;
			int yCoor = 30;

			apple = new Apple(xCoor, yCoor, 10);
			apples.add(apple);
		}

		for(int i = 0; i < apples.size(); i++) {
			if(xCoor == apples.get(i).getxCoor() && yCoor == apples.get(i).getyCoor()) {
				size++;
				apples.remove(i);
				success = true;
				System.out.println("You got the apple!");
				stop();
			}
		}

		//collision with snake body part
		for(int i = 0; i < snake.size(); i++) {
			if(xCoor == snake.get(i).getxCoor() && yCoor == snake.get(i).getyCoor()) {
				if(i != snake.size() - 1) {
					System.out.println("Game Over");
					success = false;
					stop();
				}
			}
		}

		//collision with border
		if(xCoor < 0 || xCoor > 49 || yCoor < 0 || yCoor > 49) {
			System.out.println("Game Over");
			success = false;
			stop();
		}

	}

	//getter method
	public Biometrics getBiometrics() {
		return biometrics;
	}

	public void paint(Graphics g) {
		g.clearRect(0, 0, WIDTH, HEIGHT);

		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);

		for(int i = 0; i < WIDTH/10; i++) {
			g.drawLine(i*10, 0, i*10, HEIGHT);
		}
		for(int i = 0; i < HEIGHT/10; i++) {
			g.drawLine(0, i*10, HEIGHT, i*10);
		}
		for(int i = 0; i < snake.size(); i++) {
			snake.get(i).draw(g);
		}
		for(int i = 0; i < apples.size(); i++) {
			apples.get(i).draw(g);
		}
	}

	@Override
	public void run() {
		while(running) {
			tick();
			repaint();
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		keyPresses.add(key);
		timePressed = System.nanoTime();
		if(key == KeyEvent.VK_RIGHT && !left) {
			right = true;
			up = false;
			down = false;
		}
		if(key == KeyEvent.VK_LEFT && !right) {
			left = true;
			up = false;
			down = false;
		}
		if(key == KeyEvent.VK_UP && !down) {
			up = true;
			left = false;
			right = false;
		}
		if(key == KeyEvent.VK_DOWN && !up) {
			down = true;
			left = false;
			right = false;
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		int key = arg0.getKeyCode();
		if(key == KeyEvent.VK_RIGHT && !left) {
			timeReleased = System.nanoTime();
			timePressedRight.add(timeReleased - timePressed);
		}
		if(key == KeyEvent.VK_LEFT && !right) {
			timeReleased = System.nanoTime();
			timePressedLeft.add(timeReleased - timePressed);
		}
		if(key == KeyEvent.VK_UP && !down) {
			timeReleased = System.nanoTime();
			timePressedUp.add(timeReleased - timePressed);
		}
		if(key == KeyEvent.VK_DOWN && !up) {
			timeReleased = System.nanoTime();
			timePressedDown.add(timeReleased - timePressed);
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
}