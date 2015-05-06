/* @author Gokce Sakir Ozyurt
 * @author Firat Sivrikaya
 * Question Class
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
import java.sql.SQLException;

import javax.swing.JLabel;


public class SlotsQuestionPanel extends JPanel {

	

	private CurrencyPanel curPanel;
	private Image background;
	private JButton buttonA;
	private JButton buttonB;
	private JButton buttonC;
	private JButton buttonD;
	private JButton buttonE;
	private JLabel timeLabel;
	private JPanel panel;
	private String answer;
	private String location;
	
	public SlotsQuestionPanel( String s ) {
		
		// Initialize question panel
		panel = new JPanel();
		panel.setBounds(48, 62, 700, 350);
		panel.setPreferredSize( new Dimension(700, 350));
		
		
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
		
		
		// Print location and answer for test purpose
		System.out.println( "Location: " + location );
		System.out.println( "Answer: " + answer );		
		
		
		
		
		//Currency panel at the top left corner.
		curPanel = new CurrencyPanel(0,0);
		add(curPanel); 
		
		//Initializing the buttons
		buttonA = new JButton("A");
		buttonB = new JButton("B");
		buttonC = new JButton("C");
		buttonD = new JButton("D");
		buttonE = new JButton("E");
		
	
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
					}
					else
						System.out.println( "FALSE!");
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
					}
					else
						System.out.println( "FALSE!");
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
					}
					else
						System.out.println( "FALSE!");
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
					}
					else
						System.out.println( "FALSE!");
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
					}
					else
						System.out.println( "FALSE!");
				}
			}
		});
		

		
		
		
		
		
		add(panel);
		

//		timeLabel.setBounds(690, 11, 100, 46);
//		add(timeLabel);
		

		
	}
	
	public void paintComponent( Graphics g)
	{
		super.paintComponent( g);		

		background = new ImageIcon( "images/background.png" ).getImage();
		
		g.drawImage( background, 0, 0, null);
		
		// Print the question 
		panel.getGraphics().drawImage( new ImageIcon( location ).getImage(), 0, 0, null );
	}
}

