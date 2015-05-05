/* * 
by Hüseyin BEYAN
 * vers 1.0   28.04.2015
 * 
 * Panel to show menu page of our project
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MenuPanel extends JPanel {

	private Image background;
	private String next;
	
	public MenuPanel() 
	{
		setVisible( true);				
		setBounds( 0,0, 800, 600);		
		setLayout(null);		
		
		next = "";
		
		ProjectButton contLabel = new ProjectButton("CONTINUE");
		contLabel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible( false);
				next = "cont";
			}
		});
		contLabel.setBounds(250, 300, 300, 50);
		add(contLabel);
		
		ProjectButton button = new ProjectButton("BACK TO MAIN MENU");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible( false);
				next = "wel";
			}
		});
		button.setBounds(250, 360, 300, 50);
		add(button);
		
		ProjectButton helpButton = new ProjectButton("HELP");
		helpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible( false);
				next = "help";
			}
		});
		helpButton.setBounds(250, 420, 300, 50);
		add(helpButton);
		
		ProjectButton exitButton = new ProjectButton("EXIT");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit( 0);
			}
		});
		exitButton.setBounds(250, 480, 300, 50);
		add(exitButton);
		
		CurrencyPanelBig cur = new CurrencyPanelBig( 100, 4);
		cur.setBounds( 300, 180, 200, 100);
		add( cur);
		
		JLabel titleLabel = new JLabel("");
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		titleLabel.setBounds(290, 60, 220, 100);
		titleLabel.setIcon( new ImageIcon( "images\\menu.png"));
		add(titleLabel);
		
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
