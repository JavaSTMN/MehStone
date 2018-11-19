package ihm;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import tool.ImagePaths;
import core.Hero;

public class CreateDeck {
	
	private Frame myFrame;
	int cpt = 0;
	public CreateDeck(Frame menuFrame) {
		this.myFrame = menuFrame;
	}
	
	public void main() throws MalformedURLException, IOException {
		BufferedImage myImage = ImageIO.read(new File(ImagePaths._BACKGROUND));
		JPanel mainPanel = new JPanel();
		JPanel content = new ImagePanel(myImage);
		JPanel content2 = new ImagePanel(myImage);

		JPanel test = new JPanel(new GridLayout(1,5, 10, 10));
		test.setOpaque(false);
		content.setLayout(new GridLayout(5,1, 100, 100));

		content2.setVisible(false);

		//content.setBorder(new EmptyBorder(160, 500, 160, 500));
		
		content.setVisible(true);
		ArrayList<JButton> buttons = new ArrayList<JButton>();
		
		JButton buttonRetour = new JButton("RETOUR");
		buttonRetour.setPreferredSize(new Dimension(30, 10));
		
		JButton buttonJ1 = new JButton("JOUEUR 1");
		buttonJ1.setPreferredSize(new Dimension(100, 60));

		JButton buttonJ2 = new JButton("JOUEUR 2") ;
		buttonJ2.setPreferredSize(new Dimension(100, 60));
		JButton poubelle = new JButton("");
		poubelle.setVisible(false);
		JButton poubelle2 = new JButton("");
		poubelle2.setVisible(false);
		buttons.add(buttonJ1);
		buttons.add(buttonJ2);
		buttons.add(buttonRetour);
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
		test.add(buttonRetour);
		test.add(poubelle);
		test.add(poubelle2);
		content.add(test);
		content.add(buttonJ1);
		content.add(buttonJ2);
		
		this.myFrame.add(mainPanel);
		// SELECTION DU HERO 
		
		// Chargement des images des héros
		
		ImageIcon imageIcon = new ImageIcon(ImagePaths._HERO_PAPOUNOU); 
		ImageIcon imageIcon2 = new ImageIcon(ImagePaths._HERO_CHAUVINATOR); 

		Image imgPapounou = imageIcon.getImage();
		Image imgChauvinator = imageIcon2.getImage();
		ArrayList<Hero> listHero = new ArrayList<Hero>();
		listHero.add(new Hero("Papounou", imgPapounou));
		listHero.add(new Hero("Chauvinator", imgChauvinator));

		// 
		JButton heroBtn = new JButton("");  
		JButton SuivantBtn = new JButton("Suivant");  
		JButton RetourBtn = new JButton("Précédent");  
		heroBtn.setBorderPainted(false);
		heroBtn.setBorder(null);
		heroBtn.setMargin(new Insets(0, 0, 0, 0));
		heroBtn.setContentAreaFilled(false);
		
		heroBtn.setIcon(new ImageIcon(getScaledImage(imgPapounou, 430, 569)));
		heroBtn.setFocusPainted(false);
		heroBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		heroBtn.setPreferredSize(new Dimension(430, 569));
		content2.add(RetourBtn);
		content2.add(heroBtn);
		content2.add(SuivantBtn);
		mainPanel.add(content);
		mainPanel.add(content2);
	    mainPanel.setLayout((LayoutManager) new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

		//heroSelectFrame.add(heroSelect);
		buttonJ1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)
		    {
		    	content.setVisible(false);
		    	content2.setVisible(true);
		    }
		});
		SuivantBtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)
		    {
		    	cpt++;
		    	cpt = (cpt == listHero.size())?0:cpt;
				heroBtn.setIcon(new ImageIcon(getScaledImage(listHero.get(cpt).getImage(), 430, 569)));
		    }
		});
		RetourBtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)
		    {
		    	cpt--;
		    	cpt = (cpt < 0)?listHero.size()-1:cpt;
				heroBtn.setIcon(new ImageIcon(getScaledImage(listHero.get(cpt).getImage(), 430, 569)));
		    }
		});
		
	}
	
	private Image getScaledImage(Image srcImg, int w, int h){
	    BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2 = resizedImg.createGraphics();

	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.drawImage(srcImg, 0, 0, w, h, null);
	    g2.dispose();

	    return resizedImg;
	}
}


