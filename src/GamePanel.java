
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;
	boolean shotFired = false;
	ObjectManager manager;
	RocketShip rocket;
	
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	Font titleFont;
	Font menuFont;
	int currentState = MENU;
	Timer alienSpawn;
	Timer shotCooldown;

	public GamePanel() {
		if (needImage) {
			loadImage("space.png");
		
			
			
		}
			
		rocket = new RocketShip(250, 700, 50, 50);
		manager = new ObjectManager(rocket);
		titleFont = new Font("Arial", Font.PLAIN, 48);
		menuFont = new Font("Arial", Font.PLAIN, 24);
		frameDraw = new Timer(1000 / 60, this);
		frameDraw.start();
	}

	Timer frameDraw;

	// TODO Auto-generated constructor stub
	void loadImage(String imageFile) {
		if (needImage) {
			try {
				image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
				gotImage = true;
			} catch (Exception e) {

			}
			needImage = false;
		}
	}

	public void paintComponent(Graphics g) {
		if (currentState == MENU) {
			drawMenuState(g);
		} else if (currentState == GAME) {
			drawGameState(g);
		} else if (currentState == END) {
			drawEndState(g);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Autotim-generated method stub
        if(e.getSource() == shotCooldown) {
        	shotFired = false;
        	shotCooldown.stop();
        }
		if (currentState == MENU) {
			updateMenuState();
		} else if (currentState == GAME) {
			updateGameState();
		} else if (currentState == END) {
			updateEndState();
		}
		// System.out.println("action");
		repaint();
	}

	void startGame() {
		alienSpawn = new Timer(1000, manager);
		alienSpawn.start();

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			
			if (currentState == END) {
				currentState = MENU;
				alienSpawn.stop();
				

			} else if (currentState == MENU) {
				startGame();
				currentState = GAME;
			} else {
				currentState++;

			}
		}
		if (currentState == GAME) {

			if (e.getKeyCode() == KeyEvent.VK_UP) {
				if (rocket.y > 0) {
					rocket.up();
				}

			}
			if (e.getKeyCode() == KeyEvent.VK_SPACE && shotFired == false) {
				manager.addProjectile(rocket.getProjectile());
				shotFired = true;
				shotCooldown = new Timer(1000/3,this);
				shotCooldown.start();
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				System.out.println("DOWN");
				if (rocket.y < (LeagueInvaders.HEIGHT - rocket.height))
					rocket.down();
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				System.out.println("RIGHT");
				if (rocket.x < (LeagueInvaders.WIDTH - rocket.width))
					rocket.right();
			}
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				System.out.println("LEFT");
				if (rocket.x > 0)
					rocket.left();
			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	void updateMenuState() {
	}

	void updateGameState() {
		manager.update();
		if (rocket.isActive == false) {
			currentState = END;
		}
	}

	void updateEndState() {
	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("LEAGUE INVADERS", 40, 50);
		g.setFont(menuFont);
		g.drawString("Press ENTER to start", 125, 300);
		g.drawString("Press SPACE for instructions", 80, 500);

	}

	void drawGameState(Graphics g) {
		g.drawImage(image, 0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT, null);
		manager.draw(g);
		g.drawString("score:" + manager.getScore() , 100, 100);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);

	}
}
