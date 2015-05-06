/*
 * by H�seyin BEYAN
 * vers 1.0   24.04.2015
 * 
 * Panel to entering page of Slots in our project
 */ 

import java.awt.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;


public class SlotsPanel extends JPanel {
	//VARIABLES
	
	//image variables
	private Image background;
	
	//sound variables
	
private File lockSound;
	
	
private AudioInputStream createLockSound;
	
	
private Clip startLockSound;
	
	private String next;
	
	public SlotsPanel() {		
		setVisible( true);
		setFocusable(true);
		requestFocusInWindow();		
		
		next = "";
				
		
		CurrencyPanel curpanel = new CurrencyPanel( 200, 4);
		add( curpanel);
		
		ProjectButton hydroBtn = new ProjectButton("HYDROCARBONS");
		hydroBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				next = "hydrocarbons";
				
				if(event.getSource()==hydroBtn){
					lockSound = new File("sounds/door_lock.wav");
					
					try {
						createLockSound	 =  AudioSystem.getAudioInputStream(lockSound);
						try {
							startLockSound = AudioSystem.getClip();
							
							
						} catch (LineUnavailableException e) {
							
							e.printStackTrace();
						}
					} catch (UnsupportedAudioFileException e) {
						  
						e.printStackTrace();
					} catch (IOException e) {
						
						e.printStackTrace();
					} 
					
					try {
						startLockSound.open(createLockSound);
					} catch (LineUnavailableException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					startLockSound.start();
				setVisible( false);
			}
				
				setVisible( false);
			}
		});
		hydroBtn.setBounds(75, 270, 300, 50);
		hydroBtn.setFocusable(false);
		add(hydroBtn);
		
		ProjectButton aldeBtn = new ProjectButton("Locked-ALDEHYDES/KETONS");
		aldeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				next = "aldehydes";
				setVisible( false);	
			}
		});
		aldeBtn.setBounds(75, 400, 300, 50);
		aldeBtn.setFocusable(false);
		add(aldeBtn);
		
		ProjectButton alcoBtn = new ProjectButton("Locked-ALCOHOLS/ETHERS");
		alcoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				next = "alcohols";
				setVisible( false);				
			}
		});
		alcoBtn.setBounds(425, 270, 300, 50);
		alcoBtn.setFocusable(false);
		add(alcoBtn);
		
		ProjectButton carboxBtn = new ProjectButton("Locked-CARBOXCYL�C ACIDS");
		carboxBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				next = "carboxacids";
				setVisible( false);
			}
		});
		carboxBtn.setBounds(425, 400, 300, 50);
		carboxBtn.setFocusable(false);
		add(carboxBtn);
		
		JLabel slotsLabel = new JLabel("");
		slotsLabel.setFont(new Font("Tahoma", Font.PLAIN, 33));
		slotsLabel.setIcon( new ImageIcon("images/slots.png"));
		slotsLabel.setBounds(225, 102, 350, 100);
		add(slotsLabel);
		
		setLayout( null);
		setBounds( 0, 0, 800, 600);
		
	}
	
	public void paintComponent( Graphics g)
	{   
		super.paintComponent( g);
		
		background = new ImageIcon("images/background.png" ).getImage();		
		
		g.drawImage( background, 0, 0, null);
		
	}	
	
	public String getNext()
	{
		return next;
	}
	
}
