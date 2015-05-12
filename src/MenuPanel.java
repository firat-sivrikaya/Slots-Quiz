/* * 
by H�seyin BEYAN
 * vers 1.0   28.04.2015
 * 
 * Panel to show menu page of our project
 */

import java.awt.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public class MenuPanel extends JPanel {
	
	//sound variables
	private static File backgroundSound;
	private static AudioInputStream createBackgroundSound;
	private static Clip startBackgroundSound;
	

	private CurrencyPanelBig cur;
	private Image background;
	private String next;
	private Statistics stats;
	
	public MenuPanel( Statistics stats) 
	{
		this.stats = stats;
		setVisible( true);				
		setBounds( 0,0, 800, 600);		
		setLayout(null);		
		
		next = "";
		
		ProjectButton contLabel = new ProjectButton("CONTINUE");
		contLabel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible( false);
				next = "cont";
			}
		});
		contLabel.setBounds(245, 303, 300, 50);
		add(contLabel);
		
		ProjectButton button = new ProjectButton("BACK TO MAIN MENU");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if(event.getSource()==button)
				{
					// Stop all musics
					MenuPanel.stopBackgroundMusic();
					PlayPanel.stopBackgroundMusic();
					SlotsQuestionPanel.stopBackgroundMusic();
					
					Test.stopBackgroundMusic();
					// If user haven't muted, start background music again
					if ( !OptionsPanel.mute )
						Test.startBackgroundMusic();
					
				}
				
				setVisible( false);
				next = "wel";
			}
		});
		button.setBounds(245, 363, 300, 50);
		add(button);
		
		ProjectButton helpButton = new ProjectButton("HELP");
		helpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible( false);
				next = "help";
			}
		});
		helpButton.setBounds(245, 423, 300, 50);
		add(helpButton);
		
		ProjectButton exitButton = new ProjectButton("EXIT");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				try {
					stats.save();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.exit( 0);
			}
		});
		exitButton.setBounds(245, 483, 300, 50);
		add(exitButton);
		
		cur = new CurrencyPanelBig( stats);
		cur.setBounds( 300, 180, 200, 100);
		add( cur);
		
		JLabel titleLabel = new JLabel("");
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		titleLabel.setBounds(290, 60, 220, 100);
		titleLabel.setIcon( new ImageIcon( "images/menu.png"));
		add(titleLabel);
		
	}
	
	public void paintComponent( Graphics g)
	{
		super.paintComponent( g);		

		background = new ImageIcon( "images/background.png" ).getImage();
		
		g.drawImage( background, 0, 0, null);		
	}
	
	public String getNext()
	{
		return next;
	}
	
	public void update( Statistics stats)
	{
		cur.update( stats);
	}
	public static void startBackgroundMusic(){
			
			backgroundSound = new File("sounds/questionMusic.wav");
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
				gainControl.setValue(-20.0f);
			startBackgroundSound.loop(10);	
		}
		public static void stopBackgroundMusic() {
			if (startBackgroundSound != null && startBackgroundSound.isRunning())
				startBackgroundSound.stop();
		}
}
