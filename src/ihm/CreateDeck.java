package ihm;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import tool.ImagePaths;
import tool.JReferencingButton;
import core.Card;
import core.Deck;
import core.Hero;
import core.Monster;
import core.Spell;

public class CreateDeck {

	private Frame myFrame;
	int cpt = 0;
	private Deck deckJoueur1;
	private Deck deckJoueur2;
	private int jSelected = 0;
	BufferedImage myImage;
	ArrayList<Card> listCard;
	ArrayList<JReferencingButton> buttonsListCard;
	ArrayList<JReferencingButton> buttonsListCardDeck;
	ArrayList<Hero> listHero;
	JPanel mainPanel;


	public CreateDeck(Frame menuFrame) {
		this.myFrame = menuFrame;
	}
	
	public Deck getDeckJ1() {
		return deckJoueur1;
	}
	
	public Deck getDeckJ2() {
		return deckJoueur2;
	}
	

	public void chargement() throws IOException {
		mainPanel = new JPanel();
		myImage = ImageIO.read(new File(ImagePaths._BACKGROUND));
		/////////////// Création IHM sélection des cartes du deck ///////////////
		// Création des cartes
		listCard = new ArrayList<Card>();
		buttonsListCard = new ArrayList<JReferencingButton>();
		buttonsListCardDeck = new ArrayList<JReferencingButton>();

		Image sbire_3k = new ImageIcon(ImagePaths._SBIRE_3K).getImage();
		Image sbire_furry = new ImageIcon(ImagePaths._SBIRE_FURRY).getImage();
		Image sbire_garou = new ImageIcon(ImagePaths._SBIRE_GAROU).getImage();
		Image sbire_ivan = new ImageIcon(ImagePaths._SBIRE_IVAN).getImage();
		Image sbire_lapeyrle = new ImageIcon(ImagePaths._SBIRE_LAPEYRLE).getImage();
		Image sbire_mamie = new ImageIcon(ImagePaths._SBIRE_MAMIE).getImage();
		Image spell_katon = new ImageIcon(ImagePaths._SPELL_KATON).getImage();
		Image spell_raiton = new ImageIcon(ImagePaths._SPELL_RAITON).getImage();
		Image spell_rasengan = new ImageIcon(ImagePaths._SPELL_RASENGAN).getImage();



		listCard.add(new Monster("3k",1, sbire_3k,"Détruit 2 sbires aléatoire",2,1));
		listCard.add(new Monster("furry",3, sbire_furry,"Invoque un sbire à ses côtés",3,3));
		listCard.add(new Monster("garou",2, sbire_garou,"Motive ses alliés en leurs donnant +1 de vie",2,3));
		listCard.add(new Monster("ivan",3, sbire_ivan,"Donne +2/+2 à une perlouse sur le terrain",3,2));
		listCard.add(new Monster("lapeyrle",1, sbire_lapeyrle,"Fait perdre 1 d'attaque à ses alliés",1,1));
		listCard.add(new Monster("mamie",2, sbire_mamie,"Donne +1/-1 à un bodybuilder sur le terrain",3,1));
		listCard.add(new Spell("katon",3, spell_katon,"Inflige 3 point(s) de dégats", 2));
		listCard.add(new Spell("raiton",5, spell_raiton,"Inflige 6 point(s) de dégats", 6));
		listCard.add(new Spell("rasengan",4, spell_rasengan,"Inflige 2 points de dégats à tous les serviteurs adverses",  2));


		// Chargement des images des héros

		ImageIcon imageIcon = new ImageIcon(ImagePaths._HERO_PAPOUNOU); 
		ImageIcon imageIcon2 = new ImageIcon(ImagePaths._HERO_CHAUVINATOR); 
		ImageIcon imageIcon3 = new ImageIcon(ImagePaths._HERO_LSD); 
		ImageIcon imageIcon4 = new ImageIcon(ImagePaths._HERO_GLORIA); 

		Image imgPapounou = imageIcon.getImage();
		Image imgChauvinator = imageIcon2.getImage();
		Image imgLsd = imageIcon3.getImage();
		Image imgGloria = imageIcon4.getImage();
		listHero = new ArrayList<Hero>();
		listHero.add(new Hero("Papounou", imgPapounou));
		listHero.add(new Hero("Chauvinator", imgChauvinator));
		listHero.add(new Hero("Lsd", imgLsd));
		listHero.add(new Hero("Gloria", imgGloria));

	}
	
	public void visible(ImagePanel panel) {
		panel.setVisible(false);
		mainPanel.setVisible(true);
	}


