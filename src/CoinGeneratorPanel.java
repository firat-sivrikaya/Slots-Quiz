/**
 * CoinGeneratorPanel
 * @author Gokce Sakir Ozyurt
 * @author Firat Sivrikaya
 * @date   09/05/2015
 * 
 * This is the panel class for CoinGenerator. 
 */


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;


public class CoinGeneratorPanel extends JPanel {

	final private int COIN_GAIN_AMOUNT = 5;
	
	// properties
	private CurrencyPanel curPanel;
	private Image   background;
	private JButton buttonA;
	private JButton buttonB;
	private JButton buttonC;
	private JButton buttonD;
	private JButton buttonE;
	private JLabel timeLabel;
	private JPanel panel;
	private CoinGenerator question;
	private String answer;
	private String location;
	private Question q;
	private Statistics stats;
	
	// constructors
	public CoinGeneratorPanel( Statistics stats) {
		
		question = new CoinGenerator();		
		
		//Panel has to be 800* 600
		this.setVisible( true);				
		this.setBounds( 0,0, 800, 600);
		this.setFocusable(false);
		this.requestFocusInWindow();
		
		this.stats = stats;
		
		//In order to move the necessary components
		setLayout(null);
		
		// Get the question from database
		q = question.askQuestion();
		answer = q.getAnswer();
		location = q.getLocation();	
		System.out.println( "Location: " + location + "\n Answer: " + answer );
		
		
		//Currency panel at the top left corner.
		curPanel = new CurrencyPanel(stats);
		add(curPanel); 
		
		//Initializing the buttons
		buttonA = new JButton("A");
		buttonB = new JButton("B");
		buttonC = new JButton("C");
		buttonD = new JButton("D");
		buttonE = new JButton("E");
		
		// Set focusable
		buttonA.setFocusable( false );
		buttonB.setFocusable( false );
		buttonC.setFocusable( false );
		buttonD.setFocusable( false );
		buttonE.setFocusable( false );
	
		//settings for A button
		buttonA.setBounds(20, 497, 110, 35);
		add(buttonA);
		
		
		//settings for B Button
		buttonB.setBounds(180, 497, 110, 35);
		add(buttonB);
		
		
		//settings for C button
		buttonC.setBounds(340, 497, 110, 35);
		add(buttonC);
		

		
		//settings for D button
		buttonD.setBounds(500, 497, 110, 35);
		add(buttonD);
		

		
		//settings for E button
		buttonE.setBounds(660, 497, 110, 35);
		add(buttonE);
		
		//adding action listener to A button
		buttonA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==buttonA){
					if ( answer.equals("A"))
					{
						System.out.println( "CORRECT!");
						stats.addCoins( COIN_GAIN_AMOUNT );
						curPanel.update( stats);
					}
					else
						System.out.println( "FALSE!");
					
					q = question.askQuestion();
					answer = q.getAnswer();
					location = q.getLocation();
					repaint();
				}
			}
		});

		//adding action listener to B button
		buttonB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==buttonB){
					if ( answer.equals("B"))
					{
						System.out.println( "CORRECT!");
						stats.addCoins( COIN_GAIN_AMOUNT );
						curPanel.update( stats);
					}
					else
						System.out.println( "FALSE!");
					
					q = question.askQuestion();
					answer = q.getAnswer();
					location = q.getLocation();
					repaint();
				}
			}
		});

		//adding action listener to C button
		buttonC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==buttonC)
				{
					if ( answer.equals("C"))
					{
						stats.addCoins( COIN_GAIN_AMOUNT );
						curPanel.update( stats);
						System.out.println( "CORRECT!");
					}
					else
					{
						System.out.println( "FALSE!");
					}
					q = question.askQuestion();
					answer = q.getAnswer();
					location = q.getLocation();
					repaint();
				}
			}
		});
		
		//adding action listener to D button
		buttonD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==buttonD)
				{
					if ( answer.equals("D"))
					{
						System.out.println( "CORRECT!");
						stats.addCoins( COIN_GAIN_AMOUNT );
						curPanel.update( stats);
					}
					else
					{
						System.out.println( "FALSE!");
					}
					q = question.askQuestion();
					answer = q.getAnswer();
					location = q.getLocation();
					repaint();
				}
			}
		}
		);		

		//adding action listener to E button
		buttonE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==buttonE){
				
					if ( answer.equals("E"))
					{
						System.out.println( "CORRECT!");
						stats.addCoins( COIN_GAIN_AMOUNT );
						curPanel.update( stats);
					}
					else
						System.out.println( "FALSE!");
					
					q = question.askQuestion();
					answer = q.getAnswer();
					location = q.getLocation();
					repaint();
				}
			}
		}
		);
		
		
		
	}
	
	public void paintComponent( Graphics g)
	{
		super.paintComponent( g);		

		background = new ImageIcon( "images/background.png" ).getImage();
		
		g.drawImage( background, 0, 0, null);
		g.drawImage( new ImageIcon( location ).getImage(), 48, 62, 700, 350, null );
		System.out.println("Location: " + location + " \nAnswer: " + answer ); 
	}
	
	public void update( Statistics stats)
	{
		curPanel.update( stats);
	}
}

