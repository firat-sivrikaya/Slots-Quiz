/**
 * CoinGeneratorPanel
 * @author Gokce Sakir Ozyurt
 * @author Firat Sivrikaya
 * @date   09/05/2015
 * 
 * This is the panel class for questions that are asked in slots. 
 */
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

import javax.swing.JLabel;


public class SlotsQuestionPanel extends JPanel {

	final private int COIN_GAIN_AMOUNT = 20;
	final private int CRYSTAL_GAIN_AMOUNT = 1;
	
	// properties
	private SlotsQuestionPanel sqp;
	private CurrencyPanel curPanel;
	private Image background;
	private ProjectButton buttonA;
	private ProjectButton buttonB;
	private ProjectButton buttonC;
	private ProjectButton buttonD;
	private ProjectButton buttonE;
	private JLabel timeLabel;
	private JPanel panel;
	private JPanel slotspanel;
	private String answer;
	private String location;
	private int isCorrect;
	private JFrame frame;
	private Statistics stats;
	private CurrencyPanel mainCurrency;
	
	private int counter;
	// constructors 
	
	public SlotsQuestionPanel( String s, JPanel j, Statistics statistics, int counter ) {
		stats = statistics;
		slotspanel = j;
		
		mainCurrency = null;
		
		sqp = this;
		isCorrect = 1;
		
		 this.counter = counter;
		
		// Initialize question panel
		panel = new JPanel();
		panel.setBounds(48, 62, 700, 350);
		panel.setPreferredSize( new Dimension(700, 350));
		
		frame = new JFrame("Question");
		frame.setVisible( false );
		frame.setBounds(400, 400, 800, 600);
		
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
		}
		
		else if ( s.equals("AlcoholEther") )
		{
			AlcoholEtherS slots = new AlcoholEtherS();
			Question q = slots.askQuestion();
			answer = q.getAnswer();
			location = q.getLocation();
		}
		
		else if ( s.equals("AldeKet") )
		{
			AldeKetS slots = new AldeKetS();
			Question q = slots.askQuestion();
			answer = q.getAnswer();
			location = q.getLocation();
		}
		
		else if ( s.equals("CarboxylicAcid") )
		{
			CarboxylicAcidS slots = new CarboxylicAcidS();
			Question q = slots.askQuestion();
			answer = q.getAnswer();
			location = q.getLocation();	
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
						// Popup info pane
						isCorrect = JOptionPane.showOptionDialog(null, "You answered correctly and gained prize!", "Correct!",JOptionPane.DEFAULT_OPTION,
						        JOptionPane.INFORMATION_MESSAGE, null, null, null);
						
						if ( s.equals("CarboxylicAcid") )
						{
							// Add prizes to stats
							stats.addCoins( COIN_GAIN_AMOUNT * counter);
							stats.addCrystal( CRYSTAL_GAIN_AMOUNT * counter);
							// Update stats
							curPanel.update( stats);
						}
						
					}
					else
					{
						System.out.println( "FALSE!");
						// Popup info pane
						isCorrect = JOptionPane.showOptionDialog(null, "Wrong answer :( It was " + answer, "Wrong", JOptionPane.DEFAULT_OPTION,
						        JOptionPane.INFORMATION_MESSAGE, null, null, null);
					}
					// If the button in popup clicked, close the frame
					if ( isCorrect == 0 )
					{
						JFrame frame = (JFrame) SwingUtilities.getWindowAncestor( sqp );						
						frame.dispose();
					}			
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
						// Popup info pane
						isCorrect = JOptionPane.showOptionDialog(null, "You answered correctly and gained prize!", "Correct!",JOptionPane.DEFAULT_OPTION,
						        JOptionPane.INFORMATION_MESSAGE, null, null, null);
						
