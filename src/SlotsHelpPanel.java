/*
  * by Hüseyin BEYAN
 * vers 1.0   28.04.2015
 * 
 * Panel to show help page of our project
 */

import java.awt.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.swing.event.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

public class SlotsHelpPanel extends JPanel {
	//VARIABLES
	
	//image variable
	private Image background;
	//sound varibles
	 private File buttonSound4;
		
		
	 private AudioInputStream createButtonSound4;
		
		
	 private Clip startButtonSound4;
	
	private Help helping;
	private JList list;
	private JLabel label;
	private ListListener lst;
	private CurrencyPanel cur;
	
	public SlotsHelpPanel() 
	{
		setVisible( true);				
		setBounds( 0,0, 800, 600);		
		setLayout(null);
		setFocusable(false);
		requestFocusInWindow();
		
		Statistics stats = new Statistics();
		cur = new CurrencyPanel( stats);
		cur.setBounds( 0, 0, 100, 50);
		add( cur);
		
		JLabel lblHelp = new JLabel("");
		lblHelp.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblHelp.setBounds(290, 40, 220, 100);
		lblHelp.setIcon( new ImageIcon( "images/help.png"));
		add(lblHelp);
		
		ProjectButton btnBack = new ProjectButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if(event.getSource()==btnBack){
					buttonSound4 = new File("sounds/slotSound.wav");
					
					try {
						createButtonSound4	 =  AudioSystem.getAudioInputStream(buttonSound4);
						try {
							startButtonSound4 = AudioSystem.getClip();
							
							
						} catch (LineUnavailableException e) {
							
							e.printStackTrace();
						}
					} catch (UnsupportedAudioFileException e) {
						  
						e.printStackTrace();
					} catch (IOException e) {
						
						e.printStackTrace();
					} 
					
					try {
						startButtonSound4.open(createButtonSound4);
					} catch (LineUnavailableException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					startButtonSound4.start();
				setVisible( false);
			}
		}});
		btnBack.setBounds(250, 490, 300, 50);
		add(btnBack);
		
		label = new JLabel( "  Welcome to Slots Quiz!");
		
		
		
		label.setFont(new Font("Helvetica", Font.PLAIN, 15));
		//label.setBounds(277, 141, 290, 307);
		label.setBackground( Color.white);
		label.setOpaque( true);
		add( label);
		
		helping = new Help();
		
		String[] helps = { "Introduction", "Definitions", "Symbols"};
		
		Object[] images = { new ImageIcon( "images/intro.png"), new ImageIcon( "images/def.png"), new ImageIcon( "images/sym.png")};
		
		list = new JList (images);
		list.setForeground(new Color(0, 0, 128));
		//list.setFont(new Font("Helvetica Narrow", Font.PLAIN, 18));
		
		lst = new ListListener();
	    list.addListSelectionListener ( lst);	    
	    list.setSelectionMode (ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
	    list.setBackground( SystemColor.inactiveCaption);
	    add( list);   
	    
	    
	    JSplitPane splitPane = new JSplitPane( JSplitPane.HORIZONTAL_SPLIT, list, label);
	    splitPane.setBounds(75, 140, 600, 315);
	    splitPane.setOneTouchExpandable (false);
	    add(splitPane);
	}
	
	public void paintComponent( Graphics g)
	{
		super.paintComponent( g);		

		background = new ImageIcon( "images/background.png" ).getImage();
		
		g.drawImage( background, 0, 0, null);		
	}
	
	private class ListListener implements ListSelectionListener
	{
	      public void valueChanged (ListSelectionEvent event)
	      {
	         if (list.isSelectionEmpty())
	        	 label.setText( "Welcome to Slots Quiz!");
	         
	         else
	         {
	        	 ImageIcon source = (ImageIcon)list.getSelectedValue();	         
	        	 
	        	 if( source.toString().equals("images/intro.png") )
	        	 {
	        		 label.setText( "");
	        		 label.setIcon( helping.getIntro());
	        	 }
	        	 
	        	 if(  source.toString().equals("images/def.png") )
	        	 {
	        		 label.setText( "");
	        		 label.setIcon( helping.getDef());
	        	 }	
	        	 
	        	 if(  source.toString().equals("images/sym.png") )
	        	 {
	        		 label.setText( "");
	        		 label.setIcon( helping.getSym());
	        	 }
	         }
	   }
	}
	
	public void reset()
	{
		label.setText( "Welcome to Slots Quiz!");
	}
	
	public void update( Statistics stats)
	{
		cur.update( stats);
	}
}
