/*
 * by H�seyin BEYAN
 * vers 1.0   28.04.2015
 * 
 * This panel will allow us to switch between different panels of the game
 */

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;


public class MainPanel extends JPanel {
	
	private CardLayout cl;
	
	private WelcomePanel wel;
	private PlayPanel play;
	private SlotsPanel slots;
	private MenuPanel menu;
	private HelpPanel help ;
	private StatisticsPanel stat ;
	private OptionsPanel opt;
	private SlotsQuestionPanel sqp;
	private CoinGeneratorPanel cgp;
	private HydrocarbonSlotsPanel hydro;
	private AlcoholEtherSlotsPanel alco;
	private AldehydeKetoneSlotsPanel alde;
	private CarboxylicAcidSlotsPanel carbox;
	private SlotsHelpPanel shp;
	private Statistics statistics;
	
	private JPanel last;
	
	JPanel[] array;
	
	public MainPanel() {	
		
		statistics = new Statistics();
		setBounds( 0, 0, 800, 600);
		setLayout( null);				
		setFocusable(true);
		requestFocusInWindow();
		
		wel = new WelcomePanel();
		wel.setVisible( true);
		add(wel);
		
		play = new PlayPanel();
		play.setVisible( false);
		add( play);
		
		opt = new OptionsPanel();
		opt.setVisible( false);
		add( opt);
		
		slots = new SlotsPanel();
		slots.setVisible( false);
		add( slots);		
		
		help = new HelpPanel();
		help.setVisible( false);
		add( help);	
		
		stat = new StatisticsPanel();
		stat.setVisible( false);
		add( stat);	
		
		menu = new MenuPanel();
		menu.setVisible( false);
		add( menu);	
		
		hydro = new HydrocarbonSlotsPanel( statistics );
		hydro.setVisible( false);
		add( hydro);	
		
		alco = new AlcoholEtherSlotsPanel( statistics );
		alco.setVisible( false);
		add( alco);
		
		alde = new AldehydeKetoneSlotsPanel( statistics );
		alde.setVisible( false);
		add( alde);		
		
		carbox = new CarboxylicAcidSlotsPanel( statistics );
		carbox.setVisible( false);
		add( carbox);
		
		cgp = new CoinGeneratorPanel();
		cgp.setVisible( false );
		add( cgp );		
		
		shp = new SlotsHelpPanel();
		shp.setVisible( false );
		add( shp );
		
		
		
		
		
		addKeyListener( new MyKeyListener());	
		
		//getInputMap().put(KeyStroke.getKeyStroke("ESCAPE"), "pressed");		
		//getActionMap().put("pressed", new MyAction());
		
		wel.addComponentListener(new ComponentAdapter() {			
			public void componentHidden(ComponentEvent e) {
				if( wel.getNext().equals("help"))
				{
					help.setVisible( true);
				}
				if( wel.getNext().equals("play"))
					play.setVisible( true);
				if( wel.getNext().equals("options"))
					opt.setVisible( true);
			}
		});
		
		opt.addComponentListener(new ComponentAdapter() {			
			public void componentHidden(ComponentEvent e) {
				wel.setVisible( true);
			}
		});
		
		help.addComponentListener(new ComponentAdapter() {			
			public void componentHidden(ComponentEvent e) {
				help.reset();
				wel.setVisible( true);
			}
		});
		
		shp.addComponentListener(new ComponentAdapter() {			
			public void componentHidden(ComponentEvent e) {
				help.reset();
				menu.setVisible( true);
			}
		});
		
		play.addComponentListener(new ComponentAdapter() {			
			public void componentHidden(ComponentEvent e) {
				if( play.getNext().equals("slots"))
				{
					slots.setVisible( true);
				}
				if( play.getNext().equals("coinGen"))
				{
					cgp.setVisible( true);
				}
				if( play.getNext().equals("back"))
					wel.setVisible( true);
			}
		});
		
		slots.addComponentListener(new ComponentAdapter() {			
			public void componentHidden(ComponentEvent e) {
				if( slots.getNext().equals("wel"))
				{
					wel.setVisible( true);
				}
				if( slots.getNext().equals("help"))
					help.setVisible( true);	
				
				if( slots.getNext().equals("hydrocarbons"))
				{
					hydro.setVisible( true);
				}
				if( slots.getNext().equals("alcohols"))
				{
					alco.setVisible( true);
				}
				
				if( slots.getNext().equals("aldehydes"))
				{
					alde.setVisible( true);
				}
				
				if( slots.getNext().equals("carboxacids"))
				{
					carbox.setVisible( true);
				}
			}
		});	
		
		menu.addComponentListener(new ComponentAdapter() {			
			public void componentHidden(ComponentEvent e) {
				if( menu.getNext().equals("cont"))
				{
					last.setVisible( true);
				}
				if( menu.getNext().equals("wel"))
					wel.setVisible( true);
				
				if( menu.getNext().equals("help"))
					shp.setVisible( true);
			}
		});
		
	}
	
	private class MyKeyListener implements KeyListener
	{	
		public void keyPressed(KeyEvent e) {
			if( e.getKeyCode() == KeyEvent.VK_ESCAPE && slots.isVisible())
			{
				slots.setVisible( false);
				menu.setVisible( true);
				
				last = slots;
			}
			
			if( e.getKeyCode() == KeyEvent.VK_ESCAPE && hydro.isVisible())
			{
				hydro.setVisible( false);
				menu.setVisible( true);
				
				last = hydro;
			}
			
			if( e.getKeyCode() == KeyEvent.VK_ESCAPE && alco.isVisible())
			{
				alco.setVisible( false);
				menu.setVisible( true);
				
				last = alco;
			}
			
			if( e.getKeyCode() == KeyEvent.VK_ESCAPE && alde.isVisible())
			{
				alde.setVisible( false);
				menu.setVisible( true);
				
				last = alde;
			}
			
			if( e.getKeyCode() == KeyEvent.VK_ESCAPE && carbox.isVisible())
			{
				carbox.setVisible( false);
				menu.setVisible( true);
				
				last = carbox;
			}
			if( e.getKeyCode() == KeyEvent.VK_ESCAPE && cgp.isVisible())
			{
				cgp.setVisible( false);
				menu.setVisible( true);
				
				last = cgp;
			}			
			
		}

		public void keyReleased(KeyEvent arg0) {}
		public void keyTyped(KeyEvent arg0) {}		
	}
	
	private class MyAction extends AbstractAction
	{
		public void actionPerformed(ActionEvent arg0) {
			slots.setVisible( false);
			menu.setVisible( true);			
		}		
	}
	
}
