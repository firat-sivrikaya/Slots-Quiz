import java.awt.Graphics;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class OptionsPanel extends JPanel {

	//VARIABLES
	
	//image variables
	private Image background;
	
	//sound variables
    private File buttonSound2;
	
	
	private AudioInputStream createButtonSound2;
	
	
	private Clip startButtonSound2;
	
	private ProjectButton backButton;
	
	public OptionsPanel()
	{
		setVisible( true);			
		setBounds( 0,0, 800, 600);
		setLayout(null);
		
		backButton = new ProjectButton("BACK");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if(event.getSource()==backButton){
					buttonSound2 = new File("sounds\\slotSound.wav");
					
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
						// TODO Auto-generated catch block
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
				
				
				
		
		backButton.setBounds( 250, 400, 300, 50);
		add(backButton);

		CurrencyPanel curpanel = new CurrencyPanel( 200, 4);
		add( curpanel);	
	}
	
	public void paintComponent( Graphics g)
	{
		super.paintComponent( g);		

		background = new ImageIcon( "images\\background.png" ).getImage();
		
		g.drawImage( background, 0, 0, null);		
	}

}