	public void main(ImagePanel panel) throws MalformedURLException, IOException {
		panel.setVisible(false);
		
		mainPanel.setVisible(true);
		JPanel content = new ImagePanel(myImage);
		content.setVisible(true);
		JPanel content2 = new ImagePanel(myImage);
		JButton buttonJ1 = new JButton("JOUEUR 1");
		JButton buttonJ2 = new JButton("JOUEUR 2") ;



		JPanel test = new JPanel(new GridLayout(1,5, 10, 10));
		test.setOpaque(false);
		content.setLayout(new GridLayout(5,1, 100, 100));

		content2.setVisible(false);


		///////////////////////
		JPanel panelGestionDeck = new ImagePanel(myImage);
		JPanel panelGestionCards = new JPanel();
		JPanel panelGestionCardsInDeck = new JPanel();
		panelGestionCards.setLayout(new GridLayout(0,3));
		panelGestionCardsInDeck.setLayout(new GridLayout(0,1));
		panelGestionCards.setVisible(true);
		panelGestionCardsInDeck.setVisible(true);
		panelGestionCards.setOpaque(false);
		panelGestionCardsInDeck.setOpaque(false);
		panelGestionDeck.setVisible(false);
		panelGestionDeck.setLayout(new GridLayout(1,2));
		panelGestionDeck.setBorder(new EmptyBorder(50, 50, 50, 50));
		panelGestionCardsInDeck.setBorder(new EmptyBorder(0, 30, 0, 30));

		// gestion panel selection cards

		for (Card myCard : listCard) {
			JReferencingButton temp = new JReferencingButton();
			temp.setFocusPainted(false);
			temp.setBorderPainted(false);
			temp.setBorder(null);
			temp.setMargin(new Insets(0, 0, 0, 0));
			temp.setContentAreaFilled(false);
			temp.setIcon(new ImageIcon(getScaledImage(myCard.getImg(), 200, 275)));
			temp.setCursor(new Cursor(Cursor.HAND_CURSOR));
			temp.setValue(myCard);
			buttonsListCard.add(temp);
			panelGestionCards.add(temp);

			JReferencingButton temp2 = new JReferencingButton();
			temp2.setCursor(new Cursor(Cursor.HAND_CURSOR));
			temp2.setBounds(100, 100, 30, 25);
			temp2.setBorder(new RoundedBorder(5));
			temp2.setVisible(false);
			buttonsListCardDeck.add(temp2);
			panelGestionCardsInDeck.add(temp2);
		}
		for (JReferencingButton jButton : buttonsListCard) {
			jButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					Card tempCard = (Card)jButton.getValue();

					for (JReferencingButton jButton : buttonsListCardDeck) {
						if(jButton.getValue() == null) {
							jButton.setVisible(true);
							jButton.setValue(tempCard);
							jButton.setText(tempCard.getMana()+" - "+tempCard.getName());
							break; 
						}
					}

					if(jSelected == 1) {
						if(deckJoueur1.getNbCards()< 9) {
							deckJoueur1.addCardToDeck(tempCard);
							if(deckJoueur1.getNbCards() == 9) {
								Object[] options = {"Oui",
								"Non"};
								int n = JOptionPane.showOptionDialog(myFrame,
										"Valider le deck ?",
										"Validation",
										JOptionPane.YES_NO_OPTION,
										JOptionPane.QUESTION_MESSAGE,
										null,     //do not use a custom Icon
										options,  //the titles of buttons
										options[0]);
								if(n == 0) {
									content.setVisible(true);
									panelGestionDeck.setVisible(false);
									jSelected = 0;
									for (int i = 0; i < buttonsListCardDeck.size(); i++) {
										JReferencingButton jButton = buttonsListCardDeck.get(i);
										jButton.setVisible(false);
										jButton.setValue(null);
										jButton.setText("");
									}
									buttonJ1.setText("JOUEUR 1 - Deck crée !");
									for( ActionListener al : buttonJ1.getActionListeners() ) {
										buttonJ1.removeActionListener( al );
								    }
									buttonJ1.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e)
										{
											JOptionPane.showMessageDialog(myFrame,
													"DECK JOUEUR 1\n"
													+ "Hero : "+deckJoueur1.getHero().getName()
													+"\nListe cartes :\n"
													+ deckJoueur1.getCardsToString());
										}
									});
								}
							}
						}else {
							JOptionPane.showMessageDialog(myFrame,
									"Impossible d'ajouter une carte, le deck est plein",
									"Erreur",
									JOptionPane.ERROR_MESSAGE);
						}
					}else if(jSelected == 2) {
						if(deckJoueur2.getNbCards()< 9) {
							deckJoueur2.addCardToDeck(tempCard);
							if(deckJoueur2.getNbCards() == 9) {
								Object[] options = {"Oui",
								"Non"};
								int n = JOptionPane.showOptionDialog(myFrame,
										"Valider le deck ?",
										"Validation",
										JOptionPane.YES_NO_OPTION,
										JOptionPane.QUESTION_MESSAGE,
										null,     //do not use a custom Icon
										options,  //the titles of buttons
										options[0]);
								if(n == 0) {
									content.setVisible(true);
									panelGestionDeck.setVisible(false);
									jSelected = 0;
									for (int i = 0; i < buttonsListCardDeck.size(); i++) {
										JReferencingButton jButton = buttonsListCardDeck.get(i);
										jButton.setVisible(false);
										jButton.setValue(null);
										jButton.setText("");
									}
									buttonJ2.setText("JOUEUR 2 - Deck crée !");
									for( ActionListener al : buttonJ2.getActionListeners() ) {
										buttonJ2.removeActionListener( al );
								    }
									buttonJ2.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e)
										{
											JOptionPane.showMessageDialog(myFrame,
													"DECK JOUEUR 2\n"
													+ "Hero : "+deckJoueur2.getHero().getName()
													+"\nListe cartes :\n"
													+ deckJoueur2.getCardsToString());
										}
									});
								}
							}
						}else {
							JOptionPane.showMessageDialog(myFrame,
									"Impossible d'ajouter une carte, le deck est plein",
									"Erreur",
									JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			});
		}
		for (JReferencingButton jButton : buttonsListCardDeck) {
			jButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					Card tempCard = (Card)jButton.getValue();
					if(jSelected == 1) {
						deckJoueur1.removeCardFromDeck(tempCard);
					}else if(jSelected == 2) {
						deckJoueur1.removeCardFromDeck(tempCard);
					}
					jButton.setVisible(false);
					jButton.setValue(null);
					jButton.setText("");
					for (int i = 0; i < buttonsListCardDeck.size()-1; i++) {
						JReferencingButton jButton = buttonsListCardDeck.get(i);
						JReferencingButton jButtonSuivant = buttonsListCardDeck.get(i+1);
						if(jButton.getValue() == null && jButtonSuivant.getValue() != null) {
							jButton.setValue(jButtonSuivant.getValue());
							jButton.setText(jButtonSuivant.getText());
							jButton.setVisible(true);
							jButtonSuivant.setVisible(false);
							jButtonSuivant.setValue(null);
							jButtonSuivant.setText("");
						}
					}

				}
			});
		}
		JScrollPane scroller = new JScrollPane(panelGestionCards);
		scroller.setOpaque(false);
		scroller.getViewport().setOpaque(false);
		scroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroller.getVerticalScrollBar().setUnitIncrement(20);
		scroller.setViewportBorder(null);
		scroller.setBorder(null);
		scroller.getViewport().setBorder(null);
		panelGestionDeck.add(scroller);
		panelGestionDeck.add(panelGestionCardsInDeck);



		//content.setBorder(new EmptyBorder(160, 500, 160, 500));

		content.setVisible(true);
		ArrayList<JButton> buttons = new ArrayList<JButton>();

		JButton buttonRetour = new JButton("RETOUR");
		buttonRetour.setPreferredSize(new Dimension(30, 10));

		
		buttonJ1.setPreferredSize(new Dimension(100, 60));

		
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



		JButton heroBtn = new JButton("");  
		JButton SuivantBtn = new JButton("Suivant");  
		JButton RetourBtn = new JButton("Précédent");  
		heroBtn.setBorderPainted(false);
		heroBtn.setBorder(null);
		heroBtn.setMargin(new Insets(0, 0, 0, 0));
		heroBtn.setContentAreaFilled(false);

		heroBtn.setIcon(new ImageIcon(getScaledImage(listHero.get(0).getImage(), 430, 569)));
		heroBtn.setFocusPainted(false);
		heroBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		heroBtn.setPreferredSize(new Dimension(430, 569));
		content2.add(RetourBtn);
		content2.add(heroBtn);
		content2.add(SuivantBtn);
		mainPanel.add(content);
		mainPanel.add(content2);
		mainPanel.add(panelGestionDeck);
		mainPanel.setLayout((LayoutManager) new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

		//heroSelectFrame.add(heroSelect);
		
		buttonRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				mainPanel.setVisible(false);
				panel.setVisible(true);
			}
		});
		
		buttonJ1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				content.setVisible(false);
				content2.setVisible(true);
				deckJoueur1 = new Deck();
				jSelected = 1;
			}
		});

		buttonJ2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				content.setVisible(false);
				content2.setVisible(true);
				deckJoueur2 = new Deck();
				jSelected = 2;
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

		heroBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if(jSelected == 1) {
					// Choix du joueur 1
					deckJoueur1.setHero(listHero.get(cpt));
					content2.setVisible(false);
					panelGestionDeck.setVisible(true);
				}else if(jSelected == 2) {
					// Choix du joueur 2
					deckJoueur2.setHero(listHero.get(cpt));
					content2.setVisible(false);
					panelGestionDeck.setVisible(true);
				}
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




