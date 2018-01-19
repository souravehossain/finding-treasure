package codes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class DashBoard extends JPanel implements KeyListener {
	
	int x = 35 , y = 0;
	int score = 100;
	int lives = 5;
	
	CreatCharcter cc;
	Sound sound;
	Brick[] bricks = new Brick[113];
	Treasure treasure;
	Life life;
	
	public DashBoard(){
		
		life = new Life(510, 60);
		cc = new CreatCharcter(0, 0);
		treasure = new Treasure(150,210);
		sound = new Sound();
		super.addKeyListener(this);
		
		
	}
	
	
	public  void paint(Graphics g) {
		
		
		g.setColor(Color.YELLOW);
		ImageIcon icon = new ImageIcon("images//background.jpg");
		Image background = icon.getImage();
		g.drawImage(background, 0, 0, null);
		treasure.paintTreasure(g);
		cc.paintChar(g);
		if (life.getIsAlive() ) {
			life.paintLife(g);
		}
		
		placeBricks(g);
		
		
		g.drawString("lives :" + lives , 400, 20);
     	g.drawString("Score : " + score, 460,20);
		
	}
	
	public void placeBricks(Graphics g){
		
		try{
			
			Scanner scan = new Scanner(new File("brickCoordinates.txt"));
			int i = 0;
			while(scan.hasNextLine() == true){
				
				int x = Integer.parseInt(scan.next());
				int y = Integer.parseInt(scan.next());
				
				bricks[i] = new Brick(x,y,"images//brick.png"); 
				bricks[i].draw(g);
				i++;
			}
			
			scan.close();

		}
		
		catch(Exception e){}
		
		
	}
	
	public boolean checkBrickCollision(){
		
		Rectangle charRect = new Rectangle(cc.getX(), cc.getY(), 24, 24);
			int i = 0;
			
		for (i = 0; i < bricks.length; i++) {
			
			Rectangle bricRect = new Rectangle(bricks[i].getX(), bricks[i].getY(), 24,28);
			
			if (charRect.intersects(bricRect) == true) {
				
				sound.smashBricksSound();
				return true;
			}
		}
	
		return false;
			
	}
		
	public void lifeCollision(){
		Rectangle lifeRect = new Rectangle(life.getX(), life.getY(), 24, 24);
		Rectangle charRect = new Rectangle(cc.getX(), cc.getY(), 24, 24);
		
		
		if (charRect.intersects(lifeRect) == true && life.getIsAlive() == true) {
			lives++;
			life.setAlive(false);
		}
		
	}
	
	
	public boolean checkWin(){
		
		Rectangle trRect = new Rectangle(treasure.getX(), treasure.getY(), 32, 32);
		Rectangle chaRect 	= new Rectangle(cc.getX(), cc.getY(), 24, 24);
		
		if(chaRect.intersects(trRect) == true)	{
			
			sound.gameWonSound();
			JOptionPane.showMessageDialog(null, "This is the end of your journey.You have found treasure!!!\nyour Score : " + score);
			System.exit(0);
			
			
			return true;
		}
		
		return false;
	}

		

		
	@Override
	public void keyPressed(KeyEvent e) {
		
			checkWin();
			lifeCollision();
		if (e.getKeyCode() == e.VK_UP) {
			cc.moveUp();
			
			if (checkBrickCollision()) {
				
				score -= 10;
			    lives--;
				
				cc.moveDown();
				cc.moveDown();
			}
		}
		if (e.getKeyCode() == e.VK_DOWN) {
			cc.moveDown();
			
			if (checkBrickCollision()) {
				
				score -= 10;
			    lives--;
				
				cc.moveUp();
				cc.moveUp();
			}
		
		}
		if (e.getKeyCode() == e.VK_RIGHT) {
			cc.moveRigth();
			if (checkBrickCollision()) {
				score -= 10;
			    lives--;
				cc.moveLeft();
				cc.moveLeft();
			}
			
		}
		if (e.getKeyCode() == e.VK_LEFT) {
			cc.moveLeft();
			if (checkBrickCollision()) {
				score -= 10;
			    lives--;
				cc.moveRigth();
				cc.moveRigth();
			}
		}
		super.repaint();
		
		if(lives == 0){
			sound.gameOverSound();
			JOptionPane.showMessageDialog(null, "Game over!!!");
			System.exit(0);
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

}
