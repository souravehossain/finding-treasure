package codes;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SetupDashBoard  extends JFrame   {
	
	DashBoard dBoard;

	public void showBoard(){
		BorderLayout bl = new BorderLayout();
		super.setLayout(bl);
		
		dBoard = new DashBoard();
		
		super.add(dBoard);
		super.setSize(645,500);
		super.setLocation(400, 50);
		super.setResizable(false);
		dBoard.setFocusable(true);
		super.setVisible(true);
		super.setTitle("Finding treasure");
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		while(dBoard.checkWin() == false){
			
			
		}
		


	}
	
	
	
}
