package tool;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

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
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		
		if (this.value instanceof Card) 
		{
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
			if(this.getIcon() != null) {
				if(this.getIcon().getIconWidth() == 150) {
					g.drawString((String.valueOf(((Card)this.value).getMana())), 29, 48);
					if(this.value instanceof Monster)
					{
						g.drawString((String.valueOf(((Monster)this.value).getHp())), 135, 225);
						g.drawString((String.valueOf(((Monster)this.value).getDamage())), 29, 224);
					}
				}else if(this.getIcon().getIconWidth() == 200) {
					g.drawString((String.valueOf(((Card)this.value).getMana())), 29, 34);
					if(this.value instanceof Monster)
					{
						g.drawString((String.valueOf(((Monster)this.value).getHp())), 172, 253);
						g.drawString((String.valueOf(((Monster)this.value).getDamage())), 29, 253);
					}
				}
			}
			
			
		}
	}
}

