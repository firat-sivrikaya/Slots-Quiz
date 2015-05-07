/*
 * AlcoholEtherSlots Slots
 * @author Hazal Buruk
 * @author Gokce Sakir Ozyurt
 */

import javax.swing.*;
import javax.swing.Timer;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.sound.sampled.*;

import java.io.*;

public class AldehydeKetoneSlotsPanel extends JPanel {
	
	//VARIABLES
	private Statistics stats;
	
	//images variables
	private ImageIcon[] icon, numbers, counters;
	private Image background;
	private ImageIcon sloton, slotoff, header;
	//sounds variables
	private File clickSound3;
	private File winSlot3;
	
	private AudioInputStream createClick3;
	private AudioInputStream createWin3;
	
	private Clip startSound3; 
	private Clip winSound3;
	
	//integer variables
	private int first; //to start spin, 'first' should be '0'
	private int[] saver; //to control line equalities and find the counter
	private final int DELAY_SLOTS = 295, DELAY_BUTTON = 200; //timer delays
	
	//labels variables
	private JLabel[] label; //icon labels and band labels
	private JLabel label1, label2, label_1, label_2, label_3, label_4, label_5; //to add header, counter and left numbers
	private JLabel label_6, label_7, label_8, label_9, label_10; //to add right numbers
	
	//timer variable
	private Timer timer, timer2;
	
	//random variable
	private Random generator= new Random(); //to calculate Random number
	
	//button variable
	private JButton button; //to spin button
	
	//panel variable
	private JPanel panel; //to put slots icons
	private CurrencyPanel currencyPanel; //Currency Panel

	//CONSTRUCTORS
	public AldehydeKetoneSlotsPanel( Statistics statistics ){
		
		stats = statistics;
		//create the arrays
		counters = new ImageIcon[6];
		icon = new ImageIcon[5];
		numbers = new ImageIcon[10];
		label = new JLabel[9];
		saver = new int[9];
		
		//fill the header with the icon
		header = new ImageIcon("images/aldeket/aldehydeketone.png");
		
		//counter pictures for counter label
		counters[0] = new ImageIcon("images/counter0.png");
		counters[1] = new ImageIcon("images/counter1.png");
		counters[2] = new ImageIcon("images/counter2.png");
		counters[3] = new ImageIcon("images/counter3.png");
		counters[4] = new ImageIcon("images/counter4.png");
		counters[5] = new ImageIcon("images/counter5.png");
		
		//number pictures for number labels
		numbers[0] = new ImageIcon("images/numbers01.png");
		numbers[1] = new ImageIcon("images/numbers02.png");
		numbers[2] = new ImageIcon("images/numbers03.png");
		numbers[3] = new ImageIcon("images/numbers04.png");
		numbers[4] = new ImageIcon("images/numbers05.png");
		numbers[5] = new ImageIcon("images/numbers06.png");
		numbers[6] = new ImageIcon("images/numbers07.png");
		numbers[7] = new ImageIcon("images/numbers08.png");
		numbers[8] = new ImageIcon("images/numbers09.png");
		numbers[9] = new ImageIcon("images/numbers10.png");
		
		//currency panel
		currencyPanel = new CurrencyPanel(0,0); //create
		currencyPanel.setLocation(0, 0); //setting location
		
		//spin button pictures
		slotoff = new ImageIcon("images/spinoff.png");
		sloton = new ImageIcon("images/spinon.png");
		
		//create spin button
		button = new JButton("");
		button.setBounds(540, 246, 100, 100); //button location
		button.setIcon(slotoff); //start picture
		//make spin button oval
		button.setFocusPainted(false); 
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);	
		button.setFocusable( false);
		//add listener to button
		button.addActionListener(new ButtonListener());
		
		first=0; //counter to change next picture on slots
		
		//slots timer
		SlotListener listener = new SlotListener(); //listener of slots timer
		timer = new Timer(DELAY_SLOTS, listener); //create timer

