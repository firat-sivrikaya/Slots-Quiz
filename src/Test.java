/*
 * by Huseyin BEYAN
 * vers 1.0   22.04.2015
 * 
 * This class contains a main method to test the appearence of the designed Panels
 */

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;


public class Test {	
	
	private static Statistics stats;
	static File backgroundSound;
	static AudioInputStream createBackgroundSound;
	static Clip startBackgroundSound;

	
	public static Statistics read()
	{
		Statistics stats = new Statistics();
		try{
			// Open file to read from, named SavedObj.sav.
			FileInputStream saveFile = new FileInputStream("saves/stats.sav");

			// Create an ObjectInputStream to get objects from save file.
			ObjectInputStream save = new ObjectInputStream(saveFile);

			// Now we do the restore.
			// readObject() returns a generic Object, we cast those back
			// into their original class type
			stats = (Statistics) save.readObject();

			// Close the file.
			save.close(); // This also closes saveFile.
		}
		catch(Exception exc){
			exc.printStackTrace(); // If there was an error, print the info.
		}		
		
		return stats;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		stats = new Statistics();
		
		
		if( new File( "saves/stats.sav").exists())
			stats = read();
		
		WelcomePanel wel = new WelcomePanel( stats);
		
		PlayPanel play = new PlayPanel( stats);
		
		SlotsPanel slots = new SlotsPanel( stats);
		
		MenuPanel menu = new MenuPanel( stats);
		
		HelpPanel help = new HelpPanel( stats);
		
		StatisticsPanel stat = new StatisticsPanel( stats);
		
		SlotsQuestionPanel panel = new SlotsQuestionPanel("HydroCarbon", play,  new Statistics(), 1 );	
		
		
		MainPanel main = new MainPanel( stats);
		
		JFrame frame = new JFrame( "Slots Quiz");			
		//frame.getContentPane().add( wel);
		//frame.getContentPane().add( play);	
		//frame.getContentPane().add( slots);	
		//frame.getContentPane().add( menu);	
		//frame.getContentPane().add( help);
		//frame.getContentPane().add( stat);
		frame.getContentPane().add( main);
		//frame.getContentPane().add( panel);
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
		frame.setVisible( true);		
		frame.setBounds(250,110,800,600);
		frame.setResizable( false);

		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				try {					
					stats.save();
					stopBackgroundMusic();
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					
					e1.printStackTrace();
				}				
			}
		});
		
		startBackgroundMusic();
	}
	
	public static boolean startBackgroundMusic() {

		// Old background music: sounds/bg2_converted.wav
		backgroundSound = new File("sounds/bg2_converted.wav");
		createBackgroundSound = null;
		startBackgroundSound = null;

		try {
			createBackgroundSound = AudioSystem
					.getAudioInputStream(backgroundSound);
			
			try {
				startBackgroundSound = AudioSystem.getClip();

			} catch (LineUnavailableException e) {

				e.printStackTrace();
			}
		} catch (UnsupportedAudioFileException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		try {
			startBackgroundSound.open(createBackgroundSound);
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FloatControl gainControl = 
			    (FloatControl) startBackgroundSound.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(-15.0f);
			startBackgroundSound.loop(999999999);
		return true;
	}

	public static void stopBackgroundMusic() {
		if (startBackgroundSound != null && startBackgroundSound.isRunning())
			startBackgroundSound.stop();
	}


}
