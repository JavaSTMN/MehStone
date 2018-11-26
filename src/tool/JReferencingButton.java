package tool;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

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
			f = new Font(f.getName(), f.getStyle(), 26);
			g.setFont(f);
			g.drawString((String.valueOf(((Card)this.value).getMana())), 61, 90);
			if(this.value instanceof Monster)
			{
				g.drawString((String.valueOf(((Monster)this.value).getHp())), 61, 270);
				g.drawString((String.valueOf(((Monster)this.value).getDamage())), 170, 270);
			}
		}
	}
}

