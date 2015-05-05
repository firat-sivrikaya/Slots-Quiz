/*
 * by Hüseyin BEYAN
 * vers 1.0   22.04.2015
 * 
 * Panel to show welcome page of our project
 */ 

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;


public class WelcomePanel extends JPanel {
	//VARIABLES
	
	//image variable
	private Image background;
	
	//sound variables
	private File buttonSound;
	
	
	private AudioInputStream createButtonSound;
	
	
	private Clip startButtonSound;
	
	
	private ProjectButton playButton;
	private ProjectButton helpButton;
	private ProjectButton optionButton;
	private ProjectButton exitButton;
	
	private String next = "";
	
	public WelcomePanel() {
		
		setVisible( true);		
		setBounds( 0,0, 800, 600);		
		setLayout(null);
		setFocusable(false);
		requestFocusInWindow();
		
		JLabel titleLabel = new JLabel("");
		titleLabel.setIcon(new ImageIcon("images\\6ondddiQAq.png"));
		titleLabel.setBounds(142, 141, 480, 76);
		add(titleLabel);
		
		playButton = new ProjectButton("PLAY");
		playButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {	
				setVisible( false);
				next = "play";
				
				if(event.getSource()==playButton){
					buttonSound = new File("sounds\\buttonSound.wav");
					
					try {
						createButtonSound	 =  AudioSystem.getAudioInputStream(buttonSound);
						try {
							startButtonSound = AudioSystem.getClip();
							
							
						} catch (LineUnavailableException e) {
							
							e.printStackTrace();
						}
					} catch (UnsupportedAudioFileException e) {
						  
						e.printStackTrace();
					} catch (IOException e) {
						
						e.printStackTrace();
					} 
					
					try {
						startButtonSound.open(createButtonSound);
					} catch (LineUnavailableException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					startButtonSound.start();
				
				
			   
				}
			}
		});
			
		playButton.setBounds(230, 293, 326, 35);
		add(playButton);
		
		optionButton = new ProjectButton("OPTIONS");
		optionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				setVisible( false);
				next = "options";
				if(event.getSource()==optionButton){
					buttonSound = new File("sounds\\buttonSound.wav");
					
					try {
						createButtonSound	 =  AudioSystem.getAudioInputStream(buttonSound);
						try {
							startButtonSound = AudioSystem.getClip();
							
							
						} catch (LineUnavailableException e) {
							
							e.printStackTrace();
						}
					} catch (UnsupportedAudioFileException e) {
						  
						e.printStackTrace();
					} catch (IOException e) {
						
						e.printStackTrace();
					} 
					
					try {
						startButtonSound.open(createButtonSound);
					} catch (LineUnavailableException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					startButtonSound.start();
				
				
			   
				}
			}
		});
			
		
		optionButton.setBounds(230, 367, 326, 35);
		add(optionButton);
		
		helpButton = new ProjectButton("HELP");
		helpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				setVisible( false);
				next = "help";
				if(event.getSource()==helpButton){
					buttonSound = new File("sounds\\buttonSound.wav");
					
					try {
						createButtonSound	 =  AudioSystem.getAudioInputStream(buttonSound);
						try {
							startButtonSound = AudioSystem.getClip();
							
							
						} catch (LineUnavailableException e) {
							
							e.printStackTrace();
						}
					} catch (UnsupportedAudioFileException e) {
						  
						e.printStackTrace();
					} catch (IOException e) {
						
						e.printStackTrace();
					} 
					
					try {
						startButtonSound.open(createButtonSound);
					} catch (LineUnavailableException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					startButtonSound.start();
				
				
			   
				}
			}
		});
		helpButton.setBounds(230, 429, 326, 35);
		add(helpButton);
		
		exitButton = new ProjectButton("EXIT");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
				
				
				if(event.getSource()==exitButton){
					buttonSound = new File("sounds\\buttonSound.wav");
					
					try {
						createButtonSound	 =  AudioSystem.getAudioInputStream(buttonSound);
						try {
							startButtonSound = AudioSystem.getClip();
							
							
						} catch (LineUnavailableException e) {
							
							e.printStackTrace();
						}
					} catch (UnsupportedAudioFileException e) {
						  
						e.printStackTrace();
					} catch (IOException e) {
						
						e.printStackTrace();
					} 
					
					try {
						startButtonSound.open(createButtonSound);
					} catch (LineUnavailableException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					startButtonSound.start();
				
				
					System.exit( 0);
				}
			}
		});
			
			
			
		
		exitButton.setBounds(230, 492, 326, 35);
		add(exitButton);
		
		CurrencyPanel curpanel = new CurrencyPanel( 200, 4);
		add( curpanel);		
	}
	
	public void paintComponent( Graphics g)
	{
		super.paintComponent( g);		

		background = new ImageIcon( "images\\background.png" ).getImage();
		
		g.drawImage( background, 0, 0, null);		
	}
	
	public String getNext()
	{
		return next;
	}	
	
}
