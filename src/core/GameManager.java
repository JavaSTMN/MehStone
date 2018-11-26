package core;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.RenderingHints;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;

import ihm.ImagePanel;
import tool.ImagePaths;
import tool.JReferencingButton;

public class GameManager {

	private Frame myFrame;
	JPanel mainPanel;
	BufferedImage myImage;
	JPanel content;
	JPanel actionsText;
	JPanel heroLife;
	JPanel heroLifeAdversaire;
	JPanel game1;
	JPanel adversaire1;
	JPanel monstres1;
	JPanel hand1;
	JPanel game2;
	JPanel adversaire2;
	JPanel monstres2;
	JPanel hand2;
	JPanel actions;
	JPanel manaAndDeck;
	JPanel panelFinDeTour;
	JLabel life;
	JLabel lifeAdversaire;
	JLabel labelMana;
	Hero heroJ1;
	Hero heroJ2;
	ArrayList<Card> cardsJ1;
	ArrayList<Card> cardsJ2;
	ArrayList<Card> monstresJ1;
	ArrayList<Card> monstresJ2;
	Mana manaJ1;
	Mana manaJ2;
	Hand handJ1;
	Hand handJ2;
	int jSelected;
	ArrayList<JReferencingButton> listBtnHand;
	ArrayList<JReferencingButton> listBtnMonstre;
	ArrayList<JReferencingButton> listBtnAdversaire;
	boolean pioche = true;
	Card cardAttack = null;

	public GameManager(Frame menuFrame) {
		this.myFrame = menuFrame;
	}

	public void chargement() throws IOException {
		mainPanel = new JPanel();
		myImage = ImageIO.read(new File(ImagePaths._BACKGROUND));
		content = new ImagePanel(myImage);
		///
		actionsText = new JPanel();
		heroLife = new JPanel();
		///
		game1 = new JPanel();
		adversaire1 = new JPanel();
		monstres1 = new JPanel();
		hand1 = new JPanel();
		///
		game2 = new JPanel();
		adversaire2 = new JPanel();
		monstres2 = new JPanel();
		hand2 = new JPanel();
		///
		actions = new JPanel();
		heroLifeAdversaire  = new JPanel();
		manaAndDeck  = new JPanel();
		panelFinDeTour = new JPanel();
		///
		content.setVisible(true);
		content.setLayout(new GridLayout(0,4));
		actionsText.setOpaque(false);
		heroLife.setOpaque(false);
		game1.setOpaque(false);
		adversaire1.setOpaque(false);
		monstres1.setOpaque(false);
		hand1.setOpaque(false);
		game2.setOpaque(false);
		adversaire2.setOpaque(false);
		monstres2.setOpaque(false);
		hand2.setOpaque(false);
		actions.setOpaque(false);
		heroLifeAdversaire.setOpaque(false);
		manaAndDeck.setOpaque(false);
		panelFinDeTour.setOpaque(false);
		cardsJ1 = new ArrayList<Card>();
		cardsJ2 = new ArrayList<Card>();
		monstresJ1 = new ArrayList<Card>();
		monstresJ2 = new ArrayList<Card>();
		listBtnHand = new ArrayList<JReferencingButton>();
		listBtnMonstre = new ArrayList<JReferencingButton>();
		listBtnAdversaire = new ArrayList<JReferencingButton>();
		manaJ1 = new Mana(1);
		manaJ2 = new Mana(0);
		handJ1 = new Hand();
		handJ2 = new Hand();
		jSelected = 1;
	}

