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
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
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
		
		
		ArrayList<JButton> btns = new ArrayList<JButton>();
		for (int i = 0; i < 10; i++) {
			JButton card = new JButton();
			card.setPreferredSize(new Dimension(120, 240));
			card.setMinimumSize(new Dimension(120, 240));
			ImageIcon image = new ImageIcon("D:/PROJECTS/workspace/MehStone/assets/img/papini.png");
			card.setIcon(image);
			card.setBackground(Color.WHITE);
			btns.add(card);
		}
		
		JPanel opponentPanel = new JPanel();
		for (int i = 0; i < 5; i++) {
			opponentPanel.add(btns.get(i));
			
		}
		opponentPanel.setBackground(Color.GRAY);
		opponentPanel.setPreferredSize(new Dimension(1920, 240));
		opponentPanel.setMinimumSize(new Dimension(1920, 240));
		
 		JPanel gamePanel = new JPanel();
		gamePanel.setBackground(Color.DARK_GRAY);
		gamePanel.setPreferredSize(new Dimension(1920, 600));
		gamePanel.setMinimumSize(new Dimension(1920, 600));
		
		JPanel playerPanel = new JPanel();
		
		for (int i = 5; i < 10; i++) {
			playerPanel.add(btns.get(i));
			
		}
		playerPanel.setBackground(Color.GRAY);		
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
