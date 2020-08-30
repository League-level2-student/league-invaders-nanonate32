import java.awt.Dimension;
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
    frame.getContentPane().setPreferredSize(new Dimension(WIDTH, HEIGHT));
     
    frame.pack();

	}
public static void main(String[] args) {
	LeagueInvaders invaders = new LeagueInvaders();
	invaders.setup();
	}

	
	
    
	 void setup() {
		frame.add(game);
    	frame.setVisible(true);
    	frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
    	frame.pack();
    	game.startGame();
}
}
