package codes;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Treasure {

	private int x , y;

	public  Treasure(int x , int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	
	public void paintTreasure(Graphics g){
		ImageIcon treasure = new ImageIcon("images//treasure.jpg");
		Image tr = treasure.getImage();
		g.drawImage(tr, x, y, null);
		}
	
	
	
}
