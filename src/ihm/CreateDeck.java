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
	private String _buttonBackColor = "#121212";
	private String _buttonFrontColor = "#ffffff";

	private String _buttonFrontHover = this._buttonBackColor;
	private String _buttonBackHover = "#FFC0CB";


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
		/////////////// Cr�ation IHM s�lection des cartes du deck ///////////////
		// Cr�ation des cartes
		listCard = new ArrayList<Card>();
		buttonsListCard = new ArrayList<JReferencingButton>();
		buttonsListCardDeck = new ArrayList<JReferencingButton>();
		loadCards();
		loadHeroes();
	}
	private void loadHeroes() {
		// TODO Auto-generated method stub
		this.listHero = new ArrayList<Hero>();
		// Chargement des images des h�ros

		Image imgPapounou = new ImageIcon(ImagePaths._HERO_PAPOUNOU).getImage();
		Image imgChauvinator = new ImageIcon(ImagePaths._HERO_CHAUVINATOR).getImage();
		Image imgLsd = new ImageIcon(ImagePaths._HERO_LSD).getImage();
		Image imgGloria = new ImageIcon(ImagePaths._HERO_GLORIA).getImage();
		Image imgDoge = new ImageIcon(ImagePaths._HERO_DOGE).getImage();
		Image imgBouchara = new ImageIcon(ImagePaths._HERO_BOUCHARA).getImage();
		Image imgMartin = new ImageIcon(ImagePaths._HERO_MARTIN).getImage();
		Image imgMuri = new ImageIcon(ImagePaths._HERO_MURI).getImage();
		listHero.add(new Hero("Papounou", imgPapounou));
		listHero.add(new Hero("Henriques", imgChauvinator));
		listHero.add(new Hero("Lsd", imgLsd));
		listHero.add(new Hero("Gloria", imgGloria));
		listHero.add(new Hero("Bouchara", imgBouchara));
		listHero.add(new Hero("Martin", imgMartin));
		listHero.add(new Hero("Murisasco", imgMuri));
		listHero.add(new Hero("Doge", imgDoge));
	}


	/**
	 * Load Monsters & Spells
	 */
	private void loadCards() {
		// TODO Auto-generated method stub

		Image sbire_3k = new ImageIcon(ImagePaths._SBIRE_3K).getImage();
		Image sbire_furry = new ImageIcon(ImagePaths._SBIRE_FURRY).getImage();
		Image sbire_garou = new ImageIcon(ImagePaths._SBIRE_GAROU).getImage();
		Image sbire_ivan = new ImageIcon(ImagePaths._SBIRE_IVAN).getImage();
		Image sbire_lapeyrle = new ImageIcon(ImagePaths._SBIRE_LAPEYRLE).getImage();
		Image sbire_mamie = new ImageIcon(ImagePaths._SBIRE_MAMIE).getImage();
		Image sbire_slime = new ImageIcon(ImagePaths._SLIME_3).getImage();
		Image sbire_kevin = new ImageIcon(ImagePaths._SBIRE_KEVIN).getImage();
		Image sbire_nick = new ImageIcon(ImagePaths._SBIRE_NICK).getImage();
		Image sbire_tortank = new ImageIcon(ImagePaths._SBIRE_TORTANK).getImage();
		Image sbire_meh = new ImageIcon(ImagePaths._SBIRE_MEH).getImage();
		Image sbire_kingsman = new ImageIcon(ImagePaths._SBIRE_KINGSMAN).getImage();
		Image sbire_lithium = new ImageIcon(ImagePaths._SBIRE_LITHIUM).getImage();
		Image sbire_alazar = new ImageIcon(ImagePaths._SBIRE_ALAZAR).getImage();
		Image spell_katon = new ImageIcon(ImagePaths._SPELL_KATON).getImage();
		Image spell_raiton = new ImageIcon(ImagePaths._SPELL_RAITON).getImage();
		Image spell_rasengan = new ImageIcon(ImagePaths._SPELL_RASENGAN).getImage();
		
		Monster tortank = new Monster("tortank",4, sbire_tortank,"Absorbe 1 PV � chaque carte ennemi",1,4);
		Monster kevin = new Monster("enigma",4, sbire_kevin,"Au debut de votre tour d�truit une carte al�atoirement sur le terrain",1,4);
		Monster nick = new Monster("nick",4, sbire_nick,"What does the fox say",5,2);
		Monster meh = new Monster("meh",4, sbire_meh,"meh",2,5);
		Monster threeK = new Monster("3k",1, sbire_3k,"D�truit 2 sbires al�atoire",2,1);
		Monster furry = new Monster("furry",3, sbire_furry,"Invoque un sbire � ses c�t�s",3,3);
		Monster garou = new Monster("garou",2, sbire_garou,"Motive ses alli�s en leurs donnant +1 de vie",2,3);
		Monster ivan = new Monster("ivan",3, sbire_ivan,"Donne +2/+2 � une perlouse sur le terrain",3,2);
		Monster lapeyrle = new Monster("lapeyrle",1, sbire_lapeyrle,"Fait perdre 1 d'attaque � ses alli�s",1,1);
		Monster mamie = new Monster("mamie",2, sbire_mamie,"Donne +1/-1 � un bodybuilder sur le terrain",3,1);
		Monster slime = new Monster("slime",1, sbire_slime,"Aucun effet",2,2);
		Monster kingsman = new Monster("kingsman",3, sbire_kingsman,"Attend sans jamais d�sesp�rer",3,2);
		Monster lithium = new Monster("lithium",4, sbire_lithium,"Invoque un sbire � ses c�t�s",2,4);
		Monster alazar = new Monster("alazar",3, sbire_alazar,"Provoque un effet al�atoire",2,2);
		Spell katon = new Spell("katon",2, spell_katon,"Inflige 2 point(s) de d�gats", 2);
		Spell raiton = new Spell("raiton",5, spell_raiton,"Inflige 6 point(s) de d�gats", 6);
		Spell rasegan = new Spell("rasengan",6, spell_rasengan,"Inflige 4 points de d�gats � tous les serviteurs adverses",  4);

		listCard.add(tortank);
		listCard.add(kevin);
		listCard.add(nick);
		listCard.add(meh);
		listCard.add(threeK);
		listCard.add(furry);
		listCard.add(garou);
		listCard.add(ivan);
		listCard.add(lapeyrle);
		listCard.add(mamie);
		listCard.add(slime);
		listCard.add(kingsman);
		listCard.add(lithium);
		listCard.add(alazar);
		listCard.add(katon);
		listCard.add(raiton);
		listCard.add(rasegan);	
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
			JReferencingButton<Card> temp = new JReferencingButton();
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


		}
		for (int i=0; i<20;i++) {
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
					Card card = (Card)jButton.getValue();
					Card tempCard = null;
					if(card instanceof Monster) {
						tempCard = new Monster(card.getName(),card.getMana(), card.getImg(),card.getEffect(),((Monster) card).getDamage(),((Monster) card).getHp());
					}else {
						tempCard = new Spell(card.getName(),card.getMana(), card.getImg(),card.getEffect(),((Spell) card).getDamage());
					}

					if(jSelected == 1) {
						if(deckJoueur1.getNbCards()< 20) {
							if(deckJoueur1.canAddCardToDeck(tempCard)) {
								deckJoueur1.addCardToDeck(tempCard);
								for (JReferencingButton jButton : buttonsListCardDeck) {
									if(jButton.getValue() == null) {
										jButton.setVisible(true);
										jButton.setValue(tempCard);
										jButton.setText(tempCard.getMana()+" - "+tempCard.getName());
										break; 
									}
								}
								if(deckJoueur1.getNbCards() == 20) {
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
										buttonJ1.setText("JOUEUR 1 - Deck cr�e !");
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
										"Impossible d'ajouter 3 fois la m�me carte � un deck",
										"Erreur",
										JOptionPane.ERROR_MESSAGE);
							}

						}else {
							JOptionPane.showMessageDialog(myFrame,
									"Impossible d'ajouter une carte, le deck est plein",
									"Erreur",
									JOptionPane.ERROR_MESSAGE);
						}
					}else if(jSelected == 2) {
						if(deckJoueur2.getNbCards()< 20) {
							if(deckJoueur2.canAddCardToDeck(tempCard)) {
								deckJoueur2.addCardToDeck(tempCard);
								for (JReferencingButton jButton : buttonsListCardDeck) {
									if(jButton.getValue() == null) {
										jButton.setVisible(true);
										jButton.setValue(tempCard);
										jButton.setText(tempCard.getMana()+" - "+tempCard.getName());
										break; 
									}
								}
								if(deckJoueur2.getNbCards() == 20) {
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
										buttonJ2.setText("JOUEUR 2 - Deck cr�e !");
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
										"Impossible d'ajouter 3 fois la m�me carte � un deck",
										"Erreur",
										JOptionPane.ERROR_MESSAGE);
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
			jButton.setBackground(Color.decode(_buttonBackColor));
			jButton.setForeground(Color.decode(_buttonFrontColor));
			jButton.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseEntered(java.awt.event.MouseEvent evt) {
					jButton.setBackground(Color.decode(_buttonBackHover));
					jButton.setForeground(Color.decode(_buttonFrontHover));
				}
				public void mouseExited(java.awt.event.MouseEvent evt) {
					jButton.setBackground(Color.decode(_buttonBackColor));
					jButton.setForeground(Color.decode(_buttonFrontColor));
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
		JButton RetourBtn = new JButton("Pr�c�dent");  
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
					deckJoueur1.setHero(new Hero(listHero.get(cpt)));
					content2.setVisible(false);
					panelGestionDeck.setVisible(true);
				}else if(jSelected == 2) {
					// Choix du joueur 2
					deckJoueur2.setHero(new Hero(listHero.get(cpt)));
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




