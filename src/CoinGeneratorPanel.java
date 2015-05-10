/* @author Gokce Sakir Ozyurt
 * Question Class
 */

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JLabel;




public class CoinGeneratorPanel extends JPanel {

	private CurrencyPanel curPanel;
	private Image background;	
	
	private ProjectButton aButton;
	private ProjectButton bButton;
	private ProjectButton cButton;
	private ProjectButton dButton;
	private ProjectButton eButton;
	
	private static File backgroundSound;
	private static AudioInputStream createBackgroundSound;
	private static Clip startBackgroundSound;
	
	private File answerButton;
	private AudioInputStream createAnswerButton;
	private Clip startAnswerButton;
	
	private File correctButton;
	private AudioInputStream createCorrectButton;
	private Clip startCorrectButton;

	private JPanel panel;
	private CoinGenerator question;
	private String answer;
	private String location;
	private Question q;
	private Statistics stats;
	
	public CoinGeneratorPanel( Statistics stats) {
		CoinGeneratorPanel.stopBackgroundMusic();
		
		question = new CoinGenerator();		
		
//		panel = new JPanel;
//		panel.setBounds(48, 62, 700, 350);
//		panel.setPreferredSize( new Dimension(700, 350));
		
		//Panel has to be 800* 600
		this.setVisible( true);				
		this.setBounds( 0,0, 800, 600);
		this.setFocusable(false);
		this.requestFocusInWindow();
		
		this.stats = stats;
		
		//In order to move the necessary components
		setLayout(null);
		
		// Get the question from database
		q = question.askQuestion();
		answer = q.getAnswer();
		location = q.getLocation();	
		System.out.println( "Location: " + location + "\n Answer: " + answer );
		
//		panel.setOpaque( false );
		
		//Currency panel at the top left corner.
		curPanel = new CurrencyPanel(stats);
		add(curPanel); 
		
		//Initializing the buttons
		aButton = new ProjectButton("A");
		bButton = new ProjectButton("B");
		cButton = new ProjectButton("C");
		dButton = new ProjectButton("D");
		eButton = new ProjectButton("E");		
		
		//settings for A button
		aButton.setBounds(40, 470, 70, 70);
		add(aButton);	
		
		//settings for B Button
		bButton.setBounds(200, 470, 70, 70);
		add(bButton);	
		
		//settings for C button
		cButton.setBounds(360, 470, 70, 70);
		add(cButton);
		
		//settings for D button
		dButton.setBounds(520, 470, 70, 70);
		add(dButton);
		
		
		//settings for E button
		eButton.setBounds(680, 470, 70, 70);
		add(eButton);
		
		aButton.setFocusable( false );
		bButton.setFocusable( false );
		cButton.setFocusable( false );
		dButton.setFocusable( false );
		eButton.setFocusable( false );
		
//		add( panel );
		
		//adding action listener to A button
		aButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if(event.getSource()==aButton){
					if ( answer.equals("A"))
					{
						correctButton = new File("sounds/correct.wav");

						try {
							createCorrectButton = AudioSystem
									.getAudioInputStream(correctButton);
							try {
								startCorrectButton = AudioSystem.getClip();

							} catch (LineUnavailableException e) {

								e.printStackTrace();
							}
						} catch (UnsupportedAudioFileException e) {

							e.printStackTrace();
						} catch (IOException e) {

							e.printStackTrace();
						}

						try {
							startCorrectButton.open(createCorrectButton);
						} catch (LineUnavailableException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						startCorrectButton.start();
						
						
						System.out.println( "CORRECT!");
						stats.addCoins( 5);
						curPanel.update( stats);
						repaint();
						
					}
					else{						
						
						System.out.println( "FALSE!");
						repaint();
						
						answerButton = new File("sounds/answerSelect.wav");

						try {
							createAnswerButton = AudioSystem
									.getAudioInputStream(answerButton);
							try {
								startAnswerButton = AudioSystem.getClip();

							} catch (LineUnavailableException e) {

								e.printStackTrace();
							}
						} catch (UnsupportedAudioFileException e) {

							e.printStackTrace();
						} catch (IOException e) {

							e.printStackTrace();
						}

						try {
							startAnswerButton.open(createAnswerButton);
						} catch (LineUnavailableException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						startAnswerButton.start();
						//isCorrect = JOptionPane.showOptionDialog(null, "Wrong answer :( It was " + answer, "Wrong", JOptionPane.DEFAULT_OPTION,
						//        JOptionPane.INFORMATION_MESSAGE, null, null, null);
						
					
					}
					
					q = question.askQuestion();
					answer = q.getAnswer();
					location = q.getLocation();
				
				}
			}
		});

