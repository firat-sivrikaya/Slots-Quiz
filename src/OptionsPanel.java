import java.awt.Graphics;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;


public class OptionsPanel extends JPanel {

	//VARIABLES
	
	//image variables
	private Image background;
	
	//sound variables
    private File buttonSound2;	
	private AudioInputStream createButtonSound2;	
	private Clip startButtonSound2;	
	
	private ProjectButton backButton;
	private ProjectButton soundIcon;
	private ProjectButton resetButton;
	private Statistics stats;
	private CurrencyPanel curpanel;
	public OptionsPanel( Statistics stats)
	{
		// Get the slots panel instance to be able to update when reset
		Object[] options = {"Yeah!", "No"};
		
		setVisible( true);			
		setBounds( 0,0, 800, 600);
		setLayout(null);
		
		this.stats = stats;
		
		backButton = new ProjectButton("BACK");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if(event.getSource()==backButton){
					buttonSound2 = new File("sounds/slotSound.wav");
					
					try {
						createButtonSound2	 =  AudioSystem.getAudioInputStream(buttonSound2);
						try {
							startButtonSound2 = AudioSystem.getClip();
							
							
						} catch (LineUnavailableException e) {
							
							e.printStackTrace();
						}
					} catch (UnsupportedAudioFileException e) {
						  
						e.printStackTrace();
					} catch (IOException e) {
						
						e.printStackTrace();
					} 
					
					try {
						startButtonSound2.open(createButtonSound2);
					} catch (LineUnavailableException e) {
						// 
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					startButtonSound2.start();
				
					setVisible( false);
			   
				}
			}
		});
		
		ImageIcon on = new ImageIcon("images/soundIcon/Sound-on-icon.png");
		ImageIcon of = new ImageIcon("images/soundIcon/Sound-off-icon.png");
		
		soundIcon = new ProjectButton("soundOn");
		soundIcon.setIcon( on);
		soundIcon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
					
				if( event.getSource() == soundIcon && soundIcon.getIcon() == on)
				{
					SlotsQuestionPanel.stopBackgroundMusic();
					Test.stopBackgroundMusic();
					PlayPanel.stopBackgroundMusic();
					soundIcon.setIcon(of);		
				}							
			}
		});				
		
		resetButton = new ProjectButton("RESET");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
					
				if( event.getSource() == resetButton )
				{
					int choice;
					
					choice = JOptionPane.showOptionDialog( null, "Are you sure to reset?","Reset your progress", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,
						    new ImageIcon("images/resetIcon.png"),     			//do not use a custom Icon
						    options,  			//the titles of buttons
						    options[0]); 		//default button title
					
					if ( choice == JOptionPane.YES_OPTION )
					{
						stats.reset();
						JOptionPane.showMessageDialog(null, "You have successfully reset your progress!","Done!", JOptionPane.YES_OPTION, new ImageIcon("images/tick.png") );
						update( stats );
						JOptionPane.showMessageDialog(null,"Now, please restart your game to confirm the reset", "Done!", JOptionPane.YES_OPTION, new ImageIcon("images/tick.png"));
						try {
							stats.save();
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.exit(0);
					}
				}							
			}
		});		
		resetButton.setBounds(290, 65, 220, 60);
		add(resetButton);
		
		backButton.setBounds( 250, 400, 300, 50);
		add(backButton);	
		
		soundIcon.setBounds(272, 132,256,256);
		add(soundIcon);		
		
		curpanel = new CurrencyPanel( stats);
		add( curpanel);		
	}
	
	public void paintComponent( Graphics g)
	{
		super.paintComponent( g);		

		background = new ImageIcon( "images/background.png" ).getImage();
		
		g.drawImage( background, 0, 0, null);		
	}
	
	public void update( Statistics stats)
	{
		curpanel.update( stats);
	}
}
