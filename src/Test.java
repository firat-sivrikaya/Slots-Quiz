/*
 * by H�seyin BEYAN
 * vers 1.0   22.04.2015
 * 
 * This class contains a main method to test the appearence of the designed Panels
 */

import java.awt.*;
import javax.swing.*;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WelcomePanel wel = new WelcomePanel();
		
		PlayPanel play = new PlayPanel();
		
		SlotsPanel slots = new SlotsPanel();
		
		MenuPanel menu = new MenuPanel();
		
		HelpPanel help = new HelpPanel();
		
		StatisticsPanel stat = new StatisticsPanel();
		
		


		
		
		
		MainPanel main = new MainPanel();
		
		JFrame frame = new JFrame( "Slots Quiz");		
		
		//frame.getContentPane().add( wel);
		//frame.getContentPane().add( play);	
		//frame.getContentPane().add( slots);	
		//frame.getContentPane().add( menu);	
		//frame.getContentPane().add( help);
		//frame.getContentPane().add( stat);
		frame.getContentPane().add( main);
		
		
		frame.setVisible( true);
		
		frame.setBounds(0,0,800,600);
		frame.setResizable( false);

	}

}
