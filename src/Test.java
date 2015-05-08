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
		
		
		Statistics stats = new Statistics();
		
		WelcomePanel wel = new WelcomePanel( stats);
		
		PlayPanel play = new PlayPanel( stats);
		
		SlotsPanel slots = new SlotsPanel( stats);
		
		MenuPanel menu = new MenuPanel( stats);
		
		HelpPanel help = new HelpPanel( stats);
		
		StatisticsPanel stat = new StatisticsPanel( stats);
		
		SlotsQuestionPanel panel = new SlotsQuestionPanel("HydroCarbon", play,  new Statistics(), 1 );	
		
		
		MainPanel main = new MainPanel();
		
		JFrame frame = new JFrame( "Slots Quiz");		
		
		//frame.getContentPane().add( wel);
		//frame.getContentPane().add( play);	
		//frame.getContentPane().add( slots);	
		//frame.getContentPane().add( menu);	
		//frame.getContentPane().add( help);
		//frame.getContentPane().add( stat);
		frame.getContentPane().add( main);
		//frame.getContentPane().add( panel);
		
		
		frame.setVisible( true);
		
		frame.setBounds(0,0,800,600);
		frame.setResizable( false);

	}

}