		//spin button picture changer timer to give it a button view
		SlotButtonListener listener2 = new SlotButtonListener(); //listener of spin button picture changer
		timer2 = new Timer(DELAY_BUTTON, listener2); //create timer
		
		//Counter Label
		label1 = new JLabel(counters[0]); //set default picture
		label1.setBounds(514, 413, 158, 34); //set location
		
		//slots panel
		panel = new JPanel(); //create panel
		panel.setBounds(99, 190, 330, 330); //set location
		
		//create GridLayout to slots panel
		panel.setLayout( new GridLayout(3,3));
		
		//pictures to full grid layout
		icon[0] = new ImageIcon("images/aldeket/gifaldeket.gif"); //gif
		icon[1] = new ImageIcon("images/aldeket/aldeket001.png"); 
		icon[2] = new ImageIcon("images/aldeket/aldeket002.png");
		icon[3] = new ImageIcon("images/aldeket/aldeket003.png");
		icon[4] = new ImageIcon("images/aldeket/aldeket004.png");
		
		//full savers with '0' for the start
		for(int i = 0; i<9; i++)
			saver[i]=0;
		
		//full labels with random pictures
		for ( int i = 0; i<9 ; i++)
		{
			int b = generator.nextInt(5-1)+1;
			label[i] = new JLabel(icon[b]);
			panel.add(label[i]);
		}
		
		//to locate every component
		setLayout(null);

		//add slots panel to main panel
		add(panel);
		
		//edit slots panel
		panel.setPreferredSize(new Dimension (330, 330)); //dimension
		panel.setBackground(Color.black); //background
		
		//add counter label to main panel
		add(label1);
		//add spin button to main panel
		add(button); 
		//add currency panel to main panel
		add(currencyPanel);
		
		//header panel
		label2 = new JLabel(""); //create
		label2.setBounds(81, -71, 800, 430); //locate
		add(label2); //add to main panel
		label2.setIcon(header); //full with header icon
		
		//dimension for main panel
		setBounds( 0, 0, 800, 600);
		
		//create, locate and add to main panel number labels
		label_1 = new JLabel(numbers[0]);
		label_1.setBounds(71, 214, 27, 34);
		add(label_1);
		
		label_2 = new JLabel(numbers[1]);
		label_2.setBounds(71, 246, 27, 34);
		add(label_2);
		
		label_3 = new JLabel(numbers[2]);
		label_3.setBounds(71, 335, 27, 34);
		add(label_3);
		
		label_4 = new JLabel(numbers[3]);
		label_4.setBounds(71, 425, 27, 34);
		add(label_4);
		
		label_5 = new JLabel(numbers[4]);
		label_5.setBounds(71, 455, 27, 34);
		add(label_5);
		
		label_6 = new JLabel(numbers[0]);
		label_6.setBounds(434, 214, 27, 34);
		add(label_6);
		
		label_7 = new JLabel(numbers[3]);
		label_7.setBounds(434, 246, 27, 34);
		add(label_7);
		
		label_8 = new JLabel(numbers[2]);
		label_8.setBounds(434, 335, 27, 34);
		add(label_8);
		
		label_9 = new JLabel(numbers[1]);
		label_9.setBounds(434, 425, 27, 34);
		add(label_9);
		
