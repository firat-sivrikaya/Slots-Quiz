/*
 * by Hüseyin BEYAN
 * vers 1.0   28.04.2015
 * 
 * This panel is the same as the currency panel, however it is in larger size to be used in menu and statistics screens
 */

import java.awt.*;
import javax.swing.*;


public class CurrencyPanelBig extends JPanel {
	
	private int coin;	
	private int crystal;

	/**
	 * Create the panel.
	 */
	public CurrencyPanelBig( int coin, int crystal)
	{
		this.coin = coin;
		this.crystal = crystal;
		
		setLayout(null);
		
		setBounds( 0, 0, 200,100);
		
		setBorder(BorderFactory.createMatteBorder( 1, 1, 1, 1,Color.black));
		
		JLabel coinLabel = new JLabel( coin + "");
		coinLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		coinLabel.setBounds(57, 20, 58, 22);
		add(coinLabel);
		
		JLabel crysLabel = new JLabel( crystal + "");
		crysLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		crysLabel.setBounds(57, 60, 58, 29);
		add(crysLabel);
		
		JLabel coinPict = new JLabel("");
		coinPict.setIcon(new ImageIcon("images\\coinbig.png"));
		coinPict.setBounds(2, 2, 40, 47);
		add(coinPict);
		
		JLabel crysPict = new JLabel("");
		crysPict.setIcon(new ImageIcon("images\\crystalbig.png"));
		crysPict.setBounds(2, 52, 45, 45);
		add(crysPict);
		
		setBackground( Color.WHITE);

	}
	
	public void paintComponent( Graphics g)
	{
		super.paintComponent( g);
		
		g.drawLine(0, this.getHeight() / 2, this.getWidth(), this.getHeight() / 2);
		
		g.drawLine(this.getHeight() / 2, 0, this.getHeight() / 2,  this.getWidth() / 2);
	}
}