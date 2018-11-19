package ihm;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import tool.ImagePaths;

public class MainGame {
	// DIS IS MAIN CLASS GAME	
	private JFrame myFrame;
	ArrayList<JButton> cardsCurrentPlayer = new ArrayList<JButton>();
	ArrayList<JButton> cardsCurrentOpponent = new ArrayList<JButton>();
	private int nbCardsPerPlayer = 5;
	private int _CARD_HEIGHT_FIXED = 240;
	private int _CARD_WIDTH_FIXED = 120;
	private int _GAME_HEIGHT_FIXED = 1080;
	private int _GAME_WIDTH_FIXED = 1920;
	
	
	
	public MainGame(Frame gameFrame)  {
		
		
		this.myFrame = (JFrame) gameFrame;
		this.myFrame.setBackground(Color.cyan);
		
		BufferedImage myImage = null;
		try {
			myImage = ImageIO.read(new File(ImagePaths._BACKGROUND));
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		ImagePanel content = new ImagePanel(myImage);
		
		content.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		JPanel opponentPanel = new JPanel();
		JPanel playerPanel = new JPanel();
		
		setupCards(cardsCurrentPlayer,ImagePaths._HERO_PAPOUNOU, playerPanel);
		setupCards(cardsCurrentOpponent,ImagePaths._HERO_CHAUVINATOR, opponentPanel);
		
 		JPanel gamePanel = new JPanel();
		gamePanel.setBackground(Color.DARK_GRAY);
		gamePanel.setPreferredSize(new Dimension(_GAME_WIDTH_FIXED, 600));
		gamePanel.setMinimumSize(new Dimension(_GAME_WIDTH_FIXED, 600));

	
		gc.gridy = 0;
		content.add(opponentPanel, gc);
		gc.gridy = 1;
		content.add(gamePanel, gc);
		gc.gridy = 2;
		content.add(playerPanel, gc);

		gameFrame.add(content);
		
	}
	
	
	public void setupCards(ArrayList<JButton> cards, String defaultImgPath, JPanel panel) {
		for (int i = 0; i < this.nbCardsPerPlayer; i++) {
			JButton card = new JButton();
			card.setPreferredSize(new Dimension(_CARD_WIDTH_FIXED, _CARD_HEIGHT_FIXED));
			card.setMinimumSize(new Dimension(_CARD_WIDTH_FIXED, _CARD_HEIGHT_FIXED));
			//ImageIcon image = new ImageIcon(defaultImgPath);
			//card.setIcon(image);
			card.setBackground(new Color((int)(Math.random() * 0x1000000)));
			cards.add(card);
			panel.add(card);
		}
		
		panel.setBackground(Color.GRAY);
		panel.setPreferredSize(new Dimension(_GAME_WIDTH_FIXED, 240));
		panel.setMinimumSize(new Dimension(_GAME_WIDTH_FIXED, 240));
		
		

	}
	/**
	 * 
	 * @return
	 */
	public JFrame getMyFrame() {
		return this.myFrame;
	}
	
	

}
