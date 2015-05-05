/* @author Gokce Sakir Ozyurt
 * Question Class
 */

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

	

	private CurrencyPanel curPanel;
	private Image background;
	private JButton buttonA;
	private JButton buttonB;
	private JButton buttonC;
	private JButton buttonD;
	private JButton buttonE;
	private JLabel timeLabel;

	
	public CoinGeneratorPanel() {
		
		
	
		
		//Panel has to be 800* 600
		this.setVisible( true);				
		this.setBounds( 0,0, 800, 600);
		this.setFocusable(false);
		this.requestFocusInWindow();
		
		//In order to move the necessary components
		setLayout(null);
		
		
		
		
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
		
		//adding action listener to A button
		buttonA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==buttonA){
					//TODO 
				}
			}
		});
		
		//settings for B Button
		buttonB.setBounds(180, 497, 110, 35);
		add(buttonB);
		
		//adding action listener to B button
		buttonB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==buttonB){
					//TODO 
				}
			}
		});
		
		//settings for C button
		buttonC.setBounds(340, 497, 110, 35);
		add(buttonC);
		
		//adding action listener to C button
		buttonC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==buttonC){
					//TODO 
				}
			}
		});
		
		//settings for D button
		buttonD.setBounds(500, 497, 110, 35);
		add(buttonD);
		
		//adding action listener to D button
		buttonD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(e.getSource()==buttonD){
			//TODO 	
			}
			
			}});
		
		//settings for E button
		buttonE.setBounds(660, 497, 110, 35);
		add(buttonE);
		
		JPanel panel = new JPanel();
		panel.setBounds(48, 32, 704, 411);
		add(panel);
		

		timeLabel.setBounds(690, 11, 100, 46);
		add(timeLabel);
		
		//adding action listener to E button
		buttonE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(e.getSource()==buttonE){
			//TODO 
			}
			
			}});
		
	}
	
	public void paintComponent( Graphics g)
	{
		super.paintComponent( g);		

		background = new ImageIcon( "images\\background.png" ).getImage();
		
		g.drawImage( background, 0, 0, null);		
	}
}

