package codes;
import javax.sound.sampled.*;

import java.io.*;

public class Sound {
	public static void smashBricksSound(){
		
		try{
			
			File sound = new File("sounds//smash.wav");
			AudioInputStream ais =AudioSystem.getAudioInputStream(sound);
			Clip clip = AudioSystem.getClip();
			clip.open(ais);
			clip.start();
		}
		catch(Exception e){
			
			
		}
	}
	
	public static void gameWonSound(){
		
		try{
			
			File sound = new File("sounds//Tone.wav");
			AudioInputStream ais =AudioSystem.getAudioInputStream(sound);
			Clip clip = AudioSystem.getClip();
			clip.open(ais);
			clip.start();
		}
		catch(Exception e){}
		
	}

	public static void gameOverSound(){
		
		try{
			
			File sound = new File("sounds//gameOver.wav");
			AudioInputStream ais =AudioSystem.getAudioInputStream(sound);
			Clip clip = AudioSystem.getClip();
			clip.open(ais);
			clip.start();
		}
		catch(Exception e){}
		
	}

	public static void step(){
		
		try{
			
			File sound = new File("sounds//step.wav");
			AudioInputStream ais =AudioSystem.getAudioInputStream(sound);
			Clip clip = AudioSystem.getClip();
			clip.open(ais);
			clip.start();
		}
		catch(Exception e){}
		
	}
	
	
	
}