		//adding action listener to B button
		bButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if(event.getSource()==bButton){
					if ( answer.equals("B"))
					{
						correctButton = new File("sounds/correct.wav");

						try {
							createCorrectButton = AudioSystem
									.getAudioInputStream(correctButton);
							try {
								startCorrectButton = AudioSystem.getClip();

							} catch (LineUnavailableException e) {

								e.printStackTrace();
							}
						} catch (UnsupportedAudioFileException e) {

							e.printStackTrace();
						} catch (IOException e) {

							e.printStackTrace();
						}

						try {
							startCorrectButton.open(createCorrectButton);
						} catch (LineUnavailableException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						startCorrectButton.start();
						System.out.println( "CORRECT!");
						stats.addCoins( 5);
						curPanel.update( stats);
						
					}
					else{
					
						System.out.println( "FALSE!");
						repaint();
						answerButton = new File("sounds/gameover.wav");
					

						try {
							createAnswerButton = AudioSystem
									.getAudioInputStream(answerButton);
							try {
								startAnswerButton = AudioSystem.getClip();

							} catch (LineUnavailableException e) {

								e.printStackTrace();
							}
						} catch (UnsupportedAudioFileException e) {

							e.printStackTrace();
						} catch (IOException e) {

							e.printStackTrace();
						}

						try {
							startAnswerButton.open(createAnswerButton);
						} catch (LineUnavailableException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						startAnswerButton.start();
						//isCorrect = JOptionPane.showOptionDialog(null, "Wrong answer :( It was " + answer, "Wrong", JOptionPane.DEFAULT_OPTION,
						//        JOptionPane.INFORMATION_MESSAGE, null, null, null);
						
					
					}
					
					q = question.askQuestion();
					answer = q.getAnswer();
					location = q.getLocation();
				
				}
			}
		});

		//adding action listener to C button
		cButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if(event.getSource()==cButton)
				{
					if ( answer.equals("C"))
					{
						correctButton = new File("sounds/correct.wav");

						try {
							createCorrectButton = AudioSystem
									.getAudioInputStream(correctButton);
							try {
								startCorrectButton = AudioSystem.getClip();

							} catch (LineUnavailableException e) {

								e.printStackTrace();
							}
						} catch (UnsupportedAudioFileException e) {

							e.printStackTrace();
						} catch (IOException e) {

							e.printStackTrace();
						}

						try {
							startCorrectButton.open(createCorrectButton);
						} catch (LineUnavailableException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						startCorrectButton.start();
						stats.addCoins( 5);
						curPanel.update( stats);
						System.out.println( "CORRECT!");
						repaint();
					}
					else
					{
					
						repaint();
						System.out.println( "FALSE!");
						
						answerButton = new File("sounds/gameover.wav");
					

						try {
							createAnswerButton = AudioSystem
									.getAudioInputStream(answerButton);
							try {
								startAnswerButton = AudioSystem.getClip();

							} catch (LineUnavailableException e) {

								e.printStackTrace();
							}
						} catch (UnsupportedAudioFileException e) {

							e.printStackTrace();
						} catch (IOException e) {

							e.printStackTrace();
						}

						try {
							startAnswerButton.open(createAnswerButton);
						} catch (LineUnavailableException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						startAnswerButton.start();
						//isCorrect = JOptionPane.showOptionDialog(null, "Wrong answer :( It was " + answer, "Wrong", JOptionPane.DEFAULT_OPTION,
						//        JOptionPane.INFORMATION_MESSAGE, null, null, null);
				
				
						
					}
					q = question.askQuestion();
					answer = q.getAnswer();
					location = q.getLocation();
				
				}
			}
		});
		
		//adding action listener to D button
		dButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if(event.getSource()==dButton)
				{
					if ( answer.equals("D"))
					{
						correctButton = new File("sounds/correct.wav");

						try {
							createCorrectButton = AudioSystem
									.getAudioInputStream(correctButton);
							try {
								startCorrectButton = AudioSystem.getClip();

							} catch (LineUnavailableException e) {

								e.printStackTrace();
							}
						} catch (UnsupportedAudioFileException e) {

							e.printStackTrace();
						} catch (IOException e) {

							e.printStackTrace();
						}

						try {
							startCorrectButton.open(createCorrectButton);
						} catch (LineUnavailableException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						startCorrectButton.start();
						System.out.println( "CORRECT!");
						stats.addCoins( 5);
						curPanel.update( stats);
					
					}
					else
					{
					
						repaint();
						System.out.println( "FALSE!");
					
						answerButton = new File("sounds/gameover.wav");
					

						try {
							createAnswerButton = AudioSystem
									.getAudioInputStream(answerButton);
							try {
								startAnswerButton = AudioSystem.getClip();

							} catch (LineUnavailableException e) {

								e.printStackTrace();
							}
						} catch (UnsupportedAudioFileException e) {

							e.printStackTrace();
						} catch (IOException e) {

							e.printStackTrace();
						}

						try {
							startAnswerButton.open(createAnswerButton);
						} catch (LineUnavailableException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						startAnswerButton.start();
						//isCorrect = JOptionPane.showOptionDialog(null, "Wrong answer :( It was " + answer, "Wrong", JOptionPane.DEFAULT_OPTION,
						//        JOptionPane.INFORMATION_MESSAGE, null, null, null);
						
						
					}
					q = question.askQuestion();
					answer = q.getAnswer();
					location = q.getLocation();
				
				}
			}
		}
		);		

		//adding action listener to E button
		eButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if(event.getSource()==eButton){
				
					if ( answer.equals("E"))
					{
						correctButton = new File("sounds/correct.wav");

						try {
							createCorrectButton = AudioSystem
									.getAudioInputStream(correctButton);
							try {
								startCorrectButton = AudioSystem.getClip();

							} catch (LineUnavailableException e) {

								e.printStackTrace();
							}
						} catch (UnsupportedAudioFileException e) {

							e.printStackTrace();
						} catch (IOException e) {

							e.printStackTrace();
						}

						try {
							startCorrectButton.open(createCorrectButton);
						} catch (LineUnavailableException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						startCorrectButton.start();
						System.out.println( "CORRECT!");
						stats.addCoins( 5);
						curPanel.update( stats);
					}
					else{
						
						repaint();
						System.out.println( "FALSE!");
					
						answerButton = new File("sounds/gameover.wav");
				

						try {
							createAnswerButton = AudioSystem
									.getAudioInputStream(answerButton);
							try {
								startAnswerButton = AudioSystem.getClip();

							} catch (LineUnavailableException e) {

								e.printStackTrace();
							}
						} catch (UnsupportedAudioFileException e) {

							e.printStackTrace();
						} catch (IOException e) {

							e.printStackTrace();
						}

						try {
							startAnswerButton.open(createAnswerButton);
						} catch (LineUnavailableException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						startAnswerButton.start();
						//isCorrect = JOptionPane.showOptionDialog(null, "Wrong answer :( It was " + answer, "Wrong", JOptionPane.DEFAULT_OPTION,
						//        JOptionPane.INFORMATION_MESSAGE, null, null, null);
				
					}
					
					q = question.askQuestion();
					answer = q.getAnswer();
					location = q.getLocation();
					
				}
			}
		}
		);
		
		
		
	}

		
	
	
	public void paintComponent( Graphics g)
	{
		super.paintComponent( g);		

		background = new ImageIcon( "images/backgrounds/backgroundq01.png" ).getImage();
		
		g.drawImage( background, 0, 0, null);
		// panel.getGraphics().drawImage
		g.drawImage( new ImageIcon( location ).getImage(), 48, 62, 700, 350, null );
		System.out.println("Location: " + location + " \nAnswer: " + answer ); 
		repaint();
	}
	
	public void update( Statistics stats)
	{
		curPanel.update( stats);
	}
	public static void startBackgroundMusic() {

		backgroundSound = new File("sounds/backgroundSound.wav");
		createBackgroundSound = null;
		startBackgroundSound = null;

		try {
			createBackgroundSound = AudioSystem
					.getAudioInputStream(backgroundSound);
			
			try {
				startBackgroundSound = AudioSystem.getClip();

			} catch (LineUnavailableException e) {

				e.printStackTrace();
			}
		} catch (UnsupportedAudioFileException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		try {
			startBackgroundSound.open(createBackgroundSound);
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FloatControl gainControl = 
			    (FloatControl) startBackgroundSound.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(-40.0f);
		startBackgroundSound.loop(10);
		
	}

	public static void stopBackgroundMusic() {
		if (startBackgroundSound != null && startBackgroundSound.isRunning())
			startBackgroundSound.stop();
	}
	
}

