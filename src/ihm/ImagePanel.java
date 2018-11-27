package ihm;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.swing.JPanel;

import tool.ImagePaths;

public class ImagePanel extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image image;
	private boolean main;
    public boolean isMain() {
		return main;
	}

	public void setMain(boolean main) {
		this.main = main;
	}

	public ImagePanel(Image image) {
        this.image = image;
        this.main = false;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
        if(isMain()) {
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
            int x = 1200;
            int y = 750;
            String text = "Version 1.00";
    		g.setColor(Color.black);
    		g.drawString(text, x + 1, y - 1);
    		g.drawString(text, x + 1, y + 1);
    		g.drawString(text, x - 1, y - 1);
    		g.drawString(text, x - 1, y + 1);
    		g.setColor(Color.white);
    		g.drawString(text, x, y);
        }
        
    }
}
