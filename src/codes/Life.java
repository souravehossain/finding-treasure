package codes;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Life {
	
	private int x , y;
	private boolean isAlive;
	


	
	public Life(int x , int y) {
		this.x = x;
		this.y = y;
		isAlive = true;
	}
	

	public boolean getIsAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void paintLife(Graphics g) {
		
		ImageIcon life = new ImageIcon("images//life.png");
		Image l = life.getImage();
		g.drawImage(l, x, y, null);
		
		
		
	}
	

}
