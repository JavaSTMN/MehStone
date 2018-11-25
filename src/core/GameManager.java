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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

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
	ArrayList<Card> cards;
	
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
		cards = new ArrayList<Card>();
	}

	public void startGame(Deck deckJoueur1, Deck deckJoueur2) {
		mainPanel.setVisible(true);
		heroJ1 = deckJoueur1.getHero();
		heroJ2 = deckJoueur2.getHero();
		cards = deckJoueur1.getCards();
		//Collections.shuffle(cards);

		////////////////////////////////////////////////////////////////
		//////////////// ACTIONS TEXT
		////////////////////////////////////////////////////////////////

		actionsText.setLayout(new GridLayout(0,1));
		JTextArea gameText = new JTextArea(5,25);
		gameText.append("Diligas diligas Scipio ipse L ille autem excellas fratrem ad efficere Scipio est atque autem quantum efficere efficere diligas ille sustinere atque possis est autem etiam neque sustinere efficere Quod videndum quamvis potuit tu sustinere videndum enim alterum tribuendum amplissimos Scipio neque ad potuit non fratrem L Rupilium primum efficere ad primum autem honores ad Non quantum Non deinde tu autem quantum honores Scipio adiuves Scipio tamen est consulem ad omnes ipse excellas quantum honores non alterum atque adiuves alterum efficere est honores efficere neque ille P etiam videndum neque possis tamen quantum autem potuit enim ipse etiam consulem ad.");
		gameText.setEditable(false);
		gameText.setFont(new Font("Serif", Font.ITALIC, 16));
		gameText.setLineWrap(true);
		gameText.setWrapStyleWord(true);
		gameText.setOpaque(false);
		gameText.setForeground(Color.WHITE);

		JReferencingButton btnHero = new JReferencingButton();
		btnHero.setFocusPainted(false);
		btnHero.setBorderPainted(false);
		btnHero.setBorder(null);
		btnHero.setMargin(new Insets(0, 0, 0, 0));
		btnHero.setContentAreaFilled(false);
		btnHero.setIcon(new ImageIcon(getScaledImage(heroJ1.getImage(), 180, 255)));
		btnHero.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnHero.setValue(heroJ1);
		heroLife.setLayout(new GridLayout(1,1));

		life = new JLabel("Vie : 30",JLabel.CENTER);
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

		JReferencingButton btnAdversaire1 = getBtnCard(cards.get(0),150,225);
		JReferencingButton btnAdversaire2 = getBtnCard(cards.get(1),150,225);

		JReferencingButton btnMonstres1 = getBtnCard(cards.get(0),150,225);
		JReferencingButton btnMonstres2 = getBtnCard(cards.get(1),150,225);

		JReferencingButton btnHand1 = getBtnCard(cards.get(0),150,225);
		JReferencingButton btnHand2 = getBtnCard(cards.get(1),150,225);


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

		JReferencingButton btnAdversaire3 = getBtnCard(cards.get(0),150,225);
		JReferencingButton btnAdversaire4 = getBtnCard(cards.get(1),150,225);

		JReferencingButton btnMonstres3 = getBtnCard(cards.get(0),150,225);
		JReferencingButton btnMonstres4 = getBtnCard(cards.get(1),150,225);

		JReferencingButton btnHand3 = getBtnCard(cards.get(0),150,225);
		JReferencingButton btnHand4 = getBtnCard(cards.get(1),150,225);


		adversaire2.add(btnAdversaire3);
		adversaire2.add(btnAdversaire4);
		monstres2.add(btnMonstres3);
		monstres2.add(btnMonstres4);
		hand2.add(btnHand3);
		hand2.add(btnHand4);

		game2.add(adversaire2);
		game2.add(monstres2);
		game2.add(hand2);

		////////////////////////////////////////////////////////////////
		// ACTIONS
		////////////////////////////////////////////////////////////////

		actions.setLayout(new GridLayout(0,1));


		JReferencingButton btnHeroAdversaire = new JReferencingButton();
		btnHeroAdversaire.setFocusPainted(false);
		btnHeroAdversaire.setBorderPainted(false);
		btnHeroAdversaire.setBorder(null);
		btnHeroAdversaire.setMargin(new Insets(0, 0, 0, 0));
		btnHeroAdversaire.setContentAreaFilled(false);
		btnHeroAdversaire.setIcon(new ImageIcon(getScaledImage(heroJ2.getImage(), 180, 255)));
		btnHeroAdversaire.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnHeroAdversaire.setValue(heroJ2);

		JReferencingButton btnPioche = new JReferencingButton();
		btnPioche.setFocusPainted(false);
		btnPioche.setBorderPainted(false);
		btnPioche.setBorder(null);
		btnPioche.setMargin(new Insets(0, 0, 0, 0));
		btnPioche.setContentAreaFilled(false);
		Image imgDeck = new ImageIcon(ImagePaths._DECK).getImage();
		btnPioche.setIcon(new ImageIcon(getScaledImage(imgDeck, 180, 255)));
		btnPioche.setCursor(new Cursor(Cursor.HAND_CURSOR));

		heroLifeAdversaire.setLayout(new GridLayout(1,1));
		manaAndDeck.setLayout(new GridLayout(1,1));

		lifeAdversaire = new JLabel("Vie : 30",JLabel.CENTER);
		lifeAdversaire.setFont(new Font("Serif", Font.BOLD, 40));
		lifeAdversaire.setForeground(Color.WHITE);
		heroLifeAdversaire.add(btnHeroAdversaire);
		heroLifeAdversaire.add(lifeAdversaire);
		
		JButton btnFinDeTour = new JButton("Fin de tour");  
		panelFinDeTour.add(btnFinDeTour);
		panelFinDeTour.setBorder(new EmptyBorder(150, 0, 0, 0));

		labelMana = new JLabel("Mana : 1",JLabel.CENTER);
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
	}

	private JReferencingButton getBtnCard(Card myCard, int h, int l) {
		JReferencingButton btn = new JReferencingButton();
		btn.setFocusPainted(false);
		btn.setBorderPainted(false);
		btn.setBorder(null);
		btn.setMargin(new Insets(0, 0, 0, 0));
		btn.setContentAreaFilled(false);
		btn.setIcon(new ImageIcon(getScaledImage(myCard.getImg(), h, l)));
		btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn.setValue(myCard);
		return btn;
	}

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
	
	public void endRound() {
		//TODO
	}



}
