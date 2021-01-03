import java.awt.Dimension;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LeagueInvaders {
	public final static int HEIGHT = 800;
	public final static int WIDTH = 500;
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	GamePanel game;
	public LeagueInvaders(){
    game = new GamePanel();
 
    frame.addKeyListener(game);
    frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
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
    	
    	
}
}