	public void startGame(Deck deckJoueur1, Deck deckJoueur2) {
		mainPanel.setVisible(true);
		heroJ1 = deckJoueur1.getHero();
		heroJ2 = deckJoueur2.getHero();
		cardsJ1 = deckJoueur1.getCards();
		cardsJ2 = deckJoueur2.getCards();
		Collections.shuffle(cardsJ1);
		handJ1.addCard(cardsJ1.remove(0));
		Collections.shuffle(cardsJ1);
		handJ1.addCard(cardsJ1.remove(0));
		Collections.shuffle(cardsJ2);
		handJ2.addCard(cardsJ2.remove(0));
		Collections.shuffle(cardsJ2);
		handJ2.addCard(cardsJ2.remove(0));

		////////////////////////////////////////////////////////////////
		//////////////// ACTIONS TEXT
		////////////////////////////////////////////////////////////////

		actionsText.setLayout(new GridLayout(0,1));
		JTextArea gameText = new JTextArea(5,25);
		gameText.append("TOUR DU JOUEUR 1\n");
		gameText.setEditable(false);
		gameText.setFont(new Font("Serif", Font.ITALIC, 16));
		gameText.setLineWrap(true);
		gameText.setWrapStyleWord(true);
		gameText.setOpaque(false);
		gameText.setForeground(Color.WHITE);

		JReferencingButton btnHero = getBtn();
		btnHero.setIcon(new ImageIcon(getScaledImage(heroJ1.getImage(), 180, 255)));
		btnHero.setValue(heroJ1);
		heroLife.setLayout(new GridLayout(1,1));

		life = new JLabel("Vie : "+heroJ1.getHp(),JLabel.CENTER);
		life.setFont(new Font("Serif", Font.BOLD, 40));
		life.setForeground(Color.WHITE);
		heroLife.add(life);
		heroLife.add(btnHero);


		actionsText.add(gameText);
		actionsText.add(heroLife);

		////////////////////////////////////////////////////////////////
		// GAME 1
		////////////////////////////////////////////////////////////////

		game1.setLayout(new GridLayout(0,1));
		adversaire1.setLayout(new GridLayout(1,1));
		monstres1.setLayout(new GridLayout(1,1));
		hand1.setLayout(new GridLayout(1,1));

		//JReferencingButton btnAdversaire1 = getBtnCard(cardsJ1.get(0),150,225);
		JReferencingButton btnAdversaire1 = getBtn();
		JReferencingButton btnAdversaire2 = getBtn();

		JReferencingButton btnMonstres1 = getBtn();
		JReferencingButton btnMonstres2 = getBtn();

		JReferencingButton btnHand1 = getBtn();
		JReferencingButton btnHand2 = getBtn();


		adversaire1.add(btnAdversaire1);
		adversaire1.add(btnAdversaire2);
		monstres1.add(btnMonstres1);
		monstres1.add(btnMonstres2);
		hand1.add(btnHand1);
		hand1.add(btnHand2);

		game1.add(adversaire1);
		game1.add(monstres1);
		game1.add(hand1);

		////////////////////////////////////////////////////////////////
		// GAME 2
		////////////////////////////////////////////////////////////////

		game2.setLayout(new GridLayout(0,1));
		adversaire2.setLayout(new GridLayout(1,1));
		monstres2.setLayout(new GridLayout(1,1));
		hand2.setLayout(new GridLayout(1,1));

		JReferencingButton btnAdversaire3 = getBtn();
		JReferencingButton btnAdversaire4 = getBtn();

		JReferencingButton btnMonstres3 = getBtn();
		JReferencingButton btnMonstres4 = getBtn();

		JReferencingButton btnHand3 = getBtn();
		JReferencingButton btnHand4 = getBtn();


		adversaire2.add(btnAdversaire3);
		adversaire2.add(btnAdversaire4);
		monstres2.add(btnMonstres3);
		monstres2.add(btnMonstres4);
		hand2.add(btnHand3);
		hand2.add(btnHand4);

		btnHand1.setIcon(new ImageIcon(getScaledImage(handJ1.getCards().get(0).getImg(), 150, 225)));
		btnHand1.setValue(handJ1.getCards().get(0));
		btnHand2.setIcon(new ImageIcon(getScaledImage(handJ1.getCards().get(1).getImg(), 150, 225)));
		btnHand2.setValue(handJ1.getCards().get(1));


		game2.add(adversaire2);
		game2.add(monstres2);
		game2.add(hand2);

		////////////////////////////////////////////////////////////////
		// ACTIONS
		////////////////////////////////////////////////////////////////

		actions.setLayout(new GridLayout(0,1));


		JReferencingButton btnHeroAdversaire = getBtn();
		btnHeroAdversaire.setIcon(new ImageIcon(getScaledImage(heroJ2.getImage(), 180, 255)));
		btnHeroAdversaire.setValue(heroJ2);

		JReferencingButton btnPioche = getBtn();
		Image imgDeck = new ImageIcon(ImagePaths._DECK).getImage();
		btnPioche.setIcon(new ImageIcon(getScaledImage(imgDeck, 180, 255)));

		heroLifeAdversaire.setLayout(new GridLayout(1,1));
		manaAndDeck.setLayout(new GridLayout(1,1));

		lifeAdversaire = new JLabel("Vie : "+heroJ2.getHp(),JLabel.CENTER);
		lifeAdversaire.setFont(new Font("Serif", Font.BOLD, 40));
		lifeAdversaire.setForeground(Color.WHITE);
		heroLifeAdversaire.add(btnHeroAdversaire);
		heroLifeAdversaire.add(lifeAdversaire);

		JButton btnFinDeTour = new JButton("Fin de tour");  
		panelFinDeTour.add(btnFinDeTour);
		panelFinDeTour.setBorder(new EmptyBorder(150, 0, 0, 0));

		labelMana = new JLabel("Mana : "+manaJ1.getRemainingMana(),JLabel.CENTER);
		labelMana.setFont(new Font("Serif", Font.BOLD, 20));
		labelMana.setForeground(Color.WHITE);
		manaAndDeck.add(labelMana);
		manaAndDeck.add(btnPioche);

		actions.add(heroLifeAdversaire);
		actions.add(panelFinDeTour);
		actions.add(manaAndDeck);

		////////////////////////////////////////////////////////////////

		content.add(actionsText);
		content.add(game1);
		content.add(game2);
		content.add(actions);
		mainPanel.add(content);
		mainPanel.setLayout((LayoutManager) new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		myFrame.add(mainPanel);

		listBtnHand.add(btnHand1);
		listBtnHand.add(btnHand2);
		listBtnHand.add(btnHand3);
		listBtnHand.add(btnHand4);

		listBtnMonstre.add(btnMonstres1);
		listBtnMonstre.add(btnMonstres2);
		listBtnMonstre.add(btnMonstres3);
		listBtnMonstre.add(btnMonstres4);

		listBtnAdversaire.add(btnAdversaire1);
		listBtnAdversaire.add(btnAdversaire2);
		listBtnAdversaire.add(btnAdversaire3);
		listBtnAdversaire.add(btnAdversaire4);




		btnFinDeTour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				// Clean JtextArea =>  si le nombre de ligne trop élévé, clean les premières 
				cleanTextArea(gameText);

				pioche = false;
				if(jSelected == 1) {
					jSelected = 2;
					gameText.append("TOUR DU JOUEUR 2\n");
					for (int i = 0; i < listBtnHand.size(); i++) {
						listBtnHand.get(i).setIcon(null);
						listBtnHand.get(i).setValue(null);
						listBtnMonstre.get(i).setIcon(null);
						listBtnMonstre.get(i).setValue(null);
						listBtnAdversaire.get(i).setIcon(null);
						listBtnAdversaire.get(i).setValue(null);
					}

					for(int i = 0; i < handJ2.getCards().size(); i++) {
						listBtnHand.get(i).setIcon(new ImageIcon(getScaledImage(handJ2.getCards().get(i).getImg(), 150, 225)));
						listBtnHand.get(i).setValue(handJ2.getCards().get(i));
					}
					for(int i = 0; i < monstresJ2.size(); i++) {
						listBtnMonstre.get(i).setIcon(new ImageIcon(getScaledImage(monstresJ2.get(i).getImg(), 150, 225)));
						monstresJ2.get(i).setAttack(true);
						listBtnMonstre.get(i).setValue(monstresJ2.get(i));
					}
					for(int i = 0; i < monstresJ1.size(); i++) {
						listBtnAdversaire.get(i).setIcon(new ImageIcon(getScaledImage(monstresJ1.get(i).getImg(), 150, 225)));
						listBtnAdversaire.get(i).setValue(monstresJ1.get(i));
					}
					btnHero.setIcon(new ImageIcon(getScaledImage(heroJ2.getImage(), 180, 255)));
					life.setText("Vie : "+heroJ2.getHp());
					btnHeroAdversaire.setIcon(new ImageIcon(getScaledImage(heroJ1.getImage(), 180, 255)));
					lifeAdversaire.setText("Vie : "+heroJ1.getHp());
					manaJ2.addManaTurn(1);
					labelMana.setText("Mana : "+manaJ2.getRemainingMana());
					if(cardsJ2.size() == 0) {
						btnPioche.setIcon(null);
					}else {
						btnPioche.setIcon(new ImageIcon(getScaledImage(imgDeck, 180, 255)));
					}
				}else {
					jSelected = 1;
					gameText.append("TOUR DU JOUEUR 1\n");
					for (int i = 0; i < listBtnHand.size(); i++) {
						listBtnHand.get(i).setIcon(null);
						listBtnHand.get(i).setValue(null);
						listBtnMonstre.get(i).setIcon(null);
						listBtnMonstre.get(i).setValue(null);
						listBtnAdversaire.get(i).setIcon(null);
						listBtnAdversaire.get(i).setValue(null);
					}
					for(int i = 0; i < handJ1.getCards().size(); i++) {
						listBtnHand.get(i).setIcon(new ImageIcon(getScaledImage(handJ1.getCards().get(i).getImg(), 150, 225)));
						listBtnHand.get(i).setValue(handJ1.getCards().get(i));
					}
					for(int i = 0; i < monstresJ1.size(); i++) {
						listBtnMonstre.get(i).setIcon(new ImageIcon(getScaledImage(monstresJ1.get(i).getImg(), 150, 225)));
						monstresJ1.get(i).setAttack(true);
						listBtnMonstre.get(i).setValue(monstresJ1.get(i));
						
					}
					for(int i = 0; i < monstresJ2.size(); i++) {
						listBtnAdversaire.get(i).setIcon(new ImageIcon(getScaledImage(monstresJ2.get(i).getImg(), 150, 225)));
						listBtnAdversaire.get(i).setValue(monstresJ2.get(i));
					}
					btnHero.setIcon(new ImageIcon(getScaledImage(heroJ1.getImage(), 180, 255)));
					life.setText("Vie : "+heroJ1.getHp());
					btnHeroAdversaire.setIcon(new ImageIcon(getScaledImage(heroJ2.getImage(), 180, 255)));
					lifeAdversaire.setText("Vie : "+heroJ2.getHp());
					manaJ1.addManaTurn(1);
					labelMana.setText("Mana : "+manaJ1.getRemainingMana());
					if(cardsJ1.size() == 0) {
						btnPioche.setIcon(null);
					}else {
						btnPioche.setIcon(new ImageIcon(getScaledImage(imgDeck, 180, 255)));
					}
				}
			}
		});
		btnPioche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if(!pioche) {
					pioche = true;
					if(jSelected == 1) {
						if(cardsJ1.size()>0) {
							Collections.shuffle(cardsJ1);
							if(handJ1.getCards().size()<4){
								handJ1.addCard(cardsJ1.remove(0));
							}else {
								cardsJ1.remove(0);
								JOptionPane.showMessageDialog(myFrame,
										"Votre main est pleine, votre carte piochée est détruite",
										"Erreur",
										JOptionPane.ERROR_MESSAGE);
							}
							for (JReferencingButton jButton : listBtnHand) {
								jButton.setIcon(null);
								jButton.setValue(null);
							}
							for(int i = 0; i < handJ1.getCards().size(); i++) {
								listBtnHand.get(i).setIcon(new ImageIcon(getScaledImage(handJ1.getCards().get(i).getImg(), 150, 225)));
								listBtnHand.get(i).setValue(handJ1.getCards().get(i));
							}
							if(cardsJ1.size() == 0) {
								btnPioche.setIcon(null);
							}

						}
					}else {
						if(cardsJ2.size()>0) {
							Collections.shuffle(cardsJ2);
							if(handJ2.getCards().size()<4){
								handJ2.addCard(cardsJ2.remove(0));
							}else {
								cardsJ2.remove(0);
								JOptionPane.showMessageDialog(myFrame,
										"Votre main est pleine, votre carte piochée est détruite",
										"Erreur",
										JOptionPane.ERROR_MESSAGE);
							}
							for (JReferencingButton jButton : listBtnHand) {
								jButton.setIcon(null);
								jButton.setValue(null);
							}
							for(int i = 0; i < handJ2.getCards().size(); i++) {
								listBtnHand.get(i).setIcon(new ImageIcon(getScaledImage(handJ2.getCards().get(i).getImg(), 150, 225)));
								listBtnHand.get(i).setValue(handJ2.getCards().get(i));
							}
							if(cardsJ2.size() == 0) {
								btnPioche.setIcon(null);
							}
						}
					}
				}else {
					JOptionPane.showMessageDialog(myFrame,
							"Impossible de piocher deux fois dans le même tour",
							"Erreur",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		for (JReferencingButton jButton : listBtnHand) {
			jButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					cleanTextArea(gameText);
					Card tempCard = (Card)jButton.getValue();
					if(jSelected == 1) {
						if(tempCard.getMana() <= manaJ1.getRemainingMana()) {
							if(tempCard instanceof Monster) {
								if(monstresJ1.size()!=4) {
									manaJ1.useManaTurn(tempCard.getMana());
									labelMana.setText("Mana : "+manaJ1.getRemainingMana());
									jButton.setIcon(null);
									jButton.setValue(null);
									handJ1.removeCard(tempCard);
									monstresJ1.add(tempCard);
									gameText.append("Pose sur le plateau le monstre : "+tempCard.getName()+"\n");
									for(int i = 0; i < monstresJ1.size(); i++) {
										listBtnMonstre.get(i).setIcon(new ImageIcon(getScaledImage(monstresJ1.get(i).getImg(), 150, 225)));
										listBtnMonstre.get(i).setValue(monstresJ1.get(i));
									}
								}else {
									JOptionPane.showMessageDialog(myFrame,
											"Impossible de placer le monstre. Le terrain est plein !",
											"Erreur",
											JOptionPane.ERROR_MESSAGE);
								}
								
							}else {
								manaJ1.useManaTurn(tempCard.getMana());
								labelMana.setText("Mana : "+manaJ1.getRemainingMana());
								jButton.setIcon(null);
								jButton.setValue(null);
								handJ1.removeCard(tempCard);
								if(tempCard.getName() == "katon"  || tempCard.getName() == "raiton") {
									gameText.append("Choisir la cible du sort : "+tempCard.getName()+"\n");
									cardAttack = tempCard;
								}else if(tempCard.getName() == "rasengan") {
									Spell s = (Spell)tempCard;
									gameText.append(tempCard.getName()+" enlève "+s.getDamage()+" point(s) de vie à tous les monstres\n");
									for (JReferencingButton Jbutton : listBtnAdversaire) {
										Monster m = (Monster)Jbutton.getValue();
										s.action(m);
										if(m.isDeath()) {
											Jbutton.setIcon(null);
											jButton.setValue(null);
											monstresJ2.remove(m);
										}
									}
								}
							}
						}else {
							JOptionPane.showMessageDialog(myFrame,
									"Pas assez de mana pour jouer cette carte !",
									"Erreur",
									JOptionPane.ERROR_MESSAGE);
						}
						
					}else if(jSelected == 2) {
						if(tempCard.getMana() <= manaJ2.getRemainingMana()) {
							if(tempCard instanceof Monster) {
								if(monstresJ2.size()!=4) {
									manaJ2.useManaTurn(tempCard.getMana());
									labelMana.setText("Mana : "+manaJ2.getRemainingMana());
									jButton.setIcon(null);
									jButton.setValue(null);
									handJ2.removeCard(tempCard);
									monstresJ2.add(tempCard);
									gameText.append("Pose sur le plateau le monstre : "+tempCard.getName()+"\n");
									for(int i = 0; i < monstresJ2.size(); i++) {
										listBtnMonstre.get(i).setIcon(new ImageIcon(getScaledImage(monstresJ2.get(i).getImg(), 150, 225)));
										listBtnMonstre.get(i).setValue(monstresJ2.get(i));
									}
								}else {
									JOptionPane.showMessageDialog(myFrame,
											"Impossible de placer le monstre. Le terrain est plein !",
											"Erreur",
											JOptionPane.ERROR_MESSAGE);
								}
							}else {
								manaJ2.useManaTurn(tempCard.getMana());
								labelMana.setText("Mana : "+manaJ2.getRemainingMana());
								jButton.setIcon(null);
								jButton.setValue(null);
								handJ2.removeCard(tempCard);
								if(tempCard.getName() == "katon" || tempCard.getName() == "raiton") {
									gameText.append("Choisir la cible du sort : "+tempCard.getName()+"\n");
									cardAttack = tempCard;
								}else if(tempCard.getName() == "rasengan") {
									Spell s = (Spell)tempCard;
									gameText.append(tempCard.getName()+" enlève "+s.getDamage()+" point(s) de vie à tous les monstres\n");
									for (JReferencingButton Jbutton : listBtnAdversaire) {
										Monster m = (Monster)Jbutton.getValue();
										s.action(m);
										if(m.isDeath()) {
											Jbutton.setIcon(null);
											jButton.setValue(null);
											monstresJ1.remove(m);
										}
									}
								}
							}
						}else {
							JOptionPane.showMessageDialog(myFrame,
									"Pas assez de mana pour jouer cette carte !",
									"Erreur",
									JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			});
		}
		for (JReferencingButton jButton : listBtnMonstre) {
			jButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					cleanTextArea(gameText);
					Card tempCard = (Card)jButton.getValue();
					if(tempCard.isAttack()) {
						tempCard.setAttack(false);
						gameText.append("Choisir la cible du monstre : "+tempCard.getName()+"\n");
						cardAttack = tempCard;
					}else {
						JOptionPane.showMessageDialog(myFrame,
								"Le monstre "+tempCard.getName()+" ne peut pas attaquer !",
								"Erreur",
								JOptionPane.ERROR_MESSAGE);
					}
					
				}
			});
		}
		
		for (JReferencingButton jButton : listBtnAdversaire) {
			jButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					cleanTextArea(gameText);
					Monster tempCard = (Monster)jButton.getValue();
					if(cardAttack != null) {
						if(jSelected == 1) {
							if(cardAttack instanceof Monster) {
								Monster m = (Monster)cardAttack;
								gameText.append(cardAttack.getName()+" enlève "+m.getDamage()+" point(s) de vie à "+tempCard.getName()+"\n");
								m.action(tempCard);
								if(tempCard.isDeath()) {
									jButton.setIcon(null);
									jButton.setValue(null);
									monstresJ2.remove(tempCard);
								}
							}else {
								Spell s = (Spell)cardAttack;
								gameText.append(cardAttack.getName()+" enlève "+s.getDamage()+" point(s) de vie à "+tempCard.getName()+"\n");
								s.action(tempCard);
								if(tempCard.isDeath()) {
									jButton.setIcon(null);
									jButton.setValue(null);
									monstresJ2.remove(tempCard);
								}
							}
						}else if(jSelected == 2) {
							if(cardAttack instanceof Monster) {
								Monster m = (Monster)cardAttack;
								gameText.append(cardAttack.getName()+" enlève "+m.getDamage()+" point(s) de vie à "+tempCard.getName()+"\n");
								m.action(tempCard);
								if(tempCard.isDeath()) {
									jButton.setIcon(null);
									jButton.setValue(null);
									monstresJ1.remove(tempCard);
								}
							}else {
								Spell s = (Spell)cardAttack;
								gameText.append(cardAttack.getName()+" enlève "+s.getDamage()+" point(s) de vie à "+tempCard.getName()+"\n");
								s.action(tempCard);
								if(tempCard.isDeath()) {
									jButton.setIcon(null);
									jButton.setValue(null);
									monstresJ1.remove(tempCard);
								}
							}
						}
						cardAttack = null;
						
					}
				}
			});
		}

		btnHeroAdversaire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				cleanTextArea(gameText);
				if(cardAttack != null) {
					if(jSelected == 1) {
						if(cardAttack instanceof Monster) {
							Monster m = (Monster)cardAttack;
							gameText.append(cardAttack.getName()+" enlève "+m.getDamage()+" point(s) de vie à "+heroJ2.getName()+"\n");
							m.action(heroJ2);
							lifeAdversaire.setText("Vie : "+heroJ2.getHp());
							if(heroJ2.isDeath()) {
								JOptionPane.showMessageDialog(myFrame,
										"Le joueur 1 Gagne !",
										"Erreur",
										JOptionPane.ERROR_MESSAGE);
							}
						}else {
							Spell s = (Spell)cardAttack;
							gameText.append(cardAttack.getName()+" enlève "+s.getDamage()+" point(s) de vie à "+heroJ2.getName()+"\n");
							s.action(heroJ2);
							lifeAdversaire.setText("Vie : "+heroJ2.getHp());
							if(heroJ2.isDeath()) {
								JOptionPane.showMessageDialog(myFrame,
										"Le joueur 1 Gagne !",
										"Erreur",
										JOptionPane.ERROR_MESSAGE);
							}
						}
					}else if(jSelected == 2) {
						if(cardAttack instanceof Monster) {
							Monster m = (Monster)cardAttack;
							gameText.append(cardAttack.getName()+" enlève "+m.getDamage()+" point(s) de vie à "+heroJ1.getName()+"\n");
							m.action(heroJ1);
							lifeAdversaire.setText("Vie : "+heroJ1.getHp());
							if(heroJ1.isDeath()) {
								JOptionPane.showMessageDialog(myFrame,
										"Le joueur 2 Gagne !",
										"Erreur",
										JOptionPane.ERROR_MESSAGE);
							}
						}else {
							Spell s = (Spell)cardAttack;
							gameText.append(cardAttack.getName()+" enlève "+s.getDamage()+" point(s) de vie à "+heroJ1.getName()+"\n");
							s.action(heroJ1);
							lifeAdversaire.setText("Vie : "+heroJ1.getHp());
							if(heroJ1.isDeath()) {
								JOptionPane.showMessageDialog(myFrame,
										"Le joueur 2 Gagne !",
										"Erreur",
										JOptionPane.ERROR_MESSAGE);
							}
						}
					}
					cardAttack = null;
				}
			}
		});
	}
	/**
	 * @param ta
	 */
	private void cleanTextArea(JTextArea ta) {
		int end = 0;
		try {
			end = ta.getLineEndOffset(0);
		} catch (BadLocationException e1) {
			e1.printStackTrace();
		}
		if(ta.getLineCount() >= 16) 
			ta.replaceRange("", 0, end );
	}

	private JReferencingButton getBtn() {
		JReferencingButton btn = new JReferencingButton();
		btn.setFocusPainted(false);
		btn.setBorderPainted(false);
		btn.setBorder(null);
		btn.setMargin(new Insets(0, 0, 0, 0));
		btn.setContentAreaFilled(false);
		//btn.setIcon(new ImageIcon(getScaledImage(myCard.getImg(), h, l)));
		btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		//btn.setValue(myCard);
		return btn;
	}

	/**
	 * @param srcImg
	 * @param w
	 * @param h
	 * @return
	 */
	private Image getScaledImage(Image srcImg, int w, int h){
		BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = resizedImg.createGraphics();

		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(srcImg, 0, 0, w, h, null);
		g2.dispose();

		return resizedImg;
	}


	public void endGame() {
		//TODO
	}

	public void endTurn() {
		//TODO
	}



}
