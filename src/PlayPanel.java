/*
 * by H�seyin BEYAN
 * vers 1.0   22.04.2015
 * 
 * Panel to show play page of our project
 */  

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;


public class PlayPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	
	//image variable
	private Image background;
	
	//sound variable
	private File buttonSound3;		
	private AudioInputStream createButtonSound3;		
	private Clip startButtonSound3;
	
	private CurrencyPanel curpanel;
	private String next;
	private Statistics stats;
	
	public PlayPanel( Statistics stats) {
		setVisible( false);
		setLayout(null);
		setBounds( 0,0, 800, 600);
		setFocusable(true);
		requestFocusInWindow();
		
		next = "";
		this.stats = stats;
		
		JLabel titleLabel = new JLabel("");
		titleLabel.setIcon(new ImageIcon("images/6ondddiQAq.png"));
		titleLabel.setBounds(142, 141, 480, 76);
		add(titleLabel);
		
		ProjectButton slotsBtn = new ProjectButton("SLOTS GAME");
		slotsBtn.addActionListener(new ActionListener()
		{ public void actionPerformed(ActionEvent event) {
				next = "slots";
				if(event.getSource()==slotsBtn){
					buttonSound3 = new File("sounds/buttonSound.wav");
					
					try {
						createButtonSound3	 =  AudioSystem.getAudioInputStream(buttonSound3);
						try {
							startButtonSound3 = AudioSystem.getClip();
							
							
						} catch (LineUnavailableException e) {
							
							e.printStackTrace();
						}
					} catch (UnsupportedAudioFileException e) {
						  
						e.printStackTrace();
					} catch (IOException e) {
						
						e.printStackTrace();
					} 
					
					try {
						startButtonSound3.open(createButtonSound3);
					} catch (LineUnavailableException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					startButtonSound3.start();
				
				setVisible( false);
			}
		}});
		slotsBtn.setBounds(230, 294, 326, 35);
		add(slotsBtn);
		
		ProjectButton coinGenButton = new ProjectButton("COIN GENERATOR");
		coinGenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				next = "coinGen";
				if(event.getSource()==coinGenButton){
					buttonSound3 = new File("sounds/buttonSound.wav");
					
					try {
						createButtonSound3	 =  AudioSystem.getAudioInputStream(buttonSound3);
						try {
							startButtonSound3 = AudioSystem.getClip();
							
							
						} catch (LineUnavailableException e) {
							
							e.printStackTrace();
						}
					} catch (UnsupportedAudioFileException e) {
						  
						e.printStackTrace();
					} catch (IOException e) {
						
						e.printStackTrace();
					} 
					
					try {
						startButtonSound3.open(createButtonSound3);
					} catch (LineUnavailableException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					startButtonSound3.start();
				
				
				setVisible( false);
			}
		}});
		coinGenButton.setBounds(230, 372, 326, 35);
		add(coinGenButton);
		
		ProjectButton backBtn = new ProjectButton("BACK");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {	
				next = "back";
				if(event.getSource()==backBtn){
					buttonSound3 = new File("sounds/slotSound.wav");
					
					try {
						createButtonSound3	 =  AudioSystem.getAudioInputStream(buttonSound3);
						try {
							startButtonSound3 = AudioSystem.getClip();
							
							
						} catch (LineUnavailableException e) {
							
							e.printStackTrace();
						}
					} catch (UnsupportedAudioFileException e) {
						  
						e.printStackTrace();
					} catch (IOException e) {
						
						e.printStackTrace();
					} 
					
					try {
						startButtonSound3.open(createButtonSound3);
					} catch (LineUnavailableException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					startButtonSound3.start();
				setVisible( false);
			}
		}});
		backBtn.setBounds(230, 453, 326, 35);
		add(backBtn);
				
		curpanel = new CurrencyPanel( stats);
		add( curpanel);
		
		
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
		curpanel.update( stats);
	}

}
