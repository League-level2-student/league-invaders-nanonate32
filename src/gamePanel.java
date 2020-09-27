

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;
public class gamePanel extends JPanel implements ActionListener, KeyListener{
	final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
    Font titleFont;
    int currentState = MENU;
	  public gamePanel() {
		  titleFont = new Font("Arial", Font.PLAIN, 48);
		timer = new Timer(1000/60,this);
		
	  }
	  Timer timer;
		// TODO Auto-generated constructor stub
        public void paintComponent(Graphics g) {
        	if(currentState == MENU){
        	    drawMenuState(g);
        	}else if(currentState == GAME){
        	    drawGameState(g);
        	}else if(currentState == END){
        	    drawEndState(g);
        	}

        }
	

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Autotim-generated method stub
	System.out.println("Hello");
}
	void startGame(){
		
	timer.start();	
	
}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	void updateMenuState() {  }
	 void updateGameState() {  }
	 void updateEndState()  {  }
	 void drawMenuState(Graphics g) { 
		 g.setColor(Color.BLUE);
		 g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		 g.setFont(titleFont);
		 g.setColor(Color.YELLOW);
		 g.drawString("text", x, y);
	 }
	 void drawGameState(Graphics g) {
		 g.setColor(Color.BLACK);
		 g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
	 }
	 void drawEndState(Graphics g)  { 
		 g.setColor(Color.RED);
		 g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
	 }
}	


