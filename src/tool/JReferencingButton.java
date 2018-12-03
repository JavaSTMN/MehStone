package tool;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.font.TextLayout;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.swing.JButton;

import core.Card;
import core.Monster;

public class JReferencingButton<T> extends JButton 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private T value;

	public T getValue() 
	{
		return this.value;
	}

	public void setValue(T value) 
	{
		this.value = value;
	}

	
	
	@Override
	public void paint(Graphics g1) {
		// TODO Auto-generated method stub
		super.paint(g1);
		Graphics2D g = (Graphics2D) g1;
		g.setColor(Color.WHITE);
		Font f = g.getFont();
		f = new Font(f.getName(), Font.PLAIN, 24);
		 Font font = null;
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, new File(ImagePaths._FONT));
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.setFont(font.deriveFont(26f));
		
		if(this.value instanceof ArrayList<?>) {
			int x = 120;
			int y = 210;
			ArrayList<Card> cards = (ArrayList<Card>)this.value;
			String text = String.valueOf((cards.size()));
			g.setColor(Color.black);
			g.drawString(text, x + 1, y - 1);
			g.drawString(text, x + 1, y + 1);
			g.drawString(text, x - 1, y - 1);
			g.drawString(text, x - 1, y + 1);

			g.setColor(Color.white);
			g.drawString(text, 120, 210);
		}
		if (this.value instanceof Card) 
		{
			
			if(this.getIcon() != null) {
				if(this.getIcon().getIconWidth() == 150) {
					int x = 29;
					int y = 48;
					String text = String.valueOf(((Card)this.value).getMana());
					g.setColor(Color.black);
					g.drawString(text, x + 1, y - 1);
					g.drawString(text, x + 1, y + 1);
					g.drawString(text, x - 1, y - 1);
					g.drawString(text, x - 1, y + 1);
					g.setColor(Color.white);
					g.drawString(text, 29, 48);
					if(this.value instanceof Monster)
					{
						x = 135;
						y = 225;
						String textHp = String.valueOf(((Monster)this.value).getHp());
						g.setColor(Color.black);
						g.drawString(textHp, x + 1, y - 1);
						g.drawString(textHp, x + 1, y + 1);
						g.drawString(textHp, x - 1, y - 1);
						g.drawString(textHp, x - 1, y + 1);
						g.setColor(Color.white);
						g.drawString(textHp, 135, 225);
						x = 29;
						y = 224;
						String textDmg = String.valueOf(((Monster)this.value).getDamage());
						g.setColor(Color.black);
						g.drawString(textDmg, x + 1, y - 1);
						g.drawString(textDmg, x + 1, y + 1);
						g.drawString(textDmg, x - 1, y - 1);
						g.drawString(textDmg, x - 1, y + 1);
						g.setColor(Color.white);
						g.drawString(textDmg, 29, 224);
					}
				}else if(this.getIcon().getIconWidth() == 200) {
					int x = 29;
					int y = 34;
					String text = String.valueOf(((Card)this.value).getMana());
					g.setColor(Color.black);
					g.drawString(text, x + 1, y - 1);
					g.drawString(text, x + 1, y + 1);
					g.drawString(text, x - 1, y - 1);
					g.drawString(text, x - 1, y + 1);

					g.setColor(Color.white);
					g.drawString(text, 29, 34);

					if(this.value instanceof Monster)
					{
						x = 172;
						y = 253;
						String textHp = String.valueOf(((Monster)this.value).getHp());
						g.setColor(Color.black);
						g.drawString(textHp, x + 1, y - 1);
						g.drawString(textHp, x + 1, y + 1);
						g.drawString(textHp, x - 1, y - 1);
						g.drawString(textHp, x - 1, y + 1);
						g.setColor(Color.white);
						g.drawString(textHp, 172, 253);
						x = 29;
						y = 253;
						String textDmg = String.valueOf(((Monster)this.value).getDamage());
						g.setColor(Color.black);
						g.drawString(textDmg, x + 1, y - 1);
						g.drawString(textDmg, x + 1, y + 1);
						g.drawString(textDmg, x - 1, y - 1);
						g.drawString(textDmg, x - 1, y + 1);
						g.setColor(Color.white);
						g.drawString(textDmg, 29, 253);
					}
				}
				
				
			}
			
			
		}
	}
}

