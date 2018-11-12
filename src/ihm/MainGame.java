package ihm;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MainGame {
	// DIS IS MAIN CLASS GAME
	
	/**
	 * TODO neex currentContet 
	 */
	
	private JFrame myFrame;
	public MainGame(Frame gameFrame) {
		this.myFrame = (JFrame) gameFrame;
		this.myFrame.setBackground(Color.cyan);
		this.myFrame.add(new JButton("Leh"));
		JButton buttonPlay = new JButton("JOUER");
		buttonPlay.setPreferredSize(new Dimension(100, 60));
		
		
		
	}
	
	
	public JFrame getMyFrame() {
		return this.myFrame;
	}

}
