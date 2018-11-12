package ihm;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainGame {
	// DIS IS MAIN CLASS GAME	
	private JFrame myFrame;
	public MainGame(Frame gameFrame) throws MalformedURLException, IOException {
		this.myFrame = (JFrame) gameFrame;
		this.myFrame.setBackground(Color.cyan);
		/**  MAIN CONTENT COMPOSé D'UN BACKGROUND + 3 LIGNES */
		BufferedImage myImage = ImageIO.read(new URL("https://www.zupimages.net/up/18/46/20ek.jpg"));
		ImagePanel content = new ImagePanel(myImage);
		content.setLayout(new GridLayout(3,1));
		
		
		JPanel opponentPanel = new JPanel();
		opponentPanel.add(new JButton("1"));
		opponentPanel.add(new JButton("2"));
		opponentPanel.add(new JButton("3"));
		opponentPanel.setBackground(Color.MAGENTA);

		JPanel gamePanel = new JPanel();
		gamePanel.add(new JButton("1"));
		gamePanel.add(new JButton("2"));
		gamePanel.add(new JButton("3"));
		gamePanel.setBackground(Color.CYAN);
		gamePanel.setPreferredSize(new Dimension(800, 500));
		JPanel playerPanel = new JPanel();

		
		playerPanel.add(new JButton("1"));
		playerPanel.add(new JButton("2"));
		playerPanel.add(new JButton("3"));
		playerPanel.setBackground(Color.RED);		
		
		// First 3 rows
		content.add(opponentPanel);	

		// First 3 rows
		content.add(gamePanel);
		

		// First 3 rows
		content.add(playerPanel);
		
		gameFrame.add(content);
		
	}
	
	
	/**
	 * 
	 * @return
	 */
	public JFrame getMyFrame() {
		return this.myFrame;
	}

}
