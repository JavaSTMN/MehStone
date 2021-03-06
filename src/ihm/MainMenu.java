package ihm;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import core.Deck;
import core.GameManager;
import tool.ImagePaths;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

public class MainMenu {
	
	static boolean deck = false;
	public MainMenu() {
		JPanel panneau = new JPanel();
		panneau.setBorder(new EmptyBorder(10, 10, 10, 10));
		panneau.setLayout(new GridLayout(1, 1));
	}

	public static void main(String[] args) throws MalformedURLException, IOException {
		
		BufferedImage myImage = ImageIO.read(new File(ImagePaths._BACKGROUND));
		ImagePanel content = new ImagePanel(myImage);
		content.setMain(true);
		
		
		Frame menuFrame = new JFrame();
		Frame gameFrame = new JFrame();
		CreateDeck c = new CreateDeck(menuFrame);
		GameManager gameManager = new GameManager(menuFrame);
		gameManager.chargement();
		c.chargement();
		gameFrame.setUndecorated(true); // Permet de set full screen � virer en dev
		gameFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		MainGame mg = new MainGame(gameFrame);
		Frame testFrame = mg.getMyFrame();
		testFrame.setUndecorated(true); // Permet de set full screen � virer en dev
		testFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);		

		menuFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		menuFrame.setUndecorated(true); // Permet de set full screen � virer en dev

		content.setLayout(new GridLayout(3,1, 100, 100));
		content.setBorder(new EmptyBorder(160, 500, 160, 500));
		menuFrame.add(content);
		JButton buttonPlay = new JButton("JOUER");
		buttonPlay.setPreferredSize(new Dimension(100, 60));

		JButton buttonDeck = new JButton("DECK");
		buttonDeck.setPreferredSize(new Dimension(100, 60));

		JButton buttonQuit = new JButton("QUITTER");
		buttonQuit.setPreferredSize(new Dimension(100, 60));
		
		ArrayList<JButton> buttons = new ArrayList<JButton>();
		
		buttons.add(buttonDeck);
		buttons.add(buttonPlay);
		buttons.add(buttonQuit);
		
		for (JButton jButton : buttons) {
			jButton.setBounds(100, 200, 30, 25);
			jButton.setBorder(new RoundedBorder(5));
			jButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			jButton.setBackground(Color.decode("#121212"));
			jButton.setForeground(Color.decode("#ffffff"));
			jButton.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseEntered(java.awt.event.MouseEvent evt) {
			    	jButton.setBackground(Color.PINK);
			    	jButton.setForeground(Color.decode("#444444"));
			    }
			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	jButton.setBackground(Color.decode("#121212"));
			    	jButton.setForeground(Color.decode("#ffffff"));
			    }
			});
		}

		content.add(buttonPlay);
		content.add(buttonDeck);
		content.add(buttonQuit);
		menuFrame.setVisible(true);
				
		buttonQuit.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)
		    {
		    	menuFrame.dispose();
		    }
		});

		
		buttonPlay.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)
		    {
		    	
		    	if(c.getDeckJ1() == null || c.getDeckJ2() == null) {
		    		JOptionPane.showMessageDialog(menuFrame,
							"Impossible de jouer sans avoir cr�� le deck du joueur 1 et du joueur 2 !",
							"Erreur",
							JOptionPane.ERROR_MESSAGE);
		    	}else {
		    		content.setVisible(false);
		    		gameManager.startGame(c.getDeckJ1(),c.getDeckJ2());
		    	}
		    	
		    	//content.setVisible(false);
		    	//gameManager.startGame(new Deck(1),new Deck(2));
		    }
		});
		
		buttonDeck.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)
		    {
		    	if(!deck) {
		    		try {
						c.main(content);
						deck = true;
					} catch (IOException e1) {
						e1.printStackTrace();
					}
		    	}else {
		    		c.visible(content);
		    	}
		    }
		});
	}
	
	
	
	

}