		label_10 = new JLabel(numbers[4]);
		label_10.setBounds(434, 455, 27, 34);
		add(label_10);
		
	}
	

	//paint component to set background
	public void paintComponent( Graphics g)
	{
		super.paintComponent( g);		

		background = new ImageIcon("images/slotsBackground.png").getImage(); //get background icon as image
		
		g.drawImage( background, 0, 0, null); //draw background
	}
	
	//LISTENERS
	//according to timer, change every picture one by one
	private class SlotListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			if(first < 9)
			{
				int num = generator.nextInt(5-1)+1;
				label[first].setIcon(icon[num]);
				saver[first]=num;
				first++;
			}
			else
			{
				timer.stop();
				label1.setIcon(counters[lineCounter()]);
			}
		}
	}
	
	//timer listener to change the button picture to off
	private class SlotButtonListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			if(timer2.isRunning())
			{
				button.setIcon(slotoff);
				timer2.stop();
			}
		}
	}
	
	//button listener
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			//set every image to gif
			for ( int i = 0; i<9 ; i++)
			{
				label[i].setIcon(icon[0]);
				label1.setIcon(counters[0]);
			}
			//change button picture
			button.setIcon(sloton);
			//set every number label to start settings
			label_1.setIcon(numbers[0]);
			label_2.setIcon(numbers[1]);
			label_3.setIcon(numbers[2]);
			label_4.setIcon(numbers[3]);
			label_5.setIcon(numbers[4]);
			label_6.setIcon(numbers[0]);
			label_7.setIcon(numbers[3]);
			label_8.setIcon(numbers[2]);
			label_9.setIcon(numbers[1]);
			label_10.setIcon(numbers[4]);
			
			//set first to start settings
			first=0;
			//start timers
			timer.start();
			timer2.start();
			//start the sound when triggered
			if(event.getSource()==button){
				clickSound3 = new File("sounds/slot_payoff.wav");
				
				try {
					createClick3 =  AudioSystem.getAudioInputStream(clickSound3);
					try {
						startSound3 = AudioSystem.getClip();
						
						
					} catch (LineUnavailableException e) {
						
						e.printStackTrace();
					}
				} catch (UnsupportedAudioFileException e) {
					  
					e.printStackTrace();
				} catch (IOException e) {
					
					e.printStackTrace();
				} 
				
				try {
					startSound3.open(createClick3);
				} catch (LineUnavailableException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			startSound3.start();
			
			
		   
			}
					
		}
	}
	
	//number of ranked lines
	public int lineCounter(){
		int counter=0;
		if(saver[0] == 0)
			return 0;
		else
		{
			if(saver[0]== saver[1] && saver[1]== saver[2]){ //if it is satisfied
				counter++; //increase the value
				label_1.setIcon(numbers[5]); //change picture
				label_6.setIcon(numbers[5]); //change picture
			}
			if(saver[0]== saver[4] && saver[4]== saver[8]){
				counter++;
				label_2.setIcon(numbers[6]);
				label_9.setIcon(numbers[6]);
			}
			if(saver[3]== saver[4] && saver[4]== saver[5]){
				counter++;
				label_3.setIcon(numbers[7]);
				label_8.setIcon(numbers[7]);
			}
			if(saver[6]== saver[4] && saver[4]== saver[2]){
				counter++;
				label_4.setIcon(numbers[8]);
				label_7.setIcon(numbers[8]);
			}
			if(saver[6]== saver[7] && saver[7]== saver[8]){
				counter++;
				label_5.setIcon(numbers[9]);
				label_10.setIcon(numbers[9]);
			}
		}
		if(counter!=0){
			winSlot3 = new File("sounds/win.wav");
		
		try {
			createWin3 =  AudioSystem.getAudioInputStream(winSlot3);
			try {
				winSound3 = AudioSystem.getClip();
				
				
			} catch (LineUnavailableException e) {
				
				e.printStackTrace();
			}
		} catch (UnsupportedAudioFileException e) {
			  
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} 
		
		try {
			winSound3.open(createWin3);
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		winSound3.start();
		
		// TODO: CHANGE THE QUESTION AS HYDROCARBON AS SOON AS HYDROCARBON QUESTIONS ARE WRITTEN
		JFrame frame = new JFrame("Question");
		SlotsQuestionPanel qpanel = new SlotsQuestionPanel("AldeKet", this, stats );
		frame.getContentPane().add( qpanel );
		frame.setBounds(400, 400, 800, 600);
		frame.setVisible( true );
		
		}
			
		
		return counter; //return the ranked number
			
	}
	
	//boolean method to open question
	public boolean isTriggered(){
		if(lineCounter()>0)
			return true;
		return false;
	}
}

