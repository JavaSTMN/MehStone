package ihm;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainMenu {

	public MainMenu() {
		JPanel panneau = new JPanel();
		panneau.setBorder(new EmptyBorder(10, 10, 10, 10));
		panneau.setLayout(new GridLayout(1, 1));
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Frame menuFrame = new JFrame();
		menuFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		menuFrame.setUndecorated(true); // Permet de set full screen à virer en dev
		
		JPanel content = new JPanel(new GridLayout(3,1, 100, 100));
		content.setBackground(Color.decode("#424242"));
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
			jButton.setBackground(Color.decode("#121212"));
			jButton.setBorder(null);
			jButton.setForeground(Color.decode("#ffffff"));
			
		}
		
		content.add(buttonPlay);
		content.add(buttonDeck);
		content.add(buttonQuit);
		//TODO Background Image
		menuFrame.setVisible(true);
		
		
		buttonQuit.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)
		    {
		    	menuFrame.dispose();
		    }
		});
	}
	
	
	
	

}
