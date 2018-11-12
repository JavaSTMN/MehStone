package ihm;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainGame {
	// DIS IS MAIN CLASS GAME	
	private JFrame myFrame;
	public MainGame(Frame gameFrame) throws MalformedURLException, IOException {
		
		
		this.myFrame = (JFrame) gameFrame;
		this.myFrame.setBackground(Color.cyan);
		/**  MAIN CONTENT COMPOSé D'UN BACKGROUND + 3 LIGNES */
		BufferedImage myImage = null;
		try {
			myImage = ImageIO.read(new File("20ek.jpg"));
			
		} catch (Exception e) {
			myImage = ImageIO.read(new URL("https://www.zupimages.net/up/18/46/20ek.jpg"));
		}
		ImagePanel content = new ImagePanel(myImage);
		
		
		content.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		
		
		
		// TODO reponsive Width / Height
		JPanel opponentPanel = new JPanel();
		opponentPanel.add(new JButton("1"));
		opponentPanel.add(new JButton("2"));
		opponentPanel.add(new JButton("3"));
		opponentPanel.setBackground(Color.RED);
		opponentPanel.setPreferredSize(new Dimension(1920, 240));
		opponentPanel.setMinimumSize(new Dimension(1920, 240));
		
 		JPanel gamePanel = new JPanel();
		gamePanel.setBackground(Color.MAGENTA);
		gamePanel.setPreferredSize(new Dimension(1920, 600));
		gamePanel.setMinimumSize(new Dimension(1920, 600));
		
		JPanel playerPanel = new JPanel();

		playerPanel.add(new JButton("1"));
		playerPanel.add(new JButton("2"));
		playerPanel.add(new JButton("3"));
		playerPanel.setBackground(Color.RED);		
		playerPanel.setPreferredSize(new Dimension(1920, 240));
		playerPanel.setMinimumSize(new Dimension(1920, 240));
	
		gc.gridy = 0;
		content.add(opponentPanel, gc);
		gc.gridy = 1;
		content.add(gamePanel, gc);
		gc.gridy = 2;
		content.add(playerPanel, gc);

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
