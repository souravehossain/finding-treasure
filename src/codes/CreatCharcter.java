package codes;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.*;
public class CreatCharcter {
	
	private int x , y;
	 
	
	public CreatCharcter(int x , int y){
		this.x = x;
		this.y = y;
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

	public void paintChar(Graphics g){
		
		ImageIcon icon = new ImageIcon("images//char.png");
		Image character = icon.getImage();
		g.drawImage(character, x, y, null);
		
	}
	public void moveUp(){
		if( (y - 1) >= 0 )
			y-=5;

  }
	public void moveDown(){
		if( (y + 1) <= 442)
			y+=5;

    }
 
 	public void moveRigth(){
		if( (x + 1) < 610)
			x+=5;

 	}
 
 	public void moveLeft(){
		if( (x - 1) >= 0 )
			x-=5;

 	}
 
 

}
