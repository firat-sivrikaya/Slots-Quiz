/* * 
by Hüseyin BEYAN
 * vers 1.0   28.04.2015
 * 
 * Panel to show statistics page of our project
 */
import java.awt.*;
import javax.swing.*;


public class StatisticsPanel extends JPanel {

	private Image background;
	
	public StatisticsPanel() 
	{
		setVisible( true);				
		setBounds( 0,0, 800, 600);		
		setLayout(null);
		
		CurrencyPanelBig cur = new CurrencyPanelBig( 100, 4);
		cur.setBounds( 300, 157, 200, 100);
		add( cur);
		
		JLabel titleLabel = new JLabel("STATISTICS");
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		titleLabel.setBounds(322, 70, 163, 37);
		add(titleLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Opened Levels: ");
		lblNewLabel_1.setBounds(262, 448, 250, 37);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Total Coins Won:");
		lblNewLabel_2.setBounds(262, 334, 250, 37);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Total Crystals Won:");
		lblNewLabel_3.setBounds(262, 392, 238, 32);
		add(lblNewLabel_3);
	}
	
	public void paintComponent( Graphics g)
	{
		super.paintComponent( g);		

		background = new ImageIcon( "images\\background.png" ).getImage();
		
		g.drawImage( background, 0, 0, null);		
	}
}
