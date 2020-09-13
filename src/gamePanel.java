

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;
public class gamePanel extends JPanel implements ActionListener {
	  public gamePanel() {
		timer = new Timer(1000/60,this);
	  }
	  Timer timer;
		// TODO Auto-generated constructor stub
        public void mainCOmponent(Graphics g) {
        	
        }
	

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	System.out.println("Hello");
}
	void startGame(){
	timer.start();	
		timer.
}
}	


