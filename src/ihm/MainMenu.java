package ihm;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
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
	 * @throws IOException 
	 * @throws MalformedURLException 
	 */
	public static void main(String[] args) throws MalformedURLException, IOException {
		BufferedImage myImage = ImageIO.read(new URL("https://www.zupimages.net/up/18/46/20ek.jpg"));
		ImagePanel content = new ImagePanel(myImage);
		Frame menuFrame = new JFrame();
		
		menuFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		menuFrame.setUndecorated(true); // Permet de set full screen à virer en dev

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

class ImagePanel extends JPanel {
    private Image image;
    public ImagePanel(Image image) {
        this.image = image;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}

class RoundedBorder implements Border {

    private int radius;


    RoundedBorder(int radius) {
        this.radius = radius;
    }


    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
    }


    public boolean isBorderOpaque() {
        return true;
    }


    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawRoundRect(x, y, width-1, height-1, radius, radius);
    }
}