						if ( s.equals("CarboxylicAcid") )
						{
							// Add prizes to stats
							stats.addCoins( COIN_GAIN_AMOUNT * counter);
							stats.addCrystal( CRYSTAL_GAIN_AMOUNT * counter);
							// Update stats
							curPanel.update( stats);
						}
						
					}
					else
					{
						System.out.println( "FALSE!");
						// Popup info pane
						isCorrect = JOptionPane.showOptionDialog(null, "Wrong answer :( It was " + answer, "Wrong", JOptionPane.DEFAULT_OPTION,
						        JOptionPane.INFORMATION_MESSAGE, null, null, null);
					}
					// If the button in popup clicked, close the frame
					if ( isCorrect == 0 )
					{
						JFrame frame = (JFrame) SwingUtilities.getWindowAncestor( sqp );						
						frame.dispose();
					}
				}
			}
		});

		//adding action listener to C button
		buttonC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==buttonC){
					if ( answer.equals("C"))
					{
						System.out.println( "CORRECT!");
						// Popup info pane
						isCorrect = JOptionPane.showOptionDialog(null, "You answered correctly and gained prize!", "Correct!",JOptionPane.DEFAULT_OPTION,
						        JOptionPane.INFORMATION_MESSAGE, null, null, null);
						
						if ( s.equals("CarboxylicAcid") )
						{
							// Add prizes to stats
							stats.addCoins( COIN_GAIN_AMOUNT * counter);
							stats.addCrystal( CRYSTAL_GAIN_AMOUNT * counter);
							// Update stats
							curPanel.update( stats);
						}
						
					}
					else
					{
						System.out.println( "FALSE!");
						// Popup info pane
						isCorrect = JOptionPane.showOptionDialog(null, "Wrong answer :( It was " + answer, "Wrong", JOptionPane.DEFAULT_OPTION,
						        JOptionPane.INFORMATION_MESSAGE, null, null, null);
					}
					// If the button in popup clicked, close the frame
					if ( isCorrect == 0 )
					{
						JFrame frame = (JFrame) SwingUtilities.getWindowAncestor( sqp );						
						frame.dispose();
					}
				}
			}
		});
		
		//adding action listener to D button
		buttonD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==buttonD){
					if ( answer.equals("D"))
					{
						System.out.println( "CORRECT!");
						// Popup info pane
						isCorrect = JOptionPane.showOptionDialog(null, "You answered correctly and gained prize!", "Correct!",JOptionPane.DEFAULT_OPTION,
						        JOptionPane.INFORMATION_MESSAGE, null, null, null);
						
						if ( s.equals("CarboxylicAcid") )
						{
							// Add prizes to stats
							stats.addCoins( COIN_GAIN_AMOUNT * counter);
							stats.addCrystal( CRYSTAL_GAIN_AMOUNT * counter);
							// Update stats
							curPanel.update( stats);
						}
						
					}
					else
					{
						System.out.println( "FALSE!");
						// Popup info pane
						isCorrect = JOptionPane.showOptionDialog(null, "Wrong answer :( It was " + answer, "Wrong", JOptionPane.DEFAULT_OPTION,
						        JOptionPane.INFORMATION_MESSAGE, null, null, null);
					}
					// If the button in popup clicked, close the frame
					if ( isCorrect == 0 )
					{
						JFrame frame = (JFrame) SwingUtilities.getWindowAncestor( sqp );						
						frame.dispose();
					}		
				}
			}
		});		

		//adding action listener to E button
		buttonE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==buttonE){
					if ( answer.equals("E"))
					{
						System.out.println( "CORRECT!");
						// Popup info pane
						isCorrect = JOptionPane.showOptionDialog(null, "You answered correctly and gained prize!", "Correct!",JOptionPane.DEFAULT_OPTION,
						        JOptionPane.INFORMATION_MESSAGE, null, null, null);
						
						if ( s.equals("CarboxylicAcid") )
						{
							// Add prizes to stats
							stats.addCoins( COIN_GAIN_AMOUNT * counter);
							stats.addCrystal( CRYSTAL_GAIN_AMOUNT * counter);
							// Update stats
							curPanel.update( stats);
						}
						
					}
					else
					{
						System.out.println( "FALSE!");
						// Popup info pane
						isCorrect = JOptionPane.showOptionDialog(null, "Wrong answer :( It was " + answer, "Wrong", JOptionPane.DEFAULT_OPTION,
						        JOptionPane.INFORMATION_MESSAGE, null, null, null);
					}
					// If the button in popup clicked, close the frame
					if ( isCorrect == 0 )
					{
						JFrame frame = (JFrame) SwingUtilities.getWindowAncestor( sqp );						
						frame.dispose();
					}
				}
			}
		});		
		
		add(panel);
		

		

		
	}
	
	public void paintComponent( Graphics g)
	{
		super.paintComponent( g);		

		background = new ImageIcon( "images/background.png" ).getImage();
		
		g.drawImage( background, 0, 0, null);
		
		// Print the question 
		panel.getGraphics().drawImage( new ImageIcon( location ).getImage(), 0, 0, null );
		System.out.println("Location: " + location + " \nAnswer: " + answer ); 
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
	
}

