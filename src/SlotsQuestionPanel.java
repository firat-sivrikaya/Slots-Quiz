/* SlotsQuestionPanel
 * @author Gokce Sakir Ozyurt
 * @author Firat Sivrikaya
 * 
 * 
 * This is the question panel which is used in all slots.
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;


public class SlotsQuestionPanel extends JPanel {
	// constants
	final private int CARBOX_COIN_GAIN_AMOUNT = 50;
	final private int CARBOX_CRYSTAL_GAIN_AMOUNT = 3;
	
	final private int HYDROCARBON_COIN_GAIN_AMOUNT = 15;
	final private int HYDROCARBON_CRYSTAL_GAIN_AMOUNT = 1;
	
	final private int ALCOHOLETHER_COIN_GAIN_AMOUNT = 15;
	final private int ALCOHOLETHER_CRYSTAL_GAIN_AMOUNT = 2;
	
	final private int ALDEKET_COIN_GAIN_AMOUNT = 25;
	final private int ALDEKET_CRYSTAL_GAIN_AMOUNT = 1;
	
	
	// properties
	private ProjectButton okButton;
	private ProjectButton okButton2;
	private ProjectButton okButton3;
	private static File backgroundSound;
	private static AudioInputStream createBackgroundSound;
	private static Clip startBackgroundSound;
	
	private File answerButton;
	private AudioInputStream createAnswerButton;
	private Clip startAnswerButton;
	
	private File answerSelected;
	private AudioInputStream createAnswerSelected;
	private Clip startAnswerSelected;

	
	private SlotsQuestionPanel sqp;
	private CurrencyPanel curPanel;
	
	private Image background;
	private ImageIcon header;
	private ImageIcon winBackground;
	private ImageIcon loseBackground;
	private ImageIcon noTimeLeftBackground;
	
	private ProjectButton buttonA;
	private ProjectButton buttonB;
	private ProjectButton buttonC;
	private ProjectButton buttonD;
	private ProjectButton buttonE;
	private JPanel panel;
	private JPanel winPanel;
	private JPanel losePanel;
	private JPanel noTimeLeft;
	
	private String answer;
	private String location;
	private int isCorrect;
	private JFrame frame;
	private JFrame winFrame;
	private JFrame loseFrame;
	private JFrame noTimeLeftFrame;
	private Statistics stats;
	
	//countDown variables
	public JLabel countDown;
	public Timer chrono;
	
	private int counter;
	// constructors
	public SlotsQuestionPanel( String s, JPanel j, Statistics statistics, int counter ) 
	{
//		header = new ImageIcon()
		okButton = new ProjectButton("OK");
		okButton2 = new ProjectButton("OK");
		okButton3 = new ProjectButton("OK");
		
	
		stats = statistics;	
		sqp = this;
		isCorrect = 1;
		
		this.counter = counter;
		
		// Initialize question panel
		panel = new JPanel();
		panel.setBounds(48, 62, 700, 350);
		panel.setPreferredSize( new Dimension(700, 350));
		
		//initialize win panel
	//	winPanel = new JPanel();
	//	winPanel.setBounds(48, 62, 500, 400 );
	//	winPanel.setPreferredSize(new Dimension(500,400));
		
		//initialize lose panel
	//	losePanel = new JPanel();
	//	losePanel.setBounds(48,62,500,400);
	//	losePanel.setPreferredSize(new Dimension(500,400));
		
		//initialize lose panel
	//	noTimeLeft = new JPanel();
	//	noTimeLeft.setBounds(48,62,500,400);
	//	noTimeLeft.setPreferredSize(new Dimension(500,400));
		
		//initialize the question frame
		frame = new JFrame("Question");
		//yframe.setVisible( true );
		//frame.setBounds(400, 400, 800, 600);
		frame.setLocationRelativeTo(null);
		
		//initialize the win frame
		winFrame = new JFrame("You win!");
		winFrame.setVisible(false);
		winFrame.setResizable( false);
		winFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		winFrame.setBounds(400,300, 500,250);
		
		//initialize the lose frame
		loseFrame = new JFrame("You lost!");
		loseFrame.setVisible(false);
		loseFrame.setResizable( false);
		loseFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		loseFrame.setBounds(400,300, 500,250);
		
		//initialize the noTimeLeft frame
		noTimeLeftFrame = new JFrame("Time is up!");
		noTimeLeftFrame.setVisible(false);
		noTimeLeftFrame.setBounds(400,300, 500,250);
		
		//initialize the images and add them to panel
		winBackground = new ImageIcon( "images/options/wincoin.png" );
		loseBackground = new ImageIcon( "images/options/lose.png" );
		noTimeLeftBackground = new ImageIcon( "images/options/lose.png" );
		
		
		winFrame.setContentPane(new JLabel(winBackground));
		winFrame.getContentPane().setLayout(null);
		okButton.setBounds(200, 180, 100,27);
		okButton.addActionListener(new ButtonListener());
		winFrame.getContentPane().add(okButton);
		
		loseFrame.setContentPane(new JLabel(loseBackground));
		loseFrame.getContentPane().setLayout(null);
		okButton2.setBounds(200, 180, 100,27);
		okButton2.addActionListener(new ButtonListener());
		loseFrame.getContentPane().add(okButton2);
		
		noTimeLeftFrame.setContentPane(new JLabel(noTimeLeftBackground));
		noTimeLeftFrame.getContentPane().setLayout(null);
		okButton3.setBounds(200, 180, 100,27);
		okButton3.addActionListener(new ButtonListener());
		noTimeLeftFrame.getContentPane().add(okButton3);
		
		
		
		//this.add(winFrame);
		//this.add(loseFrame);
		//this.add(noTimeLeftFrame);
		
		
		//Panel has to be 800* 600
		this.setVisible( true);				
		this.setBounds( 0,0, 800, 600);
		this.setFocusable(false);
		this.requestFocusInWindow();
		
		//In order to move the necessary components
		setLayout(null);

		// Check the current slot category and set the question accordingly.
		if ( s.equals("Hydrocarbon") )
		{
			HydrocarbonS slots = new HydrocarbonS();
			Question q = slots.askQuestion();
			answer = q.getAnswer();
			location = q.getLocation();
			SlotsQuestionPanel.startBackgroundMusic();
			
		}
		
		else if ( s.equals("AlcoholEther") )
		{
			AlcoholEtherS slots = new AlcoholEtherS();
			Question q = slots.askQuestion();
			answer = q.getAnswer();
			location = q.getLocation();
			SlotsQuestionPanel.startBackgroundMusic();
			
		}
		
		else if ( s.equals("AldeKet") )
		{
			AldeKetS slots = new AldeKetS();
			Question q = slots.askQuestion();
			answer = q.getAnswer();
			location = q.getLocation();
			SlotsQuestionPanel.startBackgroundMusic();
		}
		
		else if ( s.equals("CarboxylicAcid") )
		{
			CarboxylicAcidS slots = new CarboxylicAcidS();
			Question q = slots.askQuestion();
			answer = q.getAnswer();
			location = q.getLocation();	
			SlotsQuestionPanel.startBackgroundMusic();
			
			
		}	
		
		//Currency panel at the top left corner.
		curPanel = new CurrencyPanel( stats );
		add(curPanel); 
		
		//Initializing the buttons
		buttonA = new ProjectButton("A");
		buttonB = new ProjectButton("B");
		buttonC = new ProjectButton("C");
		buttonD = new ProjectButton("D");
		buttonE = new ProjectButton("E");
		
		JLabel headerImage = new JLabel("");
		headerImage.setIcon(new ImageIcon("images/slotsQHeader.png"));
		headerImage.setBounds(205, 0, 400, 90);
		add(headerImage);
		
		//CountDown
		
		countDown= new JLabel();
		countDown.setBounds(720, 0, 80, 80);
		countDown.setIcon( new ImageIcon("images/timer.gif"));
		countDown.setOpaque( false);
		add(countDown);
				
		chrono = new Timer( 30 *1000, new countDownListener());
		chrono.setRepeats( false);		
		
		this.addAncestorListener( new AncestorListener(){
			public void ancestorAdded(AncestorEvent arg0) {
				chrono.start();				
			}
			
			public void ancestorRemoved(AncestorEvent arg0) {
				chrono.stop();
			}
			
			public void ancestorMoved(AncestorEvent arg0) {}			
		});
	
		//settings for A button
		buttonA.setBounds(40, 470, 70, 70);
		countDown.setFocusable( false);
		add(buttonA);		
		
		//settings for B Button
		buttonB.setBounds(200, 470, 70, 70);
		countDown.setFocusable( false);
		add(buttonB);
		
		//settings for C button
		buttonC.setBounds(360, 470, 70, 70);
		countDown.setFocusable( false);
		add(buttonC);
		
		//settings for D button
		buttonD.setBounds(520, 470, 70, 70);
		countDown.setFocusable( false);
		add(buttonD);
				
		//settings for E button
		buttonE.setBounds(680, 470, 70, 70);
		countDown.setFocusable( false);
		add(buttonE);		
		
		//adding action listener to A button
	
		buttonA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if(event.getSource()==buttonA){
					
					System.out.println("Location: " + location + " \nAnswer: " + answer ); 
					
					if ( answer.equals("A"))
					{
						System.out.println( "CORRECT!");
					//	isCorrect = JOptionPane.showOptionDialog(null, "You answered correctly and gained prize!", "Correct!",JOptionPane.DEFAULT_OPTION,
					//	        JOptionPane.INFORMATION_MESSAGE, new ImageIcon("images/options/win.png"), null, null);
						winFrame.setVisible(true);
						chrono.stop();
						countDown.setIcon( null);

						JFrame frame = (JFrame) SwingUtilities.getWindowAncestor( sqp );
						frame.setEnabled( false);
						stopBackgroundMusic();
						startWinMusic();
						
						if ( s.equals("CarboxylicAcid") )
						{
							stats.addCoins( CARBOX_COIN_GAIN_AMOUNT * counter);
							stats.addCrystal( CARBOX_CRYSTAL_GAIN_AMOUNT * counter);
							curPanel.update( stats);
							// TODO: IMPORTANT!!!
							//mainCurrency = ((HydrocarbonSlotsPanel) j).getCurrencyPanel();
							//mainCurrency.repaint();
						}
						
						else if ( s.equals("AlcoholEther" ))
						{
							stats.addCoins( ALCOHOLETHER_COIN_GAIN_AMOUNT * counter);
							stats.addCrystal( ALCOHOLETHER_CRYSTAL_GAIN_AMOUNT * counter);
							curPanel.update( stats);							
						}
						else if ( s.equals("Hydrocarbon" ))
						{
							stats.addCoins( HYDROCARBON_COIN_GAIN_AMOUNT * counter);
							stats.addCrystal( HYDROCARBON_CRYSTAL_GAIN_AMOUNT * counter);
							curPanel.update( stats);							
						}		
						
						else if ( s.equals("AldeKet" ))
						{
							stats.addCoins( ALDEKET_COIN_GAIN_AMOUNT * counter);
							stats.addCrystal( ALDEKET_CRYSTAL_GAIN_AMOUNT * counter);
							curPanel.update( stats);							
						}						
						
						
					}
					else
					{
						System.out.println( "FALSE!");
						
						loseFrame.setVisible(true);
						answerButton = new File("sounds/gameover.wav");

						try {
							createAnswerButton = AudioSystem
									.getAudioInputStream(answerButton);
							try {
								startAnswerButton = AudioSystem.getClip();

							} catch (LineUnavailableException e) {

								e.printStackTrace();
							}
						} catch (UnsupportedAudioFileException e) {

							e.printStackTrace();
						} catch (IOException e) {

							e.printStackTrace();
						}

						try {
							startAnswerButton.open(createAnswerButton);
						} catch (LineUnavailableException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						startAnswerButton.start();
						//isCorrect = JOptionPane.showOptionDialog(null, "Wrong answer :( It was " + answer, "Wrong", JOptionPane.DEFAULT_OPTION,
						//        JOptionPane.INFORMATION_MESSAGE, null, null, null);
						loseFrame.setVisible(true);
						chrono.stop();
						countDown.setIcon( null);
						
						JFrame frame = (JFrame) SwingUtilities.getWindowAncestor( sqp );
						frame.setEnabled( false);						
					}
					
				}
			}
		});

		//adding action listener to B button
		buttonB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if(event.getSource()==buttonB){
					
					System.out.println("Location: " + location + " \nAnswer: " + answer ); 
					
					if ( answer.equals("B"))
					{
						System.out.println( "CORRECT!");
						//isCorrect = JOptionPane.showOptionDialog(null, "You answered correctly and gained prize!", "Correct!",JOptionPane.DEFAULT_OPTION,
						//        JOptionPane.INFORMATION_MESSAGE, null, null, null);
						winFrame.setVisible(true);
						chrono.stop();
						countDown.setIcon( null);
						stopBackgroundMusic();
						JFrame frame = (JFrame) SwingUtilities.getWindowAncestor( sqp );
						frame.setEnabled( false);
						startWinMusic();
						if ( s.equals("CarboxylicAcid") )
						{
							stats.addCoins( 20 * counter);
							stats.addCrystal( 1 * counter);
							curPanel.update( stats);							
						}
						
						else if ( s.equals("AlcoholEther" ))
						{
							stats.addCoins( ALCOHOLETHER_COIN_GAIN_AMOUNT * counter);
							stats.addCrystal( ALCOHOLETHER_CRYSTAL_GAIN_AMOUNT * counter);
							curPanel.update( stats);							
						}
						else if ( s.equals("Hydrocarbon" ))
						{
							stats.addCoins( HYDROCARBON_COIN_GAIN_AMOUNT * counter);
							stats.addCrystal( HYDROCARBON_CRYSTAL_GAIN_AMOUNT * counter);
							curPanel.update( stats);							
						}		
						
						else if ( s.equals("AldeKet" ))
						{
							stats.addCoins( ALDEKET_COIN_GAIN_AMOUNT * counter);
							stats.addCrystal( ALDEKET_CRYSTAL_GAIN_AMOUNT * counter);
							curPanel.update( stats);							
						}
						
					}
					
					
					
					else
					{
						answerButton = new File("sounds/gameover.wav");

						try {
							createAnswerButton = AudioSystem
									.getAudioInputStream(answerButton);
							try {
								startAnswerButton = AudioSystem.getClip();

							} catch (LineUnavailableException e) {

								e.printStackTrace();
							}
						} catch (UnsupportedAudioFileException e) {

							e.printStackTrace();
						} catch (IOException e) {

							e.printStackTrace();
						}

						try {
							startAnswerButton.open(createAnswerButton);
						} catch (LineUnavailableException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						startAnswerButton.start();
						System.out.println( "FALSE!");
					//	isCorrect = JOptionPane.showOptionDialog(null, "Wrong answer :( It was " + answer , "Wrong", JOptionPane.DEFAULT_OPTION,
					//	       JOptionPane.INFORMATION_MESSAGE, null, null, null);
						loseFrame.setVisible(true);
						chrono.stop();
						countDown.setIcon( null);
						
						JFrame frame = (JFrame) SwingUtilities.getWindowAncestor( sqp );
						frame.setEnabled( false);
					}
				}
			}
		});

		//adding action listener to C button
		buttonC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if(event.getSource()==buttonC){
					
					System.out.println("Location: " + location + " \nAnswer: " + answer ); 
					
					if ( answer.equals("C"))
					{
						System.out.println( "CORRECT!");
					//	isCorrect = JOptionPane.showOptionDialog(null, "You answered correctly and gained prize!", "Correct!", JOptionPane.DEFAULT_OPTION,
					//	       JOptionPane.INFORMATION_MESSAGE, null, null, null);
						winFrame.setVisible(true);
						chrono.stop();
						countDown.setIcon( null);
						stopBackgroundMusic();
						JFrame frame = (JFrame) SwingUtilities.getWindowAncestor( sqp );
						frame.setEnabled( false);
						startWinMusic();
						if ( s.equals("CarboxylicAcid") )
						{
							stats.addCoins( 20 * counter);
							stats.addCrystal( 1 * counter);
							curPanel.update( stats);
							//mainCurrency = ((HydrocarbonSlotsPanel) j).getCurrencyPanel();
							//mainCurrency.repaint();
						}
						
						else if ( s.equals("AlcoholEther" ))
						{
							stats.addCoins( ALCOHOLETHER_COIN_GAIN_AMOUNT * counter);
							stats.addCrystal( ALCOHOLETHER_CRYSTAL_GAIN_AMOUNT * counter);
							curPanel.update( stats);							
						}
						else if ( s.equals("Hydrocarbon" ))
						{
							stats.addCoins( HYDROCARBON_COIN_GAIN_AMOUNT * counter);
							stats.addCrystal( HYDROCARBON_CRYSTAL_GAIN_AMOUNT * counter);
							curPanel.update( stats);							
						}		
						
						else if ( s.equals("AldeKet" ))
						{
							stats.addCoins( ALDEKET_COIN_GAIN_AMOUNT * counter);
							stats.addCrystal( ALDEKET_CRYSTAL_GAIN_AMOUNT * counter);
							curPanel.update( stats);							
						}
						
					}
					else
					{
						answerButton = new File("sounds/gameover.wav");

						try {
							createAnswerButton = AudioSystem
									.getAudioInputStream(answerButton);
							try {
								startAnswerButton = AudioSystem.getClip();

							} catch (LineUnavailableException e) {

								e.printStackTrace();
							}
						} catch (UnsupportedAudioFileException e) {

							e.printStackTrace();
						} catch (IOException e) {

							e.printStackTrace();
						}

						try {
							startAnswerButton.open(createAnswerButton);
						} catch (LineUnavailableException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						startAnswerButton.start();
						System.out.println( "FALSE!");
					//	isCorrect = JOptionPane.showOptionDialog(null, "Wrong answer :( It was " + answer , "Wrong", JOptionPane.DEFAULT_OPTION,
					//	        JOptionPane.INFORMATION_MESSAGE, null, null, null);
						loseFrame.setVisible(true);
						chrono.stop();
						countDown.setIcon( null);

						JFrame frame = (JFrame) SwingUtilities.getWindowAncestor( sqp );
						frame.setEnabled( false);						
					}					
				}
			}
		});
		
		//adding action listener to D button
		buttonD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if(event.getSource()==buttonD){
					
					System.out.println("Location: " + location + " \nAnswer: " + answer ); 
					
					if ( answer.equals("D"))
					{
						System.out.println( "CORRECT!");
					//	isCorrect = JOptionPane.showOptionDialog(null,  "You answered correctly and gained prize!", "Correct!",JOptionPane.DEFAULT_OPTION,
					//	        JOptionPane.INFORMATION_MESSAGE, null, null, null);
						winFrame.setVisible(true);
						chrono.stop();
						countDown.setIcon( null);
						stopBackgroundMusic();
						JFrame frame = (JFrame) SwingUtilities.getWindowAncestor( sqp );
						frame.setEnabled( false);
						startWinMusic();
						if ( s.equals("CarboxylicAcid") )
						{
							stats.addCoins( 20 * counter);
							stats.addCrystal( 1 * counter);
							curPanel.update( stats);
							//mainCurrency = ((HydrocarbonSlotsPanel) j).getCurrencyPanel();
							//mainCurrency.repaint();
						}
						
						else if ( s.equals("AlcoholEther" ))
						{
							stats.addCoins( ALCOHOLETHER_COIN_GAIN_AMOUNT * counter);
							stats.addCrystal( ALCOHOLETHER_CRYSTAL_GAIN_AMOUNT * counter);
							curPanel.update( stats);							
						}
						else if ( s.equals("Hydrocarbon" ))
						{
							stats.addCoins( HYDROCARBON_COIN_GAIN_AMOUNT * counter);
							stats.addCrystal( HYDROCARBON_CRYSTAL_GAIN_AMOUNT * counter);
							curPanel.update( stats);							
						}		
						
						else if ( s.equals("AldeKet" ))
						{
							stats.addCoins( ALDEKET_COIN_GAIN_AMOUNT * counter);
							stats.addCrystal( ALDEKET_CRYSTAL_GAIN_AMOUNT * counter);
							curPanel.update( stats);							
						}
						
						
					}
					else
					{
						answerButton = new File("sounds/gameover.wav");

						try {
							createAnswerButton = AudioSystem
									.getAudioInputStream(answerButton);
							try {
								startAnswerButton = AudioSystem.getClip();

							} catch (LineUnavailableException e) {

								e.printStackTrace();
							}
						} catch (UnsupportedAudioFileException e) {

							e.printStackTrace();
						} catch (IOException e) {

							e.printStackTrace();
						}

						try {
							startAnswerButton.open(createAnswerButton);
						} catch (LineUnavailableException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						startAnswerButton.start();
						System.out.println( "FALSE!");
					//	isCorrect = JOptionPane.showOptionDialog(null, "Wrong answer :( It was " + answer , "Wrong", JOptionPane.DEFAULT_OPTION,
					//	        JOptionPane.INFORMATION_MESSAGE, null, null, null);
						loseFrame.setVisible(true);
						chrono.stop();
						countDown.setIcon( null);
						
						JFrame frame = (JFrame) SwingUtilities.getWindowAncestor( sqp );
						frame.setEnabled( false);
					}
					

				}
			}
		});		

		//adding action listener to E button
		buttonE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if(event.getSource()==buttonE){
				
					System.out.println("Location: " + location + " \nAnswer: " + answer ); 
					
					if ( answer.equals("E"))
					{
						System.out.println( "CORRECT!");
					//	isCorrect = JOptionPane.showOptionDialog(null, "You answered correctly and gained prize!", "Correct!", JOptionPane.DEFAULT_OPTION,
					//	        JOptionPane.INFORMATION_MESSAGE, null, null, null);
						winFrame.setVisible(true);
						chrono.stop();
						countDown.setIcon( null);
						stopBackgroundMusic();
						JFrame frame = (JFrame) SwingUtilities.getWindowAncestor( sqp );
						frame.setEnabled( false);
						startWinMusic();
						if ( s.equals("CarboxylicAcid") )
						{
							stats.addCoins( 20 * counter);
							stats.addCrystal( 1 * counter);
							curPanel.update( stats);
							//mainCurrency = ((HydrocarbonSlotsPanel) j).getCurrencyPanel();
							//mainCurrency.repaint();
						}
						
						else if ( s.equals("AlcoholEther" ))
						{
							stats.addCoins( ALCOHOLETHER_COIN_GAIN_AMOUNT * counter);
							stats.addCrystal( ALCOHOLETHER_CRYSTAL_GAIN_AMOUNT * counter);
							curPanel.update( stats);							
						}
						else if ( s.equals("Hydrocarbon" ))
						{
							stats.addCoins( HYDROCARBON_COIN_GAIN_AMOUNT * counter);
							stats.addCrystal( HYDROCARBON_CRYSTAL_GAIN_AMOUNT * counter);
							curPanel.update( stats);							
						}		
						
						else if ( s.equals("AldeKet" ))
						{
							stats.addCoins( ALDEKET_COIN_GAIN_AMOUNT * counter);
							stats.addCrystal( ALDEKET_CRYSTAL_GAIN_AMOUNT * counter);
							curPanel.update( stats);							
						}
						
					}
					else
					{
						answerButton = new File("sounds/gameover.wav");

						try {
							createAnswerButton = AudioSystem
									.getAudioInputStream(answerButton);
							try {
								startAnswerButton = AudioSystem.getClip();

							} catch (LineUnavailableException e) {

								e.printStackTrace();
							}
						} catch (UnsupportedAudioFileException e) {

							e.printStackTrace();
						} catch (IOException e) {

							e.printStackTrace();
						}

						try {
							startAnswerButton.open(createAnswerButton);
						} catch (LineUnavailableException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						startAnswerButton.start();
						System.out.println( "FALSE!");
					//	isCorrect = JOptionPane.showOptionDialog(null, "Wrong answer :( It was " + answer , "Wrong", JOptionPane.DEFAULT_OPTION,
					//	        JOptionPane.INFORMATION_MESSAGE, null, null, null);
						loseFrame.setVisible(true);
						chrono.stop();
						countDown.setIcon( null);
						
						JFrame frame = (JFrame) SwingUtilities.getWindowAncestor( sqp );
						frame.setEnabled( false);
					}
					
				//	if ( isCorrect == 0 )
				//	{
				//		JFrame frame = (JFrame) SwingUtilities.getWindowAncestor( sqp );
				//		frame.dispose();
				//	}
				}
			}
		});		
		
		add(panel);
//		timeLabel.setBounds(690, 11, 100, 46);
//		add(timeLabel);		
	}
	
	private class countDownListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
		
			System.out.println( "Time is up!");
			countDown.setIcon( null);
			
			chrono.stop();			
			//int timer =JOptionPane.showOptionDialog(null, "OUT OF TIME!!!!!!", " You are out of time!", JOptionPane.DEFAULT_OPTION,
			//		JOptionPane.INFORMATION_MESSAGE, null, null, null);
			noTimeLeftFrame.setVisible(true);
			
			JFrame frame = (JFrame) SwingUtilities.getWindowAncestor( sqp );
			frame.setEnabled( false);
			
			int timer =0;		
			
			SlotsQuestionPanel.stopBackgroundMusic();
				
			if( timer == 0)
			{				
				frame = (JFrame) SwingUtilities.getWindowAncestor( sqp );
				frame.dispose();
			}
		}
	}
	public void paintComponent( Graphics g)
	{
		super.paintComponent( g);		

		background = new ImageIcon( "images/backgrounds/backgroundq01.png" ).getImage();
		
		g.drawImage( background, 0, 0, null);
		
		// Print the question 
		panel.getGraphics().drawImage( new ImageIcon( location ).getImage(), 0, 0, null );

	}
	
	public int getCorrect()
	{
		return isCorrect;
	}
	
	public SlotsQuestionPanel getPanel()
	{
		return this;
	}
	
	public void updateStats()
	{
		
	}
	
	public void startTimer()
	{
		chrono.start();
	}
	
	public static void startWinMusic(){
		
		File backgroundSound = new File("sounds/slotswin.wav");
		AudioInputStream createBackgroundSound = null;
		Clip startBackgroundSound = null;

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
	}
	
	public static void stopBackgroundMusic() {
		if (startBackgroundSound != null && startBackgroundSound.isRunning())
			startBackgroundSound.stop();
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
	
	
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if(event.getSource()== okButton){
				JFrame frame = (JFrame) SwingUtilities.getWindowAncestor( sqp );
				
				frame.dispose();
				
				winFrame.setVisible(false);
			SlotsQuestionPanel.stopBackgroundMusic();	
			}
			if(event.getSource()== okButton2){
				JFrame frame = (JFrame) SwingUtilities.getWindowAncestor( sqp );
				
				frame.dispose();
				
				loseFrame.setVisible(false);
				SlotsQuestionPanel.stopBackgroundMusic();	}
			if(event.getSource()== okButton3){
				JFrame frame = (JFrame) SwingUtilities.getWindowAncestor( sqp );
				
				frame.dispose();
				
				noTimeLeftFrame.setVisible(false);
				SlotsQuestionPanel.stopBackgroundMusic();	}				
				
				repaint();
				
			}
				
		}
		
	

	private class AnswerListener extends MouseAdapter{
	public void MouseMoved(MouseEvent event){
	if(event.getSource()==buttonA){
		answerSelected = new File("sounds/answerSelect.wav");

		try {
			createAnswerSelected = AudioSystem
					.getAudioInputStream(answerSelected);
			try {
				startAnswerSelected = AudioSystem.getClip();

			} catch (LineUnavailableException e) {

				e.printStackTrace();
			}
		} catch (UnsupportedAudioFileException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		try {
			startAnswerSelected.open(createAnswerSelected);
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		startAnswerSelected.start();
	}
		
	}
		
	}
}

