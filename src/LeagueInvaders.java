import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LeagueInvaders {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	gamePanel game;
	public LeagueInvaders(){
    game = new gamePanel();
final int WIDTH = 500;
final int HEIGHT = 800;
	}
public static void main(String[] args) {
	
	}

	
	

	void setup() {
		frame.add(gamePanel);
    	frame.setVisible(true);
    	frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
    	frame.pack();
}
}
