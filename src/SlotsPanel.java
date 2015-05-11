/*
 * by Huseyin BEYAN & Firat SIVRIKAYA
 * vers 1.0   24.04.2015
 * 
 * Panel to entering page of Slots in our project
 * 
 * 
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
	
	// constants
	final private int ALCOHOLETHER_REQUIRED_CRYSTAL = 10;
	final private int ALCOHOLETHER_REQUIRED_COIN = 100;
	
	final private int ALDEKET_REQUIRED_CRYSTAL = 15;
	final private int ALDEKET_REQUIRED_COIN = 200;
	
	final private int CARBOX_REQUIRED_CRYSTAL = 20;
	final private int CARBOX_REQUIRED_COIN = 250;
	
	
	//VARIABLES
	
	//image variables
	private Image background;
	private Statistics stats;
	private CurrencyPanel curpanel;
	private ProjectButton aldeBtn;
	private ProjectButton alcoBtn;
	private ProjectButton carboxBtn;
	private SlotsPanel panel;
	
	//sound variables	
	private File lockSound;		
	private AudioInputStream createLockSound;		
	private Clip startLockSound;
	
	private String next;
	
	public SlotsPanel( Statistics stats) {		
		setVisible( true);
		setFocusable(true);
		requestFocusInWindow();		
		
		next = "";
		this.stats = stats;
		panel = this;
		
		curpanel = new CurrencyPanel( stats);
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
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////
		if( stats.getAlde())
		{
			aldeBtn = new ProjectButton("ALDEHYDES/KETONS");		
			aldeBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					next = "aldehydes";
					
					if(event.getSource()==aldeBtn){
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
			
		}
		
		else
		{
			aldeBtn = new ProjectButton("Locked-ALDEHYDES/KETONS");
			aldeBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					//Custom button text
					Object[] options = {"Unlock the Level", "Cancel"};
					
					int unlock;
					
					unlock = JOptionPane.showOptionDialog( null, " This level is locked!","Locked Level", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,
						    new ImageIcon("images/lock.png"),     			//do not use a custom Icon
						    options,  			//the titles of buttons
						    options[0]); 		//default button title
					
					if( unlock == JOptionPane.YES_OPTION)
					{
						if( !stats.enoughCrystal(ALDEKET_REQUIRED_CRYSTAL) || !stats.enoughCoin( ALDEKET_REQUIRED_COIN))
							JOptionPane.showMessageDialog(null, "You dont have enough crystals or coins!", "Couldn't unlocked", JOptionPane.ERROR_MESSAGE, new ImageIcon("images/sadface.png"));
						else
						{
							JOptionPane.showMessageDialog(null, "Level is Unlocked!!", "Unlocked", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("images/unlock.png") );
							stats.spendCrystal(ALDEKET_REQUIRED_CRYSTAL);
							stats.spendCoins(ALDEKET_REQUIRED_COIN);
							
							stats.setAlde( true);
							panel.update( stats);	
							
							remove( aldeBtn);
							
							panel.aldeBtn = new ProjectButton("ALDEHYDES/KETONS");	
							
							aldeBtn.setBounds(75, 400, 300, 50);
							aldeBtn.setFocusable(false);
							aldeBtn.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent event) {
									next = "aldehydes";
									
									if(event.getSource()==aldeBtn){
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
											e.printStackTrace();
										} catch (IOException e) {
											e.printStackTrace();
										}
										startLockSound.start();
										setVisible( false);
									}
									
									setVisible( false);	
								}
							});
							add(aldeBtn);							
							
							next = "aldehydes";	
							
							if(event.getSource()==aldeBtn){
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
									e.printStackTrace();
								} catch (IOException e) {
									e.printStackTrace();
								}
								startLockSound.start();
								setVisible( false);
							}
							
							setVisible( false);	
						
						}
					}
				}
			});			
		}			
		aldeBtn.setBounds(75, 400, 300, 50);
		aldeBtn.setFocusable(false);
		add(aldeBtn);
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////
		if( stats.getAlco())
		{
			alcoBtn = new ProjectButton("ALCOHOLS/ETHERS");		
			alcoBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					next = "alcohols";
					
					if(event.getSource()==alcoBtn){
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
			
		}
		
		else
		{
			alcoBtn = new ProjectButton("Locked-ALCOHOLS/ETHERS");
			alcoBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					//Custom button text
					Object[] options = {"Unlock the Level", "Cancel"};
					
					int unlock;
					
					unlock = JOptionPane.showOptionDialog( null, " This level is locked!","Locked Level", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,
						    new ImageIcon("images/lock.png"),     			//do not use a custom Icon
						    options,  			//the titles of buttons
						    options[0]); 		//default button title
					
					if( unlock == JOptionPane.YES_OPTION)
					{
						if( !stats.enoughCrystal(ALCOHOLETHER_REQUIRED_CRYSTAL) || !stats.enoughCoin( ALCOHOLETHER_REQUIRED_COIN) )
							JOptionPane.showMessageDialog(null, "You dont have enough crystals or coins!", "Couldn't unlocked", JOptionPane.ERROR_MESSAGE, new ImageIcon("images/sadface.png"));
						else
						{
							JOptionPane.showMessageDialog(null, "Level is Unlocked!!", "Unlocked", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("images/unlock.png") );
							stats.spendCrystal(ALCOHOLETHER_REQUIRED_CRYSTAL);
							stats.spendCoins(ALCOHOLETHER_REQUIRED_COIN);
							stats.setAlco( true);
							panel.update( stats);	
							
							remove( alcoBtn);
							
							panel.alcoBtn = new ProjectButton("ALCOHOLS/ETHERS");								
							alcoBtn.setBounds(425, 270, 300, 50);
							alcoBtn.setFocusable(false);
							alcoBtn.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent event) {
									next = "alcohols";
									
									if(event.getSource()==alcoBtn){
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
							add(alcoBtn);							
							
							next = "alcohols";	
							
							if(event.getSource()==alcoBtn){
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
					}
				}
			});			
		}			
		alcoBtn.setBounds(425, 270, 300, 50);
		alcoBtn.setFocusable(false);
		add(alcoBtn);
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////
		if( stats.getCarbox())
		{
			carboxBtn = new ProjectButton("CARBOXCYLIC ACIDS");		
			carboxBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					next = "carboxacids";
					
					if(event.getSource()==carboxBtn){
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
			
		}
		
		else
		{
			carboxBtn = new ProjectButton("Locked-CARBOXCYLIC ACIDS");
			carboxBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					//Custom button text
					Object[] options = {"Unlock the Level", "Cancel"};
					
					int unlock;
					
					unlock = JOptionPane.showOptionDialog( null, " This level is locked!","Locked Level", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,
						    new ImageIcon("images/lock.png"),     			//do not use a custom Icon
						    options,  			//the titles of buttons
						    options[0]); 		//default button title
					
					if( unlock == JOptionPane.YES_OPTION)
					{
						if( !stats.enoughCrystal(CARBOX_REQUIRED_CRYSTAL) || !stats.enoughCoin( CARBOX_REQUIRED_COIN))
							JOptionPane.showMessageDialog(null, "You dont have enough crystals or coins!", "Couldn't unlocked", JOptionPane.ERROR_MESSAGE, new ImageIcon("images/sadface.png"));
						else
						{
							JOptionPane.showMessageDialog(null, "Level is Unlocked!!", "Unlocked", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("images/unlock.png") );
							stats.spendCrystal( CARBOX_REQUIRED_CRYSTAL );
							stats.spendCoins( CARBOX_REQUIRED_COIN );
							
							stats.setCarbox( true);
							panel.update( stats);	
							
							remove( carboxBtn);
							
							panel.carboxBtn = new ProjectButton("CARBOXCYLIC ACIDS");	
							
							carboxBtn.setBounds(425, 400, 300, 50);
							carboxBtn.setFocusable(false);
							carboxBtn.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent event) {
									next = "carboxacids";
									
									if(event.getSource()==carboxBtn){
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
							add(carboxBtn);							
							
							next = "carboxacids";	
							
							if(event.getSource()==carboxBtn){
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
					}
				}
			});			
		}			
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
	
	public void update( Statistics stat)
	{
		curpanel.update( stat);
		stats = stat;
	}

	
}
